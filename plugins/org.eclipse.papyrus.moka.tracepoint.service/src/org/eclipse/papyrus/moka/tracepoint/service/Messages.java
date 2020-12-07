/**
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.papyrus.moka.tracepoint.service;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.moka.tracepoint.service.messages"; //$NON-NLS-1$

	public static String TPPreferencePage_TraceOptions;
	public static String TPPreferencePage_TRACE_IMPL;

	public static String TraceActionSelection_ClassOptions;
	public static String TraceActionSelection_ImplementationOptions;
	public static String TraceActionSelection_NoPluginsProvideTraceExt;
	public static String TraceActionSelection_NotAvail;
	public static String TraceActionSelection_OperationOptions;
	public static String TraceActionSelection_PortOptions;
	public static String TraceActionSelection_SelectTraceAction;
	public static String TraceActionSelection_StateOptions;
	public static String TraceActionSelection_TransitionOptions;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
