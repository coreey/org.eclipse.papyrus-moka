/*****************************************************************************
 * Copyright (c) 2020 CEA LIST and others.
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
package org.eclipse.papyrus.moka.engine.uml;

import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	/**
	 * Plugin instance
	 */
	private static Activator PLUGIN;
	
	/**
	 * Logger used within that plugin
	 */
	public static LogHelper LOGGER;
	
	@Override
	public void start(BundleContext context) throws Exception {
		PLUGIN = this;
		LOGGER = new LogHelper(context.getBundle());
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		LOGGER = null;
		PLUGIN = null;
	}
	
	public static Activator getInstance(){
		return PLUGIN;
	}

}
