package leetcode.Vol701to800;

public class LeetCode713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int multi = 1;
        int result = 0;
        while (right < nums.length) {
            multi = multi * nums[right];
            while (multi >= k && left <= right) {
                multi = multi / nums[left];
                left++;
            }
            result = result + (right - left + 1);
            right++;
        }

        return result;
    }
}
