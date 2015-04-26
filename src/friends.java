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
			System.out.print("\tPlease enter '1', '2', '3', or '4': ");
			check = stdin.next();
			response = check.charAt(0);
		}
		return response;
	}
	
	public static void main(String[] args) throws IOException {
		
		System.out.print("Enter Friendship Graph file: ");
		String graphFile = stdin.next();
		
		while (true) {
			try {
				System.out.print("Please enter Friendship Graph file: ");
				String graphFile = stdin.next();
				Graph friends = new Graph(graphFile);
		
		
		char option;
		
		while ((option = getOption()) != '5') {
			//System.out.println(friends);
			if (option == '2') {
				try {
				System.out.println(friends.ShortestPath("sam", "aparna"));
				}
				catch (Exception e){
					System.out.println("Test error");
				}
				
			}
			
			if (option == '3') {
				ArrayList<Graph> temp = friends.cliques("rutgers");
				System.out.println("hi");
			}
		
		}
				
	}

}
