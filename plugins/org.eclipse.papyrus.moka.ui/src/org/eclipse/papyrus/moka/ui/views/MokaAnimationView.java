/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.moka.ui.views;


import org.eclipse.papyrus.moka.utils.constants.MokaConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;


/**
 * A view which enables to control:
 * - Automatic animation,
 * - Automatic diagram opening during automatic animation
 * - Delay between two animation steps
 */

public class MokaAnimationView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.eclipse.papyrus.moka.ui.views.MokaAnimationView";

	/**
	 * The constructor.
	 */
	public MokaAnimationView() {
		// Do nothing
	}

	/**
	 * Creates the view and initializes it.
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite self = new Composite(parent, SWT.BORDER);

		// A Composite needs a layout
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 5;
		gridLayout.marginHeight = 5;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		self.setLayout(gridLayout);

		// Self has a layout. We can put objects inside.
		final Button autoAnimButton = new Button(self, SWT.CHECK);
		GridData autoAnimGridData = new GridData();
		autoAnimGridData.horizontalSpan = 2;
		autoAnimButton.setLayoutData(autoAnimGridData);
		autoAnimButton.setText("Animate");
		autoAnimButton.setSelection(MokaConstants.MOKA_AUTOMATIC_ANIMATION);

		final Button autoOpenButton = new Button(self, SWT.CHECK);
		GridData autoOpenGridData = new GridData();
		autoOpenGridData.horizontalSpan = 2;
		autoOpenButton.setLayoutData(autoOpenGridData);
		autoOpenButton.setText("Open diagrams automatically");
		autoOpenButton.setSelection(MokaConstants.MOKA_OPEN_DIAGRAM_IN_AUTOMATIC_ANIMATION);
		autoOpenButton.setEnabled(MokaConstants.MOKA_AUTOMATIC_ANIMATION);

		final Slider animationDelaySlider = new Slider(self, SWT.HORIZONTAL);
		final Label sliderLabel = new Label(self, SWT.NONE);
		sliderLabel.setText("Animation delay: " + MokaConstants.MOKA_ANIMATION_DELAY + " ms ");
		animationDelaySlider.setEnabled(MokaConstants.MOKA_AUTOMATIC_ANIMATION);
		animationDelaySlider.setValues(MokaConstants.MOKA_ANIMATION_DELAY /* selection */, 0 /* minimum */, 500 /* maximum */, 25 /* thumb */, 5 /* increment */, 50 /* pageIncrement */);

		autoAnimButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				MokaConstants.MOKA_AUTOMATIC_ANIMATION = autoAnimButton.getSelection();
				autoOpenButton.setEnabled(MokaConstants.MOKA_AUTOMATIC_ANIMATION);
				animationDelaySlider.setEnabled(MokaConstants.MOKA_AUTOMATIC_ANIMATION);
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// Nothing special
			}
		});

		autoOpenButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				MokaConstants.MOKA_OPEN_DIAGRAM_IN_AUTOMATIC_ANIMATION = autoOpenButton.getSelection();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// Nothing special
			}
		});

		animationDelaySlider.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				MokaConstants.MOKA_ANIMATION_DELAY = animationDelaySlider.getSelection();
				sliderLabel.setText("Animation delay: " + MokaConstants.MOKA_ANIMATION_DELAY + " ms ");
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// Nothing special
			}
		});

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(self, "org.eclipse.papyrus.moka.ui.viewer");
	}



	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		// Do nothing
	}
}
