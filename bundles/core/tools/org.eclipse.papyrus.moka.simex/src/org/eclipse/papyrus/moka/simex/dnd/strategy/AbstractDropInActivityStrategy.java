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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalDropStrategy;
import org.eclipse.papyrus.moka.simex.dnd.command.CreateAndDropGenericCommand;
import org.eclipse.papyrus.moka.simex.utils.RequestUtils;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityGroup;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.StructuredActivityNode;



/**
 * @author sr246418
 *
 */
public class AbstractDropInActivityStrategy extends TransactionalDropStrategy {


	public static final String SIMEX_DROP_STRATEGY_PREFIX = "org.eclipse.papyrus.moka.simex.";
	protected EClass droppedObjectEClass;
	protected EClass eObjectToCreateType;
	protected EReference referenceToSet;

	protected IElementType elementTypeToCreate;
	protected String namePrefix= null;
	protected String nameSuffix= null;
	
	protected AbstractDropInActivityStrategy(EClass droppedObjectEClass, EClass eObjectToCreateType, EReference referenceToSet) {
		this.droppedObjectEClass = droppedObjectEClass;
		this.eObjectToCreateType = eObjectToCreateType;
		this.referenceToSet = referenceToSet;
		this.elementTypeToCreate= null;
	}
	
	protected AbstractDropInActivityStrategy(EClass droppedObjectEClass, IElementType elementTypeCreateType, EReference referenceToSet) {
		this.droppedObjectEClass = droppedObjectEClass;
		this.eObjectToCreateType = null;
		this.referenceToSet = referenceToSet;
		this.elementTypeToCreate = elementTypeCreateType;
	}


	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.DropStrategy#getLabel()
	 *
	 * @return
	 */
	@Override
	public String getLabel() {
		
		String targetTypeName = getEClassToCreate().getName();
		Object[] bindings = { droppedObjectEClass.getName(), targetTypeName };
		return NLS.bind(DndMessages.AbstractDropStrategy_Label, bindings);
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.DropStrategy#getDescription()
	 *
	 * @return
	 */
	@Override
	public String getDescription() {
		if (referenceToSet != null){
			Object[] bindings = { droppedObjectEClass.getName(), getEClassToCreate().getName(), referenceToSet.getName() };
			return NLS.bind(DndMessages.AbstractDropStrategy_Description, bindings);
		}else {
			Object[] bindings = { droppedObjectEClass.getName(), getEClassToCreate().getName() };
			return NLS.bind(DndMessages.AbstractDropStrategy_Description_No_Ref, bindings);
		}
		
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.DropStrategy#getImage()
	 *
	 * @return
	 */
	@Override
	public Image getImage() {
		
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.DropStrategy#getID()
	 *
	 * @return
	 */
	@Override
	public  String getID() {

		return SIMEX_DROP_STRATEGY_PREFIX + droppedObjectEClass.getName() + "." + getEClassToCreate().getName();
	}
	


	/**
	 * @return
	 */
	private EClass getEClassToCreate() {
		return eObjectToCreateType != null ? eObjectToCreateType : elementTypeToCreate.getEClass();
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.DropStrategy#getPriority()
	 *
	 * @return
	 * @deprecated
	 */
	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalDropStrategy#doGetCommand(org.eclipse.gef.Request, org.eclipse.gef.EditPart)
	 *
	 * @param request
	 * @param targetEditPart
	 * @return
	 */
	@Override
	protected Command doGetCommand(Request request, EditPart targetEditPart) {
		
		if (!(request  instanceof DropObjectsRequest)){
			return null;
		}
		DropObjectsRequest dropReq = (DropObjectsRequest) request;
		List<EObject> handledDroppedObjects = getHandledDroppedObjects(dropReq);
		EObject targetElement = getTargetSemanticElement(targetEditPart);
		
		if (! canHandleRequest(handledDroppedObjects, targetElement)){
			return null;
		}
		
		if (targetElement.eClass() == getEClassToCreate() ){
			return RequestUtils.getSetFeatureCommand(targetElement, handledDroppedObjects.get(0), referenceToSet);
		}else{
			Activity targetActivity = getTargetActivity(targetElement);
			Point location = dropReq.getLocation();
			CompoundCommand compoundCommand = new CompoundCommand();
			for (EObject droppedObject : handledDroppedObjects ){
				compoundCommand.add(getCreateAndDropObjectCommand(droppedObject, targetActivity,location, (GraphicalEditPart)targetEditPart));
				location.performTranslate(5, 5);
			}
			return compoundCommand;
		}
			
	}

	/**
	 * @param droppedObject 
	 * @param targetActivity
	 * @param location
	 * @param targetEditPart 
	 * @return
	 */
	protected Command getCreateAndDropObjectCommand(EObject droppedObject, Activity targetActivity, Point location, GraphicalEditPart targetEditPart) {		
		CreateAndDropGenericCommand command;
		if (eObjectToCreateType != null) {
			command= new CreateAndDropGenericCommand(targetActivity, eObjectToCreateType, referenceToSet, droppedObject, location, targetEditPart);
		}else {
			command = new CreateAndDropGenericCommand(targetActivity, elementTypeToCreate, referenceToSet, droppedObject, location, targetEditPart);
		}
		command.setPrefix(namePrefix);
		command.setSuffix(nameSuffix);
		
		return new ICommandProxy(command);
	}


	/**
	 * @param targetElement
	 * @return
	 */
	private Activity getTargetActivity(EObject targetElement) {
		if(targetElement instanceof Activity){
			return (Activity) targetElement;
		}else if (targetElement instanceof ActivityGroup){
			return ((ActivityGroup)targetElement).containingActivity();
		}
		return null;
	}





	protected List<EObject> getHandledDroppedObjects(Request req){
		List<EObject> droppedObjects = getSourceEObjects(req);
		List<EObject> result = new ArrayList<EObject>();
		if (droppedObjects != null){
			for (EObject droppedObject: droppedObjects){
				if (droppedObject.eClass() == droppedObjectEClass || droppedObject.eClass().getEAllSuperTypes().contains(droppedObjectEClass)){
					result.add(droppedObject);
				}
			}
		}
		
		return result;
	}
	
	protected boolean canHandleRequest(List<EObject> droppedObjects, EObject targetElement) {
		boolean result = false;
		if (!droppedObjects.isEmpty()){
			result = (targetElement instanceof Activity || (targetElement instanceof StructuredActivityNode && !(targetElement instanceof LoopNode)) || 
					(targetElement.eClass() == getEClassToCreate() && droppedObjects.size() == 1 ));
		}
		return result;
	}
	
	public void setNamePrefix(String prefix){
		namePrefix = prefix;
	}
	
	public void setNameSuffix(String suffix){
		nameSuffix = suffix;
	}
}


