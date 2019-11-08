/*****************************************************************************
 * Copyright (c) 2020 CEA LIST.
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
 *  Jeremie TATIBOUET (CEA LIST) <jeremie.taibouet@cea.fr>
  *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.actions;

import java.util.Iterator;

import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.uml2.uml.RaiseExceptionAction;

public class RaiseExceptionActionActivation extends ActionActivation{

	@Override
	public void doAction() {
		RaiseExceptionAction action  = (RaiseExceptionAction) node;
		Iterator<IValue> itValue = this.takeTokens(action.getException()).iterator();
		if(itValue.hasNext()) {
			propagateException(itValue.next());
		}
	}
	
}
