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

package org.eclipse.papyrus.moka.engine.uml.debug.data.presentation;

import org.eclipse.papyrus.moka.engine.uml.debug.UMLDebugPlugin;
import org.eclipse.swt.graphics.Image;

public class CallEventOccurrenceVariableLabelProvider extends UMLDebugLabelProvider{
	
	public final static String CALL_EVENT_ICON = "resources/icons/call.png"; 
	
	private final static String CALL_EVENT_TEXT = "Call Event";
	
	@Override
	public String getText(Object element) {
		return CALL_EVENT_TEXT;
	}
	
	@Override
	public Image getImage(Object element) {
		if(element != null){
			return UMLDebugPlugin.getDefault().getImageRegistry().get(CALL_EVENT_ICON);
		}
		return null;
	}


}
