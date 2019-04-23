/*****************************************************************************
 * 
 * Copyright (c) 2017 CEA LIST.
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
package org.eclipse.papyrus.moka.externalcontrol.semantics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_DefaultConstructStrategy;
import org.eclipse.papyrus.moka.externalcontrol.advice.IControllerAdvice;
import org.eclipse.papyrus.moka.externalcontrol.advice.IControllerAdviceFactory;
import org.eclipse.papyrus.moka.externalcontrol.controller.ExternalController;
import org.eclipse.papyrus.moka.externalcontrol.controller.IExternallyControlledVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.IExecutionFactory;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.CallActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ActivityExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.ExecutionFactory;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallAction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.ValueSpecification;
/**
 * @author sr246418
 *
 */
public class ExternalControlExecutionFactory extends ExecutionFactory {

	IExecutionFactory delegatedExecutionFactory;
	ExternalController controller;
	List<IControllerAdviceFactory> adviceFactories = new ArrayList<>();
	

	public ExternalControlExecutionFactory(IExecutionFactory delegatedExecutionFactory, ExternalController controller, IControllerAdviceFactory... adviceFactories) {
		init(delegatedExecutionFactory, controller, Arrays.asList(adviceFactories));
	}

	public ExternalControlExecutionFactory(IExecutionFactory delegatedExecutionFactory, ExternalController controller, List<IControllerAdviceFactory> adviceFactories) {
		init(delegatedExecutionFactory, controller, adviceFactories);
	}


	private void init(IExecutionFactory delegatedExecutionFactory, ExternalController controller, List<IControllerAdviceFactory> adviceFactories) {
		if (delegatedExecutionFactory == null) {
			throw new RuntimeException("Delegated Execution Factory can't be null");
		}
		this.delegatedExecutionFactory = delegatedExecutionFactory;

		if (controller == null) {
			throw new RuntimeException("The external controller can't be null");
		}
		this.controller = controller;

		for (IControllerAdviceFactory adviceFactory : adviceFactories) {
			this.adviceFactories.add(adviceFactory);
		}

	}

	@Override
	public ISemanticVisitor instantiateVisitor(Element element) {
		
		
		ISemanticVisitor delegatedVisitor = delegatedExecutionFactory.instantiateVisitor(element);
		
		IExternallyControlledVisitor<? extends ISemanticVisitor> controlledVisitor= null;
		
		List<IControllerAdvice> adviceList = getControllerAdvices(element, delegatedVisitor);
		if(delegatedVisitor instanceof ActivityExecution){
			
			controlledVisitor= new ExternallyControlledActivityExecution((ActivityExecution)delegatedVisitor, controller, adviceList);
		}else if (delegatedVisitor instanceof CallActionActivation && isNotInLoopNodeTest(element)) {
			controlledVisitor= new ExternallyControlledCallActionActivation((CallActionActivation) delegatedVisitor, controller, adviceList);
		}

		
		if (!adviceList.isEmpty()&& controlledVisitor == null) {
			if (delegatedVisitor instanceof ActivityEdgeInstance) {
				controlledVisitor= new ExternallyControlledActivityEdgeInstance((IActivityEdgeInstance) delegatedVisitor, controller, adviceList);

			} else if (delegatedVisitor instanceof ActionActivation) {
				controlledVisitor= new ExternallyControlledActionActivation((ActionActivation) delegatedVisitor, controller, adviceList);
			}
		}

		if (controlledVisitor != null) {
			for (IControllerAdvice advice : adviceList) {
				advice.setControlledVisitor(controlledVisitor);
			}
			
			return  controlledVisitor;
		}
		
		
		return delegatedVisitor;
	}


	private boolean isNotInLoopNodeTest(Element element) {
		//LoopNode test is not allowed to be suspended currently
		if (element instanceof CallAction) {
			CallAction action = (CallAction)element;
			if (action.getInStructuredNode() instanceof LoopNode) {
				LoopNode loopNode = (LoopNode) action.getInStructuredNode();
				return  (!loopNode.getTests().contains(action));
			}
		
		}
		return true;
	}

	
	
	private List<IControllerAdvice> getControllerAdvices(Element element, ISemanticVisitor delegatedVisitor) {
		List<IControllerAdvice> adviceList = new ArrayList<>();
		for (IControllerAdviceFactory factory : adviceFactories) {
			IControllerAdvice advice = factory.getControllerAdvice(element, delegatedVisitor);
			if (advice != null) {
				adviceList.add(advice);
			}
		}
		return adviceList;
	}


	
	@Override
	public IEvaluation createEvaluation(ValueSpecification specification) {
		return this.delegatedExecutionFactory.createEvaluation(specification);
	}
	
	@Override
	public IExecution createExecution(Behavior behavior, IObject_ context) {
		return this.delegatedExecutionFactory.createExecution(behavior, context);
	}
	
	@Override
	public void setLocus(ILocus locus) {
		super.setLocus(locus);
		delegatedExecutionFactory.setLocus(locus);
	}

}
