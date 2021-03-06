/*****************************************************************************
 * Copyright (c) 2012, 2019 CEA LIST.
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
 *  Pauline DEVILLe (CEA LIST ) - Bug 546467
 *
 *****************************************************************************/

package org.eclipse.papyrus.moka.ui.breakpoint.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointManager;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.moka.debug.breakpoint.MokaBreakpoint;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;

/**
 * Command to toggle a breakpoint activation
 */
public class ToggleBreakpointActivationCommand extends AbstractTraceAndDebugCommand {

	public ToggleBreakpointActivationCommand(EObject selectedElement) {
		super("Toggle breakpoint activation", TransactionUtil.getEditingDomain(selectedElement), selectedElement); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		String selectedElementURI = EcoreUtil.getURI(selectedElement).toString();
		if (selectedElement != null) {
			IBreakpointManager breakpointManager = DebugPlugin.getDefault().getBreakpointManager();
			IBreakpoint[] breakpoints = breakpointManager.getBreakpoints(MokaConstants.MOKA_DEBUG_MODEL_ID);
			IBreakpoint alreadyDefinedBreakpoint = null;
			for (int i = 0; i < breakpoints.length && alreadyDefinedBreakpoint == null; i++) {
				MokaBreakpoint breakpoint = (MokaBreakpoint) breakpoints[i];
				URI uriOfEObjectOfBreakpoint = breakpoint.getModelElementURI();
				if (uriOfEObjectOfBreakpoint != null
						&& uriOfEObjectOfBreakpoint.toString().equals(selectedElementURI)) {
					alreadyDefinedBreakpoint = breakpoint;
				}
			}

			if (alreadyDefinedBreakpoint != null) {
				try {
					boolean enabledOrDisabled = !alreadyDefinedBreakpoint.isEnabled();
					alreadyDefinedBreakpoint.setEnabled(enabledOrDisabled);
					DebugPlugin.getDefault().getBreakpointManager().fireBreakpointChanged(alreadyDefinedBreakpoint);
				} catch (CoreException e) {
					Activator.log.error(e);
				}
			}
			return null;
		}

		return null;
	}
}
