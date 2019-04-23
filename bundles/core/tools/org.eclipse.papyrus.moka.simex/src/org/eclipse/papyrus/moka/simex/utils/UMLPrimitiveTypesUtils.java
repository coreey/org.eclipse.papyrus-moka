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

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Type;

/**
 * Utility class to retrieve UML primitive types defined in the UMLPrimitiveTypes library
 * (i.e., Integer, String, Boolean, UnlimitedNatural, Real)
 * 
 * @author ac221913
 *
 */
public class UMLPrimitiveTypesUtils {

	private final static String INTEGER_TYPE_NAME = "PrimitiveTypes::Integer" ;
	private final static String STRING_TYPE_NAME = "PrimitiveTypes::String" ;
	private final static String BOOLEAN_TYPE_NAME = "PrimitiveTypes::Boolean" ;
	private final static String UNLIMITED_NATURAL_TYPE_NAME = "PrimitiveTypes::UnlimitedNatural" ;
	private final static String REAL_TYPE_NAME = "PrimitiveTypes::Real" ;
	private final static String UML_PRIMITIVE_TYPES_LIBRARY_NAME = "UMLPrimitiveTypes" ;

	/**
	 * Retrieves a predefined UML PrimitiveType whose qualified name is qualifiedTypeName,
	 * in the context of the given context UML model element.
	 * The effect is that, if the UML Primitive TYpes library is not loaded in the
	 * resource set containing the model that contains the given context model element,
	 * the UML Primitive Types library is loaded in the resource set. Once the library
	 * is loaded, the desired primitive type is retrieve from the library using the given
	 * qualifiedTypeName 
	 * 
	 * @param context The context UML model element from which the UML Primitive Type is required
	 * @param qualifiedTypeName The qualified name of the predefined UML primitive type
	 * @return A Primitive Type from the UML Primitive Types library, whose qualified name equals qualifiedTypeName
	 */
	private static Type getUMLPrimitiveType(Element context, String qualifiedTypeName) {
		NamedElement element = RegisteredLibraryLoadAndSearchUtils.getNamedElement(context, qualifiedTypeName, UML_PRIMITIVE_TYPES_LIBRARY_NAME) ;
		if (element != null && element instanceof Type) {
			return (Type)element ;
		}
		return null ;
	}
	
	public static Type getInteger(Element context) {
		return getUMLPrimitiveType(context, INTEGER_TYPE_NAME) ;
	}

	public static Type getBoolean(Element context) {
		return getUMLPrimitiveType(context, BOOLEAN_TYPE_NAME) ;
	}
	
	public static Type getUnlimitedNatural(Element context) {
		return getUMLPrimitiveType(context, UNLIMITED_NATURAL_TYPE_NAME) ;
	}
	
	public static Type getReal(Element context) {
		return getUMLPrimitiveType(context, REAL_TYPE_NAME) ;
	}
	
	public static Type getString(Element context) {
		return getUMLPrimitiveType(context, STRING_TYPE_NAME) ;
	}
}
