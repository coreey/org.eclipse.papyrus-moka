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

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.registry.service.framework.AbstractServiceFactory;
import org.eclipse.uml2.uml.Class;

public class Master2ProxyServiceFactory extends AbstractServiceFactory {


	protected static final String SERVICE_NAME = "FMIMasterService::Master2Proxy"; // qualified name of FmuProxy

	public Master2ProxyServiceFactory() {
	}

	@Override
	public IObject_ instantiate(Class service) {
		IObject_ serviceInstance = null;
		if (service.getQualifiedName().equals(SERVICE_NAME)) {
			serviceInstance = this.createMaster2Service(service);
		}
		return serviceInstance;
	}

	public IObject_ createMaster2Service(Class service) {
		return new Master2ProxyService(service);
	}
}
