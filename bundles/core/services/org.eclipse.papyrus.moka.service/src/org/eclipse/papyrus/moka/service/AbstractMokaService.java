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

package org.eclipse.papyrus.moka.service;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.emf.ecore.EObject;

public abstract class AbstractMokaService implements IMokaService {

	@Override
	public void init(ILaunch launcher, EObject modelElement) {
		// By default do nothing - convenience for services which do not need to know
		// the model that is currently related to this instance of the execution
	}

	public void dispose() {
		// By default do nothing - convenience for services which do not need to dispose
		// any resource.
	}

}
