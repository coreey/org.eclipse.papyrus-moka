/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.presentation;

import org.eclipse.debug.core.DebugException;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;

public class MokaVariable_from_Value extends MokaVariable_for_fUML {

	protected IValue fUMLValue;

	public MokaVariable_from_Value(IValue value) {
		super();
		this.fUMLValue = value;
	}

	// ////////////////////////////////
	// Presentation
	// ////////////////////////////////

	@Override
	public Image getImage() {
		// not used for variables
		return FUMLPresentationUtils.getImage(UMLPackage.eINSTANCE.getInstanceSpecification());
	}

	// ////////////////////////////////
	// Debug
	// ////////////////////////////////
	@Override
	public org.eclipse.debug.core.model.IValue getValue() throws DebugException {
		return new MokaValue_from_Value(fUMLValue);
	}

}
