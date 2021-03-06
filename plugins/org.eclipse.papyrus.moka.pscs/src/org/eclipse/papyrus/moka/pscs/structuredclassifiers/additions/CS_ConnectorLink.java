/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.pscs.structuredclassifiers.additions;

import org.eclipse.papyrus.moka.pscs.structuredclassifiers.CS_Link;
import org.eclipse.uml2.uml.Connector;

public class CS_ConnectorLink extends CS_Link implements ICS_ConnectorLink {

	protected Connector connector;

	public void setConnector(Connector connector) {
		this.connector = connector;
	}

	public Connector getConnector() {
		return this.connector;
	}

}
