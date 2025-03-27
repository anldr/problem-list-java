package leetcode.Vol101to200;

public class LeetCode198 {
    public int rob_1(int[] nums) {
        int[][] dp = new int[nums.length + 3][2];
        dp[1][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1]);
            dp[i + 1][1] = Math.max(dp[i][0], Math.max(dp[i - 1][0], dp[i - 1][1])) + nums[i];
        }

        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }

    public int rob_2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    public int rob_3(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int pre1 = nums[0];
        int pre2 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = pre2;
            pre2 = Math.max(pre2, pre1 + nums[i]);
            pre1 = temp;
        }

        return pre2;
    }
}
