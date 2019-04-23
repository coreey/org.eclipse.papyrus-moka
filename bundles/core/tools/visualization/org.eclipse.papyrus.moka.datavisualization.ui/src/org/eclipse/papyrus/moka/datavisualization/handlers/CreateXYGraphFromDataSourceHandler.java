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
package org.eclipse.papyrus.moka.datavisualization.handlers;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.ui.command.AbstractCommandHandler;
import org.eclipse.papyrus.moka.datavisualization.profile.DataSource;
import org.eclipse.papyrus.moka.datavisualization.util.VisualizationUtil;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Stereotype;

public class CreateXYGraphFromDataSourceHandler extends AbstractCommandHandler{

	@Override
	protected Command getCommand(IEvaluationContext context) {
		
		EObject selectedElement = getSelectedElement();

		if( !(selectedElement instanceof DataType) )
			return null;
		
		DataType dataType = (DataType) selectedElement;
		
		Stereotype stereotype = VisualizationUtil.getDataSourceStereotype(dataType); 
		if(  stereotype == null )
			return null;
		
		DataSource dataSource = (DataSource)dataType.getStereotypeApplication(stereotype);
		return new CreateXYGraphFromDataSourceCommand(getEditingDomain(context), dataSource, context);
	}
	
}
