/*****************************************************************************
 * Copyright (c) 2015 CEA LIST
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
 *   Sebastien Revol - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.simex.dnd.strategy;

import org.eclipse.osgi.util.NLS;

/**
 * custom messages related to Drag and Drop
 *
 * @author SR246418
 *
 */
public class DndMessages extends NLS {

	
	static {
		NLS.initializeMessages("dnd-messages", DndMessages.class); //$NON-NLS-1$
	}

	private DndMessages() {
	}
	
	
	public static String AbstractDropStrategy_Description;
	public static String AbstractDropStrategy_Description_No_Ref;
	public static String AbstractDropStrategy_Label;
	
}
