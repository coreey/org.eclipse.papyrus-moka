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

package org.eclipse.papyrus.moka.fuml.control.execution;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;

public class RootExecution extends Execution{

	// The model element executed in the context of the
	// root execution.
	protected Class classifier;
	
	public RootExecution(){
	}
	
	public RootExecution(Class classifier, List<IParameterValue> inputParameterValues, ILocus locus){
		this.classifier = classifier;
		this.setInputParameterValues(inputParameterValues);
		this.locus = locus;
	}
	
	public void setInputParameterValues(List<IParameterValue> inputParameterValues){
		// Set input parameter values of the root execution
		for(IParameterValue inputParameterValue : inputParameterValues){
			this.setParameterValue(inputParameterValue);
		}
	}
	
	@Override
	public void execute() {
		// If the model element is a behavior then it gets executed through the locus executor.
		// Outputs of this execution are made available through the parameter values of the
		// root execution.
		// [TODO: handle the case were the model element is an active class]
		if(this.classifier instanceof Behavior){
			List<IParameterValue> outputParameterValues = this.locus.getExecutor().execute((Behavior)this.classifier, null, this.parameterValues);
			for(IParameterValue parameterValue : outputParameterValues){
				this.setParameterValue(parameterValue);
			}
		}
	}

	@Override
	public IValue new_() {
		return new RootExecution();
	}
	
	@Override
	public List<Classifier> getTypes() {
		List<Classifier> types = new ArrayList<Classifier>();
		types.add(this.classifier);
		return types;
	}
	
	
	@Override
	public String toString() {
		return "RootExecution()";
	}
}
