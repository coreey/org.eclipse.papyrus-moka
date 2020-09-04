package org.eclipse.papyrus.moka.fuml.standardlibrary.ui;

import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.papyrus.moka.fuml.standardlibrary.library.io.IFUMLIOConsole;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IOConsole;

public class EclipseUIFUMLIOConsole implements IFUMLIOConsole {

	private IOConsole console;

	protected static final String CONSOLE_NAME = "fUML Console";

	@Override
	public void init() {
		console = new IOConsole(CONSOLE_NAME, null);
		IConsoleManager conMan = ConsolePlugin.getDefault().getConsoleManager();
		conMan.addConsoles(new IConsole[] { console });
	}

	@Override
	public InputStream getInputStream() {
		return console.getInputStream();
	}

	@Override
	public OutputStream getOutputStream() {
		return console.newOutputStream();
	}

}
