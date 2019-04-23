/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
 *  David LOPEZ BETANCUR (CEA LIST)
 *  Sebastien REVOL (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.xygraph.common.ui;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.AbstractPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IEditorModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.ui.extension.diagrameditor.EditorDescriptor;
import org.eclipse.papyrus.infra.ui.extension.diagrameditor.IPluggableEditorFactory;
import org.eclipse.papyrus.infra.ui.multidiagram.actionbarcontributor.ActionBarContributorRegistry;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphCoordinator;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;
import org.eclipse.papyrus.moka.xygraph.common.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorActionBarContributor;

public abstract class AbstractXYGraphPageFactory implements IPluggableEditorFactory{

	protected ServicesRegistry servicesRegistry;
	protected EditorDescriptor editorDescriptor;
	private Image iconImage;
	
	@Override
	public boolean isPageModelFactoryFor(Object pageIdentifier) {
		return pageIdentifier instanceof XYGraphDescriptor;
	}

	@Override
	public void init(ServicesRegistry serviceRegistry, EditorDescriptor editorDescriptor) {
		this.editorDescriptor = editorDescriptor;
		this.servicesRegistry = serviceRegistry;
	}
	
	protected Image getTabIcon(){
		if( iconImage == null ){
			try {
				InputStream imgStream;
				imgStream = Activator.getDefault().getBundle().getEntry("/icons/full/obj16/xygraph16.gif").openStream();
				
				Image image = new Image(Display.getCurrent(), imgStream);
				iconImage = image;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return iconImage;
	}

	@Override
	public IPageModel createIPageModel(Object pageIdentifier) {
		XYGraphLabelProvider lblProv = new XYGraphLabelProvider(getTabIcon());
		XYGraphCoordinator coordinator = getXYGraphCoordinator((XYGraphDescriptor) pageIdentifier);
		
		return new XYGraphEditorModel(lblProv, coordinator);
	}
	
	class XYGraphEditorModel extends AbstractPageModel implements IEditorModel{

		private XYGraphCoordinator coordinator;
		private XYGraphLabelProvider lblProvider;
		
		public XYGraphEditorModel( XYGraphLabelProvider lblProvider, XYGraphCoordinator coordinator ) {
			super(lblProvider);
			this.coordinator  = coordinator;
			this.lblProvider = lblProvider;
		}

		@Override
		public Object getRawModel() {
			return coordinator.getXYGraphDescriptor();
		}

		@Override
		public void dispose() {
			coordinator.dispose();
		}

		@Override
		public IEditorPart createIEditorPart() throws PartInitException {
			return new XYGraphEditorPart(coordinator, lblProvider);
		}

		@Override
		public EditorActionBarContributor getActionBarContributor() {
			String actionBarId =  editorDescriptor.getActionBarContributorId();
			
			if( actionBarId == null || actionBarId.length() == 0 )
				return null;
			
			ActionBarContributorRegistry registry;
			try {
				registry = servicesRegistry.getService(ActionBarContributorRegistry.class);
			} catch (ServiceException e) {
				// Service not found
				Activator.log.error(e);
				return null;
			}

			try {
				return registry.getActionBarContributor(actionBarId);
			} catch (BackboneException e) {
				Activator.log.error(e);
				return null;
			}
		}
	}
	
	public abstract XYGraphCoordinator getXYGraphCoordinator(XYGraphDescriptor model);
}
