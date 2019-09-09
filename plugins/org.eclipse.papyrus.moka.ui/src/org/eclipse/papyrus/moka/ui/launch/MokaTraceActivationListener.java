/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
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

package org.eclipse.papyrus.moka.ui.launch;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

public class MokaTraceActivationListener extends SelectionAdapter {

	MokaTraceServiceComponent traceComponent;

	protected transient MokaRunConfigurationTab launchConfigTab;

	public MokaTraceActivationListener(MokaRunConfigurationTab tab) {
		this.traceComponent = tab.traceServiceComp;
		this.launchConfigTab = tab;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		super.widgetSelected(e);
		Button checkbox = (Button) e.getSource();
		traceComponent.enableTraceWidget(checkbox.getSelection());
		this.launchConfigTab.updateLaunchConfigurationDialog();
	}

}
