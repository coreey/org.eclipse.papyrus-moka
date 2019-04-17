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
import org.eclipse.papyrus.moka.tracepoint.service.TraceActions;
import org.eclipse.papyrus.moka.tracepoint.service.TraceMechanism;
import org.eclipse.papyrus.moka.tracepoint.service.TracepointConstants;


public class ToggleTracepointCommand extends AbstractTracepointCommand {

	public ToggleTracepointCommand(EObject selectedElement) {
		super("Toggle tracepoint", TransactionUtil.getEditingDomain(selectedElement), selectedElement); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		updateResourceAndURI();
		try {
			IMarker marker = toggleMarker();
			if (marker != null) {
				marker.setAttribute(TracepointConstants.isTracepoint, true);
				// set default options from preferences
				marker.setAttribute(TracepointConstants.traceAction, TraceActions.actionFromPreferences(selectedElement));
				marker.setAttribute(TracepointConstants.traceMechanism, TraceMechanism.getDefaultMechanism(selectedElement));
			}
		} catch (CoreException e) {

		}
		return null;
	}
}
