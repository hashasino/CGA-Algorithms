package Lab_Practicals;

// Q6. Write a program for circle drawing as Raster Graphics Display.

import Base.Plotter;
import Base.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q6_CircleDrawing_DDA {
	public static void main(String[] args) {

		//Program Declaration
		System.out.println("This is a program to display a series of concentric circles of varying radius using DDA Circle Drawing Algorithm.");

		//Instantiating Scanner object
		Scanner scan = new Scanner(System.in);

		//Taking input for circle radius
		System.out.println("Enter radius for the circle: ");
		int radius = scan.nextInt();

		//Initializing point list to store points generated
		List<Point> Circle = new ArrayList<>();

		//Instantiating Plotter object
		Plotter plotObj = new Plotter(radius * 2 + 1, radius * 2 + 1);

		//Finding epsilon
		int power = 0;
		while (Math.pow(2, power) <= radius) {
			power++;
		}
		double epsilon = Math.pow(2, -power);

		//Initializing loop variables
		double x = 0;
		double y = radius;

		//Calculating the first octant
		while (x <= y) {
			Circle.add(new Point(x, y));
			x = x + y * epsilon;
			y = y - x * epsilon;
		}

		//Plotting the circle
		plotObj.plotCircle(Circle, radius, 'o');
	}
}
