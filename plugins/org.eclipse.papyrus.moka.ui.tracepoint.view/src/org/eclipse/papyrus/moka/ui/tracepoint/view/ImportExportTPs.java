/*****************************************************************************
 * Copyright (c) 2020 CEA LIST.
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

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.ui.actions.ExportBreakpointsOperation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;

/**
 * Support the import and export of tracepoints
 */
public class ImportExportTPs {
	public static final String DOT_UML = ".uml"; //$NON-NLS-1$
	public static final String DOT_TPOINTS = ".tpoints"; //$NON-NLS-1$

	public static final String TRACEPOINT_FILES = "Tracepoint files"; //$NON-NLS-1$
	// extension to use for trace-point files

	/**
	 * Import tracepoints from an interactively chosen file
	 */
	public static void importTracepoints() {
		try {
			IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			IFile file = null;
			String defaultDir;
			if (part.getEditorInput() instanceof IFileEditorInput) {
				file = ((IFileEditorInput) part.getEditorInput()).getFile();
			}
			// two cases.
			// 1. An editor is currently open => select directory of open file
			// 2. Choose workspace
			if (file != null) {
				defaultDir = FileLocator.resolve(file.getParent().getLocationURI().toURL()).getFile();
			} else {
				defaultDir = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
			}

			Shell shell = Display.getCurrent().getActiveShell();
			FileDialog fd = new FileDialog(shell, SWT.OPEN);
			fd.setText("Import Tracepoints");
			String[] filterExt = { "*" + DOT_TPOINTS }; //$NON-NLS-1$
			String[] filterNames = { TRACEPOINT_FILES };
			fd.setFilterExtensions(filterExt);
			fd.setFilterPath(defaultDir);
			fd.setFilterNames(filterNames);
			String fileName = fd.open();
			if (fileName != null) {
				ImportTracepointsOperation importAction = new ImportTracepointsOperation(fileName);
				importAction.run(new NullProgressMonitor());
			}
		} catch (InvocationTargetException e) {
			Activator.log.error(e);
		} catch (IOException e) {
			Activator.log.error(e);
		}
	}

	/**
	 * Export the passed list of tracepoints to a file interactively chosen
	 * 
	 * @param tracepoints
	 *            a list of tracepoints
	 */
	public static void exportTracepoints(List<IBreakpoint> tracepoints) {
		if (tracepoints.size() > 0) {
			try {
				IBreakpoint tracepArray[] = tracepoints.toArray(new IBreakpoint[0]);
				// propose filename related to model of first breakpoint
				IBreakpoint firstTP = tracepoints.get(0);
				IResource resource = firstTP.getMarker().getResource();

				String defaultFN = resource.getName().replace(DOT_UML, DOT_TPOINTS);
				String defaultDir = FileLocator.resolve(resource.getParent().getLocationURI().toURL()).getFile();

				Shell shell = Display.getCurrent().getActiveShell();
				FileDialog fd = new FileDialog(shell, SWT.SAVE);
				fd.setText("Export Tracepoints");
				String[] filterExt = { "*" + DOT_TPOINTS }; //$NON-NLS-1$
				String[] filterNames = { TRACEPOINT_FILES };
				fd.setFilterExtensions(filterExt);
				fd.setFileName(defaultFN);
				fd.setFilterPath(defaultDir);
				fd.setFilterNames(filterNames);
				String fileName = fd.open();
				if (fileName != null) {
					ExportBreakpointsOperation exportAction = new ExportBreakpointsOperation(tracepArray, fileName);
					exportAction.run(new NullProgressMonitor());
				}
			} catch (InvocationTargetException e) {
				Activator.log.error(e);
			} catch (IOException e) {
				Activator.log.error(e);
			}
		}
	}
}
