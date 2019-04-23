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

import org.eclipse.papyrus.moka.xygraph.mapping.common.Variable;
import org.eclipse.papyrus.moka.xygraph.mapping.util.DataBatch;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor;

public class VariableDataEntry extends VariableEntry {

	//Probably this could move to a different table, for the moment we can 
	//use it from here.  
	private TraceDescriptor traceDescriptor;
	private DataBatch valuesBatch;
	private int lastFlushedIndex;
	
	public VariableDataEntry(Variable variable, TraceDescriptor trace){
		super(variable);
		lastFlushedIndex = -1;
		this.traceDescriptor = trace;
	}
	
	public VariableDataEntry(Variable variable){
		super(variable);
		lastFlushedIndex = -1;
		this.traceDescriptor = null;
	}
	
	public void setData(DataBatch valuesBatch) {
		if( this.valuesBatch != null )
			this.valuesBatch.clean();
		
		this.valuesBatch = valuesBatch;
		resetFlushedIndex();
		markUpdate();
	}

	public DataBatch getValuesBatch() {
		return valuesBatch;
	}

	public void markFlush(){
		this.lastFlushedIndex = valuesBatch.size();
	}
	
	public void resetFlushedIndex(){
		lastFlushedIndex = 0;
	}
	
	public int getLastFlushedIndex() {
		return lastFlushedIndex;
	}

	public TraceDescriptor getTraceDescriptor() {
		return traceDescriptor;
	}
	
	public void setTraceDescriptor(TraceDescriptor traceDescriptor){
		this.traceDescriptor = traceDescriptor;
	}
}
