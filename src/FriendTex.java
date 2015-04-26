public class FriendTex {
	public String name;
	public String university = "";
	public NeighborList list = new NeighborList();
	
		
	public FriendTex (String fName, String uName) {
		name = fName;
		university = uName;		
	}
	
	public FriendTex (String fName) {
		name = fName;
		
	}
	
	public FriendTex (FriendTex temp) {
		name = temp.name;
		university = temp.university;
	}
	
	public boolean equals(FriendTex compareTo) {
		if (this.name.equals(compareTo.name))
			return true;
		else
			return false;
	}
	
	public String toString() {
		if (university.equals(""))
			return name + "|" + "n";
		else
			return name+ "|" + "y" + "|" + university;
		
	}
}
