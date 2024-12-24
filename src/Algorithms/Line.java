package Algorithms;

import Base.Point;

import java.util.List;
import java.util.ArrayList;

public class Line { //Contains all Line Drawing Algorithms

	//SimpleDDA Line Drawing Algorithm
	public static List<Point> SimpleDDA(Point startPoint, Point endPoint) {

		//Calculating line length
		double delX = endPoint.x - startPoint.x;
		double delY = endPoint.y - startPoint.y;
		double length = Math.max(Math.abs(delX), Math.abs(delY));

		// Calculating increment values
		double xIncrement = delX / length;
		double yIncrement = delY / length;

		//Initializing point list for Line
		List<Point> Line = new ArrayList<>();

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

		return Line;

	} //End Method

	//TODO - Generates extra points that are not on the line when slope is -1
	//SymmetricalDDA Line Drawing Algorithm
	public static List<Point> SymmetricalDDA(Point startPoint, Point endPoint) {

		//Calculating line length
		double delX = endPoint.x - startPoint.x;
		double delY = endPoint.y - startPoint.y;
		int power = 0;
		while (Math.pow(2, power) < Math.max(Math.abs(delX), Math.abs(delY))) {
			power++;
		}
		double length = Math.pow(2, power);

		// Calculating increment values
		double xIncrement = delX / length;
		double yIncrement = delY / length;

		//Initializing point list for Line
		List<Point> Line = new ArrayList<>();
		Line.add(new Point(startPoint.x, startPoint.y)); //Adding first point

		//Initializing loop variables
		double x = startPoint.x;
		double y = startPoint.y;
		Point prevPoint = new Point(x, y), newPoint;

		//Calculating line coordinates
		for (int i = 1; i <= length; i++) {

			x = startPoint.x + xIncrement * i;
			y = startPoint.y + yIncrement * i;

			newPoint = new Point(x, y);

			if (Math.round(newPoint.x) != Math.round(prevPoint.x) || Math.round(newPoint.y) != Math.round(prevPoint.y)) {
				Line.add(newPoint);
				prevPoint = newPoint;
			}
		}

		return Line;

	} //End Method

	//Bresenham's Line Drawing Algorithm
	public static List<Point> Bresenhams(Point startPoint, Point endPoint) {

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

		//Initializing decision parameter
		double decisionParameter = 2 * delY - delX;

		//Deciding increment sign+values (-1, 0, 1)
		int xIncrement = Double.compare(endPoint.x, startPoint.x);
		int yIncrement = Double.compare(endPoint.y, startPoint.y);

		//Initializing point list for Line
		List<Point> Line = new ArrayList<>();

		//Adding the first point to the point list
		if (isSteep) Line.add(new Point(startPoint.y, startPoint.x));
		else Line.add(new Point(startPoint.x, startPoint.y));

		//Initializing loop variables
		double x = startPoint.x;
		double y = startPoint.y;

		//Calculating line coordinates
		while (x != endPoint.x || y != endPoint.y) {
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

		return Line;

	} //End Method

	//Midpoint Line Drawing Algorithm
	public static List<Point> Midpoint(Point startPoint, Point endPoint) {

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

		//Initializing point list for Line
		List<Point> Line = new ArrayList<>();

		//Adding the first point to the point list
		if (isSteep) Line.add(new Point(startPoint.y, startPoint.x));
		else Line.add(new Point(startPoint.x, startPoint.y));

		//Initializing loop variables
		double x = startPoint.x;
		double y = startPoint.y;

		//Calculating line coordinates
		while (x != endPoint.x || y != endPoint.y) {
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

		return Line;

	} //End Method

}