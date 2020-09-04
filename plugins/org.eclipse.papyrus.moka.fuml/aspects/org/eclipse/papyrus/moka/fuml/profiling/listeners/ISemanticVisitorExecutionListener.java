/*****************************************************************************
 * Copyright (c) 2015, 2019 CEA LIST and others.
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
 *   CEA LIST - Bug 551906
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.profiling.listeners;

import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.kernel.assistant.Suspension;

public interface ISemanticVisitorExecutionListener {

	public void nodeVisited(ISemanticVisitor visitor);

	public void nodeLeft(ISemanticVisitor visitor);
	
	public void nodeSuspended(ISemanticVisitor visitor, Suspension suspension);

}
