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

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.gmfdiag.css.factory.CSSNotationFactory;

public class MokaCSSNotationFactory extends CSSNotationFactory {

	@Override
	public Diagram createDiagram() {
		return new MokaCSSDiagram();
	}
	
}
