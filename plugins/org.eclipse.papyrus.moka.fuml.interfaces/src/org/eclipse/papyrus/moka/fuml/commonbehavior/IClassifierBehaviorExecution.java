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

package org.eclipse.papyrus.moka.fuml.commonbehavior;

import java.util.List;

import org.eclipse.uml2.uml.Class;

public interface IClassifierBehaviorExecution {

	public void execute(Class classifier, List<IParameterValue> inputs);

	public void terminate();

	public IExecution getExecution();
}
