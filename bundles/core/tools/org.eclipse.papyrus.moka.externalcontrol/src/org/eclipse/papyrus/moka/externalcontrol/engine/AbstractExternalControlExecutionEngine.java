/*****************************************************************************
 * 
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.externalcontrol.engine;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.moka.externalcontrol.advice.IControllerAdviceFactory;
import org.eclipse.papyrus.moka.externalcontrol.control.queue.ExternallyControlledExecutionLoop;
import org.eclipse.papyrus.moka.externalcontrol.controller.ExternalController;
import org.eclipse.papyrus.moka.externalcontrol.controller.IControlledVisitorPushPullStrategy;
import org.eclipse.papyrus.moka.externalcontrol.controller.NodeEdgeAlternatePushPullStrategy;
import org.eclipse.papyrus.moka.externalcontrol.semantics.ExternalControlExecutionFactory;
import org.eclipse.papyrus.moka.externalcontrol.semantics.ExternalControlExecutor;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.IExecutionFactory;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.IExecutor;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.ExecutionFactory;
import org.eclipse.papyrus.moka.fuml.control.execution.RootExecution;
import org.eclipse.papyrus.moka.fuml.control.queue.ExecutionController;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Loci.SM_Locus;
import org.eclipse.papyrus.moka.timedfuml.TimedUmlExecutionEngine;
import org.eclipse.uml2.uml.Behavior;

/**
 * Clients should extend this class to provide an specialized Moka execution
 * engine, relying on a default semantic ExecutionFactory, customized thanks to
 * Advices provided by the AdviceFactories.
 * 
 * @author sr246418
 *
 */

public abstract class AbstractExternalControlExecutionEngine extends TimedUmlExecutionEngine {

	/**
	 * The ExternalController instance
	 */
	protected ExternalController controller;

	/**
	 * Clients should implement this method to provide Advice Factories. The
	 * factories will return advices that will influence the default execution of
	 * semantic visitors provided by the delegated execution factory.
	 * 
	 * @return a list of Controller Advice factories. It should not be null, but can
	 *         be empty
	 */
	protected abstract List<IControllerAdviceFactory> getAdviceFactories();

	/**
	 * Clients should implement this method to return the default IExecutionFactory,
	 * which will instantiate the semantic visitors for each executable model
	 * element.
	 * 
	 * @return the default IExecutionFactory on top of which this customization is
	 *         implemented
	 */
	protected abstract IExecutionFactory getDelegatedExecutionFactory();

	/**
	 * Clients can override this method to provide another ILocus type. By default a
	 * {@link org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Loci.SM_Locus}
	 * is used.
	 * 
	 * @return the locus that will be used for this semantic customization. Should
	 *         not be null.
	 */
	protected ILocus getLocus() {
		return new SM_Locus();
	}

	/**
	 * Clients can override this method to provide another IExecutor type. By
	 * default a
	 * {@link org.eclipse.papyrus.moka.composites.Semantics.impl.Loci.LociL3.CS_Executor}
	 * is used.
	 * 
	 * @return the IExecutor that will be used for this semantic customization.
	 *         Should not be null.
	 */
	protected IExecutor getExecutor() {
		return new ExternalControlExecutor();
	}

	/**
	 * Clients can override this method to provide another
	 * IControlledVisitorPushPullStrategy to the ExternalController. By default a
	 * {@link org.eclipse.papyrus.moka.externalcontrol.controller.NodeEdgeAlternatePushPullStrategy}
	 * is returned.
	 * 
	 * @return the IControlledVisitorPushPullStrategy that will be used by the
	 *         External Control executor. Should not be null.
	 */
	protected IControlledVisitorPushPullStrategy getControllerPushPullStrategy() {
		return new NodeEdgeAlternatePushPullStrategy();
	}

	@Override
	public ILocus initializeLocus() {
		this.locus = getLocus();
		locus.setExecutor(getExecutor());
		IExecutionFactory delegatedFactory = getDelegatedExecutionFactory();
		ExecutionFactory externalControlExecutionFactory = new ExternalControlExecutionFactory(delegatedFactory,
				controller, getAdviceFactories());
		locus.setFactory(externalControlExecutionFactory);
		return this.locus;
	}

	@Override
	public void start(IProgressMonitor monitor) {
		this.controller = new ExternalController(getControllerPushPullStrategy());
		super.start(monitor);
	}
	
	@Override
	protected void run_() {
		// Starts externally controlled execution loop
		RootExecution rootExecution = new RootExecution((Behavior) this.executionEntryPoint, this.executionArguments, locus);
		ExecutionController.getInstance().setExecutionLoop(new ExternallyControlledExecutionLoop(this.controller));
		ExecutionController.getInstance().start(rootExecution);
	}

}
