/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.profiling.Semantics.CommonBehaviors.Communications;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IObjectActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Reference;
import org.eclipse.papyrus.moka.fuml.profiling.MokaObservable;
import org.eclipse.papyrus.moka.service.IMokaExecutionListener;
import org.eclipse.papyrus.moka.service.IMokaStepListener;

public aspect ObjectActivationProfiler extends MokaObservable{
	
	pointcut stepStart(IObjectActivation objectActivation):
		target(objectActivation) &&
		call(* IObjectActivation.dispatchNextEvent());
	
	before(IObjectActivation objectActivation) : stepStart(objectActivation){
		this.notifyStepStart(objectActivation);
	}
	
	after(IObjectActivation objectActivation) : stepStart(objectActivation){
		this.notifyStepEnd(objectActivation);
	}
	
	protected void notifyStepStart(IObjectActivation objectActivation) {
		for(IMokaExecutionListener listener : this.listeners) {
			if(listener instanceof IMokaStepListener) {
				IReference reference = new Reference();
				reference.setReferent(objectActivation.getObject());
				((IMokaStepListener)listener).stepStart(reference);
			}
		}
	}
	
	protected void notifyStepEnd(IObjectActivation objectActivation) {
		for(IMokaExecutionListener listener : this.listeners) {
			if(listener instanceof IMokaStepListener) {
				IReference reference = new Reference();
				reference.setReferent(objectActivation.getObject());
				((IMokaStepListener)listener).stepEnd(reference);
			}
		}
	}

}
