package leetcode.Vol101to200;

public class LeetCode121 {
    public int maxProfit(int[] prices) {
        int result = -1;
        int leftMin = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            leftMin = Math.min(leftMin, prices[i]);
            result = Math.max(result, prices[i] - leftMin);
        }

        return result;
    }
}
