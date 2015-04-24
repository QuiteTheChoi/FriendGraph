public class FriendTex {
	public String name;
	public String university;
	public NeighborNode firstNeighbor; //first neighbor
		
	public FriendTex (String fName, String uName, NeighborNode neighs) {
		name = fName;
		university = uName;		
		firstNeighbor = neighs;
	}
	
	public FriendTex (String fName, String uName) {
		name = fName;
		university = uName;		
		firstNeighbor = null;
	}
	
	public FriendTex (String fName, NeighborNode neighs) {
		name = fName;
		university = "";		
		firstNeighbor = neighs;
	}
	
	public FriendTex (String fName) {
		name = fName;
		university = "";		
		firstNeighbor = null;
	}
	
	public String toString() {
		
	}
}
