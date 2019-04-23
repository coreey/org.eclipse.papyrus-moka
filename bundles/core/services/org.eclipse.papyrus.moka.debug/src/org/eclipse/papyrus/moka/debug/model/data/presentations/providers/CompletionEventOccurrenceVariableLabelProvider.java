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

package org.eclipse.papyrus.moka.debug.model.data.presentations.providers;

import org.eclipse.papyrus.moka.debug.MokaDebugPlugin;
import org.eclipse.papyrus.moka.debug.model.data.presentations.MokaDebugLabelProvider;
import org.eclipse.swt.graphics.Image;

public class CompletionEventOccurrenceVariableLabelProvider  extends MokaDebugLabelProvider{

public final static String COMPLETION_EVENT_ICON = "resources/icons/completion.png"; 
	
	private final static String COMPLETION_EVENT_TEXT = "Completion Event";
	
	@Override
	public String getText(Object element) {
		return COMPLETION_EVENT_TEXT;
	}
	
	@Override
	public Image getImage(Object element) {
		if(element != null){
			return MokaDebugPlugin.getDefault().getImageRegistry().get(COMPLETION_EVENT_ICON);
		}
		return null;
	}
	
}
