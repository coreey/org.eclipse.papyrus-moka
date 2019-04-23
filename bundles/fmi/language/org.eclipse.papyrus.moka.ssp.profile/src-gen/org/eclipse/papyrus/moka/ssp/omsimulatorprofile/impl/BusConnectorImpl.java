/**
 * Copyright (c) 2018 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0 
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *   CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage;

import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.operations.BusConnectorOperations;

import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bus Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.BusConnectorImpl#getBase_Connector <em>Base Connector</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.BusConnectorImpl#getEnd1Component <em>End1 Component</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.BusConnectorImpl#getEnd1Signals <em>End1 Signals</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.BusConnectorImpl#getEnd2Signals <em>End2 Signals</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.BusConnectorImpl#getEnd2Component <em>End2 Component</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BusConnectorImpl extends MinimalEObjectImpl.Container implements BusConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2018 CEA LIST.\n\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License 2.0\n which accompanies this distribution, and is available at\n https://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\n\n Contributors:\n  CEA LIST - Initial API and implementation";

	/**
	 * The cached value of the '{@link #getBase_Connector() <em>Base Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Connector()
	 * @generated
	 * @ordered
	 */
	protected Connector base_Connector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BusConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OMSimulatorPackage.Literals.BUS_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connector getBase_Connector() {
		if (base_Connector != null && base_Connector.eIsProxy()) {
			InternalEObject oldBase_Connector = (InternalEObject)base_Connector;
			base_Connector = (Connector)eResolveProxy(oldBase_Connector);
			if (base_Connector != oldBase_Connector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OMSimulatorPackage.BUS_CONNECTOR__BASE_CONNECTOR, oldBase_Connector, base_Connector));
			}
		}
		return base_Connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connector basicGetBase_Connector() {
		return base_Connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Connector(Connector newBase_Connector) {
		Connector oldBase_Connector = base_Connector;
		base_Connector = newBase_Connector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMSimulatorPackage.BUS_CONNECTOR__BASE_CONNECTOR, oldBase_Connector, base_Connector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getEnd1Component() {
		Property end1Component = basicGetEnd1Component();
		return end1Component != null && end1Component.eIsProxy() ? (Property)eResolveProxy((InternalEObject)end1Component) : end1Component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetEnd1Component() {
		return BusConnectorOperations.getEnd1Component(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd1Component(Property newEnd1Component) {
		// TODO: implement this method to set the 'End1 Component' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getEnd1Signals() {
		return BusConnectorOperations.getEnd1Signals(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getEnd1Signals(String name, Type type) {
		return getEnd1Signals(name, type, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getEnd1Signals(String name, Type type, boolean ignoreCase) {
		end1SignalsLoop: for (Port end1Signals : getEnd1Signals()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(end1Signals.getName()) : name.equals(end1Signals.getName())))
				continue end1SignalsLoop;
			if (type != null && !type.equals(end1Signals.getType()))
				continue end1SignalsLoop;
			return end1Signals;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getEnd2Signals() {
		return BusConnectorOperations.getEnd2Signals(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getEnd2Signals(String name, Type type) {
		return getEnd2Signals(name, type, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getEnd2Signals(String name, Type type, boolean ignoreCase) {
		end2SignalsLoop: for (Port end2Signals : getEnd2Signals()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(end2Signals.getName()) : name.equals(end2Signals.getName())))
				continue end2SignalsLoop;
			if (type != null && !type.equals(end2Signals.getType()))
				continue end2SignalsLoop;
			return end2Signals;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getEnd2Component() {
		Property end2Component = basicGetEnd2Component();
		return end2Component != null && end2Component.eIsProxy() ? (Property)eResolveProxy((InternalEObject)end2Component) : end2Component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetEnd2Component() {
		return BusConnectorOperations.getEnd2Component(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd2Component(Property newEnd2Component) {
		// TODO: implement this method to set the 'End2 Component' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OMSimulatorPackage.BUS_CONNECTOR__BASE_CONNECTOR:
				if (resolve) return getBase_Connector();
				return basicGetBase_Connector();
			case OMSimulatorPackage.BUS_CONNECTOR__END1_COMPONENT:
				if (resolve) return getEnd1Component();
				return basicGetEnd1Component();
			case OMSimulatorPackage.BUS_CONNECTOR__END1_SIGNALS:
				return getEnd1Signals();
			case OMSimulatorPackage.BUS_CONNECTOR__END2_SIGNALS:
				return getEnd2Signals();
			case OMSimulatorPackage.BUS_CONNECTOR__END2_COMPONENT:
				if (resolve) return getEnd2Component();
				return basicGetEnd2Component();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OMSimulatorPackage.BUS_CONNECTOR__BASE_CONNECTOR:
				setBase_Connector((Connector)newValue);
				return;
			case OMSimulatorPackage.BUS_CONNECTOR__END1_COMPONENT:
				setEnd1Component((Property)newValue);
				return;
			case OMSimulatorPackage.BUS_CONNECTOR__END1_SIGNALS:
				getEnd1Signals().clear();
				getEnd1Signals().addAll((Collection<? extends Port>)newValue);
				return;
			case OMSimulatorPackage.BUS_CONNECTOR__END2_SIGNALS:
				getEnd2Signals().clear();
				getEnd2Signals().addAll((Collection<? extends Port>)newValue);
				return;
			case OMSimulatorPackage.BUS_CONNECTOR__END2_COMPONENT:
				setEnd2Component((Property)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OMSimulatorPackage.BUS_CONNECTOR__BASE_CONNECTOR:
				setBase_Connector((Connector)null);
				return;
			case OMSimulatorPackage.BUS_CONNECTOR__END1_COMPONENT:
				setEnd1Component((Property)null);
				return;
			case OMSimulatorPackage.BUS_CONNECTOR__END1_SIGNALS:
				getEnd1Signals().clear();
				return;
			case OMSimulatorPackage.BUS_CONNECTOR__END2_SIGNALS:
				getEnd2Signals().clear();
				return;
			case OMSimulatorPackage.BUS_CONNECTOR__END2_COMPONENT:
				setEnd2Component((Property)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OMSimulatorPackage.BUS_CONNECTOR__BASE_CONNECTOR:
				return base_Connector != null;
			case OMSimulatorPackage.BUS_CONNECTOR__END1_COMPONENT:
				return basicGetEnd1Component() != null;
			case OMSimulatorPackage.BUS_CONNECTOR__END1_SIGNALS:
				return !getEnd1Signals().isEmpty();
			case OMSimulatorPackage.BUS_CONNECTOR__END2_SIGNALS:
				return !getEnd2Signals().isEmpty();
			case OMSimulatorPackage.BUS_CONNECTOR__END2_COMPONENT:
				return basicGetEnd2Component() != null;
		}
		return super.eIsSet(featureID);
	}

} //BusConnectorImpl
