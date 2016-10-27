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
package org.eclipse.papyrus.moka.fmu.json;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.moka.discreteevent.DEScheduler;
import org.eclipse.papyrus.moka.fmu.communication.FMUInterface;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class JSONSocketClient extends Thread {

	FMUInterface fmu;
	int portNumber;

	public JSONSocketClient(int portNumber) {

		this.portNumber = portNumber;
	}

	public void setFmu(FMUInterface fmu) {
		this.fmu = fmu;
	}

	@Override
	public void run() {

		JsonFactory factory = new JsonFactory();

		JsonParser parser = null;
		JsonGenerator generator = null;
		try (Socket socket = new Socket("localhost", portNumber);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
				DataInputStream inputStream = new DataInputStream(socket.getInputStream());
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {

			parser = factory.createParser(in);
			generator = factory.createGenerator(out);

		
//			String line;
//			JsonNode rootNode;
//			while ((rootNode = mapper.readTree(parser)) != null) {
//				System.out.println(rootNode);
//				JSONRequest request = new JSONRequest();
//				if (rootNode.get(JSONRequest.INIT)!= null){
//					request.init = true;
//				}else if (rootNode.get(JSONRequest.TERMINATE) != null){
//					request.terminate = true;
//				}else {
//					request.t = rootNode.get(JSONRequest.STEP_TIME).asDouble();
//					request.h = rootNode.get(JSONRequest.STEP_SIZE).asDouble();
//					
//				}
//				
//				JSONResponse response = handleRequest(request);
//				sendResponse(generator, response);
//			}

			while (parser.nextToken() == JsonToken.START_OBJECT) {
				JSONRequest request = new JSONRequest();
				parseRequest(parser, request);

				JSONResponse response = handleRequest(request);
				sendResponse(generator, response);

			}
			parser.close();
			generator.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void sendResponse(JsonGenerator generator, JSONResponse response) {

		try {
			generator.writeStartObject();
			generator.writeStringField(JSONResponse.STATUS, response.status);
			if (response.nextDate != null){
				generator.writeNumberField(JSONResponse.NEXT_DATE, response.nextDate.doubleValue());
			}
			
			if (response.boolVRs != null) {
				generator.writeFieldName(JSONRequest.BOOL_VRS);
				writeIntArray(generator, response.boolVRs);
			}
			if (response.bools != null) {
				generator.writeFieldName(JSONRequest.BOOLS);
				writeBoolArray(generator, response.bools);
			}
			if (response.intVRs != null) {
				generator.writeFieldName(JSONRequest.INT_VRS);
				writeIntArray(generator, response.intVRs);
			}
			if (response.ints != null) {
				generator.writeFieldName(JSONRequest.INTS);
				writeIntArray(generator, response.ints);
			}
			if (response.doubleVRs != null) {
				generator.writeFieldName(JSONRequest.DOUBLE_VRS);
				writeIntArray(generator, response.doubleVRs);
			}
			if (response.doubles != null) {
				generator.writeFieldName(JSONRequest.DOUBLES);
				writeDoubleArray(generator, response.doubles);
			}
			if (response.stringVRs != null) {
				generator.writeFieldName(JSONRequest.STRING_VRS);
				writeIntArray(generator, response.stringVRs);
			}
			if (response.strings != null) {
				generator.writeFieldName(JSONRequest.STRINGS);
				writeStringArray(generator, response.strings);
			}
			generator.writeEndObject();
			generator.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void writeIntArray(JsonGenerator generator, int[] array) {
		try {
			generator.writeStartArray();
			for (int value : array) {
				generator.writeNumber(value);
			}
			generator.writeEndArray();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void writeBoolArray(JsonGenerator generator, boolean[] array) {
		try {
			generator.writeStartArray();
			for (boolean value : array) {
				generator.writeBoolean(value);
			}
			generator.writeEndArray();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void writeDoubleArray(JsonGenerator generator, double[] array) {
		try {
			generator.writeStartArray();
			for (double value : array) {
				generator.writeNumber(value);
			}
			generator.writeEndArray();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void writeStringArray(JsonGenerator generator, String[] array) {
		try {
			generator.writeStartArray();
			for (String value : array) {
				generator.writeString(value);
			}
			generator.writeEndArray();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void parseRequest(JsonParser parser, JSONRequest request) {
		try {

			while (parser.nextToken() != JsonToken.END_OBJECT) {
				String fieldName = parser.getCurrentName();
				parser.nextToken();

				if (fieldName.equals(JSONRequest.INIT)) {
					request.init = true;
				} else if (fieldName.equals(JSONRequest.TERMINATE)) {
					request.terminate = true;
				} else if (fieldName.equals(JSONRequest.STEP_TIME)) {
					request.t = parser.getValueAsDouble();
				} else if (fieldName.equals(JSONRequest.STEP_SIZE)) {
					request.h = parser.getValueAsDouble();
				} else if (fieldName.equals(JSONRequest.INT_VRS)) {
					parseIntArray(parser, request.intVRs);
				} else if (fieldName.equals(JSONRequest.INTS)) {
					parseIntArray(parser, request.ints);
				} else if (fieldName.equals(JSONRequest.DOUBLE_VRS)) {
					parseIntArray(parser, request.doubleVRs);
				} else if (fieldName.equals(JSONRequest.DOUBLES)) {
					parseDoubleArray(parser, request.doubles);
				} else if (fieldName.equals(JSONRequest.BOOL_VRS)) {
					parseIntArray(parser, request.boolVRs);
				} else if (fieldName.equals(JSONRequest.BOOLS)) {
					parseBoolArray(parser, request.bools);
				} else if (fieldName.equals(JSONRequest.STRING_VRS)) {
					parseIntArray(parser, request.stringVRs);
				} else if (fieldName.equals(JSONRequest.STRINGS)) {
					parseStringArray(parser, request.strings);
				}

			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void parseIntArray(JsonParser parser, List<Integer> table) {
		try {
			

			while (!parser.nextToken().equals(JsonToken.END_ARRAY)) {
				table.add(parser.getValueAsInt());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void parseBoolArray(JsonParser parser, List<Boolean> table) {
		try {
		

			while (!parser.nextToken().equals(JsonToken.END_ARRAY)) {
				table.add(parser.getValueAsBoolean());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void parseStringArray(JsonParser parser, List<String> table) {
		try {

		
			while (!parser.nextToken().equals(JsonToken.END_ARRAY)) {
				table.add(parser.getValueAsString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void parseDoubleArray(JsonParser parser, List<Double> table) {
		try {
			
			
			while (!parser.nextToken().equals(JsonToken.END_ARRAY)) {
				table.add(parser.getValueAsDouble());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private JSONResponse handleRequest(JSONRequest request) {
		JSONResponse resp = new JSONResponse();
		if (request.init == true) {
			updateValues(request);
			fmu.init();
			fmu.updateMaps();
			updateResponse(resp);
			resp.status = "ok";
		} else if (request.terminate) {
			//Fast exit method...
			System.exit(0);
			//fmu.terminate();
			//resp.status = "ok";
		} else {
			// else do step;
			updateValues(request);
			fmu.doStep(request.t, request.h);
			fmu.updateMaps();
			updateResponse(resp);
			resp.status = "ok";
		}
		return resp;
	}

	private void updateResponse(JSONResponse resp) {

		if(!DEScheduler.getInstance().getEvents().isEmpty()){
			double absoluteDate = DEScheduler.getInstance().getEvents().get(0).getAbsoluteDate();
			resp.nextDate = absoluteDate;
		}
		 
		 
		int index = 0;
		if (!fmu.fmiGetBools().isEmpty()) {
			resp.boolVRs = new int[fmu.fmiGetBools().size()];
			resp.bools = new boolean[fmu.fmiGetBools().size()];

			for (Map.Entry<Integer, Boolean> entry : fmu.fmiGetBools().entrySet()) {
				resp.boolVRs[index] = entry.getKey();
				resp.bools[index] = entry.getValue();
				index++;
			}
			fmu.fmiGetBools().clear();
		}

		if (!fmu.fmiGetStrings().isEmpty()) {
			resp.stringVRs = new int[fmu.fmiGetStrings().size()];
			resp.strings = new String[fmu.fmiGetStrings().size()];

			index = 0;
			for (Map.Entry<Integer, String> entry : fmu.fmiGetStrings().entrySet()) {
				String value = entry.getValue();
				if (value.isEmpty()) {
					value = "null";
				}
				resp.stringVRs[index] = entry.getKey();
				resp.strings[index] = value;
				index++;
			}
			fmu.fmiGetStrings().clear();
		}

		if (!fmu.fmiGetReals().isEmpty()) {
			resp.doubleVRs = new int[fmu.fmiGetReals().size()];
			resp.doubles = new double[fmu.fmiGetReals().size()];

			index = 0;
			for (Map.Entry<Integer, Double> entry : fmu.fmiGetReals().entrySet()) {
				resp.doubleVRs[index] = entry.getKey();
				resp.doubles[index] = entry.getValue();
				index++;
			}
			fmu.fmiGetReals().clear();
		}

		if (!fmu.fmiGetIntegers().isEmpty()) {
			resp.intVRs = new int[fmu.fmiGetIntegers().size()];
			resp.ints = new int[fmu.fmiGetIntegers().size()];
			index = 0;
			for (Map.Entry<Integer, Integer> entry : fmu.fmiGetIntegers().entrySet()) {
				resp.intVRs[index] = entry.getKey();
				resp.ints[index] = entry.getValue();
				index++;
			}
			fmu.fmiGetIntegers().clear();
		}
	}

	private void updateValues(JSONRequest request) {
		if (!request.boolVRs.isEmpty()) {

			for (int i = 0; i < request.boolVRs.size(); i++) {
				fmu.fmiGetBools().put(request.boolVRs.get(i), request.bools.get(i));
				
			}
			fmu.fmiSetBools(fmu.fmiGetBools());
		}
		if (!request.doubleVRs.isEmpty()) {

			for (int i = 0; i < request.doubleVRs.size(); i++) {
				fmu.fmiGetReals().put(request.doubleVRs.get(i), request.doubles.get(i));
				
			}
			fmu.fmiSetReals(fmu.fmiGetReals());
		}
		if (!request.intVRs.isEmpty()) {
			
			for (int i = 0; i < request.intVRs.size(); i++) {
				fmu.fmiGetIntegers().put(request.intVRs.get(i), request.ints.get(i));
				
			}
			fmu.fmiSetIntegers(fmu.fmiGetIntegers());
		}
		if (!request.stringVRs.isEmpty()) {
			
			for (int i = 0; i < request.stringVRs.size(); i++) {
				 fmu.fmiGetStrings().put(request.stringVRs.get(i), request.strings.get(i));
				
			}
			fmu.fmiSetStrings( fmu.fmiGetStrings());
		}

	}
}
