/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.launch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Stereotype;

public class MokaTriggerComboPopulation implements ModifyListener {

	protected transient MokaUMLComboBox list;

	public MokaTriggerComboPopulation(MokaUMLComboBox combo) {
		this.list = combo;
	}

	public void modifyText(ModifyEvent e) {
		List<NamedElement> namedElements = new ArrayList<NamedElement>();
		this.list.removeAll();
		Text text = (Text) e.widget;
		URI projectUri = URI.createURI(text.getText());
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(projectUri, true);
		Iterator<EObject> contentIterator = resource.getAllContents();
		while (contentIterator.hasNext()) {
			EObject eObject = contentIterator.next();
			if (eObject instanceof Behavior) {
				if (eObject instanceof Activity || eObject instanceof OpaqueBehavior || eObject instanceof StateMachine) {
					namedElements.add((NamedElement) eObject);
				}
			} else if (eObject instanceof Class) {
				if (!(eObject instanceof Node) || !(eObject instanceof Stereotype) || !(eObject instanceof AssociationClass)) {
					// if(((Class)eObject).isActive()){
					namedElements.add((NamedElement) eObject);
					// }
				}
			} else if (eObject instanceof InstanceSpecification) {		
				namedElements.add((NamedElement) eObject);
			}
			
		}

		Comparator<NamedElement> comp = new Comparator<NamedElement>() {

			public int compare(NamedElement o1, NamedElement o2) {
				String s1 = list.generateLabel(o1);
				String s2 = list.generateLabel(o2);
				return s1.compareTo(s2);
			}
		};

		Collections.sort(namedElements, comp);

		for (NamedElement n : namedElements) {
			this.list.add(n);
		}
		this.list.selectFirst();

	}
}
