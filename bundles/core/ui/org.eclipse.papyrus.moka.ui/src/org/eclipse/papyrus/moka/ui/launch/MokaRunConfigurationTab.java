/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class MokaRunConfigurationTab extends AbstractLaunchConfigurationTab {

	protected static String TAB_NAME = "Moka Main";

	protected Composite mainContainer;

	protected MokaProjectSelectionComponent projectSelectionComp;

	protected MokaExecutableSelectionComponent executableSelectionComp;

	protected MokaExecutionEngineSelectionComponent executionEngineSelectionComp;

	protected Image image;

	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			String init_uri = configuration.getAttribute(MokaConstants.URI_ATTRIBUTE_NAME, "");
			if (!init_uri.equals("")) {
				this.projectSelectionComp.projectSelectionText.setText(init_uri);
				String init_fragment = configuration.getAttribute(MokaConstants.FRAGMENT_ATTRIBUTE_NAME, "");
				this.executableSelectionComp.eligibleExecutableElement.selectByURIFragment(init_fragment);
			}
			String selectedExecutionEngine = configuration.getAttribute(MokaConstants.EXECUTION_ENGINE_ATTRIBUTE_NAME, "");
			if (selectedExecutionEngine != null) {
				this.executionEngineSelectionComp.eligibleExecutionEngineCombo.setText(selectedExecutionEngine);
			}
		} catch (CoreException e) {
			Activator.log.error(e);
		}
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(MokaConstants.URI_ATTRIBUTE_NAME, this.projectSelectionComp.projectSelectionText.getText());
		EObject selected = this.executableSelectionComp.eligibleExecutableElement.getSelected();
		if (selected != null) {
			configuration.setAttribute(MokaConstants.FRAGMENT_ATTRIBUTE_NAME, selected.eResource().getURIFragment(selected));
		}
		String executionEngine = this.executionEngineSelectionComp.eligibleExecutionEngineCombo.getText();
		if (executionEngine != null) {
			configuration.setAttribute(MokaConstants.EXECUTION_ENGINE_ATTRIBUTE_NAME, executionEngine);
		}
	}

	public void createControl(Composite parent) {
		/* 1. Install the components */
		this.mainContainer = new Composite(parent, SWT.FILL);
		this.mainContainer.setLayout(new GridLayout());
		this.projectSelectionComp = new MokaProjectSelectionComponent(this.mainContainer, SWT.FILL, "UML Model", 2);
		this.executableSelectionComp = new MokaExecutableSelectionComponent(this.mainContainer, SWT.FILL, "Element to be executed", 2);
		this.executionEngineSelectionComp = new MokaExecutionEngineSelectionComponent(this.mainContainer, SWT.FILL, "Execution Engine (if no selection, the default engine is used)", 2);
		/* 2. Register Listeners */
		MokaProjectSelection listener = new MokaProjectSelection(this.projectSelectionComp.projectSelectionText, this);
		MokaTriggerComboPopulation comboPopulationTrigger = new MokaTriggerComboPopulation(this.executableSelectionComp.eligibleExecutableElement);
		this.projectSelectionComp.projectSelectionButton.addSelectionListener(listener);
		this.projectSelectionComp.projectSelectionText.addModifyListener(comboPopulationTrigger);
		this.executableSelectionComp.eligibleExecutableElement.addSelectionListener(new MokaExecutableElementSelection(this));
		this.executionEngineSelectionComp.eligibleExecutionEngineCombo.addSelectionListener(new MokaExecutionEngineSelection(this));
		/* 3. Register component */
		this.setControl(this.mainContainer);
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	@Override
	public void updateLaunchConfigurationDialog() {
		super.updateLaunchConfigurationDialog();
	}

	public String getName() {
		return TAB_NAME;
	}

	@Override
	public Image getImage() {
		if (this.image == null) {
			this.image = new Image(Display.getCurrent(), getClass().getResourceAsStream("/icons/moka_icon.png"));
		}
		return this.image;
	}
}
