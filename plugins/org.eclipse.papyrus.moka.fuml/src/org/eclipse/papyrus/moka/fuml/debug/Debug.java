package org.eclipse.papyrus.moka.fuml.debug;

public class Debug {

	public static void println(String message) {
		System.out.println(message) ;
		// FIXME Bug 404555: [Moka] Pollution of the console with debug messages
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=404555
	}
}