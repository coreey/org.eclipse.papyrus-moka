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
package org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.xtend;

import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.processor.FumlLibraryData
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.processor.FumlUMLGenerator
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.processor.FumlLibraryProcessor

public class BehaviorRegistryGenerator{
	
	def public static String fullyQualifiedClassName(FumlLibraryData data)
	'''«data.packageName».« className(data) »'''
	
	def public static String className(FumlLibraryData data)
	'''« data.libraryName »BehaviorRegistry'''
	
	def public static String libraryFileName(FumlLibraryData data)
	'''« data.libraryName ».uml'''
	
	def public static String libraryURI(FumlLibraryData data)
	'''« libraryURISource(data) »«libraryFileName (data)»'''
	
	def public static String libraryURISource(FumlLibraryData data)
	'''pathmap://« FumlLibraryProcessor.camelToUpperDash(data.libraryName) »/'''
	
	def public static String generate(FumlLibraryData data)'''
	package « data.packageName »;
		
	import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
	import org.eclipse.papyrus.moka.fuml.registry.AbstractOpaqueBehaviorExecutionRegistry;
	
	public class « className(data) » extends AbstractOpaqueBehaviorExecutionRegistry{
		protected final static String LIBRARY_NAME = "« data.libraryName »";
		protected final static String LIBRARY_URI = "« libraryURI(data) »";
		
		@Override
		public void registerOpaqueBehaviorExecutions(ILocus locus) {
			this.locus = locus;
			this.buildOpaqueBehaviorsMap(LIBRARY_URI);
			
			try{
				«FOR function : data.functions »
				this.registerOpaqueBehaviorExecution(new «function.name.toFirstUpper»Behavior(), "« data.libraryName »::«FumlUMLGenerator.GEN_PACKAGE_NAME»::«function.name»");					
				«ENDFOR»
			}catch(Exception e){
				System.err.println(e);
			}
		}
	} 
	'''
}