/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
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
package org.eclipse.papyrus.moka.debug.communication;

public interface DebugTopics {

	/**
	 * Debug target client topics
	 */
	
	String DEBUG_TARGET_THREAD_TOPIC = "debug-target/thread";
	
	String DEBUG_TARGET_ENGINE_TOPIC = "debug-target/engine";
	
	/**
	 * Execution engine client topics
	 */
	
	String DEBUG_SERVICE_THREAD_TOPIC = "debug-service/thread";
	
	String DEBUG_SERVICE_ENGINE_TOPIC = "debug-service/engine";
	
}
