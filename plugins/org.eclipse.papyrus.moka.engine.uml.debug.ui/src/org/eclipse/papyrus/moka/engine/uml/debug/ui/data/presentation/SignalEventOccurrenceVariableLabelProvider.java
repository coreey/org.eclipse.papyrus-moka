/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
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

package org.eclipse.papyrus.moka.engine.uml.debug.ui.data.presentation;

import org.eclipse.papyrus.moka.engine.uml.debug.ui.UMLDebugPlugin;
import org.eclipse.swt.graphics.Image;

public class SignalEventOccurrenceVariableLabelProvider extends UMLDebugLabelProvider{

	public final static String SIGNAL_EVENT_ICON = "resources/icons/signal.png"; 
	
	private final static String SIGNAL_EVENT_TEXT = "Signal Event";
	
	@Override
	public String getText(Object element) {
		return SIGNAL_EVENT_TEXT;
	}
	
	@Override
	public Image getImage(Object element) {
		if(element != null){
			return UMLDebugPlugin.getDefault().getImageRegistry().get(SIGNAL_EVENT_ICON);
		}
		return null;
	}

}
