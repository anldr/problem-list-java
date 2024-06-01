package leetcode.Vol1to100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(2 * n, 0, new StringBuilder(""), result);
        return result;
    }

    private void dfs(int n, int left, StringBuilder str, List<String> result) {
        if (n == 0) {
            if (left == 0) {
                result.add(str.toString());
            }
            return ;
        }

        dfs(n - 1, left + 1, str.append("("), result);
        str.deleteCharAt(str.length() - 1);
        if (left > 0) {
            dfs(n - 1, left - 1, str.append(")"), result);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
