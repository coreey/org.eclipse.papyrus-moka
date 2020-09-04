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
 *
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.standardlibrary.library.io;

import java.io.OutputStream;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IExecution;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.papyrus.moka.fuml.library.ServiceObject;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.StringValue;
import org.eclipse.papyrus.moka.fuml.values.Value;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;

public final class StandardOutputChannelImpl extends ServiceObject {

	protected OutputStream out = null;

	private static final String WRITE_OPERATION = "write";

	private static final String WRITELINE_OPERATION = "writeLine";

	public StandardOutputChannelImpl(Class service) {
		super(service);
		this.out = FUMLIOConsole.getInstance().getConsole().getOutputStream();
	}

	@Override
	public IExecution dispatch(Operation operation) {
		IExecution execution = null;
		if (operation != null) {
			if (operation.getName().equals(WRITE_OPERATION)) {
				execution = new Write(operation);
			} else if (operation.getName().equals(WRITELINE_OPERATION)) {
				execution = new WriteLine(operation);
			}
		}
		return execution;
	}

	protected class WriteLine extends ServiceObject.ServiceOperationExecution {

		public WriteLine(Operation operation) {
			super(operation);
		}

		@Override
		public Value new_() {
			return new WriteLine(operation);
		}

		@Override
		public void doBody(List<IParameterValue> inputParameters, List<IParameterValue> outputParameters) {
			// Supposed to have only one input argument, corresponding to parameter 'value'
			try {
				String message = "";
				message = ((StringValue) inputParameters.get(0).getValues().get(0)).value;
				out.write((message + "\n").getBytes());
				out.flush();
				// This implementation does not produce errorStatus information.
			} catch (Exception e) {
				Debug.println("An error occured during the execution of writeLine " + e.getMessage());
			}
		}
	}

	protected class Write extends ServiceObject.ServiceOperationExecution {

		public Write(Operation operation) {
			super(operation);
		}

		@Override
		public Value new_() {
			return new Write(operation);
		}

		@Override
		public void doBody(List<IParameterValue> inputParameters, List<IParameterValue> outputParameters) {
			// Supposed to have only one input argument, corresponding to parameter 'value'
			try {
				String message = inputParameters.get(0).getValues().get(0).toString();
				out.write(message.getBytes());
				out.flush();
				// This implementation does not produce errorStatus information.
			} catch (Exception e) {
				Debug.println("An error occured during the execution of write " + e.getMessage());
			}
		}
	}

}
