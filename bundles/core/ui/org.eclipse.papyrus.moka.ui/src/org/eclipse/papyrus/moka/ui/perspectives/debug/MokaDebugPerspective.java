/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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

package org.eclipse.papyrus.moka.ui.perspectives.debug;

import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.papyrus.moka.animation.presentation.control.AnimationControlView;
import org.eclipse.papyrus.moka.ui.views.MokaAnimationView;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;

public class MokaDebugPerspective implements IPerspectiveFactory {

	public final static String ID = "org.eclipse.papyrus.moka.ui.debug.perspectives.moka.debug";
	
	private final static String USER_FEEDBACK_FOLDER = "USER_FEEDBACK_FOLDER";
	
	private final static String USER_ANIMATION_CONTROL_FOLDER = "USER_ANIMATION_CONTROL_FOLDER";
	
	private final static String DEBUG_VIEW_FOLDER = "DEBUG_VIEW_FOLDER";
	
	private final static String DEBUG_VARIABLE_FOLDER = "DEBUG_VARIABLE_FOLDER";
	
	private final static String DEBUG_OTHER_FOLDER = "DEBUG_OTHER_FOLDER";
	
	/**
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 *
	 * @param layout
	 */
	@Override
	public void createInitialLayout(IPageLayout layout) {
		this.buildProblemReport(layout);
		this.buildAnimationControl(layout);
		this.buildDebugControl(layout);
		layout.addActionSet(IDebugUIConstants.LAUNCH_ACTION_SET);
	}
	
	public void buildDebugControl(IPageLayout relative){
		IFolderLayout debugViewFolder = relative.createFolder(DEBUG_VIEW_FOLDER, IPageLayout.TOP, 0.3f, relative.getEditorArea());
		debugViewFolder.addView("org.eclipse.debug.ui.DebugView");
		IFolderLayout debugVariableFolder = relative.createFolder(DEBUG_VARIABLE_FOLDER, IPageLayout.RIGHT, 0.4f, DEBUG_VIEW_FOLDER);
		debugVariableFolder.addView("org.eclipse.debug.ui.VariableView");
		IFolderLayout debugOtherFolder = relative.createFolder(DEBUG_OTHER_FOLDER, IPageLayout.RIGHT, 0.6f, DEBUG_VARIABLE_FOLDER);
		debugOtherFolder.addView("org.eclipse.debug.ui.BreakpointView");
	}
	
	public void buildProblemReport(IPageLayout relative){
		IFolderLayout userFeedbackFolder = relative.createFolder(USER_FEEDBACK_FOLDER, IPageLayout.BOTTOM, 0.8f, relative.getEditorArea());
		userFeedbackFolder.addView(IConsoleConstants.ID_CONSOLE_VIEW);
		userFeedbackFolder.addView(IPageLayout.ID_PROBLEM_VIEW);
	}
	
	public void buildAnimationControl(IPageLayout relative){
		IFolderLayout userAnimationControlFolder = relative.createFolder(USER_ANIMATION_CONTROL_FOLDER, IPageLayout.RIGHT, 0.6f, USER_FEEDBACK_FOLDER);
		userAnimationControlFolder.addView(MokaAnimationView.ID);
		userAnimationControlFolder.addView(AnimationControlView.ID);
	}
}
