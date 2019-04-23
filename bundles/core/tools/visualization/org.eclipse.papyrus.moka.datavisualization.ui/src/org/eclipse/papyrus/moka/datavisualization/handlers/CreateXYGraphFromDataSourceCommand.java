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

package org.eclipse.papyrus.moka.datavisualization.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.ui.util.ServiceUtilsForIEvaluationContext;
import org.eclipse.papyrus.moka.datavisualization.profile.DataSource;
import org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries;
import org.eclipse.papyrus.moka.datavisualization.service.DataVisualizationService;
import org.eclipse.papyrus.moka.datavisualization.ui.GraphBuilderHelper;
import org.eclipse.papyrus.moka.xygraph.common.model.XYGraphDescriptorModel;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListSelectionDialog;

public class CreateXYGraphFromDataSourceCommand extends RecordingCommand {

	private IEvaluationContext evaluationContext;
	protected DataSource dataSource;
	
	public CreateXYGraphFromDataSourceCommand(TransactionalEditingDomain domain, DataSource dataSource,
			IEvaluationContext context) {
		super(domain);
		this.evaluationContext = context;
		this.dataSource = dataSource;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	protected void doExecute() {
		
		ListSelectionDialog ldg = new ListSelectionDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
				dataSource, new DataSeriesContentProvider(),
				new LabelSeriesContentProvider(), "Select the series");

		if (ldg.open() == Window.OK) {
			Object[] selected = ldg.getResult();

			List<ValueSeries> series = new ArrayList<ValueSeries>(selected.length);
			for (int i = 0; i < selected.length; i++)
				series.add((ValueSeries) selected[i]);
			
			//FIXME This should be done before calling this method
			DataVisualizationService.getInstance().fixDependencies(dataSource);
			
			try {
				XYGraphDescriptor desc = createDataValueSetGraph(ServiceUtilsForIEvaluationContext.getInstance().getModelSet(evaluationContext), series);
				desc.setDataSource(dataSource);
				
				final IPageManager pageMngr = ServiceUtilsForIEvaluationContext.getInstance()
						.getIPageManager(evaluationContext);
				pageMngr.openPage(desc);
			} catch (ServiceException | NotFoundException e) {
				e.printStackTrace();
			}
		}
		return;
	}

	class DataSeriesContentProvider implements IStructuredContentProvider{

		@Override
		public Object[] getElements(Object inputElement) {
			if( !(inputElement instanceof DataSource) )
				return null;
			
			DataSource set = (DataSource) inputElement;
			
			Object[] objects = new Object[set.getSeries().size()];
			int i = 0;
			for(ValueSeries serie : set.getSeries()){
				objects[i] = serie;
				i++;
			}
			
			return objects;
		}
		
	}
	
	class LabelSeriesContentProvider extends LabelProvider{
		@Override
		public String getText(Object element) {
			if( !(element instanceof ValueSeries) )
				return super.getText(element);
			
			ValueSeries serie = (ValueSeries) element;
			return serie.getBase_Property().getLabel();
		}
	}
	
	protected XYGraphDescriptor createDataValueSetGraph(ModelSet modelSet, List<ValueSeries> visibles) throws NotFoundException {
		final XYGraphDescriptor xyGraph = GraphBuilderHelper.buildFromSeries(dataSource, visibles);

		// Save the model in the associated resource
		final XYGraphDescriptorModel model = (XYGraphDescriptorModel) modelSet.getModelChecked(XYGraphDescriptorModel.MODEL_ID);
		xyGraph.setContext(dataSource.getBase_DataType().eContainer());
		model.addXYGraphDescriptor(xyGraph);
		
		return xyGraph;
	}
}