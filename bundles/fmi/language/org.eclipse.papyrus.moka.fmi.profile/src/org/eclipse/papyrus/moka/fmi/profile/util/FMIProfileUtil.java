/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
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
package org.eclipse.papyrus.moka.fmi.profile.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU;
import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIPort;
import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage;
import org.eclipse.papyrus.moka.fmi.fmiprofile.FMU;
import org.eclipse.papyrus.moka.fmi.fmiprofile.ME_FMU;
import org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable;
import org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType;
import org.eclipse.papyrus.sysml14.portsandflows.FlowDirection;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.util.UMLUtil;

public class FMIProfileUtil {
	public static final String FMI_PROFILE_URI = "pathmap://PAPYRUS_FMI_PROFILE/FMI.profile.uml";
	public static final String FMI_PROFILE_NAME = "FMIProfile";
	public static final String CS_FMU_STEREO_NAME = FMIProfilePackage.eINSTANCE.getCS_FMU().getName();
	public static final String ME_FMU_STEREO_NAME = FMIProfilePackage.eINSTANCE.getME_FMU().getName();
	public static final String CS_GRAPH_STEREO_NAME = FMIProfilePackage.eINSTANCE.getCS_Graph().getName();
	public static final String CALCULATED_PARAMETER_STEREO_NAME = FMIProfilePackage.eINSTANCE.getCalculatedParameter()
			.getName();
	public static final String PARAMETER_STEREO_NAME = FMIProfilePackage.eINSTANCE.getParameter().getName();
	public static final String LOCAL_STEREO_NAME = FMIProfilePackage.eINSTANCE.getLocal().getName();
	public static final String INDEPENDENT_STEREO_NAME = FMIProfilePackage.eINSTANCE.getIndependent().getName();
	public static final String PORT_STEREO_NAME = FMIProfilePackage.eINSTANCE.getFMIPort().getName();
	public static final String OUTPUT_DEPENDENCY_STEREO_NAME = FMIProfilePackage.eINSTANCE.getOutputDependency()
			.getName();
	public static final String DERIVATIVE_DEPENDENCY_STEREO_NAME = FMIProfilePackage.eINSTANCE.getDerivativeDependency()
			.getName();
	public static final String INITIAL_UNKNWOWN_STEREO_NAME = FMIProfilePackage.eINSTANCE.getInitialUnknownDependency()
			.getName();

	public static final String CS_FMU_STEREO_QUALIFIED_NAME = FMI_PROFILE_NAME + "::" + CS_FMU_STEREO_NAME;
	public static final String ME_FMU_STEREO_QUALIFIED_NAME = FMI_PROFILE_NAME + "::" + ME_FMU_STEREO_NAME;
	public static final String CS_GRAPH_STEREO_QUALIFIED_NAME = FMI_PROFILE_NAME + "::" + CS_GRAPH_STEREO_NAME;
	public static final String CALCULATED_PARAMETER_STEREO_QUALIFIED_NAME = FMI_PROFILE_NAME + "::"
			+ CALCULATED_PARAMETER_STEREO_NAME;
	public static final String PARAMETER_STEREO_QUALIFIED_NAME = FMI_PROFILE_NAME + "::" + PARAMETER_STEREO_NAME;
	public static final String LOCAL_STEREO_QUALIFIED_NAME = FMI_PROFILE_NAME + "::" + LOCAL_STEREO_NAME;
	public static final String INDEPENDENT_STEREO_QUALIFIED_NAME = FMI_PROFILE_NAME + "::" + INDEPENDENT_STEREO_NAME;
	public static final String PORT_STEREO_QUALIFIED_NAME = FMI_PROFILE_NAME + "::" + PORT_STEREO_NAME;
	public static final String OUTPUT_DEPENDENCY_STEREO_QUALIFIED_NAME = FMI_PROFILE_NAME + "::"
			+ OUTPUT_DEPENDENCY_STEREO_NAME;
	public static final String DERIVATIVE_DEPENDENCY_STEREO_QUALIFIED_NAME = FMI_PROFILE_NAME + "::"
			+ DERIVATIVE_DEPENDENCY_STEREO_NAME;
	public static final String INITIAL_UNKNWOWN_STEREO_QUALIFIED_NAME = FMI_PROFILE_NAME + "::"
			+ INITIAL_UNKNWOWN_STEREO_NAME;

	public static void applyProfileIfNeeded(Package owningPackage, EPackage ePackage) {
		Profile profile = getProfile(owningPackage, ePackage);

		Iterator<Profile> profileIter = owningPackage.getAllAppliedProfiles().iterator();
		Profile appliedProfile = null;
		while (profileIter.hasNext() && (appliedProfile != profile)) {
			appliedProfile = profileIter.next();
		}
		if (appliedProfile != profile) {
			Package rootPackage = owningPackage.getModel();
			if (rootPackage != null && rootPackage.eResource() == owningPackage.eResource()) {
				rootPackage.applyProfile(profile);
			} else {
				owningPackage.applyProfile(profile);
			}
		}
	}

	public static Profile getProfile(EObject context, EPackage ePackage) {
		return UMLUtil.getProfile(ePackage, context);
	}

	public static Stereotype getStereotype(EObject context, String shortName, EPackage ePackage) {
		Profile profile = getProfile(context, ePackage);
		if (profile != null) {
			return profile.getOwnedStereotype(shortName);
		}
		return null;
	}

	public static Fmi2ScalarVariable getFMIVariable(Property base_Property) {
		if (base_Property != null && base_Property.getName() != null) {
			Class owningClass = base_Property.getClass_();
			if (owningClass != null) {
				FMU owningFMU = (FMU) FastUMLUtil.fastGetStereotypeApplication(owningClass, FMU.class);

				if (owningFMU != null) {
					FmiModelDescriptionType modelDesc = owningFMU.getModelDescription();
					if (modelDesc != null && modelDesc.getModelVariables() != null) {
						for (Fmi2ScalarVariable variable : modelDesc.getModelVariables().getScalarVariable()) {
							if (base_Property.getName().equals(variable.getName())) {
								return variable;
							}
						}
					}
				}
			}

		}

		return null;

	}

	public static Boolean isFMUPort(StructuralFeature p) {
		return FastUMLUtil.fastGetStereotypeApplication(p, Port.class) != null;
	}

	public static Boolean isCS_FMU(Class c) {
		return FastUMLUtil.fastGetStereotypeApplication(c, CS_FMU.class) != null;
	}

	public static Boolean isME_FMU(Class c) {
		return FastUMLUtil.fastGetStereotypeApplication(c, ME_FMU.class) != null;
	}

	public static Boolean isFMU(Class c) {
		return isME_FMU(c) || isCS_FMU(c);

	}

	public static long getValueReference(Property fmuPort) {
		FMIPort fmiPortObj = FastUMLUtil.fastGetStereotypeApplication(fmuPort, FMIPort.class);
		if (fmiPortObj != null) {
			return fmiPortObj.getValueReference();
		}

		return -1;
	}

	public static boolean isOutputPort(Property p) {
		return (p instanceof org.eclipse.uml2.uml.Port)
				&& FlowDirection.OUT == getDirection((org.eclipse.uml2.uml.Port) p);

	}

	public static boolean isInputPort(Property p) {
		return (p instanceof org.eclipse.uml2.uml.Port)
				&& FlowDirection.IN == getDirection((org.eclipse.uml2.uml.Port) p);
	}

	public static FlowDirection getDirection(org.eclipse.uml2.uml.Port port) {
		FMIPort fmiPortObj = FastUMLUtil.fastGetStereotypeApplication(port, FMIPort.class);
		if (fmiPortObj != null) {
			return fmiPortObj.getDirection();
		}
		return null;
	}

	public static long computeNewValueReference(Property prop) {
		Class owningClass = prop.getClass_();
		List<Long> valueReferences = new ArrayList<Long>();
		for (Property attr : owningClass.getAllAttributes()) {
			if (attr != prop) {
				valueReferences.add(getValueReference(attr));
			}
		}
		if (!valueReferences.isEmpty()) {
			return Collections.max(valueReferences) + 1;
		}
		return 0;

	}

	public static CS_FMU getCSFMU(Class umlClass) {
		return FastUMLUtil.fastGetStereotypeApplication(umlClass, CS_FMU.class);
	}

	public static List<ScalarVariable> collectScalarVariables(Class umlClass) {
		List<ScalarVariable> result = new ArrayList<>();
		for (Property prop : umlClass.getAllAttributes()) {
			ScalarVariable variable = FastUMLUtil.fastGetStereotypeApplication(prop, ScalarVariable.class);
			if (variable != null) {
				result.add(variable);
			}
		}

		return result;
	}

}
