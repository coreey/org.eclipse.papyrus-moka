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

package org.eclipse.papyrus.moka.fuml.Semantics.Activities.CompleteStructuredActivities;

import org.eclipse.uml2.uml.Clause;

public interface IConditionalNodeActivation extends IStructuredActivityNodeActivation {

	public void completeBody();

	public IClauseActivation getClauseActivation(Clause clause);

	public void runTest(Clause clause);

	public void selectBody(Clause clause);

}
