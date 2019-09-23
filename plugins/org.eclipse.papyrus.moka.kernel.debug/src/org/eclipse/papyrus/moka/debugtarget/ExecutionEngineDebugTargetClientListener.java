/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  CEA LIST - Bug 551906
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.debugtarget;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.papyrus.moka.debug.communication.MessagesReader;
import org.eclipse.papyrus.moka.debug.messages.DebugRequest;
import org.eclipse.papyrus.moka.debug.messages.ThreadRequest;
import org.eclipse.papyrus.moka.debug.service.DebugService;

import static org.eclipse.papyrus.moka.debug.communication.DebugTopics.DEBUG_SERVICE_ENGINE_TOPIC;
import static org.eclipse.papyrus.moka.debug.communication.DebugTopics.DEBUG_SERVICE_THREAD_TOPIC;

import org.eclipse.debug.core.DebugEvent;

public class ExecutionEngineDebugTargetClientListener implements IMqttMessageListener {

	/**
	 * The debug target connected to the MQTT client
	 */
	protected IExecutionEngineDebugTarget debugTarget;

	public ExecutionEngineDebugTargetClientListener(IExecutionEngineDebugTarget target) {
		assert target != null;
		debugTarget = target;
	}

	/**
	 * Callback triggered each time a message is received by the
	 * {@link DebugService}}. Based on the receiving topic an interpretation is
	 * given to the message. This interpretation leads to trigger computations in
	 * the {@link DebugService}}
	 * 
	 * @param topic   the topic on which the message is received
	 * @param message the message in itself
	 */
	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		if (debugTarget != null) {
			if (topic.equals(DEBUG_SERVICE_THREAD_TOPIC)) {
				ThreadRequest request = MessagesReader.getThreadRequest(message);
				switch (request.getEventKind()) {
				case DebugEvent.SUSPEND: {
					ExecutionEngineThread thread = debugTarget.getThread(request.getThreadId());
					if (thread != null) {
						thread.setSuspensionReason(request.getSuspensionReason());
						thread.handleSuspendEvent(request.getEventDetail());
					}
				}
					break;
				case DebugEvent.CREATE:
					debugTarget.handleTargetThreadCreateEvent(request);
					break;
				case DebugEvent.TERMINATE: {
					debugTarget.handleTargetThreadTerminateEvent(request);
				}
					break;
				}
			} else if (topic.equals(DEBUG_SERVICE_ENGINE_TOPIC)) {
				DebugRequest request = MessagesReader.getDebugRequest(message);
				switch (request.getEventKind()) {
				case DebugEvent.TERMINATE:
					debugTarget.handleTargetTerminateEvent();
					break;
				}
			}

		}
	}

}
