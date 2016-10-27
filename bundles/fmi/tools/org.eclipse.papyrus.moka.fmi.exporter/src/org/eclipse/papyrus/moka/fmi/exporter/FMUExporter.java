/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmi.exporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.moka.fmi.fmu.FMUResource;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.ArchiveToUnzipInFMU;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelFactory;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.JavaFileProxy;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType;
import org.eclipse.papyrus.moka.fmi.util.FMUResourceUtil;
import org.eclipse.papyrus.moka.fmu.rcp.FMURCPApplication;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPlugin;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.osgi.framework.Bundle;

public class FMUExporter {

	private static final String RESOURCE_DIR = "resources";
	private static final String LIB_NAME = "libfmuwrapper";
	private static final String RCP_FOLDER_NAME = "rcp";

	public static final String MODEL_FODLER = "model";
	
	
	
	private static Map<String, String> platformsToRCPfile;

	private static List<String> dontExportURIs= Arrays.asList();//UMLResource.ECORE_PROFILE_URI);
	
	static {
		platformsToRCPfile = new HashMap<String, String>();
		platformsToRCPfile.put(FMUResourceUtil.BINARIES_LINUX32, "rcp-linux.gtk.x86.zip");
		platformsToRCPfile.put(FMUResourceUtil.BINARIES_LINUX64, "rcp-linux.gtk.x86_64.zip");
		platformsToRCPfile.put(FMUResourceUtil.BINARIES_WIN64, "rcp-win32.win32.x86_64.zip");
	}

	public static void generateFMU(Class umlClass, String fmuName, String outputPath, String targetPlatform,
			String jrePath) {
		ResourceSet resSet = new ResourceSetImpl();

		
		FMUBundle fmuBundle = FmumetamodelFactory.eINSTANCE.createFMUBundle();
	

		addModelDescription(umlClass, fmuName, fmuBundle);
		 List<String> exportedUMLGeneratedPackageURIs = new ArrayList<String>();
		 List<String> remappedURIs = new ArrayList<String>();
		String mainModelPath = addUMLFile(umlClass, resSet, fmuBundle, exportedUMLGeneratedPackageURIs, remappedURIs);

		addPropertiesFile(umlClass, mainModelPath, fmuBundle, exportedUMLGeneratedPackageURIs, remappedURIs);

		addRcp(targetPlatform, fmuBundle);

		addLibrary(targetPlatform, fmuName, fmuBundle);
		
		FMUResource fmuRes = (FMUResource) resSet
				.createResource(URI.createFileURI(outputPath).appendSegment(fmuName).appendFileExtension("fmu"));
		fmuRes.getContents().add(fmuBundle);
		if (jrePath != null) {
			addJRE(jrePath, fmuBundle);
		}

		try {
			fmuRes.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void addJRE(String jrePath, FMUBundle fmuBundle) {
		File jreFile = new File(jrePath);
		JavaFileProxy proxy = FMUResourceUtil.createJavaFileProxy(jreFile, "rcp/jre");
		fmuBundle.getResourcesFiles().add(proxy);
	}

	private static void addLibrary(String targetPlatform, String fmuName, FMUBundle fmuBundle) {
		Bundle bundle = Activator.getDefault().getBundle();

		String fileExtension;
		if (targetPlatform.startsWith("linux")) {
			fileExtension = ".so";
		} else {
			fileExtension = ".dll";
		}
		URL libURL = bundle.getEntry(RESOURCE_DIR + "/" + targetPlatform + "/" + LIB_NAME + fileExtension);
		try {
			libURL = FileLocator.toFileURL(libURL);
			File libFile = new File(libURL.getFile());
			JavaFileProxy proxy = FMUResourceUtil.createJavaFileProxy(libFile, fmuName + fileExtension);

			switch (targetPlatform) {
			case FMUResourceUtil.BINARIES_LINUX32:
				fmuBundle.getLinux32Files().add(proxy);
				break;
			case FMUResourceUtil.BINARIES_LINUX64:
				fmuBundle.getLinux64Files().add(proxy);
				break;
			case FMUResourceUtil.BINARIES_WIN64:
				fmuBundle.getWin64Files().add(proxy);
				break;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void addRcp(String targetPlatform, FMUBundle fmuBundle) {
		Bundle bundle = Activator.getDefault().getBundle();
		URL rcpURL = bundle
				.getEntry(RESOURCE_DIR + "/" + targetPlatform + "/" + platformsToRCPfile.get(targetPlatform));
		try {
			rcpURL = FileLocator.toFileURL(rcpURL);
			File rcpFile = new File(rcpURL.getFile());
			ArchiveToUnzipInFMU archive = FMUResourceUtil.createArchiveToUnzipInFMU(rcpFile);
			archive.setName(RCP_FOLDER_NAME);
			fmuBundle.getResourcesFiles().add(archive);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void addPropertiesFile(Class umlClass, String mainModelPath, FMUBundle fmuBundle, List<String> exportedUMLGeneratedPackageURIs, List<String> remappedURIs) {
		Properties prop = new Properties();
		prop.setProperty(FMURCPApplication.FMU_ID,umlClass.eResource().getURIFragment(umlClass));
		prop.setProperty(FMURCPApplication.MODEL_PATH_PROP, mainModelPath);
		
		Iterator<String> profilesURIMapsIterator = exportedUMLGeneratedPackageURIs.iterator();
		if (profilesURIMapsIterator.hasNext()){
			String propValue = profilesURIMapsIterator.next();
			while(profilesURIMapsIterator.hasNext()){
				propValue +=","+profilesURIMapsIterator.next();
			}
			prop.setProperty(FMURCPApplication.PROFILE_URI_MAP, propValue);
		}
		
		Iterator<String> uriRemapIterator = remappedURIs.iterator();
		if (uriRemapIterator.hasNext()){
			String propValue = uriRemapIterator.next();
			while(uriRemapIterator.hasNext()){
				propValue +=","+uriRemapIterator.next();
			}
			prop.setProperty(FMURCPApplication.URI_REMAP, propValue);
		}
		

		try {
			File propFile = File.createTempFile("fmuExport", null, null); 
			prop.store(new FileOutputStream(propFile), null);
			propFile.deleteOnExit();
			JavaFileProxy proxy = FMUResourceUtil.createJavaFileProxy(propFile, FMURCPApplication.MOKA_PROP_FILE_NAME);
			fmuBundle.getResourcesFiles().add(proxy);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String addUMLFile(Class umlClass, ResourceSet resSet, FMUBundle fmuBundle,  List<String> exportedUMLGeneratedPackageURIs, List<String> remappedURIs) {
		Resource originalUMLResource = umlClass.eResource();
		
		
		
		try {
			Path tmpDirPath = Files.createTempDirectory("fmuExport");

			URI tmpURI = URI.createFileURI(tmpDirPath.toAbsolutePath().toString());
			String mainModelPath= null; 

			//tmpURI = tmpURI.appendSegment(fileName);
			Resource reloadedResource = resSet.getResource(originalUMLResource.getURI(), true);
			EcoreUtil.resolveAll(resSet);
			
			Map<String, URI> staticProfileRegistry = UMLPlugin.getEPackageNsURIToProfileLocationMap();
			Map<Profile, String> savedStaticProfilesMap = new HashMap<Profile, String>();
			Map<String, String> newUriRemap = new HashMap<String, String>();
			List<Resource> sourceResources = new ArrayList<Resource>(resSet.getResources());
			List<Resource> targetResources = new ArrayList<Resource>();
			
//			resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("uml", new Resource.Factory(){
//
//				@Override
//				public Resource createResource(URI uri) {
//					return new BinaryResourceImpl(uri);
//				}
//				
//			});
			
			for (Resource resSetResource : sourceResources){
				if( shouldBeExported(resSetResource)){
					//we get the new output resource with potential new URI remap for resources that were saved in a plugin and referenced 
					//with an URI remap
					Resource outputResource = getOuputResource(resSet, tmpURI, resSetResource, newUriRemap);
					targetResources.add(outputResource);
					if (resSetResource == reloadedResource){
						mainModelPath = getPathRelativeToFMUResourceFolder(tmpURI, outputResource.getURI());
					}
					
					EObject rootObject = resSetResource.getContents().get(0);				
					
					//we also need to redirect EPackage static profiles for profiles which were saved in a plugin an now embedded in the FMU 
					if (rootObject instanceof Profile){
						URI normalizedProfileURI =  resSet.getURIConverter().normalize(EcoreUtil.getURI(rootObject));
						
						for (Map.Entry<String, URI> mapEntry : staticProfileRegistry.entrySet()){
							URI registeredProfileURI = mapEntry.getValue();
							if(normalizedProfileURI.equals( resSet.getURIConverter().normalize(registeredProfileURI))){
								savedStaticProfilesMap.put((Profile) rootObject,mapEntry.getKey());
								break;
							}
								
						}	
					}
					addFilteredContentsInOutputResource(outputResource, resSetResource);
					
					
				}
				
			}
		

		

			for(Map.Entry<String, String> remappedURIEntry : newUriRemap.entrySet()){
				remappedURIs.add(remappedURIEntry.getKey()+"="+remappedURIEntry.getValue());	
			}
			
			
			for(Map.Entry<Profile, String> profileEntry : savedStaticProfilesMap.entrySet()){
				exportedUMLGeneratedPackageURIs.add(profileEntry.getValue()+"="+getPathRelativeToFMUResourceFolder(tmpURI,EcoreUtil.getURI(profileEntry.getKey())));	
			}
			
			
			for (Resource targetRes: targetResources){
				//if (targetRes == reloadedResource){
					//HashMap<Object, Object> options = new HashMap<Object, Object>();
					//options.put(XMLResource.OPTION_BINARY, Boolean.TRUE);
				//}
			
				targetRes.save(null);
				File newResourceFile = new File(targetRes.getURI().toFileString());
				newResourceFile.deleteOnExit();
				
				JavaFileProxy proxy = FMUResourceUtil.createJavaFileProxy(newResourceFile, getPathRelativeToFMUResourceFolder(tmpURI,targetRes.getURI()));
				fmuBundle.getResourcesFiles().add(proxy);
			}
			
			

			return mainModelPath;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private static void addFilteredContentsInOutputResource(Resource outputResource, Resource inputPesource) {
		//we are removing EcoreProfile stereotypeApplications, since they considerably slow down the resource loading
		//process, mainly due to the fact that it's a dynamic profile which has to be fully loaded  for the
		//the stereotype application instantiations. By opposition static profile don't require to load the Profile UML
		//for instantiating the applications.
		//Moreover EcoreProfile is only used for code generation purpose, it is currently not needed for model execution.
		
		List<EObject> objectsToAdd = new ArrayList<EObject>();
		for (EObject content: inputPesource.getContents()){
			if (!UMLResource.ECORE_PROFILE_NS_URI.equals(content.eClass().getEPackage().getNsURI())){
				objectsToAdd.add(content);
				
			}
		}
		outputResource.getContents().addAll(objectsToAdd);
		
		
	}

	private static String getPathRelativeToFMUResourceFolder(URI tmpURI, URI targetURI){
		return targetURI.toString().replaceFirst(tmpURI.toString(),MODEL_FODLER);
	}
	
	private static Resource getOuputResource(ResourceSet resSet, URI tmpURI, Resource resSetResource, Map<String, String> newUriRemap) {
		
		URI sourceURI = resSetResource.getURI();
		URI normalizedSourceURI = resSet.getURIConverter().normalize(sourceURI);
		String resourcePath =normalizedSourceURI.path();
		URI targetURI = URI.createURI(tmpURI.toString()+resourcePath);
		URI normalizedTargetURI = resSet.getURIConverter().normalize(targetURI);
		String normalizedTargetURIString = normalizedTargetURI.toString();
		
		for (Map.Entry<URI, URI> remapEntry : org.eclipse.emf.ecore.resource.URIConverter.URI_MAP.entrySet()){
			if (remapEntry.getKey().isPrefix()){
				URI substitutedSourceURI = sourceURI.replacePrefix(remapEntry.getKey(), remapEntry.getValue());
				if( substitutedSourceURI != null){
					URI substitutedSourceURINormalized =resSet.getURIConverter().normalize(substitutedSourceURI);
					//if our source URI was containing a remapped prefix
					if(substitutedSourceURINormalized.equals(normalizedSourceURI) ){
						//we have to compute the new remap prefix
						//Example : sourceURI = pathmap://EXAMPLE/model/resource.uml
						//URIMAP pathmap://EXAMPLE/ --> platform:/plugin/my.plugin/
						//normalizedSourceURI =  platform:/plugin/my.plugin/model/resource.uml
						//normalizedTargetURI = file://tmpURI/plugin/my.plugin/model/resource.uml
						
						// the new remap is : pathmap://EXAMPLE/  --> file://tmpURI/plugin/my.plugin/
						
						//should be model/resource.uml
						String resourcePathRelativeToRemappedPrefix = sourceURI.deresolve(remapEntry.getKey()).toString();
						 
						String newPrefix = normalizedTargetURIString.substring(0, normalizedTargetURIString.lastIndexOf(resourcePathRelativeToRemappedPrefix));
						newPrefix = newPrefix.replaceFirst(tmpURI.toString(), MODEL_FODLER)+"/";
						newUriRemap.put(remapEntry.getKey().toString(), newPrefix);
						
					}
				}
			}
			
		}
		
		Resource result = resSet.createResource(normalizedTargetURI);
		
		return result;
	}

	private static boolean shouldBeExported(Resource resSetResource) {
		
		if ( resSetResource instanceof UMLResource && !resSetResource.getContents().isEmpty()) {
			return ! dontExportURIs.contains(resSetResource.getURI().toString());
		};
		return false;
	}

	private static void addModelDescription(Class umlClass, String fmuName, FMUBundle fmuBundle) {

		FmiModelDescriptionType modelDesc = MokaUML2FMI.getModelDescription(umlClass, fmuName);
		if (modelDesc != null) {
			fmuBundle.setModelDescription(modelDesc);
		}

	}

}
