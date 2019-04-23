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
package org.eclipse.papyrus.moka.fmi.fmiprofile;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CS FMU</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#isCanHandleVariableCommunicationStepSize <em>Can Handle Variable Communication Step Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#isCanInterpolateInputs <em>Can Interpolate Inputs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#isCanRunAsynchronuously <em>Can Run Asynchronuously</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getMaxOutputDerivativeOrder <em>Max Output Derivative Order</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getStopTime <em>Stop Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getStepSize <em>Step Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getTolerance <em>Tolerance</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getCS_FMU()
 * @model
 * @generated
 */
public interface CS_FMU extends FMU {
	/**
	 * Returns the value of the '<em><b>Can Handle Variable Communication Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Can Handle Variable Communication Step Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Can Handle Variable Communication Step Size</em>' attribute.
	 * @see #setCanHandleVariableCommunicationStepSize(boolean)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getCS_FMU_CanHandleVariableCommunicationStepSize()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isCanHandleVariableCommunicationStepSize();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#isCanHandleVariableCommunicationStepSize <em>Can Handle Variable Communication Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Can Handle Variable Communication Step Size</em>' attribute.
	 * @see #isCanHandleVariableCommunicationStepSize()
	 * @generated
	 */
	void setCanHandleVariableCommunicationStepSize(boolean value);

	/**
	 * Returns the value of the '<em><b>Can Interpolate Inputs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Can Interpolate Inputs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Can Interpolate Inputs</em>' attribute.
	 * @see #setCanInterpolateInputs(boolean)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getCS_FMU_CanInterpolateInputs()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isCanInterpolateInputs();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#isCanInterpolateInputs <em>Can Interpolate Inputs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Can Interpolate Inputs</em>' attribute.
	 * @see #isCanInterpolateInputs()
	 * @generated
	 */
	void setCanInterpolateInputs(boolean value);

	/**
	 * Returns the value of the '<em><b>Can Run Asynchronuously</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Can Run Asynchronuously</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Can Run Asynchronuously</em>' attribute.
	 * @see #setCanRunAsynchronuously(boolean)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getCS_FMU_CanRunAsynchronuously()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isCanRunAsynchronuously();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#isCanRunAsynchronuously <em>Can Run Asynchronuously</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Can Run Asynchronuously</em>' attribute.
	 * @see #isCanRunAsynchronuously()
	 * @generated
	 */
	void setCanRunAsynchronuously(boolean value);

	/**
	 * Returns the value of the '<em><b>Max Output Derivative Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Output Derivative Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Output Derivative Order</em>' attribute.
	 * @see #setMaxOutputDerivativeOrder(int)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getCS_FMU_MaxOutputDerivativeOrder()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getMaxOutputDerivativeOrder();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getMaxOutputDerivativeOrder <em>Max Output Derivative Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Output Derivative Order</em>' attribute.
	 * @see #getMaxOutputDerivativeOrder()
	 * @generated
	 */
	void setMaxOutputDerivativeOrder(int value);

	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #setStartTime(double)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getCS_FMU_StartTime()
	 * @model dataType="org.eclipse.uml2.types.Real" required="true" ordered="false"
	 * @generated
	 */
	double getStartTime();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(double value);

	/**
	 * Returns the value of the '<em><b>Stop Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop Time</em>' attribute.
	 * @see #setStopTime(double)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getCS_FMU_StopTime()
	 * @model dataType="org.eclipse.uml2.types.Real" required="true" ordered="false"
	 * @generated
	 */
	double getStopTime();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getStopTime <em>Stop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop Time</em>' attribute.
	 * @see #getStopTime()
	 * @generated
	 */
	void setStopTime(double value);

	/**
	 * Returns the value of the '<em><b>Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Size</em>' attribute.
	 * @see #setStepSize(double)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getCS_FMU_StepSize()
	 * @model dataType="org.eclipse.uml2.types.Real" required="true" ordered="false"
	 * @generated
	 */
	double getStepSize();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getStepSize <em>Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Size</em>' attribute.
	 * @see #getStepSize()
	 * @generated
	 */
	void setStepSize(double value);

	/**
	 * Returns the value of the '<em><b>Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tolerance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tolerance</em>' attribute.
	 * @see #setTolerance(double)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getCS_FMU_Tolerance()
	 * @model dataType="org.eclipse.uml2.types.Real" required="true" ordered="false"
	 * @generated
	 */
	double getTolerance();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getTolerance <em>Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tolerance</em>' attribute.
	 * @see #getTolerance()
	 * @generated
	 */
	void setTolerance(double value);

} // CS_FMU
