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

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Reference;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.CreateObjectAction;

public class CreateObjectActionActivation extends ActionActivation {

	@Override
	public void doAction() {
		// Create an object with the given classifier (which must be a class) as
		// its type, at the same locus as the action activation.
		// Place a reference to the object on the result pin of the action.
		CreateObjectAction action = (CreateObjectAction) (this.node);
		Reference reference = new Reference();
		ILocus locus = this.getExecutionLocus();
		reference.referent = ((CreateObjectActionStrategy) locus.getFactory().getStrategy("CreateObjectActionStrategy")).instantiate((Class) (action.getClassifier()), locus);
		this.putToken(action.getResult(), reference);
	}
}
