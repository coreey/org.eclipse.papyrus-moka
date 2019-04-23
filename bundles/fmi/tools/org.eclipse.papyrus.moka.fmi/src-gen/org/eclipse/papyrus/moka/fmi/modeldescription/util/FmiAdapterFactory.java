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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.moka.fmi.modeldescription.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage
 * @generated
 */
public class FmiAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FmiPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FmiAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = FmiPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FmiSwitch<Adapter> modelSwitch =
		new FmiSwitch<Adapter>() {
			@Override
			public Adapter caseBaseUnitType(BaseUnitType object) {
				return createBaseUnitTypeAdapter();
			}
			@Override
			public Adapter caseBooleanType(BooleanType object) {
				return createBooleanTypeAdapter();
			}
			@Override
			public Adapter caseCategoryType(CategoryType object) {
				return createCategoryTypeAdapter();
			}
			@Override
			public Adapter caseCoSimulationType(CoSimulationType object) {
				return createCoSimulationTypeAdapter();
			}
			@Override
			public Adapter caseDefaultExperimentType(DefaultExperimentType object) {
				return createDefaultExperimentTypeAdapter();
			}
			@Override
			public Adapter caseDisplayUnitType(DisplayUnitType object) {
				return createDisplayUnitTypeAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseEnumerationType(EnumerationType object) {
				return createEnumerationTypeAdapter();
			}
			@Override
			public Adapter caseEnumerationType1(EnumerationType1 object) {
				return createEnumerationType1Adapter();
			}
			@Override
			public Adapter caseFileType(FileType object) {
				return createFileTypeAdapter();
			}
			@Override
			public Adapter caseFileType1(FileType1 object) {
				return createFileType1Adapter();
			}
			@Override
			public Adapter caseFmi2Annotation(Fmi2Annotation object) {
				return createFmi2AnnotationAdapter();
			}
			@Override
			public Adapter caseFmi2ScalarVariable(Fmi2ScalarVariable object) {
				return createFmi2ScalarVariableAdapter();
			}
			@Override
			public Adapter caseFmi2SimpleType(Fmi2SimpleType object) {
				return createFmi2SimpleTypeAdapter();
			}
			@Override
			public Adapter caseFmi2Unit(Fmi2Unit object) {
				return createFmi2UnitAdapter();
			}
			@Override
			public Adapter caseFmi2VariableDependency(Fmi2VariableDependency object) {
				return createFmi2VariableDependencyAdapter();
			}
			@Override
			public Adapter caseFmiModelDescriptionType(FmiModelDescriptionType object) {
				return createFmiModelDescriptionTypeAdapter();
			}
			@Override
			public Adapter caseInitialUnknownsType(InitialUnknownsType object) {
				return createInitialUnknownsTypeAdapter();
			}
			@Override
			public Adapter caseIntegerType(IntegerType object) {
				return createIntegerTypeAdapter();
			}
			@Override
			public Adapter caseIntegerType1(IntegerType1 object) {
				return createIntegerType1Adapter();
			}
			@Override
			public Adapter caseItemType(ItemType object) {
				return createItemTypeAdapter();
			}
			@Override
			public Adapter caseLogCategoriesType(LogCategoriesType object) {
				return createLogCategoriesTypeAdapter();
			}
			@Override
			public Adapter caseModelExchangeType(ModelExchangeType object) {
				return createModelExchangeTypeAdapter();
			}
			@Override
			public Adapter caseModelStructureType(ModelStructureType object) {
				return createModelStructureTypeAdapter();
			}
			@Override
			public Adapter caseModelVariablesType(ModelVariablesType object) {
				return createModelVariablesTypeAdapter();
			}
			@Override
			public Adapter caseRealType(RealType object) {
				return createRealTypeAdapter();
			}
			@Override
			public Adapter caseRealType1(RealType1 object) {
				return createRealType1Adapter();
			}
			@Override
			public Adapter caseSourceFilesType(SourceFilesType object) {
				return createSourceFilesTypeAdapter();
			}
			@Override
			public Adapter caseSourceFilesType1(SourceFilesType1 object) {
				return createSourceFilesType1Adapter();
			}
			@Override
			public Adapter caseStringType(StringType object) {
				return createStringTypeAdapter();
			}
			@Override
			public Adapter caseToolType(ToolType object) {
				return createToolTypeAdapter();
			}
			@Override
			public Adapter caseTypeDefinitionsType(TypeDefinitionsType object) {
				return createTypeDefinitionsTypeAdapter();
			}
			@Override
			public Adapter caseUnitDefinitionsType(UnitDefinitionsType object) {
				return createUnitDefinitionsTypeAdapter();
			}
			@Override
			public Adapter caseUnknownType(UnknownType object) {
				return createUnknownTypeAdapter();
			}
			@Override
			public Adapter caseUnknownType1(UnknownType1 object) {
				return createUnknownType1Adapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType <em>Base Unit Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType
	 * @generated
	 */
	public Adapter createBaseUnitTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.BooleanType
	 * @generated
	 */
	public Adapter createBooleanTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CategoryType <em>Category Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CategoryType
	 * @generated
	 */
	public Adapter createCategoryTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType <em>Co Simulation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType
	 * @generated
	 */
	public Adapter createCoSimulationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType <em>Default Experiment Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType
	 * @generated
	 */
	public Adapter createDefaultExperimentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType <em>Display Unit Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType
	 * @generated
	 */
	public Adapter createDisplayUnitTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType <em>Enumeration Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType
	 * @generated
	 */
	public Adapter createEnumerationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType1 <em>Enumeration Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType1
	 * @generated
	 */
	public Adapter createEnumerationType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FileType <em>File Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FileType
	 * @generated
	 */
	public Adapter createFileTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FileType1 <em>File Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FileType1
	 * @generated
	 */
	public Adapter createFileType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Annotation <em>Fmi2 Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Annotation
	 * @generated
	 */
	public Adapter createFmi2AnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable <em>Fmi2 Scalar Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable
	 * @generated
	 */
	public Adapter createFmi2ScalarVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType <em>Fmi2 Simple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType
	 * @generated
	 */
	public Adapter createFmi2SimpleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit <em>Fmi2 Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit
	 * @generated
	 */
	public Adapter createFmi2UnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2VariableDependency <em>Fmi2 Variable Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2VariableDependency
	 * @generated
	 */
	public Adapter createFmi2VariableDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType <em>Model Description Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType
	 * @generated
	 */
	public Adapter createFmiModelDescriptionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.InitialUnknownsType <em>Initial Unknowns Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.InitialUnknownsType
	 * @generated
	 */
	public Adapter createInitialUnknownsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType <em>Integer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType
	 * @generated
	 */
	public Adapter createIntegerTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1 <em>Integer Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1
	 * @generated
	 */
	public Adapter createIntegerType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ItemType <em>Item Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ItemType
	 * @generated
	 */
	public Adapter createItemTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.LogCategoriesType <em>Log Categories Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.LogCategoriesType
	 * @generated
	 */
	public Adapter createLogCategoriesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType <em>Model Exchange Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType
	 * @generated
	 */
	public Adapter createModelExchangeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType <em>Model Structure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType
	 * @generated
	 */
	public Adapter createModelStructureTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelVariablesType <em>Model Variables Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelVariablesType
	 * @generated
	 */
	public Adapter createModelVariablesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType <em>Real Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType
	 * @generated
	 */
	public Adapter createRealTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType1 <em>Real Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType1
	 * @generated
	 */
	public Adapter createRealType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType <em>Source Files Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType
	 * @generated
	 */
	public Adapter createSourceFilesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType1 <em>Source Files Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType1
	 * @generated
	 */
	public Adapter createSourceFilesType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.StringType
	 * @generated
	 */
	public Adapter createStringTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ToolType <em>Tool Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ToolType
	 * @generated
	 */
	public Adapter createToolTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.TypeDefinitionsType <em>Type Definitions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.TypeDefinitionsType
	 * @generated
	 */
	public Adapter createTypeDefinitionsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnitDefinitionsType <em>Unit Definitions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.UnitDefinitionsType
	 * @generated
	 */
	public Adapter createUnitDefinitionsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType <em>Unknown Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType
	 * @generated
	 */
	public Adapter createUnknownTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1 <em>Unknown Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1
	 * @generated
	 */
	public Adapter createUnknownType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //FmiAdapterFactory
