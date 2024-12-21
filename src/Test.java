import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		//Creating a list of start & end coordinate pairs, covering all the possible slope values
		int[][] start = {{-5, 0}, {-5, 5}, {0, 5}, {5, 5}, {5, 0}, {5, -5}, {0, -5}, {-5, -5}};
		int[][] end = {{5, 0}, {5, -5}, {0, -5}, {-5, -5}, {-5, 0}, {-5, 5}, {0, 5}, {5, 5}};

		//Instantiating a Scanner object to control output display for each coordinate pair step-by-step
		Scanner scan = new Scanner(System.in);

		//Instantiating a LineDDA object to access required algorithms
		Line newLine = new Line();

		//Running the test
		for (int i = 0; i < 8; i++) {

			//Assigning current coordinate pair values
			int x1 = start[i][0];
			int y1 = start[i][1];
			int x2 = end[i][0];
			int y2 = end[i][1];

			//Displaying current coordinate pair
			System.out.println("\n" + i + ". Start(" + x1 + "," + y1 + ") | End(" + x2 + "," + y2 + ")");
			System.out.println();

			//Calculating coordinates using SimpleDDA
			System.out.println("SimpleDDA");
			newLine.SimpleDDA(x1, y1, x2, y2);

			//Calculating coordinates using SymmetricalDDA
			System.out.println("SymmetricalDDA");
			newLine.SymmetricalDDA(x1, y1, x2, y2);

			//Calculating coordinates using Bresenham's
			System.out.println("Bresenhams");
			newLine.Bresenhams(x1, y1, x2, y2);

			//Calculating coordinates using Midpoint
			System.out.println("Midpoint");
			newLine.Midpoint(x1, y1, x2, y2);

			scan.nextLine(); //Waiting for user input to move on to the next iteration/coordinate pair
		}
	}
}
