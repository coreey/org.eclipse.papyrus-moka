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
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;


public class ToggleTracepointActivationCommand extends AbstractTracepointCommand {

	public ToggleTracepointActivationCommand(EObject selectedElement) {
		super("Toggle tracepoint activation", TransactionUtil.getEditingDomain(selectedElement), selectedElement); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		updateResourceAndURI();
		toggleMarkerActivation();
		return null;
	}
}
