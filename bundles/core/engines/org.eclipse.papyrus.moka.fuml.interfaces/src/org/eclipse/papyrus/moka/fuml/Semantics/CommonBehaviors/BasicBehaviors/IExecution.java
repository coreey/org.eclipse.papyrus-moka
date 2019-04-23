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

package org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Parameter;

public interface IExecution extends IObject_ {

	public void execute();

	public void setParameterValue(IParameterValue parameterValue);

	public IParameterValue getReturnParameterValue();

	public IParameterValue getParameterValue(Parameter parameter);

	public List<IParameterValue> getOutputParameterValues();

	public Behavior getBehavior();

	public void terminate();

	public void setContext(IObject_ context);

	public IObject_ getContext();

	public List<IParameterValue> getParameterValues();

}
