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

package org.eclipse.papyrus.moka.simex.utils;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;

/**
 * @author SR246418
 *
 */
public class RequestUtils {

	/**
	 * @param targetElement
	 * @param eObject
	 * @return
	 */
	public static Command getSetFeatureCommand(EObject targetElement, Object value, EStructuralFeature featureToSet) {
		SetRequest req = new SetRequest(targetElement, featureToSet, value);
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetElement);

		if (provider != null) {
			ICommand setCommand = provider.getEditCommand(req);

			if (setCommand != null && setCommand.canExecute()) {
				return new ICommandProxy(setCommand);
			}
		}
		return null;
	}

	public static void setFeatureWithRequest(EObject objectToModify, Object value, EStructuralFeature featureToSet) {
		Command setFeatureCommand = getSetFeatureCommand(objectToModify, value, featureToSet);
		if (setFeatureCommand != null && setFeatureCommand.canExecute()) {
			setFeatureCommand.execute();
			
		}
	}

	public static <T extends EObject> T createElementWithRequest(EObject receiver, IElementType elementTypeToCreate, EReference containmentFeature) {
		CreateElementRequest createElementRequest;
		if (containmentFeature == null) {
			createElementRequest = new CreateElementRequest(receiver, elementTypeToCreate);
		} else {
			createElementRequest = new CreateElementRequest(receiver, elementTypeToCreate, containmentFeature);
		}

		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(receiver);
		if (provider != null) {
			ICommand createCommand = provider.getEditCommand(createElementRequest);

			if (createCommand != null && createCommand.canExecute()) {
				try {
					createCommand.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {

					e.printStackTrace();
				}
				CommandResult result = createCommand.getCommandResult();
				return getCreatedObject(result);
			}

		}
		return null;
	}

	/**
	 * @param targetEditPart
	 * @param targetActivity
	 * @param elementTypeToCreate
	 * @return
	 */
	public static <T extends EObject> T createElementWithRequest(EObject receiver, IElementType elementTypeToCreate) {
		return createElementWithRequest(receiver, elementTypeToCreate, null);

	}

	public static <T extends EObject> T getCreatedObject(CommandResult commandResult) {
		Object objectResult = commandResult.getReturnValue();
		if (objectResult instanceof List) {
			// Result of the semantic + graphical creation command
			List<?> listResult = (List<?>) objectResult;
			for (Object elementResult : listResult) {
				if (elementResult instanceof CreateElementRequestAdapter) {
					CreateElementRequest request = (CreateElementRequest) ((CreateElementRequestAdapter) elementResult).getAdapter(CreateElementRequest.class);
					if (request != null) {
						EObject newElement = request.getNewElement();
						if (newElement instanceof EObject) {
							return (T) newElement;
						}
					}
				}
			}
		} else if (commandResult.getReturnValue() instanceof EObject) {
			// Result of the semantic creation command
			return (T) commandResult.getReturnValue();
		}

		return null;
	}

	/**
	 * @param pinsToDelete
	 */
	public static void deleteObjectsWithRequest(List<EObject> objectsDelete) {
		for (EObject objectToDelete : objectsDelete) {
			deleteObjectWithRequest(objectToDelete);
		}

	}

	/**
	 * @param objectToDelete
	 */
	public static void deleteObjectWithRequest(EObject objectToDelete) {
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(objectToDelete);
		DestroyElementRequest request = new DestroyElementRequest(objectToDelete, true);
		if (provider != null) {
			ICommand deleteCommand = provider.getEditCommand(request);

			if (deleteCommand != null && deleteCommand.canExecute()) {
				try {
					deleteCommand.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {

					e.printStackTrace();
				}
			}

		}
	}
}
