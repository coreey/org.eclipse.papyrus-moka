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
 * A representation of the literals of the enumeration '<em><b>Zoom Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getZoomType()
 * @model
 * @generated
 */
public enum ZoomType implements Enumerator {
	/**
	 * The '<em><b>NONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE_VALUE
	 * @generated
	 * @ordered
	 */
	NONE(11, "NONE", "NONE"),

	/**
	 * The '<em><b>RUBBERBAND ZOOM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUBBERBAND_ZOOM_VALUE
	 * @generated
	 * @ordered
	 */
	RUBBERBAND_ZOOM(0, "RUBBERBAND_ZOOM", "RUBBERBAND_ZOOM"),

	/**
	 * The '<em><b>DYNAMIC ZOOM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DYNAMIC_ZOOM_VALUE
	 * @generated
	 * @ordered
	 */
	DYNAMIC_ZOOM(1, "DYNAMIC_ZOOM", "DYNAMIC_ZOOM"),

	/**
	 * The '<em><b>HORIZONTAL ZOOM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HORIZONTAL_ZOOM_VALUE
	 * @generated
	 * @ordered
	 */
	HORIZONTAL_ZOOM(2, "HORIZONTAL_ZOOM", "HORIZONTAL_ZOOM"),

	/**
	 * The '<em><b>VERTICAL ZOOM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERTICAL_ZOOM_VALUE
	 * @generated
	 * @ordered
	 */
	VERTICAL_ZOOM(3, "VERTICAL_ZOOM", "VERTICAL_ZOOM"),

	/**
	 * The '<em><b>ZOOM IN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZOOM_IN_VALUE
	 * @generated
	 * @ordered
	 */
	ZOOM_IN(4, "ZOOM_IN", "ZOOM_IN"),

	/**
	 * The '<em><b>ZOOM OUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZOOM_OUT_VALUE
	 * @generated
	 * @ordered
	 */
	ZOOM_OUT(5, "ZOOM_OUT", "ZOOM_OUT"),

	/**
	 * The '<em><b>ZOOM IN HORIZONTALLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZOOM_IN_HORIZONTALLY_VALUE
	 * @generated
	 * @ordered
	 */
	ZOOM_IN_HORIZONTALLY(6, "ZOOM_IN_HORIZONTALLY", "ZOOM_IN_HORIZONTALLY"),

	/**
	 * The '<em><b>ZOOM OUT HORIZONTALLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZOOM_OUT_HORIZONTALLY_VALUE
	 * @generated
	 * @ordered
	 */
	ZOOM_OUT_HORIZONTALLY(7, "ZOOM_OUT_HORIZONTALLY", "ZOOM_OUT_HORIZONTALLY"),

	/**
	 * The '<em><b>ZOOM IN VERTICALLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZOOM_IN_VERTICALLY_VALUE
	 * @generated
	 * @ordered
	 */
	ZOOM_IN_VERTICALLY(8, "ZOOM_IN_VERTICALLY", "ZOOM_IN_VERTICALLY"),

	/**
	 * The '<em><b>ZOOM OUT VERTICALLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZOOM_OUT_VERTICALLY_VALUE
	 * @generated
	 * @ordered
	 */
	ZOOM_OUT_VERTICALLY(9, "ZOOM_OUT_VERTICALLY", "ZOOM_OUT_VERTICALLY"),

	/**
	 * The '<em><b>PANNING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PANNING_VALUE
	 * @generated
	 * @ordered
	 */
	PANNING(10, "PANNING", "PANNING");

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
	public static final int NONE_VALUE = 11;

	/**
	 * The '<em><b>RUBBERBAND ZOOM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RUBBERBAND ZOOM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RUBBERBAND_ZOOM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RUBBERBAND_ZOOM_VALUE = 0;

	/**
	 * The '<em><b>DYNAMIC ZOOM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DYNAMIC ZOOM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DYNAMIC_ZOOM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DYNAMIC_ZOOM_VALUE = 1;

	/**
	 * The '<em><b>HORIZONTAL ZOOM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HORIZONTAL ZOOM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HORIZONTAL_ZOOM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HORIZONTAL_ZOOM_VALUE = 2;

	/**
	 * The '<em><b>VERTICAL ZOOM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VERTICAL ZOOM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VERTICAL_ZOOM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VERTICAL_ZOOM_VALUE = 3;

	/**
	 * The '<em><b>ZOOM IN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZOOM IN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZOOM_IN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ZOOM_IN_VALUE = 4;

	/**
	 * The '<em><b>ZOOM OUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZOOM OUT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZOOM_OUT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ZOOM_OUT_VALUE = 5;

	/**
	 * The '<em><b>ZOOM IN HORIZONTALLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZOOM IN HORIZONTALLY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZOOM_IN_HORIZONTALLY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ZOOM_IN_HORIZONTALLY_VALUE = 6;

	/**
	 * The '<em><b>ZOOM OUT HORIZONTALLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZOOM OUT HORIZONTALLY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZOOM_OUT_HORIZONTALLY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ZOOM_OUT_HORIZONTALLY_VALUE = 7;

	/**
	 * The '<em><b>ZOOM IN VERTICALLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZOOM IN VERTICALLY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZOOM_IN_VERTICALLY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ZOOM_IN_VERTICALLY_VALUE = 8;

	/**
	 * The '<em><b>ZOOM OUT VERTICALLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZOOM OUT VERTICALLY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZOOM_OUT_VERTICALLY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ZOOM_OUT_VERTICALLY_VALUE = 9;

	/**
	 * The '<em><b>PANNING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PANNING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PANNING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PANNING_VALUE = 10;

	/**
	 * An array of all the '<em><b>Zoom Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ZoomType[] VALUES_ARRAY =
		new ZoomType[] {
			NONE,
			RUBBERBAND_ZOOM,
			DYNAMIC_ZOOM,
			HORIZONTAL_ZOOM,
			VERTICAL_ZOOM,
			ZOOM_IN,
			ZOOM_OUT,
			ZOOM_IN_HORIZONTALLY,
			ZOOM_OUT_HORIZONTALLY,
			ZOOM_IN_VERTICALLY,
			ZOOM_OUT_VERTICALLY,
			PANNING,
		};

	/**
	 * A public read-only list of all the '<em><b>Zoom Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ZoomType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Zoom Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ZoomType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ZoomType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Zoom Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ZoomType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ZoomType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Zoom Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ZoomType get(int value) {
		switch (value) {
			case NONE_VALUE: return NONE;
			case RUBBERBAND_ZOOM_VALUE: return RUBBERBAND_ZOOM;
			case DYNAMIC_ZOOM_VALUE: return DYNAMIC_ZOOM;
			case HORIZONTAL_ZOOM_VALUE: return HORIZONTAL_ZOOM;
			case VERTICAL_ZOOM_VALUE: return VERTICAL_ZOOM;
			case ZOOM_IN_VALUE: return ZOOM_IN;
			case ZOOM_OUT_VALUE: return ZOOM_OUT;
			case ZOOM_IN_HORIZONTALLY_VALUE: return ZOOM_IN_HORIZONTALLY;
			case ZOOM_OUT_HORIZONTALLY_VALUE: return ZOOM_OUT_HORIZONTALLY;
			case ZOOM_IN_VERTICALLY_VALUE: return ZOOM_IN_VERTICALLY;
			case ZOOM_OUT_VERTICALLY_VALUE: return ZOOM_OUT_VERTICALLY;
			case PANNING_VALUE: return PANNING;
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
	private ZoomType(int value, String name, String literal) {
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
	
} //ZoomType
