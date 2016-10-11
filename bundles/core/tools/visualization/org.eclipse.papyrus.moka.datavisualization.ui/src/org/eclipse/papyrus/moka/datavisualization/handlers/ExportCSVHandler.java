/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
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
package org.eclipse.papyrus.moka.datavisualization.handlers;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.papyrus.infra.ui.command.AbstractCommandHandler;
import org.eclipse.papyrus.moka.datavisualization.profile.DataSource;
import org.eclipse.papyrus.moka.datavisualization.ui.dialogs.ExportImportCSVDialog;
import org.eclipse.papyrus.moka.datavisualization.util.VisualizationUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.util.UMLUtil;

public class ExportCSVHandler extends AbstractCommandHandler {

	@Override
	protected Command getCommand(IEvaluationContext context) {
		EObject selectedElement = getSelectedElement();

		if (selectedElement instanceof DataType) {
			DataType dataType = (DataType) selectedElement;
			DataSource dataSource = UMLUtil.getStereotypeApplication(dataType, DataSource.class);
			if (dataSource != null) {
				return new RecordingCommand(getEditingDomain(context)) {

					@Override
					protected void doExecute() {
						ExportImportCSVDialog dialog = new ExportImportCSVDialog(Display.getCurrent().getActiveShell(), dataType.getName(), true);
						if (Dialog.OK == dialog.open()) {
							String targetFile = dialog.getSelectedPath();
							String separator = dialog.getSeparator();
							VisualizationUtil.exportCSV(dataSource, targetFile, separator);
						}

					}
				};


			}

		}
		return null;
	}



}
