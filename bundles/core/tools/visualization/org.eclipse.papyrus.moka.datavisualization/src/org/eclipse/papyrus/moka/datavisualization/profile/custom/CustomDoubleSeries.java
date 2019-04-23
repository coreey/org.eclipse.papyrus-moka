/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
 *  David LOPEZ BETANCUR (CEA LIST)
 *  Sebastien REVOL (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.datavisualization.profile.custom;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.eclipse.papyrus.moka.datavisualization.profile.impl.DoubleSeriesImpl;
import org.eclipse.papyrus.moka.datavisualization.util.VisualizationUtil;

public class CustomDoubleSeries extends DoubleSeriesImpl {

	public CustomDoubleSeries() {
		// we modify the default value in order to force serialization
		binaryString = "";
	}

	@Override
	public String getStringValue(int index) {
		return getValues().get(index).toString();
	}

	@Override
	public int getSize() {
		return getValues().size();
	}

	@Override
	public void setBinaryString(String newBinaryString) {
		VisualizationUtil.initValuesFromBinaryString(this, newBinaryString);
	}

	@Override
	public String getBinaryString() {
			return VisualizationUtil.getBinaryString(this);

	}

	
}
