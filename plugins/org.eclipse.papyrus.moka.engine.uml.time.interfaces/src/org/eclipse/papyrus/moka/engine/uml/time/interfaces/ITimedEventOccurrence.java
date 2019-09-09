/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Jeremie Tatibouet (CEA LIST)
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.engine.uml.time.interfaces;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IRealValue;

public interface ITimedEventOccurrence extends IEventOccurrence{

	public void setReferenceInstant(double instant);
	
	public IRealValue getReferenceInstance();
	
	public void setOccurrenceInstant(double instant);
	
	public IRealValue getOccurrenceInstant();
	
}
