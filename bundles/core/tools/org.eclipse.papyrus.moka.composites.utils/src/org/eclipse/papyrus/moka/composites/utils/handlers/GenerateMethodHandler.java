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
package org.eclipse.papyrus.moka.composites.utils.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;


public class GenerateMethodHandler extends AbstractCompositeUtilsHandler {

	protected Operation contextOperation ;
	
	@Override
	public RecordingCommand getUpdateCommand(Class context, TransactionalEditingDomain domain) {
		return new GenerateMethodCommand(context, domain);
	}

	@Override
	public boolean isEnabled() {
		Element selectedElement = Utils.getSelection();
		if (selectedElement != null) {
			return selectedElement instanceof Operation ;
		}
		return false;
	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Class context = null;
		contextOperation = this.getOperationFromSelection(HandlerUtil.getCurrentSelection(event));
		context = this.getClassFromSelection(HandlerUtil.getCurrentSelection(event));
		if (contextOperation != null) {
			Element cddClass = contextOperation.getOwner();
			if (cddClass instanceof Class) {
				context = (Class)cddClass ;
			}
		}
		if (context != null) {
			this.start(context);
		}
		return null;
	}

	/**
	 * Return the Operation associated with the selection object or null 
	 *
	 * @param selected
	 * @return Class
	 */
	protected Operation getOperationFromSelection(ISelection selected) {
		if (selected.isEmpty()) {
			return null;
		} else {
			// Every object retrieved from the model explorer is an IAdaptable
			IAdaptable adaptableObj = (IAdaptable) ((IStructuredSelection) selected).getFirstElement();
			// Get the model object behind the adaptable object
			EObject modelObj = (EObject) adaptableObj.getAdapter(org.eclipse.emf.ecore.EObject.class);
			NamedElement nElem = (NamedElement) modelObj;
			return nElem instanceof Operation ? (Operation) nElem : null;
		}
	}
	
	/**
	 * Command that generate factory for a given class.
	 *
	 * @see Utils.getFactory
	 */
	protected class GenerateMethodCommand extends RecordingCommand {

		protected Class context;

		public GenerateMethodCommand(Class context, TransactionalEditingDomain domain) {
			super(domain);
			this.context = context;
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see
		 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor
		 * , org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected void doExecute() {
			Utils.getMethod(context, contextOperation);
		}
	}
}
