package org.eclipse.papyrus.moka.fuml.standardlibrary.library.io;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.papyrus.moka.fuml.standardlibrary.Activator;

public class FUMLIOConsole {

	private static volatile FUMLIOConsole instance = null;

	private FUMLIOConsole() {

		super();
	}

	public final static FUMLIOConsole getInstance() {
		if (FUMLIOConsole.instance == null) {
			synchronized (FUMLIOConsole.class) {
				if (FUMLIOConsole.instance == null) {
					FUMLIOConsole.instance = new FUMLIOConsole();
				}
			}
		}
		return FUMLIOConsole.instance;
	}

	private IFUMLIOConsole console = null;

	public IFUMLIOConsole getConsole() {
		if (console == null) {
			loadFUMLIOConsole();

			console.init();
		}
		return console;
	}

	private void loadFUMLIOConsole() {

		String id = IFUMLIOConsoleExtensionPoint.EXTENSION_POINT_ID;
		IExtensionRegistry registry = RegistryFactory.getRegistry();

		IConfigurationElement[] elements = registry.getConfigurationElementsFor(id);

		if (elements.length == 0) {
			console = new DefaultFUMLIOConsole();
		} else {
			if (elements.length > 1) {
				Activator.getDefault().logger.warn("Only one FUMLIOConsole can be used. First found will be load");//$NON-NLS-1$
			}

			IConfigurationElement configurationElement = elements[0];

			try {
				Object fumlioconsoleclass = configurationElement
						.createExecutableExtension(IFUMLIOConsoleExtensionPoint.FUMLIOCONSOLECLASS);
				if (fumlioconsoleclass instanceof IFUMLIOConsole) {
					console = (IFUMLIOConsole) fumlioconsoleclass;
				}
			} catch (CoreException e) {
				Activator.getDefault().logger.error("Failed to create class for " + configurationElement, e);//$NON-NLS-1$
				console = new DefaultFUMLIOConsole();
			}
		}
	}
}
