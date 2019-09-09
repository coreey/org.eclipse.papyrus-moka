/**
 */
package org.eclipse.papyrus.moka.debug.messages;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.debug.messages.MessagesPackage
 * @generated
 */
public interface MessagesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MessagesFactory eINSTANCE = org.eclipse.papyrus.moka.debug.messages.impl.MessagesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Thread Request</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thread Request</em>'.
	 * @generated
	 */
	ThreadRequest createThreadRequest();

	/**
	 * Returns a new object of class '<em>Debug Request</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Debug Request</em>'.
	 * @generated
	 */
	DebugRequest createDebugRequest();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MessagesPackage getMessagesPackage();

} //MessagesFactory
