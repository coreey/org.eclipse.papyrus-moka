/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  David LOPEZ BETANCUR (CEA LIST)
 *  Sebastien REVOL (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.datavisualization.ui.diagram;

import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.moka.xygraph.common.ui.AbstractXYGraphPageFactory;
import org.eclipse.papyrus.moka.xygraph.common.writing.ResourceWriteStrategyFactory;
import org.eclipse.papyrus.moka.xygraph.mapping.common.DefaultXYGraphBinder;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphBinder;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphCoordinator;
import org.eclipse.papyrus.moka.xygraph.mapping.writing.ModelWritingStrategyFactory;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;
import org.eclipse.papyrus.moka.datavisualization.service.DataSeriesXYGraphCoordinator;
import org.eclipse.papyrus.moka.datavisualization.services.XYGraphPropertiesNotificationService;

public class DataSeriesXYGraphPageFactory extends AbstractXYGraphPageFactory{

	protected XYGraphDescriptor graphDescriptor;
	
	@Override
	public XYGraphCoordinator getXYGraphCoordinator(XYGraphDescriptor model) {
		this.graphDescriptor = model;
		
		XYGraphBinder binder = new DefaultXYGraphBinder(model);
		ModelWritingStrategyFactory factory = new ResourceWriteStrategyFactory();
		XYGraphCoordinator coordinator = new DataSeriesXYGraphCoordinator(binder, factory);
		
		//Register it as a listener
		try {
			XYGraphPropertiesNotificationService notifSrv = servicesRegistry.getService(XYGraphPropertiesNotificationService.class);
			notifSrv.register(coordinator);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return coordinator;
	}

}
