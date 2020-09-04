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
package org.eclipse.papyrus.moka.trace.capture;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.moka.trace.Activator;
import org.eclipse.papyrus.moka.trace.interfaces.capture.ICaptureServiceFactory;

/**
 * Registry for Capture extension point
 */
public class CaptureServiceRegistry {

	public static final CaptureServiceRegistry INSTANCE = new CaptureServiceRegistry();

	private static final String EXTENSION_POINT = "org.eclipse.papyrus.moka.trace.capture";

	private static final String CLASS_PROPERTY_NAME = "class"; //$NON-NLS-1$

	private static final String NAME_PROPERTY_NAME = "name"; //$NON-NLS-1$

	private static final String ID_PROPERTY_NAME = "id"; //$NON-NLS-1$

	private Map<String, ICaptureServiceFactory> services;

	private CaptureServiceRegistry() {
		this.services = getRegisteredCaptureEngine();
	}

	public Map<String, ICaptureServiceFactory> getCaptureServices() {
		return services;
	}

	public ICaptureServiceFactory getCaptureService(String captureID) {
		return services.get(captureID);
	}

	private Map<String, ICaptureServiceFactory> getRegisteredCaptureEngine() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(EXTENSION_POINT);
		Map<String, ICaptureServiceFactory> captures = new HashMap<>();
		for (int i = 0; i < config.length; i++) {
			try {
				ICaptureServiceFactory engine = (ICaptureServiceFactory) config[i].createExecutableExtension(CLASS_PROPERTY_NAME);
				String engineName = config[i].getAttribute(NAME_PROPERTY_NAME);
				engine.setName(engineName);
				String engineId = config[i].getAttribute(ID_PROPERTY_NAME);
				engine.setId(engineId);
				captures.put(engineId, engine);
			} catch (CoreException e) {
				Activator.getDefault().logger.error("Could not create class for "+config[i].getAttribute(CLASS_PROPERTY_NAME),e);
			}
		}
		return captures;
	}

}
