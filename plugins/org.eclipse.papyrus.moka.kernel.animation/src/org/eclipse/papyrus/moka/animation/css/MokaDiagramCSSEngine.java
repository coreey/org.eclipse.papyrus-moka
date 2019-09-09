/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
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
package org.eclipse.papyrus.moka.animation.css;

import java.util.Set;

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.PapyrusDiagramEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.DiagramHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.infra.gmfdiag.css.dom.GMFElementAdapter;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.DiagramCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.tools.util.PlatformHelper;
import org.w3c.dom.Element;

/**
 * This class specify the DiagramCSSEngine to be able to refresh only the
 * specified EditPart when the Moka simulation is running
 */
public class MokaDiagramCSSEngine extends DiagramCSSEngine implements IJobChangeListener {

	private static boolean isMokaProcessRunning = false;

	public MokaDiagramCSSEngine(ExtendedCSSEngine parent, CSSDiagram diagram) {
		super(parent, diagram);
	}

	/**
	 * {@inheritDoc}
	 *
	 * Handles a notification that an Element has changed.
	 *
	 * When a moka process is running only refresh the local edit part otherwise
	 * refresh every thing in the diagram
	 * 
	 */
	@Override
	public void notifyChange(Element elementAdapter) {
		if (isMokaProcessRunning) {
			resetCache(); // TODO: We should only refresh a subset of the cache

			Diagram diagram = PlatformHelper.getAdapter(elementAdapter, Diagram.class);
			Set<? extends DiagramEditPart> diagramEditParts = PapyrusDiagramEditPart.getDiagramEditPartsFor(diagram);

			if (!diagramEditParts.isEmpty()) {
				if (elementAdapter instanceof GMFElementAdapter) {
					GMFElementAdapter tmp = (GMFElementAdapter) elementAdapter;
					View notationElemntTorefresh = tmp.getNotationElement();
					EditPart editPart = DiagramEditPartsUtil.getEditPartFromView(notationElemntTorefresh,
							diagramEditParts.iterator().next());
					if (editPart instanceof IPrimaryEditPart) {

						DiagramHelper.asyncExec(diagramEditParts.iterator().next(), new Runnable() {

							@Override
							public void run() {
								DiagramHelper.refresh(editPart, true);
							}
						});
					}
				}
			} else {
				DiagramHelper.scheduleRefresh();
			}
		} else {
			super.notifyChange(elementAdapter);
		}
	}

	@Override
	public void aboutToRun(IJobChangeEvent event) {
		// nothing to do
	}

	@Override
	public void awake(IJobChangeEvent event) {
		// nothing to do
	}

	@Override
	public void done(IJobChangeEvent event) {
		isMokaProcessRunning = false;
	}

	@Override
	public void running(IJobChangeEvent event) {
		isMokaProcessRunning = true;
	}

	@Override
	public void scheduled(IJobChangeEvent event) {
		// nothing to do
	}

	@Override
	public void sleeping(IJobChangeEvent event) {
		// nothing to do
	}

}
