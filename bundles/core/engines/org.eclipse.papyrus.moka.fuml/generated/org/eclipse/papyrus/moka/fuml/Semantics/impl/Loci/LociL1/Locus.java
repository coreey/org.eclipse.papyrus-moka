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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.IExecutionFactory;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.IExecutor;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Object_;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;

public class Locus implements ILocus {

	/* Locus identifier (Issue fUML12-33) */
	public String identifier;

	// FIXME : To be removed
	public Behavior currentModelToBeExecuted;

	/*
	 * The executor to be used at this locus.
	 */
	public IExecutor executor;

	/*
	 * The factory to be used at this locus.
	 */
	public IExecutionFactory factory;

	/*
	 * The set of values that are members of classifier extents at this locus.
	 */
	public List<IExtensionalValue> extensionalValues = new ArrayList<IExtensionalValue>();

	public void setExecutor(IExecutor executor) {
		// Set the executor for this locus.
		this.executor = executor;
		this.executor.setLocus(this);
	}

	public void setFactory(IExecutionFactory factory) {
		// Set the factory for this locus.
		this.factory = factory;
		this.factory.setLocus(this);
	}

	public List<IExtensionalValue> getExtent(Classifier classifier) {
		// Return the set of extensional values at this locus which have the
		// given classifier as a type.
		List<IExtensionalValue> extent = new ArrayList<IExtensionalValue>();
		List<IExtensionalValue> extensionalValues = this.extensionalValues;
		for (int i = 0; i < extensionalValues.size(); i++) {
			IExtensionalValue value = extensionalValues.get(i);
			List<Classifier> types = value.getTypes();
			boolean conforms = false;
			int j = 1;
			while (!conforms & j <= types.size()) {
				conforms = this.conforms(types.get(j - 1), classifier);
				j = j + 1;
			}
			if (conforms) {
				extent.add(value);
			}
		}
		return extent;
	}

	public void add(IExtensionalValue value) {
		// Add the given extensional value to this locus
		value.setLocus(this);
		value.setIdentifier(this.makeIdentifier(value));
		this.extensionalValues.add(value);
	}

	public void remove(IExtensionalValue value) {
		// Remove the given extensional value from this locus.
		value.setLocus(null);
		boolean notFound = true;
		int i = 1;
		while (notFound & i <= this.extensionalValues.size()) {
			if (this.extensionalValues.get(i - 1) == value) {
				this.extensionalValues.remove(i - 1);
				notFound = false;
			}
			i = i + 1;
		}
	}

	public IObject_ instantiate(Class type) {
		// Instantiate the given class at this locus.
		IObject_ object = null;
		if (type instanceof Behavior) {
			object = this.factory.createExecution((Behavior) type, null);
		} else {
			object = new Object_();
			object.addType(type);
			object.createFeatureValues();
			this.add(object);
		}
		return object;
	}

	public Boolean conforms(Classifier type, Classifier classifier) {
		// Test if a type conforms to a given classifier, that is, the type is
		// equal to or a descendant of the classifier.
		boolean doesConform = false;
		if (type == classifier) {
			doesConform = true;
		} else {
			int i = 1;
			while (!doesConform & i <= type.getGenerals().size()) {
				doesConform = this.conforms(type.getGenerals().get(i - 1), classifier);
				i = i + 1;
			}
		}
		return doesConform;
	}

	public String makeIdentifier(IExtensionalValue value) {
		// Issue FUML12-33 Extensional values should have an unique identifier
		// Implementation of this method is not normative
		String prefix = "";
		boolean multipleTypes = value.getTypes().size() > 1;
		if (multipleTypes) {
			prefix += "[";
		}
		Iterator<Classifier> typeIterator = value.getTypes().iterator();
		while (typeIterator.hasNext()) {
			prefix += typeIterator.next().getName();
			if (typeIterator.hasNext()) {
				prefix += ", ";
			}
		}
		if (multipleTypes) {
			prefix += "]";
		}
		return prefix + "@" + UUID.randomUUID().toString();
	}

	public IExecutor getExecutor() {
		return this.executor;
	}

	public IExecutionFactory getFactory() {
		return this.factory;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setExecutedTarget(Behavior behavior) {
		this.currentModelToBeExecuted = behavior;
	}

	public List<IExtensionalValue> getExtensionalValues() {
		return this.extensionalValues;
	}
}
