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
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ReadSelfAction;
import org.eclipse.uml2.uml.Type;

public class ReadSelfActionEditHelperAdvice extends AbstractEditHelperAdvice {

	protected Type _integer = null ;
	protected Type _boolean = null ;
	protected Behavior _lowerThan = null ; 
	protected Behavior _add = null ;

	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		ReadSelfAction node = (ReadSelfAction)request.getElementToConfigure() ;
		return new ConfigureElementCommand(request){
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				buildReadSelfAction(node) ;
				return CommandResult.newOKCommandResult(node);
			}
			
		};
	}

	protected void buildReadSelfAction(ReadSelfAction node) {

		// first, recovers the context Activity
		Activity contextActivity = node.getActivity() ;
		Type resultType = null ; 
		node.setName("self");
		if (contextActivity == null) {
			Element owner = node.getOwner() ;
			while (owner != null && !(owner instanceof Activity)) {
				owner = owner.getOwner() ;
			}
			if (owner != null) {
				contextActivity = (Activity)owner ;
			}
		}
		if (contextActivity.getSpecification() == null) {
			resultType = contextActivity ;
		}
		else {
			BehavioralFeature specification = contextActivity.getSpecification() ;
			resultType = (Type)specification.getOwner() ;
		}
		
		node.createResult("result", resultType) ;
		
	}
}


