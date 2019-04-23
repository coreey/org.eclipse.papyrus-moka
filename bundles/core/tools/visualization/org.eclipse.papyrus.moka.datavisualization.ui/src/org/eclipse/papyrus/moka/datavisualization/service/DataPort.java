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

import java.util.Set;

import org.eclipse.papyrus.moka.xygraph.mapping.common.Variable.VariableID;
import org.eclipse.papyrus.moka.xygraph.mapping.util.DataBatch;

public interface DataPort{			
	
	public boolean isVariableSupported( VariableID variable );
	public Set<VariableID> getSupportedVariableIDs();
	public long getLastUpdate(VariableID variable);	
//	public boolean addNewVariable(VariableID variable, VariableDataEntry entry);		
	public boolean removeVariable(VariableID variable);	
	public boolean addNewSample(VariableID variable, Double x, Double y);	
	public boolean resetValues(VariableID variable, DataBatch x, DataBatch y);		
}

interface LocalDataPort extends DataPort{
	
	public VariableEntryTable getVariablesTable();	
	
	public default Set<VariableID> getSupportedVariableIDs(){
		return getVariablesTable().getRegisteredVariableIDs();
	}
	
	public default boolean isVariableSupported( VariableID variableID ){
		return getVariablesTable().hasVariable(variableID);
	}
	
	public default long getLastUpdate(VariableID variableID){
		if( !isVariableSupported(variableID) )
			return -1;
		
		return getVariablesTable().getEntry(variableID).getLastUpdate();
	}
	
//	public default boolean addNewVariable(VariableID variable, VariableDataEntry entry){
//		if( isVariableSupported(variable) )
//			return false;
//		
//		getVariablesTable().addEntryFor(variable, entry);
//		doAddNewVariable(variable);
//		return true;
//	}
	
	void doAddNewVariable(VariableID variable);
	
	public default boolean removeVariable(VariableID variableID){
		if( !isVariableSupported(variableID) )
			return false;
		
		getVariablesTable().remove(variableID);
		doRemoveVariable(variableID);
		return true;
	}
	
	void doRemoveVariable(VariableID variableID);
	
	public default boolean addNewSample(VariableID variableID, Double x, Double y){
		if( !isVariableSupported(variableID) )
			return false;
		
		getVariablesTable().getEntry(variableID).markUpdate();
		doAddNewSample(variableID, x, y);
		
		return true;
	}
	
	void doAddNewSample(VariableID variableID, Double x, Double y);
	
	public default boolean resetValues(VariableID variableID, DataBatch x, DataBatch y){
		if( !isVariableSupported(variableID) )
			return false;
		
		getVariablesTable().getEntry(variableID).markUpdate();
		doResetValues(variableID, x, y);
		
		return true;
	}
	
	void doResetValues(VariableID variableID, DataBatch x, DataBatch y);
}
