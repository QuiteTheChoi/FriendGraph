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
			StringTokenizer st = new StringTokenizer(str, "|");
			if (st.countTokens()==3) {				//Student getting added
				FriendTex temp = new FriendTex (st.nextToken(),st.nextToken());
				FriendList.put(temp.name, temp);
			}
			else {
				FriendTex temp = new FriendTex (st.nextToken());
				FriendList.put(temp.name, temp);
			}
			
		}
		
	}

}
