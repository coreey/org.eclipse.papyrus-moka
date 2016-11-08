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
package org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.xtend

import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.processor.FumlLibraryData
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.processor.FumlLibraryData.OpaqueFunction
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.processor.FumlLibraryData.OpaqueFunctionParameter
import org.eclipse.papyrus.moka.fuml.libraries.tools.annotations.processor.FumlLibraryData.ParameterDirection

public class OpaqueBehaviorExecutionGenerator{
	
	public def static String className(OpaqueFunction f)
	'''« f.name.toFirstUpper »Behavior'''
	
	def static String genInputParamString(OpaqueFunctionParameter p, int i, int size)'''
	(« p.fqType ») in.get(« i »).getValues().get(0)« IF i != size - 1 »,
	«ENDIF»
	'''
	
	def static String generate(OpaqueFunction f, FumlLibraryData lib)'''
	package « lib.packageName »;
	«var hasOutput = f.countParams(ParameterDirection.OUT) > 0 »
	
	«IF hasOutput»
	import java.util.ArrayList;
	«ENDIF»	
	import java.util.List;
	
	import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
	import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
	import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
	
	public class « className(f) » extends OpaqueBehaviorExecution{
		
		@Override
		public void doBody(List<IParameterValue> in, List<IParameterValue> out) {
			«var inputIdx = 0 »
			«IF hasOutput »
				List<IValue> outputs = new ArrayList<IValue>();
			«ENDIF»
			
			«FOR op : f.params »
				«IF op.direction == ParameterDirection.OUT »
					« op.fqType » « op.name » = new « op.fqType »(); 
					outputs.add(« op.name »);
				«ENDIF»
				«IF op.direction == ParameterDirection.IN »
					« op.fqType » « op.name » = (« op.fqType ») in.get(« inputIdx++ »).getValues().get(0);
				«ENDIF»
			« ENDFOR »
			
			«lib.classElement.simpleName».«f.methodName»(«FOR op : f.params SEPARATOR ',' »«op.name»« ENDFOR »);

			«IF hasOutput »
			out.get(0).setValues(outputs);
			«ENDIF»
		}
		
		@Override
		public IValue new_() {
			return new « className(f) »();
		}
	}
	'''
}