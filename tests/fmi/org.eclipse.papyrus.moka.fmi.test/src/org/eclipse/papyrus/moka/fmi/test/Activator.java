/*****************************************************************************
 * 
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
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmi.test;

import org.eclipse.core.runtime.Plugin;


import org.osgi.framework.BundleContext;

public class Activator extends Plugin  {
	
	public static final String bundleID = "org.eclipse.papyrus.moka.fmi.test";
	private static Activator instance;

	public static Activator getDefault(){
		return instance;
	}
	
	
	@Override
	public void start(BundleContext context) throws Exception {
			super.start(context);
			instance = this;
	}
}
