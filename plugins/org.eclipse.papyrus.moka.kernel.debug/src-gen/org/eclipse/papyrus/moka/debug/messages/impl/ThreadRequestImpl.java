/**
 */
package org.eclipse.papyrus.moka.debug.messages.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.json.provisonnal.com.eclipsesource.json.JsonObject;
import org.eclipse.papyrus.moka.debug.messages.MessagesPackage;
import org.eclipse.papyrus.moka.debug.messages.ThreadRequest;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Thread Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.debug.messages.impl.ThreadRequestImpl#getThreadId <em>Thread Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.debug.messages.impl.ThreadRequestImpl#getSuspensionPoint <em>Suspension Point</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ThreadRequestImpl extends DebugRequestImpl implements ThreadRequest {
	/**
	 * The default value of the '{@link #getThreadId() <em>Thread Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreadId()
	 * @generated
	 * @ordered
	 */
	protected static final String THREAD_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThreadId() <em>Thread Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreadId()
	 * @generated
	 * @ordered
	 */
	protected String threadId = THREAD_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuspensionPoint() <em>Suspension Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionPoint()
	 * @generated
	 * @ordered
	 */
	protected static final int SUSPENSION_POINT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSuspensionPoint() <em>Suspension Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionPoint()
	 * @generated
	 * @ordered
	 */
	protected int suspensionPoint = SUSPENSION_POINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThreadRequestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MessagesPackage.Literals.THREAD_REQUEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThreadId() {
		return threadId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThreadId(String newThreadId) {
		String oldThreadId = threadId;
		threadId = newThreadId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MessagesPackage.THREAD_REQUEST__THREAD_ID, oldThreadId, threadId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSuspensionPoint() {
		return suspensionPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuspensionPoint(int newSuspensionPoint) {
		int oldSuspensionPoint = suspensionPoint;
		suspensionPoint = newSuspensionPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MessagesPackage.THREAD_REQUEST__SUSPENSION_POINT, oldSuspensionPoint, suspensionPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MessagesPackage.THREAD_REQUEST__THREAD_ID:
				return getThreadId();
			case MessagesPackage.THREAD_REQUEST__SUSPENSION_POINT:
				return getSuspensionPoint();
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
			case MessagesPackage.THREAD_REQUEST__THREAD_ID:
				setThreadId((String)newValue);
				return;
			case MessagesPackage.THREAD_REQUEST__SUSPENSION_POINT:
				setSuspensionPoint((Integer)newValue);
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
			case MessagesPackage.THREAD_REQUEST__THREAD_ID:
				setThreadId(THREAD_ID_EDEFAULT);
				return;
			case MessagesPackage.THREAD_REQUEST__SUSPENSION_POINT:
				setSuspensionPoint(SUSPENSION_POINT_EDEFAULT);
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
			case MessagesPackage.THREAD_REQUEST__THREAD_ID:
				return THREAD_ID_EDEFAULT == null ? threadId != null : !THREAD_ID_EDEFAULT.equals(threadId);
			case MessagesPackage.THREAD_REQUEST__SUSPENSION_POINT:
				return suspensionPoint != SUSPENSION_POINT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public String toJson() {
		String json = "";
		if(!eIsProxy()) {
			JsonObject request = JsonObject.readFrom(super.toJson());
			request.add(MessagesPackage.eINSTANCE.getThreadRequest_ThreadId().getName(), threadId);
			request.add(MessagesPackage.eINSTANCE.getThreadRequest_SuspensionPoint().getName(), suspensionPoint);
			json = request.toString();
		}
		return json;
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
		result.append(" (threadId: ");
		result.append(threadId);
		result.append(", suspensionPoint: ");
		result.append(suspensionPoint);
		result.append(')');
		return result.toString();
	}

} //ThreadRequestImpl
