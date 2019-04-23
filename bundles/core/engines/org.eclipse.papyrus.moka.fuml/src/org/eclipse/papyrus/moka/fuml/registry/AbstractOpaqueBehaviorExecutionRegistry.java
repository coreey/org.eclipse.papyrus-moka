/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.moka.fuml.registry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.utils.ResourceSetUtils;
import org.eclipse.uml2.uml.OpaqueBehavior;

public abstract class AbstractOpaqueBehaviorExecutionRegistry implements IOpaqueBehaviorExecutionRegistry {

	protected EObject contextEObject = null;

	protected ILocus locus = null;

	protected Map<String, OpaqueBehavior> opaqueBehaviorsMap = null;

	public IOpaqueBehaviorExecutionRegistry init(Object parameters) {
		if (parameters instanceof EObject) {
			this.contextEObject = (EObject) parameters;
		}
		return this;
	}

	public void registerOpaqueBehaviorExecutions(ILocus locus) {
		this.locus = locus;
	}

	protected void buildOpaqueBehaviorsMap(String libraryURIString) {
		opaqueBehaviorsMap = new HashMap<String, OpaqueBehavior>();
		if (libraryURIString != null) {
			URI libraryUri = URI.createURI(libraryURIString);
			ResourceSet resourceSet = ResourceSetUtils.getResourceSet(contextEObject);
			if (resourceSet == null){
				resourceSet = ResourceSetUtils.getDefaultResourceSet();
			}
			Resource libraryResource = resourceSet.getResource(libraryUri, true);
			for (Iterator<EObject> i = libraryResource.getAllContents(); i.hasNext();) {
				EObject cddOpaqueBehavior = i.next();
				if (cddOpaqueBehavior instanceof OpaqueBehavior) {
					OpaqueBehavior f = (OpaqueBehavior) cddOpaqueBehavior;
					opaqueBehaviorsMap.put(f.getQualifiedName(), f);
				}
			}
		}
	}

	protected void registerOpaqueBehaviorExecution(OpaqueBehaviorExecution behaviorExecution, String behaviorQualifiedName) {
		behaviorExecution.types.add(this.opaqueBehaviorsMap.get(behaviorQualifiedName));
		locus.getFactory().addPrimitiveBehaviorPrototype(behaviorExecution);
	}
}
