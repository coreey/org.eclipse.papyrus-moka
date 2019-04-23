/**
 * Copyright (c) 2016 CEA LIST.
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
package org.eclipse.papyrus.moka.fmi.modeldescription.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Unit Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.BaseUnitTypeImpl#getA <em>A</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.BaseUnitTypeImpl#getCd <em>Cd</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.BaseUnitTypeImpl#getFactor <em>Factor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.BaseUnitTypeImpl#getK <em>K</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.BaseUnitTypeImpl#getKg <em>Kg</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.BaseUnitTypeImpl#getM <em>M</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.BaseUnitTypeImpl#getMol <em>Mol</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.BaseUnitTypeImpl#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.BaseUnitTypeImpl#getRad <em>Rad</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.BaseUnitTypeImpl#getS <em>S</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BaseUnitTypeImpl extends MinimalEObjectImpl.Container implements BaseUnitType {
	/**
	 * The default value of the '{@link #getA() <em>A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA()
	 * @generated
	 * @ordered
	 */
	protected static final int A_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getA() <em>A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA()
	 * @generated
	 * @ordered
	 */
	protected int a = A_EDEFAULT;

	/**
	 * This is true if the A attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean aESet;

	/**
	 * The default value of the '{@link #getCd() <em>Cd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCd()
	 * @generated
	 * @ordered
	 */
	protected static final int CD_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCd() <em>Cd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCd()
	 * @generated
	 * @ordered
	 */
	protected int cd = CD_EDEFAULT;

	/**
	 * This is true if the Cd attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean cdESet;

	/**
	 * The default value of the '{@link #getFactor() <em>Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactor()
	 * @generated
	 * @ordered
	 */
	protected static final double FACTOR_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getFactor() <em>Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactor()
	 * @generated
	 * @ordered
	 */
	protected double factor = FACTOR_EDEFAULT;

	/**
	 * This is true if the Factor attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean factorESet;

	/**
	 * The default value of the '{@link #getK() <em>K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getK()
	 * @generated
	 * @ordered
	 */
	protected static final int K_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getK() <em>K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getK()
	 * @generated
	 * @ordered
	 */
	protected int k = K_EDEFAULT;

	/**
	 * This is true if the K attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean kESet;

	/**
	 * The default value of the '{@link #getKg() <em>Kg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKg()
	 * @generated
	 * @ordered
	 */
	protected static final int KG_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getKg() <em>Kg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKg()
	 * @generated
	 * @ordered
	 */
	protected int kg = KG_EDEFAULT;

	/**
	 * This is true if the Kg attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean kgESet;

	/**
	 * The default value of the '{@link #getM() <em>M</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM()
	 * @generated
	 * @ordered
	 */
	protected static final int M_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getM() <em>M</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM()
	 * @generated
	 * @ordered
	 */
	protected int m = M_EDEFAULT;

	/**
	 * This is true if the M attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean mESet;

	/**
	 * The default value of the '{@link #getMol() <em>Mol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMol()
	 * @generated
	 * @ordered
	 */
	protected static final int MOL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMol() <em>Mol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMol()
	 * @generated
	 * @ordered
	 */
	protected int mol = MOL_EDEFAULT;

	/**
	 * This is true if the Mol attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean molESet;

	/**
	 * The default value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected static final double OFFSET_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected double offset = OFFSET_EDEFAULT;

	/**
	 * This is true if the Offset attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean offsetESet;

	/**
	 * The default value of the '{@link #getRad() <em>Rad</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRad()
	 * @generated
	 * @ordered
	 */
	protected static final int RAD_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRad() <em>Rad</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRad()
	 * @generated
	 * @ordered
	 */
	protected int rad = RAD_EDEFAULT;

	/**
	 * This is true if the Rad attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean radESet;

	/**
	 * The default value of the '{@link #getS() <em>S</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS()
	 * @generated
	 * @ordered
	 */
	protected static final int S_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getS() <em>S</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS()
	 * @generated
	 * @ordered
	 */
	protected int s = S_EDEFAULT;

	/**
	 * This is true if the S attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean sESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseUnitTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FmiPackage.Literals.BASE_UNIT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getA() {
		return a;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setA(int newA) {
		int oldA = a;
		a = newA;
		boolean oldAESet = aESet;
		aESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.BASE_UNIT_TYPE__A, oldA, a, !oldAESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetA() {
		int oldA = a;
		boolean oldAESet = aESet;
		a = A_EDEFAULT;
		aESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.BASE_UNIT_TYPE__A, oldA, A_EDEFAULT, oldAESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetA() {
		return aESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCd() {
		return cd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCd(int newCd) {
		int oldCd = cd;
		cd = newCd;
		boolean oldCdESet = cdESet;
		cdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.BASE_UNIT_TYPE__CD, oldCd, cd, !oldCdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCd() {
		int oldCd = cd;
		boolean oldCdESet = cdESet;
		cd = CD_EDEFAULT;
		cdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.BASE_UNIT_TYPE__CD, oldCd, CD_EDEFAULT, oldCdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCd() {
		return cdESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFactor() {
		return factor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFactor(double newFactor) {
		double oldFactor = factor;
		factor = newFactor;
		boolean oldFactorESet = factorESet;
		factorESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.BASE_UNIT_TYPE__FACTOR, oldFactor, factor, !oldFactorESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFactor() {
		double oldFactor = factor;
		boolean oldFactorESet = factorESet;
		factor = FACTOR_EDEFAULT;
		factorESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.BASE_UNIT_TYPE__FACTOR, oldFactor, FACTOR_EDEFAULT, oldFactorESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFactor() {
		return factorESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getK() {
		return k;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setK(int newK) {
		int oldK = k;
		k = newK;
		boolean oldKESet = kESet;
		kESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.BASE_UNIT_TYPE__K, oldK, k, !oldKESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetK() {
		int oldK = k;
		boolean oldKESet = kESet;
		k = K_EDEFAULT;
		kESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.BASE_UNIT_TYPE__K, oldK, K_EDEFAULT, oldKESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetK() {
		return kESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getKg() {
		return kg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKg(int newKg) {
		int oldKg = kg;
		kg = newKg;
		boolean oldKgESet = kgESet;
		kgESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.BASE_UNIT_TYPE__KG, oldKg, kg, !oldKgESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetKg() {
		int oldKg = kg;
		boolean oldKgESet = kgESet;
		kg = KG_EDEFAULT;
		kgESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.BASE_UNIT_TYPE__KG, oldKg, KG_EDEFAULT, oldKgESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetKg() {
		return kgESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getM() {
		return m;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setM(int newM) {
		int oldM = m;
		m = newM;
		boolean oldMESet = mESet;
		mESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.BASE_UNIT_TYPE__M, oldM, m, !oldMESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetM() {
		int oldM = m;
		boolean oldMESet = mESet;
		m = M_EDEFAULT;
		mESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.BASE_UNIT_TYPE__M, oldM, M_EDEFAULT, oldMESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetM() {
		return mESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMol() {
		return mol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMol(int newMol) {
		int oldMol = mol;
		mol = newMol;
		boolean oldMolESet = molESet;
		molESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.BASE_UNIT_TYPE__MOL, oldMol, mol, !oldMolESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMol() {
		int oldMol = mol;
		boolean oldMolESet = molESet;
		mol = MOL_EDEFAULT;
		molESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.BASE_UNIT_TYPE__MOL, oldMol, MOL_EDEFAULT, oldMolESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMol() {
		return molESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOffset() {
		return offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffset(double newOffset) {
		double oldOffset = offset;
		offset = newOffset;
		boolean oldOffsetESet = offsetESet;
		offsetESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.BASE_UNIT_TYPE__OFFSET, oldOffset, offset, !oldOffsetESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOffset() {
		double oldOffset = offset;
		boolean oldOffsetESet = offsetESet;
		offset = OFFSET_EDEFAULT;
		offsetESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.BASE_UNIT_TYPE__OFFSET, oldOffset, OFFSET_EDEFAULT, oldOffsetESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOffset() {
		return offsetESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getRad() {
		return rad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRad(int newRad) {
		int oldRad = rad;
		rad = newRad;
		boolean oldRadESet = radESet;
		radESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.BASE_UNIT_TYPE__RAD, oldRad, rad, !oldRadESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRad() {
		int oldRad = rad;
		boolean oldRadESet = radESet;
		rad = RAD_EDEFAULT;
		radESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.BASE_UNIT_TYPE__RAD, oldRad, RAD_EDEFAULT, oldRadESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRad() {
		return radESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getS() {
		return s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setS(int newS) {
		int oldS = s;
		s = newS;
		boolean oldSESet = sESet;
		sESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmiPackage.BASE_UNIT_TYPE__S, oldS, s, !oldSESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetS() {
		int oldS = s;
		boolean oldSESet = sESet;
		s = S_EDEFAULT;
		sESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FmiPackage.BASE_UNIT_TYPE__S, oldS, S_EDEFAULT, oldSESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetS() {
		return sESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FmiPackage.BASE_UNIT_TYPE__A:
				return getA();
			case FmiPackage.BASE_UNIT_TYPE__CD:
				return getCd();
			case FmiPackage.BASE_UNIT_TYPE__FACTOR:
				return getFactor();
			case FmiPackage.BASE_UNIT_TYPE__K:
				return getK();
			case FmiPackage.BASE_UNIT_TYPE__KG:
				return getKg();
			case FmiPackage.BASE_UNIT_TYPE__M:
				return getM();
			case FmiPackage.BASE_UNIT_TYPE__MOL:
				return getMol();
			case FmiPackage.BASE_UNIT_TYPE__OFFSET:
				return getOffset();
			case FmiPackage.BASE_UNIT_TYPE__RAD:
				return getRad();
			case FmiPackage.BASE_UNIT_TYPE__S:
				return getS();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FmiPackage.BASE_UNIT_TYPE__A:
				setA((Integer)newValue);
				return;
			case FmiPackage.BASE_UNIT_TYPE__CD:
				setCd((Integer)newValue);
				return;
			case FmiPackage.BASE_UNIT_TYPE__FACTOR:
				setFactor((Double)newValue);
				return;
			case FmiPackage.BASE_UNIT_TYPE__K:
				setK((Integer)newValue);
				return;
			case FmiPackage.BASE_UNIT_TYPE__KG:
				setKg((Integer)newValue);
				return;
			case FmiPackage.BASE_UNIT_TYPE__M:
				setM((Integer)newValue);
				return;
			case FmiPackage.BASE_UNIT_TYPE__MOL:
				setMol((Integer)newValue);
				return;
			case FmiPackage.BASE_UNIT_TYPE__OFFSET:
				setOffset((Double)newValue);
				return;
			case FmiPackage.BASE_UNIT_TYPE__RAD:
				setRad((Integer)newValue);
				return;
			case FmiPackage.BASE_UNIT_TYPE__S:
				setS((Integer)newValue);
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
			case FmiPackage.BASE_UNIT_TYPE__A:
				unsetA();
				return;
			case FmiPackage.BASE_UNIT_TYPE__CD:
				unsetCd();
				return;
			case FmiPackage.BASE_UNIT_TYPE__FACTOR:
				unsetFactor();
				return;
			case FmiPackage.BASE_UNIT_TYPE__K:
				unsetK();
				return;
			case FmiPackage.BASE_UNIT_TYPE__KG:
				unsetKg();
				return;
			case FmiPackage.BASE_UNIT_TYPE__M:
				unsetM();
				return;
			case FmiPackage.BASE_UNIT_TYPE__MOL:
				unsetMol();
				return;
			case FmiPackage.BASE_UNIT_TYPE__OFFSET:
				unsetOffset();
				return;
			case FmiPackage.BASE_UNIT_TYPE__RAD:
				unsetRad();
				return;
			case FmiPackage.BASE_UNIT_TYPE__S:
				unsetS();
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
			case FmiPackage.BASE_UNIT_TYPE__A:
				return isSetA();
			case FmiPackage.BASE_UNIT_TYPE__CD:
				return isSetCd();
			case FmiPackage.BASE_UNIT_TYPE__FACTOR:
				return isSetFactor();
			case FmiPackage.BASE_UNIT_TYPE__K:
				return isSetK();
			case FmiPackage.BASE_UNIT_TYPE__KG:
				return isSetKg();
			case FmiPackage.BASE_UNIT_TYPE__M:
				return isSetM();
			case FmiPackage.BASE_UNIT_TYPE__MOL:
				return isSetMol();
			case FmiPackage.BASE_UNIT_TYPE__OFFSET:
				return isSetOffset();
			case FmiPackage.BASE_UNIT_TYPE__RAD:
				return isSetRad();
			case FmiPackage.BASE_UNIT_TYPE__S:
				return isSetS();
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
		result.append(" (a: ");
		if (aESet) result.append(a); else result.append("<unset>");
		result.append(", cd: ");
		if (cdESet) result.append(cd); else result.append("<unset>");
		result.append(", factor: ");
		if (factorESet) result.append(factor); else result.append("<unset>");
		result.append(", k: ");
		if (kESet) result.append(k); else result.append("<unset>");
		result.append(", kg: ");
		if (kgESet) result.append(kg); else result.append("<unset>");
		result.append(", m: ");
		if (mESet) result.append(m); else result.append("<unset>");
		result.append(", mol: ");
		if (molESet) result.append(mol); else result.append("<unset>");
		result.append(", offset: ");
		if (offsetESet) result.append(offset); else result.append("<unset>");
		result.append(", rad: ");
		if (radESet) result.append(rad); else result.append("<unset>");
		result.append(", s: ");
		if (sESet) result.append(s); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //BaseUnitTypeImpl
