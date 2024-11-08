public class Circle {

//	Contains all Circle Drawing Algorithms

	public static void DDA(int radius) {
		/*
		- Initialize x = 0, y = radius
		- Find epsilon = 2^-n, where 2^(n-1) <= radius < 2^n
		- While (x < y), x = x + epsilon * y, &  y = y - epsilon * x (in that exact order)
		- Transpose the coordinate for all 8 octants (x,y), (y,x), (-x,y), (-y,x), (-x,-y), (-y,-x), (x,-y) & (y,-x)
		 */
	}

	public static void Bresenham(int radius) {
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


	public static void MidPoint(int radius) {
		/*
		- Initialize x = 0, y = radius
		- Calculate decision parameter (dP) = 5/4 - radius
		- If (dP < 0), x = x+1, y = y & dP = dP + 1 + 2x
		- else If (dP >= 0), x = x+1, y = y-1 & dP = dP + 1 + 2x - 2y
		- Generate points for all 8 octants, i.e. (x,y), (y,x), (-x,y), (-y,x), (-x,-y), (-y,-x), (x,-y) & (y,-x)
		- Loop while (x < y)
		 */

		int x = 0;
		int y = radius;
		int decisionParameter = 5 / 4 - radius;

		while (x < y) {
			x++;
			if (decisionParameter < 0) {
				decisionParameter += 2 * x + 1;
			} else {
				y--;
				decisionParameter += 2 * (x - y) + 1;
			}
		}

	}
}
