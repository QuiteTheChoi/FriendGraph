
public class NeighborNode {
	public String name;
	public NeighborNode head = null;
	public NeighborNode next = null;
	public NeighborNode tail = null;
	int counter = 0;
	
	NeighborNode (String Name) {
		name = Name;
		counter++;
	}
	
	public void add (String nameNeigh) {
		NeighborNode temp = new NeighborNode (nameNeigh);
		
		if (head == null) {
			head = temp;
			tail = temp;
		}
		else if (head == tail) {
			
		}
		else {
			lastNeighbor.lastNeighbor = neigh;
		}
		
	}
	
}
