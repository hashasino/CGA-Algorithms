package Algorithms;

import Base.Plotter;
import Base.Point;

import java.util.ArrayList;
import java.util.List;

public class Polygons {

	//Algorithm to draw regular polygons
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

	//For testing purposes
	public static void main(String[] args) {
		Plotter.plotObject(Polygons.Polygon(6, 9), 'p');
	}
}
