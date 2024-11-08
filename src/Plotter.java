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

	public void plotCoordinates(double[] x, double[] y) {

	}

}
