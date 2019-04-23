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

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.moka.simex.utils.EventUtil;
import org.eclipse.papyrus.moka.simex.utils.RequestUtils;
import org.eclipse.uml2.uml.AcceptCallAction;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLPackage;
/**
 * @author SR246418
 *
 */
public class CreateAndDropAcceptCallActionCommand extends CreateAndDropGenericCommand {


	
	public CreateAndDropAcceptCallActionCommand(Activity targetActivity, IElementType elementTypeToCreate,
			EReference eRefToSet, EObject droppedObject, Point location, GraphicalEditPart targetEditPart) {
		super(targetActivity, elementTypeToCreate, eRefToSet, droppedObject, location, targetEditPart);
		// TODO Auto-generated constructor stub
	}

	protected ActivityNode createNode() {
		AcceptCallAction action =  (AcceptCallAction) super.createNode();
		action.setIsUnmarshall(true);
		Operation operation = (Operation)droppedObject;
		Trigger trigger = RequestUtils.createElementWithRequest( action, org.eclipse.papyrus.uml.service.types.element.UMLElementTypes.TRIGGER);
		String operationName = ((Operation)droppedObject).getName();
		trigger.setName(operationName+ "Trigger");
		
		
		CallEvent callEvent =  EventUtil.getCallEvent(operation);
		
		//CallEvent callEvent = DnDUtils.createElementWithRequest(targetEditPart, container, org.eclipse.papyrus.uml.service.types.element.UMLElementTypes.CALL_EVENT);
		//don't use a request to avoid to trigger costly elementtype advice (cross referencer)
		callEvent.setOperation(operation);
		callEvent.setName(operationName+ "CallEvent");
		//we call the advice here
		RequestUtils.setFeatureWithRequest(trigger, callEvent, UMLPackage.eINSTANCE.getTrigger_Event());
		
		
		return action;
	}
}
