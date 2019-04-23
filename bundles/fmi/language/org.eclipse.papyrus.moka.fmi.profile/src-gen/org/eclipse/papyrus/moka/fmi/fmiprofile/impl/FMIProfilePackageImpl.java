/**
 * Copyright (c) 2016 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *   CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.fmi.fmiprofile.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.moka.fmi.fmiprofile.AbstractVariable;
import org.eclipse.papyrus.moka.fmi.fmiprofile.BaseUnit;
import org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph;
import org.eclipse.papyrus.moka.fmi.fmiprofile.CalculatedParameter;
import org.eclipse.papyrus.moka.fmi.fmiprofile.CausalityKind;
import org.eclipse.papyrus.moka.fmi.fmiprofile.DependenciesKind;
import org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeDependency;
import org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeUnknown;
import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIPort;
import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfileFactory;
import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage;
import org.eclipse.papyrus.moka.fmi.fmiprofile.Independent;
import org.eclipse.papyrus.moka.fmi.fmiprofile.InitialKind;
import org.eclipse.papyrus.moka.fmi.fmiprofile.InitialUnknown;
import org.eclipse.papyrus.moka.fmi.fmiprofile.InitialUnknownDependency;
import org.eclipse.papyrus.moka.fmi.fmiprofile.Local;
import org.eclipse.papyrus.moka.fmi.fmiprofile.OutputDependency;
import org.eclipse.papyrus.moka.fmi.fmiprofile.OutputUnknown;
import org.eclipse.papyrus.moka.fmi.fmiprofile.Parameter;
import org.eclipse.papyrus.moka.fmi.fmiprofile.Port;
import org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable;
import org.eclipse.papyrus.moka.fmi.fmiprofile.Unknown;
import org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityKind;
import org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityNamingConvention;

import org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage;

import org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage;

import org.eclipse.papyrus.sysml14.deprecatedelements.DeprecatedelementsPackage;

import org.eclipse.papyrus.sysml14.sysmlPackage;

import org.eclipse.uml2.types.TypesPackage;

import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.uml2.uml.profile.standard.StandardPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FMIProfilePackageImpl extends EPackageImpl implements FMIProfilePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fmuEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cS_FMUEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mE_FMUEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fmiPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass independentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unknownEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputUnknownEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initialUnknownEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derivativeUnknownEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cS_GraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derivativeDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initialUnknownDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass calculatedParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum variabilityKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum initialKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum causalityKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dependenciesKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum variabilityNamingConventionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum baseUnitEEnum = null;

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
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FMIProfilePackageImpl() {
		super(eNS_URI, FMIProfileFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FMIProfilePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FMIProfilePackage init() {
		if (isInited) return (FMIProfilePackage)EPackage.Registry.INSTANCE.getEPackage(FMIProfilePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredFMIProfilePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		FMIProfilePackageImpl theFMIProfilePackage = registeredFMIProfilePackage instanceof FMIProfilePackageImpl ? (FMIProfilePackageImpl)registeredFMIProfilePackage : new FMIProfilePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		FmiPackage.eINSTANCE.eClass();
		FmumetamodelPackage.eINSTANCE.eClass();
		StandardPackage.eINSTANCE.eClass();
		sysmlPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theFMIProfilePackage.createPackageContents();

		// Initialize created meta-data
		theFMIProfilePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFMIProfilePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FMIProfilePackage.eNS_URI, theFMIProfilePackage);
		return theFMIProfilePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFMU() {
		return fmuEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_FmiVersion() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_ModelName() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_Guid() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_Description() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_Author() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_Version() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_Copyright() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_License() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_GenerationTool() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_GenerationDateAndTime() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_VariableNamingConvention() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_NumberOfEventIndicators() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMU_Base_Class() {
		return (EReference)fmuEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_SourceFiles() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_CanBeInstantiatedOnlyOncePerProcess() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_CanGetAndSetFMUstate() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_CanNotUseMemoryManagementFunctions() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_CanSerializeFMUstate() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_ProvidesDirectionalDerivative() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_NeedsExecutionTool() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMU_ModelIdentifier() {
		return (EAttribute)fmuEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMU_ModelDescription() {
		return (EReference)fmuEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMU_FmuBundle() {
		return (EReference)fmuEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractVariable() {
		return abstractVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractVariable_Base_Property() {
		return (EReference)abstractVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScalarVariable() {
		return scalarVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScalarVariable_Description() {
		return (EAttribute)scalarVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScalarVariable_Variability() {
		return (EAttribute)scalarVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScalarVariable_Initial() {
		return (EAttribute)scalarVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScalarVariable_ValueReference() {
		return (EAttribute)scalarVariableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScalarVariable_FmiVariable() {
		return (EReference)scalarVariableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScalarVariable_CausalityKind() {
		return (EAttribute)scalarVariableEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocal() {
		return localEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCS_FMU() {
		return cS_FMUEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCS_FMU_CanHandleVariableCommunicationStepSize() {
		return (EAttribute)cS_FMUEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCS_FMU_CanInterpolateInputs() {
		return (EAttribute)cS_FMUEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCS_FMU_CanRunAsynchronuously() {
		return (EAttribute)cS_FMUEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCS_FMU_MaxOutputDerivativeOrder() {
		return (EAttribute)cS_FMUEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCS_FMU_StartTime() {
		return (EAttribute)cS_FMUEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCS_FMU_StopTime() {
		return (EAttribute)cS_FMUEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCS_FMU_StepSize() {
		return (EAttribute)cS_FMUEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCS_FMU_Tolerance() {
		return (EAttribute)cS_FMUEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getME_FMU() {
		return mE_FMUEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getME_FMU_CompletedIntegratorStepNotNeeded() {
		return (EAttribute)mE_FMUEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFMIPort() {
		return fmiPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndependent() {
		return independentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnknown() {
		return unknownEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnknown_Base_Property() {
		return (EReference)unknownEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnknown_Dependencies() {
		return (EAttribute)unknownEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnknown_DependenciesKind() {
		return (EAttribute)unknownEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputUnknown() {
		return outputUnknownEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInitialUnknown() {
		return initialUnknownEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerivativeUnknown() {
		return derivativeUnknownEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCS_Graph() {
		return cS_GraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCS_Graph_StartTime() {
		return (EAttribute)cS_GraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCS_Graph_StopTime() {
		return (EAttribute)cS_GraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCS_Graph_StepSize() {
		return (EAttribute)cS_GraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCS_Graph_Tolerance() {
		return (EAttribute)cS_GraphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCS_Graph_ToleranceDefined() {
		return (EAttribute)cS_GraphEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCS_Graph_StopTimeDefined() {
		return (EAttribute)cS_GraphEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCS_Graph_ComputeSetupExperimentsFromFmus() {
		return (EAttribute)cS_GraphEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCS_Graph_Base_Class() {
		return (EReference)cS_GraphEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerivativeDependency() {
		return derivativeDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDerivativeDependency_Base_Dependency() {
		return (EReference)derivativeDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDerivativeDependency_DependencyKind() {
		return (EAttribute)derivativeDependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputDependency() {
		return outputDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputDependency_Base_Dependency() {
		return (EReference)outputDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInitialUnknownDependency() {
		return initialUnknownDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInitialUnknownDependency_Base_Dependency() {
		return (EReference)initialUnknownDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCalculatedParameter() {
		return calculatedParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPort() {
		return portEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVariabilityKind() {
		return variabilityKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInitialKind() {
		return initialKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCausalityKind() {
		return causalityKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDependenciesKind() {
		return dependenciesKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVariabilityNamingConvention() {
		return variabilityNamingConventionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBaseUnit() {
		return baseUnitEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FMIProfileFactory getFMIProfileFactory() {
		return (FMIProfileFactory)getEFactoryInstance();
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
		fmuEClass = createEClass(FMU);
		createEAttribute(fmuEClass, FMU__FMI_VERSION);
		createEAttribute(fmuEClass, FMU__MODEL_NAME);
		createEAttribute(fmuEClass, FMU__GUID);
		createEAttribute(fmuEClass, FMU__DESCRIPTION);
		createEAttribute(fmuEClass, FMU__AUTHOR);
		createEAttribute(fmuEClass, FMU__VERSION);
		createEAttribute(fmuEClass, FMU__COPYRIGHT);
		createEAttribute(fmuEClass, FMU__LICENSE);
		createEAttribute(fmuEClass, FMU__GENERATION_TOOL);
		createEAttribute(fmuEClass, FMU__GENERATION_DATE_AND_TIME);
		createEAttribute(fmuEClass, FMU__VARIABLE_NAMING_CONVENTION);
		createEAttribute(fmuEClass, FMU__NUMBER_OF_EVENT_INDICATORS);
		createEReference(fmuEClass, FMU__BASE_CLASS);
		createEAttribute(fmuEClass, FMU__SOURCE_FILES);
		createEAttribute(fmuEClass, FMU__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS);
		createEAttribute(fmuEClass, FMU__CAN_GET_AND_SET_FM_USTATE);
		createEAttribute(fmuEClass, FMU__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS);
		createEAttribute(fmuEClass, FMU__CAN_SERIALIZE_FM_USTATE);
		createEAttribute(fmuEClass, FMU__PROVIDES_DIRECTIONAL_DERIVATIVE);
		createEAttribute(fmuEClass, FMU__NEEDS_EXECUTION_TOOL);
		createEAttribute(fmuEClass, FMU__MODEL_IDENTIFIER);
		createEReference(fmuEClass, FMU__MODEL_DESCRIPTION);
		createEReference(fmuEClass, FMU__FMU_BUNDLE);

		parameterEClass = createEClass(PARAMETER);

		abstractVariableEClass = createEClass(ABSTRACT_VARIABLE);
		createEReference(abstractVariableEClass, ABSTRACT_VARIABLE__BASE_PROPERTY);

		scalarVariableEClass = createEClass(SCALAR_VARIABLE);
		createEAttribute(scalarVariableEClass, SCALAR_VARIABLE__DESCRIPTION);
		createEAttribute(scalarVariableEClass, SCALAR_VARIABLE__VARIABILITY);
		createEAttribute(scalarVariableEClass, SCALAR_VARIABLE__INITIAL);
		createEAttribute(scalarVariableEClass, SCALAR_VARIABLE__VALUE_REFERENCE);
		createEReference(scalarVariableEClass, SCALAR_VARIABLE__FMI_VARIABLE);
		createEAttribute(scalarVariableEClass, SCALAR_VARIABLE__CAUSALITY_KIND);

		localEClass = createEClass(LOCAL);

		cS_FMUEClass = createEClass(CS_FMU);
		createEAttribute(cS_FMUEClass, CS_FMU__CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE);
		createEAttribute(cS_FMUEClass, CS_FMU__CAN_INTERPOLATE_INPUTS);
		createEAttribute(cS_FMUEClass, CS_FMU__CAN_RUN_ASYNCHRONUOUSLY);
		createEAttribute(cS_FMUEClass, CS_FMU__MAX_OUTPUT_DERIVATIVE_ORDER);
		createEAttribute(cS_FMUEClass, CS_FMU__START_TIME);
		createEAttribute(cS_FMUEClass, CS_FMU__STOP_TIME);
		createEAttribute(cS_FMUEClass, CS_FMU__STEP_SIZE);
		createEAttribute(cS_FMUEClass, CS_FMU__TOLERANCE);

		mE_FMUEClass = createEClass(ME_FMU);
		createEAttribute(mE_FMUEClass, ME_FMU__COMPLETED_INTEGRATOR_STEP_NOT_NEEDED);

		fmiPortEClass = createEClass(FMI_PORT);

		independentEClass = createEClass(INDEPENDENT);

		unknownEClass = createEClass(UNKNOWN);
		createEReference(unknownEClass, UNKNOWN__BASE_PROPERTY);
		createEAttribute(unknownEClass, UNKNOWN__DEPENDENCIES);
		createEAttribute(unknownEClass, UNKNOWN__DEPENDENCIES_KIND);

		outputUnknownEClass = createEClass(OUTPUT_UNKNOWN);

		initialUnknownEClass = createEClass(INITIAL_UNKNOWN);

		derivativeUnknownEClass = createEClass(DERIVATIVE_UNKNOWN);

		cS_GraphEClass = createEClass(CS_GRAPH);
		createEAttribute(cS_GraphEClass, CS_GRAPH__START_TIME);
		createEAttribute(cS_GraphEClass, CS_GRAPH__STOP_TIME);
		createEAttribute(cS_GraphEClass, CS_GRAPH__STEP_SIZE);
		createEAttribute(cS_GraphEClass, CS_GRAPH__TOLERANCE);
		createEAttribute(cS_GraphEClass, CS_GRAPH__TOLERANCE_DEFINED);
		createEAttribute(cS_GraphEClass, CS_GRAPH__STOP_TIME_DEFINED);
		createEAttribute(cS_GraphEClass, CS_GRAPH__COMPUTE_SETUP_EXPERIMENTS_FROM_FMUS);
		createEReference(cS_GraphEClass, CS_GRAPH__BASE_CLASS);

		derivativeDependencyEClass = createEClass(DERIVATIVE_DEPENDENCY);
		createEReference(derivativeDependencyEClass, DERIVATIVE_DEPENDENCY__BASE_DEPENDENCY);
		createEAttribute(derivativeDependencyEClass, DERIVATIVE_DEPENDENCY__DEPENDENCY_KIND);

		outputDependencyEClass = createEClass(OUTPUT_DEPENDENCY);
		createEReference(outputDependencyEClass, OUTPUT_DEPENDENCY__BASE_DEPENDENCY);

		initialUnknownDependencyEClass = createEClass(INITIAL_UNKNOWN_DEPENDENCY);
		createEReference(initialUnknownDependencyEClass, INITIAL_UNKNOWN_DEPENDENCY__BASE_DEPENDENCY);

		calculatedParameterEClass = createEClass(CALCULATED_PARAMETER);

		portEClass = createEClass(PORT);

		// Create enums
		variabilityKindEEnum = createEEnum(VARIABILITY_KIND);
		initialKindEEnum = createEEnum(INITIAL_KIND);
		causalityKindEEnum = createEEnum(CAUSALITY_KIND);
		dependenciesKindEEnum = createEEnum(DEPENDENCIES_KIND);
		variabilityNamingConventionEEnum = createEEnum(VARIABILITY_NAMING_CONVENTION);
		baseUnitEEnum = createEEnum(BASE_UNIT);
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
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		FmiPackage theFmiPackage = (FmiPackage)EPackage.Registry.INSTANCE.getEPackage(FmiPackage.eNS_URI);
		FmumetamodelPackage theFmumetamodelPackage = (FmumetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(FmumetamodelPackage.eNS_URI);
		DeprecatedelementsPackage theDeprecatedelementsPackage = (DeprecatedelementsPackage)EPackage.Registry.INSTANCE.getEPackage(DeprecatedelementsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		parameterEClass.getESuperTypes().add(this.getAbstractVariable());
		abstractVariableEClass.getESuperTypes().add(this.getScalarVariable());
		localEClass.getESuperTypes().add(this.getAbstractVariable());
		cS_FMUEClass.getESuperTypes().add(this.getFMU());
		mE_FMUEClass.getESuperTypes().add(this.getFMU());
		fmiPortEClass.getESuperTypes().add(this.getScalarVariable());
		fmiPortEClass.getESuperTypes().add(theDeprecatedelementsPackage.getFlowPort());
		independentEClass.getESuperTypes().add(this.getAbstractVariable());
		outputUnknownEClass.getESuperTypes().add(this.getUnknown());
		initialUnknownEClass.getESuperTypes().add(this.getUnknown());
		derivativeUnknownEClass.getESuperTypes().add(this.getUnknown());
		calculatedParameterEClass.getESuperTypes().add(this.getAbstractVariable());
		portEClass.getESuperTypes().add(this.getFMIPort());

		// Initialize classes, features, and operations; add parameters
		initEClass(fmuEClass, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, "FMU", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFMU_FmiVersion(), theTypesPackage.getString(), "fmiVersion", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_ModelName(), theTypesPackage.getString(), "modelName", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_Guid(), theTypesPackage.getString(), "guid", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_Description(), theTypesPackage.getString(), "description", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_Author(), theTypesPackage.getString(), "author", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_Version(), theTypesPackage.getString(), "version", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_Copyright(), theTypesPackage.getString(), "copyright", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_License(), theTypesPackage.getString(), "license", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_GenerationTool(), theTypesPackage.getString(), "generationTool", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_GenerationDateAndTime(), theTypesPackage.getString(), "generationDateAndTime", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_VariableNamingConvention(), theTypesPackage.getString(), "variableNamingConvention", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_NumberOfEventIndicators(), theTypesPackage.getInteger(), "numberOfEventIndicators", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFMU_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_SourceFiles(), theTypesPackage.getString(), "sourceFiles", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_CanBeInstantiatedOnlyOncePerProcess(), theTypesPackage.getBoolean(), "canBeInstantiatedOnlyOncePerProcess", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_CanGetAndSetFMUstate(), theTypesPackage.getBoolean(), "canGetAndSetFMUstate", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_CanNotUseMemoryManagementFunctions(), theTypesPackage.getBoolean(), "canNotUseMemoryManagementFunctions", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_CanSerializeFMUstate(), theTypesPackage.getBoolean(), "canSerializeFMUstate", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_ProvidesDirectionalDerivative(), theTypesPackage.getBoolean(), "providesDirectionalDerivative", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_NeedsExecutionTool(), theTypesPackage.getBoolean(), "needsExecutionTool", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFMU_ModelIdentifier(), theTypesPackage.getString(), "modelIdentifier", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFMU_ModelDescription(), theFmiPackage.getFmiModelDescriptionType(), null, "modelDescription", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getFMU_FmuBundle(), theFmumetamodelPackage.getFMUBundle(), null, "fmuBundle", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractVariableEClass, AbstractVariable.class, "AbstractVariable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractVariable_Base_Property(), theUMLPackage.getProperty(), null, "base_Property", null, 1, 1, AbstractVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(scalarVariableEClass, ScalarVariable.class, "ScalarVariable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScalarVariable_Description(), theTypesPackage.getString(), "description", null, 1, 1, ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getScalarVariable_Variability(), this.getVariabilityKind(), "variability", null, 1, 1, ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getScalarVariable_Initial(), this.getInitialKind(), "initial", null, 1, 1, ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getScalarVariable_ValueReference(), ecorePackage.getELong(), "valueReference", "-1", 1, 1, ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getScalarVariable_FmiVariable(), theFmiPackage.getFmi2ScalarVariable(), null, "fmiVariable", null, 1, 1, ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getScalarVariable_CausalityKind(), this.getCausalityKind(), "causalityKind", null, 1, 1, ScalarVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(localEClass, Local.class, "Local", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cS_FMUEClass, org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU.class, "CS_FMU", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCS_FMU_CanHandleVariableCommunicationStepSize(), theTypesPackage.getBoolean(), "canHandleVariableCommunicationStepSize", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCS_FMU_CanInterpolateInputs(), theTypesPackage.getBoolean(), "canInterpolateInputs", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCS_FMU_CanRunAsynchronuously(), theTypesPackage.getBoolean(), "canRunAsynchronuously", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCS_FMU_MaxOutputDerivativeOrder(), theTypesPackage.getInteger(), "maxOutputDerivativeOrder", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCS_FMU_StartTime(), theTypesPackage.getReal(), "startTime", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCS_FMU_StopTime(), theTypesPackage.getReal(), "stopTime", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCS_FMU_StepSize(), theTypesPackage.getReal(), "stepSize", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCS_FMU_Tolerance(), theTypesPackage.getReal(), "tolerance", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(mE_FMUEClass, org.eclipse.papyrus.moka.fmi.fmiprofile.ME_FMU.class, "ME_FMU", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getME_FMU_CompletedIntegratorStepNotNeeded(), theTypesPackage.getBoolean(), "completedIntegratorStepNotNeeded", null, 1, 1, org.eclipse.papyrus.moka.fmi.fmiprofile.ME_FMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fmiPortEClass, FMIPort.class, "FMIPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(independentEClass, Independent.class, "Independent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unknownEClass, Unknown.class, "Unknown", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnknown_Base_Property(), theUMLPackage.getProperty(), null, "base_Property", null, 1, 1, Unknown.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUnknown_Dependencies(), theTypesPackage.getString(), "dependencies", null, 0, 1, Unknown.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUnknown_DependenciesKind(), theTypesPackage.getString(), "dependenciesKind", null, 0, 1, Unknown.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outputUnknownEClass, OutputUnknown.class, "OutputUnknown", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(initialUnknownEClass, InitialUnknown.class, "InitialUnknown", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(derivativeUnknownEClass, DerivativeUnknown.class, "DerivativeUnknown", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cS_GraphEClass, CS_Graph.class, "CS_Graph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCS_Graph_StartTime(), theTypesPackage.getReal(), "startTime", "0.0", 1, 1, CS_Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCS_Graph_StopTime(), theTypesPackage.getReal(), "stopTime", "100.0", 1, 1, CS_Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCS_Graph_StepSize(), theTypesPackage.getReal(), "stepSize", "10.0", 1, 1, CS_Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCS_Graph_Tolerance(), theTypesPackage.getReal(), "tolerance", "0.0", 1, 1, CS_Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCS_Graph_ToleranceDefined(), theTypesPackage.getBoolean(), "toleranceDefined", "true", 1, 1, CS_Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCS_Graph_StopTimeDefined(), theTypesPackage.getBoolean(), "stopTimeDefined", "true", 1, 1, CS_Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCS_Graph_ComputeSetupExperimentsFromFmus(), theTypesPackage.getBoolean(), "computeSetupExperimentsFromFmus", "false", 1, 1, CS_Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCS_Graph_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, CS_Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(derivativeDependencyEClass, DerivativeDependency.class, "DerivativeDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDerivativeDependency_Base_Dependency(), theUMLPackage.getDependency(), null, "base_Dependency", null, 1, 1, DerivativeDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDerivativeDependency_DependencyKind(), this.getDependenciesKind(), "dependencyKind", null, 1, 1, DerivativeDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outputDependencyEClass, OutputDependency.class, "OutputDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputDependency_Base_Dependency(), theUMLPackage.getDependency(), null, "base_Dependency", null, 1, 1, OutputDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(initialUnknownDependencyEClass, InitialUnknownDependency.class, "InitialUnknownDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInitialUnknownDependency_Base_Dependency(), theUMLPackage.getDependency(), null, "base_Dependency", null, 1, 1, InitialUnknownDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(calculatedParameterEClass, CalculatedParameter.class, "CalculatedParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(portEClass, Port.class, "Port", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(variabilityKindEEnum, VariabilityKind.class, "VariabilityKind");
		addEEnumLiteral(variabilityKindEEnum, VariabilityKind.CONSTANT);
		addEEnumLiteral(variabilityKindEEnum, VariabilityKind.FIXED);
		addEEnumLiteral(variabilityKindEEnum, VariabilityKind.TUNABLE);
		addEEnumLiteral(variabilityKindEEnum, VariabilityKind.DISCRETE);
		addEEnumLiteral(variabilityKindEEnum, VariabilityKind.CONTINUOUS);

		initEEnum(initialKindEEnum, InitialKind.class, "InitialKind");
		addEEnumLiteral(initialKindEEnum, InitialKind.EXACT);
		addEEnumLiteral(initialKindEEnum, InitialKind.APPROX);
		addEEnumLiteral(initialKindEEnum, InitialKind.CALCULATED);

		initEEnum(causalityKindEEnum, CausalityKind.class, "CausalityKind");
		addEEnumLiteral(causalityKindEEnum, CausalityKind.PARAMETER);
		addEEnumLiteral(causalityKindEEnum, CausalityKind.CALCULATED_PARAMETER);
		addEEnumLiteral(causalityKindEEnum, CausalityKind.INPUT);
		addEEnumLiteral(causalityKindEEnum, CausalityKind.OUTPUT);
		addEEnumLiteral(causalityKindEEnum, CausalityKind.LOCAL);
		addEEnumLiteral(causalityKindEEnum, CausalityKind.INDEPENDENT);

		initEEnum(dependenciesKindEEnum, DependenciesKind.class, "DependenciesKind");
		addEEnumLiteral(dependenciesKindEEnum, DependenciesKind.DEPENDENT);
		addEEnumLiteral(dependenciesKindEEnum, DependenciesKind.CONSTANT);
		addEEnumLiteral(dependenciesKindEEnum, DependenciesKind.FIXED);
		addEEnumLiteral(dependenciesKindEEnum, DependenciesKind.TUNABLE);
		addEEnumLiteral(dependenciesKindEEnum, DependenciesKind.DISCRETE);

		initEEnum(variabilityNamingConventionEEnum, VariabilityNamingConvention.class, "VariabilityNamingConvention");
		addEEnumLiteral(variabilityNamingConventionEEnum, VariabilityNamingConvention.FLAT);
		addEEnumLiteral(variabilityNamingConventionEEnum, VariabilityNamingConvention.STRUCTURED);

		initEEnum(baseUnitEEnum, BaseUnit.class, "BaseUnit");
		addEEnumLiteral(baseUnitEEnum, BaseUnit.A);
		addEEnumLiteral(baseUnitEEnum, BaseUnit.CD);
		addEEnumLiteral(baseUnitEEnum, BaseUnit.FACTOR);
		addEEnumLiteral(baseUnitEEnum, BaseUnit.K);
		addEEnumLiteral(baseUnitEEnum, BaseUnit.KG);
		addEEnumLiteral(baseUnitEEnum, BaseUnit.M);
		addEEnumLiteral(baseUnitEEnum, BaseUnit.MOL);
		addEEnumLiteral(baseUnitEEnum, BaseUnit.OFFSET);
		addEEnumLiteral(baseUnitEEnum, BaseUnit.RAD);
		addEEnumLiteral(baseUnitEEnum, BaseUnit.S);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "originalName", "FMIProfile"
		   });
	}

} //FMIProfilePackageImpl
