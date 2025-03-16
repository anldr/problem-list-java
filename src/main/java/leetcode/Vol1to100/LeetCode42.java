package leetcode.Vol1to100;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode42 {
    public int trap(int[] height) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.getLast()]) {
                int bottomH = height[stack.pollLast()];
                if (stack.isEmpty()) {
                    break;
                }
                int maxH = Math.min(height[stack.getLast()], height[i]);
                result = result + (maxH - bottomH) * (i - stack.getLast() - 1);
            }
            stack.addLast(i);
        }
        return result;
    }
}
