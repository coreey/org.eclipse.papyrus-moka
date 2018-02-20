package org.eclipse.papyrus.moka.animation.engine.animators.actions;

import org.eclipse.papyrus.moka.animation.engine.rendering.IRenderingEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;

public abstract class DerivedAnimationAction {
	
	public void preVisitAction(final IRenderingEngine engine, final ISemanticVisitor visitor) {
		// Default implementation does nothing.
		// Called before the animation performed upon the visit of the element referenced
		// by the visitor
	}
	
	public void postVisitAction(final IRenderingEngine engine, final ISemanticVisitor visitor) {
		// Default implementation does nothing
		// Called after the animation performed upon the visit of the element referenced
		// by the visitor
	}
	
	public void preLeftAction(final IRenderingEngine engine, final ISemanticVisitor visitor) {
		// Default implementation does nothing
		// Called before the animation performed upon leaving the element referenced
		// by the visitor'
	}
	
	public void postLeftAction(final IRenderingEngine engine, final ISemanticVisitor visitor) {
		// Default implementation does nothing
		// Called after the animation performed upon leaving the element referenced
		// by the visitor
	}
	
	// Define condition upon which the derived animation action is applied.
	// This operation shall be implemented by sub-classes.
	public abstract boolean accept(final ISemanticVisitor visitor);
		
}
