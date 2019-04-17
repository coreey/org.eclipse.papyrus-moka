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
package org.eclipse.papyrus.moka.trace.interfaces.format;

public interface ITraceFileFormater {

	public String getName();

	public void setName(String name);

	public String getCaptureId();

	public void setCaptureId(String id);

	public String getId();

	public void setId(String id);

	public void rightTrace(String filePath, Object trace);

	public String getFileExtension();

	public void setFileExtension(String fileExtensions);
}
