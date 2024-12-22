package Base;

import java.util.List;

public class Plotter {

	//To initialize grid for plotting a single object
	public String[][] ObjectCoordinates(int width, int height) {

		//Initializing grid/frame buffer
		String[][] grid = new String[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				grid[i][j] = ".";
			}
		}

//		//Drawing ordinate & abscissa markings
//		int centerX = width / 2;
//		int centerY = height / 2;
//		for (int j = 0; j < height; j++) {
//			int value = centerY - j;
//			if (value > 0)
//				grid[centerX][j] = String.valueOf('|');
//			if (value < 0)
//				grid[centerX][j] = String.valueOf('|'); //Ordinate
//		}
//		for (int i = 0; i < width; i++) {
//			int value = i - centerX;
//			if (value > 0)
//				grid[i][centerY] = String.valueOf("--");
//			if (value < 0)
//				grid[i][centerY] = String.valueOf("--"); //Abscissa
//		}
//		grid[centerX][centerY] = "+"; //Center

		return grid;
	}

	//To initialize grid to plot multiple objects i.e. the world
	public String[][] WorldCoordinates(int width, int height) {

		String[][] grid = new String[width][height];

		//Drawing background characters
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				grid[i][j] = ".";
			}
		}

		//Drawing ordinate & abscissa markings
		int centerX = width / 2;
		int centerY = height / 2;
		for (int j = 0; j < height; j++) {
			int value = centerY - j;
			grid[centerX][j] = String.valueOf(value); //Ordinate
		}
		for (int i = 0; i < width; i++) {
			int value = i - centerX;
			grid[i][centerY] = String.valueOf(value); //Abscissa
		}
		grid[centerX][centerY] = "0"; //Center

		return grid;
	}

	//To print & plot Line
	public void printCoordinates(List<Point> Line) {
		for (Point point : Line) {
			System.out.print(point.getCoordinates() + ' ');
		}
	}

	public void plotCoordinates(List<Point> Line) {

		//Setting initial min/max value
		double minX = Double.MAX_VALUE;
		double maxX = Double.MIN_VALUE;
		double minY = Double.MAX_VALUE;
		double maxY = Double.MIN_VALUE;

		//Finding min & max for x & y for all points in the list
		for (Point point : Line) {
			if (point.x < minX) minX = point.x;
			if (point.x > maxX) maxX = point.x;
			if (point.y < minY) minY = point.y;
			if (point.y > maxY) maxY = point.y;
		}

		// Calculating grid dimensions
		int width = (int) (maxX - minX + 1);
		int height = (int) (maxY - minY + 1);

		//Initializing grid/frame buffer
		Plotter plotObj = new Plotter();
		String[][] grid = plotObj.ObjectCoordinates(width, height);

		// Plotting coordinates
		for (Point point : Line) {
			int X = (int) (Math.round(point.x - minX) + 1);
			int Y = (int) (Math.round(point.y - minY) + 1);

			grid[X - 1][height - Y] = String.valueOf('*');
		}

		// Displaying coordinate grid
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				String cell = grid[i][j];
				System.out.printf("%3s", cell);
			}
			System.out.println();
		}
	}

	//To print & plot Circle
	public void printCoordinates(List<Point> Circle, int radius) {

		for (Point point : Circle) {
			System.out.print("(" + point.x + "," + point.y + ") ");
			System.out.print("(" + point.y + "," + point.x + ") ");
			System.out.print("(" + point.y + "," + -point.x + ") ");
			System.out.print("(" + point.x + "," + -point.y + ") ");
			System.out.print("(" + -point.x + "," + -point.y + ") ");
			System.out.print("(" + -point.y + "," + -point.x + ") ");
			System.out.print("(" + -point.y + "," + point.x + ") ");
			System.out.print("(" + -point.x + "," + point.y + ") ");
			System.out.println();
		}
	}

	public void plotCoordinates(List<Point> Circle, int radius) {

		int diameter = 2 * radius;

		//Initializing grid/frame buffer
		Plotter plotObj = new Plotter();
		String[][] grid = plotObj.ObjectCoordinates(diameter + 1, diameter + 1);

		// Plotting coordinates
		for (Point point : Circle) {
			int X = (int) (Math.round(point.x));
			int Y = (int) (Math.round(point.y));
			grid[radius + X][radius - Y] = String.valueOf('*');
			grid[radius + Y][radius - X] = String.valueOf('*');
			grid[radius + Y][radius + X] = String.valueOf('*');
			grid[radius + X][radius + Y] = String.valueOf('*');
			grid[radius - X][radius + Y] = String.valueOf('*');
			grid[radius - Y][radius + X] = String.valueOf('*');
			grid[radius - Y][radius - X] = String.valueOf('*');
			grid[radius - X][radius - Y] = String.valueOf('*');
		}

		// Displaying coordinate grid
		for (int j = 0; j <= diameter; j++) {
			for (int i = 0; i <= diameter; i++) {
				String cell = grid[i][j];
				System.out.printf("%3s", cell);
			}
			System.out.println();
		}

	}

	//To plot everything, everywhere, all at once
	public void WorldPlotter() {
	}

}