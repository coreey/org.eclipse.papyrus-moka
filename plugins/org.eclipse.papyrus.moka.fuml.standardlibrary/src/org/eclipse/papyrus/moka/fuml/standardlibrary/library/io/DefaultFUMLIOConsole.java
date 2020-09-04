package org.eclipse.papyrus.moka.fuml.standardlibrary.library.io;

import java.io.InputStream;
import java.io.OutputStream;

public class DefaultFUMLIOConsole implements IFUMLIOConsole {

	@Override
	public void init() {

	}

	@Override
	public InputStream getInputStream() {
		return System.in;
	}

	@Override
	public OutputStream getOutputStream() {
		return System.out;
	}

}
