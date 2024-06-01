package leetcode.Vol1to100;

public class LeetCode52 {
    private int tot;

    private boolean[] col;

    private boolean[] line_1;

    private boolean[] line_2;

    public int totalNQueens(int n) {
        tot = 0;
        col  = new boolean[n];
        line_1 = new boolean[2 * n - 1];
        line_2 = new boolean[2 * n - 1];
        dfs(n, 0);
        return tot;
    }

    private void dfs(int n, int dep) {
        if (dep == n) {
            tot++;
            return ;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !line_1[dep + i] && !line_2[n - 1 + dep - i]) {
                col[i] = true;
                line_1[dep + i] = true;
                line_2[n - 1 + dep - i] = true;
                dfs(n, dep + 1);
                col[i] = false;
                line_1[dep + i] = false;
                line_2[n - 1 + dep - i] = false;
            }
        }
    }
}
