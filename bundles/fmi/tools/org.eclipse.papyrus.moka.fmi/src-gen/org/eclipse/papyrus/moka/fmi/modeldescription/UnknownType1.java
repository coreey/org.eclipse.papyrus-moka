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

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unknown Type1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1#getDependenciesKind <em>Dependencies Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getUnknownType1()
 * @model extendedMetaData="name='Unknown_._1_._type' kind='empty'"
 * @generated
 */
public interface UnknownType1 extends EObject {
	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Defines the dependency of the Unknown (directly or indirectly via auxiliary variables) on the Knowns in Continuous-Time and Event Mode (ModelExchange) and at Communication Points (CoSimulation). If not present, it must be assumed that the Unknown depends on all Knowns. If present as empty list, the Unknown depends on none of the Knowns. Otherwise the Unknown depends on the Knowns defined by the given ScalarVariable indices. The indices are ordered according to size, starting with the smallest index.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Dependencies</em>' attribute.
	 * @see #setDependencies(List)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getUnknownType1_Dependencies()
	 * @model dataType="org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesType1" many="false"
	 *        extendedMetaData="kind='attribute' name='dependencies' namespace='##targetNamespace'"
	 * @generated
	 */
	List<Long> getDependencies();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1#getDependencies <em>Dependencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependencies</em>' attribute.
	 * @see #getDependencies()
	 * @generated
	 */
	void setDependencies(List<Long> value);

	/**
	 * Returns the value of the '<em><b>Dependencies Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If not present, it must be assumed that the Unknown depends on the Knowns without a particular structure. Otherwise, the corresponding Known v enters the equation as:
	 * = "dependent": no particular structure, f(v)
	 * = "constant"   : constant factor, c*v (only for Real variablse)
	 * = "fixed"        : fixed factor, p*v (only for Real variables)
	 * = "tunable"    : tunable factor, p*v (only for Real variables)
	 * = "discrete"    : discrete factor, d*v (only for Real variables)
	 * If "dependenciesKind" is present, "dependencies" must be present and must have the same number of list elements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Dependencies Kind</em>' attribute.
	 * @see #setDependenciesKind(List)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getUnknownType1_DependenciesKind()
	 * @model dataType="org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindType1" many="false"
	 *        extendedMetaData="kind='attribute' name='dependenciesKind' namespace='##targetNamespace'"
	 * @generated
	 */
	List<DependenciesKindTypeItem1> getDependenciesKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1#getDependenciesKind <em>Dependencies Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependencies Kind</em>' attribute.
	 * @see #getDependenciesKind()
	 * @generated
	 */
	void setDependenciesKind(List<DependenciesKindTypeItem1> value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ScalarVariable index of Unknown
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #isSetIndex()
	 * @see #unsetIndex()
	 * @see #setIndex(long)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getUnknownType1_Index()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedInt" required="true"
	 *        extendedMetaData="kind='attribute' name='index' namespace='##targetNamespace'"
	 * @generated
	 */
	long getIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #isSetIndex()
	 * @see #unsetIndex()
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(long value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIndex()
	 * @see #getIndex()
	 * @see #setIndex(long)
	 * @generated
	 */
	void unsetIndex();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1#getIndex <em>Index</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Index</em>' attribute is set.
	 * @see #unsetIndex()
	 * @see #getIndex()
	 * @see #setIndex(long)
	 * @generated
	 */
	boolean isSetIndex();

} // UnknownType1
