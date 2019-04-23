/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmi.util;

import org.eclipse.papyrus.moka.fmi.fmu.FMUParser;

public class FMIOSDetector {
		private static final String WIN_DLL_EXTENSION = ".dll";
		private static final String UNIX_DLL_EXTENSION = ".so";
		private static String os = System.getProperty("os.name").toLowerCase();
	    private static String arch = System.getProperty("os.arch").toLowerCase();
	

		
		public static String getOS(){
			
			
		
			if (isWindows()) {
				if (is64Bits()) {
					return FMUResourceUtil.BINARIES_WIN64;
				}else {
					return FMUResourceUtil.BINARIES_WIN32;
				}
			} else if (isMac()) {
				if (is64Bits()) {
					return FMUResourceUtil.BINARIES_DARWIN64;
				}else {
					return FMUResourceUtil.BINARIES_DARWIN32;
				}
			} else if (isUnix()) {
				if (is64Bits()) {
					return FMUResourceUtil.BINARIES_LINUX64;
				}else {
					return FMUResourceUtil.BINARIES_LINUX32;
				}
			}else {
				return null;
			}
		}

		
		public static String getDLLFileExtension(){
			return isWindows()? WIN_DLL_EXTENSION : UNIX_DLL_EXTENSION;
		}
		
		public static boolean is64Bits() {
		
			return arch.indexOf("64")>=0;
		}



		public static boolean isWindows() {

			return (os.indexOf("win") >= 0);

		}

		public static boolean isMac() {

			return (os.indexOf("mac") >= 0);

		}

		public static boolean isUnix() {

			return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") > 0 );
			
		}

		public static boolean isSolaris() {

			return (os.indexOf("sunos") >= 0);

		}

	
}
