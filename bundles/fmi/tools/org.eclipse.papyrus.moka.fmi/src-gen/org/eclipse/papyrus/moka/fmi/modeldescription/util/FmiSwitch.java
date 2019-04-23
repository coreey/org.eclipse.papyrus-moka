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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.moka.fmi.modeldescription.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage
 * @generated
 */
public class FmiSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FmiPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FmiSwitch() {
		if (modelPackage == null) {
			modelPackage = FmiPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case FmiPackage.BASE_UNIT_TYPE: {
				BaseUnitType baseUnitType = (BaseUnitType)theEObject;
				T result = caseBaseUnitType(baseUnitType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.BOOLEAN_TYPE: {
				BooleanType booleanType = (BooleanType)theEObject;
				T result = caseBooleanType(booleanType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.CATEGORY_TYPE: {
				CategoryType categoryType = (CategoryType)theEObject;
				T result = caseCategoryType(categoryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.CO_SIMULATION_TYPE: {
				CoSimulationType coSimulationType = (CoSimulationType)theEObject;
				T result = caseCoSimulationType(coSimulationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.DEFAULT_EXPERIMENT_TYPE: {
				DefaultExperimentType defaultExperimentType = (DefaultExperimentType)theEObject;
				T result = caseDefaultExperimentType(defaultExperimentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.DISPLAY_UNIT_TYPE: {
				DisplayUnitType displayUnitType = (DisplayUnitType)theEObject;
				T result = caseDisplayUnitType(displayUnitType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.ENUMERATION_TYPE: {
				EnumerationType enumerationType = (EnumerationType)theEObject;
				T result = caseEnumerationType(enumerationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.ENUMERATION_TYPE1: {
				EnumerationType1 enumerationType1 = (EnumerationType1)theEObject;
				T result = caseEnumerationType1(enumerationType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.FILE_TYPE: {
				FileType fileType = (FileType)theEObject;
				T result = caseFileType(fileType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.FILE_TYPE1: {
				FileType1 fileType1 = (FileType1)theEObject;
				T result = caseFileType1(fileType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.FMI2_ANNOTATION: {
				Fmi2Annotation fmi2Annotation = (Fmi2Annotation)theEObject;
				T result = caseFmi2Annotation(fmi2Annotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.FMI2_SCALAR_VARIABLE: {
				Fmi2ScalarVariable fmi2ScalarVariable = (Fmi2ScalarVariable)theEObject;
				T result = caseFmi2ScalarVariable(fmi2ScalarVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.FMI2_SIMPLE_TYPE: {
				Fmi2SimpleType fmi2SimpleType = (Fmi2SimpleType)theEObject;
				T result = caseFmi2SimpleType(fmi2SimpleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.FMI2_UNIT: {
				Fmi2Unit fmi2Unit = (Fmi2Unit)theEObject;
				T result = caseFmi2Unit(fmi2Unit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.FMI2_VARIABLE_DEPENDENCY: {
				Fmi2VariableDependency fmi2VariableDependency = (Fmi2VariableDependency)theEObject;
				T result = caseFmi2VariableDependency(fmi2VariableDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE: {
				FmiModelDescriptionType fmiModelDescriptionType = (FmiModelDescriptionType)theEObject;
				T result = caseFmiModelDescriptionType(fmiModelDescriptionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.INITIAL_UNKNOWNS_TYPE: {
				InitialUnknownsType initialUnknownsType = (InitialUnknownsType)theEObject;
				T result = caseInitialUnknownsType(initialUnknownsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.INTEGER_TYPE: {
				IntegerType integerType = (IntegerType)theEObject;
				T result = caseIntegerType(integerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.INTEGER_TYPE1: {
				IntegerType1 integerType1 = (IntegerType1)theEObject;
				T result = caseIntegerType1(integerType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.ITEM_TYPE: {
				ItemType itemType = (ItemType)theEObject;
				T result = caseItemType(itemType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.LOG_CATEGORIES_TYPE: {
				LogCategoriesType logCategoriesType = (LogCategoriesType)theEObject;
				T result = caseLogCategoriesType(logCategoriesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.MODEL_EXCHANGE_TYPE: {
				ModelExchangeType modelExchangeType = (ModelExchangeType)theEObject;
				T result = caseModelExchangeType(modelExchangeType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.MODEL_STRUCTURE_TYPE: {
				ModelStructureType modelStructureType = (ModelStructureType)theEObject;
				T result = caseModelStructureType(modelStructureType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.MODEL_VARIABLES_TYPE: {
				ModelVariablesType modelVariablesType = (ModelVariablesType)theEObject;
				T result = caseModelVariablesType(modelVariablesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.REAL_TYPE: {
				RealType realType = (RealType)theEObject;
				T result = caseRealType(realType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.REAL_TYPE1: {
				RealType1 realType1 = (RealType1)theEObject;
				T result = caseRealType1(realType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.SOURCE_FILES_TYPE: {
				SourceFilesType sourceFilesType = (SourceFilesType)theEObject;
				T result = caseSourceFilesType(sourceFilesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.SOURCE_FILES_TYPE1: {
				SourceFilesType1 sourceFilesType1 = (SourceFilesType1)theEObject;
				T result = caseSourceFilesType1(sourceFilesType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.STRING_TYPE: {
				StringType stringType = (StringType)theEObject;
				T result = caseStringType(stringType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.TOOL_TYPE: {
				ToolType toolType = (ToolType)theEObject;
				T result = caseToolType(toolType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.TYPE_DEFINITIONS_TYPE: {
				TypeDefinitionsType typeDefinitionsType = (TypeDefinitionsType)theEObject;
				T result = caseTypeDefinitionsType(typeDefinitionsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.UNIT_DEFINITIONS_TYPE: {
				UnitDefinitionsType unitDefinitionsType = (UnitDefinitionsType)theEObject;
				T result = caseUnitDefinitionsType(unitDefinitionsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.UNKNOWN_TYPE: {
				UnknownType unknownType = (UnknownType)theEObject;
				T result = caseUnknownType(unknownType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmiPackage.UNKNOWN_TYPE1: {
				UnknownType1 unknownType1 = (UnknownType1)theEObject;
				T result = caseUnknownType1(unknownType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Unit Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Unit Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseUnitType(BaseUnitType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanType(BooleanType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Category Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Category Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCategoryType(CategoryType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Co Simulation Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Co Simulation Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoSimulationType(CoSimulationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Experiment Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Experiment Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultExperimentType(DefaultExperimentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Display Unit Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Display Unit Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDisplayUnitType(DisplayUnitType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentRoot(DocumentRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationType(EnumerationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationType1(EnumerationType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileType(FileType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileType1(FileType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fmi2 Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fmi2 Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFmi2Annotation(Fmi2Annotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fmi2 Scalar Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fmi2 Scalar Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFmi2ScalarVariable(Fmi2ScalarVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fmi2 Simple Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fmi2 Simple Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFmi2SimpleType(Fmi2SimpleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fmi2 Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fmi2 Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFmi2Unit(Fmi2Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fmi2 Variable Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fmi2 Variable Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFmi2VariableDependency(Fmi2VariableDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Description Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Description Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFmiModelDescriptionType(FmiModelDescriptionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Initial Unknowns Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Initial Unknowns Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInitialUnknownsType(InitialUnknownsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerType(IntegerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerType1(IntegerType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Item Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Item Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseItemType(ItemType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Log Categories Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Log Categories Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogCategoriesType(LogCategoriesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Exchange Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Exchange Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelExchangeType(ModelExchangeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Structure Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Structure Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelStructureType(ModelStructureType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Variables Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Variables Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelVariablesType(ModelVariablesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealType(RealType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealType1(RealType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Files Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Files Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceFilesType(SourceFilesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Files Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Files Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceFilesType1(SourceFilesType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringType(StringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tool Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tool Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToolType(ToolType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Definitions Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Definitions Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeDefinitionsType(TypeDefinitionsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Definitions Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Definitions Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitDefinitionsType(UnitDefinitionsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unknown Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unknown Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnknownType(UnknownType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unknown Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unknown Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnknownType1(UnknownType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //FmiSwitch
