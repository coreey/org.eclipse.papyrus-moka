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
package org.eclipse.papyrus.moka.datavisualization.ui.tester;

import java.util.Iterator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.moka.datavisualization.util.VisualizationUtil;

public class DataSourcePropertyTester extends PropertyTester{

	/** property to test if the selected elements has a DataSourceStereotype */
	public static final String IS_DATASOURCE = "isDataSource"; //$NON-NLS-1$
	
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (IS_DATASOURCE.equals(property) && receiver instanceof IStructuredSelection) {
			boolean answer = containsDataSource((IStructuredSelection) receiver);
			return new Boolean(answer).equals(expectedValue);
		}
		return false;
	}
	
	private boolean containsDataSource(IStructuredSelection selection){
		if( selection.isEmpty() )
			return false;
		Iterator<?> iter = selection.iterator();
		while( iter.hasNext() ){
			final Object next = iter.next();
			EObject obj = EMFHelper.getEObject(next);
			if( VisualizationUtil.getDataSourceStereotype(obj) == null )
				return false;
		}
		
		return true;
	}
}
