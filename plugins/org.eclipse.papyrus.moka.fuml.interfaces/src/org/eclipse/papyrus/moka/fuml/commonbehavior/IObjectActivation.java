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

import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.uml2.uml.Class;

public interface IObjectActivation {

	public void stop();

	public void register(IEventAccepter accepter);

	public void unregister(IEventAccepter accepter);

	public void dispatchNextEvent();

	public IEventOccurrence getNextEvent();

	public void send(IEventOccurrence eventOccurrence);
	
	public void notifyEventArrival();

	public void startBehavior(Class classifier, List<IParameterValue> inputs);

	public void setObject(IObject_ context);

	public IObject_ getObject();

	public List<IClassifierBehaviorInvocationEventAccepter> getClassifierBehaviorInvocations();

	public List<IEventOccurrence> getEvents();

	public void _startObjectBehavior();

	public List<IEventAccepter> getWaitingEventAccepters();
}
