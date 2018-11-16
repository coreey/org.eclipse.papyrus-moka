/**
 *  Copyright (c) 2018,  IncQuery Labs Ltd and CEA List.
 *  All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *  IncQuery Labs Ltd - initial API and implementation
 *  CEA List 
 */
package org.eclipse.papyrus.moka.ssp.profile.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage;
import org.eclipse.papyrus.moka.ssp.profile.SsdConnection;
import org.eclipse.papyrus.moka.ssp.profile.SsdConnector;

import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ssd Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectionImpl#getBase_Connector <em>Base Connector</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectionImpl#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectionImpl#getEnd <em>End</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectionImpl#getStartSsdProperty <em>Start Ssd Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectionImpl#getEndSsdProperty <em>End Ssd Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SsdConnectionImpl extends MinimalEObjectImpl.Container implements SsdConnection {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " Copyright (c) 2018,  IncQuery Labs Ltd and CEA List.\n All rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n \nContributors:\n IncQuery Labs Ltd - initial API and implementation\n CEA List ";

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
	protected SsdConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SSPProfilePackage.Literals.SSD_CONNECTION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SSPProfilePackage.SSD_CONNECTION__BASE_CONNECTOR, oldBase_Connector, base_Connector));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SSPProfilePackage.SSD_CONNECTION__BASE_CONNECTOR, oldBase_Connector, base_Connector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SsdConnector getStart() {
		SsdConnector start = basicGetStart();
		return start != null && start.eIsProxy() ? (SsdConnector)eResolveProxy((InternalEObject)start) : start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SsdConnector basicGetStart() {
		// TODO: implement this method to return the 'Start' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SsdConnector getEnd() {
		SsdConnector end = basicGetEnd();
		return end != null && end.eIsProxy() ? (SsdConnector)eResolveProxy((InternalEObject)end) : end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SsdConnector basicGetEnd() {
		// TODO: implement this method to return the 'End' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getStartSsdProperty() {
		Property startSsdProperty = basicGetStartSsdProperty();
		return startSsdProperty != null && startSsdProperty.eIsProxy() ? (Property)eResolveProxy((InternalEObject)startSsdProperty) : startSsdProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetStartSsdProperty() {
		// TODO: implement this method to return the 'Start Ssd Property' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getEndSsdProperty() {
		Property endSsdProperty = basicGetEndSsdProperty();
		return endSsdProperty != null && endSsdProperty.eIsProxy() ? (Property)eResolveProxy((InternalEObject)endSsdProperty) : endSsdProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetEndSsdProperty() {
		// TODO: implement this method to return the 'End Ssd Property' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SSPProfilePackage.SSD_CONNECTION__BASE_CONNECTOR:
				if (resolve) return getBase_Connector();
				return basicGetBase_Connector();
			case SSPProfilePackage.SSD_CONNECTION__START:
				if (resolve) return getStart();
				return basicGetStart();
			case SSPProfilePackage.SSD_CONNECTION__END:
				if (resolve) return getEnd();
				return basicGetEnd();
			case SSPProfilePackage.SSD_CONNECTION__START_SSD_PROPERTY:
				if (resolve) return getStartSsdProperty();
				return basicGetStartSsdProperty();
			case SSPProfilePackage.SSD_CONNECTION__END_SSD_PROPERTY:
				if (resolve) return getEndSsdProperty();
				return basicGetEndSsdProperty();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SSPProfilePackage.SSD_CONNECTION__BASE_CONNECTOR:
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case SSPProfilePackage.SSD_CONNECTION__BASE_CONNECTOR:
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SSPProfilePackage.SSD_CONNECTION__BASE_CONNECTOR:
				return base_Connector != null;
			case SSPProfilePackage.SSD_CONNECTION__START:
				return basicGetStart() != null;
			case SSPProfilePackage.SSD_CONNECTION__END:
				return basicGetEnd() != null;
			case SSPProfilePackage.SSD_CONNECTION__START_SSD_PROPERTY:
				return basicGetStartSsdProperty() != null;
			case SSPProfilePackage.SSD_CONNECTION__END_SSD_PROPERTY:
				return basicGetEndSsdProperty() != null;
		}
		return super.eIsSet(featureID);
	}

} //SsdConnectionImpl
