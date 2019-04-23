/**
 * Copyright (c) 2016 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 *
 *  SPDX-License-Identifier: EPL-2.0
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

import org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph;
import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CS Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_GraphImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_GraphImpl#getStopTime <em>Stop Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_GraphImpl#getStepSize <em>Step Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_GraphImpl#getTolerance <em>Tolerance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_GraphImpl#isToleranceDefined <em>Tolerance Defined</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_GraphImpl#isStopTimeDefined <em>Stop Time Defined</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_GraphImpl#isComputeSetupExperimentsFromFmus <em>Compute Setup Experiments From Fmus</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_GraphImpl#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CS_GraphImpl extends MinimalEObjectImpl.Container implements CS_Graph {
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
	protected static final double STOP_TIME_EDEFAULT = 100.0;

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
	protected static final double STEP_SIZE_EDEFAULT = 10.0;

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
	 * The default value of the '{@link #isToleranceDefined() <em>Tolerance Defined</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isToleranceDefined()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TOLERANCE_DEFINED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isToleranceDefined() <em>Tolerance Defined</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isToleranceDefined()
	 * @generated
	 * @ordered
	 */
	protected boolean toleranceDefined = TOLERANCE_DEFINED_EDEFAULT;

	/**
	 * The default value of the '{@link #isStopTimeDefined() <em>Stop Time Defined</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStopTimeDefined()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STOP_TIME_DEFINED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isStopTimeDefined() <em>Stop Time Defined</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStopTimeDefined()
	 * @generated
	 * @ordered
	 */
	protected boolean stopTimeDefined = STOP_TIME_DEFINED_EDEFAULT;

	/**
	 * The default value of the '{@link #isComputeSetupExperimentsFromFmus() <em>Compute Setup Experiments From Fmus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComputeSetupExperimentsFromFmus()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPUTE_SETUP_EXPERIMENTS_FROM_FMUS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isComputeSetupExperimentsFromFmus() <em>Compute Setup Experiments From Fmus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComputeSetupExperimentsFromFmus()
	 * @generated
	 * @ordered
	 */
	protected boolean computeSetupExperimentsFromFmus = COMPUTE_SETUP_EXPERIMENTS_FROM_FMUS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CS_GraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FMIProfilePackage.Literals.CS_GRAPH;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.CS_GRAPH__START_TIME, oldStartTime, startTime));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.CS_GRAPH__STOP_TIME, oldStopTime, stopTime));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.CS_GRAPH__STEP_SIZE, oldStepSize, stepSize));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.CS_GRAPH__TOLERANCE, oldTolerance, tolerance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isToleranceDefined() {
		return toleranceDefined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToleranceDefined(boolean newToleranceDefined) {
		boolean oldToleranceDefined = toleranceDefined;
		toleranceDefined = newToleranceDefined;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.CS_GRAPH__TOLERANCE_DEFINED, oldToleranceDefined, toleranceDefined));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStopTimeDefined() {
		return stopTimeDefined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStopTimeDefined(boolean newStopTimeDefined) {
		boolean oldStopTimeDefined = stopTimeDefined;
		stopTimeDefined = newStopTimeDefined;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.CS_GRAPH__STOP_TIME_DEFINED, oldStopTimeDefined, stopTimeDefined));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComputeSetupExperimentsFromFmus() {
		return computeSetupExperimentsFromFmus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComputeSetupExperimentsFromFmus(boolean newComputeSetupExperimentsFromFmus) {
		boolean oldComputeSetupExperimentsFromFmus = computeSetupExperimentsFromFmus;
		computeSetupExperimentsFromFmus = newComputeSetupExperimentsFromFmus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.CS_GRAPH__COMPUTE_SETUP_EXPERIMENTS_FROM_FMUS, oldComputeSetupExperimentsFromFmus, computeSetupExperimentsFromFmus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FMIProfilePackage.CS_GRAPH__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.CS_GRAPH__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FMIProfilePackage.CS_GRAPH__START_TIME:
				return getStartTime();
			case FMIProfilePackage.CS_GRAPH__STOP_TIME:
				return getStopTime();
			case FMIProfilePackage.CS_GRAPH__STEP_SIZE:
				return getStepSize();
			case FMIProfilePackage.CS_GRAPH__TOLERANCE:
				return getTolerance();
			case FMIProfilePackage.CS_GRAPH__TOLERANCE_DEFINED:
				return isToleranceDefined();
			case FMIProfilePackage.CS_GRAPH__STOP_TIME_DEFINED:
				return isStopTimeDefined();
			case FMIProfilePackage.CS_GRAPH__COMPUTE_SETUP_EXPERIMENTS_FROM_FMUS:
				return isComputeSetupExperimentsFromFmus();
			case FMIProfilePackage.CS_GRAPH__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
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
			case FMIProfilePackage.CS_GRAPH__START_TIME:
				setStartTime((Double)newValue);
				return;
			case FMIProfilePackage.CS_GRAPH__STOP_TIME:
				setStopTime((Double)newValue);
				return;
			case FMIProfilePackage.CS_GRAPH__STEP_SIZE:
				setStepSize((Double)newValue);
				return;
			case FMIProfilePackage.CS_GRAPH__TOLERANCE:
				setTolerance((Double)newValue);
				return;
			case FMIProfilePackage.CS_GRAPH__TOLERANCE_DEFINED:
				setToleranceDefined((Boolean)newValue);
				return;
			case FMIProfilePackage.CS_GRAPH__STOP_TIME_DEFINED:
				setStopTimeDefined((Boolean)newValue);
				return;
			case FMIProfilePackage.CS_GRAPH__COMPUTE_SETUP_EXPERIMENTS_FROM_FMUS:
				setComputeSetupExperimentsFromFmus((Boolean)newValue);
				return;
			case FMIProfilePackage.CS_GRAPH__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
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
			case FMIProfilePackage.CS_GRAPH__START_TIME:
				setStartTime(START_TIME_EDEFAULT);
				return;
			case FMIProfilePackage.CS_GRAPH__STOP_TIME:
				setStopTime(STOP_TIME_EDEFAULT);
				return;
			case FMIProfilePackage.CS_GRAPH__STEP_SIZE:
				setStepSize(STEP_SIZE_EDEFAULT);
				return;
			case FMIProfilePackage.CS_GRAPH__TOLERANCE:
				setTolerance(TOLERANCE_EDEFAULT);
				return;
			case FMIProfilePackage.CS_GRAPH__TOLERANCE_DEFINED:
				setToleranceDefined(TOLERANCE_DEFINED_EDEFAULT);
				return;
			case FMIProfilePackage.CS_GRAPH__STOP_TIME_DEFINED:
				setStopTimeDefined(STOP_TIME_DEFINED_EDEFAULT);
				return;
			case FMIProfilePackage.CS_GRAPH__COMPUTE_SETUP_EXPERIMENTS_FROM_FMUS:
				setComputeSetupExperimentsFromFmus(COMPUTE_SETUP_EXPERIMENTS_FROM_FMUS_EDEFAULT);
				return;
			case FMIProfilePackage.CS_GRAPH__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
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
			case FMIProfilePackage.CS_GRAPH__START_TIME:
				return startTime != START_TIME_EDEFAULT;
			case FMIProfilePackage.CS_GRAPH__STOP_TIME:
				return stopTime != STOP_TIME_EDEFAULT;
			case FMIProfilePackage.CS_GRAPH__STEP_SIZE:
				return stepSize != STEP_SIZE_EDEFAULT;
			case FMIProfilePackage.CS_GRAPH__TOLERANCE:
				return tolerance != TOLERANCE_EDEFAULT;
			case FMIProfilePackage.CS_GRAPH__TOLERANCE_DEFINED:
				return toleranceDefined != TOLERANCE_DEFINED_EDEFAULT;
			case FMIProfilePackage.CS_GRAPH__STOP_TIME_DEFINED:
				return stopTimeDefined != STOP_TIME_DEFINED_EDEFAULT;
			case FMIProfilePackage.CS_GRAPH__COMPUTE_SETUP_EXPERIMENTS_FROM_FMUS:
				return computeSetupExperimentsFromFmus != COMPUTE_SETUP_EXPERIMENTS_FROM_FMUS_EDEFAULT;
			case FMIProfilePackage.CS_GRAPH__BASE_CLASS:
				return base_Class != null;
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
		result.append(startTime);
		result.append(", stopTime: ");
		result.append(stopTime);
		result.append(", stepSize: ");
		result.append(stepSize);
		result.append(", tolerance: ");
		result.append(tolerance);
		result.append(", toleranceDefined: ");
		result.append(toleranceDefined);
		result.append(", stopTimeDefined: ");
		result.append(stopTimeDefined);
		result.append(", computeSetupExperimentsFromFmus: ");
		result.append(computeSetupExperimentsFromFmus);
		result.append(')');
		return result.toString();
	}

} //CS_GraphImpl
