/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IBooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Pin;

public interface IActionActivation extends IActivityNodeActivation {

	public void doAction();

	public void sendOffers();

	public void addPinActivation(IPinActivation pinActivation);

	public IPinActivation getPinActivation(Pin pin);

	public void putToken(OutputPin pin, IValue value);

	public void putTokens(OutputPin pin, List<IValue> values);

	public List<IValue> getTokens(InputPin pin);

	public List<IValue> takeTokens(InputPin pin);

	public Boolean valueParticipatesInLink(IValue value, ILink link);

	public IBooleanValue makeBooleanValue(Boolean value);

}
