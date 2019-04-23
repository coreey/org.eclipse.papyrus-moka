/*****************************************************************************
 * 
  * Copyright (c) 2016 CEA LIST.
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
 * 
 *****************************************************************************/

package org.eclipse.papyrus.moka.fmi.master.jnr;

import org.eclipse.papyrus.moka.fmi.master.jnr.FMI2Callbacks.FMI2FreeMemory;

import jnr.ffi.Pointer;

public class FMI2FreeMemImpl implements FMI2FreeMemory {

	
	private FMI2AllocatorImpl alloc;
	public FMI2FreeMemImpl(FMI2AllocatorImpl allocator){
		alloc = allocator;
	}
	@Override
	public void call(Pointer pointer) {
		alloc.releasePointer(pointer);
	}

}
