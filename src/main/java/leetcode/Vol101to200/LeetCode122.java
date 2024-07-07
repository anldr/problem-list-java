package leetcode.Vol101to200;

public class LeetCode122 {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                result = result + (prices[i] - prices[i-1]);
            }
        }
        return result;
    }
}
