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

package org.eclipse.papyrus.moka.simex.dnd.strategy;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.papyrus.moka.simex.dnd.command.CreateAndDropAcceptEventActionCommand;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.UMLPackage;



/**
 * Drop strategy to create an AcceptEventAction from a Signal drop.
 * It also includes the creation of a nested trigger as well has a Signal event.
 * Hence the {@link AbstractDropInActivityStrategy#getCreateAndDropObjectCommand(EObject, Activity, Point, EditPart)}
 * is overloaded to retrun a custom Command instead of the default generic drop command.
 * 
 * @author SR246418
 *
 */
public class SignalToAcceptEventActionStrategy extends AbstractDropInActivityStrategy {

	public SignalToAcceptEventActionStrategy() {
		super(UMLPackage.eINSTANCE.getSignal(), UMLElementTypes.ACCEPT_EVENT_ACTION, null);
	}

	
	@Override
	protected Command getCreateAndDropObjectCommand(EObject droppedObject, Activity targetActivity, Point location, GraphicalEditPart targetEditPart) {
		CreateAndDropAcceptEventActionCommand command = new CreateAndDropAcceptEventActionCommand(targetActivity, elementTypeToCreate, droppedObject, location, targetEditPart);
		command.setPrefix("accept");
		return new ICommandProxy(command);

	}

}
