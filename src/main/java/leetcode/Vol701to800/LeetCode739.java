package leetcode.Vol701to800;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.getLast()]) {
                Integer idx = stack.pollLast();
                result[idx] = i - idx;
            }
            stack.addLast(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] t = new int[]{73,74,75,71,69,72,76,73};
        dailyTemperatures(t);
    }
}
