import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

//		Test.LineDrawingAlgorithms();

		Test.CircleDrawingAlgorithms();
	}

	static void LineDrawingAlgorithms() {

		//Creating a list of start & end coordinate pairs, covering all the possible slope values
		int[][] start = {{-5, 0}, {-5, 5}, {0, 5}, {5, 5}, {5, 0}, {5, -5}, {0, -5}, {-5, -5}};
		int[][] end = {{5, 0}, {5, -5}, {0, -5}, {-5, -5}, {-5, 0}, {-5, 5}, {0, 5}, {5, 5}};

		//Instantiating a Scanner object to control output display for each coordinate pair step-by-step
		Scanner scan = new Scanner(System.in);

		//Instantiating a Line object to access required algorithms
		Line newLine = new Line();

		//Initiating test loop
		for (int i = 0; i < 8; i++) {

			//Assigning current coordinate pair values
			int x1 = start[i][0];
			int y1 = start[i][1];
			int x2 = end[i][0];
			int y2 = end[i][1];

			//Displaying current coordinate pair
			System.out.println("\n" + i + ". Start(" + x1 + "," + y1 + ") | End(" + x2 + "," + y2 + ")");
			System.out.println();

			//Calculating line using SimpleDDA
			System.out.println("SimpleDDA");
			newLine.SimpleDDA(x1, y1, x2, y2);

			//Calculating line using SymmetricalDDA
			System.out.println("SymmetricalDDA");
			newLine.SymmetricalDDA(x1, y1, x2, y2);

			//Calculating line using Bresenham's
			System.out.println("Bresenhams");
			newLine.Bresenhams(x1, y1, x2, y2);

			//Calculating line using Midpoint
			System.out.println("Midpoint");
			newLine.Midpoint(x1, y1, x2, y2);

			scan.nextLine(); //Waiting for user input to move on to the next iteration/coordinate pair
		}
	}

	static void CircleDrawingAlgorithms() {

		//Creating a list of radii to test
		int[] radii = {7, 14, 21};

		//Instantiating a Scanner object to control output display for each coordinate pair step-by-step
		Scanner scan = new Scanner(System.in);

		//Instantiating a Circle object to access required algorithms
		Circle newCircle = new Circle();

		//Initiating test loop
		for (int i = 0; i < 3; i++) {

			//Assigning current radius
			int radius = radii[i];

			//Displaying current radius
			System.out.println("\n" + i + ". Radius = " + radius);
			System.out.println();

			//Calculating line using DDA
			System.out.println("DDA");
			newCircle.DDA(radius);

			//Calculating line using Bresenham's
			System.out.println("Bresenhams");
//			newCircle.Bresenhams(radius);

			//Calculating line using Midpoint
			System.out.println("Midpoint");
//			newCircle.MidPoint(radius);

			scan.nextLine(); //Waiting for user input to move on to the next iteration/coordinate pair
		}
	}

}

