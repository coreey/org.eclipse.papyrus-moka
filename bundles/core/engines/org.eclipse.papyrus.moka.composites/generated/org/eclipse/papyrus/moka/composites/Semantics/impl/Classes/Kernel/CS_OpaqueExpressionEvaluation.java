/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.moka.composites.Semantics.impl.Classes.Kernel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.composites.interfaces.Semantics.Classes.Kernel.ICS_OpaqueExpressionEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Evaluation;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.OpaqueExpression;

public class CS_OpaqueExpressionEvaluation extends Evaluation implements ICS_OpaqueExpressionEvaluation {

	@Override
	public IValue evaluate() {
		// Execute the behavior associated with the context OpaqueExpression, if any.
		// If multiple return values are computed, then return the first one.
		// If no value are computed, return null
		List<IValue> evaluation = this.executeExpressionBehavior();
		if (evaluation.size() > 0) {
			return evaluation.get(0);
		} else {
			return null;
		}
	}

	public List<IValue> executeExpressionBehavior() {
		// If a behavior is associated with the context OpaqueExpression,
		// then execute this behavior, and return computed values.
		// Otherwise, return an empty list of values.
		List<IValue> evaluation = new ArrayList<IValue>();
		OpaqueExpression expression = (OpaqueExpression) this.specification;
		Behavior behavior = expression.getBehavior();
		if (behavior != null) {
			List<IParameterValue> inputs = new ArrayList<IParameterValue>();
			List<IParameterValue> results = this.locus.getExecutor().execute(behavior, null, inputs);
			for (int i = 0; i < results.size(); i++) { // results.size should be 1
				IParameterValue parameterValue = results.get(i);
				List<IValue> values = parameterValue.getValues();
				for (int j = 0; j < values.size(); j++) {
					evaluation.add(values.get(j));
				}
			}
		}
		return evaluation;
	}

}
