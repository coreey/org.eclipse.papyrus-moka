/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
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
package org.eclipse.papyrus.moka.pscs.profiling.debug;

import org.eclipse.papyrus.moka.debug.assistant.DebugAssistantException;
import org.eclipse.papyrus.moka.fuml.activities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.profiling.debug.AbstractActivityNodeDebugAssistantProfiler;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IStructuredValue;
import org.eclipse.uml2.uml.StructuralFeature;

public aspect NullStructuredValueProfiler extends AbstractActivityNodeDebugAssistantProfiler {

	public static final String ASSISTANT_ID = "org.eclipse.papyrus.moka.pscs.profiling.debug.NullStructuredValueProfiler";

	public NullStructuredValueProfiler() {
		super();
	}

	pointcut getFeatureValue(IStructuredValue structuredValue, StructuralFeature feature):
		target(structuredValue) &&
		args(feature) &&
		call(IFeatureValue IStructuredValue.getFeatureValue(StructuralFeature));

	after(IStructuredValue structuredValue, StructuralFeature feature) returning(IFeatureValue featureValue): getFeatureValue(structuredValue, feature){
		if (checkAssistantValidity()) {
			if (featureValue == null) {
				if (thisJoinPoint.getThis() instanceof IActivityNodeActivation) {
					IActivityNodeActivation visitor = (IActivityNodeActivation) thisJoinPoint.getThis();
					throw new DebugAssistantException(this, visitor);
				}
			}
		}
	}

	@Override
	public String getAssistantID() {
		return ASSISTANT_ID;
	}

}
