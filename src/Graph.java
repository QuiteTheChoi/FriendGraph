import java.io.*;
import java.util.*;
import java.lang.*;

//Undirected, unweighted graph

//start of Friendship graph

public class Graph {
	
	public HashMap<String, FriendTex> FriendList = new HashMap<String, FriendTex> ();
	public HashMap<String,String> UniversityList = new HashMap<String,String>();
	
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
				if (!UniversityList.containsKey(univ));
					UniversityList.put(univ, univ);
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
	
	public Graph () {
		
	}
	
	public ArrayList cligues (String univName) throws NoSuchElementException {
		if (!UniversityList.containsKey(univName)) {
			throw new NoSuchElementException();
		}
		
		int counter = 0;
		HashMap<Integer,Graph> Clique = new HashMap<Integer,Graph>();
		HashMap<String,Boolean> VisitMap = this.VisitedMap();
		
		Set<String> word = VisitMap.keySet();
		Iterator<String> itr = word.iterator();
		
		while (itr.hasNext()) {						//Iterating through FriendList
			FriendTex temp = FriendList.get(itr.next());		
			if (!VisitMap.get(temp.name)) {				//if not visited, start looking at cliques. 
				
			}
			
		}
		
		return null;
	}
	
	private HashMap<String,Boolean> VisitedMap () {				//When a visited array is needed
		HashMap<String,Boolean> tempMap = new HashMap<String,Boolean>();
		
		Set<String> word = FriendList.keySet();  
		Iterator<String> itr = word.iterator();
		
		while (itr.hasNext()) {
			String key = itr.next();
			tempMap.put(key, false);			
		}
		
		return tempMap;
	}
	
	public void ShortestPath(String src, String target) throws Exception
		{
			if (!FriendList.containsKey(src) || !FriendList.containsKey(target))
			{
				throw new Exception("Invalid Input");
			}
			
			src = src.toLowerCase();
			target = target.toLowerCase();
			
			Queue<FriendTex> visited = new LinkedList<FriendTex>();
			
			FriendTex start = FriendList.get(src);
			FriendTex end = FriendList.get(target);
			FriendTex curr = start;
			
			visited.add(curr);
			while (!visited.isEmpty())
			{
				curr = visited.remove();
				
				if (curr.equals(end))
				{
					break;
				} else 
				{
					for (NeighborNode tmp = curr.neighbor; tmp!= null; tmp = tmp.next)
					{
						if (!visited.contains(tmp))
						{
							visited.add(tmp);
						}
					}
				}
			}
		}

}
