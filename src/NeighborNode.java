
public class NeighborNode {
	public String name = "";
	public String uni = "";
	public NeighborNode next = null;
		
	public NeighborNode (String Name, String uni) {
		name = Name;
		this.uni = uni;
	}
	
	
	public NeighborNode (String Name) {
		name = Name;
	}	
	
	public NeighborNode(){
		
	}
	
	public NeighborNode(String data, NeighborNode next){ 
		name = data;
		this.next = next;
	}
	
	public String toString()
	{
		if (uni.equals(""))
			return name + "|" + "n";
		else
			return name+ "|" + "y" + "|" + uni;
	}
}
