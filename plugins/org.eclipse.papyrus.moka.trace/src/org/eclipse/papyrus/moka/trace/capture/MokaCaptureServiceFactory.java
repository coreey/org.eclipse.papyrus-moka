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

import org.eclipse.papyrus.moka.fuml.activities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.activities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.trace.interfaces.capture.ICaptureServiceFactory;
import org.eclipse.papyrus.moka.trace.interfaces.capture.ITraceCaptureService;
import org.eclipse.papyrus.moka.trace.model.mokatraceservice.MokaTrace;
import org.eclipse.papyrus.moka.trace.model.mokatraceservice.MokaTraceServiceFactory;

public class MokaCaptureServiceFactory extends AbstractCaptureServiceFactory implements ICaptureServiceFactory {

	public static final String MOKA_ENGINE_ID = "org.eclipse.papyrus.moka.trace.capture.mokaCaptureService"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.papyrus.moka.trace.interfaces.capture.ICaptureServiceFactory#getCaptureService(org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor)
	 *
	 * @param visitor
	 * @return
	 */
	@Override
	public ITraceCaptureService getCaptureService(ISemanticVisitor visitor) {
		if (visitor instanceof IActivityNodeActivation) {
			return ActivityNodeActivationTracer.INSTANCE;
		} else if (visitor instanceof IActivityEdgeInstance) {
			return ActivityEdgeInstanceTracer.INSTANCE;
		}
		return null;
	}

	@Override
	public MokaTrace createTraceElement() {
		return MokaTraceServiceFactory.eINSTANCE.createMokaTrace();
	}

	@Override
	public void startTraceElement(MokaTrace trace) {
		// do nothing
	}

	@Override
	public void endTraceElement(MokaTrace trace) {
		// do nothing
	}

}
