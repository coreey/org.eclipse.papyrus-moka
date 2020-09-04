/*****************************************************************************
 * Copyright (c) 2020 CEA LIST and others.
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
package org.eclipse.papyrus.moka.engine.uml.debug;

import org.eclipse.papyrus.moka.engine.uml.UMLExecutionEngineHelper;
import org.eclipse.papyrus.moka.fuml.loci.ILocus;
import org.eclipse.papyrus.moka.kernel.engine.EngineConfiguration;

public class UMLDebugExecutionEngineHelper {

	public static void installBuiltInTypes(EngineConfiguration<?> configuration, ILocus locus) {
		UMLExecutionEngineHelper.installBuiltInTypes(configuration, locus);
	}

	public static void installLibraries(EngineConfiguration<?> configuration, ILocus locus) {
		UMLExecutionEngineHelper.installLibraries(configuration, locus);
	}

}
