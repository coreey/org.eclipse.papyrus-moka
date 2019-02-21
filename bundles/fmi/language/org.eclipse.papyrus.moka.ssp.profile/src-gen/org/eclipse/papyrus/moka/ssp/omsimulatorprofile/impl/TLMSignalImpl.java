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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMSignal;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMSignalDefinition;

import org.eclipse.uml2.uml.Port;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TLM Signal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMSignalImpl#getBase_Port <em>Base Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMSignalImpl#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TLMSignalImpl extends MinimalEObjectImpl.Container implements TLMSignal {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2018 CEA LIST.\n\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n  CEA LIST - Initial API and implementation";

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
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected TLMSignalDefinition definition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TLMSignalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OMSimulatorPackage.Literals.TLM_SIGNAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Port getBase_Port() {
		if (base_Port != null && base_Port.eIsProxy()) {
			InternalEObject oldBase_Port = (InternalEObject)base_Port;
			base_Port = (Port)eResolveProxy(oldBase_Port);
			if (base_Port != oldBase_Port) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OMSimulatorPackage.TLM_SIGNAL__BASE_PORT, oldBase_Port, base_Port));
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
	@Override
	public void setBase_Port(Port newBase_Port) {
		Port oldBase_Port = base_Port;
		base_Port = newBase_Port;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMSimulatorPackage.TLM_SIGNAL__BASE_PORT, oldBase_Port, base_Port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TLMSignalDefinition getDefinition() {
		if (definition != null && definition.eIsProxy()) {
			InternalEObject oldDefinition = (InternalEObject)definition;
			definition = (TLMSignalDefinition)eResolveProxy(oldDefinition);
			if (definition != oldDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OMSimulatorPackage.TLM_SIGNAL__DEFINITION, oldDefinition, definition));
			}
		}
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TLMSignalDefinition basicGetDefinition() {
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefinition(TLMSignalDefinition newDefinition) {
		TLMSignalDefinition oldDefinition = definition;
		definition = newDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMSimulatorPackage.TLM_SIGNAL__DEFINITION, oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OMSimulatorPackage.TLM_SIGNAL__BASE_PORT:
				if (resolve) return getBase_Port();
				return basicGetBase_Port();
			case OMSimulatorPackage.TLM_SIGNAL__DEFINITION:
				if (resolve) return getDefinition();
				return basicGetDefinition();
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
			case OMSimulatorPackage.TLM_SIGNAL__BASE_PORT:
				setBase_Port((Port)newValue);
				return;
			case OMSimulatorPackage.TLM_SIGNAL__DEFINITION:
				setDefinition((TLMSignalDefinition)newValue);
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
			case OMSimulatorPackage.TLM_SIGNAL__BASE_PORT:
				setBase_Port((Port)null);
				return;
			case OMSimulatorPackage.TLM_SIGNAL__DEFINITION:
				setDefinition((TLMSignalDefinition)null);
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
			case OMSimulatorPackage.TLM_SIGNAL__BASE_PORT:
				return base_Port != null;
			case OMSimulatorPackage.TLM_SIGNAL__DEFINITION:
				return definition != null;
		}
		return super.eIsSet(featureID);
	}

} //TLMSignalImpl
