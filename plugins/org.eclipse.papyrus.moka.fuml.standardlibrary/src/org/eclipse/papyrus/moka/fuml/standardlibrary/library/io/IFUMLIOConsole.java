package org.eclipse.papyrus.moka.fuml.standardlibrary.library.io;

import java.io.InputStream;
import java.io.OutputStream;

public interface IFUMLIOConsole {
	void init();

	InputStream getInputStream();

	OutputStream getOutputStream();
}
