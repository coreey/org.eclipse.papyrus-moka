/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
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
import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.swt.graphics.Image;

public class ParameterValueVariableLabelProvider extends UMLDebugLabelProvider{

	@Override
	public Image getImage(Object element) {
		if(element != null) {
			UMLVariableAdapter<?> variableAdapter = (UMLVariableAdapter<?>) element; 
			IParameterValue parameterValue = (IParameterValue) variableAdapter.getAdapted();
			ILabelProvider provider = this.getPapyrusLabelProvider(parameterValue.getParameter());
			if(provider != null) {
				return provider.getImage(parameterValue.getParameter());
			}
		}
		return null;
	}

}
