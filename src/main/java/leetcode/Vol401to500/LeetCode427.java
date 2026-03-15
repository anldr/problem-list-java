package leetcode.Vol401to500;

import common_structure.leetcode.quad_tree.Node;

public class LeetCode427 {
    private int[][] preSum;

    public Node construct(int[][] grid) {
        int n = grid.length;
        preSum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                preSum[i][j] = preSum[i][j - 1] + preSum[i - 1][j] - preSum[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        return dfs(0, 0, n - 1, n - 1);
    }

    private Node dfs(int a, int b, int c, int d) {
        int row = c - a + 1;
        int col = d - b + 1;
        int curGridSum = preSum[c + 1][d + 1] + preSum[a][b] - preSum[c + 1][b] - preSum[a][d + 1];
        if (curGridSum == 0 || (row * col) == curGridSum) {
            return new Node(curGridSum > 0, true);
        }

        int midRow = (a + c) / 2;
        int midCol = (b + d) / 2;
        Node topLeft = dfs(a, b, midRow, midCol);
        Node topRight = dfs(a, midCol + 1, midRow, d);
        Node bottomLeft = dfs(midRow + 1, b, c, midCol);
        Node bottomRight = dfs(midRow + 1, midCol + 1, c, d);
        return new Node(curGridSum > 0, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
