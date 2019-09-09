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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

/**
 * Some utilities for dealing with IEditorParts and File editor inputs
 *
 */
public class EditorUtils {

	/**
	 * Returns the IEditorPart associated with the given model element.
	 * If no IEditorPart is available in the workbench, a new one is created.
	 *
	 * @param modelElement
	 *            The modelElement for which an IEditorPart is requested
	 * @return The IEditorPart associated with the given model element.
	 */
	public static IEditorPart getEditorPart(EObject modelElement) {
		if (!modelElement.eIsProxy()) {
			return getEditorPart(modelElement.eResource().getURI().toString());
		}
		IEditorPart part = null;
		// Need to open a new editor
		final FileEditorInput input = getFileEditorInput(modelElement);
		OpenPapyrusEditorRunnable runnable = new OpenPapyrusEditorRunnable(input);
		Display.getDefault().syncExec(runnable);
		part = runnable.getEditorPart();

		return part;
	}

	/**
	 * Returns the IEditorPart associated with the Resource depicted by the given resourceURI string.
	 * If no IEditorPart is available in the workbench, a new one is created.
	 *
	 * @param resourceURI
	 *            The string representation of the resource URI for which an IEditorPart is requested
	 * @return The IEditorPart associated with the given resource URI.
	 */
	public static IEditorPart getEditorPart(String resourceURI) {
		// FIXME this snippet of code is not robust
		String[] splitted = resourceURI.split("/");
		String resourceName = splitted[splitted.length - 1].replaceAll("\\.uml$", ".di");
		IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
		IEditorPart part = null;
		for (int i = 0; i < windows.length && part == null; i++) {
			IWorkbenchPage[] pages = windows[i].getPages();
			for (int j = 0; j < pages.length && part == null; j++) {
				IEditorReference[] editorReferences = pages[j].getEditorReferences();
				for (int k = 0; k < editorReferences.length && part == null; k++) {
					IEditorReference ref = editorReferences[k];
					IEditorPart cdd = ref.getEditor(false);
					if (cdd instanceof IMultiDiagramEditor) {
						String cddName = cdd.getEditorInput().getName();
						if (cddName.equals(resourceName)) {
							part = cdd;
						}
					}
				}
			}
		}
		if (part == null) {
			// Need to open a new editor
			final FileEditorInput input = getFileEditorInput(resourceURI);
			OpenPapyrusEditorRunnable runnable = new OpenPapyrusEditorRunnable(input);
			Display.getDefault().syncExec(runnable);
			part = runnable.getEditorPart();

		}

		return part;
	}

	/**
	 * Returns a File Editor Input for the given model element.
	 * This shall be understood as "The FileEditorInput which shall be used
	 * to retrieve or construct the appropriate IEditorPart"
	 *
	 * @param modelElement
	 *            The model element for which a File Editor Input is requested
	 * @return The FileEditorInput which shall be used to retrieve or construct the appropriate IEditorPart for editing this model element
	 */
	public static FileEditorInput getFileEditorInput(EObject modelElement) {
		EObject resolvedElement = modelElement;
		if (resolvedElement.eIsProxy()) {
			// Tries to resolve in a new resource set
			resolvedElement = EcoreUtil.resolve(modelElement, new ResourceSetImpl());
		}
		return getFileEditorInput(resolvedElement.eResource().getURI().toString());
	}

	/**
	 * Returns a File Editor Input for the given resource URI string.
	 *
	 * @param resourceURI
	 *            The string representing the resource URI for which a FileEditorInput is requested
	 * @return a File Editor Input for the given resource URI string.
	 */
	public static FileEditorInput getFileEditorInput(String resourceURI) {
		Resource newResource = new ResourceSetImpl().createResource(URI.createURI(resourceURI.replaceAll("\\.uml$", ".di")));
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();
		IFile modelElementIFile = (IFile) workspaceRoot.findMember(newResource.getURI().toPlatformString(true));
		if (modelElementIFile == null) {
			return null;
		}
		return new FileEditorInput(modelElementIFile);
	}

}
