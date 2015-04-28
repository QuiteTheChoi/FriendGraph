import java.io.*;
import java.util.*;
import java.lang.*;

//Undirected, unweighted graph

//start of Friendship graph

public class Graph {
	
	private HashMap<String, FriendTex> FriendList = new HashMap<String, FriendTex> ();
	private HashMap<String,String> UniversityList = new HashMap<String,String>();
	
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
			NeighborNode temp1, temp2;
			
			if (firstF.university.equals("")) {
				temp1 = new NeighborNode (firstF.name);
			}
			else {
				temp1 = new NeighborNode (firstF.name, firstF.university);
			}
			
			if (secondF.university.equals("")) {
				temp2 = new NeighborNode (secondF.name);
			}
			else {
				temp2 = new NeighborNode (secondF.name, secondF.university);
			}
			firstF.list.add(temp2);			//Adding on to list
			secondF.list.add(temp1);	
		}
		
	}
	
	public Graph () {
		
	}
	
	public String toString()
	{	
		if (FriendList.isEmpty()) {
			return ("This friends list is empty");
		}
		
		StringBuilder graph = new StringBuilder();
		int count=0;
		HashMap<String, ArrayList> namesareforfriends = new HashMap<String, ArrayList>();
		for (String name: FriendList.keySet())
		{
			count++;
		}
		graph.append(count+"\n");
		for (String name: FriendList.keySet())
		{
			ArrayList<String> friends = new ArrayList<String>();
			NeighborNode tmp = FriendList.get(name).list.front;
			while (tmp != null)
			{
				friends.add(tmp.name);
				tmp = tmp.next;
			}
			namesareforfriends.put(name, friends);
		}
		for (String name : namesareforfriends.keySet())
		{
			graph.append(FriendList.get(name).toString() + "\n");
		}
		
		//dividing line - beyond here there be dragons
		
		HashMap<String, ArrayList> printed = new HashMap<String, ArrayList>();
		
		for (String name : FriendList.keySet())
		{
			ArrayList<String> friends = new ArrayList<String>();
			printed.put(name, friends); // creates the 'printed' hashmap with empty arraylists
		}
		
		for (String name : namesareforfriends.keySet())
		{
			ArrayList<String> traverse = namesareforfriends.get(name);
			String s = FriendList.get(name).name;
			
			for (String n : traverse)
			{				
					if(!printed.get(name).contains(n))
					{
						printed.get(name).add(n);
						graph.append(s + "|" + n + "\n");
						printed.get(n).add(name);
					}			
			}
		}
		return graph.toString();
	}
	
	public ArrayList<Graph> cliques (String univName) throws NoSuchElementException {
		univName = univName.toLowerCase();
		
		if (!UniversityList.containsKey(univName)) {
			throw new NoSuchElementException();
		}
		
		ArrayList<Graph> Clique = new ArrayList<Graph>();
		ArrayList<String> VisitMap = new ArrayList<String> ();			//Anytime Vertex gets added to a local hashmap mark as visited. 
		
		Set<String> word = FriendList.keySet();
		Iterator<String> itr = word.iterator();
		
		while (itr.hasNext()) {
			FriendTex tempTex = new FriendTex (FriendList.get(itr.next()));					//Iterating through FriendList
			Graph temp = new Graph();
			if (!VisitMap.contains(tempTex.name)&& tempTex.university.equals(univName)) {  //Clique has not been made
				Queue<NeighborNode> qNeigh = new LinkedList<NeighborNode>();
				Queue<String> qClique = new LinkedList<String>();
				NeighborNode curr = new NeighborNode(tempTex.name,tempTex.university);
				qNeigh.add(curr);
				while (!qNeigh.isEmpty()) {
					curr = qNeigh.remove();
					qClique.add(curr.name);
					NeighborNode tempNode = FriendList.get(curr.name).list.front;
					while (tempNode != null){
						if (tempNode.uni.equals(univName) && !qClique.contains(tempNode.name)) {
							qNeigh.add(tempNode);
							tempNode = tempNode.next;
						}
						else
							tempNode = tempNode.next;
					}
				}
				while (!qClique.isEmpty()) {
					String str = qClique.remove();
					FriendTex localCliq = new FriendTex (FriendList.get(str));
					temp.FriendList.put(str,localCliq);
					VisitMap.add(str);
				}
				Set<String> localWord = temp.FriendList.keySet();
				Iterator<String> localItr = localWord.iterator();
				
				while (localItr.hasNext()) {
					String name = localItr.next();
					NeighborNode local = FriendList.get(name).list.front;
					while (local != null) {
						if (local.uni.equals(univName)) {
							temp.FriendList.get(name).list.add(new NeighborNode(local.name,local.uni));
						}
						local = local.next;
					}
				}				
				Clique.add(temp);			
			}			
		}
			
		return Clique;
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

	public StringBuilder ShortestPath(String src, String target) throws NoSuchElementException
	{
		StringBuilder list = new StringBuilder();
		if (!FriendList.containsKey(src) || !FriendList.containsKey(target))
		{
			throw new NoSuchElementException();
		}
		
		src = src.toLowerCase();
		target = target.toLowerCase();
		
		Queue<NeighborNode> q = new LinkedList<NeighborNode>();
		
		FriendTex start = FriendList.get(src);
		FriendTex end = FriendList.get(target);
		NeighborNode curr = new NeighborNode(start.name);
		q.add(curr);
		HashMap<String, String> prevNaybs = new HashMap<String, String>();
		ArrayList<String> VisitMap = new ArrayList<String> ();
		mainloop:	
		while (!q.isEmpty()) {
			curr = q.remove();
			VisitMap.add (curr.name);
			NeighborNode tmp = FriendList.get(curr.name).list.front;
			while (tmp != null){
				if (!VisitMap.contains(tmp.name)) {
					q.add(tmp);
					prevNaybs.put(tmp.name,curr.name);
					if (tmp.name.equals(end.name)) {
						break mainloop;
					}
				}
				tmp = tmp.next;
			}
		}
		
		if (!prevNaybs.containsKey(target)) {
			StringBuilder error = new StringBuilder("There is no path between these two people.");
			return error;
		}
		
		while (prevNaybs.containsKey(target)) {
				String prevName = prevNaybs.get(target);
				list.insert(0,"--" + target);
				target = prevName;
		}			
		list.insert(0,start.name);
		
		return list;
	}
	
	public boolean nameExists(String name) {
		if (FriendList.containsKey(name))
			return true;
		else
			return false;
	}	
	
	public boolean univExists(String name) {
		if (UniversityList.containsKey(name))
			return true;
		else
			return false;
	}	
	
}
