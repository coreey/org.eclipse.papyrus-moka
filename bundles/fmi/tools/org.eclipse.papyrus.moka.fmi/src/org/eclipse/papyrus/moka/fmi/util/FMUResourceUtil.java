/*****************************************************************************
 * 
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
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmi.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.ArchiveToUnzipInFMU;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelFactory;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.FolderToCreateInFMU;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.JavaFileProxy;

public class FMUResourceUtil {

	public static final String MODEL_DESCRIPTION_FILE_NAME = "modelDescription.xml";
	public static final String FOLDER_RESOURCES = "resources";
	public static final String FOLDER_DOCUMENTATION= "documentation";
	public static final String FOLDER_SOURCES= "sources";
	
	public static final String FOLDER_BINARIES= "binaries";
	public static final String BINARIES_WIN32= "win32";
	public static final String BINARIES_WIN64= "win64";
	public static final String BINARIES_LINUX32= "linux32";
	public static final String BINARIES_LINUX64= "linux64";
	public static final String BINARIES_DARWIN32= "darwin32";
	public static final String BINARIES_DARWIN64= "darwin64";
	
	public static final URI MODEL_DESCRIPTION_ZIP_URI = URI.createURI("fmi:/fmuTmp");
	
	
	
	public static Collection<? extends JavaFileProxy> createJavaFileProxies(File[] listFiles) {
		List<JavaFileProxy> ret = new ArrayList<JavaFileProxy>();
		for (File file : listFiles) {
			ret.add(createJavaFileProxy(file));
		}
		return ret;
	}

	public static JavaFileProxy createJavaFileProxy(File file) {
		return createJavaFileProxy(file, null);
	}
	
	public static JavaFileProxy createJavaFileProxy(File file, String newName) {
		JavaFileProxy ret = FmumetamodelFactory.eINSTANCE.createJavaFileProxy();
		if (newName != null){
			ret.setName(newName);
		}
		ret.setFile(file);
		return ret;
	}
	
	public static ArchiveToUnzipInFMU createArchiveToUnzipInFMU(File archiveFile, String newName){
		ArchiveToUnzipInFMU ret = FmumetamodelFactory.eINSTANCE.createArchiveToUnzipInFMU();
		ret.setArchiveFile(archiveFile);
		if (newName != null){
			ret.setName(newName);
		}
		return ret;
	}
	
	public static ArchiveToUnzipInFMU createArchiveToUnzipInFMU(File archiveFile){
		return createArchiveToUnzipInFMU(archiveFile, null);
	}
	
	public static FolderToCreateInFMU createFolderToCreateInFMU(String folderName){
		FolderToCreateInFMU ret = FmumetamodelFactory.eINSTANCE.createFolderToCreateInFMU();
		ret.setName(folderName);
		return ret;
	}

	public static boolean isAStandardFile(File fmuChildFile) {
		String name = fmuChildFile.getName();
		return (MODEL_DESCRIPTION_FILE_NAME.equals(name)
				|| !FOLDER_BINARIES.equals(name)
				|| !FOLDER_DOCUMENTATION.equals(name)
				|| !FOLDER_RESOURCES.equals(name)
				|| !FOLDER_SOURCES.equals(name)
				);
	}
	
}
