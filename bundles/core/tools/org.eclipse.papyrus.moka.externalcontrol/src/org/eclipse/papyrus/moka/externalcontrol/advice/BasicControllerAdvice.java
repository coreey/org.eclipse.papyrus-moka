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
import org.eclipse.uml2.uml.Element;

/**
 *This class provides a default implementation of Controller Advice.
 *It can already be useful only to change the default fUML execution order
 *thanks to the ExternalController PushPullStrategy.
 *Clients should specialize this class to add specific control, duration and action 
 *to the delegatedVisitor.  
 *
 * @author sr246418
 */
public class BasicControllerAdvice<E extends Element, V extends ISemanticVisitor> implements IControllerAdvice {

	
	protected V delegatedVisitor;
	protected E element;
	protected IExternallyControlledVisitor<V> controlledVisitor;
	
	public BasicControllerAdvice(E element, V delegatedVisitor) {
		this.element= element;
		this.delegatedVisitor = delegatedVisitor;
	}	
	
	
	@Override
	public Double getDuration() {
		return null;
	}

	@Override
	public boolean canStart() {
		return true;
	}
	@Override
	public void doStartAction() {
		// do Nothing...
	}

	
	@Override
	public boolean canFinish() {
		return true;
	}
	@Override
	public void doFinishAction() {
		// do Nothing...
	}


	@SuppressWarnings("unchecked")
	@Override
	public void setControlledVisitor(IExternallyControlledVisitor<? extends ISemanticVisitor> visitor) {
		controlledVisitor =(IExternallyControlledVisitor<V>) visitor;
		
	}

	
	
}
