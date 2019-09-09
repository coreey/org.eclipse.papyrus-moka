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
package org.eclipse.papyrus.moka.debug.service;

import static org.eclipse.papyrus.moka.kernel.IKernelPreferences.KERNEL_PREFERENCES_ID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.debug.core.DebugException;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.papyrus.moka.debug.engine.IDebuggableExecutionEngine;
import org.eclipse.papyrus.moka.debug.engine.IDebuggableExecutionEngineThread;
import org.eclipse.papyrus.moka.kernel.service.ExecutionEngineService;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

import static org.eclipse.papyrus.moka.kernel.process.IServerMqttPreferences.MQTT_SERVER_PORT;

public abstract class DebugService<T, C> extends ExecutionEngineService<IDebuggableExecutionEngine<T, C>>
		implements IDebugService<T, C> {

	/**
	 * Client enabling the debug service to pass messages to the debug target (if
	 * any)
	 */
	protected DebugServiceClient client;

	/**
	 * Flag specifying the need for the execution engine to be suspended
	 */
	protected boolean enginSuspendRequest;

	/**
	 * Lock ensuring safe access and update of suspension flag
	 */
	protected ReentrantLock engineSuspendRequestLock;

	/**
	 * Flag specifying the need for the execution engine to be terminated
	 */
	protected boolean engineTerminateRequest;

	/**
	 * Lock ensuring safe access and update of the terminate flag
	 */
	protected ReentrantLock engineTerminateRequestLock;

	/**
	 * Map specifying the need for the execution engine thread to be suspended
	 */
	protected Map<String, Boolean> threadSuspendRequest;

	/**
	 * Lock ensuring safe access and update to the suspend requests
	 */
	protected ReentrantLock threadSuspendRequestLock;

	/**
	 * List specifying the need for execution engine thread to be terminated
	 */
	protected List<String> threadTerminateRequest;

	/**
	 * Lock ensuring safe access and update to the terminate requests
	 */
	protected ReentrantLock threadTerminateRequestLock;

	protected ReentrantLock engineLock;

	protected Condition engineExecutionCondition;

	@Override
	public void init(IDebuggableExecutionEngine<T, C> engine) {
		super.init(engine);
		engineLock = new ReentrantLock(true);
		engineExecutionCondition = engineLock.newCondition();
		enginSuspendRequest = false;
		engineSuspendRequestLock = new ReentrantLock(true);
		engineTerminateRequest = false;
		engineTerminateRequestLock = new ReentrantLock();
		threadSuspendRequest = new HashMap<String, Boolean>();
		threadSuspendRequestLock = new ReentrantLock(true);
		threadTerminateRequest = new ArrayList<String>();
		threadTerminateRequestLock = new ReentrantLock(true);
		initClient();
	}

	private void initClient() {
		ScopedPreferenceStore store = new ScopedPreferenceStore(ConfigurationScope.INSTANCE, KERNEL_PREFERENCES_ID);
		String port = store.getString(MQTT_SERVER_PORT);
		client = new DebugServiceClient("tcp://localhost:" + port, "Debug Service Client", this);
		client.run();
	}

	protected boolean shouldEngineSuspend() {
		boolean flag = false;
		engineSuspendRequestLock.lock();
		flag = enginSuspendRequest;
		engineSuspendRequestLock.unlock();
		return flag;
	}

	protected boolean shouldEngineTerminate() {
		boolean flag = false;
		engineTerminateRequestLock.lock();
		flag = engineTerminateRequest;
		engineTerminateRequestLock.unlock();
		return flag;
	}

	@Override
	public void dispose(IDebuggableExecutionEngine<T, C> engine) {
		client.terminate();
		if (client.isConnected()) {
			try {
				client.disconnect();
			} catch (MqttException e) {
				e.printStackTrace();
			}
		}
		client = null;
	}

	/**
	 * Request the execution engine suspension
	 * 
	 * This operations intended to be called by the debug service client listener
	 * thread.
	 */
	@Override
	public boolean requestSuspendEngine() {
		engineSuspendRequestLock.lock();
		enginSuspendRequest = true;
		engineSuspendRequestLock.unlock();
		return true;
	}

	/**
	 * Suspend the execution engine that is attached to this service
	 * 
	 * This operation is intended to be called by the thread executing the execution
	 * engine. This thread will become suspended when it executes
	 * {@code engineExecutionCondition.await()}
	 */
	public void suspendEngine() {
		if (engine.canSuspend()) {
			engineSuspendRequestLock.lock();
			enginSuspendRequest = false;
			engineSuspendRequestLock.unlock();
			if (engine.canSuspend()) {
				try {
					engine.suspend();
				} catch (DebugException e) {
					e.printStackTrace();
				} finally {
					engineLock.lock();
					while (engine.isSuspended()) {
						try {
							engineExecutionCondition.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						} finally {
							engineLock.unlock();
						}
					}
					engineLock.unlock();
				}
			}
		}
	}

	/**
	 * Request the execution engine to be resumed
	 * 
	 * This operations intended to be called by the debug service client listener
	 * thread. Invocation of {engineExecutionCondition.signalAll()} will resume the
	 * execution engine thread.
	 */
	@Override
	public boolean requestResumeEngine() {
		if (engine.canResume()) {
			try {
				engine.resume();
			} catch (DebugException e) {
				e.printStackTrace();
			} finally {
				engineLock.lock();
				engineExecutionCondition.signalAll();
				engineLock.unlock();
			}
		}
		return false;
	}

	/**
	 * Request the execution engine termination
	 * 
	 * This operations intended to be called by the debug service client listener
	 * thread.
	 */
	@Override
	public boolean requestTerminateEngine() {
		engineTerminateRequestLock.lock();
		engineTerminateRequest = true;
		engineTerminateRequestLock.unlock();
		if (engine.isSuspended()) {
			requestResumeEngine();
		}
		return true;
	}

	/**
	 * Terminate the execution engine.
	 * 
	 * This operation is intended to be called by the thread executing the execution
	 * engine. This thread will become suspended when it executes
	 * {@code engine.terminate()}
	 */
	public void terminateEngine() {
		if (engine.canTerminate()) {
			engineTerminateRequestLock.lock();
			engineTerminateRequest = false;
			engineTerminateRequestLock.unlock();
			try {
				engine.terminate();
			} catch (DebugException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Request the suspension of a specific thread.
	 * 
	 * @param identifier the thread identifier
	 * 
	 *                   This operations intended to be called by the debug service
	 *                   client listener thread.
	 */
	@Override
	public boolean requestSuspendThread(String identifier) {
		threadSuspendRequestLock.lock();
		threadSuspendRequest.put(identifier, true);
		threadSuspendRequestLock.unlock();
		return true;
	}

	/**
	 * Suspend the thread in the execution engine
	 * 
	 * @param thread the thread to be suspended
	 * 
	 *               This operation is intended to be called by the thread executing
	 *               the execution engine. This thread will be suspended.
	 */
	public void suspendThread(IDebuggableExecutionEngineThread<T, C> thread) {
		engine.suspendThread(thread);
		if (engine.canSuspend()) {
			engineLock.lock();
			try {
				// Note - The execution engine has a single
				// execution thread. Hence, when a suspension
				// request is made for a one of the logical thread,
				// then the overall execution engine is suspended
				engineExecutionCondition.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				engineLock.unlock();
			}
		}
	}

	/**
	 * Request a specific thread to be resumed
	 * 
	 * @param identifier the thread identifier
	 * 
	 *                   This operations intended to be called by the debug service
	 *                   client listener thread.
	 */
	@Override
	public boolean requestResumeThread(String identifier) {
		boolean resumed = false;
		IDebuggableExecutionEngineThread<T, C> thread = engine.getThread(identifier);
		if (thread != null) {
			boolean shouldEngineResume = false;
			engine.resumeThread(thread);
			threadSuspendRequestLock.lock();
			threadSuspendRequest.put(thread.getID(), false);
			shouldEngineResume = shouldEngineResume(threadSuspendRequest);
			threadSuspendRequestLock.unlock();
			resumed = true;
			if (shouldEngineResume) {
				engineLock.lock();
				engineExecutionCondition.signalAll();
				engineLock.unlock();
			}
		}
		return resumed;
	}

	private static boolean shouldEngineResume(final Map<String, Boolean> suspendRequest) {
		return suspendRequest.entrySet().stream().noneMatch((e) -> e.getValue() == true);
	}

	/**
	 * Request a specific thread to be terminated
	 * 
	 * @param identifier the thread identifier
	 * 
	 *                   This operations intended to be called by the debug service
	 *                   client listener thread.
	 */
	@Override
	public boolean requestTerminateThread(String identifier) {
		boolean added = false;
		threadTerminateRequestLock.lock();
		if (!threadTerminateRequest.contains(identifier)) {
			added = threadTerminateRequest.add(identifier);
		}
		threadTerminateRequestLock.unlock();
		return added;
	}

	/**
	 * Terminate the thread in the execution engine
	 * 
	 * @param thread the thread to be terminated
	 * 
	 *               This operation is intended to be called by the thread executing
	 *               the execution engine. This thread will not be suspended.
	 */
	public void terminateThread(IDebuggableExecutionEngineThread<T, C> thread) {
		threadTerminateRequestLock.lock();
		if (threadTerminateRequest.contains(thread.getID())) {
			threadTerminateRequest.remove(thread.getID());
		}
		threadTerminateRequestLock.unlock();
		engine.terminateThread(thread);
	}

	@Override
	public void fireTerminateEngineEvent() {
		client.fireTerminateEngineEvent();
	}

}
