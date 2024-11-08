import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		int[][] start = {{-5, 0}, {-5, 5}, {0, 5}, {5, 5}, {5, 0}, {5, -5}, {0, -5}, {-5, -5}};
		int[][] end = {{5, 0}, {5, -5}, {0, -5}, {-5, -5}, {-5, 0}, {-5, 5}, {0, 5}, {5, 5}};

		Scanner scan = new Scanner(System.in);
		LineDDA newLine = new LineDDA();

		for (int i = 0; i < 8; i++) {

			int x1 = start[i][0];
			int y1 = start[i][1];
			int x2 = end[i][0];
			int y2 = end[i][1];

			System.out.println("\n" + i + ". Start(" + x1 + "," + y1 + ") | End(" + x2 + "," + y2 + ")");
			System.out.println();

			newLine.SimpleDDA(x1, y1, x2, y2);
			System.out.println();

			newLine.SymmetricalDDA(x1, y1, x2, y2);
			scan.nextLine();
		}
	}
}
