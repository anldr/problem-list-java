package leetcode.Vol1to100;

public class LeetCode5 {
    public static String longestPalindrome(String s) {
        int strLen = s.length();

        String result = s.substring(0, 1);
        boolean[][] dp = new boolean[strLen][strLen];
        for (int i = 0; i < strLen; i++) {
            dp[i][i] = true;
        }

        for (int i = strLen - 1; i >= 0; i--) {
            for (int j = i + 1; j < strLen; j++) {
                dp[i][j] = (dp[i + 1][j - 1] || (j - i + 1 <= 2)) && (s.charAt(i) == s.charAt(j));
                if (dp[i][j] && result.length() < (j - i + 1)) {
                    result = s.substring(i, j + 1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        longestPalindrome(s);
    }
}
