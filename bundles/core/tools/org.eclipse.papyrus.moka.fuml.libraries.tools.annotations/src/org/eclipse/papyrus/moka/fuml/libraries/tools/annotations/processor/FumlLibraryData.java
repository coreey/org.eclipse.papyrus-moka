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

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.TypeElement;

public class FumlLibraryData {
	private TypeElement classElement;
	private String packageName;
	private String libraryName;
	private List<OpaqueFunction> functions;

	public FumlLibraryData() {
		super();
		functions = new ArrayList<>();
		
	}
		
	public TypeElement classElement() {
		return classElement;
	}

	public void setClassElement(TypeElement classElement) {
		this.classElement = classElement;
	}

	public String packageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String libraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public List<OpaqueFunction> functions() {
		return functions;
	}

	public void setFunctions(List<OpaqueFunction> functions) {
		this.functions = functions;
	}

	public OpaqueFunction getFunction(String name){
		for( OpaqueFunction f : functions )
			if( name.equals(f.name ))
				return f;
		
		return null; 
	}
	
	public static class OpaqueFunction{
		private String name;
		private String methodName;
		private List<OpaqueFunctionParameter> params;
		
		public OpaqueFunction() {
			params = new ArrayList<>();
		}
		
		public int countParams(ParameterDirection dir){
			int count = 0;
			
			for(OpaqueFunctionParameter p : params)
				if( p.direction == dir )
					count++;
			
			return count;
		}
		
		private OpaqueFunctionParameter getParameter(String name, ParameterDirection dir){
			for(OpaqueFunctionParameter p : params)
				if( name.equals(p.name) && p.direction == dir )
					return p;
			
			return null;
		}
		
		public OpaqueFunctionParameter getOuputParameter(String name){
			return getParameter(name, ParameterDirection.OUT);
		}
		
		public OpaqueFunctionParameter getInputParameter(String name){
			return getParameter(name, ParameterDirection.IN);
		}
		
		public List<OpaqueFunctionParameter> params(){
			return params;
		}
		
		public String name(){
			return name;
		}
		
		public String methodName(){
			return methodName;
		}
		
		public void setName(String name){
			this.name = name;
		}
		
		public void setMethodName(String methodName){
			this.methodName = methodName;
		}
	}
	
	public static enum ParameterDirection{
		IN,
		OUT
	}
	
	public static class OpaqueFunctionParameter{
		private String name;
		private String fqType;
		private ParameterDirection direction;
		
		public String name() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String fqType() {
			return fqType;
		}
		public void setFqType(String fqType) {
			this.fqType = fqType;
		}
		public ParameterDirection direction() {
			return direction;
		}
		public void setDirection(ParameterDirection direction) {
			this.direction = direction;
		}
	}
	
}
