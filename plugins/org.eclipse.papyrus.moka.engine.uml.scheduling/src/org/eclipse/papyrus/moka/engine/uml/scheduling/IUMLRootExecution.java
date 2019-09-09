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
package org.eclipse.papyrus.moka.engine.uml.scheduling;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.uml2.uml.Class;

public interface IUMLRootExecution extends IUMLTaskExecution{

	void setRoot(final Class root);
	
	Class getRoot();
	
	void setInputParameterValues(List<IParameterValue> inputParameterValues);
	
}
