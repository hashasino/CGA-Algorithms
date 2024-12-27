package Lab_Practicals;

// Q9. Write a program to rotate a point about origin.

import Base.Matrix;
import Base.Plotter;
import Base.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q9 {

	public static void main(String[] args) {

		//Program Declaration
		System.out.println("This is a program to rotate a point about origin.");

		//Instantiating Scanner object
		Scanner scan = new Scanner(System.in);

		//Instantiating Plotter object
		Plotter plotObj = new Plotter(20, 20);

		List<Point> originalPoint = new ArrayList<>();
		System.out.println("- Enter point coordinates: x y ");
		originalPoint.add(new Point(scan.nextInt(), scan.nextInt()));

		System.out.println("- Enter rotation angle: (in degrees) ");
		int rotationAngle = scan.nextInt();
		List<Point> rotatedPoint = Rotate(originalPoint, rotationAngle);
		rotatedPoint.addAll(Rotate(originalPoint, 45 + rotationAngle));
		rotatedPoint.addAll(Rotate(originalPoint, 90 + rotationAngle));
		rotatedPoint.addAll(Rotate(originalPoint, 180 + rotationAngle));
		rotatedPoint.addAll(Rotate(originalPoint, 225 + rotationAngle));
		rotatedPoint.addAll(Rotate(originalPoint, 270 + rotationAngle));
		rotatedPoint.addAll(Rotate(originalPoint, 315 + rotationAngle));

		plotObj.WorldPlotObject(originalPoint, 'x');
		plotObj.WorldPlotObject(rotatedPoint, 'o');
		plotObj.WorldDisplay();
	}

	public static List<Point> Rotate(List<Point> Object, double rotationAngle) {
		List<Point> rotatedObject = new ArrayList<>();
		double[][] rotationMatrix = {{Math.cos(rotationAngle), -Math.sin(rotationAngle), 0}, {Math.sin(rotationAngle), Math.cos(rotationAngle), 0}, {0, 0, 1}};
		for (Point point : Object) {
			double[][] originalPoint = {{point.x}, {point.y}, {point.z}};
			double[][] rotatedPoint = Matrix.multiply(rotationMatrix, originalPoint);
			rotatedObject.add(new Point(rotatedPoint[0][0], rotatedPoint[1][0]));
		}
		return rotatedObject;
	}

}