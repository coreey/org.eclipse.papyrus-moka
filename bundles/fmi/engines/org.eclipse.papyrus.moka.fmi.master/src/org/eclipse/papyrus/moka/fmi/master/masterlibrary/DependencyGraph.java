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
package org.eclipse.papyrus.moka.fmi.master.masterlibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.papyrus.moka.fmi.master.fmilibrary.Fmi2Port;

import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.internal.impl.PropertyImpl;

/**
 * A directed graph composed of nodes (the inputs and outputs ports of the cosimulation graph)
 * and edges (I/O dependency relations and O/I connections of the cosimulation graph)
 */
public class DependencyGraph {
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private ArrayList<Node> nodes = new ArrayList<Node>();
	private boolean cyclic = false;

	/**
	 * creates the dependency graph from the coSimgraph
	 **/
	public DependencyGraph(CoSimEnvironment cosimEnvironnement) {
		List<Dependency> ioDependencies = cosimEnvironnement.getIoDependencies();

		// create the edges of the dependency graph
		// Port mapping --> Output 2 Input
		// Dependencies --> Input 2 Output
		Node sourceNode = null;
		Node targetNode = null;
		for (Fmi2Port targetPort : cosimEnvironnement.getInputPorts()) {
			Fmi2Port sourcePort = targetPort.getDrivingPort();
			// create an edge from the output to the input
			// this correspond to create an edge from value to key
			// the key is an input port --> target
			// the value is an output port --> source
			sourceNode = new Node(sourcePort);
			targetNode = new Node(targetPort);
			Edge edge = new Edge(sourceNode, targetNode);
			this.addNode(sourceNode);
			this.addNode(targetNode);
			this.addEdge(edge);
		}


		for (Dependency d : ioDependencies) {
			if ((d.getClients().get(0)) instanceof Port) {
				Port client = (Port) d.getClients().get(0); // an output port --> target node,

				if (d.getSuppliers().get(0) instanceof Port) {
					Port supplier = (Port) d.getSuppliers().get(0); // an input port --> source node
					for (Node n : this.getNodes()) {
						if ((n.getVariable().getPort()).equals(client)) {
							targetNode = n;
						}
						if ((n.getVariable().getPort()).equals(supplier)) {
							sourceNode = n;
						}
					}
					Edge edge = new Edge(sourceNode, targetNode);
					this.addEdge(edge);
				}
			}


		}
	}

	public ArrayList<Fmi2Port> topoSort() {
		/**
		 * L ← Empty list that will contain the sorted elements
		 * S ← Set of all nodes with no incoming edges
		 * while S is non-empty do
		 * remove a node n from S
		 * add n to tail of L
		 * for each node m with an edge e from n to m do
		 * remove edge e from the graph
		 * if m has no other incoming edges then
		 * insert m into S
		 * if graph has edges then
		 * return error (graph has at least one cycle)
		 * else
		 * return L (a topologically sorted order)
		 **/
		boolean moreEdges = true;
		DependencyGraph G = this;
		ArrayList<Fmi2Port> L = new ArrayList<Fmi2Port>();// L ← Empty list that will contain the sorted elements
		ArrayList<Node> S = new ArrayList<Node>(); // S ← Set of all nodes with no incoming edges
		for (Node n : G.nodes) {
			if (n.getIncomings().size() == 0) {
				S.add(n);
			}
		}
		while (S.size() > 0) { // while S is non-empty do
			moreEdges = true;
			Node n = S.get(0);
			S.remove(0); // remove n from S
			L.add(n.getVariable()); // add n to tail of L
			ArrayList<Edge> n2m = n.getOutgoings();
			if (n2m.size() > 0) {
				while (moreEdges) {
					Node m = n2m.get(0).getTarget();
					removeEdge(n2m.get(0), G);
					if (m.getIncomings().size() == 0) {
						S.add(m);
					}
					if (n2m.size() > 0) {
						n2m.remove(0);
					}
					if (n2m.size() == 0) {
						moreEdges = false;
					}
				}
			}
		}
		if (G.edges.size() > 0) {
			this.cyclic = true;
			System.out.println("the graph is cyclic, cannot continue cosimulation");
		}
		return L;
	}

	public void addNode(Node node) {
		// TODO Auto-generated method stub
		nodes.add(node);
	}

	public void addEdge(Edge edge) {
		// TODO Auto-generated method stub
		edges.add(edge);
		edge.getSource().getOutgoings().add(edge);
		edge.getTarget().getIncomings().add(edge);
	}

	public void removeEdge(Edge edge, DependencyGraph g) {
		// TODO Auto-generated method stub
		int index = g.edges.indexOf(edge);
		if (index != -1) {
			int source_index = edge.getSource().getOutgoings().indexOf(edge);
			if (source_index != -1) {
				edge.getSource().getOutgoings().remove(source_index);
			}
			int target_index = edge.getTarget().getIncomings().indexOf(edge);
			if (target_index != -1) {
				edge.getTarget().getIncomings().remove(target_index);
			}
			g.edges.remove(index);
		} else {
			System.out.println("error, edge not found!!");
		}
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

	public boolean isCyclic() {
		return cyclic;
	}

	public void setCyclic(boolean cyclic) {
		this.cyclic = cyclic;
	}


}
