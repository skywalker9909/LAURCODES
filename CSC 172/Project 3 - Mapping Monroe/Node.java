/*
 * LAUREL TAY RAEANNE
 * LTAY3@U.ROCHESTER.EDU
 * CSC 172 PROJECT 3
 */

import java.util.ArrayList;

// Define the Node class
public class Node {
	double dist; // Distance value used in algorithms like Dijkstra's
    Boolean known; // Indicates whether the node is known in some algorithms
    Node path; // Stores the previous node in a path
    Boolean visited = false; // Indicates whether the node has been visited
    double lattitude, longitude; // Latitude and longitude coordinates
    String StringID; // Identifier for the node
    public int heapindex = 0; // Index in the heap (used in priority queue)
    public ArrayList<Edge> adjEdge = new ArrayList<Edge>(); // List of adjacent edges
    public Node prev; // Previous node in a path

	// Constructor for initializing a node with its identifier, latitude, and longitude
	public Node(String StringID, double lattitude, double longitude) {
		this.StringID = StringID;
		this.lattitude = lattitude;
		this.longitude = longitude;
	}

	// Method to compare nodes based on their distance values
	public int compareTo(Node a) {
		if (dist > a.dist) {
			return 1;
		}
		if (dist <= a.dist) {

			return -1;
		}

		return 0;

	}

	// Method to print the path from the current node to the starting node
	public void printpath() {
		if (prev != null) {
			prev.printpath();
		}
		System.out.println(this.StringID);

	}
}
