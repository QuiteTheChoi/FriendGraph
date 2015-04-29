import java.io.*;
import java.util.*;

public class friends {
static Scanner stdin = new Scanner(System.in);
	
	static char getOption() {
		System.out.println("\tWhat would you like to do?");
		System.out.println("(1) Shortest Intro Chain");
		System.out.println("(2) Cliques");
		System.out.println("(3) Connectors");
		System.out.println("(4) Quit");
		String check = stdin.next();
		char response = check.charAt(0);
		while ((response != '1' && response != '2' && response != '3' && response != '4') || check.length() > 1) {
			System.out.print("Please enter '1', '2', '3', or '4': ");
			check = stdin.next();
			response = check.charAt(0);
		}
		return response;
	}
	
	public static void main(String[] args) throws Exception {
		Graph friends;
		
		while (true) {
			try {
				System.out.print("Please enter a valid Friendship Graph file: ");
				String graphFile = stdin.next();
				friends = new Graph(graphFile);
				break;
			}
			catch (Exception e) {
				continue;
			}
		}
		System.out.println(friends);
		
		char option;
		while ((option = getOption()) != '4') {
			if (option == '1') {
				String friend1,friend2;				
				System.out.println("Please enter the first friend");
				friend1 = stdin.next();
				
				while (!friends.nameExists(friend1)) {
					System.out.println("Please enter a valid name");
					friend1 = stdin.next();
				}
				
				System.out.println("Please enter the second friend");
				friend2 = stdin.next();
				
				while (!friends.nameExists(friend2) || friend2.equals(friend1)) {
					System.out.println("Please enter a valid name");
					friend2 = stdin.next();
				}
				
			}			
			if (option == '2') {
				ArrayList<Graph> temp;
				String univName;			
				
				System.out.println("Please enter a university");
				 Scanner in = new Scanner(System.in);
				univName = in.nextLine();
								
				while (!friends.univExists(univName)) {
					System.out.println("That univeristy is not on this list");
					System.out.println("Please enter a valid university");
					univName = in.nextLine();
				}
				
				temp = friends.cliques(univName);
				
				int counter = 1;
				for (Graph G: temp) {
					System.out.println("Clique: " + counter);
					System.out.println(G);
					counter++;
				}
				
			}
			
			if (option == '3') {
				System.out.println(friends.porn());
			}
		
		}
				
	}

}
	
