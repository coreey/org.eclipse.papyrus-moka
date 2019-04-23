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
package org.eclipse.papyrus.moka.externalcontrol.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.papyrus.moka.externalcontrol.util.PushPullStrategyUtil;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;

public class NodeEdgeAlternatePushPullStrategy implements IControlledVisitorPushPullStrategy {

	private List<IExternallyControlledVisitor<? extends ISemanticVisitor>> startingOthers = new ArrayList<IExternallyControlledVisitor<? extends ISemanticVisitor>>();
	private List<IExternallyControlledVisitor<? extends ISemanticVisitor>> startingActionVisitors = new ArrayList<IExternallyControlledVisitor<? extends ISemanticVisitor>>();

	private List<IExternallyControlledVisitor<? extends ISemanticVisitor>> finishingOthers = new ArrayList<IExternallyControlledVisitor<? extends ISemanticVisitor>>();
	private List<IExternallyControlledVisitor<? extends ISemanticVisitor>> finishingActionVisitors = new ArrayList<IExternallyControlledVisitor<? extends ISemanticVisitor>>();


	private boolean pullingActions = true;

	@Override
	public IExternallyControlledVisitor<? extends ISemanticVisitor> pullEnabledVisitor() {
		IExternallyControlledVisitor<? extends ISemanticVisitor> result = null;
		if (pullingActions) {
			result = pullAction();
			if (result == null) {
				pullingActions = false;
				result = pullOthers();
			}
		} else {
			result = pullOthers();
			if (result == null) {
				pullingActions = true;
				result = pullAction();
			}
		}
		return result;
	}


	private IExternallyControlledVisitor<? extends ISemanticVisitor> pullOthers() {
		IExternallyControlledVisitor<? extends ISemanticVisitor> result = PushPullStrategyUtil.pullFirstEnabledVisitor(finishingOthers);
		if (result == null) {
			result = PushPullStrategyUtil.pullFirstEnabledVisitor(startingOthers);
		}
		return result;
	}


	private IExternallyControlledVisitor<? extends ISemanticVisitor> pullAction() {
		IExternallyControlledVisitor<? extends ISemanticVisitor> result = PushPullStrategyUtil.pullFirstEnabledVisitor(finishingActionVisitors);
		if (result == null) {
			result = PushPullStrategyUtil.pullFirstEnabledVisitor(startingActionVisitors);
		}
		return result;
	}


	@Override
	public void pushVisitor(IExternallyControlledVisitor<? extends ISemanticVisitor> visitor) {
		if (visitor instanceof IActionActivation) {
			if (visitor.getState() == ControlledVisitorStep.STARTING){
				startingActionVisitors.add(visitor);
			}else {
				finishingActionVisitors.add(visitor);
			}
		} else {
			if (visitor.getState() == ControlledVisitorStep.STARTING){
				startingOthers.add(0, visitor);	
			}else {
				finishingOthers.add(0, visitor);
			}
			
		}

	}

	@Override
	public boolean hasEnabledVisitors() {
		Iterator<IExternallyControlledVisitor<? extends ISemanticVisitor>> visitorIterator = startingActionVisitors.iterator();
		while (visitorIterator.hasNext()){
			if (visitorIterator.next().isExecutionAllowed()){
				return true;
			}
		}
		
		 visitorIterator = finishingActionVisitors.iterator();
		while (visitorIterator.hasNext()){
			if (visitorIterator.next().isExecutionAllowed()){
				return true;
			}
		}
		
		visitorIterator = startingOthers.iterator();
		while (visitorIterator.hasNext()){
			if (visitorIterator.next().isExecutionAllowed()){
				return true;
			}
		}
		
		visitorIterator = finishingOthers.iterator();
		while (visitorIterator.hasNext()){
			if (visitorIterator.next().isExecutionAllowed()){
				return true;
			}
		}
		return false;
	}

	
}
