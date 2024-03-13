/*
 * LAUREL TAY RAEANNE
 * LTAY3@U.ROCHESTER.EDU
 * CSC 172 PROJECT 3
 */

PROJECT 3 READ ME

1. OVERVIEW (SYNOPSIS)

This Java program is designed to visualize and manipulate graph structures representing road maps. It allows for calculating the shortest path between two points using Dijkstra's algorithm and constructing a Minimum Spanning Tree (MST) for the graph. The program reads a set of nodes and edges from a file, plots them on a GUI, and applies graph algorithms to find the shortest path and MST. The GUI dynamically adjusts to window resizing and provides a clear, color-coded visualization of different paths.

2. FILES INCLUDED

FinalMap.java: Main class file containing the application logic.
Node.java: Class representing a node (intersection) in the map.
Edge.java: Class representing an edge (road) in the map.
Heap.java: Class representing heap data structure. 
Graph.java: Class handling the graph structure and algorithms.
GUI.java: Graphical User Interface for map visualization.

3. HOW TO USE

Hello! Here are the instructions to use this program:
(run program to first see instructions)
to see just the map: [filename] [--show] [--directions startIntersection endIntersection]
to see just the directions: [filename] [--directions startIntersection endIntersection]
to see both the directions and map: [filename][--show][--directions startIntersection endIntersection]
Example: java FinalMap ur.txt --show --directions HOEING OBRIEN


4. NOTABLE OBSTACLES AND SOLUTIONS

Obstacle 1: Efficient Data Structure for Graph Representation
Challenge: One of the initial challenges was choosing the most efficient data structure to represent the graph for both the nodes (intersections) and edges (roads). The key was to balance quick access for rendering and efficient pathfinding.
Solution: After evaluating several options, I decided to use HashMaps for both nodes and edges. This provided O(1) average-time complexity for access operations, which was crucial for the performance of Dijkstra's algorithm and for dynamic GUI updates.

Obstacle 2: Implementing Dijkstra's Algorithm for Large Datasets
Challenge: Implementing Dijkstra's algorithm was challenging, especially for large datasets with numerous nodes and edges. The primary issue was ensuring that the algorithm was efficient enough to provide quick pathfinding solutions.
Solution: I optimized the algorithm by using a priority queue to manage the nodes during the pathfinding process. This reduced the time complexity significantly and resulted in a more responsive application, even with large maps.

Obstacle 3: Dynamic GUI Responsiveness and Redrawing
Challenge: Ensuring that the GUI dynamically adjusted to window resizing without losing map detail or becoming unresponsive was a significant hurdle. This was especially challenging when redrawing complex map structures after resizing.
Solution: I implemented a double-buffering technique to enhance the GUI's performance. This involved redrawing the map off-screen and then rendering it on-screen, which minimized flickering and improved rendering efficiency. Additionally, I optimized the rendering logic to redraw only the necessary parts of the map, thereby reducing the computational load.

5.EXTRA CREDIT CONSIDERATION

I have implemented an advanced graphical representation of the map within the JFrame, which not only accurately reflects the map's structure but also enhances user interaction. Key features include:
- Dynamic Resizing Capability: The application is designed to gracefully handle window resizing. Whether you restart the program or adjust the window size, the map quickly and efficiently readjusts to fit the new dimensions, ensuring a seamless user experience.
- Clear and Distinct Visualization: The map is distinctly illustrated with black lines representing the basic map structure. Additionally, for enhanced clarity and distinction, paths calculated using Dijkstra's algorithm are highlighted in red, while the Minimum Spanning Tree (MST) paths are shown in blue. This color-coding not only improves readability but also aids in better understanding the different functionalities of the program.
- Optimized Performance: Despite the complexity of real-time graphical adjustments and the detailed rendering of the map, the program maintains a high level of performance and responsiveness.
- Given these advanced features and the significant effort put into ensuring both functionality and user experience, I believe this project warrants the consideration of 20 extra credit points. The enhancements go beyond the basic requirements, offering a more interactive and user-friendly interface while clearly depicting complex graph structures and algorithms.

6. RUNTIME ANALYSIS

Map Visualization
- Nodes Processing (HashMap Building): The time complexity is O(n) where n is the number of nodes. This complexity arises from iterating through all nodes once to build a HashMap in the FinalMap class, which is then copied into the graph.
- Edges Processing:
    - HashMap Building: O(E), where E is the number of edges. This is because we iterate through each edge once to build a HashMap.
    - Evaluation of Edges: O(E) for processing each edge in the HashMap.
    - Overall, the time complexity for edges processing is O(E) + O(E) = O(E).
- Determining Max and Min Longitude and Latitude: O(n). This is due to updating the maximum and minimum values after processing each edge.
- GUI Rendering: O(E) for drawing each edge in the GUI.

Overall, for map visualization, the combined runtime complexity is O(n) + O(E).

Dijkstra's Algorithm
- The implementation of Dijkstra's algorithm involves extracting the minimum from a heap and updating distances. In the worst case, all edges are added to the heap, and each edge is processed until no more can be processed. The worst-case time complexity is O(E) where E is the number of edges.

Minimum Spanning Tree (MST)
- Sorting Edge List: The runtime for sorting the edge list is E(E log E) using Java's built-in sort function.
- Finding Predecessor Method: In the worst case, the time complexity is O(E), as it might need to process each edge once.
Therefore, the total runtime for the MST operation is O(E log E) + O(E).

In summary, for map visualization, the runtime is dominated by O(E) due to the edges processing. For Dijkstra's algorithm and the MST operation, the runtime complexities are O(E) and O(E log E) + O(E), respectively.
In total, the runtime is O(E) +O(n)+Elog(E)

7. Detailed Description of Project:

Classes and Their Members/Methods
    - Edge Class
        - Private Members:
            - String Intersection1ID, Intersection2ID: Identifiers for the nodes that the edge connects.
            - Boolean visited: Indicates whether the edge has been visited.
            - double weight: The weight or cost associated with the edge.
            - String StringID: An identifier for the edge.

    - Public Methods:
        - Edge(String StringID, String Intersection1ID, String Intersection2ID): Constructor that initializes an edge with the provided identifiers.
        - static double mile(double lat1, double long1, double lat2, double long2): Calculates the distance between two GPS coordinates.
        - public int compareTo(Edge n2): Compares edges based on their weight.
    
    - Node Class
        - Private Members:
            - double dist: The distance value used in algorithms like Dijkstra's.
            - Boolean known: Indicates if the node's shortest path has been found.
            - ArrayList<Edge> adjEdge: List of adjacent edges.
            - Node prev: Stores the previous node in the path.

        - Public Methods:
            - Node(String StringID, double latitude, double longitude): Constructor that initializes a node with its identifier and geographical coordinates.
            - Public void printpath(): Prints the path from the current node to the starting node.
    
    - Graph Class
        - Private Members:
            - HashMap<String, Node> intersections: Stores nodes indexed by their identifiers.
            - HashMap<String, Edge> roads: Stores edges indexed by their identifiers.
            - ArrayList<Edge> MST: Stores the edges that make up the MST.
        - Public Methods:
            - Graph(HashMap<String, Node> intersections): Constructor that initializes the graph with a set of intersections.
            - public void dijkstra(Node start, Node end): Applies Dijkstra's algorithm to find the shortest path from start to end.
            - public ArrayList<Edge> MST(): Constructs the MST of the graph.
    
    - GUI Class
        - Private Members:
            - Graph g: The graph object that contains the map's data.
            - Boolean findPath: Indicates if the shortest path should be drawn.
            - Boolean MSTTF: Indicates if the MST should be drawn.
        - Public Methods:
            - GUI(Graph g): Constructor that initializes the GUI with a graph object.
            - public void paintComponent(Graphics g): Overridden method that handles the drawing of the graph on the component.
            - public void drawMST(Graphics g): Draws the MST on the GUI.
            - public void drawShortestPath(Graphics g, Node end): Draws the shortest path on the GUI.

    - FinalMap Class
        - Public Methods:
            - createFromFile(String filename, String show, String category): Reads the map data from a file and initializes the GUI and graph.
            - public void directions(String startN, String endN): Sets the start and end nodes for finding directions.
            - public static void main(String[] arg): The entry point of the program which handles the command-line arguments and initializes the map creation.
    
    - Additional Classes and Structures:
        - Heap and Comparable Implementations: These are used for efficient storage and retrieval of nodes and edges during the execution of graph algorithms.
    
    - Input and Output Parameters:
        - Each method's input parameters are the arguments it accepts, and its output is either the return type or the effect it has on the program's state (e.g., updating a member variable, drawing on the GUI, etc.).
        - For example, the Edge constructor takes StringID, Intersection1ID, and Intersection2ID as input parameters and has no output as it initializes the object. The mile method takes four double values representing GPS coordinates as inputs and outputs a double representing the distance.



