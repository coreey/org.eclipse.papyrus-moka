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
package org.eclipse.papyrus.moka.kernel.service;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public abstract class ServiceMqttClient extends ServiceClient<MqttAsyncClient> implements IMqttAsyncClient{

	protected MemoryPersistence clientPersistence;
	
	public ServiceMqttClient(final String serverURI, final String clientID) {
		super();
		clientPersistence = new MemoryPersistence();
		try {
			client = new MqttAsyncClient(serverURI, clientID, clientPersistence);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		if(client != null && client.isConnected()) {
			terminate();
		} else {
			MqttConnectOptions options = new MqttConnectOptions();
			options.setCleanSession(true);
			try {
				client.connect(options).waitForCompletion();
			} catch (MqttSecurityException e) {
				e.printStackTrace();
			} catch (MqttException e) {
				e.printStackTrace();
			}
		}
	}

	public void terminate() {
		if(client != null && client.isConnected()) {
			try {
				client.disconnect().waitForCompletion();
			} catch (MqttException e) {
				e.printStackTrace();
			} finally {
				if(!client.isConnected()) {
					try {
						client.close();
					} catch (MqttException e) {
						try {
							client.close(true);
						} catch (MqttException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	@Override
	public void close() throws MqttException {
		if(client != null) {
			client.close();
		}
	}

	@Override
	public IMqttToken connect() throws MqttException, MqttSecurityException {
		if(client != null) {
			return client.connect();
		}
		return null;
	}

	@Override
	public IMqttToken connect(MqttConnectOptions arg0) throws MqttException, MqttSecurityException {
		if(client != null) {
			return client.connect(arg0);
		}
		return null;
	}

	@Override
	public IMqttToken connect(Object arg0, IMqttActionListener arg1) throws MqttException, MqttSecurityException {
		if(client != null) {
			return client.connect(arg0, arg1);
		}
		return null;
	}

	@Override
	public IMqttToken connect(MqttConnectOptions arg0, Object arg1, IMqttActionListener arg2)
			throws MqttException, MqttSecurityException {
		if(client != null) {
			return client.connect(arg0, arg1, arg2);
		}
		return null;
	}

	@Override
	public IMqttToken disconnect() throws MqttException {
		if(client != null) {
			return client.disconnect();
		}
		return null;
	}

	@Override
	public IMqttToken disconnect(long arg0) throws MqttException {
		if(client != null) {
			return client.disconnect(arg0);
		}
		return null;
	}

	@Override
	public IMqttToken disconnect(Object arg0, IMqttActionListener arg1) throws MqttException {
		if(client != null) {
			return client.disconnect(arg0, arg1);
		}
		return null;
	}

	@Override
	public IMqttToken disconnect(long arg0, Object arg1, IMqttActionListener arg2) throws MqttException {
		if(client != null) {
			return client.disconnect(arg0, arg1, arg2);
		}
		return null;
	}

	@Override
	public void disconnectForcibly() throws MqttException {
		if(client != null) {
			client.disconnectForcibly();
		}
	}

	@Override
	public void disconnectForcibly(long arg0) throws MqttException {
		if(client != null) {
			client.disconnectForcibly(arg0);
		}
	}

	@Override
	public void disconnectForcibly(long arg0, long arg1) throws MqttException {
		if(client != null) {
			client.disconnectForcibly(arg0, arg1);
		}
	}

	@Override
	public String getClientId() {
		if(client != null) {
			return client.getClientId();
		}
		return null;
	}

	@Override
	public IMqttDeliveryToken[] getPendingDeliveryTokens() {
		if(client != null) {
			return client.getPendingDeliveryTokens();
		}
		return null;
	}

	@Override
	public String getServerURI() {
		if(client != null) {
			return client.getServerURI();
		}
		return null;
	}

	@Override
	public boolean isConnected() {
		if(client != null) {
			return client.isConnected();
		}
		return false;
	}

	@Override
	public void messageArrivedComplete(int arg0, int arg1) throws MqttException {
		if(client != null) {
			client.messageArrivedComplete(arg0, arg1);;
		}
	}

	@Override
	public IMqttDeliveryToken publish(String arg0, MqttMessage arg1) throws MqttException, MqttPersistenceException {
		if(client != null) {
			return client.publish(arg0, arg1);
		}
		return null;
	}

	@Override
	public IMqttDeliveryToken publish(String arg0, byte[] arg1, int arg2, boolean arg3)
			throws MqttException, MqttPersistenceException {
		if(client != null) {
			return client.publish(arg0, arg1, arg2, arg3);
		}
		return null;
	}

	@Override
	public IMqttDeliveryToken publish(String arg0, MqttMessage arg1, Object arg2, IMqttActionListener arg3)
			throws MqttException, MqttPersistenceException {
		if(client != null) {
			return client.publish(arg0, arg1, arg2, arg3);
		}
		return null;
	}

	@Override
	public IMqttDeliveryToken publish(String arg0, byte[] arg1, int arg2, boolean arg3, Object arg4,
			IMqttActionListener arg5) throws MqttException, MqttPersistenceException {
		if(client != null) {
			return client.publish(arg0, arg1, arg2, arg3, arg4, arg5);
		}
		return null;
	}

	@Override
	public void setCallback(MqttCallback arg0) {
		if(client != null) {
			client.setCallback(arg0);
		}
	}

	@Override
	public void setManualAcks(boolean arg0) {
		if(client != null) {
			client.setManualAcks(arg0);
		}
	}

	@Override
	public IMqttToken subscribe(String arg0, int arg1) throws MqttException {
		if(client != null) {
			return client.subscribe(arg0, arg1);
		}
		return null;
	}

	@Override
	public IMqttToken subscribe(String[] arg0, int[] arg1) throws MqttException {
		if(client != null) {
			return client.subscribe(arg0, arg1);
		}
		return null;
	}

	@Override
	public IMqttToken subscribe(String arg0, int arg1, IMqttMessageListener arg2) throws MqttException {
		if(client != null) {
			return client.subscribe(arg0, arg1, arg2);
		}
		return null;
	}

	@Override
	public IMqttToken subscribe(String[] arg0, int[] arg1, IMqttMessageListener[] arg2) throws MqttException {
		if(client != null) {
			return client.subscribe(arg0, arg1, arg2);
		}
		return null;
	}

	@Override
	public IMqttToken subscribe(String arg0, int arg1, Object arg2, IMqttActionListener arg3) throws MqttException {
		if(client != null) {
			return client.subscribe(arg0, arg1, arg2, arg3);
		}
		return null;
	}

	@Override
	public IMqttToken subscribe(String[] arg0, int[] arg1, Object arg2, IMqttActionListener arg3) throws MqttException {
		if(client != null) {
			return client.subscribe(arg0, arg1, arg2, arg3);
		}
		return null;
	}

	@Override
	public IMqttToken subscribe(String arg0, int arg1, Object arg2, IMqttActionListener arg3, IMqttMessageListener arg4)
			throws MqttException {
		if(client != null) {
			return client.subscribe(arg0, arg1, arg2, arg3, arg4);
		}
		return null;
	}

	@Override
	public IMqttToken subscribe(String[] arg0, int[] arg1, Object arg2, IMqttActionListener arg3,
			IMqttMessageListener[] arg4) throws MqttException {
		if(client != null) {
			return client.subscribe(arg0, arg1, arg2, arg3, arg4);
		}
		return null;
	}

	@Override
	public IMqttToken unsubscribe(String arg0) throws MqttException {
		if(client != null) {
			return client.unsubscribe(arg0);
		}
		return null;
	}

	@Override
	public IMqttToken unsubscribe(String[] arg0) throws MqttException {
		if(client != null) {
			return client.unsubscribe(arg0);
		}
		return null;
	}

	@Override
	public IMqttToken unsubscribe(String arg0, Object arg1, IMqttActionListener arg2) throws MqttException {
		if(client != null) {
			return client.unsubscribe(arg0, arg1, arg2);
		}
		return null;
	}

	@Override
	public IMqttToken unsubscribe(String[] arg0, Object arg1, IMqttActionListener arg2) throws MqttException {
		if(client != null) {
			return client.unsubscribe(arg0, arg1, arg2);
		}
		return null;
	}
	
}
