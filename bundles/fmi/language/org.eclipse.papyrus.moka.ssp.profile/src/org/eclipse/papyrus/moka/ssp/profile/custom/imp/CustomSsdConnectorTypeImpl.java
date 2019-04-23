/*******************************************************************************
 * Copyright (c) 2018, Krisztián Mócsai, IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Krisztián Mócsai - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.moka.ssp.profile.custom.imp;

import org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIPortImpl;
import org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType;
import org.eclipse.papyrus.moka.fmi.profile.util.FastUMLUtil;
import org.eclipse.papyrus.moka.ssp.profile.SsdComponent;
import org.eclipse.uml2.uml.Class;

public class CustomSsdConnectorTypeImpl extends FMIPortImpl /*implements SsdConnectorType */{
		
//	@Override
//	protected EClass eStaticClass() {
//		return SSPProfilePackage.Literals.SSD_CONNECTOR_TYPE;
//	}
	
	@Override
	public Fmi2ScalarVariable getFmiVariable() {		
		if (fmiVariable != null){
			return fmiVariable;
		}else {
			fmiVariable = getFMIVariable();
			return fmiVariable;
		}
	}
	
	public Fmi2ScalarVariable getFMIVariable() {
		if (base_Port != null && base_Port.getName() != null) {
			Class owningClass = base_Port.getClass_();
			if (owningClass != null) {
				SsdComponent owningComponent = (SsdComponent) FastUMLUtil.fastGetStereotypeApplication(owningClass, SsdComponent.class);

				if (owningComponent != null && owningComponent.getFmu() != null) {
					FmiModelDescriptionType modelDesc = owningComponent.getFmu().getModelDescription();
					if (modelDesc != null && modelDesc.getModelVariables() != null) {
						for (Fmi2ScalarVariable variable : modelDesc.getModelVariables().getScalarVariable()) {
							if (base_Port.getName().equals(variable.getName())) {
								return variable;
							}
						}
					}
				}
			}
		}
		return null;
	}
} 
