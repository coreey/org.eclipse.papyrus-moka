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
package org.eclipse.papyrus.moka.simex.utils;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.uml.extensionpoints.library.IRegisteredLibrary;
import org.eclipse.papyrus.uml.extensionpoints.library.RegisteredLibrary;
import org.eclipse.papyrus.uml.tools.utils.NameResolutionUtils;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

public class RegisteredLibraryLoadAndSearchUtils {

	public static NamedElement getNamedElement(Element context, String qualifiedTypeName, String libraryName) {
		Model libraryModel = loadLibrary(context, libraryName) ;
		if (libraryModel != null) {
			List<NamedElement> result = NameResolutionUtils.getNamedElements(qualifiedTypeName, libraryModel, UMLPackage.eINSTANCE.getNamedElement()) ;
			if (! result.isEmpty()) {
				return result.get(0) ;
			}
		}
		return null ;
	}
	
	/**
	 * If the model library is not loaded in the
	 * resource set containing the model that contains the given context model element,
	 * this method loads the library in the resource set, and then returns it.
	 * If the library is already loaded, then it is simply returned. 
	 * 
	 * @param context The context UML model element, whose resource set will be the place where the library will be loaded
	 * @return The model library
	 */
	public static Model loadLibrary(Element context, String libraryName) {
		Model libraryModel = null;
		IRegisteredLibrary registeredLibrary = null ;
		for (IRegisteredLibrary l : RegisteredLibrary.getRegisteredLibraries()) {
			if (l.getName().equals(libraryName)) {
				registeredLibrary=l ;
			}
		}
		if (registeredLibrary != null) {
			Resource libraryResource = context.eResource().getResourceSet().getResource(registeredLibrary.getUri(), true) ;
			if (libraryResource.getContents().get(0) instanceof Model) {
				libraryModel = (Model) libraryResource.getContents().get(0) ;
			}
		}
		return libraryModel;
	}
}
