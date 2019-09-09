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

package org.eclipse.papyrus.moka.pssm.commonbehavior;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IObjectActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.ICompletionEventOccurrence;
import org.eclipse.papyrus.moka.pssm.statemachines.IDeferredEventOccurrence;
import org.eclipse.papyrus.moka.pssm.statemachines.IStateActivation;

public interface ISM_ObjectActivation extends IObjectActivation{

	public ICompletionEventOccurrence getNextCompletionEvent();
	
	public int getDeferredEventInsertionIndex();
	
	public void register(ICompletionEventOccurrence completionEventOccurrence);
	
	public void register(IDeferredEventOccurrence deferredEventOccurrence);
	
	public void releaseDeferredEvents(IStateActivation deferringState);
	
	public List<IDeferredEventOccurrence> getDeferredEvents();
	
}
