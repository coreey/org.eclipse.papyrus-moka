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
package org.eclipse.papyrus.moka.ssp.omsimulatorprofile.operations;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMSignalDefinition;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>TLM Interface Definition</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getSignalDefinitions() <em>Get Signal Definitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TLMInterfaceDefinitionOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2018 CEA LIST.\n\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n  CEA LIST - Initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TLMInterfaceDefinitionOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  EList<TLMSignalDefinition> getSignalDefinitions(TLMInterfaceDefinition tlmInterfaceDefinition) {
		Class baseClass = tlmInterfaceDefinition.getBase_Class();
		EList<TLMSignalDefinition> result = new BasicEList<>();
		
		for (Property  prop : baseClass.getAllAttributes()) {
			TLMSignalDefinition def = UMLUtil.getStereotypeApplication(prop, TLMSignalDefinition.class);
			if (def != null) {
				result.add(def);
			}
		}
		
		return result;
	}

} // TLMInterfaceDefinitionOperations