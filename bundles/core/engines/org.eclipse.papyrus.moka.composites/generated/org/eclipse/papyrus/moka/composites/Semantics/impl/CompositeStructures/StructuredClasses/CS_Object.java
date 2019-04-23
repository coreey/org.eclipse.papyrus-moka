/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
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
package org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses;

// Imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CommonBehaviors.Communications.CS_DispatchOperationOfInterfaceStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CommonBehaviors.Communications.CS_StructuralFeatureOfInterfaceAccessStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_RequestPropagationStrategy;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CommonBehaviors.BasicBehaviors.ICS_CallEventExecution;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.CS_LinkKind;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_InteractionPoint;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Link;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Object;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.CallOperationActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.SendSignalActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.ChoiceStrategy;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ConnectorKind;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.StructuralFeature;


public class CS_Object extends Object_ implements ICS_Object {

	public IExecution dispatchIn(Operation operation, ICS_InteractionPoint interactionPoint) {
		// If the interaction point refers to a behavior port, the operation call is dispatched
		// to the object owning the behavior port. This may result in the method being handled
		// by the method defined for the operation at the object or through a call event handled 
		// by the classifier behavior of the owning object. The latter case only occurs if the
		// dispatched operation has no implementation
		// If it does not refer to a behavior port, select appropriate delegation links
		// from interactionPoint, and propagates the operation call through
		// these links
		IExecution execution = null;
		if (interactionPoint.getDefiningPort().isBehavior()) {
			execution = this.dispatch(operation);
			if(execution instanceof ICS_CallEventExecution){
				((ICS_CallEventExecution)execution).setInteractionPoint(interactionPoint);
			}
		} else {
			boolean operationIsProvided = true;
			List<IReference> potentialTargets = new ArrayList<IReference>();
			List<ICS_Link> cddLinks = this.getLinks(interactionPoint);
			Integer linkIndex = 1;
			while (linkIndex <= cddLinks.size()) {
				List<IReference> validTargets = this.selectTargetsForDispatching(cddLinks.get(linkIndex - 1), interactionPoint, ConnectorKind.DELEGATION_LITERAL, operation, operationIsProvided);
				Integer targetIndex = 1;
				while (targetIndex <= validTargets.size()) {
					potentialTargets.add(validTargets.get(targetIndex - 1));
					targetIndex = targetIndex + 1;
				}
				linkIndex = linkIndex + 1;
			}
			// If potentialTargets is empty, no delegation target have been found,
			// and the operation call will be lost
			if (!(potentialTargets.size() == 0)) {
				CS_RequestPropagationStrategy strategy = (CS_RequestPropagationStrategy) this.locus.getFactory().getStrategy("requestPropagation");
				// Choose one target non-deterministically
				List<IReference> targets = strategy.select(potentialTargets, new CallOperationActionActivation());
				IReference target = targets.get(0);
				execution = target.dispatch(operation);
			}
		}
		return execution;
	}


	public void sendIn(IEventOccurrence eventOccurrence, ICS_InteractionPoint interactionPoint) {
		// 1] If the interaction is a behavior port then sends the event occurrence to the target
		// object using operation send.
		// 2] If this is not a behavior port, select appropriate delegation targets from interactionPoint,
		// and propagates the event occurrence to these targets
		if (interactionPoint.getDefiningPort().isBehavior()) {
			this.send(eventOccurrence);
		} else {
			boolean toInternal = true;
			List<IReference> potentialTargets = new ArrayList<IReference>();
			List<ICS_Link> cddLinks = this.getLinks(interactionPoint);
			Integer linkIndex = 1;
			while (linkIndex <= cddLinks.size()) {
				List<IReference> validTargets = this.selectTargetsForSending(cddLinks.get(linkIndex - 1), interactionPoint, ConnectorKind.DELEGATION_LITERAL, toInternal);
				Integer targetIndex = 1;
				while (targetIndex <= validTargets.size()) {
					potentialTargets.add(validTargets.get(targetIndex - 1));
					targetIndex = targetIndex + 1;
				}
				linkIndex = linkIndex + 1;
			}
			// If potential targets is empty, no delegation target has been found,
			// and the signal is lost
			// Otherwise, do the following concurrently
			for (int i = 0; i < potentialTargets.size(); i++) {
				IReference target = potentialTargets.get(i);
				target.send(eventOccurrence);
			}
		}
	}


	public List<IReference> selectTargetsForSending(ICS_Link link, ICS_InteractionPoint interactionPoint, ConnectorKind connectorKind, Boolean toInternal) {
		// From the given link, signal and interaction point, retrieves potential targets (i.e. end values of link)
		// through which request can be propagated
		// These targets are attached to interaction point through the given link, and respect the following rules:
		// - if toInternal is true, connectorKind must be Delegation, the given link has to target the internals of this CS_Object
		// - if toInternal is false, the given link has to target the environment of this CS_Object.
		List<IReference> potentialTargets = new ArrayList<IReference>();
		if (toInternal && connectorKind == ConnectorKind.DELEGATION_LITERAL) {
			if (this.getLinkKind(link, interactionPoint) == CS_LinkKind.ToInternal) {
				Integer i = 1;
				while (i <= link.getFeatureValues().size()) {
					List<IValue> values = link.getFeatureValues().get(i - 1).getValues();
					if (!values.isEmpty()) {
						Integer j = 1;
						while (j <= values.size()) {
							Reference cddTarget = (Reference) values.get(j - 1);
							if (!cddTarget.equals(interactionPoint)) {
								potentialTargets.add(cddTarget);
							}
							j = j + 1;
						}
					}
					i = i + 1;
				}
			}
		} else { // to Environment
			if (this.getLinkKind(link, interactionPoint) == CS_LinkKind.ToEnvironment) {
				Integer i = 1;
				while (i <= link.getFeatureValues().size()) {
					List<IValue> values = link.getFeatureValues().get(i - 1).getValues();
					if (!values.isEmpty() && values.get(0) instanceof Reference) {
						Reference cddTarget = (Reference) values.get(0);
						if (connectorKind == ConnectorKind.ASSEMBLY_LITERAL) {
							if (!(cddTarget instanceof CS_InteractionPoint)) { // This is an assembly link
								potentialTargets.add(cddTarget);
							} else {
								// This is an assembly if the interaction point is not a feature value
								// for a container of this CS_Object
								List<ICS_Object> directContainers = this.getDirectContainers();
								boolean isAssembly = true;
								Integer j = 1;
								if (!this.hasValueForAFeature(cddTarget)) {
									while (isAssembly && j <= directContainers.size()) {
										ICS_Object container = directContainers.get(j - 1);
										if (container.hasValueForAFeature(cddTarget)) {
											isAssembly = false;
										}
										j++;
									}
								} else {
									isAssembly = false;
								}
								if (isAssembly) {
									potentialTargets.add(cddTarget);
								}
							}
						} else { // delegation
									// This is a delegation if the target is an interaction point
									// and if this interaction is a feature value for a container of this CS_Object
							if (cddTarget instanceof CS_InteractionPoint) {
								List<ICS_Object> directContainers = this.getDirectContainers();
								boolean isDelegation = false;
								Integer j = 1;
								while (!isDelegation && j <= directContainers.size()) {
									ICS_Object container = directContainers.get(j - 1);
									if (container.hasValueForAFeature(cddTarget)) {
										isDelegation = true;
									}
									j++;
								}
								if (isDelegation) {
									potentialTargets.add(cddTarget);
								}
							}
						}
					}
					i = i + 1;
				}
			}
		}
		return potentialTargets;
	}

	public List<IReference> selectTargetsForDispatching(ICS_Link link, ICS_InteractionPoint interactionPoint, ConnectorKind connectorKind, Operation operation, Boolean toInternal) {
		// From the given link, operation and interaction point, retrieves potential targets (i.e. end values of link)
		// through which request can be propagated
		// These targets are attached to interaction point through the given link, and respect the following rules:
		// - if isProvided is true, connectorKind must be Delegation, the given link has to target the internals of this CS_Object,
		// and a valid target must provide the Operation
		// - if isProvided is false, the given link has to target the environment of this CS_Object.
		// - if connectorKind is assembly, a valid target has to provide the operation
		// - if connectorKind is delegation, a valid target has to require the operation
		List<IReference> potentialTargets = new ArrayList<IReference>();
		if (toInternal && connectorKind == ConnectorKind.DELEGATION_LITERAL) {
			if (this.getLinkKind(link, interactionPoint) == CS_LinkKind.ToInternal) {
				Integer i = 1;
				while (i <= link.getFeatureValues().size()) {
					List<IValue> values = link.getFeatureValues().get(i - 1).getValues();
					if (!values.isEmpty() && values.get(0) instanceof Reference) {
						Reference cddTarget = (Reference) values.get(0);
						if (cddTarget != interactionPoint && this.isOperationProvided(cddTarget, operation)) {
							potentialTargets.add(cddTarget);
						}
					}
					i = i + 1;
				}
			}
		} else { // to environment
			if (this.getLinkKind(link, interactionPoint) == CS_LinkKind.ToEnvironment) {
				Integer i = 1;
				while (i <= link.getFeatureValues().size()) {
					List<IValue> values = link.getFeatureValues().get(i - 1).getValues();
					if (!values.isEmpty() && values.get(0) instanceof Reference) {
						Reference cddTarget = (Reference) values.get(0);
						if (connectorKind == ConnectorKind.ASSEMBLY_LITERAL) {
							if (!(cddTarget instanceof CS_InteractionPoint)) { // This is an assembly link
								if (this.isOperationProvided(cddTarget, operation)) {
									potentialTargets.add(cddTarget);
								}
							} else {
								// This is an assembly if the interaction point is not a feature value
								// for a container of this CS_Object
								List<ICS_Object> directContainers = this.getDirectContainers();
								boolean isAssembly = true;
								Integer j = 1;
								if (!this.hasValueForAFeature(cddTarget)) {
									while (isAssembly && j <= directContainers.size()) {
										ICS_Object container = directContainers.get(j - 1);
										if (container.hasValueForAFeature(cddTarget)) {
											isAssembly = false;
										}
										j++;
									}
								} else {
									isAssembly = false;
								}
								if (isAssembly) {
									if (this.isOperationProvided(cddTarget, operation)) {
										potentialTargets.add(cddTarget);
									}
								}
							}
						} else { // delegation
									// This is a delegation if the target is an interaction point
									// and if this interaction is a feature value for a container of this CS_Object
							if (cddTarget instanceof CS_InteractionPoint) {
								List<ICS_Object> directContainers = this.getDirectContainers();
								boolean isDelegation = false;
								Integer j = 1;
								while (!isDelegation && j <= directContainers.size()) {
									ICS_Object container = directContainers.get(j - 1);
									if (container.hasValueForAFeature(cddTarget)) {
										isDelegation = true;
									}
									j++;
								}
								if (isDelegation) {
									if (this.isOperationRequired(cddTarget, operation)) {
										potentialTargets.add(cddTarget);
									}
								}
							}
						}
					}
					i = i + 1;
				}
			}
		}
		return potentialTargets;
	}

	public void sendOut(IEventOccurrence eventOccurrence, ICS_InteractionPoint interactionPoint) {
		// Select appropriate delegation links from interactionPoint,
		// and propagates the event occurrence through these links
		// Appropriate links are links which target elements
		// in the environment of this CS_Object.
		// These can be delegation links (i.e, the targeted elements must
		// require a reception for the signal) or assembly links (i.e., the target elements
		// must provide a reception for the signal)
		boolean notToInternal = false; // i.e. to environment
		List<IReference> allPotentialTargets = new ArrayList<IReference>();
		List<IReference> targetsForSendingIn = new ArrayList<IReference>();
		List<IReference> targetsForSendingOut = new ArrayList<IReference>();

		List<ICS_Link> cddLinks = this.getLinks(interactionPoint);
		Integer linkIndex = 1;
		while (linkIndex <= cddLinks.size()) {
			List<IReference> validAssemblyTargets = this.selectTargetsForSending(cddLinks.get(linkIndex - 1), interactionPoint, ConnectorKind.ASSEMBLY_LITERAL, notToInternal);
			Integer targetIndex = 1;
			while (targetIndex <= validAssemblyTargets.size()) {
				allPotentialTargets.add(validAssemblyTargets.get(targetIndex - 1));
				targetsForSendingIn.add(validAssemblyTargets.get(targetIndex - 1));
				targetIndex = targetIndex + 1;
			}
			List<IReference> validDelegationTargets = this.selectTargetsForSending(cddLinks.get(linkIndex - 1), interactionPoint, ConnectorKind.DELEGATION_LITERAL, notToInternal);
			targetIndex = 1;
			while (targetIndex <= validDelegationTargets.size()) {
				allPotentialTargets.add(validDelegationTargets.get(targetIndex - 1));
				targetsForSendingOut.add(validDelegationTargets.get(targetIndex - 1));
				targetIndex = targetIndex + 1;
			}
			linkIndex = linkIndex + 1;
		}

		CS_RequestPropagationStrategy strategy = (CS_RequestPropagationStrategy) this.locus.getFactory().getStrategy("requestPropagation");
		List<IReference> selectedTargets = strategy.select(allPotentialTargets, new SendSignalActionActivation());

		for (int j = 0; j < selectedTargets.size(); j++) {
			IReference target = selectedTargets.get(j);
			for (int k = 0; k < targetsForSendingIn.size(); k++) {
				IReference cddTarget = targetsForSendingIn.get(k);
				if (cddTarget == target) {
					target.send(eventOccurrence);
				}
			}
			for (int k = 0; k < targetsForSendingOut.size(); k++) {
				// The target must be an interaction point
				// i.e. a delegation connector for a required reception can only target a port
				ICS_InteractionPoint cddTarget = (ICS_InteractionPoint) targetsForSendingOut.get(k);
				if (cddTarget == target) {
					ICS_Reference owner = cddTarget.getOwner();
					owner.sendOut(eventOccurrence, cddTarget);
				}
			}
		}
	}

	public IExecution dispatchOut(Operation operation, ICS_InteractionPoint interactionPoint) {
		// Select appropriate delegation links from interactionPoint,
		// and propagates the operation call through these links
		// Appropriate links are links which target elements
		// in the environment of this CS_Object.
		// These can be delegation links (i.e, the targeted elements must
		// require the operation) or assembly links (i.e., the target elements
		// must provide the operation)


		IExecution execution = null;

		boolean notToInternal = false; // i.e. to environment
		List<IReference> allPotentialTargets = new ArrayList<IReference>();
		List<IReference> targetsForDispatchingIn = new ArrayList<IReference>();
		List<IReference> targetsForDispatchingOut = new ArrayList<IReference>();

		List<ICS_Link> cddLinks = this.getLinks(interactionPoint);
		Integer linkIndex = 1;
		while (linkIndex <= cddLinks.size()) {
			List<IReference> validAssemblyTargets = this.selectTargetsForDispatching(cddLinks.get(linkIndex - 1), interactionPoint, ConnectorKind.ASSEMBLY_LITERAL, operation, notToInternal);
			Integer targetIndex = 1;
			while (targetIndex <= validAssemblyTargets.size()) {
				allPotentialTargets.add(validAssemblyTargets.get(targetIndex - 1));
				targetsForDispatchingIn.add(validAssemblyTargets.get(targetIndex - 1));
				targetIndex = targetIndex + 1;
			}
			List<IReference> validDelegationTargets = this.selectTargetsForDispatching(cddLinks.get(linkIndex - 1), interactionPoint, ConnectorKind.DELEGATION_LITERAL, operation, notToInternal);
			targetIndex = 1;
			while (targetIndex <= validDelegationTargets.size()) {
				allPotentialTargets.add(validDelegationTargets.get(targetIndex - 1));
				targetsForDispatchingOut.add(validDelegationTargets.get(targetIndex - 1));
				targetIndex = targetIndex + 1;
			}
			linkIndex = linkIndex + 1;
		}

		CS_RequestPropagationStrategy strategy = (CS_RequestPropagationStrategy) this.locus.getFactory().getStrategy("requestPropagation");
		List<IReference> selectedTargets = strategy.select(allPotentialTargets, new SendSignalActionActivation());

		for (int j = 0; j < selectedTargets.size(); j++) {
			IReference target = selectedTargets.get(j);
			for (int k = 0; k < targetsForDispatchingIn.size() && execution == null; k++) {
				IReference cddTarget = targetsForDispatchingIn.get(k);
				if (cddTarget == target) {
					execution = target.dispatch(operation);
				}
			}
			for (int k = 0; k < targetsForDispatchingOut.size() && execution == null; k++) {
				// The target must be an interaction point
				// i.e. a delegation connector for a required operation can only target a port
				ICS_InteractionPoint cddTarget = (CS_InteractionPoint) targetsForDispatchingOut.get(k);
				if (cddTarget == target) {
					ICS_Reference owner = cddTarget.getOwner();
					execution = owner.dispatchOut(operation, cddTarget);
				}
			}
		}
		return execution;
	}

	@Override
	public IFeatureValue getFeatureValue(StructuralFeature feature) {
		// In the case where the feature belongs to an Interface,
		// fUML semantics is extended in the sense that reading is
		// delegated to a CS_StructuralFeatureOfInterfaceAccessStrategy
		if (feature.getNamespace() instanceof Interface) {
			CS_StructuralFeatureOfInterfaceAccessStrategy readStrategy = (CS_StructuralFeatureOfInterfaceAccessStrategy) this.locus.getFactory().getStrategy("structuralFeature");
			return readStrategy.read(this, feature);
		} else {
			return super.getFeatureValue(feature);
		}
	}

	@Override
	public void setFeatureValue(StructuralFeature feature, List<IValue> values, Integer position) {
		// In the case where the feature belongs to an Interface,
		// fUML semantics is extended in the sense that writing is
		// delegated to a CS_StructuralFeatureOfInterfaceAccessStrategy
		if (feature.getNamespace() instanceof Interface) {
			CS_StructuralFeatureOfInterfaceAccessStrategy writeStrategy = (CS_StructuralFeatureOfInterfaceAccessStrategy) this.locus.getFactory().getStrategy("structuralFeature");
			writeStrategy.write(this, feature, values, position);
		} else {
			super.setFeatureValue(feature, values, position);
		}
	}

	public Boolean contains(IObject_ object) {
		// Determines if the object given as a parameter is directly
		// or indirectly contained by this CS_Object
		boolean objectIsContained = this.directlyContains(object);
		// if object is not directly contained, restart the research
		// recursively on the objects owned by this CS_Object
		for (int i = 0; i < this.featureValues.size() && !objectIsContained; i++) {
			IFeatureValue featureValue = this.featureValues.get(i);
			List<IValue> values = featureValue.getValues();
			for (int j = 0; j < values.size() && !objectIsContained; j++) {
				IValue value = values.get(j);
				if (value instanceof CS_Object) {
					objectIsContained = ((CS_Object) value).contains(object);
				} else if (value instanceof CS_Reference) {
					ICS_Object referent = ((ICS_Reference) value).getCompositeReferent();
					objectIsContained = referent.contains(object);
				}
			}
		}
		return objectIsContained;
	}

	public Boolean directlyContains(IObject_ object) {
		// Determines if the object given as a parameter is directly
		// contained by this CS_Object
		boolean objectIsContained = false;
		for (int i = 0; i < this.featureValues.size() && !objectIsContained; i++) {
			IFeatureValue featureValue = this.featureValues.get(i);
			List<IValue> values = featureValue.getValues();
			for (int j = 0; j < values.size() && !objectIsContained; j++) {
				IValue value = values.get(j);
				if (value == object) {
					objectIsContained = true;
				} else if (value instanceof ICS_Reference) {
					objectIsContained = (((ICS_Reference) value).getReferent() == object);
				}
			}
		}
		return objectIsContained;
	}

	public List<ICS_Object> getDirectContainers() {
		// Retrieves all the extensional values at this locus which are direct
		// containers for this CS_Object
		// An extensional value is a direct container for an object if:
		// - it is a CS_Object
		// - it directly contains this object (i.e. CS_Object.directlyContains(Object)==true)
		List<ICS_Object> containers = new ArrayList<ICS_Object>();
		for (int i = 0; i < this.locus.getExtensionalValues().size(); i++) {
			IExtensionalValue extensionalValue = this.locus.getExtensionalValues().get(i);
			if (extensionalValue != this && extensionalValue instanceof ICS_Object) {
				ICS_Object cddContainer = (ICS_Object) extensionalValue;
				if (cddContainer.directlyContains(this)) {
					containers.add(cddContainer);
				}
			}
		}
		return containers;
	}

	public Boolean isOperationProvided(IReference reference, Operation operation) {
		// Determines if the given reference provides the operation
		// If the reference is an interaction point, it provides the operation if this operation
		// is a member of one of its provided interfaces
		// If the reference is NOT an interactionPoint, it provides this operation if this operation is
		// an operation of one of its type, or one of its type provides a realization for this operation (in the case
		// where the namespace of this Operation is an interface)
		boolean isProvided = false;
		if (reference instanceof ICS_InteractionPoint) {
			if (operation.getOwner() instanceof Interface) {
				// We have to look in provided interfaces of the port if
				// they define directly or indirectly the Operation
				Integer interfaceIndex = 1;
				// Iterates on provided interfaces of the port
				List<Interface> providedInterfaces = ((ICS_InteractionPoint) reference).getDefiningPort().getProvideds();
				while (interfaceIndex <= providedInterfaces.size() && !isProvided) {
					Interface interface_ = providedInterfaces.get(interfaceIndex - 1);
					// Iterates on members of the current Interface
					Integer memberIndex = 1;
					while (memberIndex <= interface_.getMembers().size() && !isProvided) {
						NamedElement cddOperation = interface_.getMembers().get(memberIndex - 1);
						if (cddOperation instanceof Operation) {
							isProvided = operation == cddOperation;
						}
						memberIndex = memberIndex + 1;
					}
					interfaceIndex = interfaceIndex + 1;
				}
			}
		} else {
			// We have to look if one of the Classifiers typing this reference
			// directly or indirectly provides this operation
			List<Classifier> types = reference.getTypes();
			Integer typeIndex = 1;
			while (typeIndex <= types.size() && !isProvided) {
				if (types.get(typeIndex - 1) instanceof Class) {
					Integer memberIndex = 1;
					List<NamedElement> members = ((Class) types.get(typeIndex - 1)).getMembers();
					while (memberIndex <= members.size() && !isProvided) {
						NamedElement cddOperation = members.get(memberIndex - 1);
						if (cddOperation instanceof Operation) {
							CS_DispatchOperationOfInterfaceStrategy strategy = new CS_DispatchOperationOfInterfaceStrategy();
							isProvided = strategy.operationsMatch((Operation) cddOperation, operation);
						}
						memberIndex = memberIndex + 1;
					}
				}
				typeIndex = typeIndex + 1;
			}
		}
		return isProvided;
	}

	public Boolean isOperationRequired(IReference reference, Operation operation) {
		// Determines if the given reference requires the operation
		// If the reference is an interaction point, it requires the operation if this operation
		// is a member of one of its required interfaces
		// If the reference is not a interaction point, it cannot require an operation
		boolean matches = false;
		if (reference instanceof CS_InteractionPoint) {
			Integer interfaceIndex = 1;
			// Iterates on provided interfaces of the port
			List<Interface> requiredInterfaces = ((CS_InteractionPoint) reference).definingPort.getRequireds();
			while (interfaceIndex <= requiredInterfaces.size() && !matches) {
				Interface interface_ = requiredInterfaces.get(interfaceIndex - 1);
				// Iterates on members of the current Interface
				Integer memberIndex = 1;
				while (memberIndex <= interface_.getMembers().size() && !matches) {
					NamedElement cddOperation = interface_.getMembers().get(memberIndex - 1);
					if (cddOperation instanceof Operation) {
						matches = operation == cddOperation;
					}
					memberIndex = memberIndex + 1;
				}
				interfaceIndex = interfaceIndex + 1;
			}
		}
		return matches;
	}

	public CS_LinkKind getLinkKind(ICS_Link link, ICS_InteractionPoint interactionPoint) {
		// If the given interaction point belongs to this object, and if the given interaction point is used as an end of the link,
		// then the links targets the environment of the object (enumeration literal ToEnvironment) if all the feature values of the link
		// (but one for the interaction point) refer to values which are not themselves values for features of this object.
		// If all the feature values of the link refer to values which are themselves values for features of this object,
		// the link targets the internals of the object (enumeration literal ToInternal). Otherwise, the link has no particular meaning
		// in the context defined by the object and the interaction point (enumeration literal None).
		if (!link.hasValueForAFeature(interactionPoint)) {
			return CS_LinkKind.None;
		}
		CS_LinkKind kind = CS_LinkKind.ToInternal;
		List<IFeatureValue> featureValues = link.getFeatureValues();
		Integer i = 1;
		while (i <= featureValues.size() && kind != CS_LinkKind.None) {
			IFeatureValue value = featureValues.get(i - 1);
			if (value.getValues().isEmpty()) {
				kind = CS_LinkKind.None;
			} else {
				IValue v = value.getValues().get(0);
				boolean vIsAValueForAFeatureOfContext = false;
				if (v.equals(interactionPoint)) {
					vIsAValueForAFeatureOfContext = true;
				} else if (v instanceof ICS_InteractionPoint) {
					v = ((ICS_InteractionPoint) v).getOwner();
					vIsAValueForAFeatureOfContext = this.hasValueForAFeature(v);
				} else {
					vIsAValueForAFeatureOfContext = this.hasValueForAFeature(v);
				}
				if (!vIsAValueForAFeatureOfContext) {
					kind = CS_LinkKind.ToEnvironment;
				}
			}
			i = i + 1;
		}
		return kind;
	}

	public List<ICS_Link> getLinks(ICS_InteractionPoint interactionPoint) {
		// Get all links (available at the locus of this object) where the given interaction point is used as a feature value
		// (i.e. the interaction is an end such links)
		List<IExtensionalValue> extensionalValues = this.locus.getExtensionalValues();
		Integer i = 1;
		List<ICS_Link> connectorInstances = new ArrayList<ICS_Link>();
		while (i <= extensionalValues.size()) {
			IExtensionalValue value = extensionalValues.get(i - 1);
			if (value instanceof CS_Link) {
				CS_Link link = (CS_Link) value;
				if (this.getLinkKind(link, interactionPoint) != CS_LinkKind.None) {
					connectorInstances.add(link);
				}
			}
			i = i + 1;
		}
		return connectorInstances;
	}

	public Boolean hasValueForAFeature(IValue value) {
		// Returns true if the given value object is used as a value for a feature value of this object
		List<IFeatureValue> allFeatureValues = this.getFeatureValues();
		Integer i = 1;
		boolean isAValue = false;
		while (i <= allFeatureValues.size() && !isAValue) {
			IFeatureValue featureValue = allFeatureValues.get(i - 1);
			if (!featureValue.getValues().isEmpty()) {
				List<IValue> valuesForCurrentFeature = featureValue.getValues();
				Integer j = 1;
				while (j <= valuesForCurrentFeature.size() && !isAValue) {
					isAValue = featureValue.getValues().get(j - 1).equals(value);
					j = j + 1;
				}
			}
			i = i + 1;
		}
		return isAValue;
	}

	public void sendOut(IEventOccurrence eventOccurrence, Port onPort) {
		// Select a CS_InteractionPoint value playing onPort,
		// and send the event occurrence to this interaction point
		IFeatureValue featureValue = this.getFeatureValue(onPort);
		List<IValue> values = featureValue.getValues();
		List<IReference> potentialTargets = new ArrayList<IReference>();
		for (int i = 0; i < values.size(); i++) {
			potentialTargets.add((IReference) values.get(i));
		}
		CS_RequestPropagationStrategy strategy = (CS_RequestPropagationStrategy) this.locus.getFactory().getStrategy("requestPropagation");
		List<IReference> targets = strategy.select(potentialTargets, new SendSignalActionActivation());
		for (int i = 0; i < targets.size(); i++) {
			CS_InteractionPoint target = (CS_InteractionPoint) targets.get(i);
			this.sendOut(eventOccurrence, target);
		}
	}

	public IExecution dispatchOut(Operation operation, Port onPort) {
		// Select a CS_InteractionPoint value playing onPort,
		// and dispatches the operation to this interaction point
		IExecution execution = null;
		IFeatureValue featureValue = this.getFeatureValue(onPort);
		List<IValue> values = featureValue.getValues();
		List<IReference> potentialTargets = new ArrayList<IReference>();
		for (int i = 0; i < values.size(); i++) {
			potentialTargets.add((Reference) values.get(i));
		}
		CS_RequestPropagationStrategy strategy = (CS_RequestPropagationStrategy) this.locus.getFactory().getStrategy("requestPropagation");
		List<IReference> targets = strategy.select(potentialTargets, new CallOperationActionActivation());
		// if targets is empty, no dispatch target has been found,
		// and the operation call is lost
		if (targets.size() >= 1) {
			ICS_InteractionPoint target = (ICS_InteractionPoint) targets.get(0);
			execution = this.dispatchOut(operation, target);
		}
		return execution;
	}

	public IExecution dispatchIn(Operation operation, Port onPort) {
		// delegates dispatching to composite referent
		// Select a CS_InteractionPoint value playing onPort,
		// and dispatches the operation call to this interaction point
		IFeatureValue featureValue = this.getFeatureValue(onPort);
		List<IValue> values = featureValue.getValues();
		Integer choice = ((ChoiceStrategy) this.locus.getFactory().getStrategy("choice")).choose(featureValue.getValues().size()) - 1;
		CS_InteractionPoint interactionPoint = (CS_InteractionPoint) values.get(choice);
		return interactionPoint.dispatch(operation);
	}

	public void sendIn(IEventOccurrence eventOccurrence, Port onPort) {
		// Select a Reference value playing onPort,
		// and send the signal instance to this interaction point
		IFeatureValue featureValue = this.getFeatureValue(onPort);
		List<IValue> values = featureValue.getValues();
		List<IReference> potentialTargets = new ArrayList<IReference>();
		for (int i = 0; i < values.size(); i++) {
			potentialTargets.add((Reference) values.get(i));
		}
		CS_RequestPropagationStrategy strategy = (CS_RequestPropagationStrategy) this.locus.getFactory().getStrategy("requestPropagation");
		List<IReference> targets = strategy.select(potentialTargets, new SendSignalActionActivation());
		for (int i = 0; i < targets.size(); i++) {
			IReference target = targets.get(i);
			target.send(eventOccurrence);
		}
	}

	public boolean checkAllParents(Classifier type, Classifier classifier) {
		// If the given classifier is not an Interface, behaves like in fUML.
		// Otherwise, check if the given type (or one of its direct or indirect ancestors)
		// has an InterfaceRealization relationships with the given classifier.
		boolean matched = false;
		if (!(classifier instanceof Interface)) {
			matched = super.checkAllParents(type, classifier);
		} else if (!(type instanceof Class)) {
			matched = false;
		} else if (this.realizesInterface((Class) type, (Interface) classifier)) {
			matched = true;
		} else {
			List<Classifier> directParents = type.getGenerals();
			int i = 1;
			while (!matched & i <= directParents.size()) {
				Classifier directParent = directParents.get(i - 1);
				matched = this.checkAllParents(directParent, classifier);
				i = i + 1;
			}
		}
		return matched;
	}

	public Boolean realizesInterface(Class type, Interface interface_) {
		// Checks if the given type has an InterfaceRealization relationship
		// with the given interface or a descendant of the interface.
		List<InterfaceRealization> realizations = type.getInterfaceRealizations();
		boolean realized = false;
		int i = 1;
		while (i <= realizations.size() && !realized) {
			InterfaceRealization realization = realizations.get(i - 1);
			Interface contract = realization.getContract();
			if (contract == interface_) {
				realized = true;
			} else if (this.isDescendant(contract, interface_)) {
				realized = true;
			}
			i = i + 1;
		}
		return realized;
	}

	public Boolean isDescendant(Interface contract, Interface interface_) {
		// Checks if the given contract is a descendant of the given interface_
		boolean matched = false;
		List<Classifier> descendants = contract.getGenerals();
		int i = 1;
		while (i <= descendants.size() && !matched) {
			if (descendants.get(i - 1) instanceof Interface) {
				Interface descendant = (Interface) descendants.get(i - 1);
				if (descendant == interface_) {
					matched = true;
				} else {
					matched = this.isDescendant(descendant, interface_);
				}
			}
			i = i + 1;
		}
		return matched;
	}
}
