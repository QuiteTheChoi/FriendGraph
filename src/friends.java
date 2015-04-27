import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
	
	public static void main(String[] args) throws IOException {
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
					System.out.println("That name does not exist");
					System.out.println("Please enter the first friend");
					friend1 = stdin.next();
				}
				System.out.println("Please enter the second friend");
				friend2 = stdin.next();
				
				while (!friends.nameExists(friend2)) {
					System.out.println("That name does not exist");
					System.out.println("Please enter the second friend");
					friend2 = stdin.next();
				}
				
				System.out.println(friends.ShortestPath(friend1, friend2));
			}
			
			if (option == '3') {
				ArrayList<Graph> temp = friends.cliques("rutgers");
				System.out.println("hi");
			}
		
		}
				
	}

}
	
