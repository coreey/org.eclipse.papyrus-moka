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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;

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
import org.eclipse.swt.widgets.Display;

@SuppressWarnings("restriction")
public class ValidationUtil {

	private static boolean dialogResult;

	private static Map<String, Boolean> storePreferenceValue = new HashMap<>();

	static {
		// Make sure that every constraint are load in preferences to be able to
		// deactivate none moka constraint
		ModelValidationService.getInstance().loadXmlConstraintDeclarations();
	}

	public static boolean validateModel(EngineConfiguration engineConfiguration, IProgressMonitor monitor) {
		// This method run the validation and should return true if the validation
		// should continue of false otherwise.
		// According to the validation result :
		// 1] there is no error in the model, then the simulation should continue
		// 2] there are errors in the model, then a dialog is display to show errors,
		// the user can still decide to continue the simulation :
		// 2.1] the user cancel, then the simulation is stopped
		// 2.2] the user click on the user button the validation continue
		Diagnostic diagnostic = validate(monitor, engineConfiguration.getExecutionSource().getModel());
		boolean isThereErrors = diagnostic.getChildren().stream().anyMatch(d -> d.getSeverity() == Diagnostic.ERROR);
		dialogResult = true;
		if (isThereErrors) {
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					ValidationDiagnosticDialog dialog = new ValidationDiagnosticDialog(
							Display.getCurrent().getActiveShell(), "Moka Validation",
							"The moka validation detect errors on the model. Do you  still want to launch the simulation ?",
							diagnostic, IStatus.ERROR);
					if (dialog.open() == Window.OK) {
						ValidationUtil.dialogResult = true;
					} else {
						ValidationUtil.dialogResult = false;
					}
				}
			});
		}
		return dialogResult;
	}

	protected static Diagnostic validate(IProgressMonitor progressMonitor, EObject validateElement) {
		// ValidateThe model according to moka validation rules
		// 1] disable non moka validation rules in preferences (save old preferences)
		// 2] validate
		// 3] restore validation preference
		removeNonMokaValidationRulesFromPreferences();
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

	protected static void removeNonMokaValidationRulesFromPreferences() {
		// Since we should run only moka validation then we have to modified preferences
		// to keep only moka constraints, at the same time the odl values of preferences
		// are store to be reused later
		storePreferenceValue.clear();
		SortedSet<Category> categories = CategoryManager.getInstance().getTopLevelCategories();
		Iterator<Category> categoryIter = categories.iterator();
		while (categoryIter.hasNext()) {
			Category category = (Category) categoryIter.next();
			removeNonMokaValidationRulesFromPreferences(category);
		}
	}

	protected static void removeNonMokaValidationRulesFromPreferences(Category category) {
		String categoryId = category.getId();
		if (false == categoryId.startsWith("org.eclipse.papyrus.moka")) {
			// Manage constraints
			Iterator<IConstraintDescriptor> constraintsIter = category.getConstraints().iterator();
			while (constraintsIter.hasNext()) {
				IConstraintDescriptor constraint = constraintsIter.next();
				storePreferenceValue.put(constraint.getId(),
						EMFModelValidationPreferences.isConstraintDisabled(constraint.getId()));
				EMFModelValidationPreferences.setConstraintDisabled(constraint.getId(), true);
			}
			// Manage sub categories
			Iterator<Category> categoryiesIter = category.getChildren().iterator();
			while (categoryiesIter.hasNext()) {
				Category subCategory = (Category) categoryiesIter.next();
				removeNonMokaValidationRulesFromPreferences(subCategory);
			}
		}
	}

	protected static void restoreOldPreferences() {
		// Restore stored preferences
		for (Iterator<Entry<String, Boolean>> iterator = storePreferenceValue.entrySet().iterator(); iterator
				.hasNext();) {
			Entry<String, Boolean> entry = iterator.next();
			EMFModelValidationPreferences.setConstraintDisabled(entry.getKey(), entry.getValue());
		}
	}

}
