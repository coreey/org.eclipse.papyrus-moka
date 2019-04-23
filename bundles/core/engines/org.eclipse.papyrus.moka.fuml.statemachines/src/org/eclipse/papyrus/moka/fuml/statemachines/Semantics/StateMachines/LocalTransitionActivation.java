/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IRegionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateMachineExecution;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IVertexActivation;
import org.eclipse.uml2.uml.Vertex;

public class LocalTransitionActivation extends TransitionActivation {

	protected IStateActivation getContainingState(){
		// The container of a local transition is determined in the following manner:
		// 1 - If the source vertex is an entry point then the containing state is the
		//     the state that has this entry point on its edge
		// 2 - Else in the case where the source contains the target then the containing
		//	   state is the source itself. Otherwise the source is the target
		IStateActivation containingState = null; 
		if(this.vertexSourceActivation instanceof EntryPointPseudostateActivation){
			containingState = (IStateActivation) this.vertexSourceActivation.getParentVertexActivation();
		}else{
			if(this.vertexSourceActivation.getVertexActivation((Vertex)this.vertexTargetActivation.getNode())!=null){
				containingState = (IStateActivation) this.vertexSourceActivation;
			}else{
				containingState = (IStateActivation) this.vertexTargetActivation;
			}
		}
		return containingState;
	}
	
	@Override
	public void exitSource(IEventOccurrence eventOccurrence) {
		// Exiting the source state of a local transition consists in the following set of actions:
		// 1 - Check if the source state can be exited (if it cannot then do nothing)
		// 2 - If the source can be exited and this latter is an entry point then the exit
		//     of the source is trivial (i.e., it only consists in exiting the entry point)
		//   - If the source can be exited and this latter is a composite state then the top
		//     vertex that is located in the top region which contains (maybe in deep nesting)
		//     the tar get is exited. At this point, if the source is not the containing state
		//     then it is also exited
		IStateActivation containingState = this.getContainingState();
		if(this.vertexSourceActivation.isExitable(this, false)){
			if(this.vertexSourceActivation instanceof EntryPointPseudostateActivation){
				this.vertexSourceActivation.exit(this, eventOccurrence, null);
			}else{
				int i=0;
				IRegionActivation containingRegion = null; 
				while(containingRegion==null && i < containingState.getRegionActivation().size()){
					IRegionActivation regionActivation = containingState.getRegionActivation().get(i);
					if(regionActivation.getVertexActivation((Vertex)this.vertexTargetActivation.getNode())!=null){
						containingRegion = regionActivation;
					}
					i++;
				}
				if(containingRegion!=null){
					i = 0;
					IVertexActivation vertexActivationToBeExited = null;
					IExecution stateMachineExecution = this.getStateMachineExecution();
					while(vertexActivationToBeExited == null && i < containingRegion.getVertexActivations().size()){
						IVertexActivation currentActivation = containingRegion.getVertexActivations().get(i);
						if(((IStateMachineExecution)stateMachineExecution).getConfiguration().isActive(currentActivation)){
							vertexActivationToBeExited = currentActivation;
						}
						i++;
					}
					if(vertexActivationToBeExited != null){
						vertexActivationToBeExited.exit(this, eventOccurrence, null);
					}
				}
				if(this.vertexSourceActivation != containingState){
					this.vertexSourceActivation.exit(this, eventOccurrence, this.getLeastCommonAncestor());
				}
			}
		}
	}
	
	@Override
	public void enterTarget(IEventOccurrence eventOccurrence) {
		// Entering the target of local transition consists in checking if the target can be entered. If
		// this is the case then only when the target is not also the containing state it is entered 
		if(this.vertexTargetActivation.isEnterable(this, false)){	
			if(this.vertexTargetActivation != this.getContainingState()){
				this.vertexTargetActivation.enter(this, eventOccurrence, this.getLeastCommonAncestor());
			}
		}
	}
}
