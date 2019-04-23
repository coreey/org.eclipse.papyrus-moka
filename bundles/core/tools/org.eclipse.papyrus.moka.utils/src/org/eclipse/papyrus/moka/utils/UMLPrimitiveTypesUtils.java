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
package org.eclipse.papyrus.moka.utils;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.resource.UMLResource;

public class UMLPrimitiveTypesUtils {

	private static final String REAL_FRAGMENT = "Real";
	private static final String INTEGER_FRAGMENT = "Integer";
	private static final String STRING_FRAGMENT = "String";
	private static final String BOOL_FRAGMENT = "Boolean";
	
	private static URI uMLTypesURI = URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI);
	private static ResourceSet defaultResourceSet = new ResourceSetImpl();

	public static  PrimitiveType getReal(EObject context){
		return getElement(REAL_FRAGMENT, context);
	}
	
	public static PrimitiveType getInteger(EObject context){
		return getElement(INTEGER_FRAGMENT, context);
	}
	public  static PrimitiveType getBoolean(EObject context){
		return getElement(BOOL_FRAGMENT, context);
	}
	public static  PrimitiveType getString(EObject context){
		return getElement(STRING_FRAGMENT, context);
	}

	
	private static PrimitiveType getElement(String typeFragment, EObject context) {
		ResourceSet resSet;
		if (context != null && context.eResource() != null && context.eResource().getResourceSet() != null){
			resSet = context.eResource().getResourceSet();
		}else {
			resSet = defaultResourceSet;
		}
		
		return (PrimitiveType) resSet.getEObject(uMLTypesURI.appendFragment(typeFragment), true);
	}
	
}
