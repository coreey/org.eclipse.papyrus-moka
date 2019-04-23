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

package org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.uml2.uml.Class;

public interface IClassifierBehaviorInvocationEventAccepter extends IEventAccepter {

	public void invokeBehavior(Class classifier, List<IParameterValue> inputs);

	public void terminate();

	public void setObjectActivation(IObjectActivation objectActivation);

	public void setExecution(IExecution execution);

	public IExecution getExecution();

	public Class getExecutedClassifier();
	
	public void setClassifier(Class classifier);
}
