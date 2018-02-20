/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.timedfuml.interfaces.semantics.CommonBehaviors;

import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.CommonBehavior.ISM_ObjectActivation;

public interface ITimedObjectActivation extends ISM_ObjectActivation{
	
	public void register(ITimedEventOccurrence timedEventOccurrence);
	
}
