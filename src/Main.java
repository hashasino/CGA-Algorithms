import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		//Initializing Scanner object
		Scanner scan = new Scanner(System.in);

		//Initializing LineDDA object
		LineDDA newLine = new LineDDA();

		//Initializing Circle object
		Circle newCircle = new Circle();

		//Initializing condition variables
		boolean condition = true;
		int choice = 0;

		//Displaying Algo choice menu
		System.out.println("\nChoose an algorithm:");
		System.out.println("  1. Simple DDA");
		System.out.println("  2. Symmetrical DDA");
		System.out.println("  3. Circle DDA");
		System.out.println("  4. Circle Bresenham");
		System.out.println("  5. Circle Mid Point");
		System.out.println("  0. Exit program");

		//Taking input to decide choice of algorithm
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
				case 3:
					System.out.println("Algorithm: Circle DDA");
					condition = false;
					break;
				case 4:
					System.out.println("Algorithm: Circle Bresenham");
					condition = false;
					break;
				case 5:
					System.out.println("Algorithm: Circle Mid Point");
					condition = false;
					break;
				case 0:
					return;
				default:
					System.out.println("Invalid input. Try again.");
			}
		}

		//Taking input for the parameters for the chosen algorithm
		System.out.println("Input coordinates in the following format: x1 y1 x2 y2");
		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		int x2 = scan.nextInt();
		int y2 = scan.nextInt();

		//Executing chosen algorithm
		System.out.println("  Line coordinates:");
		switch (choice) {
			case 1:
				newLine.SimpleDDA(x1, y1, x2, y2);
				break;
			case 2:
				newLine.SymmetricalDDA(x1, y1, x2, y2);
				break;
			case 3:
				newCircle.DDA(x1);
				break;
			case 4:
				newCircle.Bresenham(x1);
				break;
			case 5:
				newCircle.MidPoint(x1);
				break;
		}
	}
}
