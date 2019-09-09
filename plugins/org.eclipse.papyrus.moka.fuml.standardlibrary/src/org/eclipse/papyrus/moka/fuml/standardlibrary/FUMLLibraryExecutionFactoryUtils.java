/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.standardlibrary;

public interface FUMLLibraryExecutionFactoryUtils {

	/**
	 * Integer Functions
	 */

	static final String INTEGER_FUNCTIONS_NEG = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Neg";

	static final String INTEGER_FUNCTION_ADD = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::+";

	static final String INTEGER_FUNCTION_MINUS = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::-";

	static final String INTEGER_FUNCTION_TIMES = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::*";

	static final String INTEGER_FUNCTION_ABS = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Abs";

	static final String INTEGER_FUNCTION_DIVIDE = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::/";

	static final String INTEGER_FUNCTION_DIV = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Div";

	static final String INTEGER_FUNCTION_MOD = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Mod";

	static final String INTEGER_FUNCTION_MAX = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Max";

	static final String INTEGER_FUNCTION_MIN = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Min";

	static final String INTEGER_FUNCTION_LOWER = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::<";

	static final String INTEGER_FUNCTION_GREATER = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::>";

	static final String INTEGER_FUNCTION_LOWER_OR_EQUAL = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::<=";

	static final String INTEGER_FUNCTION_GREATER_OR_EQUAL = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::>=";

	static final String INTEGER_FUNCTION_TO_STRING = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::ToString";

	static final String INTEGER_FUNCTION_TO_UNLIMITED_NATURAL = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::ToUnlimitedNatural";

	static final String INTEGER_FUNCTION_TO_INTEGER = "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::ToInteger";

	/**
	 * Unlimited Natural Functions
	 */

	static final String UNLIMITED_NATURAL_FUNCTION_GREATER = "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::>";

	static final String UNLIMITED_NATURAL_FUNCTION_GREATER_OR_EQUAL = "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::>=";

	static final String UNLIMITED_NATURAL_FUNCTION_LOWER = "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::<";

	static final String UNLIMITED_NATURAL_FUNCTION_MAX = "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::Max";

	static final String UNLIMITED_NATURAL_FUNCTION_MIN = "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::Min";

	static final String UNLIMITED_NATURAL_FUNCTION_TO_INTEGER = "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::ToInteger";

	static final String UNLIMITED_NATURAL_FUNCTION_TO_STRING = "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::ToString";

	static final String UNLIMITED_NATURAL_FUNCTION_TO_UNLIMITED_NATURAL = "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::ToUnlimitedNatural";

	/**
	 * Boolean Functions
	 */

	static final String BOOLEAN_FUNCTION_OR = "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::Or";

	static final String BOOLEAN_FUNCTION_XOR = "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::Xor";

	static final String BOOLEAN_FUNCTION_AND = "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::And";

	static final String BOOLEAN_FUNCTION_NOT = "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::Not";

	static final String BOOLEAN_FUNCTION_IMPLIES = "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::Implies";

	static final String BOOLEAN_FUNCTION_TO_STRING = "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::ToString";

	static final String BOOLEAN_FUNCTION_TO_BOOLEAN = "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::ToBoolean";

	/**
	 * Real Functions
	 */

	static final String REAL_FUNCTION_ADD = "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::+";

	static final String REAL_FUNCTION_MINUS = "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::-";

	static final String REAL_FUNCTION_TIMES = "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::*";

	static final String REAL_FUNCTION_DIV = "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::/";

	static final String REAL_FUNCTION_GREATER = "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::>";

	static final String REAL_FUNCTION_GREATER_OR_EQUAL = "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::>=";

	static final String REAL_FUNCTION_LOWER = "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::<";

	static final String REAL_FUNCTION_LOWER_OR_EQUAL = "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::<=";

	static final String REAL_FUNCTION_ABS = "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::Abs";

	static final String REAL_FUNCTION_FLOOR = "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::Floor";

	static final String REAL_FUNCTION_INV = "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::Inv";

	static final String REAL_FUNCTION_MAX = "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::Max";

	static final String REAL_FUNCTION_MIN = "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::Min";

	static final String REAL_FUNCTION_NEG = "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::Neg";

	static final String REAL_FUNCTION_ROUND = "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::Round";

	static final String REAL_FUNCTION_TO_INTEGER = "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::ToInteger";

	static final String REAL_FUNCTION_TO_REAL = "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::ToReal";

	static final String REAL_FUNCTION_TO_STRING = "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::ToString";

	/**
	 * String Functions
	 */

	static final String STRING_FUNCTION_CONCAT = "FoundationalModelLibrary::PrimitiveBehaviors::StringFunctions::Concat";

	static final String STRING_FUNCTION_SIZE = "FoundationalModelLibrary::PrimitiveBehaviors::StringFunctions::Size";

	static final String STRING_FUNCTION_SUBSTRING = "FoundationalModelLibrary::PrimitiveBehaviors::StringFunctions::Substring";

	/**
	 * List Functions
	 */

	static final String LIST_FUNCTION_SIZE = "FoundationalModelLibrary::PrimitiveBehaviors::ListFunctions::ListSize";

	static final String LIST_FUNCTION_GET = "FoundationalModelLibrary::PrimitiveBehaviors::ListFunctions::ListGet";

	static final String LIST_FUNCTION_CONCAT = "FoundationalModelLibrary::PrimitiveBehaviors::ListFunctions::ListConcat";

	/**
	 * Services
	 */
	
	static final String STANDARD_INPUT_CHANNEL_SERVICE_NAME = "FoundationalModelLibrary::BasicInputOutput::StandardInputChannel";

	static final String STANDARD_OUTPUT_CHANNEL_SERVICE_NAME = "FoundationalModelLibrary::BasicInputOutput::StandardOutputChannel";
	
}
