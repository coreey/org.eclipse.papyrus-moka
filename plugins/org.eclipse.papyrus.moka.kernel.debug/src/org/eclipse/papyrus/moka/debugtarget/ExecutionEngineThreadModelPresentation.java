/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
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
package org.eclipse.papyrus.moka.debugtarget;

import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.moka.kernel.SuspensionReasons;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;

public class ExecutionEngineThreadModelPresentation implements IDebugModelPresentation {

	/**
	 * ID of the UML debug model
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.moka.kernel.debug.model.presentation";

	@Override
	public String getText(Object element) {
		if (element instanceof IExecutionEngineThread) {
			IExecutionEngineThread executionThread = (IExecutionEngineThread) element;
			if (executionThread.isSuspended()) {
				StringBuilder label = new StringBuilder();
				label.append(((IExecutionEngineThread) element).getID());
				if (executionThread.getSuspensionReason() == SuspensionReasons.ERROR_DETECTION) {
					label.append(" (suspended due to missing expected tokens)");
				} else if (executionThread.getSuspensionReason() == SuspensionReasons.BREAKPOINT) {
					label.append(" (suspend on breakpoint)");
				}
				return label.toString();
			}
		}
		return null;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		// do nothing
	}

	@Override
	public void dispose() {
		// do nothing
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// do nothing
	}

	@Override
	public IEditorInput getEditorInput(Object element) {
		return null;
	}

	@Override
	public String getEditorId(IEditorInput input, Object element) {
		return null;
	}

	@Override
	public void setAttribute(String attribute, Object value) {
		// do nothing
	}

	@Override
	public Image getImage(Object element) {
		return null;
	}

	@Override
	public void computeDetail(IValue value, IValueDetailListener listener) {
		// do nothing
	}

}
