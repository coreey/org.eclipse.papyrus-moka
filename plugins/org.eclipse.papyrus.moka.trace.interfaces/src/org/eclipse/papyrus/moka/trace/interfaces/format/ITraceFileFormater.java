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
