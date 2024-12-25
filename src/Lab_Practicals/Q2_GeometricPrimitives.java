package Lab_Practicals;

// Q2. Write a program to display basic 2D geometric primitives.

import Algorithms.Line;
import Base.Point;

import java.util.ArrayList;
import java.util.List;

// We define the basic 2D geometrics primitives as: points, lines, arcs, sectors & polygons.

public class Q2_GeometricPrimitives {

	//Arc Drawing Algorithm using parametric functions
	public static List<Point> Arc(double angle, int radius, Point startPoint) {

		//Calculating start & end angles
		double startAngle = Math.atan2(startPoint.y, startPoint.x);
		double endAngle = startAngle + Math.toRadians(angle);

		//Calculating the angle increment based on radius
		double angleIncrement = 1.0 / radius;

		//Initializing point list for the arc
		List<Point> Arc = new ArrayList<>();

		//Initializing loop variables
		double x, y, currentAngle = startAngle;

		//Generating arc coordinates
		while (currentAngle < endAngle) {
			x = radius * Math.cos(currentAngle);
			y = radius * Math.sin(currentAngle);
			Arc.add(new Point(x, y));
			currentAngle += angleIncrement;
		}
		//Adding the final point
		double endX = radius * Math.cos(endAngle);
		double endY = radius * Math.sin(endAngle);
		Arc.add(new Point(endX, endY));

		return Arc;
	}

	//Sector Drawing Method
	public static List<Point> Sector(double angle, int radius, Point startPoint) {

		//Initializing point list for the Sector with the arc
		List<Point> Sector = Arc(angle, radius, startPoint);

		//Calculating center & end point
		double startAngle = Math.atan2(startPoint.y, startPoint.x);
		double endAngle = startAngle + Math.toRadians(angle);

		Point centerPoint = new Point(0, 0);
		Point endPoint = new Point(radius * Math.cos(endAngle), radius * Math.sin(endAngle));

		//Adding the two radii to complete the Sector
		Sector.addAll(Line.Midpoint(startPoint, centerPoint));
		Sector.addAll(Line.Midpoint(endPoint, centerPoint));

		return Sector;
	}

	//Regular Polygon Drawing Algorithm
	public static List<Point> Polygon(int number_of_sides, int side_length) {

		//Calculating the radius of the circle circumscribing the polygon
		double radius = (side_length / (2 * Math.sin(Math.PI / number_of_sides)));

		//Initializing point list to store points generated
		List<Point> Polygon = new ArrayList<>();

		//Declaring vertex variables
		int[] vertex_X = new int[number_of_sides];
		int[] vertex_Y = new int[number_of_sides];

		//Generating vertex list
		for (int i = 0; i < number_of_sides; i++) {
			double vertex_angle = 2 * Math.PI * i / number_of_sides;
			vertex_X[i] = (int) Math.round(radius * Math.cos(vertex_angle));
			vertex_Y[i] = (int) Math.round(radius * Math.sin(vertex_angle));
		}

		//Generating the first n-1 sides for polygon
		for (int i = 0; i < number_of_sides - 1; i++) {
			Polygon.addAll(Line.Midpoint(new Point(vertex_X[i], vertex_Y[i]), new Point(vertex_X[i + 1], vertex_Y[i + 1])));
		}
		//Generating the nᵗʰ side for polygon
		Polygon.addAll(Line.Midpoint(new Point(vertex_X[number_of_sides - 1], vertex_Y[number_of_sides - 1]), new Point(vertex_X[0], vertex_Y[0])));

		return Polygon;
	}

	public static void main(String[] args) {
	}/*{
		Scanner scanner = new Scanner(System.in);
		Q2_GeometricPrimitives canvas = new Q2_GeometricPrimitives(40, 20);

		while (true) {
			System.out.println("\nGeometric Lab_Practicals.Primitives Drawing Program");
			System.out.println("1. Draw Base.Point");
			System.out.println("2. Draw Algorithms.Line");
			System.out.println("3. Draw Rectangle");
			System.out.println("4. Draw Algorithms.Circle");
			System.out.println("5. Clear Canvas");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();

			switch (choice) {
				case 1:
					System.out.print("Enter x coordinate: ");
					int pointX = scanner.nextInt();
					System.out.print("Enter y coordinate: ");
					int pointY = scanner.nextInt();
					canvas.drawPoint(pointX, pointY);
					break;

				case 2:
					System.out.print("Enter start x: ");
					int x0 = scanner.nextInt();
					System.out.print("Enter start y: ");
					int y0 = scanner.nextInt();
					System.out.print("Enter end x: ");
					int x1 = scanner.nextInt();
					System.out.print("Enter end y: ");
					int y1 = scanner.nextInt();
					canvas.drawLine(x0, y0, x1, y1);
					break;

				case 3:
					System.out.print("Enter top-left x: ");
					int rectX = scanner.nextInt();
					System.out.print("Enter top-left y: ");
					int rectY = scanner.nextInt();
					System.out.print("Enter width: ");
					int rectWidth = scanner.nextInt();
					System.out.print("Enter height: ");
					int rectHeight = scanner.nextInt();
					canvas.drawRectangle(rectX, rectY, rectWidth, rectHeight);
					break;

				case 4:
					System.out.print("Enter center x: ");
					int centerX = scanner.nextInt();
					System.out.print("Enter center y: ");
					int centerY = scanner.nextInt();
					System.out.print("Enter radius: ");
					int radius = scanner.nextInt();
					canvas.drawCircle(centerX, centerY, radius);
					break;

				case 5:
					canvas.clear();
					System.out.println("Canvas cleared.");
					break;

				case 6:
					System.out.println("Exiting program.");
					scanner.close();
					System.exit(0);

				default:
					System.out.println("Invalid choice. Try again.");
			}

			// Display the current state of the canvas
			canvas.display();
		}
	}*/

}