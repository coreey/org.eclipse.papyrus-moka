/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.profiling.Semantics.Loci;

import org.eclipse.papyrus.moka.fuml.profiling.MokaObservable;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.service.IMokaExecutionListener;
import org.eclipse.uml2.uml.Class;

public aspect LocusProfiler extends MokaObservable{
	
	pointcut instantiate(ILocus locus, Class type): 
		target(locus) &&
		args(type) &&
		call(* ILocus.instantiate(Class));

	after(ILocus locus, Class type) returning(IObject_ instance) : instantiate(locus, type){
		this.fireValueCreated(instance);
	}
	
	pointcut destroy(ILocus locus, IExtensionalValue value): 
		target(locus) &&
		args(value) &&
		call(* ILocus.remove(IExtensionalValue));
	
	after(ILocus locus, IExtensionalValue value): destroy(locus, value){
		this.fireValueDestroyed(value);
	}
	
	public void fireValueCreated(final IValue value){
		for(int i=0; i < this.listeners.size(); i++){
			IMokaExecutionListener listener = this.listeners.get(i); 
			listener.valueCreated(value);			
		}
	}
	
	public void fireValueDestroyed(final IValue value){
		for(int i=0; i < this.listeners.size(); i++){
			IMokaExecutionListener listener = this.listeners.get(i); 
			listener.valueDestroyed(value);
		}
	} 
}