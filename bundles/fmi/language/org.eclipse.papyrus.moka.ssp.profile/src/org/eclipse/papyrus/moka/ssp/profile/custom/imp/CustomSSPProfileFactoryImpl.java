/*******************************************************************************
 * Copyright (c) 2018, Krisztián Mócsai, IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Krisztián Mócsai - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.moka.ssp.profile.custom.imp;

import org.eclipse.papyrus.moka.ssp.profile.SsdConnection;
import org.eclipse.papyrus.moka.ssp.profile.SsdConnector;
import org.eclipse.papyrus.moka.ssp.profile.SsdConnectorAndFmiPort;
import org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfileFactoryImpl;

public class CustomSSPProfileFactoryImpl extends SSPProfileFactoryImpl {

	@Override
	public SsdConnection createSsdConnection() {
		return new CustomSsdConnectionImpl();
	}

	@Override
	public SsdConnectorAndFmiPort createSsdConnectorAndFmiPort() {
		return new CustomSsdConnectorAndFmiPortImpl();
	}

	@Override
	public SsdConnector createSsdConnector() {
		return new CustomSsdConnector();
	}
}
