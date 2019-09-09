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
package org.eclipse.papyrus.moka.trace.capture;

import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.trace.interfaces.capture.ITraceCaptureService;
import org.eclipse.papyrus.moka.trace.model.mokatraceservice.MokaTrace;


public class ActivityNodeActivationTracer implements ITraceCaptureService {

	public static final ActivityNodeActivationTracer INSTANCE = new ActivityNodeActivationTracer();

	@Override
	public void traceBeforeNode(ISemanticVisitor nodeVisitor, MokaTrace trace) {
		// TODO Auto-generated method stub

	}

	@Override
	public void traceAfterNode(ISemanticVisitor nodeVisitor, MokaTrace trace) {
		// TODO Auto-generated method stub

	}

}
