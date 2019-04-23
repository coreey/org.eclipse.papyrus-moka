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

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.moka.simex.utils.EventUtil;
import org.eclipse.papyrus.moka.simex.utils.RequestUtils;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.UMLPackage;


public class SignalEditHelperAdvice extends AbstractEditHelperAdvice {
	

@Override
protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
	
	if (request.getElementToConfigure() instanceof Signal){
		final Signal signal = (Signal) request.getElementToConfigure();
		return new ConfigureElementCommand(request){

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				EventUtil.getSignalEvent(signal);
				return CommandResult.newOKCommandResult(signal);
			}
			
		};
		
		
	}
	return super.getAfterConfigureCommand(request);
}


@Override
	protected ICommand getAfterSetCommand(SetRequest request) {
		if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(request.getFeature())){
			final Signal signal = (Signal) request.getElementToEdit();
			
			return new EditElementCommand("Update Signal Name",signal, request) {
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {
					EventUtil.alignEventName(signal);
					return CommandResult.newOKCommandResult(signal);
				}
			};
		}
		return super.getBeforeSetCommand(request);
	}



	
@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {
	if( request.getElementToDestroy() instanceof Signal){
		final Signal signal = (Signal) request.getElementToDestroy();
		final SignalEvent event = EventUtil.getSignalEvent(signal, false);
		if (event != null){
			ICommand ret = new AbstractTransactionalCommand(request.getEditingDomain(), "Destroy depending signal events", Collections.EMPTY_LIST) {
				
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					RequestUtils.deleteObjectWithRequest(event);
					return CommandResult.newOKCommandResult();
				}
			};
			return ret;
		}
		
		
	}
	return super.getBeforeDestroyDependentsCommand(request);
	
}


}
