package leetcode.Vol1to100;

public class LeetCode76 {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) {
            return "";
        }

        int diff = 0;
        int[] tCharCount = new int[128];
        for (int i = 0; i < n; i++) {
            if (tCharCount[t.charAt(i)] == 0) {
                diff++;
            }
            tCharCount[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        int resultLeft = -1;
        int resultRight = s.length();
        while(right < m) {
            tCharCount[s.charAt(right)]--;
            if (tCharCount[s.charAt(right)] == 0) {
                diff--;
            }
            while (diff == 0) {
                if (right - left < resultRight - resultLeft) {
                    resultLeft = left;
                    resultRight = right;
                }
                tCharCount[s.charAt(left)]++;
                if (tCharCount[s.charAt(left)] > 0) {
                    diff++;
                }
                left++;
            }
            right++;
        }

        return resultLeft == -1 ? "" : s.substring(resultLeft, resultRight + 1);
    }
}
