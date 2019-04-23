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
 * A representation of the model object '<em><b>Base Unit Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getA <em>A</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getCd <em>Cd</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getFactor <em>Factor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getK <em>K</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getKg <em>Kg</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getM <em>M</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getMol <em>Mol</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getRad <em>Rad</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getS <em>S</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getBaseUnitType()
 * @model extendedMetaData="name='BaseUnit_._type' kind='empty'"
 * @generated
 */
public interface BaseUnitType extends EObject {
	/**
	 * Returns the value of the '<em><b>A</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Exponent of SI base unit "A"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>A</em>' attribute.
	 * @see #isSetA()
	 * @see #unsetA()
	 * @see #setA(int)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getBaseUnitType_A()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='A' namespace='##targetNamespace'"
	 * @generated
	 */
	int getA();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getA <em>A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>A</em>' attribute.
	 * @see #isSetA()
	 * @see #unsetA()
	 * @see #getA()
	 * @generated
	 */
	void setA(int value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getA <em>A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetA()
	 * @see #getA()
	 * @see #setA(int)
	 * @generated
	 */
	void unsetA();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getA <em>A</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>A</em>' attribute is set.
	 * @see #unsetA()
	 * @see #getA()
	 * @see #setA(int)
	 * @generated
	 */
	boolean isSetA();

	/**
	 * Returns the value of the '<em><b>Cd</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Exponent of SI base unit "cd"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cd</em>' attribute.
	 * @see #isSetCd()
	 * @see #unsetCd()
	 * @see #setCd(int)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getBaseUnitType_Cd()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='cd' namespace='##targetNamespace'"
	 * @generated
	 */
	int getCd();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getCd <em>Cd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cd</em>' attribute.
	 * @see #isSetCd()
	 * @see #unsetCd()
	 * @see #getCd()
	 * @generated
	 */
	void setCd(int value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getCd <em>Cd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCd()
	 * @see #getCd()
	 * @see #setCd(int)
	 * @generated
	 */
	void unsetCd();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getCd <em>Cd</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cd</em>' attribute is set.
	 * @see #unsetCd()
	 * @see #getCd()
	 * @see #setCd(int)
	 * @generated
	 */
	boolean isSetCd();

	/**
	 * Returns the value of the '<em><b>Factor</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factor</em>' attribute.
	 * @see #isSetFactor()
	 * @see #unsetFactor()
	 * @see #setFactor(double)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getBaseUnitType_Factor()
	 * @model default="1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='factor' namespace='##targetNamespace'"
	 * @generated
	 */
	double getFactor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getFactor <em>Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factor</em>' attribute.
	 * @see #isSetFactor()
	 * @see #unsetFactor()
	 * @see #getFactor()
	 * @generated
	 */
	void setFactor(double value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getFactor <em>Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFactor()
	 * @see #getFactor()
	 * @see #setFactor(double)
	 * @generated
	 */
	void unsetFactor();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getFactor <em>Factor</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Factor</em>' attribute is set.
	 * @see #unsetFactor()
	 * @see #getFactor()
	 * @see #setFactor(double)
	 * @generated
	 */
	boolean isSetFactor();

	/**
	 * Returns the value of the '<em><b>K</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Exponent of SI base unit "K"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>K</em>' attribute.
	 * @see #isSetK()
	 * @see #unsetK()
	 * @see #setK(int)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getBaseUnitType_K()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='K' namespace='##targetNamespace'"
	 * @generated
	 */
	int getK();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getK <em>K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>K</em>' attribute.
	 * @see #isSetK()
	 * @see #unsetK()
	 * @see #getK()
	 * @generated
	 */
	void setK(int value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getK <em>K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetK()
	 * @see #getK()
	 * @see #setK(int)
	 * @generated
	 */
	void unsetK();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getK <em>K</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>K</em>' attribute is set.
	 * @see #unsetK()
	 * @see #getK()
	 * @see #setK(int)
	 * @generated
	 */
	boolean isSetK();

	/**
	 * Returns the value of the '<em><b>Kg</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Exponent of SI base unit "kg"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kg</em>' attribute.
	 * @see #isSetKg()
	 * @see #unsetKg()
	 * @see #setKg(int)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getBaseUnitType_Kg()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='kg' namespace='##targetNamespace'"
	 * @generated
	 */
	int getKg();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getKg <em>Kg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kg</em>' attribute.
	 * @see #isSetKg()
	 * @see #unsetKg()
	 * @see #getKg()
	 * @generated
	 */
	void setKg(int value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getKg <em>Kg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetKg()
	 * @see #getKg()
	 * @see #setKg(int)
	 * @generated
	 */
	void unsetKg();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getKg <em>Kg</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Kg</em>' attribute is set.
	 * @see #unsetKg()
	 * @see #getKg()
	 * @see #setKg(int)
	 * @generated
	 */
	boolean isSetKg();

	/**
	 * Returns the value of the '<em><b>M</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Exponent of SI base unit "m"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>M</em>' attribute.
	 * @see #isSetM()
	 * @see #unsetM()
	 * @see #setM(int)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getBaseUnitType_M()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='m' namespace='##targetNamespace'"
	 * @generated
	 */
	int getM();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getM <em>M</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>M</em>' attribute.
	 * @see #isSetM()
	 * @see #unsetM()
	 * @see #getM()
	 * @generated
	 */
	void setM(int value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getM <em>M</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetM()
	 * @see #getM()
	 * @see #setM(int)
	 * @generated
	 */
	void unsetM();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getM <em>M</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>M</em>' attribute is set.
	 * @see #unsetM()
	 * @see #getM()
	 * @see #setM(int)
	 * @generated
	 */
	boolean isSetM();

	/**
	 * Returns the value of the '<em><b>Mol</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Exponent of SI base unit "mol"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mol</em>' attribute.
	 * @see #isSetMol()
	 * @see #unsetMol()
	 * @see #setMol(int)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getBaseUnitType_Mol()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='mol' namespace='##targetNamespace'"
	 * @generated
	 */
	int getMol();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getMol <em>Mol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mol</em>' attribute.
	 * @see #isSetMol()
	 * @see #unsetMol()
	 * @see #getMol()
	 * @generated
	 */
	void setMol(int value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getMol <em>Mol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMol()
	 * @see #getMol()
	 * @see #setMol(int)
	 * @generated
	 */
	void unsetMol();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getMol <em>Mol</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mol</em>' attribute is set.
	 * @see #unsetMol()
	 * @see #getMol()
	 * @see #setMol(int)
	 * @generated
	 */
	boolean isSetMol();

	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #isSetOffset()
	 * @see #unsetOffset()
	 * @see #setOffset(double)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getBaseUnitType_Offset()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='offset' namespace='##targetNamespace'"
	 * @generated
	 */
	double getOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #isSetOffset()
	 * @see #unsetOffset()
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(double value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOffset()
	 * @see #getOffset()
	 * @see #setOffset(double)
	 * @generated
	 */
	void unsetOffset();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getOffset <em>Offset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Offset</em>' attribute is set.
	 * @see #unsetOffset()
	 * @see #getOffset()
	 * @see #setOffset(double)
	 * @generated
	 */
	boolean isSetOffset();

	/**
	 * Returns the value of the '<em><b>Rad</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Exponent of SI derived unit "rad"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rad</em>' attribute.
	 * @see #isSetRad()
	 * @see #unsetRad()
	 * @see #setRad(int)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getBaseUnitType_Rad()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='rad' namespace='##targetNamespace'"
	 * @generated
	 */
	int getRad();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getRad <em>Rad</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rad</em>' attribute.
	 * @see #isSetRad()
	 * @see #unsetRad()
	 * @see #getRad()
	 * @generated
	 */
	void setRad(int value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getRad <em>Rad</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRad()
	 * @see #getRad()
	 * @see #setRad(int)
	 * @generated
	 */
	void unsetRad();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getRad <em>Rad</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rad</em>' attribute is set.
	 * @see #unsetRad()
	 * @see #getRad()
	 * @see #setRad(int)
	 * @generated
	 */
	boolean isSetRad();

	/**
	 * Returns the value of the '<em><b>S</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Exponent of SI base unit "s"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>S</em>' attribute.
	 * @see #isSetS()
	 * @see #unsetS()
	 * @see #setS(int)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getBaseUnitType_S()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='s' namespace='##targetNamespace'"
	 * @generated
	 */
	int getS();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getS <em>S</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>S</em>' attribute.
	 * @see #isSetS()
	 * @see #unsetS()
	 * @see #getS()
	 * @generated
	 */
	void setS(int value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getS <em>S</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetS()
	 * @see #getS()
	 * @see #setS(int)
	 * @generated
	 */
	void unsetS();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getS <em>S</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>S</em>' attribute is set.
	 * @see #unsetS()
	 * @see #getS()
	 * @see #setS(int)
	 * @generated
	 */
	boolean isSetS();

} // BaseUnitType
