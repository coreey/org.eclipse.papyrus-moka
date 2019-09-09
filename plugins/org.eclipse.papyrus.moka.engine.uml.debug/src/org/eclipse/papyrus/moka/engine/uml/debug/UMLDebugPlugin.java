/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.engine.uml.debug;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.moka.engine.uml.debug.data.presentation.CallEventOccurrenceVariableLabelProvider;
import org.eclipse.papyrus.moka.engine.uml.debug.data.presentation.CompletionEventOccurrenceVariableLabelProvider;
import org.eclipse.papyrus.moka.engine.uml.debug.data.presentation.EventPoolVariableLabelProvider;
import org.eclipse.papyrus.moka.engine.uml.debug.data.presentation.ExecutionContextVariableLabelProvider;
import org.eclipse.papyrus.moka.engine.uml.debug.data.presentation.ItemVariableLabelProvider;
import org.eclipse.papyrus.moka.engine.uml.debug.data.presentation.SignalEventOccurrenceVariableLabelProvider;
import org.eclipse.papyrus.moka.engine.uml.debug.data.presentation.SuspensionPointVariableLabelProvider;
import org.eclipse.papyrus.moka.engine.uml.debug.data.presentation.TimeEventOccurrenceVariableLabelProvider;
import org.eclipse.papyrus.moka.engine.uml.debug.data.presentation.TokensVariableLabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class UMLDebugPlugin extends AbstractUIPlugin {

	private static UMLDebugPlugin plugin;

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		initImageRegistry();
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	protected void initImageRegistry() {
		ImageRegistry registry = this.getImageRegistry();
		registry.put(ExecutionContextVariableLabelProvider.CONTEXT_ICON,
				this.getDescriptor(ExecutionContextVariableLabelProvider.CONTEXT_ICON));
		registry.put(SuspensionPointVariableLabelProvider.SUSPEND_ICON,
				this.getDescriptor(SuspensionPointVariableLabelProvider.SUSPEND_ICON));
		registry.put(EventPoolVariableLabelProvider.EVENT_POOL_ICON,
				this.getDescriptor(EventPoolVariableLabelProvider.EVENT_POOL_ICON));
		registry.put(ItemVariableLabelProvider.ITEM_ICON, this.getDescriptor(ItemVariableLabelProvider.ITEM_ICON));
		registry.put(TokensVariableLabelProvider.TOKEN_SET_ICON,
				this.getDescriptor(TokensVariableLabelProvider.TOKEN_SET_ICON));
		registry.put(TimeEventOccurrenceVariableLabelProvider.TIME_EVENT_ICON,
				this.getDescriptor(TimeEventOccurrenceVariableLabelProvider.TIME_EVENT_ICON));
		registry.put(SignalEventOccurrenceVariableLabelProvider.SIGNAL_EVENT_ICON,
				this.getDescriptor(SignalEventOccurrenceVariableLabelProvider.SIGNAL_EVENT_ICON));
		registry.put(CallEventOccurrenceVariableLabelProvider.CALL_EVENT_ICON,
				this.getDescriptor(CallEventOccurrenceVariableLabelProvider.CALL_EVENT_ICON));
		registry.put(CompletionEventOccurrenceVariableLabelProvider.COMPLETION_EVENT_ICON,
				this.getDescriptor(CompletionEventOccurrenceVariableLabelProvider.COMPLETION_EVENT_ICON));
	}

	public ImageDescriptor getDescriptor(final String path) {
		ImageDescriptor descriptor = null;
		URL url = getDefault().getBundle().getResource(path);
		if (url != null) {
			descriptor = ImageDescriptor.createFromURL(url);
		}
		return descriptor;
	}

	public static UMLDebugPlugin getDefault() {
		return plugin;
	}
}
