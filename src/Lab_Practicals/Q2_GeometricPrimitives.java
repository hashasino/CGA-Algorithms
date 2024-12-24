package Lab_Practicals;

// Q2. Write a program to display basic 2D geometric primitives.

import java.util.Scanner;

// We define the basic 2D geometrics primitives as: points, lines, arcs, sectors & polygons.

public class Q2_GeometricPrimitives {
	private final char[][] grid;
	private final int width;
	private final int height;

	public Q2_GeometricPrimitives(int width, int height) {
		this.width = width;
		this.height = height;
		this.grid = new char[height][width];
		initializeGrid();
	}

	// Initialize grid with dots
	private void initializeGrid() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				grid[i][j] = '.';
			}
		}
	}

	// Draw a point
	public void drawPoint(int x, int y) {
		if (isValidCoordinate(x, y)) {
			grid[y][x] = '*';
		}
	}

	// Draw a line using Bresenham's line algorithm
	public void drawLine(int x0, int y0, int x1, int y1) {
		int dx = Math.abs(x1 - x0);
		int dy = Math.abs(y1 - y0);
		int sx = x0 < x1 ? 1 : -1;
		int sy = y0 < y1 ? 1 : -1;
		int err = dx - dy;

		while (true) {
			drawPoint(x0, y0);

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

	// Draw a rectangle
	public void drawRectangle(int x0, int y0, int width, int height) {
		drawLine(x0, y0, x0 + width, y0);  // Top
		drawLine(x0, y0, x0, y0 + height);  // Left
		drawLine(x0 + width, y0, x0 + width, y0 + height);  // Right
		drawLine(x0, y0 + height, x0 + width, y0 + height);  // Bottom
	}

	// Draw a circle using midpoint circle algorithm
	public void drawCircle(int centerX, int centerY, int radius) {
		int x = radius;
		int y = 0;
		int decisionOver2 = 1 - x;

		while (y <= x) {
			drawPoint(centerX + x, centerY + y);
			drawPoint(centerX - x, centerY + y);
			drawPoint(centerX + x, centerY - y);
			drawPoint(centerX - x, centerY - y);
			drawPoint(centerX + y, centerY + x);
			drawPoint(centerX - y, centerY + x);
			drawPoint(centerX + y, centerY - x);
			drawPoint(centerX - y, centerY - x);

			y++;

			if (decisionOver2 <= 0) {
				decisionOver2 += 2 * y + 1;
			} else {
				x--;
				decisionOver2 += 2 * (y - x) + 1;
			}
		}
	}

	// To check if coordinate is within grid
	private boolean isValidCoordinate(int x, int y) {
		return x >= 0 && x < width && y >= 0 && y < height;
	}

	// Display the grid
	public void display() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Reset grid to initial state
	public void clear() {
		initializeGrid();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Q2_GeometricPrimitives canvas = new Q2_GeometricPrimitives(40, 20);

		while (true) {
			System.out.println("\nGeometric Lab_Practicals.Primitives Drawing Program");
			System.out.println("1. Draw Base.Point");
			System.out.println("2. Draw Algorithms.Line");
			System.out.println("3. Draw Rectangle");
			System.out.println("4. Draw Algorithms.Circle");
			System.out.println("5. Clear Canvas");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();

			switch (choice) {
				case 1:
					System.out.print("Enter x coordinate: ");
					int pointX = scanner.nextInt();
					System.out.print("Enter y coordinate: ");
					int pointY = scanner.nextInt();
					canvas.drawPoint(pointX, pointY);
					break;

				case 2:
					System.out.print("Enter start x: ");
					int x0 = scanner.nextInt();
					System.out.print("Enter start y: ");
					int y0 = scanner.nextInt();
					System.out.print("Enter end x: ");
					int x1 = scanner.nextInt();
					System.out.print("Enter end y: ");
					int y1 = scanner.nextInt();
					canvas.drawLine(x0, y0, x1, y1);
					break;

				case 3:
					System.out.print("Enter top-left x: ");
					int rectX = scanner.nextInt();
					System.out.print("Enter top-left y: ");
					int rectY = scanner.nextInt();
					System.out.print("Enter width: ");
					int rectWidth = scanner.nextInt();
					System.out.print("Enter height: ");
					int rectHeight = scanner.nextInt();
					canvas.drawRectangle(rectX, rectY, rectWidth, rectHeight);
					break;

				case 4:
					System.out.print("Enter center x: ");
					int centerX = scanner.nextInt();
					System.out.print("Enter center y: ");
					int centerY = scanner.nextInt();
					System.out.print("Enter radius: ");
					int radius = scanner.nextInt();
					canvas.drawCircle(centerX, centerY, radius);
					break;

				case 5:
					canvas.clear();
					System.out.println("Canvas cleared.");
					break;

				case 6:
					System.out.println("Exiting program.");
					scanner.close();
					System.exit(0);

				default:
					System.out.println("Invalid choice. Try again.");
			}

			// Display the current state of the canvas
			canvas.display();
		}
	}
}