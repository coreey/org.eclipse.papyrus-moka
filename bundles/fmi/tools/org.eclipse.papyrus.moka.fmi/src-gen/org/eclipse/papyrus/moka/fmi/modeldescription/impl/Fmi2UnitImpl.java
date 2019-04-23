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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType;
import org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType;
import org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fmi2 Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2UnitImpl#getBaseUnit <em>Base Unit</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2UnitImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2UnitImpl#getDisplayUnit <em>Display Unit</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2UnitImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Fmi2UnitImpl extends MinimalEObjectImpl.Container implements Fmi2Unit {
	/**
	 * The cached value of the '{@link #getBaseUnit() <em>Base Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseUnit()
	 * @generated
	 * @ordered
	 */
	protected BaseUnitType baseUnit;

	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Fmi2UnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FmiPackage.Literals.FMI2_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BaseUnitType getBaseUnit() {
		return baseUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBaseUnit(BaseUnitType newBaseUnit, NotificationChain msgs) {
		BaseUnitType oldBaseUnit = baseUnit;
		baseUnit = newBaseUnit;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_UNIT__BASE_UNIT, oldBaseUnit, newBaseUnit);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBaseUnit(BaseUnitType newBaseUnit) {
		if (newBaseUnit != baseUnit) {
			NotificationChain msgs = null;
			if (baseUnit != null)
				msgs = ((InternalEObject)baseUnit).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_UNIT__BASE_UNIT, null, msgs);
			if (newBaseUnit != null)
				msgs = ((InternalEObject)newBaseUnit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_UNIT__BASE_UNIT, null, msgs);
			msgs = basicSetBaseUnit(newBaseUnit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_UNIT__BASE_UNIT, newBaseUnit, newBaseUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, FmiPackage.FMI2_UNIT__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DisplayUnitType> getDisplayUnit() {
		return getGroup().list(FmiPackage.Literals.FMI2_UNIT__DISPLAY_UNIT);
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_UNIT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FmiPackage.FMI2_UNIT__BASE_UNIT:
				return basicSetBaseUnit(null, msgs);
			case FmiPackage.FMI2_UNIT__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case FmiPackage.FMI2_UNIT__DISPLAY_UNIT:
				return ((InternalEList<?>)getDisplayUnit()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FmiPackage.FMI2_UNIT__BASE_UNIT:
				return getBaseUnit();
			case FmiPackage.FMI2_UNIT__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case FmiPackage.FMI2_UNIT__DISPLAY_UNIT:
				return getDisplayUnit();
			case FmiPackage.FMI2_UNIT__NAME:
				return getName();
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
			case FmiPackage.FMI2_UNIT__BASE_UNIT:
				setBaseUnit((BaseUnitType)newValue);
				return;
			case FmiPackage.FMI2_UNIT__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case FmiPackage.FMI2_UNIT__DISPLAY_UNIT:
				getDisplayUnit().clear();
				getDisplayUnit().addAll((Collection<? extends DisplayUnitType>)newValue);
				return;
			case FmiPackage.FMI2_UNIT__NAME:
				setName((String)newValue);
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
			case FmiPackage.FMI2_UNIT__BASE_UNIT:
				setBaseUnit((BaseUnitType)null);
				return;
			case FmiPackage.FMI2_UNIT__GROUP:
				getGroup().clear();
				return;
			case FmiPackage.FMI2_UNIT__DISPLAY_UNIT:
				getDisplayUnit().clear();
				return;
			case FmiPackage.FMI2_UNIT__NAME:
				setName(NAME_EDEFAULT);
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
			case FmiPackage.FMI2_UNIT__BASE_UNIT:
				return baseUnit != null;
			case FmiPackage.FMI2_UNIT__GROUP:
				return group != null && !group.isEmpty();
			case FmiPackage.FMI2_UNIT__DISPLAY_UNIT:
				return !getDisplayUnit().isEmpty();
			case FmiPackage.FMI2_UNIT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (group: ");
		result.append(group);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //Fmi2UnitImpl
