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
package org.eclipse.papyrus.moka.xygraph.common.model;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;

public class XYGraphDescriptorModel extends AbstractModelWithSharedResource<XYGraphDescriptor>{

	public static final String MODEL_ID = "org.eclipse.papyrus.moka.xygraph.model.XYGraphDescriptorModel"; //$NON-NLS-1$
	public static final String MODEL_FILE_EXTENSION = "notation"; //$NON-NLS-1$
	
	@Override
	protected boolean isModelRoot(EObject object) {
		return object instanceof XYGraphDescriptor;
	}

	@Override
	protected String getModelFileExtension() {
		return MODEL_FILE_EXTENSION;
	}

	@Override
	public String getIdentifier() {
		return MODEL_ID;
	}
	
	public void addXYGraphDescriptor(XYGraphDescriptor desc){
		Resource targetResource = getResource(desc.getContext(), desc);
		
		if( targetResource != null ){
			targetResource.getContents().add(desc);
		}
	}
	
	public Resource getResource(EObject context, XYGraphDescriptor desc){		
		if( context != null ){
			Resource targetResource;
			Resource contextResource = context.eResource();
			
			if (!contextResource.getURI().trimFileExtension().equals(getResource().getURI().trimFileExtension())) {
				URI uri = contextResource.getURI();
				uri = uri.trimFileExtension();
				uri = uri.appendFileExtension(getModelFileExtension());
				ResourceSet set = contextResource.getResourceSet();
				targetResource = set.getResource(uri, true);
			} else {
				targetResource = getResource();
			}
			
			return targetResource;
		}
		
		return null;
	}
}
