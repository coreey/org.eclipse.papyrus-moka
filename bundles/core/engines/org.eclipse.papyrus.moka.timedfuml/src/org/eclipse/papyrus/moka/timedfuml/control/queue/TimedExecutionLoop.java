/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.timedfuml.control.queue;

import org.eclipse.papyrus.moka.discreteevent.DEScheduler;
import org.eclipse.papyrus.moka.fuml.control.execution.RootExecution;
import org.eclipse.papyrus.moka.fuml.control.queue.ExecutionLoop;
import org.eclipse.papyrus.moka.timedfuml.actions._displayCurrentTimeAction;

public class TimedExecutionLoop extends ExecutionLoop{
	
	// Discrete event time scheduler
	protected DEScheduler scheduler;
	
	public TimedExecutionLoop() {
		super();
	}
	
	@Override
	public void start(RootExecution execution) {
		// Initialize the scheduler and starts the execution loop
		DEScheduler.init(-1.0);
		DEScheduler.getInstance().pushPreStepAction(new _displayCurrentTimeAction());
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
		// forward according to executable UML semantics. Conversely, if
		// the model is in a state that does not enable the execution to
		// move forward according to the executable UML semantics then enable
		// scheduler to step forward.
		boolean stepIn = super.step();
		if(!stepIn && !scheduler.isFinished()){
			scheduler.step();
		}
		return stepIn;
	}
	
}
