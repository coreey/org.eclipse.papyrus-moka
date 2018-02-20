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

public class UMLLibraryExtensionHandler extends ExtensionHandler<UMLLibraryExtensionData> {
	
	final static String EXT_POINT_NAME = "org.eclipse.papyrus.uml.extensionpoints.UMLLibrary";
	final static String DEPENDENCY_PLUGIN = "org.eclipse.papyrus.uml.extensionpoints";
	
	public static final String ICON_DIR = "icons";
	public static final String ICON_FILE = "fumlib16x16.png";
	public static final String ICON_SRC_IN_BUNDLE = "icons/fumlib16x16.png";
	
	@Override
	public UMLLibraryExtensionData load(IPluginModel pluginModel) {
		UMLLibraryExtensionData data = new UMLLibraryExtensionData();
		
		IPluginExtension ext = PluginUtil.getExtension(pluginModel, EXT_POINT_NAME);
		if( ext == null )
			return data;
		
		data.id = ext.getId();
		data.name = ext.getName();
		
		//Get the library class.
		IPluginElement libElm = getLibraryElement(ext);
		if( libElm != null ){			
			data.libraryName = PluginUtil.getAttributeIfNotNull(libElm, "name");
			data.path = PluginUtil.getAttributeIfNotNull(libElm, "path");
			data.iconPath = PluginUtil.getAttributeIfNotNull(libElm, "iconpath");
			data.description = PluginUtil.getAttributeIfNotNull(libElm, "description");
			data.provider = PluginUtil.getAttributeIfNotNull(libElm, "provider");
		}
		
		//Default values.
		if( data.iconPath == null ){
			data.iconPath = ICON_DIR + "/" + ICON_FILE;
		}
		
		return data;
	}

	@Override
	public void doSaveTo(IPluginModel pluginModel, UMLLibraryExtensionData extData) {
		try {
			PluginUtil.removeExtension(pluginModel, EXT_POINT_NAME);
			//Recreate the extension.
			addExtension(pluginModel, extData);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	private static void addExtension(IPluginModel pluginModel, UMLLibraryExtensionData umlLib ) throws CoreException{
		IPluginExtension extension = pluginModel.getPluginFactory().createExtension();
		extension.setPoint(EXT_POINT_NAME);
		extension.setId(umlLib.id);
		extension.setName(umlLib.name);
		
		IPluginElement library = pluginModel.getPluginFactory().createElement(extension);
		library.setName("library");

		PluginUtil.setAttributeIfNotNull(library, "name", umlLib.libraryName);
		PluginUtil.setAttributeIfNotNull(library, "path", umlLib.path);
		PluginUtil.setAttributeIfNotNull(library, "iconpath", umlLib.iconPath);
		PluginUtil.setAttributeIfNotNull(library, "description", umlLib.description);
		PluginUtil.setAttributeIfNotNull(library, "provider", umlLib.provider);
		
		extension.add(library);
		
		pluginModel.getExtensions().add(extension);
	}
	
	private IPluginElement getLibraryElement(IPluginExtension ext){

		for( IPluginObject obj : ext.getChildren() ) 
			if( "library".equals(obj.getName()) )
				return (IPluginElement)obj;
		
		//Not existent.
		return null;
	}

	@Override
	protected String getDependencyPluginId() {
		return DEPENDENCY_PLUGIN;		
	}

}
