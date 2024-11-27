
//	Contains all line drawing algorithms

public class Line {

	//SimpleDDA Line Drawing Algorithm
	public void SimpleDDA(int x1, int y1, int x2, int y2) {

		//Calculating slope
		int delX = x2 - x1;
		int delY = y2 - y1;
		double slope = Math.abs((double) delY / delX);

		//Calculating line length
		int steps = Math.max(Math.abs(delX), Math.abs(delY));

		//Deciding increment sign/polarity
		int directionX, directionY;
		if (x1 < x2) directionX = 1;
		else directionX = -1;
		if (y1 < y2) directionY = 1;
		else directionY = -1;

		//Calculating increments values
		double xIncrement, yIncrement;
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

		int i = 1; //Initializing iteration counter

		//Creating an array to store x values for the coordinates to be calculated
		double[] x = new double[steps + 1];
		x[0] = x1; //Assigning the first index with the starting x value

		//Creating an array to store y values for the coordinates to be calculated
		double[] y = new double[steps + 1];
		y[0] = y1; //Assigning the first index with the starting y value

		//Calculating line coordinates
		while (i <= steps) {
			x[i] = x[i - 1] + xIncrement;
			y[i] = y[i - 1] + yIncrement;
			i++;
		}

		//Instantiating new Plotter object
		Plotter plotObj = new Plotter();

		//Plotting the line using the coordinates calculated
		plotObj.printCoordinates(x, y);

	} //End Method

	//SymmetricalDDA Line Drawing Algorithm
	public void SymmetricalDDA(int x1, int y1, int x2, int y2) {

		//Calculating line length
		int delX = x2 - x1;
		int delY = y2 - y1;
		int steps = Math.max(Math.abs(delX), Math.abs(delY));

		// Calculating increment values
		double xIncrement = (double) delX / steps;
		double yIncrement = (double) delY / steps;


		/*Initializing iteration counter*/
		int i = 1;

		//Creating an array to store x values for the coordinates to be calculated
		double[] x = new double[steps + 1];
		x[0] = x1; //Assigning the first index with the starting x value

		//Creating an array to store y values for the coordinates to be calculated
		double[] y = new double[steps + 1];
		y[0] = y1; //Assigning the first index with the starting y value

		//Calculating line coordinates
		while (i <= steps) {
			x[i] = x[i - 1] + xIncrement;
			y[i] = y[i - 1] + yIncrement;
			i++;
		}

		//Instantiating new Plotter object
		Plotter plotObj = new Plotter();

		//Plotting the line using the coordinates calculated
		plotObj.printCoordinates(x, y);

	} //End Method

	//Bresenham's Line Drawing Algorithm
	public void Bresenhams(int x1, int y1, int x2, int y2) {

		//Calculating line length
		int delX = Math.abs(x2 - x1);
		int delY = Math.abs(y2 - y1);
		int steps = Math.max(delX, delY);

		//Initializing the decision parameter
		int decisionParameter = 2 * delY - delX;

		//Deciding increment sign/polarity
		int xIncrement, yIncrement;
		xIncrement = Integer.compare(x2, x1);
		yIncrement = Integer.compare(y2, y1);

		/*Initializing iteration counter*/
		int i = 1;

		//Creating an array to store x values for the coordinates to be calculated
		int[] x = new int[steps + 1];
		x[0] = x1; //Assigning the first index with the starting x value

		//Creating an array to store y values for the coordinates to be calculated
		int[] y = new int[steps + 1];
		y[0] = y1; //Assigning the first index with the starting y value

		//Calculating line coordinates
		while (i <= steps) {
			x[i] = x[i - 1] + xIncrement;
			if (decisionParameter < 0) {
				y[i] = y[i - 1];
				decisionParameter += 2 * delY;
			} else {
				y[i] = y[i - 1] + yIncrement;
				decisionParameter += 2 * (delY - delX);
			}
			i++;
		}

		//Instantiating new Plotter object
		Plotter plotObj = new Plotter();

		//Plotting the line using the coordinates calculated
		plotObj.printCoordinates(x, y);

	} //End Method
}
