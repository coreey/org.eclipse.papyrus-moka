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

import java.util.Map;

import org.eclipse.papyrus.moka.engine.uml.libraries.LibraryExecutionFactory;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IOpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.loci.ILocus;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.io.StandardInputChannelImpl;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.io.StandardOutputChannelImpl;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Class;

public class FUMLLibraryExecutionFactory extends LibraryExecutionFactory {

	@Override
	public void installFunctions(ILocus locus) {
		if (locus != null) {
			for (Map.Entry<String, OpaqueBehavior> entry : libraryOpaqueBehavior.entrySet()) {
				IOpaqueBehaviorExecution execution = null;
				// Integer Functions
				if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.INTEGER_FUNCTIONS_NEG)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Neg();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.INTEGER_FUNCTION_ADD)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Add();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.INTEGER_FUNCTION_MINUS)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Minus();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.INTEGER_FUNCTION_TIMES)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Times();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.INTEGER_FUNCTION_ABS)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Abs();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.INTEGER_FUNCTION_DIVIDE)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Div();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.INTEGER_FUNCTION_DIV)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Div_();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.INTEGER_FUNCTION_MOD)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Mod();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.INTEGER_FUNCTION_MAX)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Max();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.INTEGER_FUNCTION_MIN)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Min();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.INTEGER_FUNCTION_LOWER)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Lower();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.INTEGER_FUNCTION_GREATER)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Greater();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.INTEGER_FUNCTION_LOWER_OR_EQUAL)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.LowerOrEqual();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.INTEGER_FUNCTION_GREATER_OR_EQUAL)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.GreaterOrEqual();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.INTEGER_FUNCTION_TO_STRING)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.ToString();
				} else if (entry.getKey()
						.equals(FUMLLibraryExecutionFactoryUtils.INTEGER_FUNCTION_TO_UNLIMITED_NATURAL)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.ToUnlimitedNatural();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.INTEGER_FUNCTION_ABS)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Add();
				}
				// Unlimited Natural Functions
				else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.UNLIMITED_NATURAL_FUNCTION_GREATER)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.Greater();
				} else if (entry.getKey()
						.equals(FUMLLibraryExecutionFactoryUtils.UNLIMITED_NATURAL_FUNCTION_GREATER_OR_EQUAL)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.GreaterOrEqual();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.UNLIMITED_NATURAL_FUNCTION_LOWER)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.Lower();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.UNLIMITED_NATURAL_FUNCTION_MAX)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.Max();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.UNLIMITED_NATURAL_FUNCTION_MIN)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.Min();
				} else if (entry.getKey()
						.equals(FUMLLibraryExecutionFactoryUtils.UNLIMITED_NATURAL_FUNCTION_TO_INTEGER)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.ToInteger();
				} else if (entry.getKey()
						.equals(FUMLLibraryExecutionFactoryUtils.UNLIMITED_NATURAL_FUNCTION_TO_STRING)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.ToString();
				} else if (entry.getKey()
						.equals(FUMLLibraryExecutionFactoryUtils.UNLIMITED_NATURAL_FUNCTION_TO_UNLIMITED_NATURAL)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.ToUnlimitedNatural();
				}
				// Boolean Functions
				else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.BOOLEAN_FUNCTION_OR)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.Or();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.BOOLEAN_FUNCTION_XOR)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.Xor();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.BOOLEAN_FUNCTION_AND)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.And();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.BOOLEAN_FUNCTION_NOT)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.Not();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.BOOLEAN_FUNCTION_IMPLIES)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.Implies();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.BOOLEAN_FUNCTION_TO_STRING)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.ToString();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.BOOLEAN_FUNCTION_TO_BOOLEAN)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.ToBoolean();
				}
				// Real Functions
				else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.REAL_FUNCTION_ADD)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Add();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.REAL_FUNCTION_MINUS)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Minus();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.REAL_FUNCTION_TIMES)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Times();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.REAL_FUNCTION_DIV)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Div();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.REAL_FUNCTION_GREATER)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Greater();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.REAL_FUNCTION_GREATER_OR_EQUAL)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.GreaterOrEqual();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.REAL_FUNCTION_LOWER)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Lower();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.REAL_FUNCTION_LOWER_OR_EQUAL)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.LowerOrEqual();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.REAL_FUNCTION_ABS)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Abs();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.REAL_FUNCTION_FLOOR)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Floor();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.REAL_FUNCTION_INV)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Inv();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.REAL_FUNCTION_MAX)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Max();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.REAL_FUNCTION_MIN)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Min();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.REAL_FUNCTION_NEG)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Neg();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.REAL_FUNCTION_ROUND)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.Round();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.REAL_FUNCTION_TO_INTEGER)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.ToInteger();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.REAL_FUNCTION_TO_REAL)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.ToReal();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.REAL_FUNCTION_TO_STRING)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.real.ToString();
				}
				// String Functions
				else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.STRING_FUNCTION_CONCAT)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.string.Concat();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.STRING_FUNCTION_SIZE)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.string.Size();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.STRING_FUNCTION_SUBSTRING)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.string.Substring();
				}
				// List Functions
				else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.LIST_FUNCTION_SIZE)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.list.ListSize();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.LIST_FUNCTION_GET)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.list.ListGet();
				} else if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.LIST_FUNCTION_CONCAT)) {
					execution = new org.eclipse.papyrus.moka.fuml.standardlibrary.library.list.ListConcat();
				}
				if (execution != null) {
					execution.addType(entry.getValue());
					register(execution, locus);
				}
			}
		}
	}

	@Override
	public void installServices(ILocus locus) {
		if (locus != null) {
			for (Map.Entry<String, Class> entry : libraryService.entrySet()) {
				IObject_ service = null;
				if (entry.getKey().equals(FUMLLibraryExecutionFactoryUtils.STANDARD_INPUT_CHANNEL_SERVICE_NAME)) {
					service = new StandardInputChannelImpl(entry.getValue());
				} else if (entry.getKey()
						.equals(FUMLLibraryExecutionFactoryUtils.STANDARD_OUTPUT_CHANNEL_SERVICE_NAME)) {
					service = new StandardOutputChannelImpl(entry.getValue());
				}
				if(service != null) {
					service.setLocus(locus);
					locus.add(service);
				}
			}
		}
	}

}
