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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.moka.fmi.fmiprofile.*;

import org.eclipse.papyrus.sysml14.deprecatedelements.FlowPort;

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
 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage
 * @generated
 */
public class FMIProfileSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FMIProfilePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FMIProfileSwitch() {
		if (modelPackage == null) {
			modelPackage = FMIProfilePackage.eINSTANCE;
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
			case FMIProfilePackage.FMU: {
				FMU fmu = (FMU)theEObject;
				T result = caseFMU(fmu);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FMIProfilePackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseAbstractVariable(parameter);
				if (result == null) result = caseScalarVariable(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FMIProfilePackage.ABSTRACT_VARIABLE: {
				AbstractVariable abstractVariable = (AbstractVariable)theEObject;
				T result = caseAbstractVariable(abstractVariable);
				if (result == null) result = caseScalarVariable(abstractVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FMIProfilePackage.SCALAR_VARIABLE: {
				ScalarVariable scalarVariable = (ScalarVariable)theEObject;
				T result = caseScalarVariable(scalarVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FMIProfilePackage.LOCAL: {
				Local local = (Local)theEObject;
				T result = caseLocal(local);
				if (result == null) result = caseAbstractVariable(local);
				if (result == null) result = caseScalarVariable(local);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FMIProfilePackage.CS_FMU: {
				CS_FMU cS_FMU = (CS_FMU)theEObject;
				T result = caseCS_FMU(cS_FMU);
				if (result == null) result = caseFMU(cS_FMU);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FMIProfilePackage.ME_FMU: {
				ME_FMU mE_FMU = (ME_FMU)theEObject;
				T result = caseME_FMU(mE_FMU);
				if (result == null) result = caseFMU(mE_FMU);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FMIProfilePackage.FMI_PORT: {
				FMIPort fmiPort = (FMIPort)theEObject;
				T result = caseFMIPort(fmiPort);
				if (result == null) result = caseScalarVariable(fmiPort);
				if (result == null) result = caseFlowPort(fmiPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FMIProfilePackage.INDEPENDENT: {
				Independent independent = (Independent)theEObject;
				T result = caseIndependent(independent);
				if (result == null) result = caseAbstractVariable(independent);
				if (result == null) result = caseScalarVariable(independent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FMIProfilePackage.UNKNOWN: {
				Unknown unknown = (Unknown)theEObject;
				T result = caseUnknown(unknown);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FMIProfilePackage.OUTPUT_UNKNOWN: {
				OutputUnknown outputUnknown = (OutputUnknown)theEObject;
				T result = caseOutputUnknown(outputUnknown);
				if (result == null) result = caseUnknown(outputUnknown);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FMIProfilePackage.INITIAL_UNKNOWN: {
				InitialUnknown initialUnknown = (InitialUnknown)theEObject;
				T result = caseInitialUnknown(initialUnknown);
				if (result == null) result = caseUnknown(initialUnknown);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FMIProfilePackage.DERIVATIVE_UNKNOWN: {
				DerivativeUnknown derivativeUnknown = (DerivativeUnknown)theEObject;
				T result = caseDerivativeUnknown(derivativeUnknown);
				if (result == null) result = caseUnknown(derivativeUnknown);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FMIProfilePackage.CS_GRAPH: {
				CS_Graph cS_Graph = (CS_Graph)theEObject;
				T result = caseCS_Graph(cS_Graph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FMIProfilePackage.DERIVATIVE_DEPENDENCY: {
				DerivativeDependency derivativeDependency = (DerivativeDependency)theEObject;
				T result = caseDerivativeDependency(derivativeDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FMIProfilePackage.OUTPUT_DEPENDENCY: {
				OutputDependency outputDependency = (OutputDependency)theEObject;
				T result = caseOutputDependency(outputDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FMIProfilePackage.INITIAL_UNKNOWN_DEPENDENCY: {
				InitialUnknownDependency initialUnknownDependency = (InitialUnknownDependency)theEObject;
				T result = caseInitialUnknownDependency(initialUnknownDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FMIProfilePackage.CALCULATED_PARAMETER: {
				CalculatedParameter calculatedParameter = (CalculatedParameter)theEObject;
				T result = caseCalculatedParameter(calculatedParameter);
				if (result == null) result = caseAbstractVariable(calculatedParameter);
				if (result == null) result = caseScalarVariable(calculatedParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FMIProfilePackage.PORT: {
				Port port = (Port)theEObject;
				T result = casePort(port);
				if (result == null) result = caseFMIPort(port);
				if (result == null) result = caseScalarVariable(port);
				if (result == null) result = caseFlowPort(port);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FMU</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FMU</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFMU(FMU object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractVariable(AbstractVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scalar Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalar Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScalarVariable(ScalarVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocal(Local object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CS FMU</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CS FMU</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCS_FMU(CS_FMU object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ME FMU</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ME FMU</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseME_FMU(ME_FMU object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FMI Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FMI Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFMIPort(FMIPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Independent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Independent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndependent(Independent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unknown</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unknown</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnknown(Unknown object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Unknown</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Unknown</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputUnknown(OutputUnknown object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Initial Unknown</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Initial Unknown</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInitialUnknown(InitialUnknown object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Derivative Unknown</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Derivative Unknown</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDerivativeUnknown(DerivativeUnknown object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CS Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CS Graph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCS_Graph(CS_Graph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Derivative Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Derivative Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDerivativeDependency(DerivativeDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputDependency(OutputDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Initial Unknown Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Initial Unknown Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInitialUnknownDependency(InitialUnknownDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Calculated Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Calculated Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCalculatedParameter(CalculatedParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePort(Port object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowPort(FlowPort object) {
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

} //FMIProfileSwitch
