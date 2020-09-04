/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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

package org.eclipse.papyrus.moka.engine.uml.debug.data.variables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IVariable;

public class MokaValueAdapterList extends UMLValueAdapter<List<Object>> implements List<Object> {

	public MokaValueAdapterList(IDebugTarget target) {
		this(target, null);
	}
	
	public MokaValueAdapterList(IDebugTarget target, List<Object> adaptedObject) {
		super(target, adaptedObject);
		value = new ArrayList<Object>();
		if(adaptedObject != null) {
			value.addAll(adaptedObject);
		}
	}

	@Override
	public String getValueString() throws DebugException {
		return "(size = " + value.size() + ")";
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		if (this.variables.isEmpty()) {
			int index = 1;
			Iterator<Object> tobeAdaptedIterator = value.iterator();
			while (tobeAdaptedIterator.hasNext()) {
				this.variables.add(new ItemVariableAdapter(getDebugTarget(), index, UMLValueAdapterFactory
						.getInstance().instantiate(tobeAdaptedIterator.next(), getDebugTarget())));
				index++;
			}
		}
		return this.variables.toArray(new IVariable[0]);
	}

	@Override
	public boolean hasVariables() throws DebugException {
		return this.getVariables().length > 0;
	}

	@Override
	public int size() {
		return value.size();
	}

	@Override
	public boolean isEmpty() {
		return value.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return value.contains(o);
	}

	@Override
	public Iterator<Object> iterator() {
		return value.iterator();
	}

	@Override
	public Object[] toArray() {
		return value.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return value.toArray(a);
	}

	@Override
	public boolean add(Object e) {
		return value.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return value.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return value.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Object> c) {
		return value.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends Object> c) {
		return value.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return value.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return value.retainAll(c);
	}

	@Override
	public void clear() {
		value.clear();
	}

	@Override
	public Object get(int index) {
		return value.get(index);
	}

	@Override
	public Object set(int index, Object element) {
		return value.set(index, element);
	}

	@Override
	public void add(int index, Object element) {
		value.add(index, element);
	}

	@Override
	public Object remove(int index) {
		return value.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return value.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return value.lastIndexOf(o);
	}

	@Override
	public ListIterator<Object> listIterator() {
		return value.listIterator();
	}

	@Override
	public ListIterator<Object> listIterator(int index) {
		return value.listIterator(index);
	}

	@Override
	public List<Object> subList(int fromIndex, int toIndex) {
		return value.subList(fromIndex, toIndex);
	}

}
