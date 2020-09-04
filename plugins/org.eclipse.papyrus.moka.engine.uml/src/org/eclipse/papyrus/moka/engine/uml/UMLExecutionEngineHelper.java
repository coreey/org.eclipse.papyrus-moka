/*****************************************************************************
 * Copyright (c) 2020 CEA LIST and others.
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
package org.eclipse.papyrus.moka.engine.uml;

import org.eclipse.papyrus.moka.fuml.actions.DefaultCreateObjectActionStrategy;
import org.eclipse.papyrus.moka.fuml.actions.DefaultGetAssociationStrategy;
import org.eclipse.papyrus.moka.fuml.commonbehavior.FIFOGetNextEventStrategy;
import org.eclipse.papyrus.moka.fuml.library.LibraryRegistry;
import org.eclipse.papyrus.moka.fuml.loci.FirstChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.loci.ILocus;
import org.eclipse.papyrus.moka.kernel.engine.EngineConfiguration;
import org.eclipse.papyrus.moka.pscs.actions.additions.CS_NotNormativeDefaultConstructStrategy;
import org.eclipse.papyrus.moka.pscs.loci.CS_Executor;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.CS_DefaultRequestPropagationStrategy;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.CS_DispatchOperationOfInterfaceStrategy;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.CS_NameBased_StructuralFeatureOfInterfaceAccessStrategy;
import org.eclipse.papyrus.moka.pssm.loci.SM_ExecutionFactory;
import org.eclipse.papyrus.moka.pssm.loci.SM_Locus;
import org.eclipse.papyrus.moka.utils.UMLPrimitiveTypesUtils;
import org.eclipse.uml2.uml.Element;

public class UMLExecutionEngineHelper {

	public static ILocus createLocus() {
		ILocus locus = new SM_Locus();
		locus.setExecutor(new CS_Executor());
		locus.setFactory(new SM_ExecutionFactory());
		return locus;
	}

	public static void installBuiltInTypes(EngineConfiguration<?> configuration, ILocus locus) {
		Element source = (Element) configuration.getExecutionSource();
		if (locus != null && source != null) {
			locus.getFactory().addBuiltInType(UMLPrimitiveTypesUtils.getReal(source));
			locus.getFactory().addBuiltInType(UMLPrimitiveTypesUtils.getInteger(source));
			locus.getFactory().addBuiltInType(UMLPrimitiveTypesUtils.getBoolean(source));
			locus.getFactory().addBuiltInType(UMLPrimitiveTypesUtils.getString(source));
		}
	}

	public static void installLibraries(EngineConfiguration<?> configuration, ILocus locus) {
		Element source = (Element) configuration.getExecutionSource();
		if (locus != null && source.eResource() != null && source.eResource().getResourceSet() != null) {
			LibraryRegistry.getInstance().loadLibraryFactories(source.eResource().getResourceSet());
			LibraryRegistry.getInstance().installLibraries(locus);
		}
	}

	public static void installSemanticStrategies(ILocus locus) {
		if (locus != null) {
			locus.getFactory().setStrategy(new FirstChoiceStrategy());
			locus.getFactory().setStrategy(new FIFOGetNextEventStrategy());
			locus.getFactory().setStrategy(new CS_DispatchOperationOfInterfaceStrategy());
			locus.getFactory().setStrategy(new CS_NameBased_StructuralFeatureOfInterfaceAccessStrategy());
			locus.getFactory().setStrategy(new CS_DefaultRequestPropagationStrategy());
			locus.getFactory().setStrategy(new CS_NotNormativeDefaultConstructStrategy());
			locus.getFactory().setStrategy(new DefaultGetAssociationStrategy());
			locus.getFactory().setStrategy(new DefaultCreateObjectActionStrategy());
		}
	}

}
