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
package org.eclipse.papyrus.moka.kernel.assistant;

import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.uml2.uml.Element;

public interface IDebugAssistant {

	/**
	 * Get the ID of this assistant
	 * 
	 * @return the ID of this assistant
	 */
	public String getAssistantID();
	
	/**
	 * Get the node from the given visitor
	 * @param visitor the visitor
	 * @return the visitor node
	 */
	public Element getVisitorNode(ISemanticVisitor visitor);
	
}
