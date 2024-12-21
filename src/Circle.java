
//	Contains all Circle Drawing Algorithms

public class Circle {

	public static void main(String[] args) {
		Circle newCircle = new Circle();
		newCircle.DDA(6);
	}

	public void DDA(int radius) {
		/*
		- Initialize x = 0, y = radius
		- Find epsilon = 2^-n, where 2^(n-1) <= radius < 2^n
		- While (x < y), x = x + epsilon * y, &  y = y - epsilon * x (in that exact order)
		- Transpose the coordinate for all 8 octants (x,y), (y,x), (-x,y), (-y,x), (-x,-y), (-y,-x), (x,-y) & (y,-x)
		 */

		//Finding epsilon
		int power = 0;
		while (Math.pow(2, power) <= radius) {
			power++;
		}
		double epsilon = Math.pow(2, -power);

		int i = 0;

		int[] x = new int[radius * 8];
		x[0] = 0;
		int[] y = new int[radius * 8];
		y[0] = radius;

		//Calculating the first octant
		while (x[i] <= y[i]) {
			++i;
			x[i] = x[i - 1] + (int) Math.round(y[i - 1] * epsilon);
			y[i] = y[i - 1] - (int) Math.round(x[i] * epsilon);

			x[i + radius] = y[i];
			x[i + radius * 2] = -x[i];
			x[i + radius * 3] = -y[i];
			x[i + radius * 4] = -x[i];
			x[i + radius * 5] = -y[i];
			x[i + radius * 6] = x[i];
			x[i + radius * 7] = y[i];

			y[i + radius] = x[i];
			y[i + radius * 2] = y[i];
			y[i + radius * 3] = x[i];
			y[i + radius * 4] = -y[i];
			y[i + radius * 5] = -x[i];
			y[i + radius * 6] = -y[i];
			y[i + radius * 7] = -x[i];
		}

		//Instantiating new Plotter object
		Plotter plotObj = new Plotter();

		//Plotting the line using the coordinates calculated
//		plotObj.printCoordinates(x, y, radius);
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
