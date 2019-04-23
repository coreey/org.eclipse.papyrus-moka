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
package org.eclipse.papyrus.moka.fmi.modeldescription;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage
 * @generated
 */
public interface FmiFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FmiFactory eINSTANCE = org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Base Unit Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base Unit Type</em>'.
	 * @generated
	 */
	BaseUnitType createBaseUnitType();

	/**
	 * Returns a new object of class '<em>Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Type</em>'.
	 * @generated
	 */
	BooleanType createBooleanType();

	/**
	 * Returns a new object of class '<em>Category Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Category Type</em>'.
	 * @generated
	 */
	CategoryType createCategoryType();

	/**
	 * Returns a new object of class '<em>Co Simulation Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Co Simulation Type</em>'.
	 * @generated
	 */
	CoSimulationType createCoSimulationType();

	/**
	 * Returns a new object of class '<em>Default Experiment Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Experiment Type</em>'.
	 * @generated
	 */
	DefaultExperimentType createDefaultExperimentType();

	/**
	 * Returns a new object of class '<em>Display Unit Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Display Unit Type</em>'.
	 * @generated
	 */
	DisplayUnitType createDisplayUnitType();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Enumeration Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Type</em>'.
	 * @generated
	 */
	EnumerationType createEnumerationType();

	/**
	 * Returns a new object of class '<em>Enumeration Type1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Type1</em>'.
	 * @generated
	 */
	EnumerationType1 createEnumerationType1();

	/**
	 * Returns a new object of class '<em>File Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Type</em>'.
	 * @generated
	 */
	FileType createFileType();

	/**
	 * Returns a new object of class '<em>File Type1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Type1</em>'.
	 * @generated
	 */
	FileType1 createFileType1();

	/**
	 * Returns a new object of class '<em>Fmi2 Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fmi2 Annotation</em>'.
	 * @generated
	 */
	Fmi2Annotation createFmi2Annotation();

	/**
	 * Returns a new object of class '<em>Fmi2 Scalar Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fmi2 Scalar Variable</em>'.
	 * @generated
	 */
	Fmi2ScalarVariable createFmi2ScalarVariable();

	/**
	 * Returns a new object of class '<em>Fmi2 Simple Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fmi2 Simple Type</em>'.
	 * @generated
	 */
	Fmi2SimpleType createFmi2SimpleType();

	/**
	 * Returns a new object of class '<em>Fmi2 Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fmi2 Unit</em>'.
	 * @generated
	 */
	Fmi2Unit createFmi2Unit();

	/**
	 * Returns a new object of class '<em>Fmi2 Variable Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fmi2 Variable Dependency</em>'.
	 * @generated
	 */
	Fmi2VariableDependency createFmi2VariableDependency();

	/**
	 * Returns a new object of class '<em>Model Description Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Description Type</em>'.
	 * @generated
	 */
	FmiModelDescriptionType createFmiModelDescriptionType();

	/**
	 * Returns a new object of class '<em>Initial Unknowns Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Initial Unknowns Type</em>'.
	 * @generated
	 */
	InitialUnknownsType createInitialUnknownsType();

	/**
	 * Returns a new object of class '<em>Integer Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Type</em>'.
	 * @generated
	 */
	IntegerType createIntegerType();

	/**
	 * Returns a new object of class '<em>Integer Type1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Type1</em>'.
	 * @generated
	 */
	IntegerType1 createIntegerType1();

	/**
	 * Returns a new object of class '<em>Item Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Item Type</em>'.
	 * @generated
	 */
	ItemType createItemType();

	/**
	 * Returns a new object of class '<em>Log Categories Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Log Categories Type</em>'.
	 * @generated
	 */
	LogCategoriesType createLogCategoriesType();

	/**
	 * Returns a new object of class '<em>Model Exchange Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Exchange Type</em>'.
	 * @generated
	 */
	ModelExchangeType createModelExchangeType();

	/**
	 * Returns a new object of class '<em>Model Structure Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Structure Type</em>'.
	 * @generated
	 */
	ModelStructureType createModelStructureType();

	/**
	 * Returns a new object of class '<em>Model Variables Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Variables Type</em>'.
	 * @generated
	 */
	ModelVariablesType createModelVariablesType();

	/**
	 * Returns a new object of class '<em>Real Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real Type</em>'.
	 * @generated
	 */
	RealType createRealType();

	/**
	 * Returns a new object of class '<em>Real Type1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real Type1</em>'.
	 * @generated
	 */
	RealType1 createRealType1();

	/**
	 * Returns a new object of class '<em>Source Files Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Files Type</em>'.
	 * @generated
	 */
	SourceFilesType createSourceFilesType();

	/**
	 * Returns a new object of class '<em>Source Files Type1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Files Type1</em>'.
	 * @generated
	 */
	SourceFilesType1 createSourceFilesType1();

	/**
	 * Returns a new object of class '<em>String Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Type</em>'.
	 * @generated
	 */
	StringType createStringType();

	/**
	 * Returns a new object of class '<em>Tool Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tool Type</em>'.
	 * @generated
	 */
	ToolType createToolType();

	/**
	 * Returns a new object of class '<em>Type Definitions Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Definitions Type</em>'.
	 * @generated
	 */
	TypeDefinitionsType createTypeDefinitionsType();

	/**
	 * Returns a new object of class '<em>Unit Definitions Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Definitions Type</em>'.
	 * @generated
	 */
	UnitDefinitionsType createUnitDefinitionsType();

	/**
	 * Returns a new object of class '<em>Unknown Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unknown Type</em>'.
	 * @generated
	 */
	UnknownType createUnknownType();

	/**
	 * Returns a new object of class '<em>Unknown Type1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unknown Type1</em>'.
	 * @generated
	 */
	UnknownType1 createUnknownType1();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FmiPackage getFmiPackage();

} //FmiFactory
