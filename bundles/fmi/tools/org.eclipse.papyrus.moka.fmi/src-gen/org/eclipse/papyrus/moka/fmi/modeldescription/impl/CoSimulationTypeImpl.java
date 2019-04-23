/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
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

import org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage;
import org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Co Simulation Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.CoSimulationTypeImpl#getSourceFiles <em>Source Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.CoSimulationTypeImpl#isCanBeInstantiatedOnlyOncePerProcess <em>Can Be Instantiated Only Once Per Process</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.CoSimulationTypeImpl#isCanGetAndSetFMUstate <em>Can Get And Set FM Ustate</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.CoSimulationTypeImpl#isCanHandleVariableCommunicationStepSize <em>Can Handle Variable Communication Step Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.CoSimulationTypeImpl#isCanInterpolateInputs <em>Can Interpolate Inputs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.CoSimulationTypeImpl#isCanNotUseMemoryManagementFunctions <em>Can Not Use Memory Management Functions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.CoSimulationTypeImpl#isCanRunAsynchronuously <em>Can Run Asynchronuously</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.CoSimulationTypeImpl#isCanSerializeFMUstate <em>Can Serialize FM Ustate</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.CoSimulationTypeImpl#getMaxOutputDerivativeOrder <em>Max Output Derivative Order</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.CoSimulationTypeImpl#getModelIdentifier <em>Model Identifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.CoSimulationTypeImpl#isNeedsExecutionTool <em>Needs Execution Tool</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.CoSimulationTypeImpl#isProvidesDirectionalDerivative <em>Provides Directional Derivative</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CoSimulationTypeImpl extends MinimalEObjectImpl.Container implements CoSimulationType {
	/**
	 * The cached value of the '{@link #getSourceFiles() <em>Source Files</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFiles()
	 * @generated
	 * @ordered
	 */
	protected SourceFilesType sourceFiles;

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
	 * The default value of the '{@link #isCanHandleVariableCommunicationStepSize() <em>Can Handle Variable Communication Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanHandleVariableCommunicationStepSize()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCanHandleVariableCommunicationStepSize() <em>Can Handle Variable Communication Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanHandleVariableCommunicationStepSize()
	 * @generated
	 * @ordered
	 */
	protected boolean canHandleVariableCommunicationStepSize = CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE_EDEFAULT;

	/**
	 * This is true if the Can Handle Variable Communication Step Size attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean canHandleVariableCommunicationStepSizeESet;

	/**
	 * The default value of the '{@link #isCanInterpolateInputs() <em>Can Interpolate Inputs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanInterpolateInputs()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CAN_INTERPOLATE_INPUTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCanInterpolateInputs() <em>Can Interpolate Inputs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanInterpolateInputs()
	 * @generated
	 * @ordered
	 */
	protected boolean canInterpolateInputs = CAN_INTERPOLATE_INPUTS_EDEFAULT;

	/**
	 * This is true if the Can Interpolate Inputs attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean canInterpolateInputsESet;

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
	 * The default value of the '{@link #isCanRunAsynchronuously() <em>Can Run Asynchronuously</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanRunAsynchronuously()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CAN_RUN_ASYNCHRONUOUSLY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCanRunAsynchronuously() <em>Can Run Asynchronuously</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanRunAsynchronuously()
	 * @generated
	 * @ordered
	 */
	protected boolean canRunAsynchronuously = CAN_RUN_ASYNCHRONUOUSLY_EDEFAULT;

	/**
	 * This is true if the Can Run Asynchronuously attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean canRunAsynchronuouslyESet;

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
	 * The default value of the '{@link #getMaxOutputDerivativeOrder() <em>Max Output Derivative Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxOutputDerivativeOrder()
	 * @generated
	 * @ordered
	 */
	protected static final long MAX_OUTPUT_DERIVATIVE_ORDER_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMaxOutputDerivativeOrder() <em>Max Output Derivative Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxOutputDerivativeOrder()
	 * @generated
	 * @ordered
	 */
	protected long maxOutputDerivativeOrder = MAX_OUTPUT_DERIVATIVE_ORDER_EDEFAULT;

	/**
	 * This is true if the Max Output Derivative Order attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maxOutputDerivativeOrderESet;

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
	protected CoSimulationTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FmiPackage.Literals.CO_SIMULATION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceFilesType getSourceFiles() {
		return sourceFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceFiles(SourceFilesType newSourceFiles, NotificationChain msgs) {
		SourceFilesType oldSourceFiles = sourceFiles;
		sourceFiles = newSourceFiles;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.CO_SIMULATION_TYPE__SOURCE_FILES, oldSourceFiles, newSourceFiles);
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
	public void setSourceFiles(SourceFilesType newSourceFiles) {
		if (newSourceFiles != sourceFiles) {
			NotificationChain msgs = null;
			if (sourceFiles != null)
				msgs = ((InternalEObject)sourceFiles).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.CO_SIMULATION_TYPE__SOURCE_FILES, null, msgs);
			if (newSourceFiles != null)
				msgs = ((InternalEObject)newSourceFiles).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.CO_SIMULATION_TYPE__SOURCE_FILES, null, msgs);
			msgs = basicSetSourceFiles(newSourceFiles, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.CO_SIMULATION_TYPE__SOURCE_FILES, newSourceFiles, newSourceFiles));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.CO_SIMULATION_TYPE__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS, oldCanBeInstantiatedOnlyOncePerProcess, canBeInstantiatedOnlyOncePerProcess, !oldCanBeInstantiatedOnlyOncePerProcessESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.CO_SIMULATION_TYPE__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS, oldCanBeInstantiatedOnlyOncePerProcess, CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS_EDEFAULT, oldCanBeInstantiatedOnlyOncePerProcessESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.CO_SIMULATION_TYPE__CAN_GET_AND_SET_FM_USTATE, oldCanGetAndSetFMUstate, canGetAndSetFMUstate, !oldCanGetAndSetFMUstateESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.CO_SIMULATION_TYPE__CAN_GET_AND_SET_FM_USTATE, oldCanGetAndSetFMUstate, CAN_GET_AND_SET_FM_USTATE_EDEFAULT, oldCanGetAndSetFMUstateESet));
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
	public boolean isCanHandleVariableCommunicationStepSize() {
		return canHandleVariableCommunicationStepSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCanHandleVariableCommunicationStepSize(boolean newCanHandleVariableCommunicationStepSize) {
		boolean oldCanHandleVariableCommunicationStepSize = canHandleVariableCommunicationStepSize;
		canHandleVariableCommunicationStepSize = newCanHandleVariableCommunicationStepSize;
		boolean oldCanHandleVariableCommunicationStepSizeESet = canHandleVariableCommunicationStepSizeESet;
		canHandleVariableCommunicationStepSizeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.CO_SIMULATION_TYPE__CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE, oldCanHandleVariableCommunicationStepSize, canHandleVariableCommunicationStepSize, !oldCanHandleVariableCommunicationStepSizeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCanHandleVariableCommunicationStepSize() {
		boolean oldCanHandleVariableCommunicationStepSize = canHandleVariableCommunicationStepSize;
		boolean oldCanHandleVariableCommunicationStepSizeESet = canHandleVariableCommunicationStepSizeESet;
		canHandleVariableCommunicationStepSize = CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE_EDEFAULT;
		canHandleVariableCommunicationStepSizeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.CO_SIMULATION_TYPE__CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE, oldCanHandleVariableCommunicationStepSize, CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE_EDEFAULT, oldCanHandleVariableCommunicationStepSizeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCanHandleVariableCommunicationStepSize() {
		return canHandleVariableCommunicationStepSizeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCanInterpolateInputs() {
		return canInterpolateInputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCanInterpolateInputs(boolean newCanInterpolateInputs) {
		boolean oldCanInterpolateInputs = canInterpolateInputs;
		canInterpolateInputs = newCanInterpolateInputs;
		boolean oldCanInterpolateInputsESet = canInterpolateInputsESet;
		canInterpolateInputsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.CO_SIMULATION_TYPE__CAN_INTERPOLATE_INPUTS, oldCanInterpolateInputs, canInterpolateInputs, !oldCanInterpolateInputsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCanInterpolateInputs() {
		boolean oldCanInterpolateInputs = canInterpolateInputs;
		boolean oldCanInterpolateInputsESet = canInterpolateInputsESet;
		canInterpolateInputs = CAN_INTERPOLATE_INPUTS_EDEFAULT;
		canInterpolateInputsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.CO_SIMULATION_TYPE__CAN_INTERPOLATE_INPUTS, oldCanInterpolateInputs, CAN_INTERPOLATE_INPUTS_EDEFAULT, oldCanInterpolateInputsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCanInterpolateInputs() {
		return canInterpolateInputsESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.CO_SIMULATION_TYPE__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS, oldCanNotUseMemoryManagementFunctions, canNotUseMemoryManagementFunctions, !oldCanNotUseMemoryManagementFunctionsESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.CO_SIMULATION_TYPE__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS, oldCanNotUseMemoryManagementFunctions, CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS_EDEFAULT, oldCanNotUseMemoryManagementFunctionsESet));
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
	public boolean isCanRunAsynchronuously() {
		return canRunAsynchronuously;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCanRunAsynchronuously(boolean newCanRunAsynchronuously) {
		boolean oldCanRunAsynchronuously = canRunAsynchronuously;
		canRunAsynchronuously = newCanRunAsynchronuously;
		boolean oldCanRunAsynchronuouslyESet = canRunAsynchronuouslyESet;
		canRunAsynchronuouslyESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.CO_SIMULATION_TYPE__CAN_RUN_ASYNCHRONUOUSLY, oldCanRunAsynchronuously, canRunAsynchronuously, !oldCanRunAsynchronuouslyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCanRunAsynchronuously() {
		boolean oldCanRunAsynchronuously = canRunAsynchronuously;
		boolean oldCanRunAsynchronuouslyESet = canRunAsynchronuouslyESet;
		canRunAsynchronuously = CAN_RUN_ASYNCHRONUOUSLY_EDEFAULT;
		canRunAsynchronuouslyESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.CO_SIMULATION_TYPE__CAN_RUN_ASYNCHRONUOUSLY, oldCanRunAsynchronuously, CAN_RUN_ASYNCHRONUOUSLY_EDEFAULT, oldCanRunAsynchronuouslyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCanRunAsynchronuously() {
		return canRunAsynchronuouslyESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.CO_SIMULATION_TYPE__CAN_SERIALIZE_FM_USTATE, oldCanSerializeFMUstate, canSerializeFMUstate, !oldCanSerializeFMUstateESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.CO_SIMULATION_TYPE__CAN_SERIALIZE_FM_USTATE, oldCanSerializeFMUstate, CAN_SERIALIZE_FM_USTATE_EDEFAULT, oldCanSerializeFMUstateESet));
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
	public long getMaxOutputDerivativeOrder() {
		return maxOutputDerivativeOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaxOutputDerivativeOrder(long newMaxOutputDerivativeOrder) {
		long oldMaxOutputDerivativeOrder = maxOutputDerivativeOrder;
		maxOutputDerivativeOrder = newMaxOutputDerivativeOrder;
		boolean oldMaxOutputDerivativeOrderESet = maxOutputDerivativeOrderESet;
		maxOutputDerivativeOrderESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.CO_SIMULATION_TYPE__MAX_OUTPUT_DERIVATIVE_ORDER, oldMaxOutputDerivativeOrder, maxOutputDerivativeOrder, !oldMaxOutputDerivativeOrderESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMaxOutputDerivativeOrder() {
		long oldMaxOutputDerivativeOrder = maxOutputDerivativeOrder;
		boolean oldMaxOutputDerivativeOrderESet = maxOutputDerivativeOrderESet;
		maxOutputDerivativeOrder = MAX_OUTPUT_DERIVATIVE_ORDER_EDEFAULT;
		maxOutputDerivativeOrderESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.CO_SIMULATION_TYPE__MAX_OUTPUT_DERIVATIVE_ORDER, oldMaxOutputDerivativeOrder, MAX_OUTPUT_DERIVATIVE_ORDER_EDEFAULT, oldMaxOutputDerivativeOrderESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMaxOutputDerivativeOrder() {
		return maxOutputDerivativeOrderESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.CO_SIMULATION_TYPE__MODEL_IDENTIFIER, oldModelIdentifier, modelIdentifier));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.CO_SIMULATION_TYPE__NEEDS_EXECUTION_TOOL, oldNeedsExecutionTool, needsExecutionTool, !oldNeedsExecutionToolESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.CO_SIMULATION_TYPE__NEEDS_EXECUTION_TOOL, oldNeedsExecutionTool, NEEDS_EXECUTION_TOOL_EDEFAULT, oldNeedsExecutionToolESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.CO_SIMULATION_TYPE__PROVIDES_DIRECTIONAL_DERIVATIVE, oldProvidesDirectionalDerivative, providesDirectionalDerivative, !oldProvidesDirectionalDerivativeESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.CO_SIMULATION_TYPE__PROVIDES_DIRECTIONAL_DERIVATIVE, oldProvidesDirectionalDerivative, PROVIDES_DIRECTIONAL_DERIVATIVE_EDEFAULT, oldProvidesDirectionalDerivativeESet));
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
			case FmiPackage.CO_SIMULATION_TYPE__SOURCE_FILES:
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
			case FmiPackage.CO_SIMULATION_TYPE__SOURCE_FILES:
				return getSourceFiles();
			case FmiPackage.CO_SIMULATION_TYPE__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS:
				return isCanBeInstantiatedOnlyOncePerProcess();
			case FmiPackage.CO_SIMULATION_TYPE__CAN_GET_AND_SET_FM_USTATE:
				return isCanGetAndSetFMUstate();
			case FmiPackage.CO_SIMULATION_TYPE__CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE:
				return isCanHandleVariableCommunicationStepSize();
			case FmiPackage.CO_SIMULATION_TYPE__CAN_INTERPOLATE_INPUTS:
				return isCanInterpolateInputs();
			case FmiPackage.CO_SIMULATION_TYPE__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS:
				return isCanNotUseMemoryManagementFunctions();
			case FmiPackage.CO_SIMULATION_TYPE__CAN_RUN_ASYNCHRONUOUSLY:
				return isCanRunAsynchronuously();
			case FmiPackage.CO_SIMULATION_TYPE__CAN_SERIALIZE_FM_USTATE:
				return isCanSerializeFMUstate();
			case FmiPackage.CO_SIMULATION_TYPE__MAX_OUTPUT_DERIVATIVE_ORDER:
				return getMaxOutputDerivativeOrder();
			case FmiPackage.CO_SIMULATION_TYPE__MODEL_IDENTIFIER:
				return getModelIdentifier();
			case FmiPackage.CO_SIMULATION_TYPE__NEEDS_EXECUTION_TOOL:
				return isNeedsExecutionTool();
			case FmiPackage.CO_SIMULATION_TYPE__PROVIDES_DIRECTIONAL_DERIVATIVE:
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
			case FmiPackage.CO_SIMULATION_TYPE__SOURCE_FILES:
				setSourceFiles((SourceFilesType)newValue);
				return;
			case FmiPackage.CO_SIMULATION_TYPE__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS:
				setCanBeInstantiatedOnlyOncePerProcess((Boolean)newValue);
				return;
			case FmiPackage.CO_SIMULATION_TYPE__CAN_GET_AND_SET_FM_USTATE:
				setCanGetAndSetFMUstate((Boolean)newValue);
				return;
			case FmiPackage.CO_SIMULATION_TYPE__CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE:
				setCanHandleVariableCommunicationStepSize((Boolean)newValue);
				return;
			case FmiPackage.CO_SIMULATION_TYPE__CAN_INTERPOLATE_INPUTS:
				setCanInterpolateInputs((Boolean)newValue);
				return;
			case FmiPackage.CO_SIMULATION_TYPE__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS:
				setCanNotUseMemoryManagementFunctions((Boolean)newValue);
				return;
			case FmiPackage.CO_SIMULATION_TYPE__CAN_RUN_ASYNCHRONUOUSLY:
				setCanRunAsynchronuously((Boolean)newValue);
				return;
			case FmiPackage.CO_SIMULATION_TYPE__CAN_SERIALIZE_FM_USTATE:
				setCanSerializeFMUstate((Boolean)newValue);
				return;
			case FmiPackage.CO_SIMULATION_TYPE__MAX_OUTPUT_DERIVATIVE_ORDER:
				setMaxOutputDerivativeOrder((Long)newValue);
				return;
			case FmiPackage.CO_SIMULATION_TYPE__MODEL_IDENTIFIER:
				setModelIdentifier((String)newValue);
				return;
			case FmiPackage.CO_SIMULATION_TYPE__NEEDS_EXECUTION_TOOL:
				setNeedsExecutionTool((Boolean)newValue);
				return;
			case FmiPackage.CO_SIMULATION_TYPE__PROVIDES_DIRECTIONAL_DERIVATIVE:
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
			case FmiPackage.CO_SIMULATION_TYPE__SOURCE_FILES:
				setSourceFiles((SourceFilesType)null);
				return;
			case FmiPackage.CO_SIMULATION_TYPE__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS:
				unsetCanBeInstantiatedOnlyOncePerProcess();
				return;
			case FmiPackage.CO_SIMULATION_TYPE__CAN_GET_AND_SET_FM_USTATE:
				unsetCanGetAndSetFMUstate();
				return;
			case FmiPackage.CO_SIMULATION_TYPE__CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE:
				unsetCanHandleVariableCommunicationStepSize();
				return;
			case FmiPackage.CO_SIMULATION_TYPE__CAN_INTERPOLATE_INPUTS:
				unsetCanInterpolateInputs();
				return;
			case FmiPackage.CO_SIMULATION_TYPE__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS:
				unsetCanNotUseMemoryManagementFunctions();
				return;
			case FmiPackage.CO_SIMULATION_TYPE__CAN_RUN_ASYNCHRONUOUSLY:
				unsetCanRunAsynchronuously();
				return;
			case FmiPackage.CO_SIMULATION_TYPE__CAN_SERIALIZE_FM_USTATE:
				unsetCanSerializeFMUstate();
				return;
			case FmiPackage.CO_SIMULATION_TYPE__MAX_OUTPUT_DERIVATIVE_ORDER:
				unsetMaxOutputDerivativeOrder();
				return;
			case FmiPackage.CO_SIMULATION_TYPE__MODEL_IDENTIFIER:
				setModelIdentifier(MODEL_IDENTIFIER_EDEFAULT);
				return;
			case FmiPackage.CO_SIMULATION_TYPE__NEEDS_EXECUTION_TOOL:
				unsetNeedsExecutionTool();
				return;
			case FmiPackage.CO_SIMULATION_TYPE__PROVIDES_DIRECTIONAL_DERIVATIVE:
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
			case FmiPackage.CO_SIMULATION_TYPE__SOURCE_FILES:
				return sourceFiles != null;
			case FmiPackage.CO_SIMULATION_TYPE__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS:
				return isSetCanBeInstantiatedOnlyOncePerProcess();
			case FmiPackage.CO_SIMULATION_TYPE__CAN_GET_AND_SET_FM_USTATE:
				return isSetCanGetAndSetFMUstate();
			case FmiPackage.CO_SIMULATION_TYPE__CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE:
				return isSetCanHandleVariableCommunicationStepSize();
			case FmiPackage.CO_SIMULATION_TYPE__CAN_INTERPOLATE_INPUTS:
				return isSetCanInterpolateInputs();
			case FmiPackage.CO_SIMULATION_TYPE__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS:
				return isSetCanNotUseMemoryManagementFunctions();
			case FmiPackage.CO_SIMULATION_TYPE__CAN_RUN_ASYNCHRONUOUSLY:
				return isSetCanRunAsynchronuously();
			case FmiPackage.CO_SIMULATION_TYPE__CAN_SERIALIZE_FM_USTATE:
				return isSetCanSerializeFMUstate();
			case FmiPackage.CO_SIMULATION_TYPE__MAX_OUTPUT_DERIVATIVE_ORDER:
				return isSetMaxOutputDerivativeOrder();
			case FmiPackage.CO_SIMULATION_TYPE__MODEL_IDENTIFIER:
				return MODEL_IDENTIFIER_EDEFAULT == null ? modelIdentifier != null : !MODEL_IDENTIFIER_EDEFAULT.equals(modelIdentifier);
			case FmiPackage.CO_SIMULATION_TYPE__NEEDS_EXECUTION_TOOL:
				return isSetNeedsExecutionTool();
			case FmiPackage.CO_SIMULATION_TYPE__PROVIDES_DIRECTIONAL_DERIVATIVE:
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
		result.append(", canHandleVariableCommunicationStepSize: ");
		if (canHandleVariableCommunicationStepSizeESet) result.append(canHandleVariableCommunicationStepSize); else result.append("<unset>");
		result.append(", canInterpolateInputs: ");
		if (canInterpolateInputsESet) result.append(canInterpolateInputs); else result.append("<unset>");
		result.append(", canNotUseMemoryManagementFunctions: ");
		if (canNotUseMemoryManagementFunctionsESet) result.append(canNotUseMemoryManagementFunctions); else result.append("<unset>");
		result.append(", canRunAsynchronuously: ");
		if (canRunAsynchronuouslyESet) result.append(canRunAsynchronuously); else result.append("<unset>");
		result.append(", canSerializeFMUstate: ");
		if (canSerializeFMUstateESet) result.append(canSerializeFMUstate); else result.append("<unset>");
		result.append(", maxOutputDerivativeOrder: ");
		if (maxOutputDerivativeOrderESet) result.append(maxOutputDerivativeOrder); else result.append("<unset>");
		result.append(", modelIdentifier: ");
		result.append(modelIdentifier);
		result.append(", needsExecutionTool: ");
		if (needsExecutionToolESet) result.append(needsExecutionTool); else result.append("<unset>");
		result.append(", providesDirectionalDerivative: ");
		if (providesDirectionalDerivativeESet) result.append(providesDirectionalDerivative); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //CoSimulationTypeImpl
