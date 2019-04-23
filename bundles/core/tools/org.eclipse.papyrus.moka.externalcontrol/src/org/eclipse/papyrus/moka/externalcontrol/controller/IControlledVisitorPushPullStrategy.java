/*****************************************************************************
 * 
 * Copyright (c) 2017 CEA LIST.
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
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.externalcontrol.controller;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;

public interface IControlledVisitorPushPullStrategy {

	public IExternallyControlledVisitor<? extends ISemanticVisitor> pullEnabledVisitor();
	public void pushVisitor(IExternallyControlledVisitor<? extends ISemanticVisitor> visitor);
	
	public boolean hasEnabledVisitors();
	
}
