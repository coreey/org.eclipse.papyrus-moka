/*****************************************************************************
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
 *****************************************************************************/

package org.eclipse.papyrus.moka.debug.model.data.mapping.variables;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.DefaultValueAdapter;
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.MokaValueAdapterFactory;
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.MokaValueAdapterList;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IStructuredValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.VisibilityKind;

public class FeatureValueVariableAdapter extends MokaVariableAdapter<IFeatureValue> {

	// The owner of the adapted variable
	protected IStructuredValue featureValueOwner;

	public FeatureValueVariableAdapter(MokaDebugTarget debugTarget, IStructuredValue owner,
			IFeatureValue featureValue) {
		super(debugTarget, featureValue);
		this.featureValueOwner = owner;
	}

	@Override
	public org.eclipse.debug.core.model.IValue getValue() throws DebugException {
		// Build the value adapter for the adapted feature value. This adapter can be single
		// value adapter or a list of value adapter depending if the feature value has a single
		// value or multiple values. If no value is found for the feature then the default value
		// adapter is returned.
		if (this.value == null) {
			List<IValue> resultValues = this.getValues();
			if(resultValues.size() == 1) {
				this.value = MokaValueAdapterFactory.getInstance().instantiate(resultValues.iterator().next(), this.debugTarget);
			} else if(resultValues.size() > 1) {
				MokaValueAdapterList adapterList = new MokaValueAdapterList(this.debugTarget);
				for(IValue currentValue : resultValues) {
					adapterList.add(currentValue);
				}
				this.value = adapterList;
			} else {
				this.value = new DefaultValueAdapter(this.debugTarget, null);
			}
		}
		return this.value;
	}

	@Override
	public String getName() throws DebugException {
		// The name of the variable is the name of the feature. If no
		// feature can be accessed then '<unamed feature>' is returned.
		Feature feature = this.adaptedVariable.getFeature();
		if (feature != null) {
			return feature.getName();
		}
		return "<unamed feature>";
	}

	public boolean isFeaturePublic() {
		// Determine if the value adapter is for public feature
		if (this.adaptedVariable != null) {
			return this.adaptedVariable.getFeature().getVisibility() == VisibilityKind.PUBLIC_LITERAL;
		}
		return false;
	}

	public boolean isFeatureProtected() {
		// Determine if the value adapter is for protected feature
		if (this.adaptedVariable != null) {
			return this.adaptedVariable.getFeature().getVisibility() == VisibilityKind.PROTECTED_LITERAL;
		}
		return false;
	}

	public boolean isFeaturePrivate() {
		// Determine if the value adapter is for private feature
		if (this.adaptedVariable != null) {
			return this.adaptedVariable.getFeature().getVisibility() == VisibilityKind.PRIVATE_LITERAL;
		}
		return false;
	}

	protected List<IValue> getValues() {
		// Return the values associated to the feature. These values shall
		// be adapted in order to be accessed and displayed in the variables
		// view associated to a debug perspective.
		List<IValue> resultValues = null;
		Association association = null;
		StructuralFeature feature = this.adaptedVariable.getFeature();
		if (this.featureValueOwner instanceof IExtensionalValue
				&& feature instanceof Property) {
			association = ((Property) feature).getAssociation();
		}
		if (association != null) {
			List<ILink> links = this.getMatchingLinks(association, this.adaptedVariable.getFeature(),
					this.featureValueOwner, ((IExtensionalValue) this.featureValueOwner).getLocus());
			resultValues = new ArrayList<IValue>();
			for (int i = 0; i < links.size(); i++) {
				resultValues.addAll(links.get(i).getFeatureValue(this.adaptedVariable.getFeature()).getValues());
			}
		} else {
			resultValues = this.adaptedVariable.getValues();
		}
		return resultValues;
	}

	protected List<ILink> getMatchingLinks(Association association, StructuralFeature end, IValue oppositeValue,
			ILocus locus) {
		return this.getMatchingLinksForEndValue(association, end, oppositeValue, null, locus);
	}

	private List<ILink> getMatchingLinksForEndValue(Association association, StructuralFeature end,
			IValue oppositeValue, IValue endValue, ILocus locus) {
		Property oppositeEnd = this.getOppositeEnd(association, end);
		List<IExtensionalValue> extent = locus.getExtent(association);
		List<ILink> links = new ArrayList<ILink>();
		for (int i = 0; i < extent.size(); i++) {
			IExtensionalValue link = extent.get(i);
			IValue value = link.getFeatureValue(oppositeEnd).getValues().get(0);
			if (value instanceof IReference) {
				value = ((IReference) value).getReferent();
			}
			if (value.equals(oppositeValue)) {
				boolean matches = true;
				if (endValue != null) {
					matches = link.getFeatureValue(end).getValues().get(0).equals(endValue);
				}
				if (matches) {
					if (!end.isOrdered() | links.size() == 0) {
						links.add((ILink) link);
					} else {
						int n = link.getFeatureValue(end).getPosition();
						boolean continueSearching = true;
						int j = 0;
						while (continueSearching & j < links.size()) {
							j = j + 1;
							continueSearching = links.get(j - 1).getFeatureValue(end).getPosition() < n;
						}
						if (continueSearching) {
							links.add((ILink) link);
						} else {
							links.add(j - 1, (ILink) link);
						}
					}
				}
			}
		}
		return links;
	}

	private Property getOppositeEnd(Association association, StructuralFeature end) {
		// Get the end of a binary association opposite to the given end.
		Property oppositeEnd = association.getMemberEnds().get(0);
		if (oppositeEnd == end) {
			oppositeEnd = association.getMemberEnds().get(1);
		}
		return oppositeEnd;
	}

}
