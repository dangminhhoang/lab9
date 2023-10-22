package task1;

public class tranpose {
	public static int[][] transpose(int[][] a) {
		int row = a.length;
		int col = a[0].length;
		int[][] result = new int[col][row];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				result[j][i] = a[i][j];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		int [][]result= transpose(a);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}			
