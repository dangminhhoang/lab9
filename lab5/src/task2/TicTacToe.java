package task2;

public class TicTacToe {
    private static final char EMPTY = ' ';
    private char[][] board;

    // Constructor to initialize the Tic-Tac-Toe board
    public TicTacToe(char[][] board) {
        this.board = board;
    }

    public boolean checkRows() {
        for (int row = 0; row < board.length; row++) {
            if (checkRow(row)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRow(int row) {
        for (int col = 0; col < board.length; col++) {
            if (board[row][col] == EMPTY || board[row][col] != board[row][0]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkColumns() {
        for (int col = 0; col < board.length; col++) {
            if (checkColumn(col)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn(int col) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][col] == EMPTY || board[row][col] != board[0][col]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagonals() {
        return checkTopLeftToBottomRight() || checkBottomLeftToTopRight();
    }

    private boolean checkTopLeftToBottomRight() {
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == EMPTY || board[i][i] != board[0][0]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkBottomLeftToTopRight() {
        for (int i = 0; i < board.length; i++) {
            if (board[i][board.length - 1 - i] == EMPTY || board[i][board.length - 1 - i] != board[0][board.length - 1]) {
                return false;
            }
        }
        return true;
    }
}
