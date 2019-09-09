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
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.pscs.actions;

import org.eclipse.papyrus.moka.fuml.actions.AcceptCallActionActivation;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventOccurrence;
import org.eclipse.papyrus.moka.pscs.commonbehavior.ICS_EventOccurrence;

public class CS_AcceptCallActionActivation extends AcceptCallActionActivation {

	@Override
	public void accept(IEventOccurrence eventOccurrence) {
		// If the accepted event occurrence is a CS_EventOccurrence then the wrapped
		// event occurrence is extracted. The acceptance process is the one define
		// by AcceptCallActionActivation defined in fUML.
		if(eventOccurrence instanceof ICS_EventOccurrence){
			super.accept(((ICS_EventOccurrence) eventOccurrence).getWrappedEventOccurrence());
		}else{
			super.accept(eventOccurrence);
		}
	}
	
}
