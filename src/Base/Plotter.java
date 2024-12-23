package Base;

import java.util.List;

public class Plotter { //Contains methods to print & plot objects
	private final int width;
	private final int height;
	private final String[][] World;

	public Plotter(int width, int height) {
		this.width = width;
		this.height = height;
		this.World = WorldGrid(width, height);
	}

	//To initialize grid for plotting a single object
	private static String[][] ObjectGrid(int width, int height) {

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

	//To initialize grid for plotting multiple objects
	private String[][] WorldGrid(int width, int height) {

		String[][] grid = new String[width][height];

		//Initializing grid/frame buffer
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
	public static void printLine(List<Point> Line) {
		for (Point point : Line) {
			System.out.print(point.getCoordinates() + ' ');
		}
	}

	public static void plotLine(List<Point> Line, char character) {

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
		String[][] grid = Plotter.ObjectGrid(width, height);

		// Plotting coordinates
		for (Point point : Line) {
			int X = (int) (Math.round(point.x - minX) + 1);
			int Y = (int) (Math.round(point.y - minY) + 1);

			grid[X - 1][height - Y] = String.valueOf(character);
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
	public static void printCircle(List<Point> Circle) {

		for (Point point : Circle) {
			int X = (int) Math.round(point.x);
			int Y = (int) Math.round(point.y);
			System.out.print("(" + X + "," + Y + ") ");
			System.out.print("(" + Y + "," + X + ") ");
			System.out.print("(" + Y + "," + -X + ") ");
			System.out.print("(" + X + "," + -Y + ") ");
			System.out.print("(" + -X + "," + -Y + ") ");
			System.out.print("(" + -Y + "," + -X + ") ");
			System.out.print("(" + -Y + "," + X + ") ");
			System.out.print("(" + -X + "," + Y + ") ");
			System.out.println();
		}
	}

	public static void plotCircle(List<Point> Circle, int radius, char character) {

		int diameter = 2 * radius;

		//Initializing grid/frame buffer
		String[][] grid = Plotter.ObjectGrid(diameter + 1, diameter + 1);

		// Plotting coordinates
		for (Point point : Circle) {
			int X = (int) (Math.round(point.x));
			int Y = (int) (Math.round(point.y));
			grid[radius + X][radius - Y] = String.valueOf(character);
			grid[radius + Y][radius - X] = String.valueOf(character);
			grid[radius + Y][radius + X] = String.valueOf(character);
			grid[radius + X][radius + Y] = String.valueOf(character);
			grid[radius - X][radius + Y] = String.valueOf(character);
			grid[radius - Y][radius + X] = String.valueOf(character);
			grid[radius - Y][radius - X] = String.valueOf(character);
			grid[radius - X][radius - Y] = String.valueOf(character);
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

	//To plot (everything, everywhere, all) objects in the WorldGrid
	public void WorldPlotLine(List<Point> Line, char character) {

		int centerX = width / 2;
		int centerY = height / 2;

		for (Point point : Line) {
			int X = (int) (Math.round(point.x));
			int Y = (int) (Math.round(point.y));
			World[centerX + X][centerY - Y] = String.valueOf(character);
		}
	}

	public void WorldPlotCircle(List<Point> Circle, char character) {

		int centerX = width / 2;
		int centerY = height / 2;

		for (Point point : Circle) {
			int X = (int) (Math.round(point.x));
			int Y = (int) (Math.round(point.y));
			World[centerX + X][centerY - Y] = String.valueOf(character);
			World[centerX + Y][centerY - X] = String.valueOf(character);
			World[centerX + Y][centerY + X] = String.valueOf(character);
			World[centerX + X][centerY + Y] = String.valueOf(character);
			World[centerX - X][centerY + Y] = String.valueOf(character);
			World[centerX - Y][centerY + X] = String.valueOf(character);
			World[centerX - Y][centerY - X] = String.valueOf(character);
			World[centerX - X][centerY - Y] = String.valueOf(character);
		}
	}

	//To display the World Grid
	public void WorldDisplay() {
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				String cell = World[i][j];
				System.out.printf("%4s", cell);
			}
			System.out.println();
		}
	}

}