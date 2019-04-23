/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.debug.model.data.mapping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.debug.engine.IMokaThread;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugElement;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.model.data.mapping.variables.ExecutionContextVariableAdapter;
import org.eclipse.papyrus.moka.debug.model.data.mapping.variables.SuspensionPointVariableAdapter;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.utils.helper.semantics.SemanticHelper;

public class MokaStackFrame extends MokaDebugElement implements IStackFrame {

	protected IMokaThread owner;

	protected List<IVariable> variables;

	public MokaStackFrame(MokaDebugTarget debugTarget, IMokaThread thread) {
		super(debugTarget);
		this.owner = thread;
		this.variables = new ArrayList<IVariable>();
	}

	@Override
	public boolean canStepInto() {
		return this.owner.canStepInto();
	}

	@Override
	public boolean canStepOver() {
		return this.owner.canStepOver();
	}

	@Override
	public boolean canStepReturn() {
		return this.owner.canStepReturn();
	}

	@Override
	public boolean isStepping() {
		return this.owner.isStepping();
	}

	@Override
	public void stepInto() throws DebugException {
		this.owner.stepInto();
	}

	@Override
	public void stepOver() throws DebugException {
		this.owner.stepOver();
	}

	@Override
	public void stepReturn() throws DebugException {
		this.owner.stepReturn();
	}

	@Override
	public boolean canResume() {
		return this.owner.canResume();
	}

	@Override
	public boolean canSuspend() {
		return this.owner.canSuspend();
	}

	@Override
	public boolean isSuspended() {
		return this.owner.isSuspended();
	}

	@Override
	public void resume() throws DebugException {
		this.owner.resume();
	}

	@Override
	public void suspend() throws DebugException {
		this.owner.suspend();
	}

	@Override
	public boolean canTerminate() {
		return this.owner.canTerminate();
	}

	@Override
	public boolean isTerminated() {
		return this.owner.isTerminated();
	}

	@Override
	public void terminate() throws DebugException {
		this.owner.terminate();
	}

	@Override
	public IThread getThread() {
		return this.owner;
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		if (this.variables.isEmpty()) {
			this.variables.add(new ExecutionContextVariableAdapter(this.debugTarget, this.owner.getLogicalThread()));
			ISemanticVisitor visitor = this.owner.getSuspensionPoint();
			if (visitor != null) {
				this.variables.add(new SuspensionPointVariableAdapter(this.debugTarget, visitor));
			}
		}
		return variables.toArray(new IVariable[0]);
	}

	@Override
	public boolean hasVariables() throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLineNumber() throws DebugException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCharStart() throws DebugException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCharEnd() throws DebugException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() throws DebugException {
		return SemanticHelper.getName(this.owner.getSuspensionPoint());
	}

	@Override
	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasRegisterGroups() throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}

}
