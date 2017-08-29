/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.moka.fmu.control.queue;

import java.util.List;

import org.eclipse.papyrus.moka.fmi.profile.util.FMIProfileUtil;
import org.eclipse.papyrus.moka.fmu.engine.semantics.FMUObject;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.control.execution.RootExecution;
import org.eclipse.uml2.uml.Class;

public class FMIRootExecution extends RootExecution {

	// FMU instance registered in the locus
	protected FMUObject fmuObject;
	
	public FMIRootExecution(Class classifier, List<IParameterValue> inputParameterValues, ILocus locus){
		super(classifier, inputParameterValues, locus);
	}
	
	public FMUObject getFMUObject(){
		// Return the FMU instance corresponding to the class.
		if(this.fmuObject == null && FMIProfileUtil.isCS_FMU(this.classifier)) {
			this.fmuObject = (FMUObject) this.locus.instantiate(this.classifier);
			this.fmuObject.init();
		}
		return this.fmuObject;
	}
	
	@Override
	public void execute() {
		// If the class to execute is an FMU then instantiate the corresponding
		// object and start its classifier behavior. In any other situation apply
		// the regular instantiation strategy.
		if(FMIProfileUtil.isCS_FMU(this.classifier)) {
			if(this.fmuObject == null) {
				this.getFMUObject();
			}
			this.fmuObject.startBehavior(this.classifier, this.parameterValues);
		}else {
			super.execute();
		}
	}

}