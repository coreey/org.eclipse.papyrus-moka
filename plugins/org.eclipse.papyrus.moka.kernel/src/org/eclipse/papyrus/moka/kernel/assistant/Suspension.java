/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
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
package org.eclipse.papyrus.moka.kernel.assistant;

import org.eclipse.papyrus.moka.kernel.SuspensionReasons;

public class Suspension {

	protected IDebugAssistant debugAssistant;
	
	protected SuspensionReasons suspensionReason;

	public Suspension(IDebugAssistant debugAssistant, SuspensionReasons suspensionReason) {
		super();
		this.debugAssistant = debugAssistant;
		this.suspensionReason = suspensionReason;
	}

	/**
	 * @return the debugAssistant
	 */
	public IDebugAssistant getDebugAssistant() {
		return debugAssistant;
	}

	/**
	 * @param debugAssistant the debugAssistant to set
	 */
	public void setDebugAssistant(IDebugAssistant debugAssistant) {
		this.debugAssistant = debugAssistant;
	}

	/**
	 * @return the suspensionReason
	 */
	public SuspensionReasons getSuspensionReason() {
		return suspensionReason;
	}

	/**
	 * @param suspensionReason the suspensionReason to set
	 */
	public void setSuspensionReason(SuspensionReasons suspensionReason) {
		this.suspensionReason = suspensionReason;
	}
	
}
