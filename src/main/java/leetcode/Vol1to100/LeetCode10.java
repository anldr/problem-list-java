package leetcode.Vol1to100;

public class LeetCode10 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("aa", ".*"));
        System.out.println(solution.isMatch("aa", "a*"));
        System.out.println(solution.isMatch("aab", "c*a*b"));
        System.out.println(solution.isMatch("ab", ".*c"));
    }

    static class Solution {
        public boolean isMatch(String s, String p) {
            int sLen = s.length();
            int pLen = p.length();
            int sIdx = 0;
            int pIdx = 0;

            boolean result = true;
            while (pIdx < pLen && sIdx < sLen) {
                if (p.charAt(pIdx) == '.') {
                    char postChar = pIdx + 1 < pLen ? p.charAt(pIdx + 1) : '!';
                    if (postChar == '*') {
                        sIdx = sLen;
                        break;
                    }
                    sIdx++;
                } else if (p.charAt(pIdx) == '*') {
                    pIdx++;
                    continue;
                } else {
                    char nowChar = p.charAt(pIdx);
                    char postChar = pIdx + 1 < pLen ? p.charAt(pIdx + 1) : '!';
                    if (postChar == '*') {
                        while (sIdx < sLen && nowChar == s.charAt(sIdx)) {
                            sIdx++;
                        }
                    } else if (p.charAt(pIdx) != s.charAt(sIdx)) {
                        result = false;
                        sIdx++;
                        break;
                    } else {
                        sIdx++;
                    }
                }
                pIdx++;
            }

            if (sIdx != sLen) {
                result = false;
            } else if (pIdx < pLen) {
                int count = 0;
                while (pIdx < pLen) {
                    if (p.charAt(pIdx) != '*') {
                        count++;
                    } else {
                        count--;
                    }
                    pIdx++;
                }
                if (count > 0) {
                    result = false;
                }
            }

            return result;
        }
    }
}
