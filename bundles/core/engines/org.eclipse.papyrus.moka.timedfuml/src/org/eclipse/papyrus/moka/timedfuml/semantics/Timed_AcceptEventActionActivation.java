/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.timedfuml.semantics;

import org.eclipse.papyrus.moka.discreteevent.DEScheduler;
import org.eclipse.papyrus.moka.discreteevent.Event;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IRealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.timedfuml.actions._sendAcceptEventOfferAction;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.Trigger;

/**
 * @author sg239226
 *
 */
public class Timed_AcceptEventActionActivation extends ActionActivation {

	public Timed_AcceptEventActionActivation() {
		super();
	}

	public void sendOffers() {

		double relativeDate = 0;
		double absoluteDate = 0;
		double currentTime = 0;
		for (Trigger trigger : ((AcceptEventAction) node).getTriggers()) {
			boolean isMissed = false;
			TimeEvent e = (TimeEvent) trigger.getEvent();
			TimeExpression texp = ((TimeEvent) e).getWhen();
			IEvaluation evaluation = null;
			// FIXME Hack. Changes would be required in fUML
			// In fUML, evaluations cannot have a context
			// A context might however be useful, at least in the case of OpaqueExpression, for the execution of the expression Behavior
			if (texp.getExpr() instanceof OpaqueExpression) {
				OpaqueExpressionEvaluationWithContext opaqueEvaluation = new OpaqueExpressionEvaluationWithContext();
				opaqueEvaluation.specification = texp.getExpr();
				opaqueEvaluation.locus = this.getExecutionLocus();
				opaqueEvaluation.context = this.getExecutionContext();
				evaluation = opaqueEvaluation;
			} else {
				evaluation = this.getExecutionLocus().getFactory().createEvaluation(texp.getExpr());
			}
			if (e.isRelative()) {
				relativeDate = ((IRealValue) evaluation.evaluate()).getValue();
			} else {
				absoluteDate = ((IRealValue) evaluation.evaluate()).getValue();
				currentTime = DEScheduler.getInstance().getCurrentTime();
				if (absoluteDate < currentTime) {
					isMissed = true;
					System.out.println("Time Event is missed, absoluteTime = " + absoluteDate + " > currentTime = " + currentTime);
				} else {
					relativeDate = absoluteDate - currentTime;
				}

			}
			if (!isMissed) {
				_sendAcceptEventOfferAction sendOfferAction = new _sendAcceptEventOfferAction(this);
				this.suspend();
				DEScheduler.getInstance().pushEvent(new Event(relativeDate, sendOfferAction));
			}
		}
	}

	public void sendOffersDefault() {
		this.resume();
		super.sendOffers();
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub

	}


}
