public class LinePlot {
	private static final int GRID_WIDTH = 33; // Width of the grid
	private static final int GRID_HEIGHT = 22; // Height of the grid

	public static void main(String[] args) {
		int x1 = 2, y1 = 2; // Starting point
		int x2 = 20, y2 = 20; // Ending point

		char[][] grid = new char[GRID_HEIGHT][GRID_WIDTH];
		initializeGrid(grid);

		plotLine(grid, x1, y1, x2, y2);
		printGrid(grid);
	}

	private static void initializeGrid(char[][] grid) {
		for (int i = 0; i < GRID_HEIGHT; i++) {
			for (int j = 0; j < GRID_WIDTH; j++) {
				grid[i][j] = '.';
			}
		}
	}

	private static void plotLine(char[][] grid, int x1, int y1, int x2, int y2) {
		int dx = Math.abs(x2 - x1);
		int dy = Math.abs(y2 - y1);
		int sx = x1 < x2 ? 1 : -1;
		int sy = y1 < y2 ? 1 : -1;
		int err = dx - dy;

		while (true) {
			if (x1 >= 0 && x1 < GRID_WIDTH && y1 >= 0 && y1 < GRID_HEIGHT) {
				grid[GRID_HEIGHT - y1 - 1][x1] = '*'; // Plot point, flip y-axis for display
			}
			if (x1 == x2 && y1 == y2) break;

			int e2 = 2 * err;
			if (e2 > -dy) {
				err -= dy;
				x1 += sx;
			}
			if (e2 < dx) {
				err += dx;
				y1 += sy;
			}
		}
	}

	private static void printGrid(char[][] grid) {
		for (char[] row : grid) {
			for (char cell : row) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
	}
}
