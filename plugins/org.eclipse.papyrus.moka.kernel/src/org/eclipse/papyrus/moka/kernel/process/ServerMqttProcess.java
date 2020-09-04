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
package org.eclipse.papyrus.moka.kernel.process;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchesListener2;
import org.eclipse.debug.core.model.IStreamsProxy;

public class ServerMqttProcess extends BaseProcess<Process> implements ILaunchesListener2 {

	protected IOException exception;

	public ServerMqttProcess(ILaunch l) {
		super(l);
		exception = null;
		DebugPlugin.getDefault().getLaunchManager().addLaunchListener(this);
	}

	@Override
	public IStreamsProxy getStreamsProxy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getExitValue() throws DebugException {
		if (isTerminated()) {
			if (process == null) {
				return 2;
			} else {
				return process.exitValue();
			}
		}
		throw new DebugException(null);
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		// No adaptation is supported
		return null;
	}

	@Override
	public boolean canTerminate() {
		if (process != null) {
			return process.isAlive();
		}
		return false;
	}

	@Override
	public boolean isTerminated() {
		if (process != null) {
			return !process.isAlive();
		}
		return true;
	}

	@Override
	public void terminate() throws DebugException {
		if (process != null && process.isAlive()) {
			process.destroy();
			if (process.isAlive()) {
				process.destroyForcibly();
			}
			setStatus(MokaProcessStatus.TERMINATED);
		}
	}

	@Override
	public void run() {

		File serverExecutable = new File(MQTTServerConfig.getMQTTServerPath());
		if (serverExecutable.exists() && serverExecutable.isFile()) {
			ProcessBuilder builder = new ProcessBuilder().inheritIO();
			List<String> commands = new ArrayList<String>();
			commands.add(serverExecutable.getAbsolutePath());
			commands.add("-v");
			commands.add("-p");
			commands.add(MQTTServerConfig.getMQTTServerPort());
			builder.command(commands);
			try {
				process = builder.start();
			} catch (IOException e) {
				exception = e;
			} finally {
				if (process != null) {
					setStatus(MokaProcessStatus.RUNNING);
				} else {
					setStatus(MokaProcessStatus.TERMINATED);
				}
			}
		}
	}

	@Override
	public void launchesTerminated(ILaunch[] launches) {
		for (Iterator<ILaunch> it = Arrays.asList(launches).iterator(); it.hasNext();) {
			if (it.next().equals(launch)) {
				try {
					terminate();
				} catch (DebugException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public IOException getError() {
		return exception;
	}

	@Override
	public void launchesRemoved(ILaunch[] launches) {
		// Does nothing
	}

	@Override
	public void launchesAdded(ILaunch[] launches) {
		// Does nothing
	}

	@Override
	public void launchesChanged(ILaunch[] launches) {
		// Does nothing
	}

}
