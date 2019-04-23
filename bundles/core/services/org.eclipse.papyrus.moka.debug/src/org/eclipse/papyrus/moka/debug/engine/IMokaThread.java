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

import org.eclipse.debug.core.model.IThread;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;

public interface IMokaThread extends IThread {

	public void setLogicalThread(IObject_ object);

	public IObject_ getLogicalThread();

	public void suspend(ISemanticVisitor visitor);

	public ISemanticVisitor getSuspensionPoint();

	public void setSuspensionPoint(ISemanticVisitor visitor);

	public boolean getSuspensionFlag();

	public void setSuspensionFlag(boolean mustSuspend);
	
	public void registered();
	
	public void unregistered();

}
