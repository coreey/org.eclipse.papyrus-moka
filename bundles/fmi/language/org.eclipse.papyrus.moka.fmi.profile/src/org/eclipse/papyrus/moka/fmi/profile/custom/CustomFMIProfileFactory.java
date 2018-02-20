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
package org.eclipse.papyrus.moka.fmi.profile.custom;

import org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU;
import org.eclipse.papyrus.moka.fmi.fmiprofile.CalculatedParameter;
import org.eclipse.papyrus.moka.fmi.fmiprofile.Independent;
import org.eclipse.papyrus.moka.fmi.fmiprofile.Local;
import org.eclipse.papyrus.moka.fmi.fmiprofile.ME_FMU;
import org.eclipse.papyrus.moka.fmi.fmiprofile.Parameter;
import org.eclipse.papyrus.moka.fmi.fmiprofile.Port;
import org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfileFactoryImpl;

public class CustomFMIProfileFactory extends FMIProfileFactoryImpl {
	@Override
	public CS_FMU createCS_FMU() {

		return new CustomCS_FMU();
	}
	
	public ME_FMU createME_FMU(){
		return new CustomME_FMU();
	}
	
	@Override
	public Local createLocal() {
		return new CustomLocal();
	}
	
	@Override
	public CalculatedParameter createCalculatedParameter() {
		return new CustomCalculatedParameter();
	}
	
	@Override
	public Parameter createParameter() {
		return new CustomParameter();
	}
	
	@Override
	public Port createPort() {
		return new CustomPort();
	}
	
	@Override
	public Independent createIndependent() {
		
		return new CustomIndependant();
	}
}
