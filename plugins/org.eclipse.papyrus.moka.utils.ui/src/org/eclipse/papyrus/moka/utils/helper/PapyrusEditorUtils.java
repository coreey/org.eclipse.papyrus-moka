/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.moka.utils.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

public class PapyrusEditorUtils {

	// ID shared by all Papyrus editors
	protected final static String PAPYRUS_EDITOR_ID = "org.eclipse.papyrus.infra.core.papyrusEditor";

	public static List<IMultiDiagramEditor> resolveActiveOpenPapyrusEditors() {
		// Return the list of multi-diagram editors that are active
		List<IMultiDiagramEditor> editors = new ArrayList<IMultiDiagramEditor>();
		for (IEditorReference editorReference : resolveOpenPapyrusEditors()) {
			IEditorPart editorPart = editorReference.getEditor(false);
			if (editorPart != null) {
				editors.add((IMultiDiagramEditor) editorPart);
			}
		}
		return editors;
	}

	public static List<IEditorReference> resolveOpenPapyrusEditors() {
		// Resolve an open editor. If there is one then
		// return it. Otherwise return null
		List<IEditorReference> editorReferences = new ArrayList<IEditorReference>();
		Iterator<IWorkbenchWindow> workbenchWindowsIterator = Arrays
				.asList(PlatformUI.getWorkbench().getWorkbenchWindows()).iterator();
		while (workbenchWindowsIterator.hasNext()) {
			IWorkbenchWindow workbenchWindow = workbenchWindowsIterator.next();
			Iterator<IWorkbenchPage> workbenchPagesIterator = Arrays.asList(workbenchWindow.getPages()).iterator();
			while (workbenchPagesIterator.hasNext()) {
				IWorkbenchPage page = workbenchPagesIterator.next();
				Iterator<IEditorReference> editorReferencesIterator = Arrays.asList(page.getEditorReferences())
						.iterator();
				while (editorReferencesIterator.hasNext()) {
					IEditorReference editorReference = editorReferencesIterator.next();
					if (editorReference.getId().equals(PAPYRUS_EDITOR_ID)) {
						editorReferences.add(editorReference);
					}
				}
			}
		}
		return editorReferences;
	}

	public static boolean existsOpenPapyrusEditor() {
		// Return true if there is an open multi-diagram editor and
		// false otherwise
		return !resolveOpenPapyrusEditors().isEmpty();
	}

	public static ServicesRegistry resolveServiceRegistry() {
		// Return the Papyrus service registry
		Iterator<IMultiDiagramEditor> editorIterator = resolveActiveOpenPapyrusEditors().iterator();
		if (editorIterator.hasNext()) {
			return editorIterator.next().getServicesRegistry();
		}
		return null;
	}

	public static ModelSet resolveModelSet() {
		// This attempts to resolve the Papyrus model set thanks to an open
		// multi-diagram
		// editor.
		ModelSet modelSet = null;
		ServicesRegistry registry = resolveServiceRegistry();
		if (registry != null) {
			try {
				modelSet = registry.getService(ModelSet.class);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		return modelSet;
	}

	public static Resource resolveResource(final String path) {
		// This attempts to resolve a resource on the Papyrus model set. If the
		// resource is not loaded then it is. The resource is returned except if
		// the model set could not be resolved first
		Resource resource = null;
		ModelSet modelSet = resolveModelSet();
		if (modelSet != null) {
			resource = modelSet.getResource(URI.createURI(path), true);
		}
		return resource;
	}

	public static IEditorPart getEditor(final URI modelDIUri) {
		IEditorPart part = null; 
		Iterator<IEditorReference> editorIterator = resolveOpenPapyrusEditors().iterator();
		while (part == null && editorIterator.hasNext()) {
			IEditorReference editorReference = editorIterator.next();
			IEditorInput editorInput = null;
			try {
				editorInput = editorReference.getEditorInput();
			} catch (PartInitException e) {
				e.printStackTrace();
			}
			if (editorInput instanceof FileEditorInput && ((FileEditorInput) editorInput).getFile() != null) {
				URI fileInputURI = URI.createPlatformResourceURI(((FileEditorInput)editorInput).getFile().getFullPath().toString(), true);
				if(fileInputURI.equals(modelDIUri)) {
					part = editorReference.getEditor(false);
				}
			}
		}
		return part;
	}
	
	public static boolean isEditorActivated(final URI modelDIUri) {
		IEditorPart part = getEditor(modelDIUri);
		return part != null && part.getSite().getPage().getActiveEditor() == part;
	}
	
	public static boolean activateEditor(final URI modelDIUri) {
		IEditorPart part = getEditor(modelDIUri);
		if(part != null) {
			Display display = PlatformUI.getWorkbench().getDisplay();
			display.syncExec(new Runnable() {
				@Override
				public void run() {
					part.getSite().getPage().activate(part);
				}
			});
		}
		return isEditorActivated(modelDIUri);
	}
	
	public static boolean isProjectOpen(final URI modelDIUri) {
		// Check if the project is open in an editor. Note that this editor
		// may not be active
		boolean match = false; 
		Iterator<IEditorReference> editorIterator = resolveOpenPapyrusEditors().iterator();
		while (!match && editorIterator.hasNext()) {
			IEditorReference editorReference = editorIterator.next();
			IEditorInput editorInput = null;
			try {
				editorInput = editorReference.getEditorInput();
			} catch (PartInitException e) {
				e.printStackTrace();
			}
			if (editorInput instanceof FileEditorInput && ((FileEditorInput) editorInput).getFile() != null) {
				URI fileInputURI = URI.createPlatformResourceURI(((FileEditorInput)editorInput).getFile().getFullPath().toString(), true);
				match = fileInputURI.equals(modelDIUri);
			}
		}
		return match;
	}

	public static boolean openProject(final IProject project, final URI modelDIUri) {
		// Open the Papyrus project containing the model file that itself
		// contains the execution source.
		IFile modelFile = project.getFile(new Path(modelDIUri.lastSegment()));
		if (modelFile.exists()) {
				Display display = PlatformUI.getWorkbench().getDisplay();
				display.syncExec(new Runnable() {
					@Override
					public void run() {
						try {
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
									.openEditor(new FileEditorInput(modelFile), PAPYRUS_EDITOR_ID);
						} catch (PartInitException e) {
							e.printStackTrace();
						}
					}
				});
		}
		return isProjectOpen(modelDIUri);
	}
	
}
