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
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.moka.simex.utils.EventUtil;
import org.eclipse.papyrus.moka.simex.utils.RequestUtils;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * @author SR246418
 *
 */
public class CreateAndDropAcceptEventActionCommand extends CreateAndDropGenericCommand {

	/**
	 * Constructor.
	 *
	 * @param targetActivity
	 * @param eClassToCreate
	 * @param eRefToSet
	 * @param droppedObject
	 * @param location
	 * @param targetEditPart
	 */
	public CreateAndDropAcceptEventActionCommand(Activity targetActivity, IElementType elementTypeToCreate, EObject droppedObject, Point location, GraphicalEditPart targetEditPart) {
		super(targetActivity, elementTypeToCreate, null, droppedObject, location, targetEditPart);
	}

	
	protected ActivityNode createNode() {
		AcceptEventAction action =  (AcceptEventAction) super.createNode();
		action.setIsUnmarshall(true);
		Trigger trigger = RequestUtils.createElementWithRequest( action, org.eclipse.papyrus.uml.service.types.element.UMLElementTypes.TRIGGER);
		String signalName = ((Signal)droppedObject).getName();
		trigger.setName(signalName+ "Trigger");		
		
		SignalEvent signalEvent = EventUtil.getSignalEvent((Signal) droppedObject);
		
		//this request should trigger the pin update through associated advice
		RequestUtils.setFeatureWithRequest(trigger, signalEvent, UMLPackage.eINSTANCE.getTrigger_Event());
		
		
		return action;
	}
}
