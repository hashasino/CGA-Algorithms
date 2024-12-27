package Lab_Practicals;

// Q12. Write a program to translate a triangle using 2D transformation.

import Base.Matrix;
import Base.Point;

import java.util.ArrayList;
import java.util.List;

public class Q12 {

	public static List<Point> Translate(List<Point> Object, double xTranslate, double yTranslate) {
		List<Point> translatedObject = new ArrayList<>();
		double[][] translationMatrix = {{1, 0, xTranslate}, {0, 1, yTranslate}, {0, 0, 1}};
		for (Point point : Object) {
			double[][] originalPoint = {{point.x}, {point.y}, {point.z}};
			double[][] translatedPoint = Matrix.multiply(translationMatrix, originalPoint);
			translatedObject.add(new Point(translatedPoint[0][0], translatedPoint[1][0]));
		}
		return translatedObject;
	}

}
