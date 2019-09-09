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

package org.eclipse.papyrus.moka.engine.uml.time.scheduling.control;

import org.eclipse.papyrus.moka.engine.uml.time.scheduling.de.DEScheduler;
import org.eclipse.papyrus.moka.kernel.scheduling.control.ExecutionLoop;
import org.eclipse.papyrus.moka.kernel.scheduling.control.IScheduler;
import org.eclipse.papyrus.moka.kernel.scheduling.execution.ITaskExecution;

public class TimedExecutionLoop extends ExecutionLoop {

	/**
	 * Time based scheduler
	 */
	protected DEScheduler timeScheduler;

	public TimedExecutionLoop() {
		super();
	}

	@Override
	public void init(ITaskExecution exec, IScheduler sched) {
		timeScheduler = DEScheduler.getInstance();
		super.init(exec, sched);
	}

	/**
	 * While the DEScheduler has the opportunity to move forward in the simulation
	 * then the execution propagates as specified in the executable UML semantics.
	 * If the execution reached a wait point (i.e., not any behavior can // be
	 * executed so far) then the simulation time moves forward (if possible - i.e.,
	 * events are available).
	 */
	@Override
	public void run() {
		//
		while (!timeScheduler.isFinished()) {
			super.run();
			timeScheduler.step();
		}
	}

	/**
	 * If the model is in a state that enables the execution to move forward
	 * according to executable UML semantics then execute the next registered
	 * execution in the queue. Conversely, if the model is in a state that does not
	 * enable the execution to move forward according to the executable UML
	 * semantics then enable scheduler to step forward.
	 */
	@Override
	public boolean step() {
		boolean stepIn = super.step();
		if (!stepIn && !timeScheduler.isFinished()) {
			timeScheduler.step();
		}
		return stepIn;
	}

}
