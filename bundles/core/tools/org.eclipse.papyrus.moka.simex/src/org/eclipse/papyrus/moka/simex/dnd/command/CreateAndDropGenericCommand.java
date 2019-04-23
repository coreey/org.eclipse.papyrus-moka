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
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.CreateViewCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.moka.simex.dnd.strategy.DndMessages;
import org.eclipse.papyrus.moka.simex.utils.RequestUtils;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.UMLFactory;



/**
 * @author sr246418
 *
 */
public class CreateAndDropGenericCommand extends AbstractCommand {


	protected Activity targetActivity;
	protected EClass eClassToCreate;
	protected EReference eRefToSet;
	protected EObject droppedObject;
	protected Point location;
	protected GraphicalEditPart targetEditPart;
	protected String namePrefix= null;
	protected String nameSuffix= null;
	
	protected IElementType elementTypeToCreate;

	public CreateAndDropGenericCommand(Activity targetActivity, EClass eClassToCreate, EReference eRefToSet, EObject droppedObject, Point location, GraphicalEditPart targetEditPart) {
		super("Create and Drop Object");
		initCommonFields(targetActivity, eRefToSet, droppedObject, location, targetEditPart);
		this.eClassToCreate = eClassToCreate;
		this.elementTypeToCreate = null;

	}

	private void initCommonFields(Activity targetActivity, EReference eRefToSet, EObject droppedObject, Point location, GraphicalEditPart targetEditPart) {
		this.targetActivity = targetActivity;
		this.eRefToSet = eRefToSet;
		this.droppedObject = droppedObject;
		this.location = location;
		this.targetEditPart = targetEditPart;

	}

	public CreateAndDropGenericCommand(Activity targetActivity, IElementType elementTypeToCreate, EReference eRefToSet, EObject droppedObject, Point location, GraphicalEditPart targetEditPart) {
		super("Create and Drop Object");
		initCommonFields(targetActivity, eRefToSet, droppedObject, location, targetEditPart);
		this.eClassToCreate = null;
		this.elementTypeToCreate = elementTypeToCreate;
	}

	private EClass getEClassToCreate() {
		return eClassToCreate != null ? eClassToCreate : elementTypeToCreate.getEClass();
	}

	/**
	 * @see org.eclipse.core.commands.operations.AbstractOperation#getLabel()
	 *
	 * @return
	 */
	@Override
	public String getLabel() {
		Object[] bindings = { droppedObject.eClass().getName(), getEClassToCreate().getName() };
		return NLS.bind(DndMessages.AbstractDropStrategy_Label, bindings);
	}


	/**
	 * @param receiver
	 * @param receiverFeature
	 * @param value
	 */
	private void setFeature(EObject receiver, EStructuralFeature receiverFeature, EObject value) {
		Command setFeatureCommand = RequestUtils.getSetFeatureCommand(receiver, value, eRefToSet);
		if (setFeatureCommand != null && setFeatureCommand.canExecute()) {
			setFeatureCommand.execute();
		}
	}


	/**
	 * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 *
	 * @param progressMonitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

		ActivityNode createdNode = createNode();
		if (eRefToSet != null) {
			setFeature(createdNode, eRefToSet, droppedObject);
		}
		dropNode(createdNode);
//		PropertyEditorFactory factory = new PropertyEditorFactory();
//		factory.edit(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), createdNode);

		return CommandResult.newOKCommandResult();
	}

	/**
	 * @param createdNode
	 */
	private void dropNode(ActivityNode createdNode) {
		View targetView =  NotationHelper.findView(targetEditPart);
		ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(createdNode), Node.class,
				((IHintedType) UMLElementTypes.getElementType(UMLVisualIDRegistry.getNodeVisualID( NotationHelper.findView(targetEditPart), createdNode)))
						.getSemanticHint(),
						targetEditPart.getDiagramPreferencesHint());
		CreateViewCommand createCommand = new CreateViewCommand(targetEditPart.getEditingDomain(), descriptor, targetView);

		try {
			createCommand.execute(null, null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		Point localLocation = location.getCopy();
		targetEditPart.getContentPane().translateToRelative(localLocation);
		
		
		SetBoundsCommand setBoundsCommand = new SetBoundsCommand(targetEditPart.getEditingDomain(), "move",
				(IAdaptable) createCommand.getCommandResult().getReturnValue(), localLocation);

		try {
			setBoundsCommand.execute(null, null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}


	/**
	 * 
	 */
	protected ActivityNode createNode() {
		ActivityNode createdNode = null;
		Element container = getNodeContainer();
		if (eClassToCreate != null) {
			if (container instanceof Activity){
				createdNode = ((Activity) container).createOwnedNode(null, eClassToCreate);
			}else if (container instanceof StructuredActivityNode){
				createdNode = (ActivityNode) UMLFactory.eINSTANCE.create(eClassToCreate);
				((StructuredActivityNode) container).getNodes().add(createdNode);
			}
			
			
		} else {
			createdNode = RequestUtils.createElementWithRequest(container, elementTypeToCreate);
		}
		String defaultName = getDefaultName(createdNode);
		createdNode.setName(defaultName);
		return createdNode;
	}

	private Element getNodeContainer() {
		EObject semanticElement = targetEditPart.resolveSemanticElement();
		if (semanticElement instanceof StructuredActivityNode){
			return (StructuredActivityNode)semanticElement;
		}else {
			return targetActivity;
		}
	}

	/**
	 * @param createdNode
	 * @return
	 */
	protected String getDefaultName(ActivityNode createdNode) {
		String defaultName;
		if (droppedObject instanceof NamedElement && ((NamedElement)droppedObject).getName()!= null && (namePrefix!= null || nameSuffix != null)){
			String droppedObjectName = ((NamedElement)droppedObject).getName();
			
			if (namePrefix != null) {
				defaultName = namePrefix;
				if (!droppedObjectName.isEmpty()){
					defaultName+= Character.toUpperCase(droppedObjectName.charAt(0));
					
				}
				if (droppedObjectName.length() > 1){
					defaultName += droppedObjectName.substring(1);
				}
			}else {
				defaultName = droppedObjectName;
			}
			if(nameSuffix!= null) {
				defaultName += nameSuffix;
			}
		}else {
			 defaultName = NamedElementUtil.getDefaultNameWithIncrement(createdNode, createdNode.eContainer().eContents());
		}
		return defaultName;
	}

	public void setPrefix(String prefix){
		this.namePrefix=prefix;
	}
	public void setSuffix(String suffix){
		this.nameSuffix=suffix;
	}



	/**
	 * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doRedoWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 *
	 * @param progressMonitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doUndoWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 *
	 * @param progressMonitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

}
