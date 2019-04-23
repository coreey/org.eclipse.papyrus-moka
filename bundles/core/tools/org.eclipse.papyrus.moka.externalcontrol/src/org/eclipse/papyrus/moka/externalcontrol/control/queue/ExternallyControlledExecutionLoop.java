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

package org.eclipse.papyrus.moka.externalcontrol.control.queue;

import org.eclipse.papyrus.moka.externalcontrol.controller.ExternalController;
import org.eclipse.papyrus.moka.timedfuml.control.queue.TimedExecutionLoop;

public class ExternallyControlledExecutionLoop extends TimedExecutionLoop{

	// Semantic visitor controller
	protected ExternalController controller;
	
	public ExternallyControlledExecutionLoop(ExternalController controller) {
		this.controller = controller;
	}
	
	@Override
	public void run() {
		// While the simulation can continue (i.e., the scheduler has remaining events)
		// 1] Propagate the execution according to executable UML semantics.
		// 2] Enable the controller to resume (if possible) controlled execution visitors.
		// 3] Let simulation time progress (i.e., consume all events at the next closest time)
		while(!this.scheduler.isFinished()) {
			while(!this.queue.isEmpty() || this.controller.hasEnabledVisitors()){
				if(!this.queue.isEmpty()) {
					this.runNext();
				}else {
					this.controller.step();
				}
			}
			this.scheduler.step();
		}
	}
	
	@Override
	public boolean step() {
		// If the model is in a state that enables the execution to move
		// forward according to executable UML semantics then execute the
		// next registered execution in the queue. Conversely, if the model
		// is in a state that does enable the execution to move forward according
		// to the executable UML semantics then if possible a step is requested
		// from the controller standpoint. If no step is possible for the controller
		// then a step is requested from the scheduler.
		boolean stepIn = this.runNext();
		if(!stepIn) {
			if(!this.scheduler.isFinished()) {
				if(this.controller.hasEnabledVisitors()) {
					this.controller.step();
				}else {
					this.scheduler.step();
				}
				stepIn = true;
			}
		}
		return stepIn;
	}
	
}
