import java.io.IOException;
import java.util.Scanner;

public class friends {
static Scanner stdin = new Scanner(System.in);
	
	static char getOption() {
		System.out.println("\tWhat would you like to do?");
		System.out.println("(1) List all the students at a particular university");
		System.out.println("(2) Shortest Intro Chain");
		System.out.println("(3) Cliques");
		System.out.println("(4) Connectors");
		System.out.println("(5) Quit");
		String check = stdin.next();
		char response = check.charAt(0);
		while ((response != '1' && response != '2' && response != '3' && response != '4' && response != '5') || check.length() > 1) {
			System.out.print("\tPlease enter '1', '2', '3', '4' or '5': ");
			check = stdin.next();
			response = check.charAt(0);
		}
		return response;
	}
	
	public static void main(String[] args) 
			throws IOException {
		
		System.out.print("Enter HTML file name => ");
		String htmlFile = stdin.next();
		
		Graph friends = new Graph();
		
		char option;
		while ((option = getOption()) != 'q') {
		
			System.out.println("Test");
		
		}		
	}
}
