/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmi.ui.dnd;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalDropStrategy;
import org.eclipse.papyrus.moka.fmi.profile.util.FMIProfileUtil;
import org.eclipse.papyrus.moka.fmi.ui.Activator;
import org.eclipse.papyrus.moka.fmi.ui.commands.DropFMUAsPartCommand;
import org.eclipse.papyrus.moka.fmi.util.FMIUtil;
import org.eclipse.swt.graphics.Image;
//import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Class;


public class FMUToPartDropStrategy extends TransactionalDropStrategy {

	

	public String getLabel() {
		return "Drop an FMU as composite part";
	}

	public String getDescription() {
		return "Drop an FMU stereotyped Class into a composite structure. It automatically places input ports on the left and output ports on the right";
	}

	public Image getImage() {
		return null;
	}

	public String getID() {
		return Activator.PLUGIN_ID + ".component2part";
	}



	@Override
	protected Command doGetCommand(Request request, final EditPart targetEditPart) {

		if (!(request instanceof DropObjectsRequest)) {
			return null;
		}
		DropObjectsRequest dropRequest = (DropObjectsRequest) request;
		EObject targetSemanticElement = getTargetSemanticElement(targetEditPart);

		if ((targetSemanticElement instanceof Class) && (dropRequest.getLocation() != null)
				&& (targetEditPart instanceof GraphicalEditPart)) {
			final GraphicalEditPart targetGraphicalEditPart = (GraphicalEditPart) targetEditPart;

			final Class targetSimulator = (Class) targetSemanticElement;

			List<EObject> sourceElements = getSourceEObjects(request);

			// The only supported case is "Drop a single Component into a
			// Simulator"
			if (sourceElements.size() != 1) {
				return null;
			}

			final EObject sourceElement = sourceElements.get(0);
			if (sourceElement instanceof Class && FMIProfileUtil.isFMU((Class) sourceElement)) {
				final Class sourceType = (Class) sourceElement;
				Command resultCommand = new ICommandProxy(new DropFMUAsPartCommand(dropRequest,
						getTransactionalEditingDomain(targetGraphicalEditPart), targetSimulator, sourceType,
						targetGraphicalEditPart, getTargetView(targetGraphicalEditPart)));

				// workaround to avoid conflict with structure composite default
				// strategy
				// The default strategy is identified after those provided by
				// extension point
				// The following line is "breaking the request", hence the
				// default strategy won't return
				// a command and won't be selected by the
				// org.eclipse.papyrus.infra.gmfdiag.dnd.policy.CustomizableDropEditPolicy
				//dropRequest.setObjects(Collections.EMPTY_LIST);
				return resultCommand;
			}
		}
		return null;
	}


	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

}
