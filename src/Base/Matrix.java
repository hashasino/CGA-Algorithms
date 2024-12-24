package Base;

public class Matrix {
	public static double[][] multiply(double[][] firstMatrix, double[][] secondMatrix) {

		// Checking if matrices can be multiplied
		if (firstMatrix[0].length != secondMatrix.length) {
			throw new IllegalArgumentException("Matrices cannot be multiplied. " +
					"Number of columns in first matrix must equal number of rows in second matrix.");
		}

		// Creating result matrix with dimensions (rows of first) x (columns of second)
		int rows = firstMatrix.length;
		int cols = secondMatrix[0].length;
		int commonDimension = secondMatrix.length;
		double[][] resultMatrix = new double[rows][cols];

		// Performing matrix multiplication
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				double sum = 0.0;
				for (int k = 0; k < commonDimension; k++) {
					sum += firstMatrix[i][k] * secondMatrix[k][j];
				}
				resultMatrix[i][j] = sum;
			}
		}

		return resultMatrix;
	}
}
