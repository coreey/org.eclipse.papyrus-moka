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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.emf.nattable.provider.EMFEObjectHeaderLabelProvider;
import org.eclipse.papyrus.infra.nattable.manager.axis.CompositeAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.EObjectAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElementWrapper;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderCellContextElementWrapper;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.moka.ui.table.instancespecification.util.InstanceSpecificationTableUtil;
import org.eclipse.uml2.uml.Slot;

public class InstanceSpecificationTableHeaderLabelProvider extends EMFEObjectHeaderLabelProvider {

	@Override
	public boolean accept(Object element) {
		if (element instanceof ILabelProviderContextElementWrapper) {
			ILabelProviderContextElementWrapper context = (ILabelProviderContextElementWrapper) element;
			final IConfigRegistry configRegistry = context.getConfigRegistry();
			INattableModelManager manager = configRegistry.getConfigAttribute(
					NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL,
					NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
			
			if (manager != null && manager.getTable() != null && manager.getTable().getTableConfiguration() != null && InstanceSpecificationTableUtil.INSTANCE_SPEC_TABLE_TYPE.equals(manager.getTable().getTableConfiguration().getType())) {
				Object object = context.getObject();
				
				if (object instanceof IAxis) {
					object = ((IAxis) object).getElement();
				}
				
				return object instanceof Slot;
			}
			
			
		}
		return false;
	}

	@Override
	public String getText(Object element) {
		ILabelProviderContextElementWrapper context = (ILabelProviderContextElementWrapper) element;
		EObject object = (EObject) ((ILabelProviderContextElementWrapper) element).getObject();
		if (object instanceof EObjectAxis) {
			object = ((EObjectAxis) object).getElement();
		}
		final IConfigRegistry configRegistry = context.getConfigRegistry();

		if (object instanceof Slot) {
			Slot slot = (Slot) object;
			INattableModelManager manager = configRegistry.getConfigAttribute(
					NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL,
					NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
			String text = null;
			if (manager != null) {
				IAxisManager axisManager = manager.getRowAxisManager();
				InstanceSpecificationRowAxisManager instSpecAxisManager = null;
				if (axisManager instanceof InstanceSpecificationRowAxisManager) {
					instSpecAxisManager = (InstanceSpecificationRowAxisManager) axisManager;
				} else if (axisManager instanceof CompositeAxisManager) {
					instSpecAxisManager = (InstanceSpecificationRowAxisManager) ((CompositeAxisManager)axisManager).getAdapter(InstanceSpecificationRowAxisManager.class);
					
				}
				if (instSpecAxisManager != null) {
					Map<Slot, String> slotToNameMap = instSpecAxisManager.getSlotToNameMap();
					if (slotToNameMap != null) {
						text = slotToNameMap.get(slot);
						if (text != null) {
							return text;
						}

					}
				}

			}
		}

		final LabelProviderService serv = getLabelProviderService(configRegistry);
		ILabelProviderConfiguration conf = null;
		if (element instanceof LabelProviderCellContextElementWrapper) {
			conf = getLabelConfiguration((LabelProviderCellContextElementWrapper) element);
		}
		if (conf instanceof ObjectLabelProviderConfiguration
				&& !((ObjectLabelProviderConfiguration) conf).isDisplayLabel()) {
			return ""; //$NON-NLS-1$
		}
		return serv.getLabelProvider(object).getText(object);
	}

}
