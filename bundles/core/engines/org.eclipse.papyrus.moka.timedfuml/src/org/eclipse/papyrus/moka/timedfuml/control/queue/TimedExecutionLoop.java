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

package org.eclipse.papyrus.moka.timedfuml.control.queue;

import org.eclipse.papyrus.moka.discreteevent.DEScheduler;
import org.eclipse.papyrus.moka.fuml.control.execution.RootExecution;
import org.eclipse.papyrus.moka.fuml.control.queue.ExecutionLoop;

public class TimedExecutionLoop extends ExecutionLoop{
	
	// Discrete event time scheduler
	protected DEScheduler scheduler;
	
	public TimedExecutionLoop() {
		super();
	}
	
	@Override
	public void start(RootExecution execution) {
		// Retrieve scheduler instance and starts the execution
		this.scheduler = DEScheduler.getInstance();
		super.start(execution);
	}
	
	@Override
	public void run() {
		// While the DEScheduler has the opportunity to move
		// forward in the simulation then the execution propagates
		// as specified in the executable UML semantics. If the
		// execution reached a wait point (i.e., not any behavior can
		// be executed so far) then the simulation time moves forward
		// (if possible - i.e., events are available).
		while(!this.scheduler.isFinished()) {
			super.run();
			this.scheduler.step();
		}
	}
	
	@Override
	public boolean step() {
		// If the model is in a state that enables the execution to move
		// forward according to executable UML semantics then execute the
		// next registered execution in the queue. Conversely, if
		// the model is in a state that does not enable the execution to
		// move forward according to the executable UML semantics then enable
		// scheduler to step forward.
		boolean stepIn = super.step();
		if(!stepIn && !this.scheduler.isFinished()){
			this.scheduler.step();
		}
		return stepIn;
	}
	
}
