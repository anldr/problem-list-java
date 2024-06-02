package leetcode.Vol101to200;

public class LeetCode153 {
    public int findMin(int[] nums) {
        if (nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }

        return binSearch(nums, -1, nums.length, nums[0]);
    }

    private int binSearch(int[] nums, int l , int r, int target) {
        while (l + 1 != r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return Math.min(nums[l], nums[r >= nums.length ? r - 1 : r]);
    }
}
