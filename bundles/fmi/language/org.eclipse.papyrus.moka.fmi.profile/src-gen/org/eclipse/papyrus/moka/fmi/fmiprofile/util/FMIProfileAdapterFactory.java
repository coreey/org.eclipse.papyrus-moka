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
package org.eclipse.papyrus.moka.fmi.fmiprofile.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.moka.fmi.fmiprofile.*;

import org.eclipse.papyrus.sysml14.deprecatedelements.FlowPort;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage
 * @generated
 */
public class FMIProfileAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FMIProfilePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FMIProfileAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = FMIProfilePackage.eINSTANCE;
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
	protected FMIProfileSwitch<Adapter> modelSwitch =
		new FMIProfileSwitch<Adapter>() {
			@Override
			public Adapter caseFMU(FMU object) {
				return createFMUAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseAbstractVariable(AbstractVariable object) {
				return createAbstractVariableAdapter();
			}
			@Override
			public Adapter caseScalarVariable(ScalarVariable object) {
				return createScalarVariableAdapter();
			}
			@Override
			public Adapter caseLocal(Local object) {
				return createLocalAdapter();
			}
			@Override
			public Adapter caseCS_FMU(CS_FMU object) {
				return createCS_FMUAdapter();
			}
			@Override
			public Adapter caseME_FMU(ME_FMU object) {
				return createME_FMUAdapter();
			}
			@Override
			public Adapter caseFMIPort(FMIPort object) {
				return createFMIPortAdapter();
			}
			@Override
			public Adapter caseIndependent(Independent object) {
				return createIndependentAdapter();
			}
			@Override
			public Adapter caseUnknown(Unknown object) {
				return createUnknownAdapter();
			}
			@Override
			public Adapter caseOutputUnknown(OutputUnknown object) {
				return createOutputUnknownAdapter();
			}
			@Override
			public Adapter caseInitialUnknown(InitialUnknown object) {
				return createInitialUnknownAdapter();
			}
			@Override
			public Adapter caseDerivativeUnknown(DerivativeUnknown object) {
				return createDerivativeUnknownAdapter();
			}
			@Override
			public Adapter caseCS_Graph(CS_Graph object) {
				return createCS_GraphAdapter();
			}
			@Override
			public Adapter caseDerivativeDependency(DerivativeDependency object) {
				return createDerivativeDependencyAdapter();
			}
			@Override
			public Adapter caseOutputDependency(OutputDependency object) {
				return createOutputDependencyAdapter();
			}
			@Override
			public Adapter caseInitialUnknownDependency(InitialUnknownDependency object) {
				return createInitialUnknownDependencyAdapter();
			}
			@Override
			public Adapter caseCalculatedParameter(CalculatedParameter object) {
				return createCalculatedParameterAdapter();
			}
			@Override
			public Adapter casePort(Port object) {
				return createPortAdapter();
			}
			@Override
			public Adapter caseFlowPort(FlowPort object) {
				return createFlowPortAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMU <em>FMU</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMU
	 * @generated
	 */
	public Adapter createFMUAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.AbstractVariable <em>Abstract Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.AbstractVariable
	 * @generated
	 */
	public Adapter createAbstractVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable <em>Scalar Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable
	 * @generated
	 */
	public Adapter createScalarVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Local <em>Local</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.Local
	 * @generated
	 */
	public Adapter createLocalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU <em>CS FMU</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU
	 * @generated
	 */
	public Adapter createCS_FMUAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ME_FMU <em>ME FMU</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.ME_FMU
	 * @generated
	 */
	public Adapter createME_FMUAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.FMIPort <em>FMI Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIPort
	 * @generated
	 */
	public Adapter createFMIPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Independent <em>Independent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.Independent
	 * @generated
	 */
	public Adapter createIndependentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Unknown <em>Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.Unknown
	 * @generated
	 */
	public Adapter createUnknownAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.OutputUnknown <em>Output Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.OutputUnknown
	 * @generated
	 */
	public Adapter createOutputUnknownAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.InitialUnknown <em>Initial Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.InitialUnknown
	 * @generated
	 */
	public Adapter createInitialUnknownAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeUnknown <em>Derivative Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeUnknown
	 * @generated
	 */
	public Adapter createDerivativeUnknownAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph <em>CS Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CS_Graph
	 * @generated
	 */
	public Adapter createCS_GraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeDependency <em>Derivative Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeDependency
	 * @generated
	 */
	public Adapter createDerivativeDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.OutputDependency <em>Output Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.OutputDependency
	 * @generated
	 */
	public Adapter createOutputDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.InitialUnknownDependency <em>Initial Unknown Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.InitialUnknownDependency
	 * @generated
	 */
	public Adapter createInitialUnknownDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.CalculatedParameter <em>Calculated Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.CalculatedParameter
	 * @generated
	 */
	public Adapter createCalculatedParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.Port
	 * @generated
	 */
	public Adapter createPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.sysml14.deprecatedelements.FlowPort <em>Flow Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.sysml14.deprecatedelements.FlowPort
	 * @generated
	 */
	public Adapter createFlowPortAdapter() {
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

} //FMIProfileAdapterFactory
