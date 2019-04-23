/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.fmi.modeldescription;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Initial Unknowns Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.InitialUnknownsType#getGroup <em>Group</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.InitialUnknownsType#getUnknown <em>Unknown</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getInitialUnknownsType()
 * @model extendedMetaData="name='InitialUnknowns_._type' kind='elementOnly'"
 * @generated
 */
public interface InitialUnknownsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getInitialUnknownsType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Unknown</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Dependency of scalar Unknown from Knowns:
	 *     Unknown=f(Known_1, Known_2, ...).
	 * The Knowns are "inputs",
	 * "variables with initial=exact", and
	 * "independent variable".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unknown</em>' containment reference list.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getInitialUnknownsType_Unknown()
	 * @model containment="true" required="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Unknown' namespace='##targetNamespace' group='group:0'"
	 * @generated
	 */
	EList<UnknownType> getUnknown();

} // InitialUnknownsType
