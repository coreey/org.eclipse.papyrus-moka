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

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage;
import org.eclipse.papyrus.moka.ssp.profile.SsdConnector;
import org.eclipse.papyrus.moka.ssp.profile.TypeKind;

import org.eclipse.papyrus.sysml14.deprecatedelements.internal.impl.FlowPortImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ssd Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectorImpl#getSSDDescription <em>SSD Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectorImpl#getTypeKind <em>Type Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SsdConnectorImpl extends FlowPortImpl implements SsdConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " Copyright (c) 2018,  IncQuery Labs Ltd and CEA List.\n All rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n \nContributors:\n IncQuery Labs Ltd - initial API and implementation\n CEA List ";

	/**
	 * The default value of the '{@link #getSSDDescription() <em>SSD Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSDDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String SSD_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSSDDescription() <em>SSD Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSDDescription()
	 * @generated
	 * @ordered
	 */
	protected String ssdDescription = SSD_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeKind() <em>Type Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeKind()
	 * @generated
	 * @ordered
	 */
	protected static final TypeKind TYPE_KIND_EDEFAULT = TypeKind.INPUT_LITERAL;

	/**
	 * The cached value of the '{@link #getTypeKind() <em>Type Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeKind()
	 * @generated
	 * @ordered
	 */
	protected TypeKind typeKind = TYPE_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SsdConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SSPProfilePackage.Literals.SSD_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSSDDescription() {
		return ssdDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSDDescription(String newSSDDescription) {
		String oldSSDDescription = ssdDescription;
		ssdDescription = newSSDDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SSPProfilePackage.SSD_CONNECTOR__SSD_DESCRIPTION, oldSSDDescription, ssdDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeKind getTypeKind() {
		return typeKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeKind(TypeKind newTypeKind) {
		TypeKind oldTypeKind = typeKind;
		typeKind = newTypeKind == null ? TYPE_KIND_EDEFAULT : newTypeKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SSPProfilePackage.SSD_CONNECTOR__TYPE_KIND, oldTypeKind, typeKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SSPProfilePackage.SSD_CONNECTOR__SSD_DESCRIPTION:
				return getSSDDescription();
			case SSPProfilePackage.SSD_CONNECTOR__TYPE_KIND:
				return getTypeKind();
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
			case SSPProfilePackage.SSD_CONNECTOR__SSD_DESCRIPTION:
				setSSDDescription((String)newValue);
				return;
			case SSPProfilePackage.SSD_CONNECTOR__TYPE_KIND:
				setTypeKind((TypeKind)newValue);
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
			case SSPProfilePackage.SSD_CONNECTOR__SSD_DESCRIPTION:
				setSSDDescription(SSD_DESCRIPTION_EDEFAULT);
				return;
			case SSPProfilePackage.SSD_CONNECTOR__TYPE_KIND:
				setTypeKind(TYPE_KIND_EDEFAULT);
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
			case SSPProfilePackage.SSD_CONNECTOR__SSD_DESCRIPTION:
				return SSD_DESCRIPTION_EDEFAULT == null ? ssdDescription != null : !SSD_DESCRIPTION_EDEFAULT.equals(ssdDescription);
			case SSPProfilePackage.SSD_CONNECTOR__TYPE_KIND:
				return typeKind != TYPE_KIND_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (SSDDescription: ");
		result.append(ssdDescription);
		result.append(", typeKind: ");
		result.append(typeKind);
		result.append(')');
		return result.toString();
	}

} //SsdConnectorImpl
