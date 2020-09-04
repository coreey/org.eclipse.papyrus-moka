/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.profiling.commonbehavior;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IObjectActivation;
import org.eclipse.papyrus.moka.fuml.profiling.MokaObservable;
import org.eclipse.papyrus.moka.fuml.profiling.listeners.IRTCStepListener;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IReference;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.Reference;
import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.kernel.service.IExecutionEngineService;

public aspect ObjectActivationProfiler extends MokaObservable{
	
	pointcut dispatchNextEvent(IObjectActivation objectActivation):
		target(objectActivation) &&
		call(* IObjectActivation.dispatchNextEvent());
	
	before(IObjectActivation objectActivation) :dispatchNextEvent(objectActivation){
		this.notifyStepStart(objectActivation);
	}
	
	after(IObjectActivation objectActivation) : dispatchNextEvent(objectActivation){
		this.notifyStepEnd(objectActivation);
	}
	
	protected void notifyStepStart(IObjectActivation objectActivation) {
		for(IExecutionEngineService<IExecutionEngine> service : getListeners()) {
			if(service instanceof IRTCStepListener) {
				IReference reference = new Reference();
				reference.setReferent(objectActivation.getObject());
				((IRTCStepListener)service).rtcStepBegin(reference);
			}
		}
	}
	
	protected void notifyStepEnd(IObjectActivation objectActivation) {
		for(IExecutionEngineService<IExecutionEngine> service : getListeners()) {
			if(service instanceof IRTCStepListener) {
				IReference reference = new Reference();
				reference.setReferent(objectActivation.getObject());
				((IRTCStepListener)service).rtcStepEnd(reference);
			}
		}
	}

}
