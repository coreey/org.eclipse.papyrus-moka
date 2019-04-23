/*****************************************************************************
 * 
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0.html/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.externalcontrol.profiling;



import org.eclipse.papyrus.moka.externalcontrol.semantics.ExternallyControlledActionActivation;
import org.eclipse.papyrus.moka.fuml.profiling.Semantics.Loci.SemanticVisitorProfiler;

public aspect IExternallyControlledVisitorProfiler extends SemanticVisitorProfiler{
	
	pointcut resumeExecution(ExternallyControlledActionActivation visitor):
		target(visitor) &&
		call(* org.eclipse.papyrus.moka.externalcontrol.controller.AbstractExternallyControlledVisitor.resumeExecution());
	
	before(ExternallyControlledActionActivation visitor): resumeExecution(visitor){
		this.fireNodeLeft(visitor);
	}
}