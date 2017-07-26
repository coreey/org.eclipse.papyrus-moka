/*****************************************************************************
 * 
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.table.instancespecification;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.infra.nattable.tester.ITableTester;
import org.eclipse.uml2.uml.InstanceSpecification;

public class InstanceSpecificationTableTester implements ITableTester {

	@Override
	public IStatus isAllowed(Object context) {
		IStatus status = null;
		if (context instanceof InstanceSpecification) {

			status = new Status(IStatus.OK, null, ""); //$NON-NLS-1$
		} else {
			status = new Status(IStatus.ERROR, null, Messages.InstanceSpecificationTableTester_1);
		}

		return status;
	}

}
