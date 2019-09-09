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

package org.eclipse.papyrus.moka.tracepoint.service.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.moka.tracepoint.service.TracepointConstants;
import org.eclipse.papyrus.moka.tracepoint.service.dialogs.TraceActionSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;


public class TracepointPropertiesCommand extends AbstractTracepointCommand {

	public TracepointPropertiesCommand(EObject selectedElement) {
		super("Tracepoint properties", TransactionUtil.getEditingDomain(selectedElement), selectedElement); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException
	{
		updateResourceAndURI();
		selectTraceActions();
		return null;
	}

	protected void selectTraceActions() {
		IMarker marker = findMarker(TracepointConstants.tracepointMarker);
		if (marker != null) {
			// should normally always hold, since this is checked in canExecute
			TraceActionSelection tad = new TraceActionSelection(Display.getCurrent().getActiveShell(), marker, (Element) selectedElement);
			tad.open();
			if (tad.getReturnCode() == IDialogConstants.OK_ID) {
				Object[] result = tad.getResult();
				String traceAction = (String) result[0];
				String traceMechanism = (String) result[1];
				try {
					marker.setAttribute(TracepointConstants.traceAction, traceAction);
					marker.setAttribute(TracepointConstants.traceMechanism, traceMechanism);
				} catch (CoreException e) {
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canExecute() {
		if (selectedElement != null) {
			updateResourceAndURI();
			IMarker marker = findMarker(TracepointConstants.tracepointMarker);
			if (marker != null) {
				return marker.getAttribute(TracepointConstants.isTracepoint, false);
			}
		}
		return false;
	}
}
