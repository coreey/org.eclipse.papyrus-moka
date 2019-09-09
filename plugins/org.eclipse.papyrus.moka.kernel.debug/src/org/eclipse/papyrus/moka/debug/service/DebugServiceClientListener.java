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
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.debug.service;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.papyrus.moka.debug.communication.MessagesReader;
import org.eclipse.papyrus.moka.debug.messages.DebugRequest;
import org.eclipse.papyrus.moka.debug.messages.ThreadRequest;

import static org.eclipse.papyrus.moka.debug.communication.DebugTopics.DEBUG_TARGET_ENGINE_TOPIC;
import static org.eclipse.papyrus.moka.debug.communication.DebugTopics.DEBUG_TARGET_THREAD_TOPIC;

import org.eclipse.debug.core.DebugEvent;;

public class DebugServiceClientListener implements IMqttMessageListener {

	/**
	 * The debug service connected to the MQTT client
	 */
	protected DebugService<?, ?> debugService;

	public DebugServiceClientListener(DebugService<?, ?> service) {
		assert service != null;
		debugService = service;
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
		if (topic.equals(DEBUG_TARGET_THREAD_TOPIC)) {
			ThreadRequest request = MessagesReader.geThreadRequest(message);
			switch (request.getEventKind()) {
			case DebugEvent.SUSPEND:
				debugService.requestSuspendThread(request.getThreadId());
				break;
			case DebugEvent.RESUME:
				debugService.requestResumeThread(request.getThreadId());
				break;
			case DebugEvent.TERMINATE:
				debugService.requestTerminateThread(request.getThreadId());
				break;
			}
		} else if (topic.equals(DEBUG_TARGET_ENGINE_TOPIC)) {
			DebugRequest request = MessagesReader.getDebugRequest(message);
			switch (request.getEventKind()) {
			case DebugEvent.RESUME:
				debugService.requestResumeEngine();
				break;
			case DebugEvent.SUSPEND:
				debugService.requestSuspendEngine();
				break;
			case DebugEvent.TERMINATE:
				debugService.requestTerminateEngine();
			}
		}
	}

}
