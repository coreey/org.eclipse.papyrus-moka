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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.ProcessingEnvironment;
import javax.tools.FileObject;
import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

public class AnnotationUtil {
	
	public static List<File> getPath(){
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fm = compiler.getStandardFileManager(null, null, null);

		Iterable<? extends File> locations = fm.getLocation(StandardLocation.SOURCE_PATH);
		
		ArrayList<File> arrayList = new ArrayList<File>();

		for( File l : locations )
			arrayList.add(l);
		
		return arrayList;
	}
	
	public static File getProjectFile(ProcessingEnvironment pe, String path){
		try {
			FileObject fo = pe.getFiler().createResource(StandardLocation.SOURCE_OUTPUT, "", "../" + path);
			return new File(fo.toUri());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static IFile getWorkspaceFile(ProcessingEnvironment pe, String path){
		File mf = AnnotationUtil.getProjectFile(pe, path);
		
		if( mf == null )
			return null;
		
		IWorkspace workspace= ResourcesPlugin.getWorkspace();
		IPath location = Path.fromOSString(mf.getAbsolutePath());
		return workspace.getRoot().getFileForLocation(location);
	}
	
	public static IProject getProjectForFile(ProcessingEnvironment pe){
		IFile iFile = getWorkspaceFile(pe, ".project");
		return iFile.getProject();
	}
	
}
