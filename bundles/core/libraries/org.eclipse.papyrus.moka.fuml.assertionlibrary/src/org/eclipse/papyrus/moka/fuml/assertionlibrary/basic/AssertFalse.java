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
package org.eclipse.papyrus.moka.fuml.assertionlibrary.basic;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.StringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.reporting.Reporter;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.reporting.TestDecision;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.reporting.TestReport;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.utils.AssertionExecutionContextHelper;
import org.eclipse.uml2.uml.Classifier;


public class AssertFalse extends OpaqueBehaviorExecution {

	@Override
	public void doBody(List<IParameterValue> inputParameters, List<IParameterValue> outputParameters) {
		Classifier executionContext = AssertionExecutionContextHelper.getExecutionContext(this);
		StringValue label = (StringValue) inputParameters.get(0).getValues().get(0);
		BooleanValue assertionResult = (BooleanValue) inputParameters.get(1).getValues().get(0);
		Reporter.INSTANCE.add(new TestReport(executionContext != null ? executionContext : null, label.value, assertionResult.value == false ? TestDecision.SUCCESS : TestDecision.FAILED, getClass()));
	}

	@Override
	public Value new_() {
		return new AssertFalse();
	}
}
