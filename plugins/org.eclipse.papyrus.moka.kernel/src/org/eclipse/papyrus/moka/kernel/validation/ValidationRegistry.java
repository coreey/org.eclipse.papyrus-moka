/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
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

package org.eclipse.papyrus.moka.kernel.validation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

public class ValidationRegistry {

	/**
	 * Validation extension point id
	 */
	protected final static String MOKA_VALIDATION_EXTENSION_POINT_ID = "org.eclipse.papyrus.moka.kernel.validation";

	/**
	 * Validation extension point category child
	 */
	protected final static String VALIDATION_MAIN_CHILD = "validation";

	/**
	 * Validation extension point category child
	 */
	protected final static String VALIDATION_CATEGORY_CHILD = "category";

	/**
	 * Validation extension point excludeConstraint child
	 */
	protected final static String VALIDATION_CONTEXT_CHILD = "context";

	/**
	 * Validation extension point excludeConstraint child
	 */
	protected final static String VALIDATION_EXCLUDE_CONSTRAINT_CHILD = "excludeConstraint";

	/**
	 * Validation extension point excludeConstraint child
	 */
	protected final static String VALIDATION_EXCLUDE_CATEGORY_CHILD = "excludeCategory";

	/**
	 * Validation category id property name
	 */
	protected final static String VALIDATION_CATEGORY_ID_ATTRIBUTE = "categoryID";

	/**
	 * Validation extension point category child
	 */
	protected final static String VALIDATION_CONTEXT_ID_ATTRIBUTE = "engineID";

	/**
	 * Validation extension point category child
	 */
	protected final static String VALIDATION_EXCLUDE_CONSTRAINT_ID_ATTRIBUTE = "constraintID";

	/**
	 * Map associating engine ID to the ValidationRule
	 */
	protected Map<String, Set<ValidationDescriptor>> registry;

	/**
	 * The service registry is a singleton
	 */
	private static ValidationRegistry INSTANCE;

	private ValidationRegistry() {
		this.registry = new HashMap<String, Set<ValidationDescriptor>>();
		loadValidations();
	}

	public static ValidationRegistry getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ValidationRegistry();
		}
		return INSTANCE;
	}

	protected void loadValidations() {
		// Instantiate registered validation extension point
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] configurations = registry
				.getConfigurationElementsFor(MOKA_VALIDATION_EXTENSION_POINT_ID);
		for (int i = 0; i < configurations.length; i++) {
			IConfigurationElement config = configurations[i];
			IConfigurationElement[] contexts = config.getChildren(VALIDATION_CONTEXT_CHILD);
			IConfigurationElement[] categories = config.getChildren(VALIDATION_CATEGORY_CHILD);
			for (int j = 0; j < categories.length; j++) {
				String category = categories[j].getAttribute(VALIDATION_CATEGORY_ID_ATTRIBUTE); 
				ValidationDescriptor validationDescriptor = new ValidationDescriptor(category);
				IConfigurationElement[] excludeConstraints = categories[j].getChildren(VALIDATION_EXCLUDE_CONSTRAINT_CHILD);
				for (int k = 0; k < excludeConstraints.length; k++) {
					String constraint = excludeConstraints[k].getAttribute(VALIDATION_EXCLUDE_CONSTRAINT_ID_ATTRIBUTE);
					validationDescriptor.addExcludedConstraint(constraint);
				}
				IConfigurationElement[] excludeCategories = categories[j].getChildren(VALIDATION_EXCLUDE_CATEGORY_CHILD);
				for (int k = 0; k < excludeCategories.length; k++) {
					String excludeCategory = excludeCategories[k].getAttribute(VALIDATION_CATEGORY_ID_ATTRIBUTE);	
					validationDescriptor.addExcludedCategory(excludeCategory);
				}
				
				for (int k = 0; k < contexts.length; k++) {
					String contextID = contexts[k].getAttribute(VALIDATION_CONTEXT_ID_ATTRIBUTE);
					addToRegistry(contextID, validationDescriptor);
				}
			}
		}
	}
	
	public Set<ValidationDescriptor> getValidationDescriptors(String engineID) {
		return registry.get(engineID);
	}

	private void addToRegistry(String contextID, ValidationDescriptor validationDescriptor) {
		Set<ValidationDescriptor> descriptors = registry.get(contextID);
		if(registry.get(contextID) == null) {
			descriptors = new HashSet<ValidationDescriptor>();
			descriptors.add(validationDescriptor);
			registry.put(contextID, descriptors);
		} else {
			descriptors.add(validationDescriptor);
		}
	}

	public void clear() {
		registry.clear();
	}

}
