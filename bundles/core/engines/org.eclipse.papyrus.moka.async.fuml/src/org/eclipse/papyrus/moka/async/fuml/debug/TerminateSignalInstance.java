/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.async.fuml.debug;

import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.SignalInstance;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.UMLFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class TerminateSignalInstance.
 */
public class TerminateSignalInstance extends SignalInstance {

	/** The terminate signal. */
	protected static Signal terminateSignal;

	/**
	 * Instantiates a new terminate signal instance.
	 */
	public TerminateSignalInstance() {
		if (terminateSignal == null) {
			terminateSignal = UMLFactory.eINSTANCE.createSignal();
			terminateSignal.setName("TerminateSignal");
		}
		this.type = terminateSignal;
	}

}
