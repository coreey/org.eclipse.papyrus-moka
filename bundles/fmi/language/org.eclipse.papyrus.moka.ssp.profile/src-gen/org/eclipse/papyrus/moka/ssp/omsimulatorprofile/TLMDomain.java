/**
 * Copyright (c) 2018 CEA LIST.
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
package org.eclipse.papyrus.moka.ssp.omsimulatorprofile;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>TLM Domain</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getTLMDomain()
 * @model
 * @generated
 */
public enum TLMDomain implements Enumerator {
	/**
	 * The '<em><b>Hydraulic</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HYDRAULIC_VALUE
	 * @generated
	 * @ordered
	 */
	HYDRAULIC(0, "Hydraulic", "Hydraulic"),

	/**
	 * The '<em><b>Mechanical</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MECHANICAL_VALUE
	 * @generated
	 * @ordered
	 */
	MECHANICAL(1, "Mechanical", "Mechanical"),

	/**
	 * The '<em><b>Rotational</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROTATIONAL_VALUE
	 * @generated
	 * @ordered
	 */
	ROTATIONAL(2, "Rotational", "Rotational"),

	/**
	 * The '<em><b>Electric</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRIC_VALUE
	 * @generated
	 * @ordered
	 */
	ELECTRIC(3, "Electric", "Electric"),

	/**
	 * The '<em><b>Input</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INPUT_VALUE
	 * @generated
	 * @ordered
	 */
	INPUT(4, "input", "input"),

	/**
	 * The '<em><b>Output</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUTPUT_VALUE
	 * @generated
	 * @ordered
	 */
	OUTPUT(5, "output", "output");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2018 CEA LIST.\n\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License 2.0\n which accompanies this distribution, and is available at\n https://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\n\n Contributors:\n  CEA LIST - Initial API and implementation";

	/**
	 * The '<em><b>Hydraulic</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Hydraulic</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HYDRAULIC
	 * @model name="Hydraulic"
	 * @generated
	 * @ordered
	 */
	public static final int HYDRAULIC_VALUE = 0;

	/**
	 * The '<em><b>Mechanical</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mechanical</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MECHANICAL
	 * @model name="Mechanical"
	 * @generated
	 * @ordered
	 */
	public static final int MECHANICAL_VALUE = 1;

	/**
	 * The '<em><b>Rotational</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Rotational</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROTATIONAL
	 * @model name="Rotational"
	 * @generated
	 * @ordered
	 */
	public static final int ROTATIONAL_VALUE = 2;

	/**
	 * The '<em><b>Electric</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Electric</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRIC
	 * @model name="Electric"
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRIC_VALUE = 3;

	/**
	 * The '<em><b>Input</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Input</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INPUT
	 * @model name="input"
	 * @generated
	 * @ordered
	 */
	public static final int INPUT_VALUE = 4;

	/**
	 * The '<em><b>Output</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Output</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OUTPUT
	 * @model name="output"
	 * @generated
	 * @ordered
	 */
	public static final int OUTPUT_VALUE = 5;

	/**
	 * An array of all the '<em><b>TLM Domain</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TLMDomain[] VALUES_ARRAY =
		new TLMDomain[] {
			HYDRAULIC,
			MECHANICAL,
			ROTATIONAL,
			ELECTRIC,
			INPUT,
			OUTPUT,
		};

	/**
	 * A public read-only list of all the '<em><b>TLM Domain</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TLMDomain> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>TLM Domain</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TLMDomain get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TLMDomain result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>TLM Domain</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TLMDomain getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TLMDomain result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>TLM Domain</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TLMDomain get(int value) {
		switch (value) {
			case HYDRAULIC_VALUE: return HYDRAULIC;
			case MECHANICAL_VALUE: return MECHANICAL;
			case ROTATIONAL_VALUE: return ROTATIONAL;
			case ELECTRIC_VALUE: return ELECTRIC;
			case INPUT_VALUE: return INPUT;
			case OUTPUT_VALUE: return OUTPUT;
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
	private TLMDomain(int value, String name, String literal) {
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
	
} //TLMDomain
