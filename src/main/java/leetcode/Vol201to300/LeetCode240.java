package leetcode.Vol201to300;

public class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] < target) {
                col++;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
}
