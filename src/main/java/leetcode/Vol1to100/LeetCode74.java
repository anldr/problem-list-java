package leetcode.Vol1to100;

public class LeetCode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0;
        int r = row * col - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (matrix[mid / col][mid % col] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return matrix[l / col][l % col] == target;
    }
}
