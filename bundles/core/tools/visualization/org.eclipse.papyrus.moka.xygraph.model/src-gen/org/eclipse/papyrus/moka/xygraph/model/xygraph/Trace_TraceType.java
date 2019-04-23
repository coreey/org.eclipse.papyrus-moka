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
 * A representation of the literals of the enumeration '<em><b>Trace Trace Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTrace_TraceType()
 * @model
 * @generated
 */
public enum Trace_TraceType implements Enumerator {
	/**
	 * The '<em><b>SOLID LINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOLID_LINE_VALUE
	 * @generated
	 * @ordered
	 */
	SOLID_LINE(0, "SOLID_LINE", "SOLID_LINE"),

	/**
	 * The '<em><b>DASH LINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DASH_LINE_VALUE
	 * @generated
	 * @ordered
	 */
	DASH_LINE(1, "DASH_LINE", "DASH_LINE"),

	/**
	 * The '<em><b>POINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POINT_VALUE
	 * @generated
	 * @ordered
	 */
	POINT(2, "POINT", "POINT"),

	/**
	 * The '<em><b>BAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BAR_VALUE
	 * @generated
	 * @ordered
	 */
	BAR(3, "BAR", "BAR"),

	/**
	 * The '<em><b>AREA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AREA_VALUE
	 * @generated
	 * @ordered
	 */
	AREA(4, "AREA", "AREA"),

	/**
	 * The '<em><b>LINE AREA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINE_AREA_VALUE
	 * @generated
	 * @ordered
	 */
	LINE_AREA(5, "LINE_AREA", "LINE_AREA"),

	/**
	 * The '<em><b>STEP VERTICALLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEP_VERTICALLY_VALUE
	 * @generated
	 * @ordered
	 */
	STEP_VERTICALLY(6, "STEP_VERTICALLY", "STEP_VERTICALLY"),

	/**
	 * The '<em><b>STEP HORIZONTALLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEP_HORIZONTALLY_VALUE
	 * @generated
	 * @ordered
	 */
	STEP_HORIZONTALLY(7, "STEP_HORIZONTALLY", "STEP_HORIZONTALLY"),

	/**
	 * The '<em><b>DASHDOT LINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DASHDOT_LINE_VALUE
	 * @generated
	 * @ordered
	 */
	DASHDOT_LINE(8, "DASHDOT_LINE", "DASHDOT_LINE"),

	/**
	 * The '<em><b>DASHDOTDOT LINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DASHDOTDOT_LINE_VALUE
	 * @generated
	 * @ordered
	 */
	DASHDOTDOT_LINE(9, "DASHDOTDOT_LINE", "DASHDOTDOT_LINE"),

	/**
	 * The '<em><b>DOT LINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOT_LINE_VALUE
	 * @generated
	 * @ordered
	 */
	DOT_LINE(10, "DOT_LINE", "DOT_LINE");

	/**
	 * The '<em><b>SOLID LINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOLID LINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOLID_LINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOLID_LINE_VALUE = 0;

	/**
	 * The '<em><b>DASH LINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DASH LINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DASH_LINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DASH_LINE_VALUE = 1;

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
	public static final int POINT_VALUE = 2;

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
	public static final int BAR_VALUE = 3;

	/**
	 * The '<em><b>AREA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AREA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AREA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AREA_VALUE = 4;

	/**
	 * The '<em><b>LINE AREA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LINE AREA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LINE_AREA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINE_AREA_VALUE = 5;

	/**
	 * The '<em><b>STEP VERTICALLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STEP VERTICALLY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEP_VERTICALLY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STEP_VERTICALLY_VALUE = 6;

	/**
	 * The '<em><b>STEP HORIZONTALLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STEP HORIZONTALLY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEP_HORIZONTALLY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STEP_HORIZONTALLY_VALUE = 7;

	/**
	 * The '<em><b>DASHDOT LINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DASHDOT LINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DASHDOT_LINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DASHDOT_LINE_VALUE = 8;

	/**
	 * The '<em><b>DASHDOTDOT LINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DASHDOTDOT LINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DASHDOTDOT_LINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DASHDOTDOT_LINE_VALUE = 9;

	/**
	 * The '<em><b>DOT LINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOT LINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOT_LINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOT_LINE_VALUE = 10;

	/**
	 * An array of all the '<em><b>Trace Trace Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Trace_TraceType[] VALUES_ARRAY =
		new Trace_TraceType[] {
			SOLID_LINE,
			DASH_LINE,
			POINT,
			BAR,
			AREA,
			LINE_AREA,
			STEP_VERTICALLY,
			STEP_HORIZONTALLY,
			DASHDOT_LINE,
			DASHDOTDOT_LINE,
			DOT_LINE,
		};

	/**
	 * A public read-only list of all the '<em><b>Trace Trace Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Trace_TraceType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Trace Trace Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Trace_TraceType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Trace_TraceType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Trace Trace Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Trace_TraceType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Trace_TraceType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Trace Trace Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Trace_TraceType get(int value) {
		switch (value) {
			case SOLID_LINE_VALUE: return SOLID_LINE;
			case DASH_LINE_VALUE: return DASH_LINE;
			case POINT_VALUE: return POINT;
			case BAR_VALUE: return BAR;
			case AREA_VALUE: return AREA;
			case LINE_AREA_VALUE: return LINE_AREA;
			case STEP_VERTICALLY_VALUE: return STEP_VERTICALLY;
			case STEP_HORIZONTALLY_VALUE: return STEP_HORIZONTALLY;
			case DASHDOT_LINE_VALUE: return DASHDOT_LINE;
			case DASHDOTDOT_LINE_VALUE: return DASHDOTDOT_LINE;
			case DOT_LINE_VALUE: return DOT_LINE;
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
	private Trace_TraceType(int value, String name, String literal) {
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
	
} //Trace_TraceType
