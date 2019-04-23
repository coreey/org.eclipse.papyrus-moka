/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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

package org.eclipse.papyrus.moka.timedfuml.actions;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.papyrus.moka.discreteevent.DEScheduler;
import org.eclipse.papyrus.moka.discreteevent.actions.Action;

/**
 * @author ac221913
 *
 */
public class _displayCurrentTimeAction extends Action {

	protected int step = 0;

	protected OutputStream out = null;

	/**
	 * @see org.eclipse.papyrus.moka.discreteevent.actions.Action#execute()
	 *
	 */
	@Override
	public void execute() {
		if (out == null) {
			this.out = System.out;
		}
		StringBuilder builder = new StringBuilder();
		builder.append("\n------------------------------------------------------------------------\n");
		builder.append("Step: ");
		builder.append(this.step);
		builder.append(", Current time: ");
		builder.append(DEScheduler.getInstance().getCurrentTime());
		builder.append("\n------------------------------------------------------------------------\n");
		try {
			out.write(builder.toString().getBytes());
		} catch (IOException e) {

		}
		this.step++;
	}

}
