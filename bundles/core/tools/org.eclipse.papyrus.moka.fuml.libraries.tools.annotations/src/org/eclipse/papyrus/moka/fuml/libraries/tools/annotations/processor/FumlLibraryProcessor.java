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
import java.io.Writer;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.JavaFileObject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.Activator;
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.FBImplementation;
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.FBInParam;
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.FBLibraryClass;
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.FBOutParam;
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.processor.FumlLibraryData.OpaqueFunction;
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.processor.FumlLibraryData.OpaqueFunctionParameter;
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.processor.FumlLibraryData.ParameterDirection;
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.xtend.BehaviorRegistryGenerator;
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.xtend.OpaqueBehaviorExecutionGenerator;
import org.eclipse.pde.core.plugin.IPluginModel;
import org.eclipse.pde.internal.core.bundle.WorkspaceBundlePluginModel;


@SupportedAnnotationTypes("org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.FBLibraryClass")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class FumlLibraryProcessor extends AbstractProcessor{

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		
		for( final Element element: roundEnv.getElementsAnnotatedWith(FBLibraryClass.class)){
			if( element instanceof TypeElement ){
				processElement((TypeElement) element);
			}
		}
		
		return true;
	}
	
	public void processElement(TypeElement e){
		IProject project = AnnotationUtil.getProjectForFile(processingEnv);
		
		FumlLibraryData data = getLibraryData(e);
		
		setupExtensionPoints(project, data);
		
		try {
			FumlUMLGenerator.makeUMLLibrary(project, data);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		try {
			setupLibraryIcon(project);
		} catch (CoreException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		generateJavaFiles(project, data);
	}
	
	private final void generateJavaFiles(IProject project, FumlLibraryData data){
		try {
			JavaFileObject jfo = processingEnv.getFiler().createSourceFile(BehaviorRegistryGenerator.fullyQualifiedClassName(data));
			Writer writer = jfo.openWriter();
			writer.write(BehaviorRegistryGenerator.generate(data));
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		for( OpaqueFunction f : data.functions() ){
			try {
				JavaFileObject jfo = processingEnv.getFiler().createSourceFile(data.packageName() + "." + OpaqueBehaviorExecutionGenerator.className(f) );
				Writer writer = jfo.openWriter();
				writer.write(OpaqueBehaviorExecutionGenerator.generate(f, data));
				writer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private static final void setupLibraryIcon(IProject project) throws CoreException, IOException{
		IFolder iconDir = project.getFolder(UMLLibraryExtensionHandler.ICON_DIR);
		
		if( !iconDir.exists() )
			iconDir.create(IResource.NONE, true, null);
		
		IFile iconFile = iconDir.getFile(UMLLibraryExtensionHandler.ICON_FILE);
		
		if( !iconFile.exists() ){
			iconFile.create(Activator.getDefault().getBundle().getEntry(UMLLibraryExtensionHandler.ICON_SRC_IN_BUNDLE).openStream(), 
					IFile.FORCE, 
					null);
		}
	}
	
	public static final String camelToUpperDash(String str){
		StringBuffer b = new StringBuffer();
		
		for( int i = 0; i < str.length(); i++ ){
			if( Character.isUpperCase(str.charAt(i)) && i != 0 ) {
				b.append('_');				
			}
			b.append( Character.toUpperCase(str.charAt(i)) );
		}
		
		return b.toString();
	}
	
	private FumlLibraryData getLibraryData(TypeElement e){
		
		FumlLibraryData data = new FumlLibraryData();
		data.setClassElement(e);
		data.setPackageName( ((PackageElement)e.getEnclosingElement()).getQualifiedName().toString() );		
		data.setLibraryName( e.getAnnotation(FBLibraryClass.class).name() );
		
		for( Element enclosed : e.getEnclosedElements() ){
			if( enclosed.getKind() == ElementKind.METHOD ){
				OpaqueFunction f = new OpaqueFunction();
				FBImplementation fb = enclosed.getAnnotation(FBImplementation.class);
				if( fb != null ){
					data.functions().add(f);
					f.setName( fb.name() );
					f.setMethodName(enclosed.getSimpleName().toString());
					
					ExecutableElement method = (ExecutableElement) enclosed;
					
					for(VariableElement param : method.getParameters() ){
						
						OpaqueFunctionParameter p = new OpaqueFunctionParameter();
						p.setName(param.getSimpleName().toString());
						p.setFqType( param.asType().toString() );
					
						if( param.getAnnotation(FBOutParam.class) != null )
							p.setDirection(ParameterDirection.OUT);							
							
						if( param.getAnnotation(FBInParam.class) != null )
							p.setDirection(ParameterDirection.IN);
						
						f.params().add(p);
					}
				}
			}
		}
		
		return data;
	}
	
	private String makeUriTarget(String pluginId){
		return "platform:/plugin/" + pluginId + FumlUMLGenerator.OUT_UML_FOLDER + "/";
	}
	
	private void setupExtensionPoints(IProject project, FumlLibraryData libData){		
		
		FumlLibraryExtensionHandler fumlExtHandler = new FumlLibraryExtensionHandler();
		UMLLibraryExtensionHandler umlExtHandler = new UMLLibraryExtensionHandler();
		URIMappingExtensionHandler uriExtHandler = new URIMappingExtensionHandler();
		
		IPluginModel readOnlyPlugin = PluginUtil.getReadOnlyPluginModel(project);
		
		//Load
		FumlLibraryExtensionData fumlExtData = fumlExtHandler.load(readOnlyPlugin);
		UMLLibraryExtensionData umlExtData = umlExtHandler.load(readOnlyPlugin);
		URIMappingExtensionData uriExtData = uriExtHandler.load(readOnlyPlugin);
		
		//Update
		fumlExtData.libraryClass = BehaviorRegistryGenerator.fullyQualifiedClassName(libData);//libData.classElement.getQualifiedName().toString();
		
		umlExtData.libraryName = libData.libraryName();
		umlExtData.path = BehaviorRegistryGenerator.libraryURI(libData);
		
		uriExtData.source = BehaviorRegistryGenerator.libraryURISource(libData);
		uriExtData.target = makeUriTarget(readOnlyPlugin.getPlugin().getId());
		
		
		//Save
		WorkspaceBundlePluginModel wbpm = PluginUtil.makeWritableBundle(project, readOnlyPlugin);
		
		fumlExtHandler.saveTo(wbpm, fumlExtData);
		umlExtHandler.saveTo(wbpm, umlExtData);
		uriExtHandler.saveTo(wbpm, uriExtData);
		
		wbpm.save();
	}

}
