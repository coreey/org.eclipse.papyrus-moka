/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.debugtarget;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.debug.engine.IDebuggableExecutionEngine;
import org.eclipse.papyrus.moka.debug.engine.IDebuggableExecutionEngineThread;
import org.eclipse.papyrus.moka.utils.helper.semantics.SemanticHelper;

public class ExecutionEngineStackFrame extends ExecutionEngineDebugElement implements IStackFrame {

	/**
	 * The context thread for this stack frame
	 */
	protected IExecutionEngineThread thread;

	public ExecutionEngineStackFrame(IExecutionEngineThread t) {
		super(t.getDebugTarget());
		thread = t;
	}

	private IDebuggableExecutionEngine<?, ?> getExecutionEngine() {
		IExecutionEngineDebugTarget target = (IExecutionEngineDebugTarget) getDebugTarget();
		if (target != null) {
			return target.getExecutionEngine();
		}
		return null;
	}

	/**
	 * {@link IStackFrame#canStepInto()}
	 */
	@Override
	public boolean canStepInto() {
		return thread.canStepInto();
	}

	/**
	 * {@link IStackFrame#canStepOver()}
	 */
	@Override
	public boolean canStepOver() {
		return thread.canStepOver();
	}

	/**
	 * {@link IStackFrame#canStepReturn()}
	 */
	@Override
	public boolean canStepReturn() {
		return thread.canStepReturn();
	}

	/**
	 * {@link IStackFrame#isStepping()}
	 */
	@Override
	public boolean isStepping() {
		return thread.isStepping();
	}

	/**
	 * {@link IStackFrame#stepInto()}
	 */
	@Override
	public void stepInto() throws DebugException {
		thread.stepInto();
	}

	/**
	 * {@link IStackFrame#canStepOver()}
	 */
	@Override
	public void stepOver() throws DebugException {
		thread.stepOver();
	}

	/**
	 * {@link IStackFrame#stepReturn()}
	 */
	@Override
	public void stepReturn() throws DebugException {
		thread.stepReturn();
	}

	/**
	 * {@link IStackFrame#canResume())}
	 */
	@Override
	public boolean canResume() {
		return thread.canResume();
	}

	/**
	 * {@link IStackFrame#canSuspend()}
	 */
	@Override
	public boolean canSuspend() {
		return thread.canSuspend();
	}

	/**
	 * {@link IStackFrame#isSuspended()()}
	 */
	@Override
	public boolean isSuspended() {
		return thread.isSuspended();
	}

	/**
	 * {@link IStackFrame#resume()}
	 */
	@Override
	public void resume() throws DebugException {
		thread.resume();
	}

	/**
	 * {@link IStackFrame#suspend()}
	 */
	@Override
	public void suspend() throws DebugException {
		thread.suspend();
	}

	/**
	 * {@link IStackFrame#canTerminate()}
	 */
	@Override
	public boolean canTerminate() {
		return thread.canTerminate();
	}

	/**
	 * {@link IStackFrame#isTerminated()}
	 */
	@Override
	public boolean isTerminated() {
		return thread.isTerminated();
	}

	/**
	 * {@link IStackFrame#terminate()}
	 */
	@Override
	public void terminate() throws DebugException {
		thread.terminate();
	}

	/**
	 * {@link IStackFrame#getThread()}
	 */
	@Override
	public IThread getThread() {
		return thread;
	}

	/**
	 * {@link IStackFrame#getVariables()}
	 */
	@Override
	public IVariable[] getVariables() throws DebugException {
		IDebuggableExecutionEngine<?, ?> engine = getExecutionEngine();
		if (engine != null) {
			IDebuggableExecutionEngineThread<?, ?> debuggableThread = engine.getThread(thread.getID());
			if (debuggableThread != null) {
				return debuggableThread.getVariables(getDebugTarget()).toArray(new IVariable[0]);
			}
		}
		return new IVariable[0];
	}

	/**
	 * {@link IStackFrame#hasVariables()}
	 */
	@Override
	public boolean hasVariables() throws DebugException {
		IDebuggableExecutionEngine<?, ?> engine = getExecutionEngine();
		if (engine != null) {
			return engine.getThread(thread.getID()) != null;
		}
		return false;
	}

	/**
	 * {@link IStackFrame#getLineNumber()}
	 */
	@Override
	public int getLineNumber() throws DebugException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * {@link IStackFrame#getCharStart())}
	 */
	@Override
	public int getCharStart() throws DebugException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * {@link IStackFrame#getCharEnd()}
	 */
	@Override
	public int getCharEnd() throws DebugException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * {@link IStackFrame#getName()}
	 */
	@Override
	public String getName() throws DebugException {
		IDebuggableExecutionEngine<?, ?> engine = getExecutionEngine();
		if (engine != null) {
			IDebuggableExecutionEngineThread<?, ?> debuggableThread = engine.getThread(thread.getID());
			if(debuggableThread != null) {
				return SemanticHelper.getName(debuggableThread.getSuspensionContext());
			}
		}
		return null;
	}

	/**
	 * {@link IStackFrame#getRegisterGroups()}
	 */
	@Override
	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		return null;
	}

	/**
	 * {@link IStackFrame#hasRegisterGroups()}
	 */
	@Override
	public boolean hasRegisterGroups() throws DebugException {
		return false;
	}

}
