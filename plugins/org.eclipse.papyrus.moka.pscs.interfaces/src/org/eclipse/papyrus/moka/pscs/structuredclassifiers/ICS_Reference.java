/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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

package org.eclipse.papyrus.moka.pscs.structuredclassifiers;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IExecution;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IReference;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;

public interface ICS_Reference extends IReference {

	public IExecution dispatchIn(Operation operation, ICS_InteractionPoint interactionPoint);

	public IExecution dispatchIn(Operation operation, Port onPort);

	public IExecution dispatchOut(Operation operation, Port onPort);

	public IExecution dispatchOut(Operation operation, ICS_InteractionPoint interactionPoint);

	public void sendIn(IEventOccurrence eventOccurrence, ICS_InteractionPoint interactionPoint);

	public void sendIn(IEventOccurrence eventOccurrence, Port onPort);

	public void sendOut(IEventOccurrence eventOccurrence, Port onPort);

	public void sendOut(IEventOccurrence eventOccurrence, ICS_InteractionPoint interactionPoint);

	public ICS_Object getCompositeReferent();

	public void setCompositeReferent(ICS_Object compositeReferent);
}
