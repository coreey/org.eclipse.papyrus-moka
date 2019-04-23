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

import org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Display Unit Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.DisplayUnitTypeImpl#getFactor <em>Factor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.DisplayUnitTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.DisplayUnitTypeImpl#getOffset <em>Offset</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DisplayUnitTypeImpl extends MinimalEObjectImpl.Container implements DisplayUnitType {
	/**
	 * The default value of the '{@link #getFactor() <em>Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactor()
	 * @generated
	 * @ordered
	 */
	protected static final double FACTOR_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getFactor() <em>Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactor()
	 * @generated
	 * @ordered
	 */
	protected double factor = FACTOR_EDEFAULT;

	/**
	 * This is true if the Factor attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean factorESet;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected static final double OFFSET_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected double offset = OFFSET_EDEFAULT;

	/**
	 * This is true if the Offset attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean offsetESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DisplayUnitTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FmiPackage.Literals.DISPLAY_UNIT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFactor() {
		return factor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFactor(double newFactor) {
		double oldFactor = factor;
		factor = newFactor;
		boolean oldFactorESet = factorESet;
		factorESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.DISPLAY_UNIT_TYPE__FACTOR, oldFactor, factor, !oldFactorESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFactor() {
		double oldFactor = factor;
		boolean oldFactorESet = factorESet;
		factor = FACTOR_EDEFAULT;
		factorESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.DISPLAY_UNIT_TYPE__FACTOR, oldFactor, FACTOR_EDEFAULT, oldFactorESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFactor() {
		return factorESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.DISPLAY_UNIT_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOffset() {
		return offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffset(double newOffset) {
		double oldOffset = offset;
		offset = newOffset;
		boolean oldOffsetESet = offsetESet;
		offsetESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.DISPLAY_UNIT_TYPE__OFFSET, oldOffset, offset, !oldOffsetESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOffset() {
		double oldOffset = offset;
		boolean oldOffsetESet = offsetESet;
		offset = OFFSET_EDEFAULT;
		offsetESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.DISPLAY_UNIT_TYPE__OFFSET, oldOffset, OFFSET_EDEFAULT, oldOffsetESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOffset() {
		return offsetESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FmiPackage.DISPLAY_UNIT_TYPE__FACTOR:
				return getFactor();
			case FmiPackage.DISPLAY_UNIT_TYPE__NAME:
				return getName();
			case FmiPackage.DISPLAY_UNIT_TYPE__OFFSET:
				return getOffset();
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
			case FmiPackage.DISPLAY_UNIT_TYPE__FACTOR:
				setFactor((Double)newValue);
				return;
			case FmiPackage.DISPLAY_UNIT_TYPE__NAME:
				setName((String)newValue);
				return;
			case FmiPackage.DISPLAY_UNIT_TYPE__OFFSET:
				setOffset((Double)newValue);
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
			case FmiPackage.DISPLAY_UNIT_TYPE__FACTOR:
				unsetFactor();
				return;
			case FmiPackage.DISPLAY_UNIT_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FmiPackage.DISPLAY_UNIT_TYPE__OFFSET:
				unsetOffset();
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
			case FmiPackage.DISPLAY_UNIT_TYPE__FACTOR:
				return isSetFactor();
			case FmiPackage.DISPLAY_UNIT_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FmiPackage.DISPLAY_UNIT_TYPE__OFFSET:
				return isSetOffset();
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
		result.append(" (factor: ");
		if (factorESet) result.append(factor); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(", offset: ");
		if (offsetESet) result.append(offset); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //DisplayUnitTypeImpl
