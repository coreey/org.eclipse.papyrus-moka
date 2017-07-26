/*****************************************************************************
 * 
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.table.instancespecification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.moka.ui.table.instancespecification.util.InstanceSpecificationTableUtil;
import org.eclipse.papyrus.uml.nattable.manager.axis.AbstractUMLSynchronizedOnFeatureAxisManager;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.UMLPackage;

public class InstanceSpecificationRowAxisManager extends AbstractUMLSynchronizedOnFeatureAxisManager {

	private Map<Slot, String> slotToNameMap = null;

	@Override
	protected List<Object> getFeaturesValue() {

		updateSlotToNameMap();
		List<Object> featureValue = new ArrayList<Object>();

		List<String> names = new ArrayList<>();
		names.addAll(slotToNameMap.values());
		Collections.sort(names);
		Map<String, Slot> invertedMap = new HashMap<>();
		for (Map.Entry<Slot, String> entry : slotToNameMap.entrySet()) {
			invertedMap.put(entry.getValue(), entry.getKey());
		}
		
		
		for (String sortedName : names) {
			featureValue.add(invertedMap.get(sortedName));
		
		}
		
		return featureValue;
	}


	@Override
	protected Collection<EStructuralFeature> getListenFeatures() {
		Collection<EStructuralFeature> listenedFeatures = super.getListenFeatures();
		listenedFeatures.add(UMLPackage.eINSTANCE.getSlot_Value());
		return listenedFeatures;
	}

	
	
	public Map<Slot, String> getSlotToNameMap() {
		updateSlotToNameMap();
		
		return slotToNameMap;
	}

	private void updateSlotToNameMap() {
		if (this.getTableContext() instanceof InstanceSpecification) {
			InstanceSpecification contextInstance = (InstanceSpecification) this.getTableContext();
			slotToNameMap = InstanceSpecificationTableUtil.collectSlotsAndNames(contextInstance);
		}

	}

}
