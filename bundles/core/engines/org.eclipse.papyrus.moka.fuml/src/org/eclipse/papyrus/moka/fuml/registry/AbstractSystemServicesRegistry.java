/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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

package org.eclipse.papyrus.moka.fuml.registry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.utils.ResourceSetUtils;
import org.eclipse.uml2.uml.Class;

/**
 * Abstract implementation of ISystemServicesRegistry.
 * Clients should consider extending this abstract implementation rather than directly implementing ISystemServicesRegistry
 *
 */
public abstract class AbstractSystemServicesRegistry implements ISystemServicesRegistry {

	protected EObject contextEObject;

	protected ILocus locus;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.moka.fuml.registry.ISystemServicesRegistry#init(java.lang.Object)
	 */
	public ISystemServicesRegistry init(Object parameters) {
		if (parameters instanceof EObject) {
			this.contextEObject = (EObject) parameters;
		}
		return this;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.papyrus.moka.fuml.registry.ISystemServicesRegistry#registerSystemServices(org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus
	 * )
	 */
	public void registerSystemServices(ILocus locus) {
		this.locus = locus;
		List<IObject_> services = this.instantiateServices();
		// Guarantees that created services are added to the locus
		for (IObject_ o : services) {
			o.setLocus(locus);
			locus.add(o);
		}
	}

	/**
	 * Clients should implement this method by calling this.instantiateServices(libraryName, serviceQualifiedNames,
	 * where libraryName is the name of a registered library containing the service classes to be instantiated,
	 * and serviceQualifiedNames is the list of qualified names of service classes to be instantiated
	 *
	 * @return A List<Object_> containing instantiated services, to be added to a specific locus
	 */
	protected abstract List<IObject_> instantiateServices();

	/**
	 * Convenience method which calls the instantiate method on each service identified in the given serviceQualifiedNames list,
	 * for the library identified by the given libraryName.
	 * libraryURIString shall refer to the URI used to register a library of a registered library (registered using org.eclipse.emf.ecore.uri_mapping extension point)
	 * serviceQualifiedNames shall contain qualified names of classes defined in the library identified by libraryName
	 *
	 * @param libraryURIString
	 *            The name of the registered library containing the service classes to be instantiated
	 * @param serviceQualifiedNames
	 *            The list of qualified names of service classes to be instantiated
	 * @return A List<Object_> containing instantiated services, to be added to a specific locus
	 */
	protected List<IObject_> instantiateServices(String libraryURIString, List<String> serviceQualifiedNames) {
		List<IObject_> serviceInstances = new ArrayList<IObject_>();
		
		if (libraryURIString != null) {
			URI libraryUri = URI.createURI(libraryURIString);
			ResourceSet resourceSet = ResourceSetUtils.getResourceSet(contextEObject);
			if (resourceSet == null){
				resourceSet = ResourceSetUtils.getDefaultResourceSet();
			}
			Resource libraryResource = resourceSet.getResource(libraryUri, true);
			for (Iterator<EObject> i = libraryResource.getAllContents(); i.hasNext();) {
				EObject cddService = i.next();
				if (cddService instanceof Class) {
					if (serviceQualifiedNames.contains(((Class) cddService).getQualifiedName())) {
						serviceInstances.add(this.instantiateService((Class) cddService));
					}
				}
			}
		}
		return serviceInstances;
	}

	/**
	 * Constructs a service instance from a given service class.
	 * The service instance is returned in the form of a fuml Object_.
	 * The return Object_ typically overrids Objec_.dispatch(Operation)
	 *
	 * @param service
	 *            The class representing the service to be instantiated
	 * @return The instance of the service class, to be added at a specific locus
	 */
	protected abstract IObject_ instantiateService(Class service);

}
