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

import java.util.HashMap;
import java.util.Map;


public abstract class AbstractFMU implements FMUInterface {

	protected Map<Integer, Double> realMap = new HashMap<Integer, Double>();
	protected Map<Integer, Integer> integerMap = new HashMap<Integer, Integer>();
	protected Map<Integer, Boolean> booleanMap = new HashMap<Integer, Boolean>();
	protected Map<Integer, String> stringMap = new HashMap<Integer, String>();
	
	@Override
	public Map<Integer, Double> fmiGetReals() {
		return realMap;
	}

	@Override
	public Map<Integer, Integer> fmiGetIntegers() {
		return integerMap;
	}

	@Override
	public Map<Integer, Boolean> fmiGetBools() {
		return booleanMap;
	}

	@Override
	public Map<Integer, String> fmiGetStrings() {
		return stringMap;
	}

	@Override
	public void fmiSetReals(Map<Integer, Double> realsMap) {
		this.realMap.putAll(realsMap);
	}

	@Override
	public void fmiSetIntegers(Map<Integer, Integer> integersMap) {
		this.integerMap.putAll(integersMap);

	}

	@Override
	public void fmiSetBools(Map<Integer, Boolean> boolsMap) {
		this.booleanMap.putAll(boolsMap);

	}

	@Override
	public void fmiSetStrings(Map<Integer, String> stringsMap) {
		this.stringMap.putAll(stringsMap);
	}

	@Override
	abstract public void doStep(double currentCommunicationTime, double stepSize);
	
	@Override
	abstract public void updateMaps();
	
	@Override
	public void init() {


	}

	@Override
	public void terminate() {

	}

}
