package leetcode.Vol101to200;

public class LeetCode130 {
    private static int size_x = 0;
    private static int size_y = 0;
    public static void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return ;
        }

        size_x = board.length;
        size_y = board[0].length;

        for (int i = 0; i < size_y; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
        }
        for (int i = 0; i < size_y; i++) {
            if (board[size_x - 1][i] == 'O') {
                dfs(board, size_x - 1, i);
            }
        }
        for (int i = 0; i < size_x; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
        }
        for (int i = 0; i < size_x; i++) {
            if (board[i][size_y - 1] == 'O') {
                dfs(board, i, size_y - 1);
            }
        }

        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= size_x || y < 0 || y >= size_y || board[x][y] != 'O') {
            return ;
        }

        board[x][y] = 'Y';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','O','X'},{'O','X','O'},{'X','O','X'}};
        solve(board);
    }
}
