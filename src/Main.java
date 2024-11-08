import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		LineDDA newLine = new LineDDA();
		boolean condition = true;
		int choice = 0;

		System.out.println("\nChoose an algorithm:");
		System.out.println("  1. Simple DDA");
		System.out.println("  2. Symmetrical DDA");
		System.out.println("  0. Exit program");

		while (condition) {

			choice = scan.nextInt();

			switch (choice) {
				case 1:
					System.out.println("Algorithm: Simple DDA");
					condition = false;
					break;
				case 2:
					System.out.println("Algorithm: Symmetrical DDA");
					condition = false;
					break;
				case 0:
					return;
				default:
					System.out.println("Invalid input. Try again.");
			}
		}

		System.out.println("Input coordinates in the following format: x1 y1 x2 y2");
		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		int x2 = scan.nextInt();
		int y2 = scan.nextInt();

		System.out.println("  Line coordinates:");
		switch (choice) {
			case 1:
				newLine.SimpleDDA(x1, y1, x2, y2);
				break;
			case 2:
				newLine.SymmetricalDDA(x1, y1, x2, y2);
				break;
		}
	}
}
