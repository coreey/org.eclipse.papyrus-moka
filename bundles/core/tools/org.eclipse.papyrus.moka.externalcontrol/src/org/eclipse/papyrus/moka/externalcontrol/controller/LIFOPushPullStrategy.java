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
package org.eclipse.papyrus.moka.externalcontrol.controller;

import java.util.Iterator;
import java.util.Stack;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;

public class LIFOPushPullStrategy implements IControlledVisitorPushPullStrategy {

	private Stack<IExternallyControlledVisitor<? extends ISemanticVisitor>> visitors = new Stack<IExternallyControlledVisitor<? extends ISemanticVisitor>>();
	
	@Override
	public IExternallyControlledVisitor<? extends ISemanticVisitor> pullEnabledVisitor() {
		for (int i = 0; i< visitors.size(); i++){
			IExternallyControlledVisitor<? extends ISemanticVisitor> visitor = visitors.get(i);
			if (visitor.isExecutionAllowed()){
				visitors.remove(i);
				return visitor;
			}
		}
		return null;
	}


	@Override
	public void pushVisitor(IExternallyControlledVisitor<? extends ISemanticVisitor> visitor) {
			visitors.push(visitor);
	}
	
	@Override
	public boolean hasEnabledVisitors() {
		Iterator<IExternallyControlledVisitor<? extends ISemanticVisitor>> visitorIterator = visitors.iterator();
		while (visitorIterator.hasNext()){
			if (visitorIterator.next().isExecutionAllowed()){
				return true;
			}
		}
		return false;
	}

}
