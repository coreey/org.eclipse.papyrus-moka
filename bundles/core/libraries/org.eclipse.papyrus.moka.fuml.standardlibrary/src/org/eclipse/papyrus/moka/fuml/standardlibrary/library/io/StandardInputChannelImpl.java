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

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.StringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.papyrus.moka.fuml.registry.service.framework.AbstractService;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;

public class StandardInputChannelImpl extends AbstractService {

	protected static BufferedReader bufferedReader;

	protected InputStream in = null;

	public StandardInputChannelImpl(Class service) {
		super(service);
		this.in = StandardOutputChannelImpl.getConsole().getInputStream();
	}

	@Override
	public void doOperationExecutionMapping() {
		Class type = this.types.get(0);
		for (Operation operation : type.getAllOperations()) {
			if (operation.getName().equals("readLine")) {
				this.operationExecution.put(operation, new ReadLineExecution(operation));
			}
		}
	}

	protected class ReadLineExecution extends AbstractService.ServiceOperationExecution {

		protected Operation operation;

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
