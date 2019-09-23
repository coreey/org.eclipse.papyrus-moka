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
package org.eclipse.papyrus.moka.debug.communication;

import org.eclipse.json.provisonnal.com.eclipsesource.json.JsonObject;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.papyrus.moka.debug.messages.DebugEventContextKind;
import org.eclipse.papyrus.moka.debug.messages.DebugRequest;
import org.eclipse.papyrus.moka.debug.messages.MessagesPackage;
import org.eclipse.papyrus.moka.debug.messages.ThreadRequest;
import org.eclipse.papyrus.moka.debug.messages.impl.MessagesFactoryImpl;
import org.eclipse.papyrus.moka.kernel.SuspensionReasons;

public class MessagesReader {

	public static DebugRequest getDebugRequest(final MqttMessage message) {
		DebugRequest request = MessagesFactoryImpl.eINSTANCE.createDebugRequest();
		JsonObject content = JsonObject.readFrom(new String(message.getPayload()));
		request.setContextKind(DebugEventContextKind.get(content.getString(MessagesPackage.eINSTANCE.getDebugRequest_ContextKind().getName(), null)));
		request.setEventKind(content.getInt(MessagesPackage.eINSTANCE.getDebugRequest_EventKind().getName(), -1));
		request.setEventDetail(content.getInt(MessagesPackage.eINSTANCE.getDebugRequest_EventDetail().getName(), -1));
		return request;
	}
	
	public static ThreadRequest getThreadRequest(final MqttMessage message) {
		ThreadRequest request = MessagesFactoryImpl.eINSTANCE.createThreadRequest();
		DebugRequest debugRequest = getDebugRequest(message);
		request.setContextKind(debugRequest.getContextKind());
		request.setEventKind(debugRequest.getEventKind());
		request.setEventDetail(debugRequest.getEventDetail());
		JsonObject content = JsonObject.readFrom(new String(message.getPayload()));
		request.setThreadId(content.getString(MessagesPackage.eINSTANCE.getThreadRequest_ThreadId().getName(), null));
		request.setSuspensionPoint(content.getInt(MessagesPackage.eINSTANCE.getThreadRequest_SuspensionPoint().getName(), -1));
		request.setSuspensionReason(SuspensionReasons.get(content.getString(MessagesPackage.eINSTANCE.getThreadRequest_SuspensionReason().getName(), null)));
		return request;
	}

}
