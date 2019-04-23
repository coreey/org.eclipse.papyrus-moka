/*****************************************************************************
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
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmi.master.masterlibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Object;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Object;
import org.eclipse.papyrus.moka.fmi.master.fmilibrary.Fmi2Parameters;
import org.eclipse.papyrus.moka.fmi.master.fmilibrary.Fmi2Port;
import org.eclipse.papyrus.moka.fmi.master.fmilibrary.Fmi2ScalarVariable;
import org.eclipse.papyrus.moka.fmi.master.fmuproxy.Fmu2ProxyService;
import org.eclipse.papyrus.moka.fmi.profile.util.FMIProfileUtil;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.sysml14.portsandflows.FlowDirection;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StructuredClassifier;

public class CoSimEnvironment {

	private ICS_Object container = new CS_Object();
	private ArrayList<Fmu2ProxyService> fmus = new ArrayList<Fmu2ProxyService>();
	private ArrayList<Connector> connectors = new ArrayList<Connector>();
	private ArrayList<Dependency> ioDependencies = new ArrayList<Dependency>();
	private List<Fmi2Port> inputPorts= new ArrayList<Fmi2Port>();



	public CoSimEnvironment(List<IExtensionalValue> locus) {

		ArrayList<Fmu2ProxyService> fmusToAdd = new ArrayList<Fmu2ProxyService>();
		for (IExtensionalValue e : locus) {

			for (Classifier type : e.getTypes()) {

				if (type.getAppliedStereotype(FMIProfileUtil.CS_GRAPH_STEREO_QUALIFIED_NAME) != null) {
					this.container = ((CS_Object) e);
					for (Connector con : ((CS_Object) e).types.get(0).getOwnedConnectors()) {
						this.connectors.add(con);
					}
					break;
				}
				if (type.getAppliedStereotype(FMIProfileUtil.CS_FMU_STEREO_QUALIFIED_NAME) != null) {
					Fmi2Parameters parameters = new Fmi2Parameters(type, type.getAppliedStereotype(FMIProfileUtil.CS_FMU_STEREO_QUALIFIED_NAME));
					((Fmu2ProxyService) e).setParameters(parameters);
					fmusToAdd.add((Fmu2ProxyService) e);
					break;
				}

			}

		}

		this.fmus.addAll(fmusToAdd);
		this.setupIoDependencies();
	}

	protected boolean isPartOrReference(IFeatureValue featureValue) {
		return featureValue != null && featureValue.getFeature() != null && featureValue.getFeature() instanceof Property && featureValue.getFeature().getType() instanceof StructuredClassifier;
	}


	
	public void setupPortMapping() {
		Boolean sourceFound = false, targetFound = false;
		
		if (this.connectors.size() > 0) {
			for (Connector c : this.connectors) {
				Port sourcePort = null;
				Port targetPort = null;
				sourcePort = (Port) c.getEnds().get(0).getRole();
				Stereotype st = sourcePort.getAppliedStereotype(FMIProfileUtil.PORT_STEREO_QUALIFIED_NAME);
				if (st != null) {
					org.eclipse.papyrus.moka.fmi.fmiprofile.Port fmiPort = (org.eclipse.papyrus.moka.fmi.fmiprofile.Port) sourcePort.getStereotypeApplication(st);
					if (fmiPort.getDirection() == FlowDirection.OUT) {
						targetPort = (Port) c.getEnds().get(1).getRole();
					} else {
						sourcePort = (Port) c.getEnds().get(1).getRole();
						targetPort = (Port) c.getEnds().get(0).getRole();
					}
				}
				String sourceFmuName = sourcePort.getFeaturingClassifiers().get(0).getName();
				String targetFmuName = targetPort.getFeaturingClassifiers().get(0).getName();
				Fmu2ProxyService sourceFmu = null, targetFmu = null;
				for (Fmu2ProxyService f : this.fmus) {
					if (f.types.get(0).getName().equals(sourceFmuName)) {
						sourceFmu = f;
						sourceFound = true;
					}
					if (f.types.get(0).getName().equals(targetFmuName)) {
						targetFmu = f;
						targetFound = true;
					}
					if (sourceFound && targetFound)
						continue;
				}
				
				Fmi2Port target = findPort(targetFmu, targetPort);
				
						
				Fmi2Port source = findPort(sourceFmu, sourcePort);
				
				target.setDrivingPort(source);
				inputPorts.add(target);
			
				
			}
		}
		
	}

	private Fmi2Port findPort(Fmu2ProxyService targetFmu, Port targetPort) {
		for (Fmi2ScalarVariable variable : targetFmu.variables){
			if (variable instanceof Fmi2Port){
				Fmi2Port fmiPort = (Fmi2Port) variable;
				if (fmiPort.getPort() == targetPort){
					return fmiPort;
				}
			}
		}
		return null;
	}

	/**
	 * Retrieve dependencies from Papyrus package import.
	 * For each fmu, the dependencies are retrieved from the corresponding package import given the fmu name
	 * Dependencies we are interested in are those annotated with <<outputDependency>> stereotype
	 **/
	public void setupIoDependencies() {
		Model nameSpace = (Model) this.container.getTypes().get(0).getNamespace();
		EList<PackageImport> imports = nameSpace.getPackageImports();
		boolean packageFound = false;
		for (Fmu2ProxyService fmu : this.fmus) {
			Class fmuClass = (Class) fmu.getTypes().get(0);
			
			for (Property fmuProp : fmuClass.getOwnedAttributes()){
				for (Dependency dep : fmuProp.getClientDependencies()){
					if (dep.getAppliedStereotype(FMIProfileUtil.OUTPUT_DEPENDENCY_STEREO_QUALIFIED_NAME) != null) {
						this.ioDependencies.add(dep);
					}
				}
			}
			
		}
	}


	public ICS_Object getContainer() {
		return container;
	}

	public void setContainer(ICS_Object container) {
		this.container = container;
	}

	public ArrayList<Fmu2ProxyService> getFmus() {
		return fmus;
	}

	public void setFmus(ArrayList<Fmu2ProxyService> fmus) {
		this.fmus = fmus;
	}

	public ArrayList<Connector> getConnectors() {
		return connectors;
	}

	public void setConnectors(ArrayList<Connector> connectors) {
		this.connectors = connectors;
	}

	public ArrayList<Dependency> getIoDependencies() {
		return ioDependencies;
	}


	public void setIoDependencies(ArrayList<Dependency> ioDependencies) {
		this.ioDependencies = ioDependencies;
	}

	public List<Fmi2Port> getInputPorts() {
		
		return inputPorts;
	}




}
