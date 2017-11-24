/**
 * Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *   CEA LIST - Initial API and implementation
 */

package org.eclipse.papyrus.moka.datavisualization.profile.custom;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.impl.DataSourceInstanceImpl;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Slot;

public class CustomDataSourceInstance extends DataSourceInstanceImpl {

	@Override
	public EList<ValueSeries> getSeries() {
		EList<ValueSeries> ret = new BasicEList<ValueSeries>();
		InstanceSpecification baseInstanceSpecification = getBase_InstanceSpecification();
		if (baseInstanceSpecification != null){
			for (Slot slot : baseInstanceSpecification.getSlots()){
				for( EObject stereoApplication : slot.getStereotypeApplications()){
					if (stereoApplication instanceof ValueSeries){
						ret.add((ValueSeries) stereoApplication);
					}
				}
			}
		}
		return ret;
	}
	
}
