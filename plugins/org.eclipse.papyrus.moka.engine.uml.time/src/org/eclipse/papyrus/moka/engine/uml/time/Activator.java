/*****************************************************************************
 * Copyright (c) 2016, 2020 CEA LIST.
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
package org.eclipse.papyrus.moka.engine.uml.time;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	/**
	 * Plugin instance
	 */
	private static Activator plugin;

	/**
	 * Logger used within that plugin
	 */
	public ILog logger;

	@Override
	public void start(BundleContext context) throws Exception {
		plugin = this;
		logger = Platform.getLog(this.getClass());
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		logger = null;
		plugin = null;
	}

	public static Activator getInstance() {
		return plugin;
	}

}
