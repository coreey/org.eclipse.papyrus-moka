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
 *  Ansgar Radermacher (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.tracepoint.service;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.moka.tracepoint.service.preferences.TPPreferenceConstants;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.State;

/**
 * Set of enumerations that indicates what we want to trace.
 *
 * @author ansgar
 *
 */
public class TraceActions {

	public enum TraceScope {
		clazz,
		operation,
		state,
		activity,
	};

	/**
	 * Options for tracing a class. Note that some options need additional information, e.g. "all operations"
	 * needs additional information how operations are traced
	 */
	public enum TAClass {
		Creation,
		Destruction,
		AllOperations,
		AllPorts,
		AllStates,
		AllTransitions
		// +(?) all properties/all operations
		// +(all ports?)
		// +all state changes? (hierarchical propagation?)

	};

	/**
	 * Different ways to trace operations: put only the call itself or the values of the parameters into
	 * a trace event.
	 */
	public enum TAOperation {
		ParameterValues,
		MethodEnds,
	};

	/**
	 * Not used for the moment
	 */
	public enum TAAttribute {
		PropertyRead,
		PropertyWrite; // write old and new value
	};

	/**
	 * Options to trace state
	 */
	public enum TAState {
		StateEnter, // add incoming transition to trace?
		StateLeave, // add outgoing transition to trace?
		Transition // nothing (?) (triggers are known? - no, could be one out of many triggers)
	};

	public enum TATransition {
		OnlyTrigger,
		TriggerValues,
	};

	/**
	 * Not used for the moment
	 */
	public enum TAActivity {
		activity // (i.e. call operation action) explicit choice of (named attribute?)
	};

	public static String[][] getStringFields(Enum<?>[] enumValues) {
		int i = 0;
		String[][] taOptions = new String[enumValues.length][2];
		for (Enum<?> tLiteral : enumValues) {
			taOptions[i][1] = tLiteral.name();
			taOptions[i][0] = tLiteral.name();
			i++;
		}
		return taOptions;
	}

	public enum TraceFeature {
		Class,
		Port,
		State,
		Transition,
		Operation
	};

	/**
	 * Obtain the definition of a trace option in case of traces on classes
	 *
	 * @param traceAction
	 * @param subFeature
	 *            the trace feature which we want to obtain, i.e. class, state or operation
	 *            from a composite action string in case of class trace points
	 */
	public static String getOptions(String traceAction, TraceFeature subFeature) {
		String prefix = getStringPrefix(subFeature);
		int pos = traceAction.indexOf(prefix);
		if (pos == -1) {
			return null;
		} else {
			// comma is used as separation character.
			pos += prefix.length();
			int endPos = traceAction.indexOf(',', pos);
			if (endPos == -1) {
				return traceAction.substring(pos);
			}
			return traceAction.substring(pos, endPos);
		}
	}

	/**
	 * Get the prefix that is used in each case of a class action to distinguish class, state and operation actions.
	 *
	 * @param feature
	 *            The trace feature for which we set an action
	 */
	public static String getStringPrefix(TraceFeature feature) {
		if (feature == TraceFeature.Class) {
			return "C:"; //$NON-NLS-1$
		}
		if (feature == TraceFeature.Port) {
			return "P:"; //$NON-NLS-1$
		}
		else if (feature == TraceFeature.State) {
			return "S:"; //$NON-NLS-1$
		}
		else if (feature == TraceFeature.Operation) {
			return "O:"; //$NON-NLS-1$
		}
		else if (feature == TraceFeature.Transition) {
			return "T:"; //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * Initialize an action string that will be stored in the trace marker from the configured actions
	 * in the preferences. In case of a class, the value is a combination of different options
	 * that are prefixed to enable a unique classification
	 *
	 * @param feature
	 *            The trace feature for which we set an action
	 */
	public static String actionFromPreferences(TraceFeature feature) {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		if (feature == TraceFeature.Class) {
			return compositeClassOption(store.getInt(TPPreferenceConstants.P_TRACE_OPTION_CLASS),
					store.getInt(TPPreferenceConstants.P_TRACE_OPTION_STATE),
					store.getInt(TPPreferenceConstants.P_TRACE_OPTION_OP));
		}
		else if (feature == TraceFeature.Port) {
			return store.getString(TPPreferenceConstants.P_TRACE_OPTION_PORT);
		}
		else if (feature == TraceFeature.State) {
			return store.getString(TPPreferenceConstants.P_TRACE_OPTION_STATE);
		}
		else if (feature == TraceFeature.Transition) {
			return store.getString(TPPreferenceConstants.P_TRACE_OPTION_TRANSITION);
		}
		else if (feature == TraceFeature.Operation) {
			return store.getString(TPPreferenceConstants.P_TRACE_OPTION_OP);
		}
		return ""; //$NON-NLS-1$
	}

	public static String compositeClassOption(int classOption, int stateOption, int operationOption) {
		return getStringPrefix(TraceFeature.Class) + classOption + "," + //$NON-NLS-1$
				getStringPrefix(TraceFeature.State) + stateOption + "," + //$NON-NLS-1$
				getStringPrefix(TraceFeature.Operation) + operationOption;
	}

	/**
	 * Convenience function, return the action defined in the preferences in function of the model element
	 *
	 * @param element
	 */
	public static String actionFromPreferences(EObject element) {
		return actionFromPreferences(getTraceFeature(element));
	}


	public static TraceFeature getTraceFeature(EObject element) {
		if (element instanceof State) {
			return TraceFeature.State;
		}
		else if (element instanceof Operation) {
			return TraceFeature.Operation;
		}
		else if (element instanceof org.eclipse.uml2.uml.Class) {
			return TraceFeature.Class;
		}
		return null;
	}
}
