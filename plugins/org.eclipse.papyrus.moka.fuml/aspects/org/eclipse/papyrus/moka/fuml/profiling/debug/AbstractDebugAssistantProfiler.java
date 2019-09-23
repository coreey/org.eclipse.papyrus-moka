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

import org.eclipse.papyrus.moka.animation.engine.rendering.DiagramHandler;
import org.eclipse.papyrus.moka.debug.service.IDebugService;
import org.eclipse.papyrus.moka.engine.uml.debug.listeners.UMLSemanticVisitorExecutionListener;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.profiling.MokaObservable;
import org.eclipse.papyrus.moka.kernel.SuspensionReasons;
import org.eclipse.papyrus.moka.kernel.assistant.IDebugAssistant;
import org.eclipse.papyrus.moka.kernel.assistant.Suspension;
import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.kernel.service.IExecutionEngineService;
import org.eclipse.uml2.uml.Element;

public abstract class AbstractDebugAssistantProfiler extends MokaObservable implements IDebugAssistant {

	private DiagramHandler diagramHandler;

	public AbstractDebugAssistantProfiler() {
	}

	protected void fireDebugEvent(ISemanticVisitor visitor) {
		Suspension suspension = new Suspension(this, SuspensionReasons.ERROR_DETECTION);
		if (shouldContinueInDebugAssistant(suspension)) {
			Element node = getVisitorNode(visitor);
			if (node != null) {
				// Open diagrams
				UMLSemanticVisitorExecutionListener debugService = null;
				DiagramHandler diagramManager = getDiagramHandler(visitor);
				if (!diagramManager.hasOpenedDiagram(node)) {
					diagramManager.openDiagrams(node);
				} else {
					diagramManager.selectDiagrams(node);
				}

				// Ask to every UMLSemanticVisitorExecution service to suspend
				for (IExecutionEngineService<IExecutionEngine> service : getListeners()) {
					if (service instanceof UMLSemanticVisitorExecutionListener) {
						if (service instanceof IDebugService) {
							debugService = (UMLSemanticVisitorExecutionListener) service;
						} else {
							((UMLSemanticVisitorExecutionListener) service).nodeSuspended(visitor,
									suspension);
						}
					}
				}
				if (debugService != null) {
					// The debug service suspend the thread so it should works in last
					debugService.nodeSuspended(visitor, suspension);
				}
			}
		}
	}

	protected boolean shouldContinueInDebugAssistant(Suspension suspension) {
		for (IExecutionEngineService<IExecutionEngine> service : getListeners()) {
			if (service instanceof IDebugService) {
				return ((IDebugService<?, ?>) service).shouldContinueInDebugAssistant(suspension);
			}
		}
		return false;
	}

	protected DiagramHandler getDiagramHandler(ISemanticVisitor visitor) {
		if (diagramHandler == null) {
			diagramHandler = new DiagramHandler();
			diagramHandler.init(getVisitorNode(visitor));
		}
		return diagramHandler;
	}

	/**
	 * Get node for the visitor, this is the node which will be marked as suspended
	 * 
	 * @param visitor the current visitor
	 * @return the node corresponding to the given visitor
	 */
	protected abstract Element getVisitorNode(ISemanticVisitor visitor);

}
