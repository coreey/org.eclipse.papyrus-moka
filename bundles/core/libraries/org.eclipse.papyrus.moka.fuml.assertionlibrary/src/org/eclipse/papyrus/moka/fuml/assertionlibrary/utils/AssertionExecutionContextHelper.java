/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.assertionlibrary.utils;

import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.uml2.uml.Classifier;


public class AssertionExecutionContextHelper {

	public static Classifier getExecutionContext(Execution assertionExecution) {
		Classifier context = null;
		if (assertionExecution.context != null && assertionExecution != assertionExecution.context) {
			if (assertionExecution.context instanceof Execution) {
				context = getExecutionContext((Execution) assertionExecution.context);
			} else {
				if (assertionExecution.context.getObjectActivation() != null) {
					context = assertionExecution.context.getObjectActivation().getClassifierBehaviorInvocations().get(0).getExecutedClassifier();
				} else {
					context = assertionExecution.context.getTypes().get(0);
				}
			}
		} else {
			context = assertionExecution.types.get(0);
		}
		return context;
	}
}
