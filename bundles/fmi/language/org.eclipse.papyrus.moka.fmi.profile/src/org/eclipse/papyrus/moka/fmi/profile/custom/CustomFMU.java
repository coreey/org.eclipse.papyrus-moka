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

import org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl;
import org.eclipse.papyrus.moka.fmi.modeldescription.VariableNamingConventionType;

public class CustomFMU extends FMUImpl {

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

	


}
