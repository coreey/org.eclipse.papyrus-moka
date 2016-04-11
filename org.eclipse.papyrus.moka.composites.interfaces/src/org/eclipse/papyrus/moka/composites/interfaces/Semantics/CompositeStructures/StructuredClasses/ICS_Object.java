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

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ISignalInstance;
import org.eclipse.uml2.uml.ConnectorKind;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Signal;

public interface ICS_Object extends IObject_ {

	public IExecution dispatchIn(Operation operation, ICS_InteractionPoint interactionPoint);

	public IExecution dispatchIn(Operation operation, Port onPort);

	public IExecution dispatchOut(Operation operation, ICS_InteractionPoint interactionPoint);

	public IExecution dispatchOut(Operation operation, Port onPort);

	public void sendIn(ISignalInstance signalInstance, ICS_InteractionPoint interactionPoint);

	public void sendIn(ISignalInstance signalInstance, Port onPort);

	public void sendOut(ISignalInstance signalInstance, ICS_InteractionPoint interactionPoint);

	public void sendOut(ISignalInstance signalInstance, Port onPort);

	public List<IReference> selectTargetsForSending(ICS_Link link, ICS_InteractionPoint interactionPoint, ConnectorKind connectorKind, Signal signal, Boolean toInternal);

	public List<IReference> selectTargetsForDispatching(ICS_Link link, ICS_InteractionPoint interactionPoint, ConnectorKind connectorKind, Operation operation, Boolean toInternal);

	public Boolean contains(IObject_ object);

	public Boolean directlyContains(IObject_ object);

	public List<ICS_Object> getDirectContainers();

	public Boolean isOperationProvided(IReference reference, Operation operation);

	public Boolean isOperationRequired(IReference reference, Operation operation);

	public CS_LinkKind getLinkKind(ICS_Link link, ICS_InteractionPoint interactionPoint);

	public List<ICS_Link> getLinks(ICS_InteractionPoint interactionPoint);

	public Boolean hasValueForAFeature(IValue value);

}
