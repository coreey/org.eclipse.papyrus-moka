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
 * A representation of the literals of the enumeration '<em><b>Trace Point Style</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTrace_PointStyle()
 * @model
 * @generated
 */
public enum Trace_PointStyle implements Enumerator {
	/**
	 * The '<em><b>NONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE_VALUE
	 * @generated
	 * @ordered
	 */
	NONE(0, "NONE", "NONE"),

	/**
	 * The '<em><b>POINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POINT_VALUE
	 * @generated
	 * @ordered
	 */
	POINT(1, "POINT", "POINT"),

	/**
	 * The '<em><b>CIRCLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CIRCLE_VALUE
	 * @generated
	 * @ordered
	 */
	CIRCLE(2, "CIRCLE", "CIRCLE"),

	/**
	 * The '<em><b>TRIANGLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIANGLE_VALUE
	 * @generated
	 * @ordered
	 */
	TRIANGLE(3, "TRIANGLE", "TRIANGLE"),

	/**
	 * The '<em><b>FILLED TRIANGLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILLED_TRIANGLE_VALUE
	 * @generated
	 * @ordered
	 */
	FILLED_TRIANGLE(4, "FILLED_TRIANGLE", "FILLED_TRIANGLE"),

	/**
	 * The '<em><b>SQUARE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SQUARE_VALUE
	 * @generated
	 * @ordered
	 */
	SQUARE(5, "SQUARE", "SQUARE"),

	/**
	 * The '<em><b>FILLED SQUARE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILLED_SQUARE_VALUE
	 * @generated
	 * @ordered
	 */
	FILLED_SQUARE(6, "FILLED_SQUARE", "FILLED_SQUARE"),

	/**
	 * The '<em><b>DIAMOND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIAMOND_VALUE
	 * @generated
	 * @ordered
	 */
	DIAMOND(7, "DIAMOND", "DIAMOND"),

	/**
	 * The '<em><b>FILLED DIAMOND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILLED_DIAMOND_VALUE
	 * @generated
	 * @ordered
	 */
	FILLED_DIAMOND(8, "FILLED_DIAMOND", "FILLED_DIAMOND"),

	/**
	 * The '<em><b>XCROSS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XCROSS_VALUE
	 * @generated
	 * @ordered
	 */
	XCROSS(9, "XCROSS", "XCROSS"),

	/**
	 * The '<em><b>CROSS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CROSS_VALUE
	 * @generated
	 * @ordered
	 */
	CROSS(10, "CROSS", "CROSS"),

	/**
	 * The '<em><b>BAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BAR_VALUE
	 * @generated
	 * @ordered
	 */
	BAR(11, "BAR", "BAR");

	/**
	 * The '<em><b>NONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NONE_VALUE = 0;

	/**
	 * The '<em><b>POINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>POINT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POINT_VALUE = 1;

	/**
	 * The '<em><b>CIRCLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CIRCLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CIRCLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CIRCLE_VALUE = 2;

	/**
	 * The '<em><b>TRIANGLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRIANGLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRIANGLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRIANGLE_VALUE = 3;

	/**
	 * The '<em><b>FILLED TRIANGLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FILLED TRIANGLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILLED_TRIANGLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FILLED_TRIANGLE_VALUE = 4;

	/**
	 * The '<em><b>SQUARE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SQUARE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SQUARE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SQUARE_VALUE = 5;

	/**
	 * The '<em><b>FILLED SQUARE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FILLED SQUARE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILLED_SQUARE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FILLED_SQUARE_VALUE = 6;

	/**
	 * The '<em><b>DIAMOND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIAMOND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIAMOND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIAMOND_VALUE = 7;

	/**
	 * The '<em><b>FILLED DIAMOND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FILLED DIAMOND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILLED_DIAMOND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FILLED_DIAMOND_VALUE = 8;

	/**
	 * The '<em><b>XCROSS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>XCROSS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #XCROSS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int XCROSS_VALUE = 9;

	/**
	 * The '<em><b>CROSS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CROSS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CROSS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CROSS_VALUE = 10;

	/**
	 * The '<em><b>BAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BAR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BAR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BAR_VALUE = 11;

	/**
	 * An array of all the '<em><b>Trace Point Style</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Trace_PointStyle[] VALUES_ARRAY =
		new Trace_PointStyle[] {
			NONE,
			POINT,
			CIRCLE,
			TRIANGLE,
			FILLED_TRIANGLE,
			SQUARE,
			FILLED_SQUARE,
			DIAMOND,
			FILLED_DIAMOND,
			XCROSS,
			CROSS,
			BAR,
		};

	/**
	 * A public read-only list of all the '<em><b>Trace Point Style</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Trace_PointStyle> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Trace Point Style</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Trace_PointStyle get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Trace_PointStyle result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Trace Point Style</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Trace_PointStyle getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Trace_PointStyle result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Trace Point Style</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Trace_PointStyle get(int value) {
		switch (value) {
			case NONE_VALUE: return NONE;
			case POINT_VALUE: return POINT;
			case CIRCLE_VALUE: return CIRCLE;
			case TRIANGLE_VALUE: return TRIANGLE;
			case FILLED_TRIANGLE_VALUE: return FILLED_TRIANGLE;
			case SQUARE_VALUE: return SQUARE;
			case FILLED_SQUARE_VALUE: return FILLED_SQUARE;
			case DIAMOND_VALUE: return DIAMOND;
			case FILLED_DIAMOND_VALUE: return FILLED_DIAMOND;
			case XCROSS_VALUE: return XCROSS;
			case CROSS_VALUE: return CROSS;
			case BAR_VALUE: return BAR;
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
	private Trace_PointStyle(int value, String name, String literal) {
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
	
} //Trace_PointStyle
