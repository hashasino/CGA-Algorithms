
public class LineDDA {

	public void SimpleDDA(int x1, int y1, int x2, int y2) { //definition for the SimpleDDA Line Drawing Algorithm taking the x & y values of the start & end coordinates as arguments

		//calculate difference between x-coordinates -> delX
		int delX = x2 - x1;

		//calculate difference between y-coordinates -> delY
		int delY = y2 - y1;

		//calculate slope
		double slope = (double) delY / delX;

		//calculate the largest between delX & delY to decide how many times we'll need to calculate the next coordinate
		int steps = Math.max(Math.abs(delX), Math.abs(delY));

		//Initializing increment & direction vectors
		double xIncrement, yIncrement;
		int directionX, directionY;

		if (x1 < x2) directionX = 1; //if the x value of starting coordinate is less than that of end, move right
		else directionX = -1; //else move left

		if (y1 < y2) directionY = 1; //if the y value of starting coordinate is less than that of end, move up
		else directionY = -1; //else move down

		if (slope < 1 && slope > -1) { //if the value of slope is between -1 & +1
			xIncrement = directionX; //xIncrement is assigned
			yIncrement = slope * directionY; //yIncrement is calculated
		} else if (slope == 1 || slope == -1) { //else if the value of slope turns out to be exactly +1 or -1
			xIncrement = directionX; //xIncrement is assigned
			yIncrement = directionY; //yIncrement is assigned
		} else { //else when the value of slope is more than 1 or less than -1
			xIncrement = directionX / slope; //xIncrement is calculated
			yIncrement = directionY; //yIncrement is assigned
		}

		/*Initializing iteration counter*/
		int i = 1;

		//Creating an array to store x values for the coordinates to be calculated
		double[] x = new double[steps + 1];
		x[0] = x1; //Assigning the first index with the starting x value

		//Creating an array to store y values for the coordinates to be calculated
		double[] y = new double[steps + 1];
		y[0] = y1; //Assigning the first index with the starting y value

		//while the iteration counter is less than or equal to the number of steps
		while (i <= steps) {
			x[i] = x[i - 1] + xIncrement; //calculate the x value for the next coordinate
			y[i] = y[i - 1] + yIncrement; //calculate the y value for the next coordinate
			i++; //increment iteration counter
		}

		//Instantiating new Plotter object
		Plotter plotObj = new Plotter();

		//Plotting the line using the coordinates calculated
		plotObj.printCoordinates(x, y);

	} //End Method

	public void SymmetricalDDA(int x1, int y1, int x2, int y2) { //definition for the SymmetricalDDA Line Drawing Algorithm taking the x & y values of the start & end coordinates as arguments

		//calculate difference between x-coordinates -> delX
		int delX = x2 - x1;

		//calculate difference between y-coordinates -> delY
		int delY = y2 - y1;

		//calculate the largest between delX & delY to decide how many times we'll need to calculate the next coordinate
		int steps = Math.max(Math.abs(delX), Math.abs(delY));

		// calculate the x & y increments using symmetry using the number of steps as calculated before
		double xIncrement = (double) delX / steps;
		double yIncrement = (double) delY / steps;

		int i = 1; //Initializing iteration counter

		//Creating an array to store x values for the coordinates to be calculated
		double[] x = new double[steps + 1];
		x[0] = x1; //Assigning the first index with the starting x value

		//Creating an array to store y values for the coordinates to be calculated
		double[] y = new double[steps + 1];
		y[0] = y1; //Assigning the first index with the starting y value

		//while the iteration counter is less than or equal to the number of steps
		while (i <= steps) {
			x[i] = x[i - 1] + xIncrement; //calculate the x value for the next coordinate
			y[i] = y[i - 1] + yIncrement; //calculate the y value for the next coordinate
			i++; //increment iteration counter
		}

		//Instantiating new Plotter object
		Plotter plotObj = new Plotter();

		//Plotting the line using the coordinates calculated
		plotObj.printCoordinates(x, y);

	} //End Method
}
