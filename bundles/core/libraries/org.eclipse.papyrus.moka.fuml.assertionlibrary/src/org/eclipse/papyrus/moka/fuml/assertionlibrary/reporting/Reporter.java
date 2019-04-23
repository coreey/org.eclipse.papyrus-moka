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

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.papyrus.moka.fuml.assertionlibrary.utils.ReportNameSingleton;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class Reporter {

	protected List<TestReport> testReports;

	private Reporter() {
		this.testReports = new ArrayList<TestReport>();
	}

	public static Reporter INSTANCE = new Reporter();

	public boolean add(TestReport report) {
		// System.out.println(report);
		return this.testReports.add(report);
	}

	public Document getReport() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document xmlReport = builder.newDocument();
		Element testSuiteNode = xmlReport.createElement(JUnit.TEST_SUITE);
		ReportNameSingleton reportNameSingleton = ReportNameSingleton.getInstance();
		String reportName = reportNameSingleton.getExecutedActivityName() + JUnit.REPORTING_SEPARATOR + reportNameSingleton.getEngineName();
		testSuiteNode.setAttribute(JUnit.NAME, reportName); // TODO
		for (TestReport t : this.testReports) {
			testSuiteNode.appendChild(this.toDOMElement(t, xmlReport, reportName));
		}
		xmlReport.appendChild(testSuiteNode);
		this.testReports.clear();
		return xmlReport;
	}

	protected Element toDOMElement(TestReport test, Document context, String prefix) {
		Element testNode = context.createElement(JUnit.TEST_CASE);

		String className;
		if (test.getContext() != null) {
			className = test.getContext().getQualifiedName();
		} else {
			className = "unknown";
		}

		if (prefix != null) {
			className = prefix + JUnit.REPORTING_SEPARATOR + className;
		}

		testNode.setAttribute(JUnit.CLASS_NAME, className);

		testNode.setAttribute(JUnit.NAME, test.getLabel());
		testNode.setAttribute(JUnit.TIME, "0"); // TODO obtain elapsed time per test case
		if (test.getVerdict().equals(TestDecision.FAILED)) {
			Element failureNode = context.createElement(JUnit.FAILURE);
			failureNode.setAttribute(JUnit.MESSSAGE, test.getLabel());
			failureNode.setAttribute(JUnit.TYPE, test.getAssertionType().getName());
			testNode.appendChild(failureNode);
		}
		return testNode;
	}

	protected Element toDOMElement(TestReport test, Document context) {
		return toDOMElement(test, context, null);
	}
}
