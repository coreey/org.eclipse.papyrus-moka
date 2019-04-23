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
package org.eclipse.papyrus.moka.xygraph.common.writing;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.nebula.visualization.xygraph.figures.Trace;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphWidgetBinder;
import org.eclipse.papyrus.moka.xygraph.mapping.writing.TraceUpdateStrategy;
import org.eclipse.papyrus.moka.xygraph.model.reflection.TraceStructuralFeature;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor;


public class ResourceTraceUpdateStrategy extends ResourceBaseUpdateStrategy implements TraceUpdateStrategy {

	private TransactionalEditingDomain domain;
	private CompoundCommand cc;
	
	@Override
	public void updateTraceDescriptor(Trace trace, XYGraphWidgetBinder map) {
		TraceDescriptor tDesc = map.getDescriptorFor(trace);
		startTransactionalDomain(tDesc);
		updateAllFeatures(trace, map);
		commitUpdate();
	}

	private void startTransactionalDomain(TraceDescriptor tDesc){
		
		if( cc != null )
			return;
		
		cc = new CompoundCommand();
		domain = getTransactionalEditingDomain(tDesc.eContainer().eResource());
	}
	
	private void commitTransaction(){
		if( cc == null )
			return;
			
		if( cc.canExecute() )
			domain.getCommandStack().execute(cc);
		
		domain = null;
		cc = null;
	}
		
	@Override
	public <T> void updateTraceFeature(TraceDescriptor tDesc, TraceStructuralFeature field, T newValue) {
		startTransactionalDomain(tDesc);
		appendSetCommand(cc, domain, tDesc, field.getEStructuralFeature(), newValue);
	}

	@Override
	public void commitUpdate() {
		commitTransaction();
	}
}
