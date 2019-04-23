/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.debug.core.model.IStreamMonitor;
import org.eclipse.papyrus.moka.engine.AbstractExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.DefaultCreateObjectActionStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.DefaultGetAssociationStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.IntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.RedefinitionBasedDispatchStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.StringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.UnlimitedNaturalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.FIFOGetNextEventStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.Executor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.FirstChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.Locus;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL3.ExecutionFactoryL3;
import org.eclipse.papyrus.moka.fuml.control.execution.RootExecution;
import org.eclipse.papyrus.moka.fuml.control.queue.ExecutionController;
import org.eclipse.papyrus.moka.fuml.control.queue.ExecutionLoop;
import org.eclipse.papyrus.moka.fuml.registry.IOpaqueBehaviorExecutionRegistry;
import org.eclipse.papyrus.moka.fuml.registry.ISystemServicesRegistry;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Type;

public class FUMLExecutionEngine extends AbstractExecutionEngine {

	// Locus at which the execution occurs
	protected ILocus locus;

	// fUML parameter values passed in the execution
	protected List<IParameterValue> executionArguments;

	public FUMLExecutionEngine() {
		this.executionArguments = new ArrayList<IParameterValue>();
	}

	public ILocus initializeLocus() {
		// creates the locus, executor and execution factory
		ILocus locus = new Locus();
		locus.setExecutor(new Executor());
		locus.setFactory(new ExecutionFactoryL3());
		return locus;
	}

	public void start(IProgressMonitor monitor) {
		super.start(monitor);
		this.locus = this.initializeLocus();
		if (this.executionEntryPoint != null) {
			// initializes built-in primitive types
			this.initializeBuiltInPrimitiveTypes(locus);
			// Initializes opaque behavior executions
			this.registerOpaqueBehaviorExecutions(locus);
			// Initializes system services
			this.registerSystemServices(locus);
			// Initializes semantic strategies
			this.registerSemanticStrategies(locus);
			// Initializes arguments
			this.initializeArguments(this.executionArgs);
			// Start execution
			this.run_();
		}
	}
	
	protected void run_() {
		// Starts the execution loop
		RootExecution rootExecution = new RootExecution((Behavior) this.executionEntryPoint, this.executionArguments, locus);
		ExecutionController.getInstance().setExecutionLoop(new ExecutionLoop());
		ExecutionController.getInstance().start(rootExecution);
	}

	public void stop(IProgressMonitor monitor) {
		super.stop(monitor);
		if (this.locus != null) {
			monitor.subTask("Cleanup execution locus");

			Iterator<IExtensionalValue> extents = this.locus.getExtensionalValues().listIterator();
			while (extents.hasNext()) {
				IExtensionalValue value = extents.next();
				if (value instanceof IObject_ && ((IObject_) value).getObjectActivation() != null) {
					((IObject_) value).getObjectActivation().stop();
					((IObject_) value).getObjectActivation().setObject((IObject_) value);
					((IObject_) value).setObjectActivation(null);
				}
				value.getTypes().clear();
			}
			this.locus.getExtensionalValues().clear();
		}
	}

	protected void registerSemanticStrategies(ILocus locus) {
		locus.getFactory().setStrategy(new FirstChoiceStrategy());
		locus.getFactory().setStrategy(new FIFOGetNextEventStrategy());
		locus.getFactory().setStrategy(new RedefinitionBasedDispatchStrategy());
		locus.getFactory().setStrategy(new DefaultCreateObjectActionStrategy());
		locus.getFactory().setStrategy(new DefaultGetAssociationStrategy());
	}

	protected void registerOpaqueBehaviorExecutions(ILocus locus) {
		// Load any OpaqueBehaviorExecution library contributing to the extension LIBRAY_EXTENSION_POINT_ID
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(MokaConstants.LIBRAY_EXTENSION_POINT_ID);
		try {
			for (int i = 0; i < config.length; i++) {
				IConfigurationElement e = config[i];
				final Object o = e.createExecutableExtension("class");
				loadLibrary(o, locus, this.executionEntryPoint);
			}
		} catch (CoreException ex) {

			ex.printStackTrace();

			System.err.println(ex.getMessage());
		} catch (Exception ex) {
			//Activator.log.error(ex);
		}
	}

	protected void registerSystemServices(ILocus locus) {
		// Load any contribution to the extension SERVICES_EXTENSION_POINT_ID
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(MokaConstants.SERVICES_EXTENSION_POINT_ID);
		try {
			for (int i = 0; i < config.length; i++) {
				IConfigurationElement e = config[i];
				final Object o = e.createExecutableExtension("class");
				loadServices(o, locus, this.executionEntryPoint);
			}
		} catch (CoreException ex) {
			//Activator.log.error(ex);
		} catch (Exception ex) {
			//Activator.log.error(ex);
		}
	}

	protected void initializeBuiltInPrimitiveTypes(ILocus locus) {
		locus.getFactory().addBuiltInType(org.eclipse.papyrus.moka.utils.UMLPrimitiveTypesUtils.getReal(this.executionEntryPoint));
		locus.getFactory().addBuiltInType(org.eclipse.papyrus.moka.utils.UMLPrimitiveTypesUtils.getInteger(this.executionEntryPoint));
		locus.getFactory().addBuiltInType(org.eclipse.papyrus.moka.utils.UMLPrimitiveTypesUtils.getBoolean(this.executionEntryPoint));
		locus.getFactory().addBuiltInType(org.eclipse.papyrus.moka.utils.UMLPrimitiveTypesUtils.getString(this.executionEntryPoint));
	}

	protected static void loadLibrary(final Object o, final ILocus locus, final Object context) {
		ISafeRunnable runnable = new ISafeRunnable() {

			public void handleException(Throwable e) {
				//Activator.log.error(e);
			}

			public void run() throws Exception {
				((IOpaqueBehaviorExecutionRegistry) o).init(context).registerOpaqueBehaviorExecutions(locus);
			}
		};
		SafeRunner.run(runnable);
	}

	protected static void loadServices(final Object o, final ILocus locus, final Object context) {
		ISafeRunnable runnable = new ISafeRunnable() {

			public void handleException(Throwable e) {
				//Activator.log.error(e);
			}

			public void run() throws Exception {
				((ISystemServicesRegistry) o).init(context).registerSystemServices(locus);
			}
		};
		SafeRunner.run(runnable);
	}

	public void initializeArguments(String[] args) {
		if (this.locus == null) {
			return;
		}
		this.executionArguments = new ArrayList<IParameterValue>();
		if (args == null) {
			return;
		}		
		List<IValue> tmpArgs = new ArrayList<IValue>();
		if (! (this.executionEntryPoint instanceof Behavior)) {
			return ;
		}
		// analyzes arguments versus parameters of the main behavior
		List<Parameter> parameters = ((Behavior) this.executionEntryPoint).getOwnedParameters();
		if (parameters == null) {
			return;
		}
		List<Parameter> parametersWhichNeedArguments = new ArrayList<Parameter>();
		// There must be the same number of parameters (except the return parameter)
		for (Parameter p : parameters) {
			if (p.getDirection() != ParameterDirectionKind.RETURN_LITERAL) {
				parametersWhichNeedArguments.add(p);
			}
		}
		if (parametersWhichNeedArguments.size() != args.length) {
			return;
		}

		// iterates on parameters, and tries to create tokens corresponding to arguments
		int i = 0;
		for (Parameter p : parametersWhichNeedArguments) {
			Type t = p.getType();
			if (t != null) {
				// FIXME
				PrimitiveType pt = (PrimitiveType) this.locus.getFactory().getBuiltInType(t.getName());
				if (pt == null) {
					return;
				}
				if (pt.getName().equals("Integer")) {
					IntegerValue value = new IntegerValue();
					value.value = new Integer(args[i]);
					tmpArgs.add(value);
				} else if (pt.getName().equals("String")) {
					StringValue value = new StringValue();
					value.value = args[i];
					tmpArgs.add(value);
				} else if (pt.getName().equals("Boolean")) {
					BooleanValue value = new BooleanValue();
					value.value = new Boolean(args[i]);
					tmpArgs.add(value);
				} else if (pt.getName().equals("UnlimitedNatural")) {
					UnlimitedNaturalValue value = new UnlimitedNaturalValue();
					value.value = new Integer(args[i]);
					tmpArgs.add(value);
				} else {
					return; // Unsupported type. TODO Consider Real
				}
			}
			i++;
		}

		i = 0;
		// creates actual arguments
		for (IValue v : tmpArgs) {
			IParameterValue arg = new ParameterValue();
			arg.setParameter(parameters.get(i));
			arg.setValues(new ArrayList<IValue>());
			arg.getValues().add(v);
			this.executionArguments.add(arg);
			i++;
		}
	}

	public IStreamMonitor getErrorStreamMonitor() {
		// TODO Auto-generated method stub
		return null;
	}

	public IStreamMonitor getOutputStreamMonitor() {
		// TODO Auto-generated method stub
		return null;
	}

	public void write(String input) throws IOException {
		// TODO Auto-generated method stub

	}
}
