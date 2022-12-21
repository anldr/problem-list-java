package leetcode.Vol1to100;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LeetCode36 {
    public static boolean isValidSudoku(char[][] board) {
        int[][] numRows = new int[10][10];
        int[][] numCols = new int[10][10];
        int[][] numCells = new int[10][10];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] != '.') {
                    numRows[row][board[row][col] - '0']++;
                    numCols[col][board[row][col] - '0']++;
                    numCells[(row / 3) * 3 + col / 3][board[row][col] - '0']++;
                    if (numRows[row][board[row][col] - '0'] > 1 || numCols[col][board[row][col] - '0'] > 1 || numCells[(row / 3) * 3 + col / 3][board[row][col] - '0'] > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'},
        };

        log.info(String.valueOf(isValidSudoku(board)));
    }
}
