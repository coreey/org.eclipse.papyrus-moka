/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
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
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.validation.model.Category;
import org.eclipse.emf.validation.model.CategoryManager;
import org.eclipse.emf.validation.preferences.EMFModelValidationPreferences;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.services.validation.IPapyrusDiagnostician;
import org.eclipse.papyrus.infra.services.validation.internal.ValidationRegistry;
import org.eclipse.papyrus.moka.kernel.engine.EngineConfiguration;
import org.eclipse.papyrus.moka.kernel.validation.ValidationDescriptor;
import org.eclipse.swt.widgets.Display;

import org.eclipse.uml2.uml.Element;

@SuppressWarnings("restriction")
public class ValidationUtil {

	private static boolean dialogResult;

	private static Map<String, Boolean> storePreferenceValue = new HashMap<>();

	private static Set<String> valideRules = new HashSet<>();

	static {
		// Make sure that every constraint are load in preferences to be able to
		// deactivate none moka constraint
		ModelValidationService.getInstance().loadXmlConstraintDeclarations();
	}

	public static boolean validateModel(EngineConfiguration<?> engineConfiguration, IProgressMonitor monitor,
			String engineID) {
		// This method run the validation and should return true if the simulation
		// should continue of false otherwise.
		// (from the validation result we remove rules which are mandatory according to
		// the EMF framework)
		// According to the validation result :
		// 1] there is no error in the model, then the simulation should continue
		// 2] there are errors in the model, then a dialog is display to show errors,
		// the user can still decide to continue the simulation :
		// 2.1] the user cancel, then the simulation is stopped
		// 2.2] the user click on the user button the validation continue
		Set<ValidationDescriptor> validationDescriptors = org.eclipse.papyrus.moka.kernel.validation.ValidationRegistry
				.getInstance().getValidationDescriptors(engineID);
		dialogResult = true;
		if (validationDescriptors != null) {
			Diagnostic diagnostic = validate(monitor, ((Element)engineConfiguration.getExecutionSource()).getModel(), engineID,
					validationDescriptors);
			List<Diagnostic> filteredConstraints = new ArrayList<>(diagnostic.getChildren());
			filteredConstraints = filteredConstraints.stream().filter(d -> valideRules.contains(d.getSource()))
					.collect(Collectors.toList());
			Diagnostic filteredDiagnostics = new BasicDiagnostic(diagnostic.getSource(), diagnostic.getCode(),
					filteredConstraints, diagnostic.getMessage(), diagnostic.getData().toArray());
			boolean isThereErrors = filteredDiagnostics.getChildren().stream()
					.anyMatch(d -> d.getSeverity() == Diagnostic.ERROR);
			if (isThereErrors) {
				Display.getDefault().syncExec(new Runnable() {
					@Override
					public void run() {
						ValidationDiagnosticDialog dialog = new ValidationDiagnosticDialog(
								Display.getCurrent().getActiveShell(), "Moka Validation", //$NON-NLS-1$
								"The moka validation detect errors on the model. Do you still want to launch the simulation ?", //$NON-NLS-1$
								filteredDiagnostics, IStatus.ERROR);
						if (dialog.open() == Window.OK) {
							ValidationUtil.dialogResult = true;
						} else {
							ValidationUtil.dialogResult = false;
						}
					}
				});
			}
		}
		return dialogResult;
	}

	protected static Diagnostic validate(IProgressMonitor progressMonitor, EObject validateElement, String engineID,
			Set<ValidationDescriptor> validationDescriptors) {
		// ValidateThe model according to moka validation rules
		// 1] disable non moka validation rules in preferences (save old preferences)
		// 2] validate
		// 3] restore validation preference
		clear();
		setValidationPreferencesForMokaSimulation(engineID, validationDescriptors);
		int validationSteps = 0;
		for (Iterator<?> i = validateElement.eAllContents(); i.hasNext(); i.next()) {
			++validationSteps;
		}

		progressMonitor.beginTask("Validate Model", validationSteps); //$NON-NLS-1$
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(validateElement);
		AdapterFactory adapterFactory = domain instanceof AdapterFactoryEditingDomain
				? ((AdapterFactoryEditingDomain) domain).getAdapterFactory()
				: null;
		IPapyrusDiagnostician diagnostician = ValidationRegistry.getDiagnostician(validateElement);
		diagnostician.initialize(adapterFactory, progressMonitor);

		BasicDiagnostic diagnostic = diagnostician.createDefaultDiagnostic(validateElement);
		Map<Object, Object> context = diagnostician.createDefaultContext();

		progressMonitor.setTaskName(EMFEditUIPlugin.INSTANCE.getString("_UI_Validating_message", //$NON-NLS-1$
				new Object[] { diagnostician.getObjectLabel(validateElement) }));
		diagnostician.validate(validateElement, diagnostic, context);

		if (progressMonitor.isCanceled()) {
			return null;
		}
		restoreOldPreferences();
		return diagnostic;
	}

	protected static void setValidationPreferencesForMokaSimulation(String engineID,
			Set<ValidationDescriptor> validationDescriptors) {
		// Since we should run only moka validation then we have to modified preferences
		// to keep only moka constraints, at the same time the old values of preferences
		// are store to be reused later
		SortedSet<Category> categories = CategoryManager.getInstance().getTopLevelCategories();
		Iterator<Category> categoryIter = categories.iterator();
		while (categoryIter.hasNext()) {
			Category category = (Category) categoryIter.next();
			checkCategory(category, validationDescriptors);
		}
	}

	protected static void checkCategory(Category category, Set<ValidationDescriptor> validDescriptors) {
		// Set preferences for every constraints which are not in accepted category or
		// which are excluded
		boolean categoryFound = false;
		for (Iterator<ValidationDescriptor> iterator = validDescriptors.iterator(); iterator.hasNext();) {
			ValidationDescriptor validationDescriptor = (ValidationDescriptor) iterator.next();
			if (validationDescriptor.getCategory().equals(category.getId())) { // accepted category
				for (Iterator<IConstraintDescriptor> constrainIter = category.getConstraints().iterator(); constrainIter
						.hasNext();) {
					IConstraintDescriptor constraintDescriptor = (IConstraintDescriptor) constrainIter.next();
					checkConstraint(constraintDescriptor, validationDescriptor);
				}
				// Sub category
				for (Iterator<Category> categoryIter = category.getChildren().iterator(); categoryIter.hasNext();) {
					Category subCategory = (Category) categoryIter.next();
					if (shouldExcludeSubCategory(subCategory, validationDescriptor)) {
						excludeCategory(subCategory);
					}
				}
				categoryFound = true;
			}
		}
		if (false == categoryFound) {
			excludeCategory(category);
		}
	}

	protected static boolean shouldExcludeSubCategory(Category subCategory, ValidationDescriptor validationDescriptor) {
		// Check is the category is exclude according to the validationDescriptor
		for (Iterator<String> iterator = validationDescriptor.getExcludedCategories().iterator(); iterator.hasNext();) {
			String categoryID = (String) iterator.next();
			if (categoryID.equals(subCategory.getId())) {
				return true;
			}
		}
		return false;
	}

	protected static void excludeCategory(Category category) {
		// Exclude every constraint directly or not owned by this category
		// 1] Disable every constraints
		for (Iterator<IConstraintDescriptor> constrainIter = category.getConstraints().iterator(); constrainIter
				.hasNext();) {
			IConstraintDescriptor constraintDescriptor = (IConstraintDescriptor) constrainIter.next();
			excludeConstraint(constraintDescriptor);
		}
		// 2] Exclude sub category
		for (Iterator<Category> iterator = category.getChildren().iterator(); iterator.hasNext();) {
			Category subCategory = (Category) iterator.next();
			excludeCategory(subCategory);
		}
	}

	protected static void checkConstraint(IConstraintDescriptor constraintDescriptor,
			ValidationDescriptor validationDescriptor) {
		// Set preference if the constraint is exclude in the validationDescriptor
		if (validationDescriptor.getExcludedConstrains().contains(constraintDescriptor.getId())) {
			excludeConstraint(constraintDescriptor);
		} else {
			valideRules.add(constraintDescriptor.getId());
		}
	}

	protected static void excludeConstraint(IConstraintDescriptor constraintDescriptor) {
		storePreferenceValue.put(constraintDescriptor.getId(),
				EMFModelValidationPreferences.isConstraintDisabled(constraintDescriptor.getId()));
		EMFModelValidationPreferences.setConstraintDisabled(constraintDescriptor.getId(), true);
	}

	protected static void restoreOldPreferences() {
		// Restore stored preferences
		for (Iterator<Entry<String, Boolean>> iterator = storePreferenceValue.entrySet().iterator(); iterator
				.hasNext();) {
			Entry<String, Boolean> entry = iterator.next();
			EMFModelValidationPreferences.setConstraintDisabled(entry.getKey(), entry.getValue());
		}
	}

	protected static void clear() {
		storePreferenceValue.clear();
		valideRules.clear();
	}

}
