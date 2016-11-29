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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fmi.master.jnr.FMI2Callbacks.FMI2AllocateMemory;

import jnr.ffi.Memory;
import jnr.ffi.Pointer;
import jnr.ffi.Runtime;

public class FMI2AllocatorImpl implements FMI2AllocateMemory {

	private  List<Pointer> allocatedPointers = new ArrayList<Pointer>();
	@Override
	public Pointer call(int numberOfObjects, int size) {
		Pointer pointer =Memory.allocateDirect(Runtime.getSystemRuntime(), numberOfObjects*size, true);
		allocatedPointers.add(pointer);
		return pointer;
	}

	public void releasePointer(Pointer pointer){
		List<Pointer> pointersToRemove = new ArrayList<>();
		if (pointer.isDirect()){
			for (Pointer allocPointer: allocatedPointers ){
				if (pointer.address() == allocPointer.address()){
					pointersToRemove.add(allocPointer);
				}
			}	
		}
		allocatedPointers.removeAll(pointersToRemove);
		
		
	}
}
