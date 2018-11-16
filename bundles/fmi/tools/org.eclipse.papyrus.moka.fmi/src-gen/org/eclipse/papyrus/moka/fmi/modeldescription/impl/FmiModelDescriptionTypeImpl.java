/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.fmi.modeldescription.impl;

import java.util.Collection;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType;
import org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType;
import org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Annotation;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage;
import org.eclipse.papyrus.moka.fmi.modeldescription.LogCategoriesType;
import org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType;
import org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType;
import org.eclipse.papyrus.moka.fmi.modeldescription.ModelVariablesType;
import org.eclipse.papyrus.moka.fmi.modeldescription.TypeDefinitionsType;
import org.eclipse.papyrus.moka.fmi.modeldescription.UnitDefinitionsType;
import org.eclipse.papyrus.moka.fmi.modeldescription.VariableNamingConventionType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Description Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getModelExchange <em>Model Exchange</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getCoSimulation <em>Co Simulation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getUnitDefinitions <em>Unit Definitions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getTypeDefinitions <em>Type Definitions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getLogCategories <em>Log Categories</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getDefaultExperiment <em>Default Experiment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getVendorAnnotations <em>Vendor Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getModelVariables <em>Model Variables</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getModelStructure <em>Model Structure</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getCopyright <em>Copyright</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getFmiVersion <em>Fmi Version</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getGenerationDateAndTime <em>Generation Date And Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getGenerationTool <em>Generation Tool</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getGuid <em>Guid</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getLicense <em>License</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getModelName <em>Model Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getNumberOfEventIndicators <em>Number Of Event Indicators</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getVariableNamingConvention <em>Variable Naming Convention</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FmiModelDescriptionTypeImpl extends MinimalEObjectImpl.Container implements FmiModelDescriptionType {
	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

	/**
	 * The cached value of the '{@link #getUnitDefinitions() <em>Unit Definitions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitDefinitions()
	 * @generated
	 * @ordered
	 */
	protected UnitDefinitionsType unitDefinitions;

	/**
	 * The cached value of the '{@link #getTypeDefinitions() <em>Type Definitions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeDefinitions()
	 * @generated
	 * @ordered
	 */
	protected TypeDefinitionsType typeDefinitions;

	/**
	 * The cached value of the '{@link #getLogCategories() <em>Log Categories</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogCategories()
	 * @generated
	 * @ordered
	 */
	protected LogCategoriesType logCategories;

	/**
	 * The cached value of the '{@link #getDefaultExperiment() <em>Default Experiment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultExperiment()
	 * @generated
	 * @ordered
	 */
	protected DefaultExperimentType defaultExperiment;

	/**
	 * The cached value of the '{@link #getVendorAnnotations() <em>Vendor Annotations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVendorAnnotations()
	 * @generated
	 * @ordered
	 */
	protected Fmi2Annotation vendorAnnotations;

	/**
	 * The cached value of the '{@link #getModelVariables() <em>Model Variables</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelVariables()
	 * @generated
	 * @ordered
	 */
	protected ModelVariablesType modelVariables;

	/**
	 * The cached value of the '{@link #getModelStructure() <em>Model Structure</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelStructure()
	 * @generated
	 * @ordered
	 */
	protected ModelStructureType modelStructure;

	/**
	 * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected String author = AUTHOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getCopyright() <em>Copyright</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopyright()
	 * @generated
	 * @ordered
	 */
	protected static final String COPYRIGHT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCopyright() <em>Copyright</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopyright()
	 * @generated
	 * @ordered
	 */
	protected String copyright = COPYRIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getFmiVersion() <em>Fmi Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFmiVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String FMI_VERSION_EDEFAULT = "2.0";

	/**
	 * The cached value of the '{@link #getFmiVersion() <em>Fmi Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFmiVersion()
	 * @generated
	 * @ordered
	 */
	protected String fmiVersion = FMI_VERSION_EDEFAULT;

	/**
	 * This is true if the Fmi Version attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean fmiVersionESet;

	/**
	 * The default value of the '{@link #getGenerationDateAndTime() <em>Generation Date And Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerationDateAndTime()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar GENERATION_DATE_AND_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGenerationDateAndTime() <em>Generation Date And Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerationDateAndTime()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar generationDateAndTime = GENERATION_DATE_AND_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getGenerationTool() <em>Generation Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerationTool()
	 * @generated
	 * @ordered
	 */
	protected static final String GENERATION_TOOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGenerationTool() <em>Generation Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerationTool()
	 * @generated
	 * @ordered
	 */
	protected String generationTool = GENERATION_TOOL_EDEFAULT;

	/**
	 * The default value of the '{@link #getGuid() <em>Guid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuid()
	 * @generated
	 * @ordered
	 */
	protected static final String GUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGuid() <em>Guid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuid()
	 * @generated
	 * @ordered
	 */
	protected String guid = GUID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLicense() <em>License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected static final String LICENSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLicense() <em>License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected String license = LICENSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getModelName() <em>Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelName()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelName() <em>Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelName()
	 * @generated
	 * @ordered
	 */
	protected String modelName = MODEL_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberOfEventIndicators() <em>Number Of Event Indicators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfEventIndicators()
	 * @generated
	 * @ordered
	 */
	protected static final long NUMBER_OF_EVENT_INDICATORS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getNumberOfEventIndicators() <em>Number Of Event Indicators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfEventIndicators()
	 * @generated
	 * @ordered
	 */
	protected long numberOfEventIndicators = NUMBER_OF_EVENT_INDICATORS_EDEFAULT;

	/**
	 * This is true if the Number Of Event Indicators attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean numberOfEventIndicatorsESet;

	/**
	 * The default value of the '{@link #getVariableNamingConvention() <em>Variable Naming Convention</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableNamingConvention()
	 * @generated
	 * @ordered
	 */
	protected static final VariableNamingConventionType VARIABLE_NAMING_CONVENTION_EDEFAULT = VariableNamingConventionType.FLAT;

	/**
	 * The cached value of the '{@link #getVariableNamingConvention() <em>Variable Naming Convention</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableNamingConvention()
	 * @generated
	 * @ordered
	 */
	protected VariableNamingConventionType variableNamingConvention = VARIABLE_NAMING_CONVENTION_EDEFAULT;

	/**
	 * This is true if the Variable Naming Convention attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean variableNamingConventionESet;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FmiModelDescriptionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FmiPackage.Literals.FMI_MODEL_DESCRIPTION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModelExchangeType> getModelExchange() {
		return getGroup().list(FmiPackage.Literals.FMI_MODEL_DESCRIPTION_TYPE__MODEL_EXCHANGE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CoSimulationType> getCoSimulation() {
		return getGroup().list(FmiPackage.Literals.FMI_MODEL_DESCRIPTION_TYPE__CO_SIMULATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnitDefinitionsType getUnitDefinitions() {
		return unitDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDefinitions(UnitDefinitionsType newUnitDefinitions, NotificationChain msgs) {
		UnitDefinitionsType oldUnitDefinitions = unitDefinitions;
		unitDefinitions = newUnitDefinitions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__UNIT_DEFINITIONS, oldUnitDefinitions, newUnitDefinitions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUnitDefinitions(UnitDefinitionsType newUnitDefinitions) {
		if (newUnitDefinitions != unitDefinitions) {
			NotificationChain msgs = null;
			if (unitDefinitions != null)
				msgs = ((InternalEObject)unitDefinitions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__UNIT_DEFINITIONS, null, msgs);
			if (newUnitDefinitions != null)
				msgs = ((InternalEObject)newUnitDefinitions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__UNIT_DEFINITIONS, null, msgs);
			msgs = basicSetUnitDefinitions(newUnitDefinitions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__UNIT_DEFINITIONS, newUnitDefinitions, newUnitDefinitions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeDefinitionsType getTypeDefinitions() {
		return typeDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeDefinitions(TypeDefinitionsType newTypeDefinitions, NotificationChain msgs) {
		TypeDefinitionsType oldTypeDefinitions = typeDefinitions;
		typeDefinitions = newTypeDefinitions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__TYPE_DEFINITIONS, oldTypeDefinitions, newTypeDefinitions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTypeDefinitions(TypeDefinitionsType newTypeDefinitions) {
		if (newTypeDefinitions != typeDefinitions) {
			NotificationChain msgs = null;
			if (typeDefinitions != null)
				msgs = ((InternalEObject)typeDefinitions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__TYPE_DEFINITIONS, null, msgs);
			if (newTypeDefinitions != null)
				msgs = ((InternalEObject)newTypeDefinitions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__TYPE_DEFINITIONS, null, msgs);
			msgs = basicSetTypeDefinitions(newTypeDefinitions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__TYPE_DEFINITIONS, newTypeDefinitions, newTypeDefinitions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LogCategoriesType getLogCategories() {
		return logCategories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLogCategories(LogCategoriesType newLogCategories, NotificationChain msgs) {
		LogCategoriesType oldLogCategories = logCategories;
		logCategories = newLogCategories;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__LOG_CATEGORIES, oldLogCategories, newLogCategories);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLogCategories(LogCategoriesType newLogCategories) {
		if (newLogCategories != logCategories) {
			NotificationChain msgs = null;
			if (logCategories != null)
				msgs = ((InternalEObject)logCategories).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__LOG_CATEGORIES, null, msgs);
			if (newLogCategories != null)
				msgs = ((InternalEObject)newLogCategories).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__LOG_CATEGORIES, null, msgs);
			msgs = basicSetLogCategories(newLogCategories, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__LOG_CATEGORIES, newLogCategories, newLogCategories));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DefaultExperimentType getDefaultExperiment() {
		return defaultExperiment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultExperiment(DefaultExperimentType newDefaultExperiment, NotificationChain msgs) {
		DefaultExperimentType oldDefaultExperiment = defaultExperiment;
		defaultExperiment = newDefaultExperiment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__DEFAULT_EXPERIMENT, oldDefaultExperiment, newDefaultExperiment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefaultExperiment(DefaultExperimentType newDefaultExperiment) {
		if (newDefaultExperiment != defaultExperiment) {
			NotificationChain msgs = null;
			if (defaultExperiment != null)
				msgs = ((InternalEObject)defaultExperiment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__DEFAULT_EXPERIMENT, null, msgs);
			if (newDefaultExperiment != null)
				msgs = ((InternalEObject)newDefaultExperiment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__DEFAULT_EXPERIMENT, null, msgs);
			msgs = basicSetDefaultExperiment(newDefaultExperiment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__DEFAULT_EXPERIMENT, newDefaultExperiment, newDefaultExperiment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Fmi2Annotation getVendorAnnotations() {
		return vendorAnnotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVendorAnnotations(Fmi2Annotation newVendorAnnotations, NotificationChain msgs) {
		Fmi2Annotation oldVendorAnnotations = vendorAnnotations;
		vendorAnnotations = newVendorAnnotations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VENDOR_ANNOTATIONS, oldVendorAnnotations, newVendorAnnotations);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVendorAnnotations(Fmi2Annotation newVendorAnnotations) {
		if (newVendorAnnotations != vendorAnnotations) {
			NotificationChain msgs = null;
			if (vendorAnnotations != null)
				msgs = ((InternalEObject)vendorAnnotations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VENDOR_ANNOTATIONS, null, msgs);
			if (newVendorAnnotations != null)
				msgs = ((InternalEObject)newVendorAnnotations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VENDOR_ANNOTATIONS, null, msgs);
			msgs = basicSetVendorAnnotations(newVendorAnnotations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VENDOR_ANNOTATIONS, newVendorAnnotations, newVendorAnnotations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelVariablesType getModelVariables() {
		return modelVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelVariables(ModelVariablesType newModelVariables, NotificationChain msgs) {
		ModelVariablesType oldModelVariables = modelVariables;
		modelVariables = newModelVariables;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_VARIABLES, oldModelVariables, newModelVariables);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelVariables(ModelVariablesType newModelVariables) {
		if (newModelVariables != modelVariables) {
			NotificationChain msgs = null;
			if (modelVariables != null)
				msgs = ((InternalEObject)modelVariables).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_VARIABLES, null, msgs);
			if (newModelVariables != null)
				msgs = ((InternalEObject)newModelVariables).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_VARIABLES, null, msgs);
			msgs = basicSetModelVariables(newModelVariables, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_VARIABLES, newModelVariables, newModelVariables));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelStructureType getModelStructure() {
		return modelStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelStructure(ModelStructureType newModelStructure, NotificationChain msgs) {
		ModelStructureType oldModelStructure = modelStructure;
		modelStructure = newModelStructure;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_STRUCTURE, oldModelStructure, newModelStructure);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelStructure(ModelStructureType newModelStructure) {
		if (newModelStructure != modelStructure) {
			NotificationChain msgs = null;
			if (modelStructure != null)
				msgs = ((InternalEObject)modelStructure).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_STRUCTURE, null, msgs);
			if (newModelStructure != null)
				msgs = ((InternalEObject)newModelStructure).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_STRUCTURE, null, msgs);
			msgs = basicSetModelStructure(newModelStructure, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_STRUCTURE, newModelStructure, newModelStructure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__AUTHOR, oldAuthor, author));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCopyright() {
		return copyright;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCopyright(String newCopyright) {
		String oldCopyright = copyright;
		copyright = newCopyright;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__COPYRIGHT, oldCopyright, copyright));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFmiVersion() {
		return fmiVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFmiVersion(String newFmiVersion) {
		String oldFmiVersion = fmiVersion;
		fmiVersion = newFmiVersion;
		boolean oldFmiVersionESet = fmiVersionESet;
		fmiVersionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__FMI_VERSION, oldFmiVersion, fmiVersion, !oldFmiVersionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFmiVersion() {
		String oldFmiVersion = fmiVersion;
		boolean oldFmiVersionESet = fmiVersionESet;
		fmiVersion = FMI_VERSION_EDEFAULT;
		fmiVersionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__FMI_VERSION, oldFmiVersion, FMI_VERSION_EDEFAULT, oldFmiVersionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFmiVersion() {
		return fmiVersionESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XMLGregorianCalendar getGenerationDateAndTime() {
		return generationDateAndTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGenerationDateAndTime(XMLGregorianCalendar newGenerationDateAndTime) {
		XMLGregorianCalendar oldGenerationDateAndTime = generationDateAndTime;
		generationDateAndTime = newGenerationDateAndTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GENERATION_DATE_AND_TIME, oldGenerationDateAndTime, generationDateAndTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGenerationTool() {
		return generationTool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGenerationTool(String newGenerationTool) {
		String oldGenerationTool = generationTool;
		generationTool = newGenerationTool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GENERATION_TOOL, oldGenerationTool, generationTool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGuid() {
		return guid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGuid(String newGuid) {
		String oldGuid = guid;
		guid = newGuid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GUID, oldGuid, guid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLicense() {
		return license;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLicense(String newLicense) {
		String oldLicense = license;
		license = newLicense;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__LICENSE, oldLicense, license));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getModelName() {
		return modelName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelName(String newModelName) {
		String oldModelName = modelName;
		modelName = newModelName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_NAME, oldModelName, modelName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getNumberOfEventIndicators() {
		return numberOfEventIndicators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumberOfEventIndicators(long newNumberOfEventIndicators) {
		long oldNumberOfEventIndicators = numberOfEventIndicators;
		numberOfEventIndicators = newNumberOfEventIndicators;
		boolean oldNumberOfEventIndicatorsESet = numberOfEventIndicatorsESet;
		numberOfEventIndicatorsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__NUMBER_OF_EVENT_INDICATORS, oldNumberOfEventIndicators, numberOfEventIndicators, !oldNumberOfEventIndicatorsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetNumberOfEventIndicators() {
		long oldNumberOfEventIndicators = numberOfEventIndicators;
		boolean oldNumberOfEventIndicatorsESet = numberOfEventIndicatorsESet;
		numberOfEventIndicators = NUMBER_OF_EVENT_INDICATORS_EDEFAULT;
		numberOfEventIndicatorsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__NUMBER_OF_EVENT_INDICATORS, oldNumberOfEventIndicators, NUMBER_OF_EVENT_INDICATORS_EDEFAULT, oldNumberOfEventIndicatorsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetNumberOfEventIndicators() {
		return numberOfEventIndicatorsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableNamingConventionType getVariableNamingConvention() {
		return variableNamingConvention;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariableNamingConvention(VariableNamingConventionType newVariableNamingConvention) {
		VariableNamingConventionType oldVariableNamingConvention = variableNamingConvention;
		variableNamingConvention = newVariableNamingConvention == null ? VARIABLE_NAMING_CONVENTION_EDEFAULT : newVariableNamingConvention;
		boolean oldVariableNamingConventionESet = variableNamingConventionESet;
		variableNamingConventionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VARIABLE_NAMING_CONVENTION, oldVariableNamingConvention, variableNamingConvention, !oldVariableNamingConventionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetVariableNamingConvention() {
		VariableNamingConventionType oldVariableNamingConvention = variableNamingConvention;
		boolean oldVariableNamingConventionESet = variableNamingConventionESet;
		variableNamingConvention = VARIABLE_NAMING_CONVENTION_EDEFAULT;
		variableNamingConventionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VARIABLE_NAMING_CONVENTION, oldVariableNamingConvention, VARIABLE_NAMING_CONVENTION_EDEFAULT, oldVariableNamingConventionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetVariableNamingConvention() {
		return variableNamingConventionESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_EXCHANGE:
				return ((InternalEList<?>)getModelExchange()).basicRemove(otherEnd, msgs);
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__CO_SIMULATION:
				return ((InternalEList<?>)getCoSimulation()).basicRemove(otherEnd, msgs);
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__UNIT_DEFINITIONS:
				return basicSetUnitDefinitions(null, msgs);
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__TYPE_DEFINITIONS:
				return basicSetTypeDefinitions(null, msgs);
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__LOG_CATEGORIES:
				return basicSetLogCategories(null, msgs);
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__DEFAULT_EXPERIMENT:
				return basicSetDefaultExperiment(null, msgs);
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VENDOR_ANNOTATIONS:
				return basicSetVendorAnnotations(null, msgs);
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_VARIABLES:
				return basicSetModelVariables(null, msgs);
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_STRUCTURE:
				return basicSetModelStructure(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_EXCHANGE:
				return getModelExchange();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__CO_SIMULATION:
				return getCoSimulation();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__UNIT_DEFINITIONS:
				return getUnitDefinitions();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__TYPE_DEFINITIONS:
				return getTypeDefinitions();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__LOG_CATEGORIES:
				return getLogCategories();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__DEFAULT_EXPERIMENT:
				return getDefaultExperiment();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VENDOR_ANNOTATIONS:
				return getVendorAnnotations();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_VARIABLES:
				return getModelVariables();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_STRUCTURE:
				return getModelStructure();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__AUTHOR:
				return getAuthor();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__COPYRIGHT:
				return getCopyright();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__DESCRIPTION:
				return getDescription();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__FMI_VERSION:
				return getFmiVersion();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GENERATION_DATE_AND_TIME:
				return getGenerationDateAndTime();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GENERATION_TOOL:
				return getGenerationTool();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GUID:
				return getGuid();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__LICENSE:
				return getLicense();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_NAME:
				return getModelName();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__NUMBER_OF_EVENT_INDICATORS:
				return getNumberOfEventIndicators();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VARIABLE_NAMING_CONVENTION:
				return getVariableNamingConvention();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VERSION:
				return getVersion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_EXCHANGE:
				getModelExchange().clear();
				getModelExchange().addAll((Collection<? extends ModelExchangeType>)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__CO_SIMULATION:
				getCoSimulation().clear();
				getCoSimulation().addAll((Collection<? extends CoSimulationType>)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__UNIT_DEFINITIONS:
				setUnitDefinitions((UnitDefinitionsType)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__TYPE_DEFINITIONS:
				setTypeDefinitions((TypeDefinitionsType)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__LOG_CATEGORIES:
				setLogCategories((LogCategoriesType)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__DEFAULT_EXPERIMENT:
				setDefaultExperiment((DefaultExperimentType)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VENDOR_ANNOTATIONS:
				setVendorAnnotations((Fmi2Annotation)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_VARIABLES:
				setModelVariables((ModelVariablesType)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_STRUCTURE:
				setModelStructure((ModelStructureType)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__AUTHOR:
				setAuthor((String)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__COPYRIGHT:
				setCopyright((String)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__FMI_VERSION:
				setFmiVersion((String)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GENERATION_DATE_AND_TIME:
				setGenerationDateAndTime((XMLGregorianCalendar)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GENERATION_TOOL:
				setGenerationTool((String)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GUID:
				setGuid((String)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__LICENSE:
				setLicense((String)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_NAME:
				setModelName((String)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__NUMBER_OF_EVENT_INDICATORS:
				setNumberOfEventIndicators((Long)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VARIABLE_NAMING_CONVENTION:
				setVariableNamingConvention((VariableNamingConventionType)newValue);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VERSION:
				setVersion((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GROUP:
				getGroup().clear();
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_EXCHANGE:
				getModelExchange().clear();
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__CO_SIMULATION:
				getCoSimulation().clear();
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__UNIT_DEFINITIONS:
				setUnitDefinitions((UnitDefinitionsType)null);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__TYPE_DEFINITIONS:
				setTypeDefinitions((TypeDefinitionsType)null);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__LOG_CATEGORIES:
				setLogCategories((LogCategoriesType)null);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__DEFAULT_EXPERIMENT:
				setDefaultExperiment((DefaultExperimentType)null);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VENDOR_ANNOTATIONS:
				setVendorAnnotations((Fmi2Annotation)null);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_VARIABLES:
				setModelVariables((ModelVariablesType)null);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_STRUCTURE:
				setModelStructure((ModelStructureType)null);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__COPYRIGHT:
				setCopyright(COPYRIGHT_EDEFAULT);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__FMI_VERSION:
				unsetFmiVersion();
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GENERATION_DATE_AND_TIME:
				setGenerationDateAndTime(GENERATION_DATE_AND_TIME_EDEFAULT);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GENERATION_TOOL:
				setGenerationTool(GENERATION_TOOL_EDEFAULT);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GUID:
				setGuid(GUID_EDEFAULT);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__LICENSE:
				setLicense(LICENSE_EDEFAULT);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_NAME:
				setModelName(MODEL_NAME_EDEFAULT);
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__NUMBER_OF_EVENT_INDICATORS:
				unsetNumberOfEventIndicators();
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VARIABLE_NAMING_CONVENTION:
				unsetVariableNamingConvention();
				return;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GROUP:
				return group != null && !group.isEmpty();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_EXCHANGE:
				return !getModelExchange().isEmpty();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__CO_SIMULATION:
				return !getCoSimulation().isEmpty();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__UNIT_DEFINITIONS:
				return unitDefinitions != null;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__TYPE_DEFINITIONS:
				return typeDefinitions != null;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__LOG_CATEGORIES:
				return logCategories != null;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__DEFAULT_EXPERIMENT:
				return defaultExperiment != null;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VENDOR_ANNOTATIONS:
				return vendorAnnotations != null;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_VARIABLES:
				return modelVariables != null;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_STRUCTURE:
				return modelStructure != null;
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__COPYRIGHT:
				return COPYRIGHT_EDEFAULT == null ? copyright != null : !COPYRIGHT_EDEFAULT.equals(copyright);
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__FMI_VERSION:
				return isSetFmiVersion();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GENERATION_DATE_AND_TIME:
				return GENERATION_DATE_AND_TIME_EDEFAULT == null ? generationDateAndTime != null : !GENERATION_DATE_AND_TIME_EDEFAULT.equals(generationDateAndTime);
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GENERATION_TOOL:
				return GENERATION_TOOL_EDEFAULT == null ? generationTool != null : !GENERATION_TOOL_EDEFAULT.equals(generationTool);
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__GUID:
				return GUID_EDEFAULT == null ? guid != null : !GUID_EDEFAULT.equals(guid);
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__LICENSE:
				return LICENSE_EDEFAULT == null ? license != null : !LICENSE_EDEFAULT.equals(license);
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__MODEL_NAME:
				return MODEL_NAME_EDEFAULT == null ? modelName != null : !MODEL_NAME_EDEFAULT.equals(modelName);
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__NUMBER_OF_EVENT_INDICATORS:
				return isSetNumberOfEventIndicators();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VARIABLE_NAMING_CONVENTION:
				return isSetVariableNamingConvention();
			case FmiPackage.FMI_MODEL_DESCRIPTION_TYPE__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (group: ");
		result.append(group);
		result.append(", author: ");
		result.append(author);
		result.append(", copyright: ");
		result.append(copyright);
		result.append(", description: ");
		result.append(description);
		result.append(", fmiVersion: ");
		if (fmiVersionESet) result.append(fmiVersion); else result.append("<unset>");
		result.append(", generationDateAndTime: ");
		result.append(generationDateAndTime);
		result.append(", generationTool: ");
		result.append(generationTool);
		result.append(", guid: ");
		result.append(guid);
		result.append(", license: ");
		result.append(license);
		result.append(", modelName: ");
		result.append(modelName);
		result.append(", numberOfEventIndicators: ");
		if (numberOfEventIndicatorsESet) result.append(numberOfEventIndicators); else result.append("<unset>");
		result.append(", variableNamingConvention: ");
		if (variableNamingConventionESet) result.append(variableNamingConvention); else result.append("<unset>");
		result.append(", version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //FmiModelDescriptionTypeImpl
