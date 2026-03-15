package leetcode.Vol1to100;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode20 {
    public boolean isValid(String s) {
        int len = s.length();
        if ((len & 1) == 1) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ')' && (stack.isEmpty() || stack.pollLast() != '(')) {
                return false;
            } else if (s.charAt(i) == '}' && (stack.isEmpty() || stack.pollLast() != '{')) {
                return false;
            } else if (s.charAt(i) == ']' && (stack.isEmpty() || stack.pollLast() != '[')) {
                return false;
            } else if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.addLast(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}