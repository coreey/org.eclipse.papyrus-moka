/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.CommonBehavior.SM_ObjectActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IRegionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateMachineConfiguration;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateMachineExecution;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IVertexActivation;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Vertex;

/**
 * Visitor class used to execute a state-machine
 */
public class StateMachineExecution extends Execution implements IStateMachineExecution {

	/**
	 * List of visitors associated to regions owned by the state-machine
	 */
	protected List<IRegionActivation> regionActivation;
	
	/**
	 * The current "state" of state-machine 
	 */
	protected IStateMachineConfiguration configuration;
	
	public StateMachineExecution(){
		super();
		this.regionActivation = new ArrayList<IRegionActivation>();
		this.configuration = new StateMachineConfiguration(this);
	}
	
	public IStateMachineConfiguration getConfiguration(){
		return this.configuration;
	}
	
	public StateMachineExecution(IObject_ context){
		super();
		this.context = context;
		this.regionActivation = new ArrayList<IRegionActivation>();
		this.configuration = new StateMachineConfiguration(this);
	}
	
	protected void initRegions(){
		StateMachine machine = null;
		if(!this.getTypes().isEmpty()){
			machine = (StateMachine) this.getTypes().get(0);
		}
		if(machine!=null){
			for(Region region: machine.getRegions()){
				RegionActivation activation = (RegionActivation) this.locus.getFactory().instantiateVisitor(region);
				activation.setParent(this);
				activation.setNode(region);
				this.regionActivation.add(activation);
			}
		}
	}
	
	/**
	 * Search the corresponding visitor in the hierarchy owned by this
	 * StateMachineExecution
	 * @param vertex - the vertex for which an activation is searched
	 * @return vertexActivation - the corresponding activation
	 */
	public IVertexActivation getVertexActivation(Vertex vertex){
		int i = 0;
		IVertexActivation vertexActivation = null;
		while(vertexActivation==null && i < this.regionActivation.size()){
			 vertexActivation = this.regionActivation.get(i).getVertexActivation(vertex);
			 i++;
		}
		return vertexActivation;
	}
	
	public void execute() {
		// The execution of state-machine is realized as described below
		// 1 - An event accepter is placed in the list of waiting event accepters for this state-machine
		// 2 - All visitors required to interpret the state-machine are instantiated and link together
		// 3 - All top level regions (i.e. those directly owned by the executed state-machine) are entered
		//     concurrently. Since they are top regions then there is no transition used to enter them
		// Note: a state-machine always has at runtime a single event accepter
		if(this.context!=null && this.context.getObjectActivation()!=null){
			this.context.register(new StateMachineEventAccepter(this));
		}
		this.initRegions();
		for(IRegionActivation activation: this.regionActivation){
			activation.activate();
		}
		for(IRegionActivation activation: this.regionActivation){
			activation.activateTransitions();
		}
		for(IRegionActivation regionActivation: this.regionActivation){
			regionActivation.enter(null, null);
		}
	}

	public IValue new_() {
		if(this.context!=null){
			return new StateMachineExecution(this.context);
		}
		return new StateMachineExecution();
	}
	
	public List<IRegionActivation> getRegionActivation() {
		return regionActivation;
	}
	
	public void startBehavior(Class classifier, List<IParameterValue> inputs) {
		// The behavior captured here is almost identical to the one provide by Object_.
		// Instead of using a simple ObjectActivation we use a StateMachineObjectActivation.
		// This specialized kind of ObjectActivation allows the registering of completion events.
		if (this.objectActivation == null) {
			this.objectActivation = new SM_ObjectActivation();
			this.objectActivation.setObject(this);
		}
		this.objectActivation.startBehavior(classifier, inputs);
	}
	
	public void terminate() {
		// The termination of a state-machine consists in aborting all "ongoing" doActivity behaviors
		// started by states owned by this state-machine. States that are currently active (i.e., registered
		// in the state-machine configuration) are not exited (i.e., if they have have exit behaviors then
		// these behaviors are not executed.
		for(int i=0; i < this.regionActivation.size(); i++){
			this.regionActivation.get(i).terminate();
		}
		this.regionActivation.clear();
	}
}
