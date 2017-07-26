/*****************************************************************************
 * 
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.table.instancespecification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.utils.Activator;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.utils.commands.ValueSpecificationSetCommand;
import org.eclipse.papyrus.uml.xtext.integration.XtextFakeResourceContext;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProvider;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProviderWithInit;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.papyrus.infra.services.validation.commands.AbstractValidateCommand;
import org.eclipse.papyrus.infra.services.validation.commands.AsyncValidateSubtreeCommand;
import com.google.inject.Injector;


public class CustomSpecificationSetCommand extends ValueSpecificationSetCommand{
	
	
	/**
	 * The instance of the class.
	 */
	private static ValueSpecificationSetCommand instance = new CustomSpecificationSetCommand();

	public static ValueSpecificationSetCommand getInstance() {
		return instance;
	}
	
	@Override
	public CompositeCommand createSetCommand(Injector injector, EObject objectToEdit,
			EStructuralFeature structuralFeature, String xtextStringValue, Collection<String> defaultLanguages) {
		// Get the initial value specification
				
		//override super to handle slot value collections... We only get first value
		ValueSpecification initialValueSpecification = null;
				if (null != structuralFeature) {
					if (structuralFeature.isMany()) {
						Collection valueList = (Collection)objectToEdit
								.eGet(structuralFeature);
						if (valueList != null && !valueList.isEmpty()) {
							initialValueSpecification = (ValueSpecification) valueList.iterator().next();
						}else {
							initialValueSpecification = null;
						}
					}else {
						initialValueSpecification = (ValueSpecification) objectToEdit
								.eGet(structuralFeature);
					}
					
				}

				// Prepare the composite command
				final CompositeCommand result = new CompositeCommand("validation"); //$NON-NLS-1$
				final IContextElementProvider provider = getContextProvider(objectToEdit);

				// Get the xtext face resource context (needed to parse the xtext string
				// value
				XtextFakeResourceContext context = new XtextFakeResourceContext(
						injector);
				context.getFakeResource().eAdapters()
						.add(new ContextElementAdapter(provider));
				// Load the xtext string value
				try {
					context.getFakeResource().load(
							new StringInputStream(xtextStringValue),
							Collections.EMPTY_MAP);
				} catch (IOException e) {
					Activator.log.error(e);
				}
				if (provider instanceof IContextElementProviderWithInit) {
					((IContextElementProviderWithInit) provider).initResource(context
							.getFakeResource());
				}
				EcoreUtil2.resolveLazyCrossReferences(context.getFakeResource(),
						CancelIndicator.NullImpl);
				if (!context.getFakeResource().getParseResult().hasSyntaxErrors()
						&& context.getFakeResource().getErrors().size() == 0) {
					// No error during the parser of xtext string value
					EObject xtextObject = context.getFakeResource().getParseResult()
							.getRootASTElement();

					ICommand cmd = getParseCommand(objectToEdit,
							initialValueSpecification, structuralFeature, xtextObject,
							xtextStringValue, defaultLanguages);
					if (null != cmd) {
						result.add(cmd);
					}
				} else {
					// The parser of xtext string value throw errors
					result.add(manageOpaqueExpression(objectToEdit, structuralFeature, initialValueSpecification, xtextStringValue, defaultLanguages));
				}
//				AbstractValidateCommand validationCommand = new AsyncValidateSubtreeCommand(objectToEdit);
//				validationCommand.disableUIFeedback();
//				result.add(validationCommand);
				return result;
			}


	
	@Override
	protected ICommand createCommand(EObject objectToEdit, EStructuralFeature structuralFeature,
			ValueSpecification valueSpecification) {
		final CompositeCommand setValueCommand = new CompositeCommand("Set Value Specification Command"); //$NON-NLS-1$

		Object value;
		//override super in order to delete existing collection and replace it with the new value
		if (structuralFeature.isMany()) {
			value = Arrays.asList(valueSpecification);
		}else {
			value = valueSpecification;
		}
		final SetRequest request = new SetRequest(objectToEdit,
				structuralFeature, value);

		final IElementEditService commandProvider = ElementEditServiceUtils
				.getCommandProvider(objectToEdit);
		ICommand setDefaultValueCommand = commandProvider
				.getEditCommand(request);
		if (null != setDefaultValueCommand
				&& setDefaultValueCommand.canExecute()) {
			setValueCommand.add(setDefaultValueCommand);
		} else {
			setValueCommand
					.add(UnexecutableCommand.INSTANCE);
		}
		return setValueCommand.isEmpty() ? null : setValueCommand;
	}

	
}

