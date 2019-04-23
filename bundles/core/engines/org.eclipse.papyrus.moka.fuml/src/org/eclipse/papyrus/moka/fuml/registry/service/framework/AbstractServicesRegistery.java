/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.registry.service.framework;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.registry.AbstractSystemServicesRegistry;
import org.eclipse.uml2.uml.Class;

public abstract class AbstractServicesRegistery extends AbstractSystemServicesRegistry {

	protected IServiceFactory serviceFactory;

	protected List<String> serviceQualifiedNames;

	protected String libraryURI;

	public abstract void initServiceQualifiedNames();

	public abstract void initServiceFactory();

	public abstract void initLibraryURI();

	public AbstractServicesRegistery() {
		this.initLibraryURI();
		this.initServiceFactory();
		this.serviceQualifiedNames = new ArrayList<String>();
		this.initServiceQualifiedNames();
	}

	@Override
	public List<IObject_> instantiateServices() {
		return this.instantiateServices(this.libraryURI, this.serviceQualifiedNames);
	}

	@Override
	protected IObject_ instantiateService(Class service) {
		return this.serviceFactory.instantiate(service);
	}
}
