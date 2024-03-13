/*
 * LAUREL TAY RAEANNE
 * LTAY3@U.ROCHESTER.EDU
 * CSC 172 PROJECT 3
 */

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JPanel;

// Define the Graph class, which extends JPanel
public class Graph extends JPanel {
	public HashMap<String, Heap> graph;
	// Indicates whether the graph is directed or undirected
	boolean directed; // false for undirected graphs, true for directed
	public HashMap<String, Node> intersections; // Stores graph nodes (intersections)
	public HashMap<String, Node> unknowinter; // An auxiliary map for intersections
	public HashMap<String, Edge> roads; // Stores graph edges (roads)
	final int INFINITY = 99999999; // A constant representing infinity
	double minLattitude = 0, maxLattitude = 0, minLongitude = 0, maxLongitude = 0; // Latitude and longitude bounds
	int mstlength;


    // Dijkstra's algorithm to find the shortest distance between nodes
	public void dijkstra(Node start, Node end) {

		Heap heap = new Heap();
		start.dist = 0;
		heap.insert(start);
		while (!heap.isEmpty()) {

			Node min = heap.deleteMin();
			if (min == end) {

				break;
			}
			for (Edge e : min.adjEdge) {
				if (e.visited == false) {
					e.visited = true;
					Node b;
					if (intersections.get(e.Intersection1ID) == min) {
						b = intersections.get(e.Intersection2ID);
					} else {
						b = intersections.get(e.Intersection1ID);
					}

					double weight = e.weight;
					double distance = min.dist + weight;
					if (!heap.contain(b)) {
						b.dist = distance;
						heap.insert(b);
						b.prev = min;

					}

					else {
						if (b.dist > distance) {

							heap.decreaseKey(b, distance);
							b.prev = min;

						}
					}
				}
			}
		}
		end.printpath();
		System.out.println("Total Distance: " + end.dist+" miles");
	}

	// Method to find the Minimum Spanning Tree (MST) of the graph
	public ArrayList<Edge> MST() {
		ArrayList<Edge> MSTE = new ArrayList<Edge>();
		mstlength = 0;
		ArrayList<Edge> heaproads = new ArrayList<Edge>();
		for (String key : roads.keySet()) {
			heaproads.add(roads.get(key));
		}
		heaproads.sort(new EdgeComparator());
		for (Edge e : heaproads) {

			Node i1 = intersections.get(e.Intersection1ID);
			Node i2 = intersections.get(e.Intersection2ID);
			Node p1 = prev(i1);
			if (p1 != i1) {
				i1.prev = p1;
			}

			Node p2 = prev(i2);
			if (p2 != i2) {
				i2.prev = p2;
			}

			if (p1 != p2) {

				p2.prev = p1;
				MSTE.add(e);
				System.out.println(e.StringID);
				mstlength += e.weight;
			}

			if (MSTE.size() == intersections.size() - 1) {

				break;

			}

		}
		return MSTE;

	}

	// Method to find the representative node (root) of a set
	public static Node prev(Node x) {

		if (x.prev == null) {

			return x;

		}

		return prev(x.prev);

	}

	// Comparator for comparing edges based on their weight
	static class EdgeComparator implements Comparator<Edge> {

		public int compare(Edge n1, Edge n2) {

			return n1.compareTo(n2);
		}

	}
//constructor
	public Graph(HashMap<String, Node> intersections) { 

		this.intersections = intersections;
		unknowinter = intersections;
		findminmax();
	}

	 // Method to insert edges (roads) into the graph
	public void insertEdges(HashMap<String, Edge> roads) {
		this.roads = roads;
		for (String key : roads.keySet()) {
			Edge road = roads.get(key);
			Node n1 = intersections.get(road.Intersection1ID);
			Node n2 = intersections.get(road.Intersection2ID);
			road.weight = Edge.mile(n1.lattitude, n1.longitude, n2.lattitude, n2.longitude);
			n1.adjEdge.add(road);
			n2.adjEdge.add(road);
		}

	}

	// Method to find the minimum and maximum latitude and longitude in the graph
	public void findminmax() {
		for (String key : intersections.keySet()) {
			if (minLattitude == 0) {
				minLattitude = intersections.get(key).lattitude;
			}
			double tempt = intersections.get(key).lattitude;
			if (tempt < minLattitude) {
				minLattitude = tempt;
			}
			if (maxLattitude == 0) {
				maxLattitude = intersections.get(key).lattitude;
			}
			double tempt2 = intersections.get(key).lattitude;
			if (tempt2 > maxLattitude) {
				maxLattitude = tempt2;
			}
			if (minLongitude == 0) {
				minLongitude = intersections.get(key).longitude;
			}
			double tempt3 = intersections.get(key).longitude;
			if (tempt3 < minLongitude) {
				minLongitude = tempt3;
			}
			if (maxLongitude == 0) {
				maxLongitude = intersections.get(key).longitude;
			}
			double tempt4 = intersections.get(key).longitude;
			if (tempt4 > maxLongitude) {
				maxLongitude = tempt4;
			}
		}

	}

}