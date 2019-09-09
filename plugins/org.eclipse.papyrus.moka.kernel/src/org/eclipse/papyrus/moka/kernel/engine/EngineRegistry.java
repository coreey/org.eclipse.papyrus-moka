/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
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
package org.eclipse.papyrus.moka.kernel.engine;

import java.util.Collection;
import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

public class EngineRegistry {

	/**
	 * Engine extension point identifier
	 */
	public static String MOKA_ENGINE_EXTENSION_POINT_ID = "org.eclipse.papyrus.moka.kernel.engine";

	/**
	 * Engine extension point id attribute
	 */
	protected final static String ENGINE_ID_ATTRIBUTE = "id";

	/**
	 * Engine extension point class attribute
	 */
	protected final static String ENGINE_CLASS_ATTRIBUTE = "class";

	/**
	 * Map associating identifier to engine instances
	 */
	protected HashMap<String, IExecutionEngine> registry;

	/**
	 * Singleton instance of the registry
	 */
	private static EngineRegistry INSTANCE;

	private EngineRegistry() {
		registry = new HashMap<String, IExecutionEngine>();
	}

	public static EngineRegistry getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EngineRegistry();
		}
		return INSTANCE;
	}

	public void loadEngines() {
		// Find all engines contributed through extension point.
		// Engines are not instantiated but their ID get registered.
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IConfigurationElement[] configurations = extensionRegistry
				.getConfigurationElementsFor(MOKA_ENGINE_EXTENSION_POINT_ID);
		for (int i = 0; i < configurations.length; i++) {
			String identifier = configurations[i].getAttribute(ENGINE_ID_ATTRIBUTE);
			if (!registry.containsKey(identifier)) {
				Object instance = null;
				try {
					instance = configurations[i].createExecutableExtension(ENGINE_CLASS_ATTRIBUTE);
				} catch (CoreException e) {
					e.printStackTrace();
				}
				if (instance != null && instance instanceof IExecutionEngine) {
					((IExecutionEngine) instance).setID(identifier);
					registry.put(identifier, (IExecutionEngine) instance);
				}
			}
		}
	}

	public IExecutionEngine getEngine(final String engineID) {
		// Return an instance of the specified engine
		return registry.get(engineID);
	}

	public Collection<IExecutionEngine> getAllEngines() {
		// Return an instance of all engines contributed through the extension point
		return registry.values();
	}
	
	public void clear() {
		registry.clear();
	}

}
