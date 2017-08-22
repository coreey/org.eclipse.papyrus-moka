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
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IObjectActivation;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;

public interface IObject_ extends IExtensionalValue {

	public void addType(Class type);

	public void removeType(Class type);

	public void startBehavior(Class classifier, List<IParameterValue> inputs);

	public IExecution dispatch(Operation operation);

	public void send(IEventOccurrence eventOccurrence);

	public void register(IEventAccepter accepter);

	public void unregister(IEventAccepter accepter);

	public IObjectActivation getObjectActivation();

	public void setObjectActivation(IObjectActivation objectActivation);
}
