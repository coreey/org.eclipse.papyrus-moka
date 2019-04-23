/**
 * Copyright (c) 2016 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0 
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *   CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.xygraph.model.xygraph;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Trace Base Line</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTrace_BaseLine()
 * @model
 * @generated
 */
public enum Trace_BaseLine implements Enumerator {
	/**
	 * The '<em><b>NEGATIVE INFINITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEGATIVE_INFINITY_VALUE
	 * @generated
	 * @ordered
	 */
	NEGATIVE_INFINITY(0, "NEGATIVE_INFINITY", "NEGATIVE_INFINITY"),

	/**
	 * The '<em><b>ZERO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZERO_VALUE
	 * @generated
	 * @ordered
	 */
	ZERO(1, "ZERO", "ZERO"),

	/**
	 * The '<em><b>POSITIVE INFINITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POSITIVE_INFINITY_VALUE
	 * @generated
	 * @ordered
	 */
	POSITIVE_INFINITY(1, "POSITIVE_INFINITY", "POSITIVE_INFINITY");

	/**
	 * The '<em><b>NEGATIVE INFINITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEGATIVE INFINITY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEGATIVE_INFINITY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NEGATIVE_INFINITY_VALUE = 0;

	/**
	 * The '<em><b>ZERO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZERO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZERO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ZERO_VALUE = 1;

	/**
	 * The '<em><b>POSITIVE INFINITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>POSITIVE INFINITY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POSITIVE_INFINITY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POSITIVE_INFINITY_VALUE = 1;

	/**
	 * An array of all the '<em><b>Trace Base Line</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Trace_BaseLine[] VALUES_ARRAY =
		new Trace_BaseLine[] {
			NEGATIVE_INFINITY,
			ZERO,
			POSITIVE_INFINITY,
		};

	/**
	 * A public read-only list of all the '<em><b>Trace Base Line</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Trace_BaseLine> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Trace Base Line</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Trace_BaseLine get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Trace_BaseLine result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Trace Base Line</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Trace_BaseLine getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Trace_BaseLine result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Trace Base Line</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Trace_BaseLine get(int value) {
		switch (value) {
			case NEGATIVE_INFINITY_VALUE: return NEGATIVE_INFINITY;
			case ZERO_VALUE: return ZERO;
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
	private Trace_BaseLine(int value, String name, String literal) {
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
	
} //Trace_BaseLine
