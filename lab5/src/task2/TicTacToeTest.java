package task2;

public class TicTacToeTest {

	public static void main(String[] args) {
		char[][] board = { { 'X', 'O', 'O' },
				           { 'O', 'X', 'O' },
				           { 'X', 'X', 'O' } };

		TicTacToe ticTacToe = new TicTacToe(board);

		// Check rows, columns, and diagonals
		boolean hasWinner = ticTacToe.checkRows() || ticTacToe.checkColumns() || ticTacToe.checkDiagonals();

		if (hasWinner) {
			System.out.println("We have a winner!");
		} else {
			System.out.println("No winner yet.");
		}
	}
}
