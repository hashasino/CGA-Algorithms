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

	}

}
