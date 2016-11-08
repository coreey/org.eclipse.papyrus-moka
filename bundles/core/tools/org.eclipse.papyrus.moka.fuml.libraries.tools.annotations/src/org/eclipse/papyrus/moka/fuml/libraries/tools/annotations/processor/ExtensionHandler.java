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

import org.eclipse.pde.core.plugin.IPluginModel;

public abstract class ExtensionHandler<T> {
	
	protected abstract String getDependencyPluginId();
	protected abstract void doSaveTo(IPluginModel pluginModel, T extData);

	public abstract T load(IPluginModel pluginModel);
	
	public void saveTo(IPluginModel pluginModel, T extData){
		String dependencyId = getDependencyPluginId();
		
		if( !PluginUtil.hasDependency(pluginModel, dependencyId) )		
			PluginUtil.addDependency(pluginModel, dependencyId);
		
		doSaveTo(pluginModel, extData);
	}
	
}
