/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
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
