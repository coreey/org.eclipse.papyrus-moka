package org.eclipse.papyrus.moka.engine.schedulable;

import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.kernel.scheduling.control.IExecutionController;

public interface IScheduledExecutionEngine extends IExecutionEngine {
	/**
	 * Instantiate and configure the controller in charge of the the execution
	 * engine task scheduling
	 * 
	 * @return the controller
	 */
	IExecutionController createController();

	/**
	 * get the controller in charge of the the execution engine task scheduling
	 * 
	 * @return the controller
	 */
	IExecutionController getController();
}
