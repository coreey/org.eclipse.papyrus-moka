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

	@Override
	public void init(ILaunch launcher, EObject modelElement) {
		// TODO : check that modelElement is instance of
		// org.eclipse.uml2.uml.Class, and has stereotype CS_FMU applied
		this.fmuClass = (Class) modelElement;

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
		this.fmuObject.init();
		this.fmuObject.startBehavior(this.fmuClass, new ArrayList<IParameterValue>());
		// FIXME Need to determine if we actually start at the end of the
		// initialization phase, or on the first doStep
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
		// TODO Do something with currentCommunicationTime and stepSize, in the
		// DEScheduler
		FMUStepEnd stepEnd = new FMUStepEnd();
		DEScheduler.getInstance().pushEvent(new Event(stepSize, stepEnd));
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
		// FMUControlDelegate.terminate() FIXME which should probably be
		// freeInstance)
		
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

	@Override
	public void nodeVisited(ISemanticVisitor nodeVisitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void nodeLeft(ISemanticVisitor nodeVisitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void valueCreated(IValue value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void valueDestroyed(IValue value) {
		// TODO Auto-generated method stub

	}

}