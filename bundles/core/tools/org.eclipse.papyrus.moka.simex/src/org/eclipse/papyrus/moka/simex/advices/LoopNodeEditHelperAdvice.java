/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.simex.advices;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.papyrus.moka.simex.utils.FoundationalModelLibraryUtils;
import org.eclipse.papyrus.moka.simex.utils.UMLPrimitiveTypesUtils;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecificationAction;

public class LoopNodeEditHelperAdvice extends AbstractEditHelperAdvice {

	protected Type _integer = null ;
	protected Type _boolean = null ;
	protected Behavior _lowerThan = null ; 
	protected Behavior _add = null ;

	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		LoopNode node = (LoopNode)request.getElementToConfigure() ;
		return new ConfigureElementCommand(request){
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				buildLoopNode(node) ;
				return CommandResult.newOKCommandResult(node);
			}
			
		};
	}

	protected void buildLoopNode(LoopNode node) {

		this.resolveTypes(node);

		// Set isTestedFirst to true (i.e., this is a "while" loop, not a "do while")
		node.setIsTestedFirst(true);
		
		// Creation of loop variable input pins
		/*InputPin lvi_index = */ node.createLoopVariableInput("from", _integer) ;
		/*InputPin lvi_max = */node.createLoopVariableInput("to", _integer) ;

		// Creation of loop variable pins
		OutputPin lv_index = node.createLoopVariable("indexVar", _integer) ;
		OutputPin lv_max = node.createLoopVariable("maxVar", _integer) ;

		// Creation of loop result pins
		/*OutputPin r_index = */node.createResult("indexResult", _integer) ;
		/*OutputPin r_max = */node.createResult("maxResult", _integer) ;

		// Creation of the body part
		StructuredActivityNode bodyStructuredNode = (StructuredActivityNode)node.createNode("BodyStructuredNode", UMLPackage.eINSTANCE.getStructuredActivityNode()) ;
		node.getBodyParts().add(bodyStructuredNode) ;
		// call to +
		CallBehaviorAction callToAdd = (CallBehaviorAction)node.createNode("call +", UMLPackage.eINSTANCE.getCallBehaviorAction()) ;
		node.getBodyParts().add(callToAdd) ;
		callToAdd.setBehavior(_add);
		InputPin _CallAdd_x = callToAdd.createArgument("x", _integer) ;
		InputPin _CallAdd_y = callToAdd.createArgument("y", _integer) ;
		OutputPin _CallAdd_result = callToAdd.createResult("result", _integer) ;
		// value specification for 1
		ValueSpecificationAction valueSpec1 = (ValueSpecificationAction)node.createNode("Specify 1", UMLPackage.eINSTANCE.getValueSpecificationAction()) ;
		node.getBodyParts().add(valueSpec1) ;
		LiteralInteger literal1 = (LiteralInteger)valueSpec1.createValue("1", _integer, UMLPackage.eINSTANCE.getLiteralInteger()) ;
		literal1.setValue(1);
		OutputPin _valueSpec1_result = valueSpec1.createResult("result", _integer) ;
		node.getBodyOutputs().add(_CallAdd_result) ;

		// Creation of the test part
		// call to <
		CallBehaviorAction callToLowerThan = (CallBehaviorAction)node.createNode("call <", UMLPackage.eINSTANCE.getCallBehaviorAction()) ;
		node.getTests().add(callToLowerThan) ;
		callToLowerThan.setBehavior(_lowerThan);
		InputPin _CallLower_x = callToLowerThan.createArgument("x", _integer) ;
		InputPin _CallLower_y = callToLowerThan.createArgument("y", _integer) ;
		OutputPin _CallLower_result = callToLowerThan.createResult("result", _boolean) ;
		node.setDecider(_CallLower_result) ;
		// Fork node to fork the index loop variable
		ForkNode _forkTest = (ForkNode)node.createNode("ForkTest", UMLPackage.eINSTANCE.getForkNode()) ;

		// Creation of edges
		// object flow fromIndexVarToForkNode
		ObjectFlow fromIndexVarToForkNode = (ObjectFlow)node.createEdge("fromIndexVarToForkNode", UMLPackage.eINSTANCE.getObjectFlow()) ;
		fromIndexVarToForkNode.setSource(lv_index);
		fromIndexVarToForkNode.setTarget(_forkTest);
		// object flow fromForkToCallLower_x
		ObjectFlow fromForkToCallLower_x = (ObjectFlow)node.createEdge("fromForkToCallLower_x", UMLPackage.eINSTANCE.getObjectFlow()) ;
		fromForkToCallLower_x.setSource(_forkTest);
		fromForkToCallLower_x.setTarget(_CallLower_x);
		// object flow fromMaxVarToCallLower_y
		ObjectFlow fromMaxVarToCallLower_y = (ObjectFlow)node.createEdge("fromMaxVarToCallLower_y", UMLPackage.eINSTANCE.getObjectFlow()) ;
		fromMaxVarToCallLower_y.setSource(lv_max);
		fromMaxVarToCallLower_y.setTarget(_CallLower_y);
		// object flow fromForkToCallAdd_x
		ObjectFlow fromForkToCallAdd_x = (ObjectFlow)node.createEdge("fromForkToCallAdd_x", UMLPackage.eINSTANCE.getObjectFlow()) ;
		fromForkToCallAdd_x.setSource(_forkTest);
		fromForkToCallAdd_x.setTarget(_CallAdd_x);
		// object flow fromValueSpec1ToCallAdd_y
		ObjectFlow fromValueSpec1ToCallAdd_y = (ObjectFlow)node.createEdge("fromValueSpec1ToCallAdd_y", UMLPackage.eINSTANCE.getObjectFlow()) ;
		fromValueSpec1ToCallAdd_y.setSource(_valueSpec1_result);
		fromValueSpec1ToCallAdd_y.setTarget(_CallAdd_y);
		// control flow fromStructuredBodyToCallAdd
		ControlFlow fromStructuredBodyToCallAdd = (ControlFlow)node.createEdge("fromValueSpec1ToCallAdd_y", UMLPackage.eINSTANCE.getControlFlow()) ;
		fromStructuredBodyToCallAdd.setSource(bodyStructuredNode);
		fromStructuredBodyToCallAdd.setTarget(callToAdd);

	}

	protected void resolveTypes(LoopNode node) {
		if (this._add == null) {
			this._add = FoundationalModelLibraryUtils.get_Add_Integer(node) ;
		}
		if (this._boolean == null) {
			this._boolean = UMLPrimitiveTypesUtils.getBoolean(node) ;
		}
		if (this._integer == null) {
			this._integer = UMLPrimitiveTypesUtils.getInteger(node) ;
		}
		if (this._lowerThan == null) {
			this._lowerThan = FoundationalModelLibraryUtils.get_LowerThan_Integer(node) ;
		}
	}
}


