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

package org.eclipse.papyrus.moka.fuml.actions;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventOccurrence;

public interface IAcceptEventActionActivation extends IActionActivation {

	public void accept(IEventOccurrence eventOccurrence);

	public Boolean match(IEventOccurrence eventOccurrence);

	public IAcceptEventActionEventAccepter getEventAccepter();

}
