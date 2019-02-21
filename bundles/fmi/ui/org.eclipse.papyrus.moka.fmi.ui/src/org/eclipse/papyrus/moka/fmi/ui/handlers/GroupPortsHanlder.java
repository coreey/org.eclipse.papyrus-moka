/*****************************************************************************
 * 
 * Copyright (c) 2019 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/

package org.eclipse.papyrus.moka.fmi.ui.handlers;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.ui.command.AbstractCommandHandler;
import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIPort;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.util.UMLUtil;

public class GroupPortsHanlder extends AbstractCommandHandler {

	@Override
	protected Command getCommand(IEvaluationContext context) {

		List<EObject> selection = getSelectedElements();

		if (selection != null && selection.size() > 0) {

			if (selection.stream()
					.allMatch(elem -> elem instanceof Port
							&& UMLUtil.getStereotypeApplication((Port) elem, FMIPort.class) != null)
					&& selection.stream().map(p -> (Element) p).collect(Collectors.groupingBy(Element::getOwner))
							.size() == 1) {

//				return new RecordingCommand(getEditingDomain(context)) {
//
//					@Override
//					protected void doExecute() {
//						org.eclipse.uml2.uml.Class owningClass = ((Port) selection.get(0)).getClass_();
//						
//						
//						Port newPort = (Port) PapyrusUtilsModule.createSemanticElement(owningClass,
//								UMLElementTypes.PORT.getId());
//						
//						ResourceSet resSet = owningClass.eResource().getResourceSet();
//						Stereotype busStereo = (Stereotype) resSet.getEObject(OMSimulatorProfileUtil.OMSIMULATOR_BUS_URI, true);
//						OMSimulatorBus bus =  (OMSimulatorBus) UMLUtil.safeApplyStereotype(newPort, busStereo);
//
//						
//						List<Port> semanticPorts = new ArrayList<>();
//						List<EObject> portsViews = new ArrayList<>();
//						GraphicalEditPart parent = null;
//						
//						for (Object selectedElement : getSelection()) {
//							if (selectedElement instanceof GraphicalEditPart) {		
//								GraphicalEditPart editPart = (GraphicalEditPart) selectedElement;
//								semanticPorts.add((Port) editPart.resolveSemanticElement());
//								portsViews.add(editPart.getNotationView());
//								
//								if (parent == null) {
//									parent = (GraphicalEditPart) editPart.getParent();
//								}
//							}
//
//						}
//						
//						Node parentView = (Node) parent.getNotationView();
//				
//						Integer sumX = 0;
//						Integer sumY = 0;
//						
//						
//						for (EObject portView : portsViews) {
//							Bounds constraint = (Bounds) ((Node)portView).getLayoutConstraint();
//							sumX +=constraint.getX();
//							sumY += constraint.getY();
//							
//						}
//						
//						
//						double xMean = sumX/portsViews.size();
//						double yMean = sumY/portsViews.size();
//						Bounds parentConstraints = (Bounds) ((Node)parentView).getLayoutConstraint();
//						
//						
//						RequestUtils.deleteObjectsWithRequest(portsViews);
//						
//						
//						bus.getSignals().addAll(semanticPorts);
//						
//						PapyrusUtilsModule.createRelativeView(
//								newPort, 
//								UMLDIElementTypes.PORT_SHAPE.getId(),
//								parentView ,
//								xMean/parentConstraints.getWidth(), 
//								yMean/parentConstraints.getHeight(),
//								null, null);
//					}
//
//				};
			}

		}
	
		return null;
	}

}
