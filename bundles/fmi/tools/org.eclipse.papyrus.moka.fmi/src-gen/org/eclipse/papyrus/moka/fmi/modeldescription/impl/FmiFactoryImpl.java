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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.eclipse.papyrus.moka.fmi.modeldescription.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FmiFactoryImpl extends EFactoryImpl implements FmiFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FmiFactory init() {
		try {
			FmiFactory theFmiFactory = (FmiFactory)EPackage.Registry.INSTANCE.getEFactory(FmiPackage.eNS_URI);
			if (theFmiFactory != null) {
				return theFmiFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FmiFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FmiFactoryImpl() {
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
			case FmiPackage.BASE_UNIT_TYPE: return createBaseUnitType();
			case FmiPackage.BOOLEAN_TYPE: return createBooleanType();
			case FmiPackage.CATEGORY_TYPE: return createCategoryType();
			case FmiPackage.CO_SIMULATION_TYPE: return createCoSimulationType();
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE: return createDefaultExperimentType();
			case FmiPackage.DISPLAY_UNIT_TYPE: return createDisplayUnitType();
			case FmiPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case FmiPackage.ENUMERATION_TYPE: return createEnumerationType();
			case FmiPackage.ENUMERATION_TYPE1: return createEnumerationType1();
			case FmiPackage.FILE_TYPE: return createFileType();
			case FmiPackage.FILE_TYPE1: return createFileType1();
			case FmiPackage.FMI2_ANNOTATION: return createFmi2Annotation();
			case FmiPackage.FMI2_SCALAR_VARIABLE: return createFmi2ScalarVariable();
			case FmiPackage.FMI2_SIMPLE_TYPE: return createFmi2SimpleType();
			case FmiPackage.FMI2_UNIT: return createFmi2Unit();
			case FmiPackage.FMI2_VARIABLE_DEPENDENCY: return createFmi2VariableDependency();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE: return createFmiModelDescriptionType();
			case FmiPackage.INITIAL_UNKNOWNS_TYPE: return createInitialUnknownsType();
			case FmiPackage.INTEGER_TYPE: return createIntegerType();
			case FmiPackage.INTEGER_TYPE1: return createIntegerType1();
			case FmiPackage.ITEM_TYPE: return createItemType();
			case FmiPackage.LOG_CATEGORIES_TYPE: return createLogCategoriesType();
			case FmiPackage.MODEL_EXCHANGE_TYPE: return createModelExchangeType();
			case FmiPackage.MODEL_STRUCTURE_TYPE: return createModelStructureType();
			case FmiPackage.MODEL_VARIABLES_TYPE: return createModelVariablesType();
			case FmiPackage.REAL_TYPE: return createRealType();
			case FmiPackage.REAL_TYPE1: return createRealType1();
			case FmiPackage.SOURCE_FILES_TYPE: return createSourceFilesType();
			case FmiPackage.SOURCE_FILES_TYPE1: return createSourceFilesType1();
			case FmiPackage.STRING_TYPE: return createStringType();
			case FmiPackage.TOOL_TYPE: return createToolType();
			case FmiPackage.TYPE_DEFINITIONS_TYPE: return createTypeDefinitionsType();
			case FmiPackage.UNIT_DEFINITIONS_TYPE: return createUnitDefinitionsType();
			case FmiPackage.UNKNOWN_TYPE: return createUnknownType();
			case FmiPackage.UNKNOWN_TYPE1: return createUnknownType1();
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
			case FmiPackage.CAUSALITY_TYPE:
				return createCausalityTypeFromString(eDataType, initialValue);
			case FmiPackage.DEPENDENCIES_KIND_TYPE_ITEM:
				return createDependenciesKindTypeItemFromString(eDataType, initialValue);
			case FmiPackage.DEPENDENCIES_KIND_TYPE_ITEM1:
				return createDependenciesKindTypeItem1FromString(eDataType, initialValue);
			case FmiPackage.INITIAL_TYPE:
				return createInitialTypeFromString(eDataType, initialValue);
			case FmiPackage.VARIABILITY_TYPE:
				return createVariabilityTypeFromString(eDataType, initialValue);
			case FmiPackage.VARIABLE_NAMING_CONVENTION_TYPE:
				return createVariableNamingConventionTypeFromString(eDataType, initialValue);
			case FmiPackage.CAUSALITY_TYPE_OBJECT:
				return createCausalityTypeObjectFromString(eDataType, initialValue);
			case FmiPackage.DEPENDENCIES_KIND_TYPE:
				return createDependenciesKindTypeFromString(eDataType, initialValue);
			case FmiPackage.DEPENDENCIES_KIND_TYPE1:
				return createDependenciesKindType1FromString(eDataType, initialValue);
			case FmiPackage.DEPENDENCIES_KIND_TYPE_ITEM_OBJECT:
				return createDependenciesKindTypeItemObjectFromString(eDataType, initialValue);
			case FmiPackage.DEPENDENCIES_KIND_TYPE_ITEM_OBJECT1:
				return createDependenciesKindTypeItemObject1FromString(eDataType, initialValue);
			case FmiPackage.DEPENDENCIES_TYPE:
				return createDependenciesTypeFromString(eDataType, initialValue);
			case FmiPackage.DEPENDENCIES_TYPE1:
				return createDependenciesType1FromString(eDataType, initialValue);
			case FmiPackage.INITIAL_TYPE_OBJECT:
				return createInitialTypeObjectFromString(eDataType, initialValue);
			case FmiPackage.VARIABILITY_TYPE_OBJECT:
				return createVariabilityTypeObjectFromString(eDataType, initialValue);
			case FmiPackage.VARIABLE_NAMING_CONVENTION_TYPE_OBJECT:
				return createVariableNamingConventionTypeObjectFromString(eDataType, initialValue);
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
			case FmiPackage.CAUSALITY_TYPE:
				return convertCausalityTypeToString(eDataType, instanceValue);
			case FmiPackage.DEPENDENCIES_KIND_TYPE_ITEM:
				return convertDependenciesKindTypeItemToString(eDataType, instanceValue);
			case FmiPackage.DEPENDENCIES_KIND_TYPE_ITEM1:
				return convertDependenciesKindTypeItem1ToString(eDataType, instanceValue);
			case FmiPackage.INITIAL_TYPE:
				return convertInitialTypeToString(eDataType, instanceValue);
			case FmiPackage.VARIABILITY_TYPE:
				return convertVariabilityTypeToString(eDataType, instanceValue);
			case FmiPackage.VARIABLE_NAMING_CONVENTION_TYPE:
				return convertVariableNamingConventionTypeToString(eDataType, instanceValue);
			case FmiPackage.CAUSALITY_TYPE_OBJECT:
				return convertCausalityTypeObjectToString(eDataType, instanceValue);
			case FmiPackage.DEPENDENCIES_KIND_TYPE:
				return convertDependenciesKindTypeToString(eDataType, instanceValue);
			case FmiPackage.DEPENDENCIES_KIND_TYPE1:
				return convertDependenciesKindType1ToString(eDataType, instanceValue);
			case FmiPackage.DEPENDENCIES_KIND_TYPE_ITEM_OBJECT:
				return convertDependenciesKindTypeItemObjectToString(eDataType, instanceValue);
			case FmiPackage.DEPENDENCIES_KIND_TYPE_ITEM_OBJECT1:
				return convertDependenciesKindTypeItemObject1ToString(eDataType, instanceValue);
			case FmiPackage.DEPENDENCIES_TYPE:
				return convertDependenciesTypeToString(eDataType, instanceValue);
			case FmiPackage.DEPENDENCIES_TYPE1:
				return convertDependenciesType1ToString(eDataType, instanceValue);
			case FmiPackage.INITIAL_TYPE_OBJECT:
				return convertInitialTypeObjectToString(eDataType, instanceValue);
			case FmiPackage.VARIABILITY_TYPE_OBJECT:
				return convertVariabilityTypeObjectToString(eDataType, instanceValue);
			case FmiPackage.VARIABLE_NAMING_CONVENTION_TYPE_OBJECT:
				return convertVariableNamingConventionTypeObjectToString(eDataType, instanceValue);
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
	public BaseUnitType createBaseUnitType() {
		BaseUnitTypeImpl baseUnitType = new BaseUnitTypeImpl();
		return baseUnitType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BooleanType createBooleanType() {
		BooleanTypeImpl booleanType = new BooleanTypeImpl();
		return booleanType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CategoryType createCategoryType() {
		CategoryTypeImpl categoryType = new CategoryTypeImpl();
		return categoryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CoSimulationType createCoSimulationType() {
		CoSimulationTypeImpl coSimulationType = new CoSimulationTypeImpl();
		return coSimulationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DefaultExperimentType createDefaultExperimentType() {
		DefaultExperimentTypeImpl defaultExperimentType = new DefaultExperimentTypeImpl();
		return defaultExperimentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DisplayUnitType createDisplayUnitType() {
		DisplayUnitTypeImpl displayUnitType = new DisplayUnitTypeImpl();
		return displayUnitType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumerationType createEnumerationType() {
		EnumerationTypeImpl enumerationType = new EnumerationTypeImpl();
		return enumerationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumerationType1 createEnumerationType1() {
		EnumerationType1Impl enumerationType1 = new EnumerationType1Impl();
		return enumerationType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FileType createFileType() {
		FileTypeImpl fileType = new FileTypeImpl();
		return fileType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FileType1 createFileType1() {
		FileType1Impl fileType1 = new FileType1Impl();
		return fileType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Fmi2Annotation createFmi2Annotation() {
		Fmi2AnnotationImpl fmi2Annotation = new Fmi2AnnotationImpl();
		return fmi2Annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Fmi2ScalarVariable createFmi2ScalarVariable() {
		Fmi2ScalarVariableImpl fmi2ScalarVariable = new Fmi2ScalarVariableImpl();
		return fmi2ScalarVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Fmi2SimpleType createFmi2SimpleType() {
		Fmi2SimpleTypeImpl fmi2SimpleType = new Fmi2SimpleTypeImpl();
		return fmi2SimpleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Fmi2Unit createFmi2Unit() {
		Fmi2UnitImpl fmi2Unit = new Fmi2UnitImpl();
		return fmi2Unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Fmi2VariableDependency createFmi2VariableDependency() {
		Fmi2VariableDependencyImpl fmi2VariableDependency = new Fmi2VariableDependencyImpl();
		return fmi2VariableDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FmiModelDescriptionType createFmiModelDescriptionType() {
		FmiModelDescriptionTypeImpl fmiModelDescriptionType = new FmiModelDescriptionTypeImpl();
		return fmiModelDescriptionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InitialUnknownsType createInitialUnknownsType() {
		InitialUnknownsTypeImpl initialUnknownsType = new InitialUnknownsTypeImpl();
		return initialUnknownsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntegerType createIntegerType() {
		IntegerTypeImpl integerType = new IntegerTypeImpl();
		return integerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntegerType1 createIntegerType1() {
		IntegerType1Impl integerType1 = new IntegerType1Impl();
		return integerType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ItemType createItemType() {
		ItemTypeImpl itemType = new ItemTypeImpl();
		return itemType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LogCategoriesType createLogCategoriesType() {
		LogCategoriesTypeImpl logCategoriesType = new LogCategoriesTypeImpl();
		return logCategoriesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelExchangeType createModelExchangeType() {
		ModelExchangeTypeImpl modelExchangeType = new ModelExchangeTypeImpl();
		return modelExchangeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelStructureType createModelStructureType() {
		ModelStructureTypeImpl modelStructureType = new ModelStructureTypeImpl();
		return modelStructureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelVariablesType createModelVariablesType() {
		ModelVariablesTypeImpl modelVariablesType = new ModelVariablesTypeImpl();
		return modelVariablesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RealType createRealType() {
		RealTypeImpl realType = new RealTypeImpl();
		return realType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RealType1 createRealType1() {
		RealType1Impl realType1 = new RealType1Impl();
		return realType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceFilesType createSourceFilesType() {
		SourceFilesTypeImpl sourceFilesType = new SourceFilesTypeImpl();
		return sourceFilesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceFilesType1 createSourceFilesType1() {
		SourceFilesType1Impl sourceFilesType1 = new SourceFilesType1Impl();
		return sourceFilesType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StringType createStringType() {
		StringTypeImpl stringType = new StringTypeImpl();
		return stringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ToolType createToolType() {
		ToolTypeImpl toolType = new ToolTypeImpl();
		return toolType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeDefinitionsType createTypeDefinitionsType() {
		TypeDefinitionsTypeImpl typeDefinitionsType = new TypeDefinitionsTypeImpl();
		return typeDefinitionsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnitDefinitionsType createUnitDefinitionsType() {
		UnitDefinitionsTypeImpl unitDefinitionsType = new UnitDefinitionsTypeImpl();
		return unitDefinitionsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnknownType createUnknownType() {
		UnknownTypeImpl unknownType = new UnknownTypeImpl();
		return unknownType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnknownType1 createUnknownType1() {
		UnknownType1Impl unknownType1 = new UnknownType1Impl();
		return unknownType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CausalityType createCausalityTypeFromString(EDataType eDataType, String initialValue) {
		CausalityType result = CausalityType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCausalityTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependenciesKindTypeItem createDependenciesKindTypeItemFromString(EDataType eDataType, String initialValue) {
		DependenciesKindTypeItem result = DependenciesKindTypeItem.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDependenciesKindTypeItemToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependenciesKindTypeItem1 createDependenciesKindTypeItem1FromString(EDataType eDataType, String initialValue) {
		DependenciesKindTypeItem1 result = DependenciesKindTypeItem1.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDependenciesKindTypeItem1ToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitialType createInitialTypeFromString(EDataType eDataType, String initialValue) {
		InitialType result = InitialType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInitialTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariabilityType createVariabilityTypeFromString(EDataType eDataType, String initialValue) {
		VariabilityType result = VariabilityType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVariabilityTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableNamingConventionType createVariableNamingConventionTypeFromString(EDataType eDataType, String initialValue) {
		VariableNamingConventionType result = VariableNamingConventionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVariableNamingConventionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CausalityType createCausalityTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createCausalityTypeFromString(FmiPackage.Literals.CAUSALITY_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCausalityTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertCausalityTypeToString(FmiPackage.Literals.CAUSALITY_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<DependenciesKindTypeItem> createDependenciesKindTypeFromString(EDataType eDataType, String initialValue) {
		if (initialValue == null) return null;
		List<DependenciesKindTypeItem> result = new ArrayList<DependenciesKindTypeItem>();
		for (String item : split(initialValue)) {
			result.add(createDependenciesKindTypeItemFromString(FmiPackage.Literals.DEPENDENCIES_KIND_TYPE_ITEM, item));
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDependenciesKindTypeToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) return null;
		List<?> list = (List<?>)instanceValue;
		if (list.isEmpty()) return "";
		StringBuffer result = new StringBuffer();
		for (Object item : list) {
			result.append(convertDependenciesKindTypeItemToString(FmiPackage.Literals.DEPENDENCIES_KIND_TYPE_ITEM, item));
			result.append(' ');
		}
		return result.substring(0, result.length() - 1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<DependenciesKindTypeItem1> createDependenciesKindType1FromString(EDataType eDataType, String initialValue) {
		if (initialValue == null) return null;
		List<DependenciesKindTypeItem1> result = new ArrayList<DependenciesKindTypeItem1>();
		for (String item : split(initialValue)) {
			result.add(createDependenciesKindTypeItem1FromString(FmiPackage.Literals.DEPENDENCIES_KIND_TYPE_ITEM1, item));
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDependenciesKindType1ToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) return null;
		List<?> list = (List<?>)instanceValue;
		if (list.isEmpty()) return "";
		StringBuffer result = new StringBuffer();
		for (Object item : list) {
			result.append(convertDependenciesKindTypeItem1ToString(FmiPackage.Literals.DEPENDENCIES_KIND_TYPE_ITEM1, item));
			result.append(' ');
		}
		return result.substring(0, result.length() - 1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependenciesKindTypeItem createDependenciesKindTypeItemObjectFromString(EDataType eDataType, String initialValue) {
		return createDependenciesKindTypeItemFromString(FmiPackage.Literals.DEPENDENCIES_KIND_TYPE_ITEM, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDependenciesKindTypeItemObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDependenciesKindTypeItemToString(FmiPackage.Literals.DEPENDENCIES_KIND_TYPE_ITEM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependenciesKindTypeItem1 createDependenciesKindTypeItemObject1FromString(EDataType eDataType, String initialValue) {
		return createDependenciesKindTypeItem1FromString(FmiPackage.Literals.DEPENDENCIES_KIND_TYPE_ITEM1, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDependenciesKindTypeItemObject1ToString(EDataType eDataType, Object instanceValue) {
		return convertDependenciesKindTypeItem1ToString(FmiPackage.Literals.DEPENDENCIES_KIND_TYPE_ITEM1, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Long> createDependenciesTypeFromString(EDataType eDataType, String initialValue) {
		if (initialValue == null) return null;
		List<Long> result = new ArrayList<Long>();
		for (String item : split(initialValue)) {
			result.add((Long)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.UNSIGNED_INT, item));
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDependenciesTypeToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) return null;
		List<?> list = (List<?>)instanceValue;
		if (list.isEmpty()) return "";
		StringBuffer result = new StringBuffer();
		for (Object item : list) {
			result.append(XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.UNSIGNED_INT, item));
			result.append(' ');
		}
		return result.substring(0, result.length() - 1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Long> createDependenciesType1FromString(EDataType eDataType, String initialValue) {
		if (initialValue == null) return null;
		List<Long> result = new ArrayList<Long>();
		for (String item : split(initialValue)) {
			result.add((Long)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.UNSIGNED_INT, item));
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDependenciesType1ToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) return null;
		List<?> list = (List<?>)instanceValue;
		if (list.isEmpty()) return "";
		StringBuffer result = new StringBuffer();
		for (Object item : list) {
			result.append(XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.UNSIGNED_INT, item));
			result.append(' ');
		}
		return result.substring(0, result.length() - 1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitialType createInitialTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createInitialTypeFromString(FmiPackage.Literals.INITIAL_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInitialTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertInitialTypeToString(FmiPackage.Literals.INITIAL_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariabilityType createVariabilityTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createVariabilityTypeFromString(FmiPackage.Literals.VARIABILITY_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVariabilityTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertVariabilityTypeToString(FmiPackage.Literals.VARIABILITY_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableNamingConventionType createVariableNamingConventionTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createVariableNamingConventionTypeFromString(FmiPackage.Literals.VARIABLE_NAMING_CONVENTION_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVariableNamingConventionTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertVariableNamingConventionTypeToString(FmiPackage.Literals.VARIABLE_NAMING_CONVENTION_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FmiPackage getFmiPackage() {
		return (FmiPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FmiPackage getPackage() {
		return FmiPackage.eINSTANCE;
	}

} //FmiFactoryImpl
