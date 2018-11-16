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
package org.eclipse.papyrus.moka.ssp.omsimulatorprofile;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Interface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TLM Interface Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TLMInterface will be used to defined all the predefined TLM physical types supported by OMSimulator.
 * More particularly, each TLM interface will have to list all the corresponding signals an FMU must own.
 * Each signal will be defined with a SysML flowport.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getInterpolation <em>Interpolation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getBase_Interface <em>Base Interface</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getSignalDefinitions <em>Signal Definitions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getDimensions <em>Dimensions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getTLMInterfaceDefinition()
 * @model
 * @generated
 */
public interface TLMInterfaceDefinition extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2018 CEA LIST.\n\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n  CEA LIST - Initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Interpolation</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.Interpolation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interpolation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interpolation</em>' attribute.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.Interpolation
	 * @see #setInterpolation(Interpolation)
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getTLMInterfaceDefinition_Interpolation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Interpolation getInterpolation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getInterpolation <em>Interpolation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interpolation</em>' attribute.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.Interpolation
	 * @see #getInterpolation()
	 * @generated
	 */
	void setInterpolation(Interpolation value);

	/**
	 * Returns the value of the '<em><b>Base Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Interface</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Interface</em>' reference.
	 * @see #setBase_Interface(Interface)
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getTLMInterfaceDefinition_Base_Interface()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Interface getBase_Interface();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getBase_Interface <em>Base Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Interface</em>' reference.
	 * @see #getBase_Interface()
	 * @generated
	 */
	void setBase_Interface(Interface value);

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getTLMInterfaceDefinition_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Signal Definitions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMSignalDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signal Definitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signal Definitions</em>' reference list.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getTLMInterfaceDefinition_SignalDefinitions()
	 * @model required="true" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<TLMSignalDefinition> getSignalDefinitions();

	/**
	 * Returns the value of the '<em><b>Dimensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensions</em>' attribute.
	 * @see #setDimensions(int)
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getTLMInterfaceDefinition_Dimensions()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getDimensions();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getDimensions <em>Dimensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dimensions</em>' attribute.
	 * @see #getDimensions()
	 * @generated
	 */
	void setDimensions(int value);

} // TLMInterfaceDefinition
