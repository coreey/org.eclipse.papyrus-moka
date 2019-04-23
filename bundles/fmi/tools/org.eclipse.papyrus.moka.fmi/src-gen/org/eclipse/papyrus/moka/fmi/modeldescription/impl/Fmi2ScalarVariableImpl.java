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
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.moka.fmi.modeldescription.BooleanType;
import org.eclipse.papyrus.moka.fmi.modeldescription.CausalityType;
import org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType;
import org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Annotation;
import org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage;
import org.eclipse.papyrus.moka.fmi.modeldescription.InitialType;
import org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType;
import org.eclipse.papyrus.moka.fmi.modeldescription.RealType;
import org.eclipse.papyrus.moka.fmi.modeldescription.StringType;
import org.eclipse.papyrus.moka.fmi.modeldescription.VariabilityType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fmi2 Scalar Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2ScalarVariableImpl#getReal <em>Real</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2ScalarVariableImpl#getInteger <em>Integer</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2ScalarVariableImpl#getBoolean <em>Boolean</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2ScalarVariableImpl#getString <em>String</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2ScalarVariableImpl#getEnumeration <em>Enumeration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2ScalarVariableImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2ScalarVariableImpl#isCanHandleMultipleSetPerTimeInstant <em>Can Handle Multiple Set Per Time Instant</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2ScalarVariableImpl#getCausality <em>Causality</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2ScalarVariableImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2ScalarVariableImpl#getInitial <em>Initial</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2ScalarVariableImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2ScalarVariableImpl#getValueReference <em>Value Reference</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2ScalarVariableImpl#getVariability <em>Variability</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Fmi2ScalarVariableImpl extends MinimalEObjectImpl.Container implements Fmi2ScalarVariable {
	/**
	 * The cached value of the '{@link #getReal() <em>Real</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReal()
	 * @generated
	 * @ordered
	 */
	protected RealType real;

	/**
	 * The cached value of the '{@link #getInteger() <em>Integer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteger()
	 * @generated
	 * @ordered
	 */
	protected IntegerType integer;

	/**
	 * The cached value of the '{@link #getBoolean() <em>Boolean</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoolean()
	 * @generated
	 * @ordered
	 */
	protected BooleanType boolean_;

	/**
	 * The cached value of the '{@link #getString() <em>String</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getString()
	 * @generated
	 * @ordered
	 */
	protected StringType string;

	/**
	 * The cached value of the '{@link #getEnumeration() <em>Enumeration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumeration()
	 * @generated
	 * @ordered
	 */
	protected EnumerationType enumeration;

	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected Fmi2Annotation annotations;

	/**
	 * The default value of the '{@link #isCanHandleMultipleSetPerTimeInstant() <em>Can Handle Multiple Set Per Time Instant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanHandleMultipleSetPerTimeInstant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CAN_HANDLE_MULTIPLE_SET_PER_TIME_INSTANT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCanHandleMultipleSetPerTimeInstant() <em>Can Handle Multiple Set Per Time Instant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanHandleMultipleSetPerTimeInstant()
	 * @generated
	 * @ordered
	 */
	protected boolean canHandleMultipleSetPerTimeInstant = CAN_HANDLE_MULTIPLE_SET_PER_TIME_INSTANT_EDEFAULT;

	/**
	 * This is true if the Can Handle Multiple Set Per Time Instant attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean canHandleMultipleSetPerTimeInstantESet;

	/**
	 * The default value of the '{@link #getCausality() <em>Causality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCausality()
	 * @generated
	 * @ordered
	 */
	protected static final CausalityType CAUSALITY_EDEFAULT = CausalityType.LOCAL;

	/**
	 * The cached value of the '{@link #getCausality() <em>Causality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCausality()
	 * @generated
	 * @ordered
	 */
	protected CausalityType causality = CAUSALITY_EDEFAULT;

	/**
	 * This is true if the Causality attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean causalityESet;

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
	 * The default value of the '{@link #getInitial() <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitial()
	 * @generated
	 * @ordered
	 */
	protected static final InitialType INITIAL_EDEFAULT = InitialType.EXACT;

	/**
	 * The cached value of the '{@link #getInitial() <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitial()
	 * @generated
	 * @ordered
	 */
	protected InitialType initial = INITIAL_EDEFAULT;

	/**
	 * This is true if the Initial attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean initialESet;

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
	 * The default value of the '{@link #getValueReference() <em>Value Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueReference()
	 * @generated
	 * @ordered
	 */
	protected static final long VALUE_REFERENCE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getValueReference() <em>Value Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueReference()
	 * @generated
	 * @ordered
	 */
	protected long valueReference = VALUE_REFERENCE_EDEFAULT;

	/**
	 * This is true if the Value Reference attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean valueReferenceESet;

	/**
	 * The default value of the '{@link #getVariability() <em>Variability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariability()
	 * @generated
	 * @ordered
	 */
	protected static final VariabilityType VARIABILITY_EDEFAULT = VariabilityType.CONTINUOUS;

	/**
	 * The cached value of the '{@link #getVariability() <em>Variability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariability()
	 * @generated
	 * @ordered
	 */
	protected VariabilityType variability = VARIABILITY_EDEFAULT;

	/**
	 * This is true if the Variability attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean variabilityESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Fmi2ScalarVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FmiPackage.Literals.FMI2_SCALAR_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RealType getReal() {
		return real;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReal(RealType newReal, NotificationChain msgs) {
		RealType oldReal = real;
		real = newReal;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__REAL, oldReal, newReal);
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
	public void setReal(RealType newReal) {
		if (newReal != real) {
			NotificationChain msgs = null;
			if (real != null)
				msgs = ((InternalEObject)real).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SCALAR_VARIABLE__REAL, null, msgs);
			if (newReal != null)
				msgs = ((InternalEObject)newReal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SCALAR_VARIABLE__REAL, null, msgs);
			msgs = basicSetReal(newReal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__REAL, newReal, newReal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntegerType getInteger() {
		return integer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInteger(IntegerType newInteger, NotificationChain msgs) {
		IntegerType oldInteger = integer;
		integer = newInteger;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__INTEGER, oldInteger, newInteger);
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
	public void setInteger(IntegerType newInteger) {
		if (newInteger != integer) {
			NotificationChain msgs = null;
			if (integer != null)
				msgs = ((InternalEObject)integer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SCALAR_VARIABLE__INTEGER, null, msgs);
			if (newInteger != null)
				msgs = ((InternalEObject)newInteger).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SCALAR_VARIABLE__INTEGER, null, msgs);
			msgs = basicSetInteger(newInteger, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__INTEGER, newInteger, newInteger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BooleanType getBoolean() {
		return boolean_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBoolean(BooleanType newBoolean, NotificationChain msgs) {
		BooleanType oldBoolean = boolean_;
		boolean_ = newBoolean;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__BOOLEAN, oldBoolean, newBoolean);
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
	public void setBoolean(BooleanType newBoolean) {
		if (newBoolean != boolean_) {
			NotificationChain msgs = null;
			if (boolean_ != null)
				msgs = ((InternalEObject)boolean_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SCALAR_VARIABLE__BOOLEAN, null, msgs);
			if (newBoolean != null)
				msgs = ((InternalEObject)newBoolean).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SCALAR_VARIABLE__BOOLEAN, null, msgs);
			msgs = basicSetBoolean(newBoolean, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__BOOLEAN, newBoolean, newBoolean));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StringType getString() {
		return string;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetString(StringType newString, NotificationChain msgs) {
		StringType oldString = string;
		string = newString;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__STRING, oldString, newString);
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
	public void setString(StringType newString) {
		if (newString != string) {
			NotificationChain msgs = null;
			if (string != null)
				msgs = ((InternalEObject)string).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SCALAR_VARIABLE__STRING, null, msgs);
			if (newString != null)
				msgs = ((InternalEObject)newString).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SCALAR_VARIABLE__STRING, null, msgs);
			msgs = basicSetString(newString, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__STRING, newString, newString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumerationType getEnumeration() {
		return enumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnumeration(EnumerationType newEnumeration, NotificationChain msgs) {
		EnumerationType oldEnumeration = enumeration;
		enumeration = newEnumeration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__ENUMERATION, oldEnumeration, newEnumeration);
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
	public void setEnumeration(EnumerationType newEnumeration) {
		if (newEnumeration != enumeration) {
			NotificationChain msgs = null;
			if (enumeration != null)
				msgs = ((InternalEObject)enumeration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SCALAR_VARIABLE__ENUMERATION, null, msgs);
			if (newEnumeration != null)
				msgs = ((InternalEObject)newEnumeration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SCALAR_VARIABLE__ENUMERATION, null, msgs);
			msgs = basicSetEnumeration(newEnumeration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__ENUMERATION, newEnumeration, newEnumeration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Fmi2Annotation getAnnotations() {
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnnotations(Fmi2Annotation newAnnotations, NotificationChain msgs) {
		Fmi2Annotation oldAnnotations = annotations;
		annotations = newAnnotations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__ANNOTATIONS, oldAnnotations, newAnnotations);
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
	public void setAnnotations(Fmi2Annotation newAnnotations) {
		if (newAnnotations != annotations) {
			NotificationChain msgs = null;
			if (annotations != null)
				msgs = ((InternalEObject)annotations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SCALAR_VARIABLE__ANNOTATIONS, null, msgs);
			if (newAnnotations != null)
				msgs = ((InternalEObject)newAnnotations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI2_SCALAR_VARIABLE__ANNOTATIONS, null, msgs);
			msgs = basicSetAnnotations(newAnnotations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__ANNOTATIONS, newAnnotations, newAnnotations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCanHandleMultipleSetPerTimeInstant() {
		return canHandleMultipleSetPerTimeInstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCanHandleMultipleSetPerTimeInstant(boolean newCanHandleMultipleSetPerTimeInstant) {
		boolean oldCanHandleMultipleSetPerTimeInstant = canHandleMultipleSetPerTimeInstant;
		canHandleMultipleSetPerTimeInstant = newCanHandleMultipleSetPerTimeInstant;
		boolean oldCanHandleMultipleSetPerTimeInstantESet = canHandleMultipleSetPerTimeInstantESet;
		canHandleMultipleSetPerTimeInstantESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__CAN_HANDLE_MULTIPLE_SET_PER_TIME_INSTANT, oldCanHandleMultipleSetPerTimeInstant, canHandleMultipleSetPerTimeInstant, !oldCanHandleMultipleSetPerTimeInstantESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCanHandleMultipleSetPerTimeInstant() {
		boolean oldCanHandleMultipleSetPerTimeInstant = canHandleMultipleSetPerTimeInstant;
		boolean oldCanHandleMultipleSetPerTimeInstantESet = canHandleMultipleSetPerTimeInstantESet;
		canHandleMultipleSetPerTimeInstant = CAN_HANDLE_MULTIPLE_SET_PER_TIME_INSTANT_EDEFAULT;
		canHandleMultipleSetPerTimeInstantESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.FMI2_SCALAR_VARIABLE__CAN_HANDLE_MULTIPLE_SET_PER_TIME_INSTANT, oldCanHandleMultipleSetPerTimeInstant, CAN_HANDLE_MULTIPLE_SET_PER_TIME_INSTANT_EDEFAULT, oldCanHandleMultipleSetPerTimeInstantESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCanHandleMultipleSetPerTimeInstant() {
		return canHandleMultipleSetPerTimeInstantESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CausalityType getCausality() {
		return causality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCausality(CausalityType newCausality) {
		CausalityType oldCausality = causality;
		causality = newCausality == null ? CAUSALITY_EDEFAULT : newCausality;
		boolean oldCausalityESet = causalityESet;
		causalityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__CAUSALITY, oldCausality, causality, !oldCausalityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCausality() {
		CausalityType oldCausality = causality;
		boolean oldCausalityESet = causalityESet;
		causality = CAUSALITY_EDEFAULT;
		causalityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.FMI2_SCALAR_VARIABLE__CAUSALITY, oldCausality, CAUSALITY_EDEFAULT, oldCausalityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCausality() {
		return causalityESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InitialType getInitial() {
		return initial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitial(InitialType newInitial) {
		InitialType oldInitial = initial;
		initial = newInitial == null ? INITIAL_EDEFAULT : newInitial;
		boolean oldInitialESet = initialESet;
		initialESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__INITIAL, oldInitial, initial, !oldInitialESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInitial() {
		InitialType oldInitial = initial;
		boolean oldInitialESet = initialESet;
		initial = INITIAL_EDEFAULT;
		initialESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.FMI2_SCALAR_VARIABLE__INITIAL, oldInitial, INITIAL_EDEFAULT, oldInitialESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInitial() {
		return initialESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getValueReference() {
		return valueReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValueReference(long newValueReference) {
		long oldValueReference = valueReference;
		valueReference = newValueReference;
		boolean oldValueReferenceESet = valueReferenceESet;
		valueReferenceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__VALUE_REFERENCE, oldValueReference, valueReference, !oldValueReferenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetValueReference() {
		long oldValueReference = valueReference;
		boolean oldValueReferenceESet = valueReferenceESet;
		valueReference = VALUE_REFERENCE_EDEFAULT;
		valueReferenceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.FMI2_SCALAR_VARIABLE__VALUE_REFERENCE, oldValueReference, VALUE_REFERENCE_EDEFAULT, oldValueReferenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetValueReference() {
		return valueReferenceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariabilityType getVariability() {
		return variability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariability(VariabilityType newVariability) {
		VariabilityType oldVariability = variability;
		variability = newVariability == null ? VARIABILITY_EDEFAULT : newVariability;
		boolean oldVariabilityESet = variabilityESet;
		variabilityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI2_SCALAR_VARIABLE__VARIABILITY, oldVariability, variability, !oldVariabilityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetVariability() {
		VariabilityType oldVariability = variability;
		boolean oldVariabilityESet = variabilityESet;
		variability = VARIABILITY_EDEFAULT;
		variabilityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.FMI2_SCALAR_VARIABLE__VARIABILITY, oldVariability, VARIABILITY_EDEFAULT, oldVariabilityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetVariability() {
		return variabilityESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FmiPackage.FMI2_SCALAR_VARIABLE__REAL:
				return basicSetReal(null, msgs);
			case FmiPackage.FMI2_SCALAR_VARIABLE__INTEGER:
				return basicSetInteger(null, msgs);
			case FmiPackage.FMI2_SCALAR_VARIABLE__BOOLEAN:
				return basicSetBoolean(null, msgs);
			case FmiPackage.FMI2_SCALAR_VARIABLE__STRING:
				return basicSetString(null, msgs);
			case FmiPackage.FMI2_SCALAR_VARIABLE__ENUMERATION:
				return basicSetEnumeration(null, msgs);
			case FmiPackage.FMI2_SCALAR_VARIABLE__ANNOTATIONS:
				return basicSetAnnotations(null, msgs);
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
			case FmiPackage.FMI2_SCALAR_VARIABLE__REAL:
				return getReal();
			case FmiPackage.FMI2_SCALAR_VARIABLE__INTEGER:
				return getInteger();
			case FmiPackage.FMI2_SCALAR_VARIABLE__BOOLEAN:
				return getBoolean();
			case FmiPackage.FMI2_SCALAR_VARIABLE__STRING:
				return getString();
			case FmiPackage.FMI2_SCALAR_VARIABLE__ENUMERATION:
				return getEnumeration();
			case FmiPackage.FMI2_SCALAR_VARIABLE__ANNOTATIONS:
				return getAnnotations();
			case FmiPackage.FMI2_SCALAR_VARIABLE__CAN_HANDLE_MULTIPLE_SET_PER_TIME_INSTANT:
				return isCanHandleMultipleSetPerTimeInstant();
			case FmiPackage.FMI2_SCALAR_VARIABLE__CAUSALITY:
				return getCausality();
			case FmiPackage.FMI2_SCALAR_VARIABLE__DESCRIPTION:
				return getDescription();
			case FmiPackage.FMI2_SCALAR_VARIABLE__INITIAL:
				return getInitial();
			case FmiPackage.FMI2_SCALAR_VARIABLE__NAME:
				return getName();
			case FmiPackage.FMI2_SCALAR_VARIABLE__VALUE_REFERENCE:
				return getValueReference();
			case FmiPackage.FMI2_SCALAR_VARIABLE__VARIABILITY:
				return getVariability();
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
			case FmiPackage.FMI2_SCALAR_VARIABLE__REAL:
				setReal((RealType)newValue);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__INTEGER:
				setInteger((IntegerType)newValue);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__BOOLEAN:
				setBoolean((BooleanType)newValue);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__STRING:
				setString((StringType)newValue);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__ENUMERATION:
				setEnumeration((EnumerationType)newValue);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__ANNOTATIONS:
				setAnnotations((Fmi2Annotation)newValue);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__CAN_HANDLE_MULTIPLE_SET_PER_TIME_INSTANT:
				setCanHandleMultipleSetPerTimeInstant((Boolean)newValue);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__CAUSALITY:
				setCausality((CausalityType)newValue);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__INITIAL:
				setInitial((InitialType)newValue);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__NAME:
				setName((String)newValue);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__VALUE_REFERENCE:
				setValueReference((Long)newValue);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__VARIABILITY:
				setVariability((VariabilityType)newValue);
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
			case FmiPackage.FMI2_SCALAR_VARIABLE__REAL:
				setReal((RealType)null);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__INTEGER:
				setInteger((IntegerType)null);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__BOOLEAN:
				setBoolean((BooleanType)null);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__STRING:
				setString((StringType)null);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__ENUMERATION:
				setEnumeration((EnumerationType)null);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__ANNOTATIONS:
				setAnnotations((Fmi2Annotation)null);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__CAN_HANDLE_MULTIPLE_SET_PER_TIME_INSTANT:
				unsetCanHandleMultipleSetPerTimeInstant();
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__CAUSALITY:
				unsetCausality();
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__INITIAL:
				unsetInitial();
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__VALUE_REFERENCE:
				unsetValueReference();
				return;
			case FmiPackage.FMI2_SCALAR_VARIABLE__VARIABILITY:
				unsetVariability();
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
			case FmiPackage.FMI2_SCALAR_VARIABLE__REAL:
				return real != null;
			case FmiPackage.FMI2_SCALAR_VARIABLE__INTEGER:
				return integer != null;
			case FmiPackage.FMI2_SCALAR_VARIABLE__BOOLEAN:
				return boolean_ != null;
			case FmiPackage.FMI2_SCALAR_VARIABLE__STRING:
				return string != null;
			case FmiPackage.FMI2_SCALAR_VARIABLE__ENUMERATION:
				return enumeration != null;
			case FmiPackage.FMI2_SCALAR_VARIABLE__ANNOTATIONS:
				return annotations != null;
			case FmiPackage.FMI2_SCALAR_VARIABLE__CAN_HANDLE_MULTIPLE_SET_PER_TIME_INSTANT:
				return isSetCanHandleMultipleSetPerTimeInstant();
			case FmiPackage.FMI2_SCALAR_VARIABLE__CAUSALITY:
				return isSetCausality();
			case FmiPackage.FMI2_SCALAR_VARIABLE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case FmiPackage.FMI2_SCALAR_VARIABLE__INITIAL:
				return isSetInitial();
			case FmiPackage.FMI2_SCALAR_VARIABLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FmiPackage.FMI2_SCALAR_VARIABLE__VALUE_REFERENCE:
				return isSetValueReference();
			case FmiPackage.FMI2_SCALAR_VARIABLE__VARIABILITY:
				return isSetVariability();
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
		result.append(" (canHandleMultipleSetPerTimeInstant: ");
		if (canHandleMultipleSetPerTimeInstantESet) result.append(canHandleMultipleSetPerTimeInstant); else result.append("<unset>");
		result.append(", causality: ");
		if (causalityESet) result.append(causality); else result.append("<unset>");
		result.append(", description: ");
		result.append(description);
		result.append(", initial: ");
		if (initialESet) result.append(initial); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(", valueReference: ");
		if (valueReferenceESet) result.append(valueReference); else result.append("<unset>");
		result.append(", variability: ");
		if (variabilityESet) result.append(variability); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //Fmi2ScalarVariableImpl
