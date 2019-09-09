/**
 */
package org.eclipse.papyrus.moka.debug.messages;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Thread Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.debug.messages.ThreadRequest#getThreadId <em>Thread Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.debug.messages.ThreadRequest#getSuspensionPoint <em>Suspension Point</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.debug.messages.MessagesPackage#getThreadRequest()
 * @model
 * @generated
 */
public interface ThreadRequest extends DebugRequest {
	/**
	 * Returns the value of the '<em><b>Thread Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thread Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thread Id</em>' attribute.
	 * @see #setThreadId(String)
	 * @see org.eclipse.papyrus.moka.debug.messages.MessagesPackage#getThreadRequest_ThreadId()
	 * @model
	 * @generated
	 */
	String getThreadId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.debug.messages.ThreadRequest#getThreadId <em>Thread Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thread Id</em>' attribute.
	 * @see #getThreadId()
	 * @generated
	 */
	void setThreadId(String value);

	/**
	 * Returns the value of the '<em><b>Suspension Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspension Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspension Point</em>' attribute.
	 * @see #setSuspensionPoint(int)
	 * @see org.eclipse.papyrus.moka.debug.messages.MessagesPackage#getThreadRequest_SuspensionPoint()
	 * @model
	 * @generated
	 */
	int getSuspensionPoint();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.debug.messages.ThreadRequest#getSuspensionPoint <em>Suspension Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspension Point</em>' attribute.
	 * @see #getSuspensionPoint()
	 * @generated
	 */
	void setSuspensionPoint(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String toJson();

} // ThreadRequest
