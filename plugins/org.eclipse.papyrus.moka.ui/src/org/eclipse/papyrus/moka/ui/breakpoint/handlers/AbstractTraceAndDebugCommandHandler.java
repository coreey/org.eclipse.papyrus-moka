/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
 *  Ansgar Radermacher (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.breakpoint.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;

/**
 * <pre>
 *
 * This abstract command handler manages:
 * - current selection in order to build a list of the selected {@link EObject}
 * - execute the command (returned by children) in Papyrus {@link TransactionalEditingDomain}
 * - calculate the command enablement and visibility regarding the command executability
 * (the command is now shown in menu if not executable).
 *
 * </pre>
 */
public abstract class AbstractTraceAndDebugCommandHandler extends MokaAbstractHandler {

	/**
	 * <pre>
	 *
	 * Returns the command to execute (to be implemented
	 * in children implementing this class)
	 *
	 * &#64;return the command to execute
	 *
	 * </pre>
	 */
	protected abstract Command getCommand();

	/**
	 * <pre>
	 * Parse current selection and extract the list of {@link EObject} from
	 * this selection.
	 *
	 * This also tries to adapt selected element into {@link EObject}
	 * (for example to get the {@link EObject} from a selection in the ModelExplorer).
	 *
	 * @return a list of currently selected {@link EObject}
	 * </pre>
	 *
	 */
	protected List<EObject> getSelectedElements() {

		List<EObject> selectedEObjects = new ArrayList<EObject>();

		// Parse current selection
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			for (Object current : structuredSelection.toArray()) {
				// Adapt current selection to EObject
				if (current instanceof IAdaptable) {
					selectedEObjects.add(((IAdaptable) current).getAdapter(EObject.class));
				}
			}
		} else { // Not a IStructuredSelection
			if (selection != null) {
				// Adapt current selection to EObject
				if (selection instanceof IAdaptable) {
					selectedEObjects.add(((IAdaptable) selection).getAdapter(EObject.class));
				}
			}
		}

		return selectedEObjects;
	}

	/**
	 *
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 *
	 * @param event
	 * @return null
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// Trace & breakpoint commands do not modify the model, don't execute
		// on stack
		getCommand().execute();

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		return getCommand().canExecute();
	}

	/**
	 *
	 * @return true (visible) when the command can be executed.
	 */
	public boolean isVisible() {
		return getCommand().canExecute();
	}


}
