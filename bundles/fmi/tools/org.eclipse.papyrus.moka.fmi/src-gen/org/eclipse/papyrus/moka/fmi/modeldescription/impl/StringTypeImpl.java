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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage;
import org.eclipse.papyrus.moka.fmi.modeldescription.StringType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.StringTypeImpl#getDeclaredType <em>Declared Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.StringTypeImpl#getStart <em>Start</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StringTypeImpl extends MinimalEObjectImpl.Container implements StringType {
	/**
	 * The default value of the '{@link #getDeclaredType() <em>Declared Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredType()
	 * @generated
	 * @ordered
	 */
	protected static final String DECLARED_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDeclaredType() <em>Declared Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredType()
	 * @generated
	 * @ordered
	 */
	protected String declaredType = DECLARED_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected static final String START_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected String start = START_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FmiPackage.Literals.STRING_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDeclaredType() {
		return declaredType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeclaredType(String newDeclaredType) {
		String oldDeclaredType = declaredType;
		declaredType = newDeclaredType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.STRING_TYPE__DECLARED_TYPE, oldDeclaredType, declaredType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStart(String newStart) {
		String oldStart = start;
		start = newStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.STRING_TYPE__START, oldStart, start));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FmiPackage.STRING_TYPE__DECLARED_TYPE:
				return getDeclaredType();
			case FmiPackage.STRING_TYPE__START:
				return getStart();
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
			case FmiPackage.STRING_TYPE__DECLARED_TYPE:
				setDeclaredType((String)newValue);
				return;
			case FmiPackage.STRING_TYPE__START:
				setStart((String)newValue);
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
			case FmiPackage.STRING_TYPE__DECLARED_TYPE:
				setDeclaredType(DECLARED_TYPE_EDEFAULT);
				return;
			case FmiPackage.STRING_TYPE__START:
				setStart(START_EDEFAULT);
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
			case FmiPackage.STRING_TYPE__DECLARED_TYPE:
				return DECLARED_TYPE_EDEFAULT == null ? declaredType != null : !DECLARED_TYPE_EDEFAULT.equals(declaredType);
			case FmiPackage.STRING_TYPE__START:
				return START_EDEFAULT == null ? start != null : !START_EDEFAULT.equals(start);
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
		result.append(" (declaredType: ");
		result.append(declaredType);
		result.append(", start: ");
		result.append(start);
		result.append(')');
		return result.toString();
	}

} //StringTypeImpl
