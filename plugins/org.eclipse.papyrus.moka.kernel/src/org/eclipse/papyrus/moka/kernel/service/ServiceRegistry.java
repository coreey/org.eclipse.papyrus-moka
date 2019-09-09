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

package org.eclipse.papyrus.moka.kernel.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;

public class ServiceRegistry {

	/**
	 * Engine service extension point id
	 */
	protected static String MOKA_SERVICE_EXTENSION_POINT_ID = "org.eclipse.papyrus.moka.kernel.service";

	/**
	 * The registry map associates the actual type of the service to the
	 */
	protected HashMap<java.lang.Class<?>, IExecutionEngineService<IExecutionEngine>> registry;

	/**
	 * Service class attribute
	 */
	protected static final String SERVICE_CLASS_ATTRIBUTE = "class";

	/**
	 * Service context element
	 */
	protected static final String SERVICE_CONTEXT_ELEMENT = "context";

	/**
	 * Service context engine id attribute
	 */
	protected static final String SERVICE_ENGINE_ID = "engineID";

	/**
	 * The service registry is a singleton
	 */
	private static ServiceRegistry INSTANCE;

	private ServiceRegistry() {
		this.registry = new HashMap<java.lang.Class<?>, IExecutionEngineService<IExecutionEngine>>();
	}

	public static ServiceRegistry getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceRegistry();
		}
		return INSTANCE;
	}

	/**
	 * Check if the service can be instantiated in the current engine context
	 * 
	 * @param serviceSpecification the service specification
	 * 
	 * @param engine the current execution engine
	 *  
	 * @return true if the service contribution can be instantiated and false otherwise
	 */
	protected boolean canInstantiate(final IConfigurationElement serviceSpecification, final IExecutionEngine engine) {
		boolean canInstantiate = false;
		if (serviceSpecification != null) {
			IConfigurationElement[] contextSpecification = serviceSpecification.getChildren(SERVICE_CONTEXT_ELEMENT);
			if (contextSpecification.length == 0) {
				canInstantiate = true;
			} else {
				int i = 0;
				while (!canInstantiate && i < contextSpecification.length) {
					if (!contextSpecification[i].getAttribute(SERVICE_ENGINE_ID).equals(engine.getID())) {
						i++;
					} else {
						canInstantiate = true;
					}
				}
			}
		}
		return canInstantiate;
	}

	@SuppressWarnings("unchecked")
	public void loadServices(IExecutionEngine engine) {
		// Instantiate registered services
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] configurations = registry.getConfigurationElementsFor(MOKA_SERVICE_EXTENSION_POINT_ID);
		for (int i = 0; i < configurations.length; i++) {
			if(canInstantiate(configurations[i], engine)) {
				Object instantiatedContribution = null;
				try {
					instantiatedContribution = configurations[i].createExecutableExtension(SERVICE_CLASS_ATTRIBUTE);
				} catch (CoreException e) {
					e.printStackTrace();
				}
				if (instantiatedContribution != null && instantiatedContribution instanceof IExecutionEngineService) {
					this.register((IExecutionEngineService<IExecutionEngine>) instantiatedContribution);
				}
			}
		}
	}

	protected void register(IExecutionEngineService<IExecutionEngine> service) {
		// Register service within the registry
		if (service != null) {
			this.registry.put(service.getClass(), service);
		}
	}

	public List<IExecutionEngineService<IExecutionEngine>> getService(java.lang.Class<?> clazz) {
		// Return the list of service that are compatible with the given type
		List<IExecutionEngineService<IExecutionEngine>> services = new ArrayList<>();
		Iterator<Class<?>> iterator = this.registry.keySet().iterator();
		while (iterator.hasNext()) {
			Class<?> type = iterator.next();
			if (clazz.isAssignableFrom(type)) {
				services.add(this.registry.get(type));
			}
		}
		return services;
	}

	public Collection<IExecutionEngineService<IExecutionEngine>> getAllServices() {
		// Provide the list of all registered services
		return this.registry.values();
	}

	public void clear() {
		registry.clear();
	}

}
