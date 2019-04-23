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
package org.eclipse.papyrus.moka.fmi.profile.custom;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_FMUImpl;
import org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType;
import org.eclipse.papyrus.moka.fmi.modeldescription.FileType;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType;
import org.eclipse.papyrus.moka.fmi.modeldescription.VariableNamingConventionType;

public class CustomCS_FMU extends  CS_FMUImpl{

	@Override
	public FmiModelDescriptionType basicGetModelDescription() {
		if (getFmuBundle() != null){
			return getFmuBundle().getModelDescription();
		}
		return null;
	}
	
	
	@Override
	public String getFmiVersion() {
		if (getModelDescription() != null){
			return getModelDescription().getFmiVersion();
		}
		return super.getFmiVersion();
	}

	@Override
	public String getModelName() {
		if (getModelDescription() != null){
			return getModelDescription().getModelName();
		}
		return super.getModelName();
	}

	@Override
	public String getGuid() {
		if (getModelDescription() != null){
			return getModelDescription().getGuid();
		}
		return super.getGuid();
	}

	@Override
	public String getDescription() {
		if (getModelDescription() != null){
			return getModelDescription().getDescription();
		}
		return super.getDescription();
	}

	@Override
	public String getAuthor() {
		if (getModelDescription() != null){
			return getModelDescription().getAuthor();
		}
		return super.getAuthor();
	}

	@Override
	public String getVersion() {
		if (getModelDescription() != null){
			return getModelDescription().getVersion();
		}
		return super.getVersion();
	}

	@Override
	public String getCopyright() {
		if (getModelDescription() != null){
			return getModelDescription().getCopyright();
		}		
		return super.getCopyright();
	}

	@Override
	public String getLicense() {
		if (getModelDescription() != null){
			return getModelDescription().getLicense();
		}
		return super.getLicense();
	}

	@Override
	public String getGenerationTool() {
		if (getModelDescription() != null){
			return getModelDescription().getGenerationTool();
		}
		return super.getGenerationTool();
	}

	@Override
	public String getGenerationDateAndTime() {
		if (getModelDescription() != null){
			XMLGregorianCalendar date = getModelDescription().getGenerationDateAndTime();
			if (date != null){
				date.toString();
			}
		}
		return super.getGenerationDateAndTime();
	}

	@Override
	public String getVariableNamingConvention() {
		if (getModelDescription() != null){
			VariableNamingConventionType variableNamingConventionType =  getModelDescription().getVariableNamingConvention();
			return variableNamingConventionType.toString();
		}
		return super.getVariableNamingConvention();
	}

	@Override
	public int getNumberOfEventIndicators() {
		if (getModelDescription() != null){
			if (getModelDescription().isSetNumberOfEventIndicators()) {
				return new Long(getModelDescription().getNumberOfEventIndicators()).intValue();
			}
		}
		return super.getNumberOfEventIndicators();
	}
	
	
	@Override
	public String getSourceFiles() {
		if (getModelDescription() != null &&  !getModelDescription().getCoSimulation().isEmpty()){
			CoSimulationType cosim = getModelDescription().getCoSimulation().get(0);
			if (cosim.getSourceFiles() != null){
				String  ret = "";
				for (FileType file : cosim.getSourceFiles().getFile()){
					ret+= file.getName()+";";
				}
				return ret;
			}
		
		}
		return super.getSourceFiles();
	}

	@Override
	public boolean isCanBeInstantiatedOnlyOncePerProcess() {
		if (getModelDescription() != null &&  !getModelDescription().getCoSimulation().isEmpty()){
			CoSimulationType cosim = getModelDescription().getCoSimulation().get(0);
			return cosim.isCanBeInstantiatedOnlyOncePerProcess();
		}
		return super.isCanBeInstantiatedOnlyOncePerProcess();
	}

	@Override
	public boolean isCanGetAndSetFMUstate() {
		if (getModelDescription() != null &&  !getModelDescription().getCoSimulation().isEmpty()){
			CoSimulationType cosim = getModelDescription().getCoSimulation().get(0);
			return cosim.isCanGetAndSetFMUstate();
		}
		return super.isCanGetAndSetFMUstate();
	}

	@Override
	public boolean isCanNotUseMemoryManagementFunctions() {
		if (getModelDescription() != null &&  !getModelDescription().getCoSimulation().isEmpty()){
			CoSimulationType cosim = getModelDescription().getCoSimulation().get(0);
			return cosim.isCanNotUseMemoryManagementFunctions();
		}
		return super.isCanNotUseMemoryManagementFunctions();
	}

	@Override
	public boolean isCanSerializeFMUstate() {
		if (getModelDescription() != null &&  !getModelDescription().getCoSimulation().isEmpty()){
			CoSimulationType cosim = getModelDescription().getCoSimulation().get(0);
			return cosim.isCanSerializeFMUstate();
		}
		return super.isCanSerializeFMUstate();
	}

	@Override
	public boolean isProvidesDirectionalDerivative() {
		if (getModelDescription() != null &&  !getModelDescription().getCoSimulation().isEmpty()){
			CoSimulationType cosim = getModelDescription().getCoSimulation().get(0);
			return cosim.isProvidesDirectionalDerivative();
		}
		return super.isProvidesDirectionalDerivative();
	}

	@Override
	public boolean isNeedsExecutionTool() {
		if (getModelDescription() != null &&  !getModelDescription().getCoSimulation().isEmpty()){
			CoSimulationType cosim = getModelDescription().getCoSimulation().get(0);
			return cosim.isNeedsExecutionTool();
		}
		return super.isNeedsExecutionTool();
	}

	@Override
	public String getModelIdentifier() {
		if (getModelDescription() != null &&  !getModelDescription().getCoSimulation().isEmpty()){
			CoSimulationType cosim = getModelDescription().getCoSimulation().get(0);
			return cosim.getModelIdentifier();
		}
		return super.getModelIdentifier();
	}


	
	
	
	
	
	
	//CS_FMU specific functions
	
	@Override
	public boolean isCanHandleVariableCommunicationStepSize() {
		if (getModelDescription() != null &&  !getModelDescription().getCoSimulation().isEmpty()){
			CoSimulationType cosim = getModelDescription().getCoSimulation().get(0);
			return cosim.isCanHandleVariableCommunicationStepSize();
		}
		return super.isCanHandleVariableCommunicationStepSize();
	}

	

	@Override
	public boolean isCanInterpolateInputs() {
		if (getModelDescription() != null &&  !getModelDescription().getCoSimulation().isEmpty()){
			CoSimulationType cosim = getModelDescription().getCoSimulation().get(0);
			return cosim.isCanInterpolateInputs();
		}
		return super.isCanInterpolateInputs();
	}

	
	@Override
	public boolean isCanRunAsynchronuously() {
		if (getModelDescription() != null &&  !getModelDescription().getCoSimulation().isEmpty()){
			CoSimulationType cosim = getModelDescription().getCoSimulation().get(0);
			return cosim.isCanRunAsynchronuously();
		}
		return super.isCanRunAsynchronuously();
	}



	@Override
	public int getMaxOutputDerivativeOrder() {
		if (getModelDescription() != null &&  !getModelDescription().getCoSimulation().isEmpty()){
			CoSimulationType cosim = getModelDescription().getCoSimulation().get(0);
			if (cosim.isSetMaxOutputDerivativeOrder()){
				return new Long(cosim.getMaxOutputDerivativeOrder()).intValue();
			}
			
		}
		return super.getMaxOutputDerivativeOrder();
	}


	@Override
	public double getStartTime() {
		if (getModelDescription() != null &&  getModelDescription().getDefaultExperiment()!= null){
			return  getModelDescription().getDefaultExperiment().getStartTime();
		}
		return super.getStartTime();
	}


	@Override
	public double getStopTime() {
		if (getModelDescription() != null &&  getModelDescription().getDefaultExperiment()!= null){
			return  getModelDescription().getDefaultExperiment().getStartTime();
		}
		return super.getStopTime();
	}
	@Override
	public double getStepSize() {
		if (getModelDescription() != null &&  getModelDescription().getDefaultExperiment()!= null){
			return  getModelDescription().getDefaultExperiment().getStepSize();
		}
		return super.getStepSize();
	}

	@Override
	public double getTolerance() {
		if (getModelDescription() != null &&  getModelDescription().getDefaultExperiment()!= null){
			return  getModelDescription().getDefaultExperiment().getTolerance();
		}
		return super.getTolerance();
	}

}
