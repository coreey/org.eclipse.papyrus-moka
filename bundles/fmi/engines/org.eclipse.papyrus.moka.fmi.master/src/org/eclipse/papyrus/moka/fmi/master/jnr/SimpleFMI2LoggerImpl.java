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

package org.eclipse.papyrus.moka.fmi.master.jnr;

import org.eclipse.papyrus.moka.fmi.master.jnr.FMI2Callbacks.FMI2Logger;

import jnr.ffi.Pointer;

public class SimpleFMI2LoggerImpl implements FMI2Logger {

	@Override
	public void call(Pointer cmp, String cmpName, int status, String category, String message) {
		//TODO implement an FMI console and handle related category/status functionalities
		System.out.println("==>Component " + cmpName + " : "+ message);
	}

}
