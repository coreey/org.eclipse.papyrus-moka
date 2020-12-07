/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
 *  Ansgar Radermacher (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.tracepoint.service.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public class TPPreferenceConstants {

	/**
	 * The trace mechanism that should be used by default
	 */
	public static final String P_TRACE_IMPLEMENTATION = "papyrus.trace.implementation"; //$NON-NLS-1$

	/**
	 * Options for class trace options
	 */
	public static final String P_TRACE_OPTION_CLASS = "papyrus.trace.option.class"; //$NON-NLS-1$

	/**
	 * Options for state trace options
	 */
	public static final String P_TRACE_OPTION_STATE = "papyrus.trace.option.state"; //$NON-NLS-1$

	/**
	 * Options for state trace options
	 */
	public static final String P_TRACE_OPTION_PORT = "papyrus.trace.option.port"; //$NON-NLS-1$

	/**
	 * Options for trnasition trace options
	 */
	public static final String P_TRACE_OPTION_TRANSITION = "papyrus.trace.option.transition"; //$NON-NLS-1$

	/**
	 * Options for trace implementation via state machines
	 */
	public static final String P_TRACE_OPTION_OP = "papyrus.trace.option.op"; //$NON-NLS-1$
}
