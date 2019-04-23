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

import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.moka.debug.model.data.mapping.variables.MokaVariableAdapter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;

public class MokaDebugModelPresentation implements IDebugModelPresentation{

	public static final String ID = "org.eclipse.papyrus.moka.debug.mokaModelPresentation"; 
	
	@Override
	public Image getImage(Object element) {
		// Return the icon corresponding to the variable adapter
		ILabelProvider provider = null;
		if(element instanceof MokaVariableAdapter){
			provider = MokaDebugLabelProviderFactory.getInstance().instantiate((MokaVariableAdapter<?>)element);
		}
		if(provider != null){
			return provider.getImage(element);
		}
		return null;
	}

	@Override
	public String getText(Object element) {
		// Return the text corresponding to the variable adapter
		ILabelProvider provider = null;
		if(element instanceof MokaVariableAdapter){
			provider = MokaDebugLabelProviderFactory.getInstance().instantiate((MokaVariableAdapter<?>)element);
		}
		if(provider != null){
			return provider.getText(element);
		}
		return null;
	}

	
	@Override
	public void addListener(ILabelProviderListener listener) {
		// By default no listener can be added
	}

	@Override
	public void dispose() {
		// By default no resource are disposed
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
	}

	@Override
	public IEditorInput getEditorInput(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEditorId(IEditorInput input, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttribute(String attribute, Object value) {
		// TODO Auto-generated method stub
	}

	@Override
	public void computeDetail(IValue value, IValueDetailListener listener) {
		// TODO Auto-generated method stub
	}

}
