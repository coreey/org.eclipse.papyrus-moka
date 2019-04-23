/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.moka.fuml.control.queue;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.control.execution.RootExecution;

public class ExecutionLoop {
	
	// The queue handled by the execution manager
	protected ExecutionQueue queue;
	
	public ExecutionLoop(){
		this.queue = new ExecutionQueue();
	}
	
	public void enqueue(IExecution execution){
		// Add an execution to the queue
		this.queue.offer(execution);
	}
	
	public void start(RootExecution execution){
		// Add an execution to the queue and start the execution
		// loop.
		this.queue.clear();
		this.enqueue(execution);
		this.run();
	}
	
	public void run(){
		// Execute all execution in the queue until
		// the queue is empty
		while(!this.queue.isEmpty()){
			this.runNext();
		}
	}
	
	public boolean step(){
		// Run the execution at the head of the queue
		return this.runNext();
	}
	
	protected final boolean runNext(){
		// If the queue is not empty, then the head execution is removed
		// and executed. True is returned. False is only returned if the
		// queue was empty.
		if(!this.queue.isEmpty()){
			IExecution nextExecution = this.queue.poll();
			nextExecution.execute();
			return true;
		}
		return false;
	}
	
}