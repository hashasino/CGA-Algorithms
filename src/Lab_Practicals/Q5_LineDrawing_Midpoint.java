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
		System.out.println("- Input start & end coordinates in the following format: x1 y1 x2 y2");
		Point startPoint = new Point(scan.nextInt(), scan.nextInt());
		Point endPoint = new Point(scan.nextInt(), scan.nextInt());

		//Initializing point list to store points generated
		List<Point> Line = new ArrayList<>();

		//Calculating delX & delY
		double delX = Math.abs(endPoint.x - startPoint.x);
		double delY = Math.abs(endPoint.y - startPoint.y);
		boolean isSteep = delY > delX; //Swapping x and y for steep slopes
		if (isSteep) {
			double temp = startPoint.x;
			startPoint.x = startPoint.y;
			startPoint.y = temp;

			temp = endPoint.x;
			endPoint.x = endPoint.y;
			endPoint.y = temp;

			delX = Math.abs(endPoint.x - startPoint.x);
			delY = Math.abs(endPoint.y - startPoint.y);
		}

		//Initializing the decision parameter
		double decisionParameter = delY - (delX / 2);

		//Deciding increment sign+values (-1, 0, 1)
		int xIncrement = Double.compare(endPoint.x, startPoint.x);
		int yIncrement = Double.compare(endPoint.y, startPoint.y);

		//Adding the first point to the point list
		if (isSteep) Line.add(new Point(startPoint.y, startPoint.x));
		else Line.add(new Point(startPoint.x, startPoint.y));

		//Initializing loop variables
		double x = startPoint.x;
		double y = startPoint.y;
		endPoint.x = Math.round(endPoint.x);
		endPoint.y = Math.round(endPoint.y);

		//Calculating line coordinates
		while ((int) x != endPoint.x || (int) y != endPoint.y) {
			x = x + xIncrement;
			if (decisionParameter < 0) {
				decisionParameter += delY;
			} else {
				y = y + yIncrement;
				decisionParameter += (delY - delX);
			}
			if (isSteep) Line.add(new Point(y, x));
			else Line.add(new Point(x, y));
		}

		//Plotting the line
		Plotter.printObject(Line);
		System.out.println();
		Plotter.plotObject(Line, '*');
	}
}