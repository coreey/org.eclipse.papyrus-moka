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

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType;
import org.eclipse.papyrus.moka.fmi.modeldescription.BooleanType;
import org.eclipse.papyrus.moka.fmi.modeldescription.CategoryType;
import org.eclipse.papyrus.moka.fmi.modeldescription.CausalityType;
import org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType;
import org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType;
import org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem;
import org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem1;
import org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType;
import org.eclipse.papyrus.moka.fmi.modeldescription.DocumentRoot;
import org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType;
import org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType1;
import org.eclipse.papyrus.moka.fmi.modeldescription.FileType;
import org.eclipse.papyrus.moka.fmi.modeldescription.FileType1;
import org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Annotation;
import org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable;
import org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType;
import org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit;
import org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2VariableDependency;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiFactory;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage;
import org.eclipse.papyrus.moka.fmi.modeldescription.InitialType;
import org.eclipse.papyrus.moka.fmi.modeldescription.InitialUnknownsType;
import org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType;
import org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1;
import org.eclipse.papyrus.moka.fmi.modeldescription.ItemType;
import org.eclipse.papyrus.moka.fmi.modeldescription.LogCategoriesType;
import org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType;
import org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType;
import org.eclipse.papyrus.moka.fmi.modeldescription.ModelVariablesType;
import org.eclipse.papyrus.moka.fmi.modeldescription.RealType;
import org.eclipse.papyrus.moka.fmi.modeldescription.RealType1;
import org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType;
import org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType1;
import org.eclipse.papyrus.moka.fmi.modeldescription.StringType;
import org.eclipse.papyrus.moka.fmi.modeldescription.ToolType;
import org.eclipse.papyrus.moka.fmi.modeldescription.TypeDefinitionsType;
import org.eclipse.papyrus.moka.fmi.modeldescription.UnitDefinitionsType;
import org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType;
import org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1;
import org.eclipse.papyrus.moka.fmi.modeldescription.VariabilityType;
import org.eclipse.papyrus.moka.fmi.modeldescription.VariableNamingConventionType;

import org.eclipse.papyrus.moka.fmi.modeldescription.util.FmiValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FmiPackageImpl extends EPackageImpl implements FmiPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseUnitTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coSimulationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultExperimentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass displayUnitTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fmi2AnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fmi2ScalarVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fmi2SimpleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fmi2UnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fmi2VariableDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fmiModelDescriptionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initialUnknownsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itemTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logCategoriesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelExchangeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelStructureTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelVariablesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceFilesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceFilesType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toolTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeDefinitionsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitDefinitionsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unknownTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unknownType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum causalityTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dependenciesKindTypeItemEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dependenciesKindTypeItem1EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum initialTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum variabilityTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum variableNamingConventionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType causalityTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dependenciesKindTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dependenciesKindType1EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dependenciesKindTypeItemObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dependenciesKindTypeItemObject1EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dependenciesTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dependenciesType1EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType initialTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType variabilityTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType variableNamingConventionTypeObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FmiPackageImpl() {
		super(eNS_URI, FmiFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link FmiPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FmiPackage init() {
		if (isInited) return (FmiPackage)EPackage.Registry.INSTANCE.getEPackage(FmiPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredFmiPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		FmiPackageImpl theFmiPackage = registeredFmiPackage instanceof FmiPackageImpl ? (FmiPackageImpl)registeredFmiPackage : new FmiPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theFmiPackage.createPackageContents();

		// Initialize created meta-data
		theFmiPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theFmiPackage,
			 new EValidator.Descriptor() {
				 @Override
				 public EValidator getEValidator() {
					 return FmiValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theFmiPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FmiPackage.eNS_URI, theFmiPackage);
		return theFmiPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBaseUnitType() {
		return baseUnitTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBaseUnitType_A() {
		return (EAttribute)baseUnitTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBaseUnitType_Cd() {
		return (EAttribute)baseUnitTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBaseUnitType_Factor() {
		return (EAttribute)baseUnitTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBaseUnitType_K() {
		return (EAttribute)baseUnitTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBaseUnitType_Kg() {
		return (EAttribute)baseUnitTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBaseUnitType_M() {
		return (EAttribute)baseUnitTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBaseUnitType_Mol() {
		return (EAttribute)baseUnitTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBaseUnitType_Offset() {
		return (EAttribute)baseUnitTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBaseUnitType_Rad() {
		return (EAttribute)baseUnitTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBaseUnitType_S() {
		return (EAttribute)baseUnitTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBooleanType() {
		return booleanTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBooleanType_DeclaredType() {
		return (EAttribute)booleanTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBooleanType_Start() {
		return (EAttribute)booleanTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCategoryType() {
		return categoryTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategoryType_Description() {
		return (EAttribute)categoryTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategoryType_Name() {
		return (EAttribute)categoryTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCoSimulationType() {
		return coSimulationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCoSimulationType_SourceFiles() {
		return (EReference)coSimulationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCoSimulationType_CanBeInstantiatedOnlyOncePerProcess() {
		return (EAttribute)coSimulationTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCoSimulationType_CanGetAndSetFMUstate() {
		return (EAttribute)coSimulationTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCoSimulationType_CanHandleVariableCommunicationStepSize() {
		return (EAttribute)coSimulationTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCoSimulationType_CanInterpolateInputs() {
		return (EAttribute)coSimulationTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCoSimulationType_CanNotUseMemoryManagementFunctions() {
		return (EAttribute)coSimulationTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCoSimulationType_CanRunAsynchronuously() {
		return (EAttribute)coSimulationTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCoSimulationType_CanSerializeFMUstate() {
		return (EAttribute)coSimulationTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCoSimulationType_MaxOutputDerivativeOrder() {
		return (EAttribute)coSimulationTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCoSimulationType_ModelIdentifier() {
		return (EAttribute)coSimulationTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCoSimulationType_NeedsExecutionTool() {
		return (EAttribute)coSimulationTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCoSimulationType_ProvidesDirectionalDerivative() {
		return (EAttribute)coSimulationTypeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDefaultExperimentType() {
		return defaultExperimentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefaultExperimentType_StartTime() {
		return (EAttribute)defaultExperimentTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefaultExperimentType_StepSize() {
		return (EAttribute)defaultExperimentTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefaultExperimentType_StopTime() {
		return (EAttribute)defaultExperimentTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefaultExperimentType_Tolerance() {
		return (EAttribute)defaultExperimentTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDisplayUnitType() {
		return displayUnitTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDisplayUnitType_Factor() {
		return (EAttribute)displayUnitTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDisplayUnitType_Name() {
		return (EAttribute)displayUnitTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDisplayUnitType_Offset() {
		return (EAttribute)displayUnitTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_FmiModelDescription() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEnumerationType() {
		return enumerationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEnumerationType_DeclaredType() {
		return (EAttribute)enumerationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEnumerationType_Max() {
		return (EAttribute)enumerationTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEnumerationType_Min() {
		return (EAttribute)enumerationTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEnumerationType_Quantity() {
		return (EAttribute)enumerationTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEnumerationType_Start() {
		return (EAttribute)enumerationTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEnumerationType1() {
		return enumerationType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEnumerationType1_Group() {
		return (EAttribute)enumerationType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEnumerationType1_Item() {
		return (EReference)enumerationType1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEnumerationType1_Quantity() {
		return (EAttribute)enumerationType1EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFileType() {
		return fileTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFileType_Name() {
		return (EAttribute)fileTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFileType1() {
		return fileType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFileType1_Name() {
		return (EAttribute)fileType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFmi2Annotation() {
		return fmi2AnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmi2Annotation_Group() {
		return (EAttribute)fmi2AnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmi2Annotation_Tool() {
		return (EReference)fmi2AnnotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFmi2ScalarVariable() {
		return fmi2ScalarVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmi2ScalarVariable_Real() {
		return (EReference)fmi2ScalarVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmi2ScalarVariable_Integer() {
		return (EReference)fmi2ScalarVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmi2ScalarVariable_Boolean() {
		return (EReference)fmi2ScalarVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmi2ScalarVariable_String() {
		return (EReference)fmi2ScalarVariableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmi2ScalarVariable_Enumeration() {
		return (EReference)fmi2ScalarVariableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmi2ScalarVariable_Annotations() {
		return (EReference)fmi2ScalarVariableEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmi2ScalarVariable_CanHandleMultipleSetPerTimeInstant() {
		return (EAttribute)fmi2ScalarVariableEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmi2ScalarVariable_Causality() {
		return (EAttribute)fmi2ScalarVariableEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmi2ScalarVariable_Description() {
		return (EAttribute)fmi2ScalarVariableEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmi2ScalarVariable_Initial() {
		return (EAttribute)fmi2ScalarVariableEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmi2ScalarVariable_Name() {
		return (EAttribute)fmi2ScalarVariableEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmi2ScalarVariable_ValueReference() {
		return (EAttribute)fmi2ScalarVariableEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmi2ScalarVariable_Variability() {
		return (EAttribute)fmi2ScalarVariableEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFmi2SimpleType() {
		return fmi2SimpleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmi2SimpleType_Real() {
		return (EReference)fmi2SimpleTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmi2SimpleType_Integer() {
		return (EReference)fmi2SimpleTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmi2SimpleType_Boolean() {
		return (EReference)fmi2SimpleTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmi2SimpleType_String() {
		return (EReference)fmi2SimpleTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmi2SimpleType_Enumeration() {
		return (EReference)fmi2SimpleTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmi2SimpleType_Description() {
		return (EAttribute)fmi2SimpleTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmi2SimpleType_Name() {
		return (EAttribute)fmi2SimpleTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFmi2Unit() {
		return fmi2UnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmi2Unit_BaseUnit() {
		return (EReference)fmi2UnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmi2Unit_Group() {
		return (EAttribute)fmi2UnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmi2Unit_DisplayUnit() {
		return (EReference)fmi2UnitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmi2Unit_Name() {
		return (EAttribute)fmi2UnitEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFmi2VariableDependency() {
		return fmi2VariableDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmi2VariableDependency_Group() {
		return (EAttribute)fmi2VariableDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmi2VariableDependency_Unknown() {
		return (EReference)fmi2VariableDependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFmiModelDescriptionType() {
		return fmiModelDescriptionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmiModelDescriptionType_Group() {
		return (EAttribute)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmiModelDescriptionType_ModelExchange() {
		return (EReference)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmiModelDescriptionType_CoSimulation() {
		return (EReference)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmiModelDescriptionType_UnitDefinitions() {
		return (EReference)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmiModelDescriptionType_TypeDefinitions() {
		return (EReference)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmiModelDescriptionType_LogCategories() {
		return (EReference)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmiModelDescriptionType_DefaultExperiment() {
		return (EReference)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmiModelDescriptionType_VendorAnnotations() {
		return (EReference)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmiModelDescriptionType_ModelVariables() {
		return (EReference)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFmiModelDescriptionType_ModelStructure() {
		return (EReference)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmiModelDescriptionType_Author() {
		return (EAttribute)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmiModelDescriptionType_Copyright() {
		return (EAttribute)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmiModelDescriptionType_Description() {
		return (EAttribute)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmiModelDescriptionType_FmiVersion() {
		return (EAttribute)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmiModelDescriptionType_GenerationDateAndTime() {
		return (EAttribute)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmiModelDescriptionType_GenerationTool() {
		return (EAttribute)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmiModelDescriptionType_Guid() {
		return (EAttribute)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmiModelDescriptionType_License() {
		return (EAttribute)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmiModelDescriptionType_ModelName() {
		return (EAttribute)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmiModelDescriptionType_NumberOfEventIndicators() {
		return (EAttribute)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmiModelDescriptionType_VariableNamingConvention() {
		return (EAttribute)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFmiModelDescriptionType_Version() {
		return (EAttribute)fmiModelDescriptionTypeEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInitialUnknownsType() {
		return initialUnknownsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInitialUnknownsType_Group() {
		return (EAttribute)initialUnknownsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInitialUnknownsType_Unknown() {
		return (EReference)initialUnknownsTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntegerType() {
		return integerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntegerType_DeclaredType() {
		return (EAttribute)integerTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntegerType_Max() {
		return (EAttribute)integerTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntegerType_Min() {
		return (EAttribute)integerTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntegerType_Quantity() {
		return (EAttribute)integerTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntegerType_Start() {
		return (EAttribute)integerTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntegerType1() {
		return integerType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntegerType1_Max() {
		return (EAttribute)integerType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntegerType1_Min() {
		return (EAttribute)integerType1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntegerType1_Quantity() {
		return (EAttribute)integerType1EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getItemType() {
		return itemTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getItemType_Description() {
		return (EAttribute)itemTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getItemType_Name() {
		return (EAttribute)itemTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getItemType_Value() {
		return (EAttribute)itemTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLogCategoriesType() {
		return logCategoriesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLogCategoriesType_Group() {
		return (EAttribute)logCategoriesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLogCategoriesType_Category() {
		return (EReference)logCategoriesTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModelExchangeType() {
		return modelExchangeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelExchangeType_SourceFiles() {
		return (EReference)modelExchangeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModelExchangeType_CanBeInstantiatedOnlyOncePerProcess() {
		return (EAttribute)modelExchangeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModelExchangeType_CanGetAndSetFMUstate() {
		return (EAttribute)modelExchangeTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModelExchangeType_CanNotUseMemoryManagementFunctions() {
		return (EAttribute)modelExchangeTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModelExchangeType_CanSerializeFMUstate() {
		return (EAttribute)modelExchangeTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModelExchangeType_CompletedIntegratorStepNotNeeded() {
		return (EAttribute)modelExchangeTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModelExchangeType_ModelIdentifier() {
		return (EAttribute)modelExchangeTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModelExchangeType_NeedsExecutionTool() {
		return (EAttribute)modelExchangeTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModelExchangeType_ProvidesDirectionalDerivative() {
		return (EAttribute)modelExchangeTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModelStructureType() {
		return modelStructureTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelStructureType_Outputs() {
		return (EReference)modelStructureTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelStructureType_Derivatives() {
		return (EReference)modelStructureTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelStructureType_InitialUnknowns() {
		return (EReference)modelStructureTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModelVariablesType() {
		return modelVariablesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModelVariablesType_Group() {
		return (EAttribute)modelVariablesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelVariablesType_ScalarVariable() {
		return (EReference)modelVariablesTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRealType() {
		return realTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType_DeclaredType() {
		return (EAttribute)realTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType_Derivative() {
		return (EAttribute)realTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType_DisplayUnit() {
		return (EAttribute)realTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType_Max() {
		return (EAttribute)realTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType_Min() {
		return (EAttribute)realTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType_Nominal() {
		return (EAttribute)realTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType_Quantity() {
		return (EAttribute)realTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType_Reinit() {
		return (EAttribute)realTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType_RelativeQuantity() {
		return (EAttribute)realTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType_Start() {
		return (EAttribute)realTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType_Unbounded() {
		return (EAttribute)realTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType_Unit() {
		return (EAttribute)realTypeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRealType1() {
		return realType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType1_DisplayUnit() {
		return (EAttribute)realType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType1_Max() {
		return (EAttribute)realType1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType1_Min() {
		return (EAttribute)realType1EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType1_Nominal() {
		return (EAttribute)realType1EClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType1_Quantity() {
		return (EAttribute)realType1EClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType1_RelativeQuantity() {
		return (EAttribute)realType1EClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType1_Unbounded() {
		return (EAttribute)realType1EClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealType1_Unit() {
		return (EAttribute)realType1EClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSourceFilesType() {
		return sourceFilesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSourceFilesType_Group() {
		return (EAttribute)sourceFilesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSourceFilesType_File() {
		return (EReference)sourceFilesTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSourceFilesType1() {
		return sourceFilesType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSourceFilesType1_Group() {
		return (EAttribute)sourceFilesType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSourceFilesType1_File() {
		return (EReference)sourceFilesType1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStringType() {
		return stringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringType_DeclaredType() {
		return (EAttribute)stringTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringType_Start() {
		return (EAttribute)stringTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getToolType() {
		return toolTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getToolType_Any() {
		return (EAttribute)toolTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getToolType_Name() {
		return (EAttribute)toolTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeDefinitionsType() {
		return typeDefinitionsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTypeDefinitionsType_Group() {
		return (EAttribute)typeDefinitionsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeDefinitionsType_SimpleType() {
		return (EReference)typeDefinitionsTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUnitDefinitionsType() {
		return unitDefinitionsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnitDefinitionsType_Group() {
		return (EAttribute)unitDefinitionsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUnitDefinitionsType_Unit() {
		return (EReference)unitDefinitionsTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUnknownType() {
		return unknownTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnknownType_Dependencies() {
		return (EAttribute)unknownTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnknownType_DependenciesKind() {
		return (EAttribute)unknownTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnknownType_Index() {
		return (EAttribute)unknownTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUnknownType1() {
		return unknownType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnknownType1_Dependencies() {
		return (EAttribute)unknownType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnknownType1_DependenciesKind() {
		return (EAttribute)unknownType1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnknownType1_Index() {
		return (EAttribute)unknownType1EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getCausalityType() {
		return causalityTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getDependenciesKindTypeItem() {
		return dependenciesKindTypeItemEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getDependenciesKindTypeItem1() {
		return dependenciesKindTypeItem1EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getInitialType() {
		return initialTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getVariabilityType() {
		return variabilityTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getVariableNamingConventionType() {
		return variableNamingConventionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getCausalityTypeObject() {
		return causalityTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getDependenciesKindType() {
		return dependenciesKindTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getDependenciesKindType1() {
		return dependenciesKindType1EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getDependenciesKindTypeItemObject() {
		return dependenciesKindTypeItemObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getDependenciesKindTypeItemObject1() {
		return dependenciesKindTypeItemObject1EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getDependenciesType() {
		return dependenciesTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getDependenciesType1() {
		return dependenciesType1EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getInitialTypeObject() {
		return initialTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getVariabilityTypeObject() {
		return variabilityTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getVariableNamingConventionTypeObject() {
		return variableNamingConventionTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FmiFactory getFmiFactory() {
		return (FmiFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		baseUnitTypeEClass = createEClass(BASE_UNIT_TYPE);
		createEAttribute(baseUnitTypeEClass, BASE_UNIT_TYPE__A);
		createEAttribute(baseUnitTypeEClass, BASE_UNIT_TYPE__CD);
		createEAttribute(baseUnitTypeEClass, BASE_UNIT_TYPE__FACTOR);
		createEAttribute(baseUnitTypeEClass, BASE_UNIT_TYPE__K);
		createEAttribute(baseUnitTypeEClass, BASE_UNIT_TYPE__KG);
		createEAttribute(baseUnitTypeEClass, BASE_UNIT_TYPE__M);
		createEAttribute(baseUnitTypeEClass, BASE_UNIT_TYPE__MOL);
		createEAttribute(baseUnitTypeEClass, BASE_UNIT_TYPE__OFFSET);
		createEAttribute(baseUnitTypeEClass, BASE_UNIT_TYPE__RAD);
		createEAttribute(baseUnitTypeEClass, BASE_UNIT_TYPE__S);

		booleanTypeEClass = createEClass(BOOLEAN_TYPE);
		createEAttribute(booleanTypeEClass, BOOLEAN_TYPE__DECLARED_TYPE);
		createEAttribute(booleanTypeEClass, BOOLEAN_TYPE__START);

		categoryTypeEClass = createEClass(CATEGORY_TYPE);
		createEAttribute(categoryTypeEClass, CATEGORY_TYPE__DESCRIPTION);
		createEAttribute(categoryTypeEClass, CATEGORY_TYPE__NAME);

		coSimulationTypeEClass = createEClass(CO_SIMULATION_TYPE);
		createEReference(coSimulationTypeEClass, CO_SIMULATION_TYPE__SOURCE_FILES);
		createEAttribute(coSimulationTypeEClass, CO_SIMULATION_TYPE__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS);
		createEAttribute(coSimulationTypeEClass, CO_SIMULATION_TYPE__CAN_GET_AND_SET_FM_USTATE);
		createEAttribute(coSimulationTypeEClass, CO_SIMULATION_TYPE__CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE);
		createEAttribute(coSimulationTypeEClass, CO_SIMULATION_TYPE__CAN_INTERPOLATE_INPUTS);
		createEAttribute(coSimulationTypeEClass, CO_SIMULATION_TYPE__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS);
		createEAttribute(coSimulationTypeEClass, CO_SIMULATION_TYPE__CAN_RUN_ASYNCHRONUOUSLY);
		createEAttribute(coSimulationTypeEClass, CO_SIMULATION_TYPE__CAN_SERIALIZE_FM_USTATE);
		createEAttribute(coSimulationTypeEClass, CO_SIMULATION_TYPE__MAX_OUTPUT_DERIVATIVE_ORDER);
		createEAttribute(coSimulationTypeEClass, CO_SIMULATION_TYPE__MODEL_IDENTIFIER);
		createEAttribute(coSimulationTypeEClass, CO_SIMULATION_TYPE__NEEDS_EXECUTION_TOOL);
		createEAttribute(coSimulationTypeEClass, CO_SIMULATION_TYPE__PROVIDES_DIRECTIONAL_DERIVATIVE);

		defaultExperimentTypeEClass = createEClass(DEFAULT_EXPERIMENT_TYPE);
		createEAttribute(defaultExperimentTypeEClass, DEFAULT_EXPERIMENT_TYPE__START_TIME);
		createEAttribute(defaultExperimentTypeEClass, DEFAULT_EXPERIMENT_TYPE__STEP_SIZE);
		createEAttribute(defaultExperimentTypeEClass, DEFAULT_EXPERIMENT_TYPE__STOP_TIME);
		createEAttribute(defaultExperimentTypeEClass, DEFAULT_EXPERIMENT_TYPE__TOLERANCE);

		displayUnitTypeEClass = createEClass(DISPLAY_UNIT_TYPE);
		createEAttribute(displayUnitTypeEClass, DISPLAY_UNIT_TYPE__FACTOR);
		createEAttribute(displayUnitTypeEClass, DISPLAY_UNIT_TYPE__NAME);
		createEAttribute(displayUnitTypeEClass, DISPLAY_UNIT_TYPE__OFFSET);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__FMI_MODEL_DESCRIPTION);

		enumerationTypeEClass = createEClass(ENUMERATION_TYPE);
		createEAttribute(enumerationTypeEClass, ENUMERATION_TYPE__DECLARED_TYPE);
		createEAttribute(enumerationTypeEClass, ENUMERATION_TYPE__MAX);
		createEAttribute(enumerationTypeEClass, ENUMERATION_TYPE__MIN);
		createEAttribute(enumerationTypeEClass, ENUMERATION_TYPE__QUANTITY);
		createEAttribute(enumerationTypeEClass, ENUMERATION_TYPE__START);

		enumerationType1EClass = createEClass(ENUMERATION_TYPE1);
		createEAttribute(enumerationType1EClass, ENUMERATION_TYPE1__GROUP);
		createEReference(enumerationType1EClass, ENUMERATION_TYPE1__ITEM);
		createEAttribute(enumerationType1EClass, ENUMERATION_TYPE1__QUANTITY);

		fileTypeEClass = createEClass(FILE_TYPE);
		createEAttribute(fileTypeEClass, FILE_TYPE__NAME);

		fileType1EClass = createEClass(FILE_TYPE1);
		createEAttribute(fileType1EClass, FILE_TYPE1__NAME);

		fmi2AnnotationEClass = createEClass(FMI2_ANNOTATION);
		createEAttribute(fmi2AnnotationEClass, FMI2_ANNOTATION__GROUP);
		createEReference(fmi2AnnotationEClass, FMI2_ANNOTATION__TOOL);

		fmi2ScalarVariableEClass = createEClass(FMI2_SCALAR_VARIABLE);
		createEReference(fmi2ScalarVariableEClass, FMI2_SCALAR_VARIABLE__REAL);
		createEReference(fmi2ScalarVariableEClass, FMI2_SCALAR_VARIABLE__INTEGER);
		createEReference(fmi2ScalarVariableEClass, FMI2_SCALAR_VARIABLE__BOOLEAN);
		createEReference(fmi2ScalarVariableEClass, FMI2_SCALAR_VARIABLE__STRING);
		createEReference(fmi2ScalarVariableEClass, FMI2_SCALAR_VARIABLE__ENUMERATION);
		createEReference(fmi2ScalarVariableEClass, FMI2_SCALAR_VARIABLE__ANNOTATIONS);
		createEAttribute(fmi2ScalarVariableEClass, FMI2_SCALAR_VARIABLE__CAN_HANDLE_MULTIPLE_SET_PER_TIME_INSTANT);
		createEAttribute(fmi2ScalarVariableEClass, FMI2_SCALAR_VARIABLE__CAUSALITY);
		createEAttribute(fmi2ScalarVariableEClass, FMI2_SCALAR_VARIABLE__DESCRIPTION);
		createEAttribute(fmi2ScalarVariableEClass, FMI2_SCALAR_VARIABLE__INITIAL);
		createEAttribute(fmi2ScalarVariableEClass, FMI2_SCALAR_VARIABLE__NAME);
		createEAttribute(fmi2ScalarVariableEClass, FMI2_SCALAR_VARIABLE__VALUE_REFERENCE);
		createEAttribute(fmi2ScalarVariableEClass, FMI2_SCALAR_VARIABLE__VARIABILITY);

		fmi2SimpleTypeEClass = createEClass(FMI2_SIMPLE_TYPE);
		createEReference(fmi2SimpleTypeEClass, FMI2_SIMPLE_TYPE__REAL);
		createEReference(fmi2SimpleTypeEClass, FMI2_SIMPLE_TYPE__INTEGER);
		createEReference(fmi2SimpleTypeEClass, FMI2_SIMPLE_TYPE__BOOLEAN);
		createEReference(fmi2SimpleTypeEClass, FMI2_SIMPLE_TYPE__STRING);
		createEReference(fmi2SimpleTypeEClass, FMI2_SIMPLE_TYPE__ENUMERATION);
		createEAttribute(fmi2SimpleTypeEClass, FMI2_SIMPLE_TYPE__DESCRIPTION);
		createEAttribute(fmi2SimpleTypeEClass, FMI2_SIMPLE_TYPE__NAME);

		fmi2UnitEClass = createEClass(FMI2_UNIT);
		createEReference(fmi2UnitEClass, FMI2_UNIT__BASE_UNIT);
		createEAttribute(fmi2UnitEClass, FMI2_UNIT__GROUP);
		createEReference(fmi2UnitEClass, FMI2_UNIT__DISPLAY_UNIT);
		createEAttribute(fmi2UnitEClass, FMI2_UNIT__NAME);

		fmi2VariableDependencyEClass = createEClass(FMI2_VARIABLE_DEPENDENCY);
		createEAttribute(fmi2VariableDependencyEClass, FMI2_VARIABLE_DEPENDENCY__GROUP);
		createEReference(fmi2VariableDependencyEClass, FMI2_VARIABLE_DEPENDENCY__UNKNOWN);

		fmiModelDescriptionTypeEClass = createEClass(FMI_MODEL_DESCRIPTION_TYPE);
		createEAttribute(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__GROUP);
		createEReference(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__MODEL_EXCHANGE);
		createEReference(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__CO_SIMULATION);
		createEReference(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__UNIT_DEFINITIONS);
		createEReference(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__TYPE_DEFINITIONS);
		createEReference(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__LOG_CATEGORIES);
		createEReference(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__DEFAULT_EXPERIMENT);
		createEReference(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__VENDOR_ANNOTATIONS);
		createEReference(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__MODEL_VARIABLES);
		createEReference(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__MODEL_STRUCTURE);
		createEAttribute(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__AUTHOR);
		createEAttribute(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__COPYRIGHT);
		createEAttribute(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__DESCRIPTION);
		createEAttribute(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__FMI_VERSION);
		createEAttribute(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__GENERATION_DATE_AND_TIME);
		createEAttribute(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__GENERATION_TOOL);
		createEAttribute(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__GUID);
		createEAttribute(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__LICENSE);
		createEAttribute(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__MODEL_NAME);
		createEAttribute(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__NUMBER_OF_EVENT_INDICATORS);
		createEAttribute(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__VARIABLE_NAMING_CONVENTION);
		createEAttribute(fmiModelDescriptionTypeEClass, FMI_MODEL_DESCRIPTION_TYPE__VERSION);

		initialUnknownsTypeEClass = createEClass(INITIAL_UNKNOWNS_TYPE);
		createEAttribute(initialUnknownsTypeEClass, INITIAL_UNKNOWNS_TYPE__GROUP);
		createEReference(initialUnknownsTypeEClass, INITIAL_UNKNOWNS_TYPE__UNKNOWN);

		integerTypeEClass = createEClass(INTEGER_TYPE);
		createEAttribute(integerTypeEClass, INTEGER_TYPE__DECLARED_TYPE);
		createEAttribute(integerTypeEClass, INTEGER_TYPE__MAX);
		createEAttribute(integerTypeEClass, INTEGER_TYPE__MIN);
		createEAttribute(integerTypeEClass, INTEGER_TYPE__QUANTITY);
		createEAttribute(integerTypeEClass, INTEGER_TYPE__START);

		integerType1EClass = createEClass(INTEGER_TYPE1);
		createEAttribute(integerType1EClass, INTEGER_TYPE1__MAX);
		createEAttribute(integerType1EClass, INTEGER_TYPE1__MIN);
		createEAttribute(integerType1EClass, INTEGER_TYPE1__QUANTITY);

		itemTypeEClass = createEClass(ITEM_TYPE);
		createEAttribute(itemTypeEClass, ITEM_TYPE__DESCRIPTION);
		createEAttribute(itemTypeEClass, ITEM_TYPE__NAME);
		createEAttribute(itemTypeEClass, ITEM_TYPE__VALUE);

		logCategoriesTypeEClass = createEClass(LOG_CATEGORIES_TYPE);
		createEAttribute(logCategoriesTypeEClass, LOG_CATEGORIES_TYPE__GROUP);
		createEReference(logCategoriesTypeEClass, LOG_CATEGORIES_TYPE__CATEGORY);

		modelExchangeTypeEClass = createEClass(MODEL_EXCHANGE_TYPE);
		createEReference(modelExchangeTypeEClass, MODEL_EXCHANGE_TYPE__SOURCE_FILES);
		createEAttribute(modelExchangeTypeEClass, MODEL_EXCHANGE_TYPE__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS);
		createEAttribute(modelExchangeTypeEClass, MODEL_EXCHANGE_TYPE__CAN_GET_AND_SET_FM_USTATE);
		createEAttribute(modelExchangeTypeEClass, MODEL_EXCHANGE_TYPE__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS);
		createEAttribute(modelExchangeTypeEClass, MODEL_EXCHANGE_TYPE__CAN_SERIALIZE_FM_USTATE);
		createEAttribute(modelExchangeTypeEClass, MODEL_EXCHANGE_TYPE__COMPLETED_INTEGRATOR_STEP_NOT_NEEDED);
		createEAttribute(modelExchangeTypeEClass, MODEL_EXCHANGE_TYPE__MODEL_IDENTIFIER);
		createEAttribute(modelExchangeTypeEClass, MODEL_EXCHANGE_TYPE__NEEDS_EXECUTION_TOOL);
		createEAttribute(modelExchangeTypeEClass, MODEL_EXCHANGE_TYPE__PROVIDES_DIRECTIONAL_DERIVATIVE);

		modelStructureTypeEClass = createEClass(MODEL_STRUCTURE_TYPE);
		createEReference(modelStructureTypeEClass, MODEL_STRUCTURE_TYPE__OUTPUTS);
		createEReference(modelStructureTypeEClass, MODEL_STRUCTURE_TYPE__DERIVATIVES);
		createEReference(modelStructureTypeEClass, MODEL_STRUCTURE_TYPE__INITIAL_UNKNOWNS);

		modelVariablesTypeEClass = createEClass(MODEL_VARIABLES_TYPE);
		createEAttribute(modelVariablesTypeEClass, MODEL_VARIABLES_TYPE__GROUP);
		createEReference(modelVariablesTypeEClass, MODEL_VARIABLES_TYPE__SCALAR_VARIABLE);

		realTypeEClass = createEClass(REAL_TYPE);
		createEAttribute(realTypeEClass, REAL_TYPE__DECLARED_TYPE);
		createEAttribute(realTypeEClass, REAL_TYPE__DERIVATIVE);
		createEAttribute(realTypeEClass, REAL_TYPE__DISPLAY_UNIT);
		createEAttribute(realTypeEClass, REAL_TYPE__MAX);
		createEAttribute(realTypeEClass, REAL_TYPE__MIN);
		createEAttribute(realTypeEClass, REAL_TYPE__NOMINAL);
		createEAttribute(realTypeEClass, REAL_TYPE__QUANTITY);
		createEAttribute(realTypeEClass, REAL_TYPE__REINIT);
		createEAttribute(realTypeEClass, REAL_TYPE__RELATIVE_QUANTITY);
		createEAttribute(realTypeEClass, REAL_TYPE__START);
		createEAttribute(realTypeEClass, REAL_TYPE__UNBOUNDED);
		createEAttribute(realTypeEClass, REAL_TYPE__UNIT);

		realType1EClass = createEClass(REAL_TYPE1);
		createEAttribute(realType1EClass, REAL_TYPE1__DISPLAY_UNIT);
		createEAttribute(realType1EClass, REAL_TYPE1__MAX);
		createEAttribute(realType1EClass, REAL_TYPE1__MIN);
		createEAttribute(realType1EClass, REAL_TYPE1__NOMINAL);
		createEAttribute(realType1EClass, REAL_TYPE1__QUANTITY);
		createEAttribute(realType1EClass, REAL_TYPE1__RELATIVE_QUANTITY);
		createEAttribute(realType1EClass, REAL_TYPE1__UNBOUNDED);
		createEAttribute(realType1EClass, REAL_TYPE1__UNIT);

		sourceFilesTypeEClass = createEClass(SOURCE_FILES_TYPE);
		createEAttribute(sourceFilesTypeEClass, SOURCE_FILES_TYPE__GROUP);
		createEReference(sourceFilesTypeEClass, SOURCE_FILES_TYPE__FILE);

		sourceFilesType1EClass = createEClass(SOURCE_FILES_TYPE1);
		createEAttribute(sourceFilesType1EClass, SOURCE_FILES_TYPE1__GROUP);
		createEReference(sourceFilesType1EClass, SOURCE_FILES_TYPE1__FILE);

		stringTypeEClass = createEClass(STRING_TYPE);
		createEAttribute(stringTypeEClass, STRING_TYPE__DECLARED_TYPE);
		createEAttribute(stringTypeEClass, STRING_TYPE__START);

		toolTypeEClass = createEClass(TOOL_TYPE);
		createEAttribute(toolTypeEClass, TOOL_TYPE__ANY);
		createEAttribute(toolTypeEClass, TOOL_TYPE__NAME);

		typeDefinitionsTypeEClass = createEClass(TYPE_DEFINITIONS_TYPE);
		createEAttribute(typeDefinitionsTypeEClass, TYPE_DEFINITIONS_TYPE__GROUP);
		createEReference(typeDefinitionsTypeEClass, TYPE_DEFINITIONS_TYPE__SIMPLE_TYPE);

		unitDefinitionsTypeEClass = createEClass(UNIT_DEFINITIONS_TYPE);
		createEAttribute(unitDefinitionsTypeEClass, UNIT_DEFINITIONS_TYPE__GROUP);
		createEReference(unitDefinitionsTypeEClass, UNIT_DEFINITIONS_TYPE__UNIT);

		unknownTypeEClass = createEClass(UNKNOWN_TYPE);
		createEAttribute(unknownTypeEClass, UNKNOWN_TYPE__DEPENDENCIES);
		createEAttribute(unknownTypeEClass, UNKNOWN_TYPE__DEPENDENCIES_KIND);
		createEAttribute(unknownTypeEClass, UNKNOWN_TYPE__INDEX);

		unknownType1EClass = createEClass(UNKNOWN_TYPE1);
		createEAttribute(unknownType1EClass, UNKNOWN_TYPE1__DEPENDENCIES);
		createEAttribute(unknownType1EClass, UNKNOWN_TYPE1__DEPENDENCIES_KIND);
		createEAttribute(unknownType1EClass, UNKNOWN_TYPE1__INDEX);

		// Create enums
		causalityTypeEEnum = createEEnum(CAUSALITY_TYPE);
		dependenciesKindTypeItemEEnum = createEEnum(DEPENDENCIES_KIND_TYPE_ITEM);
		dependenciesKindTypeItem1EEnum = createEEnum(DEPENDENCIES_KIND_TYPE_ITEM1);
		initialTypeEEnum = createEEnum(INITIAL_TYPE);
		variabilityTypeEEnum = createEEnum(VARIABILITY_TYPE);
		variableNamingConventionTypeEEnum = createEEnum(VARIABLE_NAMING_CONVENTION_TYPE);

		// Create data types
		causalityTypeObjectEDataType = createEDataType(CAUSALITY_TYPE_OBJECT);
		dependenciesKindTypeEDataType = createEDataType(DEPENDENCIES_KIND_TYPE);
		dependenciesKindType1EDataType = createEDataType(DEPENDENCIES_KIND_TYPE1);
		dependenciesKindTypeItemObjectEDataType = createEDataType(DEPENDENCIES_KIND_TYPE_ITEM_OBJECT);
		dependenciesKindTypeItemObject1EDataType = createEDataType(DEPENDENCIES_KIND_TYPE_ITEM_OBJECT1);
		dependenciesTypeEDataType = createEDataType(DEPENDENCIES_TYPE);
		dependenciesType1EDataType = createEDataType(DEPENDENCIES_TYPE1);
		initialTypeObjectEDataType = createEDataType(INITIAL_TYPE_OBJECT);
		variabilityTypeObjectEDataType = createEDataType(VARIABILITY_TYPE_OBJECT);
		variableNamingConventionTypeObjectEDataType = createEDataType(VARIABLE_NAMING_CONVENTION_TYPE_OBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(baseUnitTypeEClass, BaseUnitType.class, "BaseUnitType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBaseUnitType_A(), theXMLTypePackage.getInt(), "a", "0", 0, 1, BaseUnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseUnitType_Cd(), theXMLTypePackage.getInt(), "cd", "0", 0, 1, BaseUnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseUnitType_Factor(), theXMLTypePackage.getDouble(), "factor", "1", 0, 1, BaseUnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseUnitType_K(), theXMLTypePackage.getInt(), "k", "0", 0, 1, BaseUnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseUnitType_Kg(), theXMLTypePackage.getInt(), "kg", "0", 0, 1, BaseUnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseUnitType_M(), theXMLTypePackage.getInt(), "m", "0", 0, 1, BaseUnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseUnitType_Mol(), theXMLTypePackage.getInt(), "mol", "0", 0, 1, BaseUnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseUnitType_Offset(), theXMLTypePackage.getDouble(), "offset", "0", 0, 1, BaseUnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseUnitType_Rad(), theXMLTypePackage.getInt(), "rad", "0", 0, 1, BaseUnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseUnitType_S(), theXMLTypePackage.getInt(), "s", "0", 0, 1, BaseUnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanTypeEClass, BooleanType.class, "BooleanType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanType_DeclaredType(), theXMLTypePackage.getNormalizedString(), "declaredType", null, 0, 1, BooleanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBooleanType_Start(), theXMLTypePackage.getBoolean(), "start", null, 0, 1, BooleanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(categoryTypeEClass, CategoryType.class, "CategoryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCategoryType_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, CategoryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategoryType_Name(), theXMLTypePackage.getNormalizedString(), "name", null, 1, 1, CategoryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(coSimulationTypeEClass, CoSimulationType.class, "CoSimulationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCoSimulationType_SourceFiles(), this.getSourceFilesType(), null, "sourceFiles", null, 0, 1, CoSimulationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoSimulationType_CanBeInstantiatedOnlyOncePerProcess(), theXMLTypePackage.getBoolean(), "canBeInstantiatedOnlyOncePerProcess", "false", 0, 1, CoSimulationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoSimulationType_CanGetAndSetFMUstate(), theXMLTypePackage.getBoolean(), "canGetAndSetFMUstate", "false", 0, 1, CoSimulationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoSimulationType_CanHandleVariableCommunicationStepSize(), theXMLTypePackage.getBoolean(), "canHandleVariableCommunicationStepSize", "false", 0, 1, CoSimulationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoSimulationType_CanInterpolateInputs(), theXMLTypePackage.getBoolean(), "canInterpolateInputs", "false", 0, 1, CoSimulationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoSimulationType_CanNotUseMemoryManagementFunctions(), theXMLTypePackage.getBoolean(), "canNotUseMemoryManagementFunctions", "false", 0, 1, CoSimulationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoSimulationType_CanRunAsynchronuously(), theXMLTypePackage.getBoolean(), "canRunAsynchronuously", "false", 0, 1, CoSimulationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoSimulationType_CanSerializeFMUstate(), theXMLTypePackage.getBoolean(), "canSerializeFMUstate", "false", 0, 1, CoSimulationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoSimulationType_MaxOutputDerivativeOrder(), theXMLTypePackage.getUnsignedInt(), "maxOutputDerivativeOrder", "0", 0, 1, CoSimulationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoSimulationType_ModelIdentifier(), theXMLTypePackage.getNormalizedString(), "modelIdentifier", null, 1, 1, CoSimulationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoSimulationType_NeedsExecutionTool(), theXMLTypePackage.getBoolean(), "needsExecutionTool", "false", 0, 1, CoSimulationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoSimulationType_ProvidesDirectionalDerivative(), theXMLTypePackage.getBoolean(), "providesDirectionalDerivative", "false", 0, 1, CoSimulationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defaultExperimentTypeEClass, DefaultExperimentType.class, "DefaultExperimentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefaultExperimentType_StartTime(), theXMLTypePackage.getDouble(), "startTime", null, 0, 1, DefaultExperimentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefaultExperimentType_StepSize(), theXMLTypePackage.getDouble(), "stepSize", null, 0, 1, DefaultExperimentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefaultExperimentType_StopTime(), theXMLTypePackage.getDouble(), "stopTime", null, 0, 1, DefaultExperimentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefaultExperimentType_Tolerance(), theXMLTypePackage.getDouble(), "tolerance", null, 0, 1, DefaultExperimentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(displayUnitTypeEClass, DisplayUnitType.class, "DisplayUnitType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDisplayUnitType_Factor(), theXMLTypePackage.getDouble(), "factor", "1", 0, 1, DisplayUnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDisplayUnitType_Name(), theXMLTypePackage.getNormalizedString(), "name", null, 1, 1, DisplayUnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDisplayUnitType_Offset(), theXMLTypePackage.getDouble(), "offset", "0", 0, 1, DisplayUnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_FmiModelDescription(), this.getFmiModelDescriptionType(), null, "fmiModelDescription", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(enumerationTypeEClass, EnumerationType.class, "EnumerationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumerationType_DeclaredType(), theXMLTypePackage.getNormalizedString(), "declaredType", null, 1, 1, EnumerationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumerationType_Max(), theXMLTypePackage.getInt(), "max", null, 0, 1, EnumerationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumerationType_Min(), theXMLTypePackage.getInt(), "min", null, 0, 1, EnumerationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumerationType_Quantity(), theXMLTypePackage.getNormalizedString(), "quantity", null, 0, 1, EnumerationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumerationType_Start(), theXMLTypePackage.getInt(), "start", null, 0, 1, EnumerationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumerationType1EClass, EnumerationType1.class, "EnumerationType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumerationType1_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, EnumerationType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnumerationType1_Item(), this.getItemType(), null, "item", null, 1, -1, EnumerationType1.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumerationType1_Quantity(), theXMLTypePackage.getNormalizedString(), "quantity", null, 0, 1, EnumerationType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fileTypeEClass, FileType.class, "FileType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFileType_Name(), theXMLTypePackage.getNormalizedString(), "name", null, 1, 1, FileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fileType1EClass, FileType1.class, "FileType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFileType1_Name(), theXMLTypePackage.getNormalizedString(), "name", null, 1, 1, FileType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fmi2AnnotationEClass, Fmi2Annotation.class, "Fmi2Annotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFmi2Annotation_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, Fmi2Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmi2Annotation_Tool(), this.getToolType(), null, "tool", null, 1, -1, Fmi2Annotation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(fmi2ScalarVariableEClass, Fmi2ScalarVariable.class, "Fmi2ScalarVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFmi2ScalarVariable_Real(), this.getRealType(), null, "real", null, 0, 1, Fmi2ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmi2ScalarVariable_Integer(), this.getIntegerType(), null, "integer", null, 0, 1, Fmi2ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmi2ScalarVariable_Boolean(), this.getBooleanType(), null, "boolean", null, 0, 1, Fmi2ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmi2ScalarVariable_String(), this.getStringType(), null, "string", null, 0, 1, Fmi2ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmi2ScalarVariable_Enumeration(), this.getEnumerationType(), null, "enumeration", null, 0, 1, Fmi2ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmi2ScalarVariable_Annotations(), this.getFmi2Annotation(), null, "annotations", null, 0, 1, Fmi2ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmi2ScalarVariable_CanHandleMultipleSetPerTimeInstant(), theXMLTypePackage.getBoolean(), "canHandleMultipleSetPerTimeInstant", null, 0, 1, Fmi2ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmi2ScalarVariable_Causality(), this.getCausalityType(), "causality", "local", 0, 1, Fmi2ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmi2ScalarVariable_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, Fmi2ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmi2ScalarVariable_Initial(), this.getInitialType(), "initial", null, 0, 1, Fmi2ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmi2ScalarVariable_Name(), theXMLTypePackage.getNormalizedString(), "name", null, 1, 1, Fmi2ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmi2ScalarVariable_ValueReference(), theXMLTypePackage.getUnsignedInt(), "valueReference", null, 1, 1, Fmi2ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmi2ScalarVariable_Variability(), this.getVariabilityType(), "variability", "continuous", 0, 1, Fmi2ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fmi2SimpleTypeEClass, Fmi2SimpleType.class, "Fmi2SimpleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFmi2SimpleType_Real(), this.getRealType1(), null, "real", null, 0, 1, Fmi2SimpleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmi2SimpleType_Integer(), this.getIntegerType1(), null, "integer", null, 0, 1, Fmi2SimpleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmi2SimpleType_Boolean(), ecorePackage.getEObject(), null, "boolean", null, 0, 1, Fmi2SimpleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmi2SimpleType_String(), ecorePackage.getEObject(), null, "string", null, 0, 1, Fmi2SimpleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmi2SimpleType_Enumeration(), this.getEnumerationType1(), null, "enumeration", null, 0, 1, Fmi2SimpleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmi2SimpleType_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, Fmi2SimpleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmi2SimpleType_Name(), theXMLTypePackage.getNormalizedString(), "name", null, 1, 1, Fmi2SimpleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fmi2UnitEClass, Fmi2Unit.class, "Fmi2Unit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFmi2Unit_BaseUnit(), this.getBaseUnitType(), null, "baseUnit", null, 0, 1, Fmi2Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmi2Unit_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, Fmi2Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmi2Unit_DisplayUnit(), this.getDisplayUnitType(), null, "displayUnit", null, 0, -1, Fmi2Unit.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmi2Unit_Name(), theXMLTypePackage.getNormalizedString(), "name", null, 1, 1, Fmi2Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fmi2VariableDependencyEClass, Fmi2VariableDependency.class, "Fmi2VariableDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFmi2VariableDependency_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, Fmi2VariableDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmi2VariableDependency_Unknown(), this.getUnknownType1(), null, "unknown", null, 1, -1, Fmi2VariableDependency.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(fmiModelDescriptionTypeEClass, FmiModelDescriptionType.class, "FmiModelDescriptionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFmiModelDescriptionType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmiModelDescriptionType_ModelExchange(), this.getModelExchangeType(), null, "modelExchange", null, 0, 2, FmiModelDescriptionType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFmiModelDescriptionType_CoSimulation(), this.getCoSimulationType(), null, "coSimulation", null, 0, 2, FmiModelDescriptionType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFmiModelDescriptionType_UnitDefinitions(), this.getUnitDefinitionsType(), null, "unitDefinitions", null, 0, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmiModelDescriptionType_TypeDefinitions(), this.getTypeDefinitionsType(), null, "typeDefinitions", null, 0, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmiModelDescriptionType_LogCategories(), this.getLogCategoriesType(), null, "logCategories", null, 0, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmiModelDescriptionType_DefaultExperiment(), this.getDefaultExperimentType(), null, "defaultExperiment", null, 0, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmiModelDescriptionType_VendorAnnotations(), this.getFmi2Annotation(), null, "vendorAnnotations", null, 0, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmiModelDescriptionType_ModelVariables(), this.getModelVariablesType(), null, "modelVariables", null, 1, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFmiModelDescriptionType_ModelStructure(), this.getModelStructureType(), null, "modelStructure", null, 1, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmiModelDescriptionType_Author(), theXMLTypePackage.getString(), "author", null, 0, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmiModelDescriptionType_Copyright(), theXMLTypePackage.getString(), "copyright", null, 0, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmiModelDescriptionType_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmiModelDescriptionType_FmiVersion(), theXMLTypePackage.getNormalizedString(), "fmiVersion", "2.0", 1, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmiModelDescriptionType_GenerationDateAndTime(), theXMLTypePackage.getDateTime(), "generationDateAndTime", null, 0, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmiModelDescriptionType_GenerationTool(), theXMLTypePackage.getNormalizedString(), "generationTool", null, 0, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmiModelDescriptionType_Guid(), theXMLTypePackage.getNormalizedString(), "guid", null, 1, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmiModelDescriptionType_License(), theXMLTypePackage.getString(), "license", null, 0, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmiModelDescriptionType_ModelName(), theXMLTypePackage.getString(), "modelName", null, 1, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmiModelDescriptionType_NumberOfEventIndicators(), theXMLTypePackage.getUnsignedInt(), "numberOfEventIndicators", null, 0, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmiModelDescriptionType_VariableNamingConvention(), this.getVariableNamingConventionType(), "variableNamingConvention", "flat", 0, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFmiModelDescriptionType_Version(), theXMLTypePackage.getNormalizedString(), "version", null, 0, 1, FmiModelDescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(initialUnknownsTypeEClass, InitialUnknownsType.class, "InitialUnknownsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInitialUnknownsType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, InitialUnknownsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInitialUnknownsType_Unknown(), this.getUnknownType(), null, "unknown", null, 1, -1, InitialUnknownsType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(integerTypeEClass, IntegerType.class, "IntegerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerType_DeclaredType(), theXMLTypePackage.getNormalizedString(), "declaredType", null, 0, 1, IntegerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegerType_Max(), theXMLTypePackage.getInt(), "max", null, 0, 1, IntegerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegerType_Min(), theXMLTypePackage.getInt(), "min", null, 0, 1, IntegerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegerType_Quantity(), theXMLTypePackage.getNormalizedString(), "quantity", null, 0, 1, IntegerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegerType_Start(), theXMLTypePackage.getInt(), "start", null, 0, 1, IntegerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerType1EClass, IntegerType1.class, "IntegerType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerType1_Max(), theXMLTypePackage.getInt(), "max", null, 0, 1, IntegerType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegerType1_Min(), theXMLTypePackage.getInt(), "min", null, 0, 1, IntegerType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegerType1_Quantity(), theXMLTypePackage.getNormalizedString(), "quantity", null, 0, 1, IntegerType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(itemTypeEClass, ItemType.class, "ItemType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getItemType_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, ItemType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getItemType_Name(), theXMLTypePackage.getNormalizedString(), "name", null, 1, 1, ItemType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getItemType_Value(), theXMLTypePackage.getInt(), "value", null, 1, 1, ItemType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(logCategoriesTypeEClass, LogCategoriesType.class, "LogCategoriesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLogCategoriesType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, LogCategoriesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLogCategoriesType_Category(), this.getCategoryType(), null, "category", null, 1, -1, LogCategoriesType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(modelExchangeTypeEClass, ModelExchangeType.class, "ModelExchangeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelExchangeType_SourceFiles(), this.getSourceFilesType1(), null, "sourceFiles", null, 0, 1, ModelExchangeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelExchangeType_CanBeInstantiatedOnlyOncePerProcess(), theXMLTypePackage.getBoolean(), "canBeInstantiatedOnlyOncePerProcess", "false", 0, 1, ModelExchangeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelExchangeType_CanGetAndSetFMUstate(), theXMLTypePackage.getBoolean(), "canGetAndSetFMUstate", "false", 0, 1, ModelExchangeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelExchangeType_CanNotUseMemoryManagementFunctions(), theXMLTypePackage.getBoolean(), "canNotUseMemoryManagementFunctions", "false", 0, 1, ModelExchangeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelExchangeType_CanSerializeFMUstate(), theXMLTypePackage.getBoolean(), "canSerializeFMUstate", "false", 0, 1, ModelExchangeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelExchangeType_CompletedIntegratorStepNotNeeded(), theXMLTypePackage.getBoolean(), "completedIntegratorStepNotNeeded", "false", 0, 1, ModelExchangeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelExchangeType_ModelIdentifier(), theXMLTypePackage.getNormalizedString(), "modelIdentifier", null, 1, 1, ModelExchangeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelExchangeType_NeedsExecutionTool(), theXMLTypePackage.getBoolean(), "needsExecutionTool", "false", 0, 1, ModelExchangeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelExchangeType_ProvidesDirectionalDerivative(), theXMLTypePackage.getBoolean(), "providesDirectionalDerivative", "false", 0, 1, ModelExchangeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelStructureTypeEClass, ModelStructureType.class, "ModelStructureType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelStructureType_Outputs(), this.getFmi2VariableDependency(), null, "outputs", null, 0, 1, ModelStructureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelStructureType_Derivatives(), this.getFmi2VariableDependency(), null, "derivatives", null, 0, 1, ModelStructureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelStructureType_InitialUnknowns(), this.getInitialUnknownsType(), null, "initialUnknowns", null, 0, 1, ModelStructureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelVariablesTypeEClass, ModelVariablesType.class, "ModelVariablesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelVariablesType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, ModelVariablesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelVariablesType_ScalarVariable(), this.getFmi2ScalarVariable(), null, "scalarVariable", null, 1, -1, ModelVariablesType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(realTypeEClass, RealType.class, "RealType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRealType_DeclaredType(), theXMLTypePackage.getNormalizedString(), "declaredType", null, 0, 1, RealType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealType_Derivative(), theXMLTypePackage.getUnsignedInt(), "derivative", null, 0, 1, RealType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealType_DisplayUnit(), theXMLTypePackage.getNormalizedString(), "displayUnit", null, 0, 1, RealType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealType_Max(), theXMLTypePackage.getDouble(), "max", null, 0, 1, RealType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealType_Min(), theXMLTypePackage.getDouble(), "min", null, 0, 1, RealType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealType_Nominal(), theXMLTypePackage.getDouble(), "nominal", null, 0, 1, RealType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealType_Quantity(), theXMLTypePackage.getNormalizedString(), "quantity", null, 0, 1, RealType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealType_Reinit(), theXMLTypePackage.getBoolean(), "reinit", "false", 0, 1, RealType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealType_RelativeQuantity(), theXMLTypePackage.getBoolean(), "relativeQuantity", "false", 0, 1, RealType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealType_Start(), theXMLTypePackage.getDouble(), "start", null, 0, 1, RealType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealType_Unbounded(), theXMLTypePackage.getBoolean(), "unbounded", "false", 0, 1, RealType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealType_Unit(), theXMLTypePackage.getNormalizedString(), "unit", null, 0, 1, RealType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(realType1EClass, RealType1.class, "RealType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRealType1_DisplayUnit(), theXMLTypePackage.getNormalizedString(), "displayUnit", null, 0, 1, RealType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealType1_Max(), theXMLTypePackage.getDouble(), "max", null, 0, 1, RealType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealType1_Min(), theXMLTypePackage.getDouble(), "min", null, 0, 1, RealType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealType1_Nominal(), theXMLTypePackage.getDouble(), "nominal", null, 0, 1, RealType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealType1_Quantity(), theXMLTypePackage.getNormalizedString(), "quantity", null, 0, 1, RealType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealType1_RelativeQuantity(), theXMLTypePackage.getBoolean(), "relativeQuantity", "false", 0, 1, RealType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealType1_Unbounded(), theXMLTypePackage.getBoolean(), "unbounded", "false", 0, 1, RealType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealType1_Unit(), theXMLTypePackage.getNormalizedString(), "unit", null, 0, 1, RealType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceFilesTypeEClass, SourceFilesType.class, "SourceFilesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSourceFilesType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, SourceFilesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSourceFilesType_File(), this.getFileType(), null, "file", null, 1, -1, SourceFilesType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sourceFilesType1EClass, SourceFilesType1.class, "SourceFilesType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSourceFilesType1_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, SourceFilesType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSourceFilesType1_File(), this.getFileType1(), null, "file", null, 1, -1, SourceFilesType1.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(stringTypeEClass, StringType.class, "StringType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringType_DeclaredType(), theXMLTypePackage.getNormalizedString(), "declaredType", null, 0, 1, StringType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringType_Start(), theXMLTypePackage.getString(), "start", null, 0, 1, StringType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(toolTypeEClass, ToolType.class, "ToolType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getToolType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, 1, ToolType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getToolType_Name(), theXMLTypePackage.getNormalizedString(), "name", null, 1, 1, ToolType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeDefinitionsTypeEClass, TypeDefinitionsType.class, "TypeDefinitionsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeDefinitionsType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, TypeDefinitionsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeDefinitionsType_SimpleType(), this.getFmi2SimpleType(), null, "simpleType", null, 1, -1, TypeDefinitionsType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(unitDefinitionsTypeEClass, UnitDefinitionsType.class, "UnitDefinitionsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnitDefinitionsType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, UnitDefinitionsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnitDefinitionsType_Unit(), this.getFmi2Unit(), null, "unit", null, 1, -1, UnitDefinitionsType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(unknownTypeEClass, UnknownType.class, "UnknownType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnknownType_Dependencies(), this.getDependenciesType(), "dependencies", null, 0, 1, UnknownType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnknownType_DependenciesKind(), this.getDependenciesKindType(), "dependenciesKind", null, 0, 1, UnknownType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnknownType_Index(), theXMLTypePackage.getUnsignedInt(), "index", null, 1, 1, UnknownType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unknownType1EClass, UnknownType1.class, "UnknownType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnknownType1_Dependencies(), this.getDependenciesType1(), "dependencies", null, 0, 1, UnknownType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnknownType1_DependenciesKind(), this.getDependenciesKindType1(), "dependenciesKind", null, 0, 1, UnknownType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnknownType1_Index(), theXMLTypePackage.getUnsignedInt(), "index", null, 1, 1, UnknownType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(causalityTypeEEnum, CausalityType.class, "CausalityType");
		addEEnumLiteral(causalityTypeEEnum, CausalityType.PARAMETER);
		addEEnumLiteral(causalityTypeEEnum, CausalityType.CALCULATED_PARAMETER);
		addEEnumLiteral(causalityTypeEEnum, CausalityType.INPUT);
		addEEnumLiteral(causalityTypeEEnum, CausalityType.OUTPUT);
		addEEnumLiteral(causalityTypeEEnum, CausalityType.LOCAL);
		addEEnumLiteral(causalityTypeEEnum, CausalityType.INDEPENDENT);

		initEEnum(dependenciesKindTypeItemEEnum, DependenciesKindTypeItem.class, "DependenciesKindTypeItem");
		addEEnumLiteral(dependenciesKindTypeItemEEnum, DependenciesKindTypeItem.DEPENDENT);
		addEEnumLiteral(dependenciesKindTypeItemEEnum, DependenciesKindTypeItem.CONSTANT);
		addEEnumLiteral(dependenciesKindTypeItemEEnum, DependenciesKindTypeItem.FIXED);
		addEEnumLiteral(dependenciesKindTypeItemEEnum, DependenciesKindTypeItem.TUNABLE);
		addEEnumLiteral(dependenciesKindTypeItemEEnum, DependenciesKindTypeItem.DISCRETE);

		initEEnum(dependenciesKindTypeItem1EEnum, DependenciesKindTypeItem1.class, "DependenciesKindTypeItem1");
		addEEnumLiteral(dependenciesKindTypeItem1EEnum, DependenciesKindTypeItem1.DEPENDENT);
		addEEnumLiteral(dependenciesKindTypeItem1EEnum, DependenciesKindTypeItem1.CONSTANT);
		addEEnumLiteral(dependenciesKindTypeItem1EEnum, DependenciesKindTypeItem1.FIXED);
		addEEnumLiteral(dependenciesKindTypeItem1EEnum, DependenciesKindTypeItem1.TUNABLE);
		addEEnumLiteral(dependenciesKindTypeItem1EEnum, DependenciesKindTypeItem1.DISCRETE);

		initEEnum(initialTypeEEnum, InitialType.class, "InitialType");
		addEEnumLiteral(initialTypeEEnum, InitialType.EXACT);
		addEEnumLiteral(initialTypeEEnum, InitialType.APPROX);
		addEEnumLiteral(initialTypeEEnum, InitialType.CALCULATED);

		initEEnum(variabilityTypeEEnum, VariabilityType.class, "VariabilityType");
		addEEnumLiteral(variabilityTypeEEnum, VariabilityType.CONSTANT);
		addEEnumLiteral(variabilityTypeEEnum, VariabilityType.FIXED);
		addEEnumLiteral(variabilityTypeEEnum, VariabilityType.TUNABLE);
		addEEnumLiteral(variabilityTypeEEnum, VariabilityType.DISCRETE);
		addEEnumLiteral(variabilityTypeEEnum, VariabilityType.CONTINUOUS);

		initEEnum(variableNamingConventionTypeEEnum, VariableNamingConventionType.class, "VariableNamingConventionType");
		addEEnumLiteral(variableNamingConventionTypeEEnum, VariableNamingConventionType.FLAT);
		addEEnumLiteral(variableNamingConventionTypeEEnum, VariableNamingConventionType.STRUCTURED);

		// Initialize data types
		initEDataType(causalityTypeObjectEDataType, CausalityType.class, "CausalityTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(dependenciesKindTypeEDataType, List.class, "DependenciesKindType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(dependenciesKindType1EDataType, List.class, "DependenciesKindType1", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(dependenciesKindTypeItemObjectEDataType, DependenciesKindTypeItem.class, "DependenciesKindTypeItemObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(dependenciesKindTypeItemObject1EDataType, DependenciesKindTypeItem1.class, "DependenciesKindTypeItemObject1", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(dependenciesTypeEDataType, List.class, "DependenciesType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(dependenciesType1EDataType, List.class, "DependenciesType1", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(initialTypeObjectEDataType, InitialType.class, "InitialTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(variabilityTypeObjectEDataType, VariabilityType.class, "VariabilityTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(variableNamingConventionTypeObjectEDataType, VariableNamingConventionType.class, "VariableNamingConventionTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "qualified", "false"
		   });
		addAnnotation
		  (baseUnitTypeEClass,
		   source,
		   new String[] {
			   "name", "BaseUnit_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getBaseUnitType_A(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "A",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getBaseUnitType_Cd(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "cd",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getBaseUnitType_Factor(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "factor",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getBaseUnitType_K(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "K",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getBaseUnitType_Kg(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "kg",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getBaseUnitType_M(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "m",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getBaseUnitType_Mol(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "mol",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getBaseUnitType_Offset(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "offset",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getBaseUnitType_Rad(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "rad",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getBaseUnitType_S(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "s",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (booleanTypeEClass,
		   source,
		   new String[] {
			   "name", "Boolean_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getBooleanType_DeclaredType(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "declaredType",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getBooleanType_Start(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "start",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (categoryTypeEClass,
		   source,
		   new String[] {
			   "name", "Category_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getCategoryType_Description(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "description",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCategoryType_Name(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "name",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (causalityTypeEEnum,
		   source,
		   new String[] {
			   "name", "causality_._type"
		   });
		addAnnotation
		  (causalityTypeObjectEDataType,
		   source,
		   new String[] {
			   "name", "causality_._type:Object",
			   "baseType", "causality_._type"
		   });
		addAnnotation
		  (coSimulationTypeEClass,
		   source,
		   new String[] {
			   "name", "CoSimulation_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getCoSimulationType_SourceFiles(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "SourceFiles",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoSimulationType_CanBeInstantiatedOnlyOncePerProcess(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "canBeInstantiatedOnlyOncePerProcess",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoSimulationType_CanGetAndSetFMUstate(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "canGetAndSetFMUstate",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoSimulationType_CanHandleVariableCommunicationStepSize(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "canHandleVariableCommunicationStepSize",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoSimulationType_CanInterpolateInputs(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "canInterpolateInputs",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoSimulationType_CanNotUseMemoryManagementFunctions(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "canNotUseMemoryManagementFunctions",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoSimulationType_CanRunAsynchronuously(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "canRunAsynchronuously",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoSimulationType_CanSerializeFMUstate(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "canSerializeFMUstate",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoSimulationType_MaxOutputDerivativeOrder(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "maxOutputDerivativeOrder",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoSimulationType_ModelIdentifier(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "modelIdentifier",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoSimulationType_NeedsExecutionTool(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "needsExecutionTool",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoSimulationType_ProvidesDirectionalDerivative(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "providesDirectionalDerivative",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (defaultExperimentTypeEClass,
		   source,
		   new String[] {
			   "name", "DefaultExperiment_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getDefaultExperimentType_StartTime(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "startTime",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDefaultExperimentType_StepSize(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "stepSize",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDefaultExperimentType_StopTime(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "stopTime",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDefaultExperimentType_Tolerance(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "tolerance",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (dependenciesKindTypeEDataType,
		   source,
		   new String[] {
			   "name", "dependenciesKind_._type",
			   "itemType", "dependenciesKind_._type_._item"
		   });
		addAnnotation
		  (dependenciesKindType1EDataType,
		   source,
		   new String[] {
			   "name", "dependenciesKind_._1_._type",
			   "itemType", "dependenciesKind_._1_._type_._item"
		   });
		addAnnotation
		  (dependenciesKindTypeItemEEnum,
		   source,
		   new String[] {
			   "name", "dependenciesKind_._type_._item"
		   });
		addAnnotation
		  (dependenciesKindTypeItem1EEnum,
		   source,
		   new String[] {
			   "name", "dependenciesKind_._1_._type_._item"
		   });
		addAnnotation
		  (dependenciesKindTypeItemObjectEDataType,
		   source,
		   new String[] {
			   "name", "dependenciesKind_._type_._item:Object",
			   "baseType", "dependenciesKind_._type_._item"
		   });
		addAnnotation
		  (dependenciesKindTypeItemObject1EDataType,
		   source,
		   new String[] {
			   "name", "dependenciesKind_._1_._type_._item:Object",
			   "baseType", "dependenciesKind_._1_._type_._item"
		   });
		addAnnotation
		  (dependenciesTypeEDataType,
		   source,
		   new String[] {
			   "name", "dependencies_._type",
			   "itemType", "http://www.eclipse.org/emf/2003/XMLType#unsignedInt"
		   });
		addAnnotation
		  (dependenciesType1EDataType,
		   source,
		   new String[] {
			   "name", "dependencies_._1_._type",
			   "itemType", "http://www.eclipse.org/emf/2003/XMLType#unsignedInt"
		   });
		addAnnotation
		  (displayUnitTypeEClass,
		   source,
		   new String[] {
			   "name", "DisplayUnit_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getDisplayUnitType_Factor(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "factor",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDisplayUnitType_Name(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "name",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDisplayUnitType_Offset(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "offset",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (documentRootEClass,
		   source,
		   new String[] {
			   "name", "",
			   "kind", "mixed"
		   });
		addAnnotation
		  (getDocumentRoot_Mixed(),
		   source,
		   new String[] {
			   "kind", "elementWildcard",
			   "name", ":mixed"
		   });
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "xmlns:prefix"
		   });
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "xsi:schemaLocation"
		   });
		addAnnotation
		  (getDocumentRoot_FmiModelDescription(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "fmiModelDescription",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (enumerationTypeEClass,
		   source,
		   new String[] {
			   "name", "Enumeration_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getEnumerationType_DeclaredType(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "declaredType",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getEnumerationType_Max(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "max",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getEnumerationType_Min(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "min",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getEnumerationType_Quantity(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "quantity",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getEnumerationType_Start(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "start",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (enumerationType1EClass,
		   source,
		   new String[] {
			   "name", "Enumeration_._1_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getEnumerationType1_Group(),
		   source,
		   new String[] {
			   "kind", "group",
			   "name", "group:0"
		   });
		addAnnotation
		  (getEnumerationType1_Item(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Item",
			   "namespace", "##targetNamespace",
			   "group", "group:0"
		   });
		addAnnotation
		  (getEnumerationType1_Quantity(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "quantity",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (fileTypeEClass,
		   source,
		   new String[] {
			   "name", "File_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getFileType_Name(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "name",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (fileType1EClass,
		   source,
		   new String[] {
			   "name", "File_._1_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getFileType1_Name(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "name",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (fmi2AnnotationEClass,
		   source,
		   new String[] {
			   "name", "fmi2Annotation",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getFmi2Annotation_Group(),
		   source,
		   new String[] {
			   "kind", "group",
			   "name", "group:0"
		   });
		addAnnotation
		  (getFmi2Annotation_Tool(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Tool",
			   "namespace", "##targetNamespace",
			   "group", "group:0"
		   });
		addAnnotation
		  (fmi2ScalarVariableEClass,
		   source,
		   new String[] {
			   "name", "fmi2ScalarVariable",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getFmi2ScalarVariable_Real(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Real",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2ScalarVariable_Integer(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Integer",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2ScalarVariable_Boolean(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Boolean",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2ScalarVariable_String(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "String",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2ScalarVariable_Enumeration(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Enumeration",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2ScalarVariable_Annotations(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Annotations",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2ScalarVariable_CanHandleMultipleSetPerTimeInstant(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "canHandleMultipleSetPerTimeInstant",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2ScalarVariable_Causality(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "causality",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2ScalarVariable_Description(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "description",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2ScalarVariable_Initial(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "initial",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2ScalarVariable_Name(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "name",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2ScalarVariable_ValueReference(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "valueReference",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2ScalarVariable_Variability(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "variability",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (fmi2SimpleTypeEClass,
		   source,
		   new String[] {
			   "name", "fmi2SimpleType",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getFmi2SimpleType_Real(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Real",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2SimpleType_Integer(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Integer",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2SimpleType_Boolean(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Boolean",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2SimpleType_String(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "String",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2SimpleType_Enumeration(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Enumeration",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2SimpleType_Description(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "description",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2SimpleType_Name(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "name",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (fmi2UnitEClass,
		   source,
		   new String[] {
			   "name", "fmi2Unit",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getFmi2Unit_BaseUnit(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "BaseUnit",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmi2Unit_Group(),
		   source,
		   new String[] {
			   "kind", "group",
			   "name", "group:1"
		   });
		addAnnotation
		  (getFmi2Unit_DisplayUnit(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "DisplayUnit",
			   "namespace", "##targetNamespace",
			   "group", "group:1"
		   });
		addAnnotation
		  (getFmi2Unit_Name(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "name",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (fmi2VariableDependencyEClass,
		   source,
		   new String[] {
			   "name", "fmi2VariableDependency",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getFmi2VariableDependency_Group(),
		   source,
		   new String[] {
			   "kind", "group",
			   "name", "group:0"
		   });
		addAnnotation
		  (getFmi2VariableDependency_Unknown(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Unknown",
			   "namespace", "##targetNamespace",
			   "group", "group:0"
		   });
		addAnnotation
		  (fmiModelDescriptionTypeEClass,
		   source,
		   new String[] {
			   "name", "fmiModelDescription_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_Group(),
		   source,
		   new String[] {
			   "kind", "group",
			   "name", "group:0"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_ModelExchange(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "ModelExchange",
			   "namespace", "##targetNamespace",
			   "group", "group:0"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_CoSimulation(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "CoSimulation",
			   "namespace", "##targetNamespace",
			   "group", "group:0"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_UnitDefinitions(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "UnitDefinitions",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_TypeDefinitions(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "TypeDefinitions",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_LogCategories(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "LogCategories",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_DefaultExperiment(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "DefaultExperiment",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_VendorAnnotations(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "VendorAnnotations",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_ModelVariables(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "ModelVariables",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_ModelStructure(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "ModelStructure",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_Author(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "author",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_Copyright(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "copyright",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_Description(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "description",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_FmiVersion(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "fmiVersion",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_GenerationDateAndTime(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "generationDateAndTime",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_GenerationTool(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "generationTool",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_Guid(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "guid",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_License(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "license",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_ModelName(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "modelName",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_NumberOfEventIndicators(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "numberOfEventIndicators",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_VariableNamingConvention(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "variableNamingConvention",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFmiModelDescriptionType_Version(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "version",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (initialTypeEEnum,
		   source,
		   new String[] {
			   "name", "initial_._type"
		   });
		addAnnotation
		  (initialTypeObjectEDataType,
		   source,
		   new String[] {
			   "name", "initial_._type:Object",
			   "baseType", "initial_._type"
		   });
		addAnnotation
		  (initialUnknownsTypeEClass,
		   source,
		   new String[] {
			   "name", "InitialUnknowns_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getInitialUnknownsType_Group(),
		   source,
		   new String[] {
			   "kind", "group",
			   "name", "group:0"
		   });
		addAnnotation
		  (getInitialUnknownsType_Unknown(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Unknown",
			   "namespace", "##targetNamespace",
			   "group", "group:0"
		   });
		addAnnotation
		  (integerTypeEClass,
		   source,
		   new String[] {
			   "name", "Integer_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getIntegerType_DeclaredType(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "declaredType",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getIntegerType_Max(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "max",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getIntegerType_Min(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "min",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getIntegerType_Quantity(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "quantity",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getIntegerType_Start(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "start",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (integerType1EClass,
		   source,
		   new String[] {
			   "name", "Integer_._1_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getIntegerType1_Max(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "max",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getIntegerType1_Min(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "min",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getIntegerType1_Quantity(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "quantity",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (itemTypeEClass,
		   source,
		   new String[] {
			   "name", "Item_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getItemType_Description(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "description",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getItemType_Name(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "name",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getItemType_Value(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "value",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (logCategoriesTypeEClass,
		   source,
		   new String[] {
			   "name", "LogCategories_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getLogCategoriesType_Group(),
		   source,
		   new String[] {
			   "kind", "group",
			   "name", "group:0"
		   });
		addAnnotation
		  (getLogCategoriesType_Category(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Category",
			   "namespace", "##targetNamespace",
			   "group", "group:0"
		   });
		addAnnotation
		  (modelExchangeTypeEClass,
		   source,
		   new String[] {
			   "name", "ModelExchange_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getModelExchangeType_SourceFiles(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "SourceFiles",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getModelExchangeType_CanBeInstantiatedOnlyOncePerProcess(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "canBeInstantiatedOnlyOncePerProcess",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getModelExchangeType_CanGetAndSetFMUstate(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "canGetAndSetFMUstate",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getModelExchangeType_CanNotUseMemoryManagementFunctions(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "canNotUseMemoryManagementFunctions",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getModelExchangeType_CanSerializeFMUstate(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "canSerializeFMUstate",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getModelExchangeType_CompletedIntegratorStepNotNeeded(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "completedIntegratorStepNotNeeded",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getModelExchangeType_ModelIdentifier(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "modelIdentifier",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getModelExchangeType_NeedsExecutionTool(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "needsExecutionTool",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getModelExchangeType_ProvidesDirectionalDerivative(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "providesDirectionalDerivative",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (modelStructureTypeEClass,
		   source,
		   new String[] {
			   "name", "ModelStructure_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getModelStructureType_Outputs(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Outputs",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getModelStructureType_Derivatives(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Derivatives",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getModelStructureType_InitialUnknowns(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "InitialUnknowns",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (modelVariablesTypeEClass,
		   source,
		   new String[] {
			   "name", "ModelVariables_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getModelVariablesType_Group(),
		   source,
		   new String[] {
			   "kind", "group",
			   "name", "group:0"
		   });
		addAnnotation
		  (getModelVariablesType_ScalarVariable(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "ScalarVariable",
			   "namespace", "##targetNamespace",
			   "group", "group:0"
		   });
		addAnnotation
		  (realTypeEClass,
		   source,
		   new String[] {
			   "name", "Real_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getRealType_DeclaredType(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "declaredType",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getRealType_Derivative(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "derivative",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getRealType_DisplayUnit(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "displayUnit",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getRealType_Max(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "max",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getRealType_Min(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "min",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getRealType_Nominal(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "nominal",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getRealType_Quantity(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "quantity",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getRealType_Reinit(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "reinit",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getRealType_RelativeQuantity(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "relativeQuantity",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getRealType_Start(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "start",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getRealType_Unbounded(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "unbounded",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getRealType_Unit(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "unit",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (realType1EClass,
		   source,
		   new String[] {
			   "name", "Real_._1_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getRealType1_DisplayUnit(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "displayUnit",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getRealType1_Max(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "max",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getRealType1_Min(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "min",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getRealType1_Nominal(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "nominal",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getRealType1_Quantity(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "quantity",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getRealType1_RelativeQuantity(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "relativeQuantity",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getRealType1_Unbounded(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "unbounded",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getRealType1_Unit(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "unit",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (sourceFilesTypeEClass,
		   source,
		   new String[] {
			   "name", "SourceFiles_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getSourceFilesType_Group(),
		   source,
		   new String[] {
			   "kind", "group",
			   "name", "group:0"
		   });
		addAnnotation
		  (getSourceFilesType_File(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "File",
			   "namespace", "##targetNamespace",
			   "group", "group:0"
		   });
		addAnnotation
		  (sourceFilesType1EClass,
		   source,
		   new String[] {
			   "name", "SourceFiles_._1_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getSourceFilesType1_Group(),
		   source,
		   new String[] {
			   "kind", "group",
			   "name", "group:0"
		   });
		addAnnotation
		  (getSourceFilesType1_File(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "File",
			   "namespace", "##targetNamespace",
			   "group", "group:0"
		   });
		addAnnotation
		  (stringTypeEClass,
		   source,
		   new String[] {
			   "name", "String_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getStringType_DeclaredType(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "declaredType",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getStringType_Start(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "start",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (toolTypeEClass,
		   source,
		   new String[] {
			   "name", "Tool_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getToolType_Any(),
		   source,
		   new String[] {
			   "kind", "elementWildcard",
			   "wildcards", "##any",
			   "name", ":0",
			   "processing", "lax"
		   });
		addAnnotation
		  (getToolType_Name(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "name",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (typeDefinitionsTypeEClass,
		   source,
		   new String[] {
			   "name", "TypeDefinitions_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getTypeDefinitionsType_Group(),
		   source,
		   new String[] {
			   "kind", "group",
			   "name", "group:0"
		   });
		addAnnotation
		  (getTypeDefinitionsType_SimpleType(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "SimpleType",
			   "namespace", "##targetNamespace",
			   "group", "group:0"
		   });
		addAnnotation
		  (unitDefinitionsTypeEClass,
		   source,
		   new String[] {
			   "name", "UnitDefinitions_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getUnitDefinitionsType_Group(),
		   source,
		   new String[] {
			   "kind", "group",
			   "name", "group:0"
		   });
		addAnnotation
		  (getUnitDefinitionsType_Unit(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Unit",
			   "namespace", "##targetNamespace",
			   "group", "group:0"
		   });
		addAnnotation
		  (unknownTypeEClass,
		   source,
		   new String[] {
			   "name", "Unknown_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getUnknownType_Dependencies(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "dependencies",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getUnknownType_DependenciesKind(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "dependenciesKind",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getUnknownType_Index(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "index",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (unknownType1EClass,
		   source,
		   new String[] {
			   "name", "Unknown_._1_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getUnknownType1_Dependencies(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "dependencies",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getUnknownType1_DependenciesKind(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "dependenciesKind",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getUnknownType1_Index(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "index",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (variabilityTypeEEnum,
		   source,
		   new String[] {
			   "name", "variability_._type"
		   });
		addAnnotation
		  (variabilityTypeObjectEDataType,
		   source,
		   new String[] {
			   "name", "variability_._type:Object",
			   "baseType", "variability_._type"
		   });
		addAnnotation
		  (variableNamingConventionTypeEEnum,
		   source,
		   new String[] {
			   "name", "variableNamingConvention_._type"
		   });
		addAnnotation
		  (variableNamingConventionTypeObjectEDataType,
		   source,
		   new String[] {
			   "name", "variableNamingConvention_._type:Object",
			   "baseType", "variableNamingConvention_._type"
		   });
	}

} //FmiPackageImpl
