package Algorithms; //Contains all Algorithms.Circle Drawing Algorithms

import Base.Plotter;
import Base.Point;
import java.util.ArrayList;
import java.util.List;

public class Circle {

	//DDA Algorithms.Circle Drawing Algorithm (gives hexagons tho, not circles)
	public void DDA(int radius) {

		//Finding epsilon
		int power = 0;
		while (Math.pow(2, power) <= radius) {
			power++;
		}
		double epsilon = Math.pow(2, -power);

		//Initializing point list for Algorithms.Circle
		List<Point> Circle = new ArrayList<>();

		//Initializing loop variables
		double x = 0;
		double y = radius;

		//Calculating the first octant
		while (x <= y) {
			Circle.add(new Point(x, y));
			x = x + Math.round(y * epsilon);
			y = y - Math.round(x * epsilon);
		}

		//Plotting the Algorithms.Circle using the coordinates calculated
		Plotter plotObj = new Plotter();
		plotObj.printCoordinates(Circle, radius);
		System.out.println();
		plotObj.plotCoordinates(Circle, radius);
	}

	//Bresenham's Algorithms.Circle Drawing Algorithm
	public void Bresenhams(int radius) {

		//Initializing point list for Algorithms.Circle
		List<Point> Circle = new ArrayList<>();

		//Initializing loop variables
		int x = 0;
		int y = radius;
		int decisionParameter = 3 - 2 * radius;

		//Calculating the first octant
		while (x <= y) {
			Circle.add(new Point(x, y));
			x++;
			if (decisionParameter < 0) {
				decisionParameter += 4 * x + 6;
			} else {
				y--;
				decisionParameter += 4 * (x - y) + 10;
			}
		}

		//Plotting the Algorithms.Circle using the coordinates calculated
		Plotter plotObj = new Plotter();
		plotObj.printCoordinates(Circle, radius);
		System.out.println();
		plotObj.plotCoordinates(Circle, radius);

	}

	//Midpoint Algorithms.Circle Drawing Algorithm
	public void MidPoint(int radius) {

		//Initializing point list for Algorithms.Circle
		List<Point> Circle = new ArrayList<>();

		//Initializing loop variables
		int x = 0;
		int y = radius;
		int decisionParameter = 3 - 2 * radius;

		//Calculating the first octant
		while (x <= y) {
			Circle.add(new Point(x, y));
			x++;
			if (decisionParameter < 0) {
				decisionParameter += 2 * x + 1;
			} else {
				y--;
				decisionParameter += 2 * (x - y) + 1;
			}
		}

		//Plotting the Algorithms.Circle using the coordinates calculated
		Plotter plotObj = new Plotter();
		plotObj.printCoordinates(Circle, radius);
		System.out.println();
		plotObj.plotCoordinates(Circle, radius);

	}

	//Midpoint Ellipse Drawing Algorithm
	public void Ellipse(int radiusOne, int radiusTwo) {

	}
}