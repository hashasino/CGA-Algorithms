
//	Contains all line drawing algorithms

import java.util.List;
import java.util.ArrayList;

public class Line {

	//SimpleDDA Line Drawing Algorithm
	public void SimpleDDA(int x1, int y1, int x2, int y2) {

		//Calculating line length
		int delX = x2 - x1;
		int delY = y2 - y1;
		int length = Math.max(Math.abs(delX), Math.abs(delY));

		// Calculating increment values
		double xIncrement = (double) delX / length;
		double yIncrement = (double) delY / length;

		//Initializing point list for Line
		List<Point> Line = new ArrayList<>();
		Line.add(new Point(x1, y1)); //Adding starting point

		//Initializing loop variables
		double x = x1;
		double y = y1;

		//Calculating line coordinates
		while (x != x2 || y != y2) {
			x = x + xIncrement;
			y = y + yIncrement;
			Line.add(new Point(x, y));
		}

		//Plotting the line using the coordinates calculated
		Plotter plotObj = new Plotter();
		plotObj.printCoordinates(Line);
		System.out.println();
		plotObj.plotCoordinates(Line);

	} //End Method

	//SymmetricalDDA Line Drawing Algorithm
	public void SymmetricalDDA(int x1, int y1, int x2, int y2) {

		//Calculating line length
		int delX = x2 - x1;
		int delY = y2 - y1;
		int power = 0;
		while (Math.pow(2, power) < Math.max(Math.abs(delX), Math.abs(delY))) {
			power++;
		}
		int length = (int) Math.pow(2, power);

		// Calculating increment values
		double xIncrement = (double) delX / length;
		double yIncrement = (double) delY / length;

		//Initializing point list for Line
		List<Point> Line = new ArrayList<>();
		Line.add(new Point(x1, y1)); //Adding first point

		//Initializing loop variables
		double x = x1;
		double y = y1;
		Point prevPoint = new Point(x, y), newPoint;

		//Calculating line coordinates
		for (int i = 1; i <= length; i++) {

			x = x1 + xIncrement * i;
			y = y1 + yIncrement * i;

			newPoint = new Point(x, y);

			if (Math.round(newPoint.x) != Math.round(prevPoint.x) ||
					Math.round(newPoint.y) != Math.round(prevPoint.y)) {
				Line.add(newPoint);
				prevPoint = newPoint;
			}
		}

		//Plotting the line using the coordinates calculated
		Plotter plotObj = new Plotter();
		plotObj.printCoordinates(Line);
		System.out.println();
		plotObj.plotCoordinates(Line);

	} //End Method

	//Bresenham's Line Drawing Algorithm
	public void Bresenhams(int x1, int y1, int x2, int y2) {

		//Calculating delX & delY
		int delX = Math.abs(x2 - x1);
		int delY = Math.abs(y2 - y1);

		//Initializing decision parameter
		int decisionParameter = 2 * delY - delX;

		//Deciding increment sign+values (-1, 0, 1)
		int xIncrement = Integer.compare(x2, x1);
		int yIncrement = Integer.compare(y2, y1);

		//Initializing point list for Line
		List<Point> Line = new ArrayList<>();
		Line.add(new Point(x1, y1)); //Adding starting point

		//Initializing loop variables
		double x = x1;
		double y = y1;

		//Calculating line coordinates
		while (x != x2 || y != y2) {
			x = x + xIncrement;
			if (decisionParameter < 0) {
				decisionParameter += 2 * delY;
			} else {
				y = y + yIncrement;
				decisionParameter += 2 * (delY - delX);
			}
			Line.add(new Point(x, y));
		}

		//Plotting the line using the coordinates calculated
		Plotter plotObj = new Plotter();
		plotObj.printCoordinates(Line);
		System.out.println();
		plotObj.plotCoordinates(Line);

	} //End Method

	//Midpoint Line Drawing Algorithm
	public void Midpoint(int x1, int y1, int x2, int y2) {

		//Calculating delX & delY
		int delX = Math.abs(x2 - x1);
		int delY = Math.abs(y2 - y1);

		//Initializing the decision parameter
		int decisionParameter = delY - (delX / 2);

		//Deciding increment sign+values (-1, 0, 1)
		int xIncrement = Integer.compare(x2, x1);
		int yIncrement = Integer.compare(y2, y1);

		//Initializing point list for Line
		List<Point> Line = new ArrayList<>();
		Line.add(new Point(x1, y1)); //Adding starting point

		//Initializing loop variables
		double x = x1;
		double y = y1;

		//Calculating line coordinates
		while (x != x2 || y != y2) {
			x = x + xIncrement;
			if (decisionParameter < 0) {
				decisionParameter += delY;
			} else {
				y = y + yIncrement;
				decisionParameter += (delY - delX);
			}
			Line.add(new Point(x, y));
		}

		//Plotting the line using the coordinates calculated
		Plotter plotObj = new Plotter();
		plotObj.printCoordinates(Line);
		System.out.println();
		plotObj.plotCoordinates(Line);

	} //End Method

}