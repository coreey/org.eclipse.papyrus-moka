/*****************************************************************************
 * 
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
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmu.communication;

import java.util.Map;

public interface FMUInterface {
	
	

	public Map<Integer, Double> fmiGetReals();
	public Map<Integer, Integer> fmiGetIntegers();
	public Map<Integer, Boolean>  fmiGetBools();
	public Map<Integer, String> fmiGetStrings();
	
	
	public void fmiSetReals(Map<Integer, Double> realsMap);
	public void fmiSetIntegers(Map<Integer, Integer> integersMap);
	public void fmiSetBools(Map<Integer, Boolean> boolsMap);
	public void fmiSetStrings(Map<Integer, String> stringsMap);
	
	
	public void doStep(double currentCommunicationTime, double stepSize);
	public void init();
	public void terminate();
	void updateMaps();
	
}
