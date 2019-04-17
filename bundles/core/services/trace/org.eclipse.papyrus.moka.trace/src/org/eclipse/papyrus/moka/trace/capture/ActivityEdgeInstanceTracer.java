/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.trace.capture;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.trace.interfaces.capture.ITraceCaptureService;
import org.eclipse.papyrus.moka.trace.model.mokatraceservice.MokaTrace;

public class ActivityEdgeInstanceTracer implements ITraceCaptureService {

	public static final ActivityEdgeInstanceTracer INSTANCE = new ActivityEdgeInstanceTracer();

	@Override
	public void traceBeforeNode(ISemanticVisitor nodeVisitor, MokaTrace trace) {
		// TODO Auto-generated method stub

	}

	@Override
	public void traceAfterNode(ISemanticVisitor nodeVisitor, MokaTrace trace) {
		// TODO Auto-generated method stub

	}

}
