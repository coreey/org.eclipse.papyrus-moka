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

package org.eclipse.papyrus.moka.engine.uml.debug.data.presentation;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.UMLVariableAdapter;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IFeatureValue;
import org.eclipse.swt.graphics.Image;

public class FeatureValueVariableLabelProvider extends UMLDebugLabelProvider {
	
	@Override
	public Image getImage(Object element) {
		if(element != null){
			UMLVariableAdapter<?> variableAdapter = (UMLVariableAdapter<?>) element; 
			IFeatureValue featureValue = (IFeatureValue) variableAdapter.getAdapted();
			ILabelProvider provider = this.getPapyrusLabelProvider(featureValue.getFeature());
			if(provider != null) {
				return provider.getImage(featureValue.getFeature());
			}
		}
		return null;
	}

}
