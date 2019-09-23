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

import static org.eclipse.papyrus.moka.debug.communication.DebugTopics.DEBUG_SERVICE_ENGINE_TOPIC;
import static org.eclipse.papyrus.moka.debug.communication.DebugTopics.DEBUG_SERVICE_THREAD_TOPIC;
import static org.eclipse.papyrus.moka.debug.communication.DebugTopics.DEBUG_TARGET_ENGINE_TOPIC;
import static org.eclipse.papyrus.moka.debug.communication.DebugTopics.DEBUG_TARGET_THREAD_TOPIC;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.papyrus.moka.debug.messages.DebugEventContextKind;
import org.eclipse.papyrus.moka.debug.messages.DebugRequest;
import org.eclipse.papyrus.moka.debug.messages.MessagesFactory;
import org.eclipse.papyrus.moka.debug.messages.ThreadRequest;
import org.eclipse.papyrus.moka.kernel.SuspensionReasons;
import org.eclipse.papyrus.moka.kernel.service.ServiceMqttClient;

public class ExecutionEngineDebugTargetClient extends ServiceMqttClient implements IExecutionEngineDebugTargetClient {

	/**
	 * Listener handling message reception
	 */
	private ExecutionEngineDebugTargetClientListener clientListener;

	public ExecutionEngineDebugTargetClient(String serverURI, String clientID, IExecutionEngineDebugTarget target) {
		super(serverURI, clientID);
		clientListener = new ExecutionEngineDebugTargetClientListener(target);
	}

	@Override
	public void run() {
		// If the client is already connected then, it is disconnected.
		// Next, the connection is established and topics listened
		// by the debug target are subscribed
		super.run();
		if (client != null && client.isConnected()) {
			try {
				client.subscribe(DEBUG_SERVICE_ENGINE_TOPIC, 1, clientListener);
				client.subscribe(DEBUG_SERVICE_THREAD_TOPIC, 1, clientListener);
			} catch (MqttException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void terminate() {
		// Terminate the client in a safe manner: (1) remove subscriptions
		// to the chosen topics (2) disconnect from the server
		if (client != null && client.isConnected()) {
			try {
				client.unsubscribe(DEBUG_SERVICE_ENGINE_TOPIC);
				client.unsubscribe(DEBUG_SERVICE_THREAD_TOPIC);
			} catch (MqttException e) {
				e.printStackTrace();
			}
			super.terminate();
		}
	}

	public boolean fireResumeEngineEvent() {
		boolean published = false;
		if (client != null && client.isConnected()) {
			MqttMessage resumeEngine = new MqttMessage();
			DebugRequest request = MessagesFactory.eINSTANCE.createDebugRequest();
			request.setContextKind(DebugEventContextKind.ENGINE);
			request.setEventKind(DebugEvent.RESUME);
			request.setEventDetail(DebugEvent.CLIENT_REQUEST);
			resumeEngine.setPayload(request.toJson().getBytes());
			resumeEngine.setQos(1);
			IMqttDeliveryToken token = null;
			try {
				token = publish(DEBUG_TARGET_ENGINE_TOPIC, resumeEngine);
			} catch (MqttPersistenceException e) {
				e.printStackTrace();
			} catch (MqttException e) {
				e.printStackTrace();
			}
			if (token != null) {
				published = token.isComplete();
			}
		}
		return published;
	}

	public boolean fireSuspendEngineEvent() {
		boolean published = false;
		if (client != null && client.isConnected()) {
			MqttMessage suspendEngine = new MqttMessage();
			DebugRequest request = MessagesFactory.eINSTANCE.createDebugRequest();
			request.setContextKind(DebugEventContextKind.ENGINE);
			request.setEventKind(DebugEvent.SUSPEND);
			request.setEventDetail(DebugEvent.CLIENT_REQUEST);
			suspendEngine.setPayload(request.toJson().getBytes());
			suspendEngine.setQos(1);
			IMqttDeliveryToken token = null;
			try {
				token = publish(DEBUG_TARGET_ENGINE_TOPIC, suspendEngine);
			} catch (MqttPersistenceException e) {
				e.printStackTrace();
			} catch (MqttException e) {
				e.printStackTrace();
			}
			if (token != null) {
				published = token.isComplete();
			}
		}
		return published;
	}

	public boolean fireSuspendThreadEvent(IExecutionEngineThread thread) {
		boolean published = false;
		if (client != null && client.isConnected()) {
			MqttMessage suspendEngineThread = new MqttMessage();
			ThreadRequest request = MessagesFactory.eINSTANCE.createThreadRequest();
			request.setContextKind(DebugEventContextKind.THREAD);
			request.setEventKind(DebugEvent.SUSPEND);
			request.setEventDetail(DebugEvent.CLIENT_REQUEST);
			request.setThreadId(thread.getID());
			request.setSuspensionReason(SuspensionReasons.USER_ACTION);
			suspendEngineThread.setPayload(request.toJson().getBytes());
			suspendEngineThread.setQos(1);
			IMqttDeliveryToken token = null;
			try {
				token = publish(DEBUG_TARGET_THREAD_TOPIC, suspendEngineThread, thread, new SuspendThreadActionListener());
			} catch (MqttPersistenceException e) {
				e.printStackTrace();
			} catch (MqttException e) {
				e.printStackTrace();
			}
			if (token != null) {
				published = token.isComplete();
			}
		}
		return published;
	}

	public boolean fireResumeThreadEvent(IExecutionEngineThread thread) {
		boolean published = false;
		if (client != null && client.isConnected()) {
			MqttMessage resumedEngineThread = new MqttMessage();
			ThreadRequest request = MessagesFactory.eINSTANCE.createThreadRequest();
			request.setContextKind(DebugEventContextKind.THREAD);
			request.setEventKind(DebugEvent.RESUME);
			request.setEventDetail(DebugEvent.CLIENT_REQUEST);
			request.setThreadId(thread.getID());
			request.setSuspensionReason(SuspensionReasons.NONE);
			resumedEngineThread.setPayload(request.toJson().getBytes());
			resumedEngineThread.setQos(1);
			IMqttDeliveryToken token = null;
			try {
				token = publish(DEBUG_TARGET_THREAD_TOPIC, resumedEngineThread, thread, new ResumeThreadActionListener());
			} catch (MqttPersistenceException e) {
				e.printStackTrace();
			} catch (MqttException e) {
				e.printStackTrace();
			}
			if (token != null) {
				published = token.isComplete();
			}
		}
		return published;
	}
	
	public boolean fireTerminateThreadEvent(IExecutionEngineThread thread) {
		boolean published = false;
		if (client != null && client.isConnected()) {
			MqttMessage resumedEngineThread = new MqttMessage();
			ThreadRequest request = MessagesFactory.eINSTANCE.createThreadRequest();
			request.setContextKind(DebugEventContextKind.THREAD);
			request.setEventKind(DebugEvent.TERMINATE);
			request.setEventDetail(DebugEvent.CLIENT_REQUEST);
			request.setThreadId(thread.getID());
			resumedEngineThread.setPayload(request.toJson().getBytes());
			resumedEngineThread.setQos(1);
			IMqttDeliveryToken token = null;
			try {
				token = publish(DEBUG_TARGET_THREAD_TOPIC, resumedEngineThread, thread, new TerminateThreadActionListener());
			} catch (MqttPersistenceException e) {
				e.printStackTrace();
			} catch (MqttException e) {
				e.printStackTrace();
			}
			if (token != null) {
				published = token.isComplete();
			}
		}
		return published;
	}

	class SuspendThreadActionListener implements IMqttActionListener {

		@Override
		public void onFailure(IMqttToken token, Throwable exception) {
			// The thread could not be suspended
			ExecutionEngineThread thread = (ExecutionEngineThread) token.getUserContext();
			if(thread != null) {
				thread.setStatus(DebugElementStatus.RUNNING);
			}
		}

		@Override
		public void onSuccess(IMqttToken token) {
			// The thread was correctly suspended hence updates the UI accordingly
			ExecutionEngineThread thread = (ExecutionEngineThread) token.getUserContext();
			if(thread != null) {
				thread.fireSuspendEvent(DebugEvent.CLIENT_REQUEST);
				ExecutionEngineDebugTarget target = (ExecutionEngineDebugTarget) thread.getDebugTarget();
				target.fireChangeEvent(DebugEvent.STATE);
			}
			
		}

	}

	class ResumeThreadActionListener implements IMqttActionListener {

		@Override
		public void onFailure(IMqttToken token, Throwable exception) {
			ExecutionEngineThread thread = (ExecutionEngineThread) token.getUserContext();
			if(thread != null) {
				thread.setStatus(DebugElementStatus.SUSPENDED);
			}
		}

		@Override
		public void onSuccess(IMqttToken token) {
			// The thread was correctly suspended hence updates the UI accordingly
			ExecutionEngineThread thread = (ExecutionEngineThread) token.getUserContext();
			thread.setStatus(DebugElementStatus.RUNNING);
			thread.fireResumeEvent(DebugEvent.CLIENT_REQUEST);
			ExecutionEngineDebugTarget target = (ExecutionEngineDebugTarget) thread.getDebugTarget();
			target.fireChangeEvent(DebugEvent.STATE);
		}

	}
	
	class TerminateThreadActionListener implements IMqttActionListener {

		@Override
		public void onFailure(IMqttToken token, Throwable exception) {
			ExecutionEngineThread thread = (ExecutionEngineThread) token.getUserContext();
			if(thread != null) {
				thread.setStatus(DebugElementStatus.RUNNING);
			}
		}

		@Override
		public void onSuccess(IMqttToken token) {
			// The thread was correctly terminated hence updates the UI accordingly
			ExecutionEngineThread thread = (ExecutionEngineThread) token.getUserContext();
			thread.setStatus(DebugElementStatus.TERMINATED);
			thread.fireTerminateEvent();
			ExecutionEngineDebugTarget target = (ExecutionEngineDebugTarget) thread.getDebugTarget();
			target.fireChangeEvent(DebugEvent.STATE);
		}
		
	}

}
