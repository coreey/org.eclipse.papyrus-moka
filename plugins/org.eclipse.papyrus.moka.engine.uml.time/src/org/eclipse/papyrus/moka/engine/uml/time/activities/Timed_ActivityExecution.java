/*****************************************************************************
 * Copyright (c) 2020 CEA LIST.
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

package org.eclipse.papyrus.moka.engine.uml.time.activities;

import java.util.List;

import org.eclipse.papyrus.moka.engine.uml.time.semantics.CommonBehaviors.TimedObjectActivation;
import org.eclipse.papyrus.moka.fuml.activities.ActivityExecution;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.uml2.uml.Class;

public class Timed_ActivityExecution extends ActivityExecution {

	@Override
	public void startBehavior(Class classifier, List<IParameterValue> inputs) {
		if (this.objectActivation == null) {
			this.objectActivation = new TimedObjectActivation();
			this.objectActivation.setObject(this);
		}
		this.objectActivation.startBehavior(classifier, inputs);
	}
	
}
