package Lab_Practicals;

// Q1. Write a program for 2D line drawing as Raster Graphics Display.

import Base.Point;
import Base.Plotter;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Q1_LineDrawing_SimpleDDA {
	public static void main(String[] args) {

		//Program Declaration
		System.out.println("This is a program for 2D line drawing as Raster Graphics Display using DDA Line Drawing Algorithm.");

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

		//Instantiating Plotter object
		Plotter plotObj = new Plotter();

		//Drawing the line
		{
			//Calculating line length
			int delX = x2 - x1;
			int delY = y2 - y1;
			int length = Math.max(Math.abs(delX), Math.abs(delY));

			// Calculating increment values
			double xIncrement = (double) delX / length;
			double yIncrement = (double) delY / length;

			Line.add(new Point(x1, y1)); //Adding starting point

			//Initializing loop variables
			double x = x1;
			double y = y1;

			//Calculating line coordinates
			for (int i = 0; i < length; i++) {
				x = x + xIncrement;
				y = y + yIncrement;
				Line.add(new Point(x, y));
			}
		}

		//Plotting the line
		plotObj.printLine(Line);
		System.out.println();
		plotObj.plotLine(Line, 'o');
	}

}