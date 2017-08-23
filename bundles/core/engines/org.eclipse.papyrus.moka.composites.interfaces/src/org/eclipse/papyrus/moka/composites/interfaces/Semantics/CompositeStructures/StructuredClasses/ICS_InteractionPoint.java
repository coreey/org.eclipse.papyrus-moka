/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.uml2.uml.Port;

public interface ICS_InteractionPoint extends IReference {

	public ICS_Reference getOwner();

	public void setOwner(ICS_Reference owner);

	public Port getDefiningPort();

	public void setDefiningPort(Port definingPort);
	
}
