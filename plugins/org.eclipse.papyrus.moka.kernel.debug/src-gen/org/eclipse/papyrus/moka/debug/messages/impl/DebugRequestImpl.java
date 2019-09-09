/**
 */
package org.eclipse.papyrus.moka.debug.messages.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.json.provisonnal.com.eclipsesource.json.JsonObject;
import org.eclipse.papyrus.moka.debug.messages.DebugEventContextKind;
import org.eclipse.papyrus.moka.debug.messages.DebugRequest;
import org.eclipse.papyrus.moka.debug.messages.MessagesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Debug Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.debug.messages.impl.DebugRequestImpl#getEventKind <em>Event Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.debug.messages.impl.DebugRequestImpl#getEventDetail <em>Event Detail</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.debug.messages.impl.DebugRequestImpl#getContextKind <em>Context Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DebugRequestImpl extends MinimalEObjectImpl.Container implements DebugRequest {
	/**
	 * The default value of the '{@link #getEventKind() <em>Event Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventKind()
	 * @generated
	 * @ordered
	 */
	protected static final int EVENT_KIND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEventKind() <em>Event Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventKind()
	 * @generated
	 * @ordered
	 */
	protected int eventKind = EVENT_KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getEventDetail() <em>Event Detail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventDetail()
	 * @generated
	 * @ordered
	 */
	protected static final int EVENT_DETAIL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEventDetail() <em>Event Detail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventDetail()
	 * @generated
	 * @ordered
	 */
	protected int eventDetail = EVENT_DETAIL_EDEFAULT;

	/**
	 * The default value of the '{@link #getContextKind() <em>Context Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextKind()
	 * @generated
	 * @ordered
	 */
	protected static final DebugEventContextKind CONTEXT_KIND_EDEFAULT = DebugEventContextKind.ENGINE;

	/**
	 * The cached value of the '{@link #getContextKind() <em>Context Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextKind()
	 * @generated
	 * @ordered
	 */
	protected DebugEventContextKind contextKind = CONTEXT_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DebugRequestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MessagesPackage.Literals.DEBUG_REQUEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEventKind() {
		return eventKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventKind(int newEventKind) {
		int oldEventKind = eventKind;
		eventKind = newEventKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MessagesPackage.DEBUG_REQUEST__EVENT_KIND, oldEventKind, eventKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEventDetail() {
		return eventDetail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventDetail(int newEventDetail) {
		int oldEventDetail = eventDetail;
		eventDetail = newEventDetail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MessagesPackage.DEBUG_REQUEST__EVENT_DETAIL, oldEventDetail, eventDetail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DebugEventContextKind getContextKind() {
		return contextKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextKind(DebugEventContextKind newContextKind) {
		DebugEventContextKind oldContextKind = contextKind;
		contextKind = newContextKind == null ? CONTEXT_KIND_EDEFAULT : newContextKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MessagesPackage.DEBUG_REQUEST__CONTEXT_KIND, oldContextKind, contextKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toJson() {
		String json = "";
		if(!eIsProxy()) {
			JsonObject request = new JsonObject();
			request.add(MessagesPackage.eINSTANCE.getDebugRequest_ContextKind().getName(), contextKind.toString());
			request.add(MessagesPackage.eINSTANCE.getDebugRequest_EventKind().getName(), eventKind);
			request.add(MessagesPackage.eINSTANCE.getDebugRequest_EventDetail().getName(), eventDetail);
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MessagesPackage.DEBUG_REQUEST__EVENT_KIND:
				return getEventKind();
			case MessagesPackage.DEBUG_REQUEST__EVENT_DETAIL:
				return getEventDetail();
			case MessagesPackage.DEBUG_REQUEST__CONTEXT_KIND:
				return getContextKind();
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
			case MessagesPackage.DEBUG_REQUEST__EVENT_KIND:
				setEventKind((Integer)newValue);
				return;
			case MessagesPackage.DEBUG_REQUEST__EVENT_DETAIL:
				setEventDetail((Integer)newValue);
				return;
			case MessagesPackage.DEBUG_REQUEST__CONTEXT_KIND:
				setContextKind((DebugEventContextKind)newValue);
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
			case MessagesPackage.DEBUG_REQUEST__EVENT_KIND:
				setEventKind(EVENT_KIND_EDEFAULT);
				return;
			case MessagesPackage.DEBUG_REQUEST__EVENT_DETAIL:
				setEventDetail(EVENT_DETAIL_EDEFAULT);
				return;
			case MessagesPackage.DEBUG_REQUEST__CONTEXT_KIND:
				setContextKind(CONTEXT_KIND_EDEFAULT);
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
			case MessagesPackage.DEBUG_REQUEST__EVENT_KIND:
				return eventKind != EVENT_KIND_EDEFAULT;
			case MessagesPackage.DEBUG_REQUEST__EVENT_DETAIL:
				return eventDetail != EVENT_DETAIL_EDEFAULT;
			case MessagesPackage.DEBUG_REQUEST__CONTEXT_KIND:
				return contextKind != CONTEXT_KIND_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MessagesPackage.DEBUG_REQUEST___TO_JSON:
				return toJson();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (eventKind: ");
		result.append(eventKind);
		result.append(", eventDetail: ");
		result.append(eventDetail);
		result.append(", contextKind: ");
		result.append(contextKind);
		result.append(')');
		return result.toString();
	}

} //DebugRequestImpl
