import java.io.*;
import java.util.*;

//Undirected, unweighted graph

//Friendship edges

class Neighbor {
	int vertexNum;
	Neighbor next;
	
	Neighbor (int vNum, Neighbor nextNeigh) {
		vertexNum = vNum;
		next = nextNeigh;
	}
	
}

//Vertex per student

class Vertex {
	private String name;
	private String university;
	private Neighbor adjList;
	
	Vertex (String fName, String uName, Neighbor neighs) {
		name = fName;
		university = uName;
		adjList = neighs;
	}
	
	Vertex (String fName, Neighbor neighs) {
		name = fName;
		university = null;
		adjList = neighs;
	}
}

//start of Friendship graph

public class Graph {
	
	private Vertex[] adjList;
	private HashMap<String, Integer> IntLocation = new HashMap<String, Integer> ();  
	
	public Graph(String graphFile) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(graphFile));
		
		int countOfVertex = sc.nextInt();
				
		while (sc.hasNextLine()) {
			System.out.println (sc.nextLine());
		}
	}

}
