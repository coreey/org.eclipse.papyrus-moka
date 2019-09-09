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
package org.eclipse.papyrus.moka.kernel.process;

public interface IServerMqttPreferences {

	final String MQTT_SERVER_PATH = "MQTT_SERVER_PATH";
	
	final String MQTT_SERVER_PORT = "MQTT_SERVER_PORT";
	
	final String MODEL_VALIDATION_ON_LAUNCH = "MODEL_VALIDATION_ON_LAUNCH";
	
}
