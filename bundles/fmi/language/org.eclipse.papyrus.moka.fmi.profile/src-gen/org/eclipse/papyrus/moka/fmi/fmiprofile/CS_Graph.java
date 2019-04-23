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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CS Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getStopTime <em>Stop Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getStepSize <em>Step Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getTolerance <em>Tolerance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#isToleranceDefined <em>Tolerance Defined</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#isStopTimeDefined <em>Stop Time Defined</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#isComputeSetupExperimentsFromFmus <em>Compute Setup Experiments From Fmus</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getCS_Graph()
 * @model
 * @generated
 */
public interface CS_Graph extends EObject {
	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #setStartTime(double)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getCS_Graph_StartTime()
	 * @model default="0.0" dataType="org.eclipse.uml2.types.Real" required="true" ordered="false"
	 * @generated
	 */
	double getStartTime();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(double value);

	/**
	 * Returns the value of the '<em><b>Stop Time</b></em>' attribute.
	 * The default value is <code>"100.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop Time</em>' attribute.
	 * @see #setStopTime(double)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getCS_Graph_StopTime()
	 * @model default="100.0" dataType="org.eclipse.uml2.types.Real" required="true" ordered="false"
	 * @generated
	 */
	double getStopTime();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getStopTime <em>Stop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop Time</em>' attribute.
	 * @see #getStopTime()
	 * @generated
	 */
	void setStopTime(double value);

	/**
	 * Returns the value of the '<em><b>Step Size</b></em>' attribute.
	 * The default value is <code>"10.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Size</em>' attribute.
	 * @see #setStepSize(double)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getCS_Graph_StepSize()
	 * @model default="10.0" dataType="org.eclipse.uml2.types.Real" required="true" ordered="false"
	 * @generated
	 */
	double getStepSize();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getStepSize <em>Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Size</em>' attribute.
	 * @see #getStepSize()
	 * @generated
	 */
	void setStepSize(double value);

	/**
	 * Returns the value of the '<em><b>Tolerance</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tolerance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tolerance</em>' attribute.
	 * @see #setTolerance(double)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getCS_Graph_Tolerance()
	 * @model default="0.0" dataType="org.eclipse.uml2.types.Real" required="true" ordered="false"
	 * @generated
	 */
	double getTolerance();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getTolerance <em>Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tolerance</em>' attribute.
	 * @see #getTolerance()
	 * @generated
	 */
	void setTolerance(double value);

	/**
	 * Returns the value of the '<em><b>Tolerance Defined</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tolerance Defined</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tolerance Defined</em>' attribute.
	 * @see #setToleranceDefined(boolean)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getCS_Graph_ToleranceDefined()
	 * @model default="true" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isToleranceDefined();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#isToleranceDefined <em>Tolerance Defined</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tolerance Defined</em>' attribute.
	 * @see #isToleranceDefined()
	 * @generated
	 */
	void setToleranceDefined(boolean value);

	/**
	 * Returns the value of the '<em><b>Stop Time Defined</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop Time Defined</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop Time Defined</em>' attribute.
	 * @see #setStopTimeDefined(boolean)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getCS_Graph_StopTimeDefined()
	 * @model default="true" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isStopTimeDefined();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#isStopTimeDefined <em>Stop Time Defined</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop Time Defined</em>' attribute.
	 * @see #isStopTimeDefined()
	 * @generated
	 */
	void setStopTimeDefined(boolean value);

	/**
	 * Returns the value of the '<em><b>Compute Setup Experiments From Fmus</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compute Setup Experiments From Fmus</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compute Setup Experiments From Fmus</em>' attribute.
	 * @see #setComputeSetupExperimentsFromFmus(boolean)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getCS_Graph_ComputeSetupExperimentsFromFmus()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isComputeSetupExperimentsFromFmus();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#isComputeSetupExperimentsFromFmus <em>Compute Setup Experiments From Fmus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compute Setup Experiments From Fmus</em>' attribute.
	 * @see #isComputeSetupExperimentsFromFmus()
	 * @generated
	 */
	void setComputeSetupExperimentsFromFmus(boolean value);

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getCS_Graph_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // CS_Graph
