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
package org.eclipse.papyrus.moka.tracepoint.service;



public class TracepointConstants {

	/**
	 * The id of the marker used for tracepoints and breakpoints
	 */
	public static final String tracepointMarker = "org.eclipse.papyrus.tracepointmarker"; //$NON-NLS-1$

	public static final String isActive = "isActive"; //$NON-NLS-1$

	/**
	 * if true, marker is a tracepoint. Otherwise it is a breakpoint.
	 * TODO remove this property since every marker is tracepoint
	 */
	public static final String isTracepoint = "isTracepoint"; //$NON-NLS-1$

	public static final String traceAction = "traceAction"; //$NON-NLS-1$

	public static final String traceMechanism = "traceMechanism"; //$NON-NLS-1$
}
