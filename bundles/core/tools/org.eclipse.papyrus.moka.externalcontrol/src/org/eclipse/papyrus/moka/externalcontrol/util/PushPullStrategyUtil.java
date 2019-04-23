/*****************************************************************************
 * 
 * Copyright (c) 2017 CEA LIST.
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
package org.eclipse.papyrus.moka.externalcontrol.util;

import java.util.List;

import org.eclipse.papyrus.moka.externalcontrol.controller.IExternallyControlledVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;

public class PushPullStrategyUtil {

	public static  IExternallyControlledVisitor<? extends ISemanticVisitor> pullFirstEnabledVisitor(List<IExternallyControlledVisitor<? extends ISemanticVisitor>> visitorList){
		for (int i=0; i< visitorList.size(); i++){
			IExternallyControlledVisitor<? extends ISemanticVisitor> visitor = visitorList.get(i);
			if( visitor.isExecutionAllowed()){
				visitorList.remove(i);
				return visitor;
			}
		}
		return null;
	}
}
