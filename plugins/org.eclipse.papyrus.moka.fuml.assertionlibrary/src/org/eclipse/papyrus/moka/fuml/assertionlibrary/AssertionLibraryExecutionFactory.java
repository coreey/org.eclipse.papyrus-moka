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
package org.eclipse.papyrus.moka.fuml.assertionlibrary;

import java.util.Map;

import org.eclipse.papyrus.moka.engine.uml.libraries.LibraryExecutionFactory;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.basic.AssertEquals;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.basic.AssertFalse;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.basic.AssertList;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.basic.AssertTrue;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.reporting.GenerateTestReport;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IOpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.loci.ILocus;
import org.eclipse.uml2.uml.OpaqueBehavior;

public class AssertionLibraryExecutionFactory extends LibraryExecutionFactory {

	@Override
	public void installFunctions(ILocus locus) {
		// Instantiate 
		if (locus != null) {
			for (Map.Entry<String, OpaqueBehavior> entry : libraryOpaqueBehavior.entrySet()) {
				IOpaqueBehaviorExecution execution = null;
				if(entry.getKey().equals(IAssertionLibraryExecutionFactoryUtils.ASSERT_EQUALS)) {
					execution = new AssertEquals();
				} else if(entry.getKey().equals(IAssertionLibraryExecutionFactoryUtils.ASSERT_FALSE)) {
					execution = new AssertFalse();
				} else if(entry.getKey().equals(IAssertionLibraryExecutionFactoryUtils.ASSERT_TRUE)) {
					execution = new AssertTrue();
				} else if(entry.getKey().equals(IAssertionLibraryExecutionFactoryUtils.ASSERT_LIST)) {
					execution = new AssertList();
				} else if(entry.getKey().equals(IAssertionLibraryExecutionFactoryUtils.GENERATE_TEST_REPORT)) {
					execution = new GenerateTestReport();
				}
				if (execution != null) {
					execution.addType(entry.getValue());
					register(execution, locus);
				}
			}
		}
	}

	@Override
	public void installServices(ILocus locus) {
		// The assertion library does not provide any service
	}
}
