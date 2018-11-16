/*******************************************************************************
 * Copyright (c) 2018, Krisztián Mócsai, IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Krisztián Mócsai - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.moka.ssp.profile.custom.imp;

import java.util.Map;

import org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectorImpl;
import org.eclipse.papyrus.sysml14.deprecatedelements.FlowPort;
import org.eclipse.papyrus.sysml14.deprecatedelements.FlowSpecification;
import org.eclipse.papyrus.sysml14.internal.util.IconUtil;
import org.eclipse.papyrus.sysml14.portsandflows.FlowDirection;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;

public class CustomSsdConnector extends SsdConnectorImpl {

	private static Map<String, Image> icons;
	
	@Override
	public boolean isAtomic() {
		boolean isAtomic = true;
		if (getBase_Port() != null) {
			// Find FlowPort type
			Type type = getBase_Port().getType();
			if ((type != null) && (type instanceof Interface)) {
				FlowSpecification flowSpec = UMLUtil.getStereotypeApplication(type, FlowSpecification.class);
				if (flowSpec != null) {
					isAtomic = false;
				}
			}
		}
		return isAtomic;
	}

	public static Map<String, Image> getIcons(FlowPort flowPort) {
		if (icons == null) {// for PERFORMANCE we call UMLUtil.getStereotype only once
			Stereotype stereotype = UMLUtil.getStereotype(flowPort);
			icons = IconUtil.getImages(stereotype);
		}
		return icons;
	}

	@Override
	public Image getIcon() {
		Image image = null;
		if (getBase_Port() != null) {
			Map<String, Image> iconList = getIcons(this);
			switch (getDirection()) {
			case IN:
				image = iconList.get(getImageKey(FlowDirection.IN));
				break;
			case OUT:
				image = iconList.get(getImageKey(FlowDirection.OUT));
				break;
			case INOUT:
				image = iconList.get(getImageKey(FlowDirection.INOUT));
				break;
			default:
				image = iconList.get(getImageKey(FlowDirection.INOUT));
				break;
			}
		}
		return image;
	}

	private String getImageKey(FlowDirection flowDirection) {
		return FlowPort.class.getSimpleName() + "_" + flowDirection.getName().toUpperCase();//$NON-NLS-1$
	}

}
