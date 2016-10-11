/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  David LOPEZ BETANCUR (CEA LIST)
 *  Sebastien REVOL (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.datavisualization;

import org.osgi.framework.BundleContext;

import java.io.IOException;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;

public class Activator extends Plugin {

	private static BundleContext context;

	private static Activator instance; 
	
	public Activator(){
		super();
		instance = this;
	}

	public static void log(int severity, String message, Exception e){
		getInstance().getLog().log(new Status(severity,getBundleID(),message,e ));
	}
	
	public static Activator getInstance(){
		return instance;
	}
	static BundleContext getContext() {
		return context;
	}

	public static String getBundleID() {
		return instance.getBundle().getSymbolicName();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
