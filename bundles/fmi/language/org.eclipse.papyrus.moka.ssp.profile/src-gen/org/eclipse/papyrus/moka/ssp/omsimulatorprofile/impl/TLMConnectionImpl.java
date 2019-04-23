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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection;

import org.eclipse.uml2.uml.Connector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TLM Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMConnectionImpl#getTimedelay <em>Timedelay</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMConnectionImpl#getImpedance <em>Impedance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMConnectionImpl#getRotationalimpedance <em>Rotationalimpedance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMConnectionImpl#getAlpha <em>Alpha</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMConnectionImpl#getBase_Connector <em>Base Connector</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TLMConnectionImpl extends MinimalEObjectImpl.Container implements TLMConnection {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2018 CEA LIST.\n\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License 2.0\n which accompanies this distribution, and is available at\n https://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\n\n Contributors:\n  CEA LIST - Initial API and implementation";

	/**
	 * The default value of the '{@link #getTimedelay() <em>Timedelay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimedelay()
	 * @generated
	 * @ordered
	 */
	protected static final double TIMEDELAY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTimedelay() <em>Timedelay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimedelay()
	 * @generated
	 * @ordered
	 */
	protected double timedelay = TIMEDELAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getImpedance() <em>Impedance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImpedance()
	 * @generated
	 * @ordered
	 */
	protected static final double IMPEDANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getImpedance() <em>Impedance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImpedance()
	 * @generated
	 * @ordered
	 */
	protected double impedance = IMPEDANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRotationalimpedance() <em>Rotationalimpedance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRotationalimpedance()
	 * @generated
	 * @ordered
	 */
	protected static final double ROTATIONALIMPEDANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRotationalimpedance() <em>Rotationalimpedance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRotationalimpedance()
	 * @generated
	 * @ordered
	 */
	protected double rotationalimpedance = ROTATIONALIMPEDANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlpha() <em>Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlpha()
	 * @generated
	 * @ordered
	 */
	protected static final double ALPHA_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAlpha() <em>Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlpha()
	 * @generated
	 * @ordered
	 */
	protected double alpha = ALPHA_EDEFAULT;

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
	protected TLMConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OMSimulatorPackage.Literals.TLM_CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTimedelay() {
		return timedelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimedelay(double newTimedelay) {
		double oldTimedelay = timedelay;
		timedelay = newTimedelay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMSimulatorPackage.TLM_CONNECTION__TIMEDELAY, oldTimedelay, timedelay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getImpedance() {
		return impedance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImpedance(double newImpedance) {
		double oldImpedance = impedance;
		impedance = newImpedance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMSimulatorPackage.TLM_CONNECTION__IMPEDANCE, oldImpedance, impedance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRotationalimpedance() {
		return rotationalimpedance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalimpedance(double newRotationalimpedance) {
		double oldRotationalimpedance = rotationalimpedance;
		rotationalimpedance = newRotationalimpedance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMSimulatorPackage.TLM_CONNECTION__ROTATIONALIMPEDANCE, oldRotationalimpedance, rotationalimpedance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAlpha() {
		return alpha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlpha(double newAlpha) {
		double oldAlpha = alpha;
		alpha = newAlpha;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMSimulatorPackage.TLM_CONNECTION__ALPHA, oldAlpha, alpha));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OMSimulatorPackage.TLM_CONNECTION__BASE_CONNECTOR, oldBase_Connector, base_Connector));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OMSimulatorPackage.TLM_CONNECTION__BASE_CONNECTOR, oldBase_Connector, base_Connector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OMSimulatorPackage.TLM_CONNECTION__TIMEDELAY:
				return getTimedelay();
			case OMSimulatorPackage.TLM_CONNECTION__IMPEDANCE:
				return getImpedance();
			case OMSimulatorPackage.TLM_CONNECTION__ROTATIONALIMPEDANCE:
				return getRotationalimpedance();
			case OMSimulatorPackage.TLM_CONNECTION__ALPHA:
				return getAlpha();
			case OMSimulatorPackage.TLM_CONNECTION__BASE_CONNECTOR:
				if (resolve) return getBase_Connector();
				return basicGetBase_Connector();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OMSimulatorPackage.TLM_CONNECTION__TIMEDELAY:
				setTimedelay((Double)newValue);
				return;
			case OMSimulatorPackage.TLM_CONNECTION__IMPEDANCE:
				setImpedance((Double)newValue);
				return;
			case OMSimulatorPackage.TLM_CONNECTION__ROTATIONALIMPEDANCE:
				setRotationalimpedance((Double)newValue);
				return;
			case OMSimulatorPackage.TLM_CONNECTION__ALPHA:
				setAlpha((Double)newValue);
				return;
			case OMSimulatorPackage.TLM_CONNECTION__BASE_CONNECTOR:
				setBase_Connector((Connector)newValue);
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
			case OMSimulatorPackage.TLM_CONNECTION__TIMEDELAY:
				setTimedelay(TIMEDELAY_EDEFAULT);
				return;
			case OMSimulatorPackage.TLM_CONNECTION__IMPEDANCE:
				setImpedance(IMPEDANCE_EDEFAULT);
				return;
			case OMSimulatorPackage.TLM_CONNECTION__ROTATIONALIMPEDANCE:
				setRotationalimpedance(ROTATIONALIMPEDANCE_EDEFAULT);
				return;
			case OMSimulatorPackage.TLM_CONNECTION__ALPHA:
				setAlpha(ALPHA_EDEFAULT);
				return;
			case OMSimulatorPackage.TLM_CONNECTION__BASE_CONNECTOR:
				setBase_Connector((Connector)null);
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
			case OMSimulatorPackage.TLM_CONNECTION__TIMEDELAY:
				return timedelay != TIMEDELAY_EDEFAULT;
			case OMSimulatorPackage.TLM_CONNECTION__IMPEDANCE:
				return impedance != IMPEDANCE_EDEFAULT;
			case OMSimulatorPackage.TLM_CONNECTION__ROTATIONALIMPEDANCE:
				return rotationalimpedance != ROTATIONALIMPEDANCE_EDEFAULT;
			case OMSimulatorPackage.TLM_CONNECTION__ALPHA:
				return alpha != ALPHA_EDEFAULT;
			case OMSimulatorPackage.TLM_CONNECTION__BASE_CONNECTOR:
				return base_Connector != null;
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
		result.append(" (timedelay: ");
		result.append(timedelay);
		result.append(", impedance: ");
		result.append(impedance);
		result.append(", rotationalimpedance: ");
		result.append(rotationalimpedance);
		result.append(", alpha: ");
		result.append(alpha);
		result.append(')');
		return result.toString();
	}

} //TLMConnectionImpl
