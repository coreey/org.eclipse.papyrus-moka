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

package org.eclipse.papyrus.moka.fuml.structuredclassifiers;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventAccepter;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IExecution;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IObjectActivation;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
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
