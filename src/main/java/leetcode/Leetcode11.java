package leetcode;

public class Leetcode11 {
    class Solution {
        public int maxArea(int[] height) {
            int lP = 0;
            int rP = height.length - 1;
            int result = -1;
            while (lP < rP) {
                result = Math.max(Math.min(height[lP], height[rP]) * (rP - lP), result);
                if (height[lP] < height[rP]) {
                    lP++;
                } else {
                    rP--;
                }
            }

            return result;
        }
    }
}
