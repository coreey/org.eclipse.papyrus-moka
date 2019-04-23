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
package org.eclipse.papyrus.moka.fmi.modeldescription.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem1;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage;
import org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unknown Type1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.UnknownType1Impl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.UnknownType1Impl#getDependenciesKind <em>Dependencies Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.UnknownType1Impl#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnknownType1Impl extends MinimalEObjectImpl.Container implements UnknownType1 {
	/**
	 * The default value of the '{@link #getDependencies() <em>Dependencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected static final List<Long> DEPENDENCIES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected List<Long> dependencies = DEPENDENCIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getDependenciesKind() <em>Dependencies Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependenciesKind()
	 * @generated
	 * @ordered
	 */
	protected static final List<DependenciesKindTypeItem1> DEPENDENCIES_KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDependenciesKind() <em>Dependencies Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependenciesKind()
	 * @generated
	 * @ordered
	 */
	protected List<DependenciesKindTypeItem1> dependenciesKind = DEPENDENCIES_KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final long INDEX_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected long index = INDEX_EDEFAULT;

	/**
	 * This is true if the Index attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean indexESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnknownType1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FmiPackage.Literals.UNKNOWN_TYPE1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Long> getDependencies() {
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDependencies(List<Long> newDependencies) {
		List<Long> oldDependencies = dependencies;
		dependencies = newDependencies;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.UNKNOWN_TYPE1__DEPENDENCIES, oldDependencies, dependencies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<DependenciesKindTypeItem1> getDependenciesKind() {
		return dependenciesKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDependenciesKind(List<DependenciesKindTypeItem1> newDependenciesKind) {
		List<DependenciesKindTypeItem1> oldDependenciesKind = dependenciesKind;
		dependenciesKind = newDependenciesKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.UNKNOWN_TYPE1__DEPENDENCIES_KIND, oldDependenciesKind, dependenciesKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIndex(long newIndex) {
		long oldIndex = index;
		index = newIndex;
		boolean oldIndexESet = indexESet;
		indexESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.UNKNOWN_TYPE1__INDEX, oldIndex, index, !oldIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIndex() {
		long oldIndex = index;
		boolean oldIndexESet = indexESet;
		index = INDEX_EDEFAULT;
		indexESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.UNKNOWN_TYPE1__INDEX, oldIndex, INDEX_EDEFAULT, oldIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIndex() {
		return indexESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FmiPackage.UNKNOWN_TYPE1__DEPENDENCIES:
				return getDependencies();
			case FmiPackage.UNKNOWN_TYPE1__DEPENDENCIES_KIND:
				return getDependenciesKind();
			case FmiPackage.UNKNOWN_TYPE1__INDEX:
				return getIndex();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FmiPackage.UNKNOWN_TYPE1__DEPENDENCIES:
				setDependencies((List<Long>)newValue);
				return;
			case FmiPackage.UNKNOWN_TYPE1__DEPENDENCIES_KIND:
				setDependenciesKind((List<DependenciesKindTypeItem1>)newValue);
				return;
			case FmiPackage.UNKNOWN_TYPE1__INDEX:
				setIndex((Long)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FmiPackage.UNKNOWN_TYPE1__DEPENDENCIES:
				setDependencies(DEPENDENCIES_EDEFAULT);
				return;
			case FmiPackage.UNKNOWN_TYPE1__DEPENDENCIES_KIND:
				setDependenciesKind(DEPENDENCIES_KIND_EDEFAULT);
				return;
			case FmiPackage.UNKNOWN_TYPE1__INDEX:
				unsetIndex();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FmiPackage.UNKNOWN_TYPE1__DEPENDENCIES:
				return DEPENDENCIES_EDEFAULT == null ? dependencies != null : !DEPENDENCIES_EDEFAULT.equals(dependencies);
			case FmiPackage.UNKNOWN_TYPE1__DEPENDENCIES_KIND:
				return DEPENDENCIES_KIND_EDEFAULT == null ? dependenciesKind != null : !DEPENDENCIES_KIND_EDEFAULT.equals(dependenciesKind);
			case FmiPackage.UNKNOWN_TYPE1__INDEX:
				return isSetIndex();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (dependencies: ");
		result.append(dependencies);
		result.append(", dependenciesKind: ");
		result.append(dependenciesKind);
		result.append(", index: ");
		if (indexESet) result.append(index); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //UnknownType1Impl
