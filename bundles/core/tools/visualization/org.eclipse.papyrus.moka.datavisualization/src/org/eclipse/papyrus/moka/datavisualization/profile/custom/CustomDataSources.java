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
package org.eclipse.papyrus.moka.datavisualization.profile.custom;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.impl.DataSourceImpl;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Property;

public class CustomDataSources extends DataSourceImpl {

	@Override
	public EList<ValueSeries> getSeries() {
		EList<ValueSeries> ret = new BasicEList<ValueSeries>();
		DataType baseDataType = getBase_DataType();
		if (baseDataType != null){
			for (Property prop : baseDataType.allAttributes()){
				for( EObject stereoApplication : prop.getStereotypeApplications()){
					if (stereoApplication instanceof ValueSeries){
						ret.add((ValueSeries) stereoApplication);
					}
				}
			}
		}
		return ret;
	}
	
}
