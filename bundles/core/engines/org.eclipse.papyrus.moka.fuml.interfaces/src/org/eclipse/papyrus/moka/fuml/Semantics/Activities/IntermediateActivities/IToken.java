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

package org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;

public interface IToken {

	public IToken transfer(IActivityNodeActivation holder);

	public void withdraw();

	public abstract Boolean equals(IToken other);

	public abstract IToken copy();

	public Boolean isWithdrawn();

	public Boolean isControl();

	public abstract IValue getValue();

	public void setHolder(IActivityNodeActivation holder);

	public IActivityNodeActivation getHolder();
}
