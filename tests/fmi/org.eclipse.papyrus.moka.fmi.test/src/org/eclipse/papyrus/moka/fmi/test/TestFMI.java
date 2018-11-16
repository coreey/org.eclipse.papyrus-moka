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
package org.eclipse.papyrus.moka.fmi.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.papyrus.moka.fmi.fmi2uml.FMI2UML;
import org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU;
import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage;
import org.eclipse.papyrus.moka.fmi.fmu.FMUParser;
import org.eclipse.papyrus.moka.fmi.fmu.FMUResource;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.AbstractFile;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.ArchiveToUnzipInFMU;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.JavaFileProxy;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType;
import org.eclipse.papyrus.moka.fmi.profile.util.FMIProfileUtil;
import org.eclipse.papyrus.moka.fmi.util.FMUResourceUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.junit.Test;

public class TestFMI {

	private static final String SUBARCHIVE_FOLDER_NAME = "subArchive";
	private static String testFMUPath = "resources/PV.fmu";
	private static String testArchiveToAddPath = "resources/subResources.zip";
	
	@Test
	public void testFMUHandler(){
		
		URL bundleFMUUrl =FileLocator.find(Platform.getBundle(Activator.bundleID),new Path(testFMUPath), null);
		try {
			URL fileFMUURL = FileLocator.toFileURL(bundleFMUUrl);
			FMUParser handler = new FMUParser(fileFMUURL.getFile());
			
			assertTrue(handler.getModelDescription() instanceof FmiModelDescriptionType);
			File fmuTmpFolder = handler.getFMUFolder();
			
			assertNotNull(fmuTmpFolder);
			assertTrue(fmuTmpFolder.exists());
			
			//we the model description is reparsed after unzip in tmp folder we check it's ok
			assertTrue(handler.getModelDescription() instanceof FmiModelDescriptionType);
			
			assertNotNull(handler.getCosimulationLibrary());
			assertTrue(handler.getCosimulationLibrary().exists());
			
			
			FMUParser newHandler = new FMUParser(fmuTmpFolder.getAbsolutePath());
			checkFMUHandlerFromFolder(newHandler);
			
			File fmuFolder = handler.getFMUFolder();
			newHandler.clean();
			assertFalse(fmuFolder.exists());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	private void checkFMUHandlerFromFolder(FMUParser handler) {
		File fmuFolder;
		try {
			fmuFolder = handler.getFMUFolder();
			assertNotNull(fmuFolder);
			assertTrue(fmuFolder.exists());
			
			//we the model description is reparsed after unzip in tmp folder we check it's ok
			assertTrue(handler.getModelDescription() instanceof FmiModelDescriptionType);
			
			assertNotNull(handler.getCosimulationLibrary());
			assertTrue(handler.getCosimulationLibrary().exists());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Test
	public void testFMUResource(){
		Resource res = loadFMUResource();
		assertTrue(res instanceof FMUResource);
		assertFalse(res.getContents().isEmpty());
		assertTrue(res.getContents().get(0) instanceof FMUBundle);
		
		FMUResource fmuRes = (FMUResource) res;
		assertTrue(fmuRes.getFmuParser() instanceof FMUParser);
		FMUParser handler = fmuRes.getFmuParser();
		
		checkFMUHandlerFromFolder(handler);
		
		try {
			File fmuFolder = handler.getFMUFolder();
			res.unload();
			assertFalse(fmuFolder.exists());
		} catch (IOException e) {
			fail();
			e.printStackTrace();
		}
		
		
		}
		
		
	@Test
	public void testSaveFMUResource() throws IOException{
		
		Resource res = loadFMUResource();
		ResourceSet resSet = new ResourceSetImpl();
		FMUBundle bundle = (FMUBundle) res.getContents().get(0);
		
		URL archiveToAddURL =FileLocator.toFileURL(FileLocator.find(Platform.getBundle(Activator.bundleID),new Path(testArchiveToAddPath), null));
		File archiveToAddFile =new File(archiveToAddURL.getFile());
		
		ArchiveToUnzipInFMU archiveToAdd = FMUResourceUtil.createArchiveToUnzipInFMU(archiveToAddFile, SUBARCHIVE_FOLDER_NAME);
		bundle.getResourcesFiles().add(archiveToAdd);
		
		
		File tmpFile = File.createTempFile("testSaveFMU", ".fmu");
		//tmpFile.deleteOnExit();
		URI fmuFileURI =URI.createFileURI(tmpFile.getAbsolutePath()) ;
		Resource savedFMUResource = resSet.createResource(fmuFileURI);
		
		savedFMUResource.getContents().add(bundle);
		savedFMUResource.save(null);
		

		ResourceSet newResSet = new ResourceSetImpl();
		Resource reloadedResource = newResSet.getResource(fmuFileURI, true);
		assertTrue( reloadedResource.getContents().get(0) instanceof FMUBundle);
		
		
		
		
		FMUBundle reloadedBundle = (FMUBundle) reloadedResource.getContents().get(0);
		
		assertFalse(reloadedBundle.getWin64Files().isEmpty());
		assertTrue(reloadedBundle.getResourcesFiles().size() == 4);
		
		for (AbstractFile resourceFile : reloadedBundle.getResourcesFiles()){
			assertTrue (resourceFile instanceof JavaFileProxy);
			JavaFileProxy proxy =(JavaFileProxy)resourceFile;
			assertTrue(proxy.getFile() != null);
			if (proxy.getFile().getName().equals("testEmptySubFolder")){
				assertTrue(proxy.getFile().isDirectory());
				assertTrue(proxy.getFile().listFiles().length==0);	
			}else if (proxy.getFile().getName().equals("testSubFolder")){
				assertTrue(proxy.getFile().isDirectory());
				assertTrue(proxy.getFile().listFiles().length==2);
				for (File subFile : proxy.getFile().listFiles()){
					if (subFile.getName().equals("testEmptySubFolder")){
						assertTrue(proxy.getFile().isDirectory());
						assertTrue(proxy.getFile().listFiles().length==0);
					}
				}
			}else if (proxy.getFile().getName().equals(SUBARCHIVE_FOLDER_NAME)){
				assertTrue(proxy.getFile().listFiles().length == 3);
			}
			
		}
		
		assertTrue(reloadedBundle.getRootFiles().size() ==1);
		assertTrue(reloadedBundle.getRootFiles().get(0).getName().equals("binaries/testFileThatShouldNotBeThere.txt"));
	}
	
	
	private Resource loadFMUResource() {
		URI testFMUURI = URI.createPlatformPluginURI("/"+ Activator.bundleID+"/"+testFMUPath, true);
		ResourceSet resSet = new ResourceSetImpl();
		Resource res = resSet.getResource(testFMUURI, true);
		
		return res;
	}

	@Test
	public void testFMIProfile(){
		FMUResource fmuRes = (FMUResource) loadFMUResource();
		ResourceSet resSet = fmuRes.getResourceSet();
		
		try {
			File tmpFile = File.createTempFile("fmuModel", ".uml");
			tmpFile.deleteOnExit();
			URI umlFileURI =URI.createFileURI(tmpFile.getAbsolutePath()) ;
			Resource umlResource = resSet.createResource(umlFileURI);
			Model umlModel = UMLFactory.eINSTANCE.createModel();
			umlModel.setName("testModel");
			umlResource.getContents().add(umlModel);
			
			Class fmuClass = FMI2UML.getFMUClass((FMUBundle) fmuRes.getContents().get(0), umlModel);
			
		
			
			assertNotNull(fmuClass);
			String expectedClassName = fmuRes.getFmuParser().getModelDescription().getCoSimulation().get(0).getModelIdentifier();
			assertTrue(fmuClass.getName().equals(expectedClassName));
			
			Stereotype csFMUStereo = FMIProfileUtil.getStereotype(umlModel, FMIProfileUtil.CS_FMU_STEREO_NAME, FMIProfilePackage.eINSTANCE);
			EObject application = fmuClass.getStereotypeApplication(csFMUStereo);
			assertTrue(application instanceof CS_FMU);
			CS_FMU csFMU = (CS_FMU) application;
			assertTrue(csFMU.getModelDescription() == fmuRes.getFmuParser().getModelDescription());
			
			Map<Object, Object> options = new HashMap<>();
			options.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, true);
			umlResource.save(options);
			fmuRes.unload();
			umlResource.unload();
			
			resSet = new ResourceSetImpl();
			umlResource = resSet.getResource(umlFileURI, true);
			
			assertFalse(umlResource.getContents().isEmpty());
			assertTrue(umlResource.getContents().get(0) instanceof Model);
			
			umlModel = (Model) umlResource.getContents().get(0);
			assertTrue(umlModel.getOwnedType(expectedClassName) instanceof Class);
			Class umlClass = (Class) umlModel.getOwnedType(expectedClassName) ;
			
			csFMUStereo = umlClass.getAppliedStereotype(FMIProfileUtil.CS_FMU_STEREO_QUALIFIED_NAME);
			assertTrue(csFMUStereo == FMIProfileUtil.getStereotype(umlModel, FMIProfileUtil.CS_FMU_STEREO_NAME, FMIProfilePackage.eINSTANCE));
			
			csFMU = (CS_FMU) umlClass.getStereotypeApplication(csFMUStereo);
			assertTrue(csFMU.getModelDescription() != null);
			assertTrue(csFMU.getModelDescription().eResource() instanceof FMUResource);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	}
