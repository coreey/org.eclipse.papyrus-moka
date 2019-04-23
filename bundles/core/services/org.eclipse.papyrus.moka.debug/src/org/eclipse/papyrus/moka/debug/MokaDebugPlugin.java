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
package org.eclipse.papyrus.moka.debug;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.moka.debug.model.data.presentations.providers.CallEventOccurrenceVariableLabelProvider;
import org.eclipse.papyrus.moka.debug.model.data.presentations.providers.CompletionEventOccurrenceVariableLabelProvider;
import org.eclipse.papyrus.moka.debug.model.data.presentations.providers.EventPoolVariableLabelProvider;
import org.eclipse.papyrus.moka.debug.model.data.presentations.providers.ExecutionContextVariableLabelProvider;
import org.eclipse.papyrus.moka.debug.model.data.presentations.providers.ItemVariableLabelProvider;
import org.eclipse.papyrus.moka.debug.model.data.presentations.providers.SignalEventOccurrenceVariableLabelProvider;
import org.eclipse.papyrus.moka.debug.model.data.presentations.providers.SuspensionPointVariableLabelProvider;
import org.eclipse.papyrus.moka.debug.model.data.presentations.providers.TimeEventOccurrenceVariableLabelProvider;
import org.eclipse.papyrus.moka.debug.model.data.presentations.providers.TokensVariableLabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class MokaDebugPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.moka.debug"; //$NON-NLS-1$

	// The shared instance
	private static MokaDebugPlugin plugin;

	/**
	 * The constructor
	 */
	public MokaDebugPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		this.initImageRegistry();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static MokaDebugPlugin getDefault() {
		return plugin;
	}
	
	protected void initImageRegistry() {
		ImageRegistry registry = this.getImageRegistry();
		registry.put(ExecutionContextVariableLabelProvider.CONTEXT_ICON, this.getDescriptor(ExecutionContextVariableLabelProvider.CONTEXT_ICON));
		registry.put(SuspensionPointVariableLabelProvider.SUSPEND_ICON, this.getDescriptor(SuspensionPointVariableLabelProvider.SUSPEND_ICON));
		registry.put(EventPoolVariableLabelProvider.EVENT_POOL_ICON, this.getDescriptor(EventPoolVariableLabelProvider.EVENT_POOL_ICON));
		registry.put(ItemVariableLabelProvider.ITEM_ICON, this.getDescriptor(ItemVariableLabelProvider.ITEM_ICON));
		registry.put(TokensVariableLabelProvider.TOKEN_SET_ICON, this.getDescriptor(TokensVariableLabelProvider.TOKEN_SET_ICON));
		registry.put(TimeEventOccurrenceVariableLabelProvider.TIME_EVENT_ICON, this.getDescriptor(TimeEventOccurrenceVariableLabelProvider.TIME_EVENT_ICON));
		registry.put(SignalEventOccurrenceVariableLabelProvider.SIGNAL_EVENT_ICON, this.getDescriptor(SignalEventOccurrenceVariableLabelProvider.SIGNAL_EVENT_ICON));
		registry.put(CallEventOccurrenceVariableLabelProvider.CALL_EVENT_ICON, this.getDescriptor(CallEventOccurrenceVariableLabelProvider.CALL_EVENT_ICON));
		registry.put(CompletionEventOccurrenceVariableLabelProvider.COMPLETION_EVENT_ICON, this.getDescriptor(CompletionEventOccurrenceVariableLabelProvider.COMPLETION_EVENT_ICON));
	}

	public ImageDescriptor getDescriptor(final String path) {
		ImageDescriptor descriptor = null;
		URL url = getDefault().getBundle().getResource(path);
		if (url != null) {
			descriptor = ImageDescriptor.createFromURL(url);
		}
		return descriptor;
	}
}
