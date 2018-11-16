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
package org.eclipse.papyrus.moka.fmi.fmu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.moka.fmi.Activator;
import org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType;
import org.eclipse.papyrus.moka.fmi.modeldescription.DocumentRoot;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage;
import org.eclipse.papyrus.moka.fmi.modeldescription.util.FmiResourceFactoryImpl;
import org.eclipse.papyrus.moka.fmi.util.FMIOSDetector;
import org.eclipse.papyrus.moka.fmi.util.FMUResourceUtil;
import org.eclipse.papyrus.moka.fmi.util.UnzipUtility;

public class FMUParser{




	File resourceFolder;
	File binariesFolder;

	FmiModelDescriptionType modelDescription;

	String fmuPath;
	File fmuFile;
	File fmuFolder;
	ResourceSet resSet ;


	String fmuName;

	boolean isUnzipped=false;

	public FMUParser(String fmuPath) throws FileNotFoundException{
		initializeParser(fmuPath, true);
	}
	
	
	public FMUParser(String fmuPath, boolean autoclean) throws FileNotFoundException{
		initializeParser(fmuPath, autoclean);
	}

	private void initializeParser(String fmuPath, boolean autoclean) throws FileNotFoundException {
		initResourceSet();
		
		this.fmuPath = fmuPath ;
		fmuFile= new File(fmuPath);
		if (!fmuFile.exists()){
			throw new IllegalArgumentException("file "+ fmuPath+" doesn't exist");
		}
		
		
		
		if (fmuFile.isFile()){
			fmuName= fmuFile.getName();
			if (fmuName.contains(".fmu")){
				fmuName = fmuName.substring(0, fmuFile.getName().lastIndexOf(".fmu"));
			}
			if (autoclean){
				setAutoClean();
			}
			initModelDescriptionFromZip();

		}else if (fmuFile.isDirectory()) {
			fmuFolder = fmuFile;
			fmuName = fmuFile.getName();
			isUnzipped = true;
			initModelDescriptionFromFolder();
			//we don't set autoclean by default when an FMU is initialized from an unzipped folder.
			//it is the responsability of the tool which has unzipped the FMU to clean the folder or not

		}
		
	}



	public void setAutoClean() {
		Runtime.getRuntime().addShutdownHook(new Thread("Clean FMU resource tmp folder for "+ this.toString() ){
			@Override
			public void run() {
				if (fmuFolder != null && fmuFolder.exists()){
					clean();
				}
			}
		});
		
	}




	private void initModelDescriptionFromFolder() throws FileNotFoundException {
		try {
			String uri = fmuFolder.getAbsolutePath() + File.separator + FMUResourceUtil.MODEL_DESCRIPTION_FILE_NAME;
			Resource modelDescriptionResource = resSet.getResource(URI.createFileURI(uri), true);
			if (modelDescriptionResource != null && !modelDescriptionResource.getContents().isEmpty()
					&& modelDescriptionResource.getContents().get(0) instanceof DocumentRoot) {
				DocumentRoot root = (DocumentRoot) modelDescriptionResource.getContents().get(0);
				modelDescription = root.getFmiModelDescription();

				Resource resFromZip = resSet.getResource(FMUResourceUtil.MODEL_DESCRIPTION_ZIP_URI, false);
				if (resFromZip != null && resFromZip.isLoaded()) {
					resFromZip.unload();
				}
			}
		} catch (RuntimeException e) {
			throw new FileNotFoundException("Can't find the " + FMUResourceUtil.MODEL_DESCRIPTION_FILE_NAME + " file of the FMU.");
		}
	}



	private void initResourceSet() {
		resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*",
				new FmiResourceFactoryImpl());
		resSet.getPackageRegistry().put(null, FmiPackage.eINSTANCE);
	}


	public void clean(){
		if (fmuFolder != null){
			try {
				deleteFolder(fmuFolder);
			} catch (IOException e) {
				Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.getDefault().getBundle().getSymbolicName(), "Failed to clean fmu folder " + fmuFolder, e));
			}
		}
	}
	public void unzip(String targetFolderPath, boolean erase) throws IOException{
		File targetFolder;
		boolean isTmp =false;
		if (targetFolderPath == null){
			targetFolder = Files.createTempDirectory("fmu").toFile();
			isTmp = true;
		}else {
			targetFolder = new File(targetFolderPath);
		}		

		
		if (targetFolder.isFile()){
			throw new IllegalArgumentException("Target path should be a folder");
		}
		if (fmuFile == null){
			throw new IllegalArgumentException("The FMU archive not initialized");
		}
		fmuFolder = targetFolder;
		
		if (fmuFolder.exists() && !isTmp){
			if (erase){
				deleteFolder(fmuFolder);
				fmuFolder.mkdir();
			}else {
				throw new IllegalArgumentException("FMU folder exists and erase is set to false");
			}
		}
	
		try{
			URI fileUri = URI.createFileURI(fmuFile.getAbsolutePath());
			UnzipUtility.unzip(fileUri, fmuFolder.getAbsolutePath());
		} catch (IOException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.getDefault().getBundle().getSymbolicName(), "Could not unzip fmu archive" + fmuFile, e));
		}

		initModelDescriptionFromFolder();
		isUnzipped = true;
	}


	private void deleteFolder(File folder) throws IOException {
		Path folderPath =  folder.toPath();

		Files.walkFileTree(folderPath, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
					throws IOException
			{
				Files.delete(file);
				return FileVisitResult.CONTINUE;
			}
			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException e)
					throws IOException
			{
				if (e == null) {
					Files.delete(dir);
					return FileVisitResult.CONTINUE;
				} else {
					// directory iteration failed
					throw e;
				}
			}
		});

	}




	private void initModelDescriptionFromZip() {
		try (ZipFile fmuZipFile = new ZipFile(fmuFile);){
			
			if (fmuZipFile!=null){
				ZipEntry modelDescriptionEntry = fmuZipFile.getEntry(FMUResourceUtil.MODEL_DESCRIPTION_FILE_NAME);
				try (InputStream modelDescriptionStream = fmuZipFile.getInputStream(modelDescriptionEntry);){

					Resource modelDescriptionResource = resSet.createResource(FMUResourceUtil.MODEL_DESCRIPTION_ZIP_URI);
					modelDescriptionResource.load(modelDescriptionStream, null)	;

					if (!modelDescriptionResource.getContents().isEmpty() && modelDescriptionResource.getContents().get(0) instanceof DocumentRoot){
						DocumentRoot root = (DocumentRoot) modelDescriptionResource.getContents().get(0);
						modelDescription = root.getFmiModelDescription();
					}

				} catch (IOException e) {
					Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.getDefault().getBundle().getSymbolicName(), "Could not read modelDescription in FMU "+fmuPath, e));
				}
			}
		} catch (IOException e1) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.getDefault().getBundle().getSymbolicName(), "Could not read zipped FMU ", e1));
		}


	}

	public FmiModelDescriptionType getModelDescription(){
		return modelDescription;
	}



	public File getFMUFolder() throws IOException{
		if (! isUnzipped){
			unzip(null, true);
		}
		return fmuFolder;
	}

	public File getCosimulationLibrary() throws FileNotFoundException{
		if (!isUnzipped){
			try {
				unzip(null, true);
			} catch (IOException e) {
				Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.getDefault().getBundle().getSymbolicName(), "failed to unzip FMU " + fmuName));
				return null;
			}
		}
		String dllRelativePath = getCosimulationLibraryRelativePath();
		if (dllRelativePath == null){
			String message = "Could not get compute the dll relative path in FMU " +fmuName;
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.getDefault().getBundle().getSymbolicName(),message));
			throw new FileNotFoundException(message);
		}
		File dllFile = new File(fmuFolder + File.separator + dllRelativePath);
		if (!dllFile.exists()){
			throw new FileNotFoundException("Did not find dll " + dllFile.getAbsolutePath());
		}
		return dllFile;
	}
	
	public String getCosimulationLibraryRelativePath(){
		if (modelDescription != null && ! modelDescription.getCoSimulation().isEmpty()){
			CoSimulationType cosimElem = modelDescription.getCoSimulation().get(0);
			String identifier =cosimElem.getModelIdentifier();
			if (identifier!= null){
				return FMUResourceUtil.FOLDER_BINARIES+File.separator+FMIOSDetector.getOS()+File.separator + identifier +FMIOSDetector.getDLLFileExtension();
			}else {
				Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.getDefault().getBundle().getSymbolicName(), "FMU "+ fmuName + " does not contain a cosimulation model identifier"));
			}
		}else {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.getDefault().getBundle().getSymbolicName(), "FMU "+ fmuName + " does not contain a model description with a cosimulation section"));
		}
		
		return null;
	}
	
	public File getResourceFolder() throws IOException{
		File fmuFolderFile = getFMUFolder();
		File resourceFile = new File(fmuFolderFile.getAbsolutePath() + File.separator + FMUResourceUtil.FOLDER_RESOURCES);
		if (resourceFile.isFile()){
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.getDefault().getBundle().getSymbolicName(), "FMU "+ fmuName + " resources should be a folder, not a file"));
		}
		
		if( !resourceFile.exists()){
			resourceFile.mkdir();
		}
		return resourceFile;
	}


}
