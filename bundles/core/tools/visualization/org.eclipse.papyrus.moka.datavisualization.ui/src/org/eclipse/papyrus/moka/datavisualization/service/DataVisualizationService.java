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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.moka.datavisualization.profile.BooleanSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.DataSource;
import org.eclipse.papyrus.moka.datavisualization.profile.DoubleSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.IntegerSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.VisualizationPackage;
import org.eclipse.papyrus.moka.datavisualization.ui.GraphBuilderHelper;
import org.eclipse.papyrus.moka.xygraph.mapping.common.Variable;
import org.eclipse.papyrus.moka.xygraph.mapping.common.Variable.VariableID;
import org.eclipse.papyrus.moka.xygraph.mapping.util.DataBatch;

public class DataVisualizationService implements IService{
	
	private List<DataPort> dataPorts;
	private VariableEntryTable<VariableEntry> varTable;
	
	private DataVisualizationService(){
		dataPorts = new ArrayList<>();
		varTable = new VariableEntryTable<>();
	}
	
	private static DataVisualizationService instance = new DataVisualizationService();
	
	public static DataVisualizationService getInstance(){
		return instance;
	}
	
	public void registerUnlinkedVariable(Variable v){
		if( hasVariable(v) )
			return;
		
		varTable.addEntryFor(v.getID(), new VariableDataEntry(v));
	}
	
	public boolean hasVariable(Variable var){
		return hasVariable(var.getID());
	}
	
	private boolean hasVariable(VariableID id){
		return varTable.hasVariable(id);
	}
	
	public void addDataPort(DataPort port){
		if( dataPorts.contains(port) )
			return;
		
		dataPorts.add(port);
	}
	
	private VariableDataEntry getEntry(VariableID vID){
		return (VariableDataEntry) varTable.getEntry(vID);
	}
	
	public Variable makeIndependentVariable(ValueSeries independentSeries){
		return new VariableImpl(independentSeries.getBase_Property().getLabel(), new DataSourceVariableID(independentSeries));
	}
	
	public Variable makeDependentVariable(ValueSeries depSeries, Variable independent){
		return new VariableImpl(depSeries.getBase_Property().getLabel(), new DataSourceVariableID(depSeries), independent);
	}
	
	public void setVariableBatch( Variable var, DataBatch batch){
		getEntry(var.getID()).setData(batch);
	}
	
	public List<Variable> importNewDataValueSet(DataSource set){
		
		ArrayList<Variable> contained = new ArrayList<>();
		
		ArrayList<ValueSeries> independent = new ArrayList<>();
		ArrayList<ValueSeries> dependent = new ArrayList<>();
		
		GraphBuilderHelper.separateValueSeries( set.getSeries(), independent, dependent );
		
		if( independent.size() == 0 )
			return contained;
		
		ValueSeries independentSeries = independent.get(0);
		
		//1. Check the independent variables.
		
		//For the moment we are adding a new series only if it wasn't previously.
		if( getVariable(independentSeries) == null ){
			//For the moment only 1 is supported.
			Variable iVar = makeIndependentVariable(independentSeries);
			
			//1.1. Add the independent variables.
			registerUnlinkedVariable(iVar);
			setVariableBatch(iVar, getDataFromValueSeries(independentSeries) );
		}
		
		//2. Add the dependent variables.
		for( ValueSeries dep : dependent ){
			
			//if it's already a contained variable, ignore it.
			if( getEntryFromSerie(dep) != null )
				continue;
			
			Variable in = getEntryFromSerie(dep.getDependent()).getVariable();

			//TODO Formally validate this before this method 
			//Assert.isNotNull(in, "The independent series for " + dep.getBase_Property().getLabel() + " is not in the dataset");
			//Assert.isTrue( !in.isIndependent(), "The independent series for " + dep.getBase_Property() + " is not independent");
			
			Variable dVar = makeDependentVariable( dep, in );
			registerUnlinkedVariable(dVar);
			setVariableBatch(dVar, getDataFromValueSeries(dep) );
		}
		
		return contained;
	}
	
	private VariableEntry getEntryFromSerie(ValueSeries dependent) {
		DataSourceVariableID dsID = new DataSourceVariableID(dependent);
		return getEntry(dsID);
	}

	public void updateVariableData(Variable v, DataBatch values) {
		VariableDataEntry entry = getEntry(v.getID());
		entry.setData(values);
	}
	
	public void flushData(){
		for( DataPort port : dataPorts )
			pullAllData( port );
	}
	
	public void flushVariable(Variable v){
		for( DataPort port : dataPorts )
			if( !v.isIndependent() && port.getSupportedVariableIDs().contains(v.getID()) )
				flushVariableToPort(getEntry(v.getID()), port);
	}
	
	private void flushVariableToPort(VariableDataEntry entry, DataPort port) {		
		if( entry.getVariable().isIndependent() )
			return;

		Variable v = entry.getVariable();
		VariableDataEntry indepEntry = getEntry(v.getDependsOn().getID());
		
		long portLastUpdate = port.getLastUpdate(v.getID());
		if( portLastUpdate < indepEntry.getLastUpdate() ){
			port.resetValues(v.getID(), indepEntry.getValuesBatch(), entry.getValuesBatch());
		}
	}

	public void pullAllData(DataPort port){
		for( VariableID vId : port.getSupportedVariableIDs() ){
			VariableDataEntry entry = getEntry(vId);
			flushVariableToPort(entry, port);
		}
	}

	public static DataBatch getDataFromValueSeries(ValueSeries serie){
		
		switch (serie.eClass().getClassifierID()){
			
			case VisualizationPackage.BOOLEAN_SERIES :
				return DataBatch.fromBoolean( ((BooleanSeries) serie).getValues() );
				
			case VisualizationPackage.INTEGER_SERIES :
				return DataBatch.fromInteger( ((IntegerSeries) serie).getValues() );
				
			case VisualizationPackage.DOUBLE_SERIES :
				return DataBatch.fromDouble( ((DoubleSeries) serie).getValues() );
				
				
			default : 
				//TODO This case is not implemented
				return DataBatch.dummy();
		}
	}
	
	@Override
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
	}

	@Override
	public void startService() throws ServiceException {
	}

	@Override
	public void disposeService() throws ServiceException {
		//TODO Dispose all dataPorts ?
		
	}

	//TODO This should be done automatically at the DataSource instantiation.
	public void fixDependencies(DataSource dataSource) {
		
		ValueSeries dep = null;
		
		for(ValueSeries serie : dataSource.getSeries())
			if( "time".equalsIgnoreCase(serie.getBase_Property().getLabel()) ){
				dep = serie;
				break;
			}
		
		for(ValueSeries serie : dataSource.getSeries()){
			if( "time".equalsIgnoreCase(serie.getBase_Property().getLabel()) ){
				continue;
			}
			
			serie.setDependent(dep);
		}
	}
	
	public Variable getVariable(ValueSeries series){
		VariableEntry entry = varTable.getEntry(new DataSourceVariableID(series));
		if( entry == null )
			return null;
		
		return entry.getVariable();
	}

	public void removeDataPort(DataPort port) {
		dataPorts.remove(port);
	}
}
