/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
 *  David LOPEZ BETANCUR (CEA LIST)
 *  Sebastien REVOL (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.xygraph.properties.constraints;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;

public class IsXYGraphConstraint extends AbstractConstraint{

	@Override
	protected boolean equivalent(Constraint constraint) {
		return constraint == this || constraint instanceof IsXYGraphConstraint;
	}

	@Override
	protected boolean match(Object selection) {
		final boolean expectedValue = Boolean.parseBoolean(getValue("expectedValue")); //$NON-NLS-1$
		final EObject obj = EMFHelper.getEObject(selection);
		return (obj instanceof XYGraphDescriptor) == expectedValue;
	}
}
