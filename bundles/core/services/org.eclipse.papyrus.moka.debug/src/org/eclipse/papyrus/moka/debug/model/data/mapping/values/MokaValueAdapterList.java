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

package org.eclipse.papyrus.moka.debug.model.data.mapping.values;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.model.data.mapping.variables.ItemVariableAdapter;

public class MokaValueAdapterList extends MokaValueAdapter<List<Object>> implements List<Object> {

	public MokaValueAdapterList(MokaDebugTarget debugTarget) {
		this(debugTarget, null);
	}
	
	public MokaValueAdapterList(MokaDebugTarget debugTarget, List<Object> adaptedObject) {
		super(debugTarget, adaptedObject);
		this.adaptedObject = new ArrayList<Object>();
		if(adaptedObject != null) {
			this.adaptedObject.addAll(adaptedObject);
		}
	}

	@Override
	public String getValueString() throws DebugException {
		return "(size = " + this.adaptedObject.size() + ")";
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		if (this.variables.isEmpty()) {
			int index = 1;
			Iterator<Object> tobeAdaptedIterator = this.adaptedObject.iterator();
			while (tobeAdaptedIterator.hasNext()) {
				this.variables.add(new ItemVariableAdapter(this.debugTarget, index, MokaValueAdapterFactory
						.getInstance().instantiate(tobeAdaptedIterator.next(), this.debugTarget)));
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
		return this.adaptedObject.size();
	}

	@Override
	public boolean isEmpty() {
		return this.adaptedObject.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return this.adaptedObject.contains(o);
	}

	@Override
	public Iterator<Object> iterator() {
		return this.adaptedObject.iterator();
	}

	@Override
	public Object[] toArray() {
		return this.adaptedObject.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return this.adaptedObject.toArray(a);
	}

	@Override
	public boolean add(Object e) {
		return this.adaptedObject.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return this.adaptedObject.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return this.adaptedObject.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Object> c) {
		return this.adaptedObject.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends Object> c) {
		return this.adaptedObject.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return this.adaptedObject.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return this.adaptedObject.retainAll(c);
	}

	@Override
	public void clear() {
		this.adaptedObject.clear();
	}

	@Override
	public Object get(int index) {
		return this.adaptedObject.get(index);
	}

	@Override
	public Object set(int index, Object element) {
		return this.adaptedObject.set(index, element);
	}

	@Override
	public void add(int index, Object element) {
		this.adaptedObject.add(index, element);
	}

	@Override
	public Object remove(int index) {
		return this.adaptedObject.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return this.adaptedObject.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return this.adaptedObject.lastIndexOf(o);
	}

	@Override
	public ListIterator<Object> listIterator() {
		return this.adaptedObject.listIterator();
	}

	@Override
	public ListIterator<Object> listIterator(int index) {
		return this.adaptedObject.listIterator(index);
	}

	@Override
	public List<Object> subList(int fromIndex, int toIndex) {
		return this.adaptedObject.subList(fromIndex, toIndex);
	}

}
