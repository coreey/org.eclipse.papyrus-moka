/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.validation.constraints;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.ConnectorKind;
import org.eclipse.uml2.uml.Port;


/**
 * This class is introduced to check the following constraint:
 * A non-behavior port shall have delegation connectors
 * See 482266: [MOKA][VALIDATION] A warning should be raised when a non-behavior port has no delegation connector https://bugs.eclipse.org/bugs/show_bug.cgi?id=482266
 *
 */
public class NoDelegationConnectorOnNonBehaviorPort_Constraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		Port port = (Port) ctx.getTarget();
		if (! port.isBehavior()) {
			Class owner = (Class)port.getOwner() ;
			boolean delegationFound = false ;
			for (Iterator<Connector> i = owner.getOwnedConnectors().iterator() ; i.hasNext() && !delegationFound ; ) {
				Connector c = i.next();
				if (c.getKind() == ConnectorKind.DELEGATION_LITERAL) {
					boolean endFound = false ;
					for (Iterator<ConnectorEnd> j = c.getEnds().iterator() ; j.hasNext() && !endFound ; ) {
						ConnectorEnd ce = j.next() ;
						if (ce.getPartWithPort() == null && ce.getRole() == port) {
							endFound = true ;
						}
					}
					if (endFound) {
						return ctx.createSuccessStatus();
					}
				}
			}
			return ctx.createFailureStatus("A non-behavior port shall have delegation connectors");
		}
		return ctx.createSuccessStatus();
	}

}
