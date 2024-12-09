package Lab_Practicals;

// Q1. Write a program for 2D line drawing as Raster Graphics Display.

import java.util.Scanner;

public class Q1_LineDrawing_SimpleDDA {
	// Raster display buffer
	private final char[][] grid;
	private final int width;
	private final int height;

	// Constructor
	public Q1_LineDrawing_SimpleDDA(int width, int height) {
		this.width = width;
		this.height = height;
		this.grid = new char[height][width];
		initializeGrid();
	}

	// Clear the display buffer
	public void initializeGrid() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				grid[y][x] = '.';
			}
		}
	}

	// Check if coordinate is within buffer bounds
	private boolean isValidCoordinate(int x, int y) {
		return x >= 0 && x < width && y >= 0 && y < height;
	}

	// 1. Digital Differential Analyzer (DDA) Line Drawing Algorithm
	public void drawLineDDA(int x0, int y0, int x1, int y1) {
		int dx = x1 - x0;
		int dy = y1 - y0;

		// Determine number of steps
		int steps = Math.max(Math.abs(dx), Math.abs(dy));

		// Calculate increments
		float xIncrement = (float) dx / steps;
		float yIncrement = (float) dy / steps;

		// Starting coordinates
		float x = x0;
		float y = y0;

		for (int i = 0; i <= steps; i++) {
			plotPixel(Math.round(x), Math.round(y));
			x += xIncrement;
			y += yIncrement;
		}
	}

	// 2. Bresenham's Line Drawing Algorithm
	public void drawLineBresenham(int x0, int y0, int x1, int y1) {
		int dx = Math.abs(x1 - x0);
		int dy = Math.abs(y1 - y0);
		int sx = x0 < x1 ? 1 : -1;
		int sy = y0 < y1 ? 1 : -1;
		int err = dx - dy;

		while (true) {
			plotPixel(x0, y0);

			if (x0 == x1 && y0 == y1) {
				break;
			}

			int e2 = 2 * err;
			if (e2 > -dy) {
				err -= dy;
				x0 += sx;
			}
			if (e2 < dx) {
				err += dx;
				y0 += sy;
			}
		}
	}

	// 3. Midpoint Line Drawing Algorithm
	public void drawLineMidpoint(int x0, int y0, int x1, int y1) {
		int dx = Math.abs(x1 - x0);
		int dy = Math.abs(y1 - y0);

		int sx = x0 < x1 ? 1 : -1;
		int sy = y0 < y1 ? 1 : -1;

		int x = x0;
		int y = y0;

		int interchange = 0;

		if (dy > dx) {
			int temp = dx;
			dx = dy;
			dy = temp;
			interchange = 1;
		}

		int d = 2 * dy - dx;
		int incrementE = 2 * dy;
		int incrementNE = 2 * (dy - dx);

		plotPixel(x, y);

		while (x != x1) {
			if (d <= 0) {
				// Move East
				if (interchange == 0) {
					x += sx;
				} else {
					y += sy;
				}
				d += incrementE;
			} else {
				// Move Northeast
				x += sx;
				y += sy;
				d += incrementNE;
			}
			plotPixel(x, y);
		}
	}

	// Plot a single pixel
	private void plotPixel(int x, int y) {
		if (isValidCoordinate(x, y)) {
			grid[y][x] = '*';
		}
	}

	// Display the raster buffer
	public void displayGrid() {
		System.out.println("Raster Graphics Display:");
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				System.out.print(grid[y][x] + " ");
			}
			System.out.println();
		}
	}

	// Main method with interactive interface
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Q1_LineDrawing_SimpleDDA display = new Q1_LineDrawing_SimpleDDA(40, 20);

		while (true) {
			System.out.println("\nRaster Graphics Line Drawing");
			System.out.println("1. DDA Line Algorithm");
			System.out.println("2. Bresenham Line Algorithm");
			System.out.println("3. Midpoint Line Algorithm");
			System.out.println("4. Clear Display");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();

			switch (choice) {
				case 1:
				case 2:
				case 3:
					System.out.print("Enter start x: ");
					int x0 = scanner.nextInt();
					System.out.print("Enter start y: ");
					int y0 = scanner.nextInt();
					System.out.print("Enter end x: ");
					int x1 = scanner.nextInt();
					System.out.print("Enter end y: ");
					int y1 = scanner.nextInt();

					switch (choice) {
						case 1:
							display.drawLineDDA(x0, y0, x1, y1);
							break;
						case 2:
							display.drawLineBresenham(x0, y0, x1, y1);
							break;
						case 3:
							display.drawLineMidpoint(x0, y0, x1, y1);
							break;
					}
					display.displayGrid();
					break;

				case 4:
					display.initializeGrid();
					System.out.println("Display cleared.");
					break;

				case 5:
					System.out.println("Exiting program.");
					scanner.close();
					System.exit(0);

				default:
					System.out.println("Invalid choice. Try again.");
			}
		}
	}
}
