/**
 */
package org.eclipse.papyrus.moka.debug.messages.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.moka.debug.messages.DebugEventContextKind;
import org.eclipse.papyrus.moka.debug.messages.DebugRequest;
import org.eclipse.papyrus.moka.debug.messages.MessagesFactory;
import org.eclipse.papyrus.moka.debug.messages.MessagesPackage;
import org.eclipse.papyrus.moka.debug.messages.ThreadRequest;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MessagesPackageImpl extends EPackageImpl implements MessagesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadRequestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass debugRequestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum debugEventContextKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.moka.debug.messages.MessagesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MessagesPackageImpl() {
		super(eNS_URI, MessagesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link MessagesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MessagesPackage init() {
		if (isInited) return (MessagesPackage)EPackage.Registry.INSTANCE.getEPackage(MessagesPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMessagesPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MessagesPackageImpl theMessagesPackage = registeredMessagesPackage instanceof MessagesPackageImpl ? (MessagesPackageImpl)registeredMessagesPackage : new MessagesPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theMessagesPackage.createPackageContents();

		// Initialize created meta-data
		theMessagesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMessagesPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MessagesPackage.eNS_URI, theMessagesPackage);
		return theMessagesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreadRequest() {
		return threadRequestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThreadRequest_ThreadId() {
		return (EAttribute)threadRequestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThreadRequest_SuspensionPoint() {
		return (EAttribute)threadRequestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getThreadRequest__ToJson() {
		return threadRequestEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDebugRequest() {
		return debugRequestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDebugRequest_EventKind() {
		return (EAttribute)debugRequestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDebugRequest_EventDetail() {
		return (EAttribute)debugRequestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDebugRequest_ContextKind() {
		return (EAttribute)debugRequestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDebugRequest__ToJson() {
		return debugRequestEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDebugEventContextKind() {
		return debugEventContextKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessagesFactory getMessagesFactory() {
		return (MessagesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		threadRequestEClass = createEClass(THREAD_REQUEST);
		createEAttribute(threadRequestEClass, THREAD_REQUEST__THREAD_ID);
		createEAttribute(threadRequestEClass, THREAD_REQUEST__SUSPENSION_POINT);
		createEOperation(threadRequestEClass, THREAD_REQUEST___TO_JSON);

		debugRequestEClass = createEClass(DEBUG_REQUEST);
		createEAttribute(debugRequestEClass, DEBUG_REQUEST__EVENT_KIND);
		createEAttribute(debugRequestEClass, DEBUG_REQUEST__EVENT_DETAIL);
		createEAttribute(debugRequestEClass, DEBUG_REQUEST__CONTEXT_KIND);
		createEOperation(debugRequestEClass, DEBUG_REQUEST___TO_JSON);

		// Create enums
		debugEventContextKindEEnum = createEEnum(DEBUG_EVENT_CONTEXT_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		threadRequestEClass.getESuperTypes().add(this.getDebugRequest());

		// Initialize classes, features, and operations; add parameters
		initEClass(threadRequestEClass, ThreadRequest.class, "ThreadRequest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThreadRequest_ThreadId(), ecorePackage.getEString(), "threadId", null, 0, 1, ThreadRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThreadRequest_SuspensionPoint(), ecorePackage.getEInt(), "suspensionPoint", null, 0, 1, ThreadRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getThreadRequest__ToJson(), ecorePackage.getEString(), "toJson", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(debugRequestEClass, DebugRequest.class, "DebugRequest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDebugRequest_EventKind(), ecorePackage.getEInt(), "eventKind", null, 0, 1, DebugRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDebugRequest_EventDetail(), ecorePackage.getEInt(), "eventDetail", null, 0, 1, DebugRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDebugRequest_ContextKind(), this.getDebugEventContextKind(), "contextKind", null, 0, 1, DebugRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getDebugRequest__ToJson(), ecorePackage.getEString(), "toJson", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(debugEventContextKindEEnum, DebugEventContextKind.class, "DebugEventContextKind");
		addEEnumLiteral(debugEventContextKindEEnum, DebugEventContextKind.ENGINE);
		addEEnumLiteral(debugEventContextKindEEnum, DebugEventContextKind.THREAD);

		// Create resource
		createResource(eNS_URI);
	}

} //MessagesPackageImpl
