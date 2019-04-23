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

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorBus;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMDomain;

import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bus</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorBusImpl#getBase_Port <em>Base Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorBusImpl#getSignals <em>Signals</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorBusImpl#getDomain <em>Domain</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OMSimulatorBusImpl extends MinimalEObjectImpl.Container implements OMSimulatorBus {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2018 CEA LIST.\n\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License 2.0\n which accompanies this distribution, and is available at\n https://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\n\n Contributors:\n  CEA LIST - Initial API and implementation";

	/**
	 * The cached value of the '{@link #getBase_Port() <em>Base Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Port()
	 * @generated
	 * @ordered
	 */
	protected Port base_Port;

	/**
	 * The cached value of the '{@link #getSignals() <em>Signals</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignals()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> signals;

	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected EList<TLMDomain> domain;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OMSimulatorBusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OMSimulatorPackage.Literals.OM_SIMULATOR_BUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getBase_Port() {
		if (base_Port != null && base_Port.eIsProxy()) {
			InternalEObject oldBase_Port = (InternalEObject)base_Port;
			base_Port = (Port)eResolveProxy(oldBase_Port);
			if (base_Port != oldBase_Port) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OMSimulatorPackage.OM_SIMULATOR_BUS__BASE_PORT, oldBase_Port, base_Port));
			}
		}
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port basicGetBase_Port() {
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Port(Port newBase_Port) {
		Port oldBase_Port = base_Port;
		base_Port = newBase_Port;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMSimulatorPackage.OM_SIMULATOR_BUS__BASE_PORT, oldBase_Port, base_Port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getSignals() {
		if (signals == null) {
			signals = new EObjectResolvingEList<Port>(Port.class, this, OMSimulatorPackage.OM_SIMULATOR_BUS__SIGNALS);
		}
		return signals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getSignals(String name, Type type) {
		return getSignals(name, type, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getSignals(String name, Type type, boolean ignoreCase) {
		signalsLoop: for (Port signals : getSignals()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(signals.getName()) : name.equals(signals.getName())))
				continue signalsLoop;
			if (type != null && !type.equals(signals.getType()))
				continue signalsLoop;
			return signals;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TLMDomain> getDomain() {
		if (domain == null) {
			domain = new EDataTypeUniqueEList<TLMDomain>(TLMDomain.class, this, OMSimulatorPackage.OM_SIMULATOR_BUS__DOMAIN);
		}
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OMSimulatorPackage.OM_SIMULATOR_BUS__BASE_PORT:
				if (resolve) return getBase_Port();
				return basicGetBase_Port();
			case OMSimulatorPackage.OM_SIMULATOR_BUS__SIGNALS:
				return getSignals();
			case OMSimulatorPackage.OM_SIMULATOR_BUS__DOMAIN:
				return getDomain();
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
			case OMSimulatorPackage.OM_SIMULATOR_BUS__BASE_PORT:
				setBase_Port((Port)newValue);
				return;
			case OMSimulatorPackage.OM_SIMULATOR_BUS__SIGNALS:
				getSignals().clear();
				getSignals().addAll((Collection<? extends Port>)newValue);
				return;
			case OMSimulatorPackage.OM_SIMULATOR_BUS__DOMAIN:
				getDomain().clear();
				getDomain().addAll((Collection<? extends TLMDomain>)newValue);
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
			case OMSimulatorPackage.OM_SIMULATOR_BUS__BASE_PORT:
				setBase_Port((Port)null);
				return;
			case OMSimulatorPackage.OM_SIMULATOR_BUS__SIGNALS:
				getSignals().clear();
				return;
			case OMSimulatorPackage.OM_SIMULATOR_BUS__DOMAIN:
				getDomain().clear();
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
			case OMSimulatorPackage.OM_SIMULATOR_BUS__BASE_PORT:
				return base_Port != null;
			case OMSimulatorPackage.OM_SIMULATOR_BUS__SIGNALS:
				return signals != null && !signals.isEmpty();
			case OMSimulatorPackage.OM_SIMULATOR_BUS__DOMAIN:
				return domain != null && !domain.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (domain: ");
		result.append(domain);
		result.append(')');
		return result.toString();
	}

} //OMSimulatorBusImpl
