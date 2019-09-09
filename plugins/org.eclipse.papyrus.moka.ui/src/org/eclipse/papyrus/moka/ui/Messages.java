package org.eclipse.papyrus.moka.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	public static String ModelSetOpenning_Status;

	public static String ModelSetOpenning_Title;

	public static String MokaDialogError_Title;
	
	public static String ServerError_Title;
	
	public static String ServerError_Status;
	
	public static String EngineInstantiationError_Title;
	
	public static String EngineInstantiationError_Status;

	public static String ProjectOpeningError_Title;
	
	public static String ProjectOpeningError_Status;

	static {
		NLS.initializeMessages(MokaUIActivator.PLUGIN_ID + ".messages", Messages.class);
	}

}
