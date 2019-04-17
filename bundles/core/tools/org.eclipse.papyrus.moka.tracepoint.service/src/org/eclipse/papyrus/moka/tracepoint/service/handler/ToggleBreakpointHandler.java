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
package org.eclipse.papyrus.moka.tracepoint.service.handler;

import org.eclipse.emf.common.command.Command;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.moka.tracepoint.service.commands.ToggleBreakpointCommand;

/**
 * A handler for managing creation/destruction of a Breakpoint
 *
 */
public class ToggleBreakpointHandler extends AbstractCommandHandler {

	@Override
	protected Command getCommand() {
		return new GMFtoEMFCommandWrapper(new ToggleBreakpointCommand(getSelectedElement()));
	}

}
