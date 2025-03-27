package leetcode.Vol901to1000;

public class LeetCode918 {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = nums[0];
        int maxPreVal = nums[0];
        int minPreVal = nums[0];
        int maxResult = nums[0];
        int minResult = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxPreVal = Math.max(maxPreVal + nums[i], nums[i]);
            maxResult = Math.max(maxPreVal, maxResult);

            minPreVal = Math.min(minPreVal + nums[i], nums[i]);
            minResult = Math.min(minPreVal, minResult);

            sum += nums[i];
        }

        return maxResult < 0 ? maxResult : Math.max(maxResult, sum - minResult);
    }
}
