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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType1;
import org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage;
import org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1;
import org.eclipse.papyrus.moka.fmi.modeldescription.RealType1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fmi2 Simple Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2SimpleTypeImpl#getReal <em>Real</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2SimpleTypeImpl#getInteger <em>Integer</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2SimpleTypeImpl#getBoolean <em>Boolean</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2SimpleTypeImpl#getString <em>String</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2SimpleTypeImpl#getEnumeration <em>Enumeration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2SimpleTypeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2SimpleTypeImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Fmi2SimpleTypeImpl extends MinimalEObjectImpl.Container implements Fmi2SimpleType {
	/**
	 * The cached value of the '{@link #getReal() <em>Real</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReal()
	 * @generated
	 * @ordered
	 */
	protected RealType1 real;

	/**
	 * The cached value of the '{@link #getInteger() <em>Integer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteger()
	 * @generated
	 * @ordered
	 */
	protected IntegerType1 integer;

	/**
	 * The cached value of the '{@link #getBoolean() <em>Boolean</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoolean()
	 * @generated
	 * @ordered
	 */
	protected EObject boolean_;

	/**
	 * The cached value of the '{@link #getString() <em>String</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getString()
	 * @generated
	 * @ordered
	 */
	protected EObject string;

	/**
	 * The cached value of the '{@link #getEnumeration() <em>Enumeration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumeration()
	 * @generated
	 * @ordered
	 */
	protected EnumerationType1 enumeration;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

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
	protected Fmi2SimpleTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FmiPackage.Literals.FMI2_SIMPLE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RealType1 getReal() {
		return real;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReal(RealType1 newReal, NotificationChain msgs) {
		RealType1 oldReal = real;
		real = newReal;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SIMPLE_TYPE__REAL, oldReal, newReal);
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
	public void setReal(RealType1 newReal) {
		if (newReal != real) {
			NotificationChain msgs = null;
			if (real != null)
				msgs = ((InternalEObject)real).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SIMPLE_TYPE__REAL, null, msgs);
			if (newReal != null)
				msgs = ((InternalEObject)newReal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SIMPLE_TYPE__REAL, null, msgs);
			msgs = basicSetReal(newReal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SIMPLE_TYPE__REAL, newReal, newReal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntegerType1 getInteger() {
		return integer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInteger(IntegerType1 newInteger, NotificationChain msgs) {
		IntegerType1 oldInteger = integer;
		integer = newInteger;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SIMPLE_TYPE__INTEGER, oldInteger, newInteger);
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
	public void setInteger(IntegerType1 newInteger) {
		if (newInteger != integer) {
			NotificationChain msgs = null;
			if (integer != null)
				msgs = ((InternalEObject)integer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SIMPLE_TYPE__INTEGER, null, msgs);
			if (newInteger != null)
				msgs = ((InternalEObject)newInteger).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SIMPLE_TYPE__INTEGER, null, msgs);
			msgs = basicSetInteger(newInteger, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SIMPLE_TYPE__INTEGER, newInteger, newInteger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getBoolean() {
		return boolean_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBoolean(EObject newBoolean, NotificationChain msgs) {
		EObject oldBoolean = boolean_;
		boolean_ = newBoolean;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SIMPLE_TYPE__BOOLEAN, oldBoolean, newBoolean);
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
	public void setBoolean(EObject newBoolean) {
		if (newBoolean != boolean_) {
			NotificationChain msgs = null;
			if (boolean_ != null)
				msgs = ((InternalEObject)boolean_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SIMPLE_TYPE__BOOLEAN, null, msgs);
			if (newBoolean != null)
				msgs = ((InternalEObject)newBoolean).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SIMPLE_TYPE__BOOLEAN, null, msgs);
			msgs = basicSetBoolean(newBoolean, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SIMPLE_TYPE__BOOLEAN, newBoolean, newBoolean));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getString() {
		return string;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetString(EObject newString, NotificationChain msgs) {
		EObject oldString = string;
		string = newString;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SIMPLE_TYPE__STRING, oldString, newString);
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
	public void setString(EObject newString) {
		if (newString != string) {
			NotificationChain msgs = null;
			if (string != null)
				msgs = ((InternalEObject)string).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SIMPLE_TYPE__STRING, null, msgs);
			if (newString != null)
				msgs = ((InternalEObject)newString).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SIMPLE_TYPE__STRING, null, msgs);
			msgs = basicSetString(newString, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SIMPLE_TYPE__STRING, newString, newString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumerationType1 getEnumeration() {
		return enumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnumeration(EnumerationType1 newEnumeration, NotificationChain msgs) {
		EnumerationType1 oldEnumeration = enumeration;
		enumeration = newEnumeration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SIMPLE_TYPE__ENUMERATION, oldEnumeration, newEnumeration);
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
	public void setEnumeration(EnumerationType1 newEnumeration) {
		if (newEnumeration != enumeration) {
			NotificationChain msgs = null;
			if (enumeration != null)
				msgs = ((InternalEObject)enumeration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SIMPLE_TYPE__ENUMERATION, null, msgs);
			if (newEnumeration != null)
				msgs = ((InternalEObject)newEnumeration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SIMPLE_TYPE__ENUMERATION, null, msgs);
			msgs = basicSetEnumeration(newEnumeration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SIMPLE_TYPE__ENUMERATION, newEnumeration, newEnumeration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SIMPLE_TYPE__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SIMPLE_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FmiPackage.FMI2_SIMPLE_TYPE__REAL:
				return basicSetReal(null, msgs);
			case FmiPackage.FMI2_SIMPLE_TYPE__INTEGER:
				return basicSetInteger(null, msgs);
			case FmiPackage.FMI2_SIMPLE_TYPE__BOOLEAN:
				return basicSetBoolean(null, msgs);
			case FmiPackage.FMI2_SIMPLE_TYPE__STRING:
				return basicSetString(null, msgs);
			case FmiPackage.FMI2_SIMPLE_TYPE__ENUMERATION:
				return basicSetEnumeration(null, msgs);
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
			case FmiPackage.FMI2_SIMPLE_TYPE__REAL:
				return getReal();
			case FmiPackage.FMI2_SIMPLE_TYPE__INTEGER:
				return getInteger();
			case FmiPackage.FMI2_SIMPLE_TYPE__BOOLEAN:
				return getBoolean();
			case FmiPackage.FMI2_SIMPLE_TYPE__STRING:
				return getString();
			case FmiPackage.FMI2_SIMPLE_TYPE__ENUMERATION:
				return getEnumeration();
			case FmiPackage.FMI2_SIMPLE_TYPE__DESCRIPTION:
				return getDescription();
			case FmiPackage.FMI2_SIMPLE_TYPE__NAME:
				return getName();
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
			case FmiPackage.FMI2_SIMPLE_TYPE__REAL:
				setReal((RealType1)newValue);
				return;
			case FmiPackage.FMI2_SIMPLE_TYPE__INTEGER:
				setInteger((IntegerType1)newValue);
				return;
			case FmiPackage.FMI2_SIMPLE_TYPE__BOOLEAN:
				setBoolean((EObject)newValue);
				return;
			case FmiPackage.FMI2_SIMPLE_TYPE__STRING:
				setString((EObject)newValue);
				return;
			case FmiPackage.FMI2_SIMPLE_TYPE__ENUMERATION:
				setEnumeration((EnumerationType1)newValue);
				return;
			case FmiPackage.FMI2_SIMPLE_TYPE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case FmiPackage.FMI2_SIMPLE_TYPE__NAME:
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
			case FmiPackage.FMI2_SIMPLE_TYPE__REAL:
				setReal((RealType1)null);
				return;
			case FmiPackage.FMI2_SIMPLE_TYPE__INTEGER:
				setInteger((IntegerType1)null);
				return;
			case FmiPackage.FMI2_SIMPLE_TYPE__BOOLEAN:
				setBoolean((EObject)null);
				return;
			case FmiPackage.FMI2_SIMPLE_TYPE__STRING:
				setString((EObject)null);
				return;
			case FmiPackage.FMI2_SIMPLE_TYPE__ENUMERATION:
				setEnumeration((EnumerationType1)null);
				return;
			case FmiPackage.FMI2_SIMPLE_TYPE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case FmiPackage.FMI2_SIMPLE_TYPE__NAME:
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
			case FmiPackage.FMI2_SIMPLE_TYPE__REAL:
				return real != null;
			case FmiPackage.FMI2_SIMPLE_TYPE__INTEGER:
				return integer != null;
			case FmiPackage.FMI2_SIMPLE_TYPE__BOOLEAN:
				return boolean_ != null;
			case FmiPackage.FMI2_SIMPLE_TYPE__STRING:
				return string != null;
			case FmiPackage.FMI2_SIMPLE_TYPE__ENUMERATION:
				return enumeration != null;
			case FmiPackage.FMI2_SIMPLE_TYPE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case FmiPackage.FMI2_SIMPLE_TYPE__NAME:
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
		result.append(" (description: ");
		result.append(description);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //Fmi2SimpleTypeImpl
