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

import org.eclipse.papyrus.moka.fmi.fmiprofile.CausalityKind;
import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage;
import org.eclipse.papyrus.moka.fmi.fmiprofile.InitialKind;
import org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable;
import org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityKind;

import org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scalar Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ScalarVariableImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ScalarVariableImpl#getVariability <em>Variability</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ScalarVariableImpl#getInitial <em>Initial</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ScalarVariableImpl#getValueReference <em>Value Reference</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ScalarVariableImpl#getFmiVariable <em>Fmi Variable</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ScalarVariableImpl#getCausalityKind <em>Causality Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ScalarVariableImpl extends MinimalEObjectImpl.Container implements ScalarVariable {
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
	 * The default value of the '{@link #getVariability() <em>Variability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariability()
	 * @generated
	 * @ordered
	 */
	protected static final VariabilityKind VARIABILITY_EDEFAULT = VariabilityKind.CONSTANT;

	/**
	 * The cached value of the '{@link #getVariability() <em>Variability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariability()
	 * @generated
	 * @ordered
	 */
	protected VariabilityKind variability = VARIABILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitial() <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitial()
	 * @generated
	 * @ordered
	 */
	protected static final InitialKind INITIAL_EDEFAULT = InitialKind.EXACT;

	/**
	 * The cached value of the '{@link #getInitial() <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitial()
	 * @generated
	 * @ordered
	 */
	protected InitialKind initial = INITIAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueReference() <em>Value Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueReference()
	 * @generated
	 * @ordered
	 */
	protected static final long VALUE_REFERENCE_EDEFAULT = -1L;

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
	 * The cached value of the '{@link #getFmiVariable() <em>Fmi Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFmiVariable()
	 * @generated
	 * @ordered
	 */
	protected Fmi2ScalarVariable fmiVariable;

	/**
	 * The default value of the '{@link #getCausalityKind() <em>Causality Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCausalityKind()
	 * @generated
	 * @ordered
	 */
	protected static final CausalityKind CAUSALITY_KIND_EDEFAULT = CausalityKind.PARAMETER;

	/**
	 * The cached value of the '{@link #getCausalityKind() <em>Causality Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCausalityKind()
	 * @generated
	 * @ordered
	 */
	protected CausalityKind causalityKind = CAUSALITY_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScalarVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FMIProfilePackage.Literals.SCALAR_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.SCALAR_VARIABLE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariabilityKind getVariability() {
		return variability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariability(VariabilityKind newVariability) {
		VariabilityKind oldVariability = variability;
		variability = newVariability == null ? VARIABILITY_EDEFAULT : newVariability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.SCALAR_VARIABLE__VARIABILITY, oldVariability, variability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitialKind getInitial() {
		return initial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitial(InitialKind newInitial) {
		InitialKind oldInitial = initial;
		initial = newInitial == null ? INITIAL_EDEFAULT : newInitial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.SCALAR_VARIABLE__INITIAL, oldInitial, initial));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getValueReference() {
		return valueReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueReference(long newValueReference) {
		long oldValueReference = valueReference;
		valueReference = newValueReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.SCALAR_VARIABLE__VALUE_REFERENCE, oldValueReference, valueReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fmi2ScalarVariable getFmiVariable() {
		if (fmiVariable != null && fmiVariable.eIsProxy()) {
			InternalEObject oldFmiVariable = (InternalEObject)fmiVariable;
			fmiVariable = (Fmi2ScalarVariable)eResolveProxy(oldFmiVariable);
			if (fmiVariable != oldFmiVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FMIProfilePackage.SCALAR_VARIABLE__FMI_VARIABLE, oldFmiVariable, fmiVariable));
			}
		}
		return fmiVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fmi2ScalarVariable basicGetFmiVariable() {
		return fmiVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFmiVariable(Fmi2ScalarVariable newFmiVariable) {
		Fmi2ScalarVariable oldFmiVariable = fmiVariable;
		fmiVariable = newFmiVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.SCALAR_VARIABLE__FMI_VARIABLE, oldFmiVariable, fmiVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CausalityKind getCausalityKind() {
		return causalityKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCausalityKind(CausalityKind newCausalityKind) {
		CausalityKind oldCausalityKind = causalityKind;
		causalityKind = newCausalityKind == null ? CAUSALITY_KIND_EDEFAULT : newCausalityKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.SCALAR_VARIABLE__CAUSALITY_KIND, oldCausalityKind, causalityKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FMIProfilePackage.SCALAR_VARIABLE__DESCRIPTION:
				return getDescription();
			case FMIProfilePackage.SCALAR_VARIABLE__VARIABILITY:
				return getVariability();
			case FMIProfilePackage.SCALAR_VARIABLE__INITIAL:
				return getInitial();
			case FMIProfilePackage.SCALAR_VARIABLE__VALUE_REFERENCE:
				return getValueReference();
			case FMIProfilePackage.SCALAR_VARIABLE__FMI_VARIABLE:
				if (resolve) return getFmiVariable();
				return basicGetFmiVariable();
			case FMIProfilePackage.SCALAR_VARIABLE__CAUSALITY_KIND:
				return getCausalityKind();
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
			case FMIProfilePackage.SCALAR_VARIABLE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case FMIProfilePackage.SCALAR_VARIABLE__VARIABILITY:
				setVariability((VariabilityKind)newValue);
				return;
			case FMIProfilePackage.SCALAR_VARIABLE__INITIAL:
				setInitial((InitialKind)newValue);
				return;
			case FMIProfilePackage.SCALAR_VARIABLE__VALUE_REFERENCE:
				setValueReference((Long)newValue);
				return;
			case FMIProfilePackage.SCALAR_VARIABLE__FMI_VARIABLE:
				setFmiVariable((Fmi2ScalarVariable)newValue);
				return;
			case FMIProfilePackage.SCALAR_VARIABLE__CAUSALITY_KIND:
				setCausalityKind((CausalityKind)newValue);
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
			case FMIProfilePackage.SCALAR_VARIABLE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case FMIProfilePackage.SCALAR_VARIABLE__VARIABILITY:
				setVariability(VARIABILITY_EDEFAULT);
				return;
			case FMIProfilePackage.SCALAR_VARIABLE__INITIAL:
				setInitial(INITIAL_EDEFAULT);
				return;
			case FMIProfilePackage.SCALAR_VARIABLE__VALUE_REFERENCE:
				setValueReference(VALUE_REFERENCE_EDEFAULT);
				return;
			case FMIProfilePackage.SCALAR_VARIABLE__FMI_VARIABLE:
				setFmiVariable((Fmi2ScalarVariable)null);
				return;
			case FMIProfilePackage.SCALAR_VARIABLE__CAUSALITY_KIND:
				setCausalityKind(CAUSALITY_KIND_EDEFAULT);
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
			case FMIProfilePackage.SCALAR_VARIABLE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case FMIProfilePackage.SCALAR_VARIABLE__VARIABILITY:
				return variability != VARIABILITY_EDEFAULT;
			case FMIProfilePackage.SCALAR_VARIABLE__INITIAL:
				return initial != INITIAL_EDEFAULT;
			case FMIProfilePackage.SCALAR_VARIABLE__VALUE_REFERENCE:
				return valueReference != VALUE_REFERENCE_EDEFAULT;
			case FMIProfilePackage.SCALAR_VARIABLE__FMI_VARIABLE:
				return fmiVariable != null;
			case FMIProfilePackage.SCALAR_VARIABLE__CAUSALITY_KIND:
				return causalityKind != CAUSALITY_KIND_EDEFAULT;
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
		result.append(", variability: ");
		result.append(variability);
		result.append(", initial: ");
		result.append(initial);
		result.append(", valueReference: ");
		result.append(valueReference);
		result.append(", causalityKind: ");
		result.append(causalityKind);
		result.append(')');
		return result.toString();
	}

} //ScalarVariableImpl
