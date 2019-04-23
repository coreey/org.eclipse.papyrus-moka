/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
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
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.datavisualization.handlers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.papyrus.infra.ui.command.AbstractCommandHandler;
import org.eclipse.papyrus.moka.datavisualization.ui.dialogs.ExportImportCSVDialog;
import org.eclipse.papyrus.moka.datavisualization.util.VisualizationUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Package;


public class ImportCSVHandler extends AbstractCommandHandler {

	@Override
	protected Command getCommand(IEvaluationContext context) {
		EObject selectedElement = getSelectedElement();

		if (selectedElement instanceof Package) {
			Package targetPackage = (Package) selectedElement;

				return new RecordingCommand(getEditingDomain(context)) {

					@Override
					protected void doExecute() {
						ExportImportCSVDialog dialog = new ExportImportCSVDialog(Display.getCurrent().getActiveShell(), null, false);
						URL inputModelURL;
						try {
							inputModelURL = new URL(targetPackage.eResource().getURI().toString());
							URL resolvedURL = FileLocator.toFileURL(inputModelURL);
							dialog.setDefaultPath(resolvedURL.toString());
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						if (Dialog.OK == dialog.open()) {
							String targetFile = dialog.getSelectedPath();
							String separator = dialog.getSeparator();
							VisualizationUtil.importCSV(targetPackage, targetFile, separator);
						}

					}
				};


			}

		return null;
	}



}
