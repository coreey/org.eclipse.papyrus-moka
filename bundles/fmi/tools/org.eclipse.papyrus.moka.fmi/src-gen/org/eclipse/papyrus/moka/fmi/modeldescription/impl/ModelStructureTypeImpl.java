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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2VariableDependency;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage;
import org.eclipse.papyrus.moka.fmi.modeldescription.InitialUnknownsType;
import org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Structure Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelStructureTypeImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelStructureTypeImpl#getDerivatives <em>Derivatives</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelStructureTypeImpl#getInitialUnknowns <em>Initial Unknowns</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelStructureTypeImpl extends MinimalEObjectImpl.Container implements ModelStructureType {
	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected Fmi2VariableDependency outputs;

	/**
	 * The cached value of the '{@link #getDerivatives() <em>Derivatives</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivatives()
	 * @generated
	 * @ordered
	 */
	protected Fmi2VariableDependency derivatives;

	/**
	 * The cached value of the '{@link #getInitialUnknowns() <em>Initial Unknowns</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialUnknowns()
	 * @generated
	 * @ordered
	 */
	protected InitialUnknownsType initialUnknowns;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelStructureTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FmiPackage.Literals.MODEL_STRUCTURE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Fmi2VariableDependency getOutputs() {
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputs(Fmi2VariableDependency newOutputs, NotificationChain msgs) {
		Fmi2VariableDependency oldOutputs = outputs;
		outputs = newOutputs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.MODEL_STRUCTURE_TYPE__OUTPUTS, oldOutputs, newOutputs);
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
	public void setOutputs(Fmi2VariableDependency newOutputs) {
		if (newOutputs != outputs) {
			NotificationChain msgs = null;
			if (outputs != null)
				msgs = ((InternalEObject)outputs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.MODEL_STRUCTURE_TYPE__OUTPUTS, null, msgs);
			if (newOutputs != null)
				msgs = ((InternalEObject)newOutputs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.MODEL_STRUCTURE_TYPE__OUTPUTS, null, msgs);
			msgs = basicSetOutputs(newOutputs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.MODEL_STRUCTURE_TYPE__OUTPUTS, newOutputs, newOutputs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Fmi2VariableDependency getDerivatives() {
		return derivatives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDerivatives(Fmi2VariableDependency newDerivatives, NotificationChain msgs) {
		Fmi2VariableDependency oldDerivatives = derivatives;
		derivatives = newDerivatives;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.MODEL_STRUCTURE_TYPE__DERIVATIVES, oldDerivatives, newDerivatives);
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
	public void setDerivatives(Fmi2VariableDependency newDerivatives) {
		if (newDerivatives != derivatives) {
			NotificationChain msgs = null;
			if (derivatives != null)
				msgs = ((InternalEObject)derivatives).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.MODEL_STRUCTURE_TYPE__DERIVATIVES, null, msgs);
			if (newDerivatives != null)
				msgs = ((InternalEObject)newDerivatives).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.MODEL_STRUCTURE_TYPE__DERIVATIVES, null, msgs);
			msgs = basicSetDerivatives(newDerivatives, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.MODEL_STRUCTURE_TYPE__DERIVATIVES, newDerivatives, newDerivatives));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InitialUnknownsType getInitialUnknowns() {
		return initialUnknowns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialUnknowns(InitialUnknownsType newInitialUnknowns, NotificationChain msgs) {
		InitialUnknownsType oldInitialUnknowns = initialUnknowns;
		initialUnknowns = newInitialUnknowns;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.MODEL_STRUCTURE_TYPE__INITIAL_UNKNOWNS, oldInitialUnknowns, newInitialUnknowns);
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
	public void setInitialUnknowns(InitialUnknownsType newInitialUnknowns) {
		if (newInitialUnknowns != initialUnknowns) {
			NotificationChain msgs = null;
			if (initialUnknowns != null)
				msgs = ((InternalEObject)initialUnknowns).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.MODEL_STRUCTURE_TYPE__INITIAL_UNKNOWNS, null, msgs);
			if (newInitialUnknowns != null)
				msgs = ((InternalEObject)newInitialUnknowns).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.MODEL_STRUCTURE_TYPE__INITIAL_UNKNOWNS, null, msgs);
			msgs = basicSetInitialUnknowns(newInitialUnknowns, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.MODEL_STRUCTURE_TYPE__INITIAL_UNKNOWNS, newInitialUnknowns, newInitialUnknowns));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FmiPackage.MODEL_STRUCTURE_TYPE__OUTPUTS:
				return basicSetOutputs(null, msgs);
			case FmiPackage.MODEL_STRUCTURE_TYPE__DERIVATIVES:
				return basicSetDerivatives(null, msgs);
			case FmiPackage.MODEL_STRUCTURE_TYPE__INITIAL_UNKNOWNS:
				return basicSetInitialUnknowns(null, msgs);
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
			case FmiPackage.MODEL_STRUCTURE_TYPE__OUTPUTS:
				return getOutputs();
			case FmiPackage.MODEL_STRUCTURE_TYPE__DERIVATIVES:
				return getDerivatives();
			case FmiPackage.MODEL_STRUCTURE_TYPE__INITIAL_UNKNOWNS:
				return getInitialUnknowns();
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
			case FmiPackage.MODEL_STRUCTURE_TYPE__OUTPUTS:
				setOutputs((Fmi2VariableDependency)newValue);
				return;
			case FmiPackage.MODEL_STRUCTURE_TYPE__DERIVATIVES:
				setDerivatives((Fmi2VariableDependency)newValue);
				return;
			case FmiPackage.MODEL_STRUCTURE_TYPE__INITIAL_UNKNOWNS:
				setInitialUnknowns((InitialUnknownsType)newValue);
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
			case FmiPackage.MODEL_STRUCTURE_TYPE__OUTPUTS:
				setOutputs((Fmi2VariableDependency)null);
				return;
			case FmiPackage.MODEL_STRUCTURE_TYPE__DERIVATIVES:
				setDerivatives((Fmi2VariableDependency)null);
				return;
			case FmiPackage.MODEL_STRUCTURE_TYPE__INITIAL_UNKNOWNS:
				setInitialUnknowns((InitialUnknownsType)null);
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
			case FmiPackage.MODEL_STRUCTURE_TYPE__OUTPUTS:
				return outputs != null;
			case FmiPackage.MODEL_STRUCTURE_TYPE__DERIVATIVES:
				return derivatives != null;
			case FmiPackage.MODEL_STRUCTURE_TYPE__INITIAL_UNKNOWNS:
				return initialUnknowns != null;
		}
		return super.eIsSet(featureID);
	}

} //ModelStructureTypeImpl
