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
package org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.uml2.uml.Trigger;

public interface IEventOccurrence {
	
	public boolean match(Trigger trigger);
	
	public boolean matchAny(List<Trigger> triggers);
	
	public abstract List<IParameterValue> getParameterValues();
	
	public void sendTo(IReference target);
	
	public void doSend();
	
	public void _startObjectBehavior();
	
	public void setTarget(IReference target);
	
	public IReference getTarget();
	
}
