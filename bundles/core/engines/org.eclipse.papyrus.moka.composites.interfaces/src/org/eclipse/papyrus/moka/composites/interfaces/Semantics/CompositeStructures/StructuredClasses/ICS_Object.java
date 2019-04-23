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

package org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.ConnectorKind;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;

public interface ICS_Object extends IObject_ {

	public IExecution dispatchIn(Operation operation, ICS_InteractionPoint interactionPoint);

	public IExecution dispatchIn(Operation operation, Port onPort);

	public IExecution dispatchOut(Operation operation, ICS_InteractionPoint interactionPoint);

	public IExecution dispatchOut(Operation operation, Port onPort);

	public void sendIn(IEventOccurrence eventOccurrence, ICS_InteractionPoint interactionPoint);

	public void sendIn(IEventOccurrence eventOccurrence, Port onPort);

	public void sendOut(IEventOccurrence eventOccurrence, ICS_InteractionPoint interactionPoint);

	public void sendOut(IEventOccurrence eventOccurrence, Port onPort);

	public List<IReference> selectTargetsForSending(ICS_Link link, ICS_InteractionPoint interactionPoint, ConnectorKind connectorKind, Boolean toInternal);

	public List<IReference> selectTargetsForDispatching(ICS_Link link, ICS_InteractionPoint interactionPoint, ConnectorKind connectorKind, Operation operation, Boolean toInternal);

	public Boolean contains(IObject_ object);

	public Boolean directlyContains(IObject_ object);

	public List<ICS_Object> getDirectContainers();

	public Boolean isOperationProvided(IReference reference, Operation operation);

	public Boolean isOperationRequired(IReference reference, Operation operation);

	public CS_LinkKind getLinkKind(ICS_Link link, ICS_InteractionPoint interactionPoint);

	public List<ICS_Link> getLinks(ICS_InteractionPoint interactionPoint);

	public Boolean hasValueForAFeature(IValue value);
	
	public Boolean realizesInterface(Class type, Interface interface_);
	
	public Boolean isDescendant(Interface contract, Interface interface_);

}
