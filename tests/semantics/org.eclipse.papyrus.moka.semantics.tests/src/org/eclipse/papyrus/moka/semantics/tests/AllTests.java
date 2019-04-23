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
 *  (CEA LIST) - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.moka.semantics.tests;

import org.eclipse.papyrus.moka.semantics.tests.composites.CompositeSemanticsTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CompositeSemanticsTests.class})
public class AllTests {

	public AllTests() {
		super();
	}
}
