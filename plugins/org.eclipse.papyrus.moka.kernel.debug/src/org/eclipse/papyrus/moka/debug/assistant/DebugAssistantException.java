/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.debug.assistant;

import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.kernel.assistant.IDebugAssistant;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

public class DebugAssistantException extends RuntimeException {

	private static final long serialVersionUID = 7505081361638138900L;

	protected IDebugAssistant debugAssistant;

	protected ISemanticVisitor visitor;

	protected Element visitorNode;

	protected String message;

	/**
	 * Constructor
	 * 
	 * @param visitor     the visitor
	 * @param visitorNode the node corresponding to the visitor
	 */
	public DebugAssistantException(IDebugAssistant debugAssistant, ISemanticVisitor visitor) {
		this(debugAssistant, visitor, null);
	}

	/**
	 * Constructor
	 * 
	 * @param debugAssistant the debug assistant
	 * @param visitor        the visitor
	 * @param message        a message to use in the thread label
	 */
	public DebugAssistantException(IDebugAssistant debugAssistant, ISemanticVisitor visitor, String message) {
		super();
		this.debugAssistant = debugAssistant;
		this.visitor = visitor;
		this.visitorNode = this.debugAssistant.getVisitorNode(visitor);
		this.message = message;
	}

	/**
	 * @return the debugAssistant
	 */
	public IDebugAssistant getDebugAssistant() {
		return debugAssistant;
	}

	/**
	 * @param debugAssistant the debugAssistant to set
	 */
	public void setDebugAssistant(IDebugAssistant debugAssistant) {
		this.debugAssistant = debugAssistant;
	}

	/**
	 * @return the visitor
	 */
	public ISemanticVisitor getVisitor() {
		return visitor;
	}

	/**
	 * @param visitor the visitor to set
	 */
	public void setVisitor(ISemanticVisitor visitor) {
		this.visitor = visitor;
	}

	/**
	 * @return the visitorNode
	 */
	public Element getVisitorNode() {
		return visitorNode;
	}

	/**
	 * @param visitorNode the visitorNode to set
	 */
	public void setVisitorNode(Element visitorNode) {
		this.visitorNode = visitorNode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (message != null) {
			builder.append(message);
		} else {
			builder.append("Missing expected tokens\n");
		}
		builder.append("Current visited node: ");
		if (visitorNode instanceof NamedElement) {
			builder.append(((NamedElement) visitorNode).getQualifiedName());
		} else {
			builder.append(visitorNode);
		}
		return builder.toString();
	}

}
