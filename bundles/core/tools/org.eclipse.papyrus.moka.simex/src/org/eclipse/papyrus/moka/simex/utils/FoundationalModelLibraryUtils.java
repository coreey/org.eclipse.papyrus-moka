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

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

public class FoundationalModelLibraryUtils {
	
	private final static String FOUNDATIONAL_MODEL_LIBRARY_NAME = "FoundationalModelLibrary";
	private final static String LOWER_THAN_INTEGER_QUALIFIED_NAME = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::<" ;
	private final static String ADD_INTEGER_QUALIFIED_NAME = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::+" ;
	
	public static Behavior get_LowerThan_Integer(Element context) {
		return getBehavior(context, LOWER_THAN_INTEGER_QUALIFIED_NAME) ;
	}
	
	public static Behavior get_Add_Integer(Element context) {
		return getBehavior(context, ADD_INTEGER_QUALIFIED_NAME) ;
	}
	
	private static Behavior getBehavior(Element context, String behaviorQualifiedName) {
		NamedElement element = RegisteredLibraryLoadAndSearchUtils.getNamedElement(context, behaviorQualifiedName, FOUNDATIONAL_MODEL_LIBRARY_NAME) ;
		if (element != null && element instanceof Behavior) {
			return (Behavior)element ;
		}
		return null ;
	}
}
