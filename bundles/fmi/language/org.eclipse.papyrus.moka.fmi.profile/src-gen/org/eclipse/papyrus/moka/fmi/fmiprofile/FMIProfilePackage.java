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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfileFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='FMIProfile'"
 * @generated
 */
public interface FMIProfilePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "fmiprofile";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/FMIProfile/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "fmiprofile";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FMIProfilePackage eINSTANCE = org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl <em>FMU</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getFMU()
	 * @generated
	 */
	int FMU = 0;

	/**
	 * The feature id for the '<em><b>Fmi Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__FMI_VERSION = 0;

	/**
	 * The feature id for the '<em><b>Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__MODEL_NAME = 1;

	/**
	 * The feature id for the '<em><b>Guid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__GUID = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__AUTHOR = 4;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__VERSION = 5;

	/**
	 * The feature id for the '<em><b>Copyright</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__COPYRIGHT = 6;

	/**
	 * The feature id for the '<em><b>License</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__LICENSE = 7;

	/**
	 * The feature id for the '<em><b>Generation Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__GENERATION_TOOL = 8;

	/**
	 * The feature id for the '<em><b>Generation Date And Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__GENERATION_DATE_AND_TIME = 9;

	/**
	 * The feature id for the '<em><b>Variable Naming Convention</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__VARIABLE_NAMING_CONVENTION = 10;

	/**
	 * The feature id for the '<em><b>Number Of Event Indicators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__NUMBER_OF_EVENT_INDICATORS = 11;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__BASE_CLASS = 12;

	/**
	 * The feature id for the '<em><b>Source Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__SOURCE_FILES = 13;

	/**
	 * The feature id for the '<em><b>Can Be Instantiated Only Once Per Process</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS = 14;

	/**
	 * The feature id for the '<em><b>Can Get And Set FM Ustate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__CAN_GET_AND_SET_FM_USTATE = 15;

	/**
	 * The feature id for the '<em><b>Can Not Use Memory Management Functions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS = 16;

	/**
	 * The feature id for the '<em><b>Can Serialize FM Ustate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__CAN_SERIALIZE_FM_USTATE = 17;

	/**
	 * The feature id for the '<em><b>Provides Directional Derivative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__PROVIDES_DIRECTIONAL_DERIVATIVE = 18;

	/**
	 * The feature id for the '<em><b>Needs Execution Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__NEEDS_EXECUTION_TOOL = 19;

	/**
	 * The feature id for the '<em><b>Model Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__MODEL_IDENTIFIER = 20;

	/**
	 * The feature id for the '<em><b>Model Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__MODEL_DESCRIPTION = 21;

	/**
	 * The feature id for the '<em><b>Fmu Bundle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU__FMU_BUNDLE = 22;

	/**
	 * The number of structural features of the '<em>FMU</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_FEATURE_COUNT = 23;

	/**
	 * The number of operations of the '<em>FMU</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ScalarVariableImpl <em>Scalar Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ScalarVariableImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getScalarVariable()
	 * @generated
	 */
	int SCALAR_VARIABLE = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_VARIABLE__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Variability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_VARIABLE__VARIABILITY = 1;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_VARIABLE__INITIAL = 2;

	/**
	 * The feature id for the '<em><b>Value Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_VARIABLE__VALUE_REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Fmi Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_VARIABLE__FMI_VARIABLE = 4;

	/**
	 * The feature id for the '<em><b>Causality Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_VARIABLE__CAUSALITY_KIND = 5;

	/**
	 * The number of structural features of the '<em>Scalar Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_VARIABLE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Scalar Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_VARIABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.AbstractVariableImpl <em>Abstract Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.AbstractVariableImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getAbstractVariable()
	 * @generated
	 */
	int ABSTRACT_VARIABLE = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__DESCRIPTION = SCALAR_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Variability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__VARIABILITY = SCALAR_VARIABLE__VARIABILITY;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__INITIAL = SCALAR_VARIABLE__INITIAL;

	/**
	 * The feature id for the '<em><b>Value Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__VALUE_REFERENCE = SCALAR_VARIABLE__VALUE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Fmi Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__FMI_VARIABLE = SCALAR_VARIABLE__FMI_VARIABLE;

	/**
	 * The feature id for the '<em><b>Causality Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__CAUSALITY_KIND = SCALAR_VARIABLE__CAUSALITY_KIND;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__BASE_PROPERTY = SCALAR_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE_FEATURE_COUNT = SCALAR_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Abstract Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE_OPERATION_COUNT = SCALAR_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ParameterImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DESCRIPTION = ABSTRACT_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Variability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VARIABILITY = ABSTRACT_VARIABLE__VARIABILITY;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__INITIAL = ABSTRACT_VARIABLE__INITIAL;

	/**
	 * The feature id for the '<em><b>Value Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VALUE_REFERENCE = ABSTRACT_VARIABLE__VALUE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Fmi Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__FMI_VARIABLE = ABSTRACT_VARIABLE__FMI_VARIABLE;

	/**
	 * The feature id for the '<em><b>Causality Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__CAUSALITY_KIND = ABSTRACT_VARIABLE__CAUSALITY_KIND;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__BASE_PROPERTY = ABSTRACT_VARIABLE__BASE_PROPERTY;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = ABSTRACT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = ABSTRACT_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.LocalImpl <em>Local</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.LocalImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getLocal()
	 * @generated
	 */
	int LOCAL = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL__DESCRIPTION = ABSTRACT_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Variability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL__VARIABILITY = ABSTRACT_VARIABLE__VARIABILITY;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL__INITIAL = ABSTRACT_VARIABLE__INITIAL;

	/**
	 * The feature id for the '<em><b>Value Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL__VALUE_REFERENCE = ABSTRACT_VARIABLE__VALUE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Fmi Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL__FMI_VARIABLE = ABSTRACT_VARIABLE__FMI_VARIABLE;

	/**
	 * The feature id for the '<em><b>Causality Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL__CAUSALITY_KIND = ABSTRACT_VARIABLE__CAUSALITY_KIND;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL__BASE_PROPERTY = ABSTRACT_VARIABLE__BASE_PROPERTY;

	/**
	 * The number of structural features of the '<em>Local</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FEATURE_COUNT = ABSTRACT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Local</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_OPERATION_COUNT = ABSTRACT_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_FMUImpl <em>CS FMU</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_FMUImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getCS_FMU()
	 * @generated
	 */
	int CS_FMU = 5;

	/**
	 * The feature id for the '<em><b>Fmi Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__FMI_VERSION = FMU__FMI_VERSION;

	/**
	 * The feature id for the '<em><b>Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__MODEL_NAME = FMU__MODEL_NAME;

	/**
	 * The feature id for the '<em><b>Guid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__GUID = FMU__GUID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__DESCRIPTION = FMU__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__AUTHOR = FMU__AUTHOR;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__VERSION = FMU__VERSION;

	/**
	 * The feature id for the '<em><b>Copyright</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__COPYRIGHT = FMU__COPYRIGHT;

	/**
	 * The feature id for the '<em><b>License</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__LICENSE = FMU__LICENSE;

	/**
	 * The feature id for the '<em><b>Generation Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__GENERATION_TOOL = FMU__GENERATION_TOOL;

	/**
	 * The feature id for the '<em><b>Generation Date And Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__GENERATION_DATE_AND_TIME = FMU__GENERATION_DATE_AND_TIME;

	/**
	 * The feature id for the '<em><b>Variable Naming Convention</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__VARIABLE_NAMING_CONVENTION = FMU__VARIABLE_NAMING_CONVENTION;

	/**
	 * The feature id for the '<em><b>Number Of Event Indicators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__NUMBER_OF_EVENT_INDICATORS = FMU__NUMBER_OF_EVENT_INDICATORS;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__BASE_CLASS = FMU__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Source Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__SOURCE_FILES = FMU__SOURCE_FILES;

	/**
	 * The feature id for the '<em><b>Can Be Instantiated Only Once Per Process</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS = FMU__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS;

	/**
	 * The feature id for the '<em><b>Can Get And Set FM Ustate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__CAN_GET_AND_SET_FM_USTATE = FMU__CAN_GET_AND_SET_FM_USTATE;

	/**
	 * The feature id for the '<em><b>Can Not Use Memory Management Functions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS = FMU__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS;

	/**
	 * The feature id for the '<em><b>Can Serialize FM Ustate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__CAN_SERIALIZE_FM_USTATE = FMU__CAN_SERIALIZE_FM_USTATE;

	/**
	 * The feature id for the '<em><b>Provides Directional Derivative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__PROVIDES_DIRECTIONAL_DERIVATIVE = FMU__PROVIDES_DIRECTIONAL_DERIVATIVE;

	/**
	 * The feature id for the '<em><b>Needs Execution Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__NEEDS_EXECUTION_TOOL = FMU__NEEDS_EXECUTION_TOOL;

	/**
	 * The feature id for the '<em><b>Model Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__MODEL_IDENTIFIER = FMU__MODEL_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Model Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__MODEL_DESCRIPTION = FMU__MODEL_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Fmu Bundle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__FMU_BUNDLE = FMU__FMU_BUNDLE;

	/**
	 * The feature id for the '<em><b>Can Handle Variable Communication Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE = FMU_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Can Interpolate Inputs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__CAN_INTERPOLATE_INPUTS = FMU_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Can Run Asynchronuously</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__CAN_RUN_ASYNCHRONUOUSLY = FMU_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Max Output Derivative Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__MAX_OUTPUT_DERIVATIVE_ORDER = FMU_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__START_TIME = FMU_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Stop Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__STOP_TIME = FMU_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__STEP_SIZE = FMU_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU__TOLERANCE = FMU_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>CS FMU</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU_FEATURE_COUNT = FMU_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>CS FMU</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_FMU_OPERATION_COUNT = FMU_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ME_FMUImpl <em>ME FMU</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ME_FMUImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getME_FMU()
	 * @generated
	 */
	int ME_FMU = 6;

	/**
	 * The feature id for the '<em><b>Fmi Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__FMI_VERSION = FMU__FMI_VERSION;

	/**
	 * The feature id for the '<em><b>Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__MODEL_NAME = FMU__MODEL_NAME;

	/**
	 * The feature id for the '<em><b>Guid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__GUID = FMU__GUID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__DESCRIPTION = FMU__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__AUTHOR = FMU__AUTHOR;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__VERSION = FMU__VERSION;

	/**
	 * The feature id for the '<em><b>Copyright</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__COPYRIGHT = FMU__COPYRIGHT;

	/**
	 * The feature id for the '<em><b>License</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__LICENSE = FMU__LICENSE;

	/**
	 * The feature id for the '<em><b>Generation Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__GENERATION_TOOL = FMU__GENERATION_TOOL;

	/**
	 * The feature id for the '<em><b>Generation Date And Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__GENERATION_DATE_AND_TIME = FMU__GENERATION_DATE_AND_TIME;

	/**
	 * The feature id for the '<em><b>Variable Naming Convention</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__VARIABLE_NAMING_CONVENTION = FMU__VARIABLE_NAMING_CONVENTION;

	/**
	 * The feature id for the '<em><b>Number Of Event Indicators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__NUMBER_OF_EVENT_INDICATORS = FMU__NUMBER_OF_EVENT_INDICATORS;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__BASE_CLASS = FMU__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Source Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__SOURCE_FILES = FMU__SOURCE_FILES;

	/**
	 * The feature id for the '<em><b>Can Be Instantiated Only Once Per Process</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS = FMU__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS;

	/**
	 * The feature id for the '<em><b>Can Get And Set FM Ustate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__CAN_GET_AND_SET_FM_USTATE = FMU__CAN_GET_AND_SET_FM_USTATE;

	/**
	 * The feature id for the '<em><b>Can Not Use Memory Management Functions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS = FMU__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS;

	/**
	 * The feature id for the '<em><b>Can Serialize FM Ustate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__CAN_SERIALIZE_FM_USTATE = FMU__CAN_SERIALIZE_FM_USTATE;

	/**
	 * The feature id for the '<em><b>Provides Directional Derivative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__PROVIDES_DIRECTIONAL_DERIVATIVE = FMU__PROVIDES_DIRECTIONAL_DERIVATIVE;

	/**
	 * The feature id for the '<em><b>Needs Execution Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__NEEDS_EXECUTION_TOOL = FMU__NEEDS_EXECUTION_TOOL;

	/**
	 * The feature id for the '<em><b>Model Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__MODEL_IDENTIFIER = FMU__MODEL_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Model Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__MODEL_DESCRIPTION = FMU__MODEL_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Fmu Bundle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__FMU_BUNDLE = FMU__FMU_BUNDLE;

	/**
	 * The feature id for the '<em><b>Completed Integrator Step Not Needed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU__COMPLETED_INTEGRATOR_STEP_NOT_NEEDED = FMU_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ME FMU</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU_FEATURE_COUNT = FMU_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>ME FMU</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_FMU_OPERATION_COUNT = FMU_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIPortImpl <em>FMI Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIPortImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getFMIPort()
	 * @generated
	 */
	int FMI_PORT = 7;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_PORT__DESCRIPTION = SCALAR_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Variability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_PORT__VARIABILITY = SCALAR_VARIABLE__VARIABILITY;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_PORT__INITIAL = SCALAR_VARIABLE__INITIAL;

	/**
	 * The feature id for the '<em><b>Value Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_PORT__VALUE_REFERENCE = SCALAR_VARIABLE__VALUE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Fmi Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_PORT__FMI_VARIABLE = SCALAR_VARIABLE__FMI_VARIABLE;

	/**
	 * The feature id for the '<em><b>Causality Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_PORT__CAUSALITY_KIND = SCALAR_VARIABLE__CAUSALITY_KIND;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_PORT__BASE_PORT = SCALAR_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_PORT__DIRECTION = SCALAR_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_PORT__IS_ATOMIC = SCALAR_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>FMI Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_PORT_FEATURE_COUNT = SCALAR_VARIABLE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Icon</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_PORT___GET_ICON = SCALAR_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>FMI Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_PORT_OPERATION_COUNT = SCALAR_VARIABLE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.IndependentImpl <em>Independent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.IndependentImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getIndependent()
	 * @generated
	 */
	int INDEPENDENT = 8;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEPENDENT__DESCRIPTION = ABSTRACT_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Variability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEPENDENT__VARIABILITY = ABSTRACT_VARIABLE__VARIABILITY;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEPENDENT__INITIAL = ABSTRACT_VARIABLE__INITIAL;

	/**
	 * The feature id for the '<em><b>Value Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEPENDENT__VALUE_REFERENCE = ABSTRACT_VARIABLE__VALUE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Fmi Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEPENDENT__FMI_VARIABLE = ABSTRACT_VARIABLE__FMI_VARIABLE;

	/**
	 * The feature id for the '<em><b>Causality Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEPENDENT__CAUSALITY_KIND = ABSTRACT_VARIABLE__CAUSALITY_KIND;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEPENDENT__BASE_PROPERTY = ABSTRACT_VARIABLE__BASE_PROPERTY;

	/**
	 * The number of structural features of the '<em>Independent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEPENDENT_FEATURE_COUNT = ABSTRACT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Independent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEPENDENT_OPERATION_COUNT = ABSTRACT_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.UnknownImpl <em>Unknown</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.UnknownImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getUnknown()
	 * @generated
	 */
	int UNKNOWN = 9;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN__BASE_PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN__DEPENDENCIES = 1;

	/**
	 * The feature id for the '<em><b>Dependencies Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN__DEPENDENCIES_KIND = 2;

	/**
	 * The number of structural features of the '<em>Unknown</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Unknown</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.OutputUnknownImpl <em>Output Unknown</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.OutputUnknownImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getOutputUnknown()
	 * @generated
	 */
	int OUTPUT_UNKNOWN = 10;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_UNKNOWN__BASE_PROPERTY = UNKNOWN__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_UNKNOWN__DEPENDENCIES = UNKNOWN__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Dependencies Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_UNKNOWN__DEPENDENCIES_KIND = UNKNOWN__DEPENDENCIES_KIND;

	/**
	 * The number of structural features of the '<em>Output Unknown</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_UNKNOWN_FEATURE_COUNT = UNKNOWN_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Output Unknown</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_UNKNOWN_OPERATION_COUNT = UNKNOWN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.InitialUnknownImpl <em>Initial Unknown</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.InitialUnknownImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getInitialUnknown()
	 * @generated
	 */
	int INITIAL_UNKNOWN = 11;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_UNKNOWN__BASE_PROPERTY = UNKNOWN__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_UNKNOWN__DEPENDENCIES = UNKNOWN__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Dependencies Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_UNKNOWN__DEPENDENCIES_KIND = UNKNOWN__DEPENDENCIES_KIND;

	/**
	 * The number of structural features of the '<em>Initial Unknown</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_UNKNOWN_FEATURE_COUNT = UNKNOWN_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Initial Unknown</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_UNKNOWN_OPERATION_COUNT = UNKNOWN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.DerivativeUnknownImpl <em>Derivative Unknown</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.DerivativeUnknownImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getDerivativeUnknown()
	 * @generated
	 */
	int DERIVATIVE_UNKNOWN = 12;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATIVE_UNKNOWN__BASE_PROPERTY = UNKNOWN__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATIVE_UNKNOWN__DEPENDENCIES = UNKNOWN__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Dependencies Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATIVE_UNKNOWN__DEPENDENCIES_KIND = UNKNOWN__DEPENDENCIES_KIND;

	/**
	 * The number of structural features of the '<em>Derivative Unknown</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATIVE_UNKNOWN_FEATURE_COUNT = UNKNOWN_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Derivative Unknown</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATIVE_UNKNOWN_OPERATION_COUNT = UNKNOWN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_GraphImpl <em>CS Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_GraphImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getCS_Graph()
	 * @generated
	 */
	int CS_GRAPH = 13;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_GRAPH__START_TIME = 0;

	/**
	 * The feature id for the '<em><b>Stop Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_GRAPH__STOP_TIME = 1;

	/**
	 * The feature id for the '<em><b>Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_GRAPH__STEP_SIZE = 2;

	/**
	 * The feature id for the '<em><b>Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_GRAPH__TOLERANCE = 3;

	/**
	 * The feature id for the '<em><b>Tolerance Defined</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_GRAPH__TOLERANCE_DEFINED = 4;

	/**
	 * The feature id for the '<em><b>Stop Time Defined</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_GRAPH__STOP_TIME_DEFINED = 5;

	/**
	 * The feature id for the '<em><b>Compute Setup Experiments From Fmus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_GRAPH__COMPUTE_SETUP_EXPERIMENTS_FROM_FMUS = 6;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_GRAPH__BASE_CLASS = 7;

	/**
	 * The number of structural features of the '<em>CS Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_GRAPH_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>CS Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_GRAPH_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.DerivativeDependencyImpl <em>Derivative Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.DerivativeDependencyImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getDerivativeDependency()
	 * @generated
	 */
	int DERIVATIVE_DEPENDENCY = 14;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATIVE_DEPENDENCY__BASE_DEPENDENCY = 0;

	/**
	 * The feature id for the '<em><b>Dependency Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATIVE_DEPENDENCY__DEPENDENCY_KIND = 1;

	/**
	 * The number of structural features of the '<em>Derivative Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATIVE_DEPENDENCY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Derivative Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATIVE_DEPENDENCY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.OutputDependencyImpl <em>Output Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.OutputDependencyImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getOutputDependency()
	 * @generated
	 */
	int OUTPUT_DEPENDENCY = 15;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DEPENDENCY__BASE_DEPENDENCY = 0;

	/**
	 * The number of structural features of the '<em>Output Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DEPENDENCY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Output Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DEPENDENCY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.InitialUnknownDependencyImpl <em>Initial Unknown Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.InitialUnknownDependencyImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getInitialUnknownDependency()
	 * @generated
	 */
	int INITIAL_UNKNOWN_DEPENDENCY = 16;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_UNKNOWN_DEPENDENCY__BASE_DEPENDENCY = 0;

	/**
	 * The number of structural features of the '<em>Initial Unknown Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_UNKNOWN_DEPENDENCY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Initial Unknown Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_UNKNOWN_DEPENDENCY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CalculatedParameterImpl <em>Calculated Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CalculatedParameterImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getCalculatedParameter()
	 * @generated
	 */
	int CALCULATED_PARAMETER = 17;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATED_PARAMETER__DESCRIPTION = ABSTRACT_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Variability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATED_PARAMETER__VARIABILITY = ABSTRACT_VARIABLE__VARIABILITY;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATED_PARAMETER__INITIAL = ABSTRACT_VARIABLE__INITIAL;

	/**
	 * The feature id for the '<em><b>Value Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATED_PARAMETER__VALUE_REFERENCE = ABSTRACT_VARIABLE__VALUE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Fmi Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATED_PARAMETER__FMI_VARIABLE = ABSTRACT_VARIABLE__FMI_VARIABLE;

	/**
	 * The feature id for the '<em><b>Causality Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATED_PARAMETER__CAUSALITY_KIND = ABSTRACT_VARIABLE__CAUSALITY_KIND;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATED_PARAMETER__BASE_PROPERTY = ABSTRACT_VARIABLE__BASE_PROPERTY;

	/**
	 * The number of structural features of the '<em>Calculated Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATED_PARAMETER_FEATURE_COUNT = ABSTRACT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Calculated Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATED_PARAMETER_OPERATION_COUNT = ABSTRACT_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.PortImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getPort()
	 * @generated
	 */
	int PORT = 18;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__DESCRIPTION = FMI_PORT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Variability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__VARIABILITY = FMI_PORT__VARIABILITY;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__INITIAL = FMI_PORT__INITIAL;

	/**
	 * The feature id for the '<em><b>Value Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__VALUE_REFERENCE = FMI_PORT__VALUE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Fmi Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__FMI_VARIABLE = FMI_PORT__FMI_VARIABLE;

	/**
	 * The feature id for the '<em><b>Causality Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__CAUSALITY_KIND = FMI_PORT__CAUSALITY_KIND;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__BASE_PORT = FMI_PORT__BASE_PORT;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__DIRECTION = FMI_PORT__DIRECTION;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__IS_ATOMIC = FMI_PORT__IS_ATOMIC;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = FMI_PORT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Icon</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT___GET_ICON = FMI_PORT___GET_ICON;

	/**
	 * The number of operations of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_OPERATION_COUNT = FMI_PORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityKind <em>Variability Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityKind
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getVariabilityKind()
	 * @generated
	 */
	int VARIABILITY_KIND = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.InitialKind <em>Initial Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.InitialKind
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getInitialKind()
	 * @generated
	 */
	int INITIAL_KIND = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CausalityKind <em>Causality Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CausalityKind
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getCausalityKind()
	 * @generated
	 */
	int CAUSALITY_KIND = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.DependenciesKind <em>Dependencies Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.DependenciesKind
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getDependenciesKind()
	 * @generated
	 */
	int DEPENDENCIES_KIND = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityNamingConvention <em>Variability Naming Convention</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityNamingConvention
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getVariabilityNamingConvention()
	 * @generated
	 */
	int VARIABILITY_NAMING_CONVENTION = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.BaseUnit <em>Base Unit</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.BaseUnit
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getBaseUnit()
	 * @generated
	 */
	int BASE_UNIT = 24;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU <em>FMU</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FMU</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU
	 * @generated
	 */
	EClass getFMU();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getFmiVersion <em>Fmi Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fmi Version</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getFmiVersion()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_FmiVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getModelName <em>Model Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Name</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getModelName()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_ModelName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getGuid <em>Guid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guid</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getGuid()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_Guid();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getDescription()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getAuthor()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_Author();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getVersion()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getCopyright <em>Copyright</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Copyright</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getCopyright()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_Copyright();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getLicense <em>License</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>License</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getLicense()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_License();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getGenerationTool <em>Generation Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generation Tool</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getGenerationTool()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_GenerationTool();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getGenerationDateAndTime <em>Generation Date And Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generation Date And Time</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getGenerationDateAndTime()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_GenerationDateAndTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getVariableNamingConvention <em>Variable Naming Convention</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable Naming Convention</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getVariableNamingConvention()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_VariableNamingConvention();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getNumberOfEventIndicators <em>Number Of Event Indicators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Event Indicators</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getNumberOfEventIndicators()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_NumberOfEventIndicators();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getBase_Class()
	 * @see #getFMU()
	 * @generated
	 */
	EReference getFMU_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getSourceFiles <em>Source Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Files</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getSourceFiles()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_SourceFiles();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isCanBeInstantiatedOnlyOncePerProcess <em>Can Be Instantiated Only Once Per Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Be Instantiated Only Once Per Process</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isCanBeInstantiatedOnlyOncePerProcess()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_CanBeInstantiatedOnlyOncePerProcess();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isCanGetAndSetFMUstate <em>Can Get And Set FM Ustate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Get And Set FM Ustate</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isCanGetAndSetFMUstate()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_CanGetAndSetFMUstate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isCanNotUseMemoryManagementFunctions <em>Can Not Use Memory Management Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Not Use Memory Management Functions</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isCanNotUseMemoryManagementFunctions()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_CanNotUseMemoryManagementFunctions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isCanSerializeFMUstate <em>Can Serialize FM Ustate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Serialize FM Ustate</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isCanSerializeFMUstate()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_CanSerializeFMUstate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isProvidesDirectionalDerivative <em>Provides Directional Derivative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provides Directional Derivative</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isProvidesDirectionalDerivative()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_ProvidesDirectionalDerivative();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isNeedsExecutionTool <em>Needs Execution Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Needs Execution Tool</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#isNeedsExecutionTool()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_NeedsExecutionTool();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getModelIdentifier <em>Model Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Identifier</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getModelIdentifier()
	 * @see #getFMU()
	 * @generated
	 */
	EAttribute getFMU_ModelIdentifier();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getModelDescription <em>Model Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Description</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getModelDescription()
	 * @see #getFMU()
	 * @generated
	 */
	EReference getFMU_ModelDescription();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getFmuBundle <em>Fmu Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Fmu Bundle</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU#getFmuBundle()
	 * @see #getFMU()
	 * @generated
	 */
	EReference getFMU_FmuBundle();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.AbstractVariable <em>Abstract Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Variable</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.AbstractVariable
	 * @generated
	 */
	EClass getAbstractVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.AbstractVariable#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.AbstractVariable#getBase_Property()
	 * @see #getAbstractVariable()
	 * @generated
	 */
	EReference getAbstractVariable_Base_Property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable <em>Scalar Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scalar Variable</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable
	 * @generated
	 */
	EClass getScalarVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getDescription()
	 * @see #getScalarVariable()
	 * @generated
	 */
	EAttribute getScalarVariable_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getVariability <em>Variability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variability</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getVariability()
	 * @see #getScalarVariable()
	 * @generated
	 */
	EAttribute getScalarVariable_Variability();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getInitial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getInitial()
	 * @see #getScalarVariable()
	 * @generated
	 */
	EAttribute getScalarVariable_Initial();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getValueReference <em>Value Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Reference</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getValueReference()
	 * @see #getScalarVariable()
	 * @generated
	 */
	EAttribute getScalarVariable_ValueReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getFmiVariable <em>Fmi Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Fmi Variable</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getFmiVariable()
	 * @see #getScalarVariable()
	 * @generated
	 */
	EReference getScalarVariable_FmiVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getCausalityKind <em>Causality Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Causality Kind</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getCausalityKind()
	 * @see #getScalarVariable()
	 * @generated
	 */
	EAttribute getScalarVariable_CausalityKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Local <em>Local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.Local
	 * @generated
	 */
	EClass getLocal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU <em>CS FMU</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CS FMU</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU
	 * @generated
	 */
	EClass getCS_FMU();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#isCanHandleVariableCommunicationStepSize <em>Can Handle Variable Communication Step Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Handle Variable Communication Step Size</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#isCanHandleVariableCommunicationStepSize()
	 * @see #getCS_FMU()
	 * @generated
	 */
	EAttribute getCS_FMU_CanHandleVariableCommunicationStepSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#isCanInterpolateInputs <em>Can Interpolate Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Interpolate Inputs</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#isCanInterpolateInputs()
	 * @see #getCS_FMU()
	 * @generated
	 */
	EAttribute getCS_FMU_CanInterpolateInputs();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#isCanRunAsynchronuously <em>Can Run Asynchronuously</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Run Asynchronuously</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#isCanRunAsynchronuously()
	 * @see #getCS_FMU()
	 * @generated
	 */
	EAttribute getCS_FMU_CanRunAsynchronuously();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getMaxOutputDerivativeOrder <em>Max Output Derivative Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Output Derivative Order</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getMaxOutputDerivativeOrder()
	 * @see #getCS_FMU()
	 * @generated
	 */
	EAttribute getCS_FMU_MaxOutputDerivativeOrder();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getStartTime()
	 * @see #getCS_FMU()
	 * @generated
	 */
	EAttribute getCS_FMU_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getStopTime <em>Stop Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop Time</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getStopTime()
	 * @see #getCS_FMU()
	 * @generated
	 */
	EAttribute getCS_FMU_StopTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getStepSize <em>Step Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Size</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getStepSize()
	 * @see #getCS_FMU()
	 * @generated
	 */
	EAttribute getCS_FMU_StepSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getTolerance <em>Tolerance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tolerance</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU#getTolerance()
	 * @see #getCS_FMU()
	 * @generated
	 */
	EAttribute getCS_FMU_Tolerance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ME_FMU <em>ME FMU</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ME FMU</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.ME_FMU
	 * @generated
	 */
	EClass getME_FMU();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ME_FMU#isCompletedIntegratorStepNotNeeded <em>Completed Integrator Step Not Needed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Completed Integrator Step Not Needed</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.ME_FMU#isCompletedIntegratorStepNotNeeded()
	 * @see #getME_FMU()
	 * @generated
	 */
	EAttribute getME_FMU_CompletedIntegratorStepNotNeeded();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMIPort <em>FMI Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FMI Port</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIPort
	 * @generated
	 */
	EClass getFMIPort();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Independent <em>Independent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Independent</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.Independent
	 * @generated
	 */
	EClass getIndependent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Unknown <em>Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unknown</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.Unknown
	 * @generated
	 */
	EClass getUnknown();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Unknown#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.Unknown#getBase_Property()
	 * @see #getUnknown()
	 * @generated
	 */
	EReference getUnknown_Base_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Unknown#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dependencies</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.Unknown#getDependencies()
	 * @see #getUnknown()
	 * @generated
	 */
	EAttribute getUnknown_Dependencies();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Unknown#getDependenciesKind <em>Dependencies Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dependencies Kind</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.Unknown#getDependenciesKind()
	 * @see #getUnknown()
	 * @generated
	 */
	EAttribute getUnknown_DependenciesKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.OutputUnknown <em>Output Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Unknown</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.OutputUnknown
	 * @generated
	 */
	EClass getOutputUnknown();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.InitialUnknown <em>Initial Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initial Unknown</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.InitialUnknown
	 * @generated
	 */
	EClass getInitialUnknown();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeUnknown <em>Derivative Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Derivative Unknown</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeUnknown
	 * @generated
	 */
	EClass getDerivativeUnknown();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph <em>CS Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CS Graph</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph
	 * @generated
	 */
	EClass getCS_Graph();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getStartTime()
	 * @see #getCS_Graph()
	 * @generated
	 */
	EAttribute getCS_Graph_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getStopTime <em>Stop Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop Time</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getStopTime()
	 * @see #getCS_Graph()
	 * @generated
	 */
	EAttribute getCS_Graph_StopTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getStepSize <em>Step Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Size</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getStepSize()
	 * @see #getCS_Graph()
	 * @generated
	 */
	EAttribute getCS_Graph_StepSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getTolerance <em>Tolerance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tolerance</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getTolerance()
	 * @see #getCS_Graph()
	 * @generated
	 */
	EAttribute getCS_Graph_Tolerance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#isToleranceDefined <em>Tolerance Defined</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tolerance Defined</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#isToleranceDefined()
	 * @see #getCS_Graph()
	 * @generated
	 */
	EAttribute getCS_Graph_ToleranceDefined();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#isStopTimeDefined <em>Stop Time Defined</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop Time Defined</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#isStopTimeDefined()
	 * @see #getCS_Graph()
	 * @generated
	 */
	EAttribute getCS_Graph_StopTimeDefined();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#isComputeSetupExperimentsFromFmus <em>Compute Setup Experiments From Fmus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compute Setup Experiments From Fmus</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#isComputeSetupExperimentsFromFmus()
	 * @see #getCS_Graph()
	 * @generated
	 */
	EAttribute getCS_Graph_ComputeSetupExperimentsFromFmus();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph#getBase_Class()
	 * @see #getCS_Graph()
	 * @generated
	 */
	EReference getCS_Graph_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeDependency <em>Derivative Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Derivative Dependency</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeDependency
	 * @generated
	 */
	EClass getDerivativeDependency();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeDependency#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeDependency#getBase_Dependency()
	 * @see #getDerivativeDependency()
	 * @generated
	 */
	EReference getDerivativeDependency_Base_Dependency();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeDependency#getDependencyKind <em>Dependency Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dependency Kind</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeDependency#getDependencyKind()
	 * @see #getDerivativeDependency()
	 * @generated
	 */
	EAttribute getDerivativeDependency_DependencyKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.OutputDependency <em>Output Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Dependency</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.OutputDependency
	 * @generated
	 */
	EClass getOutputDependency();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.OutputDependency#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.OutputDependency#getBase_Dependency()
	 * @see #getOutputDependency()
	 * @generated
	 */
	EReference getOutputDependency_Base_Dependency();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.InitialUnknownDependency <em>Initial Unknown Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initial Unknown Dependency</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.InitialUnknownDependency
	 * @generated
	 */
	EClass getInitialUnknownDependency();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.InitialUnknownDependency#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.InitialUnknownDependency#getBase_Dependency()
	 * @see #getInitialUnknownDependency()
	 * @generated
	 */
	EReference getInitialUnknownDependency_Base_Dependency();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CalculatedParameter <em>Calculated Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Calculated Parameter</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CalculatedParameter
	 * @generated
	 */
	EClass getCalculatedParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityKind <em>Variability Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variability Kind</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityKind
	 * @generated
	 */
	EEnum getVariabilityKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.InitialKind <em>Initial Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Initial Kind</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.InitialKind
	 * @generated
	 */
	EEnum getInitialKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CausalityKind <em>Causality Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Causality Kind</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CausalityKind
	 * @generated
	 */
	EEnum getCausalityKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.DependenciesKind <em>Dependencies Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Dependencies Kind</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.DependenciesKind
	 * @generated
	 */
	EEnum getDependenciesKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityNamingConvention <em>Variability Naming Convention</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variability Naming Convention</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityNamingConvention
	 * @generated
	 */
	EEnum getVariabilityNamingConvention();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.BaseUnit <em>Base Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Base Unit</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.BaseUnit
	 * @generated
	 */
	EEnum getBaseUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FMIProfileFactory getFMIProfileFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl <em>FMU</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMUImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getFMU()
		 * @generated
		 */
		EClass FMU = eINSTANCE.getFMU();

		/**
		 * The meta object literal for the '<em><b>Fmi Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__FMI_VERSION = eINSTANCE.getFMU_FmiVersion();

		/**
		 * The meta object literal for the '<em><b>Model Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__MODEL_NAME = eINSTANCE.getFMU_ModelName();

		/**
		 * The meta object literal for the '<em><b>Guid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__GUID = eINSTANCE.getFMU_Guid();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__DESCRIPTION = eINSTANCE.getFMU_Description();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__AUTHOR = eINSTANCE.getFMU_Author();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__VERSION = eINSTANCE.getFMU_Version();

		/**
		 * The meta object literal for the '<em><b>Copyright</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__COPYRIGHT = eINSTANCE.getFMU_Copyright();

		/**
		 * The meta object literal for the '<em><b>License</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__LICENSE = eINSTANCE.getFMU_License();

		/**
		 * The meta object literal for the '<em><b>Generation Tool</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__GENERATION_TOOL = eINSTANCE.getFMU_GenerationTool();

		/**
		 * The meta object literal for the '<em><b>Generation Date And Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__GENERATION_DATE_AND_TIME = eINSTANCE.getFMU_GenerationDateAndTime();

		/**
		 * The meta object literal for the '<em><b>Variable Naming Convention</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__VARIABLE_NAMING_CONVENTION = eINSTANCE.getFMU_VariableNamingConvention();

		/**
		 * The meta object literal for the '<em><b>Number Of Event Indicators</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__NUMBER_OF_EVENT_INDICATORS = eINSTANCE.getFMU_NumberOfEventIndicators();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMU__BASE_CLASS = eINSTANCE.getFMU_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Source Files</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__SOURCE_FILES = eINSTANCE.getFMU_SourceFiles();

		/**
		 * The meta object literal for the '<em><b>Can Be Instantiated Only Once Per Process</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS = eINSTANCE.getFMU_CanBeInstantiatedOnlyOncePerProcess();

		/**
		 * The meta object literal for the '<em><b>Can Get And Set FM Ustate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__CAN_GET_AND_SET_FM_USTATE = eINSTANCE.getFMU_CanGetAndSetFMUstate();

		/**
		 * The meta object literal for the '<em><b>Can Not Use Memory Management Functions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS = eINSTANCE.getFMU_CanNotUseMemoryManagementFunctions();

		/**
		 * The meta object literal for the '<em><b>Can Serialize FM Ustate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__CAN_SERIALIZE_FM_USTATE = eINSTANCE.getFMU_CanSerializeFMUstate();

		/**
		 * The meta object literal for the '<em><b>Provides Directional Derivative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__PROVIDES_DIRECTIONAL_DERIVATIVE = eINSTANCE.getFMU_ProvidesDirectionalDerivative();

		/**
		 * The meta object literal for the '<em><b>Needs Execution Tool</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__NEEDS_EXECUTION_TOOL = eINSTANCE.getFMU_NeedsExecutionTool();

		/**
		 * The meta object literal for the '<em><b>Model Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU__MODEL_IDENTIFIER = eINSTANCE.getFMU_ModelIdentifier();

		/**
		 * The meta object literal for the '<em><b>Model Description</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMU__MODEL_DESCRIPTION = eINSTANCE.getFMU_ModelDescription();

		/**
		 * The meta object literal for the '<em><b>Fmu Bundle</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMU__FMU_BUNDLE = eINSTANCE.getFMU_FmuBundle();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ParameterImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.AbstractVariableImpl <em>Abstract Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.AbstractVariableImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getAbstractVariable()
		 * @generated
		 */
		EClass ABSTRACT_VARIABLE = eINSTANCE.getAbstractVariable();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_VARIABLE__BASE_PROPERTY = eINSTANCE.getAbstractVariable_Base_Property();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ScalarVariableImpl <em>Scalar Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ScalarVariableImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getScalarVariable()
		 * @generated
		 */
		EClass SCALAR_VARIABLE = eINSTANCE.getScalarVariable();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALAR_VARIABLE__DESCRIPTION = eINSTANCE.getScalarVariable_Description();

		/**
		 * The meta object literal for the '<em><b>Variability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALAR_VARIABLE__VARIABILITY = eINSTANCE.getScalarVariable_Variability();

		/**
		 * The meta object literal for the '<em><b>Initial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALAR_VARIABLE__INITIAL = eINSTANCE.getScalarVariable_Initial();

		/**
		 * The meta object literal for the '<em><b>Value Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALAR_VARIABLE__VALUE_REFERENCE = eINSTANCE.getScalarVariable_ValueReference();

		/**
		 * The meta object literal for the '<em><b>Fmi Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALAR_VARIABLE__FMI_VARIABLE = eINSTANCE.getScalarVariable_FmiVariable();

		/**
		 * The meta object literal for the '<em><b>Causality Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALAR_VARIABLE__CAUSALITY_KIND = eINSTANCE.getScalarVariable_CausalityKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.LocalImpl <em>Local</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.LocalImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getLocal()
		 * @generated
		 */
		EClass LOCAL = eINSTANCE.getLocal();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_FMUImpl <em>CS FMU</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_FMUImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getCS_FMU()
		 * @generated
		 */
		EClass CS_FMU = eINSTANCE.getCS_FMU();

		/**
		 * The meta object literal for the '<em><b>Can Handle Variable Communication Step Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CS_FMU__CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE = eINSTANCE.getCS_FMU_CanHandleVariableCommunicationStepSize();

		/**
		 * The meta object literal for the '<em><b>Can Interpolate Inputs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CS_FMU__CAN_INTERPOLATE_INPUTS = eINSTANCE.getCS_FMU_CanInterpolateInputs();

		/**
		 * The meta object literal for the '<em><b>Can Run Asynchronuously</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CS_FMU__CAN_RUN_ASYNCHRONUOUSLY = eINSTANCE.getCS_FMU_CanRunAsynchronuously();

		/**
		 * The meta object literal for the '<em><b>Max Output Derivative Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CS_FMU__MAX_OUTPUT_DERIVATIVE_ORDER = eINSTANCE.getCS_FMU_MaxOutputDerivativeOrder();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CS_FMU__START_TIME = eINSTANCE.getCS_FMU_StartTime();

		/**
		 * The meta object literal for the '<em><b>Stop Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CS_FMU__STOP_TIME = eINSTANCE.getCS_FMU_StopTime();

		/**
		 * The meta object literal for the '<em><b>Step Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CS_FMU__STEP_SIZE = eINSTANCE.getCS_FMU_StepSize();

		/**
		 * The meta object literal for the '<em><b>Tolerance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CS_FMU__TOLERANCE = eINSTANCE.getCS_FMU_Tolerance();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ME_FMUImpl <em>ME FMU</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.ME_FMUImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getME_FMU()
		 * @generated
		 */
		EClass ME_FMU = eINSTANCE.getME_FMU();

		/**
		 * The meta object literal for the '<em><b>Completed Integrator Step Not Needed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ME_FMU__COMPLETED_INTEGRATOR_STEP_NOT_NEEDED = eINSTANCE.getME_FMU_CompletedIntegratorStepNotNeeded();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIPortImpl <em>FMI Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIPortImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getFMIPort()
		 * @generated
		 */
		EClass FMI_PORT = eINSTANCE.getFMIPort();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.IndependentImpl <em>Independent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.IndependentImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getIndependent()
		 * @generated
		 */
		EClass INDEPENDENT = eINSTANCE.getIndependent();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.UnknownImpl <em>Unknown</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.UnknownImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getUnknown()
		 * @generated
		 */
		EClass UNKNOWN = eINSTANCE.getUnknown();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNKNOWN__BASE_PROPERTY = eINSTANCE.getUnknown_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNKNOWN__DEPENDENCIES = eINSTANCE.getUnknown_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Dependencies Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNKNOWN__DEPENDENCIES_KIND = eINSTANCE.getUnknown_DependenciesKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.OutputUnknownImpl <em>Output Unknown</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.OutputUnknownImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getOutputUnknown()
		 * @generated
		 */
		EClass OUTPUT_UNKNOWN = eINSTANCE.getOutputUnknown();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.InitialUnknownImpl <em>Initial Unknown</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.InitialUnknownImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getInitialUnknown()
		 * @generated
		 */
		EClass INITIAL_UNKNOWN = eINSTANCE.getInitialUnknown();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.DerivativeUnknownImpl <em>Derivative Unknown</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.DerivativeUnknownImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getDerivativeUnknown()
		 * @generated
		 */
		EClass DERIVATIVE_UNKNOWN = eINSTANCE.getDerivativeUnknown();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_GraphImpl <em>CS Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CS_GraphImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getCS_Graph()
		 * @generated
		 */
		EClass CS_GRAPH = eINSTANCE.getCS_Graph();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CS_GRAPH__START_TIME = eINSTANCE.getCS_Graph_StartTime();

		/**
		 * The meta object literal for the '<em><b>Stop Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CS_GRAPH__STOP_TIME = eINSTANCE.getCS_Graph_StopTime();

		/**
		 * The meta object literal for the '<em><b>Step Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CS_GRAPH__STEP_SIZE = eINSTANCE.getCS_Graph_StepSize();

		/**
		 * The meta object literal for the '<em><b>Tolerance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CS_GRAPH__TOLERANCE = eINSTANCE.getCS_Graph_Tolerance();

		/**
		 * The meta object literal for the '<em><b>Tolerance Defined</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CS_GRAPH__TOLERANCE_DEFINED = eINSTANCE.getCS_Graph_ToleranceDefined();

		/**
		 * The meta object literal for the '<em><b>Stop Time Defined</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CS_GRAPH__STOP_TIME_DEFINED = eINSTANCE.getCS_Graph_StopTimeDefined();

		/**
		 * The meta object literal for the '<em><b>Compute Setup Experiments From Fmus</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CS_GRAPH__COMPUTE_SETUP_EXPERIMENTS_FROM_FMUS = eINSTANCE.getCS_Graph_ComputeSetupExperimentsFromFmus();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CS_GRAPH__BASE_CLASS = eINSTANCE.getCS_Graph_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.DerivativeDependencyImpl <em>Derivative Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.DerivativeDependencyImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getDerivativeDependency()
		 * @generated
		 */
		EClass DERIVATIVE_DEPENDENCY = eINSTANCE.getDerivativeDependency();

		/**
		 * The meta object literal for the '<em><b>Base Dependency</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERIVATIVE_DEPENDENCY__BASE_DEPENDENCY = eINSTANCE.getDerivativeDependency_Base_Dependency();

		/**
		 * The meta object literal for the '<em><b>Dependency Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DERIVATIVE_DEPENDENCY__DEPENDENCY_KIND = eINSTANCE.getDerivativeDependency_DependencyKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.OutputDependencyImpl <em>Output Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.OutputDependencyImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getOutputDependency()
		 * @generated
		 */
		EClass OUTPUT_DEPENDENCY = eINSTANCE.getOutputDependency();

		/**
		 * The meta object literal for the '<em><b>Base Dependency</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_DEPENDENCY__BASE_DEPENDENCY = eINSTANCE.getOutputDependency_Base_Dependency();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.InitialUnknownDependencyImpl <em>Initial Unknown Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.InitialUnknownDependencyImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getInitialUnknownDependency()
		 * @generated
		 */
		EClass INITIAL_UNKNOWN_DEPENDENCY = eINSTANCE.getInitialUnknownDependency();

		/**
		 * The meta object literal for the '<em><b>Base Dependency</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INITIAL_UNKNOWN_DEPENDENCY__BASE_DEPENDENCY = eINSTANCE.getInitialUnknownDependency_Base_Dependency();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CalculatedParameterImpl <em>Calculated Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.CalculatedParameterImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getCalculatedParameter()
		 * @generated
		 */
		EClass CALCULATED_PARAMETER = eINSTANCE.getCalculatedParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.PortImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityKind <em>Variability Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityKind
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getVariabilityKind()
		 * @generated
		 */
		EEnum VARIABILITY_KIND = eINSTANCE.getVariabilityKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.InitialKind <em>Initial Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.InitialKind
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getInitialKind()
		 * @generated
		 */
		EEnum INITIAL_KIND = eINSTANCE.getInitialKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CausalityKind <em>Causality Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CausalityKind
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getCausalityKind()
		 * @generated
		 */
		EEnum CAUSALITY_KIND = eINSTANCE.getCausalityKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.DependenciesKind <em>Dependencies Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.DependenciesKind
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getDependenciesKind()
		 * @generated
		 */
		EEnum DEPENDENCIES_KIND = eINSTANCE.getDependenciesKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityNamingConvention <em>Variability Naming Convention</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityNamingConvention
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getVariabilityNamingConvention()
		 * @generated
		 */
		EEnum VARIABILITY_NAMING_CONVENTION = eINSTANCE.getVariabilityNamingConvention();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.BaseUnit <em>Base Unit</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.BaseUnit
		 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfilePackageImpl#getBaseUnit()
		 * @generated
		 */
		EEnum BASE_UNIT = eINSTANCE.getBaseUnit();

	}

} //FMIProfilePackage
