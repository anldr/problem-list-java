package leetcode.Vol301to400;

public class LeetCode392 {
    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (t.isEmpty()) {
            return false;
        }

        int ptr = 0;
        for (int i = 0; i < s.length(); i++) {
            while (ptr < t.length() && t.charAt(ptr) != s.charAt(i)) ptr++;
            if (ptr >= t.length()) {
                return false;
            }
            ptr++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";

        isSubsequence(s, t);
    }
}
