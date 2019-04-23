/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
 *  CEA LIST - Initial API and implementation
 *  Jeremie Tatibouet (CEA LIST) - Apply fix for FUML12-33 Extensional values should have an unique identifier
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IObjectActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.ObjectActivation;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;

public class Object_ extends ExtensionalValue implements IObject_ {

	/*
	 * The classes under which this object is currently classified. (A destroyed
	 * object has no types.)
	 */
	public List<Class> types = new ArrayList<Class>();

	/*
	 * The object activation handling the active behavior of this object.
	 */
	public IObjectActivation objectActivation;

	public void addType(Class type) {
		this.types.add(type);
	}

	public void removeType(Class type) {
		this.types.remove(type);
	}

	public void startBehavior(Class classifier, List<IParameterValue> inputs) {
		// Create an object activation for this object (if one does not already
		// exist) and start its behavior(s).
		// Debug.println("[startBehavior] On object...");
		if (this.objectActivation == null) {
			this.objectActivation = new ObjectActivation();
			this.objectActivation.setObject(this);
		}
		// Debug.println("[startBehavior] objectActivation = " +
		// objectActivation);
		this.objectActivation.startBehavior(classifier, inputs);
	}

	public IExecution dispatch(Operation operation) {
		// Dispatch the given operation to a method execution, using a dispatch
		// strategy.
		return ((DispatchStrategy) this.locus.getFactory().getStrategy("dispatch")).dispatch(this, operation);
	}

	public void send(IEventOccurrence eventOccurrence) {
		// If the object is active, add the given event occurrence to the event
		// pool and signal that a new signal instance has arrived.
		if (this.objectActivation != null) {
			this.objectActivation.send(eventOccurrence);
		}
	}

	@Override
	public void destroy() {
		// Stop the object activation (if any), clear all types and destroy the
		// object as an extensional value.

		// Issue FUML12-33 Extensional values should have an unique identifier

		if (this.objectActivation != null) {
			this.objectActivation.stop();
			this.objectActivation = null;
		}
		this.types.clear();
		super.destroy();
	}

	public void register(IEventAccepter accepter) {
		// Register the given accept event accepter to wait for a dispatched
		// signal event.
		if (this.objectActivation != null) {
			this.objectActivation.register(accepter);
		}
	}

	public void unregister(IEventAccepter accepter) {
		// Remove the given event accepter for the list of waiting event
		// accepters.
		if (this.objectActivation != null) {
			this.objectActivation.unregister(accepter);
		}
	}

	@Override
	public IValue copy() {
		// Create a new object that is a copy of this object at the same locus
		// as this object.
		// However, the new object will NOT have any object activation (i.e, its
		// classifier behaviors will not be started).
		Object_ newObject = (Object_) (super.copy());
		List<Class> types = this.types;
		for (int i = 0; i < types.size(); i++) {
			Class type = types.get(i);
			newObject.types.add(type);
		}
		return newObject;
	}

	@Override
	public IValue new_() {
		// Create a new object with no type, feature values or locus.
		return new Object_();
	}

	@Override
	public List<Classifier> getTypes() {
		// Return the types of this object.
		List<Classifier> types = new ArrayList<Classifier>();
		List<Class> myTypes = this.types;
		for (int i = 0; i < myTypes.size(); i++) {
			Class type = myTypes.get(i);
			types.add(type);
		}
		return types;
	}
	
	@Override
	public Boolean equals(IValue otherValue) {
		// Test if this object is equal to the otherValue.
		// To be equal, the otherValue must be the same object as this object.
		return this == otherValue;
	}

	public IObjectActivation getObjectActivation() {
		return this.objectActivation;
	}

	public void setObjectActivation(IObjectActivation objectActivation) {
		this.objectActivation = objectActivation;
	}
}
