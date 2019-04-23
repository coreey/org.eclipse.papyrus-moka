/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.simex.dnd.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.moka.simex.advices.LinkActionEditHelperAdvice;
import org.eclipse.papyrus.moka.simex.utils.RequestUtils;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;

/**
 * @author sr246418
 *
 */
public class CreateAndDropLinkActionCommand extends CreateAndDropGenericCommand {


	
	public CreateAndDropLinkActionCommand(Activity targetActivity, IElementType elementTypeToCreate,
			EReference eRefToSet, EObject droppedObject, Point location, GraphicalEditPart targetEditPart) {
		super(targetActivity, elementTypeToCreate, eRefToSet, droppedObject, location, targetEditPart);
		// TODO Auto-generated constructor stub
	}

	
	@SuppressWarnings("unchecked")
	@Override
	protected ActivityNode createNode() {
		CreateElementRequest createReq = new CreateElementRequest(targetActivity, elementTypeToCreate);
		createReq.getParameters().put(LinkActionEditHelperAdvice.LINK_ACTION_ASSOCIATION, droppedObject);
		
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetActivity);
		if (provider != null) {
			
			ICommand createCommand = provider.getEditCommand(createReq);

			if (createCommand != null && createCommand.canExecute()) {
				try {
					createCommand.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {

					e.printStackTrace();
				}
				CommandResult result = createCommand.getCommandResult();
				ActivityNode createdNode= RequestUtils.getCreatedObject(result);
				String defaultName = getDefaultName(createdNode);
				createdNode.setName(defaultName);
				return createdNode;
			}
		}
		return null;
	}
}
