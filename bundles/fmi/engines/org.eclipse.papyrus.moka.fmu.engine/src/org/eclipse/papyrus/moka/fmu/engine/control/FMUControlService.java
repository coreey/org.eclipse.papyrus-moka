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
package org.eclipse.papyrus.moka.fmu.engine.control;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Semaphore;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.discreteevent.DEScheduler;
import org.eclipse.papyrus.moka.discreteevent.Event;
import org.eclipse.papyrus.moka.fmu.communication.FMUInterface;
import org.eclipse.papyrus.moka.fmu.engine.de.FMUStepEnd;
import org.eclipse.papyrus.moka.fmu.engine.semantics.FMUObject;
import org.eclipse.papyrus.moka.fmu.engine.utils.FMUEngineUtils;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.service.AbstractMokaService;
import org.eclipse.uml2.uml.Class;

public class FMUControlService extends AbstractMokaService implements FMUInterface {

	protected FMUObject fmuObject;
	protected Class fmuClass;
	protected Semaphore instantiationLock = new Semaphore(0);
	protected Semaphore stepLock = new Semaphore(0);
	protected Semaphore engineLock = new Semaphore(0);
	protected Semaphore terminationLock = new Semaphore(0);
	protected EngineStatus engineStatus = EngineStatus.NOT_STARTED ;

	public EngineStatus getEngineStatus() {
		return engineStatus;
	}

	@Override
	public void init(ILaunch launcher, EObject modelElement) {
		this.fmuClass = (Class) modelElement;
		this.instantiationLock = new Semaphore(0);
		this.stepLock = new Semaphore(0);
		this.engineLock = new Semaphore(0);
		this.terminationLock = new Semaphore(0);
		FMUEngineUtils.setFMUControlService(this);
	}

	public FMUObject getFmuObject() {
		return fmuObject;
	}

	public void setFmuObject(FMUObject fmuObject) {
		this.fmuObject = fmuObject;
	}

	public Class getFmuClass() {
		return fmuClass;
	}

	public void setFmuClass(Class fmuClass) {
		this.fmuClass = fmuClass;
	}

	public Semaphore getInstantiationLock() {
		return instantiationLock;
	}

	public Semaphore getStepLock() {
		return stepLock;
	}

	public Semaphore getEngineLock() {
		return engineLock;
	}

	public Semaphore getTerminationLock() {
		return terminationLock;
	}

	@Override
	public void init() {
		this.engineStatus = EngineStatus.INIT ;
		this.fmuObject.init();
		this.fmuObject.startBehavior(this.fmuClass, new ArrayList<IParameterValue>());
		FMUStepEnd stepEnd = new FMUStepEnd();
		DEScheduler.getInstance().pushEvent(new Event(0.0, stepEnd));
		Runnable deSchedulerRunnable = new Runnable() {
			@Override
			public void run() {
				DEScheduler.getInstance().run();
			}
		};
		Thread deSchedulerThread = new Thread(deSchedulerRunnable);
		deSchedulerThread.start();
		try {
			stepLock.acquire();
		} catch (InterruptedException e) {
			// Activator.log.error(e);
		}
	}

	/**
	 * This method is supposed to be called by the java side of the FMU wrapper.
	 * 
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.moka.fmu.communication.FMUInterface#doStep(double,
	 *      double)
	 */
	@Override
	public void doStep(double currentCommunicationTime, double stepSize) {
		this.engineStatus = EngineStatus.STEPPING ;
		FMUStepEnd stepEnd = new FMUStepEnd();
		DEScheduler.getInstance().pushEvent(new Event(stepSize, stepEnd), currentCommunicationTime + stepSize);
		// unlocks the engine
		engineLock.release();
		// waits for completion of the step by the engine
		try {
			stepLock.acquire();
		} catch (InterruptedException e) {
			// Activator.log.error(e);
		}
	}

	/**
	 * This method is called by the FMU Wrapper. It unlocks the thread that
	 * launched the execution engine, in order to let it terminate.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.moka.fmu.communication.FMUInterface#terminate()
	 */
	@Override
	public void terminate() {
		// Unlocks the thread that launched the execution engine to let it
		// terminate
		engineLock.release();
		stepLock.release();
		terminationLock.release();
	}

	/**
	 * This method is called by the thread that launches the execution engine,
	 * so that the engine is not terminated before the master actually decides
	 * to do so.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.moka.fuml.debug.ControlDelegate#waitForTermination()
	 */
	// @Override
	public void waitForTermination() {
		// Locks until actual termination by the master (cf.
		// FMUControlDelegate.terminate() FIXME should if be freeInstance?)		
		try {
			terminationLock.acquire();
		} catch (InterruptedException e) {
			// Activator.log.error(e);
		}
	}

	@Override
	public void updateMaps() {
		this.fmuObject.updateMaps();
	}

	@Override
	public Map<Integer, Double> fmiGetReals() {
		return this.fmuObject.fmiGetReals();
	}

	@Override
	public Map<Integer, Integer> fmiGetIntegers() {
		return this.fmuObject.fmiGetIntegers();
	}

	@Override
	public Map<Integer, Boolean> fmiGetBools() {
		return this.fmuObject.fmiGetBools();
	}

	@Override
	public Map<Integer, String> fmiGetStrings() {
		return this.fmuObject.fmiGetStrings();
	}

	@Override
	public void fmiSetReals(Map<Integer, Double> realsMap) {
		this.fmuObject.fmiSetReals(realsMap);
	}

	@Override
	public void fmiSetIntegers(Map<Integer, Integer> integersMap) {
		this.fmuObject.fmiSetIntegers(integersMap);
	}

	@Override
	public void fmiSetBools(Map<Integer, Boolean> boolsMap) {
		this.fmuObject.fmiSetBools(boolsMap);
	}

	@Override
	public void fmiSetStrings(Map<Integer, String> stringsMap) {
		this.fmuObject.fmiSetStrings(stringsMap);
	}
}
