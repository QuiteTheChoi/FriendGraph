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
			
		for (int i = 0; i < countOfVertex; i ++) {
			String str = sc.next();
			StringTokenizer st = new StringTokenizer(str, "|");
			while (st.hasMoreElements()) {
				System.out.println(st.nextElement());
			}
		}
		
	}

}
