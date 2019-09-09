/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.moka.pscs.commonbehavior;

import org.eclipse.papyrus.moka.fuml.commonbehavior.ICallEventExecution;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.ICS_InteractionPoint;

public interface ICS_CallEventExecution extends ICallEventExecution{

	public void setInteractionPoint(ICS_InteractionPoint interactionPoint);
	
	public ICS_InteractionPoint getInteractionPoint();
	
}
