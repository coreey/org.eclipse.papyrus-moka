/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0.html/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.composites.profiling.Semantics.CompositeStructures.StructuredClasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_RequestPropagationStrategy;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_InteractionPoint;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Link;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Object;
import org.eclipse.papyrus.moka.composites.interfaces.extensions.Semantics.CompositeStructures.StructuredClasses.ICS_ConnectorLink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.SendSignalActionActivation;
import org.eclipse.papyrus.moka.fuml.profiling.Semantics.Loci.SemanticVisitorProfiler;
import org.eclipse.uml2.uml.ConnectorKind;
import org.eclipse.uml2.uml.Operation;

public aspect CS_ObjectProfiler extends SemanticVisitorProfiler {

	public CS_ObjectProfiler() {
		super();
	}

	// Listen to any call on a CS_Object that results in sendIn(...)
	pointcut sendIn(ICS_Object object, IEventOccurrence eventOccurrence, ICS_InteractionPoint interactionPoint) :
		target(object) &&
		args(eventOccurrence, interactionPoint) &&
		call(* ICS_Object.sendIn(IEventOccurrence, ICS_InteractionPoint));

	// Listen to any call on a CS_Object that results in sendOut(...)
	pointcut sendOut(ICS_Object object, IEventOccurrence eventOccurrence, ICS_InteractionPoint interactionPoint) :
		target(object) &&
		args(eventOccurrence, interactionPoint) &&
		call(* ICS_Object.sendOut(IEventOccurrence, ICS_InteractionPoint));

	before(ICS_Object object, IEventOccurrence eventOccurrence, ICS_InteractionPoint interactionPoint) : 
		sendIn(object, eventOccurrence, interactionPoint){
		// Each time a sendIn(...) is performed this implies the event occurrence is
		// propagated through the interaction point to an internal target. This target
		// is always an interaction point. At this point, the interaction point from which the
		// event occurrence flows and the outgoing links are visited. This implies that
		// any service listening to the node visited events will get notified about the
		// the visit of the interaction points as well as its outgoing links.
		this.visit(new CS_InteractionPointWrapper(interactionPoint));
		Iterator<ICS_ConnectorLink> linkIterator = this
				.getTraversedLinkWhenSentIn(object, eventOccurrence, interactionPoint).iterator();
		while (linkIterator.hasNext()) {
			this.visit(new CS_ConnectorLinkWrapper(linkIterator.next()));
		}
	}

	before(ICS_Object object, IEventOccurrence eventOccurrence, ICS_InteractionPoint interactionPoint) : 
		sendOut(object, eventOccurrence, interactionPoint){
		// Each time a sendOut(...) is performed this implies the event occurrences is
		// propagated through the interaction point to the environment of the object.
		// The target of the propagation always is an interaction point. At this point, the
		// interaction point from which the event occurs flows and the outgoing links
		// are visited. This implies that any service listening to the node visited events
		// will get notified about the the visit of the interaction points as well as its
		// outgoing links.
		this.visit(new CS_InteractionPointWrapper(interactionPoint));
		Iterator<ICS_ConnectorLink> linkIterator = this
				.getTraversedLinkWhenSentOut(object, eventOccurrence, interactionPoint).iterator();
		while (linkIterator.hasNext()) {
			this.visit(new CS_ConnectorLinkWrapper(linkIterator.next()));
		}
	}

	public List<ICS_ConnectorLink> getTraversedLinkWhenSentIn(ICS_Object object, IEventOccurrence eventOccurrence,
			ICS_InteractionPoint interactionPoint) {
		// Find out all links (i.e., runtime manifestation of connectors) that can be
		// traversed
		// to propagate the event occurrence when sent to the internals the object.
		Iterator<ICS_Link> linkIterator = object.getLinks(interactionPoint).iterator();
		List<ICS_ConnectorLink> traversedLink = new ArrayList<ICS_ConnectorLink>();
		while (linkIterator.hasNext()) {
			ICS_Link link = linkIterator.next();
			List<IReference> targets = object.selectTargetsForSending(link, interactionPoint,
					ConnectorKind.DELEGATION_LITERAL, true);
			if (!targets.isEmpty()) {
				traversedLink.add((ICS_ConnectorLink) link);
			}
		}
		return traversedLink;
	}

	public List<ICS_ConnectorLink> getTraversedLinkWhenSentOut(ICS_Object object, IEventOccurrence eventOccurrence,
			ICS_InteractionPoint interactionPoint) {
		// Find out all links (i.e., runtime manifestation of connectors) that can be
		// traversed to propagate the event occurrence when sent to the object environment.
		// Note: in order to accurately notify the services about which links have been
		// traversed, it is required to rely on a RequestPropagationStrategy that when executed two
		// times on the same target list produces the exact same results.
		List<IReference> allPotentialTargets = new ArrayList<IReference>();
		List<ICS_ConnectorLink> referencedLink = new ArrayList<ICS_ConnectorLink>();
		List<ICS_ConnectorLink> traversedLink = new ArrayList<ICS_ConnectorLink>();
		Iterator<ICS_Link> linkIterator = object.getLinks(interactionPoint).iterator();
		while (linkIterator.hasNext()) {
			boolean referenceLink = false;
			ICS_Link link = linkIterator.next();
			Iterator<IReference> referenceIterator = object
					.selectTargetsForSending(link, interactionPoint, ConnectorKind.ASSEMBLY_LITERAL, false).iterator();
			while (referenceIterator.hasNext()) {
				if (!referenceLink) {
					referenceLink = true;
				}
				allPotentialTargets.add(referenceIterator.next());
			}
			referenceIterator = object
					.selectTargetsForSending(link, interactionPoint, ConnectorKind.DELEGATION_LITERAL, false)
					.iterator();
			while (referenceIterator.hasNext()) {
				if (!referenceLink) {
					referenceLink = true;
				}
				allPotentialTargets.add(referenceIterator.next());
			}
			if (referenceLink) {
				referencedLink.add((ICS_ConnectorLink) link);
			}
		}
		CS_RequestPropagationStrategy strategy = (CS_RequestPropagationStrategy) object.getLocus().getFactory()
				.getStrategy("requestPropagation");
		List<IReference> selectedTargets = strategy.select(allPotentialTargets, new SendSignalActionActivation());
		for (IReference target : selectedTargets) {
			for (ICS_ConnectorLink connectorLink : referencedLink) {
				if (connectorLink.hasValueForAFeature(target)) {
					traversedLink.add((ICS_ConnectorLink) connectorLink);
				}
			}
		}
		return traversedLink;
	}
	
	// Listen to any call on CS_Object that results in dispatchIn(...)
	pointcut dispatchIn(ICS_Object object, Operation operation, ICS_InteractionPoint interactionPoint):
		target(object) &&
		args(operation, interactionPoint) &&
		call(* ICS_Object.dispatchIn(Operation, ICS_InteractionPoint));

	// Listen to any call on CS_Object that results in dispatchOut(...)
	pointcut dispatchOut(ICS_Object object, Operation operation, ICS_InteractionPoint interactionPoint):
		target(object) &&
		args(operation, interactionPoint) &&
		call(* ICS_Object.dispatchOut(Operation, ICS_InteractionPoint));
	
	
	before(ICS_Object object, Operation operation, ICS_InteractionPoint interactionPoint) : 
	    // Each time a dispatchIn(...) is performed this implies the operation call is
	    // propagated through the interaction point to an internal target. This target
	    // is not always an interaction point. At this point, the interaction point from which the
	    // operation call flows and the outgoing links are visited.
		dispatchIn(object, operation, interactionPoint){
		this.visit(new CS_InteractionPointWrapper(interactionPoint));
		Iterator<ICS_ConnectorLink> linkIterator = this
				.getTraversedLinkWhenDispatchIn(object, interactionPoint, operation).iterator();
		while (linkIterator.hasNext()) {
			this.visit(new CS_ConnectorLinkWrapper(linkIterator.next()));
		}
	}
	
	before(ICS_Object object, Operation operation, ICS_InteractionPoint interactionPoint) : 
		// Each time a dispatchIn(...) is performed this implies the operation call is
	    // propagated through the interaction point to an environment target. This target
	    // is not always an interaction point. At this point, the interaction point from which the
	    // operation call flows and the outgoing links are visited.
		dispatchOut(object, operation, interactionPoint){
		this.visit(new CS_InteractionPointWrapper(interactionPoint));
		Iterator<ICS_ConnectorLink> linkIterator = this
				.getTraversedLinkWhenDispatchOut(object, interactionPoint, operation).iterator();
		while (linkIterator.hasNext()) {
			this.visit(new CS_ConnectorLinkWrapper(linkIterator.next()));
		}
	}
	
	public List<ICS_ConnectorLink> getTraversedLinkWhenDispatchIn(ICS_Object object,
			ICS_InteractionPoint interactionPoint, Operation operation) {
		// Find out all links (i.e., runtime manifestation of connectors) that can be
		// traversed to propagate the operation call when sent to the internals the object.
		Iterator<ICS_Link> linkIterator = object.getLinks(interactionPoint).iterator();
		List<ICS_ConnectorLink> traversedLink = new ArrayList<ICS_ConnectorLink>();
		while (linkIterator.hasNext()) {
			ICS_Link link = linkIterator.next();
			List<IReference> targets = object.selectTargetsForDispatching(link, interactionPoint,
					ConnectorKind.DELEGATION_LITERAL, operation, true);
			if (!targets.isEmpty()) {
				traversedLink.add((ICS_ConnectorLink) link);
			}
		}
		return traversedLink;
	}

	public List<ICS_ConnectorLink> getTraversedLinkWhenDispatchOut(ICS_Object object,
			ICS_InteractionPoint interactionPoint, Operation operation) {
		// Find out all links (i.e., runtime manifestation of connectors) that can be
		// traversed to propagate the operation call when sent to the object environment.
		// Note: in order to accurately notify the services about which links have been
		// traversed, it is required to rely on a RequestPropagationStrategy that when
		// executed two times on the same target list produces the exact same results.
		List<IReference> allPotentialTargets = new ArrayList<IReference>();
		List<ICS_ConnectorLink> referencedLink = new ArrayList<ICS_ConnectorLink>();
		List<ICS_ConnectorLink> traversedLink = new ArrayList<ICS_ConnectorLink>();
		Iterator<ICS_Link> linkIterator = object.getLinks(interactionPoint).iterator();
		while (linkIterator.hasNext()) {
			boolean referenceLink = false;
			ICS_Link link = linkIterator.next();
			Iterator<IReference> referenceIterator = object
					.selectTargetsForDispatching(link, interactionPoint, ConnectorKind.ASSEMBLY_LITERAL, operation, false).iterator();
			while (referenceIterator.hasNext()) {
				if (!referenceLink) {
					referenceLink = true;
				}
				allPotentialTargets.add(referenceIterator.next());
			}
			referenceIterator = object
					.selectTargetsForDispatching(link, interactionPoint, ConnectorKind.DELEGATION_LITERAL, operation, false)
					.iterator();
			while (referenceIterator.hasNext()) {
				if (!referenceLink) {
					referenceLink = true;
				}
				allPotentialTargets.add(referenceIterator.next());
			}
			if (referenceLink) {
				referencedLink.add((ICS_ConnectorLink) link);
			}
		}
		CS_RequestPropagationStrategy strategy = (CS_RequestPropagationStrategy) object.getLocus().getFactory()
				.getStrategy("requestPropagation");
		List<IReference> selectedTargets = strategy.select(allPotentialTargets, new SendSignalActionActivation());
		for (IReference target : selectedTargets) {
			for (ICS_ConnectorLink connectorLink : referencedLink) {
				if (connectorLink.hasValueForAFeature(target)) {
					traversedLink.add((ICS_ConnectorLink) connectorLink);
				}
			}
		}
		return traversedLink;
	}
}
