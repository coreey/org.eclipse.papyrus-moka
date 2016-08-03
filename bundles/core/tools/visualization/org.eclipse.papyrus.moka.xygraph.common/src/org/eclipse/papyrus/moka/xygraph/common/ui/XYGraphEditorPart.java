/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  David LOPEZ BETANCUR (CEA LIST)
 *  Sebastien REVOL (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.xygraph.common.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.nebula.visualization.xygraph.figures.IXYGraph;
import org.eclipse.nebula.visualization.xygraph.figures.ToolbarArmedXYGraph;
import org.eclipse.nebula.visualization.xygraph.figures.XYGraph;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphCoordinator;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.internal.part.NullEditorInput;
import org.eclipse.ui.part.EditorPart;

public class XYGraphEditorPart extends EditorPart implements PropertyChangeListener{

	private XYGraphCoordinator coordinator;
	private XYGraphLabelProvider lblProvider;

	private boolean dirty;
	
	public XYGraphEditorPart(XYGraphCoordinator coordinator, XYGraphLabelProvider lblProvider) {
		super();
		this.coordinator = coordinator;
		this.lblProvider = lblProvider;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		dirty = false;
	}

	@Override
	public void doSaveAs() {
		
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite( site );
		setInput( new NullEditorInput() );
		setPartName(this.coordinator.getXYGraphDescriptor().getTitle());
		
		site.setSelectionProvider(new XYGraphEditorPartSelectionProvider(this.coordinator.getXYGraphDescriptor()));
	}

	@Override
	public boolean isDirty() {
		return dirty;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	@Override
	public void createPartControl(Composite parent) {
		Canvas canvas = new Canvas(parent, SWT.NONE);
		
		LightweightSystem lws = new LightweightSystem(canvas);
		lws.setContents(buildGraphFromModel());
	}
	
	protected ToolbarArmedXYGraph buildGraphFromModel(){
		IXYGraph xyGraph = coordinator.buildXYGraph();
		xyGraph.addPropertyChangeListener(IXYGraph.PROPERTY_CONFIG, this);
		return new ToolbarArmedXYGraph(xyGraph);
	}

	@Override
	public void setFocus() {
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		XYGraphDescriptor gDesc = coordinator.getXYGraphDescriptor();
		gDesc.getContext();
		coordinator.updateDescriptors((XYGraph) evt.getNewValue());
		lblProvider.onGraphUpdated(gDesc);
		dirty = true;
	}
}
