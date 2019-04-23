/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.simex.dnd.strategy;

import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Drop strategy to create an CreateObjectAction from a Classifier drop and to update
 * the "classifier" reference.
 * 
 * @author SR246418
 *
 */
public class ClassifierToCreateObjectActionStrategy extends AbstractDropInActivityStrategy {

	public ClassifierToCreateObjectActionStrategy() {
		super(UMLPackage.eINSTANCE.getClassifier(), UMLElementTypes.CREATE_OBJECT_ACTION, UMLPackage.eINSTANCE.getCreateObjectAction_Classifier());
		setNamePrefix("create");
	}

}
