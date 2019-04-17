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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


/**
 * The trace mechanism itself is not specific for specific implementations such
 * as instrumenting code generators. Thus, the following interface may be defined
 * by extensions that provide an implementation of a trace point.
 * The first operation gets a set of available trace implementations that are supplied
 * by the extension (in conjunction with other mechanisms).
 * This interface is used for mechanisms that have a way of implementing trace point
 *
 * @author ansgar
 *
 */
public interface ITraceMechanism {

	/**
	 * @param eObj
	 *            the element on which tracing is applied. It is passed, since the
	 *            list of available trace mechanisms may depend on this object
	 * @return a list of IDs corresponding to available trace mechanisms
	 */
	EList<String> getTraceMechanismIDs(EObject eObj);

	/**
	 * Provide a description of the trace mechanism
	 *
	 * @param id
	 *            the id of the trace mechanism
	 * @return its description
	 */
	String getTraceMechanismDescription(EObject eObj, String id);

	/**
	 * Apply the tracing. This usually means that an implementation specific
	 * mechanism will add additional information to the EObject, for instance
	 * in form of additional markings or stereotypes (there is no assumption
	 * how this is actually done). The idea is that these markings will be
	 * evaluated during code generation to produce the right result.
	 *
	 * @param id
	 *            the ID of a trace mechanism
	 * @param element
	 *            the element that should be trace
	 * @param traceOption
	 *            an encoded trace option. e.g. that only the called operation
	 *            should be trace and not the values of the passed parameters.
	 */
	boolean applyTraceMechanism(EObject eObj, String id, int traceOption);

	/**
	 * Configure the trace mechanisms for runtime, in particular evaluate activate/inactive
	 * tracepoint settings to obtain a suitable runtime configuration.
	 *
	 * @return true, if successful
	 */
	boolean configureTraceMechanisms();
}
