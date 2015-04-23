
public class NeighborNode {
	public String name;
	public NeighborNode next;
	
	NeighborNode (String Name, NeighborNode nextNeigh) {
		name = Name;
		next = nextNeigh;
	}
	
	NeighborNode (String Name) {
		name = Name;
		next = null;
	}
}
