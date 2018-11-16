/**
 * Copyright (c) 2016 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *   CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.fmi.fmiprofile.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage;
import org.eclipse.papyrus.moka.fmi.fmiprofile.Unknown;

import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unknown</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.UnknownImpl#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.UnknownImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.UnknownImpl#getDependenciesKind <em>Dependencies Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnknownImpl extends MinimalEObjectImpl.Container implements Unknown {
	/**
	 * The cached value of the '{@link #getBase_Property() <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Property()
	 * @generated
	 * @ordered
	 */
	protected Property base_Property;

	/**
	 * The default value of the '{@link #getDependencies() <em>Dependencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected static final String DEPENDENCIES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected String dependencies = DEPENDENCIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getDependenciesKind() <em>Dependencies Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependenciesKind()
	 * @generated
	 * @ordered
	 */
	protected static final String DEPENDENCIES_KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDependenciesKind() <em>Dependencies Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependenciesKind()
	 * @generated
	 * @ordered
	 */
	protected String dependenciesKind = DEPENDENCIES_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnknownImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FMIProfilePackage.Literals.UNKNOWN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getBase_Property() {
		if (base_Property != null && base_Property.eIsProxy()) {
			InternalEObject oldBase_Property = (InternalEObject)base_Property;
			base_Property = (Property)eResolveProxy(oldBase_Property);
			if (base_Property != oldBase_Property) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FMIProfilePackage.UNKNOWN__BASE_PROPERTY, oldBase_Property, base_Property));
			}
		}
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetBase_Property() {
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Property(Property newBase_Property) {
		Property oldBase_Property = base_Property;
		base_Property = newBase_Property;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.UNKNOWN__BASE_PROPERTY, oldBase_Property, base_Property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDependencies() {
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependencies(String newDependencies) {
		String oldDependencies = dependencies;
		dependencies = newDependencies;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.UNKNOWN__DEPENDENCIES, oldDependencies, dependencies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDependenciesKind() {
		return dependenciesKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependenciesKind(String newDependenciesKind) {
		String oldDependenciesKind = dependenciesKind;
		dependenciesKind = newDependenciesKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.UNKNOWN__DEPENDENCIES_KIND, oldDependenciesKind, dependenciesKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FMIProfilePackage.UNKNOWN__BASE_PROPERTY:
				if (resolve) return getBase_Property();
				return basicGetBase_Property();
			case FMIProfilePackage.UNKNOWN__DEPENDENCIES:
				return getDependencies();
			case FMIProfilePackage.UNKNOWN__DEPENDENCIES_KIND:
				return getDependenciesKind();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FMIProfilePackage.UNKNOWN__BASE_PROPERTY:
				setBase_Property((Property)newValue);
				return;
			case FMIProfilePackage.UNKNOWN__DEPENDENCIES:
				setDependencies((String)newValue);
				return;
			case FMIProfilePackage.UNKNOWN__DEPENDENCIES_KIND:
				setDependenciesKind((String)newValue);
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
			case FMIProfilePackage.UNKNOWN__BASE_PROPERTY:
				setBase_Property((Property)null);
				return;
			case FMIProfilePackage.UNKNOWN__DEPENDENCIES:
				setDependencies(DEPENDENCIES_EDEFAULT);
				return;
			case FMIProfilePackage.UNKNOWN__DEPENDENCIES_KIND:
				setDependenciesKind(DEPENDENCIES_KIND_EDEFAULT);
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
			case FMIProfilePackage.UNKNOWN__BASE_PROPERTY:
				return base_Property != null;
			case FMIProfilePackage.UNKNOWN__DEPENDENCIES:
				return DEPENDENCIES_EDEFAULT == null ? dependencies != null : !DEPENDENCIES_EDEFAULT.equals(dependencies);
			case FMIProfilePackage.UNKNOWN__DEPENDENCIES_KIND:
				return DEPENDENCIES_KIND_EDEFAULT == null ? dependenciesKind != null : !DEPENDENCIES_KIND_EDEFAULT.equals(dependenciesKind);
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
		result.append(')');
		return result.toString();
	}

} //UnknownImpl
