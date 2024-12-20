public class Grid {
	public static void main(String[] args) {
		int width = 20;
		int height = 20;

		// Initializing grid
		String[][] grid = new String[width][height];  // Changed to String array to handle multi-digit numbers
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				grid[i][j] = ".";
			}
		}

		// Center points
		int centerX = width / 2;
		int centerY = height / 2;

		// Fill horizontal axis (middle row)
		for (int i = 0; i < width; i++) {
			int value = i - centerX;  // This gives us negative to positive numbers
			grid[i][centerY] = String.valueOf(value);
		}

		// Fill vertical axis (middle column)
		for (int j = 0; j < height; j++) {
			int value = centerY - j;  // Reverse direction for Y-axis (negative down, positive up)
			grid[centerX][j] = String.valueOf(value);
		}

		// Set center point to "0"
		grid[centerX][centerY] = "0";

		// Displaying coordinate grid
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				String cell = grid[i][j];
				// Right-align numbers with padding for consistent spacing
				System.out.printf("%4s", cell);
			}
			System.out.println();
		}
	}
}