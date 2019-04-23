/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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

package org.eclipse.papyrus.moka.simex.advices.commands;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.moka.simex.utils.PinUtils;
import org.eclipse.papyrus.uml.diagram.common.util.CrossReferencerUtil;
import org.eclipse.uml2.uml.AcceptCallAction;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.AddStructuralFeatureValueAction;
import org.eclipse.uml2.uml.BroadcastSignalAction;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.ClearAssociationAction;
import org.eclipse.uml2.uml.ClearStructuralFeatureAction;
import org.eclipse.uml2.uml.CreateObjectAction;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.ReadExtentAction;
import org.eclipse.uml2.uml.ReadStructuralFeatureAction;
import org.eclipse.uml2.uml.ReduceAction;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UnmarshallAction;
import org.eclipse.uml2.uml.util.UMLSwitch;

/**
 * @author sr246418
 *
 */
public class PinUpdateICommandFactory extends UMLSwitch<ICommand> {


	private EObject objectToEdit;
	private EStructuralFeature updatedFeature;




	/**
	 * @see org.eclipse.uml2.uml.util.UMLSwitch#caseCallOperationAction(org.eclipse.uml2.uml.CallOperationAction)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public ICommand caseCallOperationAction(final CallOperationAction object) {
		if (updatedFeature.getFeatureID() == UMLPackage.CALL_OPERATION_ACTION__OPERATION ||
				updatedFeature.getFeatureID() == UMLPackage.CALL_OPERATION_ACTION__ON_PORT) {
			ICommand command = new AbstractPinUpdateCommand("update " + object.getName() + " pins") {
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					PinUtils.updateCallOperationActionPins(object);
					return CommandResult.newOKCommandResult();
				}
			};
			return command;
		}
		return null;

	}


	/**
	 * @see org.eclipse.uml2.uml.util.UMLSwitch#caseCallBehaviorAction(org.eclipse.uml2.uml.CallBehaviorAction)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public ICommand caseCallBehaviorAction(final CallBehaviorAction object) {
		if (updatedFeature.getFeatureID() == UMLPackage.CALL_BEHAVIOR_ACTION__BEHAVIOR) {
			ICommand command = new AbstractPinUpdateCommand("update " + object.getName() + " pins") {
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					PinUtils.updateCallBehaviorActionPins(object);
					return CommandResult.newOKCommandResult();
				}
			};
			return command;
		}
		return null;
	}


	/**
	 * @see org.eclipse.uml2.uml.util.UMLSwitch#caseSendSignalAction(org.eclipse.uml2.uml.SendSignalAction)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public ICommand caseSendSignalAction(final SendSignalAction object) {
		if (updatedFeature.getFeatureID() == UMLPackage.SEND_SIGNAL_ACTION__SIGNAL ||
				updatedFeature.getFeatureID() == UMLPackage.SEND_SIGNAL_ACTION__ON_PORT) {
			ICommand command = new AbstractPinUpdateCommand("update " + object.getName() + " pins") {
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					PinUtils.updateSendSignalActionPins(object);
					return CommandResult.newOKCommandResult();
				}
			};
			return command;
		}
		return null;
	}

	/**
	 * @see org.eclipse.uml2.uml.util.UMLSwitch#caseBroadcastSignalAction(org.eclipse.uml2.uml.BroadcastSignalAction)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public ICommand caseBroadcastSignalAction(final BroadcastSignalAction object) {
		if (updatedFeature.getFeatureID() == UMLPackage.BROADCAST_SIGNAL_ACTION__SIGNAL) {
			ICommand command = new AbstractPinUpdateCommand("update " + object.getName() + " pins") {
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					PinUtils.updateBroadcastSignalActionPins(object);
					return CommandResult.newOKCommandResult();
				}
			};
			return command;
		}
		return null;
	}

	/**
	 * @see org.eclipse.uml2.uml.util.UMLSwitch#caseAcceptEventAction(org.eclipse.uml2.uml.AcceptEventAction)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public ICommand caseAcceptEventAction(AcceptEventAction object) {
		if (updatedFeature.getFeatureID() == UMLPackage.ACCEPT_EVENT_ACTION__TRIGGER ||
				updatedFeature.getFeatureID() == UMLPackage.ACCEPT_EVENT_ACTION__IS_UNMARSHALL) {
			return getUpdateAcceptEventUpdateCommand(object);
		} else {
			return null;
		}

	}

	/**
	 * @see org.eclipse.uml2.uml.util.UMLSwitch#caseAcceptCallAction(org.eclipse.uml2.uml.AcceptCallAction)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public ICommand caseAcceptCallAction(AcceptCallAction acceptAction) {
		if (updatedFeature.getFeatureID() == UMLPackage.ACCEPT_CALL_ACTION__TRIGGER) {
			return getUpdateAcceptCallActionUpdateCommand(acceptAction);
		}
		return null;
	}

	/**
	 * @see org.eclipse.uml2.uml.util.UMLSwitch#caseSignalEvent(org.eclipse.uml2.uml.SignalEvent)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public ICommand caseSignalEvent(SignalEvent signalEvent) {
		if (updatedFeature.getFeatureID() == UMLPackage.SIGNAL_EVENT__SIGNAL) {

			Set<Action> actionsToUpdate = findReferencingAcceptActions(signalEvent);
			CompositeCommand cc = new CompositeCommand("update accept signal actions");

			for (final Action actionToUpdate : actionsToUpdate) {
				if (actionToUpdate instanceof AcceptEventAction) {
					cc.add(getUpdateAcceptEventUpdateCommand((AcceptEventAction) actionToUpdate));
				}
			}
			return cc;
		}
		return null;
	}

	/**
	 * @see org.eclipse.uml2.uml.util.UMLSwitch#caseCallEvent(org.eclipse.uml2.uml.CallEvent)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public ICommand caseCallEvent(CallEvent callEvent) {
		if (updatedFeature.getFeatureID() == UMLPackage.CALL_EVENT__OPERATION) {

			Set<Action> actionsToUpdate = findReferencingAcceptActions(callEvent);
			CompositeCommand cc = new CompositeCommand("update accept call event actions");

			for (final Action actionToUpdate : actionsToUpdate) {
				if (actionToUpdate instanceof AcceptCallAction) {
					cc.add(getUpdateAcceptCallActionUpdateCommand((AcceptCallAction) actionToUpdate));
				}
			}
			return cc;
		}
		return null;
	}



	/**
	 * @see org.eclipse.uml2.uml.util.UMLSwitch#caseTrigger(org.eclipse.uml2.uml.Trigger)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public ICommand caseTrigger(Trigger trigger) {
		if (updatedFeature.getFeatureID() == UMLPackage.TRIGGER__EVENT) {
			if (trigger.getOwner() instanceof AcceptCallAction) {
				AcceptCallAction action = (AcceptCallAction) trigger.getOwner();
				return getUpdateAcceptCallActionUpdateCommand(action);
			} else if (trigger.getOwner() instanceof AcceptEventAction) {
				AcceptEventAction action = (AcceptEventAction) trigger.getOwner();
				return getUpdateAcceptEventUpdateCommand(action);
			}
		}
		return null;
	}

	/**
	 * @see org.eclipse.uml2.uml.util.UMLSwitch#caseReadStructuralFeatureAction(org.eclipse.uml2.uml.ReadStructuralFeatureAction)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public ICommand caseReadStructuralFeatureAction(final ReadStructuralFeatureAction readAction) {
		if (updatedFeature.getFeatureID() == UMLPackage.READ_STRUCTURAL_FEATURE_ACTION__STRUCTURAL_FEATURE) {
			ICommand command = new AbstractPinUpdateCommand("update " + readAction.getName() + " pins") {
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					PinUtils.updateReadStructuralFeatureActionPins(readAction);
					return CommandResult.newOKCommandResult();
				}
			};
			return command;
		}
		return null;
	}


	/**
	 * @see org.eclipse.uml2.uml.util.UMLSwitch#caseAddStructuralFeatureValueAction(org.eclipse.uml2.uml.AddStructuralFeatureValueAction)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public ICommand caseAddStructuralFeatureValueAction(final AddStructuralFeatureValueAction addAction) {
		if (updatedFeature.getFeatureID() == UMLPackage.ADD_STRUCTURAL_FEATURE_VALUE_ACTION__STRUCTURAL_FEATURE) {
			ICommand command = new AbstractPinUpdateCommand("update " + addAction.getName() + " pins") {
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					PinUtils.updateAddStructuralFeatureActionPins(addAction);
					return CommandResult.newOKCommandResult();
				}
			};
			return command;
		}
		return null;
	}


	/**
	 * @see org.eclipse.uml2.uml.util.UMLSwitch#caseClearStructuralFeatureAction(org.eclipse.uml2.uml.ClearStructuralFeatureAction)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public ICommand caseClearStructuralFeatureAction(final ClearStructuralFeatureAction clearAction) {
		if (updatedFeature.getFeatureID() == UMLPackage.CLEAR_STRUCTURAL_FEATURE_ACTION__STRUCTURAL_FEATURE) {
			ICommand command = new AbstractPinUpdateCommand("update " + clearAction.getName() + " pins") {
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					PinUtils.updateClearStructuralFeatureActionPins(clearAction);
					return CommandResult.newOKCommandResult();
				}
			};
			return command;
		}
		return null;
	}


	/**
	 * @see org.eclipse.uml2.uml.util.UMLSwitch#caseUnmarshallAction(org.eclipse.uml2.uml.UnmarshallAction)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public ICommand caseUnmarshallAction(final UnmarshallAction action) {
		if (updatedFeature.getFeatureID() == UMLPackage.UNMARSHALL_ACTION__UNMARSHALL_TYPE) {
			ICommand command = new AbstractPinUpdateCommand("update " + action.getName() + " pins") {
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					PinUtils.updateUnmarshallActionPins(action);
					return CommandResult.newOKCommandResult();
				}
			};
			return command;
		}
		return null;
	}

	/**
	 * @see org.eclipse.uml2.uml.util.UMLSwitch#caseReadExtentAction(org.eclipse.uml2.uml.ReadExtentAction)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public ICommand caseReadExtentAction(final ReadExtentAction action) {
		if (updatedFeature.getFeatureID() == UMLPackage.READ_EXTENT_ACTION__CLASSIFIER) {
			ICommand command = new AbstractPinUpdateCommand("update " + action + " pins") {
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					PinUtils.updateReadExtentActionPins(action);
					return CommandResult.newOKCommandResult();
				}
			};
			return command;
		}
		return null;
	}


	/**
	 * @see org.eclipse.uml2.uml.util.UMLSwitch#caseCreateObjectAction(org.eclipse.uml2.uml.CreateObjectAction)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public ICommand caseCreateObjectAction(final CreateObjectAction action) {
		if (updatedFeature.getFeatureID() == UMLPackage.CREATE_OBJECT_ACTION__CLASSIFIER) {
			ICommand command = new AbstractPinUpdateCommand("update " + action + " pins") {
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					PinUtils.updateCreateObjectActionPins(action);
					return CommandResult.newOKCommandResult();
				}
			};
			return command;
		}
		return null;
	}

	/**
	 * @see org.eclipse.uml2.uml.util.UMLSwitch#caseReduceAction(org.eclipse.uml2.uml.ReduceAction)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public ICommand caseReduceAction(final ReduceAction action) {
		if (updatedFeature.getFeatureID() == UMLPackage.REDUCE_ACTION__REDUCER) {
			ICommand command = new AbstractPinUpdateCommand("update " + action + " pins") {
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					PinUtils.updateReduceActionPins(action);
					return CommandResult.newOKCommandResult();
				}
			};
			return command;
		}
		return null;
	}

	
	/**
	 * @see org.eclipse.uml2.uml.util.UMLSwitch#caseClearAssociationAction(org.eclipse.uml2.uml.ClearAssociationAction)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public ICommand caseClearAssociationAction(final ClearAssociationAction action) {
		if (updatedFeature.getFeatureID() == UMLPackage.CLEAR_ASSOCIATION_ACTION__ASSOCIATION) {
			ICommand command = new AbstractPinUpdateCommand("update " + action + " pins") {
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					PinUtils.updateClearAssocationActionPins(action);
					return CommandResult.newOKCommandResult();
				}
			};
			return command;
		}
		return null;
		
	}

	private Set<Action> findReferencingAcceptActions(Event event) {
		Set<Action> referencingActions = new HashSet<Action>();
		CrossReferenceAdapter refAdapter = CrossReferencerUtil.getCrossReferenceAdapter(event);
		@SuppressWarnings("unchecked")
		Set<Trigger> triggers = refAdapter.getInverseReferencers(event, UMLPackage.eINSTANCE.getTrigger_Event(), UMLPackage.eINSTANCE.getTrigger());
		for (Trigger trigger : triggers) {
			if (trigger.getOwner() instanceof Action) {
				referencingActions.add((AcceptEventAction) trigger.getOwner());
			}
		}

		return referencingActions;
	}




	/**
	 * @param action
	 * @return
	 */
	private ICommand getUpdateAcceptCallActionUpdateCommand(final AcceptCallAction acceptAction) {
		ICommand command = new AbstractPinUpdateCommand("update " + acceptAction.getName() + " pins") {
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				PinUtils.updateAcceptCallActionPins(acceptAction);
				return CommandResult.newOKCommandResult();
			}
		};
		return command;
	}

	/**
	 * @param action
	 * @return
	 */
	private ICommand getUpdateAcceptEventUpdateCommand(final AcceptEventAction actionToUpdate) {
		ICommand command = new AbstractPinUpdateCommand("update " + actionToUpdate.getName() + " pins") {
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				PinUtils.updateAcceptEventActionPins(actionToUpdate);
				return CommandResult.newOKCommandResult();
			}
		};
		return command;
	}


	/**
	 * @param request
	 * @return
	 */
	public ICommand getCommand(IEditCommandRequest request) {
		if (request instanceof SetRequest) {
			SetRequest setReq = (SetRequest) request;
			objectToEdit = setReq.getElementToEdit();
			updatedFeature = setReq.getFeature();
			if (updatedFeature != null) {
				return doSwitch(objectToEdit);
			}

		}
		return null;

	}




}
