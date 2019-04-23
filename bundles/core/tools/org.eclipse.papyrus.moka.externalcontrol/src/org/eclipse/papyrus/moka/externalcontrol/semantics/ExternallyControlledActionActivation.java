/*****************************************************************************
 * 
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.externalcontrol.semantics;

import java.util.List;

import org.eclipse.papyrus.moka.externalcontrol.advice.IControllerAdvice;
import org.eclipse.papyrus.moka.externalcontrol.controller.ExternalController;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;

public class ExternallyControlledActionActivation extends AbstractExternallyControlledActionActivation<ActionActivation>  {


	public ExternallyControlledActionActivation(ActionActivation visitor, ExternalController controller, List<IControllerAdvice> advices) {
		super(visitor, controller, advices);
	}

	@Override
	protected void doSemanticAction() {
		delegatedVisitor.doAction();
	}


	@Override
	public void doResumeExecution() {

		// FIXME completeAction should probably move to IActionActivation
		List<IToken> incomingTokens = delegatedVisitor.completeAction();
		if (incomingTokens.size() > 0) {
			this.fire(incomingTokens);
		}
		// TODO clarify if resume should be called before or after complete action...
		this.resume();
		
	}


}
