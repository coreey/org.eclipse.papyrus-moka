/**
 * Copyright (c) 2018 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnectionEnd;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage;

import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bus Connection End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.BusConnectionEndImpl#getBase_ConnectorEnd <em>Base Connector End</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.BusConnectionEndImpl#getReferencedSignal <em>Referenced Signal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BusConnectionEndImpl extends MinimalEObjectImpl.Container implements BusConnectionEnd {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2018 CEA LIST.\n\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n  CEA LIST - Initial API and implementation";

	/**
	 * The cached value of the '{@link #getBase_ConnectorEnd() <em>Base Connector End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_ConnectorEnd()
	 * @generated
	 * @ordered
	 */
	protected ConnectorEnd base_ConnectorEnd;

	/**
	 * The cached value of the '{@link #getReferencedSignal() <em>Referenced Signal</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedSignal()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> referencedSignal;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BusConnectionEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OMSimulatorPackage.Literals.BUS_CONNECTION_END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectorEnd getBase_ConnectorEnd() {
		if (base_ConnectorEnd != null && base_ConnectorEnd.eIsProxy()) {
			InternalEObject oldBase_ConnectorEnd = (InternalEObject)base_ConnectorEnd;
			base_ConnectorEnd = (ConnectorEnd)eResolveProxy(oldBase_ConnectorEnd);
			if (base_ConnectorEnd != oldBase_ConnectorEnd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OMSimulatorPackage.BUS_CONNECTION_END__BASE_CONNECTOR_END, oldBase_ConnectorEnd, base_ConnectorEnd));
			}
		}
		return base_ConnectorEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorEnd basicGetBase_ConnectorEnd() {
		return base_ConnectorEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_ConnectorEnd(ConnectorEnd newBase_ConnectorEnd) {
		ConnectorEnd oldBase_ConnectorEnd = base_ConnectorEnd;
		base_ConnectorEnd = newBase_ConnectorEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMSimulatorPackage.BUS_CONNECTION_END__BASE_CONNECTOR_END, oldBase_ConnectorEnd, base_ConnectorEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Port> getReferencedSignal() {
		if (referencedSignal == null) {
			referencedSignal = new EObjectResolvingEList<Port>(Port.class, this, OMSimulatorPackage.BUS_CONNECTION_END__REFERENCED_SIGNAL);
		}
		return referencedSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getReferencedSignal(String name, Type type) {
		return getReferencedSignal(name, type, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getReferencedSignal(String name, Type type, boolean ignoreCase) {
		referencedSignalLoop: for (Port referencedSignal : getReferencedSignal()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(referencedSignal.getName()) : name.equals(referencedSignal.getName())))
				continue referencedSignalLoop;
			if (type != null && !type.equals(referencedSignal.getType()))
				continue referencedSignalLoop;
			return referencedSignal;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OMSimulatorPackage.BUS_CONNECTION_END__BASE_CONNECTOR_END:
				if (resolve) return getBase_ConnectorEnd();
				return basicGetBase_ConnectorEnd();
			case OMSimulatorPackage.BUS_CONNECTION_END__REFERENCED_SIGNAL:
				return getReferencedSignal();
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
			case OMSimulatorPackage.BUS_CONNECTION_END__BASE_CONNECTOR_END:
				setBase_ConnectorEnd((ConnectorEnd)newValue);
				return;
			case OMSimulatorPackage.BUS_CONNECTION_END__REFERENCED_SIGNAL:
				getReferencedSignal().clear();
				getReferencedSignal().addAll((Collection<? extends Port>)newValue);
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
			case OMSimulatorPackage.BUS_CONNECTION_END__BASE_CONNECTOR_END:
				setBase_ConnectorEnd((ConnectorEnd)null);
				return;
			case OMSimulatorPackage.BUS_CONNECTION_END__REFERENCED_SIGNAL:
				getReferencedSignal().clear();
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
			case OMSimulatorPackage.BUS_CONNECTION_END__BASE_CONNECTOR_END:
				return base_ConnectorEnd != null;
			case OMSimulatorPackage.BUS_CONNECTION_END__REFERENCED_SIGNAL:
				return referencedSignal != null && !referencedSignal.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BusConnectionEndImpl
