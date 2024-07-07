package leetcode.Vol101to200;

public class LeetCode123 {
    public int maxProfit(int[] prices) {
        int result = 0;
        int[] dp = new int[prices.length];
        int lefMin = prices[0];

        dp[0] = 0;
        for (int i = 0; i < prices.length; i++) {
            dp[i] = Math.max(dp[Math.max(0, i - 1)], prices[i] - lefMin);
            lefMin = Math.min(lefMin, prices[i]);
        }

        int rightMax = prices[prices.length - 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            result = Math.max(result, dp[Math.max(i - 1, 0)] + rightMax - prices[i]);
            rightMax = Math.max(rightMax, prices[i]);
        }

        return result;
    }
}
