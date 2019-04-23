/*****************************************************************************
 * 
 * Copyright (c) 2017 CEA LIST.
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
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.externalcontrol.advice;

import org.eclipse.papyrus.moka.externalcontrol.controller.IExternallyControlledVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;

public interface IControllerAdvice {

	public Double getDuration();
	public void doStartAction();
	public void doFinishAction();
	public boolean canStart();
	public boolean canFinish();
	
	public void setControlledVisitor(IExternallyControlledVisitor< ? extends ISemanticVisitor> visitor);
	
}
