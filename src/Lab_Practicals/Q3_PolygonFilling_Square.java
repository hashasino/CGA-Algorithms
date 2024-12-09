package Lab_Practicals;

// Q3. Write a program to display a filled square.

import java.util.Scanner;

public class Q3_PolygonFilling_Square {
	// Raster display buffer
	private final char[][] grid;
	private final int width;
	private final int height;

	// Constructor
	public Q3_PolygonFilling_Square(int width, int height) {
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

	// 1. Outline Square
	public void drawSquareOutline(int topLeftX, int topLeftY, int size) {
		// Top and bottom lines
		for (int x = topLeftX; x < topLeftX + size; x++) {
			plotPixel(x, topLeftY);
			plotPixel(x, topLeftY + size - 1);
		}

		// Left and right lines
		for (int y = topLeftY; y < topLeftY + size; y++) {
			plotPixel(topLeftX, y);
			plotPixel(topLeftX + size - 1, y);
		}
	}

	// 2. Filled Square - Horizontal Scan Line Fill
	public void drawSquareFillHorizontal(int topLeftX, int topLeftY, int size) {
		for (int y = topLeftY; y < topLeftY + size; y++) {
			for (int x = topLeftX; x < topLeftX + size; x++) {
				plotPixel(x, y);
			}
		}
	}

	// 3. Filled Square - Vertical Scan Line Fill
	public void drawSquareFillVertical(int topLeftX, int topLeftY, int size) {
		for (int x = topLeftX; x < topLeftX + size; x++) {
			for (int y = topLeftY; y < topLeftY + size; y++) {
				plotPixel(x, y);
			}
		}
	}

	// 4. Diagonal Pattern Fill
	public void drawSquareFillDiagonal(int topLeftX, int topLeftY, int size) {
		for (int y = topLeftY; y < topLeftY + size; y++) {
			for (int x = topLeftX; x < topLeftX + size; x++) {
				// Diagonal pattern using modulo
				if ((x + y) % 2 == 0) {
					plotPixel(x, y);
				}
			}
		}
	}

	// 5. Checkerboard Pattern Fill
	public void drawSquareFillCheckerboard(int topLeftX, int topLeftY, int size) {
		for (int y = topLeftY; y < topLeftY + size; y++) {
			for (int x = topLeftX; x < topLeftX + size; x++) {
				// Checkerboard pattern
				if ((x - topLeftX + y - topLeftY) % 2 == 0) {
					plotPixel(x, y);
				}
			}
		}
	}

	// Plot a single pixel
	private void plotPixel(int x, int y) {
		if (isValidCoordinate(x, y)) {
			grid[y][x] = '*';
		}
	}

	// Display the raster buffer
	public void displayBuffer() {
		System.out.println("Raster Graphics Square Display:");
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				System.out.print(grid[y][x] + "  ");
			}
			System.out.println();
		}
	}

	// Main method with interactive interface
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Q3_PolygonFilling_Square display = new Q3_PolygonFilling_Square(40, 20);

		while (true) {
			System.out.println("\nRaster Graphics Square Drawing");
			System.out.println("1. Square Outline");
			System.out.println("2. Horizontal Scan Line Fill");
			System.out.println("3. Vertical Scan Line Fill");
			System.out.println("4. Diagonal Pattern Fill");
			System.out.println("5. Checkerboard Pattern Fill");
			System.out.println("6. Clear Display");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();

			if (choice >= 1 && choice <= 5) {
				System.out.print("Enter top-left x coordinate: ");
				int x = scanner.nextInt();
				System.out.print("Enter top-left y coordinate: ");
				int y = scanner.nextInt();
				System.out.print("Enter square size: ");
				int size = scanner.nextInt();

				// Clear previous drawing
				display.initializeGrid();

				// Draw square based on selected method
				switch (choice) {
					case 1:
						display.drawSquareOutline(x, y, size);
						break;
					case 2:
						display.drawSquareFillHorizontal(x, y, size);
						break;
					case 3:
						display.drawSquareFillVertical(x, y, size);
						break;
					case 4:
						display.drawSquareFillDiagonal(x, y, size);
						break;
					case 5:
						display.drawSquareFillCheckerboard(x, y, size);
						break;
				}

				// Display the result
				display.displayBuffer();
			} else if (choice == 6) {
				display.initializeGrid();
				System.out.println("Display cleared.");
			} else if (choice == 7) {
				System.out.println("Exiting program.");
				scanner.close();
				System.exit(0);
			} else {
				System.out.println("Invalid choice. Try again.");
			}
		}
	}
}