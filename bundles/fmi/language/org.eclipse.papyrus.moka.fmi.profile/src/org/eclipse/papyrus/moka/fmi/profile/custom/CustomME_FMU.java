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

import org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ME_FMUImpl;
import org.eclipse.papyrus.moka.fmi.modeldescription.FileType1;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType;
import org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType;
import org.eclipse.papyrus.moka.fmi.modeldescription.VariableNamingConventionType;

public class CustomME_FMU extends ME_FMUImpl {
	
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
		if (getModelDescription() != null &&  !getModelDescription().getModelExchange().isEmpty()){
			ModelExchangeType modelExchange = getModelDescription().getModelExchange().get(0);
			if (modelExchange.getSourceFiles() != null){
				String  ret = "";
				for (FileType1 file : modelExchange.getSourceFiles().getFile()){
					ret+= file.getName()+";";
				}
				return ret;
			}
		
		}
		return super.getSourceFiles();
	}

	@Override
	public boolean isCanBeInstantiatedOnlyOncePerProcess() {
		if (getModelDescription() != null &&  !getModelDescription().getModelExchange().isEmpty()){
			ModelExchangeType modelExchange = getModelDescription().getModelExchange().get(0);
			return modelExchange.isCanBeInstantiatedOnlyOncePerProcess();
		}
		return super.isCanBeInstantiatedOnlyOncePerProcess();
	}

	@Override
	public boolean isCanGetAndSetFMUstate() {
		if (getModelDescription() != null &&  !getModelDescription().getModelExchange().isEmpty()){
			ModelExchangeType modelExchange = getModelDescription().getModelExchange().get(0);
			return modelExchange.isCanGetAndSetFMUstate();
		}
		return super.isCanGetAndSetFMUstate();
	}

	@Override
	public boolean isCanNotUseMemoryManagementFunctions() {
		if (getModelDescription() != null &&  !getModelDescription().getModelExchange().isEmpty()){
			ModelExchangeType modelExchange = getModelDescription().getModelExchange().get(0);
			return modelExchange.isCanNotUseMemoryManagementFunctions();
		}
		return super.isCanNotUseMemoryManagementFunctions();
	}

	@Override
	public boolean isCanSerializeFMUstate() {
		if (getModelDescription() != null &&  !getModelDescription().getModelExchange().isEmpty()){
			ModelExchangeType modelExchange = getModelDescription().getModelExchange().get(0);
			return modelExchange.isCanSerializeFMUstate();
		}
		return super.isCanSerializeFMUstate();
	}

	@Override
	public boolean isProvidesDirectionalDerivative() {
		if (getModelDescription() != null &&  !getModelDescription().getModelExchange().isEmpty()){
			ModelExchangeType modelExchange = getModelDescription().getModelExchange().get(0);
			return modelExchange.isProvidesDirectionalDerivative();
		}
		return super.isProvidesDirectionalDerivative();
	}

	@Override
	public boolean isNeedsExecutionTool() {
		if (getModelDescription() != null &&  !getModelDescription().getModelExchange().isEmpty()){
			ModelExchangeType modelExchange = getModelDescription().getModelExchange().get(0);
			return modelExchange.isNeedsExecutionTool();
		}
		return super.isNeedsExecutionTool();
	}

	@Override
	public String getModelIdentifier() {
		if (getModelDescription() != null &&  !getModelDescription().getModelExchange().isEmpty()){
			ModelExchangeType modelExchange = getModelDescription().getModelExchange().get(0);
			return modelExchange.getModelIdentifier();
		}
		return super.getModelIdentifier();
	}
}
