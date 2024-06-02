package leetcode.Vol1to100;

public class LeetCode34_2 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int leftPos = binSearch1(nums, target);
        if (leftPos >= nums.length || nums[leftPos] != target) {
            return new int[]{-1, -1};
        }

        return new int[] {leftPos, binSearch2(nums, target)};
    }

    private int binSearch1(int[] nums, int target) {
        int l = -1;
        int r = nums.length;
        while (l + 1 != r) {
            int mid = (l + r) >>1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return r;
    }

    private int binSearch2(int[] nums, int target) {
        int l = -1;
        int r = nums.length;
        while (l + 1 != r) {
            int mid = (l + r) >>1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
