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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.EStructuralFeatureAxis;
import org.eclipse.papyrus.infra.ui.converter.AbstractStringValueConverter;
import org.eclipse.papyrus.uml.nattable.xtext.valuespecification.manager.cell.ValueSpecificationCellManager;
import org.eclipse.uml2.uml.UMLPackage;

public class InstanceSpecificationTableCellManager extends ValueSpecificationCellManager {

	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.cell.EMFFeatureValueCellManager#getSetStringValueCommand(org.eclipse.emf.transaction.TransactionalEditingDomain,
	 *      java.lang.Object, java.lang.Object, java.lang.String,
	 *      org.eclipse.papyrus.infra.tools.converter.AbstractStringValueConverter,
	 *      org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 */
	@Override
	public Command getSetStringValueCommand(
			final TransactionalEditingDomain domain, final Object columnElement,
			final Object rowElement, final String newValue,
			final AbstractStringValueConverter valueSolver,
			final INattableModelManager tableManager) {
		
		//TODO understand why in super, rowElement instanceof EObjectAxis and not EObject. Probably linked to the AxisManager?
		if (columnElement instanceof EStructuralFeatureAxis && rowElement instanceof EObject || columnElement instanceof EObject && rowElement instanceof EStructuralFeatureAxis) {

			EStructuralFeature structuralFeature = null;
			if (columnElement instanceof EStructuralFeatureAxis) {
				structuralFeature = ((EStructuralFeatureAxis) columnElement).getElement();
			} else {
				structuralFeature = ((EStructuralFeatureAxis) rowElement).getElement();
			}

			if (UMLPackage.Literals.VALUE_SPECIFICATION == structuralFeature
					.getEType()) {
				EObject eObject = null;
				if (rowElement instanceof EObject) {
					eObject = (EObject) rowElement;
				} else {
					eObject = (EObject) columnElement;
				}

				CompositeCommand result = CustomSpecificationSetCommand
						.getInstance().createSetCommand(getInjector(), eObject,
								structuralFeature, newValue, getDefaultLanguages());

				return result.isEmpty() ? null : new GMFtoEMFCommandWrapper(
						result);
			}
		}

		return null;
	}
	
	@Override
	protected Object doGetValue(Object columnElement, Object rowElement, INattableModelManager tableManager) {
		
			//Modified to only return first slot value...
			final List<Object> objects = organizeAndResolvedObjects(columnElement, rowElement, null);
			final EObject eobject = (EObject) objects.get(0);
			final EStructuralFeature feature = (EStructuralFeature) objects.get(1);
			if (eobject.eClass().getEAllStructuralFeatures().contains(feature)) {
				Object value = eobject.eGet(feature);
				if (feature.isMany()) {
					Collection valueCollection = ((Collection)value);
					if (valueCollection.isEmpty()){
						value = NOT_AVALAIBLE;
					}else {
						value = valueCollection.iterator().next();
					}	
				}
					
				return value;
			}
			return NOT_AVALAIBLE;
		

	}
//	
//	@Override
//	public boolean isCellEditable(Object columnElement, Object rowElement, INattableModelManager tableManager) {
//		ValueSpecification valSpec= rowElement instanceof ValueSpecification ? (ValueSpecification) rowElement: null; 
//		EStructuralFeatureAxis valueRefAxis = columnElement instanceof EStructuralFeatureAxis ? (EStructuralFeatureAxis) columnElement: rowElement instanceof EStructuralFeatureAxis ?  (EStructuralFeatureAxis) rowElement : null; 
//		
//		return (valSpec != null &&  valueRefAxis != null && UMLPackage.eINSTANCE.getSlot_Value().equals(valueRefAxis.getElement()));
//		
//	}
//	
//	@Override
//	public Command getSetStringValueCommand(TransactionalEditingDomain domain, Object columnElement, Object rowElement,
//			String newValue, AbstractStringValueConverter valueSolver, INattableModelManager tableManager) {
//		
//		if (columnElement instanceof EStructuralFeatureAxis && rowElement instanceof EObjectAxis || columnElement instanceof EObjectAxis && rowElement instanceof EStructuralFeatureAxis) {
//
//			EStructuralFeature structuralFeature = null;
//			if (columnElement instanceof EStructuralFeatureAxis) {
//				structuralFeature = ((EStructuralFeatureAxis) columnElement).getElement();
//			} else {
//				structuralFeature = ((EStructuralFeatureAxis) rowElement).getElement();
//			}
//
//			if (UMLPackage.Literals.VALUE_SPECIFICATION == structuralFeature
//					.getEType()) {
//				EObject eObject = null;
//				if (rowElement instanceof EObjectAxis) {
//					eObject = ((EObjectAxis) rowElement).getElement();
//				} else {
//					eObject = ((EObjectAxis) columnElement).getElement();
//				}
//
//				CompositeCommand result = ValueSpecificationSetCommand
//						.getInstance().createSetCommand(getInjector(), eObject,
//								structuralFeature, newValue, getDefaultLanguages());
//
//				return result.isEmpty() ? null : new GMFtoEMFCommandWrapper(
//						result);
//			}
//		}
//		return null;
//	}
//	
//	
//	@Override
//	public boolean handles(Object columnElement, Object rowElement, INattableModelManager tableManager) {
//		// TODO Auto-generated method stub
//		return super.handles(columnElement, rowElement, tableManager);
//	}
}
