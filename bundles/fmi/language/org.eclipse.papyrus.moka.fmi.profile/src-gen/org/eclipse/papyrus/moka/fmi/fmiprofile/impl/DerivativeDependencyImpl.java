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

import org.eclipse.papyrus.moka.fmi.fmiprofile.DependenciesKind;
import org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeDependency;
import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage;

import org.eclipse.uml2.uml.Dependency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Derivative Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.DerivativeDependencyImpl#getBase_Dependency <em>Base Dependency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.DerivativeDependencyImpl#getDependencyKind <em>Dependency Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DerivativeDependencyImpl extends MinimalEObjectImpl.Container implements DerivativeDependency {
	/**
	 * The cached value of the '{@link #getBase_Dependency() <em>Base Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Dependency()
	 * @generated
	 * @ordered
	 */
	protected Dependency base_Dependency;

	/**
	 * The default value of the '{@link #getDependencyKind() <em>Dependency Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencyKind()
	 * @generated
	 * @ordered
	 */
	protected static final DependenciesKind DEPENDENCY_KIND_EDEFAULT = DependenciesKind.DEPENDENT;

	/**
	 * The cached value of the '{@link #getDependencyKind() <em>Dependency Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencyKind()
	 * @generated
	 * @ordered
	 */
	protected DependenciesKind dependencyKind = DEPENDENCY_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DerivativeDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FMIProfilePackage.Literals.DERIVATIVE_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency getBase_Dependency() {
		if (base_Dependency != null && base_Dependency.eIsProxy()) {
			InternalEObject oldBase_Dependency = (InternalEObject)base_Dependency;
			base_Dependency = (Dependency)eResolveProxy(oldBase_Dependency);
			if (base_Dependency != oldBase_Dependency) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FMIProfilePackage.DERIVATIVE_DEPENDENCY__BASE_DEPENDENCY, oldBase_Dependency, base_Dependency));
			}
		}
		return base_Dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency basicGetBase_Dependency() {
		return base_Dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Dependency(Dependency newBase_Dependency) {
		Dependency oldBase_Dependency = base_Dependency;
		base_Dependency = newBase_Dependency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.DERIVATIVE_DEPENDENCY__BASE_DEPENDENCY, oldBase_Dependency, base_Dependency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependenciesKind getDependencyKind() {
		return dependencyKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependencyKind(DependenciesKind newDependencyKind) {
		DependenciesKind oldDependencyKind = dependencyKind;
		dependencyKind = newDependencyKind == null ? DEPENDENCY_KIND_EDEFAULT : newDependencyKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.DERIVATIVE_DEPENDENCY__DEPENDENCY_KIND, oldDependencyKind, dependencyKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FMIProfilePackage.DERIVATIVE_DEPENDENCY__BASE_DEPENDENCY:
				if (resolve) return getBase_Dependency();
				return basicGetBase_Dependency();
			case FMIProfilePackage.DERIVATIVE_DEPENDENCY__DEPENDENCY_KIND:
				return getDependencyKind();
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
			case FMIProfilePackage.DERIVATIVE_DEPENDENCY__BASE_DEPENDENCY:
				setBase_Dependency((Dependency)newValue);
				return;
			case FMIProfilePackage.DERIVATIVE_DEPENDENCY__DEPENDENCY_KIND:
				setDependencyKind((DependenciesKind)newValue);
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
			case FMIProfilePackage.DERIVATIVE_DEPENDENCY__BASE_DEPENDENCY:
				setBase_Dependency((Dependency)null);
				return;
			case FMIProfilePackage.DERIVATIVE_DEPENDENCY__DEPENDENCY_KIND:
				setDependencyKind(DEPENDENCY_KIND_EDEFAULT);
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
			case FMIProfilePackage.DERIVATIVE_DEPENDENCY__BASE_DEPENDENCY:
				return base_Dependency != null;
			case FMIProfilePackage.DERIVATIVE_DEPENDENCY__DEPENDENCY_KIND:
				return dependencyKind != DEPENDENCY_KIND_EDEFAULT;
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
		result.append(" (dependencyKind: ");
		result.append(dependencyKind);
		result.append(')');
		return result.toString();
	}

} //DerivativeDependencyImpl
