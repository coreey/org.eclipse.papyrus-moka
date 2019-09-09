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
package org.eclipse.papyrus.moka.engine.uml.libraries;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.moka.fuml.loci.ILocus;

public class LibraryRegistry {

	/**
	 * Factory class attribute name
	 */
	protected static final String LIBRARY_CLASS = "libraryFactoryClass";
	
	/**
	 * URI attribute name
	 */
	protected static final String LIBRARY_URI = "libraryURI";
	
	/**
	 * Library extension point ID
	 */
	protected static final String MOKA_ENGINE_LIBRARY_EXTENSION_POINT_ID = "org.eclipse.papyrus.moka.engine.uml.library";
	
	/**
	 * Library factories instantiated through the registry
	 */
	protected List<LibraryExecutionFactory> libraryFactory;
	
	/**
	 * Library registry self reference
	 */
	private static LibraryRegistry INSTANCE;
	
	private LibraryRegistry() {
		libraryFactory = new ArrayList<LibraryExecutionFactory>();
	}
	
	public static LibraryRegistry getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new LibraryRegistry();
		}
		return INSTANCE;
	}
	
	/**
	 * Instantiate all registered libraries
	 * @param resourceSet
	 *  the resource set that should contain the libraries
	 */
	public void loadLibraryFactories(ResourceSet resourceSet) {
		// Instantiate registered libraries
		if(resourceSet != null) {
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IConfigurationElement[] configurations = registry.getConfigurationElementsFor(MOKA_ENGINE_LIBRARY_EXTENSION_POINT_ID);
			for (int i = 0; i < configurations.length; i++) {
				URI libraryURI = null;
				Object factory = null;
				try {
					libraryURI = URI.createURI(configurations[i].getAttribute(LIBRARY_URI));
					factory = configurations[i].createExecutableExtension(LIBRARY_CLASS);
				} catch (CoreException e) {
					e.printStackTrace();
				}
				if(factory != null && libraryURI != null && !libraryURI.isEmpty()) {
					Resource libraryResource = resourceSet.getResource(libraryURI, true);
					if(libraryResource != null) {
						((LibraryExecutionFactory)factory).parseLibrary(libraryURI, libraryResource);
						libraryFactory.add(((LibraryExecutionFactory)factory));
					}
				}
			}
		}
	}
	
	/**
	 * Install opaque behavior execution / services provided 
	 * by the factories to the provided locus
	 * @param locus
	 *  the locus at which the executions / services get installed
	 */
	public void installLibraries(ILocus locus) {
		for(LibraryExecutionFactory factory : libraryFactory) {
			factory.installFunctions(locus);
		}
		for(LibraryExecutionFactory factory : libraryFactory) {
			factory.installServices(locus);
		}
	}
	
}
