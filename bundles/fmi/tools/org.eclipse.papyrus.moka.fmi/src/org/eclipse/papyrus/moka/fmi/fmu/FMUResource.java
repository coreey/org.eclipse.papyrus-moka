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
package org.eclipse.papyrus.moka.fmi.fmu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.AbstractFile;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.ArchiveToUnzipInFMU;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelFactory;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.FolderToCreateInFMU;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.JavaFileProxy;
import org.eclipse.papyrus.moka.fmi.modeldescription.DocumentRoot;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiFactory;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage;
import org.eclipse.papyrus.moka.fmi.modeldescription.util.FmiResourceImpl;
import org.eclipse.papyrus.moka.fmi.util.FMUResourceUtil;
import org.eclipse.papyrus.moka.fmi.util.UnzipUtility;

public class FMUResource extends XMLResourceImpl {

	FMUParser fmuParser;
	FMUBundle fmuBundle;

	public FMUParser getFmuParser() {
		return fmuParser;
	}

	@Override
	public void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {

		Path tmpDirectoryPath = Files.createTempDirectory("fmuResource");
		UnzipUtility.unzip(new ZipInputStream(inputStream), tmpDirectoryPath.toString(), uri.lastSegment());
		fmuParser = new FMUParser(tmpDirectoryPath.toString());
		createFmuBundle();
		getContents().add(fmuBundle);

	}

	private void createFmuBundle() throws IOException {
		fmuBundle = FmumetamodelFactory.eINSTANCE.createFMUBundle();
		if (fmuParser.getModelDescription() != null) {
			fmuBundle.setModelDescription(fmuParser.getModelDescription());
		}

		File fmuFolder = fmuParser.getFMUFolder();
		for (File fmuChildFile : fmuFolder.listFiles()) {
			switch (fmuChildFile.getName()) {
			case FMUResourceUtil.FOLDER_RESOURCES:
				fmuBundle.getResourcesFiles().addAll(FMUResourceUtil.createJavaFileProxies(fmuChildFile.listFiles()));
				break;

			case FMUResourceUtil.FOLDER_DOCUMENTATION:
				fmuBundle.getDocumentationFiles()
						.addAll(FMUResourceUtil.createJavaFileProxies(fmuChildFile.listFiles()));
				break;

			case FMUResourceUtil.FOLDER_SOURCES:
				fmuBundle.getSourceFiles()
						.addAll(FMUResourceUtil.createJavaFileProxies(fmuChildFile.listFiles()));
				break;

			case FMUResourceUtil.FOLDER_BINARIES:
				for (File fmuGrandChildFile : fmuChildFile.listFiles()) {
					switch (fmuGrandChildFile.getName()) {
					case FMUResourceUtil.BINARIES_WIN32:
						fmuBundle.getWin32Files()
								.addAll(FMUResourceUtil.createJavaFileProxies(fmuGrandChildFile.listFiles()));
						break;
					case FMUResourceUtil.BINARIES_WIN64:
						fmuBundle.getWin64Files()
								.addAll(FMUResourceUtil.createJavaFileProxies(fmuGrandChildFile.listFiles()));
						break;
					case FMUResourceUtil.BINARIES_LINUX32:
						fmuBundle.getLinux32Files()
								.addAll(FMUResourceUtil.createJavaFileProxies(fmuGrandChildFile.listFiles()));
						break;
					case FMUResourceUtil.BINARIES_LINUX64:
						fmuBundle.getLinux64Files()
								.addAll(FMUResourceUtil.createJavaFileProxies(fmuGrandChildFile.listFiles()));
						break;
					case FMUResourceUtil.BINARIES_DARWIN32:
						fmuBundle.getDarwin32Files()
								.addAll(FMUResourceUtil.createJavaFileProxies(fmuGrandChildFile.listFiles()));
						break;
					case FMUResourceUtil.BINARIES_DARWIN64:
						fmuBundle.getDarwin64Files()
								.addAll(FMUResourceUtil.createJavaFileProxies(fmuGrandChildFile.listFiles()));
						break;

					default:
						// there should not be a file there, but we keep track
						// of it as a root file with a compound path
						fmuBundle.getRootFiles().add(FMUResourceUtil.createJavaFileProxy(fmuGrandChildFile,
								FMUResourceUtil.FOLDER_BINARIES + "/" + fmuGrandChildFile.getName()));
						break;
					}
				}

			default:
				if (! FMUResourceUtil.isAStandardFile(fmuChildFile)){
					fmuBundle.getRootFiles().add(FMUResourceUtil.createJavaFileProxy(fmuChildFile));
				}
			
				break;
			}

		}

	}

	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		if (getContents().get(0) instanceof FMUBundle) {
			fmuBundle = (FMUBundle) getContents().get(0);
			ZipOutputStream zipOputputStream = new ZipOutputStream(outputStream);

			saveModelDescription(zipOputputStream);
			saveBinaries(zipOputputStream);
			saveResources(zipOputputStream);
			saveSources(zipOputputStream);
			saveDocumentation(zipOputputStream);
			saveRoot(zipOputputStream);
			zipOputputStream.close();

		} else {
			throw new IOException("The content of the FMUResource should be a FMUBundle");
		}

	}

	private void saveModelDescription(ZipOutputStream zipOutputStream) throws IOException {
		if (fmuBundle.getModelDescription() != null) {

			XMLResource modelDescRes = new FmiResourceImpl(null);
			FmiModelDescriptionType modelDesc = EcoreUtil.copy(fmuBundle.getModelDescription());
			DocumentRoot root = FmiFactory.eINSTANCE.createDocumentRoot();
			root.setFmiModelDescription(modelDesc);
			modelDescRes.getContents().add(root);
			ExtendedMetaData exMet = new BasicExtendedMetaData();
			exMet.setQualified(FmiPackage.eINSTANCE, false);
			Map<Object, Object> saveOptions = new HashMap<Object, Object>();
			saveOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, exMet);
			saveOptions.put(XMLResource.OPTION_ENCODING, "utf-8");

			StringWriter stringWriter = new StringWriter();
			modelDescRes.save(stringWriter, saveOptions);

			ZipEntry modelDescEntry = new ZipEntry(FMUResourceUtil.MODEL_DESCRIPTION_FILE_NAME);
			zipOutputStream.putNextEntry(modelDescEntry);
			zipOutputStream.write(stringWriter.getBuffer().toString().getBytes());
			zipOutputStream.closeEntry();

		}

	}

	private void saveBinaries(ZipOutputStream zipOputputStream) throws IOException {
		addFiles(fmuBundle.getWin32Files(), zipOputputStream,
				FMUResourceUtil.FOLDER_BINARIES + "/" + FMUResourceUtil.BINARIES_WIN32);
		addFiles(fmuBundle.getWin64Files(), zipOputputStream,
				FMUResourceUtil.FOLDER_BINARIES + "/" + FMUResourceUtil.BINARIES_WIN64);
		addFiles(fmuBundle.getLinux32Files(), zipOputputStream,
				FMUResourceUtil.FOLDER_BINARIES + "/" + FMUResourceUtil.BINARIES_LINUX32);
		addFiles(fmuBundle.getLinux64Files(), zipOputputStream,
				FMUResourceUtil.FOLDER_BINARIES + "/" + FMUResourceUtil.BINARIES_LINUX64);
		addFiles(fmuBundle.getDarwin32Files(), zipOputputStream,
				FMUResourceUtil.FOLDER_BINARIES + "/" + FMUResourceUtil.BINARIES_DARWIN32);
		addFiles(fmuBundle.getDarwin64Files(), zipOputputStream,
				FMUResourceUtil.FOLDER_BINARIES + "/" + FMUResourceUtil.BINARIES_DARWIN64);
	}

	private void saveRoot(ZipOutputStream zipOutputStream) throws IOException {
		addFiles(fmuBundle.getRootFiles(), zipOutputStream, ".");
	}

	private void saveDocumentation(ZipOutputStream zipOutputStream) throws IOException {
		addFiles(fmuBundle.getDocumentationFiles(), zipOutputStream,FMUResourceUtil.FOLDER_DOCUMENTATION );
	}

	private void saveResources(ZipOutputStream zipOutputStream) throws IOException {
		addFiles(fmuBundle.getResourcesFiles(), zipOutputStream, FMUResourceUtil.FOLDER_RESOURCES);
	}
	
	private void saveSources(ZipOutputStream zipOutputStream) throws IOException {
		addFiles(fmuBundle.getSourceFiles(), zipOutputStream, FMUResourceUtil.FOLDER_SOURCES);
	}

	private void addFile(AbstractFile fmuFile, ZipOutputStream zipOutputStream, String fmuFolder) throws IOException {
		if (fmuFile instanceof JavaFileProxy && ((JavaFileProxy) fmuFile).getFile() != null
				&& ((JavaFileProxy) fmuFile).getFile().exists()) {
			addEntry(((JavaFileProxy) fmuFile).getFile(), zipOutputStream, fmuFolder, fmuFile.getName());

		} else if (fmuFile instanceof FolderToCreateInFMU) {
			FolderToCreateInFMU folderToCreate = (FolderToCreateInFMU) fmuFile;

			if (folderToCreate.getChildren().isEmpty()) {
				createEmptyDir(zipOutputStream, fmuFolder + "/" + folderToCreate.getName());
			} else {
				for (AbstractFile childFile : folderToCreate.getChildren()) {
					addFile(childFile, zipOutputStream, fmuFolder + "/" + folderToCreate.getName());
				}
			}

		} else if (fmuFile instanceof ArchiveToUnzipInFMU) {
			unzipArchiveFile((ArchiveToUnzipInFMU) fmuFile, zipOutputStream, fmuFolder);
		}

	}

	private void addFiles(List<AbstractFile> fmuFiles, ZipOutputStream zipOutputStream, String fmuFolder)
			throws IOException {
		for (AbstractFile fmuFile : fmuFiles) {
			addFile(fmuFile, zipOutputStream, fmuFolder);
		}
	}

	private void unzipArchiveFile(ArchiveToUnzipInFMU archiveToAdd, ZipOutputStream zipOutputStream, String fmuFolder)
			throws IOException {
		if (archiveToAdd.getArchiveFile() != null && archiveToAdd.getArchiveFile().exists()) {
			String rootName = fmuFolder;
			try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(archiveToAdd.getArchiveFile()));) {

				if (archiveToAdd.getName() != null) {
					rootName = fmuFolder +"/"+ archiveToAdd.getName();
				}

				ZipEntry entryToCopy;
				while ((entryToCopy = zipIn.getNextEntry()) != null) {
					ZipEntry newEntry = new ZipEntry(rootName + "/" + entryToCopy.getName());
					zipOutputStream.putNextEntry(newEntry);
					byte[] buffer = new byte[1024];
					int len;
					while ((len = zipIn.read(buffer)) > 0) {
						zipOutputStream.write(buffer, 0, len);
					}
					zipOutputStream.closeEntry();
				}
			}
			;

		}

	}

	private void createEmptyDir(ZipOutputStream zipOutputStream, String entryName) throws IOException {
		ZipEntry emptyDirEntry = new ZipEntry(entryName + "/");
		zipOutputStream.putNextEntry(emptyDirEntry);
		zipOutputStream.closeEntry();
	}

	private void addEntry(File file, ZipOutputStream zipOutputStream, String fmuFolder, String entryName)
			throws IOException {
		String name = entryName != null ? entryName : file.getName();
		if (file.isDirectory()) {
			if (file.listFiles().length == 0) {
				createEmptyDir(zipOutputStream, fmuFolder + "/" + name);
			}
			for (File child : file.listFiles()) {
				addEntry(child, zipOutputStream, fmuFolder + "/" + name, null);
			}
		} else {
			ZipEntry fileEntry = new ZipEntry(fmuFolder + "/" + name);
			try (FileInputStream in = new FileInputStream(file)) {
				zipOutputStream.putNextEntry(fileEntry);
				byte[] buffer = new byte[1024];
				int len;
				while ((len = in.read(buffer)) > 0) {
					zipOutputStream.write(buffer, 0, len);
				}
				zipOutputStream.closeEntry();
			}
		}
	}

	@Override
	protected void doUnload() {
		super.doUnload();
		if (fmuParser != null) {
			fmuParser.clean();
			fmuParser = null;
		}

	}
}