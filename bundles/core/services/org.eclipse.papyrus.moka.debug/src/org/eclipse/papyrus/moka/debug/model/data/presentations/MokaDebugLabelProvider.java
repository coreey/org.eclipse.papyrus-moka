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
package org.eclipse.papyrus.moka.debug.model.data.presentations;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.moka.debug.model.data.mapping.variables.MokaVariableAdapter;
import org.eclipse.uml2.uml.Element;

public abstract class MokaDebugLabelProvider implements ILabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {
		// Do nothing
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// Do nothing
	}
	
	@Override
	public boolean isLabelProperty(Object element, String property) {
		// Do nothing
		return false;
	}
	
	@Override
	public void dispose() {
		// Do nothing
	}
	
	@Override
	public String getText(Object element) {
		if(element != null){
			try {
				return ((MokaVariableAdapter<?>)element).getName();
			} catch (DebugException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	protected ILabelProvider getPapyrusLabelProvider(Element element) {
		ILabelProvider papyrusProvider = null;
		if(element != null && element.eResource() != null) {
			ServicesRegistry registry = null;
			try {
				registry = ServiceUtilsForResource.getInstance().getServiceRegistry(element.eResource());
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			if(registry != null) {
				LabelProviderService service = null;
				try {
					service = registry.getService(LabelProviderService.class);
				} catch (ServiceException e) {
					e.printStackTrace();
				}
				if(service != null) {
					papyrusProvider = service.getLabelProvider(element);
				}
			}
		}
		
		return papyrusProvider;
	}

}
