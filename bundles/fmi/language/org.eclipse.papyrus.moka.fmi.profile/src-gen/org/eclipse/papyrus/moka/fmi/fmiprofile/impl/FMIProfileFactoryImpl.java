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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.moka.fmi.fmiprofile.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FMIProfileFactoryImpl extends EFactoryImpl implements FMIProfileFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FMIProfileFactory init() {
		try {
			FMIProfileFactory theFMIProfileFactory = (FMIProfileFactory)EPackage.Registry.INSTANCE.getEFactory(FMIProfilePackage.eNS_URI);
			if (theFMIProfileFactory != null) {
				return theFMIProfileFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FMIProfileFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FMIProfileFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FMIProfilePackage.FMU: return createFMU();
			case FMIProfilePackage.PARAMETER: return createParameter();
			case FMIProfilePackage.LOCAL: return createLocal();
			case FMIProfilePackage.CS_FMU: return createCS_FMU();
			case FMIProfilePackage.ME_FMU: return createME_FMU();
			case FMIProfilePackage.FMI_PORT: return createFMIPort();
			case FMIProfilePackage.INDEPENDENT: return createIndependent();
			case FMIProfilePackage.UNKNOWN: return createUnknown();
			case FMIProfilePackage.OUTPUT_UNKNOWN: return createOutputUnknown();
			case FMIProfilePackage.INITIAL_UNKNOWN: return createInitialUnknown();
			case FMIProfilePackage.DERIVATIVE_UNKNOWN: return createDerivativeUnknown();
			case FMIProfilePackage.CS_GRAPH: return createCS_Graph();
			case FMIProfilePackage.DERIVATIVE_DEPENDENCY: return createDerivativeDependency();
			case FMIProfilePackage.OUTPUT_DEPENDENCY: return createOutputDependency();
			case FMIProfilePackage.INITIAL_UNKNOWN_DEPENDENCY: return createInitialUnknownDependency();
			case FMIProfilePackage.CALCULATED_PARAMETER: return createCalculatedParameter();
			case FMIProfilePackage.PORT: return createPort();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case FMIProfilePackage.VARIABILITY_KIND:
				return createVariabilityKindFromString(eDataType, initialValue);
			case FMIProfilePackage.INITIAL_KIND:
				return createInitialKindFromString(eDataType, initialValue);
			case FMIProfilePackage.CAUSALITY_KIND:
				return createCausalityKindFromString(eDataType, initialValue);
			case FMIProfilePackage.DEPENDENCIES_KIND:
				return createDependenciesKindFromString(eDataType, initialValue);
			case FMIProfilePackage.VARIABILITY_NAMING_CONVENTION:
				return createVariabilityNamingConventionFromString(eDataType, initialValue);
			case FMIProfilePackage.BASE_UNIT:
				return createBaseUnitFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case FMIProfilePackage.VARIABILITY_KIND:
				return convertVariabilityKindToString(eDataType, instanceValue);
			case FMIProfilePackage.INITIAL_KIND:
				return convertInitialKindToString(eDataType, instanceValue);
			case FMIProfilePackage.CAUSALITY_KIND:
				return convertCausalityKindToString(eDataType, instanceValue);
			case FMIProfilePackage.DEPENDENCIES_KIND:
				return convertDependenciesKindToString(eDataType, instanceValue);
			case FMIProfilePackage.VARIABILITY_NAMING_CONVENTION:
				return convertVariabilityNamingConventionToString(eDataType, instanceValue);
			case FMIProfilePackage.BASE_UNIT:
				return convertBaseUnitToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FMU createFMU() {
		FMUImpl fmu = new FMUImpl();
		return fmu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Local createLocal() {
		LocalImpl local = new LocalImpl();
		return local;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CS_FMU createCS_FMU() {
		CS_FMUImpl cS_FMU = new CS_FMUImpl();
		return cS_FMU;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ME_FMU createME_FMU() {
		ME_FMUImpl mE_FMU = new ME_FMUImpl();
		return mE_FMU;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FMIPort createFMIPort() {
		FMIPortImpl fmiPort = new FMIPortImpl();
		return fmiPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Independent createIndependent() {
		IndependentImpl independent = new IndependentImpl();
		return independent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unknown createUnknown() {
		UnknownImpl unknown = new UnknownImpl();
		return unknown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputUnknown createOutputUnknown() {
		OutputUnknownImpl outputUnknown = new OutputUnknownImpl();
		return outputUnknown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitialUnknown createInitialUnknown() {
		InitialUnknownImpl initialUnknown = new InitialUnknownImpl();
		return initialUnknown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DerivativeUnknown createDerivativeUnknown() {
		DerivativeUnknownImpl derivativeUnknown = new DerivativeUnknownImpl();
		return derivativeUnknown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CS_Graph createCS_Graph() {
		CS_GraphImpl cS_Graph = new CS_GraphImpl();
		return cS_Graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DerivativeDependency createDerivativeDependency() {
		DerivativeDependencyImpl derivativeDependency = new DerivativeDependencyImpl();
		return derivativeDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputDependency createOutputDependency() {
		OutputDependencyImpl outputDependency = new OutputDependencyImpl();
		return outputDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitialUnknownDependency createInitialUnknownDependency() {
		InitialUnknownDependencyImpl initialUnknownDependency = new InitialUnknownDependencyImpl();
		return initialUnknownDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalculatedParameter createCalculatedParameter() {
		CalculatedParameterImpl calculatedParameter = new CalculatedParameterImpl();
		return calculatedParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port createPort() {
		PortImpl port = new PortImpl();
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariabilityKind createVariabilityKindFromString(EDataType eDataType, String initialValue) {
		VariabilityKind result = VariabilityKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVariabilityKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitialKind createInitialKindFromString(EDataType eDataType, String initialValue) {
		InitialKind result = InitialKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInitialKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CausalityKind createCausalityKindFromString(EDataType eDataType, String initialValue) {
		CausalityKind result = CausalityKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCausalityKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependenciesKind createDependenciesKindFromString(EDataType eDataType, String initialValue) {
		DependenciesKind result = DependenciesKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDependenciesKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariabilityNamingConvention createVariabilityNamingConventionFromString(EDataType eDataType, String initialValue) {
		VariabilityNamingConvention result = VariabilityNamingConvention.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVariabilityNamingConventionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseUnit createBaseUnitFromString(EDataType eDataType, String initialValue) {
		BaseUnit result = BaseUnit.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBaseUnitToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FMIProfilePackage getFMIProfilePackage() {
		return (FMIProfilePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FMIProfilePackage getPackage() {
		return FMIProfilePackage.eINSTANCE;
	}

} //FMIProfileFactoryImpl
