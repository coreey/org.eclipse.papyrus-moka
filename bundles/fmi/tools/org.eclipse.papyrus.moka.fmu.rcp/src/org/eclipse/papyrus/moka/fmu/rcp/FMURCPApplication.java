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
package org.eclipse.papyrus.moka.fmu.rcp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.papyrus.moka.engine.IExecutionEngine;
//import org.eclipse.papyrus.moka.composites.CompositeStructuresExecutionEngine;
import org.eclipse.papyrus.moka.engine.IExecutionEngine.OperatingMode;
import org.eclipse.papyrus.moka.fmi.fmu.FMUParser;
import org.eclipse.papyrus.moka.fmu.engine.MokaEngineForFMUExport;
import org.eclipse.papyrus.moka.fmu.engine.utils.FMUEngineUtils;
import org.eclipse.papyrus.moka.fmu.json.JSONSocketClient;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.UMLPlugin;

/**
 * This class controls all aspects of the application's execution
 */
public class FMURCPApplication implements IApplication {

	private static final String FMU_PATH = "fmu";
	private static final String PORT_NUMBER = "port";
	public static final String MOKA_PROP_FILE_NAME = "moka.properties";
	public static final String MODEL_PATH_PROP = "model.path";
	public static final String FMU_QN = "fmu.qualifiedname";
	public static final String FMU_ID = "fmu.id";
	public static final String PROFILE_URI_MAP = "profile.map";
	public static final String URI_REMAP = "uri.map";
	
	



	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("FMU RCP Running");
		CommandLine cmdLine = parseArgs(context);

		if (cmdLine != null){
			String unzippedFmuPath = cmdLine.getOptionValue(FMU_PATH);
			String portNumber = cmdLine.getOptionValue(PORT_NUMBER);

			if (portNumber == null) {
				throw new Exception("The argument "+ PORT_NUMBER +" should be specified");
			}
			int portNumberInt = Integer.parseInt(portNumber);

			JSONSocketClient client = new JSONSocketClient(portNumberInt);
			FMUEngineUtils.setJSONSocketClient(client);
			
			if (unzippedFmuPath == null){
				throw new Exception("The argument "+ FMU_PATH +" should be specified");
			}

			FMUParser handler = new FMUParser(unzippedFmuPath, false);

			File resourceFolder = handler.getResourceFolder();
			if (resourceFolder != null){
				Properties mokaProp = new Properties();
				try(InputStream propFileStream = new FileInputStream(resourceFolder.getAbsolutePath() + File.separator + MOKA_PROP_FILE_NAME)){
					mokaProp.load(propFileStream);
				}

				String modelPath = mokaProp.getProperty(MODEL_PATH_PROP);
				String fmuID = mokaProp.getProperty(FMU_ID);
				
				URI resURI = URI.createFileURI(resourceFolder.getAbsolutePath()+"/"+modelPath);
				initProfileMap(mokaProp, resourceFolder.getAbsolutePath());
				ResourceSet resSet = initResourceSet(mokaProp, resourceFolder.getAbsolutePath());
				
				double startLoad =  System.nanoTime();
				Class fmuClass = loadFMUClass(resSet, resURI, fmuID );
				System.out.println("FMU loaded:"+((System.nanoTime()-startLoad)/1000000)+"ms");
				if (fmuClass != null){
					
					launchSimulation(fmuClass);
					
				}

			}else {
				throw new Exception("FMU doesn't contain a resource folder");
			}
		}

		return IApplication.EXIT_OK;

	}


	private ResourceSet initResourceSet(Properties mokaProp, String resourceFolderPath) {
		ResourceSet resSet = new ResourceSetImpl();
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_DEFER_ATTACHMENT, true);
		options.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, true);
		options.put(XMLResource.OPTION_DISABLE_NOTIFY, true);
		options.put(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, new HashMap< >());
		options.put(XMLResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());
		options.put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.FALSE);
		
		resSet.getLoadOptions().putAll(options);
		
		initURIRemMap(mokaProp, resourceFolderPath, resSet);
		
		return resSet;
	}


	private void initURIRemMap(Properties mokaProp, String resourceFolder, ResourceSet resSet) {
		String propValue = mokaProp.getProperty(URI_REMAP);
		if (propValue != null){
			for (String mapEntry : propValue.split(",")){
				String[] entrySplit = mapEntry.split("=");
				String sourceURI = entrySplit[0];
				String targetURI = entrySplit[1];
				resSet.getURIConverter().getURIMap().put(URI.createURI(sourceURI), URI.createFileURI(resourceFolder+"/"+ targetURI));
			}
		}
		
	}

	private void initProfileMap(Properties mokaProp, String resourceFolder) {
		String propValue = mokaProp.getProperty(PROFILE_URI_MAP);
		if (propValue != null){
			for (String mapEntry : propValue.split(",")){
				String[] entrySplit = mapEntry.split("=");
				String ecorePackURI = entrySplit[0];
				String profileRelativeURI = entrySplit[1];
				String structuredProfileRelativeURI[]=profileRelativeURI.split("#");
				String profilePath =structuredProfileRelativeURI[0];
				String profileFragment= structuredProfileRelativeURI[1];
				UMLPlugin.getEPackageNsURIToProfileLocationMap().put(ecorePackURI,URI.createFileURI(resourceFolder+"/"+profilePath).appendFragment(profileFragment));
			}
		}
		
	}



	private void launchSimulation(Class fmuClass) throws InterruptedException {
		MokaEngineForFMUExport engine = new MokaEngineForFMUExport();
		((IExecutionEngine)engine).init(null, fmuClass, new String[]{}, OperatingMode.NORMAL);		
		engine.start(new NullProgressMonitor());
		engine.waitForTermination();
	}

	private Class loadFMUClass(ResourceSet resSet, URI resURI, String fmuID) {
		if (resURI!= null && fmuID != null){
			
			
			Resource res = resSet.createResource(resURI);
			res.eSetDeliver(false);
		
			try {
				res.load(resSet.getLoadOptions());
			} catch (IOException e) {
				e.printStackTrace();
			}	
			
			if (res != null){
				return (Class) res.getEObject(fmuID);
			}

		}
		return null;
	}

	private CommandLine parseArgs(IApplicationContext context) {
		System.out.println("Starting Moka Application");
		Map<String, Object> argMap = context.getArguments();
		String[] appArgs = (String[]) argMap.get(IApplicationContext.APPLICATION_ARGS);

		// create Options object
		Options options = new Options();
		// add t option
		options.addOption(PORT_NUMBER, true, " JSON socket server port number");
		options.addOption(FMU_PATH, true, " path to the unzipped FMU folder");

		CommandLineParser parser = new BasicParser();
		try {
			CommandLine cmd = parser.parse( options, appArgs);
			return cmd;
		} catch (ParseException e) {

			e.printStackTrace();
		}


		return null;
	}

	


	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		// nothing to do
	}
}
