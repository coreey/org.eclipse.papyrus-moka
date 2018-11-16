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
package org.eclipse.papyrus.moka.fmi.fmiprofile.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage;
import org.eclipse.papyrus.moka.fmi.fmiprofile.FMU;

import org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle;

import org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FMU</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#getFmiVersion <em>Fmi Version</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#getModelName <em>Model Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#getGuid <em>Guid</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#getCopyright <em>Copyright</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#getLicense <em>License</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#getGenerationTool <em>Generation Tool</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#getGenerationDateAndTime <em>Generation Date And Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#getVariableNamingConvention <em>Variable Naming Convention</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#getNumberOfEventIndicators <em>Number Of Event Indicators</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#getSourceFiles <em>Source Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#isCanBeInstantiatedOnlyOncePerProcess <em>Can Be Instantiated Only Once Per Process</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#isCanGetAndSetFMUstate <em>Can Get And Set FM Ustate</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#isCanNotUseMemoryManagementFunctions <em>Can Not Use Memory Management Functions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#isCanSerializeFMUstate <em>Can Serialize FM Ustate</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#isProvidesDirectionalDerivative <em>Provides Directional Derivative</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#isNeedsExecutionTool <em>Needs Execution Tool</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#getModelIdentifier <em>Model Identifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#getModelDescription <em>Model Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl#getFmuBundle <em>Fmu Bundle</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FMUImpl extends MinimalEObjectImpl.Container implements FMU {
	/**
	 * The default value of the '{@link #getFmiVersion() <em>Fmi Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFmiVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String FMI_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFmiVersion() <em>Fmi Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFmiVersion()
	 * @generated
	 * @ordered
	 */
	protected String fmiVersion = FMI_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getModelName() <em>Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelName()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelName() <em>Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelName()
	 * @generated
	 * @ordered
	 */
	protected String modelName = MODEL_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getGuid() <em>Guid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuid()
	 * @generated
	 * @ordered
	 */
	protected static final String GUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGuid() <em>Guid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuid()
	 * @generated
	 * @ordered
	 */
	protected String guid = GUID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected String author = AUTHOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCopyright() <em>Copyright</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopyright()
	 * @generated
	 * @ordered
	 */
	protected static final String COPYRIGHT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCopyright() <em>Copyright</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopyright()
	 * @generated
	 * @ordered
	 */
	protected String copyright = COPYRIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLicense() <em>License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected static final String LICENSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLicense() <em>License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected String license = LICENSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getGenerationTool() <em>Generation Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerationTool()
	 * @generated
	 * @ordered
	 */
	protected static final String GENERATION_TOOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGenerationTool() <em>Generation Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerationTool()
	 * @generated
	 * @ordered
	 */
	protected String generationTool = GENERATION_TOOL_EDEFAULT;

	/**
	 * The default value of the '{@link #getGenerationDateAndTime() <em>Generation Date And Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerationDateAndTime()
	 * @generated
	 * @ordered
	 */
	protected static final String GENERATION_DATE_AND_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGenerationDateAndTime() <em>Generation Date And Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerationDateAndTime()
	 * @generated
	 * @ordered
	 */
	protected String generationDateAndTime = GENERATION_DATE_AND_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getVariableNamingConvention() <em>Variable Naming Convention</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableNamingConvention()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIABLE_NAMING_CONVENTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariableNamingConvention() <em>Variable Naming Convention</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableNamingConvention()
	 * @generated
	 * @ordered
	 */
	protected String variableNamingConvention = VARIABLE_NAMING_CONVENTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberOfEventIndicators() <em>Number Of Event Indicators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfEventIndicators()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_EVENT_INDICATORS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumberOfEventIndicators() <em>Number Of Event Indicators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfEventIndicators()
	 * @generated
	 * @ordered
	 */
	protected int numberOfEventIndicators = NUMBER_OF_EVENT_INDICATORS_EDEFAULT;

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
	 * The default value of the '{@link #getSourceFiles() <em>Source Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFiles()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_FILES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceFiles() <em>Source Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFiles()
	 * @generated
	 * @ordered
	 */
	protected String sourceFiles = SOURCE_FILES_EDEFAULT;

	/**
	 * The default value of the '{@link #isCanBeInstantiatedOnlyOncePerProcess() <em>Can Be Instantiated Only Once Per Process</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanBeInstantiatedOnlyOncePerProcess()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCanBeInstantiatedOnlyOncePerProcess() <em>Can Be Instantiated Only Once Per Process</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanBeInstantiatedOnlyOncePerProcess()
	 * @generated
	 * @ordered
	 */
	protected boolean canBeInstantiatedOnlyOncePerProcess = CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS_EDEFAULT;

	/**
	 * The default value of the '{@link #isCanGetAndSetFMUstate() <em>Can Get And Set FM Ustate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanGetAndSetFMUstate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CAN_GET_AND_SET_FM_USTATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCanGetAndSetFMUstate() <em>Can Get And Set FM Ustate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanGetAndSetFMUstate()
	 * @generated
	 * @ordered
	 */
	protected boolean canGetAndSetFMUstate = CAN_GET_AND_SET_FM_USTATE_EDEFAULT;

	/**
	 * The default value of the '{@link #isCanNotUseMemoryManagementFunctions() <em>Can Not Use Memory Management Functions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanNotUseMemoryManagementFunctions()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCanNotUseMemoryManagementFunctions() <em>Can Not Use Memory Management Functions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanNotUseMemoryManagementFunctions()
	 * @generated
	 * @ordered
	 */
	protected boolean canNotUseMemoryManagementFunctions = CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #isCanSerializeFMUstate() <em>Can Serialize FM Ustate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanSerializeFMUstate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CAN_SERIALIZE_FM_USTATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCanSerializeFMUstate() <em>Can Serialize FM Ustate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanSerializeFMUstate()
	 * @generated
	 * @ordered
	 */
	protected boolean canSerializeFMUstate = CAN_SERIALIZE_FM_USTATE_EDEFAULT;

	/**
	 * The default value of the '{@link #isProvidesDirectionalDerivative() <em>Provides Directional Derivative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProvidesDirectionalDerivative()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PROVIDES_DIRECTIONAL_DERIVATIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isProvidesDirectionalDerivative() <em>Provides Directional Derivative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProvidesDirectionalDerivative()
	 * @generated
	 * @ordered
	 */
	protected boolean providesDirectionalDerivative = PROVIDES_DIRECTIONAL_DERIVATIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isNeedsExecutionTool() <em>Needs Execution Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNeedsExecutionTool()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NEEDS_EXECUTION_TOOL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNeedsExecutionTool() <em>Needs Execution Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNeedsExecutionTool()
	 * @generated
	 * @ordered
	 */
	protected boolean needsExecutionTool = NEEDS_EXECUTION_TOOL_EDEFAULT;

	/**
	 * The default value of the '{@link #getModelIdentifier() <em>Model Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelIdentifier() <em>Model Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String modelIdentifier = MODEL_IDENTIFIER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFmuBundle() <em>Fmu Bundle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFmuBundle()
	 * @generated
	 * @ordered
	 */
	protected FMUBundle fmuBundle;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FMUImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FMIProfilePackage.Literals.FMU;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFmiVersion() {
		return fmiVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFmiVersion(String newFmiVersion) {
		String oldFmiVersion = fmiVersion;
		fmiVersion = newFmiVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__FMI_VERSION, oldFmiVersion, fmiVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelName(String newModelName) {
		String oldModelName = modelName;
		modelName = newModelName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__MODEL_NAME, oldModelName, modelName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGuid() {
		return guid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuid(String newGuid) {
		String oldGuid = guid;
		guid = newGuid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__GUID, oldGuid, guid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__AUTHOR, oldAuthor, author));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCopyright() {
		return copyright;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCopyright(String newCopyright) {
		String oldCopyright = copyright;
		copyright = newCopyright;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__COPYRIGHT, oldCopyright, copyright));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLicense(String newLicense) {
		String oldLicense = license;
		license = newLicense;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__LICENSE, oldLicense, license));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGenerationTool() {
		return generationTool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerationTool(String newGenerationTool) {
		String oldGenerationTool = generationTool;
		generationTool = newGenerationTool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__GENERATION_TOOL, oldGenerationTool, generationTool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGenerationDateAndTime() {
		return generationDateAndTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerationDateAndTime(String newGenerationDateAndTime) {
		String oldGenerationDateAndTime = generationDateAndTime;
		generationDateAndTime = newGenerationDateAndTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__GENERATION_DATE_AND_TIME, oldGenerationDateAndTime, generationDateAndTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVariableNamingConvention() {
		return variableNamingConvention;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableNamingConvention(String newVariableNamingConvention) {
		String oldVariableNamingConvention = variableNamingConvention;
		variableNamingConvention = newVariableNamingConvention;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__VARIABLE_NAMING_CONVENTION, oldVariableNamingConvention, variableNamingConvention));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfEventIndicators() {
		return numberOfEventIndicators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfEventIndicators(int newNumberOfEventIndicators) {
		int oldNumberOfEventIndicators = numberOfEventIndicators;
		numberOfEventIndicators = newNumberOfEventIndicators;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__NUMBER_OF_EVENT_INDICATORS, oldNumberOfEventIndicators, numberOfEventIndicators));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FMIProfilePackage.FMU__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceFiles() {
		return sourceFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceFiles(String newSourceFiles) {
		String oldSourceFiles = sourceFiles;
		sourceFiles = newSourceFiles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__SOURCE_FILES, oldSourceFiles, sourceFiles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCanBeInstantiatedOnlyOncePerProcess() {
		return canBeInstantiatedOnlyOncePerProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCanBeInstantiatedOnlyOncePerProcess(boolean newCanBeInstantiatedOnlyOncePerProcess) {
		boolean oldCanBeInstantiatedOnlyOncePerProcess = canBeInstantiatedOnlyOncePerProcess;
		canBeInstantiatedOnlyOncePerProcess = newCanBeInstantiatedOnlyOncePerProcess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS, oldCanBeInstantiatedOnlyOncePerProcess, canBeInstantiatedOnlyOncePerProcess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCanGetAndSetFMUstate() {
		return canGetAndSetFMUstate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCanGetAndSetFMUstate(boolean newCanGetAndSetFMUstate) {
		boolean oldCanGetAndSetFMUstate = canGetAndSetFMUstate;
		canGetAndSetFMUstate = newCanGetAndSetFMUstate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__CAN_GET_AND_SET_FM_USTATE, oldCanGetAndSetFMUstate, canGetAndSetFMUstate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCanNotUseMemoryManagementFunctions() {
		return canNotUseMemoryManagementFunctions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCanNotUseMemoryManagementFunctions(boolean newCanNotUseMemoryManagementFunctions) {
		boolean oldCanNotUseMemoryManagementFunctions = canNotUseMemoryManagementFunctions;
		canNotUseMemoryManagementFunctions = newCanNotUseMemoryManagementFunctions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS, oldCanNotUseMemoryManagementFunctions, canNotUseMemoryManagementFunctions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCanSerializeFMUstate() {
		return canSerializeFMUstate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCanSerializeFMUstate(boolean newCanSerializeFMUstate) {
		boolean oldCanSerializeFMUstate = canSerializeFMUstate;
		canSerializeFMUstate = newCanSerializeFMUstate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__CAN_SERIALIZE_FM_USTATE, oldCanSerializeFMUstate, canSerializeFMUstate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isProvidesDirectionalDerivative() {
		return providesDirectionalDerivative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidesDirectionalDerivative(boolean newProvidesDirectionalDerivative) {
		boolean oldProvidesDirectionalDerivative = providesDirectionalDerivative;
		providesDirectionalDerivative = newProvidesDirectionalDerivative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__PROVIDES_DIRECTIONAL_DERIVATIVE, oldProvidesDirectionalDerivative, providesDirectionalDerivative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNeedsExecutionTool() {
		return needsExecutionTool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNeedsExecutionTool(boolean newNeedsExecutionTool) {
		boolean oldNeedsExecutionTool = needsExecutionTool;
		needsExecutionTool = newNeedsExecutionTool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__NEEDS_EXECUTION_TOOL, oldNeedsExecutionTool, needsExecutionTool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelIdentifier() {
		return modelIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelIdentifier(String newModelIdentifier) {
		String oldModelIdentifier = modelIdentifier;
		modelIdentifier = newModelIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__MODEL_IDENTIFIER, oldModelIdentifier, modelIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FmiModelDescriptionType getModelDescription() {
		FmiModelDescriptionType modelDescription = basicGetModelDescription();
		return modelDescription != null && modelDescription.eIsProxy() ? (FmiModelDescriptionType)eResolveProxy((InternalEObject)modelDescription) : modelDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FmiModelDescriptionType basicGetModelDescription() {
		// TODO: implement this method to return the 'Model Description' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FMUBundle getFmuBundle() {
		if (fmuBundle != null && fmuBundle.eIsProxy()) {
			InternalEObject oldFmuBundle = (InternalEObject)fmuBundle;
			fmuBundle = (FMUBundle)eResolveProxy(oldFmuBundle);
			if (fmuBundle != oldFmuBundle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FMIProfilePackage.FMU__FMU_BUNDLE, oldFmuBundle, fmuBundle));
			}
		}
		return fmuBundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FMUBundle basicGetFmuBundle() {
		return fmuBundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFmuBundle(FMUBundle newFmuBundle) {
		FMUBundle oldFmuBundle = fmuBundle;
		fmuBundle = newFmuBundle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FMIProfilePackage.FMU__FMU_BUNDLE, oldFmuBundle, fmuBundle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FMIProfilePackage.FMU__FMI_VERSION:
				return getFmiVersion();
			case FMIProfilePackage.FMU__MODEL_NAME:
				return getModelName();
			case FMIProfilePackage.FMU__GUID:
				return getGuid();
			case FMIProfilePackage.FMU__DESCRIPTION:
				return getDescription();
			case FMIProfilePackage.FMU__AUTHOR:
				return getAuthor();
			case FMIProfilePackage.FMU__VERSION:
				return getVersion();
			case FMIProfilePackage.FMU__COPYRIGHT:
				return getCopyright();
			case FMIProfilePackage.FMU__LICENSE:
				return getLicense();
			case FMIProfilePackage.FMU__GENERATION_TOOL:
				return getGenerationTool();
			case FMIProfilePackage.FMU__GENERATION_DATE_AND_TIME:
				return getGenerationDateAndTime();
			case FMIProfilePackage.FMU__VARIABLE_NAMING_CONVENTION:
				return getVariableNamingConvention();
			case FMIProfilePackage.FMU__NUMBER_OF_EVENT_INDICATORS:
				return getNumberOfEventIndicators();
			case FMIProfilePackage.FMU__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case FMIProfilePackage.FMU__SOURCE_FILES:
				return getSourceFiles();
			case FMIProfilePackage.FMU__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS:
				return isCanBeInstantiatedOnlyOncePerProcess();
			case FMIProfilePackage.FMU__CAN_GET_AND_SET_FM_USTATE:
				return isCanGetAndSetFMUstate();
			case FMIProfilePackage.FMU__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS:
				return isCanNotUseMemoryManagementFunctions();
			case FMIProfilePackage.FMU__CAN_SERIALIZE_FM_USTATE:
				return isCanSerializeFMUstate();
			case FMIProfilePackage.FMU__PROVIDES_DIRECTIONAL_DERIVATIVE:
				return isProvidesDirectionalDerivative();
			case FMIProfilePackage.FMU__NEEDS_EXECUTION_TOOL:
				return isNeedsExecutionTool();
			case FMIProfilePackage.FMU__MODEL_IDENTIFIER:
				return getModelIdentifier();
			case FMIProfilePackage.FMU__MODEL_DESCRIPTION:
				if (resolve) return getModelDescription();
				return basicGetModelDescription();
			case FMIProfilePackage.FMU__FMU_BUNDLE:
				if (resolve) return getFmuBundle();
				return basicGetFmuBundle();
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
			case FMIProfilePackage.FMU__FMI_VERSION:
				setFmiVersion((String)newValue);
				return;
			case FMIProfilePackage.FMU__MODEL_NAME:
				setModelName((String)newValue);
				return;
			case FMIProfilePackage.FMU__GUID:
				setGuid((String)newValue);
				return;
			case FMIProfilePackage.FMU__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case FMIProfilePackage.FMU__AUTHOR:
				setAuthor((String)newValue);
				return;
			case FMIProfilePackage.FMU__VERSION:
				setVersion((String)newValue);
				return;
			case FMIProfilePackage.FMU__COPYRIGHT:
				setCopyright((String)newValue);
				return;
			case FMIProfilePackage.FMU__LICENSE:
				setLicense((String)newValue);
				return;
			case FMIProfilePackage.FMU__GENERATION_TOOL:
				setGenerationTool((String)newValue);
				return;
			case FMIProfilePackage.FMU__GENERATION_DATE_AND_TIME:
				setGenerationDateAndTime((String)newValue);
				return;
			case FMIProfilePackage.FMU__VARIABLE_NAMING_CONVENTION:
				setVariableNamingConvention((String)newValue);
				return;
			case FMIProfilePackage.FMU__NUMBER_OF_EVENT_INDICATORS:
				setNumberOfEventIndicators((Integer)newValue);
				return;
			case FMIProfilePackage.FMU__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case FMIProfilePackage.FMU__SOURCE_FILES:
				setSourceFiles((String)newValue);
				return;
			case FMIProfilePackage.FMU__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS:
				setCanBeInstantiatedOnlyOncePerProcess((Boolean)newValue);
				return;
			case FMIProfilePackage.FMU__CAN_GET_AND_SET_FM_USTATE:
				setCanGetAndSetFMUstate((Boolean)newValue);
				return;
			case FMIProfilePackage.FMU__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS:
				setCanNotUseMemoryManagementFunctions((Boolean)newValue);
				return;
			case FMIProfilePackage.FMU__CAN_SERIALIZE_FM_USTATE:
				setCanSerializeFMUstate((Boolean)newValue);
				return;
			case FMIProfilePackage.FMU__PROVIDES_DIRECTIONAL_DERIVATIVE:
				setProvidesDirectionalDerivative((Boolean)newValue);
				return;
			case FMIProfilePackage.FMU__NEEDS_EXECUTION_TOOL:
				setNeedsExecutionTool((Boolean)newValue);
				return;
			case FMIProfilePackage.FMU__MODEL_IDENTIFIER:
				setModelIdentifier((String)newValue);
				return;
			case FMIProfilePackage.FMU__FMU_BUNDLE:
				setFmuBundle((FMUBundle)newValue);
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
			case FMIProfilePackage.FMU__FMI_VERSION:
				setFmiVersion(FMI_VERSION_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__MODEL_NAME:
				setModelName(MODEL_NAME_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__GUID:
				setGuid(GUID_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__COPYRIGHT:
				setCopyright(COPYRIGHT_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__LICENSE:
				setLicense(LICENSE_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__GENERATION_TOOL:
				setGenerationTool(GENERATION_TOOL_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__GENERATION_DATE_AND_TIME:
				setGenerationDateAndTime(GENERATION_DATE_AND_TIME_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__VARIABLE_NAMING_CONVENTION:
				setVariableNamingConvention(VARIABLE_NAMING_CONVENTION_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__NUMBER_OF_EVENT_INDICATORS:
				setNumberOfEventIndicators(NUMBER_OF_EVENT_INDICATORS_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case FMIProfilePackage.FMU__SOURCE_FILES:
				setSourceFiles(SOURCE_FILES_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS:
				setCanBeInstantiatedOnlyOncePerProcess(CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__CAN_GET_AND_SET_FM_USTATE:
				setCanGetAndSetFMUstate(CAN_GET_AND_SET_FM_USTATE_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS:
				setCanNotUseMemoryManagementFunctions(CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__CAN_SERIALIZE_FM_USTATE:
				setCanSerializeFMUstate(CAN_SERIALIZE_FM_USTATE_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__PROVIDES_DIRECTIONAL_DERIVATIVE:
				setProvidesDirectionalDerivative(PROVIDES_DIRECTIONAL_DERIVATIVE_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__NEEDS_EXECUTION_TOOL:
				setNeedsExecutionTool(NEEDS_EXECUTION_TOOL_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__MODEL_IDENTIFIER:
				setModelIdentifier(MODEL_IDENTIFIER_EDEFAULT);
				return;
			case FMIProfilePackage.FMU__FMU_BUNDLE:
				setFmuBundle((FMUBundle)null);
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
			case FMIProfilePackage.FMU__FMI_VERSION:
				return FMI_VERSION_EDEFAULT == null ? fmiVersion != null : !FMI_VERSION_EDEFAULT.equals(fmiVersion);
			case FMIProfilePackage.FMU__MODEL_NAME:
				return MODEL_NAME_EDEFAULT == null ? modelName != null : !MODEL_NAME_EDEFAULT.equals(modelName);
			case FMIProfilePackage.FMU__GUID:
				return GUID_EDEFAULT == null ? guid != null : !GUID_EDEFAULT.equals(guid);
			case FMIProfilePackage.FMU__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case FMIProfilePackage.FMU__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
			case FMIProfilePackage.FMU__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case FMIProfilePackage.FMU__COPYRIGHT:
				return COPYRIGHT_EDEFAULT == null ? copyright != null : !COPYRIGHT_EDEFAULT.equals(copyright);
			case FMIProfilePackage.FMU__LICENSE:
				return LICENSE_EDEFAULT == null ? license != null : !LICENSE_EDEFAULT.equals(license);
			case FMIProfilePackage.FMU__GENERATION_TOOL:
				return GENERATION_TOOL_EDEFAULT == null ? generationTool != null : !GENERATION_TOOL_EDEFAULT.equals(generationTool);
			case FMIProfilePackage.FMU__GENERATION_DATE_AND_TIME:
				return GENERATION_DATE_AND_TIME_EDEFAULT == null ? generationDateAndTime != null : !GENERATION_DATE_AND_TIME_EDEFAULT.equals(generationDateAndTime);
			case FMIProfilePackage.FMU__VARIABLE_NAMING_CONVENTION:
				return VARIABLE_NAMING_CONVENTION_EDEFAULT == null ? variableNamingConvention != null : !VARIABLE_NAMING_CONVENTION_EDEFAULT.equals(variableNamingConvention);
			case FMIProfilePackage.FMU__NUMBER_OF_EVENT_INDICATORS:
				return numberOfEventIndicators != NUMBER_OF_EVENT_INDICATORS_EDEFAULT;
			case FMIProfilePackage.FMU__BASE_CLASS:
				return base_Class != null;
			case FMIProfilePackage.FMU__SOURCE_FILES:
				return SOURCE_FILES_EDEFAULT == null ? sourceFiles != null : !SOURCE_FILES_EDEFAULT.equals(sourceFiles);
			case FMIProfilePackage.FMU__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS:
				return canBeInstantiatedOnlyOncePerProcess != CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS_EDEFAULT;
			case FMIProfilePackage.FMU__CAN_GET_AND_SET_FM_USTATE:
				return canGetAndSetFMUstate != CAN_GET_AND_SET_FM_USTATE_EDEFAULT;
			case FMIProfilePackage.FMU__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS:
				return canNotUseMemoryManagementFunctions != CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS_EDEFAULT;
			case FMIProfilePackage.FMU__CAN_SERIALIZE_FM_USTATE:
				return canSerializeFMUstate != CAN_SERIALIZE_FM_USTATE_EDEFAULT;
			case FMIProfilePackage.FMU__PROVIDES_DIRECTIONAL_DERIVATIVE:
				return providesDirectionalDerivative != PROVIDES_DIRECTIONAL_DERIVATIVE_EDEFAULT;
			case FMIProfilePackage.FMU__NEEDS_EXECUTION_TOOL:
				return needsExecutionTool != NEEDS_EXECUTION_TOOL_EDEFAULT;
			case FMIProfilePackage.FMU__MODEL_IDENTIFIER:
				return MODEL_IDENTIFIER_EDEFAULT == null ? modelIdentifier != null : !MODEL_IDENTIFIER_EDEFAULT.equals(modelIdentifier);
			case FMIProfilePackage.FMU__MODEL_DESCRIPTION:
				return basicGetModelDescription() != null;
			case FMIProfilePackage.FMU__FMU_BUNDLE:
				return fmuBundle != null;
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
		result.append(" (fmiVersion: ");
		result.append(fmiVersion);
		result.append(", modelName: ");
		result.append(modelName);
		result.append(", guid: ");
		result.append(guid);
		result.append(", description: ");
		result.append(description);
		result.append(", author: ");
		result.append(author);
		result.append(", version: ");
		result.append(version);
		result.append(", copyright: ");
		result.append(copyright);
		result.append(", license: ");
		result.append(license);
		result.append(", generationTool: ");
		result.append(generationTool);
		result.append(", generationDateAndTime: ");
		result.append(generationDateAndTime);
		result.append(", variableNamingConvention: ");
		result.append(variableNamingConvention);
		result.append(", numberOfEventIndicators: ");
		result.append(numberOfEventIndicators);
		result.append(", sourceFiles: ");
		result.append(sourceFiles);
		result.append(", canBeInstantiatedOnlyOncePerProcess: ");
		result.append(canBeInstantiatedOnlyOncePerProcess);
		result.append(", canGetAndSetFMUstate: ");
		result.append(canGetAndSetFMUstate);
		result.append(", canNotUseMemoryManagementFunctions: ");
		result.append(canNotUseMemoryManagementFunctions);
		result.append(", canSerializeFMUstate: ");
		result.append(canSerializeFMUstate);
		result.append(", providesDirectionalDerivative: ");
		result.append(providesDirectionalDerivative);
		result.append(", needsExecutionTool: ");
		result.append(needsExecutionTool);
		result.append(", modelIdentifier: ");
		result.append(modelIdentifier);
		result.append(')');
		return result.toString();
	}

} //FMUImpl
