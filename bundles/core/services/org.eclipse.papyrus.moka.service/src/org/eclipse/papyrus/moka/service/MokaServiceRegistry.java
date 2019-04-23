/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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

package org.eclipse.papyrus.moka.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

public class MokaServiceRegistry {

	protected static String MOKA_SERVICE_EXTENSION_POIN_ID = "org.eclipse.papyrus.moka.service.service";

	private boolean loaded;
	
	// The registry map associates the actual type of the service to the
	// service instance
	protected HashMap<java.lang.Class<?>, IMokaService> registry;

	// The service registry is a singleton
	private static MokaServiceRegistry INSTANCE;

	private MokaServiceRegistry() {
		this.registry = new HashMap<java.lang.Class<?>, IMokaService>();
		this.loaded = false;
	}

	public static MokaServiceRegistry getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MokaServiceRegistry();
		}
		return INSTANCE;
	}

	public void loadServices() {
		// Instantiate registered services
		if(!this.loaded){
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IConfigurationElement[] configurations = registry.getConfigurationElementsFor(MOKA_SERVICE_EXTENSION_POIN_ID);
			for (int i = 0; i < configurations.length; i++) {
				Object instantiatedContribution = null;
				try {
					instantiatedContribution = configurations[i].createExecutableExtension("class");
				} catch (CoreException e) {
					e.printStackTrace();
				}
				if (instantiatedContribution != null && instantiatedContribution instanceof IMokaService) {
					this.register((IMokaService) instantiatedContribution);
				}
			}
			this.loaded = true;
		}
	}

	protected void register(IMokaService service) {
		// Register service within the registry
		if (service != null) {
			this.registry.put(service.getClass(), service);
		}
	}

	public List<IMokaService> getService(java.lang.Class<?> clazz) {
		// Return the list of service that are compatible with the given type
		List<IMokaService> services = new ArrayList<>();
		Iterator<Class<?>> iterator = this.registry.keySet().iterator();
		while (iterator.hasNext()) {
			Class<?> type = iterator.next();
			if (clazz.isAssignableFrom(type)) {
				services.add(this.registry.get(type));
			}
		}
		return services;
	}

	public Collection<IMokaService> getAllServices() {
		// Provide the list of all registered services
		return this.registry.values();
	}

}
