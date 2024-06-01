package leetcode.Vol1to100;

public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int leftPos = binSearch1(nums, target);
        if (nums[leftPos] != target) {
            return new int[]{-1, -1};
        }

        return new int[] {leftPos, binSearch2(nums, target)};
    }

    private int binSearch1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int binSearch2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
