package org.eclipse.papyrus.moka.pscs.actions;

import org.eclipse.papyrus.moka.fuml.loci.ISemanticStrategy;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.ICS_Object;
import org.eclipse.uml2.uml.Operation;

public interface ICS_ConstructStrategy extends ISemanticStrategy{

	public IObject_ construct(Operation constructor, ICS_Object context);
	
}
