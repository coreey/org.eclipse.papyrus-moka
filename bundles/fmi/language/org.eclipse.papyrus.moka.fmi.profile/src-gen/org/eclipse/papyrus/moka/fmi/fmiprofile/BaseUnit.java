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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Base Unit</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getBaseUnit()
 * @model
 * @generated
 */
public enum BaseUnit implements Enumerator {
	/**
	 * The '<em><b>A</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A_VALUE
	 * @generated
	 * @ordered
	 */
	A(0, "a", "a"),

	/**
	 * The '<em><b>Cd</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CD_VALUE
	 * @generated
	 * @ordered
	 */
	CD(1, "cd", "cd"),

	/**
	 * The '<em><b>Factor</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FACTOR_VALUE
	 * @generated
	 * @ordered
	 */
	FACTOR(2, "factor", "factor"),

	/**
	 * The '<em><b>K</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #K_VALUE
	 * @generated
	 * @ordered
	 */
	K(3, "k", "k"),

	/**
	 * The '<em><b>Kg</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KG_VALUE
	 * @generated
	 * @ordered
	 */
	KG(4, "kg", "kg"),

	/**
	 * The '<em><b>M</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #M_VALUE
	 * @generated
	 * @ordered
	 */
	M(5, "m", "m"),

	/**
	 * The '<em><b>Mol</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOL_VALUE
	 * @generated
	 * @ordered
	 */
	MOL(6, "mol", "mol"),

	/**
	 * The '<em><b>Offset</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OFFSET_VALUE
	 * @generated
	 * @ordered
	 */
	OFFSET(7, "offset", "offset"),

	/**
	 * The '<em><b>Rad</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAD_VALUE
	 * @generated
	 * @ordered
	 */
	RAD(8, "rad", "rad"),

	/**
	 * The '<em><b>S</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #S_VALUE
	 * @generated
	 * @ordered
	 */
	S(9, "s", "s");

	/**
	 * The '<em><b>A</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>A</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #A
	 * @model name="a"
	 * @generated
	 * @ordered
	 */
	public static final int A_VALUE = 0;

	/**
	 * The '<em><b>Cd</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cd</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CD
	 * @model name="cd"
	 * @generated
	 * @ordered
	 */
	public static final int CD_VALUE = 1;

	/**
	 * The '<em><b>Factor</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Factor</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FACTOR
	 * @model name="factor"
	 * @generated
	 * @ordered
	 */
	public static final int FACTOR_VALUE = 2;

	/**
	 * The '<em><b>K</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>K</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #K
	 * @model name="k"
	 * @generated
	 * @ordered
	 */
	public static final int K_VALUE = 3;

	/**
	 * The '<em><b>Kg</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Kg</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KG
	 * @model name="kg"
	 * @generated
	 * @ordered
	 */
	public static final int KG_VALUE = 4;

	/**
	 * The '<em><b>M</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>M</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #M
	 * @model name="m"
	 * @generated
	 * @ordered
	 */
	public static final int M_VALUE = 5;

	/**
	 * The '<em><b>Mol</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mol</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOL
	 * @model name="mol"
	 * @generated
	 * @ordered
	 */
	public static final int MOL_VALUE = 6;

	/**
	 * The '<em><b>Offset</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Offset</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OFFSET
	 * @model name="offset"
	 * @generated
	 * @ordered
	 */
	public static final int OFFSET_VALUE = 7;

	/**
	 * The '<em><b>Rad</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Rad</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RAD
	 * @model name="rad"
	 * @generated
	 * @ordered
	 */
	public static final int RAD_VALUE = 8;

	/**
	 * The '<em><b>S</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>S</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #S
	 * @model name="s"
	 * @generated
	 * @ordered
	 */
	public static final int S_VALUE = 9;

	/**
	 * An array of all the '<em><b>Base Unit</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final BaseUnit[] VALUES_ARRAY =
		new BaseUnit[] {
			A,
			CD,
			FACTOR,
			K,
			KG,
			M,
			MOL,
			OFFSET,
			RAD,
			S,
		};

	/**
	 * A public read-only list of all the '<em><b>Base Unit</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<BaseUnit> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Base Unit</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BaseUnit get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BaseUnit result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Base Unit</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BaseUnit getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BaseUnit result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Base Unit</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BaseUnit get(int value) {
		switch (value) {
			case A_VALUE: return A;
			case CD_VALUE: return CD;
			case FACTOR_VALUE: return FACTOR;
			case K_VALUE: return K;
			case KG_VALUE: return KG;
			case M_VALUE: return M;
			case MOL_VALUE: return MOL;
			case OFFSET_VALUE: return OFFSET;
			case RAD_VALUE: return RAD;
			case S_VALUE: return S;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private BaseUnit(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //BaseUnit
