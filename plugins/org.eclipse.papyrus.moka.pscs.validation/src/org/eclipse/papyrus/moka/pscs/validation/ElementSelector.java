package org.eclipse.papyrus.moka.pscs.validation;

import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.uml2.uml.Element;

public class ElementSelector implements IClientSelector {

	@Override
	public boolean selects(Object object) {
		return (object instanceof Element);
	}

}
