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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModel;
import org.eclipse.pde.core.plugin.IPluginObject;

public class FumlLibraryExtensionHandler extends ExtensionHandler<FumlLibraryExtensionData> {
	
	final static String EXT_POINT_NAME = "org.eclipse.papyrus.moka.fuml.library";
	final static String DEPENDENCY_PLUGIN = "org.eclipse.papyrus.moka.fuml";
	
	@Override
	public FumlLibraryExtensionData load(IPluginModel pluginModel) {
		FumlLibraryExtensionData data = new FumlLibraryExtensionData();
		
		IPluginExtension ext = PluginUtil.getExtension(pluginModel, EXT_POINT_NAME);
		if( ext == null )
			return data;
		
		data.id = ext.getId();
		data.name = ext.getName();
		
		IPluginElement libElm = getLibraryElement(ext);
		if( libElm != null ){
			data.libraryClass = PluginUtil.getAttributeIfNotNull(libElm, "class");
		}
		
		return data;
	}
	
	private IPluginElement getLibraryElement(IPluginExtension ext){

		for( IPluginObject obj : ext.getChildren() ) 
			if( "library".equals(obj.getName()) )
				return (IPluginElement)obj;
		
		return null;
	}

	private static void addExtension(IPluginModel pluginModel, FumlLibraryExtensionData fumlLib ) throws CoreException{
		IPluginExtension extension = pluginModel.getPluginFactory().createExtension();
		extension.setPoint(EXT_POINT_NAME);
		extension.setId(fumlLib.id);
		extension.setName(fumlLib.name);
		
		IPluginElement library = pluginModel.getPluginFactory().createElement(extension);
		library.setName("library");
		library.setAttribute("class", fumlLib.libraryClass);
		extension.add(library);
		
		pluginModel.getExtensions().add(extension);
	}

	@Override
	protected void doSaveTo(IPluginModel pluginModel, FumlLibraryExtensionData extData) {
		try {
			PluginUtil.removeExtension(pluginModel, EXT_POINT_NAME);
			addExtension(pluginModel, extData);
		} catch (CoreException e) {
			e.printStackTrace();
		}		
	}

	@Override
	protected String getDependencyPluginId() {
		return DEPENDENCY_PLUGIN;		
	}
}
