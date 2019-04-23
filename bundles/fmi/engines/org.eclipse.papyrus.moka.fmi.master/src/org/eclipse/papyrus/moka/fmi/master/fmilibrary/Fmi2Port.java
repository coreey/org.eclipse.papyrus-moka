/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmi.master.fmilibrary;

import org.eclipse.papyrus.moka.fmi.master.fmuproxy.Fmu2ProxyService;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Stereotype;

public class Fmi2Port extends Fmi2ScalarVariable {
	private Port port;

	private Fmi2Port drivingPort = null;
	
	public Fmi2Port(Fmu2ProxyService fmu, Port p, Stereotype st) {
		// TODO Auto-generated constructor stub
		super(fmu, p, st);
		this.port = p;
	}

	public Port getPort() {
		return port;
	}

	public void setPort(Port port) {
		this.port = port;
	}

	public void setDrivingPort(Fmi2Port drivingPort) {
		this.drivingPort = drivingPort;
	}
	
	public Fmi2Port getDrivingPort() {
		return drivingPort;
	}
	
	public void updateRuntimeValue(){
		if (drivingPort != null){
			setRuntimeValue(drivingPort.getRuntimeValue());
		}
		
	}
}
