package leetcode.Vol1to100;

public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return nums[l] < target ? nums.length : l;
    }
}
