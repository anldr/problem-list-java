package LeetCode;

/*
* 矩阵快速幂
*
* O(logn * k^3)
*
* */
public class LeetCode1137 {
    private static final int MAX_N = 3;

    public static int[][] multiOfMatrix(int[][] matrixA, int[][] matrixB) {
        int[][] result = new int[MAX_N][MAX_N];
        for (int i = 0; i < MAX_N; i++) {
            for (int j = 0; j < MAX_N; j++) {
                int tempSum = 0;
                for (int k = 0; k < MAX_N; k++) {
                    tempSum += matrixA[i][k] * matrixB[k][j];
                }
                result[i][j] = tempSum;
            }
        }
        return result;
    }

    public static int[][] quickPowOfMatrix(int[][]power, int k) {
        int[][] result = new int[][]{
                {1,0,0},
                {0,1,0},
                {0,0,1}
        };
        while (k != 0) {
            if ((k & 1) != 0) {
                result = multiOfMatrix(result, power);
            }
            power = multiOfMatrix(power, power);
            k >>= 1;
        }
        return result;
    }

    public int tribonacci(int n) {
        int[][] power = new int[][]{
                {1,1,1},
                {1,0,0},
                {0,1,0}
        };
        int[][] result = quickPowOfMatrix(power, n-2);
        return result[0][0] + result[0][1];
    }
}