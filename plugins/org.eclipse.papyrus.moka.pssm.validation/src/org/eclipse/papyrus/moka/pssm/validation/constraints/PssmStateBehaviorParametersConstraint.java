/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier:EPL-2.0 
 *
 * Contributors:
 *  Pauline DEVILLE (CEA LIST) pauline.deville@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.pssm.validation.constraints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;

/**
 * pssm_state_behavior_parameters
 * 
 * The entry and doActivity Behaviors of a State must conform to all the
 * Triggers of Transitions that might cause the State to be entered. The exit
 * Behavior of a State must conform to all the Triggers of Transitions that
 * might cause the State to be exited. The effect and guard Behaviors of an
 * outgoing Transition of a State must conform to all the Triggers of the
 * Transition. (Note that only Transitions outgoing from a State may have
 * triggers.)
 * 
 */
public class PssmStateBehaviorParametersConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		State state = (State) ctx.getTarget();
		// Collect this State and all containing States.
		List<State> allState = new ArrayList<>();
		allState.add(state);
		if (state.getContainer() != null && state.getContainer().getState() != null) {
			allState.add(state.getContainer().getState());
		}

		// Get all the incoming Transitions of the collected States, including
		// Transitions incoming to entryPoint Pseudostates owned by the States and
		// all segments of compound Transitions.
		Set<Transition> allIncoming = new HashSet<Transition>();
		allState.stream().forEach(s -> allIncoming.addAll(s.getIncomings()));
		allState.stream()
				.forEach(s -> s.getConnectionPoints().stream()
						.filter(ps -> ps.getKind().equals(PseudostateKind.ENTRY_POINT_LITERAL))
						.forEach(ep -> allIncoming.addAll(ep.getIncomings())));
		Set<Transition> incomingInPseudostate = new HashSet<Transition>();
		allIncoming.stream()
				.forEach(t -> incomingInPseudostate
						.addAll(t.getSource() instanceof Pseudostate ? ((Pseudostate) t.getSource()).getIncomings()
								: Collections.emptySet()));
		allIncoming.addAll(incomingInPseudostate);

		// Get all the outgoing Transitions of the collected States, including
		// Transitions outgoing from exitPoint Pseudostates owned by the States and
		// all segments of compound Transitions.
		Set<Transition> allOutgoing = new HashSet<Transition>();
		allState.stream().forEach(s -> allOutgoing.addAll(s.getOutgoings()));
		allState.stream()
				.forEach(s -> s.getConnectionPoints().stream()
						.filter(ps -> ps.getKind().equals(PseudostateKind.EXIT_POINT_LITERAL))
						.forEach(ep -> allOutgoing.addAll(ep.getIncomings())));
		Set<Transition> outgoingOfPseudostate = new HashSet<Transition>();
		allOutgoing.stream()
				.forEach(t -> outgoingOfPseudostate
						.addAll(t.getTarget() instanceof Pseudostate ? ((Pseudostate) t.getTarget()).getOutgoings()
								: Collections.emptySet()));
		allOutgoing.addAll(outgoingOfPseudostate);

		Boolean expression = true;
		// Check the conformance of the various State Behaviors. (Note that
		// doActivity Behaviors are separately required to have only "in" Parameters.)
		List<Trigger> allIncomingTriggers = new ArrayList<Trigger>();
		allIncoming.stream().forEach(t -> allIncomingTriggers.addAll(t.getTriggers()));
		List<Trigger> allOutgoingTriggers = new ArrayList<Trigger>();
		allOutgoing.stream().forEach(t -> allOutgoingTriggers.addAll(t.getTriggers()));
		if (state.getEntry() != null) {
			expression &= conformsToAll(state.getEntry().getOwnedParameters(), allIncomingTriggers);
		}
		if (expression && state.getDoActivity() != null) {
			expression &= conformsToAll(state.getDoActivity().getOwnedParameters(), allIncomingTriggers);
		}
		if (expression && state.getExit() != null) {
			expression &= conformsToAll(state.getExit().getOwnedParameters(), allOutgoingTriggers);
		}

		// Check the conformance of the effect and guard Behaviors on outgoing
		// Transitions. (Note that the behavior on an OpaqueExpression is
		// separately required to have only "in" Parameters, other than a single
		// return parameter.)
		if (expression) {
			// MODIFIED FROM the NORME
			List<List<Transition>> outgoingCompositionTransition = getAllOutgoingCompositeTransition(state);
			for (Transition transition : allOutgoing) {
				List<Trigger> compositeTransitionTriggers = getCompositeTransitionTriggers(transition, outgoingCompositionTransition);
				if (transition.getEffect() != null) {
					expression &= conformsToAll(transition.getEffect().getOwnedParameters(), compositeTransitionTriggers);
				}
				if (transition.getGuard() != null
						&& transition.getGuard().getSpecification() instanceof OpaqueExpression) {
					Behavior behavior = ((OpaqueExpression) transition.getGuard().getSpecification()).getBehavior();
					if (behavior != null) {
						expression &= conformsToAll(behavior.getOwnedParameters().stream()
								.filter(p -> !p.getDirection().equals(ParameterDirectionKind.RETURN_LITERAL))
								.collect(Collectors.toList()), compositeTransitionTriggers);
					}
				}
			}
			// END MODIFIED FROM the NORME
		}

		if (!expression) {
			return ctx.createFailureStatus(
					"State - The entry and doActivity Behaviors of a State must conform to all the Triggers of Transitions that might cause the  State to be entered. The exit Behavior of a State must conform to all the Triggers of Transitions that might cause the  State to be exited. The effect and guard Behaviors of an outgoing Transition of a State must conform to all the  Triggers of the Transition. (Note that only Transitions outgoing from a State may have triggers.)");
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * A signature (set of Parameters) conforms to a collection of Triggers if one of the following is true:
	 * -the signature is empty;
	 * -all the Triggers are for SignalEvents and the signature has exactly one Parameter of direction in, has multiplicity upper
	 * bound of 1 and is either untyped or has a type that is a Signal that conforms to all the Signals of the Triggers;
	 * -or all the Triggers are for CallEvents and the signature conforms to or input-conforms to all the signatures of the Operations of
	 * the CallEvents.
	 * (A signature input-conforms to another if the first signature conforms to the signature containing only the
	 * in Parameters from the second signature).
	 */
	protected boolean conformsToAll(List<Parameter> signature, List<Trigger> triggers) {
		boolean result = signature.isEmpty();
		final Parameter parameter = signature.size() == 1 ? signature.get(0) : null;
		result |= triggers.stream().map(t -> t.getEvent()).allMatch(e -> e instanceof SignalEvent) && parameter != null
				&& parameter.getDirection().equals(ParameterDirectionKind.IN_LITERAL) && parameter.is(1, 1)
				&& (parameter.getType() == null || triggers.stream().map(t -> t.getEvent()).map(SignalEvent.class::cast)
						.map(se -> se.getSignal()).allMatch(s -> parameter.getType().conformsTo(s)));
		result |= triggers.stream().map(t -> t.getEvent()).allMatch(e -> e instanceof CallEvent)
				&& triggers.stream().map(t -> t.getEvent()).map(CallEvent.class::cast).map(ce -> ce.getOperation())
						.allMatch(o -> conforms(signature, o.getOwnedParameters()) || conforms(signature,
								o.getOwnedParameters().stream()
										.filter(p -> p.getDirection().equals(ParameterDirectionKind.IN_LITERAL))
										.collect(Collectors.toList())));
		return result;
	}

	/**
	 * One signature conforms to another if the first signature has the same number
	 * of Parameters as the second signature, and each Parameter of the first
	 * signature has the same direction, ordering and uniqueness as the
	 * corresponding Parameter (in order) from the second signature and a type and
	 * multiplicity that are compatible with those of the corresponding Parameter
	 * (depending on the Parameter direction).
	 */
	protected boolean conforms(List<Parameter> signature1, List<Parameter> signature2) {
		boolean result = true;
		if (signature1.size() == signature2.size()) {
			for (int i = 0; result && i < signature1.size(); i++) {
				Parameter parameter1 = signature1.get(i);
				Parameter parameter2 = signature2.get(i);
				result &= parameter1.getDirection().equals(parameter2.getDirection())
						&& parameter1.isOrdered() == parameter2.isOrdered()
						&& parameter1.isUnique() == parameter2.isUnique();
				if (parameter2.getDirection().equals(ParameterDirectionKind.IN_LITERAL)) {
					result &= parameter2.getType() == null
							|| parameter2.getType() != null && parameter2.getType().conformsTo(parameter1.getType())
									&& parameter2.compatibleWith(parameter1);
				} else if (parameter2.getDirection().equals(ParameterDirectionKind.RETURN_LITERAL)
						|| parameter2.getDirection().equals(ParameterDirectionKind.OUT_LITERAL)) {
					result &= parameter1.getType() == null
							|| parameter1.getType() != null && parameter1.getType().conformsTo(parameter2.getType())
									&& parameter1.compatibleWith(parameter2);
				} else if (parameter2.getDirection().equals(ParameterDirectionKind.INOUT_LITERAL)) {
					result &= parameter1.getType().equals(parameter2.getType()) && parameter2.compatibleWith(parameter1)
							&& parameter1.compatibleWith(parameter2);
				}
			}
			return result;
		}
		return false;
	}

	/**
	 * Composite transition are all transition that are evaluate in the same step
	 * during the simulation. 
	 * - the transition outgoing from a state S1.1 ant the transition outgoing of
	 * the composite state S1 owning the state S1.1 are
	 * composite 
	 * - A transition incoming in an entryPoint and every transition outgoing of 
	 * this entryPoint are composite
	 */
	private List<List<Transition>> getAllOutgoingCompositeTransition(final State state) {
		List<List<Transition>> compositions = new ArrayList<List<Transition>>();

		EList<Transition> directOutgoingTransitions = state.getOutgoings();
		// if the state is in a composite state
		State parent = state.getContainer().getState();
		if(parent != null) {
			for (Iterator<Transition> iter = directOutgoingTransitions.iterator(); iter.hasNext();) {
				Transition transition = (Transition) iter.next();
				List<Transition> intermediateList = new ArrayList<Transition>();
				intermediateList.addAll(parent.getOutgoings());
				intermediateList.add(transition);
				compositions.add(intermediateList);
			}
		}
		
		// if there is a composite transition with entryPoint
		for (Iterator<Transition> iter = directOutgoingTransitions.iterator(); iter.hasNext();) {
			Transition transition = (Transition) iter.next();
			if(transition.getTarget() instanceof Pseudostate && ((Pseudostate)transition.getTarget()).getKind() == PseudostateKind.ENTRY_POINT_LITERAL){
				List<Transition> intermediateList = new ArrayList<Transition>();
				intermediateList.add(transition);
				intermediateList.addAll(transition.getTarget().getOutgoings());
				compositions.add(intermediateList);
			}
		}
		
		return compositions;
	}

	/**
	 * For the given transition, search in which composition this transition take
	 * part then get all triggers owned by those transitions
	 */
	private List<Trigger> getCompositeTransitionTriggers(Transition transition,
			List<List<Transition>> outgoingCompositionTransition) {
		List<Trigger> triggers = new ArrayList<Trigger>(transition.getTriggers());

		for (Iterator<List<Transition>> iter = outgoingCompositionTransition.iterator(); iter.hasNext();) {
			List<Transition> list = (List<Transition>) iter.next();
			if (list.contains(transition)) {
				list.forEach(t -> triggers.addAll(t.getTriggers()));
			}
		}

		return triggers;
	}

}