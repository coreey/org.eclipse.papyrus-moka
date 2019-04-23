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
 *   CEA LIST Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.timedfuml.semantics.StateMachines;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.StateMachineConfiguration;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateMachineExecution;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.ITransitionActivation;
import org.eclipse.papyrus.moka.timedfuml.utils.DESchedulerUtils;
import org.eclipse.uml2.uml.Transition;

public class TimedStateMachineConfiguration extends StateMachineConfiguration {

	public TimedStateMachineConfiguration(IStateMachineExecution execution) {
		super(execution);
	}

	@Override
	public boolean register(IStateActivation stateActivation) {
		// Register the state activation to the state machine configuration.
		// Install timers corresponding to expected time events to the clock
		// (i.e. the DEScheduler)
		boolean registered = super.register(stateActivation);
		if (registered) {
			List<ITransitionActivation> transitionActivation = stateActivation.getOutgoingTransitions();
			for (int i = 1; i <= transitionActivation.size(); i++) {
				Transition transition = (Transition) transitionActivation.get(i - 1).getNode();
				DESchedulerUtils.pushEvents(transition.getTriggers(), stateActivation, stateActivation.getExecutionContext());
			}
		}
		return registered;
	}

	@Override
	public boolean unregister(IStateActivation stateActivation) {
		// Unregister the state activation to the state machine configuration.
		// Cancel timers installed by the unregistered state activation. indeed
		// if the state activation leaves the configuration that means transitions
		// outgoing the visited state can no longer be fired
		boolean unregistered = super.unregister(stateActivation);
		if (unregistered) {
			DESchedulerUtils.cancelEvents(stateActivation);
		}
		return unregistered;
	}

}
