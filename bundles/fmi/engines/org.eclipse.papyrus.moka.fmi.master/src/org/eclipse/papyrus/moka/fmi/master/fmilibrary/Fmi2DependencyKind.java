/*****************************************************************************
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
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmi.master.fmilibrary;

public interface Fmi2DependencyKind {
	public static final String fmi2Dependent = "dependent";
	public static final String fmi2Constant = "constant";
	public static final String fmi2Fixed = "fixed";
	public static final String fmi2Tunable = "tunable";
	public static final String fmi2Discrete = "discrete";
}
