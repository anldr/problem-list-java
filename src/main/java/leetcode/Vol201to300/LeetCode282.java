package leetcode.Vol201to300;

import java.util.ArrayList;
import java.util.List;

public class LeetCode282 {
    private char[] chars;

    private List<String> result;

    public List<String> addOperators(String num, int target) {
        chars = new char[num.length() * 2 + 7];
        result = new ArrayList<>();
        dfs(num, 0, 0, 0, 1, target);
        return result;
    }

    private void dfs(String num, int idx, int len, long a, long b, long target) {
        if (idx == num.length()) {
            if (a == target) {
                result.add(new String(chars).substring(0, len - 1));
            }
            return ;
        }

        long number = 0;
        for (int i = idx; i < num.length(); i++) {
            number = number * 10 + num.charAt(i) - '0';
            chars[len++] = num.charAt(i);
            chars[len] = '+';
            dfs(num, i + 1, len + 1, a + b * number, 1, target);
            if (i + 1 < num.length()) {
                chars[len] = '-';
                dfs(num, i + 1, len + 1, a + b * number, -1, target);
            }
            if (i + 1 < num.length()) {
                chars[len] = '*';
                dfs(num, i + 1, len + 1, a,  b * number,  target);
            }
            if (num.charAt(idx) == '0') {
                break;
            }
        }
    }
}
