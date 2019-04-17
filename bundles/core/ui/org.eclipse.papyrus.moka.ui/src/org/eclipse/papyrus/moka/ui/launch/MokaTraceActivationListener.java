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
