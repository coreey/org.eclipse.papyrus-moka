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
 * A representation of the model object '<em><b>Fmi2 Scalar Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Properties of a scalar variable
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getReal <em>Real</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getInteger <em>Integer</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getBoolean <em>Boolean</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getString <em>String</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getEnumeration <em>Enumeration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#isCanHandleMultipleSetPerTimeInstant <em>Can Handle Multiple Set Per Time Instant</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getCausality <em>Causality</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getInitial <em>Initial</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getValueReference <em>Value Reference</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getVariability <em>Variability</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2ScalarVariable()
 * @model extendedMetaData="name='fmi2ScalarVariable' kind='elementOnly'"
 * @generated
 */
public interface Fmi2ScalarVariable extends EObject {
	/**
	 * Returns the value of the '<em><b>Real</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Real</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Real</em>' containment reference.
	 * @see #setReal(RealType)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2ScalarVariable_Real()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Real' namespace='##targetNamespace'"
	 * @generated
	 */
	RealType getReal();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getReal <em>Real</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Real</em>' containment reference.
	 * @see #getReal()
	 * @generated
	 */
	void setReal(RealType value);

	/**
	 * Returns the value of the '<em><b>Integer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Integer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Integer</em>' containment reference.
	 * @see #setInteger(IntegerType)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2ScalarVariable_Integer()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Integer' namespace='##targetNamespace'"
	 * @generated
	 */
	IntegerType getInteger();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getInteger <em>Integer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integer</em>' containment reference.
	 * @see #getInteger()
	 * @generated
	 */
	void setInteger(IntegerType value);

	/**
	 * Returns the value of the '<em><b>Boolean</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boolean</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boolean</em>' containment reference.
	 * @see #setBoolean(BooleanType)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2ScalarVariable_Boolean()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Boolean' namespace='##targetNamespace'"
	 * @generated
	 */
	BooleanType getBoolean();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getBoolean <em>Boolean</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boolean</em>' containment reference.
	 * @see #getBoolean()
	 * @generated
	 */
	void setBoolean(BooleanType value);

	/**
	 * Returns the value of the '<em><b>String</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String</em>' containment reference.
	 * @see #setString(StringType)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2ScalarVariable_String()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='String' namespace='##targetNamespace'"
	 * @generated
	 */
	StringType getString();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getString <em>String</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String</em>' containment reference.
	 * @see #getString()
	 * @generated
	 */
	void setString(StringType value);

	/**
	 * Returns the value of the '<em><b>Enumeration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration</em>' containment reference.
	 * @see #setEnumeration(EnumerationType)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2ScalarVariable_Enumeration()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Enumeration' namespace='##targetNamespace'"
	 * @generated
	 */
	EnumerationType getEnumeration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getEnumeration <em>Enumeration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumeration</em>' containment reference.
	 * @see #getEnumeration()
	 * @generated
	 */
	void setEnumeration(EnumerationType value);

	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Additional data of the scalar variable, e.g., for the dialog menu or the graphical layout
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference.
	 * @see #setAnnotations(Fmi2Annotation)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2ScalarVariable_Annotations()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Annotations' namespace='##targetNamespace'"
	 * @generated
	 */
	Fmi2Annotation getAnnotations();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getAnnotations <em>Annotations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotations</em>' containment reference.
	 * @see #getAnnotations()
	 * @generated
	 */
	void setAnnotations(Fmi2Annotation value);

	/**
	 * Returns the value of the '<em><b>Can Handle Multiple Set Per Time Instant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Only for ModelExchange and only for variables with variability = "input":
	 * If present with value = false, then only one fmi2SetXXX call is allowed at one super dense time instant. In other words, this input is not allowed to appear in an algebraic loop.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Can Handle Multiple Set Per Time Instant</em>' attribute.
	 * @see #isSetCanHandleMultipleSetPerTimeInstant()
	 * @see #unsetCanHandleMultipleSetPerTimeInstant()
	 * @see #setCanHandleMultipleSetPerTimeInstant(boolean)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2ScalarVariable_CanHandleMultipleSetPerTimeInstant()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='canHandleMultipleSetPerTimeInstant' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isCanHandleMultipleSetPerTimeInstant();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#isCanHandleMultipleSetPerTimeInstant <em>Can Handle Multiple Set Per Time Instant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Can Handle Multiple Set Per Time Instant</em>' attribute.
	 * @see #isSetCanHandleMultipleSetPerTimeInstant()
	 * @see #unsetCanHandleMultipleSetPerTimeInstant()
	 * @see #isCanHandleMultipleSetPerTimeInstant()
	 * @generated
	 */
	void setCanHandleMultipleSetPerTimeInstant(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#isCanHandleMultipleSetPerTimeInstant <em>Can Handle Multiple Set Per Time Instant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCanHandleMultipleSetPerTimeInstant()
	 * @see #isCanHandleMultipleSetPerTimeInstant()
	 * @see #setCanHandleMultipleSetPerTimeInstant(boolean)
	 * @generated
	 */
	void unsetCanHandleMultipleSetPerTimeInstant();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#isCanHandleMultipleSetPerTimeInstant <em>Can Handle Multiple Set Per Time Instant</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Can Handle Multiple Set Per Time Instant</em>' attribute is set.
	 * @see #unsetCanHandleMultipleSetPerTimeInstant()
	 * @see #isCanHandleMultipleSetPerTimeInstant()
	 * @see #setCanHandleMultipleSetPerTimeInstant(boolean)
	 * @generated
	 */
	boolean isSetCanHandleMultipleSetPerTimeInstant();

	/**
	 * Returns the value of the '<em><b>Causality</b></em>' attribute.
	 * The default value is <code>"local"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.moka.fmi.modeldescription.CausalityType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * parameter: independent parameter
	 * calculatedParameter: calculated parameter
	 * input/output: can be used in connections
	 * local: variable calculated from other variables
	 * independent: independent variable (usually time)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Causality</em>' attribute.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CausalityType
	 * @see #isSetCausality()
	 * @see #unsetCausality()
	 * @see #setCausality(CausalityType)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2ScalarVariable_Causality()
	 * @model default="local" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='causality' namespace='##targetNamespace'"
	 * @generated
	 */
	CausalityType getCausality();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getCausality <em>Causality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Causality</em>' attribute.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CausalityType
	 * @see #isSetCausality()
	 * @see #unsetCausality()
	 * @see #getCausality()
	 * @generated
	 */
	void setCausality(CausalityType value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getCausality <em>Causality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCausality()
	 * @see #getCausality()
	 * @see #setCausality(CausalityType)
	 * @generated
	 */
	void unsetCausality();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getCausality <em>Causality</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Causality</em>' attribute is set.
	 * @see #unsetCausality()
	 * @see #getCausality()
	 * @see #setCausality(CausalityType)
	 * @generated
	 */
	boolean isSetCausality();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2ScalarVariable_Description()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='description' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Initial</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.moka.fmi.modeldescription.InitialType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * exact: initialized with start value
	 * approx: iteration variable that starts with start value
	 * calculated: calculated from other variables.
	 * If not provided, initial is deduced from causality and variability (details see specification)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Initial</em>' attribute.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.InitialType
	 * @see #isSetInitial()
	 * @see #unsetInitial()
	 * @see #setInitial(InitialType)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2ScalarVariable_Initial()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='initial' namespace='##targetNamespace'"
	 * @generated
	 */
	InitialType getInitial();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getInitial <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial</em>' attribute.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.InitialType
	 * @see #isSetInitial()
	 * @see #unsetInitial()
	 * @see #getInitial()
	 * @generated
	 */
	void setInitial(InitialType value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getInitial <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInitial()
	 * @see #getInitial()
	 * @see #setInitial(InitialType)
	 * @generated
	 */
	void unsetInitial();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getInitial <em>Initial</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Initial</em>' attribute is set.
	 * @see #unsetInitial()
	 * @see #getInitial()
	 * @see #setInitial(InitialType)
	 * @generated
	 */
	boolean isSetInitial();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Identifier of variable, e.g. "a.b.mod[3,4].'#123'.c". "name" must be unique with respect to all other elements of the ModelVariables list
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2ScalarVariable_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NormalizedString" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Identifier for variable value in FMI2 function calls (not necessarily unique with respect to all variables)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value Reference</em>' attribute.
	 * @see #isSetValueReference()
	 * @see #unsetValueReference()
	 * @see #setValueReference(long)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2ScalarVariable_ValueReference()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedInt" required="true"
	 *        extendedMetaData="kind='attribute' name='valueReference' namespace='##targetNamespace'"
	 * @generated
	 */
	long getValueReference();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getValueReference <em>Value Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Reference</em>' attribute.
	 * @see #isSetValueReference()
	 * @see #unsetValueReference()
	 * @see #getValueReference()
	 * @generated
	 */
	void setValueReference(long value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getValueReference <em>Value Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetValueReference()
	 * @see #getValueReference()
	 * @see #setValueReference(long)
	 * @generated
	 */
	void unsetValueReference();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getValueReference <em>Value Reference</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Value Reference</em>' attribute is set.
	 * @see #unsetValueReference()
	 * @see #getValueReference()
	 * @see #setValueReference(long)
	 * @generated
	 */
	boolean isSetValueReference();

	/**
	 * Returns the value of the '<em><b>Variability</b></em>' attribute.
	 * The default value is <code>"continuous"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.moka.fmi.modeldescription.VariabilityType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * constant: value never changes
	 * fixed: value fixed after initialization
	 * tunable: value constant between external events
	 * discrete: value constant between internal events
	 * continuous: no restriction on value changes
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variability</em>' attribute.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.VariabilityType
	 * @see #isSetVariability()
	 * @see #unsetVariability()
	 * @see #setVariability(VariabilityType)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2ScalarVariable_Variability()
	 * @model default="continuous" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='variability' namespace='##targetNamespace'"
	 * @generated
	 */
	VariabilityType getVariability();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getVariability <em>Variability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variability</em>' attribute.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.VariabilityType
	 * @see #isSetVariability()
	 * @see #unsetVariability()
	 * @see #getVariability()
	 * @generated
	 */
	void setVariability(VariabilityType value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getVariability <em>Variability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVariability()
	 * @see #getVariability()
	 * @see #setVariability(VariabilityType)
	 * @generated
	 */
	void unsetVariability();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getVariability <em>Variability</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Variability</em>' attribute is set.
	 * @see #unsetVariability()
	 * @see #getVariability()
	 * @see #setVariability(VariabilityType)
	 * @generated
	 */
	boolean isSetVariability();

} // Fmi2ScalarVariable
