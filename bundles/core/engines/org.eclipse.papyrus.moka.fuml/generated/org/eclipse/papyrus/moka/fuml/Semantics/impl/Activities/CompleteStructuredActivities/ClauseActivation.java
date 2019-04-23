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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.CompleteStructuredActivities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.CompleteStructuredActivities.IClauseActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IBooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.Clause;

public class ClauseActivation implements IClauseActivation {

	/*
	 * The activation of the conditional node that contains the clause for this
	 * clause activation.
	 */
	public ConditionalNodeActivation conditionalNodeActivation;

	public Clause clause;

	public void receiveControl() {
		// If all predecessors to the clause for this activation have run their
		// tests and failed, then run the test for this clause.
		// If the test succeeds, then terminate any other clauses that may be
		// running and run the body of this clause.
		// If the test fails, then pass control to successor clauses.
		Debug.println("[receiveControl] clauseActivation = " + this);
		if (this.isReady()) {
			Debug.println("[receiveControl] Running test...");
			this.runTest();
			BooleanValue decision = this.getDecision();
			// Note that the decision may be null if the test was terminated
			// before completion.
			if (decision != null) {
				if (decision.value == true) {
					Debug.println("[receiveControl] Test succeeded.");
					this.selectBody();
				} else {
					Debug.println("[receiveControl] Test failed.");
					List<IClauseActivation> successors = this.getSuccessors();
					// *** Give control to all successors concurrently. ***
					for (Iterator<IClauseActivation> i = successors.iterator(); i.hasNext();) {
						IClauseActivation successor = i.next();
						successor.receiveControl();
					}
				}
			}
		}
	}

	public Boolean isReady() {
		// Test if all predecessors to this clause activation have failed.
		List<IClauseActivation> predecessors = this.getPredecessors();
		boolean ready = true;
		int i = 1;
		while (ready & i <= predecessors.size()) {
			IClauseActivation predecessor = predecessors.get(i - 1);
			IBooleanValue decisionValue = predecessor.getDecision();
			// Note that the decision will be null if the predecessor clause has
			// not run yet.
			if (decisionValue == null) {
				ready = false;
			} else {
				ready = !decisionValue.getValue();
			}
			i = i + 1;
		}
		return ready;
	}

	public void runTest() {
		// Run the test of the clause for this clause activation.
		this.conditionalNodeActivation.runTest(this.clause);
	}

	public void selectBody() {
		// Select the body of the clause for this clause activation.
		this.conditionalNodeActivation.selectBody(this.clause);
	}

	public BooleanValue getDecision() {
		// Get the value (if any) on the decider pin of the clause for this
		// clause activation.
		List<IValue> deciderValues = this.conditionalNodeActivation.getPinValues(this.clause.getDecider());
		BooleanValue deciderValue = null;
		if (deciderValues.size() > 0) {
			deciderValue = (BooleanValue) (deciderValues.get(0));
		}
		return deciderValue;
	}

	public List<IClauseActivation> getPredecessors() {
		// Return the clause activations for the predecessors of the clause for
		// this clause activation.
		List<IClauseActivation> predecessors = new ArrayList<IClauseActivation>();
		List<Clause> predecessorClauses = this.clause.getPredecessorClauses();
		for (int i = 0; i < predecessorClauses.size(); i++) {
			Clause predecessorClause = predecessorClauses.get(i);
			predecessors.add(this.conditionalNodeActivation.getClauseActivation(predecessorClause));
		}
		return predecessors;
	}

	public List<IClauseActivation> getSuccessors() {
		// Return the clause activations for the successors of the clause for
		// this clause activation.
		List<IClauseActivation> successors = new ArrayList<IClauseActivation>();
		List<Clause> successorClauses = this.clause.getSuccessorClauses();
		for (int i = 0; i < successorClauses.size(); i++) {
			Clause successorClause = successorClauses.get(i);
			successors.add(this.conditionalNodeActivation.getClauseActivation(successorClause));
		}
		return successors;
	}
}
