package Algorithms;

import Base.Matrix;
import Base.Point;

import java.util.List;
import java.util.ArrayList;

public class Transform {

	//TODO - Try to have only one copy transformFactors for the whole object, i.e. this would need object creation, no static access

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

	public static List<Point> Shear(List<Point> Object, double xShear, double yShear) {
		List<Point> shearedObject = new ArrayList<>();
		double[][] shearMatrix = {{1, xShear, 0}, {yShear, 1, 0}, {0, 0, 1}};
		for (Point point : Object) {
			double[][] originalPoint = {{point.x}, {point.y}, {point.z}};
			double[][] shearedPoint = Matrix.multiply(shearMatrix, originalPoint);
			shearedObject.add(new Point(shearedPoint[0][0], shearedPoint[1][0]));
		}
		return shearedObject;
	}

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
