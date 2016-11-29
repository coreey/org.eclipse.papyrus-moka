/*****************************************************************************
 * 
  * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmi.master.jnr;

import java.nio.ByteBuffer;

import jnr.ffi.Pointer;
import jnr.ffi.annotations.IgnoreError;
import jnr.ffi.annotations.In;
import jnr.ffi.annotations.Out;
import jnr.ffi.byref.DoubleByReference;
import jnr.ffi.byref.IntByReference;
import jnr.ffi.byref.PointerByReference;
import jnr.ffi.types.size_t;

public interface JNRFMUInterface {


	public enum Fmi2Status {
		fmi2OK, fmi2Warning, fmi2Discard, fmi2Error, fmi2Fatal, fmi2Pending
	};

	public enum Fmi2Type {
		fmi2ModelExchange, fmi2CoSimulation
	};

	public enum Fmi2StatusKind {
		fmi2DoStepStatus, fmi2PendingStatus, fmi2LastSuccessfulTime, fmi2Terminated
	};


	@IgnoreError
	public Fmi2Status fmi2DoStep(@In Pointer pointer, @In double currentTime, @In double stepSize, @In boolean noSetPrior);
	

	public Pointer fmi2Instantiate(@In String instanceName, @In Fmi2Type fmuType, @In String fmuGUID,
			@In String fmuResourceLocation, Pointer callbacksPointer,
			@In boolean visible,@In boolean loggingOn);
	@IgnoreError
	public void fmi2FreeInstance(@In Pointer component);

	@IgnoreError
	public String fmi2GetTypesPlatform();
	@IgnoreError
	public String fmi2GetVersion();

	@IgnoreError
	public Fmi2Status fmi2SetDebugLogging(@In Pointer component, boolean loggingOn, @size_t int numberOfCategories, String categories[]);

	public Fmi2Status fmi2SetupExperiment(@In Pointer component, boolean toleranceDefined, double tolerance, double startTime, boolean stopTimeDefined, double stopTime);
	@IgnoreError
	public int fmi2EnterInitializationMode( Pointer component);
	@IgnoreError
	public Fmi2Status fmi2ExitInitializationMode(@In Pointer component);
	@IgnoreError
	public Fmi2Status fmi2Terminate(@In Pointer component);
	@IgnoreError
	public Fmi2Status fmi2Reset( @In Pointer component);
	@IgnoreError
	public Fmi2Status fmi2SetReal(@In Pointer pointer, @In int[] vr, @In @size_t int nvr, @In double[] values);
	@IgnoreError
	public Fmi2Status fmi2GetReal(@In Pointer pointer, @In int[] vr, @In @size_t int nvr, @Out double[] values);
	
	@IgnoreError
	public Fmi2Status fmi2SetReal(@In Pointer pointer, @In Pointer vr, @In @size_t int nvr, @In Pointer values);
	@IgnoreError
	public Fmi2Status fmi2GetReal(@In Pointer pointer,@In Pointer vr, @In @size_t int nvr, @In Pointer values);
	
	
	@IgnoreError
	public Fmi2Status fmi2GetInteger(@In Pointer pointer, @In int[] vr, @In @size_t int nvr, @In int[] values);
	@IgnoreError
	public Fmi2Status fmi2SetInteger(@In Pointer pointer, @In int[] vr, @In @size_t int nvr, @Out int[] values);
	
	@IgnoreError
	public Fmi2Status fmi2GetInteger(@In Pointer pointer, @In Pointer vr, @In @size_t int nvr, @In Pointer values);
	@IgnoreError
	public Fmi2Status fmi2SetInteger(@In Pointer pointer,@In Pointer vr, @In @size_t int nvr, @In Pointer values);
	
	
	@IgnoreError
	public Fmi2Status fmi2GetBoolean(@In Pointer pointer, @In int[] vr, @In @size_t int nvr, @In boolean[] values);
	@IgnoreError
	public Fmi2Status fmi2SetBoolean(@In Pointer pointer, @In int[] vr, @In @size_t int nvr, @Out boolean[] values);
	
	@IgnoreError
	public Fmi2Status fmi2GetBoolean(@In Pointer pointer, @In Pointer vr, @In @size_t int nvr, @In boolean[] values);
	@IgnoreError
	public Fmi2Status fmi2SetBoolean(@In Pointer pointer,@In Pointer vr, @In @size_t int nvr, @Out boolean[] values);
	
	@IgnoreError
	public Fmi2Status fmi2GetString(@In Pointer pointer, @In int[] vr, @In @size_t int nvr, @In String[] values);
	@IgnoreError
	public Fmi2Status fmi2SetString(@In Pointer pointer, @In int[] vr, @In @size_t int nvr, @Out String[] values);
	
	@IgnoreError
	public Fmi2Status fmi2GetString(@In Pointer pointer, @In Pointer vr, @In @size_t int nvr,  @In String[] values);
	@IgnoreError
	public Fmi2Status fmi2SetString(@In Pointer pointer,@In Pointer vr, @In @size_t int nvr,@Out String[] values);
	
	@IgnoreError
	public Fmi2Status fmi2GetFMUstate(@In Pointer component, @Out PointerByReference state);
	@IgnoreError
	public Fmi2Status fmi2SetFMUstate(@In Pointer component, Pointer state);
	@IgnoreError
	public Fmi2Status fmi2FreeFMUstate(@In Pointer component, PointerByReference state);
	@IgnoreError
	public Fmi2Status fmi2SerializedFMUstateSize(@In Pointer component, Pointer state, IntByReference stateSize);
	@IgnoreError
	public Fmi2Status fmi2SerializeFMUstate(@In Pointer component, Pointer state, @Out ByteBuffer serializedState, @size_t int serializedStateSize);
	@IgnoreError
	public Fmi2Status fmi2DeSerializeFMUstate(@In Pointer component, @In ByteBuffer serializedState, @size_t int size, PointerByReference state);
	@IgnoreError
	public Fmi2Status fmi2GetDirectionalDerivative(@In Pointer component, @In int unknownValueReferences[],
			@size_t int numberOfUnknowns, @In int knownValueReferences[],
			@size_t int numberOfKnowns, @In double knownDifferential[],
			@Out double unknownDifferential[]);
	@IgnoreError
	public Fmi2Status fmi2SetRealInputDerivatives(@In Pointer component, @In int valueReferences[],
			@size_t int numberOfValueReferences, @In int orders[], @In double values[]);
	@IgnoreError
	public Fmi2Status fmi2GetRealOutputDerivatives(@In Pointer component, @In int valueReference[],
			@size_t int numberOfValueReferences, @In int order[], @Out double values[]);
	@IgnoreError
	public Fmi2Status fmi2CancelStep(@In Pointer component);
	@IgnoreError
	public Fmi2Status fmi2GetStatus(@In Pointer component, @In Fmi2StatusKind kind, @Out PointerByReference status);
	@IgnoreError
	public Fmi2Status fmi2GetRealStatus(@In Pointer component, @In Fmi2StatusKind kind, @Out DoubleByReference value);
	@IgnoreError
	public Fmi2Status fmi2GetIntegerStatus(@In Pointer component, @In Fmi2StatusKind kind, @Out IntByReference value);
	@IgnoreError
	public Fmi2Status fmi2GetBooleanStatus(@In Pointer component, @In Fmi2StatusKind kind, @Out IntByReference value);
	@IgnoreError
	public Fmi2Status fmi2GetStringStatus(@In Pointer component, @In Fmi2StatusKind kind, @Out String value);

}
