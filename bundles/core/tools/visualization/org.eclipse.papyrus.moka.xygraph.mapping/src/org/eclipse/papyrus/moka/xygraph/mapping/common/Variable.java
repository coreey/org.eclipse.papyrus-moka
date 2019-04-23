/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
 *  David LOPEZ BETANCUR (CEA LIST)
 *  Sebastien REVOL (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.xygraph.mapping.common;

public interface Variable {
	
	public static abstract class VariableID{
		
		public abstract boolean equals(Object obj);
		
		public abstract int hashCode();	
	}
	
	String getName();
	
	String getFullyQualifiedName();
	
	VariableID getID();
	
	Variable getDependsOn();
	
	default boolean isIndependent(){
		return getDependsOn() == null;
	}
	
	default boolean equals(Variable other){
		return getID().equals(other.getID());
	}
}
