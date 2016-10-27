/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmi.profile.util;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.util.UMLUtil;

public class FastUMLUtil extends UMLUtil {

	/**
	 * Retrieves the stereotype application of the specified class for the
	 * specified element, or null if no such stereotype application exists.
	 * This fast implem doesn't check the defining stereotype, i.e. doesn't 
	 * require to load the defining profile
	 * 
	 * @param element The element to which the stereotype is applied.
	 * @param clazz The class of the stereotype application to retrieve.
	 * @return The stereotype application.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T fastGetStereotypeApplication(Element element, Class<T> clazz) {

		for (EObject stereotypeApplication :fastGetStereotypeApplications(element)) {
			
			if (clazz.isInstance(stereotypeApplication)) {
				return (T) stereotypeApplication;
			}
		}
		
		return null;
	}

	/**

	 * Retrieves the stereotype applications for this element
	 * This fast implem doesn't check the defining stereotype, i.e. doesn't 
	 * require to load the defining profile
	 * @param element The receiving '<em><b>Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * 
	 */
	public static EList<EObject> fastGetStereotypeApplications(Element element) {
		EList<EObject> stereotypeApplications = new UniqueEList.FastCompare<EObject>();

		for (EStructuralFeature.Setting setting : getNonNavigableInverseReferences(
			element)) {

			if (setting.getEStructuralFeature().getName()
				.startsWith(Extension.METACLASS_ROLE_PREFIX)) {

				EObject eObject = setting.getEObject();

				if (eObject != null) {
					stereotypeApplications.add(eObject);
				}
			}
		}

		return ECollections.unmodifiableEList(stereotypeApplications);
	}
}
