package org.eclipse.papyrus.moka.fmi.fmi2uml;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.moka.fmi.fmiprofile.CS_FMU;
import org.eclipse.papyrus.moka.fmi.modeldescription.CausalityType;
import org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType;
import org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType;
import org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType;
import org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1;
import org.eclipse.papyrus.moka.fmi.profile.util.FMIProfileUtil;
import org.eclipse.papyrus.moka.fmi.util.FMIUtil;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLUtil;

public class FMU2UMLTransformation {

	public static final String PRIMITIVE_TYPE_URI = "pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml";
	public static final String REAL_NAME = "Real";
	public static final String BOOLEAN_NAME = "Boolean";
	public static final String INTEGER_NAME = "Integer";
	public static final String STRING_NAME = "String";


	Package receivingPackage;
	FmiModelDescriptionType modelDescription;
	Package dependencyPackage;
	Class fmuClass ;
	public FMU2UMLTransformation(FmiModelDescriptionType modelDescription, Package receivingPackage) {
		this.receivingPackage = receivingPackage;
		this.modelDescription  = modelDescription;

	}

	public Class transform(){

		if (receivingPackage != null && modelDescription != null){
			if (! modelDescription.getCoSimulation().isEmpty()) {
				CoSimulationType cosim =modelDescription.getCoSimulation().get(0);

				FMIProfileUtil.applyFMIProfileIfNeeded(receivingPackage);
				fmuClass = receivingPackage.createOwnedClass(cosim.getModelIdentifier(), false);
				dependencyPackage = receivingPackage.createNestedPackage(cosim.getModelIdentifier()+FMI2UML.DEPENDENCIES_PACKAGE_SUFFIX);

				CS_FMU csFMU = (CS_FMU) fmuClass.applyStereotype(FMIProfileUtil.getStereotype(receivingPackage, FMIProfileUtil.CS_FMU_STEREO_NAME));

				csFMU.setModelDescription(modelDescription);

				if (modelDescription.getModelVariables() != null){
					for (Fmi2ScalarVariable variable : modelDescription.getModelVariables().getScalarVariable()){
						createProperty(variable);
					}
				}
				if (modelDescription.getModelStructure() != null){
					if (modelDescription.getModelStructure().getDerivatives() != null){
						for (UnknownType1 unknown :modelDescription.getModelStructure().getDerivatives().getUnknown() ){
							createDerivativeDependency(unknown);
						}
					}
					if (modelDescription.getModelStructure().getInitialUnknowns() != null){
						for (UnknownType unknown :modelDescription.getModelStructure().getInitialUnknowns().getUnknown() ){
							createInitialUnknwonDependency(unknown);
						}
					}
					if (modelDescription.getModelStructure().getOutputs() != null){
						for (UnknownType1 unknown :modelDescription.getModelStructure().getOutputs().getUnknown() ){
							createOutputsDependency(unknown);
						}
					}

				}


			}
		}
		return fmuClass;
	}




	private void createOutputsDependency(UnknownType1 unknown) {
		Stereotype outputDepStereo = FMIProfileUtil.getStereotype(receivingPackage, FMIProfileUtil.OUTPUT_DEPENDENCY_STEREO_NAME);
		createDependency(unknown.getIndex(), unknown.getDependencies(), outputDepStereo);	
	}

	private void createInitialUnknwonDependency(UnknownType unknown) {
		Stereotype initialUnknownDepStereo = FMIProfileUtil.getStereotype(receivingPackage, FMIProfileUtil.INITIAL_UNKNWOWN_STEREO_NAME);
		createDependency(unknown.getIndex(), unknown.getDependencies(), initialUnknownDepStereo);		
	}

	private void createDerivativeDependency(UnknownType1 unknown) {
		Stereotype derivativeDepStereo = FMIProfileUtil.getStereotype(receivingPackage, FMIProfileUtil.DERIVATIVE_DEPENDENCY_STEREO_NAME);
		createDependency(unknown.getIndex(), unknown.getDependencies(), derivativeDepStereo);
	}

	private void createDependency(long clientIndex, List<Long> suppliersIndexes, Stereotype setereoToApply) {

		if (clientIndex< fmuClass.getOwnedAttributes().size() && suppliersIndexes != null){
			Property client = fmuClass.getOwnedAttributes().get(getInt(clientIndex));
			List<NamedElement> suppliers = new ArrayList<NamedElement>();
			if (client != null){
				for (long dep : suppliersIndexes){
					if (dep <fmuClass.getOwnedAttributes().size() ){
						suppliers.add(fmuClass.getOwnedAttributes().get(getInt(dep)));
					}
				}
				if (!suppliers.isEmpty()){
					Dependency dependency = UMLFactory.eINSTANCE.createDependency();
					dependencyPackage.getPackagedElements().add(dependency);
					dependency.applyStereotype(setereoToApply);
					dependency.getClients().add(client);
					dependency.getSuppliers().addAll(suppliers);
				}
			}
		}

	}

	private int getInt(long longValue){
		return new Long(longValue).intValue();
	}

	private void createProperty(Fmi2ScalarVariable variable) {
		Type propType = getUMLType(variable);
		Property prop;
		if (FMIUtil.isPort(variable)){
			prop=fmuClass.createOwnedPort(variable.getName(), propType);
			prop.setUpper(1);
			prop.setLower(1);
		}else {
			prop=fmuClass.createOwnedAttribute(variable.getName(), propType, 1, 1);
		}
		prop.setAggregation(AggregationKind.COMPOSITE_LITERAL);
		setDefaultValue(prop, variable);
		Stereotype stereo = getPropertyStereotype(variable.getCausality());
		if (stereo != null){
			prop.applyStereotype(stereo);
		
		}


	}

	private Stereotype getPropertyStereotype(CausalityType causality) {
		switch (causality){
		case CALCULATED_PARAMETER :
			return FMIProfileUtil.getStereotype(receivingPackage, FMIProfileUtil.CALCULATED_PARAMETER_STEREO_NAME);
		case INDEPENDENT:
			return FMIProfileUtil.getStereotype(receivingPackage, FMIProfileUtil.INDEPENDENT_STEREO_NAME);
		case INPUT:
			return FMIProfileUtil.getStereotype(receivingPackage, FMIProfileUtil.PORT_STEREO_NAME);
		case OUTPUT:
			return FMIProfileUtil.getStereotype(receivingPackage, FMIProfileUtil.PORT_STEREO_NAME);
		case LOCAL:
			return FMIProfileUtil.getStereotype(receivingPackage, FMIProfileUtil.LOCAL_STEREO_NAME);

		case PARAMETER:
			return FMIProfileUtil.getStereotype(receivingPackage, FMIProfileUtil.PARAMETER_STEREO_NAME);
		default:
			break;
		}
		return null;
	}

	private void setDefaultValue(Property prop, Fmi2ScalarVariable variable) {
		ValueSpecification valSpec = null;
		if (variable.getReal() != null){
			if (variable.getReal().isSetStart()){
				valSpec = UMLFactory.eINSTANCE.createLiteralReal();
				((LiteralReal)valSpec).setValue(variable.getReal().getStart());
			}
		}else if (variable.getBoolean() != null){
			if (variable.getBoolean().isSetStart()){
				valSpec = UMLFactory.eINSTANCE.createLiteralBoolean();
				((LiteralBoolean)valSpec).setValue(variable.getBoolean().isStart());
			}
		}else if (variable.getInteger() != null){
			if (variable.getInteger().isSetStart()){
				valSpec = UMLFactory.eINSTANCE.createLiteralInteger();
				((LiteralInteger)valSpec).setValue(variable.getInteger().getStart());
			}
		}else if (variable.getString() != null){
			if (variable.getString().getStart()!= null){
				valSpec = UMLFactory.eINSTANCE.createLiteralString();
				((LiteralString)valSpec).setValue(variable.getString().getStart());
			}
		}else if (variable.getEnumeration() != null){
			//TODO should be better handled
			if (variable.getEnumeration().isSetStart()){
				valSpec = UMLFactory.eINSTANCE.createLiteralString();
				((LiteralString)valSpec).setValue(Integer.toString(variable.getEnumeration().getStart()));
			}
		}
		if (valSpec != null){
			prop.setDefaultValue(valSpec);
		}

	}

	private Type getUMLType(Fmi2ScalarVariable variable) {
		if (variable.getReal() != null){
			return getUMLPrimitiveType(REAL_NAME);
		}else if (variable.getBoolean() != null){
			return getUMLPrimitiveType(BOOLEAN_NAME);
		}else if (variable.getInteger() != null){
			return getUMLPrimitiveType(INTEGER_NAME);
		}else {
			//TODO Enumeration should be handled
			return getUMLPrimitiveType(STRING_NAME);
		}

	}


	private  PrimitiveType getUMLPrimitiveType( String typeName){
		ResourceSet resSet = UMLUtil.getResourceSet(receivingPackage);
		if (resSet == null){
			resSet = new ResourceSetImpl();
		}
		return (PrimitiveType) resSet.getEObject(URI.createURI(PRIMITIVE_TYPE_URI).appendFragment(typeName), true);
	}
}
