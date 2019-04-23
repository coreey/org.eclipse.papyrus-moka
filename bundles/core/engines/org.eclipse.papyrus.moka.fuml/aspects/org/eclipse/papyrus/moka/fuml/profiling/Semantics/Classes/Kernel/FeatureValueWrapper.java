/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.profiling.Semantics.Classes.Kernel;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Profiling.Semantics.Kernel.Classes.IFeatureValueWrapper;
import org.eclipse.uml2.uml.StructuralFeature;

public class FeatureValueWrapper implements IFeatureValueWrapper{

	protected IFeatureValue featureValue;
	
	protected IObject_ context; 
	
	public FeatureValueWrapper(IFeatureValue featureValue, IObject_ context) {
		this.featureValue = featureValue;
		this.context = context;
	}
	
	@Override
	public void _endIsolation() {
		// Do nothing
	}

	@Override
	public void _beginIsolation() {
		// Do nothing
	}

	@Override
	public Boolean hasEqualValues(IFeatureValue other) {
		return this.featureValue.hasEqualValues(other);
	}

	@Override
	public IFeatureValue copy() {
		return this.featureValue.copy();
	}

	@Override
	public List<IValue> getValues() {
		return this.featureValue.getValues();
	}

	@Override
	public void setValues(List<IValue> values) {
		this.featureValue.setValues(values);
	}

	@Override
	public StructuralFeature getFeature() {
		return this.featureValue.getFeature();
	}

	@Override
	public void setFeature(StructuralFeature feature) {
		this.featureValue.setFeature(feature);
	}

	@Override
	public Integer getPosition() {
		return this.featureValue.getPosition();
	}

	@Override
	public void setPosition(Integer position) {
		this.featureValue.setPosition(position);
	}

	@Override
	public IObject_ getContext() {
		return this.context;
	}

}
