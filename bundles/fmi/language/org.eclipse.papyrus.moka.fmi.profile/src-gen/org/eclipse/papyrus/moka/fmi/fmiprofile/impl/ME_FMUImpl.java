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

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage;
import org.eclipse.papyrus.moka.fmi.fmiprofile.ME_FMU;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ME FMU</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ME_FMUImpl#isCompletedIntegratorStepNotNeeded <em>Completed Integrator Step Not Needed</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ME_FMUImpl extends FMUImpl implements ME_FMU {
	/**
	 * The default value of the '{@link #isCompletedIntegratorStepNotNeeded() <em>Completed Integrator Step Not Needed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCompletedIntegratorStepNotNeeded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPLETED_INTEGRATOR_STEP_NOT_NEEDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCompletedIntegratorStepNotNeeded() <em>Completed Integrator Step Not Needed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCompletedIntegratorStepNotNeeded()
	 * @generated
	 * @ordered
	 */
	protected boolean completedIntegratorStepNotNeeded = COMPLETED_INTEGRATOR_STEP_NOT_NEEDED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ME_FMUImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FMIProfilePackage.Literals.ME_FMU;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCompletedIntegratorStepNotNeeded() {
		return completedIntegratorStepNotNeeded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompletedIntegratorStepNotNeeded(boolean newCompletedIntegratorStepNotNeeded) {
		boolean oldCompletedIntegratorStepNotNeeded = completedIntegratorStepNotNeeded;
		completedIntegratorStepNotNeeded = newCompletedIntegratorStepNotNeeded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.ME_FMU__COMPLETED_INTEGRATOR_STEP_NOT_NEEDED, oldCompletedIntegratorStepNotNeeded, completedIntegratorStepNotNeeded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FMIProfilePackage.ME_FMU__COMPLETED_INTEGRATOR_STEP_NOT_NEEDED:
				return isCompletedIntegratorStepNotNeeded();
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
			case FMIProfilePackage.ME_FMU__COMPLETED_INTEGRATOR_STEP_NOT_NEEDED:
				setCompletedIntegratorStepNotNeeded((Boolean)newValue);
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
			case FMIProfilePackage.ME_FMU__COMPLETED_INTEGRATOR_STEP_NOT_NEEDED:
				setCompletedIntegratorStepNotNeeded(COMPLETED_INTEGRATOR_STEP_NOT_NEEDED_EDEFAULT);
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
			case FMIProfilePackage.ME_FMU__COMPLETED_INTEGRATOR_STEP_NOT_NEEDED:
				return completedIntegratorStepNotNeeded != COMPLETED_INTEGRATOR_STEP_NOT_NEEDED_EDEFAULT;
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
		result.append(" (completedIntegratorStepNotNeeded: ");
		result.append(completedIntegratorStepNotNeeded);
		result.append(')');
		return result.toString();
	}

} //ME_FMUImpl
