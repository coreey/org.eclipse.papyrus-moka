/*****************************************************************************
 * 
  * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/

package org.eclipse.papyrus.moka.fmi.master.jnr;
/*****************************************************************************
 * 
  * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/


import org.eclipse.papyrus.moka.fmi.master.jnr.JNRFMUInterface.Fmi2Status;

import jnr.ffi.Memory;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import jnr.ffi.annotations.Delegate;
import jnr.ffi.provider.ClosureManager;

public class FMI2Callbacks extends Struct {


	public interface FMI2Logger {
		@Delegate
		public void call(jnr.ffi.Pointer cmp, java.lang.String cmpName, int status, java.lang.String category, java.lang.String message);
	}
	public interface FMI2AllocateMemory {
		@Delegate
		public jnr.ffi.Pointer call(@jnr.ffi.types.size_t int numberOfObjects, @jnr.ffi.types.size_t int size);
		
	}
	public interface FMI2FreeMemory {
		@Delegate
		public void call(jnr.ffi.Pointer object);
	}
	public interface FMI2StepFinished {
		@Delegate
		public void invoke(jnr.ffi.Pointer fmiComponent, Fmi2Status status);
	}
	
	//private constructor, we only get direct memory pointers
	private FMI2Callbacks(Runtime runtime) {
		super(runtime);
	}


	public final Pointer logger = new Pointer();
	public final Pointer allocateMemory =new Pointer() ;
	public final Pointer freeMemory =new Pointer(); 
	public final Pointer stepFinished =new Pointer();
	public final Pointer componentEnvironment = new Pointer();
	
	public static jnr.ffi.Pointer getStructDirectPointer(FMI2Logger loggerParam, FMI2AllocateMemory allocatorParam, FMI2FreeMemory freeMemParam, FMI2StepFinished stepFinishedParam) {
		Runtime runtime = Runtime.getSystemRuntime();
		FMI2Callbacks tmpStruct = new FMI2Callbacks(runtime);
		jnr.ffi.Pointer ret=  Memory.allocateDirect(runtime, Struct.size(tmpStruct));
		
		ClosureManager closureManager = runtime.getClosureManager();	
		if (loggerParam != null){
			ret.putPointer(tmpStruct.logger.offset(), closureManager.getClosurePointer(FMI2Logger.class, loggerParam ));	
		}
		if(allocatorParam != null){
			ret.putPointer(tmpStruct.allocateMemory.offset(), closureManager.getClosurePointer(FMI2AllocateMemory.class, allocatorParam ));	
		}
		if(freeMemParam != null){
			ret.putPointer(tmpStruct.freeMemory.offset(), closureManager.getClosurePointer(FMI2FreeMemory.class, freeMemParam));	
		}
		if(stepFinishedParam != null){
			ret.putPointer(tmpStruct.stepFinished.offset(), closureManager.getClosurePointer(FMI2StepFinished.class,stepFinishedParam ));	
		}
		return ret;
	}
}
