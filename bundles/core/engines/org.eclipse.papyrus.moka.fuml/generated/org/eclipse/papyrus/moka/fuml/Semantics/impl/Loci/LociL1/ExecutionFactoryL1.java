/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.InstanceValueEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.LiteralBooleanEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.LiteralIntegerEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.LiteralNullEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.LiteralRealEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.LiteralStringEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.LiteralUnlimitedNaturalEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.CallEventBehavior;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.CallEventExecution;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;

public class ExecutionFactoryL1 extends ExecutionFactory {

	public ExecutionFactoryL1() {
		super();
	}

	@Override
	public ISemanticVisitor instantiateVisitor(Element element) {
		// Instantiate a visitor object for the given element (at Conformance
		// Level 1)
		SemanticVisitor visitor = null;
		if (element instanceof LiteralBoolean) {
			visitor = new LiteralBooleanEvaluation();
		} else if (element instanceof LiteralString) {
			visitor = new LiteralStringEvaluation();
		} else if (element instanceof LiteralNull) {
			visitor = new LiteralNullEvaluation();
		} else if (element instanceof InstanceValue) {
			visitor = new InstanceValueEvaluation();
		} else if (element instanceof LiteralUnlimitedNatural) {
			visitor = new LiteralUnlimitedNaturalEvaluation();
		} else if (element instanceof LiteralInteger) {
			visitor = new LiteralIntegerEvaluation();
		} else if (element instanceof LiteralReal) {
			visitor = new LiteralRealEvaluation();
		} else if (element instanceof CallEventBehavior){
			visitor = new CallEventExecution();
 		}
		return visitor;
	}
}
