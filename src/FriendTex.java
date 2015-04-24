public class FriendTex {
	public String name;
	public String university;
	public FriendTex firstNeighbor; //first neighbor
	public FriendTex lastNeighbor; //Last neighbor
		
	public FriendTex (String fName, String uName, FriendTex neighs) {
		name = fName;
		university = uName;		
		firstNeighbor = neighs;
	}
	
	public FriendTex (String fName, String uName) {
		name = fName;
		university = uName;		
		firstNeighbor = null;
		lastNeighbor = null;
	}
	
	public FriendTex (String fName, FriendTex neighs) {
		name = fName;
		university = "";		
		firstNeighbor = neighs;
	}
	
	public FriendTex (String fName) {
		name = fName;
		university = "";		
		firstNeighbor = null;
		lastNeighbor = null;
	}
	
	public void add (FriendTex neigh) {
		if (firstNeighbor == null) {
			firstNeighbor = neigh;
			lastNeighbor = neigh;
		}
		else if (lastNeighbor == firstNeighbor) {
			firstNeighbor.lastNeighbor = neigh;
			lastNeighbor = neigh;
		}
		else {
			lastNeighbor.lastNeighbor = neigh;
		}
		
	}
	
	public String toString() {
		if (university.equals(""))
			return name + "|" + "n";
		else
			return name+ "|" + university;
		
	}
}
