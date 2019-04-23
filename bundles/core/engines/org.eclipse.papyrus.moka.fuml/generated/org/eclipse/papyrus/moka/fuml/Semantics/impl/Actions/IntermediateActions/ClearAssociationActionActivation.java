/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.uml2.uml.ClearAssociationAction;

public class ClearAssociationActionActivation extends ActionActivation {

	@Override
	public void doAction() {
		// Get the extent, at the current execution locus, of the given
		// association.
		// Read the object input pin. Destroy all links in which the object
		// participates.
		ClearAssociationAction action = (ClearAssociationAction) (this.node);
		List<IExtensionalValue> extent = this.getExecutionLocus().getExtent(action.getAssociation());
		IValue objectValue = this.takeTokens(action.getObject()).get(0);
		for (int i = 0; i < extent.size(); i++) {
			ILink link = (ILink) (extent.get(i));
			if (this.valueParticipatesInLink(objectValue, link)) {
				link.destroy();
			}
		}
	}
}
