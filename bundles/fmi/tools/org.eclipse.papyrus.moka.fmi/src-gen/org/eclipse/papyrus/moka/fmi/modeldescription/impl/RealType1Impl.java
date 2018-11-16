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
import org.eclipse.papyrus.moka.fmi.modeldescription.RealType1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Real Type1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealType1Impl#getDisplayUnit <em>Display Unit</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealType1Impl#getMax <em>Max</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealType1Impl#getMin <em>Min</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealType1Impl#getNominal <em>Nominal</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealType1Impl#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealType1Impl#isRelativeQuantity <em>Relative Quantity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealType1Impl#isUnbounded <em>Unbounded</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealType1Impl#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RealType1Impl extends MinimalEObjectImpl.Container implements RealType1 {
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
	protected RealType1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FmiPackage.Literals.REAL_TYPE1;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE1__DISPLAY_UNIT, oldDisplayUnit, displayUnit));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE1__MAX, oldMax, max, !oldMaxESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.REAL_TYPE1__MAX, oldMax, MAX_EDEFAULT, oldMaxESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE1__MIN, oldMin, min, !oldMinESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.REAL_TYPE1__MIN, oldMin, MIN_EDEFAULT, oldMinESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE1__NOMINAL, oldNominal, nominal, !oldNominalESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.REAL_TYPE1__NOMINAL, oldNominal, NOMINAL_EDEFAULT, oldNominalESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE1__QUANTITY, oldQuantity, quantity));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE1__RELATIVE_QUANTITY, oldRelativeQuantity, relativeQuantity, !oldRelativeQuantityESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.REAL_TYPE1__RELATIVE_QUANTITY, oldRelativeQuantity, RELATIVE_QUANTITY_EDEFAULT, oldRelativeQuantityESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE1__UNBOUNDED, oldUnbounded, unbounded, !oldUnboundedESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.REAL_TYPE1__UNBOUNDED, oldUnbounded, UNBOUNDED_EDEFAULT, oldUnboundedESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.REAL_TYPE1__UNIT, oldUnit, unit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FmiPackage.REAL_TYPE1__DISPLAY_UNIT:
				return getDisplayUnit();
			case FmiPackage.REAL_TYPE1__MAX:
				return getMax();
			case FmiPackage.REAL_TYPE1__MIN:
				return getMin();
			case FmiPackage.REAL_TYPE1__NOMINAL:
				return getNominal();
			case FmiPackage.REAL_TYPE1__QUANTITY:
				return getQuantity();
			case FmiPackage.REAL_TYPE1__RELATIVE_QUANTITY:
				return isRelativeQuantity();
			case FmiPackage.REAL_TYPE1__UNBOUNDED:
				return isUnbounded();
			case FmiPackage.REAL_TYPE1__UNIT:
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
			case FmiPackage.REAL_TYPE1__DISPLAY_UNIT:
				setDisplayUnit((String)newValue);
				return;
			case FmiPackage.REAL_TYPE1__MAX:
				setMax((Double)newValue);
				return;
			case FmiPackage.REAL_TYPE1__MIN:
				setMin((Double)newValue);
				return;
			case FmiPackage.REAL_TYPE1__NOMINAL:
				setNominal((Double)newValue);
				return;
			case FmiPackage.REAL_TYPE1__QUANTITY:
				setQuantity((String)newValue);
				return;
			case FmiPackage.REAL_TYPE1__RELATIVE_QUANTITY:
				setRelativeQuantity((Boolean)newValue);
				return;
			case FmiPackage.REAL_TYPE1__UNBOUNDED:
				setUnbounded((Boolean)newValue);
				return;
			case FmiPackage.REAL_TYPE1__UNIT:
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
			case FmiPackage.REAL_TYPE1__DISPLAY_UNIT:
				setDisplayUnit(DISPLAY_UNIT_EDEFAULT);
				return;
			case FmiPackage.REAL_TYPE1__MAX:
				unsetMax();
				return;
			case FmiPackage.REAL_TYPE1__MIN:
				unsetMin();
				return;
			case FmiPackage.REAL_TYPE1__NOMINAL:
				unsetNominal();
				return;
			case FmiPackage.REAL_TYPE1__QUANTITY:
				setQuantity(QUANTITY_EDEFAULT);
				return;
			case FmiPackage.REAL_TYPE1__RELATIVE_QUANTITY:
				unsetRelativeQuantity();
				return;
			case FmiPackage.REAL_TYPE1__UNBOUNDED:
				unsetUnbounded();
				return;
			case FmiPackage.REAL_TYPE1__UNIT:
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
			case FmiPackage.REAL_TYPE1__DISPLAY_UNIT:
				return DISPLAY_UNIT_EDEFAULT == null ? displayUnit != null : !DISPLAY_UNIT_EDEFAULT.equals(displayUnit);
			case FmiPackage.REAL_TYPE1__MAX:
				return isSetMax();
			case FmiPackage.REAL_TYPE1__MIN:
				return isSetMin();
			case FmiPackage.REAL_TYPE1__NOMINAL:
				return isSetNominal();
			case FmiPackage.REAL_TYPE1__QUANTITY:
				return QUANTITY_EDEFAULT == null ? quantity != null : !QUANTITY_EDEFAULT.equals(quantity);
			case FmiPackage.REAL_TYPE1__RELATIVE_QUANTITY:
				return isSetRelativeQuantity();
			case FmiPackage.REAL_TYPE1__UNBOUNDED:
				return isSetUnbounded();
			case FmiPackage.REAL_TYPE1__UNIT:
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
		result.append(" (displayUnit: ");
		result.append(displayUnit);
		result.append(", max: ");
		if (maxESet) result.append(max); else result.append("<unset>");
		result.append(", min: ");
		if (minESet) result.append(min); else result.append("<unset>");
		result.append(", nominal: ");
		if (nominalESet) result.append(nominal); else result.append("<unset>");
		result.append(", quantity: ");
		result.append(quantity);
		result.append(", relativeQuantity: ");
		if (relativeQuantityESet) result.append(relativeQuantity); else result.append("<unset>");
		result.append(", unbounded: ");
		if (unboundedESet) result.append(unbounded); else result.append("<unset>");
		result.append(", unit: ");
		result.append(unit);
		result.append(')');
		return result.toString();
	}

} //RealType1Impl
