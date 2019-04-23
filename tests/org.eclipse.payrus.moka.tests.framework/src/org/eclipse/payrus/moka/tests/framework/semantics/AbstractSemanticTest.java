/*****************************************************************************
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
 *****************************************************************************/

package org.eclipse.payrus.moka.tests.framework.semantics;

import java.util.Iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.junit.utils.tests.AbstractEditorTest;
import org.eclipse.papyrus.moka.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;
import org.junit.Assert;
import org.junit.Before;
import org.osgi.framework.Bundle;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;

public abstract class AbstractSemanticTest extends AbstractEditorTest {

	protected Classifier executionEntryPoint;
	
	public abstract Bundle getTestBundle();
	
	public abstract String getModelName();
	
	public abstract String getExecutionEntryPointQualifiedName();
	
	protected abstract String getSourcePath();
	
	public final Classifier getExecutionEntryPoint(){
		return this.executionEntryPoint;
	}
	
	@Before
	public void initialize(){
		try {
			this.createProject(this.getTestBundle().getSymbolicName());
			this.initModel(this.getModelName(), this.getTestBundle());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Package modelRoot = this.getRootUMLModel();
		Iterator<EObject> contentIterator = modelRoot.eAllContents();
		while(this.executionEntryPoint==null && contentIterator.hasNext()){
			EObject modelElement = contentIterator.next();
			if(modelElement instanceof NamedElement){
				if(!modelElement.eIsProxy() &&
						((NamedElement)modelElement).getQualifiedName() != null &&
						((NamedElement)modelElement).getQualifiedName().equals(this.getExecutionEntryPointQualifiedName())){
					if(modelElement instanceof Classifier){
						this.executionEntryPoint = (Classifier) modelElement;
					}
				}
			}
		}
		Assert.assertNotNull("The execution entry point "+this.getExecutionEntryPointQualifiedName()+" could not be found", this.executionEntryPoint);
	}
	
	protected IExecutionEngine getExecutionEngine(final String engineID){
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(MokaConstants.MOKA_ENGINE_EXTENSION_POINT_ID);
		try {
			IConfigurationElement e = null;
			if (engineID == null || engineID.equals("")) {
				// This situation happens when the preferences for the default Moka execution engine have never been changed
				e = config[0];
			} else {
				for (int i = 0; i < config.length; i++) {
					if (config[i].getNamespaceIdentifier().equals(engineID)) {
						e = config[i];
					}
				}
			}
			final Object o = e.createExecutableExtension("class");
			return (IExecutionEngine) o;
		} catch (CoreException ex) {
			org.eclipse.papyrus.infra.core.Activator.log.equals(ex);
		} catch (Exception ex) {
			org.eclipse.papyrus.infra.core.Activator.log.equals(ex);
		}
		return null;
	}
}
