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
package org.eclipse.papyrus.moka.standalone.rcp;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.papyrus.moka.composites.CompositeStructuresExecutionEngine;
import org.eclipse.papyrus.moka.engine.IExecutionEngine.OperatingMode;
import org.eclipse.uml2.uml.Behavior;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * This class controls all aspects of the application's execution
 */
public class MokaApplication implements IApplication {

	private static final String MODEL_ARG = "model";
	private static final String BEHAVIOR_NAME_ARG = "behavior";
	private static final String DURATION_ARG = "duration";
	private static final String RESOLVE_ARG = "resolve";

	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		
		CommandLine cmdLine = parseArgs(context);
		
		if (cmdLine != null){
			String modelPath = cmdLine.getOptionValue(MODEL_ARG);
			String behaviorName = cmdLine.getOptionValue(BEHAVIOR_NAME_ARG);
			String duration = cmdLine.getOptionValue(DURATION_ARG);
			boolean resolve = cmdLine.hasOption(RESOLVE_ARG);
			if (duration == null){
				duration  = "-1.0";
			}
			if (modelPath!= null){
				ResourceSet resSet = new ResourceSetImpl();
				URI resURI = URI.createFileURI(modelPath);
				Resource res = resSet.getResource(resURI, true);
				if (resolve){
					EcoreUtil.resolveAll(resSet);
				}
				
				if( res != null){
					if (behaviorName != null){
						Behavior behavior = getBehaviorByName(res, behaviorName);
						if (behavior != null){
							return runSimulation(behavior, duration);
						}else {
							System.err.println("ERROR : did not find behavior \"" + behaviorName+"\" in model \"" + resURI.toFileString()+"\"" );
							return 1;
						}
						
					}else {
						System.err.println("ERROR : missing argument \"" + BEHAVIOR_NAME_ARG+"\"" );
						return 1;
					}
					
				}else {
					System.err.println("ERROR : could not load model " +resURI.toFileString() );
					return 1;
				}
				
			}else {
				System.err.println("ERROR : missing argument \"" + MODEL_ARG+"\"" );
				return 1;
			}
		}else {
			return 1;
		}
		
		
	}

	private CommandLine parseArgs(IApplicationContext context) {
		System.out.println("Starting Moka Application");
		Map<String, Object> argMap = context.getArguments();
		String[] appArgs = (String[]) argMap.get(IApplicationContext.APPLICATION_ARGS);
		
		// create Options object
		Options options = new Options();
		// add t option
		options.addOption(MODEL_ARG, true, "path to the UML model");
		options.addOption(BEHAVIOR_NAME_ARG, true, " qualified name of the behavior to execute");
		options.addOption(DURATION_ARG, true, " duration of simlution (simulated time)");
		options.addOption(RESOLVE_ARG, false, " tells if resource should be resolved before");
		
		CommandLineParser parser = new BasicParser();
		try {
			CommandLine cmd = parser.parse( options, appArgs);
			return cmd;
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		return null;
	}

	private Object runSimulation(Behavior behavior, String duration) {
		CompositeStructuresExecutionEngine engine = new CompositeStructuresExecutionEngine();
		System.out.println("Launching engine PSCS Execution Engine");
		engine.init(null, behavior, new String[]{}, OperatingMode.QUIET);
		engine.start(new NullProgressMonitor());
		return 0;
	}

	private Behavior getBehaviorByName(Resource res, String behaviorName) {
		Iterator<EObject> iter = res.getAllContents();
		while (iter.hasNext()) {
			EObject eObject = (EObject) iter.next();
			if (eObject instanceof Behavior && behaviorName.equals(((Behavior)eObject).getQualifiedName())){
				return (Behavior) eObject;
			}
		}
		return null;
	}


	@Override
	public void stop() {
		// nothing to do
	}
}
