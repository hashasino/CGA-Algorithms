
//	Contains all Circle Drawing Algorithms

import java.util.ArrayList;
import java.util.List;

public class Circle {

	//DDA Circle Drawing Algorithm (gives hexagons tho, not circles)
	public void DDA(int radius) {

		//Finding epsilon
		int power = 0;
		while (Math.pow(2, power) <= radius) {
			power++;
		}
		double epsilon = Math.pow(2, -power);

		//Initializing point list for Circle
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
		Plotter plotObj = new Plotter();
		plotObj.printCoordinates(Circle, radius);
		System.out.println();
		plotObj.plotCoordinates(Circle, radius);
	}

	public void Bresenhams(int radius) {
		/*
		- Initialize x = 0, y = radius
		- Calculate decision parameter (dP) = 3 - 2 * radius
		- If (dP < 0), x = x+1, dP = dP + 4x + 6
		- else If ( dp >= 0), x = x+1, y = y+1, dP = dP + 4x - 4y + 10
		- Loop while (x < y)
		 */

		int x = 0;
		int y = radius;
		int decisionParameter = 3 - 2 * radius;

		while (x < y) {
			x++;
			if (decisionParameter < 0) {
				decisionParameter += 4 * x + 6;
			} else {
				y++;
				decisionParameter += 4 * (x - y) + 10;
			}
		}
	}

	public void MidPoint(int radius) {
		/*
		- Initialize x = 0, y = radius
		- Calculate decision parameter (dP) = 5/4 - radius
		- If (dP < 0), x = x+1, y = y & dP = dP + 1 + 2x
		- else If (dP >= 0), x = x+1, y = y-1 & dP = dP + 1 + 2x - 2y
		- Generate points for all 8 octants, i.e. (x,y), (y,x), (-x,y), (-y,x), (-x,-y), (-y,-x), (x,-y) & (y,-x)
		- Loop while (x < y)
		 */

		int[] x = new int[radius * radius];
		x[0] = 0;
		int[] y = new int[radius * radius];
		y[0] = radius;
		int decisionParameter = 5 / 4 - radius;
		int i = 0;

		while (x[i] < y[i]) {
			x[i + 1] = x[i] + 1;
			if (decisionParameter < 0) {
				y[i + 1] = y[i];
				decisionParameter += 2 * x[i] + 1;
			} else {
				y[i + 1] = y[i] - 1;
				decisionParameter += 2 * (x[i] - y[i]) + 1;
			}
			i++;
		}
		Plotter plotObj = new Plotter();
//		plotObj.printCoordinates(x, y, radius);
	}
}
