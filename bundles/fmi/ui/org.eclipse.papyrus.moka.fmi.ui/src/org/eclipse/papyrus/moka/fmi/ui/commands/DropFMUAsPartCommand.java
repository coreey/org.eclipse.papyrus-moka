/*****************************************************************************
 * 
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
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmi.ui.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.moka.fmi.profile.util.FMIProfileUtil;
import org.eclipse.papyrus.moka.ssp.profile.custom.StereotypeStrings;
import org.eclipse.papyrus.sysml14.portsandflows.FlowDirection;
import org.eclipse.papyrus.uml.diagram.composite.custom.edit.command.CreateViewCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PropertyPartEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

public class DropFMUAsPartCommand extends AbstractTransactionalCommand {

	protected static final int PORT_DEFAULT_HEIGHT = 20;
	protected static final int WIDTH_FACTOR = 11;
	protected static final int MIN_WIDTH = 150;
	protected static final int MIN_HEIGHT = 150;

	protected static final double X_FONT_HEIGHT_FACTOR = 0.9;
	protected static final double Y_FONT_HEIGHT_FACTOR = 0.85;

	protected static final double X_WEST_OFFSET = 8;
	protected static final int Y_LABEL_OFFSET = 20;




	protected Class targetSimulator;
	protected Class sourceType;
	protected DropObjectsRequest request;
	protected Property newPart;
	protected GraphicalEditPart targetGraphicalEditPart;

	protected View targetView;

	protected TransactionalEditingDomain domain;

	enum PositionKind {
		EAST, WEST
	};

	public DropFMUAsPartCommand(DropObjectsRequest request, TransactionalEditingDomain domain,
			Class containerClass, Class sourceType, GraphicalEditPart targetEditPart, View targetView) {
		super(domain, "Create a composite part from FMU and create graphical view",
				getWorkspaceFiles(containerClass));
		this.targetSimulator = containerClass;
		this.sourceType = sourceType;
		this.request = request;
		this.targetGraphicalEditPart = targetEditPart;
		this.targetView = targetView;
		this.domain = domain;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		createNewPart();
		createGraphicalViews();

		request.setResult(newPart);
		return CommandResult.newOKCommandResult(newPart);

	}

	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// TODO Auto-generated method stub
		return super.doUndo(monitor, info);
	}
	protected void createNewPart() {
		

		String partName = sourceType.getName();

		
		newPart = targetSimulator.createOwnedAttribute(partName, sourceType);
		newPart.setName(NamedElementUtil.getDefaultNameWithIncrementFromBase(partName,targetSimulator.getOwnedAttributes()));
		newPart.setAggregation(AggregationKind.COMPOSITE_LITERAL);
		
		Stereotype stereotype = newPart.getApplicableStereotype(StereotypeStrings.SSDCOMPONENT_QUALIFIEDNAME);
		if (stereotype != null) {
			EObject SsdComponent = newPart.applyStereotype(stereotype);
		}
		
	}



	protected void createGraphicalViews() {
		List<Port> inPorts = collectPorts(newPart, FlowDirection.IN);
		List<Port> outPorts = collectPorts(newPart, FlowDirection.OUT);
		outPorts.addAll(collectPorts(newPart, FlowDirection.INOUT));

		int figureWidth = Math.max(MIN_WIDTH, WIDTH_FACTOR * newPart.getName().length());

		int maxPortOnOneSide = Math.max(inPorts.size(), outPorts.size());
		int figureHeight = Math.max(MIN_HEIGHT, (2 * maxPortOnOneSide + 1) * PORT_DEFAULT_HEIGHT);
		
		String elementType = PropertyPartEditPartCN.VISUAL_ID;
		
		ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(newPart), Node.class,
				((IHintedType) UMLElementTypes.getElementType(elementType))
				.getSemanticHint(),
				targetGraphicalEditPart.getDiagramPreferencesHint());
		CreateViewCommand createCommand = new CreateViewCommand(domain, descriptor, targetView);

		try {
			createCommand.execute(null, null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		Point location = request.getLocation().getCopy();
		targetGraphicalEditPart.getContentPane().translateToRelative(location);
		Dimension dimension = new Dimension(figureWidth, figureHeight);
		Rectangle partRectangle = new Rectangle(location, dimension);
		SetBoundsCommand setBoundsCommand = new SetBoundsCommand(domain, "move",
				(IAdaptable) createCommand.getCommandResult().getReturnValue(), partRectangle);

		try {
			setBoundsCommand.execute(null, null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		createPorts(inPorts, outPorts, partRectangle, (IAdaptable) createCommand.getCommandResult().getReturnValue());

	}

	private void createPorts(List<Port> inPorts, List<Port> outPorts, Rectangle rectangle, IAdaptable figureAdapter) {

		View view = (View) figureAdapter.getAdapter(View.class);

		for (int index = 0; index < inPorts.size(); index++) {
			Port port = inPorts.get(index);
			Point proposedLocation = new Point(0, (index + 1) * rectangle.height / (inPorts.size() + 1));
			createPortView(port, proposedLocation, view, PositionKind.EAST);
		}

		for (int index = 0; index < outPorts.size(); index++) {
			Port port = outPorts.get(index);
			Point proposedLocation = new Point(rectangle.width, (index + 1) * rectangle.height / (outPorts.size() + 1));
			createPortView(port, proposedLocation, view, PositionKind.WEST);

		}

	}

	private void createPortView(Port port, Point location, View view, PositionKind position) {
		ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(port), Node.class,
				((IHintedType) UMLElementTypes.getElementType(UMLVisualIDRegistry.getNodeVisualID(view, port)))
				.getSemanticHint(),
				targetGraphicalEditPart.getDiagramPreferencesHint());

		CreateViewCommand createCommand = new CreateViewCommand(domain, descriptor, view);

		try {
			createCommand.execute(null, null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		SetBoundsCommand setBoundsCommand = new SetBoundsCommand(domain, "move",
				(IAdaptable) createCommand.getCommandResult().getReturnValue(), location);

		try {
			setBoundsCommand.execute(null, null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	

		

	}

	

	private List<Port> collectPorts(Property newPart, FlowDirection direction) {
		List<Port> ret = new ArrayList<Port>();
		Class partType = (Class) newPart.getType();
		for (Port port : partType.getOwnedPorts()) {
			if (direction ==FMIProfileUtil.getDirection(port)) {
				ret.add(port);
			}
		}
		return ret;
	}

	
	


	
}
