package leetcode.Vol1701to1800;

/**
 * author: xuchen
 * created: 2022/1/31 12:41
 * <p>
 * Description:
 */
public class LeetCode1756 {
    static class Solution {
        private static int[] moveX = {-1, 0, 1, 0};

        private static int[] moveY = {0, 1, 0, -1};

        public int[][] highestPeak(int[][] isWater) {
            int n = isWater.length;
            int m = isWater[0].length;
            int[][] result = new int[n][m];

            int total = n * m;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (isWater[i][j] == 1) {
                        result[i][j] = 0;
                        total--;
                    } else {
                        result[i][j] = -1;
                    }
                }
            }

            int num = 0;
            while (total != 0) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (result[i][j] == num) {
                            for (int k = 0; k < 4; k++) {
                                int nx = i + moveX[k];
                                int ny = j + moveY[k];
                                if (isValid(nx, ny, n, m) && result[nx][ny] == -1) {
                                    result[nx][ny] = num + 1;
                                    total--;
                                }
                            }
                        }
                    }
                }

                num++;
            }

            return result;
        }

        public boolean isValid(int nx, int ny, int n, int m) {
            return nx >= 0 && nx < n && ny >= 0 && ny < m;
        }
    }
}
