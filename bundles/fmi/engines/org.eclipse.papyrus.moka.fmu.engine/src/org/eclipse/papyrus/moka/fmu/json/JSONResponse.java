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
package org.eclipse.papyrus.moka.fmu.json;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONResponse {
	public static final String STATUS = "s";
	public static final String NEXT_DATE = "nd";

	public String status;
	public Double nextDate;
	
	public int[] intVRs;
	public int[] ints;
	
	public int[] doubleVRs;
	public double[] doubles;
	
	public int[] boolVRs;
	public boolean[] bools;
	
	public int[] stringVRs;
	public String[] strings;
	
}
