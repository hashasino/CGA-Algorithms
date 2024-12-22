package Algorithms; //Contains all line drawing algorithms

import Base.Point;
import Base.Plotter;
import java.util.List;
import java.util.ArrayList;

public class Line {

	//SimpleDDA Algorithms.Line Drawing Algorithm
	public void SimpleDDA(int x1, int y1, int x2, int y2) {

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

		//Plotting the line using the coordinates calculated
		printCoordinates(Line);
		System.out.println();
		plotCoordinates(Line);

	} //End Method

	//TODO - Generates extra points that are not on the line when slope is -1.
	//SymmetricalDDA Algorithms.Line Drawing Algorithm
	public void SymmetricalDDA(int x1, int y1, int x2, int y2) {

		//Calculating line length
		int delX = x2 - x1;
		int delY = y2 - y1;
		int power = 0;
		while (Math.pow(2, power) < Math.max(Math.abs(delX), Math.abs(delY))) {
			power++;
		}
		int length = (int) Math.pow(2, power);

		// Calculating increment values
		double xIncrement = (double) delX / length;
		double yIncrement = (double) delY / length;

		//Initializing point list for Algorithms.Line
		List<Point> Line = new ArrayList<>();
		Line.add(new Point(x1, y1)); //Adding first point

		//Initializing loop variables
		double x = x1;
		double y = y1;
		Point prevPoint = new Point(x, y), newPoint;

		//Calculating line coordinates
		for (int i = 1; i <= length; i++) {

			x = x1 + xIncrement * i;
			y = y1 + yIncrement * i;

			newPoint = new Point(x, y);

			if (Math.round(newPoint.x) != Math.round(prevPoint.x) ||
					Math.round(newPoint.y) != Math.round(prevPoint.y)) {
				Line.add(newPoint);
				prevPoint = newPoint;
			}
		}

		//Plotting the line using the coordinates calculated
		printCoordinates(Line);
		System.out.println();
		plotCoordinates(Line);

	} //End Method

	//Bresenham's Algorithms.Line Drawing Algorithm
	public void Bresenhams(int x1, int y1, int x2, int y2) {

		//Calculating delX & delY
		int delX = Math.abs(x2 - x1);
		int delY = Math.abs(y2 - y1);

		//Initializing decision parameter
		int decisionParameter = 2 * delY - delX;

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
				decisionParameter += 2 * delY;
			} else {
				y = y + yIncrement;
				decisionParameter += 2 * (delY - delX);
			}
			Line.add(new Point(x, y));
		}

		//Plotting the line using the coordinates calculated
		printCoordinates(Line);
		System.out.println();
		plotCoordinates(Line);

	} //End Method

	//Midpoint Algorithms.Line Drawing Algorithm
	public void Midpoint(int x1, int y1, int x2, int y2) {

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
		printCoordinates(Line);
		System.out.println();
		plotCoordinates(Line);

	} //End Method

	//To print the coordinates calculated
	void printCoordinates(List<Point> Line) {
		for (Point point : Line) {
			System.out.print(point.getCoordinates() + ' ');
		}
	}

	//To plot the coordinates calculated
	void plotCoordinates(List<Point> Line) {

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
		Plotter plotObj = new Plotter();
		String[][] grid = plotObj.ObjectCoordinates(width, height);

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