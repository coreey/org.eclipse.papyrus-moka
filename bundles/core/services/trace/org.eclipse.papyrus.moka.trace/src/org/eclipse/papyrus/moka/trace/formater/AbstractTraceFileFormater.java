/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.trace.formater;

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

}