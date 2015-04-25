
public class NeighborNode {
	public String name = "";
	public NeighborNode next = null;
		
	public NeighborNode (String Name) {
		name = Name;
	}
	
	public NeighborNode(){
		
	}
	
	public NeighborNode(String data, NeighborNode next){ 
		name = data;
		this.next = next;
	}
	
}
