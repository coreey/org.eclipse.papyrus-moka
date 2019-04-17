/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.trace.formater;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.moka.trace.Activator;
import org.eclipse.papyrus.moka.trace.capture.MokaCaptureServiceFactory;
import org.eclipse.papyrus.moka.trace.interfaces.format.ITraceFileFormater;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;

public class TraceFileFormaterRegistry {

	public static final TraceFileFormaterRegistry INSTANCE = new TraceFileFormaterRegistry();

	private static final String EXTENSION_POINT = MokaConstants.MOKA_TRACE_FORMATER_EXTENSION_POINT_ID;

	private static final String CLASS_PROPERTY_NAME = "class"; //$NON-NLS-1$

	private static final String NAME_PROPERTY_NAME = "name"; //$NON-NLS-1$

	private static final String ID_PROPERTY_NAME = "id"; //$NON-NLS-1$

	private static final String CAPTURE_ID_PROPERTY_NAME = "captureId"; //$NON-NLS-1$

	private static final String FILE_EXTENSION_PROPERTY_NAME = "fileExtension"; //$NON-NLS-1$

	private Map<String, ITraceFileFormater> formaters;

	private TraceFileFormaterRegistry() {
		this.formaters = getRegisteredFormaters();
	}

	public Collection<ITraceFileFormater> getTraceFileFormater() {
		return formaters.values();
	}

	private Map<String, ITraceFileFormater> getRegisteredFormaters() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(EXTENSION_POINT);
		Map<String, ITraceFileFormater> formaters = new HashMap<>();
		for (int i = 0; i < config.length; i++) {
			try {
				ITraceFileFormater traceformater = (ITraceFileFormater) config[i].createExecutableExtension(CLASS_PROPERTY_NAME);
				String formaterName = config[i].getAttribute(NAME_PROPERTY_NAME);
				traceformater.setName(formaterName);
				String formaterId = config[i].getAttribute(ID_PROPERTY_NAME);
				traceformater.setId(formaterId);
				String formaterCaptureId = config[i].getAttribute(CAPTURE_ID_PROPERTY_NAME);
				traceformater.setCaptureId(formaterCaptureId);
				String fileExtension = config[i].getAttribute(FILE_EXTENSION_PROPERTY_NAME);
				traceformater.setFileExtension(fileExtension);
				formaters.put(formaterId, traceformater);
			} catch (CoreException e) {
				Activator.log.error(e);
			}
		}
		// Moka json trace formater
		ITraceFileFormater mokaJsonFormater = new MokaJsonTraceFileFormater();
		mokaJsonFormater.setName("Moka json formater"); //$NON-NLS-1$
		mokaJsonFormater.setCaptureId(MokaCaptureServiceFactory.MOKA_ENGINE_ID); //$NON-NLS-1$
		mokaJsonFormater.setId(MokaJsonTraceFileFormater.MOKA_JSON_FORMATER_ID);
		mokaJsonFormater.setFileExtension("json"); //$NON-NLS-1$
		formaters.put(mokaJsonFormater.getCaptureId(), mokaJsonFormater);
		return formaters;
	}

	public ITraceFileFormater getFormaterFromCaptureID(String id) {
		return formaters.get(id);
	}

	public ITraceFileFormater getFormaterFromID(String id) {
		for (ITraceFileFormater formater : formaters.values()) {
			if (formater.getId().equals(id)) {
				return formater;
			}
		}
		return null;
	}

}
