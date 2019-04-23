/*****************************************************************************
 * Copyright (c) 2015 CEA
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
 *  Francois Le Fevre  francois.le-fevre@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.components.tools.norm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;

import org.eclipse.emf.ecore.util.EcoreUtil;

public class RequirementGenerator {

	public static String OLD_IDS_NORM_FILE="src/main/resources/input/requirements.reqid.reqTextPage.reqXmiID.packageelementXmiID.beta.tsv";
	public static String WEBSITE_NORM_URL="https://hudson.eclipse.org/papyrus/view/Components/job/papyrus-sysml-website/ws/site-staging/org.eclipse.papyrus.sysml.core/norm/formal-15-06-03.pdf";
	
	public static void main(String[] args) {
		HashMap<String,String> reqID2PackageElementXmiID = new HashMap<String,String>();
		HashMap<String,String> reqID2RequirementXmiID = new HashMap<String,String>();

		Date d = new Date();
		String outputfolder= new String("src/main/resources/"+d.getTime()+"/");
		File theFile = new File(outputfolder);
	    theFile.mkdirs();
	    
		try {
			FileInputStream fisReqOldNorm = new FileInputStream(OLD_IDS_NORM_FILE);

			BufferedReader brReqOldNorm = new BufferedReader(new InputStreamReader(fisReqOldNorm));

			
			String lineOld = null;
			String reqId,reqXmiId,packageElementXmiId;
			while ((lineOld = brReqOldNorm.readLine()) != null) {
				reqId=lineOld.split("\t")[0];
				reqXmiId=lineOld.split("\t")[2];
				packageElementXmiId=lineOld.split("\t")[3];
				reqID2PackageElementXmiID.put(reqId, packageElementXmiId);
				reqID2RequirementXmiID.put(reqId, reqXmiId);
			}

			brReqOldNorm.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			FileInputStream fisReqNewNorm = new FileInputStream("src/main/resources/input/omg.sysml14.req.tsv");
			BufferedReader brReqNewNorm = new BufferedReader(new InputStreamReader(fisReqNewNorm));

			File autoreq_tsv=new File(outputfolder+"requirements.reqid.reqTextPage.reqXmiID.packageelementXmiID.tsv");
			BufferedWriter writerReqFullTsv = new BufferedWriter(new FileWriter(autoreq_tsv));
			
			File autoreq_packageElement=new File(outputfolder+"autoreq_packageElement.new.properties");
			File autoreq_req=new File(outputfolder+"autoreq_requirement.new.properties");
			BufferedWriter writerPac = new BufferedWriter(new FileWriter(autoreq_packageElement));
			BufferedWriter writerReq = new BufferedWriter(new FileWriter(autoreq_req));


			String line = null;
			String packageElementXmiID,requirementXmiID;
			String reqId, reqText;
			String page;
			String packageElementName;
			while ((line = brReqNewNorm.readLine()) != null) {
				System.out.println(line);
				reqId = line.split("\t")[0];
				reqText = line.split("\t")[1].split("\\[")[0];
				page = line.split("\\[")[1].replace("]", "");
				packageElementName=line.split("\\[")[0];
				
				packageElementXmiID = reqID2PackageElementXmiID.get(reqId);
				if(packageElementXmiID==null){
					packageElementXmiID = EcoreUtil.generateUUID();
				}
				
				
				requirementXmiID = reqID2RequirementXmiID.get(reqId);
				if(requirementXmiID==null){
					requirementXmiID = EcoreUtil.generateUUID();
				}
				
				//Backup the full ids: reqId text[page] packageElementXmiID requirementXmiID
				writerReqFullTsv.write(line+"\t"+requirementXmiID+"\t"+packageElementXmiID+"\n");
				
				//Generate the PackageElement Part
				writerPac.write ("<packagedElement xmi:type=\"uml:Class\" xmi:id=\""+packageElementXmiID+"\" name=\""+packageElementName+"\"/>\n");
				
				//Generate the Requirement Part
				writerReq.write ("<Requirements:Requirement xmi:id=\""+requirementXmiID+"\" text=\""+reqText+" details here "+WEBSITE_NORM_URL+"#page="+page+"\" id=\""+reqId+"\" base_Class=\""+packageElementXmiID+"\"/>\n");
			}

			//Close writer
			writerReqFullTsv.close();
			writerPac.close();
			writerReq.close();


			brReqNewNorm.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}