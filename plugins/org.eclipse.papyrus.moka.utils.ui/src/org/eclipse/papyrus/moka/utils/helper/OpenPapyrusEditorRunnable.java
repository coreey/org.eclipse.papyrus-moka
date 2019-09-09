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
package org.eclipse.papyrus.moka.utils.helper;

import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

/**
 * A runnable to open a new Papyrus editor from a file editor input
 *
 */
public class OpenPapyrusEditorRunnable implements Runnable {

	/**
	 * The file editor input from which an IEditorPart has to be constructed and added to the workbench
	 */
	protected FileEditorInput input;

	protected IEditorPart part;

	public OpenPapyrusEditorRunnable(FileEditorInput input) {
		this.input = input;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			this.part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, MokaConstants.PAPYRUS_EDITOR_ID);
		} catch (PartInitException e) {
			Activator.log.error(e);
		}
	}

	/**
	 * Returns the created IEditorPart
	 * This method shall be called only after run() has been executed
	 *
	 * @return The created IEditorPart
	 */
	public IEditorPart getEditorPart() {
		return this.part;
	}

}
