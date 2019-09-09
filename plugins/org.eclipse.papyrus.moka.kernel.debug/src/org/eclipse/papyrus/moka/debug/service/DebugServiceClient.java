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

import static org.eclipse.papyrus.moka.debug.communication.DebugTopics.DEBUG_SERVICE_ENGINE_TOPIC;
import static org.eclipse.papyrus.moka.debug.communication.DebugTopics.DEBUG_SERVICE_THREAD_TOPIC;
import static org.eclipse.papyrus.moka.debug.communication.DebugTopics.DEBUG_TARGET_ENGINE_TOPIC;
import static org.eclipse.papyrus.moka.debug.communication.DebugTopics.DEBUG_TARGET_THREAD_TOPIC;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.papyrus.moka.debug.messages.DebugEventContextKind;
import org.eclipse.papyrus.moka.debug.messages.DebugRequest;
import org.eclipse.papyrus.moka.debug.messages.ThreadRequest;
import org.eclipse.papyrus.moka.debug.messages.impl.MessagesFactoryImpl;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.papyrus.moka.kernel.service.ServiceMqttClient;

public class DebugServiceClient extends ServiceMqttClient{

	/**
	 * Listener handling message reception
	 */
	private DebugServiceClientListener clientListener;
	
	public DebugServiceClient(String serverURI, String clientID, DebugService<?, ?> service) {
		super(serverURI, clientID);
		clientListener = new DebugServiceClientListener(service);
	}
	
	@Override
	public void run() {
		super.run();
		if (client != null && client.isConnected()) {
			try {		
				client.subscribe(DEBUG_TARGET_ENGINE_TOPIC, 1, clientListener);
				client.subscribe(DEBUG_TARGET_THREAD_TOPIC, 1, clientListener);
			} catch (MqttException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void terminate() {
		if (client != null && client.isConnected()) {
			try {
				client.unsubscribe(DEBUG_TARGET_ENGINE_TOPIC);
				client.unsubscribe(DEBUG_TARGET_THREAD_TOPIC);
			} catch (MqttException e) {
				e.printStackTrace();
			}
			super.terminate();
		}
	}

	/**
	 * Notifies the debug target about the creation of a new thread
	 * in the execution engine.
	 * 
	 * @param object
	 * 		the new thread
	 * 
	 * @return true if the notification was received and false otherwise
	 */
	public boolean fireNewThreadEvent(IObject_ object) {
		boolean published = false;
		if (client != null && client.isConnected()) {
			MqttMessage message = new MqttMessage();
			ThreadRequest request = MessagesFactoryImpl.eINSTANCE.createThreadRequest();
			request.setContextKind(DebugEventContextKind.THREAD);
			request.setEventKind(DebugEvent.CREATE);
			request.setThreadId(object.getIdentifier());
			message.setPayload(request.toJson().getBytes());
			message.setQos(1);
			IMqttDeliveryToken token = null;
			try {
				token = publish(DEBUG_SERVICE_THREAD_TOPIC, message);
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

	/**
	 * Notifies the debug target about the termination of a thread
	 * in the execution engine.
	 * 
	 * @param object
	 * 		the terminated thread
	 * 
	 * @return true if the notification was received and false otherwise
	 */
	public boolean fireTerminateThreadEvent(IObject_ object) {
		boolean published = false;
		if (client != null && client.isConnected()) {
			MqttMessage message = new MqttMessage();
			ThreadRequest request = MessagesFactoryImpl.eINSTANCE.createThreadRequest();
			request.setContextKind(DebugEventContextKind.THREAD);
			request.setEventKind(DebugEvent.TERMINATE);
			request.setThreadId(object.getIdentifier());
			message.setPayload(request.toJson().getBytes());
			message.setQos(1);
			IMqttDeliveryToken token = null;
			try {
				token = publish(DEBUG_SERVICE_THREAD_TOPIC, message);
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

	/**
	 * Notifies the debug target about the suspension of a thread in
	 * the execution engine
	 *  
	 * @param object
	 * 		the thread to be suspended
	 * 
	 * @param visitor
	 * 		the visitor on which the thread is suspended
	 * 
	 * @return true if the notification was received and false otherwise
	 */
	public boolean fireSuspendThreadEvent(IObject_ object, ISemanticVisitor visitor) {
		boolean published = true;
		if (client != null && client.isConnected()) {
			MqttMessage message = new MqttMessage();
			ThreadRequest request = MessagesFactoryImpl.eINSTANCE.createThreadRequest();
			request.setContextKind(DebugEventContextKind.THREAD);
			request.setEventKind(DebugEvent.SUSPEND);
			request.setEventDetail(DebugEvent.BREAKPOINT);
			request.setThreadId(object.getIdentifier());
			request.setSuspensionPoint(visitor.hashCode());
			message.setPayload(request.toJson().getBytes());
			IMqttDeliveryToken token = null;
			try {
				token = publish(DEBUG_SERVICE_THREAD_TOPIC, message);
			} catch (MqttPersistenceException e) {
				e.printStackTrace();
			} catch (MqttException e) {
				e.printStackTrace();
			}
			if (token != null) {
				try {
					token.waitForCompletion();
				} catch (MqttException e) {
					published = false;
					e.printStackTrace();
				}
			}
		}
		return published;
	}
	
	public boolean fireTerminateEngineEvent() {
		boolean published = true;
		if (client != null && client.isConnected()) {
			MqttMessage message = new MqttMessage();
			DebugRequest request = MessagesFactoryImpl.eINSTANCE.createDebugRequest();
			request.setContextKind(DebugEventContextKind.ENGINE);
			request.setEventKind(DebugEvent.TERMINATE);
			message.setPayload(request.toJson().getBytes());
			IMqttDeliveryToken token = null;
			try {
				token = publish(DEBUG_SERVICE_ENGINE_TOPIC, message);
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

}
