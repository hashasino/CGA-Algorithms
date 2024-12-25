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
		System.out.println("- Input start & end coordinates in the following format: x1 y1 x2 y2");
		Point startPoint = new Point(scan.nextInt(), scan.nextInt());
		Point endPoint = new Point(scan.nextInt(), scan.nextInt());

		//Initializing point list to store points to be generated
		List<Point> Line = new ArrayList<>();

		//Calculating line length
		double delX = endPoint.x - startPoint.x;
		double delY = endPoint.y - startPoint.y;
		double length = Math.max(Math.abs(delX), Math.abs(delY));

		// Calculating increment values
		double xIncrement = delX / length;
		double yIncrement = delY / length;

		//Initializing loop variables
		double x = startPoint.x;
		double y = startPoint.y;
		Line.add(new Point(x, y)); //Adding starting point

		//Calculating line coordinates
		for (int i = 0; i < length; i++) {
			x = x + xIncrement;
			y = y + yIncrement;
			Line.add(new Point(x, y));
		}

		//Plotting the line
		Plotter.printObject(Line);
		System.out.println();
		Plotter.plotObject(Line, 'o');
	}

}