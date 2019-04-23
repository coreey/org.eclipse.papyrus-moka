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

import org.eclipse.papyrus.moka.datavisualization.profile.DataSource;
import org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries;
import org.eclipse.papyrus.moka.datavisualization.ui.GraphBuilderHelper;
import org.eclipse.papyrus.moka.xygraph.mapping.common.Variable;
import org.eclipse.papyrus.moka.xygraph.mapping.common.Variable.VariableID;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphBinder;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphCoordinator;
import org.eclipse.papyrus.moka.xygraph.mapping.util.DataBatch;
import org.eclipse.papyrus.moka.xygraph.mapping.writing.ModelWritingStrategyFactory;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;

public class DataSeriesXYGraphCoordinator extends XYGraphCoordinator implements LocalDataPort {
	
	private VariableEntryTable<VariableDataEntry> varTable = new VariableEntryTable<VariableDataEntry>();
	
	public DataSeriesXYGraphCoordinator(XYGraphBinder binder, ModelWritingStrategyFactory factory) {
		super(binder, factory);
	}

	@Override
	protected void onXYGraphBuilt() {
		super.onXYGraphBuilt();

		DataVisualizationService.getInstance().importNewDataValueSet((DataSource)getXYGraphDescriptor().getDataSource());
		addNewVariables();
		DataVisualizationService.getInstance().addDataPort(this);
		
		synchronizeTracesVisibility();
		
		DataVisualizationService.getInstance().pullAllData(this);
		
		rescaleAxesIfNeeded();
	}

	private VariableDataEntry makeEntryFor(VariableID id, TraceDescriptor tDesc){
		Variable var = new VariableImpl(tDesc.getName(), id);
		return new VariableDataEntry(var, tDesc);
	}

	private void addNewVariables() {
		for( TraceDescriptor tDesc : getXYGraphDescriptor().getTraceDescriptors() ){
			
			VariableID id = new DataSourceVariableID((ValueSeries)tDesc.getDataSource());
					
			if( isVariableSupported(id) )
				continue;
			
			getVariablesTable().addEntryFor(id, makeEntryFor(id, tDesc));
		}
	}
	
	@Override
	public VariableEntryTable<VariableDataEntry> getVariablesTable() {
		return varTable;
	}

	@Override
	public void doAddNewVariable(VariableID varId) {
		
		if( !(varId instanceof DataSourceVariableID) ){
			throw new UnsupportedOperationException("For the moment only DataSourceVariables are supported");
		}
		
		DataSourceVariableID dsId = (DataSourceVariableID)varId;
		XYGraphDescriptor xy = graphMap.getXYGraphDescriptor();
		TraceDescriptor tDesc = GraphBuilderHelper.buildTraceFor(xy, (ValueSeries)dsId.getDataSource());	
		factory.getXYGraphUpdateStrategy().addTrace(xy, tDesc);
	}

	@Override
	public void doRemoveVariable(VariableID varId) {
		VariableDataEntry entry = (VariableDataEntry)varTable.getEntry(varId);
		TraceDescriptor tDesc = entry.getTraceDescriptor();
		removeTrace(tDesc);
	}

	@Override
	public void doAddNewSample(VariableID varId, Double x, Double y) {
		//Add a new value
		VariableDataEntry entry = (VariableDataEntry)varTable.getEntry(varId);
		TraceDescriptor tDesc = entry.getTraceDescriptor();
		graphMap.addTraceSample(tDesc, x, y);
	}

	@Override
	public void doResetValues(VariableID varId, DataBatch x, DataBatch y) {
		//Reset the batches.
		VariableDataEntry entry = (VariableDataEntry)varTable.getEntry(varId);
		TraceDescriptor tDesc = entry.getTraceDescriptor();
		graphMap.setTraceData(tDesc, x, y);
	}

	@Override
	public void dispose() {
		super.dispose();
		
		DataVisualizationService.getInstance().removeDataPort(this);
	}
}
