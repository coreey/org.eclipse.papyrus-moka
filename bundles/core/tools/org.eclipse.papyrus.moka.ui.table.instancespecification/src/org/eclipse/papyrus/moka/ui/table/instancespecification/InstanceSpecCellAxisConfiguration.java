/*****************************************************************************
 * 
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.table.instancespecification;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.painter.cell.TextPainter;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.celleditor.config.ICellAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.moka.ui.table.instancespecification.util.InstanceSpecificationTableUtil;
import org.eclipse.papyrus.uml.nattable.xtext.valuespecification.celleditor.ValueSpecificationCellEditor;
import org.eclipse.uml2.uml.UMLPackage;

public class InstanceSpecCellAxisConfiguration implements ICellAxisConfiguration {

	public static final String INSTANCE_SPEC_CELL_EDITOR_CONFIGURATION_ID = "org.eclipse.papyrus.moka.ui.table.instancespecification.editor.configuration.id";

	@Override
	public String getConfigurationId() {
		return INSTANCE_SPEC_CELL_EDITOR_CONFIGURATION_ID;
	}

	@Override
	public String getConfigurationDescription() {
		return "";
	}

	@Override
	public boolean handles(Table table, Object axisElement) {
		
		TableConfiguration config = table.getTableConfiguration();
		if (config != null && InstanceSpecificationTableUtil.INSTANCE_SPEC_TABLE_TYPE.equals(config.getType())) {
			if (axisElement instanceof EStructuralFeature) {
				return UMLPackage.Literals.VALUE_SPECIFICATION.equals(((EStructuralFeature)axisElement).getEType());
			}
		
		}
		
		return false;
	}

	@Override
	public void configureCellEditor(IConfigRegistry configRegistry, Object axis, String configLabel) {
		final INattableModelManager modelManager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
		final Table table = modelManager.getTable();
		
		configRegistry.registerConfigAttribute(EditConfigAttributes.CELL_EDITOR,new ValueSpecificationCellEditor(table, axis, modelManager.getTableAxisElementProvider()), DisplayMode.EDIT, configLabel);
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, new TextPainter(), DisplayMode.EDIT, configLabel);
		configRegistry.registerConfigAttribute(CellConfigAttributes.DISPLAY_CONVERTER, null, DisplayMode.EDIT, configLabel);
	}

}
