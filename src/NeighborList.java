
public class NeighborList {

	NeighborNode tail,front = null;
	int counter = 0;
	
	public NeighborList(){
	
	}
	
	public void add(String toAdd){
		NeighborNode  n = new NeighborNode(toAdd);
		tail.next = n;
		tail = n;
		counter++;		
	}
	
}
