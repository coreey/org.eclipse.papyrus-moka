/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.simex.utils;

import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.UMLPackage;

public class EventUtil {

	public static final String EVENT_PACKAGE_NAME = "Events";
	public static final String EVENT_SUFFIX = "Event";

	public static Package getEventPackage(Element context) {
		return getEventPackage(context, true);
	}
	
	public static Package getEventPackage(Element context, boolean create) {
		Package ret = null;
		Model root = context.getModel();
	
		ret = root.getNestedPackage(EVENT_PACKAGE_NAME);
		if (ret == null && create){
			ret = root.createNestedPackage(EVENT_PACKAGE_NAME);
		}
		return ret;
	}
	
	public static SignalEvent getSignalEvent(Signal signal, boolean create){
	Package eventPack = getEventPackage(signal, create);
		
		if (eventPack != null){
			for (PackageableElement elem : eventPack.getPackagedElements()){
				if (elem instanceof SignalEvent && signal.equals(((SignalEvent)elem).getSignal())) {
					return (SignalEvent) elem;
				}
			}
			if (create) {
				SignalEvent event = (SignalEvent) eventPack.createPackagedElement(signal.getName()+EVENT_SUFFIX , UMLPackage.eINSTANCE.getSignalEvent());
				event.setSignal(signal);
				return event;
			}
		
		}
		
		return null;
	}
	
	public static SignalEvent getSignalEvent(Signal signal){	
		return getSignalEvent(signal, true);
	}
	
	public static void  alignEventName(Signal signal) {
		String signalName = signal.getName();
		if (signalName != null){
			SignalEvent event = getSignalEvent(signal);
			event.setName(signalName + EVENT_SUFFIX);
		}
	
		
	}

	public static CallEvent getCallEvent(Operation operation) {
		Package eventPack = getEventPackage(operation);
		
		for (PackageableElement elem : eventPack.getPackagedElements()){
			if (elem instanceof CallEvent && operation.equals(((CallEvent)elem).getOperation())) {
				return (CallEvent) elem;
			}
		}
		
		CallEvent event = (CallEvent) eventPack.createPackagedElement(operation.getQualifiedName()+EVENT_SUFFIX , UMLPackage.eINSTANCE.getCallEvent());
		event.setOperation(operation);
		return event;
	}

}
