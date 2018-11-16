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

import org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU;
import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CS FMU</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_FMUImpl#isCanHandleVariableCommunicationStepSize <em>Can Handle Variable Communication Step Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_FMUImpl#isCanInterpolateInputs <em>Can Interpolate Inputs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_FMUImpl#isCanRunAsynchronuously <em>Can Run Asynchronuously</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_FMUImpl#getMaxOutputDerivativeOrder <em>Max Output Derivative Order</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_FMUImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_FMUImpl#getStopTime <em>Stop Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_FMUImpl#getStepSize <em>Step Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_FMUImpl#getTolerance <em>Tolerance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CS_FMUImpl extends FMUImpl implements CS_FMU {
	/**
	 * The default value of the '{@link #isCanHandleVariableCommunicationStepSize() <em>Can Handle Variable Communication Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanHandleVariableCommunicationStepSize()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCanHandleVariableCommunicationStepSize() <em>Can Handle Variable Communication Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanHandleVariableCommunicationStepSize()
	 * @generated
	 * @ordered
	 */
	protected boolean canHandleVariableCommunicationStepSize = CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #isCanInterpolateInputs() <em>Can Interpolate Inputs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanInterpolateInputs()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CAN_INTERPOLATE_INPUTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCanInterpolateInputs() <em>Can Interpolate Inputs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanInterpolateInputs()
	 * @generated
	 * @ordered
	 */
	protected boolean canInterpolateInputs = CAN_INTERPOLATE_INPUTS_EDEFAULT;

	/**
	 * The default value of the '{@link #isCanRunAsynchronuously() <em>Can Run Asynchronuously</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanRunAsynchronuously()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CAN_RUN_ASYNCHRONUOUSLY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCanRunAsynchronuously() <em>Can Run Asynchronuously</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanRunAsynchronuously()
	 * @generated
	 * @ordered
	 */
	protected boolean canRunAsynchronuously = CAN_RUN_ASYNCHRONUOUSLY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxOutputDerivativeOrder() <em>Max Output Derivative Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxOutputDerivativeOrder()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_OUTPUT_DERIVATIVE_ORDER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxOutputDerivativeOrder() <em>Max Output Derivative Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxOutputDerivativeOrder()
	 * @generated
	 * @ordered
	 */
	protected int maxOutputDerivativeOrder = MAX_OUTPUT_DERIVATIVE_ORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
	protected static final double START_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
	protected double startTime = START_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStopTime() <em>Stop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopTime()
	 * @generated
	 * @ordered
	 */
	protected static final double STOP_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getStopTime() <em>Stop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopTime()
	 * @generated
	 * @ordered
	 */
	protected double stopTime = STOP_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStepSize() <em>Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepSize()
	 * @generated
	 * @ordered
	 */
	protected static final double STEP_SIZE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getStepSize() <em>Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepSize()
	 * @generated
	 * @ordered
	 */
	protected double stepSize = STEP_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTolerance() <em>Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTolerance()
	 * @generated
	 * @ordered
	 */
	protected static final double TOLERANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTolerance() <em>Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTolerance()
	 * @generated
	 * @ordered
	 */
	protected double tolerance = TOLERANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CS_FMUImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FMIProfilePackage.Literals.CS_FMU;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCanHandleVariableCommunicationStepSize() {
		return canHandleVariableCommunicationStepSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCanHandleVariableCommunicationStepSize(boolean newCanHandleVariableCommunicationStepSize) {
		boolean oldCanHandleVariableCommunicationStepSize = canHandleVariableCommunicationStepSize;
		canHandleVariableCommunicationStepSize = newCanHandleVariableCommunicationStepSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.CS_FMU__CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE, oldCanHandleVariableCommunicationStepSize, canHandleVariableCommunicationStepSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCanInterpolateInputs() {
		return canInterpolateInputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCanInterpolateInputs(boolean newCanInterpolateInputs) {
		boolean oldCanInterpolateInputs = canInterpolateInputs;
		canInterpolateInputs = newCanInterpolateInputs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.CS_FMU__CAN_INTERPOLATE_INPUTS, oldCanInterpolateInputs, canInterpolateInputs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCanRunAsynchronuously() {
		return canRunAsynchronuously;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCanRunAsynchronuously(boolean newCanRunAsynchronuously) {
		boolean oldCanRunAsynchronuously = canRunAsynchronuously;
		canRunAsynchronuously = newCanRunAsynchronuously;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.CS_FMU__CAN_RUN_ASYNCHRONUOUSLY, oldCanRunAsynchronuously, canRunAsynchronuously));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxOutputDerivativeOrder() {
		return maxOutputDerivativeOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxOutputDerivativeOrder(int newMaxOutputDerivativeOrder) {
		int oldMaxOutputDerivativeOrder = maxOutputDerivativeOrder;
		maxOutputDerivativeOrder = newMaxOutputDerivativeOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.CS_FMU__MAX_OUTPUT_DERIVATIVE_ORDER, oldMaxOutputDerivativeOrder, maxOutputDerivativeOrder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStartTime() {
		return startTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartTime(double newStartTime) {
		double oldStartTime = startTime;
		startTime = newStartTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.CS_FMU__START_TIME, oldStartTime, startTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStopTime() {
		return stopTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStopTime(double newStopTime) {
		double oldStopTime = stopTime;
		stopTime = newStopTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.CS_FMU__STOP_TIME, oldStopTime, stopTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStepSize() {
		return stepSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepSize(double newStepSize) {
		double oldStepSize = stepSize;
		stepSize = newStepSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.CS_FMU__STEP_SIZE, oldStepSize, stepSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTolerance() {
		return tolerance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTolerance(double newTolerance) {
		double oldTolerance = tolerance;
		tolerance = newTolerance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.CS_FMU__TOLERANCE, oldTolerance, tolerance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FMIProfilePackage.CS_FMU__CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE:
				return isCanHandleVariableCommunicationStepSize();
			case FMIProfilePackage.CS_FMU__CAN_INTERPOLATE_INPUTS:
				return isCanInterpolateInputs();
			case FMIProfilePackage.CS_FMU__CAN_RUN_ASYNCHRONUOUSLY:
				return isCanRunAsynchronuously();
			case FMIProfilePackage.CS_FMU__MAX_OUTPUT_DERIVATIVE_ORDER:
				return getMaxOutputDerivativeOrder();
			case FMIProfilePackage.CS_FMU__START_TIME:
				return getStartTime();
			case FMIProfilePackage.CS_FMU__STOP_TIME:
				return getStopTime();
			case FMIProfilePackage.CS_FMU__STEP_SIZE:
				return getStepSize();
			case FMIProfilePackage.CS_FMU__TOLERANCE:
				return getTolerance();
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
			case FMIProfilePackage.CS_FMU__CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE:
				setCanHandleVariableCommunicationStepSize((Boolean)newValue);
				return;
			case FMIProfilePackage.CS_FMU__CAN_INTERPOLATE_INPUTS:
				setCanInterpolateInputs((Boolean)newValue);
				return;
			case FMIProfilePackage.CS_FMU__CAN_RUN_ASYNCHRONUOUSLY:
				setCanRunAsynchronuously((Boolean)newValue);
				return;
			case FMIProfilePackage.CS_FMU__MAX_OUTPUT_DERIVATIVE_ORDER:
				setMaxOutputDerivativeOrder((Integer)newValue);
				return;
			case FMIProfilePackage.CS_FMU__START_TIME:
				setStartTime((Double)newValue);
				return;
			case FMIProfilePackage.CS_FMU__STOP_TIME:
				setStopTime((Double)newValue);
				return;
			case FMIProfilePackage.CS_FMU__STEP_SIZE:
				setStepSize((Double)newValue);
				return;
			case FMIProfilePackage.CS_FMU__TOLERANCE:
				setTolerance((Double)newValue);
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
			case FMIProfilePackage.CS_FMU__CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE:
				setCanHandleVariableCommunicationStepSize(CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE_EDEFAULT);
				return;
			case FMIProfilePackage.CS_FMU__CAN_INTERPOLATE_INPUTS:
				setCanInterpolateInputs(CAN_INTERPOLATE_INPUTS_EDEFAULT);
				return;
			case FMIProfilePackage.CS_FMU__CAN_RUN_ASYNCHRONUOUSLY:
				setCanRunAsynchronuously(CAN_RUN_ASYNCHRONUOUSLY_EDEFAULT);
				return;
			case FMIProfilePackage.CS_FMU__MAX_OUTPUT_DERIVATIVE_ORDER:
				setMaxOutputDerivativeOrder(MAX_OUTPUT_DERIVATIVE_ORDER_EDEFAULT);
				return;
			case FMIProfilePackage.CS_FMU__START_TIME:
				setStartTime(START_TIME_EDEFAULT);
				return;
			case FMIProfilePackage.CS_FMU__STOP_TIME:
				setStopTime(STOP_TIME_EDEFAULT);
				return;
			case FMIProfilePackage.CS_FMU__STEP_SIZE:
				setStepSize(STEP_SIZE_EDEFAULT);
				return;
			case FMIProfilePackage.CS_FMU__TOLERANCE:
				setTolerance(TOLERANCE_EDEFAULT);
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
			case FMIProfilePackage.CS_FMU__CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE:
				return canHandleVariableCommunicationStepSize != CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE_EDEFAULT;
			case FMIProfilePackage.CS_FMU__CAN_INTERPOLATE_INPUTS:
				return canInterpolateInputs != CAN_INTERPOLATE_INPUTS_EDEFAULT;
			case FMIProfilePackage.CS_FMU__CAN_RUN_ASYNCHRONUOUSLY:
				return canRunAsynchronuously != CAN_RUN_ASYNCHRONUOUSLY_EDEFAULT;
			case FMIProfilePackage.CS_FMU__MAX_OUTPUT_DERIVATIVE_ORDER:
				return maxOutputDerivativeOrder != MAX_OUTPUT_DERIVATIVE_ORDER_EDEFAULT;
			case FMIProfilePackage.CS_FMU__START_TIME:
				return startTime != START_TIME_EDEFAULT;
			case FMIProfilePackage.CS_FMU__STOP_TIME:
				return stopTime != STOP_TIME_EDEFAULT;
			case FMIProfilePackage.CS_FMU__STEP_SIZE:
				return stepSize != STEP_SIZE_EDEFAULT;
			case FMIProfilePackage.CS_FMU__TOLERANCE:
				return tolerance != TOLERANCE_EDEFAULT;
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
		result.append(" (canHandleVariableCommunicationStepSize: ");
		result.append(canHandleVariableCommunicationStepSize);
		result.append(", canInterpolateInputs: ");
		result.append(canInterpolateInputs);
		result.append(", canRunAsynchronuously: ");
		result.append(canRunAsynchronuously);
		result.append(", maxOutputDerivativeOrder: ");
		result.append(maxOutputDerivativeOrder);
		result.append(", startTime: ");
		result.append(startTime);
		result.append(", stopTime: ");
		result.append(stopTime);
		result.append(", stepSize: ");
		result.append(stepSize);
		result.append(", tolerance: ");
		result.append(tolerance);
		result.append(')');
		return result.toString();
	}

} //CS_FMUImpl
