package leetcode.Vol1to100;

public class LeetCode97 {
    public static boolean isInterleave2(String s1, String s2, String s3) {
        int sLen1 = s1.length();
        int sLen2 = s2.length();
        int sLen3 = s3.length();

        if (sLen1 + sLen2 != sLen3) {
            return false;
        }

        boolean[][] dp = new boolean[sLen1 + 1][sLen2 + 1];
        dp[0][0] = true;

        for (int i = 0; i <= sLen1; i++) {
            for (int j = 0; j <= sLen2; j++) {
                int idx= i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(idx));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(idx));
                }
            }
        }

        return dp[sLen1][sLen2];
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int sLen1 = s1.length();
        int sLen2 = s2.length();
        int sLen3 = s3.length();

        if (sLen1 + sLen2 != sLen3) {
            return false;
        }

        boolean[] dp = new boolean[sLen2 + 1];
        dp[0] = true;

        for (int i = 0; i <= sLen1; i++) {
            for (int j = 0; j <= sLen2; j++) {
                int idx= i + j - 1;
                if (i > 0) {
                    dp[j] = dp[j] && (s1.charAt(i - 1) == s3.charAt(idx));
                }
                if (j > 0) {
                    dp[j] = dp[j] || dp[j - 1] && (s2.charAt(j - 1) == s3.charAt(idx));
                }
            }
        }

        return dp[sLen2];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        isInterleave(s1, s2, s3);
    }
}
