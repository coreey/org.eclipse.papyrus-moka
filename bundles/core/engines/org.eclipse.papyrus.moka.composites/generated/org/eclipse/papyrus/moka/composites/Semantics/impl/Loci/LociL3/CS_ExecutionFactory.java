/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.moka.composites.Semantics.impl.Loci.LociL3;

import org.eclipse.papyrus.moka.composites.Semantics.impl.Actions.CompleteActions.CS_ReadExtentActionActivation;
import org.eclipse.papyrus.moka.composites.Semantics.impl.Actions.IntermediateActions.CS_AddStructuralFeatureValueActionActivation;
import org.eclipse.papyrus.moka.composites.Semantics.impl.Actions.IntermediateActions.CS_ClearStructuralFeatureValueActionActivation;
import org.eclipse.papyrus.moka.composites.Semantics.impl.Actions.IntermediateActions.CS_CreateLinkActionActivation;
import org.eclipse.papyrus.moka.composites.Semantics.impl.Actions.IntermediateActions.CS_CreateObjectActionActivation;
import org.eclipse.papyrus.moka.composites.Semantics.impl.Actions.IntermediateActions.CS_ReadSelfActionActivation;
import org.eclipse.papyrus.moka.composites.Semantics.impl.Actions.IntermediateActions.CS_RemoveStructuralFeatureValueActionActivation;
import org.eclipse.papyrus.moka.composites.Semantics.impl.Classes.Kernel.CS_InstanceValueEvaluation;
import org.eclipse.papyrus.moka.composites.Semantics.impl.Classes.Kernel.CS_OpaqueExpressionEvaluation;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CommonBehaviors.BasicBehaviors.CS_CallEventExecution;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_AcceptCallActionActivation;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_AcceptEventActionActivation;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_CallOperationActionActivation;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_SendSignalActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.CallEventBehavior;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL3.ExecutionFactoryL3;
import org.eclipse.uml2.uml.AcceptCallAction;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.AddStructuralFeatureValueAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.ClearStructuralFeatureAction;
import org.eclipse.uml2.uml.CreateLinkAction;
import org.eclipse.uml2.uml.CreateObjectAction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.ReadExtentAction;
import org.eclipse.uml2.uml.ReadSelfAction;
import org.eclipse.uml2.uml.RemoveStructuralFeatureValueAction;
import org.eclipse.uml2.uml.SendSignalAction;


public class CS_ExecutionFactory extends ExecutionFactoryL3 {

	@Override
	public ISemanticVisitor instantiateVisitor(Element element) {
		// Extends fUML semantics in the sense that newly introduced
		// semantic visitors are instantiated instead of fUML visitors

		ISemanticVisitor visitor = null;
		if (element instanceof ReadExtentAction) {
			visitor = new CS_ReadExtentActionActivation();
		}else if (element instanceof AcceptCallAction) {
			visitor = new CS_AcceptCallActionActivation();
 		}else if (element instanceof AcceptEventAction) {
			visitor = new CS_AcceptEventActionActivation();
		} else if (element instanceof AddStructuralFeatureValueAction) {
			visitor = new CS_AddStructuralFeatureValueActionActivation();
		} else if (element instanceof ClearStructuralFeatureAction) {
			visitor = new CS_ClearStructuralFeatureValueActionActivation();
		} else if (element instanceof CreateLinkAction) {
			visitor = new CS_CreateLinkActionActivation();
		} else if (element instanceof CreateObjectAction) {
			visitor = new CS_CreateObjectActionActivation();
		} else if (element instanceof ReadSelfAction) {
			visitor = new CS_ReadSelfActionActivation();
		} else if (element instanceof InstanceValue) {
			visitor = new CS_InstanceValueEvaluation();
		}  else if (element instanceof CallOperationAction) {
			visitor = new CS_CallOperationActionActivation();
		} else if (element instanceof SendSignalAction) {
			visitor = new CS_SendSignalActionActivation();
		} else if (element instanceof OpaqueExpression) {
			visitor = new CS_OpaqueExpressionEvaluation();
		} else if (element instanceof CallEventBehavior) {
			visitor = new CS_CallEventExecution();
 		} else if (element instanceof RemoveStructuralFeatureValueAction) {
 			visitor = new CS_RemoveStructuralFeatureValueActionActivation();
 		} else {
			visitor = super.instantiateVisitor(element);
		}
		return visitor;
	}
}
