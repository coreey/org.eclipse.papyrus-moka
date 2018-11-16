/*******************************************************************************
 * Copyright (c) 2018, Krisztián Mócsai, IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Krisztián Mócsai - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.moka.ssp.profile.custom.imp;

import org.eclipse.papyrus.moka.ssp.profile.SsdConnector;
import org.eclipse.papyrus.moka.ssp.profile.custom.StereotypeStrings;
import org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectionImpl;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

public class CustomSsdConnectionImpl extends SsdConnectionImpl {

	private final int START_INDEX = 0;
	private final int END_INDEX = 1;

	@Override
	public SsdConnector basicGetStart() {
		if (getBase_Connector() != null) {
			ConnectorEnd connectionEnd = getBase_Connector().getEnds().get(START_INDEX);

			ConnectableElement port = connectionEnd.getRole();
			if (port == null || !(port instanceof Port)) {
				return null;
			}
			SsdConnector ssdConnector = getSsdConnector((Port) port);
			return ssdConnector;
		}
		return null;
	}

	@Override
	public SsdConnector basicGetEnd() {
		if (getBase_Connector() != null) {
			ConnectorEnd connectionEnd = getBase_Connector().getEnds().get(END_INDEX);

			ConnectableElement port = connectionEnd.getRole();
			if (port == null || !(port instanceof Port)) {
				return null;
			}
			SsdConnector ssdConnector = getSsdConnector((Port) port);
			return ssdConnector;
		}
		return null;
	}
	
	private SsdConnector getSsdConnector(Port umlPort) {
		Stereotype appliedStereotype = umlPort.getAppliedStereotype(StereotypeStrings.SSDCONNECTOR_QUALIFIEDNAME);
		if (appliedStereotype == null) {
			appliedStereotype = umlPort.getAppliedStereotype(StereotypeStrings.SSDCONNECTORANDFMIPORT_QUALIFIEDNAME);
		}
		SsdConnector ssdConnector = (SsdConnector) umlPort.getStereotypeApplication(appliedStereotype);
		return ssdConnector;
	}

	@Override
	public Property basicGetStartSsdProperty() {
		if (getBase_Connector() != null && basicGetStart() != null) {
			ConnectorEnd connectorEnd = base_Connector.getEnds().get(START_INDEX);
			return connectorEnd.getPartWithPort();
		}
		return null;
	}

	@Override
	public Property basicGetEndSsdProperty() {
		if (getBase_Connector() != null && basicGetEnd() != null) {
			ConnectorEnd connectorEnd = base_Connector.getEnds().get(END_INDEX);
			return connectorEnd.getPartWithPort();
		}
		return null;
	}
}
