import java.util.Arrays;

public class Plotter {

	public void printCoordinates(double[] x, double[] y) {
		for (int i = 0; i < x.length; i++) {
			System.out.print("(" + Math.round(x[i]) + "," + Math.round(y[i]) + ") ");
		}
	}

	public void printCoordinates(int[] x, int[] y) {
		for (int i = 0; i < x.length; i++) {
			System.out.print("(" + x[i] + "," + y[i] + ") ");
		}
	}

	public void printCoordinates(int[] x, int[] y, int radius) {
		for (int j = 0; j < radius; j++) {
			for (int i = 0; i < radius; i++) {
				System.out.print("(" + x[i] + "," + y[i] + ") ");
			}
			System.out.println();
		}
	}

	public void plotCoordinates(double[] x, double[] y) {

		// Finding the min and max coordinates to determine grid size
		int minX = (int) Math.floor(Arrays.stream(x).min().orElse(0.0));
		int maxX = (int) Math.ceil(Arrays.stream(x).max().orElse(0.0));
		int minY = (int) Math.floor(Arrays.stream(y).min().orElse(0.0));
		int maxY = (int) Math.ceil(Arrays.stream(y).max().orElse(0.0));

		// Calculating grid dimensions
		int width = maxX - minX + 3;  // +3 for padding
		int height = maxY - minY + 3; // +3 for padding

		// Initializing grid
		char[][] grid = new char[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				grid[i][j] = '.';
			}
		}

		// Plotting coordinates
		for (int i = 0; i < x.length; i++) {
			int X = (int) Math.round(x[i]) - minX + 1;
			int Y = (int) Math.round(y[i]) - minY + 1;

			// Ensure coordinate is within grid bounds
			if (X >= 0 && X < width && Y >= 0 && Y < height) {
				grid[height - Y - 1][X] = '*'; // Plotting point & flipping y-axis for display
			}
		}

		// Displaying coordinate grid
		for (char[] row : grid) {
			for (char cell : row) {
				System.out.print(cell + "  ");
			}
			System.out.println();
		}
	}

	public void plotCoordinates(int[] x, int[] y) {

		// Finding the min and max coordinates to determine grid size
		int minX = Arrays.stream(x).min().orElse(0);
		int maxX = Arrays.stream(x).max().orElse(0);
		int minY = Arrays.stream(y).min().orElse(0);
		int maxY = Arrays.stream(y).max().orElse(0);

		// Calculating grid dimensions
		int width = maxX - minX + 3;  // +3 for padding
		int height = maxY - minY + 3; // +3 for padding

		// Initializing grid
		char[][] grid = new char[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				grid[i][j] = '.';
			}
		}

		// Plotting coordinates
		for (int i = 0; i < x.length; i++) {
			int X = x[i] - minX + 1;
			int Y = y[i] - minY + 1;

			// Ensure coordinate is within grid bounds
			if (X >= 0 && X < width && Y >= 0 && Y < height) {
				grid[height - Y - 1][X] = '*'; // Plotting point & flipping y-axis for display
			}
		}

		// Displaying coordinate grid
		for (char[] row : grid) {
			for (char cell : row) {
				System.out.print(cell + "  ");
			}
			System.out.println();
		}
	}

}
