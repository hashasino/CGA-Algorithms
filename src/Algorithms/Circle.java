package Algorithms;

import Base.Point;
import java.util.ArrayList;
import java.util.List;

public class Circle { //Contains all Circle Drawing Algorithms

	//DDA Circle Drawing Algorithm (gives hexagons tho, not circles)
	public static List<Point> DDA(int radius) {

		//Finding epsilon
		int power = 0;
		while (Math.pow(2, power) <= radius) {
			power++;
		}
		double epsilon = Math.pow(2, -power);

		//Initializing point list for Circle
		List<Point> Circle = new ArrayList<>();

		//Initializing loop variables
		double x = 0;
		double y = radius;

		//Calculating the first octant
		while (x <= y) {
			Circle.add(new Point(x, y));
			x = x + y * epsilon;
			y = y - x * epsilon;
		}

		return Circle;
	}

	//Bresenham's Circle Drawing Algorithm
	public static List<Point> Bresenhams(int radius) {

		//Initializing point list for Circle
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

		return Circle;
	}

	//Midpoint Circle Drawing Algorithm
	public static List<Point> MidPoint(int radius) {

		//Initializing point list for Circle
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

		return Circle;
	}

	//Midpoint Ellipse Drawing Algorithm
	public static void Ellipse(int radiusOne, int radiusTwo) {

	}

}