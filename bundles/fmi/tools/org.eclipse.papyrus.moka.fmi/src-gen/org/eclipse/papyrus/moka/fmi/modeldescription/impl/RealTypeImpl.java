/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.papyrus.moka.fmi.modeldescription.RealType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Real Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealTypeImpl#getDeclaredType <em>Declared Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealTypeImpl#getDerivative <em>Derivative</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealTypeImpl#getDisplayUnit <em>Display Unit</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealTypeImpl#getMax <em>Max</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealTypeImpl#getMin <em>Min</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealTypeImpl#getNominal <em>Nominal</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealTypeImpl#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealTypeImpl#isReinit <em>Reinit</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealTypeImpl#isRelativeQuantity <em>Relative Quantity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealTypeImpl#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealTypeImpl#isUnbounded <em>Unbounded</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealTypeImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RealTypeImpl extends MinimalEObjectImpl.Container implements RealType {
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
	 * The default value of the '{@link #getDerivative() <em>Derivative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivative()
	 * @generated
	 * @ordered
	 */
	protected static final long DERIVATIVE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getDerivative() <em>Derivative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivative()
	 * @generated
	 * @ordered
	 */
	protected long derivative = DERIVATIVE_EDEFAULT;

	/**
	 * This is true if the Derivative attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean derivativeESet;

	/**
	 * The default value of the '{@link #getDisplayUnit() <em>Display Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayUnit()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPLAY_UNIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisplayUnit() <em>Display Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayUnit()
	 * @generated
	 * @ordered
	 */
	protected String displayUnit = DISPLAY_UNIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMax() <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected static final double MAX_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMax() <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected double max = MAX_EDEFAULT;

	/**
	 * This is true if the Max attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maxESet;

	/**
	 * The default value of the '{@link #getMin() <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected static final double MIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMin() <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected double min = MIN_EDEFAULT;

	/**
	 * This is true if the Min attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean minESet;

	/**
	 * The default value of the '{@link #getNominal() <em>Nominal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNominal()
	 * @generated
	 * @ordered
	 */
	protected static final double NOMINAL_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getNominal() <em>Nominal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNominal()
	 * @generated
	 * @ordered
	 */
	protected double nominal = NOMINAL_EDEFAULT;

	/**
	 * This is true if the Nominal attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean nominalESet;

	/**
	 * The default value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantity()
	 * @generated
	 * @ordered
	 */
	protected static final String QUANTITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantity()
	 * @generated
	 * @ordered
	 */
	protected String quantity = QUANTITY_EDEFAULT;

	/**
	 * The default value of the '{@link #isReinit() <em>Reinit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReinit()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REINIT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReinit() <em>Reinit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReinit()
	 * @generated
	 * @ordered
	 */
	protected boolean reinit = REINIT_EDEFAULT;

	/**
	 * This is true if the Reinit attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean reinitESet;

	/**
	 * The default value of the '{@link #isRelativeQuantity() <em>Relative Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRelativeQuantity()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RELATIVE_QUANTITY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRelativeQuantity() <em>Relative Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRelativeQuantity()
	 * @generated
	 * @ordered
	 */
	protected boolean relativeQuantity = RELATIVE_QUANTITY_EDEFAULT;

	/**
	 * This is true if the Relative Quantity attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean relativeQuantityESet;

	/**
	 * The default value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected static final double START_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected double start = START_EDEFAULT;

	/**
	 * This is true if the Start attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean startESet;

	/**
	 * The default value of the '{@link #isUnbounded() <em>Unbounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnbounded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNBOUNDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUnbounded() <em>Unbounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnbounded()
	 * @generated
	 * @ordered
	 */
	protected boolean unbounded = UNBOUNDED_EDEFAULT;

	/**
	 * This is true if the Unbounded attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean unboundedESet;

	/**
	 * The default value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected static final String UNIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected String unit = UNIT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RealTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FmiPackage.Literals.REAL_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE__DECLARED_TYPE, oldDeclaredType, declaredType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getDerivative() {
		return derivative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDerivative(long newDerivative) {
		long oldDerivative = derivative;
		derivative = newDerivative;
		boolean oldDerivativeESet = derivativeESet;
		derivativeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE__DERIVATIVE, oldDerivative, derivative, !oldDerivativeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDerivative() {
		long oldDerivative = derivative;
		boolean oldDerivativeESet = derivativeESet;
		derivative = DERIVATIVE_EDEFAULT;
		derivativeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.REAL_TYPE__DERIVATIVE, oldDerivative, DERIVATIVE_EDEFAULT, oldDerivativeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDerivative() {
		return derivativeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDisplayUnit() {
		return displayUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDisplayUnit(String newDisplayUnit) {
		String oldDisplayUnit = displayUnit;
		displayUnit = newDisplayUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE__DISPLAY_UNIT, oldDisplayUnit, displayUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMax() {
		return max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMax(double newMax) {
		double oldMax = max;
		max = newMax;
		boolean oldMaxESet = maxESet;
		maxESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE__MAX, oldMax, max, !oldMaxESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMax() {
		double oldMax = max;
		boolean oldMaxESet = maxESet;
		max = MAX_EDEFAULT;
		maxESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.REAL_TYPE__MAX, oldMax, MAX_EDEFAULT, oldMaxESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMax() {
		return maxESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMin() {
		return min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMin(double newMin) {
		double oldMin = min;
		min = newMin;
		boolean oldMinESet = minESet;
		minESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE__MIN, oldMin, min, !oldMinESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMin() {
		double oldMin = min;
		boolean oldMinESet = minESet;
		min = MIN_EDEFAULT;
		minESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.REAL_TYPE__MIN, oldMin, MIN_EDEFAULT, oldMinESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMin() {
		return minESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getNominal() {
		return nominal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNominal(double newNominal) {
		double oldNominal = nominal;
		nominal = newNominal;
		boolean oldNominalESet = nominalESet;
		nominalESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE__NOMINAL, oldNominal, nominal, !oldNominalESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetNominal() {
		double oldNominal = nominal;
		boolean oldNominalESet = nominalESet;
		nominal = NOMINAL_EDEFAULT;
		nominalESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.REAL_TYPE__NOMINAL, oldNominal, NOMINAL_EDEFAULT, oldNominalESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetNominal() {
		return nominalESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getQuantity() {
		return quantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQuantity(String newQuantity) {
		String oldQuantity = quantity;
		quantity = newQuantity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE__QUANTITY, oldQuantity, quantity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isReinit() {
		return reinit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReinit(boolean newReinit) {
		boolean oldReinit = reinit;
		reinit = newReinit;
		boolean oldReinitESet = reinitESet;
		reinitESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE__REINIT, oldReinit, reinit, !oldReinitESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReinit() {
		boolean oldReinit = reinit;
		boolean oldReinitESet = reinitESet;
		reinit = REINIT_EDEFAULT;
		reinitESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.REAL_TYPE__REINIT, oldReinit, REINIT_EDEFAULT, oldReinitESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReinit() {
		return reinitESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRelativeQuantity() {
		return relativeQuantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelativeQuantity(boolean newRelativeQuantity) {
		boolean oldRelativeQuantity = relativeQuantity;
		relativeQuantity = newRelativeQuantity;
		boolean oldRelativeQuantityESet = relativeQuantityESet;
		relativeQuantityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE__RELATIVE_QUANTITY, oldRelativeQuantity, relativeQuantity, !oldRelativeQuantityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRelativeQuantity() {
		boolean oldRelativeQuantity = relativeQuantity;
		boolean oldRelativeQuantityESet = relativeQuantityESet;
		relativeQuantity = RELATIVE_QUANTITY_EDEFAULT;
		relativeQuantityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.REAL_TYPE__RELATIVE_QUANTITY, oldRelativeQuantity, RELATIVE_QUANTITY_EDEFAULT, oldRelativeQuantityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRelativeQuantity() {
		return relativeQuantityESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStart(double newStart) {
		double oldStart = start;
		start = newStart;
		boolean oldStartESet = startESet;
		startESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE__START, oldStart, start, !oldStartESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetStart() {
		double oldStart = start;
		boolean oldStartESet = startESet;
		start = START_EDEFAULT;
		startESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.REAL_TYPE__START, oldStart, START_EDEFAULT, oldStartESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetStart() {
		return startESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isUnbounded() {
		return unbounded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUnbounded(boolean newUnbounded) {
		boolean oldUnbounded = unbounded;
		unbounded = newUnbounded;
		boolean oldUnboundedESet = unboundedESet;
		unboundedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE__UNBOUNDED, oldUnbounded, unbounded, !oldUnboundedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUnbounded() {
		boolean oldUnbounded = unbounded;
		boolean oldUnboundedESet = unboundedESet;
		unbounded = UNBOUNDED_EDEFAULT;
		unboundedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.REAL_TYPE__UNBOUNDED, oldUnbounded, UNBOUNDED_EDEFAULT, oldUnboundedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUnbounded() {
		return unboundedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUnit() {
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUnit(String newUnit) {
		String oldUnit = unit;
		unit = newUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE__UNIT, oldUnit, unit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FmiPackage.REAL_TYPE__DECLARED_TYPE:
				return getDeclaredType();
			case FmiPackage.REAL_TYPE__DERIVATIVE:
				return getDerivative();
			case FmiPackage.REAL_TYPE__DISPLAY_UNIT:
				return getDisplayUnit();
			case FmiPackage.REAL_TYPE__MAX:
				return getMax();
			case FmiPackage.REAL_TYPE__MIN:
				return getMin();
			case FmiPackage.REAL_TYPE__NOMINAL:
				return getNominal();
			case FmiPackage.REAL_TYPE__QUANTITY:
				return getQuantity();
			case FmiPackage.REAL_TYPE__REINIT:
				return isReinit();
			case FmiPackage.REAL_TYPE__RELATIVE_QUANTITY:
				return isRelativeQuantity();
			case FmiPackage.REAL_TYPE__START:
				return getStart();
			case FmiPackage.REAL_TYPE__UNBOUNDED:
				return isUnbounded();
			case FmiPackage.REAL_TYPE__UNIT:
				return getUnit();
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
			case FmiPackage.REAL_TYPE__DECLARED_TYPE:
				setDeclaredType((String)newValue);
				return;
			case FmiPackage.REAL_TYPE__DERIVATIVE:
				setDerivative((Long)newValue);
				return;
			case FmiPackage.REAL_TYPE__DISPLAY_UNIT:
				setDisplayUnit((String)newValue);
				return;
			case FmiPackage.REAL_TYPE__MAX:
				setMax((Double)newValue);
				return;
			case FmiPackage.REAL_TYPE__MIN:
				setMin((Double)newValue);
				return;
			case FmiPackage.REAL_TYPE__NOMINAL:
				setNominal((Double)newValue);
				return;
			case FmiPackage.REAL_TYPE__QUANTITY:
				setQuantity((String)newValue);
				return;
			case FmiPackage.REAL_TYPE__REINIT:
				setReinit((Boolean)newValue);
				return;
			case FmiPackage.REAL_TYPE__RELATIVE_QUANTITY:
				setRelativeQuantity((Boolean)newValue);
				return;
			case FmiPackage.REAL_TYPE__START:
				setStart((Double)newValue);
				return;
			case FmiPackage.REAL_TYPE__UNBOUNDED:
				setUnbounded((Boolean)newValue);
				return;
			case FmiPackage.REAL_TYPE__UNIT:
				setUnit((String)newValue);
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
			case FmiPackage.REAL_TYPE__DECLARED_TYPE:
				setDeclaredType(DECLARED_TYPE_EDEFAULT);
				return;
			case FmiPackage.REAL_TYPE__DERIVATIVE:
				unsetDerivative();
				return;
			case FmiPackage.REAL_TYPE__DISPLAY_UNIT:
				setDisplayUnit(DISPLAY_UNIT_EDEFAULT);
				return;
			case FmiPackage.REAL_TYPE__MAX:
				unsetMax();
				return;
			case FmiPackage.REAL_TYPE__MIN:
				unsetMin();
				return;
			case FmiPackage.REAL_TYPE__NOMINAL:
				unsetNominal();
				return;
			case FmiPackage.REAL_TYPE__QUANTITY:
				setQuantity(QUANTITY_EDEFAULT);
				return;
			case FmiPackage.REAL_TYPE__REINIT:
				unsetReinit();
				return;
			case FmiPackage.REAL_TYPE__RELATIVE_QUANTITY:
				unsetRelativeQuantity();
				return;
			case FmiPackage.REAL_TYPE__START:
				unsetStart();
				return;
			case FmiPackage.REAL_TYPE__UNBOUNDED:
				unsetUnbounded();
				return;
			case FmiPackage.REAL_TYPE__UNIT:
				setUnit(UNIT_EDEFAULT);
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
			case FmiPackage.REAL_TYPE__DECLARED_TYPE:
				return DECLARED_TYPE_EDEFAULT == null ? declaredType != null : !DECLARED_TYPE_EDEFAULT.equals(declaredType);
			case FmiPackage.REAL_TYPE__DERIVATIVE:
				return isSetDerivative();
			case FmiPackage.REAL_TYPE__DISPLAY_UNIT:
				return DISPLAY_UNIT_EDEFAULT == null ? displayUnit != null : !DISPLAY_UNIT_EDEFAULT.equals(displayUnit);
			case FmiPackage.REAL_TYPE__MAX:
				return isSetMax();
			case FmiPackage.REAL_TYPE__MIN:
				return isSetMin();
			case FmiPackage.REAL_TYPE__NOMINAL:
				return isSetNominal();
			case FmiPackage.REAL_TYPE__QUANTITY:
				return QUANTITY_EDEFAULT == null ? quantity != null : !QUANTITY_EDEFAULT.equals(quantity);
			case FmiPackage.REAL_TYPE__REINIT:
				return isSetReinit();
			case FmiPackage.REAL_TYPE__RELATIVE_QUANTITY:
				return isSetRelativeQuantity();
			case FmiPackage.REAL_TYPE__START:
				return isSetStart();
			case FmiPackage.REAL_TYPE__UNBOUNDED:
				return isSetUnbounded();
			case FmiPackage.REAL_TYPE__UNIT:
				return UNIT_EDEFAULT == null ? unit != null : !UNIT_EDEFAULT.equals(unit);
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
		result.append(", derivative: ");
		if (derivativeESet) result.append(derivative); else result.append("<unset>");
		result.append(", displayUnit: ");
		result.append(displayUnit);
		result.append(", max: ");
		if (maxESet) result.append(max); else result.append("<unset>");
		result.append(", min: ");
		if (minESet) result.append(min); else result.append("<unset>");
		result.append(", nominal: ");
		if (nominalESet) result.append(nominal); else result.append("<unset>");
		result.append(", quantity: ");
		result.append(quantity);
		result.append(", reinit: ");
		if (reinitESet) result.append(reinit); else result.append("<unset>");
		result.append(", relativeQuantity: ");
		if (relativeQuantityESet) result.append(relativeQuantity); else result.append("<unset>");
		result.append(", start: ");
		if (startESet) result.append(start); else result.append("<unset>");
		result.append(", unbounded: ");
		if (unboundedESet) result.append(unbounded); else result.append("<unset>");
		result.append(", unit: ");
		result.append(unit);
		result.append(')');
		return result.toString();
	}

} //RealTypeImpl
