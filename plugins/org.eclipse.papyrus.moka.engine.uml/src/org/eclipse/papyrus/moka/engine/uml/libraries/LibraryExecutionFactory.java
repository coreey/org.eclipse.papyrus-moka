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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IOpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.loci.ILocus;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;

public abstract class LibraryExecutionFactory implements ILibraryExecutionFactory{

	/**
	 * Library path
	 */
	protected URI libraryURI;
	
	/**
	 * Resource containing the library
	 */
	protected Resource libraryResource;
	
	/**
	 * Map linking opaque behaviors to their qualified name
	 */
	protected Map<String, OpaqueBehavior> libraryOpaqueBehavior;
	
	/**
	 * Map linking classes to their qualified names
	 */
	protected Map<String, Class> libraryService;
	
	public LibraryExecutionFactory() {
		libraryOpaqueBehavior = new HashMap<String, OpaqueBehavior>();
		libraryService = new HashMap<String, Class>();
	}
	
	/**
	 * Find all opaque behaviors within the resource
	 */
	protected void parseLibrary(URI uri, Resource resource) {
		libraryURI = uri;
		libraryResource = resource;
		if(libraryResource != null) {
			libraryOpaqueBehavior.clear();
			Iterator<EObject> contentIterator = libraryResource.getAllContents();
			while(contentIterator.hasNext()) {
				EObject current = contentIterator.next();
				if(!current.eIsProxy() && current instanceof OpaqueBehavior) {
					libraryOpaqueBehavior.put(((OpaqueBehavior)current).getQualifiedName(), (OpaqueBehavior)current);
				} else if(!current.eIsProxy() && !(current instanceof Behavior) && current instanceof Class) {
					libraryService.put(((Class)current).getQualifiedName(), (Class)current);
				}
			}
		}
	}
	
	/**
	 * Add an opaque behavior execution to the locus
	 * @param execution
	 *  the opaque behavior execution
	 * @param locus
	 * 	the locus at which the execution is registered
	 */
	protected void register(IOpaqueBehaviorExecution execution, ILocus locus) {
		if(locus != null && execution != null) {
			locus.getFactory().addPrimitiveBehaviorPrototype(execution);
		}
	}

}
