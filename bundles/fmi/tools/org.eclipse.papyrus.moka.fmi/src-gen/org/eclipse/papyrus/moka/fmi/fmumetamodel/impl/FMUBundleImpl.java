/**
 * Copyright (c) 2019 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.fmi.fmumetamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.moka.fmi.fmumetamodel.AbstractFile;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage;

import org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FMU Bundle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FMUBundleImpl#getModelDescription <em>Model Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FMUBundleImpl#getResourcesFiles <em>Resources Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FMUBundleImpl#getWin32Files <em>Win32 Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FMUBundleImpl#getWin64Files <em>Win64 Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FMUBundleImpl#getLinux32Files <em>Linux32 Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FMUBundleImpl#getLinux64Files <em>Linux64 Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FMUBundleImpl#getDarwin64Files <em>Darwin64 Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FMUBundleImpl#getDarwin32Files <em>Darwin32 Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FMUBundleImpl#getDocumentationFiles <em>Documentation Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FMUBundleImpl#getSourceFiles <em>Source Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FMUBundleImpl#getRootFiles <em>Root Files</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FMUBundleImpl extends MinimalEObjectImpl.Container implements FMUBundle {
	/**
	 * The cached value of the '{@link #getModelDescription() <em>Model Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelDescription()
	 * @generated
	 * @ordered
	 */
	protected FmiModelDescriptionType modelDescription;

	/**
	 * The cached value of the '{@link #getResourcesFiles() <em>Resources Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourcesFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFile> resourcesFiles;

	/**
	 * The cached value of the '{@link #getWin32Files() <em>Win32 Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWin32Files()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFile> win32Files;

	/**
	 * The cached value of the '{@link #getWin64Files() <em>Win64 Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWin64Files()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFile> win64Files;

	/**
	 * The cached value of the '{@link #getLinux32Files() <em>Linux32 Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinux32Files()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFile> linux32Files;

	/**
	 * The cached value of the '{@link #getLinux64Files() <em>Linux64 Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinux64Files()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFile> linux64Files;

	/**
	 * The cached value of the '{@link #getDarwin64Files() <em>Darwin64 Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDarwin64Files()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFile> darwin64Files;

	/**
	 * The cached value of the '{@link #getDarwin32Files() <em>Darwin32 Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDarwin32Files()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFile> darwin32Files;

	/**
	 * The cached value of the '{@link #getDocumentationFiles() <em>Documentation Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentationFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFile> documentationFiles;

	/**
	 * The cached value of the '{@link #getSourceFiles() <em>Source Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFile> sourceFiles;

	/**
	 * The cached value of the '{@link #getRootFiles() <em>Root Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFile> rootFiles;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FMUBundleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FmumetamodelPackage.Literals.FMU_BUNDLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FmiModelDescriptionType getModelDescription() {
		return modelDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelDescription(FmiModelDescriptionType newModelDescription, NotificationChain msgs) {
		FmiModelDescriptionType oldModelDescription = modelDescription;
		modelDescription = newModelDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FmumetamodelPackage.FMU_BUNDLE__MODEL_DESCRIPTION, oldModelDescription, newModelDescription);
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
	public void setModelDescription(FmiModelDescriptionType newModelDescription) {
		if (newModelDescription != modelDescription) {
			NotificationChain msgs = null;
			if (modelDescription != null)
				msgs = ((InternalEObject)modelDescription).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FmumetamodelPackage.FMU_BUNDLE__MODEL_DESCRIPTION, null, msgs);
			if (newModelDescription != null)
				msgs = ((InternalEObject)newModelDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FmumetamodelPackage.FMU_BUNDLE__MODEL_DESCRIPTION, null, msgs);
			msgs = basicSetModelDescription(newModelDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmumetamodelPackage.FMU_BUNDLE__MODEL_DESCRIPTION, newModelDescription, newModelDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractFile> getResourcesFiles() {
		if (resourcesFiles == null) {
			resourcesFiles = new EObjectContainmentEList<AbstractFile>(AbstractFile.class, this, FmumetamodelPackage.FMU_BUNDLE__RESOURCES_FILES);
		}
		return resourcesFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractFile> getWin32Files() {
		if (win32Files == null) {
			win32Files = new EObjectContainmentEList<AbstractFile>(AbstractFile.class, this, FmumetamodelPackage.FMU_BUNDLE__WIN32_FILES);
		}
		return win32Files;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractFile> getWin64Files() {
		if (win64Files == null) {
			win64Files = new EObjectContainmentEList<AbstractFile>(AbstractFile.class, this, FmumetamodelPackage.FMU_BUNDLE__WIN64_FILES);
		}
		return win64Files;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractFile> getLinux32Files() {
		if (linux32Files == null) {
			linux32Files = new EObjectContainmentEList<AbstractFile>(AbstractFile.class, this, FmumetamodelPackage.FMU_BUNDLE__LINUX32_FILES);
		}
		return linux32Files;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractFile> getLinux64Files() {
		if (linux64Files == null) {
			linux64Files = new EObjectContainmentEList<AbstractFile>(AbstractFile.class, this, FmumetamodelPackage.FMU_BUNDLE__LINUX64_FILES);
		}
		return linux64Files;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractFile> getDarwin64Files() {
		if (darwin64Files == null) {
			darwin64Files = new EObjectContainmentEList<AbstractFile>(AbstractFile.class, this, FmumetamodelPackage.FMU_BUNDLE__DARWIN64_FILES);
		}
		return darwin64Files;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractFile> getDarwin32Files() {
		if (darwin32Files == null) {
			darwin32Files = new EObjectContainmentEList<AbstractFile>(AbstractFile.class, this, FmumetamodelPackage.FMU_BUNDLE__DARWIN32_FILES);
		}
		return darwin32Files;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractFile> getDocumentationFiles() {
		if (documentationFiles == null) {
			documentationFiles = new EObjectContainmentEList<AbstractFile>(AbstractFile.class, this, FmumetamodelPackage.FMU_BUNDLE__DOCUMENTATION_FILES);
		}
		return documentationFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractFile> getSourceFiles() {
		if (sourceFiles == null) {
			sourceFiles = new EObjectContainmentEList<AbstractFile>(AbstractFile.class, this, FmumetamodelPackage.FMU_BUNDLE__SOURCE_FILES);
		}
		return sourceFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractFile> getRootFiles() {
		if (rootFiles == null) {
			rootFiles = new EObjectContainmentEList<AbstractFile>(AbstractFile.class, this, FmumetamodelPackage.FMU_BUNDLE__ROOT_FILES);
		}
		return rootFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FmumetamodelPackage.FMU_BUNDLE__MODEL_DESCRIPTION:
				return basicSetModelDescription(null, msgs);
			case FmumetamodelPackage.FMU_BUNDLE__RESOURCES_FILES:
				return ((InternalEList<?>)getResourcesFiles()).basicRemove(otherEnd, msgs);
			case FmumetamodelPackage.FMU_BUNDLE__WIN32_FILES:
				return ((InternalEList<?>)getWin32Files()).basicRemove(otherEnd, msgs);
			case FmumetamodelPackage.FMU_BUNDLE__WIN64_FILES:
				return ((InternalEList<?>)getWin64Files()).basicRemove(otherEnd, msgs);
			case FmumetamodelPackage.FMU_BUNDLE__LINUX32_FILES:
				return ((InternalEList<?>)getLinux32Files()).basicRemove(otherEnd, msgs);
			case FmumetamodelPackage.FMU_BUNDLE__LINUX64_FILES:
				return ((InternalEList<?>)getLinux64Files()).basicRemove(otherEnd, msgs);
			case FmumetamodelPackage.FMU_BUNDLE__DARWIN64_FILES:
				return ((InternalEList<?>)getDarwin64Files()).basicRemove(otherEnd, msgs);
			case FmumetamodelPackage.FMU_BUNDLE__DARWIN32_FILES:
				return ((InternalEList<?>)getDarwin32Files()).basicRemove(otherEnd, msgs);
			case FmumetamodelPackage.FMU_BUNDLE__DOCUMENTATION_FILES:
				return ((InternalEList<?>)getDocumentationFiles()).basicRemove(otherEnd, msgs);
			case FmumetamodelPackage.FMU_BUNDLE__SOURCE_FILES:
				return ((InternalEList<?>)getSourceFiles()).basicRemove(otherEnd, msgs);
			case FmumetamodelPackage.FMU_BUNDLE__ROOT_FILES:
				return ((InternalEList<?>)getRootFiles()).basicRemove(otherEnd, msgs);
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
			case FmumetamodelPackage.FMU_BUNDLE__MODEL_DESCRIPTION:
				return getModelDescription();
			case FmumetamodelPackage.FMU_BUNDLE__RESOURCES_FILES:
				return getResourcesFiles();
			case FmumetamodelPackage.FMU_BUNDLE__WIN32_FILES:
				return getWin32Files();
			case FmumetamodelPackage.FMU_BUNDLE__WIN64_FILES:
				return getWin64Files();
			case FmumetamodelPackage.FMU_BUNDLE__LINUX32_FILES:
				return getLinux32Files();
			case FmumetamodelPackage.FMU_BUNDLE__LINUX64_FILES:
				return getLinux64Files();
			case FmumetamodelPackage.FMU_BUNDLE__DARWIN64_FILES:
				return getDarwin64Files();
			case FmumetamodelPackage.FMU_BUNDLE__DARWIN32_FILES:
				return getDarwin32Files();
			case FmumetamodelPackage.FMU_BUNDLE__DOCUMENTATION_FILES:
				return getDocumentationFiles();
			case FmumetamodelPackage.FMU_BUNDLE__SOURCE_FILES:
				return getSourceFiles();
			case FmumetamodelPackage.FMU_BUNDLE__ROOT_FILES:
				return getRootFiles();
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
			case FmumetamodelPackage.FMU_BUNDLE__MODEL_DESCRIPTION:
				setModelDescription((FmiModelDescriptionType)newValue);
				return;
			case FmumetamodelPackage.FMU_BUNDLE__RESOURCES_FILES:
				getResourcesFiles().clear();
				getResourcesFiles().addAll((Collection<? extends AbstractFile>)newValue);
				return;
			case FmumetamodelPackage.FMU_BUNDLE__WIN32_FILES:
				getWin32Files().clear();
				getWin32Files().addAll((Collection<? extends AbstractFile>)newValue);
				return;
			case FmumetamodelPackage.FMU_BUNDLE__WIN64_FILES:
				getWin64Files().clear();
				getWin64Files().addAll((Collection<? extends AbstractFile>)newValue);
				return;
			case FmumetamodelPackage.FMU_BUNDLE__LINUX32_FILES:
				getLinux32Files().clear();
				getLinux32Files().addAll((Collection<? extends AbstractFile>)newValue);
				return;
			case FmumetamodelPackage.FMU_BUNDLE__LINUX64_FILES:
				getLinux64Files().clear();
				getLinux64Files().addAll((Collection<? extends AbstractFile>)newValue);
				return;
			case FmumetamodelPackage.FMU_BUNDLE__DARWIN64_FILES:
				getDarwin64Files().clear();
				getDarwin64Files().addAll((Collection<? extends AbstractFile>)newValue);
				return;
			case FmumetamodelPackage.FMU_BUNDLE__DARWIN32_FILES:
				getDarwin32Files().clear();
				getDarwin32Files().addAll((Collection<? extends AbstractFile>)newValue);
				return;
			case FmumetamodelPackage.FMU_BUNDLE__DOCUMENTATION_FILES:
				getDocumentationFiles().clear();
				getDocumentationFiles().addAll((Collection<? extends AbstractFile>)newValue);
				return;
			case FmumetamodelPackage.FMU_BUNDLE__SOURCE_FILES:
				getSourceFiles().clear();
				getSourceFiles().addAll((Collection<? extends AbstractFile>)newValue);
				return;
			case FmumetamodelPackage.FMU_BUNDLE__ROOT_FILES:
				getRootFiles().clear();
				getRootFiles().addAll((Collection<? extends AbstractFile>)newValue);
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
			case FmumetamodelPackage.FMU_BUNDLE__MODEL_DESCRIPTION:
				setModelDescription((FmiModelDescriptionType)null);
				return;
			case FmumetamodelPackage.FMU_BUNDLE__RESOURCES_FILES:
				getResourcesFiles().clear();
				return;
			case FmumetamodelPackage.FMU_BUNDLE__WIN32_FILES:
				getWin32Files().clear();
				return;
			case FmumetamodelPackage.FMU_BUNDLE__WIN64_FILES:
				getWin64Files().clear();
				return;
			case FmumetamodelPackage.FMU_BUNDLE__LINUX32_FILES:
				getLinux32Files().clear();
				return;
			case FmumetamodelPackage.FMU_BUNDLE__LINUX64_FILES:
				getLinux64Files().clear();
				return;
			case FmumetamodelPackage.FMU_BUNDLE__DARWIN64_FILES:
				getDarwin64Files().clear();
				return;
			case FmumetamodelPackage.FMU_BUNDLE__DARWIN32_FILES:
				getDarwin32Files().clear();
				return;
			case FmumetamodelPackage.FMU_BUNDLE__DOCUMENTATION_FILES:
				getDocumentationFiles().clear();
				return;
			case FmumetamodelPackage.FMU_BUNDLE__SOURCE_FILES:
				getSourceFiles().clear();
				return;
			case FmumetamodelPackage.FMU_BUNDLE__ROOT_FILES:
				getRootFiles().clear();
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
			case FmumetamodelPackage.FMU_BUNDLE__MODEL_DESCRIPTION:
				return modelDescription != null;
			case FmumetamodelPackage.FMU_BUNDLE__RESOURCES_FILES:
				return resourcesFiles != null && !resourcesFiles.isEmpty();
			case FmumetamodelPackage.FMU_BUNDLE__WIN32_FILES:
				return win32Files != null && !win32Files.isEmpty();
			case FmumetamodelPackage.FMU_BUNDLE__WIN64_FILES:
				return win64Files != null && !win64Files.isEmpty();
			case FmumetamodelPackage.FMU_BUNDLE__LINUX32_FILES:
				return linux32Files != null && !linux32Files.isEmpty();
			case FmumetamodelPackage.FMU_BUNDLE__LINUX64_FILES:
				return linux64Files != null && !linux64Files.isEmpty();
			case FmumetamodelPackage.FMU_BUNDLE__DARWIN64_FILES:
				return darwin64Files != null && !darwin64Files.isEmpty();
			case FmumetamodelPackage.FMU_BUNDLE__DARWIN32_FILES:
				return darwin32Files != null && !darwin32Files.isEmpty();
			case FmumetamodelPackage.FMU_BUNDLE__DOCUMENTATION_FILES:
				return documentationFiles != null && !documentationFiles.isEmpty();
			case FmumetamodelPackage.FMU_BUNDLE__SOURCE_FILES:
				return sourceFiles != null && !sourceFiles.isEmpty();
			case FmumetamodelPackage.FMU_BUNDLE__ROOT_FILES:
				return rootFiles != null && !rootFiles.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FMUBundleImpl
