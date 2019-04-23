/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
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
package org.eclipse.papyrus.moka.animation;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.moka.animation.presentation.control.AnimatingInstanceLabelProvider;
import org.eclipse.papyrus.moka.animation.presentation.control.RootLabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class AnimationPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.moka.animation"; //$NON-NLS-1$

	// The shared instance
	private static AnimationPlugin plugin;

	/**
	 * The constructor
	 */
	public AnimationPlugin() {
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
	public static AnimationPlugin getDefault() {
		return plugin;
	}

	protected void initImageRegistry() {
		ImageRegistry registry = this.getImageRegistry();
		registry.put(AnimatingInstanceLabelProvider.THREAD_ICON, this.getDescriptor(AnimatingInstanceLabelProvider.THREAD_ICON));
		registry.put(RootLabelProvider.ROOT_ICON, this.getDescriptor(RootLabelProvider.ROOT_ICON));
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
