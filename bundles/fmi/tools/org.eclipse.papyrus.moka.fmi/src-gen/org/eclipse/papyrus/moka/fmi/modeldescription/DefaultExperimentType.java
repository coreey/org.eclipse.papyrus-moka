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
package org.eclipse.papyrus.moka.fmi.modeldescription;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Default Experiment Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getStepSize <em>Step Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getStopTime <em>Stop Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getTolerance <em>Tolerance</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getDefaultExperimentType()
 * @model extendedMetaData="name='DefaultExperiment_._type' kind='empty'"
 * @generated
 */
public interface DefaultExperimentType extends EObject {
	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Default start time of simulation
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #isSetStartTime()
	 * @see #unsetStartTime()
	 * @see #setStartTime(double)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getDefaultExperimentType_StartTime()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='startTime' namespace='##targetNamespace'"
	 * @generated
	 */
	double getStartTime();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #isSetStartTime()
	 * @see #unsetStartTime()
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(double value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStartTime()
	 * @see #getStartTime()
	 * @see #setStartTime(double)
	 * @generated
	 */
	void unsetStartTime();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getStartTime <em>Start Time</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Start Time</em>' attribute is set.
	 * @see #unsetStartTime()
	 * @see #getStartTime()
	 * @see #setStartTime(double)
	 * @generated
	 */
	boolean isSetStartTime();

	/**
	 * Returns the value of the '<em><b>Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ModelExchange: Default step size for fixed step integrators.
	 * CoSimulation: Preferred communicationStepSize.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Step Size</em>' attribute.
	 * @see #isSetStepSize()
	 * @see #unsetStepSize()
	 * @see #setStepSize(double)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getDefaultExperimentType_StepSize()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='stepSize' namespace='##targetNamespace'"
	 * @generated
	 */
	double getStepSize();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getStepSize <em>Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Size</em>' attribute.
	 * @see #isSetStepSize()
	 * @see #unsetStepSize()
	 * @see #getStepSize()
	 * @generated
	 */
	void setStepSize(double value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getStepSize <em>Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStepSize()
	 * @see #getStepSize()
	 * @see #setStepSize(double)
	 * @generated
	 */
	void unsetStepSize();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getStepSize <em>Step Size</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Step Size</em>' attribute is set.
	 * @see #unsetStepSize()
	 * @see #getStepSize()
	 * @see #setStepSize(double)
	 * @generated
	 */
	boolean isSetStepSize();

	/**
	 * Returns the value of the '<em><b>Stop Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Default stop time of simulation
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Stop Time</em>' attribute.
	 * @see #isSetStopTime()
	 * @see #unsetStopTime()
	 * @see #setStopTime(double)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getDefaultExperimentType_StopTime()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='stopTime' namespace='##targetNamespace'"
	 * @generated
	 */
	double getStopTime();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getStopTime <em>Stop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop Time</em>' attribute.
	 * @see #isSetStopTime()
	 * @see #unsetStopTime()
	 * @see #getStopTime()
	 * @generated
	 */
	void setStopTime(double value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getStopTime <em>Stop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStopTime()
	 * @see #getStopTime()
	 * @see #setStopTime(double)
	 * @generated
	 */
	void unsetStopTime();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getStopTime <em>Stop Time</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Stop Time</em>' attribute is set.
	 * @see #unsetStopTime()
	 * @see #getStopTime()
	 * @see #setStopTime(double)
	 * @generated
	 */
	boolean isSetStopTime();

	/**
	 * Returns the value of the '<em><b>Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Default relative integration tolerance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tolerance</em>' attribute.
	 * @see #isSetTolerance()
	 * @see #unsetTolerance()
	 * @see #setTolerance(double)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getDefaultExperimentType_Tolerance()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='tolerance' namespace='##targetNamespace'"
	 * @generated
	 */
	double getTolerance();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getTolerance <em>Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tolerance</em>' attribute.
	 * @see #isSetTolerance()
	 * @see #unsetTolerance()
	 * @see #getTolerance()
	 * @generated
	 */
	void setTolerance(double value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getTolerance <em>Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTolerance()
	 * @see #getTolerance()
	 * @see #setTolerance(double)
	 * @generated
	 */
	void unsetTolerance();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getTolerance <em>Tolerance</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tolerance</em>' attribute is set.
	 * @see #unsetTolerance()
	 * @see #getTolerance()
	 * @see #setTolerance(double)
	 * @generated
	 */
	boolean isSetTolerance();

} // DefaultExperimentType
