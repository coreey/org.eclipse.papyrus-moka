package org.eclipse.papyrus.moka.fuml.activities;

import org.eclipse.papyrus.moka.fuml.actions.IActionActivation;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.uml2.uml.ExceptionHandler;

public interface IExceptionHandlerActivation {

	public void setHandler(ExceptionHandler handler);
	
	public void setDeclaringActionActivation(IActionActivation activation);
	
	public boolean match(IValue exception);
	
	public boolean handle(IValue exception);
	
}
