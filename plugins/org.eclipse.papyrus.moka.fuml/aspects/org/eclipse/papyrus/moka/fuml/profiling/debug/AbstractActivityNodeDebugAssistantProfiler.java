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
 *  CEA LIST Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.profiling.debug;

import org.eclipse.papyrus.moka.fuml.activities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.uml2.uml.Element;

public abstract class AbstractActivityNodeDebugAssistantProfiler extends AbstractDebugAssistantProfiler {

	@Override
	protected Element getVisitorNode(ISemanticVisitor visitor) {
		if(visitor instanceof IActivityNodeActivation) {
			return ((IActivityNodeActivation) visitor).getNode();
		}
		return null;
	}

}
