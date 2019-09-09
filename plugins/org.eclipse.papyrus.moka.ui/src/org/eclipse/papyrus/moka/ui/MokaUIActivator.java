/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.moka.ui;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class MokaUIActivator extends AbstractUIPlugin {

	/**
	 * The plug-in ID
	 */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.moka.ui"; //$NON-NLS-1$

	/**
	 * MOKA icon identifier
	 */
	public static final String MOKA_ICON_ID = "MOKA-ICON";
	
	// The shared instance
	private static MokaUIActivator plugin;
	
	private LogHelper logger;

	/**
	 * The constructor
	 */
	public MokaUIActivator() {
		logger = new LogHelper(this);
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static MokaUIActivator getDefault() {
		return plugin;
	}
	
	public LogHelper getLogger() {
		return logger;
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		reg.put(MOKA_ICON_ID, imageDescriptorFromPlugin(PLUGIN_ID, "icons/moka_icon.png"));
	}
	
}
