/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.trace.capture;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.trace.interfaces.capture.ICaptureServiceFactory;
import org.eclipse.papyrus.moka.utils.helper.semantics.SemanticHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

public abstract class AbstractCaptureServiceFactory implements ICaptureServiceFactory {

	protected String name;

	protected String id;

	@Override
	public boolean isVisitorConcernedByTracepoints(Set<EObject> tracedElement, ISemanticVisitor visitor) {
		NamedElement visitedModelElement = SemanticHelper.getModelElement(visitor);
		return isVisitorConcernedByTracepoints(tracedElement, visitedModelElement);
	}

	public boolean isVisitorConcernedByTracepoints(Set<EObject> allElementMarked, Element semanticElement) {
		return allElementMarked.contains(semanticElement);
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

}
