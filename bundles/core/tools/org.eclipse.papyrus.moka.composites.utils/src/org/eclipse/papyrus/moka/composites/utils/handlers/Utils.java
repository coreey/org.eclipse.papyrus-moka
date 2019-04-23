/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.moka.composites.utils.handlers;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.extensionpoints.profile.IRegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.CreateObjectAction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.StartObjectBehaviorAction;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

public class Utils {

	public static Profile standardProfile;

	public static String STANDARD_PROFILE_NAME = "Standard";


	/**
	 * Generates (or retrieve) a factory Activity for the given context Class.
	 * A factory Activity consists in a CreateObjectAction for the given context Class,
	 * followed by a CallOperationAction for the default constructor of this class.
	 *
	 * @param context
	 *            The class for which a Factory is requested
	 * @return A factory Activity for the given context Class
	 */
	public static Activity getFactory(Class context) {

		// First try to retrieve the factory
		// Retrieval is based on name.
		Activity factory = null;
		String contextName = context.getName() == null ? "" : context.getName();
		for (Iterator<Behavior> i = context.getOwnedBehaviors().iterator(); i.hasNext() && factory == null;) {
			Behavior cddFactory = i.next();
			String cddName = cddFactory.getName() == null ? "" : cddFactory.getName();
			if (cddFactory instanceof Activity && cddName.equals(contextName + "_Factory")) {
				factory = (Activity) cddFactory;
			}
		}

		Parameter returnParam = null;
		// if the factory does not exist, then creates it, otherwise "cleans" it
		if (factory == null) {
			factory = (Activity) context.createOwnedBehavior(context.getName() + "_Factory", UMLPackage.eINSTANCE.getActivity());
			returnParam = factory.createOwnedParameter("result", context);
			returnParam.setDirection(ParameterDirectionKind.RETURN_LITERAL);
		} else {
			factory.getNodes().clear();
			factory.getEdges().clear();
			for (Iterator<Parameter> i = factory.getOwnedParameters().iterator(); i.hasNext() && returnParam == null;) {
				Parameter cddReturn = i.next();
				if (cddReturn.getDirection() == ParameterDirectionKind.RETURN_LITERAL) {
					returnParam = cddReturn;
				}
			}
			if (returnParam == null) {
				returnParam = factory.createOwnedParameter("result", context);
				returnParam.setDirection(ParameterDirectionKind.RETURN_LITERAL);
			}
		}

		ActivityParameterNode returnParamNode = (ActivityParameterNode) factory.createOwnedNode("resultParameterNode", UMLPackage.eINSTANCE.getActivityParameterNode());
		returnParamNode.setParameter(returnParam);
		returnParamNode.setType(context);
		LiteralInteger returnParamNodeUpperBound = UMLFactory.eINSTANCE.createLiteralInteger();
		returnParamNodeUpperBound.setValue(1);
		returnParamNode.setUpperBound(returnParamNodeUpperBound);

		// Retrieves the default constructor of context
		Operation defaultConstructor = getDefaultConstructor(context);

		CreateObjectAction createObject = (CreateObjectAction) factory.createOwnedNode("createObject", UMLPackage.eINSTANCE.getCreateObjectAction());
		OutputPin createObjectResultPin = createObject.createResult("result", context);
		LiteralInteger createObjectResultPinUpperBound = UMLFactory.eINSTANCE.createLiteralInteger();
		createObjectResultPinUpperBound.setValue(1);
		createObjectResultPin.setUpperBound(createObjectResultPinUpperBound);
		createObject.setClassifier(context);

		CallOperationAction callConstructor = (CallOperationAction) factory.createOwnedNode("callConstructor", UMLPackage.eINSTANCE.getCallOperationAction());
		callConstructor.setOperation(defaultConstructor);
		InputPin callConstructorTargetPin = callConstructor.createTarget("target", context);
		LiteralInteger callConstructorTargetPinUpperBound = UMLFactory.eINSTANCE.createLiteralInteger();
		callConstructorTargetPinUpperBound.setValue(1);
		callConstructorTargetPin.setUpperBound(callConstructorTargetPinUpperBound);
		OutputPin callConstructorResultPin = callConstructor.createResult("result", context);
		LiteralInteger callConstructorResultPinUpperBound = UMLFactory.eINSTANCE.createLiteralInteger();
		callConstructorResultPinUpperBound.setValue(1);
		callConstructorResultPin.setUpperBound(callConstructorResultPinUpperBound);

		ObjectFlow createObjectAction_callConstructor = (ObjectFlow) factory.createEdge("createObjectAction to callConstructor", UMLPackage.eINSTANCE.getObjectFlow());
		createObjectAction_callConstructor.setSource(createObjectResultPin);
		createObjectAction_callConstructor.setTarget(callConstructorTargetPin);

		ObjectFlow toReturnParamNode = (ObjectFlow) factory.createEdge("callConstructor to returnParamNode", UMLPackage.eINSTANCE.getObjectFlow());
		toReturnParamNode.setTarget(returnParamNode);
		if (!context.isActive()) {
			toReturnParamNode.setSource(callConstructorResultPin);
		} else {
			StartObjectBehaviorAction startBehavior = (StartObjectBehaviorAction) factory.createOwnedNode("start classifier behavior", UMLPackage.eINSTANCE.getStartObjectBehaviorAction());
			InputPin startBehaviorInputPin = startBehavior.createObject("object", context);
			LiteralInteger startBehaviorInputPinUpperBound = UMLFactory.eINSTANCE.createLiteralInteger();
			startBehaviorInputPinUpperBound.setValue(1);
			startBehaviorInputPin.setUpperBound(startBehaviorInputPinUpperBound);
			/*
			 * // 439321: [Moka] The factory generator of oepm.composite.utils is invalid in the case of an Active class
			 * // https://bugs.eclipse.org/bugs/show_bug.cgi?id=439321
			 * //OutputPin startBehaviorResultPin = startBehavior.createResult("result", context);
			 * //LiteralInteger startBehaviorResultPinUpperBound = UMLFactory.eINSTANCE.createLiteralInteger();
			 * //startBehaviorResultPinUpperBound.setValue(1) ;
			 * //startBehaviorResultPin.setUpperBound(startBehaviorResultPinUpperBound) ;
			 * //toReturnParamNode.setSource(startBehaviorResultPin);
			 */
			ForkNode fork = (ForkNode) factory.createOwnedNode("forkInstanciatedObject", UMLPackage.eINSTANCE.getForkNode());
			toReturnParamNode.setSource(fork);
			ObjectFlow forkToStartBehaviorInputPin = (ObjectFlow) factory.createEdge("fork to startbehavior input pin", UMLPackage.eINSTANCE.getObjectFlow());
			forkToStartBehaviorInputPin.setSource(fork);
			forkToStartBehaviorInputPin.setTarget(startBehaviorInputPin);
			//
			ObjectFlow callConstructor_startBehavior = (ObjectFlow) factory.createEdge("callConstructor to startBehavior", UMLPackage.eINSTANCE.getObjectFlow());
			callConstructor_startBehavior.setSource(callConstructorResultPin);
			callConstructor_startBehavior.setTarget(fork);
		}

		return factory;
	}

	/**
	 * Returns the default constructor of the given UML Class context.
	 * If the default constructor does not exist, it is the generated, with side effects
	 * on the given context Class (i.e., the generated constructor is added to the list of
	 * operations of the given context Class.
	 * A default constructor for a given context Class is a UML Operation with:
	 * - constructor.name == context.name
	 * - a single parameter p such that: p.direction == Return and p.type = context
	 *
	 * @param context
	 *            A UML Class
	 * @return the default constructor Operation for the given context Class
	 */
	public static Operation getDefaultConstructor(Class context) {
		// Returns the default constructor if it exists.
		// Creates it otherwise.
		Operation createdOp = null;

		// Find operation with "Create" Stereotype
		for (int i = 0; i < context.getOwnedOperations().size() && createdOp == null; i++) {
			Operation cddOperation = context.getOwnedOperations().get(i);
			for (int j = 0; j < cddOperation.getAppliedStereotypes().size(); j++) {
				Stereotype createStereotype = cddOperation.getAppliedStereotypes().get(j);
				if (createStereotype.getName().equals("Create")) {
					if (cddOperation.getName().equals(context.getName())) {
						if (cddOperation.getOwnedParameters().size() == 1) {
							Parameter returnParameter = cddOperation.getOwnedParameters().get(0);
							if (returnParameter.getDirection().equals(ParameterDirectionKind.RETURN_LITERAL)) {
								if (returnParameter.getType().getName().equals(context.getName())) {
									createdOp = cddOperation;
								}
							}
						}
					}

				}
			}
		}

		// No operation with "Create" Stereotype found : => Creation of the operation.
		if (createdOp == null) {
			Stereotype appliedStereotype = null;
			if (!isStandardProfileApplied(context)) {
				PackageUtil.applyProfile(context.getModel(), standardProfile, true);
			}

			createdOp = UMLFactory.eINSTANCE.createOperation();
			context.getOwnedOperations().add(createdOp);



			for (int j = 0; j < createdOp.getApplicableStereotypes().size() && appliedStereotype == null; j++) {
				Stereotype cddStereotype = createdOp.getApplicableStereotypes().get(j);
				if (cddStereotype.getName().equals("Create")) {
					appliedStereotype = cddStereotype;
				}
			}

			Parameter result = UMLFactory.eINSTANCE.createParameter();
			result.setDirection(ParameterDirectionKind.RETURN_LITERAL);
			result.setType(context);
			result.setName("return");

			createdOp.setName(context.getName());
			createdOp.getOwnedParameters().add(result);
			createdOp.applyStereotype(appliedStereotype);
		}

		return createdOp;
	}

	/**
	 * Returns the the method activity for the context operation.
	 * If the method does not exist, it is the generated, with side effects
	 * on the given context Class (i.e., the generated method is added to the list of
	 * of owned behaviors the given context Class.)
	 * The generated method signature matches the signature of the operation
	 *
	 * @param context
	 *            A UML Class
	 * @param operation
	 * 			  A UML operation
	 * @return the method Activity of the given Operation for the given context Class
	 */
	public static Activity getMethod(Class context, Operation operation) {
		Activity method = null ;
		if (operation.getMethods().isEmpty()) {
			method = (Activity)context.createOwnedBehavior(operation.getName() + "Impl", UMLPackage.eINSTANCE.getActivity()) ;
			method.setSpecification(operation);
			for (Parameter p : operation.getOwnedParameters()) {
				Parameter pAct = method.createOwnedParameter(p.getName(), p.getType()) ;
				pAct.setDirection(p.getDirection());
				pAct.setLowerValue(pAct.getLowerValue());
				pAct.setUpperValue(p.getUpperValue());
			}
		}
		else {
			for(Iterator<Behavior> i = operation.getMethods().iterator() ; i.hasNext() && method==null ; ) {
				Behavior b = i.next() ;
				if (b instanceof Activity) {
					method = (Activity)b ;
				}
			}
		}
		return method ;
	}
	
	/**
	 * Returns true if the Standard profile is applied on the Model containing the given element
	 *
	 * @param element
	 *            A UML model element
	 * @return true if the Standard profile is applied on the Model containing the given element
	 */
	public static boolean isStandardProfileApplied(Element element) {
		if (standardProfile == null) {
			IRegisteredProfile registeredProfile = RegisteredProfile.getRegisteredProfile(STANDARD_PROFILE_NAME);
			URI modelUri = registeredProfile.getUri();
			Resource modelResource = Util.createTemporaryResourceSet().getResource(modelUri, true);
			if (modelResource.getContents().get(0) instanceof Profile) {
				standardProfile = (Profile) modelResource.getContents().get(0);
			}
		}
		List<Profile> appliedProfiles = element.getModel().getAppliedProfiles();
		return appliedProfiles.contains(standardProfile);
	}

	/**
	 * Duplicated from SequoiaAbstractHandler. @author Patrick Tessier (CEA).
	 * getSelected element in the diagram or in hte model explorer
	 *
	 * @return Element or null
	 */
	public static Element getSelection() {
		Element selectedElement = null;
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		ISelection selection = selectionService.getSelection();

		if (selection instanceof IStructuredSelection) {
			Object selectedobject = ((IStructuredSelection) selection).getFirstElement();
			if (selectedobject instanceof GraphicalEditPart) {
				Object graphicalElement = ((GraphicalEditPart) selectedobject).getModel();
				if ((graphicalElement instanceof View) && ((View) graphicalElement).getElement() instanceof org.eclipse.uml2.uml.Element) {
					selectedElement = (org.eclipse.uml2.uml.Element) ((View) graphicalElement).getElement();
				}
			} else if (selectedobject instanceof IAdaptable) {
				EObject selectedEObject = (EObject) ((IAdaptable) selectedobject).getAdapter(EObject.class);
				if (selectedEObject instanceof org.eclipse.uml2.uml.Element) {
					selectedElement = (Element) selectedEObject;
				}
			}

			return selectedElement;
		}
		return null;
	}

}
