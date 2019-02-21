/*****************************************************************************
 * 
 * Copyright (c) 2019 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmi.ui.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.TagElement;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.ui.command.AbstractCommandHandler;
import org.eclipse.papyrus.moka.fmi.fmi2uml.FMI2UML;
import org.eclipse.papyrus.moka.fmi.fmu.FMUResource;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType;
import org.eclipse.papyrus.moka.fmi.ui.Activator;
import org.eclipse.papyrus.moka.fmi.ui.dialogs.ImportFMUDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Class;

/**
 * @author Sebastien Revol
 * 
 */
public class ImportFMULibHandler
		extends AbstractCommandHandler

{
	private static final String FMU_FOLDER_NAME="FMU";
	private static final String DEFAULT_LIBRARY_NAME = "FMULibrary";

	public String getLibraryName() {
		String defaultModelLibName = DEFAULT_LIBRARY_NAME;
		ImportFMUDialog dialog = new ImportFMUDialog(
			Display.getCurrent().getActiveShell(), defaultModelLibName);
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		dialog.setPreferenceStore(store);
		dialog.open();

		// If the operation was cancelled, then return
		if (dialog.getReturnCode() != ImportFMUDialog.CANCEL) {
			return dialog.getImportedModelName();
		}
		return null;
	}

	public List<String> getFMUFiles() {
		ArrayList<String> fmuFiles = new ArrayList<>();
		// Retrieve shell instance
		Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();

		FileDialog fd = new FileDialog(shell, SWT.MULTI);
		fd.setText("Select FMU to be imported");
		// fd.setFilterPath(currentProjectDir);
		String[] filterExt = {"*.fmu"};
		fd.setFilterExtensions(filterExt);

		if (fd.open() != null) {
			String folder = fd.getFilterPath();
			for (String name : fd.getFileNames()) {
				fmuFiles.add(folder + File.separator + name);
			}
		}

		return fmuFiles;
	}

	protected static void unloadOpenedFMUs(List<FMUBundle> fmuBundles) {
		for (FMUBundle fmuBundle : fmuBundles) {
			fmuBundle.eResource().unload();
		}

	}

	private static void cleanFolder(IFolder libFolder) {
		try {
			libFolder.delete(false, null);
		} catch (CoreException e) {
			Activator.getDefault().getLog()
				.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					"failed to delete folder "
						+ libFolder.getFullPath().toPortableString()));
		}

	}

	private static void errorDialog(Exception e, String message) {
		ErrorDialog.openError(Display.getCurrent().getActiveShell(),
			"Error", message,
			new Status(IStatus.ERROR, Activator.PLUGIN_ID, message, e));
	}

	private static void errorPopup(String message) {
		MessageBox messageBox = new MessageBox(
			Display.getCurrent().getActiveShell(), SWT.ICON_ERROR);
		messageBox.setMessage(message);
		messageBox.open();
	}

	private boolean libExists(Package targetPackage, String libName) {
		for (Package pack : targetPackage.getNestedPackages()) {
			if (libName.equals(pack.getName())) {
				return true;
			}
		}
		return false;
	}

	
	@Override
	protected Command getCommand(IEvaluationContext context) {
		EObject selection = getSelectedElement();
		if (selection instanceof Package) {
			final Package target = (Package) selection;
			return new RecordingCommand(getEditingDomain(context)) {

				@Override
				protected void doExecute() {
					boolean canContinue = false;
					String libName = null;
					while (!canContinue) {
						libName = getLibraryName();
						if (libName == null) {
							return;
						} else {
							canContinue = !libExists(target, libName);
							if (!canContinue) {
								errorPopup("A library named " + libName
									+ " already exists! Please choose another name");
							}
						}
					}
					URI modelURI = target.eResource().getURI();
					IFile modelIFile = ResourcesPlugin.getWorkspace().getRoot()
						.getFile(new Path(modelURI.toPlatformString(true)));
					IProject project = modelIFile.getProject();
					IFolder libFolder = project.getFolder(libName);
					if (libFolder.exists()) {
						errorPopup("A folder with name " + libName
							+ " already exists in the project "
							+ libFolder.getName() + " Aborting.");
						return;
					}

					try {
						libFolder.create(false, true, null);
					} catch (CoreException e) {
						errorDialog(e, "Could not create library folder"
							+ libFolder.getName());
						return;
					}

					List<String> fmuAndSlxPaths = getFMUFiles();

					importFMUs(target, libName, libFolder, fmuAndSlxPaths);

				}
				
				

			};
		}
		return null;

	}

	// TODO put it into common
	public static void importFMUs(final Package target, String libName,
			IFolder libFolder, List<String> fmuAndSlxPaths) {
		List<FMUBundle> fmuBundles = new ArrayList<>();
		ResourceSet papyResourceSet = target.eResource().getResourceSet();

		for (String filePath : fmuAndSlxPaths) {
			File sourceFile = new File(filePath);
			IFile targetIFile = libFolder.getFile(sourceFile.getName());
			try {
				targetIFile.create(new FileInputStream(sourceFile), true, null);
			} catch (CoreException e) {
				errorDialog(e,
					"Could not copy FMU File " + targetIFile.getName() + " in "+ targetIFile.getLocation());
				cleanFolder(libFolder);
				return;
			} catch (FileNotFoundException e) {
				errorDialog(e, "Could not create FMU file "
					+ libFolder.getFullPath().toOSString() + " in workspace");

			}

			URI fmuURI = URI.createPlatformResourceURI(
				targetIFile.getFullPath().toPortableString(), true);

			FMUResource resource = null;
			try {
				resource = (FMUResource) papyResourceSet.getResource(fmuURI,
					true);
			} catch (Exception e) {
				errorDialog(e, "Error importing fmu " + filePath);
				unloadOpenedFMUs(fmuBundles);
				cleanFolder(libFolder);
				return;
			}

			if (resource != null && resource.getFmuParser() != null) {
				if (resource.getFmuParser().getModelDescription() != null) {
					fmuBundles.add((FMUBundle) resource.getContents().get(0));
				} else {
					errorPopup("Ignoring FMU " + filePath
						+ " since it doesn't contain a modelDescription.xml file.");
				}
			}
		}

		Package libPackage = target.createNestedPackage(libName);

		for (FMUBundle fmuBundle : fmuBundles) {
			FmiModelDescriptionType modelDescription = fmuBundle
				.getModelDescription();

			if (modelDescription != null
				&& !modelDescription.getCoSimulation().isEmpty()) {
				String name = modelDescription.getCoSimulation().get(0)
					.getModelIdentifier();
				Package targetPackage = libPackage.createNestedPackage(name);
				FMI2UML.getFMUClass(fmuBundle, targetPackage);

			} else {
				errorPopup("Ignoring FMU "
					+ modelDescription.eResource().getURI()
						.toPlatformString(true)
					+ " since it doesn't contain a  Cosimulation section.");
			}
		}
	}

	public static List<FMUBundle> loadFMUs(final Package target, String libName,
			URI fmuLibURI, List<String> fmuNames) {
		List<FMUBundle> fmuBundles = new ArrayList<>();
		ResourceSet papyResourceSet = target.eResource().getResourceSet();

		for (String fmuName : fmuNames) {

			URI fmuURI = fmuLibURI.appendSegment(fmuName);

			FMUResource resource = null;
			try {
				resource = (FMUResource) papyResourceSet.getResource(fmuURI,
					true);
			} catch (Exception e) {
				errorDialog(e, "Error importing fmu " + fmuName);
				unloadOpenedFMUs(fmuBundles);
				// cleanFolder(libFolder);
				return null;
			}

			if (resource != null && resource.getFmuParser() != null) {
				if (resource.getFmuParser().getModelDescription() != null) {
					fmuBundles.add((FMUBundle) resource.getContents().get(0));
				} else {
					errorPopup("Ignoring FMU " + fmuName
						+ " since it doesn't contain a modelDescription.xml file.");
				}
			}
		}
		return fmuBundles;
	}

	public static Class createUMLMoldel(Package libPackage,
			FMUBundle fmuBundle) {
		FmiModelDescriptionType modelDescription = fmuBundle
			.getModelDescription();

		if (modelDescription != null
			&& !modelDescription.getCoSimulation().isEmpty()) {
			String name = modelDescription.getCoSimulation().get(0)
				.getModelIdentifier();
			Package targetPackage = libPackage.createNestedPackage(name);
			return FMI2UML.getFMUClass(fmuBundle, targetPackage);

		} else {
			errorPopup("Ignoring FMU "
				+ modelDescription.eResource().getURI().toPlatformString(true)
				+ " since it doesn't contain a  Cosimulation section.");

			return null;
		}
	}

}
