/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;

public interface IReference extends IStructuredValue {

	public void startBehavior(Class classifier, List<IParameterValue> inputs);

	public IExecution dispatch(Operation operation);

	public void send(IEventOccurrence eventOccurrence);

	public void destroy();

	public void setReferent(IObject_ referent);

	public IObject_ getReferent();
}
