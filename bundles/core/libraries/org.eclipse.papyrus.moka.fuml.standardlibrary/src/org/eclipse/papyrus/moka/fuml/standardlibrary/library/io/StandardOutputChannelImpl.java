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

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.StringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.papyrus.moka.fuml.registry.service.framework.AbstractService;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleOutputStream;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;

public class StandardOutputChannelImpl extends AbstractService {

	protected static final String CONSOLE_NAME = "fUML Console";

	protected static IOConsole console = null;

	protected IOConsoleOutputStream out = null;

	public static IOConsole getConsole() {
		if (console == null) {
			console = new IOConsole(CONSOLE_NAME, null);
			IConsoleManager conMan = ConsolePlugin.getDefault().getConsoleManager();
			conMan.addConsoles(new IConsole[] { console });
		}
		return console;
	}

	public StandardOutputChannelImpl(Class service) {
		super(service);
		this.out = getConsole().newOutputStream();
	}

	@Override
	public void doOperationExecutionMapping() {
		Class type = this.types.get(0);
		for (Operation operation : type.getAllOperations()) {
			if (operation.getName().equals("writeLine")) {
				this.operationExecution.put(operation, new WriteLineExecution(operation));
			} else if (operation.getName().equals("write")) {
				this.operationExecution.put(operation, new Write(operation));
			}
		}
	}

	protected class WriteLineExecution extends AbstractService.ServiceOperationExecution {

		public WriteLineExecution(Operation operation) {
			super(operation);
		}

		@Override
		public Value new_() {
			return new WriteLineExecution(operation);
		}

		@Override
		public void doBody(List<IParameterValue> inputParameters, List<IParameterValue> outputParameters) {
			// Supposed to have only one input argument, corresponding to parameter 'value'
			try {
				String message = "";
				message = ((StringValue) inputParameters.get(0).getValues().get(0)).value;
				out.write(message + "\n");
				out.flush();
				// This implementation does not produce errorStatus information.
			} catch (Exception e) {
				Debug.println("An error occured during the execution of writeLine " + e.getMessage());
			}
		}
	}

	protected class Write extends AbstractService.ServiceOperationExecution {

		protected Operation operation;

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
				out.write(message);
				out.flush();
				// This implementation does not produce errorStatus information.
			} catch (Exception e) {
				Debug.println("An error occured during the execution of write " + e.getMessage());
			}
		}
	}
}
