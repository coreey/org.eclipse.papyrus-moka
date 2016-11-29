/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmi.master.fmuproxy;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Object;
import org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable;
import org.eclipse.papyrus.moka.fmi.master.fmilibrary.Fmi2CausalityType;
import org.eclipse.papyrus.moka.fmi.master.fmilibrary.Fmi2Parameters;
import org.eclipse.papyrus.moka.fmi.master.fmilibrary.Fmi2Port;
import org.eclipse.papyrus.moka.fmi.master.fmilibrary.Fmi2ScalarVariable;
import org.eclipse.papyrus.moka.fmi.master.fmilibrary.Fmi2VariableType;
import org.eclipse.papyrus.moka.fmi.master.jnr.JNRFMUInterface;
import org.eclipse.papyrus.moka.fmi.master.jnr.JNRFMUInterface.Fmi2Status;
import org.eclipse.papyrus.moka.fmi.master.jnr.JNRFMUInterface.Fmi2StatusKind;
import org.eclipse.papyrus.moka.fmi.master.jnr.JNRFMUInterface.Fmi2Type;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

import jnr.ffi.LibraryLoader;
import jnr.ffi.Memory;
import jnr.ffi.Pointer;
import jnr.ffi.Runtime;
import jnr.ffi.byref.DoubleByReference;
import jnr.ffi.byref.IntByReference;
import jnr.ffi.byref.PointerByReference;




public class Fmu2ProxyService extends CS_Object {

	public Fmi2Parameters parameters;

	public ArrayList<Fmi2Port> inputPorts = new ArrayList<Fmi2Port>();
	public ArrayList<Fmi2Port> outputPorts = new ArrayList<Fmi2Port>();
	public ArrayList<Fmi2ScalarVariable> variables = new ArrayList<Fmi2ScalarVariable>();


	public JNRFMUInterface jnrIf;
	private Pointer component = null;
	public Pointer fmuState = null;

	public Fmi2Status status = Fmi2Status.fmi2OK;

	private static final int INTEGER_GET_INDEX = 0;
	private static final int INTEGER_SET_INDEX = 1;
	private static final int REAL_GET_INDEX = 2;
	private static final int REAL_SET_INDEX = 3;
	private static final int STRING_GET_INDEX = 4;
	private static final int STRING_SET_INDEX = 5;
	private static final int BOOLEAN_GET_INDEX = 6;
	private static final int BOOLEAN_SET_INDEX = 7;


	@SuppressWarnings("unchecked")
	private ArrayList<Fmi2ScalarVariable>[] cacheableVariableArray = (ArrayList<Fmi2ScalarVariable>[]) Array.newInstance(ArrayList.class, 8);

	private Pointer[] valueReferenceArrays = new Pointer[8];
	private int[] numberOfValueReferencesArray = new int[8];

	private Pointer getRealValues = null;
	private Pointer setRealValues = null;
	
	private Pointer getIntValues = null;
	private Pointer setIntValues = null;

	//Boolean size is implementation defined, safer to rely on
	//jnr translation even if maybe slower than direct pointer
	private boolean[] getBoolValues = null;
	private boolean[] setBoolValues = null;

	//TODO see if it's possible to handle char* pointers
	//string translation seems to be tricky, safer to rely on JNR as well
	private String[] getStringValues = null;
	private String[] setStringValues = null;

	protected Map<Property, Fmi2ScalarVariable> property2VarialeMap = new HashMap<>();

	public void setComponent(Pointer component) {
		this.component = component;
	}

	public Pointer getComponent() {
		return component;
	}


	public Fmu2ProxyService(Class service) {
		this.addType(service);
		initialize();
	}

	public Fmi2ScalarVariable getVariable(Property p) {
		return this.property2VarialeMap.get(p);
	}

	private void initialize() {
		for (int index = 0; index < 8; index++) {
			cacheableVariableArray[index] = new ArrayList<Fmi2ScalarVariable>();
		}

		for (Property p : types.get(0).getOwnedAttributes()) {

			Stereotype st = null;
			for (EObject application : p.getStereotypeApplications()) {
				if (application instanceof ScalarVariable) {
					st = UMLUtil.getStereotype(application);
					break;
				}
			}

			if (st != null) {
				// String variableType = p.getType().getName();
				Fmi2ScalarVariable variable;
				if (p instanceof Port) {
					variable = new Fmi2Port(this, (Port) p, st);
					if (variable.getCausality().equals(Fmi2CausalityType.fmi2Output)) {
						outputPorts.add((Fmi2Port) variable);
					} else {
						inputPorts.add((Fmi2Port) variable);
					}
				} else {
					variable = new Fmi2ScalarVariable(this, p, st);
					this.property2VarialeMap.put(p, variable);
				}

				variables.add(variable);

				if (variable.getCausality().equals(Fmi2CausalityType.fmi2Input)) {

					switch (variable.getType()) {
					case Fmi2VariableType.fmi2Boolean:
						cacheableVariableArray[BOOLEAN_SET_INDEX].add(variable);
						break;
					case Fmi2VariableType.fmi2Integer:
						cacheableVariableArray[INTEGER_SET_INDEX].add(variable);
						break;
					case Fmi2VariableType.fmi2Real:
						cacheableVariableArray[REAL_SET_INDEX].add(variable);
						break;
					case Fmi2VariableType.fmi2String:
						cacheableVariableArray[STRING_SET_INDEX].add(variable);
					default:
						break;
					}

				} else if (variable.getCausality().equals(Fmi2CausalityType.fmi2Output)
				// || variable.getCausality().equals(Fmi2CausalityType.fmi2Parameter)
				// && !variable.getVariability().equals(Fmi2VariabilityType.fmi2Constant)
				) {

					switch (variable.getType()) {
					case Fmi2VariableType.fmi2Boolean:
						cacheableVariableArray[BOOLEAN_GET_INDEX].add(variable);
						break;
					case Fmi2VariableType.fmi2Integer:
						cacheableVariableArray[INTEGER_GET_INDEX].add(variable);
						break;
					case Fmi2VariableType.fmi2Real:
						cacheableVariableArray[REAL_GET_INDEX].add(variable);
						break;
					case Fmi2VariableType.fmi2String:
						cacheableVariableArray[STRING_GET_INDEX].add(variable);
					default:
						break;
					}
				}

			}
			
		}


		for (int cachedKind = 0; cachedKind < 8; cachedKind++) {
			intializeVRS(cachedKind, cacheableVariableArray[cachedKind]);
		}

		if (!cacheableVariableArray[BOOLEAN_GET_INDEX].isEmpty()) {
			getBoolValues = new boolean[cacheableVariableArray[BOOLEAN_GET_INDEX].size()];
		}
		if (!cacheableVariableArray[BOOLEAN_SET_INDEX].isEmpty()) {
			setBoolValues =  new boolean[cacheableVariableArray[BOOLEAN_SET_INDEX].size()];
		}
		if (!cacheableVariableArray[REAL_GET_INDEX].isEmpty()) {
			getRealValues = Memory.allocateDirect(Runtime.getSystemRuntime(),cacheableVariableArray[REAL_GET_INDEX].size()*Double.BYTES);
		}
		if (!cacheableVariableArray[REAL_SET_INDEX].isEmpty()) {
			setRealValues = Memory.allocateDirect(Runtime.getSystemRuntime(),cacheableVariableArray[REAL_SET_INDEX].size()*Double.BYTES);
		}
		if (!cacheableVariableArray[INTEGER_GET_INDEX].isEmpty()) {
			getIntValues = Memory.allocateDirect(Runtime.getSystemRuntime(),cacheableVariableArray[INTEGER_GET_INDEX].size()*Integer.BYTES);
		}
		if (!cacheableVariableArray[INTEGER_SET_INDEX].isEmpty()) {
			setIntValues =Memory.allocateDirect(Runtime.getSystemRuntime(),cacheableVariableArray[INTEGER_SET_INDEX].size()*Integer.BYTES);
		}
		if (!cacheableVariableArray[STRING_GET_INDEX].isEmpty()) {
			getStringValues = new String[cacheableVariableArray[STRING_GET_INDEX].size()];
		}
		if (!cacheableVariableArray[STRING_SET_INDEX].isEmpty()) {
			setStringValues = new String[cacheableVariableArray[STRING_SET_INDEX].size()];
		}



	}


	private void intializeVRS(int cachedKind, ArrayList<Fmi2ScalarVariable> cacheableVariables) {
		valueReferenceArrays[cachedKind] = Memory.allocateDirect(Runtime.getSystemRuntime(), cacheableVariables.size()*Integer.BYTES);
		for (int i = 0; i < cacheableVariables.size(); i++) {
			valueReferenceArrays[cachedKind].putInt(i*Integer.BYTES, (int) cacheableVariables.get(i).getValueReference());
		}
		numberOfValueReferencesArray[cachedKind] = cacheableVariables.size();
	}


	public void fetchGetCache() {

		if (!cacheableVariableArray[REAL_GET_INDEX].isEmpty()) {
			fetchRealCache();
		}
		if (!cacheableVariableArray[INTEGER_GET_INDEX].isEmpty()) {
			fetchIntegerCache();
		}
		if (!cacheableVariableArray[BOOLEAN_GET_INDEX].isEmpty()) {
			fetchBooleanCache();
		}
		if (!cacheableVariableArray[STRING_GET_INDEX].isEmpty()) {
			fetchStringCache();
		}

	}

	private void fetchStringCache() {
		jnrIf.fmi2GetString(component, valueReferenceArrays[STRING_GET_INDEX], numberOfValueReferencesArray[STRING_GET_INDEX], getStringValues);
		for (int i = 0; i < cacheableVariableArray[STRING_GET_INDEX].size(); i++) {
			Fmi2ScalarVariable variable = cacheableVariableArray[STRING_GET_INDEX].get(i);
			variable.setRuntimeValue(getStringValues[i]);
		}
	}

	private void fetchBooleanCache() {
		jnrIf.fmi2GetBoolean(component, valueReferenceArrays[BOOLEAN_GET_INDEX], numberOfValueReferencesArray[BOOLEAN_GET_INDEX], getBoolValues);
		for (int i = 0; i < cacheableVariableArray[BOOLEAN_GET_INDEX].size(); i++) {
			Fmi2ScalarVariable variable = cacheableVariableArray[BOOLEAN_GET_INDEX].get(i);
			variable.setRuntimeValue(getBoolValues[i]);
		}
	}


	private void fetchIntegerCache() {
		jnrIf.fmi2GetInteger(component, valueReferenceArrays[INTEGER_GET_INDEX], numberOfValueReferencesArray[INTEGER_GET_INDEX], getIntValues);
		for (int i = 0; i < cacheableVariableArray[INTEGER_GET_INDEX].size(); i++) {
			Fmi2ScalarVariable variable = cacheableVariableArray[INTEGER_GET_INDEX].get(i);
			variable.setRuntimeValue(getIntValues.getInt(i*Integer.BYTES));
		}

	}

	private void fetchRealCache() {
		 jnrIf.fmi2GetReal(component, valueReferenceArrays[REAL_GET_INDEX], numberOfValueReferencesArray[REAL_GET_INDEX], getRealValues);
		for (int i = 0; i < cacheableVariableArray[REAL_GET_INDEX].size(); i++) {
			Fmi2ScalarVariable variable = cacheableVariableArray[REAL_GET_INDEX].get(i);
			variable.setRuntimeValue(getRealValues.getDouble(i * Double.BYTES));
		}
	}





	public void flushSetCache() {
		if (!cacheableVariableArray[REAL_SET_INDEX].isEmpty()) {
			flushRealCache();
		}
		if (!cacheableVariableArray[INTEGER_SET_INDEX].isEmpty()) {
			flushIntegerCache();
		}
		if (!cacheableVariableArray[BOOLEAN_SET_INDEX].isEmpty()) {
			flushBooleanCache();
		}
		if (!cacheableVariableArray[STRING_SET_INDEX].isEmpty()) {
			flushStringCache();
		}
	}

	private void flushStringCache() {
		for (int i = 0; i < cacheableVariableArray[STRING_SET_INDEX].size(); i++) {
			Fmi2ScalarVariable variable = cacheableVariableArray[STRING_SET_INDEX].get(i);
			setStringValues[i] = (String) variable.getRuntimeValue();
		}
		jnrIf.fmi2SetString(component, valueReferenceArrays[STRING_SET_INDEX], numberOfValueReferencesArray[STRING_SET_INDEX], setStringValues);

	}


	private void flushBooleanCache() {
		for (int i = 0; i < cacheableVariableArray[BOOLEAN_SET_INDEX].size(); i++) {
			Fmi2ScalarVariable variable = cacheableVariableArray[BOOLEAN_SET_INDEX].get(i);
			setBoolValues[i] = (boolean) variable.getRuntimeValue();
		}
		jnrIf.fmi2SetBoolean(component, valueReferenceArrays[BOOLEAN_SET_INDEX], numberOfValueReferencesArray[BOOLEAN_SET_INDEX], setBoolValues);
	}


	private void flushIntegerCache() {
		for (int i = 0; i < cacheableVariableArray[INTEGER_SET_INDEX].size(); i++) {
			Fmi2ScalarVariable variable = cacheableVariableArray[INTEGER_SET_INDEX].get(i);
			setIntValues.putInt(i*Integer.BYTES,  (int) variable.getRuntimeValue());
		}
		jnrIf.fmi2SetInteger(component, valueReferenceArrays[INTEGER_SET_INDEX], numberOfValueReferencesArray[INTEGER_SET_INDEX], setIntValues);
	}


	private void flushRealCache() {
		
		for (int i = 0; i < cacheableVariableArray[REAL_SET_INDEX].size(); i++) {
			Fmi2ScalarVariable variable = cacheableVariableArray[REAL_SET_INDEX].get(i);
			setRealValues.putDouble(i*Double.BYTES,(double) variable.getRuntimeValue());
		}
		jnrIf.fmi2SetReal(component, valueReferenceArrays[REAL_SET_INDEX], numberOfValueReferencesArray[REAL_SET_INDEX], setRealValues);

	}


	public Fmi2Parameters getParameters() {
		return parameters;
	}

	public void setParameters(Fmi2Parameters parameters) {
		this.parameters = parameters;
		this.jnrIf = LibraryLoader.create(JNRFMUInterface.class).load(parameters.getDllPath());
	}


	public Fmi2Status fmi2Instantiate(Pointer callbacksPointer, boolean debug) {

		Pointer component = jnrIf.fmi2Instantiate(parameters.getModelIdentifier(), Fmi2Type.fmi2CoSimulation,
				parameters.getGuid(), "file:///" + parameters.getResourceFolder(), callbacksPointer, false, debug);

		if (component == null) {
			status = Fmi2Status.fmi2Error;
			// result.value = fmiStatus;
			throw new RuntimeException("Could not instantiate model.");
		} else {
			status = Fmi2Status.fmi2OK;
			setComponent(component);
		}

		return status;

	}

	public void fmi2Get(List<Fmi2ScalarVariable> variables) {
		for (Fmi2ScalarVariable variable : variables) {
			fmi2Get(variable);
		}
	}

	public void fmi2Get(Fmi2ScalarVariable variable) {
		int[] valueReferences = new int[1];
		valueReferences[0] = (int) variable.getValueReference();

		if (Fmi2VariableType.fmi2Boolean.equals(variable.getType())) {

			boolean[] values = new boolean[1];
			jnrIf.fmi2GetBoolean(component, valueReferences, 1, values);
			variable.setRuntimeValue(values[0]);

		} else if (Fmi2VariableType.fmi2Integer.equals(variable.getType())) {
			int[] values = new int[1];
			jnrIf.fmi2GetInteger(component, valueReferences, 1, values);
			variable.setRuntimeValue(values[0]);

		} else if (Fmi2VariableType.fmi2Real.equals(variable.getType())) {
			double[] values = new double[1];
			jnrIf.fmi2GetReal(component, valueReferences, 1, values);
			variable.setRuntimeValue(values[0]);

		} else if (Fmi2VariableType.fmi2String.equals(variable.getType())) {
			String[] values = new String[1];
			jnrIf.fmi2GetString(component, valueReferences, 1, values);
			variable.setRuntimeValue(values[0]);
		}

	}

	public void fmi2Set(List<Fmi2ScalarVariable> variables) {
		for (Fmi2ScalarVariable variable : variables) {
			fmi2Set(variable);
		}
	}

	public void fmi2Set(Fmi2ScalarVariable variable) {
		int[] valueReferences = new int[1];
		valueReferences[0] = (int) variable.getValueReference();

		if (Fmi2VariableType.fmi2Boolean.equals(variable.getType())) {
			jnrIf.fmi2SetBoolean(component, valueReferences, 1, new boolean[] { getBoolean(variable.getRuntimeValue()) });

		} else if (Fmi2VariableType.fmi2Integer.equals(variable.getType())) {
			jnrIf.fmi2SetInteger(component, valueReferences, 1, new int[] { getInteger(variable.getRuntimeValue()) });

		} else if (Fmi2VariableType.fmi2Real.equals(variable.getType())) {
			jnrIf.fmi2SetReal(component, valueReferences, 1, new double[] { getDouble(variable.getRuntimeValue()) });

		} else if (Fmi2VariableType.fmi2String.equals(variable.getType())) {
			jnrIf.fmi2SetString(component, valueReferences, 1, new String[] { getString(variable.getRuntimeValue()) });
		}

	}

	private boolean getBoolean(Object value) {
		if (value instanceof Boolean) {
			return (boolean) value;
		} else if (value instanceof String) {
			return Boolean.parseBoolean((String) value);
		} else if (value instanceof Number) {
			return ((Number) value).intValue() != 0;
		}
		return false;
	}


	private int getInteger(Object value) {
		if (value instanceof String) {
			return Integer.decode((String) value);
		} else if (value instanceof Number) {
			return ((Number) value).intValue();
		}
		return 0;
	}

	private double getDouble(Object value) {
		if (value instanceof String) {
			return Double.parseDouble((String) value);
		} else if (value instanceof Number) {
			return ((Number) value).doubleValue();
		}
		return 0.0;
	}

	private String getString(Object value) {
		return value.toString();
	}





	public JNRFMUInterface getJnrIf() {
		return jnrIf;
	}

	public Fmi2Status fmi2DoStep(double simulatedTime, double stepSize, boolean noSetPrior) {
		return jnrIf.fmi2DoStep(component, simulatedTime, stepSize, noSetPrior);
	}

	public void dispose() {
		// TODO: ensure that the DLL is disposed
		jnrIf = null;

	}


	public void fmi2FreeInstance() {
		jnrIf.fmi2FreeInstance(component);
	}


	public String fmi2GetTypesPlatform() {
		return jnrIf.fmi2GetTypesPlatform();
	}

	public String fmi2GetVersion() {
		return jnrIf.fmi2GetVersion();
	}

	public Fmi2Status fmi2SetDebugLogging(boolean loggingOn, int numberOfCategories, String categories[]) {
		return jnrIf.fmi2SetDebugLogging(component, loggingOn, numberOfCategories, categories);
	}

	public Fmi2Status fmi2SetupExperiment(boolean toleranceDefined, double tolerance, double startTime, boolean stopTimeDefined, double stopTime) {
		return jnrIf.fmi2SetupExperiment(component, toleranceDefined, tolerance, startTime, stopTimeDefined, stopTime);
	}

	public int fmi2EnterInitializationMode() {
		return jnrIf.fmi2EnterInitializationMode(component);
	}

	public Fmi2Status fmi2ExitInitializationMode() {
		return jnrIf.fmi2ExitInitializationMode(component);
	}

	public Fmi2Status fmi2Terminate() {
		return jnrIf.fmi2Terminate(component);
	}

	public Fmi2Status fmi2Reset() {
		return jnrIf.fmi2Reset(component);
	}



	public Fmi2Status fmi2GetFMUstate(PointerByReference state) {
		return jnrIf.fmi2GetFMUstate(component, state);
	}

	public Fmi2Status fmi2SetFMUstate(Pointer state) {
		return jnrIf.fmi2SetFMUstate(component, state);
	}

	public Fmi2Status fmi2FreeFMUstate(PointerByReference state) {
		return jnrIf.fmi2FreeFMUstate(component, state);
	}

	public Fmi2Status fmi2SerializedFMUstateSize(Pointer state, IntByReference stateSize) {
		return jnrIf.fmi2SerializedFMUstateSize(component, state, stateSize);
	}

	public Fmi2Status fmi2SerializeFMUstate(Pointer state, ByteBuffer serializedState, int serializedStateSize) {
		return jnrIf.fmi2SerializeFMUstate(component, state, serializedState, serializedStateSize);
	}

	public Fmi2Status fmi2DeSerializeFMUstate(ByteBuffer serializedState, int size, PointerByReference state) {
		return jnrIf.fmi2DeSerializeFMUstate(component, serializedState, size, state);
	}

	public Fmi2Status fmi2GetDirectionalDerivative(int unknownValueReferences[],
			int numberOfUnknowns, int knownValueReferences[],
			int numberOfKnowns, double knownDifferential[],
			double unknownDifferential[]) {

		return jnrIf.fmi2GetDirectionalDerivative(component, unknownValueReferences, numberOfUnknowns, knownValueReferences, numberOfKnowns, knownDifferential, unknownDifferential);
	}

	public Fmi2Status fmi2SetRealInputDerivatives(int valueReferences[],
			int numberOfValueReferences, int orders[], double values[]) {
		return jnrIf.fmi2SetRealInputDerivatives(component, valueReferences, numberOfValueReferences, orders, values);
	}


	public Fmi2Status fmi2GetRealOutputDerivatives(int valueReference[],
			int numberOfValueReferences, int order[], double values[]) {
		return jnrIf.fmi2GetRealOutputDerivatives(component, valueReference, numberOfValueReferences, order, values);
	}


	public Fmi2Status fmi2CancelStep() {
		return jnrIf.fmi2CancelStep(component);
	}

	public Fmi2Status fmi2GetStatus(Fmi2StatusKind kind, PointerByReference status) {
		return jnrIf.fmi2GetStatus(component, kind, status);
	}

	public Fmi2Status fmi2GetRealStatus(Fmi2StatusKind kind, DoubleByReference value) {
		return jnrIf.fmi2GetRealStatus(component, kind, value);
	}

	public Fmi2Status fmi2GetIntegerStatus(Fmi2StatusKind kind, IntByReference value) {
		return jnrIf.fmi2GetIntegerStatus(component, kind, value);
	}

	public Fmi2Status fmi2GetBooleanStatus(Fmi2StatusKind kind, IntByReference value) {
		return jnrIf.fmi2GetBooleanStatus(component, kind, value);
	}

	public Fmi2Status fmi2GetStringStatus(Fmi2StatusKind kind, String value) {
		return jnrIf.fmi2GetStringStatus(component, kind, value);
	}

}