package task1;

public class addNsubtract {
	// add 2 matrices
	public static int[][] add(int[][] a, int[][] b) {
		int[][] result = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				result[i][j] = a[i][j] + b[i][j];
			}
		}
		return result;
	}
	// subtract 2 matrices
	public static int[][]subtract(int[][] a, int[][] b) {
		int[][] resultS = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				resultS[i][j] = a[i][j] - b[i][j];
			}
		}
		return resultS;
	}
	public static void main(String[] args) {
		int[][] a = { { 7, 2 }, {5, 3}};
		int[][] b = { { 2, 1 }, {3, 1}};

		int[][] result = add(a, b);
		int[][] resultS = subtract(a, b);
		// Print the resultAdd matrix
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		// Print the resultSubtract matrix
				for (int i = 0; i < resultS.length; i++) {
					for (int j = 0; j < resultS[i].length; j++) {
						System.out.print(resultS[i][j] + " ");
					}
					System.out.println();
				}
	}
}
