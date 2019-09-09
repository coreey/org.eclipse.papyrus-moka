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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointManager;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.moka.debug.breakpoint.MokaBreakpoint;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;

/**
 * A handler for managing creation/destruction of a Moka Breakpoint
 *
 */
public class ToggleBreakpointHandler extends MokaAbstractHandler implements IHandler {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EObject selectedElement = this.getSelectedElement();
		String selectedElementURI = EcoreUtil.getURI(selectedElement).toString();
		if (selectedElement != null) {
			IBreakpointManager breakpointManager = DebugPlugin.getDefault().getBreakpointManager();
			IBreakpoint[] breakpoints = breakpointManager.getBreakpoints(MokaConstants.MOKA_DEBUG_MODEL_ID);
			IBreakpoint alreadyDefinedBreakpoint = null;
			for (int i = 0; i < breakpoints.length && alreadyDefinedBreakpoint == null; i++) {
				MokaBreakpoint breakpoint = (MokaBreakpoint) breakpoints[i];
				String eObjectOfBreakpointUri = null;
				try {
					eObjectOfBreakpointUri = (String) breakpoint.getMarker().getAttribute(EValidator.URI_ATTRIBUTE);
				} catch (CoreException e) {
					Activator.log.error(e);
				}
				if (eObjectOfBreakpointUri.equals(selectedElementURI)) {
					alreadyDefinedBreakpoint = breakpoint;
				}
			}
			try {
				if (alreadyDefinedBreakpoint != null) {
					breakpointManager.removeBreakpoint(alreadyDefinedBreakpoint, true);
				} else {
					MokaBreakpoint breakpoint = new MokaBreakpoint();
					breakpoint.toggleBreakpoint(selectedElement);
					breakpointManager.addBreakpoint(breakpoint);
				}
			} catch (CoreException e) {
				Activator.log.error(e);
			}
			return null;
		}

		return null;
	}

}
