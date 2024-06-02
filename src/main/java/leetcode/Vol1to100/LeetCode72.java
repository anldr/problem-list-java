package leetcode.Vol1to100;

public class LeetCode72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 * len2 == 0) {
            return len1 + len2;
        }

        int[][] edit = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            edit[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            edit[0][i] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int val = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                edit[i][j] = edit[i-1][j-1] + val;
                edit[i][j] = Math.min(edit[i][j], edit[i - 1][j] + 1);
                edit[i][j] = Math.min(edit[i][j], edit[i][j - 1] + 1);
            }
        }

        return edit[len1][len2];
    }
}
