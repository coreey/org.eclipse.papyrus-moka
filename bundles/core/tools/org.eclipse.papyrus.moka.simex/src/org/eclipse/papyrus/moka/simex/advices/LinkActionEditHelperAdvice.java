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
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.CreateLinkAction;
import org.eclipse.uml2.uml.DestroyLinkAction;
import org.eclipse.uml2.uml.LinkAction;
import org.eclipse.uml2.uml.ReadLinkAction;

/**
 * @author sr246418
 *
 */
public class LinkActionEditHelperAdvice extends AbstractEditHelperAdvice {

	public static final String LINK_ACTION_ASSOCIATION = "ASSOCIATION";



	
	
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		final LinkAction action = (LinkAction) request.getElementToConfigure();
		Object associationParam = request.getParameter(LINK_ACTION_ASSOCIATION);
		
		if (associationParam instanceof Association){
			final Association association = (Association) associationParam;
			ICommand command = new AbstractPinUpdateCommand("update " + action.getName() + " pins") {
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					if (action instanceof CreateLinkAction){
						PinUtils.updateCreateLinkAction((CreateLinkAction) action,association);
					}else if (action instanceof ReadLinkAction){
						PinUtils.updateReadLinkAction((ReadLinkAction)action,  association);
					}else if (action instanceof DestroyLinkAction){
						PinUtils.updateDestroyLinkAction((DestroyLinkAction)action, association);
					}else {
						return CommandResult.newErrorCommandResult("Not supported LinkAction");
					}
					
					return CommandResult.newOKCommandResult();
				}
			};
			return command;
		}
		
		return null;
	
		
		
	}
	
}
