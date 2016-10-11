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
package org.eclipse.papyrus.moka.datavisualization.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.papyrus.moka.datavisualization.profile.BooleanSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.DataSource;
import org.eclipse.papyrus.moka.datavisualization.profile.DoubleSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.IntegerSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.StringSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.VisualizationPackage;
import org.eclipse.papyrus.moka.datavisualization.util.VisualizationUtil;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

public class CSVResource extends ResourceImpl {




	private String separator=";";


	public static final String OPTION_SEPARATOR= "separator";
	public static final String OPTION_TARGET_PACKAGE= "TARGET_PACKAGE";



	private static final String VALUES_FEATURE_NAME = "values";





	
	private UMLFactory eFactory = (UMLFactory) UMLPackage.eINSTANCE.getEFactoryInstance();
	private Package rootModel;
	private DataType dataType;
	private DataSource  dataSource;
	private ArrayList<ValueSeries> seriesList= new ArrayList<>();

	private String DEFAULT_SOURCE_NAME= "CSVFile";
	




	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
	
		initializeOptions(options);
		
		URI uri = getURI();
		String sourceName = DEFAULT_SOURCE_NAME;
		if (uri != null){
			sourceName = uri.trimFileExtension().lastSegment();
		}
		if (rootModel ==null){
			rootModel = eFactory.createModel();
			rootModel.setName(sourceName+"Model");
			getContents().add(rootModel);
		}
		
		
		VisualizationUtil.applyVisualizationProfileIfNeeded(rootModel);
		
		dataType = (DataType) rootModel.createOwnedType(sourceName, UMLPackage.eINSTANCE.getDataType());
		dataType.setName(sourceName);
		dataType.applyStereotype(VisualizationUtil.getDataSourceStereotype(rootModel));
		
		dataType.eSetDeliver(false);
		rootModel.getPackagedElements().add(dataType);
		
		//first release does not support options
		//initializeOptions(options);

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

		String line =bufferedReader.readLine();

		//we skip emptyLines
		while (line != null && line.trim().isEmpty()){
			line = bufferedReader.readLine();
		}
		if (line != null){
			 initializeProperties(line);

			line = bufferedReader.readLine();
			//we skip emptyLines
			while (line != null && line.trim().isEmpty()){
				line = bufferedReader.readLine();
			}
			initializeSeries(line);

			while ((line = bufferedReader.readLine()) != null){
				populateValues(line);
			}

		}
			
		bufferedReader.close();

		
		rootModel.eSetDeliver(true);
		for (ValueSeries serie : seriesList){
			serie.eSetDeliver(true);
		}

		
	}



	private void initializeOptions(Map<?, ?> options) {
		if (options != null){

			Object optionSeparator = options.get(OPTION_SEPARATOR);
			if (optionSeparator instanceof String){
				separator = (String) optionSeparator;
			}
			
			Object optionTargetPackage = options.get(OPTION_TARGET_PACKAGE);
		
			if (optionTargetPackage instanceof Package){
				rootModel = (Package) optionTargetPackage;
			}
		}
		
	}



	private void initializeSeries(String line) {
		String[] tokens = line.split(separator);
		if (tokens != null){
			for(int i = 0; i< tokens.length; i++){
				String token = tokens[i];
				ValueSeries serie = getValueSeries(guessType(token), dataType.getOwnedAttributes().get(i));
				 addInSeries(serie, token);
			}
		}
	}


	private void initializeProperties(String line) {
		String[] tokens = line.split(separator);
		if (tokens != null){
			for(int i = 0; i< tokens.length; i++){
				dataType.createOwnedAttribute(tokens[i], null);
			}
		}
		
	}




	private int computeAlternateType(String token, int unSuccessfulID){
		switch (unSuccessfulID){

		case VisualizationPackage.BOOLEAN_SERIES :
			//if we parsed "true or false" once and then failed
			//the only possible alternative is String 
			return EcorePackage.ESTRING;

		case VisualizationPackage.INTEGER_SERIES :
			//we parsed an int once and then failed, maybe it's a double
			if(isDouble(token)){
				return EcorePackage.EDOUBLE;
			}else {
				//if it's not a double, it's a string
				return EcorePackage.ESTRING;
			}
		case VisualizationPackage.DOUBLE_SERIES :
			//if we parsed a double once and then failed,
			//we fall back to String
			return EcorePackage.ESTRING;
		}

		return EcorePackage.ESTRING;
	}

	private int guessType(String token){
		if (isBoolean(token)){
			return EcorePackage.EBOOLEAN;
		}else if (isInteger(token)){
			return EcorePackage.EINT;
		}else if (isDouble(token)){
			return 	EcorePackage.EDOUBLE;
		}else {
			return  EcorePackage.ESTRING;
		}

	}



	private boolean isDouble(String token) {
		try{
			Double.parseDouble(token);
			return true;
		}catch(NumberFormatException exDouble){
			return false;
		}
	}

	private boolean isInteger(String token) {
		try{
			Integer.decode(token);
			return true;
		}catch(NumberFormatException exDouble){
			return false;
		}
	}



	private boolean isBoolean(String token) {
		return "TRUE".equalsIgnoreCase(token) || "FALSE".equalsIgnoreCase(token);
	}


	private boolean parseBoolean(String token) throws NumberFormatException{
		if ("TRUE".equalsIgnoreCase(token)){
			return true;
		}else if ("FALSE".equalsIgnoreCase(token)){
			return false;
		}else {
			throw new NumberFormatException();
		}
	}

	private ValueSeries getValueSeries(int dataTypeID, Property property){
		ValueSeries ret= null;
		
		switch (dataTypeID){
		case EcorePackage.EDOUBLE :
			ret = (ValueSeries) property.applyStereotype(VisualizationUtil.getStereotype(VisualizationPackage.eINSTANCE.getDoubleSeries(), property));
			property.setType(VisualizationUtil.getUMLPrimitiveType(property,VisualizationUtil.REAL_NAME));
			break;
		case EcorePackage.EBOOLEAN:
			ret = (ValueSeries) property.applyStereotype(VisualizationUtil.getStereotype(VisualizationPackage.eINSTANCE.getBooleanSeries(), property));
			property.setType(VisualizationUtil.getUMLPrimitiveType(property,VisualizationUtil.BOOLEAN_NAME));
			break;
		case EcorePackage.EINT :
			ret = (ValueSeries) property.applyStereotype(VisualizationUtil.getStereotype(VisualizationPackage.eINSTANCE.getIntegerSeries(), property));
			property.setType(VisualizationUtil.getUMLPrimitiveType(property,VisualizationUtil.INTEGER_NAME));
			break;
		default:
			ret = (ValueSeries) property.applyStereotype(VisualizationUtil.getStereotype(VisualizationPackage.eINSTANCE.getStringSeries(), property));
			property.setType(VisualizationUtil.getUMLPrimitiveType(property,VisualizationUtil.STRING_NAME));
			break;
		}
		ret.eSetDeliver(false);
		seriesList.add(ret);
		return ret;
	}


	private void addInSeries(ValueSeries serie, String token){
		try{
			int id = serie.eClass().getClassifierID();
			if ( VisualizationPackage.DOUBLE_SERIES== id){
				((DoubleSeries)serie).getValues().add(Double.parseDouble(token));
			}else if (VisualizationPackage.STRING_SERIES == id){
				((StringSeries)serie).getValues().add(token);
			}else if ( VisualizationPackage.INTEGER_SERIES == id){
				((IntegerSeries)serie).getValues().add(Integer.decode(token));
			}else {
				((BooleanSeries)serie).getValues().add(parseBoolean(token));
			}
			
		}catch(NumberFormatException exeption){
			reinitializeSeries(serie, token);
		}

	}


	private void reinitializeSeries(ValueSeries serie, String token) {

		ValueSeries newSerie = getValueSeries(computeAlternateType(token, serie.eClass().getClassifierID()), serie.getBase_Property());
		int index = seriesList.indexOf(serie);
		seriesList.remove(index);
		seriesList.add(index,newSerie);
		
		@SuppressWarnings("rawtypes")
		List values = (List) serie.eGet(serie.eClass().getEStructuralFeature(VALUES_FEATURE_NAME));

		for (Object value : values){
			addInSeries(newSerie, value.toString());
		}
		
		addInSeries(newSerie, token);

		serie.getBase_Property().unapplyStereotype(UMLUtil.getStereotype(serie));
		

	}



	private void populateValues(String line) throws IOException {
		String[] tokens = line.split(separator);
		for (int i = 0; i< tokens.length; i++){
			//we skip incorrect lines
			if (tokens.length ==  dataType.getOwnedAttributes().size()){
				addInSeries( seriesList.get(i), tokens[i]);
			}
		}

	}




	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		//first release does not support options
		initializeOptions(options);
		updateDataType();
		if (dataType != null){
			BufferedWriter writter = new BufferedWriter(new PrintWriter(outputStream));
			
			
			if( dataSource != null){
				List<ValueSeries> series = dataSource.getSeries();
				int seriesNumber = series.size();
				
				for(int i=0; i< seriesNumber; i++){
					writter.append(series.get(i).getBase_Property().getName());
					if (i < seriesNumber -1){
						writter.append(separator);
					}
				}
				writter.newLine();
				
			
				int lineNumber = dataSource.getSeries().get(0).getSize();
				
				for (int lineIndex  =0 ; lineIndex< lineNumber; lineIndex++ ){
					for(int serieIndex  = 0; serieIndex <seriesNumber; serieIndex++){
						writter.append( dataSource.getSeries().get(serieIndex).getStringValue(lineIndex));
						if (serieIndex < seriesNumber-1){
							writter.append(separator);
						}
					}
					if (lineIndex < lineNumber -1){
						writter.newLine();
					}
				
				}
			}
		
			
			writter.close();
		
			
			
		}
		
	}



	private void updateDataType() {
		
		for (EObject content : getContents()){
			if( content instanceof DataSource && ((DataSource)content).getBase_DataType() != null){
				dataSource = (DataSource) content;
				dataType = ((DataSource)content).getBase_DataType() ;
				return;
			}
		}
		
	}


}
