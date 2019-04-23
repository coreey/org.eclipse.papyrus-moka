/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.assertionlibrary.reporting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.Activator;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.utils.ReportNameSingleton;
import org.w3c.dom.Document;


public class GenerateTestReport extends OpaqueBehaviorExecution {

	@Override
	public void doBody(List<IParameterValue> inputParameters, List<IParameterValue> outputParameters) {
		Document report = null;
		Transformer transformer = null;
		TransformerFactory factory = TransformerFactory.newInstance();
		ReportNameSingleton reportNameSingleton = ReportNameSingleton.getInstance();
		String reportName = reportNameSingleton.getExecutedActivityName() + reportNameSingleton.getEngineName();

		try {
			report = Reporter.INSTANCE.getReport();
		} catch (ParserConfigurationException e) {
			Activator.log.error(e);
		}

		try {
			transformer = factory.newTransformer();
		} catch (TransformerConfigurationException e) {
			Activator.log.error(e);
		}
		if (transformer != null) {
			this.writeReport(transformer, report, Platform.getInstanceLocation().getURL(), reportName);
			// System.out.println(Platform.getInstanceLocation().getURL());
		}
	}

	protected boolean writeReport(Transformer transformer, Document report, URL location, String reportName) {
		File file = new File(location.getPath() + "/" + reportName + ".xml");
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file, false);
		} catch (FileNotFoundException e1) {
			Activator.log.error(e1);
			return false;
		}
		try {
			transformer.transform(new DOMSource(report), new StreamResult(out));
		} catch (TransformerException e) {
			Activator.log.error(e);
			return false;
		}
		return true;
	}

	@Override
	public Value new_() {
		return new GenerateTestReport();
	}

}
