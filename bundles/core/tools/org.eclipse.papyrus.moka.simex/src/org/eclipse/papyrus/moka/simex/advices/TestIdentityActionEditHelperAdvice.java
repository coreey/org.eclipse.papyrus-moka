/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
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
package org.eclipse.papyrus.moka.simex.advices;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.papyrus.moka.simex.utils.UMLPrimitiveTypesUtils;
import org.eclipse.uml2.uml.TestIdentityAction;

public class TestIdentityActionEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		TestIdentityAction node = (TestIdentityAction)request.getElementToConfigure() ;
		return new ConfigureElementCommand(request){
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				buildTestIdentityAction(node) ;
				return CommandResult.newOKCommandResult(node);
			}
			
		};
	}

	protected void buildTestIdentityAction(TestIdentityAction node) {
		node.createFirst("x", null) ;
		node.createSecond("y", null) ;
		node.createResult("result", UMLPrimitiveTypesUtils.getBoolean(node)) ;
		node.setName("==");
	}
}


