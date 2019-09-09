/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
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
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.breakpoint.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;
import org.eclipse.ui.PlatformUI;

/**
 * An abstract handler, used as a basis for ToggleBreakpointActivationHandler, and ToggleBreakpointHandler.
 *
 */
public abstract class MokaAbstractHandler extends AbstractHandler {

	/**
	 * <pre>
	 * Get the selected element, the first selected element if several are selected or null
	 * if no selection or the selection is not an {@link EObject}.
	 *
	 * @return selected {@link EObject} or null
	 * </pre>
	 *
	 */
	protected EObject getSelectedElement() {
		EObject eObject = null;
		Object selection = null;

		// Get current selection
		selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

		// Get first element if the selection is an IStructuredSelection
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			selection = structuredSelection.getFirstElement();
		}

		// Treat non-null selected object (try to adapt and return EObject)
		if (selection != null) {
			if (selection instanceof IAdaptable) {
				selection = ((IAdaptable) selection).getAdapter(EObject.class);
			}

			Object businessObject = BusinessModelResolver.getInstance().getBusinessModel(selection);
			if (businessObject instanceof EObject) {
				eObject = (EObject) businessObject;
			}
		}
		return eObject;
	}

}
