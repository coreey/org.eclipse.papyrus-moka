/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.simex.advices;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.papyrus.moka.simex.advices.commands.AbstractPinUpdateCommand;
import org.eclipse.papyrus.moka.simex.utils.PinUtils;
import org.eclipse.uml2.uml.ReadIsClassifiedObjectAction;

/**
 * @author sr246418
 *
 */
public class ReadIsClassifiedObjectActionEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		final ReadIsClassifiedObjectAction action = (ReadIsClassifiedObjectAction) request.getElementToConfigure();
		
		ICommand command = new AbstractPinUpdateCommand("update " + action.getName() + " pins") {
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				PinUtils.updateReadIsClassifiedObjectAction(action);
				return CommandResult.newOKCommandResult();
			}
		};
		return command;
	
		
		
	}
	
}
