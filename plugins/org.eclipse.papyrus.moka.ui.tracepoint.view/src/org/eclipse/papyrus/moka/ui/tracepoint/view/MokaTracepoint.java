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
package org.eclipse.papyrus.moka.ui.tracepoint.view;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.model.Breakpoint;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;

/**
 * Implementation of IBreakpoint provided by Moka.
 * MokaBreakpoint relies on markers of type MokaConstants.MOKA_BREAKPOINT_MARKER_ID,
 * which extend both papyrus model marker and eclipse breakpoint marker.
 *
 */
public class MokaTracepoint extends Breakpoint {

	public MokaTracepoint(IMarker marker) {
		try {
			setMarker(marker);
		} catch (CoreException e) {
			//Activator.log.error(e);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.debug.core.model.IBreakpoint#getModelIdentifier()
	 */
	public String getModelIdentifier() {
		return MokaConstants.MOKA_DEBUG_MODEL_ID;
	}
}
