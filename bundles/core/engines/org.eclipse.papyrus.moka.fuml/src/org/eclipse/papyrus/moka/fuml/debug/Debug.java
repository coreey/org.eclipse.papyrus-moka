/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.moka.fuml.debug;

public class Debug {

	public static void println(String message) {
		// System.err.println(message) ;
		// FIXME Bug 404555: [Moka] Pollution of the console with debug messages
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=404555
	}
}
