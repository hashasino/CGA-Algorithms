
public class LineDDA {

	public void SimpleDDA(int x1, int y1, int x2, int y2) {
		int delX = x2 - x1;
		int delY = y2 - y1;
		double slope = (double) delY / delX;
		int steps = Math.max(Math.abs(delX), Math.abs(delY));
		double xIncrement, yIncrement;
		int directionX, directionY;

		if (x1 < x2) directionX = 1;
		else directionX = -1;
		if (y1 < y2) directionY = 1;
		else directionY = -1;

		if (slope < 1 && slope > -1) {
			xIncrement = directionX;
			yIncrement = slope * directionY;
		} else if (slope == 1 || slope == -1) {
			xIncrement = directionX;
			yIncrement = directionY;
		} else {
			xIncrement = directionX / slope;
			yIncrement = directionY;
		}

		int i = 1;
		double[] x = new double[steps + 1];
		x[0] = x1;
		double[] y = new double[steps + 1];
		y[0] = y1;

		while (i <= steps) {
			x[i] = x[i - 1] + xIncrement;
			y[i] = y[i - 1] + yIncrement;
			i++;
		}

		Plotter plotObj = new Plotter();
		plotObj.printCoordinates(x, y);
	}

	public void SymmetricalDDA(int x1, int y1, int x2, int y2) {
		int delX = x2 - x1;
		int delY = y2 - y1;
		int steps = Math.max(Math.abs(delX), Math.abs(delY));
		double xinc = (double) delX / steps;
		double yinc = (double) delY / steps;

		int i = 1;
		double[] x = new double[steps + 1];
		x[0] = x1;
		double[] y = new double[steps + 1];
		y[0] = y1;

		while (i <= steps) {
			x[i] = x[i - 1] + xinc;
			y[i] = y[i - 1] + yinc;
			i++;
		}

		Plotter plotObj = new Plotter();
		plotObj.printCoordinates(x, y);
	}

}

