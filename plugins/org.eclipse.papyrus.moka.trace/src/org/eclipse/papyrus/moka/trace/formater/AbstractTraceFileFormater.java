/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   CEA LIST - Bug 552564
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.trace.formater;

import java.util.StringTokenizer;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.papyrus.moka.trace.interfaces.format.ITraceFileFormater;

public abstract class AbstractTraceFileFormater implements ITraceFileFormater {

	protected String name;

	protected String id;

	protected String captureId;

	protected String fileExtensions;

	public AbstractTraceFileFormater() {
		super();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getFileExtension() {
		return this.fileExtensions;
	}

	@Override
	public void setFileExtension(String fileExtensions) {
		this.fileExtensions = fileExtensions;
	}

	@Override
	public String getCaptureId() {
		return captureId;
	}

	@Override
	public void setCaptureId(String id) {
		this.captureId = id;
	}

	/**
	 * Refresh the workspace in order to make appears the created file.
	 * 
	 * @param outputFolder the folder to refresh (ex:
	 *                     /projectName/folderName1/folderName2)
	 */
	public void refreshWorkspace(String outputFolder) {
		IContainer container;

		int nbToken = new StringTokenizer(outputFolder, "/").countTokens(); //$NON-NLS-1$
		if (nbToken == 1) {// it is a project
			container = ResourcesPlugin.getWorkspace().getRoot().getProject(outputFolder); // only one /
		} else {// it is a folder in a project
			container = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(outputFolder));
		}

		try {
			container.refreshLocal(2, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

}