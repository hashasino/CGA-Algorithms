package Lab_Practicals;

// Q13. Write a program to reflect a triangle 2D transformation.

import Base.Matrix;
import Base.Point;

import java.util.ArrayList;
import java.util.List;

public class Q13 {

	public static List<Point> Reflect(List<Point> Object, double xReflect, double yReflect) {
		List<Point> reflectedObject = new ArrayList<>();
		double[][] reflectionMatrix = {{xReflect, 0, 0}, {0, yReflect, 0}, {0, 0, 1}};
		for (Point point : Object) {
			double[][] originalPoint = {{point.x}, {point.y}, {point.z}};
			double[][] reflectedPoint = Matrix.multiply(reflectionMatrix, originalPoint);
			reflectedObject.add(new Point(reflectedPoint[0][0], reflectedPoint[1][0]));
		}
		return reflectedObject;
	}

}
