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
 *   Sebastie  Revol CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.simex.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.AcceptCallAction;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.AddStructuralFeatureValueAction;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BroadcastSignalAction;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ClearAssociationAction;
import org.eclipse.uml2.uml.ClearStructuralFeatureAction;
import org.eclipse.uml2.uml.CreateLinkAction;
import org.eclipse.uml2.uml.CreateObjectAction;
import org.eclipse.uml2.uml.DestroyLinkAction;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InvocationAction;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.ReadExtentAction;
import org.eclipse.uml2.uml.ReadIsClassifiedObjectAction;
import org.eclipse.uml2.uml.ReadLinkAction;
import org.eclipse.uml2.uml.ReadStructuralFeatureAction;
import org.eclipse.uml2.uml.ReduceAction;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UnmarshallAction;

/**
 * @author sr246418
 *
 */
public class PinUtils {

	/**
	 * @param object
	 * @param domain
	 */

	public static void updateCallOperationActionPins(CallOperationAction callOperationAction) {
		Operation operation = callOperationAction.getOperation();
		if (operation != null) {
			updateTargetPin(callOperationAction, getTargetPinTheoriticalType(callOperationAction));
			alignPinsWithTypedElements(callOperationAction, operation.inputParameters(), callOperationAction.getArguments(), UMLElementTypes.INPUT_PIN, UMLPackage.eINSTANCE.getInvocationAction_Argument());
			alignPinsWithTypedElements(callOperationAction, operation.outputParameters(), callOperationAction.getResults(), UMLElementTypes.OUTPUT_PIN, UMLPackage.eINSTANCE.getCallAction_Result());
		}

	}

	/**
	 * @param object
	 */
	public static void updateCallBehaviorActionPins(CallBehaviorAction callBehaviorAction) {
		Behavior behavior = callBehaviorAction.getBehavior();
		if (behavior != null) {
			alignPinsWithTypedElements(callBehaviorAction, behavior.inputParameters(), callBehaviorAction.getArguments(), UMLElementTypes.INPUT_PIN, UMLPackage.eINSTANCE.getInvocationAction_Argument());
			alignPinsWithTypedElements(callBehaviorAction, behavior.outputParameters(), callBehaviorAction.getResults(), UMLElementTypes.OUTPUT_PIN, UMLPackage.eINSTANCE.getCallAction_Result());
		}
	}

	/**
	 * @param object
	 */
	public static void updateSendSignalActionPins(SendSignalAction sendSignalAction) {
		updateTargetPin(sendSignalAction, getTargetPinTheoriticalType(sendSignalAction));
		Signal signal = sendSignalAction.getSignal();
		if (signal != null) {
			alignPinsWithTypedElements(sendSignalAction, signal.allAttributes(), sendSignalAction.getArguments(), UMLElementTypes.INPUT_PIN, UMLPackage.eINSTANCE.getInvocationAction_Argument());
		}
	}

	/**
	 * @param object
	 */
	public static void updateBroadcastSignalActionPins(BroadcastSignalAction braodCastSignalAction) {
		Signal signal = braodCastSignalAction.getSignal();
		if (signal != null) {
			alignPinsWithTypedElements(braodCastSignalAction, signal.allAttributes(), braodCastSignalAction.getArguments(), UMLElementTypes.INPUT_PIN, UMLPackage.eINSTANCE.getInvocationAction_Argument());
		}
	}


	public static void updateAcceptEventActionPins(AcceptEventAction acceptEventAction) {
		if (acceptEventAction.isUnmarshall() && !acceptEventAction.getTriggers().isEmpty()) {
			// there should be only one trigger on a Signal Event
			Trigger firstTrigger = acceptEventAction.getTriggers().get(0);
			Event event = firstTrigger.getEvent();
			if (event instanceof SignalEvent) {
				Signal signal = ((SignalEvent) event).getSignal();
				if (signal != null) {
					alignPinsWithTypedElements(acceptEventAction, signal.allAttributes(), acceptEventAction.getResults(), UMLElementTypes.OUTPUT_PIN, UMLPackage.eINSTANCE.getAcceptEventAction_Result());
				}
			}
		} else {
			// if it is not Unmarshall, there should be only on result pin.
			// It seems that the type can stay null, since the type of the resulting object may change depending on the kind of event which triggered the action
			if (acceptEventAction.getResults().isEmpty()) {
				OutputPin result = RequestUtils.createElementWithRequest(acceptEventAction, UMLElementTypes.OUTPUT_PIN, UMLPackage.eINSTANCE.getAcceptEventAction_Result());
				result.setName("result");
			} else {
				OutputPin result = acceptEventAction.getResults().get(0);
				result.setName("result");
				result.setType(null);
				destroyObjectsAfterIndex(acceptEventAction.getResults(), 1);
			}

		}
	}
	
	
	/**
	 * @param acceptAction
	 */
	public static void updateAcceptCallActionPins(AcceptCallAction acceptAction) {
		getOrCreatePin(acceptAction, UMLElementTypes.OUTPUT_PIN, UMLPackage.eINSTANCE.getAcceptCallAction_ReturnInformation(), "returnInformation");
		if (!acceptAction.getTriggers().isEmpty()){
			//there should be only one trigger
			Trigger trigger = acceptAction.getTriggers().get(0);
			if (trigger.getEvent() instanceof CallEvent){
				CallEvent event = (CallEvent) trigger.getEvent();
				Operation operation = event.getOperation();
				if (operation != null){
					alignPinsWithTypedElements(acceptAction, operation.inputParameters(), acceptAction.getResults(), UMLElementTypes.OUTPUT_PIN, UMLPackage.eINSTANCE.getAcceptEventAction_Result());
				}
			}
		}
		
		
	}

	/**
	 * @param readAction
	 */
	public static void updateReadStructuralFeatureActionPins(ReadStructuralFeatureAction readAction) {
		InputPin object = getOrCreatePin(readAction, UMLElementTypes.INPUT_PIN, UMLPackage.eINSTANCE.getStructuralFeatureAction_Object(), "object");
		OutputPin result = getOrCreatePin(readAction, UMLElementTypes.OUTPUT_PIN, UMLPackage.eINSTANCE.getReadStructuralFeatureAction_Result(), "result");

		StructuralFeature feature = readAction.getStructuralFeature();
		if (feature != null) {
			alignTypeIfNotCompatible(object, (Type) feature.getOwner());
			alignPinWithTypedElement(result, feature);
		}
	}

	/**
	 * @param addAction
	 */
	public static void updateAddStructuralFeatureActionPins(AddStructuralFeatureValueAction addAction) {
		InputPin object = getOrCreatePin(addAction, UMLElementTypes.INPUT_PIN, UMLPackage.eINSTANCE.getStructuralFeatureAction_Object(), "object");
		OutputPin result = getOrCreatePin(addAction, UMLElementTypes.OUTPUT_PIN, UMLPackage.eINSTANCE.getWriteStructuralFeatureAction_Result(), "result");
		InputPin value =  getOrCreatePin(addAction, UMLElementTypes.INPUT_PIN, UMLPackage.eINSTANCE.getWriteStructuralFeatureAction_Value(), "value");
		
		StructuralFeature feature = addAction.getStructuralFeature();
		if (feature != null){
			alignTypeIfNotCompatible(object, (Type) feature.getOwner());
			alignTypeIfNotCompatible(result, (Type) feature.getOwner());
			alignTypeIfNotCompatible(value, feature.getType());
			
			if (feature.isOrdered()){
				InputPin insertAt = getOrCreatePin(addAction, UMLElementTypes.INPUT_PIN, UMLPackage.eINSTANCE.getAddStructuralFeatureValueAction_InsertAt(), "insertAt");
				if (insertAt.getType()== null){
					insertAt.setType(UMLPrimitiveTypesUtils.getUnlimitedNatural(addAction));
				}
			}else {
				destroyIfExists(addAction.getInsertAt());
			}
		}	
	}
	/**
	 * @param clearAction
	 */
	public static void updateClearStructuralFeatureActionPins(ClearStructuralFeatureAction clearAction) {
		InputPin object = getOrCreatePin(clearAction, UMLElementTypes.INPUT_PIN, UMLPackage.eINSTANCE.getStructuralFeatureAction_Object(), "object");
		OutputPin result = getOrCreatePin(clearAction, UMLElementTypes.OUTPUT_PIN, UMLPackage.eINSTANCE.getClearStructuralFeatureAction_Result(), "result");
		
		StructuralFeature feature = clearAction.getStructuralFeature();
		if (feature != null){
			alignTypeIfNotCompatible(object, (Type) feature.getOwner());
			alignTypeIfNotCompatible(result, (Type) feature.getOwner());
		}
	}

	
	/**
	 * @param action
	 */
	public static void updateUnmarshallActionPins(UnmarshallAction action) {
		InputPin object = getOrCreatePin(action, UMLElementTypes.INPUT_PIN, UMLPackage.eINSTANCE.getUnmarshallAction_Object(), "object");
		
		Classifier unmarchallType = action.getUnmarshallType();
		if (unmarchallType != null) {
			alignTypeIfNotCompatible(object, unmarchallType);
			alignPinsWithTypedElements(action, unmarchallType.allAttributes(), action.getResults(), UMLElementTypes.OUTPUT_PIN, UMLPackage.eINSTANCE.getUnmarshallAction_Result());	
		}
		
		
	}


	/**
	 * @param action
	 */
	public static void updateReadIsClassifiedObjectAction(ReadIsClassifiedObjectAction action) {
		getOrCreatePin(action, UMLElementTypes.INPUT_PIN, UMLPackage.eINSTANCE.getReadIsClassifiedObjectAction_Object(), "object");
		OutputPin result = getOrCreatePin(action, UMLElementTypes.OUTPUT_PIN, UMLPackage.eINSTANCE.getReadIsClassifiedObjectAction_Result(), "result");
		RequestUtils.setFeatureWithRequest(result,UMLPrimitiveTypesUtils.getBoolean(result), UMLPackage.eINSTANCE.getTypedElement_Type());
		
	}
	
	/**
	 * @param action
	 */
	public static void updateReadExtentActionPins(ReadExtentAction action) {
		OutputPin result = getOrCreatePin(action, UMLElementTypes.OUTPUT_PIN, UMLPackage.eINSTANCE.getReadExtentAction_Result(), "result");
		RequestUtils.setFeatureWithRequest(result, action.getClassifier(), UMLPackage.eINSTANCE.getTypedElement_Type());
		result.setLower(0);
		result.setUpper(-1);
	}
	
	

	/**
	 * @param action
	 */
	public static void updateCreateObjectActionPins(CreateObjectAction action) {
		OutputPin result = getOrCreatePin(action, UMLElementTypes.OUTPUT_PIN, UMLPackage.eINSTANCE.getCreateObjectAction_Result(), "result");
		RequestUtils.setFeatureWithRequest(result, action.getClassifier(), UMLPackage.eINSTANCE.getTypedElement_Type());
	}

	
	/**
	 * @param action
	 */
	public static void updateReduceActionPins(ReduceAction action) {
		InputPin collection = getOrCreatePin(action, UMLElementTypes.INPUT_PIN, UMLPackage.eINSTANCE.getReduceAction_Collection(), "collection");
		OutputPin result = getOrCreatePin(action, UMLElementTypes.OUTPUT_PIN, UMLPackage.eINSTANCE.getReduceAction_Result(), "result");
		
		Behavior reducer = action.getReducer();
		if (reducer != null) {
			if (!reducer.inputParameters().isEmpty()){
				Parameter firstParam = reducer.inputParameters().get(0);
				alignTypeIfNotCompatible(collection, firstParam.getType());
			}
			if (!reducer.outputParameters().isEmpty()){
				Parameter firstOutput = reducer.outputParameters().get(0);
				alignTypeIfNotCompatible(result, firstOutput.getType());	
			}
			
		}
		
	}

	
	/**
	 * @param action
	 */
	public static void updateClearAssocationActionPins(ClearAssociationAction action) {
		getOrCreatePin(action, UMLElementTypes.INPUT_PIN, UMLPackage.eINSTANCE.getClearAssociationAction_Object(), "object");
		//TODO implement a popup to ask user which association end to clear 
		
	}
	
	
	
	/**
	 * @param action
	 * @param association
	 */
	public static void updateCreateLinkAction(CreateLinkAction action, Association association) {
		//TODO implement create link behaviour
		
	}

	/**
	 * @param action
	 * @param association
	 */
	public static void updateReadLinkAction(ReadLinkAction action, Association association) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param action
	 * @param association
	 */
	public static void updateDestroyLinkAction(DestroyLinkAction action, Association association) {
		// TODO Auto-generated method stub
		
	}

	
	
	/**
	 * @param insertAt
	 */
	private static void destroyIfExists(EObject objectToDestroy) {
		if (objectToDestroy != null){
			RequestUtils.deleteObjectWithRequest(objectToDestroy);
		}
	}

	/**
	 * @param readAction
	 * @param outputPin
	 * @param readStructuralFeatureAction_Result
	 * @param string
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static <T extends Pin> T getOrCreatePin(Action action, IHintedType pinType, EReference containingFeature, String name) {
		Object result = action.eGet(containingFeature);
		if (!(result instanceof Pin)) {
			result = RequestUtils.createElementWithRequest(action, pinType, containingFeature);
			((Pin) result).setName(name);
		}
		
		return (T) result;
	}

	/**
	 * @param callOperationAction
	 * @param targetPinTheoriticalType
	 */
	private static void updateTargetPin(InvocationAction invocationAction, Classifier targetPinTheoriticalType) {
		EStructuralFeature targetFeature = invocationAction.eClass().getEStructuralFeature("target");
		InputPin targetInputPin = getOrCreatePin(invocationAction, UMLElementTypes.INPUT_PIN, (EReference) targetFeature, "target");
		alignTypeIfNotCompatible(targetInputPin, targetPinTheoriticalType);
	}



	private static void alignPinsWithTypedElements(EObject objectWithPins, List<? extends TypedElement> typedElements, List<? extends Pin> pins, IHintedType pinType, EReference containmentFeature) {
		int index = 0;
		for (; index < typedElements.size(); index++) {
			TypedElement param = typedElements.get(index);
			Pin argument;
			if (index >= pins.size()) {
				argument = RequestUtils.createElementWithRequest(objectWithPins, pinType, containmentFeature);
			} else {
				argument = pins.get(index);
			}
			alignPinWithTypedElement(argument, param);
		}
		destroyObjectsAfterIndex(pins, index);

	}

	/**
	 * @param pin
	 * @param typedElement
	 */
	private static void alignPinWithTypedElement(Pin pin, TypedElement typedElement) {
		String name = typedElement.getName();

		if (name != null) {
			pin.setName(name);
		}
		alignTypeIfNotCompatible(pin, typedElement.getType());

		if (pin instanceof MultiplicityElement) {
			pin.setIsOrdered(((MultiplicityElement) typedElement).isOrdered());
			pin.setUpper(((MultiplicityElement) typedElement).getUpper());
			pin.setUpperBound(EcoreUtil.copy(((MultiplicityElement) typedElement).getUpperValue()));
			pin.setLower(((MultiplicityElement) typedElement).getLower());
		}
	}

	/**
	 * @param argument
	 * @param type
	 */
	private static void alignTypeIfNotCompatible(Pin pin, Type typeToComplyWith) {
		Type pinType = pin.getType();
		if (typeToComplyWith != null) {

			if (pinType == null || !pinType.isCompatibleWith(typeToComplyWith)) {
				RequestUtils.setFeatureWithRequest(pin, typeToComplyWith, UMLPackage.eINSTANCE.getTypedElement_Type());
			}
		} else if (pinType != null) {
			RequestUtils.setFeatureWithRequest(pin, null, UMLPackage.eINSTANCE.getTypedElement_Type());
		}
	}

	/**
	 * @param callOperationAction
	 * @return
	 */
	private static Classifier getTargetPinTheoriticalType(CallOperationAction callOperationAction) {
		Port onPort = callOperationAction.getOnPort();
		if (onPort != null) {
			return (Classifier) onPort.getOwner();
		} else {
			Operation operation = callOperationAction.getOperation();
			return (Classifier) operation.getOwner();
		}
	}

	/**
	 * @param
	 * @return
	 */
	private static Classifier getTargetPinTheoriticalType(SendSignalAction sendSignalAction) {
		Port onPort = sendSignalAction.getOnPort();
		if (onPort != null) {
			return (Classifier) onPort.getOwner();
		}
		return null;
	}

	private static void destroyObjectsAfterIndex(List<? extends EObject> collection, int index) {
		List<EObject> objectToDelete = new ArrayList<EObject>();
		for (; index < collection.size(); index++) {
			objectToDelete.add(collection.get(index));
		}
		RequestUtils.deleteObjectsWithRequest(objectToDelete);

	}
















}
