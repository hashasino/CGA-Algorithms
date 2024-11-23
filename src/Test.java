import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		//Creating a list of start & end coordinate pairs, covering all the possible slope values
		int[][] start = {{-5, 0}, {-5, 5}, {0, 5}, {5, 5}, {5, 0}, {5, -5}, {0, -5}, {-5, -5}};
		int[][] end = {{5, 0}, {5, -5}, {0, -5}, {-5, -5}, {-5, 0}, {-5, 5}, {0, 5}, {5, 5}};

		//Instantiating a Scanner object to control output display for each coordinate pair step-by-step
		Scanner scan = new Scanner(System.in);

		//Instantiating a LineDDA object to access required algorithms
		LineDDA newLine = new LineDDA();

		//for while the counter is less than 8 i.e. the number of coordinate pairs
		for (int i = 0; i < 8; i++) {

			//assign current start & end x & y values
			int x1 = start[i][0];
			int y1 = start[i][1];
			int x2 = end[i][0];
			int y2 = end[i][1];

			//display current start & end coordinates
			System.out.println("\n" + i + ". Start(" + x1 + "," + y1 + ") | End(" + x2 + "," + y2 + ")");
			System.out.println();

			//calculate coordinates using SimpleDDA
			newLine.SimpleDDA(x1, y1, x2, y2);
			System.out.println();

			//calculate coordinates using SymmetricalDDA
			newLine.SymmetricalDDA(x1, y1, x2, y2);

			scan.nextLine(); //wait for user input to move on to the next coordinate pair
		}
	}
}
