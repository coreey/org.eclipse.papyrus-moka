/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  David LOPEZ BETANCUR (CEA LIST)
 *  Sebastien REVOL (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.datavisualization.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.moka.datavisualization.Activator;
import org.eclipse.papyrus.moka.datavisualization.csv.CSVResource;
import org.eclipse.papyrus.moka.datavisualization.profile.BooleanSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.DataSource;
import org.eclipse.papyrus.moka.datavisualization.profile.DoubleSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.IntegerSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.StringSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.VisualizationPackage;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;

public class VisualizationUtil {


	public static final String VISUALIZATION_PROFILE_URI = "pathmap://PAPYRUS_MOKA_DATA_VISUALIZATION/datavisualization.profile.uml";
	public static final String DATA_SOURCE_STEREO_NAME = "DataSource";
	public static final String VISUALIZATION_PROFILE_NAME = "DataVisualizationProfile";

	public static final String DATA_SOURCE_STEREO_QUALIFIED_NAME = VISUALIZATION_PROFILE_NAME + "::"
			+ DATA_SOURCE_STEREO_NAME;


	public static final String PRIMITIVE_TYPE_URI = "pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml";
	public static final String REAL_NAME = "Real";
	public static final String BOOLEAN_NAME = "Boolean";
	public static final String INTEGER_NAME = "Integer";
	public static final String STRING_NAME = "String";

	public static final byte BINARY_STRING_SEPARATOR = ';';

	public static final String BINARY_STRING_ZIP_ENTRY_NAME = "entry";



	public static Type getUMLTypeForValueSeries(ValueSeries serie) {
		switch (serie.eClass().getClassifierID()) {
		case VisualizationPackage.BOOLEAN_SERIES:
			return getUMLPrimitiveType(serie, BOOLEAN_NAME);
		case VisualizationPackage.INTEGER_SERIES:
			return getUMLPrimitiveType(serie, INTEGER_NAME);
		case VisualizationPackage.DOUBLE_SERIES:
			return getUMLPrimitiveType(serie, REAL_NAME);
		default:
			return getUMLPrimitiveType(serie, STRING_NAME);
		}

	}


	public static Stereotype getStereotype(EClass stereoEClass, EObject context) {

		Profile profile = UMLUtil.getProfile(stereoEClass.getEPackage(), context);
		if (profile != null) {
			return profile.getOwnedStereotype(stereoEClass.getName());
		}
		return null;
	}

	public static void applyVisualizationProfileIfNeeded(Package owningPackage) {
		Profile visualizationProfile = getVisualizationProfile(owningPackage);

		Iterator<Profile> profileIter = owningPackage.getAllAppliedProfiles().iterator();
		Profile appliedProfile = null;
		while (profileIter.hasNext() && (appliedProfile != visualizationProfile)) {
			appliedProfile = profileIter.next();
		}
		if (appliedProfile != visualizationProfile) {
			Package rootPackage = owningPackage.getModel();
			if (rootPackage != null && rootPackage.eResource() == owningPackage.eResource()) {
				rootPackage.applyProfile(visualizationProfile);
			} else {
				owningPackage.applyProfile(visualizationProfile);
			}
		}
	}

	public ResourceSet getResourceSet(EObject context) {
		if (context != null && context.eResource() != null && context.eResource().getResourceSet() != null) {
			return context.eResource().getResourceSet();
		} else {
			return new ResourceSetImpl();
		}
	}

	public static Profile getVisualizationProfile(EObject context) {
		return UMLUtil.getProfile(VisualizationPackage.eINSTANCE, context);
	}

	public static PrimitiveType getUMLPrimitiveType(EObject context, String typeName) {
		ResourceSet resSet = UMLUtil.getResourceSet(context);
		if (resSet == null) {
			resSet = new ResourceSetImpl();
		}
		return (PrimitiveType) resSet.getEObject(URI.createURI(PRIMITIVE_TYPE_URI).appendFragment(typeName), true);
	}

	public static Stereotype getDataSourceStereotype(EObject context) {
		Profile visualizationProfile = getVisualizationProfile(context);
		if (visualizationProfile != null) {
			return visualizationProfile.getOwnedStereotype(DATA_SOURCE_STEREO_NAME);
		}
		return null;
	}



	public static String getBinaryString(ValueSeries series) {
		try (ByteArrayOutputStream outputStringStream = new ByteArrayOutputStream();
				ZipOutputStream zipStream = new ZipOutputStream(outputStringStream);) {

			zipStream.putNextEntry(new ZipEntry(VisualizationUtil.BINARY_STRING_ZIP_ENTRY_NAME));

			switch (series.eClass().getClassifierID()) {

			case VisualizationPackage.BOOLEAN_SERIES:
				encodeBooleanSeries((BooleanSeries) series, zipStream);
				break;
			case VisualizationPackage.DOUBLE_SERIES:
				encodeDoubleSeries((DoubleSeries) series, zipStream);
				break;

			case VisualizationPackage.INTEGER_SERIES:
				encodeIntegerSeries((IntegerSeries) series, zipStream);
				break;

			case VisualizationPackage.STRING_SERIES:
				encodeStringSeries((StringSeries) series, zipStream);
				break;
			}

			zipStream.closeEntry();
			zipStream.close();

			return Base64.getEncoder().encodeToString(outputStringStream.toByteArray());
		} catch (IOException e1) {

		}

		return null;

	}

	private static void encodeBooleanSeries(BooleanSeries series, ZipOutputStream zipStream) throws IOException {
		for (Boolean value : series.getValues()) {
			if (value) {
				zipStream.write('1');
			} else {
				zipStream.write('0');
			}
			zipStream.write(VisualizationUtil.BINARY_STRING_SEPARATOR);
		}

	}

	public static void initValuesFromBinaryString(ValueSeries series, String newBinaryString) {

		if (newBinaryString != null) {

			byte[] array = Base64.getDecoder().decode(newBinaryString);

			// Deactivate notification when filling the list
			// We store current state before deactivating
			boolean previousDeliver = series.eDeliver();
			series.eSetDeliver(false);

			try (ZipInputStream zipInput = new ZipInputStream(new ByteArrayInputStream(array));) {

				zipInput.getNextEntry();

				switch (series.eClass().getClassifierID()) {

				case VisualizationPackage.BOOLEAN_SERIES:
					decodeBooleanSeries((BooleanSeries) series, zipInput);
					break;
				case VisualizationPackage.DOUBLE_SERIES:
					decodeDoubleSeries((DoubleSeries) series, zipInput);
					break;

				case VisualizationPackage.INTEGER_SERIES:
					decodeIntegerSeries((IntegerSeries) series, zipInput);
					break;

				case VisualizationPackage.STRING_SERIES:
					decodeStringSeries((StringSeries) series, zipInput);
					break;
				}

				zipInput.closeEntry();
				zipInput.close();

			} catch (IOException e) {

			}

			series.eSetDeliver(previousDeliver);
		}

	}

	private static void encodeStringSeries(StringSeries series, ZipOutputStream zipStream) throws IOException {
		for (String value : series.getValues()) {
			zipStream.write(value.getBytes());
			zipStream.write(VisualizationUtil.BINARY_STRING_SEPARATOR);
		}

	}

	private static void decodeStringSeries(StringSeries series, ZipInputStream zipInput) throws IOException {
		int readByte;
		ByteArrayOutputStream outputStringStream = new ByteArrayOutputStream();
		while ((readByte = zipInput.read()) != -1) {
			if (readByte == VisualizationUtil.BINARY_STRING_SEPARATOR) {
				series.getValues().add(outputStringStream.toString());
				outputStringStream.reset();
			} else {
				outputStringStream.write(readByte);
			}
		}

	}

	private static void encodeIntegerSeries(IntegerSeries series, ZipOutputStream zipStream) throws IOException {
		for (Integer value : series.getValues()) {
			zipStream.write(value.toString().getBytes());
			zipStream.write(VisualizationUtil.BINARY_STRING_SEPARATOR);
		}
	}

	private static void decodeIntegerSeries(IntegerSeries series, ZipInputStream zipInput)
			throws NumberFormatException, IOException {
		int readByte;
		ByteArrayOutputStream outputStringStream = new ByteArrayOutputStream();
		while ((readByte = zipInput.read()) != -1) {
			if (readByte == VisualizationUtil.BINARY_STRING_SEPARATOR) {
				series.getValues().add(Integer.parseInt(outputStringStream.toString()));
				outputStringStream.reset();
			} else {
				outputStringStream.write(readByte);
			}
		}

	}

	private static void encodeDoubleSeries(DoubleSeries series, ZipOutputStream zipStream) throws IOException {
		for (Double value : series.getValues()) {
			zipStream.write(value.toString().getBytes());
			zipStream.write(VisualizationUtil.BINARY_STRING_SEPARATOR);
		}

	}

	private static void decodeDoubleSeries(DoubleSeries series, ZipInputStream zipInput) throws IOException {
		int readByte;
		ByteArrayOutputStream outputStringStream = new ByteArrayOutputStream();
		while ((readByte = zipInput.read()) != -1) {
			if (readByte == VisualizationUtil.BINARY_STRING_SEPARATOR) {
				series.getValues().add(Double.parseDouble(outputStringStream.toString()));
				outputStringStream.reset();
			} else {
				outputStringStream.write(readByte);
			}
		}
	}

	private static void decodeBooleanSeries(BooleanSeries series, ZipInputStream zipInput) throws IOException {
		int readByte;
		while ((readByte = zipInput.read()) != -1) {
			if ('1' == readByte) {
				series.getValues().add(true);
			} else {
				series.getValues().add(false);
			}
		}

	}


	
	public static void importCSV(Package targetPackage, String csvFile, String separator) {
		URI targetURI = URI.createFileURI(csvFile);
		CSVResource csvRes = new CSVResource();
		csvRes.setURI(targetURI);
		
		Map<Object, Object> options = new HashMap<>();
		options.put(CSVResource.OPTION_SEPARATOR, separator);
		options.put(CSVResource.OPTION_TARGET_PACKAGE, targetPackage);

		try {
			csvRes.load(options);
		} catch (IOException e) {
			Activator.log(IStatus.ERROR, "Failed to load csv file", e);
		}
	}
	
	public static void exportCSV(DataSource dataSource, String targetFile, String separator) {
		URI targetURI = URI.createFileURI(targetFile);
		CSVResource csvRes = new CSVResource();
		csvRes.setURI(targetURI);

		csvRes.getContents().add(EcoreUtil.copy(dataSource));


		Map<Object, Object> options = new HashMap<>();
		options.put(CSVResource.OPTION_SEPARATOR, separator);

		try {
			csvRes.save(options);
		} catch (IOException e) {
			Activator.log(IStatus.ERROR, "Failed to save csv file", e);
		}
	}

}
