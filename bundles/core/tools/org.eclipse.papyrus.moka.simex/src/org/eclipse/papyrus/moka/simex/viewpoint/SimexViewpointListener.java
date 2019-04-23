/*****************************************************************************
 * 
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
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.simex.viewpoint;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.infra.architecture.listeners.IArchitectureDescriptionListener;
import org.eclipse.papyrus.infra.gmfdiag.dnd.policy.DropStrategyManager;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.DropStrategy;
import org.eclipse.papyrus.moka.simex.dnd.strategy.AbstractDropInActivityStrategy;

public class SimexViewpointListener implements IArchitectureDescriptionListener {

	// The architecture context ID
	private static final String SIMEX_ARCHITECTURE_FRAMEWORK = "Simex";
	
	// Is the architecture context enabled
	protected boolean isActive;
	
	// Drop strategies to be restored when the architecture context is left
	private List<DropStrategy> dropStrategiesToRestore;
	
	public SimexViewpointListener() {
		this.isActive = false;
		this.dropStrategiesToRestore = new ArrayList<DropStrategy>();
		this.init();
	}
	
	private void init(){
		// Every strategy that shall not be active in the current architecture context
		// is registered in the list of strategies to be restored. These strategies will
		// be restored when the current architecture context is left.
		for(DropStrategy strategy: DropStrategyManager.instance.getAllStrategies()){
			if(!this.shouldBeActivated(strategy)) {
				this.dropStrategiesToRestore.add(strategy);
			}
		}
		this.configureDndStrategies();
	}
	
	@Override
	public void architectureContextChanged(Notification notification) {
		// If the new architecture context is SIMEX and it is not already
		// enabled then drop strategies that are specific to this architecture
		// context are enabled. Conversely, if SIMEX architecture context is left
		// then additional drop strategies are disabled.
		final String architectureContext = notification.getNewStringValue();
		if(architectureContext.equals(SIMEX_ARCHITECTURE_FRAMEWORK)) {
			if(!this.isActive) {
				this.configureDndStrategies();
				this.isActive = true;
			}
		}else {
			this.restoreDndStrategies();
			this.isActive = false;
		}
	}

	@Override
	public void architectureViewpointsChanged(Notification notification) {
		// TODO: enable filtering of available drop strategies based on the
		// viewpoints that are currently enabled in the Simex framework.
	}

	protected void restoreDndStrategies() {
		// Any strategy that is not referenced in the list of strategies to be restored
		// is disabled. Conversely, any strategy owned by this list is enabled.
		if (dropStrategiesToRestore != null) {
			for (DropStrategy strategy : DropStrategyManager.instance.getAllStrategies()){
				if (dropStrategiesToRestore.contains(strategy)){
					DropStrategyManager.instance.setActive(strategy, true);
				}else {
					DropStrategyManager.instance.setActive(strategy, false);
				}
			}
		}
	}

	protected void configureDndStrategies() {
		// Any strategy that is referenced in the list of strategies to be restored
		// is disabled. Conversely, any strategy not owned by this list is enabled.
		// (exact mirror of restoreDndStrategies operation)
		if (dropStrategiesToRestore != null) {
			for (DropStrategy strategy : DropStrategyManager.instance.getAllStrategies()){
				if (!dropStrategiesToRestore.contains(strategy)){
					DropStrategyManager.instance.setActive(strategy, true);
				}else {
					DropStrategyManager.instance.setActive(strategy, false);
				}
			}
		}
	}

	protected boolean shouldBeActivated(DropStrategy strategy) {
		// If the ID of a strategy matches the SIMEX prefix then this means the strategy shall
		// be enabled in the current architecture context
		return strategy.getID().startsWith(AbstractDropInActivityStrategy.SIMEX_DROP_STRATEGY_PREFIX);
	}

}
