package Algorithms; //Contains all Algorithms.Circle Drawing Algorithms

import Base.Point;
import Base.Plotter;
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

		//Plotting the Circle using the coordinates calculated
		printCoordinates(Circle);
		System.out.println();
		plotCoordinates(Circle, radius);
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

		//Plotting the Circle using the coordinates calculated
		printCoordinates(Circle);
		System.out.println();
		plotCoordinates(Circle, radius);

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

		//Plotting the Circle using the coordinates calculated
		printCoordinates(Circle);
		System.out.println();
		plotCoordinates(Circle, radius);

	}

	//Midpoint Ellipse Drawing Algorithm
	public void Ellipse(int radiusOne, int radiusTwo) {

	}

	//To print the coordinates calculated
	public void printCoordinates(List<Point> Circle) {

		for (Point point : Circle) {
			System.out.print("(" + point.x + "," + point.y + ") ");
			System.out.print("(" + point.y + "," + point.x + ") ");
			System.out.print("(" + point.y + "," + -point.x + ") ");
			System.out.print("(" + point.x + "," + -point.y + ") ");
			System.out.print("(" + -point.x + "," + -point.y + ") ");
			System.out.print("(" + -point.y + "," + -point.x + ") ");
			System.out.print("(" + -point.y + "," + point.x + ") ");
			System.out.print("(" + -point.x + "," + point.y + ") ");
			System.out.println();
		}
	}

	//To plot the coordinates calculated
	public void plotCoordinates(List<Point> Circle, int radius) {

		int diameter = 2 * radius;

		//Initializing grid/frame buffer
		Plotter plotObj = new Plotter();
		String[][] grid = plotObj.ObjectCoordinates(diameter + 1, diameter + 1);

		// Plotting coordinates
		for (Point point : Circle) {
			int X = (int) (Math.round(point.x));
			int Y = (int) (Math.round(point.y));
			grid[radius + X][radius - Y] = String.valueOf('*');
			grid[radius + Y][radius - X] = String.valueOf('*');
			grid[radius + Y][radius + X] = String.valueOf('*');
			grid[radius + X][radius + Y] = String.valueOf('*');
			grid[radius - X][radius + Y] = String.valueOf('*');
			grid[radius - Y][radius + X] = String.valueOf('*');
			grid[radius - Y][radius - X] = String.valueOf('*');
			grid[radius - X][radius - Y] = String.valueOf('*');
		}

		// Displaying coordinate grid
		for (int j = 0; j <= diameter; j++) {
			for (int i = 0; i <= diameter; i++) {
				String cell = grid[i][j];
				System.out.printf("%3s", cell);
			}
			System.out.println();
		}

	}


}