
public class NeighborList {

	NeighborNode tail,front = null;
	int counter = 0;
	
	public NeighborList(){
	
	}
	
	public void add(String name){
		NeighborNode  n = new NeighborNode(name);
		
		if (tail == null && front == null) {
			front = n;
			counter++;
			return;
		}
		
		if (tail == null) {
			tail = n;
			front.next = n;			
			counter++;
			return;
		}
		
		tail.next = n;
		tail = n;
		counter++;		
	}
			
	public void add(NeighborNode temp){
		NeighborNode  n = new NeighborNode(temp);
		
		if (tail == null && front == null) {
			front = n;
			tail = n;
			counter++;
			return;
		}
		tail.next = n;
		tail = n;
		counter++;		
	}
}
