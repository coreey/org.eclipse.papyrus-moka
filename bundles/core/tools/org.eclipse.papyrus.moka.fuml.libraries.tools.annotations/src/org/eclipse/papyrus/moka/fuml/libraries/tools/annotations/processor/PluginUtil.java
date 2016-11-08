/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  David LOPEZ BETANCUR (CEA LIST) - david.lopez@cea.fr
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.processor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginImport;
import org.eclipse.pde.core.plugin.IPluginModel;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.bundle.WorkspaceBundlePluginModel;
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModel;
import org.eclipse.pde.internal.core.project.PDEProject;

public class PluginUtil {
	
	public static IPluginModel getReadOnlyPluginModel(IProject project){		
		return (IPluginModel) PDECore.getDefault().getModelManager().findModel(project);
	}
	
	public static IFile getPluginXml(IProject project){
		return PDEProject.getPluginXml(project);
	}
	
	
	public static WorkspaceBundlePluginModel makeWritableBundle(IProject project, IPluginModel readOnly){
		WorkspaceBundlePluginModel pm = new WorkspaceBundlePluginModel( (IFile)readOnly.getUnderlyingResource(), getPluginXml(project));
		try {
			PluginUtil.copyExtensions(readOnly, pm);
		} catch (CoreException e1) {
			e1.printStackTrace();
		}
		
		return pm;
	}
	
	private static void makeWritableCopy(IPluginModel readOnly, IPluginModel writableModel){
		try {
			copyExtensions(readOnly, writableModel);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	public static IPluginExtension getExtension( IPluginModel model, String point ){
		for( IPluginExtension e : model.getExtensions().getExtensions() )
			if( e.getPoint().equals(point) )
				return e;
		
		return null;
	}
	
	public static IPluginExtension addPluginExtension(IPluginModel pm, String point, String name ) throws CoreException{
		IPluginExtension ext = pm.getFactory().createExtension();

		ext.setPoint(point);
		ext.setName(name);
		
		pm.getExtensions().add(ext);
		
		return ext;
	}
	
	private static void copyExtensions(IPluginModel readOnly, IPluginModel pm) throws CoreException{
		for( IPluginExtension ext : readOnly.getExtensions().getExtensions() ){
			IPluginExtension ce = pm.getPluginFactory().createExtension();
			ce.setPoint(ext.getPoint());
			ce.setId(ext.getId());
			ce.setName(ext.getName());
			ce.setInTheModel(true);
			
			for (IPluginObject obj : ext.getChildren()) {
				ce.add( ((IPluginElement)obj) ) ;
            }
			
            pm.getExtensions().add(ce);
		}
	}
	
	public static void removeExtension(IPluginModel pm, String point) throws CoreException{
		IPluginExtension e = getExtension(pm, point);
		
		if( e == null )
			return;
		
		pm.getExtensions().remove(e);
	}
	
	public static String getAttributeIfNotNull(IPluginElement e, String attName){
		IPluginAttribute attr = e.getAttribute(attName);
		if( attr != null )
			return attr.getValue();
		
		return null;
	}
	
	public static void setAttributeIfNotNull(IPluginElement e, String attName, String value) throws CoreException{
		if( value == null )
			return;
		
		e.setAttribute(attName, value);
	}
	
	public static boolean hasDependency(IPluginModel pluginModel, String id){
		for(IPluginImport imp: pluginModel.getPluginBase().getImports())
			if( id.equals(imp.getId()) )
				return true;
		
		return false;
	}
	
	public static void addDependency(IPluginModel pluginModel, String id){
		try {
			IPluginImport custom = pluginModel.getPluginFactory().createImport();
			custom.setId(id);
			pluginModel.getPluginBase().add(custom);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
}
