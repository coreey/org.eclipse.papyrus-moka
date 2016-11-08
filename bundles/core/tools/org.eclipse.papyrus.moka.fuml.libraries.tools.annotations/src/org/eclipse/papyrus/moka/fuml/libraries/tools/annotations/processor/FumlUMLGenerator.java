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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.processor.FumlLibraryData.OpaqueFunction;
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.processor.FumlLibraryData.OpaqueFunctionParameter;
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.processor.FumlLibraryData.ParameterDirection;
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.xtend.BehaviorRegistryGenerator;
import org.eclipse.papyrus.moka.simex.utils.UMLPrimitiveTypesUtils;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;


public class FumlUMLGenerator {
	
	public static final String GEN_PACKAGE_NAME = "OpaqueBehaviors";
	public static final String OUT_UML_FOLDER = "/resources";
	
	
	public static String umlFileRelativePath(FumlLibraryData data){
		return OUT_UML_FOLDER + "/" + BehaviorRegistryGenerator.libraryFileName(data);
	}
	
	public static void makeUMLLibrary(IProject project, FumlLibraryData data) throws IOException{
		//Find the location URI.
		IFile file = project.getFile( umlFileRelativePath(data) );

		//Load the primitive model. (This could be cached)
		ResourceSet rSet = new ResourceSetImpl();
		Model primitiveModel = loadPrimitiveModel(rSet);
		
		Model model = null;
		Resource modelResource = rSet.createResource(URI.createFileURI(file.getFullPath().toOSString()));
		
		if( file.exists() ){
			modelResource.load(Collections.EMPTY_MAP);
			model = (Model)modelResource.getContents().iterator().next();
		}else{
			model = makeEmptyModel(data, primitiveModel);
			modelResource.getContents().add(model);
		}
		
		//The synchronization could be done after checking if there's anything to be done on the model.
		synchFunctionBehaviors(primitiveModel, (Package)model.getPackagedElements().iterator().next(), data);
		
		//Only should save if synchronization changed anything.
		modelResource.save(Collections.EMPTY_MAP);
	}
	
	public static Model loadPrimitiveModel(ResourceSet rSet){
		Resource primitiveTypesUml = rSet.getResource(URI.createURI("pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml"), true);
		return (Model)primitiveTypesUml.getContents().iterator().next();
	}
	
	
	public static Model makeEmptyModel(FumlLibraryData data, Model primitiveModel){
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName(data.libraryName());
		
		//Setup package
		Package obPack = UMLFactory.eINSTANCE.createPackage();
		obPack.setName(GEN_PACKAGE_NAME);
		model.getPackagedElements().add(obPack);
		
		//Connect with primitivePackage
		PackageImport primivePackage = UMLFactory.eINSTANCE.createPackageImport();
		primivePackage.setImportedPackage(primitiveModel);
		model.getPackageImports().add(primivePackage);
		
		return model;
	}
	
	
	public static void synchFunctionBehaviors( Model primitiveModel, Package previous,  FumlLibraryData data){
		List<PackageableElement> elms = previous.getPackagedElements();
		
		//1. Remove the functions that were deleted/renamed
		for(int i = 0; i < elms.size(); i++){
			if( !(elms.get(i) instanceof FunctionBehavior) )
				continue;
			
			FunctionBehavior f = (FunctionBehavior) elms.get(i);
			OpaqueFunction cMatch = data.getFunction(f.getName());
			
			if( cMatch == null ){ //This is not in the current data model
				elms.remove(i);
				i--;
				continue;
			}
			
			//It's in the new library. Synchronize the parameters.
			synchParams(primitiveModel, f, cMatch);
		}
		
		//2. Add the functions that are absent from the model.
		addNewFunctions(primitiveModel, previous,  data);
	}
	
	private static void addNewFunctions(Model primitiveModel, Package previous, FumlLibraryData data) {
		for( OpaqueFunction opFunc : data.functions() ){
			if( getFunctionBehavior(previous, opFunc.name()) == null ){
				FunctionBehavior fb = makeFunctionBehavior(primitiveModel, opFunc);
				previous.getPackagedElements().add(fb);
			}
		}
	}

	private static FunctionBehavior makeFunctionBehavior(Model primitiveModel, OpaqueFunction opFunc) {
		FunctionBehavior umlF = UMLFactory.eINSTANCE.createFunctionBehavior();
		umlF.setName(opFunc.name());
		
		for( OpaqueFunctionParameter p : opFunc.params() ){
			ParameterDirectionKind kind = ParameterDirectionKind.IN_LITERAL;
			
			if( p.direction() == ParameterDirection.OUT )
				kind = ParameterDirectionKind.OUT_LITERAL;
			
			umlF.getOwnedParameters().add( makeParameter(primitiveModel, p, kind) );
		}

		return umlF;
	}

	private static void synchParams(Model primitiveModel, FunctionBehavior f, OpaqueFunction opFunc) {
		
		removeUnsetParameters(f, opFunc);
		//Add the remaining parameters.
		addSetParameters(primitiveModel, f, opFunc);
		//Synchronize positions.
		synchPositions(f, opFunc);
	}
	
	private static void synchPositions(FunctionBehavior f, OpaqueFunction opFunc) {
		List<Parameter> tmp = new ArrayList<Parameter>(opFunc.params().size());
		
		tmp.addAll( f.getOwnedParameters() );
		
		f.getOwnedParameters().clear();
		
		for (int i = 0; i < opFunc.params().size(); i++) {
			String name = opFunc.params().get(i).name();
			int pos = searchForParam(tmp, name);
			f.getOwnedParameters().add( tmp.remove(pos) );
		}
	}

	private static int searchForParam(List<Parameter> params, String name){
		for (int i = 0; i < params.size(); i++) {
			if( name.equals( params.get(i).getName() )  )
				return i;
		}
		
		return -1;
	}
	
	private static void removeUnsetParameters(FunctionBehavior f, OpaqueFunction opFun){
		List<Parameter> parameters = f.getOwnedParameters();
		for (int i = 0; i < parameters.size(); i++) {
			Parameter p = parameters.get(i);
			if( p.getDirection() == ParameterDirectionKind.IN_LITERAL  &&
				( opFun.getInputParameter(p.getName()) == null ) ){
					parameters.remove(i);
					i--;
					continue;
				}
			
			if( p.getDirection() == ParameterDirectionKind.OUT_LITERAL  &&
					( opFun.getOuputParameter(p.getName()) == null ) ){
				parameters.remove(i);
				i--;
				continue;
			}
		}
	}
	
	private static Parameter getParameter(List<Parameter> params, String name, ParameterDirectionKind dir){
		for( Parameter p : params )
			if( p.getName().equals(name) && p.getDirection() == dir )
				return p;
		
		return null;
	}
	
	private static FunctionBehavior getFunctionBehavior(Package pack, String name){
		for( PackageableElement elm : pack.getPackagedElements() )
			if( elm instanceof FunctionBehavior && name.equals(elm.getName()) )
				return (FunctionBehavior)elm;
		
		return null;
	}
	
	private static void addSetParameters(Model primitiveModel, FunctionBehavior f, OpaqueFunction opFun){
		for( OpaqueFunctionParameter p : opFun.params() ){
			
			ParameterDirectionKind kind = ParameterDirectionKind.IN_LITERAL;
			
			if( p.direction() == ParameterDirection.OUT )
				kind = ParameterDirectionKind.OUT_LITERAL;
			
			if( getParameter(f.getOwnedParameters(), p.name(), kind) == null ){
				Parameter umlP = makeParameter(primitiveModel, p, kind);
				f.getOwnedParameters().add(umlP);
			}
		}
		
	}
	
	private static Parameter makeParameter(Model primitiveModel, OpaqueFunctionParameter p, ParameterDirectionKind dir){
		Parameter umlP = UMLFactory.eINSTANCE.createParameter();
		umlP.setName(p.name());
		umlP.setDirection(dir);
		Type t = getPrimitiveTypeFor(p.fqType(), primitiveModel);
		umlP.setType(t);
		return umlP;
	}

	public static FunctionBehavior getFunction( String name, Package from ){
		for( PackageableElement e : from.getPackagedElements()){
			if( e instanceof FunctionBehavior ){
				FunctionBehavior fb = (FunctionBehavior) e;
				if( name.equals( fb.getName() ) )
					return fb;
			}
		}
		return null;
	}
	
	public static Type getPrimitiveTypeFor(String semanticFullyQualifiedClass, Model primitiveModel){
		
		switch(semanticFullyQualifiedClass){
			case "org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.IntegerValue":
				return UMLPrimitiveTypesUtils.getInteger(primitiveModel);
				
			case "org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.RealValue":
				return UMLPrimitiveTypesUtils.getReal(primitiveModel);
				
			case "org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.StringValue":
				return UMLPrimitiveTypesUtils.getString(primitiveModel);
				
			case "org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.BooleanValue":
				return UMLPrimitiveTypesUtils.getBoolean(primitiveModel);
				
			case "org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.UnlimitedNaturalValue":
				return UMLPrimitiveTypesUtils.getUnlimitedNatural(primitiveModel);
		}
		
		return null;
	}
}
