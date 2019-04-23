/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.composites.extensions.Semantics.CompositeStructures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_DefaultConstructStrategy;
import org.eclipse.papyrus.moka.composites.extensions.Semantics.InvocationActions.CS_ConnectorLink;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Reference;
import org.eclipse.papyrus.moka.composites.interfaces.extensions.Semantics.CompositeStructures.StructuredClasses.ICS_ConnectorLink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;

public class CS_NotNormativeDefaultConstructStrategy extends CS_DefaultConstructStrategy{

	public void generateArrayPattern(ICS_Reference context, Connector connector) {
		ConnectorEnd end1 = connector.getEnds().get(0);
		ConnectorEnd end2 = connector.getEnds().get(1);
		List<IReference> end1Values = this.getValuesFromConnectorEnd(context, end1);
		List<IReference> end2Values = this.getValuesFromConnectorEnd(context, end2);
		for (int i = 0; i < end1Values.size(); i++) {
			ICS_ConnectorLink link = new CS_ConnectorLink();
			link.setConnector(connector);
			if (connector.getType() == null) {
				link.setType(this.getDefaultAssociation());
			} else {
				link.setType(connector.getType());
			}
			List<IValue> valuesForEnd1 = new ArrayList<IValue>();
			valuesForEnd1.add(end1Values.get(i));
			List<IValue> valuesForEnd2 = new ArrayList<IValue>();
			valuesForEnd2.add(end2Values.get(i));
			link.setFeatureValue(link.getType().getOwnedEnds().get(0), valuesForEnd1, -1);
			link.setFeatureValue(link.getType().getOwnedEnds().get(1), valuesForEnd2, -1);
			link.addTo(context.getReferent().getLocus());
		}
	}
	
	public void generateStarPattern(ICS_Reference context, Connector connector) {
		ConnectorEnd end1 = connector.getEnds().get(0);
		ConnectorEnd end2 = connector.getEnds().get(1);
		List<IReference> end1Values = this.getValuesFromConnectorEnd(context, end1);
		List<IReference> end2Values = this.getValuesFromConnectorEnd(context, end2);
		for (int i = 0; i < end1Values.size(); i++) {
			for (int j = 0; j < end2Values.size(); j++) {
				ICS_ConnectorLink link = new CS_ConnectorLink();
				link.setConnector(connector);
				if (connector.getType() == null) {
					link.setType(this.getDefaultAssociation());
				} else {
					link.setType(connector.getType());
				}
				List<IValue> valuesForEnd1 = new ArrayList<IValue>();
				valuesForEnd1.add(end1Values.get(i));
				List<IValue> valuesForEnd2 = new ArrayList<IValue>();
				valuesForEnd2.add(end2Values.get(j));
				link.setFeatureValue(link.getType().getOwnedEnds().get(0), valuesForEnd1, -1);
				link.setFeatureValue(link.getType().getOwnedEnds().get(1), valuesForEnd2, -1);
				link.addTo(context.getReferent().getLocus());
			}
		}
	}
	
}
