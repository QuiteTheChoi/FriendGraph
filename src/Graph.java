import java.io.*;
import java.util.*;
import java.lang.*;

//Undirected, unweighted graph

//start of Friendship graph

public class Graph {
	
	public HashMap<String, FriendTex> FriendList = new HashMap<String, FriendTex> ();  
	
	public Graph(String graphFile) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(graphFile));
		
		int countOfVertex = sc.nextInt();
		sc.nextLine();
			
		for (int i = 0; i < countOfVertex; i ++) {
			String str = sc.nextLine();
			str.toLowerCase();
			StringTokenizer st = new StringTokenizer(str, "|");
			if (st.countTokens()==3) {				//Student getting added
				String name = st.nextToken();
				st.nextToken();
				String univ = st.nextToken();
				FriendTex temp = new FriendTex (name,univ);
				FriendList.put(temp.name, temp);
			}
			else {   //teacher getting added 
				FriendTex temp = new FriendTex (st.nextToken());
				FriendList.put(temp.name, temp);
			}
			
		}
		//Creation of neighbors
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			str.toLowerCase();
			StringTokenizer st = new StringTokenizer(str, "|");
			String friend1 = st.nextToken();	//friend 1 name
			String friend2 = st.nextToken();	//friend 2 name
			
			FriendTex firstF = FriendList.get(friend1);
			FriendTex secondF = FriendList.get(friend2);
			
			NeighborNode temp1 = new NeighborNode (friend1);
			NeighborNode temp2 = new NeighborNode (friend2);
			
			if (firstF.list == null) {				//Adding new list to first friend
				firstF.list = new NeighborList();
				firstF.list.front = temp2;
				firstF.list.tail = temp2;
			}
			else {
				firstF.list.add(friend2);			//Adding on to list
			}
			
			if (secondF.list == null) {
				secondF.list = new NeighborList();
				secondF.list.front = temp1;
				secondF.list.tail = temp1;
			}
			else {
				secondF.list.add(friend1);
			}
			
		}
		
	}
	
	
	
	public class ShortestPath {
		
		public ShortestPath(String src, String target) throws Exception
		{
			if (src == null || target == null)
			{
				throw new Exception("Invalid Input");
			}
			
			if (FriendList.get(src) == null || FriendList.get(target) == null)
			{
				throw new Exception("Inputs don't exist.");
			}
			
			src = src.toLowerCase();
			target = target.toLowerCase();
			
			int distance; 
			
			Queue<FriendTex> visited = new LinkedList<FriendTex>();
			
			FriendTex start = FriendList.get(src);
			FriendTex end = FriendList.get(target);
			FriendTex prev = null;
			
			for (String key: FriendList.keySet())
			{
				
			}
			
		}
	}

}
