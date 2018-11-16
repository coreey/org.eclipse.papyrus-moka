package org.eclipse.papyrus.moka.ssp.profile.custom;

import org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage;

public final class StereotypeStrings {
	
	private static final SSPProfilePackage sspPackage = SSPProfilePackage.eINSTANCE;	
	public static final String SSPPROFILE_QUALIFIEDNAME = "SSPProfile";
	
	public static final String SSD_SHORTNAME = sspPackage.getSsd().getName();
	public static final String SSDSYSTEM_SHORTNAME = sspPackage.getSsdSystem().getName();
	public static final String SSDCOMPONENT_SHORTNAME = sspPackage.getSsdComponent().getName();
	public static final String SSDSIGNAL_DICTIONARY_REFERENCE_SHORTNAME = sspPackage.getSsdSignalDictionaryReference().getName();
	public static final String SSDCONNECTION_SHORTNAME = sspPackage.getSsdConnection().getName();
	public static final String SSDCONNECTOR_SHORTNAME = sspPackage.getSsdConnector().getName();
	public static final String SSDCONNECTORANDFMIPORT_SHORTNAME = sspPackage.getSsdConnectorAndFmiPort().getName();
	
	public static final String SSD_QUALIFIEDNAME = SSPPROFILE_QUALIFIEDNAME + "::" + SSD_SHORTNAME;	
	public static final String SSDSYSTEM_QUALIFIEDNAME = SSPPROFILE_QUALIFIEDNAME + "::" + SSDSYSTEM_SHORTNAME;	
	public static final String SSDCOMPONENT_QUALIFIEDNAME = SSPPROFILE_QUALIFIEDNAME + "::" + SSDCOMPONENT_SHORTNAME;	
	public static final String SSDSIGNAL_DICTIONARY_REFERENCE_QUALIFIEDNAME = SSPPROFILE_QUALIFIEDNAME + "::" + SSDSIGNAL_DICTIONARY_REFERENCE_SHORTNAME;	
	public static final String SSDCONNECTION_QUALIFIEDNAME = SSPPROFILE_QUALIFIEDNAME + "::" + SSDCONNECTION_SHORTNAME;	
	public static final String SSDCONNECTOR_QUALIFIEDNAME = SSPPROFILE_QUALIFIEDNAME + "::" + SSDCONNECTOR_SHORTNAME;	
	public static final String SSDCONNECTORANDFMIPORT_QUALIFIEDNAME = SSPPROFILE_QUALIFIEDNAME + "::" + SSDCONNECTORANDFMIPORT_SHORTNAME;
	
	public static final String SSDCONNECTION_START = "start";
	public static final String SSDCONNECTION_END = "end";
	public static final String SSDCOMPONENT_SOURCE = "source";
	public static final String SSDCOMPONENT_TYPE = "type";
	public static final String SSDCOMPONENT_FMU = "fmu";
	public static final String SSDELEMENT_ID = "ID";
	public static final String SSD_VERSION = "version";
	public static final String SSD_MAINSYSTEM = "mainSystem";
	public static final String SSD_NAME = "name";
}
