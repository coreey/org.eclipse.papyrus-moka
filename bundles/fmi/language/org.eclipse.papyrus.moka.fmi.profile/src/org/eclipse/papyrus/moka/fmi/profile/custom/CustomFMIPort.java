/*****************************************************************************
 * 
 * Copyright (c) 2016,2019 CEA LIST.
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
package org.eclipse.papyrus.moka.fmi.profile.custom;

import java.util.Map;

import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfileFactory;
import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage;
import org.eclipse.papyrus.moka.fmi.fmiprofile.InitialKind;
import org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityKind;
import org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIPortImpl;
import org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable;
import org.eclipse.papyrus.moka.fmi.profile.util.FMIProfileUtil;
import org.eclipse.papyrus.sysml14.deprecatedelements.FlowPort;
import org.eclipse.papyrus.sysml14.deprecatedelements.FlowSpecification;
import org.eclipse.papyrus.sysml14.internal.util.IconUtil;
import org.eclipse.papyrus.sysml14.portsandflows.FlowDirection;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;

public class CustomFMIPort extends FMIPortImpl {

	private static Map<String, Image> icons;

	@Override
	public Fmi2ScalarVariable getFmiVariable() {
		if (fmiVariable == null) {
			fmiVariable = FMIProfileUtil.getFMIVariable(base_Port);
		}
		return fmiVariable;
	}

	@Override
	public String getDescription() {
		if (getFmiVariable() != null) {
			return getFmiVariable().getDescription();
		}
		return super.getDescription();
	}

	@Override
	public VariabilityKind getVariability() {
		if (getFmiVariable() != null) {
			return (VariabilityKind) FMIProfileFactory.eINSTANCE.createFromString(
					FMIProfilePackage.eINSTANCE.getVariabilityKind(), getFmiVariable().getVariability().getLiteral());
		}
		return super.getVariability();
	}

	@Override
	public InitialKind getInitial() {
		if (getFmiVariable() != null) {
			return (InitialKind) FMIProfileFactory.eINSTANCE.createFromString(
					FMIProfilePackage.eINSTANCE.getInitialKind(), getFmiVariable().getInitial().getLiteral());
		}
		return super.getInitial();
	}

	@Override
	public long getValueReference() {
		if (getFmiVariable() != null) {
			return (int) getFmiVariable().getValueReference();
		}
		return super.getValueReference();
	}

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
	
	@Override
	public FlowDirection getDirection() {
		if (getFmiVariable() != null){
			switch( getFmiVariable().getCausality()){
			case INPUT:
				return FlowDirection.IN;
			case OUTPUT:
				return FlowDirection.OUT;
			default:
				return null;			
			}
	}
		return super.getDirection();
	}
}
