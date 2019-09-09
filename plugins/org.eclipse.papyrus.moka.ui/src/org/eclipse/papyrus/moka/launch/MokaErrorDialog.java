package org.eclipse.papyrus.moka.launch;

import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.papyrus.moka.ui.MokaUIActivator;

import static org.eclipse.papyrus.moka.ui.MokaUIActivator.MOKA_ICON_ID;

import org.eclipse.core.runtime.IStatus;

public class MokaErrorDialog extends ErrorDialog {

	public MokaErrorDialog(Shell parentShell, String dialogTitle, String message, IStatus status, int displayMask) {
		super(parentShell, dialogTitle, message, status, displayMask);
	}

	private static Image getTitleImage() {
		ImageDescriptor desc = MokaUIActivator.getDefault().getImageRegistry().getDescriptor(MOKA_ICON_ID);
		if (desc != null) {
			return desc.createImage();
		}
		return null;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setImage(getTitleImage());
	}

}
