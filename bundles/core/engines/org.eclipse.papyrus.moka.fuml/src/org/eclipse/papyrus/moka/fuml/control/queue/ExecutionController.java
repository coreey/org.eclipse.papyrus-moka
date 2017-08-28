package org.eclipse.papyrus.moka.fuml.control.queue;

import org.eclipse.papyrus.moka.fuml.control.execution.RootExecution;

public class ExecutionController {

	// The manager is a singleton
	private static ExecutionController INSTANCE;
	
	private ExecutionController(){}
	
	protected ExecutionLoop executionLoop;
	
	public static ExecutionController getInstance(){
		// Instantiate the manager if required and return the
		// singleton instance 
		if(INSTANCE == null){
			INSTANCE = new ExecutionController();
		}
		return INSTANCE;
	}
	
	public void setExecutionLoop(ExecutionLoop loop) {
		this.executionLoop = loop;
	}
	
	public ExecutionLoop getExecutionLoop() {
		return this.executionLoop;
	}
	
	public void start(RootExecution rootExecution){
		if(this.executionLoop != null){
			this.executionLoop.start(rootExecution);
		}else {
			throw new RuntimeException("Execution loop cannot be null");
		}
	}
}
