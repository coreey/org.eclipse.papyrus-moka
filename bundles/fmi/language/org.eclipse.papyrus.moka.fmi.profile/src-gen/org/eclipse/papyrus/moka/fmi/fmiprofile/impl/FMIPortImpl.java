/**
 * Copyright (c) 2016 CEA LIST.
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
package org.eclipse.papyrus.moka.fmi.fmiprofile.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIPort;
import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage;

import org.eclipse.papyrus.sysml14.deprecatedelements.DeprecatedelementsPackage;
import org.eclipse.papyrus.sysml14.deprecatedelements.FlowPort;

import org.eclipse.papyrus.sysml14.portsandflows.FlowDirection;

import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Port;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FMI Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIPortImpl#getBase_Port <em>Base Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIPortImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIPortImpl#isAtomic <em>Is Atomic</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FMIPortImpl extends ScalarVariableImpl implements FMIPort {
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
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final FlowDirection DIRECTION_EDEFAULT = FlowDirection.INOUT;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected FlowDirection direction = DIRECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #isAtomic() <em>Is Atomic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAtomic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ATOMIC_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FMIPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FMIProfilePackage.Literals.FMI_PORT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FMIProfilePackage.FMI_PORT__BASE_PORT, oldBase_Port, base_Port));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMI_PORT__BASE_PORT, oldBase_Port, base_Port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowDirection getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(FlowDirection newDirection) {
		FlowDirection oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMI_PORT__DIRECTION, oldDirection, direction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAtomic() {
		// TODO: implement this method to return the 'Is Atomic' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Image getIcon() {
		// TODO: implement this method
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
			case FMIProfilePackage.FMI_PORT__BASE_PORT:
				if (resolve) return getBase_Port();
				return basicGetBase_Port();
			case FMIProfilePackage.FMI_PORT__DIRECTION:
				return getDirection();
			case FMIProfilePackage.FMI_PORT__IS_ATOMIC:
				return isAtomic();
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
			case FMIProfilePackage.FMI_PORT__BASE_PORT:
				setBase_Port((Port)newValue);
				return;
			case FMIProfilePackage.FMI_PORT__DIRECTION:
				setDirection((FlowDirection)newValue);
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
			case FMIProfilePackage.FMI_PORT__BASE_PORT:
				setBase_Port((Port)null);
				return;
			case FMIProfilePackage.FMI_PORT__DIRECTION:
				setDirection(DIRECTION_EDEFAULT);
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
			case FMIProfilePackage.FMI_PORT__BASE_PORT:
				return base_Port != null;
			case FMIProfilePackage.FMI_PORT__DIRECTION:
				return direction != DIRECTION_EDEFAULT;
			case FMIProfilePackage.FMI_PORT__IS_ATOMIC:
				return isAtomic() != IS_ATOMIC_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == FlowPort.class) {
			switch (derivedFeatureID) {
				case FMIProfilePackage.FMI_PORT__BASE_PORT: return DeprecatedelementsPackage.FLOW_PORT__BASE_PORT;
				case FMIProfilePackage.FMI_PORT__DIRECTION: return DeprecatedelementsPackage.FLOW_PORT__DIRECTION;
				case FMIProfilePackage.FMI_PORT__IS_ATOMIC: return DeprecatedelementsPackage.FLOW_PORT__IS_ATOMIC;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == FlowPort.class) {
			switch (baseFeatureID) {
				case DeprecatedelementsPackage.FLOW_PORT__BASE_PORT: return FMIProfilePackage.FMI_PORT__BASE_PORT;
				case DeprecatedelementsPackage.FLOW_PORT__DIRECTION: return FMIProfilePackage.FMI_PORT__DIRECTION;
				case DeprecatedelementsPackage.FLOW_PORT__IS_ATOMIC: return FMIProfilePackage.FMI_PORT__IS_ATOMIC;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == FlowPort.class) {
			switch (baseOperationID) {
				case DeprecatedelementsPackage.FLOW_PORT___GET_ICON: return FMIProfilePackage.FMI_PORT___GET_ICON;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case FMIProfilePackage.FMI_PORT___GET_ICON:
				return getIcon();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (direction: ");
		result.append(direction);
		result.append(')');
		return result.toString();
	}

} //FMIPortImpl
