/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines;

import java.util.List;

public interface IStateConfiguration {
	
	public int getLevel();
	
	public IStateConfiguration getParent();
	
	public void setParent(IStateConfiguration configuration);
	
	public IVertexActivation getVertexActivation();
	
	public List<IStateConfiguration> getChildren();
	
	public boolean addChild(IVertexActivation activation);
	
	public boolean removeChild(IVertexActivation activation);
	
	public boolean add(IVertexActivation activation, List<IVertexActivation> context);
	
	public boolean remove(IVertexActivation activation, List<IVertexActivation> context);
	
	public boolean isConfigurationFor(IVertexActivation activation);
	
	public boolean isConfigurationFor(IVertexActivation activation, List<IVertexActivation> context);
}
