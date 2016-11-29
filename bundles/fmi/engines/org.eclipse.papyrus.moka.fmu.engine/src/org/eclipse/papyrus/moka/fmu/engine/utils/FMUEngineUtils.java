/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmu.engine.utils;

import org.eclipse.papyrus.moka.fmu.engine.control.FMUControlService;
import org.eclipse.papyrus.moka.fmu.json.JSONSocketClient;

public class FMUEngineUtils {

	protected static FMUControlService fmuControlService ;

	private static JSONSocketClient jsonSocketClient;

	protected static final String PORT_STEREOTYPE_NAME = "Port";
	protected static final String CS_FMU_STEREOTYPE_NAME = "CS_FMU";

	protected static final String PORT_INPUT_DIRECTION = "in";
	protected static final String PORT_OUTPUT_DIRECTION = "out";
	protected static final String PORT_CAUSILITY_ATTRIBUTE = "causality";
	protected static final String PORT_DIRECTION_ATTRIBUTE = "direction" ;

	protected static final String VALUE_REFERENCE_FIELD_NAME = "valueReference" ;



	public static FMUControlService getFMUControlService() {
		return fmuControlService ;
	}

	public static void setFMUControlService(FMUControlService controlService) {
		fmuControlService = controlService ;
	}
	
	public static void setJSONSocketClient(JSONSocketClient server){
		jsonSocketClient = server;
	}
	
	public static JSONSocketClient getJsonSocketClient() {
		
		//TODO improve the way to implement a socket server from the GUI...
		if (jsonSocketClient== null){
			jsonSocketClient = new JSONSocketClient(9090);
		}
		return jsonSocketClient;
	}
}
