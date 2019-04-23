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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.papyrus.moka.discreteevent.DEScheduler;
import org.eclipse.papyrus.moka.discreteevent.Event;
import org.eclipse.papyrus.moka.discreteevent.actions.Action;
import org.eclipse.papyrus.moka.externalcontrol.advice.IControllerAdvice;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;

public abstract class AbstractExternallyControlledVisitor<T extends ISemanticVisitor> implements IExternallyControlledVisitor<T> {

	protected ExternalController controller;
	protected List<IControllerAdvice> advices = new ArrayList<>();
	
	protected T delegatedVisitor;
	
	protected List<IToken> suspendedTokens;
	
	
	protected Set<AbstractExternallyControlledVisitor<? extends ISemanticVisitor>> suspendedChildren = new HashSet<AbstractExternallyControlledVisitor<? extends ISemanticVisitor>>();
	
	
	protected ControlledVisitorStep currentState = ControlledVisitorStep.STARTING;
	
	public AbstractExternallyControlledVisitor(T visitor, ExternalController controller, List<IControllerAdvice> advices){
		delegatedVisitor = visitor;
		this.controller = controller;
		this.advices = advices;
	}
	
	protected abstract void doResumeExecution();
	
	protected abstract void doSemanticAction();
	
	
	public abstract IExternallyControlledVisitor<? extends ISemanticVisitor> getStackParent();
	
	
	@Override
	public List<IControllerAdvice> getRegisteredAdvices() {
		return advices;
	}
	
	public boolean hasSuspendedChildren(){
		return ! suspendedChildren.isEmpty();
	}

	public void addSuspendedChild(AbstractExternallyControlledVisitor<? extends ISemanticVisitor> child){
		suspendedChildren.add(child);
	}
	
	public void removeSuspendedChild(AbstractExternallyControlledVisitor<? extends ISemanticVisitor> child){
		suspendedChildren.remove(child);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void resumeExecution(){
		IExternallyControlledVisitor<? extends ISemanticVisitor> parent = getStackParent();
		if (parent instanceof AbstractExternallyControlledVisitor){
			((AbstractExternallyControlledVisitor)parent).removeSuspendedChild(this);
		}
		doResumeExecution();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void suspendForControl() {
		IExternallyControlledVisitor<? extends ISemanticVisitor> parent = getStackParent();
		if (parent instanceof AbstractExternallyControlledVisitor){
			((AbstractExternallyControlledVisitor)parent).addSuspendedChild(this);
		}
		controller.suspendForControl(this);
	}
	

	protected void suspendForTime(Double duration){
		DEScheduler.getInstance().pushEvent(new Event(duration, new Action() {
			@Override
			public void execute() {
				currentState = ControlledVisitorStep.FINISHING;
				suspendForControl();
			}
		}));
	}
	
	
	protected void doStartActions() {
		for (IControllerAdvice advice : advices ){
			advice.doStartAction();
		}
	}
	
	protected void doFinishActions() {
		for (IControllerAdvice advice : advices ){
			advice.doFinishAction();
		}
	}
	
	
	protected Double getDuration() {
		Double totalDuration= null;
		for (IControllerAdvice advice : advices ){
			Double duration= advice.getDuration();
			if (duration != null){
				if (totalDuration == null){
					totalDuration = duration;
				}else {
					totalDuration += duration;
				}
				
			}
		}
		return totalDuration;
	}
	
	private boolean canStart(){
		boolean result =true;
		Iterator<IControllerAdvice> iter = advices.iterator();
		while (iter.hasNext() && result){
			result &= iter.next().canStart();
		}
		return result;
	}
	
	private boolean canFinish(){
		boolean result =true;
		Iterator<IControllerAdvice> iter = advices.iterator();
		while (iter.hasNext() && result){
			result &= iter.next().canFinish();
		}
		return result;
	}
	
	
	@Override
	public boolean isExecutionAllowed() {
		if (hasSuspendedChildren()){
			return false;
		}
		if (currentState == ControlledVisitorStep.STARTING){
				return canStart();
		}else {
			return canFinish();
		}		
		
	}

	@Override
	public void doExecute() {
		if (currentState == ControlledVisitorStep.STARTING){
			doStart();
		}else{
			doFinish();
		}	
	}
	
	
	
	private void doFinish() {
		doFinishActions();		
		//we reset current state
		currentState = ControlledVisitorStep.STARTING;
		resumeExecution();
	}

	private void doStart() {
		doStartActions();
		//we do the semantic action if any
		doSemanticAction();
		currentState = ControlledVisitorStep.FINISHING;

		Double duration = getDuration();
		if (duration != null){
			suspendForTime(duration);
			return;
		}
		if (! hasSuspendedChildren()&& canFinish()){
			doFinish();
		}else {
			suspendForControl();
		}
		

	}

	@Override
	public void setController(ExternalController controller) {
		this.controller = controller;

	}

	@Override
	public ExternalController getController() {
		return this.controller;
	}
	
	@Override
	public void registerAdvice(IControllerAdvice advice) {
		advices.add(advice);
	}

	
	@Override
	public T getDelegatedVisitor() {
		return delegatedVisitor;
	}
	
	@Override
	public ControlledVisitorStep getState() {
		return currentState;
	}

	

}
