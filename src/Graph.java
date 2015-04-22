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

public class Graph {
	
	

}
