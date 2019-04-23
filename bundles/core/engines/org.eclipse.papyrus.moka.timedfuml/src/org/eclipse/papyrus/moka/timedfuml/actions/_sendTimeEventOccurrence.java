/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.timedfuml.actions;

import org.eclipse.papyrus.moka.discreteevent.DEScheduler;
import org.eclipse.papyrus.moka.discreteevent.actions.Action;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Reference;
import org.eclipse.papyrus.moka.timedfuml.semantics.CommonBehaviors.TimedEventOccurrence;

public class _sendTimeEventOccurrence extends Action{

	// Time instant at which the timeout was registered
	protected double referenceInstant;
	
	// Target to which a time event is sent
	protected IObject_ target;
	
	// Visitor that implied the timer setup
	protected ISemanticVisitor visitor;
	
	public _sendTimeEventOccurrence(double referenceInstant, ISemanticVisitor visitor,  IObject_ target) {
		this.referenceInstant = referenceInstant;
		this.visitor = visitor;
		this.target = target;
	}
	
	public ISemanticVisitor getVisitor() {
		return this.visitor;
	}
	
	
	@Override
	public void execute() {
		// Register a time event occurrence to the target object. This
		// enables the target object classifier behavior to react (if possible)
		// to the fact that clock time has evolved.
		TimedEventOccurrence eventOccurrence = new TimedEventOccurrence();
		eventOccurrence.setReferenceInstant(this.referenceInstant);
		eventOccurrence.setOccurrenceInstant(DEScheduler.getInstance().getCurrentTime());
		IReference targetReference = new Reference();
		targetReference.setReferent(this.target);
		eventOccurrence.setTarget(targetReference);
		eventOccurrence.register();
	}

}
