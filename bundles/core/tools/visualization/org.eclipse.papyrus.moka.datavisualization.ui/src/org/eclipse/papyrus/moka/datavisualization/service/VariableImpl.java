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

public class VariableImpl implements Variable{

	private String name;
	private VariableID variableID;
	private Variable dependsOn;
	
	public VariableImpl(String name, VariableID variableID){
		this.name = name;
		this.variableID = variableID;
		this.dependsOn = null;
	}
	
	public VariableImpl(String name, VariableID variableID, Variable dependsOn){
		this.name = name;
		this.variableID = variableID;
		this.dependsOn = dependsOn;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public VariableID getID() {
		return variableID;
	}

	@Override
	public String getFullyQualifiedName() {
		return variableID.toString();
	}

	@Override
	public Variable getDependsOn() {
		return dependsOn;
	}

	public void setDependsOn(Variable dependsOn) {
		this.dependsOn = dependsOn;
	}
}
