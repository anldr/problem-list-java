package leetcode.Vol101to200;

public class LeetCode188 {
    public int maxProfit(int k, int[] prices) {
        int result = 0;
        if (k >= prices.length / 2) {
            for (int i = 1; i < prices.length; i++) {
                result = result + Math.max(0, prices[i] - prices[i - 1]);
            }
            return result;
        }

        int[] dp1 = new int[k + 1];
        int[] dp2 = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            dp1[i] = 0;
            dp2[i] = Integer.MIN_VALUE;
        }

        for (int price : prices) {
            for (int i = k; k > 0; i--) {
                dp1[i] = Math.max(dp1[i], dp2[i] + price);
                dp2[i] = Math.max(dp2[i], dp1[i - 1] - price);
            }
        }

        return dp1[k];
    }
}
