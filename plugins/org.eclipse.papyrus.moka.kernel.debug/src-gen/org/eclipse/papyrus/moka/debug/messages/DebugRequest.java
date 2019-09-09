/**
 */
package org.eclipse.papyrus.moka.debug.messages;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Debug Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.debug.messages.DebugRequest#getEventKind <em>Event Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.debug.messages.DebugRequest#getEventDetail <em>Event Detail</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.debug.messages.DebugRequest#getContextKind <em>Context Kind</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.debug.messages.MessagesPackage#getDebugRequest()
 * @model
 * @generated
 */
public interface DebugRequest extends EObject {
	/**
	 * Returns the value of the '<em><b>Event Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Kind</em>' attribute.
	 * @see #setEventKind(int)
	 * @see org.eclipse.papyrus.moka.debug.messages.MessagesPackage#getDebugRequest_EventKind()
	 * @model
	 * @generated
	 */
	int getEventKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.debug.messages.DebugRequest#getEventKind <em>Event Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Kind</em>' attribute.
	 * @see #getEventKind()
	 * @generated
	 */
	void setEventKind(int value);

	/**
	 * Returns the value of the '<em><b>Event Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Detail</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Detail</em>' attribute.
	 * @see #setEventDetail(int)
	 * @see org.eclipse.papyrus.moka.debug.messages.MessagesPackage#getDebugRequest_EventDetail()
	 * @model
	 * @generated
	 */
	int getEventDetail();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.debug.messages.DebugRequest#getEventDetail <em>Event Detail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Detail</em>' attribute.
	 * @see #getEventDetail()
	 * @generated
	 */
	void setEventDetail(int value);

	/**
	 * Returns the value of the '<em><b>Context Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.moka.debug.messages.DebugEventContextKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Kind</em>' attribute.
	 * @see org.eclipse.papyrus.moka.debug.messages.DebugEventContextKind
	 * @see #setContextKind(DebugEventContextKind)
	 * @see org.eclipse.papyrus.moka.debug.messages.MessagesPackage#getDebugRequest_ContextKind()
	 * @model
	 * @generated
	 */
	DebugEventContextKind getContextKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.debug.messages.DebugRequest#getContextKind <em>Context Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Kind</em>' attribute.
	 * @see org.eclipse.papyrus.moka.debug.messages.DebugEventContextKind
	 * @see #getContextKind()
	 * @generated
	 */
	void setContextKind(DebugEventContextKind value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String toJson();

} // DebugRequest
