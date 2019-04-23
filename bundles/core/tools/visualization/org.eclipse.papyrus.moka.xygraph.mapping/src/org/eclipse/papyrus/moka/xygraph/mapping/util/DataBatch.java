/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  David LOPEZ BETANCUR (CEA LIST)
 *  Sebastien REVOL (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.xygraph.mapping.util;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will hold a raw set of values from a variable.
 *  
 *
 */
public class DataBatch {
	
	private List<Double> values;
	
	private DataBatch(int size){
		values = new ArrayList<>(size);
	}
	
	public static DataBatch fromDouble(List<Double> values){
		DataBatch batch = new DataBatch(values.size());
		batch.values.addAll(values);
		return batch;
	}
	
	public static DataBatch fromBoolean(List<Boolean> values){
		
		DataBatch batch = new DataBatch(values.size());
		
		for(int i = 0; i < values.size(); i++)
			batch.values.add(values.get(i) ? 1.0 : 0.0);
		
		return batch;
	}
	
	public static DataBatch fromInteger(List<Integer> values){
		
		DataBatch batch = new DataBatch(values.size());
		
		//TODO This is insanely slow !
		for(int i = 0; i < values.size(); i++)
			batch.values.add((double)values.get(i));
		
		return batch;
	}
	
	public static DataBatch dummy(){
		DataBatch batch = new DataBatch(1);
		return batch;
	}
	
	public List<Double> getValues(){
		return values;
	}
	
	public int size(){
		return values.size();
	}
	
	public void addValue(double value){
		values.add(value);
	}
	
	public void clean(){
		values.clear();
	}
}
	
