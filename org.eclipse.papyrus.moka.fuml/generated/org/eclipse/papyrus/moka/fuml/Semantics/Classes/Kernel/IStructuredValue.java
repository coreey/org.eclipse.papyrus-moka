/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.FeatureValue;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.StructuralFeature;

public interface IStructuredValue extends IValue {
	
	public void addFeatureValues(List<FeatureValue> oldFeatureValues);
	
	public void addFeatureValuesForType(Classifier type, List<FeatureValue> oldFeatureValues);
	
	public void createFeatureValues();
	
	public List<FeatureValue> getMemberValues();
	
	public List<IValue> getValues(NamedElement feature, List<FeatureValue> featureValues);
	
	public FeatureValue getFeatureValue(StructuralFeature feature);
	
	public void setFeatureValue(StructuralFeature feature, List<IValue> values, Integer position);
	
	public List<FeatureValue> getFeatureValues();
	
	public void setFeatureValues(List<FeatureValue> featureValues);
}
