package org.eclipse.papyrus.moka.kernel.process;

import org.eclipse.papyrus.moka.kernel.IKernelProperties;
import org.eclipse.papyrus.moka.kernel.MokaKernelActivator;

public class MQTTServerConfig {

	private static String mqttServerPath;

	private static String mqttServerPort;

	static public String getMQTTServerPort() {
		if (mqttServerPort != null) {
			return mqttServerPort;
		}

		// Try to get from System property
		mqttServerPort = System.getProperty(IKernelProperties.MQTT_SERVER_PORT);
		if (mqttServerPort == null) {
			// Get the default value
			mqttServerPort = IKernelProperties.DEFAULT_MQTT_SERVER_PORT;
		}

		return mqttServerPort;
	}

	static public String getMQTTServerPath() {
		if (mqttServerPath != null) {
			return mqttServerPath;
		}

		// Try to get from System property
		mqttServerPath = System.getProperty(IKernelProperties.MQTT_SERVER_PATH);

		if (mqttServerPath == null) {
			MokaKernelActivator.getDefault().logger
					.error("Invlaid value for property " + IKernelProperties.MQTT_SERVER_PATH); //$NON-NLS-1$
		}

		return mqttServerPath;
	}

	static public boolean isSetServerPortSystemProperty() {
		return System.getProperty(IKernelProperties.MQTT_SERVER_PORT) != null;
	}

	static public boolean isSetServerPathSystemProperty() {
		return System.getProperty(IKernelProperties.MQTT_SERVER_PATH) != null;
	}

	public static void setMQTTServerPort(String newServerPort) {
		if (isSetServerPortSystemProperty()) {
			MokaKernelActivator.getDefault().logger.warn(
					"New value for " + IKernelProperties.MQTT_SERVER_PATH + " may conflict with set System Property"); //$NON-NLS-1$
		}
		mqttServerPort = newServerPort;

	}

	public static void setMQTTServerPath(String newServerPath) {
		if (isSetServerPathSystemProperty()) {
			MokaKernelActivator.getDefault().logger.warn(
					"New value for " + IKernelProperties.MQTT_SERVER_PATH + " may conflict with set System Property"); //$NON-NLS-1$
		}
		mqttServerPath = newServerPath;
	}

}
