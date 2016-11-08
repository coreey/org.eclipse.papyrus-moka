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

public class URIMappingExtensionHandler extends ExtensionHandler<URIMappingExtensionData> {
	
	final static String EXT_POINT_NAME = "org.eclipse.emf.ecore.uri_mapping";
	final static String DEPENDENCY_PLUGIN = "org.eclipse.emf.ecore";
	
	@Override
	public URIMappingExtensionData load(IPluginModel pluginModel) {
		URIMappingExtensionData data = new URIMappingExtensionData();
		
		IPluginExtension ext = PluginUtil.getExtension(pluginModel, EXT_POINT_NAME);
		if( ext == null )
			return data;
		
		data.id = ext.getId();
		data.name = ext.getName();
		
		//Get the library class.
		IPluginElement libElm = getLibraryElement(ext);
		if( libElm != null ){			
			data.source = PluginUtil.getAttributeIfNotNull(libElm, "source");
			data.target = PluginUtil.getAttributeIfNotNull(libElm, "target");
		}
		
		return data;
	}

	@Override
	public void doSaveTo(IPluginModel pluginModel, URIMappingExtensionData extData) {
		try {
			PluginUtil.removeExtension(pluginModel, EXT_POINT_NAME);
			//Recreate the extension.
			addExtension(pluginModel, extData);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	private static void addExtension(IPluginModel pluginModel, URIMappingExtensionData umlLib ) throws CoreException{
		IPluginExtension extension = pluginModel.getPluginFactory().createExtension();
		extension.setPoint(EXT_POINT_NAME);
		extension.setId(umlLib.id);
		extension.setName(umlLib.name);
		
		IPluginElement library = pluginModel.getPluginFactory().createElement(extension);
		library.setName("mapping");

		PluginUtil.setAttributeIfNotNull(library, "source", umlLib.source);
		PluginUtil.setAttributeIfNotNull(library, "target", umlLib.target);
		
		extension.add(library);
		
		pluginModel.getExtensions().add(extension);
	}
	
	private IPluginElement getLibraryElement(IPluginExtension ext){

		for( IPluginObject obj : ext.getChildren() ) 
			if( "mapping".equals(obj.getName()) )
				return (IPluginElement)obj;
		
		//Not existent.
		return null;
	}

	@Override
	protected String getDependencyPluginId() {
		return DEPENDENCY_PLUGIN;		
	}

}
