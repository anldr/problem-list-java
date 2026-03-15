package leetcode.Vol201to300;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode224 {
    public static int calculate(String s) {
        int curOp = 1;
        int len = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(curOp);

        Long result = 0L;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '+') {
                curOp = stack.peekLast();
            } else if (ch == '-') {
                curOp = -stack.peekLast();
            } else if (ch == '(') {
                stack.addLast(curOp);
            } else if (ch == ')') {
                stack.removeLast();
            } else if (ch >= '0' && ch <= '9') {
                Long tmp = 0L;
                for (; i < len; i++) {
                    if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        tmp = tmp * 10 + s.charAt(i) - '0';
                    } else  {
                        i--;
                        break;
                    }
                }
                result = result + curOp * tmp;
            }
        }

        return result.intValue();
    }

    public static void main(String[] args) {
        String s = "1-(     -2)";
        calculate(s);
    }
}
