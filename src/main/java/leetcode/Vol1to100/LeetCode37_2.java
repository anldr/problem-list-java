package leetcode.Vol1to100;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class LeetCode37_2 {
    private boolean[][] rowBorad = new boolean[9][9];

    private boolean[][] colBorad = new boolean[9][9];

    private boolean[][][] miniborad = new boolean[3][3][9];

    private List<int[]> blanks = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    blanks.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    rowBorad[i][digit] = true;
                    colBorad[j][digit] = true;
                    miniborad[i / 3][j / 3][digit] = true;
                }
            }
        }

        dfs(board, 0);
    }

    private boolean dfs(char[][] board, int idx) {
        if (idx >= blanks.size()) {
            return true;
        }

        int i = blanks.get(idx)[0];
        int j = blanks.get(idx)[1];
        for (int k = 1; k <= 9; k++) {
            if (!rowBorad[i][k - 1] && !colBorad[j][k - 1] && !miniborad[i / 3][j / 3][k - 1]) {
                board[i][j] = (char)(k + '0');
                rowBorad[i][k  -1] = true;
                colBorad[j][k  -1] = true;
                miniborad[i / 3][j / 3][k  -1] = true;
                if (dfs(board, idx + 1)) {
                    return true;
                }
                rowBorad[i][k  -1] = false;
                colBorad[j][k  -1] = false;
                miniborad[i / 3][j / 3][k  -1] = false;
            }
        }
        return false;
    }
}
