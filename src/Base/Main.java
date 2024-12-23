package Base;

import Algorithms.*;
import java.util.Scanner;

class Main { //The Main Program Interface
	public static void main(String[] args) {

		//Initializing Scanner object
		Scanner scan = new Scanner(System.in);

		//Initializing condition variables
		boolean condition = true;
		int choice = 0;

		//Starting program loop
		do {
			System.out.println("\nChoose an algorithm:");
			System.out.println("  1. Line, Simple DDA");
			System.out.println("  2. Line, Symmetrical DDA");
			System.out.println("  3. Line, Bresenham's");
			System.out.println("  4. Circle, DDA");
			System.out.println("  5. Circle, Bresenham's");
			System.out.println("  6. Circle, Mid Base.Point");
			System.out.println("  0. Exit program");

			//Taking input to decide choice of algorithm
			while (condition) {

				choice = scan.nextInt();

				switch (choice) {
					case 1:
						System.out.println("Algorithm: Line, Simple DDA");
						condition = false;
						break;
					case 2:
						System.out.println("Algorithm: Line, Symmetrical DDA");
						condition = false;
						break;
					case 3:
						System.out.println("Algorithm: Line, Bresenham's");
						condition = false;
						break;
					case 4:
						System.out.println("Algorithm: Circle, DDA");
						condition = false;
						break;
					case 5:
						System.out.println("Algorithm: Circle, Bresenham's");
						condition = false;
						break;
					case 6:
						System.out.println("Algorithm: Circle, Mid Base.Point");
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
					Line.SimpleDDA(x1, y1, x2, y2);
					break;
				case 2:
					Line.SymmetricalDDA(x1, y1, x2, y2);
					break;
				case 3:
					Line.Bresenhams(x1, y1, x2, y2);
					break;
				case 4:
					Circle.DDA(x1);
					break;
				case 5:
					Circle.Bresenhams(x1);
					break;
				case 6:
					Circle.MidPoint(x1);
					break;
			}

			scan.nextLine();
			condition = true;
			scan.nextLine();

		} while (true);
	}
}