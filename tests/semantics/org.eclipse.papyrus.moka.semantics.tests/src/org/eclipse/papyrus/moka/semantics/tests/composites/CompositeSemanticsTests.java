/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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

package org.eclipse.papyrus.moka.semantics.tests.composites;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.papyrus.moka.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.engine.IExecutionEngine.OperatingMode;
import org.eclipse.papyrus.moka.semantics.tests.MokaSemanticTestsActivator;
import org.eclipse.payrus.moka.tests.framework.semantics.AbstractSemanticTest;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.junit.Assert;


public class CompositeSemanticsTests extends AbstractSemanticTest {

	protected final String COMPOSITE_ENGINE_ID = "org.eclipse.papyrus.moka.composites";  
	
	@Override
	public String getExecutionEntryPointQualifiedName() {
		return "Test Suites::Run all tests but Test Suite 4";
	}
	
	@Override
	public String getModelName() {
		return "/TestSuite";
	}

	@Override
	protected String getSourcePath() {
		return "/resources/Test Suites/Composites";
	}
	
	@Override
	public Bundle getTestBundle() {
		return MokaSemanticTestsActivator.getDefault().getBundle();
	}

	@Test
	public void runCompositesSemanticTests() {
		IExecutionEngine engine = this.getExecutionEngine(this.COMPOSITE_ENGINE_ID);
		Assert.assertNotNull("Unable to find engine: "+this.COMPOSITE_ENGINE_ID, engine);
		engine.init(null, this.executionEntryPoint, new String[]{}, OperatingMode.QUIET);
		engine.start(new NullProgressMonitor());
	}
	
}
