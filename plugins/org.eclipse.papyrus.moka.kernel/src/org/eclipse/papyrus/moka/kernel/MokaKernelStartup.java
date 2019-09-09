/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.kernel;

import org.eclipse.ui.IStartup;

/**
 * This class is only used to be sure that this plugin will be activate on
 * startup otherwise the preference initialization can not works correctly
 */
public class MokaKernelStartup implements IStartup {

	@Override
	public void earlyStartup() {

	}

}
