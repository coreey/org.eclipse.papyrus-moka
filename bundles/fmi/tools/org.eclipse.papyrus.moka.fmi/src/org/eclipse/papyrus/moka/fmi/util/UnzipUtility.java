/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmi.util;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.emf.common.util.URI;
 

public class UnzipUtility {
    /**
     * Size of the buffer to read/write data
     */
    private static final int BUFFER_SIZE = 4096;
    /**
     * Extracts a zip file specified by the zipFilePath to a directory specified by
     * destDirectory (will be created if does not exists)
     * @param zipFilePath
     * @param destDirectory
     * @throws IOException
     */
    public static void unzip(URI zipFileURI, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
		try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFileURI.toFileString()))) {
			unzip(zipIn, destDirectory, zipFileURI.lastSegment());
		}
    }
    
    
    public static void unzip(ZipInputStream zipIn, String destDirectory, String zipFileName) throws IOException {
    	ZipEntry entry = zipIn.getNextEntry();
		try {			
			// iterates over entries in the zip file
			while (entry != null) {
				String filePath = destDirectory + File.separator + entry.getName();
				boolean isDirectory = entry.isDirectory();

				String replacement = File.separator.equals("\\") ? "\\\\" : "/";
				filePath = filePath.replaceAll("/", replacement);
				filePath = filePath.replaceAll("\\\\", replacement);
				if (!isDirectory) {
					// if the entry is a file, extracts it
					extractFile(zipIn, filePath);
				} else {
					// if the entry is a directory, make the directory
					File dir = new File(filePath);
					dir.mkdirs();

				}
				zipIn.closeEntry();
				entry = zipIn.getNextEntry();
			}
			zipIn.close();
		} catch (IOException e) {
			throw new IOException("Could not unzip " + zipFileName +  " archive.\n The problematic entry is \"" + entry.getName() + "\".");
		} finally {
			zipIn.close();
		}
	}
	/**
     * Extracts a zip entry (file entry)
     * @param zipIn
     * @param filePath
     * @throws IOException
     */
    private static void extractFile(ZipInputStream zipIn,  String filePath) throws IOException {
	
		File outputFile = new File(filePath);
		File parent = new File(outputFile.getParent());
		if (!parent.exists()) {
			parent.mkdirs();
		}
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
		byte[] bytesIn = new byte[BUFFER_SIZE];
		int read = 0;
		while ((read = zipIn.read(bytesIn)) != -1) {
			bos.write(bytesIn, 0, read);
		}
		bos.close();
		outputFile.setExecutable(true);
		      
        
    }
}