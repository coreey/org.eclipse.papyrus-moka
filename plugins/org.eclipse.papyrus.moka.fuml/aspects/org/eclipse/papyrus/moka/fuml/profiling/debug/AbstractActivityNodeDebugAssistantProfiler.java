/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.profiling.debug;

import org.eclipse.papyrus.moka.debug.service.IDebugService;
import org.eclipse.papyrus.moka.fuml.activities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.profiling.MokaObservable;
import org.eclipse.papyrus.moka.kernel.assistant.IDebugAssistant;
import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.kernel.service.IExecutionEngineService;
import org.eclipse.uml2.uml.Element;

public abstract class AbstractActivityNodeDebugAssistantProfiler extends MokaObservable implements IDebugAssistant {

	@Override
	public Element getVisitorNode(ISemanticVisitor visitor) {
		if(visitor instanceof IActivityNodeActivation) {
			return ((IActivityNodeActivation) visitor).getNode();
		}
		return null;
	}
	
	/**
	 * Ask to the debug service if the current assistant is valid in this context
	 * 
	 * WARNING: this method should be called by each subclass before throwing exceptions 
	 * 
	 * @return true if the current assistant is valid in this context, false otherwise
	 */
	protected boolean checkAssistantValidity() {
		for (IExecutionEngineService<IExecutionEngine> service : getListeners()) {
			if (service instanceof IDebugService) {
				return ((IDebugService<?, ?>) service).shouldContinueInDebugAssistant(getAssistantID());
			}
		}
		return false;
	}

}
