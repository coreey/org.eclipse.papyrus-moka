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
package org.eclipse.papyrus.moka.externalcontrol.controller;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;

public class ExternalController {

	protected IControlledVisitorPushPullStrategy pushPullStrategy;

	public ExternalController(IControlledVisitorPushPullStrategy strategy) {
		this.pushPullStrategy = strategy;
	}

	public void suspendForControl(IExternallyControlledVisitor<? extends ISemanticVisitor> controlledVisitor) {
		pushPullStrategy.pushVisitor(controlledVisitor);
	}

	public void step() {
		// this is the responsibility of the pushPullStrategy to provide only visitors
		// that can execute
		IExternallyControlledVisitor<? extends ISemanticVisitor> visitor = pushPullStrategy.pullEnabledVisitor();
		// we perform a first loop on all visitors that can execute now
		while (visitor != null) {
			visitor.doExecute();
			visitor = pushPullStrategy.pullEnabledVisitor();
		}
	}

	public boolean hasEnabledVisitors() {
		return pushPullStrategy.hasEnabledVisitors();
	}

}
