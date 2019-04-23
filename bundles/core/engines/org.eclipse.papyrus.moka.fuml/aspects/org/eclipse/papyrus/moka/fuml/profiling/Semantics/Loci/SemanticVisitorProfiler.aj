/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0.html/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.profiling.Semantics.Loci;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.papyrus.moka.engine.MokaExecutionEngineJob;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.profiling.MokaObservable;
import org.eclipse.papyrus.moka.service.IMokaExecutionListener;

public abstract aspect SemanticVisitorProfiler extends MokaObservable{
	
	public SemanticVisitorProfiler(){
		super();
	}
	
	pointcut beginIsolation(ISemanticVisitor visitor): target(visitor) && call(* ISemanticVisitor._beginIsolation());
	
	before(ISemanticVisitor visitor) : beginIsolation(visitor) {}
	
	pointcut endIsolation(ISemanticVisitor visitor): target(visitor) && call(void ISemanticVisitor._endIsolation());
	
	after(ISemanticVisitor visitor) : endIsolation(visitor) {} 
	
	public void visit(ISemanticVisitor visitor) {
		IProgressMonitor monitor = MokaExecutionEngineJob.getInstance().getMonitor();
		if (monitor != null && monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
		this.fireNodeVisited(visitor);
	}
	
	public void leave(ISemanticVisitor visitor) {
		IProgressMonitor monitor = MokaExecutionEngineJob.getInstance().getMonitor();
		if (monitor != null && monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
		this.fireNodeLeft(visitor);
	}
	
	protected void fireNodeVisited(ISemanticVisitor visitor){
		for(IMokaExecutionListener listener: this.listeners)
			listener.nodeVisited(visitor);
		
	}
	
	protected void fireNodeLeft(ISemanticVisitor visitor){
		for(IMokaExecutionListener listener: this.listeners)
			listener.nodeLeft(visitor);
	}
}