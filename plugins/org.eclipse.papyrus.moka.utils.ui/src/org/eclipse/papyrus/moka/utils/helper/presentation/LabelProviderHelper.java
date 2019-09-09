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
package org.eclipse.papyrus.moka.utils.helper.presentation;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.swt.graphics.Image;

public class LabelProviderHelper extends LabelProvider {

	protected static LabelProviderHelper INSTANCE = null;
	
	protected LabelProviderService labelProviderService; 
	
	private LabelProviderHelper(){
		this.labelProviderService = this.getLabelProviderService();
	}

	private LabelProviderService getLabelProviderService(){
		LabelProviderService service = new LabelProviderServiceImpl();
		try {
			service.startService();
		} catch (ServiceException e) {
			service = null;
		}
		return service;
	}
	
	public static LabelProviderHelper getInstance(){
		if(INSTANCE == null){
			INSTANCE = new LabelProviderHelper();
		}
		return INSTANCE;
	}

	public Image getImage(Object element) {
		// Return the image corresponding to the specified element.
		// If no label provider could be found then null is returned.
		Image image = null;
		if(labelProviderService != null){
			ILabelProvider provider = this.labelProviderService.getLabelProvider(element);
			if(provider != null){
				image = provider.getImage(element);
			}
		}
		return image;
	}

	@Override
	public String getText(Object element) {
		// Return the textual representation of the specified element.
		// If no label provider could be found the text that is returned is null.
		String text = null;
		if(labelProviderService != null){
			ILabelProvider provider = this.labelProviderService.getLabelProvider(element);
			if(provider != null){
				text = provider.getText(element);
			}
		}
		return text;
	}
}