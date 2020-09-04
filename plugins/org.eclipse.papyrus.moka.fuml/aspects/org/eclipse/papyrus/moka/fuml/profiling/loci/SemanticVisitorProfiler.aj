/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
package org.eclipse.papyrus.moka.fuml.profiling.loci;

import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.profiling.MokaObservable;
import org.eclipse.papyrus.moka.fuml.profiling.listeners.ISemanticVisitorExecutionListener;
import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.kernel.service.IExecutionEngineService;

public abstract aspect SemanticVisitorProfiler extends MokaObservable {

	public SemanticVisitorProfiler() {
		super();
	}

	pointcut beginIsolation(ISemanticVisitor visitor): target(visitor) && call(* ISemanticVisitor._beginIsolation());

	before(ISemanticVisitor visitor) : beginIsolation(visitor) {
	}

	pointcut endIsolation(ISemanticVisitor visitor): target(visitor) && call(void ISemanticVisitor._endIsolation());

	after(ISemanticVisitor visitor) : endIsolation(visitor) {
	}

	public void visit(ISemanticVisitor visitor) {
		this.fireNodeVisited(visitor);
	}

	public void leave(ISemanticVisitor visitor) {
		this.fireNodeLeft(visitor);
	}

	protected void fireNodeVisited(ISemanticVisitor visitor) {
		for (IExecutionEngineService<IExecutionEngine> service : getListeners()) {
			if (service instanceof ISemanticVisitorExecutionListener) {
				((ISemanticVisitorExecutionListener) service).nodeVisited(visitor);
			}
		}
	}

	protected void fireNodeLeft(ISemanticVisitor visitor) {
		for (IExecutionEngineService<IExecutionEngine> service : getListeners()) {
			if (service instanceof ISemanticVisitorExecutionListener) {
				((ISemanticVisitorExecutionListener) service).nodeLeft(visitor);
			}
		}
	}
}