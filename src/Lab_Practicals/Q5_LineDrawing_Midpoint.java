package Lab_Practicals;

// Q5. Write a program for line drawing as Raster Graphics Display.

import Base.Point;
import Base.Plotter;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Q5_LineDrawing_Midpoint {

	public static void main(String[] args) {

		//Program Declaration
		System.out.println("This is a program for 2D line drawing as Raster Graphics Display using Midpoint Line Drawing Algorithm.");

		//Initializing Scanner object
		Scanner scan = new Scanner(System.in);

		//Taking input for the parameters for the chosen algorithm
		System.out.println("Input start & end coordinates in the following format: x1 y1 x2 y2");
		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		int x2 = scan.nextInt();
		int y2 = scan.nextInt();

		//Calculating delX & delY
		int delX = Math.abs(x2 - x1);
		int delY = Math.abs(y2 - y1);

		//Initializing the decision parameter
		int decisionParameter = delY - (delX / 2);

		//Deciding increment sign+values (-1, 0, 1)
		int xIncrement = Integer.compare(x2, x1);
		int yIncrement = Integer.compare(y2, y1);

		//Initializing point list for Algorithms.Line
		List<Point> Line = new ArrayList<>();
		Line.add(new Point(x1, y1)); //Adding starting point

		//Initializing loop variables
		double x = x1;
		double y = y1;

		//Calculating line coordinates
		while (x != x2 || y != y2) {
			x = x + xIncrement;
			if (decisionParameter < 0) {
				decisionParameter += delY;
			} else {
				y = y + yIncrement;
				decisionParameter += (delY - delX);
			}
			Line.add(new Point(x, y));
		}

		//Plotting the line using the coordinates calculated
		Plotter plotObj = new Plotter();
		plotObj.printLine(Line);
		System.out.println();
		plotObj.plotLine(Line, '*');
	}
}