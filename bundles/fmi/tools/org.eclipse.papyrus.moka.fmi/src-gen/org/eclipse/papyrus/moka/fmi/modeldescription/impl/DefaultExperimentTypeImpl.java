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

import org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default Experiment Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.DefaultExperimentTypeImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.DefaultExperimentTypeImpl#getStepSize <em>Step Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.DefaultExperimentTypeImpl#getStopTime <em>Stop Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.DefaultExperimentTypeImpl#getTolerance <em>Tolerance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DefaultExperimentTypeImpl extends MinimalEObjectImpl.Container implements DefaultExperimentType {
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
	 * This is true if the Start Time attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean startTimeESet;

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
	 * This is true if the Step Size attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean stepSizeESet;

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
	 * This is true if the Stop Time attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean stopTimeESet;

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
	 * This is true if the Tolerance attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean toleranceESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultExperimentTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FmiPackage.Literals.DEFAULT_EXPERIMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getStartTime() {
		return startTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartTime(double newStartTime) {
		double oldStartTime = startTime;
		startTime = newStartTime;
		boolean oldStartTimeESet = startTimeESet;
		startTimeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.DEFAULT_EXPERIMENT_TYPE__START_TIME, oldStartTime, startTime, !oldStartTimeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetStartTime() {
		double oldStartTime = startTime;
		boolean oldStartTimeESet = startTimeESet;
		startTime = START_TIME_EDEFAULT;
		startTimeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.DEFAULT_EXPERIMENT_TYPE__START_TIME, oldStartTime, START_TIME_EDEFAULT, oldStartTimeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetStartTime() {
		return startTimeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getStepSize() {
		return stepSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStepSize(double newStepSize) {
		double oldStepSize = stepSize;
		stepSize = newStepSize;
		boolean oldStepSizeESet = stepSizeESet;
		stepSizeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.DEFAULT_EXPERIMENT_TYPE__STEP_SIZE, oldStepSize, stepSize, !oldStepSizeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetStepSize() {
		double oldStepSize = stepSize;
		boolean oldStepSizeESet = stepSizeESet;
		stepSize = STEP_SIZE_EDEFAULT;
		stepSizeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.DEFAULT_EXPERIMENT_TYPE__STEP_SIZE, oldStepSize, STEP_SIZE_EDEFAULT, oldStepSizeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetStepSize() {
		return stepSizeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getStopTime() {
		return stopTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStopTime(double newStopTime) {
		double oldStopTime = stopTime;
		stopTime = newStopTime;
		boolean oldStopTimeESet = stopTimeESet;
		stopTimeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.DEFAULT_EXPERIMENT_TYPE__STOP_TIME, oldStopTime, stopTime, !oldStopTimeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetStopTime() {
		double oldStopTime = stopTime;
		boolean oldStopTimeESet = stopTimeESet;
		stopTime = STOP_TIME_EDEFAULT;
		stopTimeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.DEFAULT_EXPERIMENT_TYPE__STOP_TIME, oldStopTime, STOP_TIME_EDEFAULT, oldStopTimeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetStopTime() {
		return stopTimeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTolerance() {
		return tolerance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTolerance(double newTolerance) {
		double oldTolerance = tolerance;
		tolerance = newTolerance;
		boolean oldToleranceESet = toleranceESet;
		toleranceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.DEFAULT_EXPERIMENT_TYPE__TOLERANCE, oldTolerance, tolerance, !oldToleranceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTolerance() {
		double oldTolerance = tolerance;
		boolean oldToleranceESet = toleranceESet;
		tolerance = TOLERANCE_EDEFAULT;
		toleranceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.DEFAULT_EXPERIMENT_TYPE__TOLERANCE, oldTolerance, TOLERANCE_EDEFAULT, oldToleranceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTolerance() {
		return toleranceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE__START_TIME:
				return getStartTime();
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE__STEP_SIZE:
				return getStepSize();
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE__STOP_TIME:
				return getStopTime();
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE__TOLERANCE:
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
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE__START_TIME:
				setStartTime((Double)newValue);
				return;
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE__STEP_SIZE:
				setStepSize((Double)newValue);
				return;
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE__STOP_TIME:
				setStopTime((Double)newValue);
				return;
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE__TOLERANCE:
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
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE__START_TIME:
				unsetStartTime();
				return;
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE__STEP_SIZE:
				unsetStepSize();
				return;
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE__STOP_TIME:
				unsetStopTime();
				return;
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE__TOLERANCE:
				unsetTolerance();
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
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE__START_TIME:
				return isSetStartTime();
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE__STEP_SIZE:
				return isSetStepSize();
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE__STOP_TIME:
				return isSetStopTime();
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE__TOLERANCE:
				return isSetTolerance();
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
		result.append(" (startTime: ");
		if (startTimeESet) result.append(startTime); else result.append("<unset>");
		result.append(", stepSize: ");
		if (stepSizeESet) result.append(stepSize); else result.append("<unset>");
		result.append(", stopTime: ");
		if (stopTimeESet) result.append(stopTime); else result.append("<unset>");
		result.append(", tolerance: ");
		if (toleranceESet) result.append(tolerance); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //DefaultExperimentTypeImpl
