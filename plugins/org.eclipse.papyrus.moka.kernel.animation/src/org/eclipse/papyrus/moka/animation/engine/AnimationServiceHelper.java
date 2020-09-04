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
package org.eclipse.papyrus.moka.animation.engine;

import java.util.List;

import org.eclipse.papyrus.moka.animation.engine.rendering.IAnimation;
import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.kernel.service.IExecutionEngineService;
import org.eclipse.papyrus.moka.kernel.service.ServiceRegistry;

public class AnimationServiceHelper {

	private AnimationServiceHelper() {
	}

	public static AnimationServiceHelper INSTANCE = new AnimationServiceHelper();

	public IAnimation getAnimationService() {
		IAnimation animationService = null;
		List<IExecutionEngineService<IExecutionEngine>> services = ServiceRegistry.getInstance()
				.getService(IAnimation.class);
		if (!services.isEmpty()) {
			if (services.size() == 1) {
				animationService = (IAnimation) services.iterator().next();
			} else {
				// TODO: handle via a strategy (e.g., the animation service with the highest
				// priority)
			}
		}
		return animationService;
	}

}
