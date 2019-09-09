/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.pssm.values;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.papyrus.moka.pscs.values.ICS_OpaqueExpressionEvaluation;
import org.eclipse.uml2.uml.Parameter;

public interface ISM_OpaqueExpressionEvaluation extends ICS_OpaqueExpressionEvaluation{

	public void initialize(IEventOccurrence eventOccurrence);
	
	public void setParameterValue(IParameterValue parameterValue);
	
	public IParameterValue getParameterValue(Parameter parameter);
	
	public void setContext(IObject_ context);
	
	public IObject_ getContext();
	
}
