/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.standardlibrary;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.registry.AbstractSystemServicesRegistry;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.io.StandardInputChannelImpl;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.io.StandardOutputChannelImpl;
import org.eclipse.uml2.uml.Class;

/**
 * Registers system services related to the foundational model library.
 * This includes standard input/ouput channel services
 *
 */
public class StandardServicesRegistry extends AbstractSystemServicesRegistry {

	protected final static String FUML_LIBRARY_NAME = "FoundationalModelLibrary";
	protected final static String FUML_LIBRARY_URI = "pathmap://PAPYRUS_fUML_LIBRARY/fUML_Library.uml";

	protected final static String STANDARD_INPUT_CHANNEL_SERVICE_NAME = "FoundationalModelLibrary::BasicInputOutput::StandardInputChannel";

	protected final static String STANDARD_OUTPUT_CHANNEL_SERVICE_NAME = "FoundationalModelLibrary::BasicInputOutput::StandardOutputChannel";

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.moka.fuml.registry.AbstractSystemServicesRegistry#instantiateServices()
	 */
	@Override
	public List<IObject_> instantiateServices() {
		List<String> serviceQualifiedNames = new ArrayList<String>();
		serviceQualifiedNames.add(STANDARD_INPUT_CHANNEL_SERVICE_NAME);
		serviceQualifiedNames.add(STANDARD_OUTPUT_CHANNEL_SERVICE_NAME);
		return this.instantiateServices(FUML_LIBRARY_URI, serviceQualifiedNames);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.moka.fuml.registry.AbstractSystemServicesRegistry#instantiateService(org.eclipse.uml2.uml.Class)
	 */
	@Override
	protected Object_ instantiateService(Class service) {
		if (service.getQualifiedName().equals(STANDARD_INPUT_CHANNEL_SERVICE_NAME)) {
			return new StandardInputChannelImpl(service);
		} else if (service.getQualifiedName().equals(STANDARD_OUTPUT_CHANNEL_SERVICE_NAME)) {
			return new StandardOutputChannelImpl(service);
		}
		return null;
	}



}
