public class FriendTex {
	public String name;
	public String university;
	public NeighborNode firstNeighbor; //first neighbor
		
	public FriendTex (String fName, String uName, NeighborNode neighs) {
		name = fName;
		university = uName;		
	}
	
	public FriendTex (String fName, NeighborNode neighs) {
		name = fName;
		university = "";		
	}
}
