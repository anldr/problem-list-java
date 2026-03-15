package leetcode.Vol101to200;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode150 {
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].length() == 1 && tokens[i].charAt(0) == '+') {
                int tmp = stack.pollLast() + stack.pollLast();
                stack.addLast(tmp);
            } else if (tokens[i].length() == 1 && tokens[i].charAt(0) == '-') {
                int tmp = -stack.pollLast() + stack.pollLast();
                stack.addLast(tmp);
            } else if (tokens[i].length() == 1 && tokens[i].charAt(0) == '*') {
                int tmp = stack.pollLast() * stack.pollLast();
                stack.addLast(tmp);
            } else if (tokens[i].length() == 1 && tokens[i].charAt(0) == '/') {
                int a = stack.pollLast();
                int b = stack.pollLast();
                int tmp = b/ a;
                stack.addLast(tmp);
            } else {
                stack.addLast(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pollLast();
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        evalRPN(tokens);
    }
}
