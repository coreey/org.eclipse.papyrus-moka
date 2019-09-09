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
package org.eclipse.papyrus.moka.trace.interfaces.capture;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.trace.model.mokatraceservice.MokaTrace;

/**
 * This interface define the Capture factory
 */
public interface ICaptureServiceFactory {

	public ITraceCaptureService getCaptureService(ISemanticVisitor visitor);

	public MokaTrace createTraceElement();

	public void startTraceElement(MokaTrace trace);

	public void endTraceElement(MokaTrace trace);

	public boolean isVisitorConcernedByTracepoints(Set<EObject> tracedElement, ISemanticVisitor visitor);

	public String getName();

	public void setName(String name);

	public String getId();

	public void setId(String id);

}