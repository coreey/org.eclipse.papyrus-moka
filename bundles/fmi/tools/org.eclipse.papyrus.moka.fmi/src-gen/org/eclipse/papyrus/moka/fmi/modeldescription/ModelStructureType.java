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
 * A representation of the model object '<em><b>Model Structure Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType#getDerivatives <em>Derivatives</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType#getInitialUnknowns <em>Initial Unknowns</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getModelStructureType()
 * @model extendedMetaData="name='ModelStructure_._type' kind='elementOnly'"
 * @generated
 */
public interface ModelStructureType extends EObject {
	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Ordered list of all outputs. Exactly all variables with causality="output" must be in this list. The dependency definition holds for Continuous-Time and for Event Mode (ModelExchange) and for Communication Points (CoSimulation).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Outputs</em>' containment reference.
	 * @see #setOutputs(Fmi2VariableDependency)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getModelStructureType_Outputs()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Outputs' namespace='##targetNamespace'"
	 * @generated
	 */
	Fmi2VariableDependency getOutputs();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType#getOutputs <em>Outputs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outputs</em>' containment reference.
	 * @see #getOutputs()
	 * @generated
	 */
	void setOutputs(Fmi2VariableDependency value);

	/**
	 * Returns the value of the '<em><b>Derivatives</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Ordered list of all exposed state derivatives (and therefore implicitely associated continuous-time states). Exactly all state derivatives of a ModelExchange FMU must be in this list. A CoSimulation FMU need not expose its state derivatives. If a model has dynamic state selection, introduce dummy state variables. The dependency definition holds for Continuous-Time and for Event Mode (ModelExchange) and for Communication Points (CoSimulation).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Derivatives</em>' containment reference.
	 * @see #setDerivatives(Fmi2VariableDependency)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getModelStructureType_Derivatives()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Derivatives' namespace='##targetNamespace'"
	 * @generated
	 */
	Fmi2VariableDependency getDerivatives();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType#getDerivatives <em>Derivatives</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derivatives</em>' containment reference.
	 * @see #getDerivatives()
	 * @generated
	 */
	void setDerivatives(Fmi2VariableDependency value);

	/**
	 * Returns the value of the '<em><b>Initial Unknowns</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Ordered list of all exposed Unknowns in Initialization Mode. This list consists of all variables with (1) causality = "output" and (initial="approx" or calculated"), (2) causality = "calculatedParameter", and (3) all continuous-time states and all state derivatives (defined with element Derivatives from ModelStructure)with initial=("approx" or "calculated"). The resulting list is not allowed to have duplicates (e.g. if a state is also an output, it is included only once in the list). The Unknowns in this list must be ordered according to their ScalarVariable index (e.g. if for two variables A and B the  ScalarVariable index of A is less than the index of B, then A must appear before B in InitialUnknowns).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Initial Unknowns</em>' containment reference.
	 * @see #setInitialUnknowns(InitialUnknownsType)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getModelStructureType_InitialUnknowns()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='InitialUnknowns' namespace='##targetNamespace'"
	 * @generated
	 */
	InitialUnknownsType getInitialUnknowns();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType#getInitialUnknowns <em>Initial Unknowns</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Unknowns</em>' containment reference.
	 * @see #getInitialUnknowns()
	 * @generated
	 */
	void setInitialUnknowns(InitialUnknownsType value);

} // ModelStructureType
