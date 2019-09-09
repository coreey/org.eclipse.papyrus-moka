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
package org.eclipse.papyrus.moka.engine.uml;

import org.eclipse.papyrus.moka.fuml.loci.ILocus;

public interface IUMLExecutionEngine {

	/**
	 * Instantiate the locus that hosts the execution
	 * @return
	 */
	ILocus createLocus();
	
	/**
	 * Install built in types (e.g., primitive ones)
	 */
	void installBuiltInTypes();
	
	/**
	 * Install Opaque Behavior Execution for behavior defined in model libraries
	 */
	void installLibraries();
	
	/**
	 * Install Executable UML semantic strategies
	 */
	void installSemanticStrategies();
	
}
