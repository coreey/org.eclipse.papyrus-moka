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

import static org.eclipse.papyrus.moka.kernel.IKernelPreferences.KERNEL_PREFERENCES_ID;
import static org.eclipse.papyrus.moka.kernel.process.IServerMqttPreferences.MQTT_SERVER_PORT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.papyrus.moka.debug.engine.IDebuggableExecutionEngine;
import org.eclipse.papyrus.moka.debug.messages.ThreadRequest;
import org.eclipse.papyrus.moka.kernel.process.ExecutionEngineProcess;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

public class ExecutionEngineDebugTarget extends ExecutionEngineDebugElement implements IExecutionEngineDebugTarget {

	/**
	 * The debug target name
	 */
	private final static String DEBUG_TARGET_NAME = "UML Execution Engine Debug Target";

	/**
	 * Launch object from which this debug target was spawned
	 */
	protected ILaunch launch;

	/**
	 * The process on which the execution engine is running.
	 */
	protected ExecutionEngineProcess process;

	/**
	 * Client enabling the debug target to receive notifications from the execution
	 * engine
	 */
	protected ExecutionEngineDebugTargetClient client;

	/**
	 * Threads known by the debug target. These threads are those running at the
	 * execution engine
	 */
	protected Map<String, ExecutionEngineThread> threadMap;

	/**
	 * Lock ensuring safe access and modification to the thread map
	 */
	protected ReentrantLock threadLock;

	public ExecutionEngineDebugTarget(ILaunch l, ExecutionEngineProcess p) {
		super(null);
		launch = l;
		process = p;
		threadMap = new HashMap<String, ExecutionEngineThread>();
		threadLock = new ReentrantLock(true);
		status = DebugElementStatus.RUNNING;
		statusLock = new ReentrantLock(true);
		initClient();
		fireCreationEvent();
	}

	private void initClient() {
		ScopedPreferenceStore store = new ScopedPreferenceStore(ConfigurationScope.INSTANCE, KERNEL_PREFERENCES_ID);
		String port = store.getString(MQTT_SERVER_PORT);
		client = new ExecutionEngineDebugTargetClient("tcp://localhost:" + port, "Debug Target", this);
		client.run();
	}

	/**
	 * @see IExecutionEngineDebugTarget#getExecutionEngine()
	 */
	@Override
	public IDebuggableExecutionEngine<?, ?> getExecutionEngine() {
		if (process != null) {
			return (IDebuggableExecutionEngine<?, ?>) process.getExecutionEngine();
		}
		return null;
	}

	@Override
	public ILaunch getLaunch() {
		return launch;
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		return null;
	}

	@Override
	public boolean canResume() {
		return !isDisconnected() && isSuspended();
	}

	/**
	 * @see IDebugTarget#canSuspend()
	 * 
	 *      The debug target can only be suspended if it is not already suspended
	 */
	@Override
	public boolean canSuspend() {
		return !isDisconnected() && !isSuspended();
	}

	/**
	 * @see IDebugTarget#isSuspended()
	 * 
	 *      If the debug target is disconnected then it cannot be suspended. It is
	 *      considered as suspended when all debug target threads are also
	 *      suspended.
	 */
	@Override
	public boolean isSuspended() {
		boolean suspended = false;
		if (!isDisconnected()) {
			if (!threadLock.isHeldByCurrentThread()) {
				threadLock.lock();
			}
			Iterator<Map.Entry<String, ExecutionEngineThread>> it = threadMap.entrySet().iterator();
			suspended = it.hasNext();
			while (suspended && it.hasNext()) {
				suspended = suspended & it.next().getValue().isSuspended();
			}
			if (threadLock.isHeldByCurrentThread()) {
				threadLock.unlock();
			}
		}
		return suspended;
	}

	/**
	 * @see IDebugTarget#suspend()
	 * 
	 *      Suspend all threads that can be suspended.
	 * 
	 *      Suspend call always occurs as the result of a UI command (i.e., the user
	 *      hits the pause button in the debug UI).
	 */
	@Override
	public void suspend() throws DebugException {
		threadLock.lock();
		for (Map.Entry<String, ExecutionEngineThread> entry : threadMap.entrySet()) {
			if (entry.getValue().canSuspend()) {
				entry.getValue().suspend();
			}
		}
		threadLock.unlock();
	}

	/**
	 * @see ExecutionEngineDebugElement#getDebugTarget()
	 */
	@Override
	public IDebugTarget getDebugTarget() {
		return this;
	}

	/**
	 * @see IDebugTarget#resume()
	 * 
	 *      Resume call always occurs as the result of client request.
	 */
	@Override
	public void resume() throws DebugException {
		threadLock.lock();
		for (Map.Entry<String, ExecutionEngineThread> entry : threadMap.entrySet()) {
			if (entry.getValue().canResume()) {
				entry.getValue().resume();
			}
		}
		threadLock.unlock();
		setStatus(DebugElementStatus.RUNNING);
		fireResumeEvent(DebugEvent.CLIENT_REQUEST);
	}

	/**
	 * @see IDebugTarget#canTerminate()()
	 * 
	 *      A debug target can only be terminated if it is not already terminated.
	 *      Note that termination check also verifies if the debug target is
	 *      connected.
	 * 
	 * @return true if it can terminate and false otherwise
	 */
	@Override
	public boolean canTerminate() {
		return !isDisconnected() && (!isTerminated() | isSuspended());
	}

	/**
	 * @see IDebugTarget#isTerminated()
	 * 
	 *      A debug target can only be considered as terminated if it is connected
	 *      and all threads are terminated. Alternatively, if the debug target is
	 *      connected but has no thread then it is considered as terminated.
	 * 
	 * @return true if it is terminated and false otherwise
	 */
	@Override
	public boolean isTerminated() {
		boolean isTerminated = false;
		if (!isDisconnected()) {
			if (!threadLock.isHeldByCurrentThread()) {
				threadLock.lock();
			}
			Iterator<Map.Entry<String, ExecutionEngineThread>> it = threadMap.entrySet().iterator();
			isTerminated = !it.hasNext();
			while (isTerminated && it.hasNext()) {
				isTerminated = isTerminated & it.next().getValue().isTerminated();
			}
			if (threadLock.isHeldByCurrentThread()) {
				threadLock.unlock();
			}
		}
		return isTerminated;
	}

	/**
	 * @see IDebugTarget#terminate()
	 * 
	 *      Requests are sent to execution engine threads in order to make them to
	 *      terminate. Note that if the debug target is suspended then it is resumed
	 *      before termination. A call to this operation only occurs as a client
	 *      request (i.e., from the UI)
	 */
	@Override
	public void terminate() throws DebugException {
		if (isSuspended()) {
			resume();
		}
		if (!threadLock.isHeldByCurrentThread()) {
			threadLock.lock();
		}
		List<String> removed = new ArrayList<String>();
		for (Map.Entry<String, ExecutionEngineThread> entry : threadMap.entrySet()) {
			removed.add(entry.getKey());
			entry.getValue().terminate();
		}
		if (threadLock.isHeldByCurrentThread()) {
			threadLock.unlock();
		}
	}

	/**
	 * A call to this operation can only be performed by the debug target client as
	 * a response to a event describing the termination of the execution engine
	 * (i.e., the program being debugged)
	 */
	public void handleTargetTerminateEvent() {
		threadLock.lock();
		for (Map.Entry<String, ExecutionEngineThread> entry : threadMap.entrySet()) {
			ExecutionEngineThread thread = entry.getValue();
			thread.setStatus(DebugElementStatus.TERMINATED);
			thread.fireTerminateEvent();
		}
		threadMap.clear();
		threadLock.unlock();
		new Thread(new Runnable() {
			@Override
			public void run() {
				if (canDisconnect()) {
					try {
						disconnect();
					} catch (DebugException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		fireChangeEvent(DebugEvent.CONTENT);
	}

	/**
	 * The debug target can only be disconnected if it has a client and this later
	 * is connected
	 * 
	 * @return true if it can be disconnected and false otherwise
	 */
	@Override
	public boolean canDisconnect() {
		return client != null && client.isConnected();
	}

	/**
	 * Disconnect debug target client and requests UI to be updated accordingly
	 * (i.e., debug target state shall be updated)
	 */
	@Override
	public void disconnect() throws DebugException {
		if (isSuspended()) {
			resume();
		}
		client.terminate();
		if (!client.isConnected()) {
			threadLock.lock();
			threadMap.clear();
			threadLock.unlock();
			fireChangeEvent(DebugEvent.CONTENT);
		}
	}

	/**
	 * The debug target is considered as being disconnected if its client is
	 * disconnected
	 * 
	 * @return true if disconnected ; false otherwise
	 */
	@Override
	public boolean isDisconnected() {
		return client != null && !client.isConnected();
	}

	@Override
	public IProcess getProcess() {
		return process;
	}

	@Override
	public IThread[] getThreads() throws DebugException {
		IThread[] thread = null;
		threadLock.lock();
		thread = threadMap.values().toArray(new IExecutionEngineThread[] {});
		threadLock.unlock();
		return thread;
	}

	@Override
	public boolean hasThreads() throws DebugException {
		boolean hasThread = false;
		threadLock.lock();
		hasThread = !threadMap.isEmpty();
		threadLock.unlock();
		return hasThread;
	}

	public boolean hasSuspendedThreads() {
		boolean hasSuspendedThread = true;
		threadLock.lock();
		Iterator<ExecutionEngineThread> it = threadMap.values().iterator();
		while (!hasSuspendedThread && it.hasNext()) {
			hasSuspendedThread = it.next().getStatus().equals(DebugElementStatus.SUSPENDED);
		}
		threadLock.unlock();
		return hasSuspendedThread;
	}

	@Override
	public String getName() throws DebugException {
		return DEBUG_TARGET_NAME;
	}

	/**
	 * {@link IExecutionEngineDebugTarget#addThread(ExecutionEngineThread)}
	 */
	@Override
	public void handleTargetThreadCreateEvent(ThreadRequest request) {
		ExecutionEngineThread thread = getThread(request.getThreadId());
		if (thread == null) {
			thread = new ExecutionEngineThread(getDebugTarget());
			thread.setID(request.getThreadId());
			threadLock.lock();
			threadMap.put(request.getThreadId(), thread);
			threadLock.unlock();
			thread.fireCreationEvent();
			fireChangeEvent(DebugEvent.CONTENT);
		}
	}

	/**
	 * {@link IExecutionEngineDebugTarget#removeThread(ExecutionEngineThread)}
	 */
	@Override
	public void handleTargetThreadTerminateEvent(ThreadRequest request) {
		ExecutionEngineThread thread = getThread(request.getThreadId());
		if (thread != null) {
			threadLock.lock();
			threadMap.remove(thread.getID());
			threadLock.unlock();
			thread.fireTerminateEvent();
			fireChangeEvent(DebugEvent.CONTENT);
		}
	}

	/**
	 * {@link IExecutionEngineDebugTarget#getThread(String)}
	 */
	@Override
	public ExecutionEngineThread getThread(String threadId) {
		ExecutionEngineThread thread = null;
		threadLock.lock();
		thread = threadMap.get(threadId);
		threadLock.unlock();
		return thread;
	}

	/**
	 * {@link IExecutionEngineDebugTarget#getClient()}
	 */
	@Override
	public IExecutionEngineDebugTargetClient getClient() {
		return client;
	}

	@Override
	public void breakpointAdded(IBreakpoint breakpoint) {
		// TODO Auto-generated method stub

	}

	@Override
	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean supportsStorageRetrieval() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		// TODO Auto-generated method stub
		return false;
	}

}
