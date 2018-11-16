/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.fmi.modeldescription.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage;
import org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType;
import org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Exchange Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelExchangeTypeImpl#getSourceFiles <em>Source Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelExchangeTypeImpl#isCanBeInstantiatedOnlyOncePerProcess <em>Can Be Instantiated Only Once Per Process</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelExchangeTypeImpl#isCanGetAndSetFMUstate <em>Can Get And Set FM Ustate</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelExchangeTypeImpl#isCanNotUseMemoryManagementFunctions <em>Can Not Use Memory Management Functions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelExchangeTypeImpl#isCanSerializeFMUstate <em>Can Serialize FM Ustate</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelExchangeTypeImpl#isCompletedIntegratorStepNotNeeded <em>Completed Integrator Step Not Needed</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelExchangeTypeImpl#getModelIdentifier <em>Model Identifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelExchangeTypeImpl#isNeedsExecutionTool <em>Needs Execution Tool</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelExchangeTypeImpl#isProvidesDirectionalDerivative <em>Provides Directional Derivative</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelExchangeTypeImpl extends MinimalEObjectImpl.Container implements ModelExchangeType {
	/**
	 * The cached value of the '{@link #getSourceFiles() <em>Source Files</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFiles()
	 * @generated
	 * @ordered
	 */
	protected SourceFilesType1 sourceFiles;

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
	 * This is true if the Can Be Instantiated Only Once Per Process attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean canBeInstantiatedOnlyOncePerProcessESet;

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
	 * This is true if the Can Get And Set FM Ustate attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean canGetAndSetFMUstateESet;

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
	 * This is true if the Can Not Use Memory Management Functions attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean canNotUseMemoryManagementFunctionsESet;

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
	 * This is true if the Can Serialize FM Ustate attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean canSerializeFMUstateESet;

	/**
	 * The default value of the '{@link #isCompletedIntegratorStepNotNeeded() <em>Completed Integrator Step Not Needed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCompletedIntegratorStepNotNeeded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPLETED_INTEGRATOR_STEP_NOT_NEEDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCompletedIntegratorStepNotNeeded() <em>Completed Integrator Step Not Needed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCompletedIntegratorStepNotNeeded()
	 * @generated
	 * @ordered
	 */
	protected boolean completedIntegratorStepNotNeeded = COMPLETED_INTEGRATOR_STEP_NOT_NEEDED_EDEFAULT;

	/**
	 * This is true if the Completed Integrator Step Not Needed attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean completedIntegratorStepNotNeededESet;

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
	 * This is true if the Needs Execution Tool attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean needsExecutionToolESet;

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
	 * This is true if the Provides Directional Derivative attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean providesDirectionalDerivativeESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelExchangeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FmiPackage.Literals.MODEL_EXCHANGE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceFilesType1 getSourceFiles() {
		return sourceFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceFiles(SourceFilesType1 newSourceFiles, NotificationChain msgs) {
		SourceFilesType1 oldSourceFiles = sourceFiles;
		sourceFiles = newSourceFiles;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.MODEL_EXCHANGE_TYPE__SOURCE_FILES, oldSourceFiles, newSourceFiles);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourceFiles(SourceFilesType1 newSourceFiles) {
		if (newSourceFiles != sourceFiles) {
			NotificationChain msgs = null;
			if (sourceFiles != null)
				msgs = ((InternalEObject)sourceFiles).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.MODEL_EXCHANGE_TYPE__SOURCE_FILES, null, msgs);
			if (newSourceFiles != null)
				msgs = ((InternalEObject)newSourceFiles).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.MODEL_EXCHANGE_TYPE__SOURCE_FILES, null, msgs);
			msgs = basicSetSourceFiles(newSourceFiles, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.MODEL_EXCHANGE_TYPE__SOURCE_FILES, newSourceFiles, newSourceFiles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCanBeInstantiatedOnlyOncePerProcess() {
		return canBeInstantiatedOnlyOncePerProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCanBeInstantiatedOnlyOncePerProcess(boolean newCanBeInstantiatedOnlyOncePerProcess) {
		boolean oldCanBeInstantiatedOnlyOncePerProcess = canBeInstantiatedOnlyOncePerProcess;
		canBeInstantiatedOnlyOncePerProcess = newCanBeInstantiatedOnlyOncePerProcess;
		boolean oldCanBeInstantiatedOnlyOncePerProcessESet = canBeInstantiatedOnlyOncePerProcessESet;
		canBeInstantiatedOnlyOncePerProcessESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.MODEL_EXCHANGE_TYPE__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS, oldCanBeInstantiatedOnlyOncePerProcess, canBeInstantiatedOnlyOncePerProcess, !oldCanBeInstantiatedOnlyOncePerProcessESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCanBeInstantiatedOnlyOncePerProcess() {
		boolean oldCanBeInstantiatedOnlyOncePerProcess = canBeInstantiatedOnlyOncePerProcess;
		boolean oldCanBeInstantiatedOnlyOncePerProcessESet = canBeInstantiatedOnlyOncePerProcessESet;
		canBeInstantiatedOnlyOncePerProcess = CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS_EDEFAULT;
		canBeInstantiatedOnlyOncePerProcessESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.MODEL_EXCHANGE_TYPE__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS, oldCanBeInstantiatedOnlyOncePerProcess, CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS_EDEFAULT, oldCanBeInstantiatedOnlyOncePerProcessESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCanBeInstantiatedOnlyOncePerProcess() {
		return canBeInstantiatedOnlyOncePerProcessESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCanGetAndSetFMUstate() {
		return canGetAndSetFMUstate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCanGetAndSetFMUstate(boolean newCanGetAndSetFMUstate) {
		boolean oldCanGetAndSetFMUstate = canGetAndSetFMUstate;
		canGetAndSetFMUstate = newCanGetAndSetFMUstate;
		boolean oldCanGetAndSetFMUstateESet = canGetAndSetFMUstateESet;
		canGetAndSetFMUstateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.MODEL_EXCHANGE_TYPE__CAN_GET_AND_SET_FM_USTATE, oldCanGetAndSetFMUstate, canGetAndSetFMUstate, !oldCanGetAndSetFMUstateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCanGetAndSetFMUstate() {
		boolean oldCanGetAndSetFMUstate = canGetAndSetFMUstate;
		boolean oldCanGetAndSetFMUstateESet = canGetAndSetFMUstateESet;
		canGetAndSetFMUstate = CAN_GET_AND_SET_FM_USTATE_EDEFAULT;
		canGetAndSetFMUstateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.MODEL_EXCHANGE_TYPE__CAN_GET_AND_SET_FM_USTATE, oldCanGetAndSetFMUstate, CAN_GET_AND_SET_FM_USTATE_EDEFAULT, oldCanGetAndSetFMUstateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCanGetAndSetFMUstate() {
		return canGetAndSetFMUstateESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCanNotUseMemoryManagementFunctions() {
		return canNotUseMemoryManagementFunctions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCanNotUseMemoryManagementFunctions(boolean newCanNotUseMemoryManagementFunctions) {
		boolean oldCanNotUseMemoryManagementFunctions = canNotUseMemoryManagementFunctions;
		canNotUseMemoryManagementFunctions = newCanNotUseMemoryManagementFunctions;
		boolean oldCanNotUseMemoryManagementFunctionsESet = canNotUseMemoryManagementFunctionsESet;
		canNotUseMemoryManagementFunctionsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.MODEL_EXCHANGE_TYPE__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS, oldCanNotUseMemoryManagementFunctions, canNotUseMemoryManagementFunctions, !oldCanNotUseMemoryManagementFunctionsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCanNotUseMemoryManagementFunctions() {
		boolean oldCanNotUseMemoryManagementFunctions = canNotUseMemoryManagementFunctions;
		boolean oldCanNotUseMemoryManagementFunctionsESet = canNotUseMemoryManagementFunctionsESet;
		canNotUseMemoryManagementFunctions = CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS_EDEFAULT;
		canNotUseMemoryManagementFunctionsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.MODEL_EXCHANGE_TYPE__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS, oldCanNotUseMemoryManagementFunctions, CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS_EDEFAULT, oldCanNotUseMemoryManagementFunctionsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCanNotUseMemoryManagementFunctions() {
		return canNotUseMemoryManagementFunctionsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCanSerializeFMUstate() {
		return canSerializeFMUstate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCanSerializeFMUstate(boolean newCanSerializeFMUstate) {
		boolean oldCanSerializeFMUstate = canSerializeFMUstate;
		canSerializeFMUstate = newCanSerializeFMUstate;
		boolean oldCanSerializeFMUstateESet = canSerializeFMUstateESet;
		canSerializeFMUstateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.MODEL_EXCHANGE_TYPE__CAN_SERIALIZE_FM_USTATE, oldCanSerializeFMUstate, canSerializeFMUstate, !oldCanSerializeFMUstateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCanSerializeFMUstate() {
		boolean oldCanSerializeFMUstate = canSerializeFMUstate;
		boolean oldCanSerializeFMUstateESet = canSerializeFMUstateESet;
		canSerializeFMUstate = CAN_SERIALIZE_FM_USTATE_EDEFAULT;
		canSerializeFMUstateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.MODEL_EXCHANGE_TYPE__CAN_SERIALIZE_FM_USTATE, oldCanSerializeFMUstate, CAN_SERIALIZE_FM_USTATE_EDEFAULT, oldCanSerializeFMUstateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCanSerializeFMUstate() {
		return canSerializeFMUstateESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCompletedIntegratorStepNotNeeded() {
		return completedIntegratorStepNotNeeded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompletedIntegratorStepNotNeeded(boolean newCompletedIntegratorStepNotNeeded) {
		boolean oldCompletedIntegratorStepNotNeeded = completedIntegratorStepNotNeeded;
		completedIntegratorStepNotNeeded = newCompletedIntegratorStepNotNeeded;
		boolean oldCompletedIntegratorStepNotNeededESet = completedIntegratorStepNotNeededESet;
		completedIntegratorStepNotNeededESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.MODEL_EXCHANGE_TYPE__COMPLETED_INTEGRATOR_STEP_NOT_NEEDED, oldCompletedIntegratorStepNotNeeded, completedIntegratorStepNotNeeded, !oldCompletedIntegratorStepNotNeededESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCompletedIntegratorStepNotNeeded() {
		boolean oldCompletedIntegratorStepNotNeeded = completedIntegratorStepNotNeeded;
		boolean oldCompletedIntegratorStepNotNeededESet = completedIntegratorStepNotNeededESet;
		completedIntegratorStepNotNeeded = COMPLETED_INTEGRATOR_STEP_NOT_NEEDED_EDEFAULT;
		completedIntegratorStepNotNeededESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.MODEL_EXCHANGE_TYPE__COMPLETED_INTEGRATOR_STEP_NOT_NEEDED, oldCompletedIntegratorStepNotNeeded, COMPLETED_INTEGRATOR_STEP_NOT_NEEDED_EDEFAULT, oldCompletedIntegratorStepNotNeededESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCompletedIntegratorStepNotNeeded() {
		return completedIntegratorStepNotNeededESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getModelIdentifier() {
		return modelIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelIdentifier(String newModelIdentifier) {
		String oldModelIdentifier = modelIdentifier;
		modelIdentifier = newModelIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.MODEL_EXCHANGE_TYPE__MODEL_IDENTIFIER, oldModelIdentifier, modelIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNeedsExecutionTool() {
		return needsExecutionTool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNeedsExecutionTool(boolean newNeedsExecutionTool) {
		boolean oldNeedsExecutionTool = needsExecutionTool;
		needsExecutionTool = newNeedsExecutionTool;
		boolean oldNeedsExecutionToolESet = needsExecutionToolESet;
		needsExecutionToolESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.MODEL_EXCHANGE_TYPE__NEEDS_EXECUTION_TOOL, oldNeedsExecutionTool, needsExecutionTool, !oldNeedsExecutionToolESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetNeedsExecutionTool() {
		boolean oldNeedsExecutionTool = needsExecutionTool;
		boolean oldNeedsExecutionToolESet = needsExecutionToolESet;
		needsExecutionTool = NEEDS_EXECUTION_TOOL_EDEFAULT;
		needsExecutionToolESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.MODEL_EXCHANGE_TYPE__NEEDS_EXECUTION_TOOL, oldNeedsExecutionTool, NEEDS_EXECUTION_TOOL_EDEFAULT, oldNeedsExecutionToolESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetNeedsExecutionTool() {
		return needsExecutionToolESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isProvidesDirectionalDerivative() {
		return providesDirectionalDerivative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProvidesDirectionalDerivative(boolean newProvidesDirectionalDerivative) {
		boolean oldProvidesDirectionalDerivative = providesDirectionalDerivative;
		providesDirectionalDerivative = newProvidesDirectionalDerivative;
		boolean oldProvidesDirectionalDerivativeESet = providesDirectionalDerivativeESet;
		providesDirectionalDerivativeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.MODEL_EXCHANGE_TYPE__PROVIDES_DIRECTIONAL_DERIVATIVE, oldProvidesDirectionalDerivative, providesDirectionalDerivative, !oldProvidesDirectionalDerivativeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetProvidesDirectionalDerivative() {
		boolean oldProvidesDirectionalDerivative = providesDirectionalDerivative;
		boolean oldProvidesDirectionalDerivativeESet = providesDirectionalDerivativeESet;
		providesDirectionalDerivative = PROVIDES_DIRECTIONAL_DERIVATIVE_EDEFAULT;
		providesDirectionalDerivativeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.MODEL_EXCHANGE_TYPE__PROVIDES_DIRECTIONAL_DERIVATIVE, oldProvidesDirectionalDerivative, PROVIDES_DIRECTIONAL_DERIVATIVE_EDEFAULT, oldProvidesDirectionalDerivativeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetProvidesDirectionalDerivative() {
		return providesDirectionalDerivativeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FmiPackage.MODEL_EXCHANGE_TYPE__SOURCE_FILES:
				return basicSetSourceFiles(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FmiPackage.MODEL_EXCHANGE_TYPE__SOURCE_FILES:
				return getSourceFiles();
			case FmiPackage.MODEL_EXCHANGE_TYPE__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS:
				return isCanBeInstantiatedOnlyOncePerProcess();
			case FmiPackage.MODEL_EXCHANGE_TYPE__CAN_GET_AND_SET_FM_USTATE:
				return isCanGetAndSetFMUstate();
			case FmiPackage.MODEL_EXCHANGE_TYPE__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS:
				return isCanNotUseMemoryManagementFunctions();
			case FmiPackage.MODEL_EXCHANGE_TYPE__CAN_SERIALIZE_FM_USTATE:
				return isCanSerializeFMUstate();
			case FmiPackage.MODEL_EXCHANGE_TYPE__COMPLETED_INTEGRATOR_STEP_NOT_NEEDED:
				return isCompletedIntegratorStepNotNeeded();
			case FmiPackage.MODEL_EXCHANGE_TYPE__MODEL_IDENTIFIER:
				return getModelIdentifier();
			case FmiPackage.MODEL_EXCHANGE_TYPE__NEEDS_EXECUTION_TOOL:
				return isNeedsExecutionTool();
			case FmiPackage.MODEL_EXCHANGE_TYPE__PROVIDES_DIRECTIONAL_DERIVATIVE:
				return isProvidesDirectionalDerivative();
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
			case FmiPackage.MODEL_EXCHANGE_TYPE__SOURCE_FILES:
				setSourceFiles((SourceFilesType1)newValue);
				return;
			case FmiPackage.MODEL_EXCHANGE_TYPE__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS:
				setCanBeInstantiatedOnlyOncePerProcess((Boolean)newValue);
				return;
			case FmiPackage.MODEL_EXCHANGE_TYPE__CAN_GET_AND_SET_FM_USTATE:
				setCanGetAndSetFMUstate((Boolean)newValue);
				return;
			case FmiPackage.MODEL_EXCHANGE_TYPE__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS:
				setCanNotUseMemoryManagementFunctions((Boolean)newValue);
				return;
			case FmiPackage.MODEL_EXCHANGE_TYPE__CAN_SERIALIZE_FM_USTATE:
				setCanSerializeFMUstate((Boolean)newValue);
				return;
			case FmiPackage.MODEL_EXCHANGE_TYPE__COMPLETED_INTEGRATOR_STEP_NOT_NEEDED:
				setCompletedIntegratorStepNotNeeded((Boolean)newValue);
				return;
			case FmiPackage.MODEL_EXCHANGE_TYPE__MODEL_IDENTIFIER:
				setModelIdentifier((String)newValue);
				return;
			case FmiPackage.MODEL_EXCHANGE_TYPE__NEEDS_EXECUTION_TOOL:
				setNeedsExecutionTool((Boolean)newValue);
				return;
			case FmiPackage.MODEL_EXCHANGE_TYPE__PROVIDES_DIRECTIONAL_DERIVATIVE:
				setProvidesDirectionalDerivative((Boolean)newValue);
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
			case FmiPackage.MODEL_EXCHANGE_TYPE__SOURCE_FILES:
				setSourceFiles((SourceFilesType1)null);
				return;
			case FmiPackage.MODEL_EXCHANGE_TYPE__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS:
				unsetCanBeInstantiatedOnlyOncePerProcess();
				return;
			case FmiPackage.MODEL_EXCHANGE_TYPE__CAN_GET_AND_SET_FM_USTATE:
				unsetCanGetAndSetFMUstate();
				return;
			case FmiPackage.MODEL_EXCHANGE_TYPE__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS:
				unsetCanNotUseMemoryManagementFunctions();
				return;
			case FmiPackage.MODEL_EXCHANGE_TYPE__CAN_SERIALIZE_FM_USTATE:
				unsetCanSerializeFMUstate();
				return;
			case FmiPackage.MODEL_EXCHANGE_TYPE__COMPLETED_INTEGRATOR_STEP_NOT_NEEDED:
				unsetCompletedIntegratorStepNotNeeded();
				return;
			case FmiPackage.MODEL_EXCHANGE_TYPE__MODEL_IDENTIFIER:
				setModelIdentifier(MODEL_IDENTIFIER_EDEFAULT);
				return;
			case FmiPackage.MODEL_EXCHANGE_TYPE__NEEDS_EXECUTION_TOOL:
				unsetNeedsExecutionTool();
				return;
			case FmiPackage.MODEL_EXCHANGE_TYPE__PROVIDES_DIRECTIONAL_DERIVATIVE:
				unsetProvidesDirectionalDerivative();
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
			case FmiPackage.MODEL_EXCHANGE_TYPE__SOURCE_FILES:
				return sourceFiles != null;
			case FmiPackage.MODEL_EXCHANGE_TYPE__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS:
				return isSetCanBeInstantiatedOnlyOncePerProcess();
			case FmiPackage.MODEL_EXCHANGE_TYPE__CAN_GET_AND_SET_FM_USTATE:
				return isSetCanGetAndSetFMUstate();
			case FmiPackage.MODEL_EXCHANGE_TYPE__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS:
				return isSetCanNotUseMemoryManagementFunctions();
			case FmiPackage.MODEL_EXCHANGE_TYPE__CAN_SERIALIZE_FM_USTATE:
				return isSetCanSerializeFMUstate();
			case FmiPackage.MODEL_EXCHANGE_TYPE__COMPLETED_INTEGRATOR_STEP_NOT_NEEDED:
				return isSetCompletedIntegratorStepNotNeeded();
			case FmiPackage.MODEL_EXCHANGE_TYPE__MODEL_IDENTIFIER:
				return MODEL_IDENTIFIER_EDEFAULT == null ? modelIdentifier != null : !MODEL_IDENTIFIER_EDEFAULT.equals(modelIdentifier);
			case FmiPackage.MODEL_EXCHANGE_TYPE__NEEDS_EXECUTION_TOOL:
				return isSetNeedsExecutionTool();
			case FmiPackage.MODEL_EXCHANGE_TYPE__PROVIDES_DIRECTIONAL_DERIVATIVE:
				return isSetProvidesDirectionalDerivative();
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
		result.append(" (canBeInstantiatedOnlyOncePerProcess: ");
		if (canBeInstantiatedOnlyOncePerProcessESet) result.append(canBeInstantiatedOnlyOncePerProcess); else result.append("<unset>");
		result.append(", canGetAndSetFMUstate: ");
		if (canGetAndSetFMUstateESet) result.append(canGetAndSetFMUstate); else result.append("<unset>");
		result.append(", canNotUseMemoryManagementFunctions: ");
		if (canNotUseMemoryManagementFunctionsESet) result.append(canNotUseMemoryManagementFunctions); else result.append("<unset>");
		result.append(", canSerializeFMUstate: ");
		if (canSerializeFMUstateESet) result.append(canSerializeFMUstate); else result.append("<unset>");
		result.append(", completedIntegratorStepNotNeeded: ");
		if (completedIntegratorStepNotNeededESet) result.append(completedIntegratorStepNotNeeded); else result.append("<unset>");
		result.append(", modelIdentifier: ");
		result.append(modelIdentifier);
		result.append(", needsExecutionTool: ");
		if (needsExecutionToolESet) result.append(needsExecutionTool); else result.append("<unset>");
		result.append(", providesDirectionalDerivative: ");
		if (providesDirectionalDerivativeESet) result.append(providesDirectionalDerivative); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ModelExchangeTypeImpl
