package Lab_Practicals;

// Q1. Write a program for 2D line drawing as Raster Graphics Display.

import Base.Point;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Q1_LineDrawing_SimpleDDA {

	public static void main(String[] args) {

		//Initializing Scanner object
		Scanner scan = new Scanner(System.in);

		//Taking input for the parameters for the chosen algorithm
		System.out.println("This is a program for 2D line drawing as Raster Graphics Display using DDA Line Drawing Algorithm.");
		System.out.println("Input start & end coordinates in the following format: x1 y1 x2 y2");
		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		int x2 = scan.nextInt();
		int y2 = scan.nextInt();

		//Calculating line length
		int delX = x2 - x1;
		int delY = y2 - y1;
		int length = Math.max(Math.abs(delX), Math.abs(delY));

		// Calculating increment values
		double xIncrement = (double) delX / length;
		double yIncrement = (double) delY / length;

		//Initializing point list for Algorithms.Line
		List<Point> Line = new ArrayList<>();
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

		//Printing the Line coordinates
		for (Point point : Line) {
			System.out.print(point.getCoordinates() + ' ');
		}

		System.out.println();
		plotCoordinates(Line);
	}

	static void plotCoordinates(List<Point> Line) {

		//Setting initial min/max value
		double minX = Double.MAX_VALUE;
		double maxX = Double.MIN_VALUE;
		double minY = Double.MAX_VALUE;
		double maxY = Double.MIN_VALUE;

		//Finding min & max for x & y for all points in the list
		for (Point point : Line) {
			if (point.x < minX) minX = point.x;
			if (point.x > maxX) maxX = point.x;
			if (point.y < minY) minY = point.y;
			if (point.y > maxY) maxY = point.y;
		}

		// Calculating grid dimensions
		int width = (int) (maxX - minX + 1);
		int height = (int) (maxY - minY + 1);

		//Initializing grid/frame buffer
		String[][] grid = new String[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				grid[i][j] = ".";
			}
		}

		// Plotting coordinates
		for (Point point : Line) {
			int X = (int) (Math.round(point.x - minX) + 1);
			int Y = (int) (Math.round(point.y - minY) + 1);

			grid[X - 1][height - Y] = String.valueOf('*');
		}

		// Displaying coordinate grid
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				String cell = grid[i][j];
				System.out.printf("%3s", cell);
			}
			System.out.println();
		}
	}

}
