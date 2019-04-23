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

package org.eclipse.papyrus.moka.fuml.Semantics.Activities.CompleteStructuredActivities;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.OutputPin;

public interface IStructuredActivityNodeActivation extends IActionActivation {

	public void doStructuredActivity();

	public List<ActivityNode> makeActivityNodeList(List<ExecutableNode> nodes);

	public List<IValue> getPinValues(OutputPin pin);

	public void putPinValues(OutputPin pin, List<IValue> values);

	public void terminateAll();

	public Boolean isSuspended();
}
