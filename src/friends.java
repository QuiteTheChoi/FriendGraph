import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class friends {
static Scanner stdin = new Scanner(System.in);
	
	static char getOption() {
		System.out.println("\tWhat would you like to do?");
		System.out.println("(1) List all the students at a particular university");
		System.out.println("(2) Shortest Intro Chain");
		System.out.println("(3) Cliques");
		System.out.println("(4) Connectors");
		System.out.println("(5) Quit");
		char response = stdin.next().toLowerCase().charAt(0);
		while (response != 'p' && response != 'r' && response != 'b' && response != 'd' && response != 'a' && response != 'q') {
			System.out.print("\tYou must enter one of p, r, b, d, a, or q => ");
			response = stdin.next().toLowerCase().charAt(0);
		}
		return response;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
