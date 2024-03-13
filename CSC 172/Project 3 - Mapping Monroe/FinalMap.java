/*
 * LAUREL TAY RAEANNE
 * LTAY3@U.ROCHESTER.EDU
 * CSC 172 PROJECT 3
 */

 import java.awt.Dimension;
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.util.Arrays;
 import java.util.HashMap;
 import java.util.Scanner;
 
 import javax.swing.JFrame;
 
 // Define the FinalMap class
 public class FinalMap {

	 Boolean integer=true;
	 HashMap<String,Node> intersections=new HashMap<String,Node>(390000);
	 HashMap<String,Edge> roads=new HashMap<String,Edge>(720000);
	 int numOfnode=0;
	 int numOfroad=0;
	 String startN,endN;

    // Method to create a graph from a file
	public Graph createFromFile(String filename,String show, String category) {
		 
		 Scanner in;
		 try {
		 in = new Scanner(new File(filename));

		 // Loop through lines in the file
		 while(in.hasNextLine()){
			 String IR=in.next();

			 // If "i" is read, it indicates an intersection node
			 if(IR.equals("i")){
				 String key=in.next();
				 Node intersection=new Node(key,Double.parseDouble(in.next()),Double.parseDouble(in.next()));
				 intersections.put(key, intersection);
				 numOfnode++;
			 }else{
			     // Otherwise, it indicates a road edge
				 String keye=in.next();
				 Edge road=new Edge(keye,in.next(),in.next());
				 roads.put(keye, road);
				 numOfroad++;
			 }
		 }
		 in.close();

		// Create a JFrame for displaying the map
		 JFrame jframe=new JFrame("Map");
		 jframe.setSize(530,530);

		// Create a Graph object and populate it with intersections and edges
		 Graph g=new Graph(intersections);
		 g.insertEdges(roads);

		// Create a GUI component for rendering the graph
		 GUI gui=new GUI(g);
		 gui.setFocusable(true);
		 gui.setPreferredSize(new Dimension(500,500));

		// Add the GUI component to the JFrame
		 jframe.add(gui);

        // Set the JFrame's visibility based on the "show" argument
		jframe.setVisible(show.equals("--show"));
		 jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// If the "category" argument is "--directions," calculate and display directions
		 if(category.equals("--directions")||show.equals("--directions")){
		 	Node start=intersections.get(startN);
		 	Node end=intersections.get(endN);
		 	g.dijkstra(start, end);
		 	gui.end=end;
		 	gui.findPath=true;
		 } else {
			// Otherwise, calculate and display the Minimum Spanning Tree (MST)
		 	gui.MST=g.MST();
		 	gui.MSTTF=true;
		 }

			// Repaint the GUI component

		 gui.repaint();
		 return g;
		 } catch (FileNotFoundException e1) {
			 // TODO Auto-generated catch block
			 return null;
		 }
 	}

	public void directions(String startN,String endN){
		this.startN=startN;
		this.endN=endN;
	}
	
	public static void main(String[] arg) {

		if (arg.length == 0) {
			System.out.println("");
			System.out.println("Hello! Here are the instructions to use this program:");
			System.out.println("to see just the map: [filename] [--show] [--directions startIntersection endIntersection]");
			System.out.println("to see just the directions: [filename] [--directions startIntersection endIntersection]");
			System.out.println("to see both the directions and map: [filename][--show][--directions startIntersection endIntersection]");
			System.out.println("Example: java FinalMap ur.txt --show --directions HOEING OBRIEN");
			System.out.println("");

			return;
		} // Exit the program if no arguments are provided
		String filename = arg[0];
		String show = arg[1];
		String category;

		// Assign a default value to category if less than 3 arguments are provided
		if (arg.length < 3) {
			category = "x";
		} else {
			category = arg[2];
		}

		FinalMap t = new FinalMap();

		// Check if category is --directions and sufficient arguments are provided
		if (category.equals("--directions") && arg.length >= 5) {
			t.directions(arg[3], arg[4]);
		} else if (show.equals("--directions") && arg.length >= 4) {
			// Check if show is --directions and sufficient arguments are provided
			t.directions(arg[2], arg[3]);
		}

		t.createFromFile(filename, show, category);
	}
}

