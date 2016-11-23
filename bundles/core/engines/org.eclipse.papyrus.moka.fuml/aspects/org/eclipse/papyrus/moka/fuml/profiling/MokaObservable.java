/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.profiling;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.service.IMokaExecutionListener;
import org.eclipse.papyrus.moka.service.IMokaService;
import org.eclipse.papyrus.moka.service.MokaServiceRegistry;

public abstract class MokaObservable {

	protected List<IMokaExecutionListener> listeners;

	public MokaObservable() {
		this.listeners = new ArrayList<IMokaExecutionListener>();
		this.initialize();
	}

	public void initialize() {
		// An observable is by default listened by any registered service
		// ADDED: An observable is by default listener by any registered service 
		// that implements IMokaExecutionListener
		for (IMokaService service : MokaServiceRegistry.getInstance().getAllServices()) {
			if( service instanceof IMokaExecutionListener )
				this.addListener( (IMokaExecutionListener)service);
		}
	}

	public void addListener(IMokaExecutionListener service) {
		this.listeners.add(service);
	}

	public void removeListener(IMokaExecutionListener service) {
		this.listeners.remove(service);
	}

	public void finalize() {
		this.listeners.clear();
	}
}
