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

import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.Interpolation;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMSignalDefinition;

import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.operations.TLMInterfaceDefinitionOperations;

import org.eclipse.uml2.uml.Interface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TLM Interface Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMInterfaceDefinitionImpl#getInterpolation <em>Interpolation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMInterfaceDefinitionImpl#getBase_Interface <em>Base Interface</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMInterfaceDefinitionImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMInterfaceDefinitionImpl#getSignalDefinitions <em>Signal Definitions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMInterfaceDefinitionImpl#getDimensions <em>Dimensions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TLMInterfaceDefinitionImpl extends MinimalEObjectImpl.Container implements TLMInterfaceDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2018 CEA LIST.\n\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n  CEA LIST - Initial API and implementation";

	/**
	 * The default value of the '{@link #getInterpolation() <em>Interpolation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterpolation()
	 * @generated
	 * @ordered
	 */
	protected static final Interpolation INTERPOLATION_EDEFAULT = Interpolation.NONE;

	/**
	 * The cached value of the '{@link #getInterpolation() <em>Interpolation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterpolation()
	 * @generated
	 * @ordered
	 */
	protected Interpolation interpolation = INTERPOLATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Interface() <em>Base Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Interface()
	 * @generated
	 * @ordered
	 */
	protected Interface base_Interface;

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The default value of the '{@link #getDimensions() <em>Dimensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDimensions()
	 * @generated
	 * @ordered
	 */
	protected static final int DIMENSIONS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDimensions() <em>Dimensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDimensions()
	 * @generated
	 * @ordered
	 */
	protected int dimensions = DIMENSIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TLMInterfaceDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OMSimulatorPackage.Literals.TLM_INTERFACE_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interpolation getInterpolation() {
		return interpolation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterpolation(Interpolation newInterpolation) {
		Interpolation oldInterpolation = interpolation;
		interpolation = newInterpolation == null ? INTERPOLATION_EDEFAULT : newInterpolation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMSimulatorPackage.TLM_INTERFACE_DEFINITION__INTERPOLATION, oldInterpolation, interpolation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getBase_Interface() {
		if (base_Interface != null && base_Interface.eIsProxy()) {
			InternalEObject oldBase_Interface = (InternalEObject)base_Interface;
			base_Interface = (Interface)eResolveProxy(oldBase_Interface);
			if (base_Interface != oldBase_Interface) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OMSimulatorPackage.TLM_INTERFACE_DEFINITION__BASE_INTERFACE, oldBase_Interface, base_Interface));
			}
		}
		return base_Interface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetBase_Interface() {
		return base_Interface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Interface(Interface newBase_Interface) {
		Interface oldBase_Interface = base_Interface;
		base_Interface = newBase_Interface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMSimulatorPackage.TLM_INTERFACE_DEFINITION__BASE_INTERFACE, oldBase_Interface, base_Interface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OMSimulatorPackage.TLM_INTERFACE_DEFINITION__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMSimulatorPackage.TLM_INTERFACE_DEFINITION__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TLMSignalDefinition> getSignalDefinitions() {
		return TLMInterfaceDefinitionOperations.getSignalDefinitions(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDimensions() {
		return dimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDimensions(int newDimensions) {
		int oldDimensions = dimensions;
		dimensions = newDimensions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMSimulatorPackage.TLM_INTERFACE_DEFINITION__DIMENSIONS, oldDimensions, dimensions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__INTERPOLATION:
				return getInterpolation();
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__BASE_INTERFACE:
				if (resolve) return getBase_Interface();
				return basicGetBase_Interface();
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__SIGNAL_DEFINITIONS:
				return getSignalDefinitions();
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__DIMENSIONS:
				return getDimensions();
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
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__INTERPOLATION:
				setInterpolation((Interpolation)newValue);
				return;
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__BASE_INTERFACE:
				setBase_Interface((Interface)newValue);
				return;
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__SIGNAL_DEFINITIONS:
				getSignalDefinitions().clear();
				getSignalDefinitions().addAll((Collection<? extends TLMSignalDefinition>)newValue);
				return;
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__DIMENSIONS:
				setDimensions((Integer)newValue);
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
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__INTERPOLATION:
				setInterpolation(INTERPOLATION_EDEFAULT);
				return;
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__BASE_INTERFACE:
				setBase_Interface((Interface)null);
				return;
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__SIGNAL_DEFINITIONS:
				getSignalDefinitions().clear();
				return;
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__DIMENSIONS:
				setDimensions(DIMENSIONS_EDEFAULT);
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
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__INTERPOLATION:
				return interpolation != INTERPOLATION_EDEFAULT;
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__BASE_INTERFACE:
				return base_Interface != null;
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__BASE_CLASS:
				return base_Class != null;
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__SIGNAL_DEFINITIONS:
				return !getSignalDefinitions().isEmpty();
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION__DIMENSIONS:
				return dimensions != DIMENSIONS_EDEFAULT;
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
		result.append(" (interpolation: ");
		result.append(interpolation);
		result.append(", dimensions: ");
		result.append(dimensions);
		result.append(')');
		return result.toString();
	}

} //TLMInterfaceDefinitionImpl
