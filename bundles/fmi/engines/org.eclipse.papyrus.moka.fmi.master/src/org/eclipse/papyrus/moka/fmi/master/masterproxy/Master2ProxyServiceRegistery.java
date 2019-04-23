/*****************************************************************************
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
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmi.master.masterproxy;

import org.eclipse.papyrus.moka.fuml.registry.service.framework.AbstractServicesRegistery;

public class Master2ProxyServiceRegistery extends AbstractServicesRegistery {

	public Master2ProxyServiceRegistery() {
		super();
	}

	@Override
	public void initServiceQualifiedNames() {
		this.serviceQualifiedNames.add(Master2ProxyServiceFactory.SERVICE_NAME);
	}

	@Override
	public void initServiceFactory() {
		this.serviceFactory = new Master2ProxyServiceFactory();

	}

	@Override
	public void initLibraryURI() {
		this.libraryURI = "pathmap://PAPYRUS_MOKA_EXTRAS_FMI2_MASTER/master2Proxy.uml";
	}

}
