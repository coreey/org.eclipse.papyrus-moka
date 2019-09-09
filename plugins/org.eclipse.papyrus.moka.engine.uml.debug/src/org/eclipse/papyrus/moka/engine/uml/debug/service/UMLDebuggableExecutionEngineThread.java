/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.engine.uml.debug.service;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.debug.engine.IDebuggableExecutionEngineThread;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.ExecutionContextVariableAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.SuspensionPointVariableAdapter;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;

public class UMLDebuggableExecutionEngineThread implements IDebuggableExecutionEngineThread<IObject_, ISemanticVisitor>{

	/**
	 * The executable UML object that plays the role of a thread
	 */
	protected IObject_ thread;
	
	/**
	 * The execution context on which the executable UML object is
	 * currently suspended
	 */
	protected ISemanticVisitor context;
	
	public UMLDebuggableExecutionEngineThread() {
		this(null);
	}
	
	public UMLDebuggableExecutionEngineThread(IObject_ t) {
		thread = t;
	}
	
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getID() {
		if(thread != null) {
			return thread.getIdentifier();
		}
		return null;
	}

	@Override
	public void setID(String identifier) {
		if(thread != null) {
			thread.setIdentifier(identifier);
		}
	}

	@Override
	public IObject_ getThread() {
		return thread;
	}

	@Override
	public void setThread(IObject_ t) {
		thread = t;
	}

	@Override
	public ISemanticVisitor getSuspensionContext() {
		return context;
	}

	@Override
	public void setSuspensionContext(ISemanticVisitor c) {
		context = c;
	}

	@Override
	public List<IVariable> getVariables(final IDebugTarget target) {
		List<IVariable> variables = new ArrayList<IVariable>();
		if(thread != null) {
			variables.add(new ExecutionContextVariableAdapter(target, thread));
		}
		if(context != null) {
			variables.add(new SuspensionPointVariableAdapter(target, context));
		}
		return variables;
	}

}
