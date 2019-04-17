/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.trace.formater;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.papyrus.moka.trace.interfaces.format.ITraceFileFormater;

public class MokaJsonTraceFileFormater extends AbstractTraceFileFormater implements ITraceFileFormater {

	public static final String MOKA_JSON_FORMATER_ID = "org.eclipse.papyrus.moka.trace.formater.mokaJsonFormater"; //$NON-NLS-1$
	
	public MokaJsonTraceFileFormater() {
		super();
	}

	@Override
	public void rightTrace(String filePath, Object trace) {
		if (trace instanceof EObject) {
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
			Map<String, Object> m = reg.getExtensionToFactoryMap();
			m.put("mokaTrace", new XMIResourceFactoryImpl()); //$NON-NLS-1$
			ResourceSet resSet = new ResourceSetImpl();
			Resource resource = resSet.createResource(URI
					.createURI(filePath));
			resource.getContents().add((EObject) trace);
			try {
				resource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
