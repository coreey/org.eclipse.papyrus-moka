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
package org.eclipse.papyrus.moka.fmi.modeldescription.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.eclipse.emf.ecore.xml.type.util.XMLTypeValidator;

import org.eclipse.papyrus.moka.fmi.modeldescription.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage
 * @generated
 */
public class FmiValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final FmiValidator INSTANCE = new FmiValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.papyrus.moka.fmi.modeldescription";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMLTypeValidator xmlTypeValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FmiValidator() {
		super();
		xmlTypeValidator = XMLTypeValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return FmiPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case FmiPackage.BASE_UNIT_TYPE:
				return validateBaseUnitType((BaseUnitType)value, diagnostics, context);
			case FmiPackage.BOOLEAN_TYPE:
				return validateBooleanType((BooleanType)value, diagnostics, context);
			case FmiPackage.CATEGORY_TYPE:
				return validateCategoryType((CategoryType)value, diagnostics, context);
			case FmiPackage.CO_SIMULATION_TYPE:
				return validateCoSimulationType((CoSimulationType)value, diagnostics, context);
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE:
				return validateDefaultExperimentType((DefaultExperimentType)value, diagnostics, context);
			case FmiPackage.DISPLAY_UNIT_TYPE:
				return validateDisplayUnitType((DisplayUnitType)value, diagnostics, context);
			case FmiPackage.DOCUMENT_ROOT:
				return validateDocumentRoot((DocumentRoot)value, diagnostics, context);
			case FmiPackage.ENUMERATION_TYPE:
				return validateEnumerationType((EnumerationType)value, diagnostics, context);
			case FmiPackage.ENUMERATION_TYPE1:
				return validateEnumerationType1((EnumerationType1)value, diagnostics, context);
			case FmiPackage.FILE_TYPE:
				return validateFileType((FileType)value, diagnostics, context);
			case FmiPackage.FILE_TYPE1:
				return validateFileType1((FileType1)value, diagnostics, context);
			case FmiPackage.FMI2_ANNOTATION:
				return validateFmi2Annotation((Fmi2Annotation)value, diagnostics, context);
			case FmiPackage.FMI2_SCALAR_VARIABLE:
				return validateFmi2ScalarVariable((Fmi2ScalarVariable)value, diagnostics, context);
			case FmiPackage.FMI2_SIMPLE_TYPE:
				return validateFmi2SimpleType((Fmi2SimpleType)value, diagnostics, context);
			case FmiPackage.FMI2_UNIT:
				return validateFmi2Unit((Fmi2Unit)value, diagnostics, context);
			case FmiPackage.FMI2_VARIABLE_DEPENDENCY:
				return validateFmi2VariableDependency((Fmi2VariableDependency)value, diagnostics, context);
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE:
				return validateFmiModelDescriptionType((FmiModelDescriptionType)value, diagnostics, context);
			case FmiPackage.INITIAL_UNKNOWNS_TYPE:
				return validateInitialUnknownsType((InitialUnknownsType)value, diagnostics, context);
			case FmiPackage.INTEGER_TYPE:
				return validateIntegerType((IntegerType)value, diagnostics, context);
			case FmiPackage.INTEGER_TYPE1:
				return validateIntegerType1((IntegerType1)value, diagnostics, context);
			case FmiPackage.ITEM_TYPE:
				return validateItemType((ItemType)value, diagnostics, context);
			case FmiPackage.LOG_CATEGORIES_TYPE:
				return validateLogCategoriesType((LogCategoriesType)value, diagnostics, context);
			case FmiPackage.MODEL_EXCHANGE_TYPE:
				return validateModelExchangeType((ModelExchangeType)value, diagnostics, context);
			case FmiPackage.MODEL_STRUCTURE_TYPE:
				return validateModelStructureType((ModelStructureType)value, diagnostics, context);
			case FmiPackage.MODEL_VARIABLES_TYPE:
				return validateModelVariablesType((ModelVariablesType)value, diagnostics, context);
			case FmiPackage.REAL_TYPE:
				return validateRealType((RealType)value, diagnostics, context);
			case FmiPackage.REAL_TYPE1:
				return validateRealType1((RealType1)value, diagnostics, context);
			case FmiPackage.SOURCE_FILES_TYPE:
				return validateSourceFilesType((SourceFilesType)value, diagnostics, context);
			case FmiPackage.SOURCE_FILES_TYPE1:
				return validateSourceFilesType1((SourceFilesType1)value, diagnostics, context);
			case FmiPackage.STRING_TYPE:
				return validateStringType((StringType)value, diagnostics, context);
			case FmiPackage.TOOL_TYPE:
				return validateToolType((ToolType)value, diagnostics, context);
			case FmiPackage.TYPE_DEFINITIONS_TYPE:
				return validateTypeDefinitionsType((TypeDefinitionsType)value, diagnostics, context);
			case FmiPackage.UNIT_DEFINITIONS_TYPE:
				return validateUnitDefinitionsType((UnitDefinitionsType)value, diagnostics, context);
			case FmiPackage.UNKNOWN_TYPE:
				return validateUnknownType((UnknownType)value, diagnostics, context);
			case FmiPackage.UNKNOWN_TYPE1:
				return validateUnknownType1((UnknownType1)value, diagnostics, context);
			case FmiPackage.CAUSALITY_TYPE:
				return validateCausalityType((CausalityType)value, diagnostics, context);
			case FmiPackage.DEPENDENCIES_KIND_TYPE_ITEM:
				return validateDependenciesKindTypeItem((DependenciesKindTypeItem)value, diagnostics, context);
			case FmiPackage.DEPENDENCIES_KIND_TYPE_ITEM1:
				return validateDependenciesKindTypeItem1((DependenciesKindTypeItem1)value, diagnostics, context);
			case FmiPackage.INITIAL_TYPE:
				return validateInitialType((InitialType)value, diagnostics, context);
			case FmiPackage.VARIABILITY_TYPE:
				return validateVariabilityType((VariabilityType)value, diagnostics, context);
			case FmiPackage.VARIABLE_NAMING_CONVENTION_TYPE:
				return validateVariableNamingConventionType((VariableNamingConventionType)value, diagnostics, context);
			case FmiPackage.CAUSALITY_TYPE_OBJECT:
				return validateCausalityTypeObject((CausalityType)value, diagnostics, context);
			case FmiPackage.DEPENDENCIES_KIND_TYPE:
				return validateDependenciesKindType((List<?>)value, diagnostics, context);
			case FmiPackage.DEPENDENCIES_KIND_TYPE1:
				return validateDependenciesKindType1((List<?>)value, diagnostics, context);
			case FmiPackage.DEPENDENCIES_KIND_TYPE_ITEM_OBJECT:
				return validateDependenciesKindTypeItemObject((DependenciesKindTypeItem)value, diagnostics, context);
			case FmiPackage.DEPENDENCIES_KIND_TYPE_ITEM_OBJECT1:
				return validateDependenciesKindTypeItemObject1((DependenciesKindTypeItem1)value, diagnostics, context);
			case FmiPackage.DEPENDENCIES_TYPE:
				return validateDependenciesType((List<?>)value, diagnostics, context);
			case FmiPackage.DEPENDENCIES_TYPE1:
				return validateDependenciesType1((List<?>)value, diagnostics, context);
			case FmiPackage.INITIAL_TYPE_OBJECT:
				return validateInitialTypeObject((InitialType)value, diagnostics, context);
			case FmiPackage.VARIABILITY_TYPE_OBJECT:
				return validateVariabilityTypeObject((VariabilityType)value, diagnostics, context);
			case FmiPackage.VARIABLE_NAMING_CONVENTION_TYPE_OBJECT:
				return validateVariableNamingConventionTypeObject((VariableNamingConventionType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBaseUnitType(BaseUnitType baseUnitType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(baseUnitType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanType(BooleanType booleanType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(booleanType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCategoryType(CategoryType categoryType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(categoryType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCoSimulationType(CoSimulationType coSimulationType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(coSimulationType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDefaultExperimentType(DefaultExperimentType defaultExperimentType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(defaultExperimentType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDisplayUnitType(DisplayUnitType displayUnitType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(displayUnitType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDocumentRoot(DocumentRoot documentRoot, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(documentRoot, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationType(EnumerationType enumerationType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(enumerationType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationType1(EnumerationType1 enumerationType1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(enumerationType1, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFileType(FileType fileType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fileType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFileType1(FileType1 fileType1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fileType1, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFmi2Annotation(Fmi2Annotation fmi2Annotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fmi2Annotation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFmi2ScalarVariable(Fmi2ScalarVariable fmi2ScalarVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fmi2ScalarVariable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFmi2SimpleType(Fmi2SimpleType fmi2SimpleType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fmi2SimpleType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFmi2Unit(Fmi2Unit fmi2Unit, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fmi2Unit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFmi2VariableDependency(Fmi2VariableDependency fmi2VariableDependency, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fmi2VariableDependency, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFmiModelDescriptionType(FmiModelDescriptionType fmiModelDescriptionType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fmiModelDescriptionType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInitialUnknownsType(InitialUnknownsType initialUnknownsType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(initialUnknownsType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntegerType(IntegerType integerType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(integerType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntegerType1(IntegerType1 integerType1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(integerType1, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateItemType(ItemType itemType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(itemType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLogCategoriesType(LogCategoriesType logCategoriesType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(logCategoriesType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelExchangeType(ModelExchangeType modelExchangeType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modelExchangeType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelStructureType(ModelStructureType modelStructureType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modelStructureType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelVariablesType(ModelVariablesType modelVariablesType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modelVariablesType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRealType(RealType realType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(realType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRealType1(RealType1 realType1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(realType1, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceFilesType(SourceFilesType sourceFilesType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sourceFilesType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceFilesType1(SourceFilesType1 sourceFilesType1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sourceFilesType1, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringType(StringType stringType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stringType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateToolType(ToolType toolType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(toolType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeDefinitionsType(TypeDefinitionsType typeDefinitionsType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(typeDefinitionsType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnitDefinitionsType(UnitDefinitionsType unitDefinitionsType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(unitDefinitionsType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnknownType(UnknownType unknownType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(unknownType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnknownType1(UnknownType1 unknownType1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(unknownType1, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCausalityType(CausalityType causalityType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependenciesKindTypeItem(DependenciesKindTypeItem dependenciesKindTypeItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependenciesKindTypeItem1(DependenciesKindTypeItem1 dependenciesKindTypeItem1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInitialType(InitialType initialType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariabilityType(VariabilityType variabilityType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableNamingConventionType(VariableNamingConventionType variableNamingConventionType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCausalityTypeObject(CausalityType causalityTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependenciesKindType(List<?> dependenciesKindType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateDependenciesKindType_ItemType(dependenciesKindType, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ItemType constraint of '<em>Dependencies Kind Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependenciesKindType_ItemType(List<?> dependenciesKindType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (Iterator<?> i = dependenciesKindType.iterator(); i.hasNext() && (result || diagnostics != null); ) {
			Object item = i.next();
			if (FmiPackage.Literals.DEPENDENCIES_KIND_TYPE_ITEM.isInstance(item)) {
				result &= validateDependenciesKindTypeItem((DependenciesKindTypeItem)item, diagnostics, context);
			}
			else {
				result = false;
				reportDataValueTypeViolation(FmiPackage.Literals.DEPENDENCIES_KIND_TYPE_ITEM, item, diagnostics, context);
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependenciesKindType1(List<?> dependenciesKindType1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateDependenciesKindType1_ItemType(dependenciesKindType1, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ItemType constraint of '<em>Dependencies Kind Type1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependenciesKindType1_ItemType(List<?> dependenciesKindType1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (Iterator<?> i = dependenciesKindType1.iterator(); i.hasNext() && (result || diagnostics != null); ) {
			Object item = i.next();
			if (FmiPackage.Literals.DEPENDENCIES_KIND_TYPE_ITEM1.isInstance(item)) {
				result &= validateDependenciesKindTypeItem1((DependenciesKindTypeItem1)item, diagnostics, context);
			}
			else {
				result = false;
				reportDataValueTypeViolation(FmiPackage.Literals.DEPENDENCIES_KIND_TYPE_ITEM1, item, diagnostics, context);
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependenciesKindTypeItemObject(DependenciesKindTypeItem dependenciesKindTypeItemObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependenciesKindTypeItemObject1(DependenciesKindTypeItem1 dependenciesKindTypeItemObject1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependenciesType(List<?> dependenciesType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateDependenciesType_ItemType(dependenciesType, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ItemType constraint of '<em>Dependencies Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependenciesType_ItemType(List<?> dependenciesType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (Iterator<?> i = dependenciesType.iterator(); i.hasNext() && (result || diagnostics != null); ) {
			Object item = i.next();
			if (XMLTypePackage.Literals.UNSIGNED_INT.isInstance(item)) {
				result &= xmlTypeValidator.validateUnsignedInt((Long)item, diagnostics, context);
			}
			else {
				result = false;
				reportDataValueTypeViolation(XMLTypePackage.Literals.UNSIGNED_INT, item, diagnostics, context);
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependenciesType1(List<?> dependenciesType1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateDependenciesType1_ItemType(dependenciesType1, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ItemType constraint of '<em>Dependencies Type1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependenciesType1_ItemType(List<?> dependenciesType1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (Iterator<?> i = dependenciesType1.iterator(); i.hasNext() && (result || diagnostics != null); ) {
			Object item = i.next();
			if (XMLTypePackage.Literals.UNSIGNED_INT.isInstance(item)) {
				result &= xmlTypeValidator.validateUnsignedInt((Long)item, diagnostics, context);
			}
			else {
				result = false;
				reportDataValueTypeViolation(XMLTypePackage.Literals.UNSIGNED_INT, item, diagnostics, context);
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInitialTypeObject(InitialType initialTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariabilityTypeObject(VariabilityType variabilityTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableNamingConventionTypeObject(VariableNamingConventionType variableNamingConventionTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //FmiValidator
