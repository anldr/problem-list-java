package leetcode.Vol101to200;

public class LeetCode153_2 {
    public int findMin(int[] nums) {
        if (nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }

        return binSearch(nums, 0, nums.length - 1, nums[0]);
    }

    private int binSearch(int[] nums, int l , int r, int target) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[l];
    }
}
