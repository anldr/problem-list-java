package leetcode.Vol1to100;

public class LeetCode33 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int lastNum = nums[r];
        while (l < r) {
            int mid = (l + r) >> 1;
            if (target > lastNum && nums[mid] <= lastNum) {
                r = mid;
            } else if (target <= lastNum && nums[mid] > lastNum) {
                l = mid + 1;
            } else if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return nums[l] == target ? l : -1;
    }
}
