package Lab_Practicals;

// Q11. Write a program to scale the triangle using 2D transformation.

import Base.Matrix;
import Base.Point;

import java.util.ArrayList;
import java.util.List;

public class Q11 {

	public static List<Point> Scale(List<Point> Object, double xScale, double yScale) {
		List<Point> scaledObject = new ArrayList<>();
		double[][] scaleMatrix = {{xScale, 0, 0}, {0, yScale, 0}, {0, 0, 1}};
		for (Point point : Object) {
			double[][] originalPoint = {{point.x}, {point.y}, {point.z}};
			double[][] scaledPoint = Matrix.multiply(scaleMatrix, originalPoint);
			scaledObject.add(new Point(scaledPoint[0][0], scaledPoint[1][0]));
		}
		return scaledObject;
	}

}
