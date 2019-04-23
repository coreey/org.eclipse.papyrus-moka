/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.registry.AbstractOpaqueBehaviorExecutionRegistry;


public class StandardLibraryRegistry extends AbstractOpaqueBehaviorExecutionRegistry {

	protected final static String FUML_LIBRARY_NAME = "FoundationalModelLibrary";
	protected final static String FUML_LIBRARY_URI = "pathmap://PAPYRUS_fUML_LIBRARY/fUML_Library.uml";

	@Override
	public void registerOpaqueBehaviorExecutions(ILocus locus) {
		this.locus = locus;
		this.buildOpaqueBehaviorsMap(FUML_LIBRARY_URI);
		try {
			// ////////////////////
			// Integer functions
			// Neg
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Neg(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Neg");
			// +
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Add(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::+");
			// -
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Minus(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::-");
			// *
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Times(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::*");
			// Abs
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Abs(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Abs");
			// '/'
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Div_(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::/");
			// Div
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Div(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Div");
			// Mod
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Mod(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Mod");
			// Max
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Max(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Max");
			// Min
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Min(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Min");
			// <
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Lower(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::<");
			// >
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Greater(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::>");
			// <=
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.LowerOrEqual(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::<=");
			// >=
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.GreaterOrEqual(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::>=");
			// ToString
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.ToString(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::ToString");
			// ToUnlimitedNatural
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.ToUnlimitedNatural(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::ToUnlimitedNatural");
			// ToInteger
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.ToInteger(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::ToInteger");
			// '/' is missing TODO

			// ////////////////////
			// Unlimited natural functions
			// >
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.Greater(), "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::>");
			// >=
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.GreaterOrEqual(), "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::>=");
			// <
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.Lower(), "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::<");
			// <=
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.LowerOrEqual(), "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::<=");
			// Max
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.Max(), "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::Max");
			// Min
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.Min(), "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::Min");
			// ToInteger
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.ToInteger(), "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::ToInteger");
			// ToString
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.ToString(), "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::ToString");
			// ToUnlimitedNatural
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.ToUnlimitedNatural(), "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::ToUnlimitedNatural");

			// ////////////////////
			// Boolean functions
			// Or
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.Or(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::Or");
			// Xor
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.Xor(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::Xor");
			// And
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.And(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::And");
			// Not
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.Not(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::Not");
			// Implies
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.Implies(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::Implies");
			// ToString
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.ToString(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::ToString");
			// ToBoolean
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.ToBoolean(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::ToBoolean");

			// ////////////////////
			// Real functions
			// +
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Add(), "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::+");
			// -
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Minus(), "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::-");
			// *
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Times(), "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::*");
			// /
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Div(), "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::/");
			// >
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Greater(), "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::>");
			// >=
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.GreaterOrEqual(), "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::>=");
			// <
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Lower(), "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::<");
			// <=
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.LowerOrEqual(), "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::<=");
			// Abs
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Abs(), "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::Abs");
			// Floor
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Floor(), "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::Floor");
			// Inv
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Inv(), "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::Inv");
			// Max
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Max(), "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::Max");
			// Min
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Min(), "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::Min");
			// Neg
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Neg(), "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::Neg");
			// Round
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Round(), "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::Round");
			// ToInteger
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.ToInteger(), "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::ToInteger");
			// ToReal
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.ToReal(), "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::ToReal");
			// ToString
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.ToString(), "FoundationalModelLibrary::PrimitiveBehaviors::RealFunctions::ToString");

			// ////////////////////
			// String functions
			// Concat
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.string.Concat(), "FoundationalModelLibrary::PrimitiveBehaviors::StringFunctions::Concat");
			// Size
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.string.Size(), "FoundationalModelLibrary::PrimitiveBehaviors::StringFunctions::Size");
			// Substring
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.string.Substring(), "FoundationalModelLibrary::PrimitiveBehaviors::StringFunctions::Substring");
			// ////////////////////
			// List functions
			// ListSize
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.list.ListSize(), "FoundationalModelLibrary::PrimitiveBehaviors::ListFunctions::ListSize");
			// ListGet
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.list.ListGet(), "FoundationalModelLibrary::PrimitiveBehaviors::ListFunctions::ListGet");
			// ListConcat
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.list.ListConcat(), "FoundationalModelLibrary::PrimitiveBehaviors::ListFunctions::ListConcat");
		} catch (Exception e) {
			org.eclipse.papyrus.infra.core.Activator.log.error(e);
		}
	}
}
