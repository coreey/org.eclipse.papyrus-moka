/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.simex.advices;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Edit helper advice for {@link SendSignalAction}, that pops up a dialog during creation
 */
public class AddStructuralFeatureActionEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		// get the activity containing the new element

		CompositeCommand command = new CompositeCommand("Configure created element");
		IElementEditService service = ElementEditServiceUtils.getCommandProvider(request.getElementToConfigure());

		SetRequest setSignalRequest = new SetRequest(request.getElementToConfigure(), UMLPackage.eINSTANCE.getAddStructuralFeatureValueAction_IsReplaceAll(), true);
		command.add(service.getEditCommand(setSignalRequest));

		return command;

	}
}
