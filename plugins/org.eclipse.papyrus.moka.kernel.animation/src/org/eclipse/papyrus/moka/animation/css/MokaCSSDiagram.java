/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
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
package org.eclipse.papyrus.moka.animation.css;

import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;

/**
 * Specific CSS Diagram to be able to change the DiagramCSSEngine
 */
public class MokaCSSDiagram extends CSSDiagramImpl{

	@Override
	protected ExtendedCSSEngine createEngine(ExtendedCSSEngine viewpointCSSEngine) {
		return new MokaDiagramCSSEngine(viewpointCSSEngine, this);
	}

}
