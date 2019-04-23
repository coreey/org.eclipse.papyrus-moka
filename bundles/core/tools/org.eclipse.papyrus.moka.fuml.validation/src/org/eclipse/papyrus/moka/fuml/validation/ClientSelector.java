/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.validation;

import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.uml2.uml.Element;

/**
 * THe client selector for constraints contributed by Moka
 *
 */
public class ClientSelector implements IClientSelector {

	@Override
	public boolean selects(Object object) {
		return (object instanceof Element);
	}

}
