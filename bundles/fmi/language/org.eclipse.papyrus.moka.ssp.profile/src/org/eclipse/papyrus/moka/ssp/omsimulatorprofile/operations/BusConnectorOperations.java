/**
 * Copyright (c) 2018 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *   CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.ssp.omsimulatorprofile.operations;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorBus;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * <!-- begin-user-doc --> A static utility class that provides operations
 * related to '<em><b>Bus Connector</b></em>' model objects. <!-- end-user-doc
 * -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd1Component()
 * <em>Get End1 Component</em>}</li>
 * <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd2Component()
 * <em>Get End2 Component</em>}</li>
 * <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd1Signals()
 * <em>Get End1 Signals</em>}</li>
 * <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd2Signals()
 * <em>Get End2 Signals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BusConnectorOperations {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2018 CEA LIST.\n\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License 2.0\n which accompanies this distribution, and is available at\n https://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\n\n Contributors:\n  CEA LIST - Initial API and implementation";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected BusConnectorOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public static Property getEnd1Component(BusConnector busConnector) {
		if (busConnector.getBase_Connector() != null && busConnector.getBase_Connector().getEnds().size() > 0) {
			ConnectorEnd end = busConnector.getBase_Connector().getEnds().get(0);
			return end.getPartWithPort();
		} else {
			return null;
		}

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public static Property getEnd2Component(BusConnector busConnector) {
		if (busConnector.getBase_Connector() != null && busConnector.getBase_Connector().getEnds().size() >1) {
			ConnectorEnd end = busConnector.getBase_Connector().getEnds().get(1);
			return end.getPartWithPort();
		} else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public static EList<Port> getEnd1Signals(BusConnector busConnector) {
		if (busConnector.getBase_Connector() != null && busConnector.getBase_Connector().getEnds().size() > 0) {
			ConnectorEnd end = busConnector.getBase_Connector().getEnds().get(0);

			return getSignals(end);

		} else {
			return ECollections.<Port>emptyEList();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public static EList<Port> getEnd2Signals(BusConnector busConnector) {

		if (busConnector.getBase_Connector() != null && busConnector.getBase_Connector().getEnds().size() > 1) {
			ConnectorEnd end = busConnector.getBase_Connector().getEnds().get(1);

			return getSignals(end);

		} else {
			return ECollections.<Port>emptyEList();
		}

	}

	public static EList<Port> getSignals(ConnectorEnd end) {

		ConnectableElement role = end.getRole();
		OMSimulatorBus bus = UMLUtil.getStereotypeApplication(role, OMSimulatorBus.class);
		if (bus != null) {
			return bus.getSignals();
		} else {
			return ECollections.<Port>emptyEList();
		}
	}

} // BusConnectorOperations