/*******************************************************************************
 * Copyright (c) 2018, Krisztián Mócsai, IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Krisztián Mócsai - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.moka.ssp.profile.custom.imp;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.moka.fmi.profile.custom.CustomPort;
import org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage;
import org.eclipse.papyrus.moka.ssp.profile.SsdConnector;
import org.eclipse.papyrus.moka.ssp.profile.SsdConnectorAndFmiPort;
import org.eclipse.papyrus.moka.ssp.profile.TypeKind;

public class CustomSsdConnectorAndFmiPortImpl extends CustomPort implements SsdConnectorAndFmiPort {

	protected static final String DESCRIPTION_SSD_EDEFAULT = null;
	protected static final TypeKind TYPE_KIND_EDEFAULT = TypeKind.INPUT_LITERAL;
	protected String descriptionSSD = DESCRIPTION_SSD_EDEFAULT;
	protected TypeKind typeKind = TYPE_KIND_EDEFAULT;

	@Override
	protected EClass eStaticClass() {
		return SSPProfilePackage.Literals.SSD_CONNECTOR_AND_FMI_PORT;
	}

	@Override
	public String getSSDDescription() {
		return descriptionSSD;
	}

	@Override
	public void setSSDDescription(String newDescriptionSSD) {
		String oldDescriptionSSD = descriptionSSD;
		descriptionSSD = newDescriptionSSD;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					SSPProfilePackage.SSD_CONNECTOR_AND_FMI_PORT__SSD_DESCRIPTION, oldDescriptionSSD, descriptionSSD));
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SSPProfilePackage.SSD_CONNECTOR_AND_FMI_PORT__SSD_DESCRIPTION:
			return getSSDDescription();
		case SSPProfilePackage.SSD_CONNECTOR_AND_FMI_PORT__TYPE_KIND:
			return getTypeKind();
		}		
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SSPProfilePackage.SSD_CONNECTOR_AND_FMI_PORT__SSD_DESCRIPTION:
			setSSDDescription((String) newValue);
			return;
		case SSPProfilePackage.SSD_CONNECTOR_AND_FMI_PORT__TYPE_KIND:
			setTypeKind((TypeKind)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case SSPProfilePackage.SSD_CONNECTOR_AND_FMI_PORT__SSD_DESCRIPTION:
			setSSDDescription(DESCRIPTION_SSD_EDEFAULT);
			return;
		case SSPProfilePackage.SSD_CONNECTOR_AND_FMI_PORT__TYPE_KIND:
			setTypeKind(TYPE_KIND_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SSPProfilePackage.SSD_CONNECTOR_AND_FMI_PORT__SSD_DESCRIPTION:
			return DESCRIPTION_SSD_EDEFAULT == null ? descriptionSSD != null
					: !DESCRIPTION_SSD_EDEFAULT.equals(descriptionSSD);
		case SSPProfilePackage.SSD_CONNECTOR_AND_FMI_PORT__TYPE_KIND:
			return typeKind != TYPE_KIND_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public TypeKind getTypeKind() {
		return typeKind;
	}

	@Override
	public void setTypeKind(TypeKind newTypeKind) {
		TypeKind oldTypeKind = typeKind;
		typeKind = newTypeKind == null ? TYPE_KIND_EDEFAULT : newTypeKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SSPProfilePackage.SSD_CONNECTOR_AND_FMI_PORT__TYPE_KIND, oldTypeKind, typeKind));
	}
	
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == SsdConnector.class) {
			switch (baseFeatureID) {
				case SSPProfilePackage.SSD_CONNECTOR__SSD_DESCRIPTION: return SSPProfilePackage.SSD_CONNECTOR_AND_FMI_PORT__SSD_DESCRIPTION;
				case SSPProfilePackage.SSD_CONNECTOR__TYPE_KIND: return SSPProfilePackage.SSD_CONNECTOR_AND_FMI_PORT__TYPE_KIND;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

}
