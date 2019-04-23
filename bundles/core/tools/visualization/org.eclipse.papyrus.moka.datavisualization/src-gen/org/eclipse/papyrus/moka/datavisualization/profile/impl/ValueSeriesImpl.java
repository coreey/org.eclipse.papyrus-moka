/**
 * Copyright (c) 2016 CEA LIST.
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
package org.eclipse.papyrus.moka.datavisualization.profile.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.VisualizationPackage;

import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Series</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.datavisualization.profile.impl.ValueSeriesImpl#getBinaryString <em>Binary String</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.datavisualization.profile.impl.ValueSeriesImpl#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.datavisualization.profile.impl.ValueSeriesImpl#getDependent <em>Dependent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValueSeriesImpl extends MinimalEObjectImpl.Container implements ValueSeries {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2016 CEA LIST.\r\n\r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License 2.0\r\n which accompanies this distribution, and is available at\r\n https://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\r\n\r\n Contributors:\r\n  CEA LIST - Initial API and implementation";

	/**
	 * The default value of the '{@link #getBinaryString() <em>Binary String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinaryString()
	 * @generated
	 * @ordered
	 */
	protected static final String BINARY_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBinaryString() <em>Binary String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinaryString()
	 * @generated
	 * @ordered
	 */
	protected String binaryString = BINARY_STRING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Property() <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Property()
	 * @generated
	 * @ordered
	 */
	protected Property base_Property;

	/**
	 * The cached value of the '{@link #getDependent() <em>Dependent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependent()
	 * @generated
	 * @ordered
	 */
	protected ValueSeries dependent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueSeriesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VisualizationPackage.Literals.VALUE_SERIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBinaryString() {
		return binaryString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBinaryString(String newBinaryString) {
		String oldBinaryString = binaryString;
		binaryString = newBinaryString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisualizationPackage.VALUE_SERIES__BINARY_STRING, oldBinaryString, binaryString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getBase_Property() {
		if (base_Property != null && base_Property.eIsProxy()) {
			InternalEObject oldBase_Property = (InternalEObject)base_Property;
			base_Property = (Property)eResolveProxy(oldBase_Property);
			if (base_Property != oldBase_Property) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VisualizationPackage.VALUE_SERIES__BASE_PROPERTY, oldBase_Property, base_Property));
			}
		}
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetBase_Property() {
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Property(Property newBase_Property) {
		Property oldBase_Property = base_Property;
		base_Property = newBase_Property;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisualizationPackage.VALUE_SERIES__BASE_PROPERTY, oldBase_Property, base_Property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSeries getDependent() {
		if (dependent != null && dependent.eIsProxy()) {
			InternalEObject oldDependent = (InternalEObject)dependent;
			dependent = (ValueSeries)eResolveProxy(oldDependent);
			if (dependent != oldDependent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VisualizationPackage.VALUE_SERIES__DEPENDENT, oldDependent, dependent));
			}
		}
		return dependent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSeries basicGetDependent() {
		return dependent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependent(ValueSeries newDependent) {
		ValueSeries oldDependent = dependent;
		dependent = newDependent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisualizationPackage.VALUE_SERIES__DEPENDENT, oldDependent, dependent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSize() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStringValue(int index) {
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
			case VisualizationPackage.VALUE_SERIES__BINARY_STRING:
				return getBinaryString();
			case VisualizationPackage.VALUE_SERIES__BASE_PROPERTY:
				if (resolve) return getBase_Property();
				return basicGetBase_Property();
			case VisualizationPackage.VALUE_SERIES__DEPENDENT:
				if (resolve) return getDependent();
				return basicGetDependent();
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
			case VisualizationPackage.VALUE_SERIES__BINARY_STRING:
				setBinaryString((String)newValue);
				return;
			case VisualizationPackage.VALUE_SERIES__BASE_PROPERTY:
				setBase_Property((Property)newValue);
				return;
			case VisualizationPackage.VALUE_SERIES__DEPENDENT:
				setDependent((ValueSeries)newValue);
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
			case VisualizationPackage.VALUE_SERIES__BINARY_STRING:
				setBinaryString(BINARY_STRING_EDEFAULT);
				return;
			case VisualizationPackage.VALUE_SERIES__BASE_PROPERTY:
				setBase_Property((Property)null);
				return;
			case VisualizationPackage.VALUE_SERIES__DEPENDENT:
				setDependent((ValueSeries)null);
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
			case VisualizationPackage.VALUE_SERIES__BINARY_STRING:
				return BINARY_STRING_EDEFAULT == null ? binaryString != null : !BINARY_STRING_EDEFAULT.equals(binaryString);
			case VisualizationPackage.VALUE_SERIES__BASE_PROPERTY:
				return base_Property != null;
			case VisualizationPackage.VALUE_SERIES__DEPENDENT:
				return dependent != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case VisualizationPackage.VALUE_SERIES___GET_SIZE:
				return getSize();
			case VisualizationPackage.VALUE_SERIES___GET_STRING_VALUE__INT:
				return getStringValue((Integer)arguments.get(0));
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
		result.append(" (binaryString: ");
		result.append(binaryString);
		result.append(')');
		return result.toString();
	}

} //ValueSeriesImpl
