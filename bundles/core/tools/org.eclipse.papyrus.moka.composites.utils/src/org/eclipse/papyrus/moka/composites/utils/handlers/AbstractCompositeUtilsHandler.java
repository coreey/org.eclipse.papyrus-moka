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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

public abstract class AbstractCompositeUtilsHandler extends AbstractHandler {


	/**
	 * Moka Modeling Utils menu are enable only if selected object refer as a Class
	 *
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		Element selectedElement = Utils.getSelection();
		if (selectedElement != null) {
			return selectedElement instanceof Class && !(selectedElement instanceof Behavior);
		}
		return false;
	}

	/**
	 * Return the class associated with the selection object or null whether
	 * no class could have been found
	 *
	 * @param selected
	 * @return Class
	 */
	protected Class getClassFromSelection(ISelection selected) {
		if (selected.isEmpty()) {
			return null;
		} else {
			// Every object retrieved from the model explorer is an IAdaptable
			IAdaptable adaptableObj = (IAdaptable) ((IStructuredSelection) selected).getFirstElement();
			// Get the model object behind the adaptable object
			EObject modelObj = (EObject) adaptableObj.getAdapter(org.eclipse.emf.ecore.EObject.class);
			NamedElement nElem = (NamedElement) modelObj;
			return nElem instanceof Class ? (Class) nElem : null;
		}
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Class context = null;
		context = this.getClassFromSelection(HandlerUtil.getCurrentSelection(event));
		if (context != null) {
			this.start(context);
		}
		return null;
	}

	/**
	 * Launch the ConstructorBehaviorCreationCompiler
	 *
	 * @param myClass
	 *            which is the class who need to create the constructor
	 *
	 */
	public void start(Class myClass) {
		TransactionalEditingDomain domain = (TransactionalEditingDomain) EMFHelper.resolveEditingDomain(myClass);
		RecordingCommand updateCommand = this.getUpdateCommand(myClass, domain);
		domain.getCommandStack().execute(updateCommand);
	}

	public abstract RecordingCommand getUpdateCommand(Class myClass, TransactionalEditingDomain domain);
}
