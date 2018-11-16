/**
 * Copyright (c) 2016 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *   CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.fmi.fmiprofile;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle;

import org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FMU</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getFmiVersion <em>Fmi Version</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getModelName <em>Model Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getGuid <em>Guid</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getCopyright <em>Copyright</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getLicense <em>License</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getGenerationTool <em>Generation Tool</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getGenerationDateAndTime <em>Generation Date And Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getVariableNamingConvention <em>Variable Naming Convention</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getNumberOfEventIndicators <em>Number Of Event Indicators</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getSourceFiles <em>Source Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isCanBeInstantiatedOnlyOncePerProcess <em>Can Be Instantiated Only Once Per Process</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isCanGetAndSetFMUstate <em>Can Get And Set FM Ustate</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isCanNotUseMemoryManagementFunctions <em>Can Not Use Memory Management Functions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isCanSerializeFMUstate <em>Can Serialize FM Ustate</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isProvidesDirectionalDerivative <em>Provides Directional Derivative</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isNeedsExecutionTool <em>Needs Execution Tool</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getModelIdentifier <em>Model Identifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getModelDescription <em>Model Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getFmuBundle <em>Fmu Bundle</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU()
 * @model
 * @generated
 */
public interface FMU extends EObject {
	/**
	 * Returns the value of the '<em><b>Fmi Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fmi Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fmi Version</em>' attribute.
	 * @see #setFmiVersion(String)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_FmiVersion()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getFmiVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getFmiVersion <em>Fmi Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fmi Version</em>' attribute.
	 * @see #getFmiVersion()
	 * @generated
	 */
	void setFmiVersion(String value);

	/**
	 * Returns the value of the '<em><b>Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Name</em>' attribute.
	 * @see #setModelName(String)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_ModelName()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getModelName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getModelName <em>Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Name</em>' attribute.
	 * @see #getModelName()
	 * @generated
	 */
	void setModelName(String value);

	/**
	 * Returns the value of the '<em><b>Guid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guid</em>' attribute.
	 * @see #setGuid(String)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_Guid()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getGuid();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getGuid <em>Guid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guid</em>' attribute.
	 * @see #getGuid()
	 * @generated
	 */
	void setGuid(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_Description()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' attribute.
	 * @see #setAuthor(String)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_Author()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getAuthor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getAuthor <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' attribute.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_Version()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Copyright</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Copyright</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Copyright</em>' attribute.
	 * @see #setCopyright(String)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_Copyright()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getCopyright();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getCopyright <em>Copyright</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Copyright</em>' attribute.
	 * @see #getCopyright()
	 * @generated
	 */
	void setCopyright(String value);

	/**
	 * Returns the value of the '<em><b>License</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>License</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>License</em>' attribute.
	 * @see #setLicense(String)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_License()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getLicense();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getLicense <em>License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>License</em>' attribute.
	 * @see #getLicense()
	 * @generated
	 */
	void setLicense(String value);

	/**
	 * Returns the value of the '<em><b>Generation Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generation Tool</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generation Tool</em>' attribute.
	 * @see #setGenerationTool(String)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_GenerationTool()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getGenerationTool();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getGenerationTool <em>Generation Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generation Tool</em>' attribute.
	 * @see #getGenerationTool()
	 * @generated
	 */
	void setGenerationTool(String value);

	/**
	 * Returns the value of the '<em><b>Generation Date And Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generation Date And Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generation Date And Time</em>' attribute.
	 * @see #setGenerationDateAndTime(String)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_GenerationDateAndTime()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getGenerationDateAndTime();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getGenerationDateAndTime <em>Generation Date And Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generation Date And Time</em>' attribute.
	 * @see #getGenerationDateAndTime()
	 * @generated
	 */
	void setGenerationDateAndTime(String value);

	/**
	 * Returns the value of the '<em><b>Variable Naming Convention</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Naming Convention</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Naming Convention</em>' attribute.
	 * @see #setVariableNamingConvention(String)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_VariableNamingConvention()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getVariableNamingConvention();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getVariableNamingConvention <em>Variable Naming Convention</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Naming Convention</em>' attribute.
	 * @see #getVariableNamingConvention()
	 * @generated
	 */
	void setVariableNamingConvention(String value);

	/**
	 * Returns the value of the '<em><b>Number Of Event Indicators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Event Indicators</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Event Indicators</em>' attribute.
	 * @see #setNumberOfEventIndicators(int)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_NumberOfEventIndicators()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getNumberOfEventIndicators();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getNumberOfEventIndicators <em>Number Of Event Indicators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Event Indicators</em>' attribute.
	 * @see #getNumberOfEventIndicators()
	 * @generated
	 */
	void setNumberOfEventIndicators(int value);

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
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Source Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Files</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Files</em>' attribute.
	 * @see #setSourceFiles(String)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_SourceFiles()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getSourceFiles();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getSourceFiles <em>Source Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Files</em>' attribute.
	 * @see #getSourceFiles()
	 * @generated
	 */
	void setSourceFiles(String value);

	/**
	 * Returns the value of the '<em><b>Can Be Instantiated Only Once Per Process</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Can Be Instantiated Only Once Per Process</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Can Be Instantiated Only Once Per Process</em>' attribute.
	 * @see #setCanBeInstantiatedOnlyOncePerProcess(boolean)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_CanBeInstantiatedOnlyOncePerProcess()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isCanBeInstantiatedOnlyOncePerProcess();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isCanBeInstantiatedOnlyOncePerProcess <em>Can Be Instantiated Only Once Per Process</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Can Be Instantiated Only Once Per Process</em>' attribute.
	 * @see #isCanBeInstantiatedOnlyOncePerProcess()
	 * @generated
	 */
	void setCanBeInstantiatedOnlyOncePerProcess(boolean value);

	/**
	 * Returns the value of the '<em><b>Can Get And Set FM Ustate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Can Get And Set FM Ustate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Can Get And Set FM Ustate</em>' attribute.
	 * @see #setCanGetAndSetFMUstate(boolean)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_CanGetAndSetFMUstate()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isCanGetAndSetFMUstate();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isCanGetAndSetFMUstate <em>Can Get And Set FM Ustate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Can Get And Set FM Ustate</em>' attribute.
	 * @see #isCanGetAndSetFMUstate()
	 * @generated
	 */
	void setCanGetAndSetFMUstate(boolean value);

	/**
	 * Returns the value of the '<em><b>Can Not Use Memory Management Functions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Can Not Use Memory Management Functions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Can Not Use Memory Management Functions</em>' attribute.
	 * @see #setCanNotUseMemoryManagementFunctions(boolean)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_CanNotUseMemoryManagementFunctions()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isCanNotUseMemoryManagementFunctions();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isCanNotUseMemoryManagementFunctions <em>Can Not Use Memory Management Functions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Can Not Use Memory Management Functions</em>' attribute.
	 * @see #isCanNotUseMemoryManagementFunctions()
	 * @generated
	 */
	void setCanNotUseMemoryManagementFunctions(boolean value);

	/**
	 * Returns the value of the '<em><b>Can Serialize FM Ustate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Can Serialize FM Ustate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Can Serialize FM Ustate</em>' attribute.
	 * @see #setCanSerializeFMUstate(boolean)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_CanSerializeFMUstate()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isCanSerializeFMUstate();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isCanSerializeFMUstate <em>Can Serialize FM Ustate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Can Serialize FM Ustate</em>' attribute.
	 * @see #isCanSerializeFMUstate()
	 * @generated
	 */
	void setCanSerializeFMUstate(boolean value);

	/**
	 * Returns the value of the '<em><b>Provides Directional Derivative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provides Directional Derivative</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provides Directional Derivative</em>' attribute.
	 * @see #setProvidesDirectionalDerivative(boolean)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_ProvidesDirectionalDerivative()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isProvidesDirectionalDerivative();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isProvidesDirectionalDerivative <em>Provides Directional Derivative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provides Directional Derivative</em>' attribute.
	 * @see #isProvidesDirectionalDerivative()
	 * @generated
	 */
	void setProvidesDirectionalDerivative(boolean value);

	/**
	 * Returns the value of the '<em><b>Needs Execution Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Needs Execution Tool</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Needs Execution Tool</em>' attribute.
	 * @see #setNeedsExecutionTool(boolean)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_NeedsExecutionTool()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isNeedsExecutionTool();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isNeedsExecutionTool <em>Needs Execution Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Needs Execution Tool</em>' attribute.
	 * @see #isNeedsExecutionTool()
	 * @generated
	 */
	void setNeedsExecutionTool(boolean value);

	/**
	 * Returns the value of the '<em><b>Model Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Identifier</em>' attribute.
	 * @see #setModelIdentifier(String)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_ModelIdentifier()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getModelIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getModelIdentifier <em>Model Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Identifier</em>' attribute.
	 * @see #getModelIdentifier()
	 * @generated
	 */
	void setModelIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Model Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Description</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Description</em>' reference.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_ModelDescription()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	FmiModelDescriptionType getModelDescription();

	/**
	 * Returns the value of the '<em><b>Fmu Bundle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fmu Bundle</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fmu Bundle</em>' reference.
	 * @see #setFmuBundle(FMUBundle)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getFMU_FmuBundle()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FMUBundle getFmuBundle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getFmuBundle <em>Fmu Bundle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fmu Bundle</em>' reference.
	 * @see #getFmuBundle()
	 * @generated
	 */
	void setFmuBundle(FMUBundle value);

} // FMU
