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
package org.eclipse.papyrus.moka.ui.table.instancespecification.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

import org.eclipse.papyrus.moka.ui.table.instancespecification.Messages;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.ValueSpecification;

public class InstanceSpecificationTableUtil {

	public static final String INSTANCE_SPEC_TABLE_TYPE = "InstanceSpecificationTable";//$NON-NLS-1$
	
	public static Map<ValueSpecification, String> collectSlotsValuesAndNames(InstanceSpecification contextInstance) {

		List<InstanceSpecification> visitedInstances = new ArrayList<>();

		return collectSlotsValuesAndNames(contextInstance, visitedInstances, contextInstance.getLabel());

	}

	private static Map<ValueSpecification, String> collectSlotsValuesAndNames(InstanceSpecification contextInstance,
			List<InstanceSpecification> visitedInstances, String namePath) {

		Map<ValueSpecification, String> result = new HashMap<>();
		visitedInstances.add(contextInstance);

		for (Slot slot : contextInstance.getSlots()) {
			String slotNamePath = namePath;
			if (slot.getDefiningFeature() != null) {
				slotNamePath += "." + slot.getDefiningFeature().getLabel();
			} else {
				slotNamePath += "." + Messages.NoFeatureName;
			}

			for (int i = 0; i < slot.getValues().size(); i++) {
				ValueSpecification value = slot.getValues().get(i);
				if (slot.getValues().size() > 1) {
					slotNamePath += "[" + i + "]";
				}
				result.put(value, slotNamePath);
				if (value instanceof InstanceValue) {
					InstanceSpecification instanceSpec = ((InstanceValue) value).getInstance();
					if (instanceSpec != null && !visitedInstances.contains(instanceSpec)) {
						result.putAll(collectSlotsValuesAndNames(instanceSpec, visitedInstances, slotNamePath));
					}

				}
			}
		}

		return result;
	}

	
	
	public static Map<Slot, String> collectSlotsAndNames(InstanceSpecification contextInstance) {

		List<InstanceSpecification> visitedInstances = new ArrayList<>();

		return collectSlotsAndNames(contextInstance, visitedInstances, contextInstance.getLabel());

	}

	private static Map<Slot, String> collectSlotsAndNames(InstanceSpecification contextInstance,
			List<InstanceSpecification> visitedInstances, String namePath) {

		Map<Slot, String> result = new HashMap<>();
		visitedInstances.add(contextInstance);

		for (Slot slot : contextInstance.getSlots()) {
			String slotNamePath = namePath;
			if (slot.getDefiningFeature() != null) {
				slotNamePath += "." + slot.getDefiningFeature().getLabel();
			} else {
				slotNamePath += "." + Messages.NoFeatureName;
			}
			result.put(slot, slotNamePath);
			 
			for (int i = 0; i < slot.getValues().size(); i++) {
				ValueSpecification value = slot.getValues().get(i);
				//in case of multiple sub instance values, we flatten the sub instance tree	
				String newPath = slotNamePath;
				if (value instanceof InstanceValue) {
					if (slot.getValues().size() > 1) {
						newPath += "[" + i + "]";
					}
					InstanceSpecification instanceSpec = ((InstanceValue) value).getInstance();
					if (instanceSpec != null && !visitedInstances.contains(instanceSpec)) {
						result.putAll(collectSlotsAndNames(instanceSpec, visitedInstances, newPath));
					}

				}
			}
		}
		//normalizeNames(result);
		return result;
	}

	
	private static void normalizeNames( Map<Slot, String> map) {
		OptionalInt maxLength = map.values().stream().mapToInt(String::length).max();
		if (maxLength.isPresent()) {
			for (Map.Entry<Slot, String> entry : map.entrySet()) {
				entry.setValue(getNormalizedName(entry.getValue(), maxLength.getAsInt()));
			}
			
		}
			
		
	}

	private static String getNormalizedName(String value, int maxLength) {
		String result = value;
		for (int i=value.length(); i< maxLength; i++) {
			result+=(".");
		}
		return result;
	}

}
