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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Connector;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TLM Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getTimedelay <em>Timedelay</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getImpedance <em>Impedance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getRotationalimpedance <em>Rotationalimpedance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getAlpha <em>Alpha</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getBase_Connector <em>Base Connector</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getTLMConnection()
 * @model
 * @generated
 */
public interface TLMConnection extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2018 CEA LIST.\n\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n  CEA LIST - Initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Timedelay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timedelay</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timedelay</em>' attribute.
	 * @see #setTimedelay(double)
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getTLMConnection_Timedelay()
	 * @model dataType="org.eclipse.uml2.types.Real" required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='time delay'"
	 * @generated
	 */
	double getTimedelay();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getTimedelay <em>Timedelay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timedelay</em>' attribute.
	 * @see #getTimedelay()
	 * @generated
	 */
	void setTimedelay(double value);

	/**
	 * Returns the value of the '<em><b>Impedance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Impedance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Impedance</em>' attribute.
	 * @see #setImpedance(double)
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getTLMConnection_Impedance()
	 * @model dataType="org.eclipse.uml2.types.Real" ordered="false"
	 * @generated
	 */
	double getImpedance();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getImpedance <em>Impedance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Impedance</em>' attribute.
	 * @see #getImpedance()
	 * @generated
	 */
	void setImpedance(double value);

	/**
	 * Returns the value of the '<em><b>Rotationalimpedance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotationalimpedance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotationalimpedance</em>' attribute.
	 * @see #setRotationalimpedance(double)
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getTLMConnection_Rotationalimpedance()
	 * @model dataType="org.eclipse.uml2.types.Real" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='rotational impedance'"
	 * @generated
	 */
	double getRotationalimpedance();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getRotationalimpedance <em>Rotationalimpedance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotationalimpedance</em>' attribute.
	 * @see #getRotationalimpedance()
	 * @generated
	 */
	void setRotationalimpedance(double value);

	/**
	 * Returns the value of the '<em><b>Alpha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alpha</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alpha</em>' attribute.
	 * @see #setAlpha(double)
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getTLMConnection_Alpha()
	 * @model dataType="org.eclipse.uml2.types.Real" ordered="false"
	 * @generated
	 */
	double getAlpha();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getAlpha <em>Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alpha</em>' attribute.
	 * @see #getAlpha()
	 * @generated
	 */
	void setAlpha(double value);

	/**
	 * Returns the value of the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Connector</em>' reference.
	 * @see #setBase_Connector(Connector)
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getTLMConnection_Base_Connector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Connector getBase_Connector();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getBase_Connector <em>Base Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Connector</em>' reference.
	 * @see #getBase_Connector()
	 * @generated
	 */
	void setBase_Connector(Connector value);

} // TLMConnection
