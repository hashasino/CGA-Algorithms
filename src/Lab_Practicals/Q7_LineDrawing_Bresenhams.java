package Lab_Practicals;

// Q7. Write a program to draw a line using Bresenham line drawing algorithm.

import Base.Point;
import Base.Plotter;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Q7_LineDrawing_Bresenhams {
	public static void main(String[] args) {

		//Program Declaration
		System.out.println("This is a program for 2D line drawing as Raster Graphics Display using Bresenham's Line Drawing Algorithm.");

		//Initializing Scanner object
		Scanner scan = new Scanner(System.in);

		//Taking input for the parameters for the chosen algorithm
		System.out.println("Input start & end coordinates in the following format: x1 y1 x2 y2");
		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		int x2 = scan.nextInt();
		int y2 = scan.nextInt();

		//Initializing point list to store points generated
		List<Point> Line = new ArrayList<>();

		//Drawing the line
		{
			//Calculating delX & delY
			int delX = Math.abs(x2 - x1);
			int delY = Math.abs(y2 - y1);

			// Swapping x and y for steep slopes
			boolean isSteep = delY > delX;
			if (isSteep) {
				int temp = x1;
				x1 = y1;
				y1 = temp;

				temp = x2;
				x2 = y2;
				y2 = temp;

				delX = Math.abs(x2 - x1);
				delY = Math.abs(y2 - y1);
			}

			//Initializing decision parameter
			int decisionParameter = 2 * delY - delX;

			//Deciding increment sign+values (-1, 0, 1)
			int xIncrement = Integer.compare(x2, x1);
			int yIncrement = Integer.compare(y2, y1);

			//Adding the first point to the point list
			if (isSteep) Line.add(new Point(y1, x1));
			else Line.add(new Point(x1, y1));

			//Initializing loop variables
			double x = x1;
			double y = y1;

			//Calculating line coordinates
			while (x != x2 || y != y2) {
				x = x + xIncrement;
				if (decisionParameter < 0) {
					decisionParameter += 2 * delY;
				} else {
					y = y + yIncrement;
					decisionParameter += 2 * (delY - delX);
				}
				if (isSteep) Line.add(new Point(y, x));
				else Line.add(new Point(x, y));
			}
		}

		//Plotting the line
		Plotter.printLine(Line);
		System.out.println();
		Plotter.plotLine(Line, '*');
	}
}
