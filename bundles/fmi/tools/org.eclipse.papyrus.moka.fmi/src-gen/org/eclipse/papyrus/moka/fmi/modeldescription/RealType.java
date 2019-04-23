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
 * A representation of the model object '<em><b>Real Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getDeclaredType <em>Declared Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getDerivative <em>Derivative</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getDisplayUnit <em>Display Unit</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getMax <em>Max</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getMin <em>Min</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getNominal <em>Nominal</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#isReinit <em>Reinit</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#isRelativeQuantity <em>Relative Quantity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#isUnbounded <em>Unbounded</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getRealType()
 * @model extendedMetaData="name='Real_._type' kind='empty'"
 * @generated
 */
public interface RealType extends EObject {
	/**
	 * Returns the value of the '<em><b>Declared Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If present, name of type defined with TypeDefinitions / SimpleType providing defaults.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Declared Type</em>' attribute.
	 * @see #setDeclaredType(String)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getRealType_DeclaredType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NormalizedString"
	 *        extendedMetaData="kind='attribute' name='declaredType' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDeclaredType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getDeclaredType <em>Declared Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declared Type</em>' attribute.
	 * @see #getDeclaredType()
	 * @generated
	 */
	void setDeclaredType(String value);

	/**
	 * Returns the value of the '<em><b>Derivative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If present, this variable is the derivative of variable with ScalarVariable index "derivative".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Derivative</em>' attribute.
	 * @see #isSetDerivative()
	 * @see #unsetDerivative()
	 * @see #setDerivative(long)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getRealType_Derivative()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedInt"
	 *        extendedMetaData="kind='attribute' name='derivative' namespace='##targetNamespace'"
	 * @generated
	 */
	long getDerivative();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getDerivative <em>Derivative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derivative</em>' attribute.
	 * @see #isSetDerivative()
	 * @see #unsetDerivative()
	 * @see #getDerivative()
	 * @generated
	 */
	void setDerivative(long value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getDerivative <em>Derivative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDerivative()
	 * @see #getDerivative()
	 * @see #setDerivative(long)
	 * @generated
	 */
	void unsetDerivative();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getDerivative <em>Derivative</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Derivative</em>' attribute is set.
	 * @see #unsetDerivative()
	 * @see #getDerivative()
	 * @see #setDerivative(long)
	 * @generated
	 */
	boolean isSetDerivative();

	/**
	 * Returns the value of the '<em><b>Display Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Default display unit, provided the conversion of values in "unit" to values in "displayUnit" is defined in UnitDefinitions / Unit / DisplayUnit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Display Unit</em>' attribute.
	 * @see #setDisplayUnit(String)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getRealType_DisplayUnit()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NormalizedString"
	 *        extendedMetaData="kind='attribute' name='displayUnit' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDisplayUnit();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getDisplayUnit <em>Display Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Unit</em>' attribute.
	 * @see #getDisplayUnit()
	 * @generated
	 */
	void setDisplayUnit(String value);

	/**
	 * Returns the value of the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * max >= min required
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max</em>' attribute.
	 * @see #isSetMax()
	 * @see #unsetMax()
	 * @see #setMax(double)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getRealType_Max()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='max' namespace='##targetNamespace'"
	 * @generated
	 */
	double getMax();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getMax <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max</em>' attribute.
	 * @see #isSetMax()
	 * @see #unsetMax()
	 * @see #getMax()
	 * @generated
	 */
	void setMax(double value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getMax <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMax()
	 * @see #getMax()
	 * @see #setMax(double)
	 * @generated
	 */
	void unsetMax();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getMax <em>Max</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max</em>' attribute is set.
	 * @see #unsetMax()
	 * @see #getMax()
	 * @see #setMax(double)
	 * @generated
	 */
	boolean isSetMax();

	/**
	 * Returns the value of the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min</em>' attribute.
	 * @see #isSetMin()
	 * @see #unsetMin()
	 * @see #setMin(double)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getRealType_Min()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='min' namespace='##targetNamespace'"
	 * @generated
	 */
	double getMin();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getMin <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min</em>' attribute.
	 * @see #isSetMin()
	 * @see #unsetMin()
	 * @see #getMin()
	 * @generated
	 */
	void setMin(double value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getMin <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMin()
	 * @see #getMin()
	 * @see #setMin(double)
	 * @generated
	 */
	void unsetMin();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getMin <em>Min</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Min</em>' attribute is set.
	 * @see #unsetMin()
	 * @see #getMin()
	 * @see #setMin(double)
	 * @generated
	 */
	boolean isSetMin();

	/**
	 * Returns the value of the '<em><b>Nominal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * nominal > 0.0 required
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nominal</em>' attribute.
	 * @see #isSetNominal()
	 * @see #unsetNominal()
	 * @see #setNominal(double)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getRealType_Nominal()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='nominal' namespace='##targetNamespace'"
	 * @generated
	 */
	double getNominal();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getNominal <em>Nominal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal</em>' attribute.
	 * @see #isSetNominal()
	 * @see #unsetNominal()
	 * @see #getNominal()
	 * @generated
	 */
	void setNominal(double value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getNominal <em>Nominal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNominal()
	 * @see #getNominal()
	 * @see #setNominal(double)
	 * @generated
	 */
	void unsetNominal();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getNominal <em>Nominal</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Nominal</em>' attribute is set.
	 * @see #unsetNominal()
	 * @see #getNominal()
	 * @see #setNominal(double)
	 * @generated
	 */
	boolean isSetNominal();

	/**
	 * Returns the value of the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quantity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quantity</em>' attribute.
	 * @see #setQuantity(String)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getRealType_Quantity()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NormalizedString"
	 *        extendedMetaData="kind='attribute' name='quantity' namespace='##targetNamespace'"
	 * @generated
	 */
	String getQuantity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getQuantity <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantity</em>' attribute.
	 * @see #getQuantity()
	 * @generated
	 */
	void setQuantity(String value);

	/**
	 * Returns the value of the '<em><b>Reinit</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Only for ModelExchange and if variable is a continuous-time state:
	 * If true, state can be reinitialized at an event by the FMU
	 * If false, state will never be reinitialized at an event by the FMU
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reinit</em>' attribute.
	 * @see #isSetReinit()
	 * @see #unsetReinit()
	 * @see #setReinit(boolean)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getRealType_Reinit()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='reinit' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isReinit();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#isReinit <em>Reinit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reinit</em>' attribute.
	 * @see #isSetReinit()
	 * @see #unsetReinit()
	 * @see #isReinit()
	 * @generated
	 */
	void setReinit(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#isReinit <em>Reinit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReinit()
	 * @see #isReinit()
	 * @see #setReinit(boolean)
	 * @generated
	 */
	void unsetReinit();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#isReinit <em>Reinit</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reinit</em>' attribute is set.
	 * @see #unsetReinit()
	 * @see #isReinit()
	 * @see #setReinit(boolean)
	 * @generated
	 */
	boolean isSetReinit();

	/**
	 * Returns the value of the '<em><b>Relative Quantity</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If relativeQuantity=true, offset for displayUnit must be ignored.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Relative Quantity</em>' attribute.
	 * @see #isSetRelativeQuantity()
	 * @see #unsetRelativeQuantity()
	 * @see #setRelativeQuantity(boolean)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getRealType_RelativeQuantity()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='relativeQuantity' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isRelativeQuantity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#isRelativeQuantity <em>Relative Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relative Quantity</em>' attribute.
	 * @see #isSetRelativeQuantity()
	 * @see #unsetRelativeQuantity()
	 * @see #isRelativeQuantity()
	 * @generated
	 */
	void setRelativeQuantity(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#isRelativeQuantity <em>Relative Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelativeQuantity()
	 * @see #isRelativeQuantity()
	 * @see #setRelativeQuantity(boolean)
	 * @generated
	 */
	void unsetRelativeQuantity();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#isRelativeQuantity <em>Relative Quantity</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relative Quantity</em>' attribute is set.
	 * @see #unsetRelativeQuantity()
	 * @see #isRelativeQuantity()
	 * @see #setRelativeQuantity(boolean)
	 * @generated
	 */
	boolean isSetRelativeQuantity();

	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Value before initialization, if initial=exact or approx.
	 * max >= start >= min required
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #isSetStart()
	 * @see #unsetStart()
	 * @see #setStart(double)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getRealType_Start()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='start' namespace='##targetNamespace'"
	 * @generated
	 */
	double getStart();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #isSetStart()
	 * @see #unsetStart()
	 * @see #getStart()
	 * @generated
	 */
	void setStart(double value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStart()
	 * @see #getStart()
	 * @see #setStart(double)
	 * @generated
	 */
	void unsetStart();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getStart <em>Start</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Start</em>' attribute is set.
	 * @see #unsetStart()
	 * @see #getStart()
	 * @see #setStart(double)
	 * @generated
	 */
	boolean isSetStart();

	/**
	 * Returns the value of the '<em><b>Unbounded</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Set to true, e.g., for crank angle. If true and variable is a state, relative tolerance should be zero on this variable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unbounded</em>' attribute.
	 * @see #isSetUnbounded()
	 * @see #unsetUnbounded()
	 * @see #setUnbounded(boolean)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getRealType_Unbounded()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='unbounded' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isUnbounded();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#isUnbounded <em>Unbounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unbounded</em>' attribute.
	 * @see #isSetUnbounded()
	 * @see #unsetUnbounded()
	 * @see #isUnbounded()
	 * @generated
	 */
	void setUnbounded(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#isUnbounded <em>Unbounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnbounded()
	 * @see #isUnbounded()
	 * @see #setUnbounded(boolean)
	 * @generated
	 */
	void unsetUnbounded();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#isUnbounded <em>Unbounded</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unbounded</em>' attribute is set.
	 * @see #unsetUnbounded()
	 * @see #isUnbounded()
	 * @see #setUnbounded(boolean)
	 * @generated
	 */
	boolean isSetUnbounded();

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see #setUnit(String)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getRealType_Unit()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NormalizedString"
	 *        extendedMetaData="kind='attribute' name='unit' namespace='##targetNamespace'"
	 * @generated
	 */
	String getUnit();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(String value);

} // RealType
