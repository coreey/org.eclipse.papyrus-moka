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
package org.eclipse.papyrus.moka.datavisualization.services;

import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphCoordinator;

public class XYGraphPropertiesNotificationService implements IService {
	
	private XYGraphResourceSetListener listener;
	
	public XYGraphPropertiesNotificationService() {
		listener = new XYGraphResourceSetListener();
	}

	@Override
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		ModelSet modelSet = ServiceUtils.getInstance().getModelSet(servicesRegistry);
		
		try {
			registerListener(modelSet);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void registerListener(ModelSet modelSet) throws NotFoundException{
		modelSet.getTransactionalEditingDomain().addResourceSetListener(listener);
	}

	public void register(XYGraphCoordinator coordinator) {
		listener.registerCoordinator(coordinator);
	}
	
	@Override
	public void startService() throws ServiceException {

	}

	@Override
	public void disposeService() throws ServiceException {

	}
}
