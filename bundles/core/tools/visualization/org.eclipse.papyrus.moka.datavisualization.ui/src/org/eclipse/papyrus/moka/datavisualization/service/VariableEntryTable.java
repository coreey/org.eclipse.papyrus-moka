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
package org.eclipse.papyrus.moka.datavisualization.service;

import java.util.HashMap;
import java.util.Set;

import org.eclipse.papyrus.moka.xygraph.mapping.common.Variable.VariableID;

public class VariableEntryTable<E extends VariableEntry> {
	
	private HashMap<VariableID, E> variables;
	
	public VariableEntryTable() {
		super();
		variables = new HashMap<>();
	}
	
	public void addEntryFor(VariableID variableID, E entry){
		variables.put(variableID, entry);
	}

	public boolean hasVariable(VariableID id){
		return variables.containsKey(id);
	}
	
	public VariableEntry getEntry(VariableID id){		
		return variables.get(id);
	}
	
	public Set<VariableID> getRegisteredVariableIDs(){
		return variables.keySet();
	}

	public void remove(VariableID id) {
		variables.remove(id);
	}
}
