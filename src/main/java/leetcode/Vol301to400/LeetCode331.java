package leetcode.Vol301to400;

public class LeetCode331 {
    private int idx;

    private boolean result;

    public boolean isValidSerialization(String preorder) {
        idx = 0;
        result = true;
        preorder = preorder + ",";
        dfs(preorder);
        return result && idx >= preorder.length();
    }

    private void dfs(String preorder) {
        if (idx >= preorder.length()) {
            result = false;
            return;
        }
        if (preorder.charAt(idx) == '#') {
            idx += 2;
            return;
        }

        while (preorder.charAt(idx) != ',') {
            idx++;
        }
        idx++;
        dfs(preorder);
        dfs(preorder);
    }
}
