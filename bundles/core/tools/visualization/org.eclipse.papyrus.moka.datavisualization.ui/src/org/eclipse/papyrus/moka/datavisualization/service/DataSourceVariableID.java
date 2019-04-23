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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries;
import org.eclipse.papyrus.moka.xygraph.mapping.common.Variable.VariableID;

public class DataSourceVariableID extends VariableID{
	
	private ValueSeries dataSource;
	
	public DataSourceVariableID(ValueSeries dataSource){
		this.dataSource = dataSource;
	}
	
	@Override
	public boolean equals(Object obj) {
		if( !(obj instanceof DataSourceVariableID) )
			return false;
		
		DataSourceVariableID other = (DataSourceVariableID)obj;
		EObject ds = other.getDataSource();

		//TODO Is there a better ID for the dataSource?
		return ds.equals(dataSource);
	}
	
	public EObject getDataSource() {
		return dataSource;
	}

	@Override
	public int hashCode() {
		return dataSource.getBase_Property().hashCode();
	}
}
