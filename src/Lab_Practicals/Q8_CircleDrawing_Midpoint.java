package Lab_Practicals;

// Q8. Write a program to draw a circle using Midpoint algorithm. Modify the same for drawing an arc and sector.

import Base.Point;
import Base.Plotter;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Q8_CircleDrawing_Midpoint { //TODO - Add methods to draw arc & sector
	public static void main(String[] args) {

		//Program Declaration
		System.out.println("This is a program to drawing a circle, an arc & a sector using Midpoint Circle Drawing Algorithm.");

		//Instantiating Scanner object
		Scanner scan = new Scanner(System.in);

		//Taking input for circle radius
		System.out.println("Enter radius for the circle: ");
		int radius = scan.nextInt();

		//Initializing point list to store points generated
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

		//Plotting the circle
		Plotter.plotObject(Circle, 'o');
	}
}
