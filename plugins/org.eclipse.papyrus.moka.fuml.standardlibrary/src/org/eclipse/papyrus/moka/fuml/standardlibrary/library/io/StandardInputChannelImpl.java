/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
 *  Jeremie Tatibouet (CEA LIST) - Align service code with abstract service
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.standardlibrary.library.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IExecution;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.papyrus.moka.fuml.library.ServiceObject;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.StringValue;
import org.eclipse.papyrus.moka.fuml.values.Value;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;

public class StandardInputChannelImpl extends ServiceObject {

	protected static BufferedReader bufferedReader;

	protected InputStream in = null;

	private static final String READLINE_OPERATION = "readLine";

	public StandardInputChannelImpl(Class service) {
		super(service);
		this.in = FUMLIOConsole.getInstance().getConsole().getInputStream();
	}

	@Override
	public IExecution dispatch(Operation operation) {
		IExecution execution = null;
		if (operation != null) {
			if (operation.getName().equals(READLINE_OPERATION)) {
				execution = new ReadLineExecution(operation);
			}
		}
		return execution;
	}

	protected class ReadLineExecution extends ServiceObject.ServiceOperationExecution {

		public ReadLineExecution(Operation operation) {
			super(operation);
		}

		@Override
		public Value new_() {
			return new ReadLineExecution(operation);
		}

		@Override
		public void doBody(List<IParameterValue> inputParameters, List<IParameterValue> outputParameters) {
			// This implementation does not produce errorStatus information.
			try {
				if (bufferedReader == null) {
					bufferedReader = new BufferedReader(new InputStreamReader(in));
				}
				String line = bufferedReader.readLine();
				StringValue result = new StringValue();
				result.value = "" + line;
				List<IValue> outputs = new ArrayList<IValue>();
				outputs.add(result);
				outputParameters.get(0).setValues(outputs);
			} catch (Exception e) {
				Debug.println("An error occured during the execution of readLine " + e.getMessage());
			}
		}
	}

}
