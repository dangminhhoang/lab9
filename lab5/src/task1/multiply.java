package task1;

public class multiply {
	// multiply 2 matrices
	public static int[][] multiply(int[][] a, int[][] b) {
		int rowA = a.length;
		int colA = a[0].length;
		int colB = b[0].length;
		int[][] result = new int[rowA][colB];
		for (int i = 0; i < rowA; i++) {
			for (int j = 0; j < colB; j++) {
				for (int k = 0; k < colA; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] b = { { 7, 8 }, { 9, 10 }, { 11, 12 } };
		int[][] result = multiply(a, b);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
