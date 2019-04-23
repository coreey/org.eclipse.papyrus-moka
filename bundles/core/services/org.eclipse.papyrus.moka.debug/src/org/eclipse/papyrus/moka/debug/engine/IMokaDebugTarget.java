/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
package org.eclipse.papyrus.moka.debug.engine;

import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;

public interface IMokaDebugTarget extends IDebugTarget {

	public boolean isNewThread(IObject_ object);

	public void registerThread(IObject_ object);

	public void unregisterThread(IObject_ object);

	public boolean isSuspensionRequired(IObject_ object, ISemanticVisitor nodeVisitor);

	public void suspend(IObject_ object, ISemanticVisitor visitor);

	public void update(IObject_ object, ISemanticVisitor visitor);

	public boolean hasSuspendedThread();

}
