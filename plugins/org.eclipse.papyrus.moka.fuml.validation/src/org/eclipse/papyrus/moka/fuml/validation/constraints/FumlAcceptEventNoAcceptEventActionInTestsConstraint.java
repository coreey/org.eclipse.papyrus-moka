/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier:EPL-2.0 
 *
 * Contributors:
 *  Pauline DEVILLE (CEA LIST) pauline.deville@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ConditionalNode;
import org.eclipse.uml2.uml.LoopNode;

/**
 * fUML_no_accept_event_action_in_tests
 * 
 * An accept event action may not be contained directly or indirectly in the
 * test part of a clause or loop node.
 * self->closure(inStructuredNode.oclAsType(ActivityNode))->forAll(n | let s :
 * StructuredActivityNode = n.inStructuredNode in s->notEmpty() implies
 * (s.ocllsTypeOf(ConditionalNode) implies
 * s.oclAsType(ConditionalNode).clause.test->
 * excludes(n.oclAsType(ExecutableNode)) and s.ocllsTypeOf(LoopNode) implies
 * s.oclAsType(LoopNode).test->excludes(n.oclAsType(ExecutableNode))))
 * 
 * FIXME The implementation is not exactly the same as the ocl description since it is not possible
 */
public class FumlAcceptEventNoAcceptEventActionInTestsConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		boolean condition = true;
		AcceptEventAction acceptEventAction = (AcceptEventAction) ctx.getTarget();
		ActivityNode inStructuredNode = acceptEventAction.getInStructuredNode();
		if (inStructuredNode != null) {
			if (inStructuredNode instanceof ConditionalNode) {
				condition &= ((ConditionalNode) inStructuredNode).getClauses().stream()
						.allMatch(c -> false == c.getTests().contains(acceptEventAction));
			}
			if (inStructuredNode instanceof LoopNode) {
				condition &= false == ((LoopNode) inStructuredNode).getTests().contains(acceptEventAction);
			}
		}
		if (!condition) {
			return ctx.createFailureStatus(
					"AcceptEventAction - An accept event action may not be contained directly or indirectly in the test part of a clause or loop node.");
		}
		return ctx.createSuccessStatus();
	}
}