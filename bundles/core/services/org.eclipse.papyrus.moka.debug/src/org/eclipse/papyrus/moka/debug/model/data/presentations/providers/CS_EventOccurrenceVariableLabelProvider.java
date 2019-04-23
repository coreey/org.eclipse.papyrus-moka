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

package org.eclipse.papyrus.moka.debug.model.data.presentations.providers;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.InvocationActions.ICS_EventOccurrence;
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.CS_EventOccurrenceValueAdapter;
import org.eclipse.papyrus.moka.debug.model.data.mapping.variables.EventOccurrenceVariableAdapter;
import org.eclipse.papyrus.moka.debug.model.data.presentations.MokaDebugLabelProvider;
import org.eclipse.papyrus.moka.debug.model.data.presentations.MokaDebugLabelProviderFactory;
import org.eclipse.swt.graphics.Image;

public class CS_EventOccurrenceVariableLabelProvider extends MokaDebugLabelProvider {

	protected ILabelProvider getDelegatedLabelProvider(Object element) {
		ILabelProvider labelProvider = null;
		if (element != null) {
			try {
				CS_EventOccurrenceValueAdapter valueAdapter = (CS_EventOccurrenceValueAdapter) ((EventOccurrenceVariableAdapter) element)
						.getValue();
				ICS_EventOccurrence eventOccurrence = (ICS_EventOccurrence) valueAdapter.getAdapted();
				labelProvider = MokaDebugLabelProviderFactory.getInstance().instantiate(
						new EventOccurrenceVariableAdapter(null, eventOccurrence.getWrappedEventOccurrence()));
			} catch (DebugException e) {
				// Silently catch the exception (the default icon will be used)
			}
		}
		return labelProvider;
	}

	@Override
	public String getText(Object element) {
		String text = "";
		if (element != null) {
			ILabelProvider labelProvider = this.getDelegatedLabelProvider(element);
			if (labelProvider != null) {
				text = labelProvider.getText(element);
			}
		}
		return text;
	}

	@Override
	public Image getImage(Object element) {
		Image icon = null;
		if (element != null) {
			ILabelProvider labelProvider = this.getDelegatedLabelProvider(element);
			if (labelProvider != null) {
				icon = labelProvider.getImage(element);
			}
		}
		return icon;
	}

}
